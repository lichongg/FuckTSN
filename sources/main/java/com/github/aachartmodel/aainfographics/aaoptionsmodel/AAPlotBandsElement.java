package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class AAPlotBandsElement {
    private String borderColor;
    private Number borderWidth;
    private String className;
    private Object color;
    private Number from;
    private Integer index;
    private AALabel label;
    private Number to;

    @NotNull
    public final AAPlotBandsElement borderColor(@NotNull String prop) {
        g0.p(prop, "prop");
        this.borderColor = prop;
        return this;
    }

    @NotNull
    public final AAPlotBandsElement borderWidth(@Nullable Number number) {
        this.borderWidth = number;
        return this;
    }

    @NotNull
    public final AAPlotBandsElement className(@NotNull String prop) {
        g0.p(prop, "prop");
        this.className = prop;
        return this;
    }

    @NotNull
    public final AAPlotBandsElement color(@NotNull Object prop) {
        g0.p(prop, "prop");
        this.color = prop;
        return this;
    }

    @NotNull
    public final AAPlotBandsElement from(@Nullable Number number) {
        this.from = number;
        return this;
    }

    @NotNull
    public final AAPlotBandsElement index(@Nullable Integer num) {
        this.index = num;
        return this;
    }

    @NotNull
    public final AAPlotBandsElement label(@NotNull AALabel prop) {
        g0.p(prop, "prop");
        this.label = prop;
        return this;
    }

    @NotNull
    public final AAPlotBandsElement to(@Nullable Number number) {
        this.to = number;
        return this;
    }
}
