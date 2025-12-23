package com.bytedance.sdk.component.adexpress.xt;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.component.adexpress.xt.oq;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\Downloads\app\classes4.dex */
public class av implements oq {
    private tl cw;

    /* renamed from: j, reason: collision with root package name */
    private Context f26012j;

    /* renamed from: m, reason: collision with root package name */
    private AtomicBoolean f26013m = new AtomicBoolean(false);

    /* renamed from: r, reason: collision with root package name */
    private jy f26014r;
    private ScheduledFuture<?> up;
    private com.bytedance.sdk.component.adexpress.up.j xt;

    private class j implements Runnable {
        private int cw;

        /* renamed from: j, reason: collision with root package name */
        oq.j f26016j;

        public j(int i6, oq.j jVar) {
            this.cw = i6;
            this.f26016j = jVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.cw == 1) {
                av.this.xt.j(true);
                av.this.j(this.f26016j, 107, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cw() {
        try {
            ScheduledFuture<?> scheduledFuture = this.up;
            if (scheduledFuture == null || scheduledFuture.isCancelled()) {
                return;
            }
            this.up.cancel(false);
            this.up = null;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.vl.j(th);
        }
    }

    public com.bytedance.sdk.component.adexpress.up.j xt() {
        return this.xt;
    }

    public av(Context context, jy jyVar, com.bytedance.sdk.component.adexpress.up.j jVar, tl tlVar) {
        this.f26012j = context;
        this.f26014r = jyVar;
        this.cw = tlVar;
        this.xt = jVar;
        jVar.j(this.cw);
    }

    @Override // com.bytedance.sdk.component.adexpress.xt.oq
    public boolean j(final oq.j jVar) {
        int tl = this.f26014r.tl();
        if (tl < 0) {
            j(jVar, 107, "time is ".concat(String.valueOf(tl)));
        } else {
            this.up = com.bytedance.sdk.component.adexpress.r.up.j(new j(1, jVar), tl, TimeUnit.MILLISECONDS);
            this.xt.j(new ae() { // from class: com.bytedance.sdk.component.adexpress.xt.av.1
                @Override // com.bytedance.sdk.component.adexpress.xt.ae
                public void j(View view, ws wsVar) {
                    az xt;
                    av.this.cw();
                    if (jVar.cw() || (xt = jVar.xt()) == null) {
                        return;
                    }
                    xt.j(av.this.xt, wsVar);
                    jVar.j(true);
                }

                @Override // com.bytedance.sdk.component.adexpress.xt.ae
                public void j(int i6, String str) {
                    av.this.j(jVar, i6, str);
                }
            });
        }
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.xt.oq
    public void j() {
        this.xt.r();
        cw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(oq.j jVar, int i6, String str) {
        az xt;
        if (jVar.cw() || this.f26013m.get()) {
            return;
        }
        cw();
        this.f26014r.ae().j(i6, str);
        if (jVar.xt(this)) {
            jVar.j(this);
        } else {
            if (jVar.cw() || (xt = jVar.xt()) == null) {
                return;
            }
            jVar.j(true);
            xt.a_(i6);
        }
        this.f26013m.getAndSet(true);
    }
}
