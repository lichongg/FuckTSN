package com.bxkj.base.v2.common.utils;

import android.content.Context;
import android.util.Pair;
import com.baidu.liantian.ac.LH;
import com.baidu.mobads.sdk.internal.by;
import com.tencent.bugly.crashreport.CrashReport;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nAndroidDevice.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AndroidDevice.kt\ncom/bxkj/base/v2/common/utils/AndroidDevice\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,86:1\n1#2:87\n*E\n"})
/* loaded from: D:\Downloads\app\classes3.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f16889a = new f();

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static String f16890b = "";

    private final String c(Context context) {
        String str;
        if (kotlin.jvm.internal.g0.g("", f16890b)) {
            try {
                LH.init(context, false);
                Pair<String, String> id = LH.getId(context, "1");
                if (id != null && (str = (String) id.second) != null) {
                    Locale locale = Locale.getDefault();
                    kotlin.jvm.internal.g0.o(locale, "getDefault(...)");
                    String upperCase = str.toUpperCase(locale);
                    kotlin.jvm.internal.g0.o(upperCase, "toUpperCase(...)");
                    if (upperCase != null) {
                        f16890b = upperCase;
                    }
                }
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }
        return f16890b;
    }

    private final String e(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(by.f10823a);
            Charset forName = Charset.forName("UTF-8");
            kotlin.jvm.internal.g0.o(forName, "forName(...)");
            byte[] bytes = str.getBytes(forName);
            kotlin.jvm.internal.g0.o(bytes, "getBytes(...)");
            byte[] digest = messageDigest.digest(bytes);
            kotlin.jvm.internal.g0.m(digest);
            return kotlin.collections.n.yh(digest, "", null, null, 0, null, new Function1() { // from class: com.bxkj.base.v2.common.utils.d
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    CharSequence f6;
                    f6 = f.f(((Byte) obj).byteValue());
                    return f6;
                }
            }, 30, null);
        } catch (Exception e6) {
            com.orhanobut.logger.j.e("MD5HashError：Error computing MD5 hash", e6);
            return null;
        }
    }

    private final String g(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            Charset forName = Charset.forName("UTF-8");
            kotlin.jvm.internal.g0.m(forName);
            byte[] bytes = str.getBytes(forName);
            kotlin.jvm.internal.g0.o(bytes, "getBytes(...)");
            byte[] digest = messageDigest.digest(bytes);
            kotlin.jvm.internal.g0.m(digest);
            return kotlin.collections.n.yh(digest, "", null, null, 0, null, new Function1() { // from class: com.bxkj.base.v2.common.utils.e
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    CharSequence h6;
                    h6 = f.h(((Byte) obj).byteValue());
                    return h6;
                }
            }, 30, null);
        } catch (Exception e6) {
            com.orhanobut.logger.j.e("Error computing SHA-256 hash", e6);
            throw new RuntimeException("Error computing SHA-256 hash", e6);
        }
    }

    @NotNull
    public final String d(@NotNull Context context) {
        kotlin.jvm.internal.g0.p(context, "context");
        if (kotlin.jvm.internal.g0.g("", f16890b)) {
            try {
                String e6 = e(f0.a(context) + c(context));
                if (e6 != null) {
                    f16890b = e6;
                }
            } catch (Exception e7) {
                com.orhanobut.logger.j.c(e7.getMessage());
                CrashReport.postCatchedException(e7);
            }
        }
        return f16890b;
    }

    private f() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence f(byte b6) {
        String format = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b6)}, 1));
        kotlin.jvm.internal.g0.o(format, "format(...)");
        return format;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence h(byte b6) {
        String format = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b6)}, 1));
        kotlin.jvm.internal.g0.o(format, "format(...)");
        return format;
    }
}
