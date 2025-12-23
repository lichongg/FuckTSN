package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import com.acse.ottn.l3;
import java.io.IOException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class bq {
    public static String get(String str) {
        Object b6 = b(l3.f4736f, new Class[]{String.class}, str);
        return b6 instanceof String ? (String) b6 : hq(str);
    }

    public static boolean getBoolean(String str, boolean z5) {
        Object b6 = b("getBoolean", new Class[]{String.class, Boolean.TYPE}, str, Boolean.valueOf(z5));
        return b6 instanceof Boolean ? ((Boolean) b6).booleanValue() : ((Boolean) a(str, Boolean.valueOf(z5), new com.kwad.sdk.g.b<String, Boolean>() { // from class: com.kwad.sdk.utils.bq.4
            @Override // com.kwad.sdk.g.b
            public final /* synthetic */ Boolean apply(String str2) {
                return hu(str2);
            }

            private static Boolean hu(String str2) {
                return Boolean.valueOf(Boolean.parseBoolean(str2));
            }
        })).booleanValue();
    }

    public static int getInt(String str, int i6) {
        Object b6 = b("getInt", new Class[]{String.class, Integer.TYPE}, str, Integer.valueOf(i6));
        return b6 instanceof Integer ? ((Integer) b6).intValue() : ((Integer) a(str, Integer.valueOf(i6), new com.kwad.sdk.g.b<String, Integer>() { // from class: com.kwad.sdk.utils.bq.2
            @Override // com.kwad.sdk.g.b
            public final /* synthetic */ Integer apply(String str2) {
                return hs(str2);
            }

            private static Integer hs(String str2) {
                return Integer.valueOf(Integer.parseInt(str2));
            }
        })).intValue();
    }

    public static long getLong(String str, long j6) {
        Object b6 = b("getLong", new Class[]{String.class, Long.TYPE}, str, Long.valueOf(j6));
        return b6 instanceof Long ? ((Long) b6).longValue() : ((Long) a(str, Long.valueOf(j6), new com.kwad.sdk.g.b<String, Long>() { // from class: com.kwad.sdk.utils.bq.3
            @Override // com.kwad.sdk.g.b
            public final /* synthetic */ Long apply(String str2) {
                return ht(str2);
            }

            private static Long ht(String str2) {
                return Long.valueOf(Long.parseLong(str2));
            }
        })).longValue();
    }

    @SuppressLint({"PrivateApi"})
    private static Object b(String str, Class[] clsArr, Object... objArr) {
        try {
            return z.a("android.os.SystemProperties", str, clsArr, objArr);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTrace(th);
            return null;
        }
    }

    private static <T> T a(String str, T t5, com.kwad.sdk.g.b<String, T> bVar) {
        String hq = hq(str);
        if (hq == null) {
            return t5;
        }
        try {
            return bVar.apply(hq);
        } catch (Throwable unused) {
            return t5;
        }
    }

    private static String hq(String str) {
        try {
            return com.kwad.sdk.crash.utils.h.c(Runtime.getRuntime().exec("getprop " + str).getInputStream());
        } catch (IOException e6) {
            com.kwad.sdk.core.d.c.printStackTrace(e6);
            return null;
        }
    }

    public static String get(String str, String str2) {
        Object b6 = b(l3.f4736f, new Class[]{String.class, String.class}, str, str2);
        if (b6 instanceof String) {
            return (String) b6;
        }
        return (String) a(str, str2, new com.kwad.sdk.g.b<String, String>() { // from class: com.kwad.sdk.utils.bq.1
            @Override // com.kwad.sdk.g.b
            public final /* synthetic */ String apply(String str3) {
                return hr(str3);
            }

            private static String hr(String str3) {
                return str3;
            }
        });
    }
}
