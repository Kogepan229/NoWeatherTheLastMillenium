package com.github.kogepan229.noweatherthelastmillenium.mixins.late;

import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.Chunk;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(WorldProvider.class)
public abstract class MixinWorldProvider {

    @Inject(
        method = "canDoRainSnowIce(Lnet/minecraft/world/chunk/Chunk;)Z",
        at = @At("HEAD"),
        cancellable = true,
        remap = false)
    public void noWeatherTheLastMillenium$canDoRainSnowIce(Chunk chunk, CallbackInfoReturnable<Boolean> cir) {}

    @Inject(method = "updateWeather", at = @At("HEAD"), cancellable = true, remap = false)
    public void noWeatherTheLastMillenium$updateWeather(CallbackInfo ci) {}

    @Inject(method = "calculateInitialWeather", at = @At("HEAD"), cancellable = true, remap = false)
    public void noWeatherTheLastMillenium$calculateInitialWeather(CallbackInfo ci) {}
}
