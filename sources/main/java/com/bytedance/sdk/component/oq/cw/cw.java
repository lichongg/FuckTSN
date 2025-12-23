package com.bytedance.sdk.component.oq.cw;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw extends com.bytedance.sdk.component.oq.j.cw implements Runnable {

    /* renamed from: r, reason: collision with root package name */
    final Runnable f26613r;

    @Override // com.bytedance.sdk.component.oq.j.cw, java.lang.Runnable
    public void run() {
        this.f26613r.run();
    }

    public cw(Runnable runnable) {
        super(runnable);
        this.f26613r = runnable;
        xt(false);
        j(false);
    }
}
