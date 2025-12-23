package com.kwad.components.ad.h.a.a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bw;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b implements com.kwad.sdk.core.webview.c.a {
    public static int qo = 1;
    public static int qp = 2;
    private com.kwad.sdk.core.webview.c.c qn;
    private int qq;
    private int qr;
    private InterfaceC0561b qt;
    private c qs = new c(this, 0);

    @Nullable
    private Runnable qu = null;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KsJson
    public static class a extends com.kwad.sdk.core.response.a.a {
        public int qw;
        public int qx;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.kwad.components.ad.h.a.a.b$b, reason: collision with other inner class name */
    public interface InterfaceC0561b {
        void Q(int i6);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c implements Runnable {
        private boolean qy;
        private int qz;

        private c() {
            this.qy = false;
            this.qz = -1;
        }

        public final void X(int i6) {
            this.qz = i6;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.kwad.sdk.core.d.c.d("RegisterTimer", "TimerRunnable run timerPaused:  " + this.qy + ", currentTime: " + this.qz);
            if (this.qy) {
                bw.a(this, null, 1000L);
                return;
            }
            int i6 = this.qz;
            if (i6 < 0) {
                return;
            }
            b.this.W(i6);
            this.qz--;
            bw.a(this, null, 1000L);
        }

        public final void z(boolean z5) {
            this.qy = z5;
        }

        /* synthetic */ c(b bVar, byte b6) {
            this();
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.qn = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(int i6) {
        com.kwad.sdk.core.d.c.d("RegisterTimer", "updateTimer: " + i6 + ", mCallBackFunction: " + this.qn);
        if (i6 >= 0 && this.qn != null) {
            InterfaceC0561b interfaceC0561b = this.qt;
            if (interfaceC0561b != null && i6 == 0) {
                interfaceC0561b.Q(this.qq);
            }
            a aVar = new a();
            aVar.qx = i6;
            aVar.qw = this.qq;
            com.kwad.sdk.core.webview.c.c cVar = this.qn;
            if (cVar != null) {
                cVar.a(aVar);
            }
        }
    }

    public final void a(InterfaceC0561b interfaceC0561b) {
        this.qt = interfaceC0561b;
    }

    public final void au() {
        com.kwad.sdk.core.d.c.d("RegisterTimer", "startTimer: mCallBackFunction: " + this.qn);
        if (this.qn == null) {
            this.qu = new Runnable() { // from class: com.kwad.components.ad.h.a.a.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.au();
                }
            };
        } else {
            this.qs.X(this.qr);
            bw.runOnUiThread(this.qs);
        }
    }

    public final void fP() {
        this.qs.z(true);
    }

    public final void fQ() {
        this.qs.z(false);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerTimerListener";
    }

    private b(int i6, int i7) {
        this.qq = i6;
        this.qr = i7;
    }

    @Nullable
    public static b I(AdTemplate adTemplate) {
        AdInfo el = e.el(adTemplate);
        if (com.kwad.sdk.core.response.b.a.bc(el)) {
            return null;
        }
        if (com.kwad.sdk.core.response.b.a.bK(el)) {
            return new b(qp, f(el));
        }
        int i6 = el.adInsertScreenInfo.autoCloseTime;
        if (i6 <= 0) {
            return null;
        }
        return new b(qo, i6);
    }

    private static int f(AdInfo adInfo) {
        int b6 = com.kwad.components.ad.interstitial.b.b.b(adInfo);
        if (b6 <= 0) {
            b6 = 60;
        }
        int i6 = adInfo.adInsertScreenInfo.autoCloseTime;
        if (i6 > 0) {
            return Math.min(b6, i6);
        }
        return b6;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.qn = cVar;
        Runnable runnable = this.qu;
        if (runnable != null) {
            runnable.run();
            this.qu = null;
        }
    }
}
