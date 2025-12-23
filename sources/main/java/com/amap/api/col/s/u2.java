package com.amap.api.col.s;

import android.os.SystemClock;
import android.text.TextUtils;
import com.amap.api.col.s.dz;
import com.amap.api.maps.AMapException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class u2 {

    /* renamed from: a, reason: collision with root package name */
    public static int f8507a = 0;

    /* renamed from: b, reason: collision with root package name */
    public static String f8508b = "";

    /* renamed from: c, reason: collision with root package name */
    public static HashMap<String, String> f8509c;

    /* renamed from: d, reason: collision with root package name */
    public static HashMap<String, String> f8510d;

    /* renamed from: e, reason: collision with root package name */
    public static HashMap<String, String> f8511e;

    /* renamed from: f, reason: collision with root package name */
    private static u2 f8512f;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        URLConnection a();
    }

    public static u2 b() {
        if (f8512f == null) {
            f8512f = new u2();
        }
        return f8512f;
    }

    protected static void k(dz dzVar) throws bv {
        if (dzVar == null) {
            throw new bv("requeust is null");
        }
        if (dzVar.h() == null || "".equals(dzVar.h())) {
            throw new bv("request url is empty");
        }
    }

    public u2() {
        y0.I();
    }

    protected static int a(dz dzVar, long j6) {
        try {
            k(dzVar);
            long j7 = 0;
            if (j6 != 0) {
                j7 = SystemClock.elapsedRealtime() - j6;
            }
            int u5 = dzVar.u();
            if (dzVar.w() != dz.a.FIX && dzVar.w() != dz.a.SINGLE) {
                long j8 = u5;
                if (j7 < j8) {
                    long j9 = j8 - j7;
                    if (j9 >= 1000) {
                        return (int) j9;
                    }
                }
                return Math.min(1000, dzVar.u());
            }
            return u5;
        } catch (Throwable unused) {
            return 5000;
        }
    }

    protected static dz.b c(dz dzVar, boolean z5) {
        if (dzVar.w() == dz.a.FIX) {
            return dz.b.FIX_NONDEGRADE;
        }
        if (dzVar.w() == dz.a.SINGLE) {
            return dz.b.NEVER_GRADE;
        }
        if (z5) {
            return dz.b.FIRST_NONDEGRADE;
        }
        return dz.b.NEVER_GRADE;
    }

    public static b3 d(dz dzVar) throws bv {
        return j(dzVar, dzVar.z());
    }

    private static b3 e(dz dzVar, dz.b bVar, int i6) throws bv {
        try {
            k(dzVar);
            dzVar.f(bVar);
            dzVar.l(i6);
            return new x2().o(dzVar);
        } catch (bv e6) {
            throw e6;
        } catch (Throwable th) {
            th.printStackTrace();
            throw new bv(AMapException.ERROR_UNKNOWN);
        }
    }

    protected static dz.b f(dz dzVar, boolean z5) {
        if (dzVar.w() == dz.a.FIX) {
            if (z5) {
                return dz.b.FIX_DEGRADE_BYERROR;
            }
            return dz.b.FIX_DEGRADE_ONLY;
        }
        if (z5) {
            return dz.b.DEGRADE_BYERROR;
        }
        return dz.b.DEGRADE_ONLY;
    }

    protected static boolean g(dz dzVar) throws bv {
        k(dzVar);
        try {
            String a6 = dzVar.a();
            if (TextUtils.isEmpty(a6)) {
                return false;
            }
            String host = new URL(a6).getHost();
            if (!TextUtils.isEmpty(dzVar.r())) {
                host = dzVar.r();
            }
            return y0.R(host);
        } catch (Throwable unused) {
            return true;
        }
    }

    protected static int h(dz dzVar, boolean z5) {
        try {
            k(dzVar);
            int u5 = dzVar.u();
            int i6 = y0.f8725s;
            if (dzVar.w() != dz.a.FIX) {
                if (dzVar.w() != dz.a.SINGLE && u5 >= i6 && z5) {
                    return i6;
                }
            }
            return u5;
        } catch (Throwable unused) {
            return 5000;
        }
    }

    protected static boolean i(dz dzVar) throws bv {
        k(dzVar);
        if (!g(dzVar)) {
            return true;
        }
        if (dzVar.h().equals(dzVar.a()) || dzVar.w() == dz.a.SINGLE) {
            return false;
        }
        if (y0.f8729w) {
            return true;
        }
        return false;
    }

    @Deprecated
    private static b3 j(dz dzVar, boolean z5) throws bv {
        dz.c cVar;
        byte[] bArr;
        k(dzVar);
        if (z5) {
            cVar = dz.c.HTTPS;
        } else {
            cVar = dz.c.HTTP;
        }
        dzVar.g(cVar);
        b3 b3Var = null;
        long j6 = 0;
        boolean z6 = false;
        if (g(dzVar)) {
            boolean i6 = i(dzVar);
            try {
                j6 = SystemClock.elapsedRealtime();
                b3Var = e(dzVar, c(dzVar, i6), h(dzVar, i6));
            } catch (bv e6) {
                if (e6.f() == 21 && dzVar.w() == dz.a.INTERRUPT_IO) {
                    throw e6;
                }
                if (i6) {
                    z6 = true;
                } else {
                    throw e6;
                }
            }
        }
        if (b3Var != null && (bArr = b3Var.f7876a) != null && bArr.length > 0) {
            return b3Var;
        }
        return e(dzVar, f(dzVar, z6), a(dzVar, j6));
    }
}
