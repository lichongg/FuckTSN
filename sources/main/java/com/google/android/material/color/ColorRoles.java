package com.google.android.material.color;

import androidx.annotation.ColorInt;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class ColorRoles {
    private final int accent;
    private final int accentContainer;
    private final int onAccent;
    private final int onAccentContainer;

    @ColorInt
    public int getAccent() {
        return this.accent;
    }

    @ColorInt
    public int getAccentContainer() {
        return this.accentContainer;
    }

    @ColorInt
    public int getOnAccent() {
        return this.onAccent;
    }

    @ColorInt
    public int getOnAccentContainer() {
        return this.onAccentContainer;
    }

    ColorRoles(@ColorInt int i6, @ColorInt int i7, @ColorInt int i8, @ColorInt int i9) {
        this.accent = i6;
        this.onAccent = i7;
        this.accentContainer = i8;
        this.onAccentContainer = i9;
    }
}
