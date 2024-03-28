package com.github.kogepan229.noweatherthelastmillenium;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import com.gtnewhorizon.gtnhmixins.ILateMixinLoader;
import com.gtnewhorizon.gtnhmixins.LateMixin;

@LateMixin
public class NoWeatherTheLastMilleniumLateMixins implements ILateMixinLoader {

    @Override
    public String getMixinConfig() {
        return "mixins.noweatherthelastmillenium.late.json";
    }

    @Override
    public List<String> getMixins(Set<String> loadedMods) {
        return Arrays.asList("MixinDisableTheLastMilleniumWeather");
    }
}
