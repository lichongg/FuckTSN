package com.github.aachartmodel.aainfographics.aatools;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartAlignType;
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartAnimationType;
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartModel;
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartStackingType;
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartSymbolStyleType;
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartSymbolType;
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartType;
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartZoomType;
import com.github.aachartmodel.aainfographics.aachartcreator.AASeriesElement;
import com.github.aachartmodel.aainfographics.aaoptionsmodel.AAScrollablePlotArea;
import com.github.aachartmodel.aainfographics.aaoptionsmodel.AAStyle;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.t0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class AABuilder {
    private Integer animationDuration;
    private AAChartAnimationType animationType;
    private final Context applicationContext;
    private String axesTextColor;
    private Object backgroundColor;
    private Number borderRadius;
    private String[] categories;
    private AAChartType chartType;
    private Object[] colorsTheme;
    private Boolean dataLabelsEnabled;
    private AAStyle dataLabelsStyle;
    private Boolean gradientColorEnable;
    private Boolean inverted;
    private Boolean legendEnabled;
    private Number[] margin;
    private Number markerRadius;
    private AAChartSymbolType markerSymbol;
    private AAChartSymbolStyleType markerSymbolStyle;
    private Boolean polar;
    private final Resources resources;
    private AAScrollablePlotArea scrollablePlotArea;
    private Object[] series;
    private AAChartStackingType stacking;
    private String subtitle;
    private AAChartAlignType subtitleAlign;
    private AAStyle subtitleStyle;
    private String title;
    private AAStyle titleStyle;
    private Boolean tooltipEnabled;
    private String tooltipValueSuffix;
    private Boolean touchEventEnabled;
    private Number xAxisGridLineWidth;
    private Boolean xAxisLabelsEnabled;
    private Boolean xAxisReversed;
    private Integer xAxisTickInterval;
    private Boolean xAxisVisible;
    private Boolean yAxisAllowDecimals;
    private Number yAxisGridLineWidth;
    private Boolean yAxisLabelsEnabled;
    private Number yAxisLineWidth;
    private Number yAxisMax;
    private Number yAxisMin;
    private Boolean yAxisReversed;
    private String yAxisTitle;
    private Boolean yAxisVisible;
    private AAChartZoomType zoomType;

    public AABuilder(@NotNull Context context) {
        g0.p(context, "context");
        Context applicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.applicationContext = applicationContext;
        g0.o(applicationContext, "applicationContext");
        this.resources = applicationContext.getResources();
        this.animationType = AAChartAnimationType.Linear;
        this.animationDuration = 500;
        this.title = "";
        this.subtitle = "";
        this.chartType = AAChartType.Line;
        this.stacking = AAChartStackingType.False;
        this.markerRadius = Float.valueOf(6.0f);
        this.markerSymbolStyle = AAChartSymbolStyleType.Normal;
        this.zoomType = AAChartZoomType.None;
        Boolean bool = Boolean.FALSE;
        this.inverted = bool;
        this.xAxisReversed = bool;
        this.yAxisReversed = bool;
        this.gradientColorEnable = bool;
        this.polar = bool;
        this.dataLabelsEnabled = bool;
        Boolean bool2 = Boolean.TRUE;
        this.xAxisLabelsEnabled = bool2;
        Float valueOf = Float.valueOf(0.0f);
        this.xAxisGridLineWidth = valueOf;
        this.yAxisLabelsEnabled = bool2;
        this.yAxisGridLineWidth = Float.valueOf(1.0f);
        this.colorsTheme = new Object[]{"#fe117c", "#ffc069", "#06caf4", "#7dffc0"};
        this.legendEnabled = bool2;
        this.backgroundColor = "#ffffff";
        this.borderRadius = valueOf;
    }

    @NotNull
    public final AABuilder setAxesTextColor(@NotNull String prop) {
        g0.p(prop, "prop");
        this.axesTextColor = prop;
        return this;
    }

    @NotNull
    public final AABuilder setBackgroundColor(@NotNull String prop) {
        g0.p(prop, "prop");
        this.backgroundColor = prop;
        return this;
    }

    @NotNull
    public final AABuilder setBorderRadius(@NotNull Number prop) {
        g0.p(prop, "prop");
        this.borderRadius = prop;
        return this;
    }

    @NotNull
    public final AABuilder setCategories(@NotNull String... prop) {
        g0.p(prop, "prop");
        ArrayList arrayList = new ArrayList(prop.length);
        for (String str : prop) {
            arrayList.add(str);
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        this.categories = (String[]) array;
        return this;
    }

    @NotNull
    public final AABuilder setColorsTheme(@NotNull Object[] prop) {
        g0.p(prop, "prop");
        ArrayList arrayList = new ArrayList(prop.length);
        for (Object obj : prop) {
            arrayList.add(obj);
        }
        Object[] array = arrayList.toArray(new Object[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        this.colorsTheme = array;
        return this;
    }

    @NotNull
    public final AABuilder setMargin(@NotNull Number top2, @NotNull Number left, @NotNull Number bottom, @NotNull Number right) {
        g0.p(top2, "top");
        g0.p(left, "left");
        g0.p(bottom, "bottom");
        g0.p(right, "right");
        return setMargin(top2, left, bottom, right);
    }

    @NotNull
    public final AABuilder setSubtitle(@NotNull String prop) {
        g0.p(prop, "prop");
        this.subtitle = prop;
        return this;
    }

    @NotNull
    public final AABuilder setTitle(@NotNull String prop) {
        g0.p(prop, "prop");
        this.title = prop;
        return this;
    }

    @NotNull
    public final AABuilder setTooltipValueSuffix(@NotNull String prop) {
        g0.p(prop, "prop");
        this.tooltipValueSuffix = prop;
        return this;
    }

    @NotNull
    public final AABuilder setXAxisGridLineWidth(@NotNull Number prop) {
        g0.p(prop, "prop");
        this.xAxisGridLineWidth = prop;
        return this;
    }

    @NotNull
    public final AABuilder setYAxisGridLineWidth(@NotNull Number prop) {
        g0.p(prop, "prop");
        this.yAxisGridLineWidth = prop;
        return this;
    }

    @NotNull
    public final AABuilder setYAxisLineWidth(@NotNull Number prop) {
        g0.p(prop, "prop");
        this.yAxisLineWidth = prop;
        return this;
    }

    @NotNull
    public final AABuilder setYAxisMax(@Nullable Number number) {
        this.yAxisMax = number;
        return this;
    }

    @NotNull
    public final AABuilder setYAxisMin(@Nullable Number number) {
        this.yAxisMin = number;
        return this;
    }

    @NotNull
    public final AABuilder setYAxisTitle(@NotNull String prop) {
        g0.p(prop, "prop");
        this.yAxisTitle = prop;
        return this;
    }

    private final int getColor(int i6) {
        int color;
        if (Build.VERSION.SDK_INT < 23) {
            return this.resources.getColor(i6);
        }
        color = this.applicationContext.getColor(i6);
        return color;
    }

    private final float getDimen(int i6) {
        return this.resources.getDimension(i6);
    }

    private final String getString(int i6, Object... objArr) {
        String string = this.resources.getString(i6, objArr);
        g0.o(string, "resources.getString(id, formatArgs)");
        return string;
    }

    private final String toColorString(int i6) {
        t0 t0Var = t0.f44062a;
        String format = String.format("#%06X", Arrays.copyOf(new Object[]{Integer.valueOf(i6 & 16777215)}, 1));
        g0.o(format, "java.lang.String.format(format, *args)");
        return format;
    }

    @NotNull
    public final AAChartModel build() {
        return new AAChartModel(this.animationType, this.animationDuration, this.title, this.titleStyle, this.subtitle, this.subtitleAlign, this.subtitleStyle, this.axesTextColor, this.chartType, this.stacking, this.markerRadius, this.markerSymbol, this.markerSymbolStyle, this.zoomType, this.inverted, this.xAxisReversed, this.yAxisReversed, this.tooltipEnabled, this.tooltipValueSuffix, this.gradientColorEnable, this.polar, this.margin, this.dataLabelsEnabled, this.dataLabelsStyle, this.xAxisLabelsEnabled, this.xAxisTickInterval, this.categories, this.xAxisGridLineWidth, this.xAxisVisible, this.yAxisVisible, this.yAxisLabelsEnabled, this.yAxisTitle, this.yAxisLineWidth, this.yAxisMin, this.yAxisMax, this.yAxisAllowDecimals, this.yAxisGridLineWidth, this.colorsTheme, this.legendEnabled, this.backgroundColor, this.borderRadius, this.series, this.touchEventEnabled, this.scrollablePlotArea);
    }

    @NotNull
    public final AABuilder set(@NotNull AAChartModel prop) {
        g0.p(prop, "prop");
        this.animationType = prop.getAnimationType();
        this.animationDuration = prop.getAnimationDuration();
        this.title = prop.getTitle();
        this.titleStyle = prop.getTitleStyle();
        this.subtitle = prop.getSubtitle();
        this.subtitleAlign = prop.getSubtitleAlign();
        this.subtitleStyle = prop.getSubtitleStyle();
        this.axesTextColor = prop.getAxesTextColor();
        this.chartType = prop.getChartType();
        this.stacking = prop.getStacking();
        this.markerRadius = prop.getMarkerRadius();
        this.markerSymbol = prop.getMarkerSymbol();
        this.markerSymbolStyle = prop.getMarkerSymbolStyle();
        this.zoomType = prop.getZoomType();
        this.inverted = prop.getInverted();
        this.xAxisReversed = prop.getXAxisReversed();
        this.yAxisReversed = prop.getYAxisReversed();
        this.tooltipEnabled = prop.getTooltipEnabled();
        this.tooltipValueSuffix = prop.getTooltipValueSuffix();
        this.gradientColorEnable = prop.getGradientColorEnable();
        this.polar = prop.getPolar();
        this.margin = prop.getMargin();
        this.dataLabelsEnabled = prop.getDataLabelsEnabled();
        this.dataLabelsStyle = prop.getDataLabelsStyle();
        this.xAxisLabelsEnabled = prop.getXAxisLabelsEnabled();
        this.xAxisTickInterval = prop.getXAxisTickInterval();
        this.categories = prop.getCategories();
        this.xAxisGridLineWidth = prop.getXAxisGridLineWidth();
        this.xAxisVisible = prop.getXAxisVisible();
        this.yAxisVisible = prop.getYAxisVisible();
        this.yAxisLabelsEnabled = prop.getYAxisLabelsEnabled();
        this.yAxisTitle = prop.getYAxisTitle();
        this.yAxisLineWidth = prop.getYAxisLineWidth();
        this.yAxisMin = prop.getYAxisMin();
        this.yAxisMax = prop.getYAxisMax();
        this.yAxisAllowDecimals = prop.getYAxisAllowDecimals();
        this.yAxisGridLineWidth = prop.getYAxisGridLineWidth();
        this.colorsTheme = prop.getColorsTheme();
        this.legendEnabled = prop.getLegendEnabled();
        this.backgroundColor = prop.getBackgroundColor();
        this.borderRadius = prop.getBorderRadius();
        this.series = prop.getSeries();
        this.touchEventEnabled = prop.getTouchEventEnabled();
        this.scrollablePlotArea = prop.getScrollablePlotArea();
        return this;
    }

    @NotNull
    public final AABuilder setAnimationType(@NotNull AAChartAnimationType prop) {
        g0.p(prop, "prop");
        this.animationType = prop;
        return this;
    }

    @NotNull
    public final AABuilder setAxesTextColor(int i6) {
        return setAxesTextColor(toColorString(i6));
    }

    @NotNull
    public final AABuilder setBackgroundColor(int i6) {
        return setBackgroundColor(toColorString(getColor(i6)));
    }

    @NotNull
    public final AABuilder setBorderRadius(int i6) {
        return setBorderRadius(Float.valueOf(getDimen(i6)));
    }

    @NotNull
    public final AABuilder setChartType(@NotNull AAChartType prop) {
        g0.p(prop, "prop");
        this.chartType = prop;
        return this;
    }

    @NotNull
    public final AABuilder setDataLabelsStyle(@NotNull AAStyle prop) {
        g0.p(prop, "prop");
        this.dataLabelsStyle = prop;
        return this;
    }

    @NotNull
    public final AABuilder setMargin(int i6, int i7, int i8, int i9) {
        return setMargin(Float.valueOf(getDimen(i6)), Float.valueOf(getDimen(i7)), Float.valueOf(getDimen(i8)), Float.valueOf(getDimen(i9)));
    }

    @NotNull
    public final AABuilder setMarkerRadius(@NotNull Number prop) {
        g0.p(prop, "prop");
        this.markerRadius = prop;
        return this;
    }

    @NotNull
    public final AABuilder setMarkerSymbol(@NotNull AAChartSymbolType prop) {
        g0.p(prop, "prop");
        this.markerSymbol = prop;
        return this;
    }

    @NotNull
    public final AABuilder setMarkerSymbolStyle(@NotNull AAChartSymbolStyleType prop) {
        g0.p(prop, "prop");
        this.markerSymbolStyle = prop;
        return this;
    }

    @NotNull
    public final AABuilder setScrollablePlotArea(@NotNull AAScrollablePlotArea prop) {
        g0.p(prop, "prop");
        this.scrollablePlotArea = prop;
        return this;
    }

    @NotNull
    public final AABuilder setSeries(@NotNull AASeriesElement... prop) {
        g0.p(prop, "prop");
        ArrayList arrayList = new ArrayList(prop.length);
        for (AASeriesElement aASeriesElement : prop) {
            arrayList.add(aASeriesElement);
        }
        Object[] array = arrayList.toArray(new Object[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        this.series = array;
        return this;
    }

    @NotNull
    public final AABuilder setStacking(@NotNull AAChartStackingType prop) {
        g0.p(prop, "prop");
        this.stacking = prop;
        return this;
    }

    @NotNull
    public final AABuilder setSubtitle(int i6, @NotNull Object... formatArgs) {
        g0.p(formatArgs, "formatArgs");
        return setSubtitle(getString(i6, formatArgs));
    }

    @NotNull
    public final AABuilder setSubtitleAlign(@NotNull AAChartAlignType prop) {
        g0.p(prop, "prop");
        this.subtitleAlign = prop;
        return this;
    }

    @NotNull
    public final AABuilder setSubtitleStyle(@NotNull AAStyle prop) {
        g0.p(prop, "prop");
        this.subtitleStyle = prop;
        return this;
    }

    @NotNull
    public final AABuilder setTitle(int i6, @NotNull Object... formatArgs) {
        g0.p(formatArgs, "formatArgs");
        return setTitle(getString(i6, formatArgs));
    }

    @NotNull
    public final AABuilder setTitleStyle(@NotNull AAStyle prop) {
        g0.p(prop, "prop");
        this.titleStyle = prop;
        return this;
    }

    @NotNull
    public final AABuilder setTooltipValueSuffix(int i6, @NotNull Object... formatArgs) {
        g0.p(formatArgs, "formatArgs");
        return setTooltipValueSuffix(getString(i6, formatArgs));
    }

    @NotNull
    public final AABuilder setXAxisGridLineWidth(int i6) {
        return setXAxisGridLineWidth(Float.valueOf(getDimen(i6)));
    }

    @NotNull
    public final AABuilder setYAxisGridLineWidth(int i6) {
        return setYAxisGridLineWidth(Float.valueOf(getDimen(i6)));
    }

    @NotNull
    public final AABuilder setYAxisLineWidth(int i6) {
        return setYAxisLineWidth(Float.valueOf(getDimen(i6)));
    }

    @NotNull
    public final AABuilder setYAxisMax(int i6) {
        return setYAxisMax(Float.valueOf(getDimen(i6)));
    }

    @NotNull
    public final AABuilder setYAxisMin(int i6) {
        return setYAxisMin(Float.valueOf(getDimen(i6)));
    }

    @NotNull
    public final AABuilder setYAxisTitle(int i6, @NotNull Object... formatArgs) {
        g0.p(formatArgs, "formatArgs");
        return setYAxisTitle(getString(i6, formatArgs));
    }

    @NotNull
    public final AABuilder setZoomType(@NotNull AAChartZoomType prop) {
        g0.p(prop, "prop");
        this.zoomType = prop;
        return this;
    }

    @NotNull
    public final AABuilder setAnimationDuration(int i6) {
        this.animationDuration = Integer.valueOf(i6);
        return this;
    }

    @NotNull
    public final AABuilder setAxesTextColorRes(int i6) {
        return setAxesTextColor(toColorString(getColor(i6)));
    }

    @NotNull
    public final AABuilder setDataLabelsEnabled(boolean z5) {
        this.dataLabelsEnabled = Boolean.valueOf(z5);
        return this;
    }

    @NotNull
    public final AABuilder setGradientColorEnable(boolean z5) {
        this.gradientColorEnable = Boolean.valueOf(z5);
        return this;
    }

    @NotNull
    public final AABuilder setInverted(boolean z5) {
        this.inverted = Boolean.valueOf(z5);
        return this;
    }

    @NotNull
    public final AABuilder setLegendEnabled(boolean z5) {
        this.legendEnabled = Boolean.valueOf(z5);
        return this;
    }

    @NotNull
    public final AABuilder setMarkerRadiusRes(int i6) {
        return setMarkerRadius(Float.valueOf(getDimen(i6)));
    }

    @NotNull
    public final AABuilder setPolar(boolean z5) {
        this.polar = Boolean.valueOf(z5);
        return this;
    }

    @NotNull
    public final AABuilder setTooltipEnabled(boolean z5) {
        this.tooltipEnabled = Boolean.valueOf(z5);
        return this;
    }

    @NotNull
    public final AABuilder setTouchEventEnabled(boolean z5) {
        this.touchEventEnabled = Boolean.valueOf(z5);
        return this;
    }

    @NotNull
    public final AABuilder setXAxisLabelsEnabled(boolean z5) {
        this.xAxisLabelsEnabled = Boolean.valueOf(z5);
        return this;
    }

    @NotNull
    public final AABuilder setXAxisReversed(boolean z5) {
        this.xAxisReversed = Boolean.valueOf(z5);
        return this;
    }

    @NotNull
    public final AABuilder setXAxisTickInterval(int i6) {
        this.xAxisTickInterval = Integer.valueOf(i6);
        return this;
    }

    @NotNull
    public final AABuilder setXAxisVisible(boolean z5) {
        this.xAxisVisible = Boolean.valueOf(z5);
        return this;
    }

    @NotNull
    public final AABuilder setYAxisAllowDecimals(boolean z5) {
        this.yAxisAllowDecimals = Boolean.valueOf(z5);
        return this;
    }

    @NotNull
    public final AABuilder setYAxisLabelsEnabled(boolean z5) {
        this.yAxisLabelsEnabled = Boolean.valueOf(z5);
        return this;
    }

    @NotNull
    public final AABuilder setYAxisReversed(boolean z5) {
        this.yAxisReversed = Boolean.valueOf(z5);
        return this;
    }

    @NotNull
    public final AABuilder setYAxisVisible(boolean z5) {
        this.yAxisVisible = Boolean.valueOf(z5);
        return this;
    }

    @NotNull
    public final AABuilder setCategories(@NotNull int... stringResIds) {
        g0.p(stringResIds, "stringResIds");
        ArrayList arrayList = new ArrayList(stringResIds.length);
        for (int i6 : stringResIds) {
            arrayList.add(getString(i6, new Object[0]));
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array != null) {
            String[] strArr = (String[]) array;
            return setCategories((String[]) Arrays.copyOf(strArr, strArr.length));
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    @NotNull
    public final AABuilder setColorsTheme(@NotNull String... prop) {
        g0.p(prop, "prop");
        ArrayList arrayList = new ArrayList(prop.length);
        for (String str : prop) {
            arrayList.add(str);
        }
        Object[] array = arrayList.toArray(new Object[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        this.colorsTheme = array;
        return this;
    }

    @NotNull
    public final AABuilder setMargin(@NotNull Number... prop) {
        g0.p(prop, "prop");
        ArrayList arrayList = new ArrayList(prop.length);
        for (Number number : prop) {
            arrayList.add(number);
        }
        Object[] array = arrayList.toArray(new Number[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        this.margin = (Number[]) array;
        return this;
    }

    @NotNull
    public final AABuilder setColorsTheme(@NotNull int... colorResIds) {
        g0.p(colorResIds, "colorResIds");
        ArrayList arrayList = new ArrayList(colorResIds.length);
        for (int i6 : colorResIds) {
            arrayList.add(toColorString(getColor(i6)));
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array != null) {
            String[] strArr = (String[]) array;
            return setColorsTheme((String[]) Arrays.copyOf(strArr, strArr.length));
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AABuilder(@NotNull Context context, @NotNull AAChartModel source) {
        this(context);
        g0.p(context, "context");
        g0.p(source, "source");
        set(source);
    }
}
