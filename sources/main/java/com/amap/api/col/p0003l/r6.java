package com.amap.api.col.p0003l;

import android.os.SystemClock;
import android.text.TextUtils;
import com.amap.api.col.p0003l.Cif;
import com.amap.api.maps.AMapException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class r6 {

    /* renamed from: a, reason: collision with root package name */
    public static int f7183a = 0;

    /* renamed from: b, reason: collision with root package name */
    public static String f7184b = "";

    /* renamed from: c, reason: collision with root package name */
    public static HashMap<String, String> f7185c;

    /* renamed from: d, reason: collision with root package name */
    public static HashMap<String, String> f7186d;

    /* renamed from: e, reason: collision with root package name */
    public static HashMap<String, String> f7187e;

    /* renamed from: f, reason: collision with root package name */
    private static r6 f7188f;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        URLConnection a();
    }

    public static r6 b() {
        if (f7188f == null) {
            f7188f = new r6();
        }
        return f7188f;
    }

    protected static void k(Cif cif) throws fk {
        if (cif == null) {
            throw new fk("requeust is null");
        }
        if (cif.getURL() == null || "".equals(cif.getURL())) {
            throw new fk("request url is empty");
        }
    }

    public r6() {
        g4.O();
    }

    protected static int a(Cif cif, long j6) {
        try {
            k(cif);
            long j7 = 0;
            if (j6 != 0) {
                j7 = SystemClock.elapsedRealtime() - j6;
            }
            int conntectionTimeout = cif.getConntectionTimeout();
            if (cif.getDegradeAbility() != Cif.a.FIX && cif.getDegradeAbility() != Cif.a.SINGLE) {
                long j8 = conntectionTimeout;
                if (j7 < j8) {
                    long j9 = j8 - j7;
                    if (j9 >= 1000) {
                        return (int) j9;
                    }
                }
                return Math.min(1000, cif.getConntectionTimeout());
            }
            return conntectionTimeout;
        } catch (Throwable unused) {
            return 5000;
        }
    }

    protected static Cif.b c(Cif cif, boolean z5) {
        if (cif.getDegradeAbility() == Cif.a.FIX) {
            return Cif.b.FIX_NONDEGRADE;
        }
        if (cif.getDegradeAbility() == Cif.a.SINGLE) {
            return Cif.b.NEVER_GRADE;
        }
        if (z5) {
            return Cif.b.FIRST_NONDEGRADE;
        }
        return Cif.b.NEVER_GRADE;
    }

    public static z6 d(Cif cif) throws fk {
        return j(cif, cif.isHttps());
    }

    private static z6 e(Cif cif, Cif.b bVar, int i6) throws fk {
        try {
            k(cif);
            cif.setDegradeType(bVar);
            cif.setReal_max_timeout(i6);
            return new w6().x(cif);
        } catch (fk e6) {
            throw e6;
        } catch (Throwable th) {
            th.printStackTrace();
            throw new fk(AMapException.ERROR_UNKNOWN);
        }
    }

    protected static Cif.b f(Cif cif, boolean z5) {
        if (cif.getDegradeAbility() == Cif.a.FIX) {
            if (z5) {
                return Cif.b.FIX_DEGRADE_BYERROR;
            }
            return Cif.b.FIX_DEGRADE_ONLY;
        }
        if (z5) {
            return Cif.b.DEGRADE_BYERROR;
        }
        return Cif.b.DEGRADE_ONLY;
    }

    protected static boolean g(Cif cif) throws fk {
        k(cif);
        try {
            String ipv6url = cif.getIPV6URL();
            if (TextUtils.isEmpty(ipv6url)) {
                return false;
            }
            String host = new URL(ipv6url).getHost();
            if (!TextUtils.isEmpty(cif.getIPDNSName())) {
                host = cif.getIPDNSName();
            }
            return g4.U(host);
        } catch (Throwable unused) {
            return true;
        }
    }

    protected static int h(Cif cif, boolean z5) {
        try {
            k(cif);
            int conntectionTimeout = cif.getConntectionTimeout();
            int i6 = g4.f6305s;
            if (cif.getDegradeAbility() != Cif.a.FIX) {
                if (cif.getDegradeAbility() != Cif.a.SINGLE && conntectionTimeout >= i6 && z5) {
                    return i6;
                }
            }
            return conntectionTimeout;
        } catch (Throwable unused) {
            return 5000;
        }
    }

    protected static boolean i(Cif cif) throws fk {
        k(cif);
        if (!g(cif)) {
            return true;
        }
        if (cif.getURL().equals(cif.getIPV6URL()) || cif.getDegradeAbility() == Cif.a.SINGLE) {
            return false;
        }
        if (g4.f6309w) {
            return true;
        }
        return false;
    }

    @Deprecated
    private static z6 j(Cif cif, boolean z5) throws fk {
        Cif.c cVar;
        byte[] bArr;
        k(cif);
        if (z5) {
            cVar = Cif.c.HTTPS;
        } else {
            cVar = Cif.c.HTTP;
        }
        cif.setHttpProtocol(cVar);
        z6 z6Var = null;
        long j6 = 0;
        boolean z6 = false;
        if (g(cif)) {
            boolean i6 = i(cif);
            try {
                j6 = SystemClock.elapsedRealtime();
                z6Var = e(cif, c(cif, i6), h(cif, i6));
            } catch (fk e6) {
                if (e6.f() == 21 && cif.getDegradeAbility() == Cif.a.INTERRUPT_IO) {
                    throw e6;
                }
                if (i6) {
                    z6 = true;
                } else {
                    throw e6;
                }
            }
        }
        if (z6Var != null && (bArr = z6Var.f7800a) != null && bArr.length > 0) {
            return z6Var;
        }
        return e(cif, f(cif, z6), a(cif, j6));
    }
}
