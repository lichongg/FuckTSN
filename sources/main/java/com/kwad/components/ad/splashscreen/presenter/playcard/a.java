package com.kwad.components.ad.splashscreen.presenter.playcard;

import android.os.SystemClock;
import android.text.TextUtils;
import com.kwad.components.ad.splashscreen.h;
import com.kwad.components.ad.splashscreen.presenter.e;
import com.kwad.components.ad.splashscreen.presenter.j;
import com.kwad.components.core.webview.tachikoma.f.g;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a extends e {
    private com.kwad.components.core.o.a.e.b IH;
    private long II;
    private volatile boolean IJ = false;
    private g mq = new g() { // from class: com.kwad.components.ad.splashscreen.presenter.playcard.a.1
        @Override // com.kwad.components.core.webview.tachikoma.f.g
        public final void a(String str, long j6, long j7, long j8) {
            if (TextUtils.isEmpty(str) || !str.equals(com.kwad.sdk.core.response.b.b.dK(a.this.Gf.mAdTemplate))) {
                return;
            }
            com.kwad.components.ad.splashscreen.monitor.b.lZ();
            com.kwad.components.ad.splashscreen.monitor.b.a(a.this.Gf.mAdTemplate, a.this.Gf.Fr, a.this.Gf.FA, a.this.Gf.FC, a.this.Gf.FB, a.this.Gf.FD, j6, j7, j8, SystemClock.elapsedRealtime() - a.this.II);
            a.this.Gf.FE = j6;
            a.this.Gf.FF = j7;
            a.this.Gf.FG = j8;
            bw.c(a.this.IK);
        }

        @Override // com.kwad.components.core.webview.tachikoma.f.b
        public final void v(String str) {
            a.this.Gf.bO = true;
            if ("tk_splash".equals(str)) {
                a.this.aV();
            }
        }
    };
    private final Runnable IK = new Runnable() { // from class: com.kwad.components.ad.splashscreen.presenter.playcard.a.2
        @Override // java.lang.Runnable
        public final void run() {
            if (!a.this.IJ) {
                a.this.mZ();
                return;
            }
            a.this.Gf.bO = true;
            a.this.aV();
            com.kwad.components.ad.splashscreen.monitor.b.lZ();
            com.kwad.components.ad.splashscreen.monitor.b.c(a.this.Gf.mAdTemplate, a.this.Gf.Fr);
        }
    };
    private com.kwad.components.core.o.a.e.a IL = new com.kwad.components.core.o.a.e.a() { // from class: com.kwad.components.ad.splashscreen.presenter.playcard.a.3
        @Override // com.kwad.components.core.o.a.e.a
        public final void a(int i6, int i7, long j6, long j7) {
            a.this.Gf.FA = i6;
            a.this.Gf.FB = i7;
            a.this.Gf.FC = j6;
            a.this.Gf.FD = j7;
            com.kwad.components.ad.splashscreen.monitor.b.lZ();
            com.kwad.components.ad.splashscreen.monitor.b.g(a.this.Gf.mAdTemplate, SystemClock.elapsedRealtime() - a.this.II);
            a.this.mZ();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void aV() {
        h hVar = this.Gf;
        if (hVar.Fy) {
            return;
        }
        hVar.Fy = true;
        hVar.Fx = true;
        bw.postOnUiThread(new bg() { // from class: com.kwad.components.ad.splashscreen.presenter.playcard.a.5
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                a.this.a(new j(), true);
            }
        });
    }

    private void mY() {
        com.kwad.components.core.o.a.e.b bVar = (com.kwad.components.core.o.a.e.b) com.kwad.sdk.components.d.f(com.kwad.components.core.o.a.e.b.class);
        this.IH = bVar;
        if (bVar != null) {
            bVar.a(this.IL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mZ() {
        if (this.IJ) {
            return;
        }
        this.IJ = true;
        bw.postOnUiThread(new bg() { // from class: com.kwad.components.ad.splashscreen.presenter.playcard.a.4
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                a.this.a(new com.kwad.components.ad.splashscreen.presenter.a.a(), true);
            }
        });
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        this.II = SystemClock.elapsedRealtime();
        com.kwad.components.ad.splashscreen.monitor.b.lZ();
        h hVar = this.Gf;
        com.kwad.components.ad.splashscreen.monitor.b.a(hVar.mAdTemplate, hVar.Fr);
        h hVar2 = this.Gf;
        hVar2.Fz = this.II;
        bw.runOnUiThreadDelay(this.IK, com.kwad.sdk.core.response.b.b.dw(hVar2.mAdTemplate));
        com.kwad.components.core.webview.tachikoma.e.c.vO().a(this.mq);
        mY();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.core.o.a.e.b bVar = this.IH;
        if (bVar != null) {
            bVar.b(this.IL);
        }
        bw.c(this.IK);
        com.kwad.components.core.webview.tachikoma.e.c.vO().b(this.mq);
    }
}
