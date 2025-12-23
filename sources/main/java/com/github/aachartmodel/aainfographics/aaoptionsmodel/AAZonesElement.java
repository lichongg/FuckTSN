package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class AAZonesElement {

    @Nullable
    private Object color;

    @Nullable
    private String dashStyle;

    @Nullable
    private Object fillColor;

    @Nullable
    private Number value;

    @NotNull
    public final AAZonesElement color(@Nullable Object obj) {
        this.color = obj;
        return this;
    }

    @NotNull
    public final AAZonesElement dashStyle(@Nullable String str) {
        this.dashStyle = str;
        return this;
    }

    @NotNull
    public final AAZonesElement fillColor(@Nullable Object obj) {
        this.fillColor = obj;
        return this;
    }

    @Nullable
    public final Object getColor() {
        return this.color;
    }

    @Nullable
    public final String getDashStyle() {
        return this.dashStyle;
    }

    @Nullable
    public final Object getFillColor() {
        return this.fillColor;
    }

    @Nullable
    public final Number getValue() {
        return this.value;
    }

    public final void setColor(@Nullable Object obj) {
        this.color = obj;
    }

    public final void setDashStyle(@Nullable String str) {
        this.dashStyle = str;
    }

    public final void setFillColor(@Nullable Object obj) {
        this.fillColor = obj;
    }

    public final void setValue(@Nullable Number number) {
        this.value = number;
    }

    @NotNull
    public final AAZonesElement value(@Nullable Number number) {
        this.value = number;
        return this;
    }
}
