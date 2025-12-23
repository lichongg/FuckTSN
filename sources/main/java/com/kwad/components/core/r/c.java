package com.kwad.components.core.r;

import androidx.annotation.NonNull;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.c.x;
import com.kwad.components.core.webview.tachikoma.d;
import com.kwad.components.core.webview.tachikoma.d.e;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.t;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class c extends com.kwad.components.core.webview.tachikoma.d.c {
    @Override // com.kwad.components.core.webview.tachikoma.d.a, com.kwad.components.core.webview.tachikoma.j
    public final void a(t tVar, com.kwad.sdk.core.webview.b bVar) {
        tVar.c(sN());
    }

    private d sN() {
        return new d() { // from class: com.kwad.components.core.r.c.1
            @Override // com.kwad.components.core.webview.tachikoma.b.w, com.kwad.sdk.core.webview.c.a
            public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
                super.a(str, cVar);
                x xVar = new x();
                xVar.ahm = a.sF().sM() + 1;
                cVar.a(xVar);
            }
        };
    }

    @Override // com.kwad.components.core.webview.tachikoma.d.c, com.kwad.components.core.webview.tachikoma.d.a, com.kwad.components.core.webview.tachikoma.j
    public final void a(WebCloseStatus webCloseStatus) {
        super.a(webCloseStatus);
        if (!webCloseStatus.interactSuccess) {
            this.ahp.mActivity.finish();
            return;
        }
        e eVar = this.ahp.afi;
        if (eVar != null) {
            eVar.dismiss();
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.d.c, com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        super.a(tKRenderFailReason);
    }
}
