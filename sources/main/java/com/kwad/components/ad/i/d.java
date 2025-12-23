package com.kwad.components.ad.i;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.webview.jshandler.a;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.az;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.b.o;
import com.kwad.components.core.webview.tachikoma.b.p;
import com.kwad.components.core.webview.tachikoma.c.n;
import com.kwad.components.core.webview.tachikoma.c.u;
import com.kwad.components.core.webview.tachikoma.i;
import com.kwad.components.core.webview.tachikoma.j;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.t;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.KSFrameLayout;
import com.kwad.sdk.widget.g;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class d extends KSFrameLayout implements j, com.kwad.sdk.core.j.c {
    public static String qP = "PUSH_VIEW_TAG";
    private az eS;
    private i fU;
    private final com.kwad.components.core.widget.a.b fg;
    private AdTemplate qQ;
    private com.kwad.components.ad.b.a.b qR;
    private boolean qS;
    private ViewGroup qT;
    private boolean qU;

    private boolean gd() {
        try {
            com.kwad.sdk.core.c.b.Ho();
            final Activity currentActivity = com.kwad.sdk.core.c.b.getCurrentActivity();
            if (currentActivity != null && !currentActivity.isFinishing()) {
                View findViewById = currentActivity.getWindow().getDecorView().findViewById(R.id.content);
                if (!(findViewById instanceof ViewGroup)) {
                    return false;
                }
                this.qT = (ViewGroup) findViewById;
                this.qT.addView(this, new ViewGroup.LayoutParams(-1, -1));
                com.kwad.sdk.core.c.b.Ho();
                com.kwad.sdk.core.c.b.a(new com.kwad.sdk.core.c.d() { // from class: com.kwad.components.ad.i.d.2
                    @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
                    /* renamed from: onActivityDestroyed */
                    public final void b(Activity activity) {
                        super.b(activity);
                        com.kwad.sdk.core.c.b.Ho();
                        com.kwad.sdk.core.c.b.b((com.kwad.sdk.core.c.c) this);
                        if (activity.equals(currentActivity)) {
                            d.this.fZ();
                        }
                    }
                });
                return true;
            }
            return false;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTrace(th);
            return false;
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(a.C0637a c0637a) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getRegisterViewKey() {
        return null;
    }

    private void destroy() {
        this.fU.kz();
        ViewGroup viewGroup = this.qT;
        if (viewGroup != null) {
            viewGroup.removeView(this);
        }
        ViewParent parent = getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fZ() {
        if (this.qU) {
            return;
        }
        this.qU = true;
        gc();
        destroy();
    }

    private void ga() {
        com.kwad.components.ad.b.a.b bVar = this.qR;
        if (bVar != null) {
            bVar.U();
        }
        az azVar = this.eS;
        if (azVar != null) {
            azVar.uF();
            this.eS.uG();
        }
    }

    private void gc() {
        com.kwad.components.ad.b.a.b bVar = this.qR;
        if (bVar != null) {
            bVar.V();
        }
        az azVar = this.eS;
        if (azVar != null) {
            azVar.uH();
            this.eS.uI();
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(o oVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void az() {
        com.kwad.sdk.core.d.c.d("PushAdView", "onTkLoadSuccess");
        this.qS = true;
    }

    @Override // com.kwad.sdk.core.j.c
    public final void bt() {
        com.kwad.sdk.core.d.c.d("PushAdView", "onPageVisible: ");
        az azVar = this.eS;
        if (azVar != null) {
            azVar.uJ();
        }
    }

    @Override // com.kwad.sdk.core.j.c
    public final void bu() {
        com.kwad.sdk.core.d.c.d("PushAdView", "onPageInvisible: ");
        az azVar = this.eS;
        if (azVar != null) {
            azVar.uK();
        }
    }

    public final boolean c(com.kwad.components.ad.b.a.b bVar) {
        this.qR = bVar;
        if (!this.qS || !gd()) {
            return false;
        }
        ga();
        return true;
    }

    public final boolean gb() {
        return this.qS;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTKReaderScene() {
        return "tk_push_ad";
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTkTemplateId() {
        return com.kwad.sdk.core.response.b.b.dS(this.qQ);
    }

    public d(@NonNull Context context, AdTemplate adTemplate) {
        super(context);
        this.qS = false;
        setTag(qP);
        this.qQ = adTemplate;
        this.fg = new com.kwad.components.core.widget.a.b(this, 100);
        this.fU = new i(-1L, getContext()) { // from class: com.kwad.components.ad.i.d.1
            {
                super(-1L, r4);
            }

            @Override // com.kwad.components.core.webview.tachikoma.i
            public final void a(com.kwad.sdk.core.webview.b bVar, com.kwad.components.core.e.d.c cVar, t tVar, ViewGroup viewGroup) {
                super.a(bVar, cVar, tVar, viewGroup);
                tVar.c(new z(bVar, cVar, this) { // from class: com.kwad.components.ad.i.d.1.1
                    @Override // com.kwad.components.core.webview.jshandler.z
                    public final void Y(int i6) {
                        super.Y(i6);
                        if (i6 == 3) {
                            d.this.a((WebCloseStatus) null);
                        }
                    }
                });
            }
        };
        this.fU.a((Activity) null, com.kwad.sdk.core.response.b.c.dW(this.qQ), this);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(p pVar) {
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void aa() {
        super.aa();
        this.fg.a(this);
        this.fg.wi();
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void ab() {
        super.ab();
        this.fg.release();
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(n nVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(u uVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(t tVar, com.kwad.sdk.core.webview.b bVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        com.kwad.sdk.core.d.c.d("PushAdView", "onTkLoadFailed");
        this.qS = false;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(@Nullable com.kwad.sdk.core.webview.d.b.a aVar) {
        com.kwad.sdk.core.d.c.d("PushAdView", "onAdClicked");
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(ae.a aVar) {
        float bj = com.kwad.sdk.c.a.a.bj(getContext());
        float screenHeight = com.kwad.sdk.c.a.a.getScreenHeight(getContext());
        aVar.width = (int) ((com.kwad.sdk.c.a.a.getScreenWidth(getContext()) / bj) + 0.5f);
        aVar.height = (int) ((screenHeight / bj) + 0.5f);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(az azVar) {
        this.eS = azVar;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(@Nullable WebCloseStatus webCloseStatus) {
        fZ();
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void aA() {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void aB() {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final FrameLayout getTKContainer() {
        return this;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final g getTouchCoordsView() {
        return this;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void f(AdTemplate adTemplate) {
    }
}
