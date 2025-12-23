package com.kwad.components.ad.i;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.j.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ag;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class c implements Runnable {
    private static final Handler qI = new Handler(Looper.getMainLooper());
    private static volatile boolean qM;
    private final long qJ;
    private final AdTemplate qK;
    private boolean qL = false;

    @Nullable
    private d qN;

    static /* synthetic */ boolean access$002(boolean z5) {
        qM = false;
        return false;
    }

    private static void a(int i6, Runnable runnable, long j6) {
        Handler handler = qI;
        Message obtain = Message.obtain(handler, runnable);
        obtain.what = i6;
        handler.sendMessageDelayed(obtain, j6);
    }

    public final void fV() {
        com.kwad.sdk.core.d.c.w("PushAdManager", "startRequestPushAd processingPush: " + qM);
        if (qM || this.qK.mAdScene == null) {
            return;
        }
        qM = true;
        com.kwad.components.core.j.a.b(this.qK.mAdScene, new a.InterfaceC0621a() { // from class: com.kwad.components.ad.i.c.1
            @Override // com.kwad.components.core.j.a.InterfaceC0621a
            public final void e(@Nullable List<com.kwad.components.core.j.c> list) {
                com.kwad.sdk.core.d.c.d("PushAdManager", "onInnerAdLoad: " + list);
                if (list == null || list.size() <= 0) {
                    c.access$002(false);
                    return;
                }
                AdTemplate adTemplate = list.get(0).getAdTemplate();
                if (!com.kwad.sdk.core.response.b.a.cZ(com.kwad.sdk.core.response.b.e.el(adTemplate))) {
                    c.access$002(false);
                    com.kwad.sdk.core.d.c.d("PushAdManager", "pushAdInfo templateId invalid");
                } else {
                    com.kwad.sdk.core.d.c.d("PushAdManager", "loadPushTK");
                    c.this.qN = new d(ServiceProvider.getContext(), adTemplate);
                }
            }

            @Override // com.kwad.components.core.j.a.InterfaceC0621a
            public final void onError(int i6, String str) {
                com.kwad.sdk.core.d.c.d("PushAdManager", "onError: " + str);
                c.access$002(false);
            }

            @Override // com.kwad.components.core.j.a.InterfaceC0621a
            public final void onRequestResult(int i6) {
            }
        });
    }

    public final void fX() {
        com.kwad.sdk.core.d.c.d("PushAdManager", "onOutSDKPage: ");
        if (qI.hasMessages(1000001)) {
            return;
        }
        com.kwad.sdk.core.d.c.d("PushAdManager", "onOutSDKPage: sendMessageDelay MSG_WHAT_PAGE_OUT");
        a(1000002, this, 500L);
    }

    public c(@NonNull com.kwad.components.core.internal.api.a aVar) {
        AdTemplate adTemplate = aVar.getAdTemplate();
        this.qK = adTemplate;
        long db = com.kwad.sdk.core.response.b.a.db(com.kwad.sdk.core.response.b.e.el(adTemplate));
        this.qJ = db;
        com.kwad.sdk.core.d.c.d("PushAdManager", "PushAdManager create adTemplate: " + adTemplate.hashCode() + ", " + db);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    public void fW() {
        d dVar;
        if (!b.fR().fT()) {
            com.kwad.sdk.core.d.c.d("PushAdManager", "run preCheckResult false");
            return;
        }
        qM = false;
        if (!this.qL && (dVar = this.qN) != null && dVar.gb()) {
            this.qL = true;
            this.qN.c(new com.kwad.components.ad.b.a.b() { // from class: com.kwad.components.ad.i.c.3
                @Override // com.kwad.components.ad.b.a.b
                public final void V() {
                    com.kwad.sdk.core.d.c.d("PushAdManager", "onAdClose: ");
                    e.ge().gc();
                    b.fR().a(c.this);
                }

                @Override // com.kwad.components.ad.b.a.b
                public final void U() {
                    ag.aZ(System.currentTimeMillis());
                    e.ge().ga();
                }
            });
        }
    }

    public final void d(com.kwad.components.core.internal.api.a aVar) {
        AdTemplate adTemplate = aVar.getAdTemplate();
        if (!adTemplate.equals(this.qK)) {
            com.kwad.sdk.core.d.c.d("PushAdManager", "onAdExit not current ad");
            return;
        }
        com.kwad.sdk.core.d.c.d("PushAdManager", "onAdExit showPushAdDelayTime: " + this.qJ + ", adTemplate: " + adTemplate.hashCode());
        if (aVar.supportPushAd()) {
            a(1000001, this, this.qJ);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (com.kwad.components.core.e.a.e.oK().isShowing()) {
            com.kwad.components.core.e.a.e.oK().a(new com.kwad.components.core.e.a.c() { // from class: com.kwad.components.ad.i.c.2
                @Override // com.kwad.components.core.e.a.c, com.kwad.components.core.e.a.b
                public final void fY() {
                    com.kwad.components.core.e.a.e.oK().b(this);
                    c.this.fW();
                }
            });
        } else {
            fW();
        }
    }
}
