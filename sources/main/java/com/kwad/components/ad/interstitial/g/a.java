package com.kwad.components.ad.interstitial.g;

import android.app.Activity;
import android.content.DialogInterface;
import com.alibaba.fastjson.asm.Opcodes;
import com.kwad.components.ad.interstitial.d;
import com.kwad.components.ad.interstitial.f.c;
import com.kwad.components.core.page.widget.a;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a {
    public static boolean d(final c cVar) {
        Activity ownerActivity;
        d dVar = cVar.kW;
        if (dVar != null && (ownerActivity = dVar.getOwnerActivity()) != null && !ownerActivity.isFinishing()) {
            AdInfo el = e.el(cVar.mAdTemplate);
            int dO = com.kwad.components.ad.interstitial.c.b.dO();
            int dP = com.kwad.components.ad.interstitial.c.b.dP();
            if (dO > com.kwad.sdk.core.response.b.a.cw(el) && dP < com.kwad.sdk.core.response.b.a.cx(el)) {
                if (com.kwad.sdk.core.response.b.a.cy(el) == 2) {
                    com.kwad.components.ad.interstitial.h.b.e(cVar);
                    return true;
                }
                if (com.kwad.sdk.core.response.b.a.cy(el) == 1) {
                    new com.kwad.components.core.page.widget.a(ownerActivity, com.kwad.sdk.core.response.b.a.cz(el), new a.InterfaceC0631a() { // from class: com.kwad.components.ad.interstitial.g.a.1
                        @Override // com.kwad.components.core.page.widget.a.InterfaceC0631a
                        public final void b(DialogInterface dialogInterface) {
                            c cVar2 = c.this;
                            cVar2.a(false, -1, cVar2.cq);
                            dialogInterface.dismiss();
                            com.kwad.sdk.core.adlog.c.e(c.this.mAdTemplate, null, new com.kwad.sdk.core.adlog.c.b().df(151).dk(8));
                            c.this.kW.dismiss();
                        }

                        @Override // com.kwad.components.core.page.widget.a.InterfaceC0631a
                        public final void a(DialogInterface dialogInterface) {
                            dialogInterface.dismiss();
                            com.kwad.sdk.core.adlog.c.c(c.this.mAdTemplate, (JSONObject) null, new com.kwad.sdk.core.adlog.c.b().dk(8));
                        }

                        @Override // com.kwad.components.core.page.widget.a.InterfaceC0631a
                        public final void c(DialogInterface dialogInterface) {
                        }
                    }).show();
                    com.kwad.sdk.core.adlog.c.d(cVar.mAdTemplate, new JSONObject(), new com.kwad.sdk.core.adlog.c.b().df(Opcodes.FCMPL).dk(8));
                    return true;
                }
            }
        }
        return false;
    }
}
