package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class AAMarkerHover {

    @Nullable
    private Boolean enabled;

    @Nullable
    private String fillColor;

    @Nullable
    private String lineColor;

    @Nullable
    private Number lineWidth;

    @Nullable
    private Number lineWidthPlus;

    @Nullable
    private Number radius;

    @Nullable
    private Number radiusPlus;

    @NotNull
    public final AAMarkerHover enabled(@Nullable Boolean bool) {
        this.enabled = bool;
        return this;
    }

    @NotNull
    public final AAMarkerHover fillColor(@Nullable String str) {
        this.fillColor = str;
        return this;
    }

    @Nullable
    public final Boolean getEnabled() {
        return this.enabled;
    }

    @Nullable
    public final String getFillColor() {
        return this.fillColor;
    }

    @Nullable
    public final String getLineColor() {
        return this.lineColor;
    }

    @Nullable
    public final Number getLineWidth() {
        return this.lineWidth;
    }

    @Nullable
    public final Number getLineWidthPlus() {
        return this.lineWidthPlus;
    }

    @Nullable
    public final Number getRadius() {
        return this.radius;
    }

    @Nullable
    public final Number getRadiusPlus() {
        return this.radiusPlus;
    }

    @NotNull
    public final AAMarkerHover lineColor(@Nullable String str) {
        this.lineColor = str;
        return this;
    }

    @NotNull
    public final AAMarkerHover lineWidth(@Nullable Number number) {
        this.lineWidth = number;
        return this;
    }

    @NotNull
    public final AAMarkerHover lineWidthPlus(@Nullable Number number) {
        this.lineWidthPlus = number;
        return this;
    }

    @NotNull
    public final AAMarkerHover radius(@Nullable Number number) {
        this.radius = number;
        return this;
    }

    @NotNull
    public final AAMarkerHover radiusPlus(@Nullable Number number) {
        this.radiusPlus = number;
        return this;
    }

    public final void setEnabled(@Nullable Boolean bool) {
        this.enabled = bool;
    }

    public final void setFillColor(@Nullable String str) {
        this.fillColor = str;
    }

    public final void setLineColor(@Nullable String str) {
        this.lineColor = str;
    }

    public final void setLineWidth(@Nullable Number number) {
        this.lineWidth = number;
    }

    public final void setLineWidthPlus(@Nullable Number number) {
        this.lineWidthPlus = number;
    }

    public final void setRadius(@Nullable Number number) {
        this.radius = number;
    }

    public final void setRadiusPlus(@Nullable Number number) {
        this.radiusPlus = number;
    }
}
