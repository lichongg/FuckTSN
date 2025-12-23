package com.github.aachartmodel.aainfographics.aachartcreator;

import com.github.aachartmodel.aainfographics.aaoptionsmodel.AADataLabels;
import com.github.aachartmodel.aainfographics.aaoptionsmodel.AAMarker;
import com.github.aachartmodel.aainfographics.aaoptionsmodel.AATooltip;
import com.github.aachartmodel.aainfographics.aaoptionsmodel.AAZonesElement;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class AASeriesElement {
    private Boolean allowPointSelect;
    private String borderColor;
    private Number borderRadius;
    private Object borderRadiusBottomLeft;
    private Object borderRadiusBottomRight;
    private Object borderRadiusTopLeft;
    private Object borderRadiusTopRight;
    private Number borderWidth;
    private Object color;
    private Boolean colorByPoint;
    private Boolean connectNulls;
    private String dashStyle;
    private Object[] data;
    private AADataLabels dataLabels;
    private Boolean enableMouseTracking;
    private Object fillColor;
    private Float fillOpacity;
    private String id;
    private Object innerSize;
    private Number lineWidth;
    private AAMarker marker;
    private String name;
    private String negativeColor;
    private Object negativeFillColor;
    private Boolean reversed;
    private AAShadow shadow;
    private Boolean showInLegend;
    private Object size;
    private String stack;
    private Object states;
    private Object step;
    private Number threshold;
    private AATooltip tooltip;
    private String type;
    private Integer yAxis;
    private Integer zIndex;
    private String zoneAxis;
    private AAZonesElement[] zones;

    @NotNull
    public final AASeriesElement allowPointSelect(@Nullable Boolean bool) {
        this.allowPointSelect = bool;
        return this;
    }

    @NotNull
    public final AASeriesElement borderColor(@Nullable String str) {
        this.borderColor = str;
        return this;
    }

    @NotNull
    public final AASeriesElement borderRadius(@Nullable Number number) {
        this.borderRadius = number;
        return this;
    }

    @NotNull
    public final AASeriesElement borderRadiusBottomLeft(@Nullable Object obj) {
        this.borderRadiusBottomLeft = obj;
        return this;
    }

    @NotNull
    public final AASeriesElement borderRadiusBottomRight(@Nullable Object obj) {
        this.borderRadiusBottomRight = obj;
        return this;
    }

    @NotNull
    public final AASeriesElement borderRadiusTopLeft(@Nullable Object obj) {
        this.borderRadiusTopLeft = obj;
        return this;
    }

    @NotNull
    public final AASeriesElement borderRadiusTopRight(@Nullable Object obj) {
        this.borderRadiusTopRight = obj;
        return this;
    }

    @NotNull
    public final AASeriesElement borderWidth(@Nullable Number number) {
        this.borderWidth = number;
        return this;
    }

    @NotNull
    public final AASeriesElement color(@Nullable Object obj) {
        this.color = obj;
        return this;
    }

    @NotNull
    public final AASeriesElement colorByPoint(@Nullable Boolean bool) {
        this.colorByPoint = bool;
        return this;
    }

    @NotNull
    public final AASeriesElement connectNulls(@Nullable Boolean bool) {
        this.connectNulls = bool;
        return this;
    }

    @NotNull
    public final AASeriesElement dashStyle(@Nullable AAChartLineDashStyleType aAChartLineDashStyleType) {
        this.dashStyle = aAChartLineDashStyleType != null ? aAChartLineDashStyleType.getValue() : null;
        return this;
    }

    @NotNull
    public final AASeriesElement data(@NotNull Object[] prop) {
        g0.p(prop, "prop");
        this.data = prop;
        return this;
    }

    @NotNull
    public final AASeriesElement dataLabels(@Nullable AADataLabels aADataLabels) {
        this.dataLabels = aADataLabels;
        return this;
    }

    @NotNull
    public final AASeriesElement enableMouseTracking(@Nullable Boolean bool) {
        this.enableMouseTracking = bool;
        return this;
    }

    @NotNull
    public final AASeriesElement fillColor(@Nullable Object obj) {
        this.fillColor = obj;
        return this;
    }

    @NotNull
    public final AASeriesElement fillOpacity(@Nullable Float f6) {
        this.fillOpacity = f6;
        return this;
    }

    @NotNull
    public final AASeriesElement id(@Nullable String str) {
        this.id = str;
        return this;
    }

    @NotNull
    public final AASeriesElement innerSize(@Nullable Object obj) {
        this.innerSize = obj;
        return this;
    }

    @NotNull
    public final AASeriesElement lineWidth(@Nullable Number number) {
        this.lineWidth = number;
        return this;
    }

    @NotNull
    public final AASeriesElement marker(@Nullable AAMarker aAMarker) {
        this.marker = aAMarker;
        return this;
    }

    @NotNull
    public final AASeriesElement name(@Nullable String str) {
        this.name = str;
        return this;
    }

    @NotNull
    public final AASeriesElement negativeColor(@Nullable String str) {
        this.negativeColor = str;
        return this;
    }

    @NotNull
    public final AASeriesElement negativeFillColor(@Nullable Object obj) {
        this.negativeFillColor = obj;
        return this;
    }

    @NotNull
    public final AASeriesElement reversed(@Nullable Boolean bool) {
        this.reversed = bool;
        return this;
    }

    @NotNull
    public final AASeriesElement shadow(@Nullable AAShadow aAShadow) {
        this.shadow = aAShadow;
        return this;
    }

    @NotNull
    public final AASeriesElement showInLegend(@Nullable Boolean bool) {
        this.showInLegend = bool;
        return this;
    }

    @NotNull
    public final AASeriesElement size(@Nullable Object obj) {
        this.size = obj;
        return this;
    }

    @NotNull
    public final AASeriesElement stack(@Nullable String str) {
        this.stack = str;
        return this;
    }

    @NotNull
    public final AASeriesElement states(@Nullable Object obj) {
        this.states = obj;
        return this;
    }

    @NotNull
    public final AASeriesElement step(@Nullable Object obj) {
        this.step = obj;
        return this;
    }

    @NotNull
    public final AASeriesElement threshold(@Nullable Number number) {
        this.threshold = number;
        return this;
    }

    @NotNull
    public final AASeriesElement tooltip(@Nullable AATooltip aATooltip) {
        this.tooltip = aATooltip;
        return this;
    }

    @NotNull
    public final AASeriesElement type(@Nullable AAChartType aAChartType) {
        this.type = aAChartType != null ? aAChartType.getValue() : null;
        return this;
    }

    @NotNull
    public final AASeriesElement yAxis(@Nullable Integer num) {
        this.yAxis = num;
        return this;
    }

    @NotNull
    public final AASeriesElement zIndex(@Nullable Integer num) {
        this.zIndex = num;
        return this;
    }

    @NotNull
    public final AASeriesElement zoneAxis(@Nullable String str) {
        this.zoneAxis = str;
        return this;
    }

    @NotNull
    public final AASeriesElement zones(@NotNull AAZonesElement[] prop) {
        g0.p(prop, "prop");
        this.zones = prop;
        return this;
    }
}
