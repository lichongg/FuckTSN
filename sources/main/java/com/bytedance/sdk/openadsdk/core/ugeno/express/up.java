package com.bytedance.sdk.openadsdk.core.ugeno.express;

import android.content.Context;
import android.view.View;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.adsdk.ugeno.cw.tj;
import com.bytedance.sdk.component.adexpress.xt.az;
import com.bytedance.sdk.component.adexpress.xt.jy;
import com.bytedance.sdk.component.adexpress.xt.oq;
import com.bytedance.sdk.component.adexpress.xt.tl;
import com.bytedance.sdk.component.adexpress.xt.ws;
import com.bytedance.sdk.component.oq.ae;
import com.bytedance.sdk.component.utils.vl;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\Downloads\app\classes4.dex */
public class up implements oq {
    private jy cw;

    /* renamed from: j, reason: collision with root package name */
    private Context f30719j;

    /* renamed from: r, reason: collision with root package name */
    private ScheduledFuture<?> f30720r;
    private AtomicBoolean up = new AtomicBoolean(false);
    private r xt;

    private class j implements Runnable {
        private int cw;

        /* renamed from: j, reason: collision with root package name */
        oq.j f30722j;

        j(int i6, oq.j jVar) {
            this.cw = i6;
            this.f30722j = jVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.cw == 1) {
                up.this.xt.j(true);
                up.this.j(this.f30722j, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_START_TIME);
            }
        }
    }

    private void xt() {
        try {
            ScheduledFuture<?> scheduledFuture = this.f30720r;
            if (scheduledFuture == null || scheduledFuture.isCancelled()) {
                return;
            }
            this.f30720r.cancel(false);
            this.f30720r = null;
        } catch (Throwable th) {
            vl.j(th);
        }
    }

    public up(Context context, r rVar, tl tlVar, jy jyVar) {
        this.f30719j = context;
        this.xt = rVar;
        this.cw = jyVar;
        this.xt.j(tlVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.xt.oq
    public boolean j(final oq.j jVar) {
        int tl = this.cw.tl();
        if (tl < 0) {
            j(jVar, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_START_TIME);
        } else {
            this.f30720r = ae.r().schedule(new j(1, jVar), tl, TimeUnit.MILLISECONDS);
            this.xt.j(new com.bytedance.sdk.component.adexpress.xt.ae() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.express.up.1
                @Override // com.bytedance.sdk.component.adexpress.xt.ae
                public void j(View view, ws wsVar) {
                    if (jVar.cw()) {
                        return;
                    }
                    tj tjVar = new tj();
                    tjVar.j(0);
                    ((xt) up.this.cw).rn().j(tjVar);
                    up.this.cw.ae().jy();
                    az xt = jVar.xt();
                    if (xt == null) {
                        return;
                    }
                    xt.j(up.this.xt, wsVar);
                    jVar.j(true);
                }

                @Override // com.bytedance.sdk.component.adexpress.xt.ae
                public void j(int i6, String str) {
                    az xt;
                    tj tjVar = new tj();
                    tjVar.j(i6);
                    tjVar.j(str);
                    ((xt) up.this.cw).rn().j(tjVar);
                    if (jVar.xt(up.this)) {
                        jVar.j(up.this);
                    } else {
                        if (jVar.cw() || (xt = jVar.xt()) == null) {
                            return;
                        }
                        xt.a_(i6);
                    }
                }
            });
        }
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.xt.oq
    public void j() {
        r rVar = this.xt;
        if (rVar != null) {
            rVar.qv();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(oq.j jVar, int i6) {
        az xt;
        if (jVar.cw() || this.up.get()) {
            return;
        }
        xt();
        tj tjVar = new tj();
        tjVar.j(i6);
        ((xt) this.cw).rn().j(tjVar);
        if (jVar.xt(this)) {
            jVar.j(this);
        } else {
            if (jVar.cw() || (xt = jVar.xt()) == null) {
                return;
            }
            jVar.j(true);
            xt.a_(i6);
        }
        this.up.getAndSet(true);
    }
}
