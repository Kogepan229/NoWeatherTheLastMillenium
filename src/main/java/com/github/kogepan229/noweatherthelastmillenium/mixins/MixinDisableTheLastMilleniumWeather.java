package com.github.kogepan229.noweatherthelastmillenium.mixins;

import net.minecraft.world.chunk.Chunk;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.rwtema.extrautils.worldgen.endoftime.WorldProviderEndOfTime;

@Mixin(WorldProviderEndOfTime.class)
public class MixinDisableTheLastMilleniumWeather extends MixinWorldProvider {

    @Override
    public void noWeatherTheLastMillenium$canDoRainSnowIce(Chunk chunk, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(false);
        cir.cancel();
    }

    @Override
    public void noWeatherTheLastMillenium$updateWeather(CallbackInfo ci) {
        if (!((WorldProviderEndOfTime) (Object) this).worldObj.isRemote) {
            ((WorldProviderEndOfTime) (Object) this).resetRainAndThunder();
            ((WorldProviderEndOfTime) (Object) this).worldObj.rainingStrength = 0.0F;
            ((WorldProviderEndOfTime) (Object) this).worldObj.thunderingStrength = 0.0F;
            ((WorldProviderEndOfTime) (Object) this).worldObj.prevRainingStrength = 0.0F;
            ((WorldProviderEndOfTime) (Object) this).worldObj.prevThunderingStrength = 0.0F;
            ci.cancel();
        }
    }

    @Override
    public void noWeatherTheLastMillenium$calculateInitialWeather(CallbackInfo ci) {
        ((WorldProviderEndOfTime) (Object) this).worldObj.rainingStrength = 0.0F;
        ((WorldProviderEndOfTime) (Object) this).worldObj.thunderingStrength = 0.0F;
        ((WorldProviderEndOfTime) (Object) this).worldObj.prevRainingStrength = 0.0F;
        ((WorldProviderEndOfTime) (Object) this).worldObj.prevThunderingStrength = 0.0F;
        ((WorldProviderEndOfTime) (Object) this).worldObj.getWorldInfo()
            .setRaining(false);
        ((WorldProviderEndOfTime) (Object) this).worldObj.getWorldInfo()
            .setThundering(false);
        ci.cancel();
    }
}
