package com.amap.api.col.s;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.amap.api.col.s.dz;
import com.amap.api.maps.AMapException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class z2 extends u2 {

    /* renamed from: h, reason: collision with root package name */
    private static z2 f8782h;

    /* renamed from: g, reason: collision with root package name */
    private Handler f8783g;

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

    private static synchronized z2 m() {
        synchronized (z2.class) {
            try {
                if (f8782h == null) {
                    f8782h = new z2();
                }
            } finally {
                return f8782h;
            }
        }
        return f8782h;
    }

    private z2() {
        try {
            if (Looper.myLooper() == null) {
                this.f8783g = new a(Looper.getMainLooper(), (byte) 0);
            } else {
                this.f8783g = new a();
            }
        } catch (Throwable th) {
            g2.o(th, "NetManger", "NetManger1");
            th.printStackTrace();
        }
    }

    private static b3 e(dz dzVar, dz.b bVar, int i6) throws bv {
        try {
            u2.k(dzVar);
            dzVar.f(bVar);
            dzVar.l(i6);
            return new x2().d(dzVar);
        } catch (bv e6) {
            throw e6;
        } catch (Throwable th) {
            th.printStackTrace();
            throw new bv(AMapException.ERROR_UNKNOWN);
        }
    }

    @Deprecated
    private static b3 j(dz dzVar, boolean z5) throws bv {
        dz.c cVar;
        byte[] bArr;
        u2.k(dzVar);
        if (z5) {
            cVar = dz.c.HTTPS;
        } else {
            cVar = dz.c.HTTP;
        }
        dzVar.g(cVar);
        b3 b3Var = null;
        long j6 = 0;
        boolean z6 = false;
        if (u2.g(dzVar)) {
            boolean i6 = u2.i(dzVar);
            try {
                j6 = SystemClock.elapsedRealtime();
                b3Var = e(dzVar, u2.c(dzVar, i6), u2.h(dzVar, i6));
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
        return e(dzVar, u2.f(dzVar, z6), u2.a(dzVar, j6));
    }

    public static z2 l() {
        return m();
    }

    public static b3 n(dz dzVar) throws bv {
        return j(dzVar, dzVar.z());
    }
}
