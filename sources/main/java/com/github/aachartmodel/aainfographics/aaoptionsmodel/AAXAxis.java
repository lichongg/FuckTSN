package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class AAXAxis extends AAAxis {
    @NotNull
    public final AAXAxis alternateGridColor(@NotNull Object prop) {
        g0.p(prop, "prop");
        setAlternateGridColor(prop);
        return this;
    }

    @NotNull
    public final AAXAxis crosshair(@NotNull AACrosshair prop) {
        g0.p(prop, "prop");
        setCrosshair(prop);
        return this;
    }

    @NotNull
    public final AAXAxis dateTimeLabelFormats(@NotNull AADateTimeLabelFormats prop) {
        g0.p(prop, "prop");
        setDateTimeLabelFormats(prop);
        return this;
    }

    @NotNull
    public final AAXAxis gridLineColor(@NotNull String prop) {
        g0.p(prop, "prop");
        setGridLineColor(prop);
        return this;
    }

    @NotNull
    public final AAXAxis gridLineDashStyle(@NotNull String prop) {
        g0.p(prop, "prop");
        setGridLineDashStyle(prop);
        return this;
    }

    @NotNull
    public final AAXAxis gridLineInterpolation(@NotNull String prop) {
        g0.p(prop, "prop");
        setGridLineInterpolation(prop);
        return this;
    }

    @NotNull
    public final AAXAxis labels(@NotNull AALabels prop) {
        g0.p(prop, "prop");
        setLabels(prop);
        return this;
    }

    @NotNull
    public final AAXAxis lineColor(@NotNull String prop) {
        g0.p(prop, "prop");
        setLineColor(prop);
        return this;
    }

    @NotNull
    public final AAXAxis plotBands(@NotNull AAPlotBandsElement[] prop) {
        g0.p(prop, "prop");
        setPlotBands(prop);
        return this;
    }

    @NotNull
    public final AAXAxis plotLines(@NotNull AAPlotLinesElement[] prop) {
        g0.p(prop, "prop");
        setPlotLines(prop);
        return this;
    }

    @NotNull
    public final AAXAxis tickPosition(@NotNull String prop) {
        g0.p(prop, "prop");
        setTickPosition(prop);
        return this;
    }

    @NotNull
    public final AAXAxis tickPositions(@NotNull Object[] prop) {
        g0.p(prop, "prop");
        setTickPositions(prop);
        return this;
    }

    @NotNull
    public final AAXAxis tickmarkPlacement(@NotNull String prop) {
        g0.p(prop, "prop");
        setTickmarkPlacement(prop);
        return this;
    }

    @NotNull
    public final AAXAxis title(@NotNull AATitle prop) {
        g0.p(prop, "prop");
        setTitle(prop);
        return this;
    }

    @NotNull
    public final AAXAxis type(@NotNull AAChartAxisType prop) {
        g0.p(prop, "prop");
        setType(prop.getValue());
        return this;
    }

    @NotNull
    public final AAXAxis allowDecimals(@Nullable Boolean bool) {
        setAllowDecimals(bool);
        return this;
    }

    @NotNull
    public final AAXAxis categories(@Nullable String[] strArr) {
        setCategories(strArr);
        return this;
    }

    @NotNull
    public final AAXAxis gridLineWidth(@Nullable Number number) {
        setGridLineWidth(number);
        return this;
    }

    @NotNull
    public final AAXAxis lineWidth(@Nullable Number number) {
        setLineWidth(number);
        return this;
    }

    @NotNull
    public final AAXAxis linkedTo(@Nullable Integer num) {
        setLinkedTo(num);
        return this;
    }

    @NotNull
    public final AAXAxis max(@Nullable Number number) {
        setMax(number);
        return this;
    }

    @NotNull
    public final AAXAxis min(@Nullable Number number) {
        setMin(number);
        return this;
    }

    @NotNull
    public final AAXAxis minRange(@Nullable Integer num) {
        setMinRange(num);
        return this;
    }

    @NotNull
    public final AAXAxis minTickInterval(@Nullable Integer num) {
        setMinTickInterval(num);
        return this;
    }

    @NotNull
    public final AAXAxis minorGridLineColor(@Nullable String str) {
        setMinorGridLineColor(str);
        return this;
    }

    @NotNull
    public final AAXAxis minorGridLineDashStyle(@Nullable String str) {
        setMinorGridLineDashStyle(str);
        return this;
    }

    @NotNull
    public final AAXAxis minorGridLineWidth(@Nullable Number number) {
        setMinorGridLineWidth(number);
        return this;
    }

    @NotNull
    public final AAXAxis minorTickColor(@Nullable String str) {
        setMinorTickColor(str);
        return this;
    }

    @NotNull
    public final AAXAxis minorTickInterval(@Nullable Object obj) {
        setMinorTickInterval(obj);
        return this;
    }

    @NotNull
    public final AAXAxis minorTickLength(@Nullable Number number) {
        setMinorTickLength(number);
        return this;
    }

    @NotNull
    public final AAXAxis minorTickPosition(@Nullable String str) {
        setMinorTickPosition(str);
        return this;
    }

    @NotNull
    public final AAXAxis minorTickWidth(@Nullable Number number) {
        setMinorTickWidth(number);
        return this;
    }

    @NotNull
    public final AAXAxis off(@Nullable Number number) {
        setOff(number);
        return this;
    }

    @NotNull
    public final AAXAxis opposite(@Nullable Boolean bool) {
        setOpposite(bool);
        return this;
    }

    @NotNull
    public final AAXAxis reversed(@Nullable Boolean bool) {
        setReversed(bool);
        return this;
    }

    @NotNull
    public final AAXAxis startOnTick(@Nullable Boolean bool) {
        setStartOnTick(bool);
        return this;
    }

    @NotNull
    public final AAXAxis tickColor(@Nullable String str) {
        setTickColor(str);
        return this;
    }

    @NotNull
    public final AAXAxis tickInterval(@Nullable Integer num) {
        setTickInterval(num);
        return this;
    }

    @NotNull
    public final AAXAxis tickLength(@Nullable Number number) {
        setTickLength(number);
        return this;
    }

    @NotNull
    public final AAXAxis tickWidth(@Nullable Number number) {
        setTickWidth(number);
        return this;
    }

    @NotNull
    public final AAXAxis visible(@Nullable Boolean bool) {
        setVisible(bool);
        return this;
    }
}
