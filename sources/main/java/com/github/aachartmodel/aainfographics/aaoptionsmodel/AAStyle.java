package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import com.github.aachartmodel.aainfographics.aachartcreator.AAChartFontWeightType;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class AAStyle {
    public static final Companion Companion = new Companion(null);

    @Nullable
    private String background;

    @Nullable
    private String backgroundColor;

    @Nullable
    private String border;

    @Nullable
    private String borderRadius;

    @Nullable
    private String color;

    @Nullable
    private String cursor;

    @Nullable
    private String fontFamily;

    @Nullable
    private String fontSize;

    @Nullable
    private String fontWeight;

    @Nullable
    private Number height;

    @Nullable
    private Number lineWidth;

    @Nullable
    private Number opacity;

    @Nullable
    private String padding;

    @Nullable
    private String pointerEvents;

    @Nullable
    private String position;

    @Nullable
    private String textAlign;

    @Nullable
    private String textDecoration;

    @Nullable
    private String textOutline;

    @Nullable
    private String textOverflow;

    /* renamed from: top, reason: collision with root package name */
    @Nullable
    private String f32553top;

    @Nullable
    private String transition;

    @Nullable
    private String whiteSpace;

    @Nullable
    private Number width;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final AAStyle style(@Nullable String str) {
            return style(str, null);
        }

        public /* synthetic */ Companion(v vVar) {
            this();
        }

        @NotNull
        public final AAStyle style(@Nullable String str, @Nullable Number number) {
            return style(str, number, null);
        }

        @NotNull
        public final AAStyle style(@Nullable String str, @Nullable Number number, @Nullable AAChartFontWeightType aAChartFontWeightType) {
            return style(str, number, aAChartFontWeightType, null);
        }

        @NotNull
        public final AAStyle style(@Nullable String str, @Nullable Number number, @Nullable AAChartFontWeightType aAChartFontWeightType, @Nullable String str2) {
            return new AAStyle().color(str).fontSize(number).fontWeight(aAChartFontWeightType).textOutline(str2);
        }
    }

    @NotNull
    public final AAStyle background(@Nullable String str) {
        this.background = str;
        return this;
    }

    @NotNull
    public final AAStyle backgroundColor(@Nullable String str) {
        this.backgroundColor = str;
        return this;
    }

    @NotNull
    public final AAStyle border(@Nullable String str) {
        this.border = str;
        return this;
    }

    @NotNull
    public final AAStyle borderRadius(@Nullable Number number) {
        if (number != null) {
            this.borderRadius = number + "px";
        }
        return this;
    }

    @NotNull
    public final AAStyle color(@Nullable String str) {
        this.color = str;
        return this;
    }

    @NotNull
    public final AAStyle cursor(@Nullable String str) {
        this.cursor = str;
        return this;
    }

    @NotNull
    public final AAStyle fontFamily(@Nullable String str) {
        this.fontFamily = str;
        return this;
    }

    @NotNull
    public final AAStyle fontSize(@Nullable Number number) {
        if (number != null) {
            this.fontSize = number + "px";
        }
        return this;
    }

    @NotNull
    public final AAStyle fontWeight(@Nullable AAChartFontWeightType aAChartFontWeightType) {
        this.fontWeight = aAChartFontWeightType != null ? aAChartFontWeightType.getValue() : null;
        return this;
    }

    @Nullable
    public final String getBackground() {
        return this.background;
    }

    @Nullable
    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    @Nullable
    public final String getBorder() {
        return this.border;
    }

    @Nullable
    public final String getBorderRadius() {
        return this.borderRadius;
    }

    @Nullable
    public final String getColor() {
        return this.color;
    }

    @Nullable
    public final String getCursor() {
        return this.cursor;
    }

    @Nullable
    public final String getFontFamily() {
        return this.fontFamily;
    }

    @Nullable
    public final String getFontSize() {
        return this.fontSize;
    }

    @Nullable
    public final String getFontWeight() {
        return this.fontWeight;
    }

    @Nullable
    public final Number getHeight() {
        return this.height;
    }

    @Nullable
    public final Number getLineWidth() {
        return this.lineWidth;
    }

    @Nullable
    public final Number getOpacity() {
        return this.opacity;
    }

    @Nullable
    public final String getPadding() {
        return this.padding;
    }

    @Nullable
    public final String getPointerEvents() {
        return this.pointerEvents;
    }

    @Nullable
    public final String getPosition() {
        return this.position;
    }

    @Nullable
    public final String getTextAlign() {
        return this.textAlign;
    }

    @Nullable
    public final String getTextDecoration() {
        return this.textDecoration;
    }

    @Nullable
    public final String getTextOutline() {
        return this.textOutline;
    }

    @Nullable
    public final String getTextOverflow() {
        return this.textOverflow;
    }

    @Nullable
    public final String getTop() {
        return this.f32553top;
    }

    @Nullable
    public final String getTransition() {
        return this.transition;
    }

    @Nullable
    public final String getWhiteSpace() {
        return this.whiteSpace;
    }

    @Nullable
    public final Number getWidth() {
        return this.width;
    }

    @NotNull
    public final AAStyle height(@Nullable Number number) {
        this.height = number;
        return this;
    }

    @NotNull
    public final AAStyle lineWidth(@Nullable Number number) {
        this.lineWidth = number;
        return this;
    }

    @NotNull
    public final AAStyle opacity(@Nullable Number number) {
        this.opacity = number;
        return this;
    }

    @NotNull
    public final AAStyle padding(@Nullable Number number) {
        if (number != null) {
            this.padding = number + "px";
        }
        return this;
    }

    @NotNull
    public final AAStyle pointerEvents(@Nullable String str) {
        this.pointerEvents = str;
        return this;
    }

    @NotNull
    public final AAStyle position(@Nullable String str) {
        this.position = str;
        return this;
    }

    public final void setBackground(@Nullable String str) {
        this.background = str;
    }

    public final void setBackgroundColor(@Nullable String str) {
        this.backgroundColor = str;
    }

    public final void setBorder(@Nullable String str) {
        this.border = str;
    }

    public final void setBorderRadius(@Nullable String str) {
        this.borderRadius = str;
    }

    public final void setColor(@Nullable String str) {
        this.color = str;
    }

    public final void setCursor(@Nullable String str) {
        this.cursor = str;
    }

    public final void setFontFamily(@Nullable String str) {
        this.fontFamily = str;
    }

    public final void setFontSize(@Nullable String str) {
        this.fontSize = str;
    }

    public final void setFontWeight(@Nullable String str) {
        this.fontWeight = str;
    }

    public final void setHeight(@Nullable Number number) {
        this.height = number;
    }

    public final void setLineWidth(@Nullable Number number) {
        this.lineWidth = number;
    }

    public final void setOpacity(@Nullable Number number) {
        this.opacity = number;
    }

    public final void setPadding(@Nullable String str) {
        this.padding = str;
    }

    public final void setPointerEvents(@Nullable String str) {
        this.pointerEvents = str;
    }

    public final void setPosition(@Nullable String str) {
        this.position = str;
    }

    public final void setTextAlign(@Nullable String str) {
        this.textAlign = str;
    }

    public final void setTextDecoration(@Nullable String str) {
        this.textDecoration = str;
    }

    public final void setTextOutline(@Nullable String str) {
        this.textOutline = str;
    }

    public final void setTextOverflow(@Nullable String str) {
        this.textOverflow = str;
    }

    public final void setTop(@Nullable String str) {
        this.f32553top = str;
    }

    public final void setTransition(@Nullable String str) {
        this.transition = str;
    }

    public final void setWhiteSpace(@Nullable String str) {
        this.whiteSpace = str;
    }

    public final void setWidth(@Nullable Number number) {
        this.width = number;
    }

    @NotNull
    public final AAStyle textAlign(@Nullable String str) {
        this.textAlign = str;
        return this;
    }

    @NotNull
    public final AAStyle textDecoration(@Nullable String str) {
        this.textDecoration = str;
        return this;
    }

    @NotNull
    public final AAStyle textOutline(@Nullable String str) {
        this.textOutline = str;
        return this;
    }

    @NotNull
    public final AAStyle textOverflow(@Nullable String str) {
        this.textOverflow = str;
        return this;
    }

    @NotNull
    public final AAStyle top(@Nullable String str) {
        this.f32553top = str;
        return this;
    }

    @NotNull
    public final AAStyle transition(@Nullable String str) {
        this.transition = str;
        return this;
    }

    @NotNull
    public final AAStyle whiteSpace(@Nullable String str) {
        this.whiteSpace = str;
        return this;
    }

    @NotNull
    public final AAStyle width(@Nullable Number number) {
        this.width = number;
        return this;
    }
}
