package com.yxcorp.kuaishou.addfp.android.b;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
class c {

    /* renamed from: a, reason: collision with root package name */
    boolean f42928a;

    /* renamed from: b, reason: collision with root package name */
    int f42929b;

    /* renamed from: c, reason: collision with root package name */
    boolean f42930c;

    /* renamed from: d, reason: collision with root package name */
    String f42931d;

    public String a(boolean z5) {
        if (!this.f42928a) {
            return "KWE_OTHER";
        }
        if (z5 != this.f42930c) {
            return "KWE_NPN";
        }
        int i6 = this.f42929b;
        return i6 != 0 ? i6 != 1 ? i6 != 2 ? i6 != 3 ? i6 != 4 ? "KWE_OTHER" : "KWE_NS" : "KWE_N" : "KWE_PE" : "KWE_PN" : !TextUtils.isEmpty(this.f42931d) ? this.f42931d : "KWE_N";
    }

    c(String str) {
        this.f42928a = true;
        if (TextUtils.isEmpty(str)) {
            this.f42928a = false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f42929b = jSONObject.optInt("errorCode", 2);
            this.f42930c = jSONObject.optBoolean("userSet", true);
            this.f42931d = jSONObject.optString("value", "KWE_OTHER");
        } catch (JSONException e6) {
            this.f42928a = false;
            e6.printStackTrace();
        }
    }
}
