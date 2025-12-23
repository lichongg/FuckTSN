package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class AAMarkerStates {

    @Nullable
    private AAMarkerHover hover;

    @Nullable
    public final AAMarkerHover getHover() {
        return this.hover;
    }

    @NotNull
    public final AAMarkerStates hover(@Nullable AAMarkerHover aAMarkerHover) {
        this.hover = aAMarkerHover;
        return this;
    }

    public final void setHover(@Nullable AAMarkerHover aAMarkerHover) {
        this.hover = aAMarkerHover;
    }
}
