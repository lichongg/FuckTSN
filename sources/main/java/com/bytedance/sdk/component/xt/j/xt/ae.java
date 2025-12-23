package com.bytedance.sdk.component.xt.j.xt;

/* loaded from: D:\Downloads\app\classes4.dex */
final class ae {

    /* renamed from: j, reason: collision with root package name */
    static m f27320j;
    static long xt;

    static m j() {
        synchronized (ae.class) {
            try {
                m mVar = f27320j;
                if (mVar == null) {
                    return new m();
                }
                f27320j = mVar.f27323m;
                mVar.f27323m = null;
                xt -= 8192;
                return mVar;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private ae() {
    }

    static void j(m mVar) {
        if (mVar.f27323m == null && mVar.ae == null) {
            if (mVar.f27324r) {
                return;
            }
            synchronized (ae.class) {
                try {
                    long j6 = xt;
                    if (j6 + 8192 > 65536) {
                        return;
                    }
                    xt = j6 + 8192;
                    mVar.f27323m = f27320j;
                    mVar.cw = 0;
                    mVar.xt = 0;
                    f27320j = mVar;
                    return;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        throw new IllegalArgumentException();
    }
}
