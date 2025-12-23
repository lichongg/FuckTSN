package com.bxkj.base.v2.common.ext;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.t0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class g {
    @NotNull
    public static final String a(long j6) {
        long j7 = 1024;
        long j8 = j7 * 1024;
        long j9 = j7 * j8;
        if (j6 >= j9) {
            t0 t0Var = t0.f44062a;
            String format = String.format("%.1f GB", Arrays.copyOf(new Object[]{Float.valueOf(j6 / j9)}, 1));
            g0.o(format, "format(...)");
            return format;
        }
        if (j6 >= j8) {
            float f6 = j6 / j8;
            t0 t0Var2 = t0.f44062a;
            String format2 = String.format(f6 > 100.0f ? "%.0f MB" : "%.1f MB", Arrays.copyOf(new Object[]{Float.valueOf(f6)}, 1));
            g0.o(format2, "format(...)");
            return format2;
        }
        if (j6 < 1024) {
            t0 t0Var3 = t0.f44062a;
            String format3 = String.format("%d B", Arrays.copyOf(new Object[]{Long.valueOf(j6)}, 1));
            g0.o(format3, "format(...)");
            return format3;
        }
        float f7 = j6 / 1024;
        t0 t0Var4 = t0.f44062a;
        String format4 = String.format(f7 > 100.0f ? "%.0f KB" : "%.1f KB", Arrays.copyOf(new Object[]{Float.valueOf(f7)}, 1));
        g0.o(format4, "format(...)");
        return format4;
    }

    @NotNull
    public static final String b(long j6) {
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(Long.valueOf(j6));
        g0.o(format, "format(...)");
        return format;
    }

    @NotNull
    public static final String c(long j6) {
        if (j6 < 1000) {
            return j6 + "ms";
        }
        if (j6 < 60000) {
            return ((j6 % 60000) / 1000) + "s";
        }
        return ((j6 % 3600000) / 60000) + "min";
    }

    @NotNull
    public static final String d(long j6) {
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(Long.valueOf(j6));
        g0.o(format, "format(...)");
        return format;
    }

    public static final boolean e(long j6) {
        if (System.currentTimeMillis() - j6 < 3600000) {
            return true;
        }
        return false;
    }

    public static final boolean f(long j6) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j6);
        Calendar calendar2 = Calendar.getInstance();
        if (calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6)) {
            return true;
        }
        return false;
    }
}
