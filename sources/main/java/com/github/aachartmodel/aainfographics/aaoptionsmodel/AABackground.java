package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class AABackground {

    @Nullable
    private Object backgroundColor;

    @Nullable
    private String borderColor;

    @Nullable
    private Number borderWidth;

    @Nullable
    private String className;

    @Nullable
    private Number innerRadius;

    @Nullable
    private Number outerRadius;

    @Nullable
    private String shape;

    @NotNull
    public final AABackground backgroundColor(@Nullable Object obj) {
        this.backgroundColor = obj;
        return this;
    }

    @NotNull
    public final AABackground borderColor(@Nullable String str) {
        this.borderColor = str;
        return this;
    }

    @NotNull
    public final AABackground borderWidth(@Nullable Number number) {
        this.borderWidth = number;
        return this;
    }

    @NotNull
    public final AABackground className(@Nullable String str) {
        this.className = str;
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
    public final Number getBorderWidth() {
        return this.borderWidth;
    }

    @Nullable
    public final String getClassName() {
        return this.className;
    }

    @Nullable
    public final Number getInnerRadius() {
        return this.innerRadius;
    }

    @Nullable
    public final Number getOuterRadius() {
        return this.outerRadius;
    }

    @Nullable
    public final String getShape() {
        return this.shape;
    }

    @NotNull
    public final AABackground innerRadius(@Nullable Number number) {
        this.innerRadius = number;
        return this;
    }

    @NotNull
    public final AABackground outerRadius(@Nullable Number number) {
        this.outerRadius = number;
        return this;
    }

    public final void setBackgroundColor(@Nullable Object obj) {
        this.backgroundColor = obj;
    }

    public final void setBorderColor(@Nullable String str) {
        this.borderColor = str;
    }

    public final void setBorderWidth(@Nullable Number number) {
        this.borderWidth = number;
    }

    public final void setClassName(@Nullable String str) {
        this.className = str;
    }

    public final void setInnerRadius(@Nullable Number number) {
        this.innerRadius = number;
    }

    public final void setOuterRadius(@Nullable Number number) {
        this.outerRadius = number;
    }

    public final void setShape(@Nullable String str) {
        this.shape = str;
    }

    @NotNull
    public final AABackground shape(@Nullable String str) {
        this.shape = str;
        return this;
    }
}
