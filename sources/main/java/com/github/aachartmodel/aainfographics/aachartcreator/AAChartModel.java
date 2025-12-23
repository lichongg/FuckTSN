package com.github.aachartmodel.aainfographics.aachartcreator;

import android.content.Context;
import com.github.aachartmodel.aainfographics.aaoptionsmodel.AAScrollablePlotArea;
import com.github.aachartmodel.aainfographics.aaoptionsmodel.AAStyle;
import com.github.aachartmodel.aainfographics.aatools.AABuilder;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class AAChartModel {
    public static final Companion Companion = new Companion(null);

    @Nullable
    private Integer animationDuration;

    @Nullable
    private AAChartAnimationType animationType;

    @Nullable
    private String axesTextColor;

    @Nullable
    private Object backgroundColor;

    @Nullable
    private Number borderRadius;

    @Nullable
    private String[] categories;

    @Nullable
    private AAChartType chartType;

    @Nullable
    private Object[] colorsTheme;

    @Nullable
    private Boolean dataLabelsEnabled;

    @Nullable
    private AAStyle dataLabelsStyle;

    @Nullable
    private Boolean gradientColorEnable;

    @Nullable
    private Boolean inverted;

    @Nullable
    private Boolean legendEnabled;

    @Nullable
    private Number[] margin;

    @Nullable
    private Number markerRadius;

    @Nullable
    private AAChartSymbolType markerSymbol;

    @Nullable
    private AAChartSymbolStyleType markerSymbolStyle;

    @Nullable
    private Boolean polar;

    @Nullable
    private AAScrollablePlotArea scrollablePlotArea;

    @Nullable
    private Object[] series;

    @Nullable
    private AAChartStackingType stacking;

    @Nullable
    private String subtitle;

    @Nullable
    private AAChartAlignType subtitleAlign;

    @Nullable
    private AAStyle subtitleStyle;

    @Nullable
    private String title;

    @Nullable
    private AAStyle titleStyle;

    @Nullable
    private Boolean tooltipEnabled;

    @Nullable
    private String tooltipValueSuffix;

    @Nullable
    private Boolean touchEventEnabled;

    @Nullable
    private Number xAxisGridLineWidth;

    @Nullable
    private Boolean xAxisLabelsEnabled;

    @Nullable
    private Boolean xAxisReversed;

    @Nullable
    private Integer xAxisTickInterval;

    @Nullable
    private Boolean xAxisVisible;

    @Nullable
    private Boolean yAxisAllowDecimals;

    @Nullable
    private Number yAxisGridLineWidth;

    @Nullable
    private Boolean yAxisLabelsEnabled;

    @Nullable
    private Number yAxisLineWidth;

    @Nullable
    private Number yAxisMax;

    @Nullable
    private Number yAxisMin;

    @Nullable
    private Boolean yAxisReversed;

    @Nullable
    private String yAxisTitle;

    @Nullable
    private Boolean yAxisVisible;

    @Nullable
    private AAChartZoomType zoomType;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(v vVar) {
            this();
        }

        @NotNull
        public final AABuilder Builder(@NotNull Context context) {
            g0.p(context, "context");
            return new AABuilder(context);
        }
    }

    public AAChartModel() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, 4095, null);
    }

    public AAChartModel(@Nullable AAChartAnimationType aAChartAnimationType, @Nullable Integer num, @Nullable String str, @Nullable AAStyle aAStyle, @Nullable String str2, @Nullable AAChartAlignType aAChartAlignType, @Nullable AAStyle aAStyle2, @Nullable String str3, @Nullable AAChartType aAChartType, @Nullable AAChartStackingType aAChartStackingType, @Nullable Number number, @Nullable AAChartSymbolType aAChartSymbolType, @Nullable AAChartSymbolStyleType aAChartSymbolStyleType, @Nullable AAChartZoomType aAChartZoomType, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable Boolean bool3, @Nullable Boolean bool4, @Nullable String str4, @Nullable Boolean bool5, @Nullable Boolean bool6, @Nullable Number[] numberArr, @Nullable Boolean bool7, @Nullable AAStyle aAStyle3, @Nullable Boolean bool8, @Nullable Integer num2, @Nullable String[] strArr, @Nullable Number number2, @Nullable Boolean bool9, @Nullable Boolean bool10, @Nullable Boolean bool11, @Nullable String str5, @Nullable Number number3, @Nullable Number number4, @Nullable Number number5, @Nullable Boolean bool12, @Nullable Number number6, @Nullable Object[] objArr, @Nullable Boolean bool13, @Nullable Object obj, @Nullable Number number7, @Nullable Object[] objArr2, @Nullable Boolean bool14, @Nullable AAScrollablePlotArea aAScrollablePlotArea) {
        this.animationType = aAChartAnimationType;
        this.animationDuration = num;
        this.title = str;
        this.titleStyle = aAStyle;
        this.subtitle = str2;
        this.subtitleAlign = aAChartAlignType;
        this.subtitleStyle = aAStyle2;
        this.axesTextColor = str3;
        this.chartType = aAChartType;
        this.stacking = aAChartStackingType;
        this.markerRadius = number;
        this.markerSymbol = aAChartSymbolType;
        this.markerSymbolStyle = aAChartSymbolStyleType;
        this.zoomType = aAChartZoomType;
        this.inverted = bool;
        this.xAxisReversed = bool2;
        this.yAxisReversed = bool3;
        this.tooltipEnabled = bool4;
        this.tooltipValueSuffix = str4;
        this.gradientColorEnable = bool5;
        this.polar = bool6;
        this.margin = numberArr;
        this.dataLabelsEnabled = bool7;
        this.dataLabelsStyle = aAStyle3;
        this.xAxisLabelsEnabled = bool8;
        this.xAxisTickInterval = num2;
        this.categories = strArr;
        this.xAxisGridLineWidth = number2;
        this.xAxisVisible = bool9;
        this.yAxisVisible = bool10;
        this.yAxisLabelsEnabled = bool11;
        this.yAxisTitle = str5;
        this.yAxisLineWidth = number3;
        this.yAxisMin = number4;
        this.yAxisMax = number5;
        this.yAxisAllowDecimals = bool12;
        this.yAxisGridLineWidth = number6;
        this.colorsTheme = objArr;
        this.legendEnabled = bool13;
        this.backgroundColor = obj;
        this.borderRadius = number7;
        this.series = objArr2;
        this.touchEventEnabled = bool14;
        this.scrollablePlotArea = aAScrollablePlotArea;
    }

    @NotNull
    public final AAChartModel animationDuration(@Nullable Integer num) {
        this.animationDuration = num;
        return this;
    }

    @NotNull
    public final AAChartModel animationType(@NotNull AAChartAnimationType prop) {
        g0.p(prop, "prop");
        this.animationType = prop;
        return this;
    }

    @NotNull
    public final AAChartModel axesTextColor(@NotNull String prop) {
        g0.p(prop, "prop");
        this.axesTextColor = prop;
        return this;
    }

    @NotNull
    public final AAChartModel backgroundColor(@NotNull Object prop) {
        g0.p(prop, "prop");
        this.backgroundColor = prop;
        return this;
    }

    @NotNull
    public final AAChartModel borderRadius(@Nullable Number number) {
        this.borderRadius = number;
        return this;
    }

    @NotNull
    public final AAChartModel categories(@NotNull String[] prop) {
        g0.p(prop, "prop");
        this.categories = prop;
        return this;
    }

    @NotNull
    public final AAChartModel chartType(@NotNull AAChartType prop) {
        g0.p(prop, "prop");
        this.chartType = prop;
        return this;
    }

    @NotNull
    public final AAChartModel colorsTheme(@NotNull Object[] prop) {
        g0.p(prop, "prop");
        this.colorsTheme = prop;
        return this;
    }

    @NotNull
    public final AAChartModel dataLabelsEnabled(@Nullable Boolean bool) {
        this.dataLabelsEnabled = bool;
        return this;
    }

    @NotNull
    public final AAChartModel dataLabelsStyle(@NotNull AAStyle prop) {
        g0.p(prop, "prop");
        this.dataLabelsStyle = prop;
        return this;
    }

    @Nullable
    public final Integer getAnimationDuration() {
        return this.animationDuration;
    }

    @Nullable
    public final AAChartAnimationType getAnimationType() {
        return this.animationType;
    }

    @Nullable
    public final String getAxesTextColor() {
        return this.axesTextColor;
    }

    @Nullable
    public final Object getBackgroundColor() {
        return this.backgroundColor;
    }

    @Nullable
    public final Number getBorderRadius() {
        return this.borderRadius;
    }

    @Nullable
    public final String[] getCategories() {
        return this.categories;
    }

    @Nullable
    public final AAChartType getChartType() {
        return this.chartType;
    }

    @Nullable
    public final Object[] getColorsTheme() {
        return this.colorsTheme;
    }

    @Nullable
    public final Boolean getDataLabelsEnabled() {
        return this.dataLabelsEnabled;
    }

    @Nullable
    public final AAStyle getDataLabelsStyle() {
        return this.dataLabelsStyle;
    }

    @Nullable
    public final Boolean getGradientColorEnable() {
        return this.gradientColorEnable;
    }

    @Nullable
    public final Boolean getInverted() {
        return this.inverted;
    }

    @Nullable
    public final Boolean getLegendEnabled() {
        return this.legendEnabled;
    }

    @Nullable
    public final Number[] getMargin() {
        return this.margin;
    }

    @Nullable
    public final Number getMarkerRadius() {
        return this.markerRadius;
    }

    @Nullable
    public final AAChartSymbolType getMarkerSymbol() {
        return this.markerSymbol;
    }

    @Nullable
    public final AAChartSymbolStyleType getMarkerSymbolStyle() {
        return this.markerSymbolStyle;
    }

    @Nullable
    public final Boolean getPolar() {
        return this.polar;
    }

    @Nullable
    public final AAScrollablePlotArea getScrollablePlotArea() {
        return this.scrollablePlotArea;
    }

    @Nullable
    public final Object[] getSeries() {
        return this.series;
    }

    @Nullable
    public final AAChartStackingType getStacking() {
        return this.stacking;
    }

    @Nullable
    public final String getSubtitle() {
        return this.subtitle;
    }

    @Nullable
    public final AAChartAlignType getSubtitleAlign() {
        return this.subtitleAlign;
    }

    @Nullable
    public final AAStyle getSubtitleStyle() {
        return this.subtitleStyle;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final AAStyle getTitleStyle() {
        return this.titleStyle;
    }

    @Nullable
    public final Boolean getTooltipEnabled() {
        return this.tooltipEnabled;
    }

    @Nullable
    public final String getTooltipValueSuffix() {
        return this.tooltipValueSuffix;
    }

    @Nullable
    public final Boolean getTouchEventEnabled() {
        return this.touchEventEnabled;
    }

    @Nullable
    public final Number getXAxisGridLineWidth() {
        return this.xAxisGridLineWidth;
    }

    @Nullable
    public final Boolean getXAxisLabelsEnabled() {
        return this.xAxisLabelsEnabled;
    }

    @Nullable
    public final Boolean getXAxisReversed() {
        return this.xAxisReversed;
    }

    @Nullable
    public final Integer getXAxisTickInterval() {
        return this.xAxisTickInterval;
    }

    @Nullable
    public final Boolean getXAxisVisible() {
        return this.xAxisVisible;
    }

    @Nullable
    public final Boolean getYAxisAllowDecimals() {
        return this.yAxisAllowDecimals;
    }

    @Nullable
    public final Number getYAxisGridLineWidth() {
        return this.yAxisGridLineWidth;
    }

    @Nullable
    public final Boolean getYAxisLabelsEnabled() {
        return this.yAxisLabelsEnabled;
    }

    @Nullable
    public final Number getYAxisLineWidth() {
        return this.yAxisLineWidth;
    }

    @Nullable
    public final Number getYAxisMax() {
        return this.yAxisMax;
    }

    @Nullable
    public final Number getYAxisMin() {
        return this.yAxisMin;
    }

    @Nullable
    public final Boolean getYAxisReversed() {
        return this.yAxisReversed;
    }

    @Nullable
    public final String getYAxisTitle() {
        return this.yAxisTitle;
    }

    @Nullable
    public final Boolean getYAxisVisible() {
        return this.yAxisVisible;
    }

    @Nullable
    public final AAChartZoomType getZoomType() {
        return this.zoomType;
    }

    @NotNull
    public final AAChartModel gradientColorEnable(@Nullable Boolean bool) {
        this.gradientColorEnable = bool;
        return this;
    }

    @NotNull
    public final AAChartModel inverted(@Nullable Boolean bool) {
        this.inverted = bool;
        return this;
    }

    @NotNull
    public final AAChartModel legendEnabled(@Nullable Boolean bool) {
        this.legendEnabled = bool;
        return this;
    }

    @NotNull
    public final AAChartModel margin(@Nullable Number[] numberArr) {
        this.margin = numberArr;
        return this;
    }

    @NotNull
    public final AAChartModel markerRadius(@Nullable Number number) {
        this.markerRadius = number;
        return this;
    }

    @NotNull
    public final AAChartModel markerSymbol(@NotNull AAChartSymbolType prop) {
        g0.p(prop, "prop");
        this.markerSymbol = prop;
        return this;
    }

    @NotNull
    public final AAChartModel markerSymbolStyle(@NotNull AAChartSymbolStyleType prop) {
        g0.p(prop, "prop");
        this.markerSymbolStyle = prop;
        return this;
    }

    @NotNull
    public final AAChartModel polar(@Nullable Boolean bool) {
        this.polar = bool;
        return this;
    }

    @NotNull
    public final AAChartModel scrollablePlotArea(@NotNull AAScrollablePlotArea prop) {
        g0.p(prop, "prop");
        this.scrollablePlotArea = prop;
        return this;
    }

    @NotNull
    public final AAChartModel series(@NotNull Object[] prop) {
        g0.p(prop, "prop");
        this.series = prop;
        return this;
    }

    public final void setAnimationDuration(@Nullable Integer num) {
        this.animationDuration = num;
    }

    public final void setAnimationType(@Nullable AAChartAnimationType aAChartAnimationType) {
        this.animationType = aAChartAnimationType;
    }

    public final void setAxesTextColor(@Nullable String str) {
        this.axesTextColor = str;
    }

    public final void setBackgroundColor(@Nullable Object obj) {
        this.backgroundColor = obj;
    }

    public final void setBorderRadius(@Nullable Number number) {
        this.borderRadius = number;
    }

    public final void setCategories(@Nullable String[] strArr) {
        this.categories = strArr;
    }

    public final void setChartType(@Nullable AAChartType aAChartType) {
        this.chartType = aAChartType;
    }

    public final void setColorsTheme(@Nullable Object[] objArr) {
        this.colorsTheme = objArr;
    }

    public final void setDataLabelsEnabled(@Nullable Boolean bool) {
        this.dataLabelsEnabled = bool;
    }

    public final void setDataLabelsStyle(@Nullable AAStyle aAStyle) {
        this.dataLabelsStyle = aAStyle;
    }

    public final void setGradientColorEnable(@Nullable Boolean bool) {
        this.gradientColorEnable = bool;
    }

    public final void setInverted(@Nullable Boolean bool) {
        this.inverted = bool;
    }

    public final void setLegendEnabled(@Nullable Boolean bool) {
        this.legendEnabled = bool;
    }

    public final void setMargin(@Nullable Number[] numberArr) {
        this.margin = numberArr;
    }

    public final void setMarkerRadius(@Nullable Number number) {
        this.markerRadius = number;
    }

    public final void setMarkerSymbol(@Nullable AAChartSymbolType aAChartSymbolType) {
        this.markerSymbol = aAChartSymbolType;
    }

    public final void setMarkerSymbolStyle(@Nullable AAChartSymbolStyleType aAChartSymbolStyleType) {
        this.markerSymbolStyle = aAChartSymbolStyleType;
    }

    public final void setPolar(@Nullable Boolean bool) {
        this.polar = bool;
    }

    public final void setScrollablePlotArea(@Nullable AAScrollablePlotArea aAScrollablePlotArea) {
        this.scrollablePlotArea = aAScrollablePlotArea;
    }

    public final void setSeries(@Nullable Object[] objArr) {
        this.series = objArr;
    }

    public final void setStacking(@Nullable AAChartStackingType aAChartStackingType) {
        this.stacking = aAChartStackingType;
    }

    public final void setSubtitle(@Nullable String str) {
        this.subtitle = str;
    }

    public final void setSubtitleAlign(@Nullable AAChartAlignType aAChartAlignType) {
        this.subtitleAlign = aAChartAlignType;
    }

    public final void setSubtitleStyle(@Nullable AAStyle aAStyle) {
        this.subtitleStyle = aAStyle;
    }

    public final void setTitle(@Nullable String str) {
        this.title = str;
    }

    public final void setTitleStyle(@Nullable AAStyle aAStyle) {
        this.titleStyle = aAStyle;
    }

    public final void setTooltipEnabled(@Nullable Boolean bool) {
        this.tooltipEnabled = bool;
    }

    public final void setTooltipValueSuffix(@Nullable String str) {
        this.tooltipValueSuffix = str;
    }

    public final void setTouchEventEnabled(@Nullable Boolean bool) {
        this.touchEventEnabled = bool;
    }

    public final void setXAxisGridLineWidth(@Nullable Number number) {
        this.xAxisGridLineWidth = number;
    }

    public final void setXAxisLabelsEnabled(@Nullable Boolean bool) {
        this.xAxisLabelsEnabled = bool;
    }

    public final void setXAxisReversed(@Nullable Boolean bool) {
        this.xAxisReversed = bool;
    }

    public final void setXAxisTickInterval(@Nullable Integer num) {
        this.xAxisTickInterval = num;
    }

    public final void setXAxisVisible(@Nullable Boolean bool) {
        this.xAxisVisible = bool;
    }

    public final void setYAxisAllowDecimals(@Nullable Boolean bool) {
        this.yAxisAllowDecimals = bool;
    }

    public final void setYAxisGridLineWidth(@Nullable Number number) {
        this.yAxisGridLineWidth = number;
    }

    public final void setYAxisLabelsEnabled(@Nullable Boolean bool) {
        this.yAxisLabelsEnabled = bool;
    }

    public final void setYAxisLineWidth(@Nullable Number number) {
        this.yAxisLineWidth = number;
    }

    public final void setYAxisMax(@Nullable Number number) {
        this.yAxisMax = number;
    }

    public final void setYAxisMin(@Nullable Number number) {
        this.yAxisMin = number;
    }

    public final void setYAxisReversed(@Nullable Boolean bool) {
        this.yAxisReversed = bool;
    }

    public final void setYAxisTitle(@Nullable String str) {
        this.yAxisTitle = str;
    }

    public final void setYAxisVisible(@Nullable Boolean bool) {
        this.yAxisVisible = bool;
    }

    public final void setZoomType(@Nullable AAChartZoomType aAChartZoomType) {
        this.zoomType = aAChartZoomType;
    }

    @NotNull
    public final AAChartModel stacking(@NotNull AAChartStackingType prop) {
        g0.p(prop, "prop");
        this.stacking = prop;
        return this;
    }

    @NotNull
    public final AAChartModel subtitle(@NotNull String prop) {
        g0.p(prop, "prop");
        this.subtitle = prop;
        return this;
    }

    @NotNull
    public final AAChartModel subtitleAlign(@NotNull AAChartAlignType prop) {
        g0.p(prop, "prop");
        this.subtitleAlign = prop;
        return this;
    }

    @NotNull
    public final AAChartModel subtitleStyle(@NotNull AAStyle prop) {
        g0.p(prop, "prop");
        this.subtitleStyle = prop;
        return this;
    }

    @NotNull
    public final AAChartModel title(@NotNull String prop) {
        g0.p(prop, "prop");
        this.title = prop;
        return this;
    }

    @NotNull
    public final AAChartModel titleStyle(@NotNull AAStyle prop) {
        g0.p(prop, "prop");
        this.titleStyle = prop;
        return this;
    }

    @NotNull
    public final AAChartModel tooltipEnabled(@Nullable Boolean bool) {
        this.tooltipEnabled = bool;
        return this;
    }

    @NotNull
    public final AAChartModel tooltipValueSuffix(@Nullable String str) {
        this.tooltipValueSuffix = str;
        return this;
    }

    @NotNull
    public final AAChartModel touchEventEnabled(@Nullable Boolean bool) {
        this.touchEventEnabled = bool;
        return this;
    }

    @NotNull
    public final AAChartModel xAxisGridLineWidth(@Nullable Number number) {
        this.xAxisGridLineWidth = number;
        return this;
    }

    @NotNull
    public final AAChartModel xAxisLabelsEnabled(@Nullable Boolean bool) {
        this.xAxisLabelsEnabled = bool;
        return this;
    }

    @NotNull
    public final AAChartModel xAxisReversed(@Nullable Boolean bool) {
        this.xAxisReversed = bool;
        return this;
    }

    @NotNull
    public final AAChartModel xAxisTickInterval(@Nullable Integer num) {
        this.xAxisTickInterval = num;
        return this;
    }

    @NotNull
    public final AAChartModel xAxisVisible(@Nullable Boolean bool) {
        this.xAxisVisible = bool;
        return this;
    }

    @NotNull
    public final AAChartModel yAxisAllowDecimals(@Nullable Boolean bool) {
        this.yAxisAllowDecimals = bool;
        return this;
    }

    @NotNull
    public final AAChartModel yAxisGridLineWidth(@Nullable Number number) {
        this.yAxisGridLineWidth = number;
        return this;
    }

    @NotNull
    public final AAChartModel yAxisLabelsEnabled(@Nullable Boolean bool) {
        this.yAxisLabelsEnabled = bool;
        return this;
    }

    @NotNull
    public final AAChartModel yAxisLineWidth(@Nullable Number number) {
        this.yAxisLineWidth = number;
        return this;
    }

    @NotNull
    public final AAChartModel yAxisMax(@Nullable Number number) {
        this.yAxisMax = number;
        return this;
    }

    @NotNull
    public final AAChartModel yAxisMin(@Nullable Number number) {
        this.yAxisMin = number;
        return this;
    }

    @NotNull
    public final AAChartModel yAxisReversed(@Nullable Boolean bool) {
        this.yAxisReversed = bool;
        return this;
    }

    @NotNull
    public final AAChartModel yAxisTitle(@NotNull String prop) {
        g0.p(prop, "prop");
        this.yAxisTitle = prop;
        return this;
    }

    @NotNull
    public final AAChartModel yAxisVisible(@Nullable Boolean bool) {
        this.yAxisVisible = bool;
        return this;
    }

    @NotNull
    public final AAChartModel zoomType(@NotNull AAChartZoomType prop) {
        g0.p(prop, "prop");
        this.zoomType = prop;
        return this;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ AAChartModel(com.github.aachartmodel.aainfographics.aachartcreator.AAChartAnimationType r40, java.lang.Integer r41, java.lang.String r42, com.github.aachartmodel.aainfographics.aaoptionsmodel.AAStyle r43, java.lang.String r44, com.github.aachartmodel.aainfographics.aachartcreator.AAChartAlignType r45, com.github.aachartmodel.aainfographics.aaoptionsmodel.AAStyle r46, java.lang.String r47, com.github.aachartmodel.aainfographics.aachartcreator.AAChartType r48, com.github.aachartmodel.aainfographics.aachartcreator.AAChartStackingType r49, java.lang.Number r50, com.github.aachartmodel.aainfographics.aachartcreator.AAChartSymbolType r51, com.github.aachartmodel.aainfographics.aachartcreator.AAChartSymbolStyleType r52, com.github.aachartmodel.aainfographics.aachartcreator.AAChartZoomType r53, java.lang.Boolean r54, java.lang.Boolean r55, java.lang.Boolean r56, java.lang.Boolean r57, java.lang.String r58, java.lang.Boolean r59, java.lang.Boolean r60, java.lang.Number[] r61, java.lang.Boolean r62, com.github.aachartmodel.aainfographics.aaoptionsmodel.AAStyle r63, java.lang.Boolean r64, java.lang.Integer r65, java.lang.String[] r66, java.lang.Number r67, java.lang.Boolean r68, java.lang.Boolean r69, java.lang.Boolean r70, java.lang.String r71, java.lang.Number r72, java.lang.Number r73, java.lang.Number r74, java.lang.Boolean r75, java.lang.Number r76, java.lang.Object[] r77, java.lang.Boolean r78, java.lang.Object r79, java.lang.Number r80, java.lang.Object[] r81, java.lang.Boolean r82, com.github.aachartmodel.aainfographics.aaoptionsmodel.AAScrollablePlotArea r83, int r84, int r85, kotlin.jvm.internal.v r86) {
        /*
            Method dump skipped, instructions count: 575
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.aachartmodel.aainfographics.aachartcreator.AAChartModel.<init>(com.github.aachartmodel.aainfographics.aachartcreator.AAChartAnimationType, java.lang.Integer, java.lang.String, com.github.aachartmodel.aainfographics.aaoptionsmodel.AAStyle, java.lang.String, com.github.aachartmodel.aainfographics.aachartcreator.AAChartAlignType, com.github.aachartmodel.aainfographics.aaoptionsmodel.AAStyle, java.lang.String, com.github.aachartmodel.aainfographics.aachartcreator.AAChartType, com.github.aachartmodel.aainfographics.aachartcreator.AAChartStackingType, java.lang.Number, com.github.aachartmodel.aainfographics.aachartcreator.AAChartSymbolType, com.github.aachartmodel.aainfographics.aachartcreator.AAChartSymbolStyleType, com.github.aachartmodel.aainfographics.aachartcreator.AAChartZoomType, java.lang.Boolean, java.lang.Boolean, java.lang.Boolean, java.lang.Boolean, java.lang.String, java.lang.Boolean, java.lang.Boolean, java.lang.Number[], java.lang.Boolean, com.github.aachartmodel.aainfographics.aaoptionsmodel.AAStyle, java.lang.Boolean, java.lang.Integer, java.lang.String[], java.lang.Number, java.lang.Boolean, java.lang.Boolean, java.lang.Boolean, java.lang.String, java.lang.Number, java.lang.Number, java.lang.Number, java.lang.Boolean, java.lang.Number, java.lang.Object[], java.lang.Boolean, java.lang.Object, java.lang.Number, java.lang.Object[], java.lang.Boolean, com.github.aachartmodel.aainfographics.aaoptionsmodel.AAScrollablePlotArea, int, int, kotlin.jvm.internal.v):void");
    }
}
