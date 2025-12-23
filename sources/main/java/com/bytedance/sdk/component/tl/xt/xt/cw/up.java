package com.bytedance.sdk.component.tl.xt.xt.cw;

import android.os.Looper;

/* loaded from: D:\Downloads\app\classes4.dex */
public class up {
    protected final com.bytedance.sdk.component.tl.xt.xt.xt cw;

    /* renamed from: j, reason: collision with root package name */
    private volatile r f26828j;
    protected final com.bytedance.sdk.component.tl.j.up xt;

    public Looper ae() {
        com.bytedance.sdk.component.tl.j.r r5 = this.xt.r();
        return (r5 == null || r5.az() == null) ? up().getLooper() : r5.az();
    }

    public void m() {
        com.bytedance.sdk.component.tl.j.r r5 = this.xt.r();
        if (r5 != null && r5.az() != null) {
            cw();
            return;
        }
        r up = up();
        up.j(this);
        up.start();
    }

    public r up() {
        if (this.f26828j == null) {
            synchronized (this) {
                try {
                    if (this.f26828j == null) {
                        this.f26828j = new r();
                    }
                } finally {
                }
            }
        }
        return this.f26828j;
    }

    public up(com.bytedance.sdk.component.tl.j.up upVar, com.bytedance.sdk.component.tl.xt.xt.xt xtVar) {
        this.xt = upVar;
        this.cw = xtVar;
    }

    public void cw() {
    }
}
