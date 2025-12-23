package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import com.github.aachartmodel.aainfographics.aachartcreator.AAChartLineDashStyleType;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class AAPlotLinesElement {
    private Object color;
    private String dashStyle;
    private AALabel label;
    private Number value;
    private Number width;
    private Integer zIndex;

    @NotNull
    public final AAPlotLinesElement color(@NotNull Object prop) {
        g0.p(prop, "prop");
        this.color = prop;
        return this;
    }

    @NotNull
    public final AAPlotLinesElement dashStyle(@NotNull AAChartLineDashStyleType prop) {
        g0.p(prop, "prop");
        this.dashStyle = prop.getValue();
        return this;
    }

    @NotNull
    public final AAPlotLinesElement label(@NotNull AALabel prop) {
        g0.p(prop, "prop");
        this.label = prop;
        return this;
    }

    @NotNull
    public final AAPlotLinesElement value(@Nullable Number number) {
        this.value = number;
        return this;
    }

    @NotNull
    public final AAPlotLinesElement width(@Nullable Number number) {
        this.width = number;
        return this;
    }

    @NotNull
    public final AAPlotLinesElement zIndex(@Nullable Integer num) {
        this.zIndex = num;
        return this;
    }
}
