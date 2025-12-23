package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class AAPosition {

    @Nullable
    private String align;

    @Nullable
    private String verticalAlign;

    /* renamed from: x, reason: collision with root package name */
    @Nullable
    private Number f32551x;

    /* renamed from: y, reason: collision with root package name */
    @Nullable
    private Number f32552y;

    @NotNull
    public final AAPosition align(@Nullable String str) {
        this.align = str;
        return this;
    }

    @NotNull
    public final AAPosition align(@Nullable Number number) {
        this.f32551x = number;
        return this;
    }

    @Nullable
    public final String getAlign() {
        return this.align;
    }

    @Nullable
    public final String getVerticalAlign() {
        return this.verticalAlign;
    }

    @Nullable
    public final Number getX() {
        return this.f32551x;
    }

    @Nullable
    public final Number getY() {
        return this.f32552y;
    }

    public final void setAlign(@Nullable String str) {
        this.align = str;
    }

    public final void setVerticalAlign(@Nullable String str) {
        this.verticalAlign = str;
    }

    public final void setX(@Nullable Number number) {
        this.f32551x = number;
    }

    public final void setY(@Nullable Number number) {
        this.f32552y = number;
    }

    @NotNull
    public final AAPosition verticalAlign(@Nullable String str) {
        this.verticalAlign = str;
        return this;
    }

    @NotNull
    public final AAPosition y(@Nullable Number number) {
        this.f32552y = number;
        return this;
    }
}
