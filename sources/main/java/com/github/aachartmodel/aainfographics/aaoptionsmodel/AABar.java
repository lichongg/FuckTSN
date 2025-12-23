package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class AABar {

    @Nullable
    private Number borderRadius;

    @Nullable
    private Number borderWidth;

    @Nullable
    private String color;

    @Nullable
    private Boolean colorByPoint;

    @Nullable
    private Object[] data;

    @Nullable
    private AADataLabels dataLabels;

    @Nullable
    private Float groupPadding;

    @Nullable
    private Boolean grouping;

    @Nullable
    private String name;

    @Nullable
    private Float pointPadding;

    @Nullable
    private Float pointPlacement;

    @Nullable
    private String stacking;

    @Nullable
    private Integer yAxis;

    @NotNull
    public final AABar borderRadius(@Nullable Number number) {
        this.borderRadius = number;
        return this;
    }

    @NotNull
    public final AABar borderWidth(@Nullable Number number) {
        this.borderWidth = number;
        return this;
    }

    @NotNull
    public final AABar color(@NotNull String prop) {
        g0.p(prop, "prop");
        this.color = prop;
        return this;
    }

    @NotNull
    public final AABar colorByPoint(@Nullable Boolean bool) {
        this.colorByPoint = bool;
        return this;
    }

    @NotNull
    public final AABar data(@NotNull Object[] prop) {
        g0.p(prop, "prop");
        this.data = prop;
        return this;
    }

    @NotNull
    public final AABar dataLabels(@NotNull AADataLabels prop) {
        g0.p(prop, "prop");
        this.dataLabels = prop;
        return this;
    }

    @Nullable
    public final Number getBorderRadius() {
        return this.borderRadius;
    }

    @Nullable
    public final Number getBorderWidth() {
        return this.borderWidth;
    }

    @Nullable
    public final String getColor() {
        return this.color;
    }

    @Nullable
    public final Boolean getColorByPoint() {
        return this.colorByPoint;
    }

    @Nullable
    public final Object[] getData() {
        return this.data;
    }

    @Nullable
    public final AADataLabels getDataLabels() {
        return this.dataLabels;
    }

    @Nullable
    public final Float getGroupPadding() {
        return this.groupPadding;
    }

    @Nullable
    public final Boolean getGrouping() {
        return this.grouping;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final Float getPointPadding() {
        return this.pointPadding;
    }

    @Nullable
    public final Float getPointPlacement() {
        return this.pointPlacement;
    }

    @Nullable
    public final String getStacking() {
        return this.stacking;
    }

    @Nullable
    public final Integer getYAxis() {
        return this.yAxis;
    }

    @NotNull
    public final AABar groupPadding(@Nullable Float f6) {
        this.groupPadding = f6;
        return this;
    }

    @NotNull
    public final AABar grouping(@Nullable Boolean bool) {
        this.grouping = bool;
        return this;
    }

    @NotNull
    public final AABar name(@NotNull String prop) {
        g0.p(prop, "prop");
        this.name = prop;
        return this;
    }

    @NotNull
    public final AABar pointPadding(@Nullable Float f6) {
        this.pointPadding = f6;
        return this;
    }

    @NotNull
    public final AABar pointPlacement(@Nullable Float f6) {
        this.pointPlacement = f6;
        return this;
    }

    public final void setBorderRadius(@Nullable Number number) {
        this.borderRadius = number;
    }

    public final void setBorderWidth(@Nullable Number number) {
        this.borderWidth = number;
    }

    public final void setColor(@Nullable String str) {
        this.color = str;
    }

    public final void setColorByPoint(@Nullable Boolean bool) {
        this.colorByPoint = bool;
    }

    public final void setData(@Nullable Object[] objArr) {
        this.data = objArr;
    }

    public final void setDataLabels(@Nullable AADataLabels aADataLabels) {
        this.dataLabels = aADataLabels;
    }

    public final void setGroupPadding(@Nullable Float f6) {
        this.groupPadding = f6;
    }

    public final void setGrouping(@Nullable Boolean bool) {
        this.grouping = bool;
    }

    public final void setName(@Nullable String str) {
        this.name = str;
    }

    public final void setPointPadding(@Nullable Float f6) {
        this.pointPadding = f6;
    }

    public final void setPointPlacement(@Nullable Float f6) {
        this.pointPlacement = f6;
    }

    public final void setStacking(@Nullable String str) {
        this.stacking = str;
    }

    public final void setYAxis(@Nullable Integer num) {
        this.yAxis = num;
    }

    @NotNull
    public final AABar stacking(@NotNull String prop) {
        g0.p(prop, "prop");
        this.stacking = prop;
        return this;
    }

    @NotNull
    public final AABar yAxis(@Nullable Integer num) {
        this.yAxis = num;
        return this;
    }
}
