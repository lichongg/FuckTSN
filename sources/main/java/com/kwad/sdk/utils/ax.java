package com.kwad.sdk.utils;

import android.text.TextUtils;
import androidx.annotation.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class ax {
    public static void d(Object... objArr) {
        for (int i6 = 0; i6 < 2; i6++) {
            checkNotNull(objArr[i6]);
        }
    }

    public static void checkArgument(boolean z5, @Nullable Object obj) {
        if (z5) {
            return;
        }
        a(new IllegalArgumentException("Expression cannot be false " + obj));
    }

    public static <T> T checkNotNull(T t5) {
        return (T) g(t5, "");
    }

    public static <T> T g(T t5, @Nullable String str) {
        if (t5 == null) {
            a(new NullPointerException("Argument cannot be null " + str));
        }
        return t5;
    }

    public static String hh(String str) {
        return ax(str, "");
    }

    private static void a(RuntimeException runtimeException) {
        com.kwad.sdk.core.d.c.printStackTrace(runtimeException);
    }

    public static String ax(String str, @Nullable String str2) {
        if (TextUtils.isEmpty(str)) {
            a(new NullPointerException("Argument cannot be null " + str2));
        }
        return str;
    }
}
