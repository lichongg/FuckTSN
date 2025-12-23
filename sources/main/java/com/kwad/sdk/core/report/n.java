package com.kwad.sdk.core.report;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PageInfo;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aa;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KsJson
/* loaded from: D:\Downloads\app\classes6.dex */
public class n extends e {
    public String Ne;
    public String Nf;
    public long Nh;
    public String Pj;
    public String WH;
    public long WO;
    public long WP;
    public long WQ;
    public long XI;
    public long aDb;
    public long aGE;
    public JSONObject aGF;
    public JSONObject aGG;
    public long aGH;
    public long aGI;
    public long aGJ;
    public long aGK;
    public long aGL;
    public long aGN;
    public URLPackage aGO;
    public String aGP;
    public JSONArray aGQ;
    public JSONArray aGR;
    public a aGS;
    public int aGT;
    public int aGU;
    public int aGV;
    public int aGW;
    public String aGX;
    public int aGY;
    public int aGZ;
    public String aHA;
    public String aHB;
    public String aHC;
    public String aHD;
    public String aHF;
    public String aHG;
    public int aHH;
    public long aHK;
    public long aHL;
    public String aHM;
    public String aHa;
    public JSONObject aHb;
    public JSONArray aHc;
    public int aHd;
    public int aHe;
    public int aHf;
    public JSONArray aHh;
    public boolean aHi;
    public String aHj;
    public long aHm;
    public int aHn;
    public String aHo;
    public long aHp;
    public long aHq;
    public long aHr;
    public long aHs;
    public String aHt;
    public int aHu;
    public JSONArray aHv;
    public long aHw;
    public long aHx;
    public JSONArray aHy;
    public String aHz;
    public long aci;
    public long actionType;
    public int adE;
    public transient SceneImpl adScene;
    public long blockDuration;
    public long clickTime;
    public int contentSourceType;
    public long creativeId;
    public long downloadDuration;
    public String entryPageSource;
    public int errorCode;
    public String errorMsg;
    public long llsid;

    @Nullable
    public transient AdTemplate mAdTemplate;
    public int pageType;
    public long photoId;
    public long posId;
    public long position;
    public String sdkApiVersion;
    public int sdkType;
    public String sessionId;
    public long timestamp;
    public String trace;
    public URLPackage urlPackage;
    public int adStyle = -1;
    public int contentType = 0;
    public int realShowType = 0;
    public long aGM = -1;
    public int aye = 0;
    public long aHg = 0;
    public int aHk = 0;
    public int aHl = -1;
    public int aHE = 0;
    public int aHI = BuildConfig.VERSION_CODE;
    public String sdkVersion = BuildConfig.VERSION_NAME;
    public String aHJ = BuildConfig.VERSION_NAME;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KsJson
    public static final class a extends com.kwad.sdk.core.response.a.a {
        public int aHN;
        public int aHO;

        public static a Ix() {
            a aVar = new a();
            aVar.aHN = b.aHN;
            aVar.aHO = b.aHO;
            return aVar;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class b {
        public static int aHN;
        public static int aHO;
    }

    public n(long j6) {
        this.sdkApiVersion = ServiceProvider.get(com.kwad.sdk.service.a.f.class) == null ? "" : ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getApiVersion();
        this.sdkType = 1;
        this.aHM = "";
        this.actionType = j6;
    }

    private void ck(@Nullable AdTemplate adTemplate) {
        SceneImpl sceneImpl;
        try {
            this.aGU = 3;
            s sVar = (s) ServiceProvider.get(s.class);
            if (sVar != null) {
                this.aHk = sVar.wm();
            }
            this.actionId = UUID.randomUUID().toString();
            this.timestamp = System.currentTimeMillis();
            this.sessionId = t.IC();
            try {
                this.Nh = t.ID();
            } catch (Exception e6) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(e6);
            }
            this.aGE = t.IE();
            SceneImpl sceneImpl2 = this.adScene;
            if (sceneImpl2 != null) {
                this.posId = sceneImpl2.getPosId();
                this.urlPackage = this.adScene.getUrlPackage();
                this.adStyle = this.adScene.getAdStyle();
            } else if (adTemplate != null && (sceneImpl = adTemplate.mAdScene) != null) {
                this.adScene = sceneImpl;
                this.posId = sceneImpl.getPosId();
                this.urlPackage = this.adScene.getUrlPackage();
                this.adStyle = this.adScene.getAdStyle();
            }
            if (adTemplate != null) {
                this.position = adTemplate.getShowPosition() + 1;
                this.aGH = adTemplate.getServerPosition() + 1;
                this.llsid = com.kwad.sdk.core.response.b.e.ei(adTemplate);
                String ej = com.kwad.sdk.core.response.b.e.ej(adTemplate);
                if (!TextUtils.isEmpty(ej)) {
                    try {
                        this.aGF = new JSONObject(ej);
                    } catch (Exception e7) {
                        com.kwad.sdk.core.d.c.printStackTraceOnly(e7);
                    }
                }
                String ek = com.kwad.sdk.core.response.b.e.ek(adTemplate);
                if (!TextUtils.isEmpty(ek)) {
                    try {
                        this.aGG = new JSONObject(ek);
                    } catch (Exception e8) {
                        com.kwad.sdk.core.d.c.printStackTraceOnly(e8);
                    }
                }
                this.posId = com.kwad.sdk.core.response.b.e.ee(adTemplate);
                this.contentType = com.kwad.sdk.core.response.b.e.eh(adTemplate);
                this.realShowType = adTemplate.realShowType;
                this.photoId = com.kwad.sdk.core.response.b.e.er(adTemplate);
                if (this.realShowType == 2) {
                    AdInfo el = com.kwad.sdk.core.response.b.e.el(adTemplate);
                    this.creativeId = el.adBaseInfo.creativeId;
                    this.aGI = com.kwad.sdk.core.response.b.a.L(el) * 1000;
                    this.XI = el.advertiserInfo.userId;
                }
                this.aGT = adTemplate.mMediaPlayerType;
                this.aGV = adTemplate.mIsLeftSlipStatus;
                this.aGW = adTemplate.mPhotoResponseType;
                PageInfo pageInfo = adTemplate.mPageInfo;
                if (pageInfo != null) {
                    this.pageType = pageInfo.pageType;
                }
                this.contentSourceType = com.kwad.sdk.core.response.b.e.es(adTemplate);
            }
            this.aGS = a.Ix();
            if (this.adScene == null && adTemplate != null) {
                this.adScene = adTemplate.mAdScene;
            }
            SceneImpl sceneImpl3 = this.adScene;
            if (sceneImpl3 != null) {
                this.posId = sceneImpl3.getPosId();
                this.urlPackage = this.adScene.getUrlPackage();
            }
        } catch (Exception e9) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e9);
        }
    }

    public final n Iv() {
        ck(this.mAdTemplate);
        return this;
    }

    public final void Iw() {
        com.kwad.sdk.service.a.j jVar = (com.kwad.sdk.service.a.j) ServiceProvider.get(com.kwad.sdk.service.a.j.class);
        this.aHd = jVar.sz() ? 1 : 0;
        this.aHe = jVar.sA();
        this.aHf = jVar.sB();
    }

    @Override // com.kwad.sdk.core.response.a.a
    @NonNull
    public String toString() {
        if (TextUtils.isEmpty(this.aHM)) {
            return super.toString();
        }
        return "ReportAction{actionJSONString=" + this.aHM + '}';
    }

    @Override // com.kwad.sdk.core.report.e, com.kwad.sdk.core.response.a.a
    public void afterParseJson(@Nullable JSONObject jSONObject) {
        super.afterParseJson(jSONObject);
        if (jSONObject != null) {
            this.aGU = 3;
            this.adStyle = jSONObject.optInt("adStyle", -1);
            this.aGZ = jSONObject.optInt("num");
            this.aGY = jSONObject.optInt("state");
            this.aHg = jSONObject.optLong("timeSpend");
            this.aHw = jSONObject.optLong("loadingDuration");
            this.aHx = jSONObject.optLong("loadingDurationLimt");
            this.aHl = jSONObject.optInt("playerTypeInfo", -1);
            if (jSONObject.has("actionId")) {
                this.actionId = jSONObject.optString("actionId");
            }
        }
    }

    @Override // com.kwad.sdk.core.report.e, com.kwad.sdk.core.response.a.a
    public void afterToJson(JSONObject jSONObject) {
        super.afterToJson(jSONObject);
        aa.putValue(jSONObject, "actionId", this.actionId);
        int i6 = this.adStyle;
        if (i6 > 0) {
            aa.putValue(jSONObject, "adStyle", i6);
        }
        int i7 = this.aGZ;
        if (i7 > 0) {
            aa.putValue(jSONObject, "num", i7);
        }
        int i8 = this.aGY;
        if (i8 != 0) {
            aa.putValue(jSONObject, "state", i8);
        }
        long j6 = this.aHg;
        if (j6 > 0) {
            aa.putValue(jSONObject, "timeSpend", j6);
        }
        long j7 = this.aHw;
        if (j7 > 0) {
            aa.putValue(jSONObject, "loadingDuration", j7);
        }
        long j8 = this.aHx;
        if (j8 > 0) {
            aa.putValue(jSONObject, "loadingDurationLimt", j8);
        }
        aa.putValue(jSONObject, "playerTypeInfo", this.aHl);
    }

    public n(long j6, @Nullable AdTemplate adTemplate) {
        this.sdkApiVersion = ServiceProvider.get(com.kwad.sdk.service.a.f.class) == null ? "" : ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getApiVersion();
        this.sdkType = 1;
        this.aHM = "";
        this.actionType = j6;
        this.mAdTemplate = adTemplate;
    }

    public n(long j6, @Nullable AdTemplate adTemplate, String str) {
        this.sdkApiVersion = ServiceProvider.get(com.kwad.sdk.service.a.f.class) == null ? "" : ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getApiVersion();
        this.sdkType = 1;
        this.aHM = "";
        this.actionType = j6;
        this.mAdTemplate = adTemplate;
        this.Pj = str;
    }

    public n(String str, String str2, boolean z5) {
        String apiVersion;
        if (ServiceProvider.get(com.kwad.sdk.service.a.f.class) != null) {
            apiVersion = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getApiVersion();
        } else {
            apiVersion = "";
        }
        this.sdkApiVersion = apiVersion;
        this.sdkType = 1;
        this.actionId = str;
        this.aHM = str2;
    }
}
