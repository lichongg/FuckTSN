package com.amap.api.col.p0003l;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.amap.api.col.p0003l.Cif;
import com.amap.api.col.p0003l.z7;
import com.amap.api.maps.AMapException;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class y6 extends r6 {

    /* renamed from: i, reason: collision with root package name */
    private static y6 f7769i;

    /* renamed from: g, reason: collision with root package name */
    private a8 f7770g;

    /* renamed from: h, reason: collision with root package name */
    private Handler f7771h;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a extends Handler {
        /* synthetic */ a(Looper looper, byte b6) {
            this(looper);
        }

        private a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            try {
                int i6 = message.what;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        public a() {
        }
    }

    public static y6 n() {
        return l(true);
    }

    public static y6 p() {
        return l(false);
    }

    private static synchronized y6 l(boolean z5) {
        synchronized (y6.class) {
            try {
                y6 y6Var = f7769i;
                if (y6Var == null) {
                    f7769i = new y6(z5);
                } else if (z5 && y6Var.f7770g == null) {
                    y6Var.f7770g = a8.i(new z7.b().c("amap-netmanger-threadpool-%d").h());
                }
            } finally {
                return f7769i;
            }
        }
        return f7769i;
    }

    private y6(boolean z5) {
        if (z5) {
            try {
                this.f7770g = a8.i(new z7.b().c("amap-netmanger-threadpool-%d").h());
            } catch (Throwable th) {
                v5.p(th, "NetManger", "NetManger1");
                th.printStackTrace();
                return;
            }
        }
        if (Looper.myLooper() == null) {
            this.f7771h = new a(Looper.getMainLooper(), (byte) 0);
        } else {
            this.f7771h = new a();
        }
    }

    private static Map<String, String> m(Cif cif, Cif.b bVar, int i6) throws fk {
        try {
            r6.k(cif);
            cif.setDegradeType(bVar);
            cif.setReal_max_timeout(i6);
            return new w6().j(cif);
        } catch (fk e6) {
            throw e6;
        } catch (Throwable th) {
            th.printStackTrace();
            throw new fk(AMapException.ERROR_UNKNOWN);
        }
    }

    private static z6 o(Cif cif, Cif.b bVar, int i6) throws fk {
        try {
            r6.k(cif);
            cif.setDegradeType(bVar);
            cif.setReal_max_timeout(i6);
            return new w6().q(cif);
        } catch (fk e6) {
            throw e6;
        } catch (Throwable th) {
            th.printStackTrace();
            throw new fk(AMapException.ERROR_UNKNOWN);
        }
    }

    @Deprecated
    public static Map<String, String> q(Cif cif, boolean z5) throws fk {
        Cif.c cVar;
        r6.k(cif);
        if (z5) {
            cVar = Cif.c.HTTPS;
        } else {
            cVar = Cif.c.HTTP;
        }
        cif.setHttpProtocol(cVar);
        Map<String, String> map = null;
        long j6 = 0;
        boolean z6 = false;
        if (r6.g(cif)) {
            boolean i6 = r6.i(cif);
            try {
                j6 = SystemClock.elapsedRealtime();
                map = m(cif, r6.c(cif, i6), r6.h(cif, i6));
            } catch (fk e6) {
                if (i6) {
                    z6 = true;
                } else {
                    throw e6;
                }
            }
        }
        if (map == null) {
            return m(cif, r6.f(cif, z6), r6.a(cif, j6));
        }
        return map;
    }

    public static z6 r(Cif cif) throws fk {
        return s(cif, cif.isHttps());
    }

    @Deprecated
    private static z6 s(Cif cif, boolean z5) throws fk {
        Cif.c cVar;
        byte[] bArr;
        r6.k(cif);
        if (z5) {
            cVar = Cif.c.HTTPS;
        } else {
            cVar = Cif.c.HTTP;
        }
        cif.setHttpProtocol(cVar);
        z6 z6Var = null;
        long j6 = 0;
        boolean z6 = false;
        if (r6.g(cif)) {
            boolean i6 = r6.i(cif);
            try {
                j6 = SystemClock.elapsedRealtime();
                z6Var = o(cif, r6.c(cif, i6), r6.h(cif, i6));
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
        return o(cif, r6.f(cif, z6), r6.a(cif, j6));
    }
}
