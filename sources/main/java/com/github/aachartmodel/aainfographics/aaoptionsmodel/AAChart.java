package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import com.github.aachartmodel.aainfographics.aachartcreator.AAChartType;
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartZoomType;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class AAChart {

    @Nullable
    private Object animation;

    @Nullable
    private Object backgroundColor;

    @Nullable
    private AAChartEvents events;

    @Nullable
    private Number height;

    @Nullable
    private Boolean inverted;

    @Nullable
    private Number[] margin;

    @Nullable
    private Number marginBottom;

    @Nullable
    private Number marginLeft;

    @Nullable
    private Number marginRight;

    @Nullable
    private Number marginTop;

    @Nullable
    private String panKey;

    @Nullable
    private Boolean panning;

    @Nullable
    private String pinchType;

    @Nullable
    private String plotBackgroundImage;

    @Nullable
    private Boolean polar;

    @Nullable
    private AAResetZoomButton resetZoomButton;

    @Nullable
    private AAScrollablePlotArea scrollablePlotArea;

    @Nullable
    private String type;

    @Nullable
    private String zoomType;

    @NotNull
    public final AAChart animation(@NotNull Object prop) {
        g0.p(prop, "prop");
        this.animation = prop;
        return this;
    }

    @NotNull
    public final AAChart backgroundColor(@Nullable Object obj) {
        this.backgroundColor = obj;
        return this;
    }

    @NotNull
    public final AAChart events(@Nullable AAChartEvents aAChartEvents) {
        this.events = aAChartEvents;
        return this;
    }

    @Nullable
    public final Object getAnimation() {
        return this.animation;
    }

    @Nullable
    public final Object getBackgroundColor() {
        return this.backgroundColor;
    }

    @Nullable
    public final AAChartEvents getEvents() {
        return this.events;
    }

    @Nullable
    public final Number getHeight() {
        return this.height;
    }

    @Nullable
    public final Boolean getInverted() {
        return this.inverted;
    }

    @Nullable
    public final Number[] getMargin() {
        return this.margin;
    }

    @Nullable
    public final Number getMarginBottom() {
        return this.marginBottom;
    }

    @Nullable
    public final Number getMarginLeft() {
        return this.marginLeft;
    }

    @Nullable
    public final Number getMarginRight() {
        return this.marginRight;
    }

    @Nullable
    public final Number getMarginTop() {
        return this.marginTop;
    }

    @Nullable
    public final String getPanKey() {
        return this.panKey;
    }

    @Nullable
    public final Boolean getPanning() {
        return this.panning;
    }

    @Nullable
    public final String getPinchType() {
        return this.pinchType;
    }

    @Nullable
    public final String getPlotBackgroundImage() {
        return this.plotBackgroundImage;
    }

    @Nullable
    public final Boolean getPolar() {
        return this.polar;
    }

    @Nullable
    public final AAResetZoomButton getResetZoomButton() {
        return this.resetZoomButton;
    }

    @Nullable
    public final AAScrollablePlotArea getScrollablePlotArea() {
        return this.scrollablePlotArea;
    }

    @Nullable
    public final String getType() {
        return this.type;
    }

    @Nullable
    public final String getZoomType() {
        return this.zoomType;
    }

    @NotNull
    public final AAChart height(@Nullable Number number) {
        this.height = number;
        return this;
    }

    @NotNull
    public final AAChart inverted(@Nullable Boolean bool) {
        this.inverted = bool;
        return this;
    }

    @NotNull
    public final AAChart margin(@Nullable Number[] numberArr) {
        this.margin = numberArr;
        return this;
    }

    @NotNull
    public final AAChart marginBottom(@NotNull Number prop) {
        g0.p(prop, "prop");
        this.marginBottom = prop;
        return this;
    }

    @NotNull
    public final AAChart marginLeft(@NotNull Number prop) {
        g0.p(prop, "prop");
        this.marginLeft = prop;
        return this;
    }

    @NotNull
    public final AAChart marginRight(@NotNull Number prop) {
        g0.p(prop, "prop");
        this.marginRight = prop;
        return this;
    }

    @NotNull
    public final AAChart marginTop(@NotNull Number prop) {
        g0.p(prop, "prop");
        this.marginTop = prop;
        return this;
    }

    @NotNull
    public final AAChart panKey(@NotNull String prop) {
        g0.p(prop, "prop");
        this.panKey = prop;
        return this;
    }

    @NotNull
    public final AAChart panning(@Nullable Boolean bool) {
        this.panning = bool;
        return this;
    }

    @NotNull
    public final AAChart pinchType(@Nullable AAChartZoomType aAChartZoomType) {
        this.pinchType = aAChartZoomType != null ? aAChartZoomType.getValue() : null;
        return this;
    }

    @NotNull
    public final AAChart plotBackgroundImage(@NotNull String prop) {
        g0.p(prop, "prop");
        this.plotBackgroundImage = prop;
        return this;
    }

    @NotNull
    public final AAChart polar(@Nullable Boolean bool) {
        this.polar = bool;
        return this;
    }

    @NotNull
    public final AAChart resetZoomButton(@NotNull AAResetZoomButton prop) {
        g0.p(prop, "prop");
        this.resetZoomButton = prop;
        return this;
    }

    @NotNull
    public final AAChart scrollablePlotArea(@Nullable AAScrollablePlotArea aAScrollablePlotArea) {
        this.scrollablePlotArea = aAScrollablePlotArea;
        return this;
    }

    public final void setAnimation(@Nullable Object obj) {
        this.animation = obj;
    }

    public final void setBackgroundColor(@Nullable Object obj) {
        this.backgroundColor = obj;
    }

    public final void setEvents(@Nullable AAChartEvents aAChartEvents) {
        this.events = aAChartEvents;
    }

    public final void setHeight(@Nullable Number number) {
        this.height = number;
    }

    public final void setInverted(@Nullable Boolean bool) {
        this.inverted = bool;
    }

    public final void setMargin(@Nullable Number[] numberArr) {
        this.margin = numberArr;
    }

    public final void setMarginBottom(@Nullable Number number) {
        this.marginBottom = number;
    }

    public final void setMarginLeft(@Nullable Number number) {
        this.marginLeft = number;
    }

    public final void setMarginRight(@Nullable Number number) {
        this.marginRight = number;
    }

    public final void setMarginTop(@Nullable Number number) {
        this.marginTop = number;
    }

    public final void setPanKey(@Nullable String str) {
        this.panKey = str;
    }

    public final void setPanning(@Nullable Boolean bool) {
        this.panning = bool;
    }

    public final void setPinchType(@Nullable String str) {
        this.pinchType = str;
    }

    public final void setPlotBackgroundImage(@Nullable String str) {
        this.plotBackgroundImage = str;
    }

    public final void setPolar(@Nullable Boolean bool) {
        this.polar = bool;
    }

    public final void setResetZoomButton(@Nullable AAResetZoomButton aAResetZoomButton) {
        this.resetZoomButton = aAResetZoomButton;
    }

    public final void setScrollablePlotArea(@Nullable AAScrollablePlotArea aAScrollablePlotArea) {
        this.scrollablePlotArea = aAScrollablePlotArea;
    }

    public final void setType(@Nullable String str) {
        this.type = str;
    }

    public final void setZoomType(@Nullable String str) {
        this.zoomType = str;
    }

    @NotNull
    public final AAChart type(@Nullable AAChartType aAChartType) {
        this.type = aAChartType != null ? aAChartType.getValue() : null;
        return this;
    }

    @NotNull
    public final AAChart zoomType(@Nullable String str) {
        this.zoomType = str;
        return this;
    }
}
