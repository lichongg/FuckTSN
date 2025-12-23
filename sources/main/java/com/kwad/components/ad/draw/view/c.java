package com.kwad.components.ad.draw.view;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.ad.draw.c;
import com.kwad.components.core.webview.jshandler.a;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.az;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.b.o;
import com.kwad.components.core.webview.tachikoma.b.p;
import com.kwad.components.core.webview.tachikoma.c.n;
import com.kwad.components.core.webview.tachikoma.c.u;
import com.kwad.components.core.webview.tachikoma.c.y;
import com.kwad.components.core.webview.tachikoma.i;
import com.kwad.components.core.webview.tachikoma.j;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.t;
import com.kwad.sdk.core.c.d;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.o.m;
import com.kwad.sdk.widget.KSFrameLayout;
import com.kwad.sdk.widget.g;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class c extends KSFrameLayout {
    private boolean dA;
    private KsDrawAd.AdInteractionListener dh;
    private boolean dl;
    private com.kwad.sdk.core.j.b dn;
    private long fG;
    private i fU;
    private KSFrameLayout fV;
    private c.a fW;
    private boolean fX;
    private int fY;
    private boolean fZ;
    private com.kwad.components.core.widget.a.b fg;
    private boolean fj;
    private final com.kwad.sdk.core.j.c fo;
    private AdInfo mAdInfo;

    @NonNull
    private AdResultData mAdResultData;

    @NonNull
    private AdTemplate mAdTemplate;
    private Context mContext;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KsJson
    public class a extends com.kwad.sdk.core.response.a.a {
        public boolean gb;
        public int status;

        public a() {
        }
    }

    public final void bK() {
        this.dl = true;
        A(0);
    }

    public final void setVideoSound(boolean z5) {
        this.fj = !z5;
        this.fX = true;
        bN();
    }

    private void B(Context context) {
        this.mContext = context;
        m.inflate(context, R.layout.ksad_draw_tk_layout, this);
        this.fV = (KSFrameLayout) findViewById(R.id.ksad_draw_tk_container);
        int a6 = e.a(com.kwad.sdk.core.config.c.aBa);
        this.fU = new i(context, a6, a6);
        final WeakReference weakReference = new WeakReference(m.ej(context));
        com.kwad.sdk.core.c.b.Ho();
        com.kwad.sdk.core.c.b.a(new d() { // from class: com.kwad.components.ad.draw.view.c.1
            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            /* renamed from: onActivityDestroyed */
            public final void b(@NonNull Activity activity) {
                Activity activity2 = (Activity) weakReference.get();
                if (activity2 == null || !activity2.equals(activity)) {
                    return;
                }
                if (c.this.fU != null) {
                    c.this.setLifeStatue("hideStart");
                    c.this.setLifeStatue("hideEnd");
                    c.this.fZ = false;
                    c.this.fU.kz();
                }
                com.kwad.sdk.core.c.b.Ho();
                com.kwad.sdk.core.c.b.b((com.kwad.sdk.core.c.c) this);
            }
        });
    }

    static /* synthetic */ boolean b(c cVar, boolean z5) {
        cVar.dA = true;
        return true;
    }

    private void bL() {
        this.fg.a(this.dn);
        this.fg.a(this.fo);
        this.fg.wi();
        if (this.fU != null) {
            this.fG = SystemClock.elapsedRealtime();
            com.kwad.components.ad.draw.a.b.g(this.mAdTemplate);
            this.fU.a(m.ej(this.mContext), this.mAdResultData, new j() { // from class: com.kwad.components.ad.draw.view.c.3
                @Override // com.kwad.components.core.webview.tachikoma.j
                public final void a(az azVar) {
                }

                @Override // com.kwad.components.core.webview.tachikoma.j
                public final g getTouchCoordsView() {
                    return null;
                }

                @Override // com.kwad.components.core.webview.tachikoma.j
                public final void a(o oVar) {
                }

                @Override // com.kwad.components.core.webview.tachikoma.j
                public final void aB() {
                    c.this.bM();
                    c.this.bN();
                    c cVar = c.this;
                    cVar.A(cVar.fY);
                }

                @Override // com.kwad.components.core.webview.tachikoma.j
                public final void az() {
                    if (c.this.fW != null) {
                        c.this.fW.aI();
                    }
                    c.this.fV.setVisibility(0);
                }

                @Override // com.kwad.components.core.webview.tachikoma.j
                public final String getRegisterViewKey() {
                    return "ksad-draw-card";
                }

                @Override // com.kwad.components.core.webview.tachikoma.j
                public final FrameLayout getTKContainer() {
                    return c.this.fV;
                }

                @Override // com.kwad.components.core.webview.tachikoma.j
                public final String getTKReaderScene() {
                    return "tk_draw_card";
                }

                @Override // com.kwad.components.core.webview.tachikoma.j
                public final String getTkTemplateId() {
                    return com.kwad.sdk.core.response.b.b.dV(c.this.mAdTemplate);
                }

                @Override // com.kwad.components.core.webview.tachikoma.j
                public final void a(p pVar) {
                }

                @Override // com.kwad.components.core.webview.tachikoma.j
                public final void a(n nVar) {
                }

                @Override // com.kwad.components.core.webview.tachikoma.j
                public final void a(u uVar) {
                }

                @Override // com.kwad.components.core.webview.tachikoma.j
                public final void a(WebCloseStatus webCloseStatus) {
                }

                @Override // com.kwad.components.core.webview.tachikoma.j
                public final void a(t tVar, com.kwad.sdk.core.webview.b bVar) {
                }

                @Override // com.kwad.components.core.webview.tachikoma.j
                public final void a(TKRenderFailReason tKRenderFailReason) {
                    if (c.this.fW != null) {
                        c.this.fW.aJ();
                    }
                    c.this.fV.setVisibility(8);
                }

                @Override // com.kwad.components.core.webview.tachikoma.j
                public final void a(@Nullable com.kwad.sdk.core.webview.d.b.a aVar) {
                    if (c.this.dh != null) {
                        c.this.dh.onAdClicked();
                    }
                    if (c.this.dA) {
                        return;
                    }
                    c.b(c.this, true);
                    com.kwad.components.ad.draw.a.c.b(c.this.mAdTemplate, 2, 2);
                }

                @Override // com.kwad.components.core.webview.tachikoma.j
                public final void a(ae.a aVar) {
                    aVar.width = com.kwad.sdk.c.a.a.px2dip(c.this.getContext(), c.this.fV.getWidth());
                    aVar.height = com.kwad.sdk.c.a.a.px2dip(c.this.getContext(), c.this.fV.getHeight());
                }

                @Override // com.kwad.components.core.webview.tachikoma.j
                public final void aA() {
                }

                @Override // com.kwad.components.core.webview.tachikoma.j
                public final void a(a.C0637a c0637a) {
                    if (c.this.dh != null) {
                        String str = c0637a.acf;
                        str.getClass();
                        if (str.equals("adShowCallback")) {
                            c.this.dh.onAdShow();
                            if (c.this.mAdTemplate == null || c.this.mAdTemplate.mHasAdShow) {
                                return;
                            }
                            com.kwad.components.ad.draw.a.c.a(c.this.mAdTemplate, 2, 2);
                            c.this.mAdTemplate.mHasAdShow = true;
                            return;
                        }
                        if (str.equals("adClickCallback")) {
                            c.this.dh.onAdClicked();
                            if (c.this.dA) {
                                return;
                            }
                            c.b(c.this, true);
                            com.kwad.components.ad.draw.a.c.b(c.this.mAdTemplate, 2, 2);
                        }
                    }
                }

                @Override // com.kwad.components.core.webview.tachikoma.j
                public final void f(AdTemplate adTemplate) {
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bM() {
        i iVar = this.fU;
        if (iVar != null) {
            iVar.a("setVideoPlayStatusCallback", (String) null, new com.kwad.components.core.webview.tachikoma.a.g() { // from class: com.kwad.components.ad.draw.view.c.4
                @Override // com.kwad.components.core.webview.tachikoma.a.g
                public final void a(y yVar) {
                    if (c.this.dh != null) {
                        c.this.dh.onVideoPlayError();
                        com.kwad.components.ad.draw.a.b.a(c.this.mAdTemplate, SystemClock.elapsedRealtime() - c.this.fG, "video play error");
                    }
                }

                @Override // com.kwad.components.core.webview.tachikoma.a.g
                public final void bP() {
                    if (c.this.dh != null) {
                        c.this.dh.onVideoPlayResume();
                    }
                }

                @Override // com.kwad.components.core.webview.tachikoma.a.g
                public final void bQ() {
                    if (c.this.dh != null) {
                        c.this.dh.onVideoPlayPause();
                    }
                }

                @Override // com.kwad.components.core.webview.tachikoma.a.g
                public final void bR() {
                    if (c.this.dh != null) {
                        c.this.dh.onVideoPlayEnd();
                    }
                }

                @Override // com.kwad.components.core.webview.tachikoma.a.g
                public final void bS() {
                    if (c.this.dh != null) {
                        c.this.dh.onVideoPlayStart();
                        com.kwad.components.ad.draw.a.b.a(c.this.mAdTemplate, SystemClock.elapsedRealtime() - c.this.fG);
                        c.this.bN();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bN() {
        if (this.fU != null) {
            n nVar = new n();
            nVar.ahg = bO();
            this.fU.a("setVideoMuteStateListener", nVar.toJson().toString(), (com.kwad.sdk.components.m) null);
        }
    }

    private boolean bO() {
        return this.fX ? this.fj : com.kwad.sdk.core.response.b.a.cb(com.kwad.sdk.core.response.b.e.el(this.mAdTemplate));
    }

    public final void A(int i6) {
        this.fY = i6;
        if (this.fU == null) {
            return;
        }
        a aVar = new a();
        aVar.status = this.fY;
        aVar.gb = this.dl;
        this.fU.a("setVideoPlayerStatus", aVar.toJson().toString(), (com.kwad.sdk.components.m) null);
    }

    public final void c(@NonNull AdResultData adResultData) {
        this.mAdResultData = adResultData;
        AdTemplate r5 = com.kwad.sdk.core.response.b.c.r(adResultData);
        this.mAdTemplate = r5;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.el(r5);
        this.fg = new com.kwad.components.ad.draw.b(this.fV);
        bL();
    }

    public final void setAdInteractionListener(KsDrawAd.AdInteractionListener adInteractionListener) {
        this.dh = adInteractionListener;
    }

    public final void setLifeStatue(String str) {
        i iVar = this.fU;
        if (iVar != null) {
            iVar.a("setLifeStatus", str, (com.kwad.sdk.components.m) null);
        }
    }

    public final void setPageExitListener(com.kwad.sdk.core.j.b bVar) {
        this.dn = bVar;
    }

    public final void setTKLoadStateListener(c.a aVar) {
        this.fW = aVar;
    }

    public c(@NonNull Context context) {
        super(context);
        this.fo = new com.kwad.sdk.core.j.c() { // from class: com.kwad.components.ad.draw.view.c.2
            @Override // com.kwad.sdk.core.j.c
            public final void bt() {
                if (!c.this.mAdTemplate.mPvReported && c.this.dh != null && !c.this.mAdTemplate.mHasAdShow) {
                    c.this.dh.onAdShow();
                    com.kwad.components.ad.draw.a.c.a(c.this.mAdTemplate, 2, 2);
                    c.this.mAdTemplate.mHasAdShow = true;
                }
                if (!c.this.fZ) {
                    c.this.setLifeStatue("showStart");
                    c.this.setLifeStatue("showEnd");
                    c.this.fZ = true;
                }
                c.this.setLifeStatue("pageVisiable");
            }

            @Override // com.kwad.sdk.core.j.c
            public final void bu() {
                c.this.setLifeStatue("pageInvisiable");
            }
        };
        B(context);
    }
}
