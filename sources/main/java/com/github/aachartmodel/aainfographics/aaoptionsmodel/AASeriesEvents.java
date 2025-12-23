package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import com.github.aachartmodel.aainfographics.aatools.AAJSStringPurer;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class AASeriesEvents {

    @Nullable
    private String legendItemClick;

    @Nullable
    public final String getLegendItemClick() {
        return this.legendItemClick;
    }

    @NotNull
    public final AASeriesEvents legendItemClick(@NotNull String prop) {
        g0.p(prop, "prop");
        this.legendItemClick = AAJSStringPurer.INSTANCE.pureAnonymousJSFunctionString(prop);
        return this;
    }

    public final void setLegendItemClick(@Nullable String str) {
        this.legendItemClick = str;
    }
}
