package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import com.github.aachartmodel.aainfographics.aachartcreator.AAChartAlignType;
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartVerticalAlignType;
import com.github.aachartmodel.aainfographics.aatools.AAJSStringPurer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class AADataLabels {

    @Nullable
    private String align;

    @Nullable
    private Boolean allowOverlap;

    @Nullable
    private String backgroundColor;

    @Nullable
    private String borderColor;

    @Nullable
    private Number borderRadius;

    @Nullable
    private Number borderWidth;

    @Nullable
    private String color;

    @Nullable
    private Boolean crop;

    @Nullable
    private Number distance;

    @Nullable
    private Boolean enabled;

    @Nullable
    private Object filter;

    @Nullable
    private String format;

    @Nullable
    private String formatter;

    @Nullable
    private Boolean inside;

    @Nullable
    private String overflow;

    @Nullable
    private Number rotation;

    @Nullable
    private String shape;

    @Nullable
    private Boolean softConnector;

    @Nullable
    private AAStyle style;

    @Nullable
    private Object textPath;

    @Nullable
    private Boolean useHTML;

    @Nullable
    private String verticalAlign;

    /* renamed from: x, reason: collision with root package name */
    @Nullable
    private Number f32543x;

    /* renamed from: y, reason: collision with root package name */
    @Nullable
    private Number f32544y;

    @NotNull
    public final AADataLabels align(@Nullable AAChartAlignType aAChartAlignType) {
        this.align = aAChartAlignType != null ? aAChartAlignType.getValue() : null;
        return this;
    }

    @NotNull
    public final AADataLabels allowOverlap(@Nullable Boolean bool) {
        this.allowOverlap = bool;
        return this;
    }

    @NotNull
    public final AADataLabels backgroundColor(@Nullable String str) {
        this.backgroundColor = str;
        return this;
    }

    @NotNull
    public final AADataLabels borderColor(@Nullable String str) {
        this.borderColor = str;
        return this;
    }

    @NotNull
    public final AADataLabels borderRadius(@Nullable Number number) {
        this.borderRadius = number;
        return this;
    }

    @NotNull
    public final AADataLabels borderWidth(@Nullable Number number) {
        this.borderWidth = number;
        return this;
    }

    @NotNull
    public final AADataLabels color(@Nullable String str) {
        this.color = str;
        return this;
    }

    @NotNull
    public final AADataLabels crop(@Nullable Boolean bool) {
        this.crop = bool;
        return this;
    }

    @NotNull
    public final AADataLabels distance(@Nullable Number number) {
        this.distance = number;
        return this;
    }

    @NotNull
    public final AADataLabels enabled(@Nullable Boolean bool) {
        this.enabled = bool;
        return this;
    }

    @NotNull
    public final AADataLabels filter(@Nullable Object obj) {
        this.filter = obj;
        return this;
    }

    @NotNull
    public final AADataLabels format(@Nullable String str) {
        this.format = str;
        return this;
    }

    @NotNull
    public final AADataLabels formatter(@Nullable String str) {
        this.formatter = AAJSStringPurer.INSTANCE.pureAnonymousJSFunctionString(str);
        return this;
    }

    @Nullable
    public final String getAlign() {
        return this.align;
    }

    @Nullable
    public final Boolean getAllowOverlap() {
        return this.allowOverlap;
    }

    @Nullable
    public final String getBackgroundColor() {
        return this.backgroundColor;
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
    public final Number getBorderWidth() {
        return this.borderWidth;
    }

    @Nullable
    public final String getColor() {
        return this.color;
    }

    @Nullable
    public final Boolean getCrop() {
        return this.crop;
    }

    @Nullable
    public final Number getDistance() {
        return this.distance;
    }

    @Nullable
    public final Boolean getEnabled() {
        return this.enabled;
    }

    @Nullable
    public final Object getFilter() {
        return this.filter;
    }

    @Nullable
    public final String getFormat() {
        return this.format;
    }

    @Nullable
    public final String getFormatter() {
        return this.formatter;
    }

    @Nullable
    public final Boolean getInside() {
        return this.inside;
    }

    @Nullable
    public final String getOverflow() {
        return this.overflow;
    }

    @Nullable
    public final Number getRotation() {
        return this.rotation;
    }

    @Nullable
    public final String getShape() {
        return this.shape;
    }

    @Nullable
    public final Boolean getSoftConnector() {
        return this.softConnector;
    }

    @Nullable
    public final AAStyle getStyle() {
        return this.style;
    }

    @Nullable
    public final Object getTextPath() {
        return this.textPath;
    }

    @Nullable
    public final Boolean getUseHTML() {
        return this.useHTML;
    }

    @Nullable
    public final String getVerticalAlign() {
        return this.verticalAlign;
    }

    @Nullable
    public final Number getX() {
        return this.f32543x;
    }

    @Nullable
    public final Number getY() {
        return this.f32544y;
    }

    @NotNull
    public final AADataLabels inside(@Nullable Boolean bool) {
        this.inside = bool;
        return this;
    }

    @NotNull
    public final AADataLabels overflow(@Nullable String str) {
        this.overflow = str;
        return this;
    }

    @NotNull
    public final AADataLabels rotation(@Nullable Number number) {
        this.rotation = number;
        return this;
    }

    public final void setAlign(@Nullable String str) {
        this.align = str;
    }

    public final void setAllowOverlap(@Nullable Boolean bool) {
        this.allowOverlap = bool;
    }

    public final void setBackgroundColor(@Nullable String str) {
        this.backgroundColor = str;
    }

    public final void setBorderColor(@Nullable String str) {
        this.borderColor = str;
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

    public final void setCrop(@Nullable Boolean bool) {
        this.crop = bool;
    }

    public final void setDistance(@Nullable Number number) {
        this.distance = number;
    }

    public final void setEnabled(@Nullable Boolean bool) {
        this.enabled = bool;
    }

    public final void setFilter(@Nullable Object obj) {
        this.filter = obj;
    }

    public final void setFormat(@Nullable String str) {
        this.format = str;
    }

    public final void setFormatter(@Nullable String str) {
        this.formatter = str;
    }

    public final void setInside(@Nullable Boolean bool) {
        this.inside = bool;
    }

    public final void setOverflow(@Nullable String str) {
        this.overflow = str;
    }

    public final void setRotation(@Nullable Number number) {
        this.rotation = number;
    }

    public final void setShape(@Nullable String str) {
        this.shape = str;
    }

    public final void setSoftConnector(@Nullable Boolean bool) {
        this.softConnector = bool;
    }

    public final void setStyle(@Nullable AAStyle aAStyle) {
        this.style = aAStyle;
    }

    public final void setTextPath(@Nullable Object obj) {
        this.textPath = obj;
    }

    public final void setUseHTML(@Nullable Boolean bool) {
        this.useHTML = bool;
    }

    public final void setVerticalAlign(@Nullable String str) {
        this.verticalAlign = str;
    }

    public final void setX(@Nullable Number number) {
        this.f32543x = number;
    }

    public final void setY(@Nullable Number number) {
        this.f32544y = number;
    }

    @NotNull
    public final AADataLabels shape(@Nullable String str) {
        this.shape = str;
        return this;
    }

    @NotNull
    public final AADataLabels softConnector(@Nullable Boolean bool) {
        this.softConnector = bool;
        return this;
    }

    @NotNull
    public final AADataLabels style(@Nullable AAStyle aAStyle) {
        this.style = aAStyle;
        return this;
    }

    @NotNull
    public final AADataLabels textPath(@Nullable Object obj) {
        this.textPath = obj;
        return this;
    }

    @NotNull
    public final AADataLabels useHTML(@Nullable Boolean bool) {
        this.useHTML = bool;
        return this;
    }

    @NotNull
    public final AADataLabels verticalAlign(@Nullable AAChartVerticalAlignType aAChartVerticalAlignType) {
        this.verticalAlign = aAChartVerticalAlignType != null ? aAChartVerticalAlignType.getValue() : null;
        return this;
    }

    @NotNull
    public final AADataLabels x(@Nullable Number number) {
        this.f32543x = number;
        return this;
    }

    @NotNull
    public final AADataLabels y(@Nullable Number number) {
        this.f32544y = number;
        return this;
    }
}
