package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import com.github.aachartmodel.aainfographics.aachartcreator.AAChartAlignType;
import com.github.aachartmodel.aainfographics.aatools.AAJSStringPurer;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class AALabels {

    @Nullable
    private String align;

    @Nullable
    private Object autoRotation;

    @Nullable
    private Number autoRotationLimit;

    @Nullable
    private Number distance;

    @Nullable
    private Boolean enabled;

    @Nullable
    private String format;

    @Nullable
    private String formatter;

    @Nullable
    private Number padding;

    @Nullable
    private Number rotation;

    @Nullable
    private Integer staggerLines;

    @Nullable
    private Integer step;

    @Nullable
    private AAStyle style;

    @Nullable
    private Boolean useHTML;

    /* renamed from: x, reason: collision with root package name */
    @Nullable
    private Number f32547x;

    /* renamed from: y, reason: collision with root package name */
    @Nullable
    private Number f32548y;

    @NotNull
    public final AALabels align(@NotNull AAChartAlignType prop) {
        g0.p(prop, "prop");
        this.align = prop.getValue();
        return this;
    }

    @NotNull
    public final AALabels autoRotation(@NotNull Object prop) {
        g0.p(prop, "prop");
        this.autoRotation = prop;
        return this;
    }

    @NotNull
    public final AALabels autoRotationLimit(@Nullable Number number) {
        this.autoRotationLimit = number;
        return this;
    }

    @NotNull
    public final AALabels distance(@Nullable Number number) {
        this.distance = number;
        return this;
    }

    @NotNull
    public final AALabels enabled(@Nullable Boolean bool) {
        this.enabled = bool;
        return this;
    }

    @NotNull
    public final AALabels format(@NotNull String prop) {
        g0.p(prop, "prop");
        this.format = prop;
        return this;
    }

    @NotNull
    public final AALabels formatter(@NotNull String prop) {
        g0.p(prop, "prop");
        this.formatter = AAJSStringPurer.INSTANCE.pureAnonymousJSFunctionString(prop);
        return this;
    }

    @Nullable
    public final String getAlign() {
        return this.align;
    }

    @Nullable
    public final Object getAutoRotation() {
        return this.autoRotation;
    }

    @Nullable
    public final Number getAutoRotationLimit() {
        return this.autoRotationLimit;
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
    public final String getFormat() {
        return this.format;
    }

    @Nullable
    public final String getFormatter() {
        return this.formatter;
    }

    @Nullable
    public final Number getPadding() {
        return this.padding;
    }

    @Nullable
    public final Number getRotation() {
        return this.rotation;
    }

    @Nullable
    public final Integer getStaggerLines() {
        return this.staggerLines;
    }

    @Nullable
    public final Integer getStep() {
        return this.step;
    }

    @Nullable
    public final AAStyle getStyle() {
        return this.style;
    }

    @Nullable
    public final Boolean getUseHTML() {
        return this.useHTML;
    }

    @Nullable
    public final Number getX() {
        return this.f32547x;
    }

    @Nullable
    public final Number getY() {
        return this.f32548y;
    }

    @NotNull
    public final AALabels padding(@Nullable Number number) {
        this.padding = number;
        return this;
    }

    @NotNull
    public final AALabels rotation(@Nullable Number number) {
        this.rotation = number;
        return this;
    }

    public final void setAlign(@Nullable String str) {
        this.align = str;
    }

    public final void setAutoRotation(@Nullable Object obj) {
        this.autoRotation = obj;
    }

    public final void setAutoRotationLimit(@Nullable Number number) {
        this.autoRotationLimit = number;
    }

    public final void setDistance(@Nullable Number number) {
        this.distance = number;
    }

    public final void setEnabled(@Nullable Boolean bool) {
        this.enabled = bool;
    }

    public final void setFormat(@Nullable String str) {
        this.format = str;
    }

    public final void setFormatter(@Nullable String str) {
        this.formatter = str;
    }

    public final void setPadding(@Nullable Number number) {
        this.padding = number;
    }

    public final void setRotation(@Nullable Number number) {
        this.rotation = number;
    }

    public final void setStaggerLines(@Nullable Integer num) {
        this.staggerLines = num;
    }

    public final void setStep(@Nullable Integer num) {
        this.step = num;
    }

    public final void setStyle(@Nullable AAStyle aAStyle) {
        this.style = aAStyle;
    }

    public final void setUseHTML(@Nullable Boolean bool) {
        this.useHTML = bool;
    }

    public final void setX(@Nullable Number number) {
        this.f32547x = number;
    }

    public final void setY(@Nullable Number number) {
        this.f32548y = number;
    }

    @NotNull
    public final AALabels staggerLines(@Nullable Integer num) {
        this.staggerLines = num;
        return this;
    }

    @NotNull
    public final AALabels step(@Nullable Integer num) {
        this.step = num;
        return this;
    }

    @NotNull
    public final AALabels style(@NotNull AAStyle prop) {
        g0.p(prop, "prop");
        this.style = prop;
        return this;
    }

    @NotNull
    public final AALabels useHTML(@Nullable Boolean bool) {
        this.useHTML = bool;
        return this;
    }

    @NotNull
    public final AALabels x(@Nullable Number number) {
        this.f32547x = number;
        return this;
    }

    @NotNull
    public final AALabels y(@Nullable Number number) {
        this.f32548y = number;
        return this;
    }
}
