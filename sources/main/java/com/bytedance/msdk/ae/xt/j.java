package com.bytedance.msdk.ae.xt;

import android.text.TextUtils;
import com.bytedance.msdk.j.up.cw;
import com.bytedance.msdk.tl.l;
import com.bytedance.sdk.component.utils.vl;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j {
    private static volatile j xt;

    /* renamed from: m, reason: collision with root package name */
    private String f24323m;

    /* renamed from: r, reason: collision with root package name */
    private long f24324r;
    private long up;

    /* renamed from: j, reason: collision with root package name */
    private final String f24322j = j.class.getSimpleName();
    private l cw = com.bytedance.msdk.ae.j.up();

    public static j j() {
        if (xt == null) {
            synchronized (j.class) {
                try {
                    if (xt == null) {
                        xt = new j();
                    }
                } finally {
                }
            }
        }
        return xt;
    }

    public synchronized void cw() {
        this.cw.j("discard_num", this.cw.xt("discard_num", 0) + 1);
    }

    public synchronized int r() {
        return this.cw.xt("discard_num", 0);
    }

    public synchronized void up() {
        this.cw.j("discard_num", 0);
    }

    public boolean qv() {
        return TextUtils.isEmpty(this.f24323m);
    }

    public long tl() {
        long j6 = this.up - this.f24324r;
        cw.xt(this.f24322j, "InitMethodDuration = ".concat(String.valueOf(j6)));
        return j6;
    }

    public boolean vl() {
        String str = this.f24323m;
        String str2 = com.bytedance.msdk.up.j.cw;
        boolean equals = TextUtils.equals(str, str2);
        cw.xt(this.f24322j, "canUploadInitDuration = " + equals + " 当sessionId = " + str2 + " 存储的sessionId = " + this.f24323m);
        return !equals;
    }

    public long xt() {
        try {
            long xt2 = this.cw.xt("first_install_time", -1L);
            if (xt2 == -1) {
                xt2 = com.bytedance.msdk.ae.j.j().xt("first_install_time", -1L);
                if (xt2 == -1) {
                    xt2 = System.currentTimeMillis();
                }
                this.cw.j("first_install_time", xt2);
            }
            return xt2;
        } catch (Throwable th) {
            vl.j(th);
            return 0L;
        }
    }

    private j() {
    }

    public void ae() {
        this.up = System.currentTimeMillis();
    }

    public long g() {
        long currentTimeMillis = System.currentTimeMillis() - this.f24324r;
        cw.xt(this.f24322j, "SplashRequestDuration = ".concat(String.valueOf(currentTimeMillis)));
        return currentTimeMillis;
    }

    public void m() {
        this.f24324r = System.currentTimeMillis();
    }

    public long oq() {
        long currentTimeMillis = System.currentTimeMillis() - this.f24324r;
        cw.xt(this.f24322j, "SplashFillDuration = ".concat(String.valueOf(currentTimeMillis)));
        return currentTimeMillis;
    }

    public void j(long j6) {
        try {
            if (this.cw.xt("first_install_time", -1L) == -1) {
                long xt2 = com.bytedance.msdk.ae.j.j().xt("first_install_time", -1L);
                if (xt2 != -1) {
                    j6 = xt2;
                }
                this.cw.j("first_install_time", j6);
            }
        } catch (Throwable th) {
            vl.j(th);
        }
    }

    public void j(String str) {
        this.f24323m = str;
    }
}
