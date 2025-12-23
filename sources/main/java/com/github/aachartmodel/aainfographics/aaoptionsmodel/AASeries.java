package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import com.github.aachartmodel.aainfographics.aachartcreator.AAChartStackingType;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class AASeries {

    @Nullable
    private AAAnimation animation;

    @Nullable
    private String borderColor;

    @Nullable
    private Number borderRadius;

    @Nullable
    private Object borderRadiusBottomLeft;

    @Nullable
    private Object borderRadiusBottomRight;

    @Nullable
    private Object borderRadiusTopLeft;

    @Nullable
    private Object borderRadiusTopRight;

    @Nullable
    private Number borderWidth;

    @Nullable
    private Boolean colorByPoint;

    @Nullable
    private Boolean connectNulls;

    @Nullable
    private AADataLabels dataLabels;

    @Nullable
    private AASeriesEvents events;

    @Nullable
    private String[] keys;

    @Nullable
    private AAMarker marker;

    @Nullable
    private AAPoint point;

    @Nullable
    private Integer pointInterval;

    @Nullable
    private String pointIntervalUnit;

    @Nullable
    private Object pointPlacement;

    @Nullable
    private Number pointStart;

    @Nullable
    private com.github.aachartmodel.aainfographics.aachartcreator.AAShadow shadow;

    @Nullable
    private String stacking;

    @Nullable
    private AAStates states;

    @NotNull
    public final AASeries animation(@NotNull AAAnimation prop) {
        g0.p(prop, "prop");
        this.animation = prop;
        return this;
    }

    @NotNull
    public final AASeries borderColor(@Nullable String str) {
        this.borderColor = str;
        return this;
    }

    @NotNull
    public final AASeries borderRadius(@Nullable Number number) {
        this.borderRadius = number;
        return this;
    }

    @NotNull
    public final AASeries borderRadiusBottomLeft(@Nullable Object obj) {
        this.borderRadiusBottomLeft = obj;
        return this;
    }

    @NotNull
    public final AASeries borderRadiusBottomRight(@Nullable Object obj) {
        this.borderRadiusBottomRight = obj;
        return this;
    }

    @NotNull
    public final AASeries borderRadiusTopLeft(@Nullable Object obj) {
        this.borderRadiusTopLeft = obj;
        return this;
    }

    @NotNull
    public final AASeries borderRadiusTopRight(@Nullable Object obj) {
        this.borderRadiusTopRight = obj;
        return this;
    }

    @NotNull
    public final AASeries borderWidth(@Nullable Number number) {
        this.borderWidth = number;
        return this;
    }

    @NotNull
    public final AASeries colorByPoint(@Nullable Boolean bool) {
        this.colorByPoint = bool;
        return this;
    }

    @NotNull
    public final AASeries connectNulls(@Nullable Boolean bool) {
        this.connectNulls = bool;
        return this;
    }

    @NotNull
    public final AASeries dataLabels(@NotNull AADataLabels prop) {
        g0.p(prop, "prop");
        this.dataLabels = prop;
        return this;
    }

    @NotNull
    public final AASeries events(@NotNull AASeriesEvents prop) {
        g0.p(prop, "prop");
        this.events = prop;
        return this;
    }

    @Nullable
    public final AAAnimation getAnimation() {
        return this.animation;
    }

    @Nullable
    public final String getBorderColor() {
        return this.borderColor;
    }

    @Nullable
    public final Number getBorderRadius() {
        return this.borderRadius;
    }

    @Nullable
    public final Object getBorderRadiusBottomLeft() {
        return this.borderRadiusBottomLeft;
    }

    @Nullable
    public final Object getBorderRadiusBottomRight() {
        return this.borderRadiusBottomRight;
    }

    @Nullable
    public final Object getBorderRadiusTopLeft() {
        return this.borderRadiusTopLeft;
    }

    @Nullable
    public final Object getBorderRadiusTopRight() {
        return this.borderRadiusTopRight;
    }

    @Nullable
    public final Number getBorderWidth() {
        return this.borderWidth;
    }

    @Nullable
    public final Boolean getColorByPoint() {
        return this.colorByPoint;
    }

    @Nullable
    public final Boolean getConnectNulls() {
        return this.connectNulls;
    }

    @Nullable
    public final AADataLabels getDataLabels() {
        return this.dataLabels;
    }

    @Nullable
    public final AASeriesEvents getEvents() {
        return this.events;
    }

    @Nullable
    public final String[] getKeys() {
        return this.keys;
    }

    @Nullable
    public final AAMarker getMarker() {
        return this.marker;
    }

    @Nullable
    public final AAPoint getPoint() {
        return this.point;
    }

    @Nullable
    public final Integer getPointInterval() {
        return this.pointInterval;
    }

    @Nullable
    public final String getPointIntervalUnit() {
        return this.pointIntervalUnit;
    }

    @Nullable
    public final Object getPointPlacement() {
        return this.pointPlacement;
    }

    @Nullable
    public final Number getPointStart() {
        return this.pointStart;
    }

    @Nullable
    public final com.github.aachartmodel.aainfographics.aachartcreator.AAShadow getShadow() {
        return this.shadow;
    }

    @Nullable
    public final String getStacking() {
        return this.stacking;
    }

    @Nullable
    public final AAStates getStates() {
        return this.states;
    }

    @NotNull
    public final AASeries keys(@NotNull String[] prop) {
        g0.p(prop, "prop");
        this.keys = prop;
        return this;
    }

    @NotNull
    public final AASeries marker(@NotNull AAMarker prop) {
        g0.p(prop, "prop");
        this.marker = prop;
        return this;
    }

    @NotNull
    public final AASeries point(@NotNull AAPoint prop) {
        g0.p(prop, "prop");
        this.point = prop;
        return this;
    }

    @NotNull
    public final AASeries pointIntervalUnit(@NotNull String prop) {
        g0.p(prop, "prop");
        this.pointIntervalUnit = prop;
        return this;
    }

    @NotNull
    public final AASeries pointPlacement(@NotNull Object prop) {
        g0.p(prop, "prop");
        this.pointPlacement = prop;
        return this;
    }

    @NotNull
    public final AASeries pointStart(@NotNull Number prop) {
        g0.p(prop, "prop");
        this.pointStart = prop;
        return this;
    }

    public final void setAnimation(@Nullable AAAnimation aAAnimation) {
        this.animation = aAAnimation;
    }

    public final void setBorderColor(@Nullable String str) {
        this.borderColor = str;
    }

    public final void setBorderRadius(@Nullable Number number) {
        this.borderRadius = number;
    }

    public final void setBorderRadiusBottomLeft(@Nullable Object obj) {
        this.borderRadiusBottomLeft = obj;
    }

    public final void setBorderRadiusBottomRight(@Nullable Object obj) {
        this.borderRadiusBottomRight = obj;
    }

    public final void setBorderRadiusTopLeft(@Nullable Object obj) {
        this.borderRadiusTopLeft = obj;
    }

    public final void setBorderRadiusTopRight(@Nullable Object obj) {
        this.borderRadiusTopRight = obj;
    }

    public final void setBorderWidth(@Nullable Number number) {
        this.borderWidth = number;
    }

    public final void setColorByPoint(@Nullable Boolean bool) {
        this.colorByPoint = bool;
    }

    public final void setConnectNulls(@Nullable Boolean bool) {
        this.connectNulls = bool;
    }

    public final void setDataLabels(@Nullable AADataLabels aADataLabels) {
        this.dataLabels = aADataLabels;
    }

    public final void setEvents(@Nullable AASeriesEvents aASeriesEvents) {
        this.events = aASeriesEvents;
    }

    public final void setKeys(@Nullable String[] strArr) {
        this.keys = strArr;
    }

    public final void setMarker(@Nullable AAMarker aAMarker) {
        this.marker = aAMarker;
    }

    public final void setPoint(@Nullable AAPoint aAPoint) {
        this.point = aAPoint;
    }

    public final void setPointInterval(@Nullable Integer num) {
        this.pointInterval = num;
    }

    public final void setPointIntervalUnit(@Nullable String str) {
        this.pointIntervalUnit = str;
    }

    public final void setPointPlacement(@Nullable Object obj) {
        this.pointPlacement = obj;
    }

    public final void setPointStart(@Nullable Number number) {
        this.pointStart = number;
    }

    public final void setShadow(@Nullable com.github.aachartmodel.aainfographics.aachartcreator.AAShadow aAShadow) {
        this.shadow = aAShadow;
    }

    public final void setStacking(@Nullable String str) {
        this.stacking = str;
    }

    public final void setStates(@Nullable AAStates aAStates) {
        this.states = aAStates;
    }

    @NotNull
    public final AASeries shadow(@NotNull com.github.aachartmodel.aainfographics.aachartcreator.AAShadow prop) {
        g0.p(prop, "prop");
        this.shadow = prop;
        return this;
    }

    @NotNull
    public final AASeries stacking(@Nullable AAChartStackingType aAChartStackingType) {
        this.stacking = aAChartStackingType != null ? aAChartStackingType.getValue() : null;
        return this;
    }

    @NotNull
    public final AASeries states(@NotNull AAStates prop) {
        g0.p(prop, "prop");
        this.states = prop;
        return this;
    }

    @NotNull
    public final AASeries pointInterval(int i6) {
        this.pointInterval = Integer.valueOf(i6);
        return this;
    }
}
