package com.kwad.components.ad.reward.k.a;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.g;
import com.kwad.components.ad.reward.k.l;
import com.kwad.components.ad.reward.k.m;
import com.kwad.components.ad.reward.k.n;
import com.kwad.components.ad.reward.k.o;
import com.kwad.components.ad.reward.k.p;
import com.kwad.components.ad.reward.k.q;
import com.kwad.components.ad.reward.k.r;
import com.kwad.components.ad.reward.k.s;
import com.kwad.components.ad.reward.page.BackPressHandleResult;
import com.kwad.components.core.webview.jshandler.am;
import com.kwad.components.core.webview.jshandler.y;
import com.kwad.components.core.webview.tachikoma.i;
import com.kwad.components.core.webview.tachikoma.j;
import com.kwad.sdk.components.t;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.lang.ref.WeakReference;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class d extends i implements s, y.b {
    private com.kwad.components.ad.reward.c.e AS;
    private m AT;
    private l AU;
    private n AV;
    private List<AdTemplate> AW;

    @Nullable
    private DialogInterface.OnDismissListener AX;

    @Nullable
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private WeakReference<g> td;

    public d(@NonNull g gVar, long j6, Context context) {
        super(j6, context);
        this.AW = null;
        this.td = new WeakReference<>(gVar);
    }

    @Override // com.kwad.components.core.webview.tachikoma.i
    public final void a(@Nullable Activity activity, AdResultData adResultData, j jVar) {
        super.a(activity, adResultData, jVar);
        WeakReference<g> weakReference = this.td;
        g gVar = weakReference != null ? weakReference.get() : null;
        if (gVar != null) {
            gVar.a(this);
        }
    }

    @Override // com.kwad.components.core.webview.jshandler.y.b
    public final void W(AdTemplate adTemplate) {
        com.kwad.components.core.j.c cVar = new com.kwad.components.core.j.c(adTemplate, com.kwad.components.core.j.e.AGGREGATION);
        WeakReference<g> weakReference = this.td;
        g gVar = weakReference != null ? weakReference.get() : null;
        if (gVar != null) {
            gVar.b(cVar);
        }
    }

    @Override // com.kwad.components.ad.reward.k.s
    public final void ab(boolean z5) {
        n nVar = this.AV;
        if (nVar != null) {
            nVar.aa(z5);
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.i
    public final am c(com.kwad.sdk.core.webview.b bVar) {
        WeakReference<g> weakReference = this.td;
        return new p(weakReference != null ? weakReference.get() : null, getTkTemplateId(), this.AO, bVar);
    }

    @Override // com.kwad.components.core.webview.tachikoma.i, com.kwad.components.core.e.e.f
    public final void dismiss() {
        WeakReference<g> weakReference = this.td;
        if (weakReference != null) {
            weakReference.get().E(false);
        }
        super.dismiss();
    }

    public final void h(List<AdTemplate> list) {
        this.AW = list;
    }

    public final BackPressHandleResult hx() {
        m mVar = this.AT;
        if (mVar == null) {
            return BackPressHandleResult.NOT_HANDLED;
        }
        mVar.kq();
        return BackPressHandleResult.HANDLED;
    }

    public final com.kwad.components.ad.reward.c.e kx() {
        return this.AS;
    }

    public final l ky() {
        return this.AU;
    }

    @Override // com.kwad.components.core.webview.tachikoma.i
    public final void kz() {
        g gVar;
        super.kz();
        WeakReference<g> weakReference = this.td;
        if (weakReference != null) {
            gVar = weakReference.get();
        } else {
            gVar = null;
        }
        if (gVar != null) {
            gVar.b(this);
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.i, com.kwad.components.core.e.e.f
    public final void show() {
        super.show();
        WeakReference<g> weakReference = this.td;
        if (weakReference != null) {
            weakReference.get().E(true);
        }
    }

    public d(g gVar, long j6, Context context, @Nullable DialogInterface.OnDismissListener onDismissListener) {
        super(-1L, context);
        this.AW = null;
        this.AX = onDismissListener;
        this.td = new WeakReference<>(gVar);
    }

    @Override // com.kwad.components.core.webview.tachikoma.i
    public final void a(com.kwad.sdk.core.webview.b bVar, com.kwad.components.core.e.d.c cVar, t tVar, ViewGroup viewGroup) {
        super.a(bVar, cVar, tVar, viewGroup);
        this.mApkDownloadHelper = cVar;
        WeakReference<g> weakReference = this.td;
        com.kwad.sdk.core.webview.c.a qVar = new q(bVar, cVar, weakReference != null ? weakReference.get() : null, this.AO, this, this.AX);
        com.kwad.components.core.e.e.g.pY().a(this);
        tVar.c(qVar);
        com.kwad.components.ad.reward.c.e eVar = new com.kwad.components.ad.reward.c.e();
        this.AS = eVar;
        tVar.c(eVar);
        Context context = this.mContext;
        WeakReference<g> weakReference2 = this.td;
        tVar.c(new com.kwad.components.ad.reward.k.t(context, weakReference2 != null ? weakReference2.get() : null));
        WeakReference<g> weakReference3 = this.td;
        tVar.c(new o(weakReference3 != null ? weakReference3.get() : null));
        m mVar = new m();
        this.AT = mVar;
        tVar.c(mVar);
        l lVar = new l();
        this.AU = lVar;
        tVar.c(lVar);
        List<AdTemplate> list = this.AW;
        if (list != null) {
            this.AU.g(list);
            this.AW = null;
        }
        y yVar = new y(bVar);
        yVar.a(this);
        tVar.c(yVar);
        n nVar = new n();
        this.AV = nVar;
        tVar.c(nVar);
        tVar.c(new r(this.td));
    }
}
