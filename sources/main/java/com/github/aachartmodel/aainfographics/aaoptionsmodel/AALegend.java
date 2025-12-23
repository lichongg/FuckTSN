package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import com.github.aachartmodel.aainfographics.aachartcreator.AAChartAlignType;
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartLayoutType;
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartVerticalAlignType;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class AALegend {

    @Nullable
    private String align;

    @Nullable
    private String borderColor;

    @Nullable
    private Number borderWidth;

    @Nullable
    private Boolean enabled;

    @Nullable
    private Boolean floating;

    @Nullable
    private Number itemMarginTop;

    @Nullable
    private AAItemStyle itemStyle;

    @Nullable
    private String labelFormat;

    @Nullable
    private String layout;

    @Nullable
    private String verticalAlign;

    /* renamed from: x, reason: collision with root package name */
    @Nullable
    private Number f32549x;

    /* renamed from: y, reason: collision with root package name */
    @Nullable
    private Number f32550y;

    @NotNull
    public final AALegend align(@NotNull AAChartAlignType prop) {
        g0.p(prop, "prop");
        this.align = prop.getValue();
        return this;
    }

    @NotNull
    public final AALegend borderColor(@NotNull String prop) {
        g0.p(prop, "prop");
        this.borderColor = prop;
        return this;
    }

    @NotNull
    public final AALegend borderWidth(@Nullable Number number) {
        this.borderWidth = number;
        return this;
    }

    @NotNull
    public final AALegend enabled(@Nullable Boolean bool) {
        this.enabled = bool;
        return this;
    }

    @NotNull
    public final AALegend floating(@Nullable Boolean bool) {
        this.floating = bool;
        return this;
    }

    @Nullable
    public final String getAlign() {
        return this.align;
    }

    @Nullable
    public final String getBorderColor() {
        return this.borderColor;
    }

    @Nullable
    public final Number getBorderWidth() {
        return this.borderWidth;
    }

    @Nullable
    public final Boolean getEnabled() {
        return this.enabled;
    }

    @Nullable
    public final Boolean getFloating() {
        return this.floating;
    }

    @Nullable
    public final Number getItemMarginTop() {
        return this.itemMarginTop;
    }

    @Nullable
    public final AAItemStyle getItemStyle() {
        return this.itemStyle;
    }

    @Nullable
    public final String getLabelFormat() {
        return this.labelFormat;
    }

    @Nullable
    public final String getLayout() {
        return this.layout;
    }

    @Nullable
    public final String getVerticalAlign() {
        return this.verticalAlign;
    }

    @Nullable
    public final Number getX() {
        return this.f32549x;
    }

    @Nullable
    public final Number getY() {
        return this.f32550y;
    }

    @NotNull
    public final AALegend itemMarginTop(@Nullable Number number) {
        this.itemMarginTop = number;
        return this;
    }

    @NotNull
    public final AALegend itemStyle(@NotNull AAItemStyle prop) {
        g0.p(prop, "prop");
        this.itemStyle = prop;
        return this;
    }

    @NotNull
    public final AALegend labelFormat(@Nullable String str) {
        this.labelFormat = str;
        return this;
    }

    @NotNull
    public final AALegend layout(@NotNull AAChartLayoutType prop) {
        g0.p(prop, "prop");
        this.layout = prop.getValue();
        return this;
    }

    public final void setAlign(@Nullable String str) {
        this.align = str;
    }

    public final void setBorderColor(@Nullable String str) {
        this.borderColor = str;
    }

    public final void setBorderWidth(@Nullable Number number) {
        this.borderWidth = number;
    }

    public final void setEnabled(@Nullable Boolean bool) {
        this.enabled = bool;
    }

    public final void setFloating(@Nullable Boolean bool) {
        this.floating = bool;
    }

    public final void setItemMarginTop(@Nullable Number number) {
        this.itemMarginTop = number;
    }

    public final void setItemStyle(@Nullable AAItemStyle aAItemStyle) {
        this.itemStyle = aAItemStyle;
    }

    public final void setLabelFormat(@Nullable String str) {
        this.labelFormat = str;
    }

    public final void setLayout(@Nullable String str) {
        this.layout = str;
    }

    public final void setVerticalAlign(@Nullable String str) {
        this.verticalAlign = str;
    }

    public final void setX(@Nullable Number number) {
        this.f32549x = number;
    }

    public final void setY(@Nullable Number number) {
        this.f32550y = number;
    }

    @NotNull
    public final AALegend verticalAlign(@NotNull AAChartVerticalAlignType prop) {
        g0.p(prop, "prop");
        this.verticalAlign = prop.getValue();
        return this;
    }

    @NotNull
    public final AALegend x(@Nullable Number number) {
        this.f32549x = number;
        return this;
    }

    @NotNull
    public final AALegend y(@Nullable Number number) {
        this.f32550y = number;
        return this;
    }
}
