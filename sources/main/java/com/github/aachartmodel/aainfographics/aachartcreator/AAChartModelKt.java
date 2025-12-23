package com.github.aachartmodel.aainfographics.aachartcreator;

import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class AAChartModelKt {
    @NotNull
    public static final AAOptions aa_toAAOptions(@NotNull AAChartModel aa_toAAOptions) {
        g0.p(aa_toAAOptions, "$this$aa_toAAOptions");
        return AAOptionsConstructor.INSTANCE.configureChartOptions(aa_toAAOptions);
    }
}
