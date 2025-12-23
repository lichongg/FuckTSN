package com.github.aachartmodel.aainfographics.aachartcreator;

import com.github.aachartmodel.aainfographics.aaoptionsmodel.AAChart;
import com.github.aachartmodel.aainfographics.aaoptionsmodel.AACredits;
import com.github.aachartmodel.aainfographics.aaoptionsmodel.AALang;
import com.github.aachartmodel.aainfographics.aaoptionsmodel.AALegend;
import com.github.aachartmodel.aainfographics.aaoptionsmodel.AAPane;
import com.github.aachartmodel.aainfographics.aaoptionsmodel.AAPlotOptions;
import com.github.aachartmodel.aainfographics.aaoptionsmodel.AASubtitle;
import com.github.aachartmodel.aainfographics.aaoptionsmodel.AATitle;
import com.github.aachartmodel.aainfographics.aaoptionsmodel.AATooltip;
import com.github.aachartmodel.aainfographics.aaoptionsmodel.AAXAxis;
import com.github.aachartmodel.aainfographics.aaoptionsmodel.AAYAxis;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class AAOptions {

    @Nullable
    private AAChart chart;

    @Nullable
    private Object[] colors;

    @Nullable
    private AACredits credits;

    @Nullable
    private AALang defaultOptions;

    @Nullable
    private AALegend legend;

    @Nullable
    private AAPane pane;

    @Nullable
    private AAPlotOptions plotOptions;

    @Nullable
    private Object[] series;

    @Nullable
    private AASubtitle subtitle;

    @Nullable
    private AATitle title;

    @Nullable
    private AATooltip tooltip;

    @Nullable
    private Boolean touchEventEnabled;

    @Nullable
    private AAXAxis xAxis;

    @Nullable
    private AAXAxis[] xAxisArray;

    @Nullable
    private AAYAxis yAxis;

    @Nullable
    private AAYAxis[] yAxisArray;

    @NotNull
    public final AAOptions chart(@NotNull AAChart prop) {
        g0.p(prop, "prop");
        this.chart = prop;
        return this;
    }

    @NotNull
    public final AAOptions colors(@Nullable Object[] objArr) {
        this.colors = objArr;
        return this;
    }

    @NotNull
    public final AAOptions credits(@NotNull AACredits prop) {
        g0.p(prop, "prop");
        this.credits = prop;
        return this;
    }

    @NotNull
    public final AAOptions defaultOptions(@NotNull AALang prop) {
        g0.p(prop, "prop");
        this.defaultOptions = prop;
        return this;
    }

    @Nullable
    public final AAChart getChart() {
        return this.chart;
    }

    @Nullable
    public final Object[] getColors() {
        return this.colors;
    }

    @Nullable
    public final AACredits getCredits() {
        return this.credits;
    }

    @Nullable
    public final AALang getDefaultOptions() {
        return this.defaultOptions;
    }

    @Nullable
    public final AALegend getLegend() {
        return this.legend;
    }

    @Nullable
    public final AAPane getPane() {
        return this.pane;
    }

    @Nullable
    public final AAPlotOptions getPlotOptions() {
        return this.plotOptions;
    }

    @Nullable
    public final Object[] getSeries() {
        return this.series;
    }

    @Nullable
    public final AASubtitle getSubtitle() {
        return this.subtitle;
    }

    @Nullable
    public final AATitle getTitle() {
        return this.title;
    }

    @Nullable
    public final AATooltip getTooltip() {
        return this.tooltip;
    }

    @Nullable
    public final Boolean getTouchEventEnabled() {
        return this.touchEventEnabled;
    }

    @Nullable
    public final AAXAxis getXAxis() {
        return this.xAxis;
    }

    @Nullable
    public final AAXAxis[] getXAxisArray() {
        return this.xAxisArray;
    }

    @Nullable
    public final AAYAxis getYAxis() {
        return this.yAxis;
    }

    @Nullable
    public final AAYAxis[] getYAxisArray() {
        return this.yAxisArray;
    }

    @NotNull
    public final AAOptions legend(@NotNull AALegend prop) {
        g0.p(prop, "prop");
        this.legend = prop;
        return this;
    }

    @NotNull
    public final AAOptions pane(@Nullable AAPane aAPane) {
        this.pane = aAPane;
        return this;
    }

    @NotNull
    public final AAOptions plotOptions(@NotNull AAPlotOptions prop) {
        g0.p(prop, "prop");
        this.plotOptions = prop;
        return this;
    }

    @NotNull
    public final AAOptions series(@Nullable Object[] objArr) {
        this.series = objArr;
        return this;
    }

    public final void setChart(@Nullable AAChart aAChart) {
        this.chart = aAChart;
    }

    public final void setColors(@Nullable Object[] objArr) {
        this.colors = objArr;
    }

    public final void setCredits(@Nullable AACredits aACredits) {
        this.credits = aACredits;
    }

    public final void setDefaultOptions(@Nullable AALang aALang) {
        this.defaultOptions = aALang;
    }

    public final void setLegend(@Nullable AALegend aALegend) {
        this.legend = aALegend;
    }

    public final void setPane(@Nullable AAPane aAPane) {
        this.pane = aAPane;
    }

    public final void setPlotOptions(@Nullable AAPlotOptions aAPlotOptions) {
        this.plotOptions = aAPlotOptions;
    }

    public final void setSeries(@Nullable Object[] objArr) {
        this.series = objArr;
    }

    public final void setSubtitle(@Nullable AASubtitle aASubtitle) {
        this.subtitle = aASubtitle;
    }

    public final void setTitle(@Nullable AATitle aATitle) {
        this.title = aATitle;
    }

    public final void setTooltip(@Nullable AATooltip aATooltip) {
        this.tooltip = aATooltip;
    }

    public final void setTouchEventEnabled(@Nullable Boolean bool) {
        this.touchEventEnabled = bool;
    }

    public final void setXAxis(@Nullable AAXAxis aAXAxis) {
        this.xAxis = aAXAxis;
    }

    public final void setXAxisArray(@Nullable AAXAxis[] aAXAxisArr) {
        this.xAxisArray = aAXAxisArr;
    }

    public final void setYAxis(@Nullable AAYAxis aAYAxis) {
        this.yAxis = aAYAxis;
    }

    public final void setYAxisArray(@Nullable AAYAxis[] aAYAxisArr) {
        this.yAxisArray = aAYAxisArr;
    }

    @NotNull
    public final AAOptions subtitle(@NotNull AASubtitle prop) {
        g0.p(prop, "prop");
        this.subtitle = prop;
        return this;
    }

    @NotNull
    public final AAOptions title(@NotNull AATitle prop) {
        g0.p(prop, "prop");
        this.title = prop;
        return this;
    }

    @NotNull
    public final AAOptions tooltip(@NotNull AATooltip prop) {
        g0.p(prop, "prop");
        this.tooltip = prop;
        return this;
    }

    @NotNull
    public final AAOptions touchEventEnabled(@Nullable Boolean bool) {
        this.touchEventEnabled = bool;
        return this;
    }

    @NotNull
    public final AAOptions xAxis(@NotNull AAXAxis prop) {
        g0.p(prop, "prop");
        this.xAxis = prop;
        return this;
    }

    @NotNull
    public final AAOptions xAxisArray(@NotNull AAXAxis[] prop) {
        g0.p(prop, "prop");
        this.xAxisArray = prop;
        return this;
    }

    @NotNull
    public final AAOptions yAxis(@NotNull AAYAxis prop) {
        g0.p(prop, "prop");
        this.yAxis = prop;
        return this;
    }

    @NotNull
    public final AAOptions yAxisArray(@NotNull AAYAxis[] prop) {
        g0.p(prop, "prop");
        this.yAxisArray = prop;
        return this;
    }

    public AAOptions() {
        AACredits aACredits = new AACredits();
        aACredits.setEnabled(Boolean.FALSE);
        this.credits = aACredits;
    }
}
