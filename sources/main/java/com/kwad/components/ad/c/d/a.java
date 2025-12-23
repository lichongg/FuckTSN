package com.kwad.components.ad.c.d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.az;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.b.o;
import com.kwad.components.core.webview.tachikoma.c.n;
import com.kwad.components.core.widget.a;
import com.kwad.sdk.R;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.t;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.utils.bg;
import com.stub.StubApp;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a extends c {
    private FrameLayout cV;
    private boolean cW;
    private az cX;
    private o cY;
    private boolean cp;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f(boolean z5) {
        if (!z5) {
            com.kwad.components.core.t.a.aC(this.mContext).aQ(false);
            return false;
        }
        if (!e.FL()) {
            return !com.kwad.components.core.t.a.aC(this.mContext).sX() ? com.kwad.components.core.t.a.aC(this.mContext).aQ(false) : !com.kwad.components.core.t.a.aC(this.mContext).sW();
        }
        if (!this.cp) {
            this.cp = com.kwad.components.core.t.a.aC(this.mContext).aQ(true);
        }
        return this.cp;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void az() {
        if (this.cD.bO) {
            return;
        }
        az azVar = this.cX;
        if (azVar != null) {
            azVar.uJ();
            this.cX.uF();
            this.cX.uG();
        }
        this.cV.setVisibility(0);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final FrameLayout getTKContainer() {
        return this.cV;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTKReaderScene() {
        return "tk_splash";
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTkTemplateId() {
        return com.kwad.sdk.core.response.b.b.cr(this.cD.mAdTemplate).bannerTKInfo.templateId;
    }

    @Override // com.kwad.components.ad.c.d.c, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        az azVar = this.cX;
        if (azVar != null) {
            azVar.uH();
            this.cX.uI();
        }
        super.onUnbind();
    }

    public a(Context context) {
        this.mContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    private void a(ViewGroup viewGroup) {
        if (e.FK() || e.FJ() < 0.0f) {
            return;
        }
        com.kwad.components.core.widget.a aVar = new com.kwad.components.core.widget.a(viewGroup.getContext(), viewGroup);
        viewGroup.addView(aVar);
        aVar.setViewCallback(new a.InterfaceC0647a() { // from class: com.kwad.components.ad.c.d.a.1
            @Override // com.kwad.components.core.widget.a.InterfaceC0647a
            public final void ay() {
                com.kwad.sdk.core.d.c.e("BannerFullTKCardPresenter ", "onViewFirstInVisible");
            }

            @Override // com.kwad.components.core.widget.a.InterfaceC0647a
            public final void c(View view) {
                com.kwad.sdk.core.d.c.e("BannerFullTKCardPresenter ", "onViewVisible");
            }

            @Override // com.kwad.components.core.widget.a.InterfaceC0647a
            public final void onWindowFocusChanged(boolean z5) {
                if (a.this.cX != null) {
                    if (!z5) {
                        a aVar2 = a.this;
                        aVar2.f(aVar2.cD.mAdTemplate.mIsAudioEnable);
                        a.this.cX.uK();
                        return;
                    }
                    a.this.cX.uJ();
                    n nVar = new n();
                    if (a.this.cW) {
                        a aVar3 = a.this;
                        nVar.ahg = !aVar3.f(aVar3.cD.mAdTemplate.mIsAudioEnable);
                    } else {
                        nVar.ahg = false;
                    }
                    a.this.cY.c(nVar);
                }
            }

            @Override // com.kwad.components.core.widget.a.InterfaceC0647a
            public final void aa() {
            }

            @Override // com.kwad.components.core.widget.a.InterfaceC0647a
            public final void ab() {
            }
        });
        aVar.vU();
    }

    @Override // com.kwad.components.ad.c.d.c, com.kwad.components.ad.c.c.a, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
    }

    @Override // com.kwad.components.ad.c.c.a, com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.banner_full_tk_card_view);
        this.cV = frameLayout;
        a((ViewGroup) frameLayout.getParent());
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        az azVar = this.cX;
        if (azVar != null) {
            azVar.uH();
            this.cX.uI();
        }
        this.cV.setVisibility(8);
        com.kwad.components.ad.c.b bVar = this.cD;
        bVar.bO = true;
        bVar.bI.Z();
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(ae.a aVar) {
        aVar.width = com.kwad.sdk.c.a.a.px2dip(getContext(), this.cD.bH.getWidth());
        aVar.height = com.kwad.sdk.c.a.a.px2dip(getContext(), this.cD.bH.getHeight());
    }

    @Override // com.kwad.components.ad.c.d.c, com.kwad.components.core.webview.tachikoma.j
    public final void a(az azVar) {
        super.a(azVar);
        this.cX = azVar;
    }

    @Override // com.kwad.components.ad.c.d.c, com.kwad.components.core.webview.tachikoma.j
    public final void a(t tVar, com.kwad.sdk.core.webview.b bVar) {
        super.a(tVar, bVar);
        tVar.c(a(bVar));
    }

    @NonNull
    private z a(com.kwad.sdk.core.webview.b bVar) {
        return new z(bVar, (com.kwad.components.core.e.d.c) null, new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.c.d.a.2
            @Override // com.kwad.sdk.core.webview.d.a.a
            public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
                if (aVar != null) {
                    a.this.cD.bH.post(new bg() { // from class: com.kwad.components.ad.c.d.a.2.1
                        @Override // com.kwad.sdk.utils.bg
                        public final void doTask() {
                            a.this.cD.X();
                        }
                    });
                }
            }
        });
    }

    @Override // com.kwad.components.ad.c.d.c, com.kwad.components.core.webview.tachikoma.j
    public final void a(WebCloseStatus webCloseStatus) {
        this.cX.uI();
        this.cD.bH.removeAllViews();
        onDestroy();
        this.cD.Y();
    }

    @Override // com.kwad.components.ad.c.d.c, com.kwad.components.core.webview.tachikoma.j
    public final void a(o oVar) {
        this.cY = oVar;
        oVar.a(new o.a() { // from class: com.kwad.components.ad.c.d.a.3
            /* JADX WARN: Removed duplicated region for block: B:10:0x0063 A[Catch: all -> 0x0075, TryCatch #0 {all -> 0x0075, blocks: (B:3:0x0001, B:5:0x0007, B:8:0x0059, B:10:0x0063, B:11:0x006f, B:15:0x001b, B:17:0x0027, B:19:0x0037, B:20:0x0045), top: B:2:0x0001 }] */
            @Override // com.kwad.components.core.webview.tachikoma.b.o.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final boolean isMuted() {
                /*
                    r4 = this;
                    r0 = 1
                    boolean r1 = com.kwad.sdk.core.config.e.FL()     // Catch: java.lang.Throwable -> L75
                    if (r1 != 0) goto L1b
                    com.kwad.components.ad.c.d.a r1 = com.kwad.components.ad.c.d.a.this     // Catch: java.lang.Throwable -> L75
                    com.kwad.components.ad.c.b r1 = com.kwad.components.ad.c.d.a.h(r1)     // Catch: java.lang.Throwable -> L75
                    android.content.Context r1 = r1.mContext     // Catch: java.lang.Throwable -> L75
                    com.kwad.components.core.t.a r1 = com.kwad.components.core.t.a.aC(r1)     // Catch: java.lang.Throwable -> L75
                    boolean r1 = r1.sW()     // Catch: java.lang.Throwable -> L75
                    if (r1 == 0) goto L1b
                L19:
                    r1 = 1
                    goto L59
                L1b:
                    com.kwad.components.ad.c.d.a r1 = com.kwad.components.ad.c.d.a.this     // Catch: java.lang.Throwable -> L75
                    com.kwad.components.ad.c.b r1 = com.kwad.components.ad.c.d.a.i(r1)     // Catch: java.lang.Throwable -> L75
                    com.kwad.sdk.api.KsAdVideoPlayConfig r1 = r1.bJ     // Catch: java.lang.Throwable -> L75
                    boolean r1 = r1 instanceof com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl     // Catch: java.lang.Throwable -> L75
                    if (r1 == 0) goto L45
                    com.kwad.components.ad.c.d.a r1 = com.kwad.components.ad.c.d.a.this     // Catch: java.lang.Throwable -> L75
                    com.kwad.components.ad.c.b r1 = com.kwad.components.ad.c.d.a.j(r1)     // Catch: java.lang.Throwable -> L75
                    com.kwad.sdk.api.KsAdVideoPlayConfig r1 = r1.bJ     // Catch: java.lang.Throwable -> L75
                    com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl r1 = (com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl) r1     // Catch: java.lang.Throwable -> L75
                    int r1 = r1.getVideoSoundValue()     // Catch: java.lang.Throwable -> L75
                    if (r1 == 0) goto L45
                    com.kwad.components.ad.c.d.a r1 = com.kwad.components.ad.c.d.a.this     // Catch: java.lang.Throwable -> L75
                    com.kwad.components.ad.c.b r1 = com.kwad.components.ad.c.d.a.k(r1)     // Catch: java.lang.Throwable -> L75
                    com.kwad.sdk.api.KsAdVideoPlayConfig r1 = r1.bJ     // Catch: java.lang.Throwable -> L75
                    boolean r1 = r1.isVideoSoundEnable()     // Catch: java.lang.Throwable -> L75
                    r1 = r1 ^ r0
                    goto L59
                L45:
                    com.kwad.components.ad.c.d.a r1 = com.kwad.components.ad.c.d.a.this     // Catch: java.lang.Throwable -> L75
                    com.kwad.components.ad.c.b r1 = com.kwad.components.ad.c.d.a.l(r1)     // Catch: java.lang.Throwable -> L75
                    com.kwad.sdk.core.response.model.AdTemplate r1 = r1.mAdTemplate     // Catch: java.lang.Throwable -> L75
                    com.kwad.sdk.core.response.model.AdInfo r1 = com.kwad.sdk.core.response.b.e.el(r1)     // Catch: java.lang.Throwable -> L75
                    boolean r1 = com.kwad.sdk.core.response.b.a.bX(r1)     // Catch: java.lang.Throwable -> L75
                    if (r1 != 0) goto L58
                    goto L19
                L58:
                    r1 = 0
                L59:
                    com.kwad.components.ad.c.d.a r2 = com.kwad.components.ad.c.d.a.this     // Catch: java.lang.Throwable -> L75
                    com.kwad.components.ad.c.b r2 = com.kwad.components.ad.c.d.a.m(r2)     // Catch: java.lang.Throwable -> L75
                    com.kwad.sdk.core.response.model.AdTemplate r2 = r2.mAdTemplate     // Catch: java.lang.Throwable -> L75
                    if (r2 == 0) goto L6f
                    com.kwad.components.ad.c.d.a r2 = com.kwad.components.ad.c.d.a.this     // Catch: java.lang.Throwable -> L75
                    com.kwad.components.ad.c.b r2 = com.kwad.components.ad.c.d.a.n(r2)     // Catch: java.lang.Throwable -> L75
                    com.kwad.sdk.core.response.model.AdTemplate r2 = r2.mAdTemplate     // Catch: java.lang.Throwable -> L75
                    r3 = r1 ^ 1
                    r2.mIsAudioEnable = r3     // Catch: java.lang.Throwable -> L75
                L6f:
                    com.kwad.components.ad.c.d.a r2 = com.kwad.components.ad.c.d.a.this     // Catch: java.lang.Throwable -> L75
                    com.kwad.components.ad.c.d.a.b(r2, r1)     // Catch: java.lang.Throwable -> L75
                    return r1
                L75:
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.c.d.a.AnonymousClass3.isMuted():boolean");
            }
        });
    }
}
