package com.bytedance.sdk.component.xt.j.xt;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class up implements Runnable {
    protected final String xt;

    protected abstract void xt();

    public up(String str, Object... objArr) {
        this.xt = oq.j(str, objArr);
    }

    @Override // java.lang.Runnable
    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName("csj_" + this.xt);
        try {
            xt();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
