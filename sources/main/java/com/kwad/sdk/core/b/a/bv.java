package com.kwad.sdk.core.b.a;

import com.kwad.sdk.crash.message.BackTraceElement;
import com.kwad.sdk.crash.message.Backtrace;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class bv implements com.kwad.sdk.core.d<Backtrace> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(Backtrace backtrace, JSONObject jSONObject) {
        a2(backtrace, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(Backtrace backtrace, JSONObject jSONObject) {
        return b2(backtrace, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(Backtrace backtrace, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        backtrace.mBacktraces = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("mBacktraces");
        if (optJSONArray != null) {
            for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                BackTraceElement backTraceElement = new BackTraceElement();
                backTraceElement.parseJson(optJSONArray.optJSONObject(i6));
                backtrace.mBacktraces.add(backTraceElement);
            }
        }
        backtrace.mFrame = jSONObject.optInt("mFrame");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(Backtrace backtrace, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "mBacktraces", backtrace.mBacktraces);
        int i6 = backtrace.mFrame;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mFrame", i6);
        }
        return jSONObject;
    }
}
