package com.kwad.sdk.core.b.a;

import com.kwad.sdk.crash.online.monitor.block.BlockEvent;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class lk implements com.kwad.sdk.core.d<BlockEvent.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(BlockEvent.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(BlockEvent.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(BlockEvent.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.aPG = jSONObject.optLong("endTimestamp");
        aVar.repeatCount = jSONObject.optInt("repeatCount", new Integer("1").intValue());
        aVar.aPH = jSONObject.optBoolean("runIdle");
        aVar.aPI = jSONObject.optString("stackTraceDetail");
        if (JSONObject.NULL.toString().equals(aVar.aPI)) {
            aVar.aPI = "";
        }
        aVar.aPJ = jSONObject.optLong("startTimestamp");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(BlockEvent.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j6 = aVar.aPG;
        if (j6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "endTimestamp", j6);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "repeatCount", aVar.repeatCount);
        boolean z5 = aVar.aPH;
        if (z5) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "runIdle", z5);
        }
        String str = aVar.aPI;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "stackTraceDetail", aVar.aPI);
        }
        long j7 = aVar.aPJ;
        if (j7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "startTimestamp", j7);
        }
        return jSONObject;
    }
}
