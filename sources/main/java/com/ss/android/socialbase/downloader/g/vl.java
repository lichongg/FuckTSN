package com.ss.android.socialbase.downloader.g;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: D:\Downloads\app\classes6.dex */
public class vl {

    /* renamed from: j, reason: collision with root package name */
    private static final String f38820j = "vl";
    private int ae;
    private volatile boolean cw;

    /* renamed from: m, reason: collision with root package name */
    private final ArrayList<Object> f38821m;

    /* renamed from: r, reason: collision with root package name */
    private final AtomicReference<jy> f38822r;
    private AtomicReference<jy> up;
    private final r xt;

    private static class j {

        /* renamed from: j, reason: collision with root package name */
        public static final vl f38824j = new vl(null);
    }

    /* synthetic */ vl(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static vl j() {
        return j.f38824j;
    }

    public synchronized jy xt() {
        r rVar = this.xt;
        if (rVar == null) {
            return jy.UNKNOWN;
        }
        try {
            return j(rVar.j());
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.vl.j(th);
            return jy.UNKNOWN;
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.g.vl$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: j, reason: collision with root package name */
        static final /* synthetic */ int[] f38823j;

        static {
            int[] iArr = new int[jy.values().length];
            f38823j = iArr;
            try {
                iArr[jy.POOR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f38823j[jy.MODERATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f38823j[jy.GOOD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f38823j[jy.EXCELLENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private vl() {
        this.xt = new r(0.05d);
        this.cw = false;
        this.f38822r = new AtomicReference<>(jy.UNKNOWN);
        this.f38821m = new ArrayList<>();
    }

    private boolean cw() {
        double d6;
        if (this.xt == null) {
            return false;
        }
        try {
            int i6 = AnonymousClass1.f38823j[this.f38822r.get().ordinal()];
            double d7 = 150.0d;
            if (i6 == 1) {
                d6 = 0.0d;
            } else if (i6 == 2) {
                d6 = 150.0d;
                d7 = 550.0d;
            } else if (i6 == 3) {
                d6 = 550.0d;
                d7 = 2000.0d;
            } else {
                if (i6 != 4) {
                    return true;
                }
                d7 = 3.4028234663852886E38d;
                d6 = 2000.0d;
            }
            double j6 = this.xt.j();
            if (j6 > d7) {
                if (j6 > d7 * 1.25d) {
                    return true;
                }
            } else if (j6 < d6 * 0.8d) {
                return true;
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.vl.j(th);
        }
        return false;
    }

    private void r() {
        try {
            int size = this.f38821m.size();
            for (int i6 = 0; i6 < size; i6++) {
                this.f38821m.get(i6);
                this.f38822r.get();
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.vl.j(th);
        }
    }

    public synchronized void j(long j6, long j7) {
        double d6 = ((j6 * 1.0d) / j7) * 8.0d;
        if (j7 == 0 || d6 < 3.0d) {
            return;
        }
        try {
            this.xt.j(d6);
            jy xt = xt();
            if (!this.cw) {
                if (this.f38822r.get() != xt) {
                    this.cw = true;
                    this.up = new AtomicReference<>(xt);
                }
                return;
            }
            this.ae++;
            if (xt != this.up.get()) {
                this.cw = false;
                this.ae = 1;
            }
            if (this.ae >= 5.0d && cw()) {
                this.cw = false;
                this.ae = 1;
                this.f38822r.set(this.up.get());
                r();
            }
        } catch (Throwable unused) {
        }
    }

    private jy j(double d6) {
        if (d6 < 0.0d) {
            return jy.UNKNOWN;
        }
        if (d6 < 150.0d) {
            return jy.POOR;
        }
        if (d6 < 550.0d) {
            return jy.MODERATE;
        }
        if (d6 < 2000.0d) {
            return jy.GOOD;
        }
        return jy.EXCELLENT;
    }
}
