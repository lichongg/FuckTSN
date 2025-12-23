package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class AAPlotOptions {

    @Nullable
    private AAArea area;

    @Nullable
    private Object arearange;

    @Nullable
    private AAAreaspline areaspline;

    @Nullable
    private AABar bar;

    @Nullable
    private AAColumn column;

    @Nullable
    private Object columnrange;

    @Nullable
    private AALine line;

    @Nullable
    private AAPie pie;

    @Nullable
    private AAScatter scatter;

    @Nullable
    private AASeries series;

    @Nullable
    private AASpline spline;

    @NotNull
    public final AAPlotOptions area(@NotNull AAArea prop) {
        g0.p(prop, "prop");
        this.area = prop;
        return this;
    }

    @NotNull
    public final AAPlotOptions arearange(@NotNull Object prop) {
        g0.p(prop, "prop");
        this.arearange = prop;
        return this;
    }

    @NotNull
    public final AAPlotOptions areaspline(@NotNull AAAreaspline prop) {
        g0.p(prop, "prop");
        this.areaspline = prop;
        return this;
    }

    @NotNull
    public final AAPlotOptions bar(@NotNull AABar prop) {
        g0.p(prop, "prop");
        this.bar = prop;
        return this;
    }

    @NotNull
    public final AAPlotOptions column(@NotNull AAColumn prop) {
        g0.p(prop, "prop");
        this.column = prop;
        return this;
    }

    @NotNull
    public final AAPlotOptions columnrange(@NotNull Object prop) {
        g0.p(prop, "prop");
        this.columnrange = prop;
        return this;
    }

    @Nullable
    public final AAArea getArea() {
        return this.area;
    }

    @Nullable
    public final Object getArearange() {
        return this.arearange;
    }

    @Nullable
    public final AAAreaspline getAreaspline() {
        return this.areaspline;
    }

    @Nullable
    public final AABar getBar() {
        return this.bar;
    }

    @Nullable
    public final AAColumn getColumn() {
        return this.column;
    }

    @Nullable
    public final Object getColumnrange() {
        return this.columnrange;
    }

    @Nullable
    public final AALine getLine() {
        return this.line;
    }

    @Nullable
    public final AAPie getPie() {
        return this.pie;
    }

    @Nullable
    public final AAScatter getScatter() {
        return this.scatter;
    }

    @Nullable
    public final AASeries getSeries() {
        return this.series;
    }

    @Nullable
    public final AASpline getSpline() {
        return this.spline;
    }

    @NotNull
    public final AAPlotOptions line(@NotNull AALine prop) {
        g0.p(prop, "prop");
        this.line = prop;
        return this;
    }

    @NotNull
    public final AAPlotOptions pie(@NotNull AAPie prop) {
        g0.p(prop, "prop");
        this.pie = prop;
        return this;
    }

    @NotNull
    public final AAPlotOptions scatter(@NotNull AAScatter prop) {
        g0.p(prop, "prop");
        this.scatter = prop;
        return this;
    }

    @NotNull
    public final AAPlotOptions series(@NotNull AASeries prop) {
        g0.p(prop, "prop");
        this.series = prop;
        return this;
    }

    public final void setArea(@Nullable AAArea aAArea) {
        this.area = aAArea;
    }

    public final void setArearange(@Nullable Object obj) {
        this.arearange = obj;
    }

    public final void setAreaspline(@Nullable AAAreaspline aAAreaspline) {
        this.areaspline = aAAreaspline;
    }

    public final void setBar(@Nullable AABar aABar) {
        this.bar = aABar;
    }

    public final void setColumn(@Nullable AAColumn aAColumn) {
        this.column = aAColumn;
    }

    public final void setColumnrange(@Nullable Object obj) {
        this.columnrange = obj;
    }

    public final void setLine(@Nullable AALine aALine) {
        this.line = aALine;
    }

    public final void setPie(@Nullable AAPie aAPie) {
        this.pie = aAPie;
    }

    public final void setScatter(@Nullable AAScatter aAScatter) {
        this.scatter = aAScatter;
    }

    public final void setSeries(@Nullable AASeries aASeries) {
        this.series = aASeries;
    }

    public final void setSpline(@Nullable AASpline aASpline) {
        this.spline = aASpline;
    }

    @NotNull
    public final AAPlotOptions spline(@NotNull AASpline prop) {
        g0.p(prop, "prop");
        this.spline = prop;
        return this;
    }
}
