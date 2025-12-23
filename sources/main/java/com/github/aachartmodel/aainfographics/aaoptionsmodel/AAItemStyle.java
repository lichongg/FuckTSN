package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import com.github.aachartmodel.aainfographics.aachartcreator.AAChartFontWeightType;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class AAItemStyle {

    @Nullable
    private String color;

    @Nullable
    private String cursor;

    @Nullable
    private String fontSize;

    @Nullable
    private String fontWeight;

    @Nullable
    private String pointer;

    @NotNull
    public final AAItemStyle color(@Nullable String str) {
        this.color = str;
        return this;
    }

    @NotNull
    public final AAItemStyle cursor(@NotNull String prop) {
        g0.p(prop, "prop");
        this.cursor = prop;
        return this;
    }

    @NotNull
    public final AAItemStyle fontSize(@Nullable Number number) {
        if (number != null) {
            this.fontSize = number + "px";
        }
        return this;
    }

    @NotNull
    public final AAItemStyle fontWeight(@Nullable AAChartFontWeightType aAChartFontWeightType) {
        this.fontWeight = aAChartFontWeightType != null ? aAChartFontWeightType.getValue() : null;
        return this;
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
    public final String getFontSize() {
        return this.fontSize;
    }

    @Nullable
    public final String getFontWeight() {
        return this.fontWeight;
    }

    @Nullable
    public final String getPointer() {
        return this.pointer;
    }

    @NotNull
    public final AAItemStyle pointer(@NotNull String prop) {
        g0.p(prop, "prop");
        this.pointer = prop;
        return this;
    }

    public final void setColor(@Nullable String str) {
        this.color = str;
    }

    public final void setCursor(@Nullable String str) {
        this.cursor = str;
    }

    public final void setFontSize(@Nullable String str) {
        this.fontSize = str;
    }

    public final void setFontWeight(@Nullable String str) {
        this.fontWeight = str;
    }

    public final void setPointer(@Nullable String str) {
        this.pointer = str;
    }
}
