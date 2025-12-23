package com.bxkj.base.v2.common.utils;

import java.text.NumberFormat;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class e0 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e0 f16888a = new e0();

    @JvmStatic
    @NotNull
    public static final String a(@Nullable Object obj) {
        if (obj == null) {
            return "";
        }
        if (!(obj instanceof Double)) {
            return obj.toString();
        }
        NumberFormat integerInstance = NumberFormat.getIntegerInstance();
        kotlin.jvm.internal.g0.n(obj, "null cannot be cast to non-null type kotlin.Double");
        String format = integerInstance.format(((Double) obj).doubleValue());
        kotlin.jvm.internal.g0.m(format);
        return format;
    }

    private e0() {
    }
}
