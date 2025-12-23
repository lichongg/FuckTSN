package com.bxkj.base.v2.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nDataFormatUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DataFormatUtils.kt\ncom/bxkj/base/v2/common/utils/DataFormatUtils\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,29:1\n1#2:30\n*E\n"})
/* loaded from: D:\Downloads\app\classes3.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f16894a = new g();

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static SimpleDateFormat f16895b = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @JvmStatic
    @NotNull
    public static final String a(@Nullable Object obj) {
        try {
            String format = f16895b.format(new Date(Long.parseLong(String.valueOf(obj))));
            kotlin.jvm.internal.g0.m(format);
            return format;
        } catch (Exception unused) {
            return "";
        }
    }

    @JvmStatic
    @NotNull
    public static final String b(long j6) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss", Locale.CHINA);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        String format = simpleDateFormat.format(new Date(j6 * 1000));
        kotlin.jvm.internal.g0.o(format, "format(...)");
        return format;
    }

    private g() {
    }
}
