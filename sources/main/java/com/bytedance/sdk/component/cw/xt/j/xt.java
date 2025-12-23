package com.bytedance.sdk.component.cw.xt.j;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class xt implements Runnable {
    protected final String xt;

    protected abstract void cw();

    public xt(String str, Object... objArr) {
        this.xt = cw.j(str, objArr);
    }

    @Override // java.lang.Runnable
    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName("csj_" + this.xt);
        try {
            cw();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
