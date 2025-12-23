package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class AASelect {

    @Nullable
    private String borderColor;

    @Nullable
    private String color;

    @Nullable
    private AAHalo halo;

    @NotNull
    public final AASelect borderColor(@Nullable String str) {
        this.borderColor = str;
        return this;
    }

    @NotNull
    public final AASelect color(@Nullable String str) {
        this.color = str;
        return this;
    }

    @Nullable
    public final String getBorderColor() {
        return this.borderColor;
    }

    @Nullable
    public final String getColor() {
        return this.color;
    }

    @Nullable
    public final AAHalo getHalo() {
        return this.halo;
    }

    @NotNull
    public final AASelect halo(@Nullable AAHalo aAHalo) {
        this.halo = aAHalo;
        return this;
    }

    public final void setBorderColor(@Nullable String str) {
        this.borderColor = str;
    }

    public final void setColor(@Nullable String str) {
        this.color = str;
    }

    public final void setHalo(@Nullable AAHalo aAHalo) {
        this.halo = aAHalo;
    }
}
