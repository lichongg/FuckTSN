package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import com.github.aachartmodel.aainfographics.aachartcreator.AAChartAnimationType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class AAAnimation {

    @Nullable
    private Integer duration;

    @Nullable
    private String easing;

    @NotNull
    public final AAAnimation duration(@Nullable Integer num) {
        this.duration = num;
        return this;
    }

    @NotNull
    public final AAAnimation easing(@Nullable AAChartAnimationType aAChartAnimationType) {
        this.easing = aAChartAnimationType != null ? aAChartAnimationType.getValue() : null;
        return this;
    }

    @Nullable
    public final Integer getDuration() {
        return this.duration;
    }

    @Nullable
    public final String getEasing() {
        return this.easing;
    }

    public final void setDuration(@Nullable Integer num) {
        this.duration = num;
    }

    public final void setEasing(@Nullable String str) {
        this.easing = str;
    }
}
