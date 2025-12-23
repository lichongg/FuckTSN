package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import com.github.aachartmodel.aainfographics.aachartcreator.AAChartLineDashStyleType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class AAScatter {

    @Nullable
    private String dashStyle;

    @Nullable
    private Object enableMouseTracking;

    @Nullable
    private String lineColor;

    @Nullable
    private Number lineWidth;

    @Nullable
    private String linkedTo;

    @Nullable
    private AAMarker marker;

    @Nullable
    private AAStates states;

    @NotNull
    public final AAScatter dashStyle(@Nullable AAChartLineDashStyleType aAChartLineDashStyleType) {
        this.dashStyle = aAChartLineDashStyleType != null ? aAChartLineDashStyleType.getValue() : null;
        return this;
    }

    @NotNull
    public final AAScatter enableMouseTracking(@Nullable Object obj) {
        this.enableMouseTracking = obj;
        return this;
    }

    @Nullable
    public final String getDashStyle() {
        return this.dashStyle;
    }

    @Nullable
    public final Object getEnableMouseTracking() {
        return this.enableMouseTracking;
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
    public final String getLinkedTo() {
        return this.linkedTo;
    }

    @Nullable
    public final AAMarker getMarker() {
        return this.marker;
    }

    @Nullable
    public final AAStates getStates() {
        return this.states;
    }

    @NotNull
    public final AAScatter lineColor(@Nullable String str) {
        this.lineColor = str;
        return this;
    }

    @NotNull
    public final AAScatter lineWidth(@Nullable Number number) {
        this.lineWidth = number;
        return this;
    }

    @NotNull
    public final AAScatter linkedTo(@Nullable String str) {
        this.linkedTo = str;
        return this;
    }

    @NotNull
    public final AAScatter marker(@Nullable AAMarker aAMarker) {
        this.marker = aAMarker;
        return this;
    }

    public final void setDashStyle(@Nullable String str) {
        this.dashStyle = str;
    }

    public final void setEnableMouseTracking(@Nullable Object obj) {
        this.enableMouseTracking = obj;
    }

    public final void setLineColor(@Nullable String str) {
        this.lineColor = str;
    }

    public final void setLineWidth(@Nullable Number number) {
        this.lineWidth = number;
    }

    public final void setLinkedTo(@Nullable String str) {
        this.linkedTo = str;
    }

    public final void setMarker(@Nullable AAMarker aAMarker) {
        this.marker = aAMarker;
    }

    public final void setStates(@Nullable AAStates aAStates) {
        this.states = aAStates;
    }

    @NotNull
    public final AAScatter states(@Nullable AAStates aAStates) {
        this.states = aAStates;
        return this;
    }
}
