package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class AAScrollablePlotArea {

    @Nullable
    private Number minHeight;

    @Nullable
    private Number minWidth;

    @Nullable
    private Float opacity;

    @Nullable
    private Number scrollPositionX;

    @Nullable
    private Number scrollPositionY;

    @Nullable
    public final Number getMinHeight() {
        return this.minHeight;
    }

    @Nullable
    public final Number getMinWidth() {
        return this.minWidth;
    }

    @Nullable
    public final Float getOpacity() {
        return this.opacity;
    }

    @Nullable
    public final Number getScrollPositionX() {
        return this.scrollPositionX;
    }

    @Nullable
    public final Number getScrollPositionY() {
        return this.scrollPositionY;
    }

    @NotNull
    public final AAScrollablePlotArea minHeight(@Nullable Number number) {
        this.minHeight = number;
        return this;
    }

    @NotNull
    public final AAScrollablePlotArea minWidth(@Nullable Number number) {
        this.minWidth = number;
        return this;
    }

    @NotNull
    public final AAScrollablePlotArea opacity(@Nullable Float f6) {
        this.opacity = f6;
        return this;
    }

    @NotNull
    public final AAScrollablePlotArea scrollPositionX(@Nullable Number number) {
        this.scrollPositionX = number;
        return this;
    }

    @NotNull
    public final AAScrollablePlotArea scrollPositionY(@Nullable Number number) {
        this.scrollPositionY = number;
        return this;
    }

    public final void setMinHeight(@Nullable Number number) {
        this.minHeight = number;
    }

    public final void setMinWidth(@Nullable Number number) {
        this.minWidth = number;
    }

    public final void setOpacity(@Nullable Float f6) {
        this.opacity = f6;
    }

    public final void setScrollPositionX(@Nullable Number number) {
        this.scrollPositionX = number;
    }

    public final void setScrollPositionY(@Nullable Number number) {
        this.scrollPositionY = number;
    }
}
