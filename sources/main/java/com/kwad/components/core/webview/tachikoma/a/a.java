package com.kwad.components.core.webview.tachikoma.a;

import android.content.DialogInterface;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.e.d.a;
import com.kwad.sdk.components.m;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.TKAdLiveShopItemInfo;
import com.kwad.sdk.utils.aj;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a implements m {

    @Nullable
    private DialogInterface.OnDismissListener AX;
    private int acI;
    private boolean acJ;
    private final boolean acK;
    private boolean acL;
    private List<com.kwad.components.core.e.d.c> acM;
    private boolean acN;
    protected final com.kwad.sdk.core.webview.b acw;

    @Nullable
    private com.kwad.sdk.core.webview.d.a.a eT;

    private a(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.e.d.c cVar, @Nullable com.kwad.sdk.core.webview.d.a.a aVar, boolean z5, int i6, boolean z6, boolean z7) {
        this.acJ = false;
        this.acM = new ArrayList();
        this.acJ = false;
        this.acw = bVar;
        this.acI = 0;
        if (cVar != null) {
            cVar.aG(1);
            this.acM.add(cVar);
        }
        this.eT = aVar;
        this.acK = false;
        this.acN = false;
    }

    static /* synthetic */ boolean a(a aVar, com.kwad.sdk.core.webview.d.b.a aVar2) {
        return b(aVar2);
    }

    private static boolean b(com.kwad.sdk.core.webview.d.b.a aVar) {
        return aVar.adN == 1;
    }

    @Nullable
    protected final com.kwad.components.core.e.d.c Q(long j6) {
        List<com.kwad.components.core.e.d.c> list = this.acM;
        if (list == null) {
            return null;
        }
        if (j6 < 0 && list.size() == 1) {
            return this.acM.get(0);
        }
        for (com.kwad.components.core.e.d.c cVar : this.acM) {
            if (com.kwad.sdk.core.response.b.e.ev(cVar.pH()) == j6) {
                return cVar;
            }
        }
        return null;
    }

    @Override // com.kwad.sdk.components.m
    public final Object call(@Nullable Object... objArr) {
        final com.kwad.sdk.core.webview.d.b.a aVar = new com.kwad.sdk.core.webview.d.b.a();
        if (objArr != null) {
            try {
                if (objArr.length > 0) {
                    Object obj = objArr[0];
                    if (obj instanceof String) {
                        aVar.parseJson(new JSONObject((String) obj));
                    }
                }
            } catch (JSONException e6) {
                com.kwad.sdk.core.d.c.printStackTrace(e6);
            }
        }
        if (this.acw.KJ() && aVar.adTemplate == null) {
            return null;
        }
        if (this.acw.aMP && !aVar.aNQ) {
            bw.runOnUiThread(new bg() { // from class: com.kwad.components.core.webview.tachikoma.a.a.1
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    String str;
                    TKAdLiveShopItemInfo tKAdLiveShopItemInfo;
                    com.kwad.sdk.core.webview.b bVar = a.this.acw;
                    if (bVar.aMQ) {
                        com.kwad.sdk.core.webview.d.b.a aVar2 = aVar;
                        AdTemplate adTemplate = aVar2.adTemplate;
                        if (adTemplate != null) {
                            a.this.acM.add(new com.kwad.components.core.e.d.c(adTemplate));
                        } else if (aVar2.creativeId >= 0) {
                            List<AdTemplate> KI = bVar.KI();
                            com.kwad.sdk.core.webview.d.b.a aVar3 = aVar;
                            adTemplate = com.kwad.sdk.core.response.b.e.a(KI, aVar3.creativeId, aVar3.adStyle);
                        } else {
                            adTemplate = bVar.getAdTemplate();
                            aVar.creativeId = com.kwad.sdk.core.response.b.e.ev(adTemplate);
                            aVar.adStyle = com.kwad.sdk.core.response.b.e.eg(adTemplate);
                        }
                        com.kwad.components.core.e.d.c Q = a.this.Q(aVar.creativeId);
                        if (a.this.AX != null && Q != null) {
                            Q.setOnDismissListener(a.this.AX);
                        }
                        if (TextUtils.isEmpty(aVar.Pv)) {
                            str = (adTemplate == null || (tKAdLiveShopItemInfo = adTemplate.tkLiveShopItemInfo) == null) ? null : tKAdLiveShopItemInfo.itemId;
                        } else {
                            try {
                                str = com.kwad.components.core.e.b.a.y(Long.parseLong(aVar.Pv));
                            } catch (Exception unused) {
                                str = aVar.Pv;
                            }
                        }
                        com.kwad.components.core.e.d.a.a(a.this.a(new a.C0616a(a.this.acw.TG.getContext()).aB(adTemplate).b(Q).al(str).aq(a.a(a.this, aVar)).ar(a.this.acJ).c(a.this.acw.mReportExtData).aB(aVar.adN).az(aVar.aNP).aA(aVar.mI).as(a.this.acK || aVar.Ph).aF(a.this.acI).an(a.this.acN).au(a.this.acL).ay(true).a(new a.b() { // from class: com.kwad.components.core.webview.tachikoma.a.a.1.1
                            @Override // com.kwad.components.core.e.d.a.b
                            public final void onAdClicked() {
                                if (a.this.eT != null) {
                                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                    if (aVar.aNR) {
                                        return;
                                    }
                                    a.this.eT.a(aVar);
                                }
                            }
                        }), aVar, adTemplate));
                    }
                }
            });
        } else if (this.eT != null) {
            bw.postOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.a.a.2
                @Override // java.lang.Runnable
                public final void run() {
                    if (a.this.eT == null || aVar.aNR) {
                        return;
                    }
                    a.this.eT.a(aVar);
                }
            });
        }
        return null;
    }

    protected final a.C0616a a(a.C0616a c0616a, com.kwad.sdk.core.webview.d.b.a aVar, AdTemplate adTemplate) {
        com.kwad.sdk.core.webview.d.b.d dVar;
        int i6;
        com.kwad.sdk.core.webview.d.b.d dVar2 = aVar.adO;
        if (dVar2 != null && !TextUtils.isEmpty(dVar2.Pj)) {
            c0616a.am(aVar.adO.Pj);
        }
        com.kwad.sdk.core.webview.d.b.d dVar3 = aVar.adO;
        if (dVar3 != null && (i6 = dVar3.aha) != 0) {
            c0616a.aD(i6);
        }
        if (com.kwad.sdk.core.response.b.e.eE(adTemplate) && (dVar = aVar.adO) != null && dVar.aNT != null) {
            aj.a aVar2 = new aj.a();
            com.kwad.sdk.core.webview.d.b.c cVar = aVar.adO.aNT;
            aVar2.f((float) cVar.f36350x, (float) cVar.f36351y);
            com.kwad.sdk.core.webview.d.b.c cVar2 = aVar.adO.aNT;
            aVar2.e((float) cVar2.f36350x, (float) cVar2.f36351y);
            com.kwad.sdk.core.webview.d.b.c cVar3 = aVar.adO.aNT;
            aVar2.B(cVar3.width, cVar3.height);
            c0616a.d(aVar2);
        } else {
            com.kwad.sdk.widget.g gVar = this.acw.aMN;
            if (gVar != null) {
                c0616a.d(gVar.getTouchCoords());
            }
        }
        c0616a.a(null, null, null);
        return c0616a;
    }

    public a(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.e.d.c cVar, @Nullable com.kwad.sdk.core.webview.d.a.a aVar, boolean z5) {
        this(bVar, cVar, aVar, false, 0, false, false);
        this.acL = true;
    }
}
