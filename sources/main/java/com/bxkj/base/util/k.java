package com.bxkj.base.util;

import android.os.Build;
import android.text.TextUtils;
import com.acse.ottn.l3;
import java.lang.reflect.Method;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final k f16630a = new k();

    private final String c(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            Method declaredMethod = cls.getDeclaredMethod(l3.f4736f, String.class);
            g0.o(declaredMethod, "getDeclaredMethod(...)");
            Object invoke = declaredMethod.invoke(cls, str);
            g0.n(invoke, "null cannot be cast to non-null type kotlin.String");
            String str3 = (String) invoke;
            return TextUtils.isEmpty(str3) ? str2 : str3;
        } catch (Throwable th) {
            th.printStackTrace();
            return str2;
        }
    }

    @Nullable
    public final String a() {
        return Build.DISPLAY;
    }

    @Nullable
    public final String b() {
        return c("hw_sc.build.platform.version", "");
    }

    public final boolean d() {
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            return kotlin.text.u.a2("Harmony", cls.getMethod("getOsBrand", null).invoke(cls, null).toString(), true);
        } catch (Throwable unused) {
            return false;
        }
    }

    private k() {
    }
}
