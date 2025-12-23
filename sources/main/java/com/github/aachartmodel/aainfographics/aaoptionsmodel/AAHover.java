package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class AAHover {

    @Nullable
    private String borderColor;

    @Nullable
    private Float brightness;

    @Nullable
    private String color;

    @Nullable
    private Boolean enabled;

    @Nullable
    private AAHalo halo;

    @Nullable
    private Number lineWidth;

    @Nullable
    private Number lineWidthPlus;

    @NotNull
    public final AAHover borderColor(@Nullable String str) {
        this.borderColor = str;
        return this;
    }

    @NotNull
    public final AAHover brightness(@Nullable Float f6) {
        this.brightness = f6;
        return this;
    }

    @NotNull
    public final AAHover color(@Nullable String str) {
        this.color = str;
        return this;
    }

    @NotNull
    public final AAHover enabled(@Nullable Boolean bool) {
        this.enabled = bool;
        return this;
    }

    @Nullable
    public final String getBorderColor() {
        return this.borderColor;
    }

    @Nullable
    public final Float getBrightness() {
        return this.brightness;
    }

    @Nullable
    public final String getColor() {
        return this.color;
    }

    @Nullable
    public final Boolean getEnabled() {
        return this.enabled;
    }

    @Nullable
    public final AAHalo getHalo() {
        return this.halo;
    }

    @Nullable
    public final Number getLineWidth() {
        return this.lineWidth;
    }

    @Nullable
    public final Number getLineWidthPlus() {
        return this.lineWidthPlus;
    }

    @NotNull
    public final AAHover halo(@Nullable AAHalo aAHalo) {
        this.halo = aAHalo;
        return this;
    }

    @NotNull
    public final AAHover lineWidth(@Nullable Number number) {
        this.lineWidth = number;
        return this;
    }

    @NotNull
    public final AAHover lineWidthPlus(@Nullable Number number) {
        this.lineWidthPlus = number;
        return this;
    }

    public final void setBorderColor(@Nullable String str) {
        this.borderColor = str;
    }

    public final void setBrightness(@Nullable Float f6) {
        this.brightness = f6;
    }

    public final void setColor(@Nullable String str) {
        this.color = str;
    }

    public final void setEnabled(@Nullable Boolean bool) {
        this.enabled = bool;
    }

    public final void setHalo(@Nullable AAHalo aAHalo) {
        this.halo = aAHalo;
    }

    public final void setLineWidth(@Nullable Number number) {
        this.lineWidth = number;
    }

    public final void setLineWidthPlus(@Nullable Number number) {
        this.lineWidthPlus = number;
    }
}
