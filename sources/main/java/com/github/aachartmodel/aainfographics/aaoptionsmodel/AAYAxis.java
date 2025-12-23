package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class AAYAxis extends AAAxis {

    @Nullable
    private Object stackLabels;

    @NotNull
    public final AAYAxis alternateGridColor(@NotNull Object prop) {
        g0.p(prop, "prop");
        setAlternateGridColor(prop);
        return this;
    }

    @NotNull
    public final AAYAxis crosshair(@NotNull AACrosshair prop) {
        g0.p(prop, "prop");
        setCrosshair(prop);
        return this;
    }

    @NotNull
    public final AAYAxis dateTimeLabelFormats(@NotNull AADateTimeLabelFormats prop) {
        g0.p(prop, "prop");
        setDateTimeLabelFormats(prop);
        return this;
    }

    @Nullable
    public final Object getStackLabels() {
        return this.stackLabels;
    }

    @NotNull
    public final AAYAxis gridLineColor(@NotNull String prop) {
        g0.p(prop, "prop");
        setGridLineColor(prop);
        return this;
    }

    @NotNull
    public final AAYAxis gridLineDashStyle(@NotNull String prop) {
        g0.p(prop, "prop");
        setGridLineDashStyle(prop);
        return this;
    }

    @NotNull
    public final AAYAxis gridLineInterpolation(@NotNull String prop) {
        g0.p(prop, "prop");
        setGridLineInterpolation(prop);
        return this;
    }

    @NotNull
    public final AAYAxis labels(@NotNull AALabels prop) {
        g0.p(prop, "prop");
        setLabels(prop);
        return this;
    }

    @NotNull
    public final AAYAxis lineColor(@NotNull String prop) {
        g0.p(prop, "prop");
        setLineColor(prop);
        return this;
    }

    @NotNull
    public final AAYAxis plotBands(@NotNull AAPlotBandsElement[] prop) {
        g0.p(prop, "prop");
        setPlotBands(prop);
        return this;
    }

    @NotNull
    public final AAYAxis plotLines(@NotNull AAPlotLinesElement[] prop) {
        g0.p(prop, "prop");
        setPlotLines(prop);
        return this;
    }

    public final void setStackLabels(@Nullable Object obj) {
        this.stackLabels = obj;
    }

    @NotNull
    public final AAYAxis stackLabels(@Nullable Object obj) {
        this.stackLabels = obj;
        return this;
    }

    @NotNull
    public final AAYAxis tickPosition(@NotNull String prop) {
        g0.p(prop, "prop");
        setTickPosition(prop);
        return this;
    }

    @NotNull
    public final AAYAxis tickPositions(@NotNull Object[] prop) {
        g0.p(prop, "prop");
        setTickPositions(prop);
        return this;
    }

    @NotNull
    public final AAYAxis tickmarkPlacement(@NotNull String prop) {
        g0.p(prop, "prop");
        setTickmarkPlacement(prop);
        return this;
    }

    @NotNull
    public final AAYAxis title(@NotNull AATitle prop) {
        g0.p(prop, "prop");
        setTitle(prop);
        return this;
    }

    @NotNull
    public final AAYAxis type(@NotNull AAChartAxisType prop) {
        g0.p(prop, "prop");
        setType(prop.getValue());
        return this;
    }

    @NotNull
    public final AAYAxis allowDecimals(@Nullable Boolean bool) {
        setAllowDecimals(bool);
        return this;
    }

    @NotNull
    public final AAYAxis categories(@Nullable String[] strArr) {
        setCategories(strArr);
        return this;
    }

    @NotNull
    public final AAYAxis gridLineWidth(@Nullable Number number) {
        setGridLineWidth(number);
        return this;
    }

    @NotNull
    public final AAYAxis lineWidth(@Nullable Number number) {
        setLineWidth(number);
        return this;
    }

    @NotNull
    public final AAYAxis linkedTo(@Nullable Integer num) {
        setLinkedTo(num);
        return this;
    }

    @NotNull
    public final AAYAxis max(@Nullable Number number) {
        setMax(number);
        return this;
    }

    @NotNull
    public final AAYAxis min(@Nullable Number number) {
        setMin(number);
        return this;
    }

    @NotNull
    public final AAYAxis minRange(@Nullable Integer num) {
        setMinRange(num);
        return this;
    }

    @NotNull
    public final AAYAxis minTickInterval(@Nullable Integer num) {
        setMinTickInterval(num);
        return this;
    }

    @NotNull
    public final AAYAxis minorGridLineColor(@Nullable String str) {
        setMinorGridLineColor(str);
        return this;
    }

    @NotNull
    public final AAYAxis minorGridLineDashStyle(@Nullable String str) {
        setMinorGridLineDashStyle(str);
        return this;
    }

    @NotNull
    public final AAYAxis minorGridLineWidth(@Nullable Number number) {
        setMinorGridLineWidth(number);
        return this;
    }

    @NotNull
    public final AAYAxis minorTickColor(@Nullable String str) {
        setMinorTickColor(str);
        return this;
    }

    @NotNull
    public final AAYAxis minorTickInterval(@Nullable Object obj) {
        setMinorTickInterval(obj);
        return this;
    }

    @NotNull
    public final AAYAxis minorTickLength(@Nullable Number number) {
        setMinorTickLength(number);
        return this;
    }

    @NotNull
    public final AAYAxis minorTickPosition(@Nullable String str) {
        setMinorTickPosition(str);
        return this;
    }

    @NotNull
    public final AAYAxis minorTickWidth(@Nullable Number number) {
        setMinorTickWidth(number);
        return this;
    }

    @NotNull
    public final AAYAxis off(@Nullable Number number) {
        setOff(number);
        return this;
    }

    @NotNull
    public final AAYAxis opposite(@Nullable Boolean bool) {
        setOpposite(bool);
        return this;
    }

    @NotNull
    public final AAYAxis reversed(@Nullable Boolean bool) {
        setReversed(bool);
        return this;
    }

    @NotNull
    public final AAYAxis startOnTick(@Nullable Boolean bool) {
        setStartOnTick(bool);
        return this;
    }

    @NotNull
    public final AAYAxis tickColor(@Nullable String str) {
        setTickColor(str);
        return this;
    }

    @NotNull
    public final AAYAxis tickInterval(@Nullable Integer num) {
        setTickInterval(num);
        return this;
    }

    @NotNull
    public final AAYAxis tickLength(@Nullable Number number) {
        setTickLength(number);
        return this;
    }

    @NotNull
    public final AAYAxis tickWidth(@Nullable Number number) {
        setTickWidth(number);
        return this;
    }

    @NotNull
    public final AAYAxis visible(@Nullable Boolean bool) {
        setVisible(bool);
        return this;
    }
}
