package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class AAColumnrange {

    @Nullable
    private Number borderRadius;

    @Nullable
    private Number borderWidth;

    @Nullable
    private AADataLabels dataLabels;

    @NotNull
    public final AAColumnrange borderRadius(@Nullable Number number) {
        this.borderRadius = number;
        return this;
    }

    @NotNull
    public final AAColumnrange borderWidth(@Nullable Number number) {
        this.borderWidth = number;
        return this;
    }

    @NotNull
    public final AAColumnrange dataLabels(@NotNull AADataLabels prop) {
        g0.p(prop, "prop");
        this.dataLabels = prop;
        return this;
    }

    @Nullable
    public final Number getBorderRadius() {
        return this.borderRadius;
    }

    @Nullable
    public final Number getBorderWidth() {
        return this.borderWidth;
    }

    @Nullable
    public final AADataLabels getDataLabels() {
        return this.dataLabels;
    }

    public final void setBorderRadius(@Nullable Number number) {
        this.borderRadius = number;
    }

    public final void setBorderWidth(@Nullable Number number) {
        this.borderWidth = number;
    }

    public final void setDataLabels(@Nullable AADataLabels aADataLabels) {
        this.dataLabels = aADataLabels;
    }
}
