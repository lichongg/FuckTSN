package com.huawei.hms.hatool;

import android.util.Pair;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class g0 extends g1 {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f33576a;

        static {
            int[] iArr = new int[d0.values().length];
            f33576a = iArr;
            try {
                iArr[d0.SN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f33576a[d0.IMEI.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f33576a[d0.UDID.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static x f(List<f> list, String str, String str2, String str3, String str4) {
        j1.h("hmsSdk", "generate UploadData");
        x d6 = g1.d(str, str2);
        if (d6 == null) {
            return null;
        }
        d6.b(a(n0.f().b(), str, str2, str3));
        d6.c(b(str, str2));
        d6.d(c(str2, str, str4));
        d6.e(c.h(str, str2));
        d6.f(list);
        return d6;
    }

    protected static p a(String str, String str2, String str3, String str4) {
        p a6 = g1.a(str, str2, str3, str4);
        String c6 = c0.a().c(c.d(str2, str3));
        long currentTimeMillis = System.currentTimeMillis();
        String b6 = z1.d.b(y0.k() + c6 + currentTimeMillis);
        a6.f(String.valueOf(currentTimeMillis));
        a6.g(b6);
        return a6;
    }

    protected static l0 b(String str, String str2) {
        l0 b6 = g1.b(str, str2);
        b0 f6 = c0.a().f(str, str2);
        b6.g(c0.a().c(c.d(str, str2)));
        b6.f(c.p(str, str2));
        b6.c(c0.a().i(str, str2));
        int i6 = a.f33576a[f6.a().ordinal()];
        if (i6 != 1) {
            if (i6 != 2) {
                if (i6 != 3) {
                    return b6;
                }
                b6.e(f6.b());
                return b6;
            }
            b6.b(f6.b());
            return b6;
        }
        b6.d(f6.b());
        return b6;
    }

    protected static o1 c(String str, String str2, String str3) {
        o1 c6 = g1.c(str, str2, str3);
        Pair<String, String> h6 = c0.a().h(str2, str);
        c6.f((String) h6.first);
        c6.g((String) h6.second);
        c6.h(s0.g());
        c6.d(c0.a().g(str2, str));
        return c6;
    }

    public static Map<String, String> g(String str, String str2, String str3) {
        Map<String, String> e6 = g1.e(str, str3);
        Map<String, String> j6 = c.j(str, str2);
        if (j6 == null) {
            return e6;
        }
        e6.putAll(j6);
        return e6;
    }
}
