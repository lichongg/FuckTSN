package com.kwad.sdk.core.b.a;

import com.kwad.sdk.crash.online.monitor.block.BlockEvent;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class ca implements com.kwad.sdk.core.d<BlockEvent> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(BlockEvent blockEvent, JSONObject jSONObject) {
        a2(blockEvent, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(BlockEvent blockEvent, JSONObject jSONObject) {
        return b2(blockEvent, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(BlockEvent blockEvent, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        blockEvent.blockDuration = jSONObject.optLong("blockDuration");
        blockEvent.blockTimeThreshold = jSONObject.optLong("blockTimeThreshold", new Long(Constants.DEFAULT_UIN).longValue());
        blockEvent.blockLoopInterval = jSONObject.optLong("blockLoopInterval", new Long("100").longValue());
        blockEvent.calcBlockOverhead = jSONObject.optLong("calcBlockOverhead");
        blockEvent.currentActivity = jSONObject.optString("currentActivity");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(blockEvent.currentActivity)) {
            blockEvent.currentActivity = "";
        }
        blockEvent.processName = jSONObject.optString("processName");
        if (obj.toString().equals(blockEvent.processName)) {
            blockEvent.processName = "";
        }
        blockEvent.stackTraceSample = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("stackTraceSample");
        if (optJSONArray != null) {
            for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                BlockEvent.a aVar = new BlockEvent.a();
                aVar.parseJson(optJSONArray.optJSONObject(i6));
                blockEvent.stackTraceSample.add(aVar);
            }
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(BlockEvent blockEvent, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j6 = blockEvent.blockDuration;
        if (j6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "blockDuration", j6);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "blockTimeThreshold", blockEvent.blockTimeThreshold);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "blockLoopInterval", blockEvent.blockLoopInterval);
        long j7 = blockEvent.calcBlockOverhead;
        if (j7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "calcBlockOverhead", j7);
        }
        String str = blockEvent.currentActivity;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "currentActivity", blockEvent.currentActivity);
        }
        String str2 = blockEvent.processName;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "processName", blockEvent.processName);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "stackTraceSample", blockEvent.stackTraceSample);
        return jSONObject;
    }
}
