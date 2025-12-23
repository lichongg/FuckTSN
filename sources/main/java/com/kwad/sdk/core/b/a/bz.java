package com.kwad.sdk.core.b.a;

import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class bz implements com.kwad.sdk.core.d<com.kwad.sdk.crash.online.monitor.a.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.crash.online.monitor.a.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.crash.online.monitor.a.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.crash.online.monitor.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.aPW = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("systemFilterList");
        if (optJSONArray != null) {
            for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                aVar.aPW.add((String) optJSONArray.opt(i6));
            }
        }
        aVar.aPX = new ArrayList();
        JSONArray optJSONArray2 = jSONObject.optJSONArray("sdkFilterList");
        if (optJSONArray2 != null) {
            for (int i7 = 0; i7 < optJSONArray2.length(); i7++) {
                aVar.aPX.add((String) optJSONArray2.opt(i7));
            }
        }
        aVar.aPY = new ArrayList();
        JSONArray optJSONArray3 = jSONObject.optJSONArray("matrixPrinterNameList");
        if (optJSONArray3 != null) {
            for (int i8 = 0; i8 < optJSONArray3.length(); i8++) {
                aVar.aPY.add((String) optJSONArray3.opt(i8));
            }
        }
        aVar.aPZ = new ArrayList();
        JSONArray optJSONArray4 = jSONObject.optJSONArray("commonPrinterNameList");
        if (optJSONArray4 != null) {
            for (int i9 = 0; i9 < optJSONArray4.length(); i9++) {
                aVar.aPZ.add((String) optJSONArray4.opt(i9));
            }
        }
        aVar.aQa = new ArrayList();
        JSONArray optJSONArray5 = jSONObject.optJSONArray("featureConfigList");
        if (optJSONArray5 != null) {
            for (int i10 = 0; i10 < optJSONArray5.length(); i10++) {
                com.kwad.sdk.crash.online.monitor.a.b bVar = new com.kwad.sdk.crash.online.monitor.a.b();
                bVar.parseJson(optJSONArray5.optJSONObject(i10));
                aVar.aQa.add(bVar);
            }
        }
        aVar.aQc = jSONObject.optInt("afterFilterSystemCheckNum", new Integer("5").intValue());
        aVar.aQd = jSONObject.optInt("batchNum", new Integer(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ).intValue());
        aVar.avY = jSONObject.optDouble("ratio", new Double("0.01").doubleValue());
        aVar.aQe = jSONObject.optInt("monitorSwitch");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.crash.online.monitor.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "systemFilterList", aVar.aPW);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "sdkFilterList", aVar.aPX);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "matrixPrinterNameList", aVar.aPY);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "commonPrinterNameList", aVar.aPZ);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "featureConfigList", aVar.aQa);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "afterFilterSystemCheckNum", aVar.aQc);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "batchNum", aVar.aQd);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "ratio", aVar.avY);
        int i6 = aVar.aQe;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "monitorSwitch", i6);
        }
        return jSONObject;
    }
}
