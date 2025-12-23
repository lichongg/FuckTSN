package com.github.aachartmodel.aainfographics.aachartcreator;

import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public enum AAChartVerticalAlignType {
    Top("top"),
    Middle("middle"),
    Bottom("bottom");


    @NotNull
    private final String value;

    @NotNull
    public final String getValue() {
        return this.value;
    }

    AAChartVerticalAlignType(String str) {
        this.value = str;
    }
}
