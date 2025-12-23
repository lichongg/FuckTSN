package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class AAStates {

    @Nullable
    private AAHover hover;

    @Nullable
    private AAInactive inactive;

    @Nullable
    private AASelect select;

    @Nullable
    public final AAHover getHover() {
        return this.hover;
    }

    @Nullable
    public final AAInactive getInactive() {
        return this.inactive;
    }

    @Nullable
    public final AASelect getSelect() {
        return this.select;
    }

    @NotNull
    public final AAStates hover(@Nullable AAHover aAHover) {
        this.hover = aAHover;
        return this;
    }

    @NotNull
    public final AAStates inactive(@Nullable AAInactive aAInactive) {
        this.inactive = aAInactive;
        return this;
    }

    @NotNull
    public final AAStates select(@Nullable AASelect aASelect) {
        this.select = aASelect;
        return this;
    }

    public final void setHover(@Nullable AAHover aAHover) {
        this.hover = aAHover;
    }

    public final void setInactive(@Nullable AAInactive aAInactive) {
        this.inactive = aAInactive;
    }

    public final void setSelect(@Nullable AASelect aASelect) {
        this.select = aASelect;
    }
}
