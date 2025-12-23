package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import com.github.aachartmodel.aainfographics.aatools.AAJSStringPurer;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class AATooltip {

    @Nullable
    private Object backgroundColor;

    @Nullable
    private String borderColor;

    @Nullable
    private Number borderRadius;

    @Nullable
    private Number borderWidth;

    @Nullable
    private AADateTimeLabelFormats dateTimeLabelFormats;

    @Nullable
    private Boolean enabled;

    @Nullable
    private Boolean followTouchMove;

    @Nullable
    private String footerFormat;

    @Nullable
    private String formatter;

    @Nullable
    private String headerFormat;

    @Nullable
    private Number padding;

    @Nullable
    private String pointFormat;

    @Nullable
    private String pointFormatter;

    @Nullable
    private String positioner;

    @Nullable
    private Boolean shadow;

    @Nullable
    private String shape;

    @Nullable
    private Boolean shared;

    @Nullable
    private AAStyle style;

    @Nullable
    private Boolean useHTML;

    @Nullable
    private Integer valueDecimals;

    @Nullable
    private String valueSuffix;

    @NotNull
    public final AATooltip backgroundColor(@NotNull Object prop) {
        g0.p(prop, "prop");
        this.backgroundColor = prop;
        return this;
    }

    @NotNull
    public final AATooltip borderColor(@NotNull String prop) {
        g0.p(prop, "prop");
        this.borderColor = prop;
        return this;
    }

    @NotNull
    public final AATooltip borderRadius(@Nullable Number number) {
        this.borderRadius = number;
        return this;
    }

    @NotNull
    public final AATooltip borderWidth(@Nullable Number number) {
        this.borderWidth = number;
        return this;
    }

    @NotNull
    public final AATooltip dateTimeLabelFormats(@NotNull AADateTimeLabelFormats prop) {
        g0.p(prop, "prop");
        this.dateTimeLabelFormats = prop;
        return this;
    }

    @NotNull
    public final AATooltip enabled(@Nullable Boolean bool) {
        this.enabled = bool;
        return this;
    }

    @NotNull
    public final AATooltip footerFormat(@NotNull String prop) {
        g0.p(prop, "prop");
        this.footerFormat = prop;
        return this;
    }

    @NotNull
    public final AATooltip formatter(@NotNull String prop) {
        g0.p(prop, "prop");
        this.formatter = AAJSStringPurer.INSTANCE.pureAnonymousJSFunctionString(prop);
        return this;
    }

    @Nullable
    public final Object getBackgroundColor() {
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
    public final AADateTimeLabelFormats getDateTimeLabelFormats() {
        return this.dateTimeLabelFormats;
    }

    @Nullable
    public final Boolean getEnabled() {
        return this.enabled;
    }

    @Nullable
    public final Boolean getFollowTouchMove() {
        return this.followTouchMove;
    }

    @Nullable
    public final String getFooterFormat() {
        return this.footerFormat;
    }

    @Nullable
    public final String getFormatter() {
        return this.formatter;
    }

    @Nullable
    public final String getHeaderFormat() {
        return this.headerFormat;
    }

    @Nullable
    public final Number getPadding() {
        return this.padding;
    }

    @Nullable
    public final String getPointFormat() {
        return this.pointFormat;
    }

    @Nullable
    public final String getPointFormatter() {
        return this.pointFormatter;
    }

    @Nullable
    public final String getPositioner() {
        return this.positioner;
    }

    @Nullable
    public final Boolean getShadow() {
        return this.shadow;
    }

    @Nullable
    public final String getShape() {
        return this.shape;
    }

    @Nullable
    public final Boolean getShared() {
        return this.shared;
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
    public final Integer getValueDecimals() {
        return this.valueDecimals;
    }

    @Nullable
    public final String getValueSuffix() {
        return this.valueSuffix;
    }

    @NotNull
    public final AATooltip headerFormat(@NotNull String prop) {
        g0.p(prop, "prop");
        this.headerFormat = prop;
        return this;
    }

    @NotNull
    public final AATooltip padding(@NotNull Number prop) {
        g0.p(prop, "prop");
        this.padding = prop;
        return this;
    }

    @NotNull
    public final AATooltip pointFormat(@NotNull String prop) {
        g0.p(prop, "prop");
        this.pointFormat = prop;
        return this;
    }

    @NotNull
    public final AATooltip pointFormatter(@NotNull String prop) {
        g0.p(prop, "prop");
        this.pointFormatter = AAJSStringPurer.INSTANCE.pureAnonymousJSFunctionString(prop);
        return this;
    }

    @NotNull
    public final AATooltip positioner(@NotNull String prop) {
        g0.p(prop, "prop");
        this.positioner = AAJSStringPurer.INSTANCE.pureAnonymousJSFunctionString(prop);
        return this;
    }

    public final void setBackgroundColor(@Nullable Object obj) {
        this.backgroundColor = obj;
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

    public final void setDateTimeLabelFormats(@Nullable AADateTimeLabelFormats aADateTimeLabelFormats) {
        this.dateTimeLabelFormats = aADateTimeLabelFormats;
    }

    public final void setEnabled(@Nullable Boolean bool) {
        this.enabled = bool;
    }

    public final void setFollowTouchMove(@Nullable Boolean bool) {
        this.followTouchMove = bool;
    }

    public final void setFooterFormat(@Nullable String str) {
        this.footerFormat = str;
    }

    public final void setFormatter(@Nullable String str) {
        this.formatter = str;
    }

    public final void setHeaderFormat(@Nullable String str) {
        this.headerFormat = str;
    }

    public final void setPadding(@Nullable Number number) {
        this.padding = number;
    }

    public final void setPointFormat(@Nullable String str) {
        this.pointFormat = str;
    }

    public final void setPointFormatter(@Nullable String str) {
        this.pointFormatter = str;
    }

    public final void setPositioner(@Nullable String str) {
        this.positioner = str;
    }

    public final void setShadow(@Nullable Boolean bool) {
        this.shadow = bool;
    }

    public final void setShape(@Nullable String str) {
        this.shape = str;
    }

    public final void setShared(@Nullable Boolean bool) {
        this.shared = bool;
    }

    public final void setStyle(@Nullable AAStyle aAStyle) {
        this.style = aAStyle;
    }

    public final void setUseHTML(@Nullable Boolean bool) {
        this.useHTML = bool;
    }

    public final void setValueDecimals(@Nullable Integer num) {
        this.valueDecimals = num;
    }

    public final void setValueSuffix(@Nullable String str) {
        this.valueSuffix = str;
    }

    @NotNull
    public final AATooltip shape(@NotNull String prop) {
        g0.p(prop, "prop");
        this.shape = prop;
        return this;
    }

    @NotNull
    public final AATooltip shared(@Nullable Boolean bool) {
        this.shared = bool;
        return this;
    }

    @NotNull
    public final AATooltip style(@NotNull AAStyle prop) {
        g0.p(prop, "prop");
        this.style = prop;
        return this;
    }

    @NotNull
    public final AATooltip useHTML(@Nullable Boolean bool) {
        this.useHTML = bool;
        return this;
    }

    @NotNull
    public final AATooltip valueDecimals(@Nullable Integer num) {
        this.valueDecimals = num;
        return this;
    }

    @NotNull
    public final AATooltip valueSuffix(@Nullable String str) {
        this.valueSuffix = str;
        return this;
    }

    public AATooltip() {
        Boolean bool = Boolean.TRUE;
        this.shared = bool;
        this.enabled = bool;
        this.shadow = bool;
    }

    @NotNull
    public final AATooltip followTouchMove(boolean z5) {
        this.followTouchMove = Boolean.valueOf(z5);
        return this;
    }

    @NotNull
    public final AATooltip shadow(boolean z5) {
        this.shadow = Boolean.valueOf(z5);
        return this;
    }
}
