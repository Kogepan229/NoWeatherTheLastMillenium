package com.github.kogepan229.noweatherthelastmillenium.mixins.late;

import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.Chunk;

import org.spongepowered.asm.mixin.Mixin;

import com.rwtema.extrautils.worldgen.endoftime.WorldProviderEndOfTime;

@Mixin(WorldProviderEndOfTime.class)
public class MixinDisableTheLastMilleniumWeather extends WorldProvider {

    public String getDimensionName() {
        return "The Last Millenium";
    };

    @Override
    public boolean canDoRainSnowIce(Chunk chunk) {
        return false;
    }

    @Override
    public void updateWeather() {
        if (!this.worldObj.isRemote) {
            this.resetRainAndThunder();
            this.worldObj.rainingStrength = 0.0F;
            this.worldObj.thunderingStrength = 0.0F;
            this.worldObj.prevRainingStrength = 0.0F;
            this.worldObj.prevThunderingStrength = 0.0F;
        }
    }

    @Override
    public void calculateInitialWeather() {
        this.worldObj.rainingStrength = 0.0F;
        this.worldObj.thunderingStrength = 0.0F;
        this.worldObj.prevRainingStrength = 0.0F;
        this.worldObj.prevThunderingStrength = 0.0F;
        this.worldObj.getWorldInfo()
            .setRaining(false);
        this.worldObj.getWorldInfo()
            .setThundering(false);
    }
}
