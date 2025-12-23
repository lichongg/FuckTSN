package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class AAMarker {

    @Nullable
    private Boolean enabled;

    @Nullable
    private String fillColor;

    @Nullable
    private Object lineColor;

    @Nullable
    private Number lineWidth;

    @Nullable
    private Number radius;

    @Nullable
    private AAMarkerStates states;

    @Nullable
    private String symbol;

    @NotNull
    public final AAMarker fillColor(@NotNull String prop) {
        g0.p(prop, "prop");
        this.fillColor = prop;
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
    public final Object getLineColor() {
        return this.lineColor;
    }

    @Nullable
    public final Number getLineWidth() {
        return this.lineWidth;
    }

    @Nullable
    public final Number getRadius() {
        return this.radius;
    }

    @Nullable
    public final AAMarkerStates getStates() {
        return this.states;
    }

    @Nullable
    public final String getSymbol() {
        return this.symbol;
    }

    @NotNull
    public final AAMarker lineColor(@Nullable Object obj) {
        this.lineColor = obj;
        return this;
    }

    @NotNull
    public final AAMarker lineWidth(@Nullable Number number) {
        this.lineWidth = number;
        return this;
    }

    @NotNull
    public final AAMarker radius(@Nullable Number number) {
        this.radius = number;
        return this;
    }

    public final void setEnabled(@Nullable Boolean bool) {
        this.enabled = bool;
    }

    public final void setFillColor(@Nullable String str) {
        this.fillColor = str;
    }

    public final void setLineColor(@Nullable Object obj) {
        this.lineColor = obj;
    }

    public final void setLineWidth(@Nullable Number number) {
        this.lineWidth = number;
    }

    public final void setRadius(@Nullable Number number) {
        this.radius = number;
    }

    public final void setStates(@Nullable AAMarkerStates aAMarkerStates) {
        this.states = aAMarkerStates;
    }

    public final void setSymbol(@Nullable String str) {
        this.symbol = str;
    }

    @Nullable
    public final AAMarker states(@NotNull AAMarkerStates prop) {
        g0.p(prop, "prop");
        this.states = prop;
        return this;
    }

    @NotNull
    public final AAMarker symbol(@Nullable String str) {
        this.symbol = str;
        return this;
    }

    @NotNull
    public final AAMarker enabled(boolean z5) {
        this.enabled = Boolean.valueOf(z5);
        return this;
    }
}
