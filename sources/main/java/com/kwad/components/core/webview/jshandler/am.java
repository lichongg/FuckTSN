package com.kwad.components.core.webview.jshandler;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bp;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class am implements com.kwad.sdk.core.webview.c.a {
    private final com.kwad.sdk.core.webview.b acw;
    private int adC = 0;
    private a adD;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void onAdShow();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class b extends com.kwad.sdk.core.report.a implements com.kwad.sdk.core.b {
        private String NN;
        private String Pj;
        private int actionType;
        private int adE;
        private AdTemplate adTemplate;

        public final int getActionType() {
            return this.actionType;
        }

        public final String os() {
            return this.NN;
        }

        @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.actionType = jSONObject.optInt("actionType");
            this.adE = jSONObject.optInt("refreshType");
            this.Pj = jSONObject.optString("payload");
            this.NN = jSONObject.optString("creativeId");
            try {
                if (jSONObject.has("adTemplate")) {
                    String string = jSONObject.getString("adTemplate");
                    if (this.adTemplate == null) {
                        this.adTemplate = new AdTemplate();
                    }
                    this.adTemplate.parseJson(new JSONObject(string));
                }
            } catch (Exception e6) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(e6);
            }
            if (this.adTemplate == null && jSONObject.has("adCacheId")) {
                this.adTemplate = com.kwad.sdk.core.response.b.c.a(com.kwad.components.core.o.a.e.a.a.aI(jSONObject.optInt("adCacheId")), this.NN);
            }
        }

        @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.aa.putValue(jSONObject, "actionType", this.actionType);
            com.kwad.sdk.utils.aa.putValue(jSONObject, "payload", this.Pj);
            com.kwad.sdk.utils.aa.putValue(jSONObject, "refreshType", this.adE);
            com.kwad.sdk.utils.aa.a(jSONObject, "adTemplate", this.adTemplate);
            com.kwad.sdk.utils.aa.putValue(jSONObject, "creativeId", this.NN);
            return jSONObject;
        }

        public final String uD() {
            return this.Pj;
        }
    }

    protected void a(com.kwad.sdk.core.adlog.c.b bVar) {
    }

    public final void a(a aVar) {
        this.adD = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "log";
    }

    public am(com.kwad.sdk.core.webview.b bVar) {
        this.acw = bVar;
    }

    private AdTemplate c(@NonNull b bVar) {
        if (bVar.adTemplate != null) {
            return bVar.adTemplate;
        }
        return this.acw.dk(bVar.NN);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        try {
            b bVar = new b();
            bVar.parseJson(new JSONObject(str));
            if (c(bVar) == null) {
                cVar.onError(-1, "native adTemplate is null");
            }
            a(bVar);
            cVar.a(null);
        } catch (JSONException e6) {
            com.kwad.sdk.core.d.c.printStackTrace(e6);
            cVar.onError(-1, e6.getMessage());
        }
    }

    protected void b(boolean z5, AdTemplate adTemplate, @Nullable JSONObject jSONObject, @Nullable com.kwad.sdk.core.adlog.c.b bVar) {
        com.kwad.components.core.t.b.sY().a(adTemplate, null, bVar);
    }

    @SuppressLint({"SwitchIntDef"})
    protected void a(@NonNull b bVar) {
        com.kwad.sdk.core.d.c.d("WebCardLogHandler", "handleH5Log actionType actionType" + bVar.actionType);
        if (bVar.actionType == 1) {
            com.kwad.sdk.core.adlog.c.b ds = new com.kwad.sdk.core.adlog.c.b().ds(bVar.Pj);
            a aVar = this.adD;
            if (aVar != null) {
                aVar.onAdShow();
            }
            if (bVar.adTemplate != null) {
                ds.dh(this.adC);
                b(true, bVar.adTemplate, null, ds);
                return;
            }
            if (bp.isNullString(bVar.os())) {
                b(true, this.acw.getAdTemplate(), null, ds);
                return;
            }
            if (this.acw.KI() != null) {
                for (AdTemplate adTemplate : this.acw.KI()) {
                    if (bp.isEquals(bVar.os(), String.valueOf(com.kwad.sdk.core.response.b.e.ev(adTemplate)))) {
                        b(false, adTemplate, null, ds);
                        return;
                    }
                }
                return;
            }
            return;
        }
        if (bVar.actionType != 2) {
            if (bVar.actionType == 12006) {
                com.kwad.components.core.p.a.se().f(c(bVar), bVar.adE, this.adC);
                return;
            }
            if (bVar.actionType != 140) {
                if (bVar.actionType == 141) {
                    com.kwad.sdk.core.adlog.c.e(c(bVar), this.acw.mReportExtData, new com.kwad.sdk.core.adlog.c.b().ds(bVar.Pj));
                    return;
                } else {
                    com.kwad.sdk.core.adlog.c.a(c(bVar), bVar.actionType, this.acw.mReportExtData, bVar.Pj);
                    com.kwad.components.core.webview.tachikoma.e.a.vI().bi(bVar.Pj);
                    return;
                }
            }
            com.kwad.sdk.core.adlog.c.d(c(bVar), this.acw.mReportExtData, new com.kwad.sdk.core.adlog.c.b().ds(bVar.Pj));
            return;
        }
        com.kwad.sdk.widget.g gVar = this.acw.aMN;
        com.kwad.sdk.core.adlog.c.b ds2 = new com.kwad.sdk.core.adlog.c.b().dh(this.adC).ds(bVar.Pj);
        if (gVar != null) {
            ds2.f(gVar.getTouchCoords());
        }
        a(ds2);
        com.kwad.sdk.core.adlog.c.a(c(bVar), ds2, this.acw.mReportExtData);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }
}
