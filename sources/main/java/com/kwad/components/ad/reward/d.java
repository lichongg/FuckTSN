package com.kwad.components.ad.reward;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.kwad.components.core.webview.jshandler.az;
import com.kwad.components.core.webview.jshandler.y;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class d extends com.kwad.components.ad.l.b {
    private List<AdTemplate> rv;
    private boolean rw;

    /* renamed from: rx, reason: collision with root package name */
    private List<com.kwad.components.core.e.d.c> f36342rx;
    private y.b ry;

    public d(List<AdTemplate> list, @Nullable JSONObject jSONObject, y.b bVar) {
        super(jSONObject, null);
        this.rw = false;
        this.f36342rx = new ArrayList();
        this.rv = list;
        this.ry = bVar;
        if (list == null || list.size() <= 0) {
            return;
        }
        Iterator<AdTemplate> it = this.rv.iterator();
        while (it.hasNext()) {
            this.f36342rx.add(new com.kwad.components.core.e.d.c(it.next()));
        }
    }

    @Override // com.kwad.components.ad.l.b
    public final void a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, AdTemplate adTemplate, com.kwad.components.core.e.d.c cVar, int i6) {
        super.a(frameLayout, adBaseFrameLayout, this.rv, this.f36342rx);
    }

    @Override // com.kwad.components.ad.l.b
    public final boolean gt() {
        return false;
    }

    @Override // com.kwad.components.ad.l.b
    public final void gv() {
        com.kwad.components.ad.reward.monitor.c.a(true, "middle_play_end_card");
    }

    @Override // com.kwad.components.ad.l.b
    public final String K(AdTemplate adTemplate) {
        List<AdTemplate> list = this.rv;
        return (list == null || list.size() < 2) ? super.K(adTemplate) : com.kwad.sdk.core.response.b.b.cA(this.rv.get(1));
    }

    @Override // com.kwad.components.ad.l.b
    public final void a(com.kwad.components.core.webview.a aVar) {
        super.a(aVar);
        List<AdTemplate> list = this.rv;
        y yVar = new y(new ArrayList(list.subList(1, list.size() - 1)));
        yVar.a(this.ry);
        aVar.a(yVar);
    }

    @Override // com.kwad.components.ad.l.b
    public final void b(com.kwad.sdk.core.webview.b bVar) {
        bVar.setAdTemplateList(this.rv);
    }

    @Override // com.kwad.components.ad.l.b
    public final boolean cH() {
        return this.rw ? this.Mn : super.cH();
    }

    @Override // com.kwad.components.ad.l.b
    public final String getName() {
        return "MiddlePlayEndCard";
    }

    public final void gu() {
        az azVar = this.eS;
        if (azVar != null) {
            azVar.uG();
        }
    }

    @Override // com.kwad.components.ad.l.b
    public final void gw() {
        AdTemplate adTemplate = this.mAdTemplate;
        com.kwad.components.ad.reward.monitor.c.a(adTemplate, true, "middle_play_end_card", K(adTemplate));
    }

    @Override // com.kwad.components.ad.l.b
    public final void gx() {
        com.kwad.components.ad.reward.monitor.c.a(true, "middle_play_end_card", K(this.mAdTemplate), System.currentTimeMillis() - getLoadTime());
    }

    public final void setShowLandingPage(boolean z5) {
        this.rw = z5;
    }

    @Override // com.kwad.components.ad.l.b
    @SuppressLint({"ClickableViewAccessibility"})
    public final void gs() {
        super.gs();
        this.eN.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.components.ad.reward.d.1
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    return true;
                }
                return false;
            }
        });
    }
}
