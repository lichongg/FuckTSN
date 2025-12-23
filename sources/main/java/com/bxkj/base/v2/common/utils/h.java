package com.bxkj.base.v2.common.utils;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nDecimalFormatUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DecimalFormatUtils.kt\ncom/bxkj/base/v2/common/utils/DecimalFormatUtils\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,18:1\n1#2:19\n*E\n"})
/* loaded from: D:\Downloads\app\classes3.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final h f16899a = new h();

    @NotNull
    public final String a(double d6) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        decimalFormat.setRoundingMode(RoundingMode.FLOOR);
        String format = decimalFormat.format(d6);
        kotlin.jvm.internal.g0.o(format, "format(...)");
        return format;
    }

    @NotNull
    public final String b(double d6) {
        DecimalFormat decimalFormat = new DecimalFormat("0.000");
        decimalFormat.setRoundingMode(RoundingMode.FLOOR);
        String format = decimalFormat.format(d6);
        kotlin.jvm.internal.g0.o(format, "format(...)");
        return format;
    }

    private h() {
    }
}
