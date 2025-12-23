package com.kwad.sdk.core.b.a;

import com.kwad.sdk.crash.model.message.AnrReason;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class bh implements com.kwad.sdk.core.d<AnrReason> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AnrReason anrReason, JSONObject jSONObject) {
        a2(anrReason, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AnrReason anrReason, JSONObject jSONObject) {
        return b2(anrReason, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(AnrReason anrReason, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        anrReason.mTag = jSONObject.optString("mTag");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(anrReason.mTag)) {
            anrReason.mTag = "";
        }
        anrReason.mShortMsg = jSONObject.optString("mShortMsg");
        if (obj.toString().equals(anrReason.mShortMsg)) {
            anrReason.mShortMsg = "";
        }
        anrReason.mLongMsg = jSONObject.optString("mLongMsg");
        if (obj.toString().equals(anrReason.mLongMsg)) {
            anrReason.mLongMsg = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(AnrReason anrReason, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = anrReason.mTag;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mTag", anrReason.mTag);
        }
        String str2 = anrReason.mShortMsg;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mShortMsg", anrReason.mShortMsg);
        }
        String str3 = anrReason.mLongMsg;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "mLongMsg", anrReason.mLongMsg);
        }
        return jSONObject;
    }
}
