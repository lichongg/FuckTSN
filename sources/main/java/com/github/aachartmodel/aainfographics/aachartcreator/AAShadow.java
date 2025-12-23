package com.github.aachartmodel.aainfographics.aachartcreator;

import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class AAShadow {
    private String color;
    private Number offsetX;
    private Number offsetY;
    private Float opacity;
    private Number width;

    @NotNull
    public final AAShadow color(@NotNull String prop) {
        g0.p(prop, "prop");
        this.color = prop;
        return this;
    }

    @NotNull
    public final AAShadow offsetX(@Nullable Number number) {
        this.offsetX = number;
        return this;
    }

    @NotNull
    public final AAShadow offsetY(@Nullable Number number) {
        this.offsetY = number;
        return this;
    }

    @NotNull
    public final AAShadow opacity(@Nullable Float f6) {
        this.opacity = f6;
        return this;
    }

    @NotNull
    public final AAShadow width(@Nullable Number number) {
        this.width = number;
        return this;
    }
}
