package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class AAInactive {

    @Nullable
    private Boolean enabled;

    @Nullable
    private Number opacity;

    @NotNull
    public final AAInactive enabled(@Nullable Boolean bool) {
        this.enabled = bool;
        return this;
    }

    @Nullable
    public final Boolean getEnabled() {
        return this.enabled;
    }

    @Nullable
    public final Number getOpacity() {
        return this.opacity;
    }

    @NotNull
    public final AAInactive opacity(@Nullable Number number) {
        this.opacity = number;
        return this;
    }

    public final void setEnabled(@Nullable Boolean bool) {
        this.enabled = bool;
    }

    public final void setOpacity(@Nullable Number number) {
        this.opacity = number;
    }
}
