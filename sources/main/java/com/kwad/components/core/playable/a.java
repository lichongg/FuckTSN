package com.kwad.components.core.playable;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.e.d.c;
import com.kwad.components.core.webview.jshandler.ag;
import com.kwad.components.core.webview.jshandler.ah;
import com.kwad.components.core.webview.jshandler.am;
import com.kwad.components.core.webview.jshandler.as;
import com.kwad.components.core.webview.jshandler.az;
import com.kwad.components.core.webview.jshandler.bi;
import com.kwad.components.core.webview.jshandler.j;
import com.kwad.components.core.webview.jshandler.n;
import com.kwad.components.core.webview.jshandler.o;
import com.kwad.components.core.webview.jshandler.p;
import com.kwad.components.core.webview.tachikoma.b.f;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.core.webview.b;
import com.kwad.sdk.utils.bw;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a implements p {
    private final KsAdWebView VU;
    private long VV;
    private int VW;
    private PlayableSource VX = PlayableSource.UNKNOWN_TRYPLAY_ENTRY_SOURCE;
    private List<as.b> VY = new CopyOnWriteArrayList();
    private List<KsAdWebView.e> VZ = new CopyOnWriteArrayList();

    @Nullable
    private com.kwad.components.core.webview.a eP;
    private az eS;

    @Nullable
    private AdTemplate mAdTemplate;
    private c mApkDownloadHelper;
    private Context mContext;
    private AdBaseFrameLayout mRootContainer;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.kwad.components.core.playable.a$a, reason: collision with other inner class name */
    static class C0632a implements bi.b {
        private final WeakReference<a> Wb;

        @Override // com.kwad.components.core.webview.jshandler.bi.b
        public final void ae(int i6) {
            a aVar = this.Wb.get();
            if (aVar != null) {
                aVar.aR(i6);
            }
        }

        public C0632a(a aVar) {
            this.Wb = new WeakReference<>(aVar);
        }
    }

    private void bf() {
        com.kwad.components.core.webview.a aVar = this.eP;
        if (aVar != null) {
            aVar.destroy();
            this.eP = null;
        }
    }

    @Nullable
    private AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    private String getUrl() {
        AdTemplate adTemplate = this.mAdTemplate;
        return adTemplate == null ? "" : com.kwad.sdk.core.response.b.a.bQ(e.el(adTemplate));
    }

    private KsAdWebView.e ju() {
        return new KsAdWebView.e() { // from class: com.kwad.components.core.playable.a.2
            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onPageFinished() {
                Iterator it = a.this.VZ.iterator();
                while (it.hasNext()) {
                    ((KsAdWebView.e) it.next()).onPageFinished();
                }
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onPageStart() {
                Iterator it = a.this.VZ.iterator();
                while (it.hasNext()) {
                    ((KsAdWebView.e) it.next()).onPageStart();
                }
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onReceivedHttpError(int i6, String str, String str2) {
                Iterator it = a.this.VZ.iterator();
                while (it.hasNext()) {
                    ((KsAdWebView.e) it.next()).onReceivedHttpError(i6, str, str2);
                }
            }
        };
    }

    private void rp() {
        if (com.kwad.sdk.core.response.b.a.bM(e.el(this.mAdTemplate)) > 0) {
            bw.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.core.playable.a.4
                @Override // java.lang.Runnable
                @SuppressLint({"SetTextI18n"})
                public final void run() {
                    a.this.VU.getClientConfig().bB(true);
                }
            }, com.kwad.sdk.core.response.b.a.bM(e.el(this.mAdTemplate)));
        }
        if (com.kwad.sdk.core.response.b.a.bM(e.el(this.mAdTemplate)) == 0) {
            this.VU.getClientConfig().bB(true);
        }
    }

    public final void e(PlayableSource playableSource) {
        if (playableSource != null) {
            this.VX = playableSource;
        }
        if (this.VU == null) {
            return;
        }
        rp();
        com.kwad.sdk.core.d.c.d("PlayableViewHelper", "showPlayable");
        az azVar = this.eS;
        if (azVar != null) {
            azVar.uF();
        }
        this.VU.setVisibility(0);
        az azVar2 = this.eS;
        if (azVar2 != null) {
            azVar2.uG();
        }
    }

    public final long getLoadTime() {
        KsAdWebView ksAdWebView = this.VU;
        if (ksAdWebView != null) {
            return ksAdWebView.getLoadTime();
        }
        return -1L;
    }

    public final void iK() {
        com.kwad.sdk.core.d.c.d("PlayableViewHelper", "showPlayable");
        if (this.VU == null) {
            return;
        }
        az azVar = this.eS;
        if (azVar != null) {
            azVar.uH();
        }
        this.VU.setVisibility(8);
        az azVar2 = this.eS;
        if (azVar2 != null) {
            azVar2.uI();
        }
        this.VU.reload();
    }

    public final void rQ() {
        com.kwad.components.core.webview.a aVar = this.eP;
        if (aVar != null) {
            aVar.destroy();
            this.eP = null;
        }
    }

    public final void rR() {
        KsAdWebView ksAdWebView;
        if (this.mAdTemplate == null || (ksAdWebView = this.VU) == null) {
            return;
        }
        ksAdWebView.getClientConfig().bB(false);
        String url = getUrl();
        if (!TextUtils.isEmpty(url)) {
            this.VU.loadUrl(url);
        }
        com.kwad.sdk.core.adlog.c.cd(this.mAdTemplate);
    }

    public final boolean rS() {
        return this.VU != null && this.VW == 1;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public a(KsAdWebView ksAdWebView) {
        this.VU = ksAdWebView;
        ksAdWebView.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.components.core.playable.a.1
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    a.this.VV = SystemClock.elapsedRealtime();
                    a.this.VU.getClientConfig().bB(true);
                    return false;
                }
                return false;
            }
        });
        ksAdWebView.setClientConfig(ksAdWebView.getClientConfig().eJ(this.mAdTemplate).b(ju()));
        a(ksAdWebView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aR(int i6) {
        if (getAdTemplate() != null) {
            long FO = com.kwad.sdk.core.config.e.FO();
            if (FO > 0 && SystemClock.elapsedRealtime() - this.VV > FO) {
                return;
            }
            com.kwad.components.core.e.d.a.a(new a.C0616a(this.mContext).aB(this.mAdTemplate).b(this.mApkDownloadHelper).aq(false).aA(i6).d(this.mRootContainer.getTouchCoords()).as(true));
        }
    }

    public final void b(@Nullable as.b bVar) {
        this.VY.remove(bVar);
    }

    private static void a(KsAdWebView ksAdWebView) {
        if (com.kwad.sdk.core.config.e.FN()) {
            ksAdWebView.getSettings().setMediaPlaybackRequiresUserGesture(false);
        }
    }

    @SuppressLint({"AddJavascriptInterface"})
    public final void a(AdTemplate adTemplate, AdBaseFrameLayout adBaseFrameLayout, c cVar) {
        if (this.VU == null) {
            com.kwad.sdk.core.d.c.w("PlayableViewHelper", "registerJsBridge mPlayableView is null");
            return;
        }
        this.mContext = adBaseFrameLayout.getContext();
        this.mRootContainer = adBaseFrameLayout;
        this.mAdTemplate = adTemplate;
        this.mApkDownloadHelper = cVar;
        this.VW = -1;
        b bVar = new b();
        bVar.setAdTemplate(adTemplate);
        bVar.mScreenOrientation = 0;
        AdBaseFrameLayout adBaseFrameLayout2 = this.mRootContainer;
        bVar.aMN = adBaseFrameLayout2;
        bVar.TG = adBaseFrameLayout2;
        bVar.Ta = this.VU;
        bf();
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.VU);
        this.eP = aVar;
        a(bVar, aVar, cVar);
        this.VU.addJavascriptInterface(this.eP, "KwaiAd");
    }

    public final void a(@Nullable as.b bVar) {
        this.VY.add(bVar);
    }

    public final void a(@Nullable KsAdWebView.e eVar) {
        this.VZ.add(eVar);
    }

    private void a(b bVar, com.kwad.components.core.webview.a aVar, c cVar) {
        aVar.a(new bi(bVar, cVar, new C0632a(this)));
        aVar.a(new as(new as.b() { // from class: com.kwad.components.core.playable.a.3
            @Override // com.kwad.components.core.webview.jshandler.as.b
            public final void a(as.a aVar2) {
                a.this.VW = aVar2.status;
                if (aVar2.status == 1 && a.this.mAdTemplate != null) {
                    com.kwad.sdk.core.adlog.c.cc(a.this.mAdTemplate);
                }
                Iterator it = a.this.VY.iterator();
                while (it.hasNext()) {
                    ((as.b) it.next()).a(aVar2);
                }
            }
        }, getUrl()));
        aVar.a(new am(bVar));
        aVar.b(new o(bVar));
        aVar.b(new n(bVar));
        this.eS = new az();
        aVar.a(new ah());
        aVar.a(new ag(bVar));
        aVar.a(new f());
        aVar.a(this.eS);
        aVar.a(new j(this));
    }

    @Override // com.kwad.components.core.webview.jshandler.p
    public final void a(j jVar, String str) {
        AdTemplate adTemplate;
        if ("playableSrc".equals(str)) {
            jVar.f(this.VX);
        }
        if (!"getAdType".equals(str) || (adTemplate = this.mAdTemplate) == null) {
            return;
        }
        jVar.be(adTemplate.adStyle);
    }
}
