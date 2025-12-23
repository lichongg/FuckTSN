package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import com.github.aachartmodel.aainfographics.aachartcreator.AAChartLineDashStyleType;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class AACrosshair {

    @Nullable
    private String color;

    @Nullable
    private AAChartLineDashStyleType dashStyle;

    @Nullable
    private Number width;

    @NotNull
    public final AACrosshair color(@NotNull String prop) {
        g0.p(prop, "prop");
        this.color = prop;
        return this;
    }

    @NotNull
    public final AACrosshair dashStyle(@NotNull AAChartLineDashStyleType prop) {
        g0.p(prop, "prop");
        this.dashStyle = prop;
        return this;
    }

    @Nullable
    public final String getColor() {
        return this.color;
    }

    @Nullable
    public final AAChartLineDashStyleType getDashStyle() {
        return this.dashStyle;
    }

    @Nullable
    public final Number getWidth() {
        return this.width;
    }

    public final void setColor(@Nullable String str) {
        this.color = str;
    }

    public final void setDashStyle(@Nullable AAChartLineDashStyleType aAChartLineDashStyleType) {
        this.dashStyle = aAChartLineDashStyleType;
    }

    public final void setWidth(@Nullable Number number) {
        this.width = number;
    }

    @NotNull
    public final AACrosshair width(@Nullable Number number) {
        this.width = number;
        return this;
    }
}
