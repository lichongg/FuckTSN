package com.bytedance.sdk.component.j;

import com.bytedance.component.sdk.annotation.CallSuper;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class r<P, R> extends com.bytedance.sdk.component.j.xt<P, R> {
    private m cw;

    /* renamed from: j, reason: collision with root package name */
    private boolean f26501j = true;
    private j xt;

    interface j {
        void j(Object obj);

        void j(Throwable th);
    }

    public interface xt {
        r j();
    }

    protected final void cw() {
        j((Throwable) null);
    }

    @Override // com.bytedance.sdk.component.j.xt
    public /* bridge */ /* synthetic */ String j() {
        return super.j();
    }

    protected abstract void j(P p5, m mVar) throws Exception;

    protected abstract void r();

    @CallSuper
    protected void up() {
        this.f26501j = false;
        this.cw = null;
    }

    private boolean ae() {
        if (this.f26501j) {
            return true;
        }
        g.j(new IllegalStateException("Jsb async call already finished: " + j() + ", hashcode: " + hashCode()));
        return false;
    }

    protected final void j(R r5) {
        if (ae()) {
            this.xt.j(r5);
            up();
        }
    }

    void m() {
        r();
        up();
    }

    protected final void j(Throwable th) {
        if (ae()) {
            this.xt.j(th);
            up();
        }
    }

    void j(P p5, m mVar, j jVar) throws Exception {
        this.cw = mVar;
        this.xt = jVar;
        j(p5, mVar);
    }
}
