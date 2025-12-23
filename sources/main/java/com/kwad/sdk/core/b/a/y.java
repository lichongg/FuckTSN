package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdInfo;
import com.tencent.connect.common.Constants;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class y implements com.kwad.sdk.core.d<AdInfo.AdInsertScreenInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.AdInsertScreenInfo adInsertScreenInfo, JSONObject jSONObject) {
        a2(adInsertScreenInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.AdInsertScreenInfo adInsertScreenInfo, JSONObject jSONObject) {
        return b2(adInsertScreenInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(AdInfo.AdInsertScreenInfo adInsertScreenInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adInsertScreenInfo.cycleAggregateSwitch = jSONObject.optBoolean("cycleAggregateSwitch");
        adInsertScreenInfo.cycleAggregateDailyShowCount = jSONObject.optInt("cycleAggregateDailyShowCount", new Integer(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ).intValue());
        adInsertScreenInfo.cycleAggregateStyle = jSONObject.optInt("cycleAggregateStyle");
        adInsertScreenInfo.cycleAggregateInterval = jSONObject.optInt("cycleAggregateInterval", new Integer(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ).intValue());
        adInsertScreenInfo.autoCloseTime = jSONObject.optInt("autoCloseTime");
        adInsertScreenInfo.retainWindowStyle = jSONObject.optInt("retainWindowStyle");
        adInsertScreenInfo.retainWindowText = jSONObject.optString("retainWindowText");
        if (JSONObject.NULL.toString().equals(adInsertScreenInfo.retainWindowText)) {
            adInsertScreenInfo.retainWindowText = "";
        }
        adInsertScreenInfo.retainWindowBasedAdShowCount = jSONObject.optInt("retainWindowBasedAdShowCount");
        adInsertScreenInfo.retainWindowDailyShowCount = jSONObject.optInt("retainWindowDailyShowCount");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdInfo.AdInsertScreenInfo adInsertScreenInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z5 = adInsertScreenInfo.cycleAggregateSwitch;
        if (z5) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "cycleAggregateSwitch", z5);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "cycleAggregateDailyShowCount", adInsertScreenInfo.cycleAggregateDailyShowCount);
        int i6 = adInsertScreenInfo.cycleAggregateStyle;
        if (i6 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "cycleAggregateStyle", i6);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "cycleAggregateInterval", adInsertScreenInfo.cycleAggregateInterval);
        int i7 = adInsertScreenInfo.autoCloseTime;
        if (i7 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "autoCloseTime", i7);
        }
        int i8 = adInsertScreenInfo.retainWindowStyle;
        if (i8 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "retainWindowStyle", i8);
        }
        String str = adInsertScreenInfo.retainWindowText;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "retainWindowText", adInsertScreenInfo.retainWindowText);
        }
        int i9 = adInsertScreenInfo.retainWindowBasedAdShowCount;
        if (i9 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "retainWindowBasedAdShowCount", i9);
        }
        int i10 = adInsertScreenInfo.retainWindowDailyShowCount;
        if (i10 != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "retainWindowDailyShowCount", i10);
        }
        return jSONObject;
    }
}
