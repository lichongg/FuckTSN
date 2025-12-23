package com.kwad.sdk.core.request.model;

import android.content.Context;
import android.text.TextUtils;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.components.p;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.am;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.br;
import com.kwad.sdk.utils.m;
import com.kwad.sdk.utils.s;
import org.json.JSONArray;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KsJson
/* loaded from: D:\Downloads\app\classes6.dex */
public class b extends com.kwad.sdk.core.response.a.a {
    private static boolean aIb;
    private static JSONArray aIc;
    public String LM;
    public String LN;
    public String LO;
    public String LP;
    public String LQ;
    public int Qv;
    public int Qw;
    public String aCk;
    public String aCl;
    public String aId;
    public String aIe;
    public String aIf;
    public String aIg;
    public String aIh;
    public int aIi;
    public int aIj;
    public String aIk;
    public String aIl;
    public int aIm;
    public String aIn;
    public String aIo;
    public JSONArray aIp;
    public String aIq;
    public String aIr;
    public String aIt;
    public String aIu;
    public String aIv;

    @Deprecated
    public String aIx;
    public String aIy;
    public int aIz;
    public int adi;
    public int adk;
    public String adl;
    public String uaid;
    public int aIs = 0;
    public long aIw = 0;

    private static boolean BC() {
        return ((h) ServiceProvider.get(h.class)).BC();
    }

    private static boolean BD() {
        return ((h) ServiceProvider.get(h.class)).BD();
    }

    public static b IK() {
        b bVar = new b();
        try {
            bVar.aCl = bd.getOaid();
            bVar.LQ = bd.getDeviceId();
            bVar.LM = br.RT();
            bVar.adi = 1;
            bVar.adk = br.Sg();
            bVar.LO = br.getOsVersion();
            bVar.aIo = ag.Qz();
            if (ag.QC()) {
                bVar.aIq = ag.QB();
            }
            if (ag.QD() && !TextUtils.isEmpty(ag.QA())) {
                bVar.uaid = ag.QA();
            }
            com.kwad.sdk.components.h hVar = (com.kwad.sdk.components.h) com.kwad.sdk.components.d.f(com.kwad.sdk.components.h.class);
            if (hVar != null) {
                bVar.aIn = hVar.qd();
            }
            if (((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)) != null) {
                bVar.aCk = bd.m125do(ServiceProvider.Pp());
            }
            return bVar;
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
            return bVar;
        }
    }

    private static String a(com.kwad.sdk.service.a.f fVar, b bVar, Context context) {
        StringBuilder sb = new StringBuilder("i=");
        sb.append(fVar.getAppId());
        sb.append(",n=");
        sb.append(fVar.getAppName());
        sb.append(",external:");
        sb.append(fVar.Bk());
        sb.append(",v1:");
        sb.append(fVar.getApiVersion());
        sb.append(",v2:4.6.30.1");
        sb.append(",d:");
        sb.append(bVar.LQ);
        sb.append(",dh:");
        String str = bVar.LQ;
        sb.append(str != null ? Integer.valueOf(str.hashCode()) : "");
        sb.append(",b:214");
        sb.append(",p:");
        sb.append(ay.isInMainProcess(context));
        sb.append(",dy:");
        sb.append(com.kwad.framework.a.a.akY);
        String sb2 = sb.toString();
        if (BD()) {
            return sb2;
        }
        return sb2 + ",o:" + bVar.aCl;
    }

    private static synchronized JSONArray bF(Context context) {
        synchronized (b.class) {
            try {
                if (!aIb) {
                    aIb = true;
                    p pVar = (p) com.kwad.sdk.components.d.f(p.class);
                    com.kwad.sdk.core.d.c.d("DeviceInfo", "getAppList: OptDataFetchComponent: " + pVar);
                    if (pVar != null && s.PW()) {
                        pVar.a(context, new com.kwad.sdk.g.a<JSONArray>() { // from class: com.kwad.sdk.core.request.model.b.1
                            @Override // com.kwad.sdk.g.a
                            public final /* synthetic */ void accept(JSONArray jSONArray) {
                                g(jSONArray);
                            }

                            private static void g(JSONArray jSONArray) {
                                JSONArray unused = b.aIc = jSONArray;
                            }
                        });
                    }
                }
                JSONArray jSONArray = aIc;
                if (jSONArray == null) {
                    return null;
                }
                aIc = null;
                return jSONArray;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static b h(boolean z5, int i6) {
        b bVar = new b();
        try {
            Context Pp = ServiceProvider.Pp();
            bVar.aCk = bd.m125do(Pp);
            bVar.aId = bd.dr(Pp);
            bVar.aIe = bd.ds(Pp);
            bVar.aIf = br.dU(Pp);
            bVar.aCl = bd.getOaid();
            bVar.LM = br.RT();
            bVar.LN = br.RV();
            bVar.adi = 1;
            bVar.adk = br.Sg();
            bVar.LO = br.getOsVersion();
            bVar.adl = m.getLanguage();
            bVar.Qv = m.getScreenHeight(Pp);
            bVar.Qw = m.getScreenWidth(Pp);
            bVar.aIi = m.cI(Pp);
            bVar.aIj = m.cJ(Pp);
            bVar.aIk = bd.dp(Pp);
            if (z5) {
                bVar.aIp = bF(Pp);
            }
            bVar.aIz = ((h) ServiceProvider.get(h.class)).Ca();
            bVar.aIr = br.Sf();
            if (ag.QC()) {
                bVar.aIq = ag.QB();
            }
            if (ag.QD() && !TextUtils.isEmpty(ag.QA())) {
                bVar.uaid = ag.QA();
            }
            bVar.LQ = bd.getDeviceId();
            bVar.aIw = br.RU();
            bVar.aIl = br.Sd();
            bVar.aIo = ag.Qz();
            com.kwad.sdk.components.h hVar = (com.kwad.sdk.components.h) com.kwad.sdk.components.d.f(com.kwad.sdk.components.h.class);
            if (hVar != null) {
                bVar.aIn = hVar.qd();
            }
            bVar.aIm = br.Se();
            try {
                com.kwad.sdk.core.d.c.T("DeviceInfo", a((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class), bVar, Pp));
            } catch (Exception unused) {
            }
            bVar.aIr = br.Sf();
            bVar.aIs = i6;
            if (BC() && com.kwad.sdk.app.b.Dw() != null) {
                bVar.aIt = com.kwad.sdk.app.b.Dw().getVersion(Pp, "com.smile.gifmaker");
                bVar.aIu = com.kwad.sdk.app.b.Dw().getVersion(Pp, "com.kuaishou.nebula");
                bVar.aIv = com.kwad.sdk.app.b.Dw().getVersion(Pp, "com.tencent.mm");
            }
            bVar.LP = br.Sb();
            bVar.aIh = am.dc(Pp);
            bVar.aIy = br.hz("/data/data");
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
        return bVar;
    }
}
