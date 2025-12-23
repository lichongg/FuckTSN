package com.bytedance.sdk.component.tl.xt.xt.cw;

import android.os.HandlerThread;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r extends HandlerThread {

    /* renamed from: j, reason: collision with root package name */
    private up f26827j;

    public r() {
        super("csj_openlog");
    }

    public void j(up upVar) {
        this.f26827j = upVar;
    }

    @Override // android.os.HandlerThread
    protected void onLooperPrepared() {
        super.onLooperPrepared();
        up upVar = this.f26827j;
        if (upVar != null) {
            upVar.cw();
        }
    }
}
