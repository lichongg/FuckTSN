package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import com.github.aachartmodel.aainfographics.aachartcreator.AAChartAlignType;
import com.github.aachartmodel.aainfographics.aatools.AAJSStringPurer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class AALabel {

    @Nullable
    private String align;

    @Nullable
    private String format;

    @Nullable
    private String formatter;

    @Nullable
    private Number rotation;

    @Nullable
    private Object style;

    @Nullable
    private String text;

    @Nullable
    private String textAlign;

    @Nullable
    private Boolean useHTML;

    @Nullable
    private String verticalAlign;

    /* renamed from: x, reason: collision with root package name */
    @Nullable
    private Number f32545x;

    /* renamed from: y, reason: collision with root package name */
    @Nullable
    private Number f32546y;

    @NotNull
    public final AALabel align(@Nullable String str) {
        this.align = str;
        return this;
    }

    @NotNull
    public final AALabel format(@Nullable String str) {
        this.format = str;
        return this;
    }

    @NotNull
    public final AALabel formatter(@Nullable String str) {
        this.formatter = AAJSStringPurer.INSTANCE.pureAnonymousJSFunctionString(str);
        return this;
    }

    @Nullable
    public final String getAlign() {
        return this.align;
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
    public final Number getRotation() {
        return this.rotation;
    }

    @Nullable
    public final Object getStyle() {
        return this.style;
    }

    @Nullable
    public final String getText() {
        return this.text;
    }

    @Nullable
    public final String getTextAlign() {
        return this.textAlign;
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
        return this.f32545x;
    }

    @Nullable
    public final Number getY() {
        return this.f32546y;
    }

    @NotNull
    public final AALabel rotation(@Nullable Number number) {
        this.rotation = number;
        return this;
    }

    public final void setAlign(@Nullable String str) {
        this.align = str;
    }

    public final void setFormat(@Nullable String str) {
        this.format = str;
    }

    public final void setFormatter(@Nullable String str) {
        this.formatter = str;
    }

    public final void setRotation(@Nullable Number number) {
        this.rotation = number;
    }

    public final void setStyle(@Nullable Object obj) {
        this.style = obj;
    }

    public final void setText(@Nullable String str) {
        this.text = str;
    }

    public final void setTextAlign(@Nullable String str) {
        this.textAlign = str;
    }

    public final void setUseHTML(@Nullable Boolean bool) {
        this.useHTML = bool;
    }

    public final void setVerticalAlign(@Nullable String str) {
        this.verticalAlign = str;
    }

    public final void setX(@Nullable Number number) {
        this.f32545x = number;
    }

    public final void setY(@Nullable Number number) {
        this.f32546y = number;
    }

    @NotNull
    public final AALabel style(@Nullable Object obj) {
        this.style = obj;
        return this;
    }

    @NotNull
    public final AALabel text(@Nullable String str) {
        this.text = str;
        return this;
    }

    @NotNull
    public final AALabel textAlign(@Nullable AAChartAlignType aAChartAlignType) {
        this.textAlign = aAChartAlignType != null ? aAChartAlignType.getValue() : null;
        return this;
    }

    @NotNull
    public final AALabel useHTML(@Nullable Boolean bool) {
        this.useHTML = bool;
        return this;
    }

    @NotNull
    public final AALabel verticalAlign(@Nullable String str) {
        this.verticalAlign = str;
        return this;
    }

    @NotNull
    public final AALabel x(@Nullable Number number) {
        this.f32545x = number;
        return this;
    }

    @NotNull
    public final AALabel y(@Nullable Number number) {
        this.f32546y = number;
        return this;
    }
}
