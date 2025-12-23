package com.bytedance.embedapplog;

import android.text.TextUtils;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
final class na {
    final Long ae;
    final Boolean cw;

    /* renamed from: j, reason: collision with root package name */
    final String f24014j;

    /* renamed from: m, reason: collision with root package name */
    final Integer f24015m;

    /* renamed from: r, reason: collision with root package name */
    final Long f24016r;
    final Long up;
    final String xt;

    @NonNull
    Map<String, String> j() {
        HashMap hashMap = new HashMap();
        wi.j(hashMap, "id", this.f24014j);
        wi.j(hashMap, "req_id", this.xt);
        wi.j(hashMap, "is_track_limited", String.valueOf(this.cw));
        wi.j(hashMap, "take_ms", String.valueOf(this.f24016r));
        wi.j(hashMap, "time", String.valueOf(this.up));
        wi.j(hashMap, "query_times", String.valueOf(this.f24015m));
        wi.j(hashMap, "hw_id_version_code", String.valueOf(this.ae));
        return hashMap;
    }

    @NonNull
    JSONObject xt() {
        JSONObject jSONObject = new JSONObject();
        wi.j(jSONObject, "id", this.f24014j);
        wi.j(jSONObject, "req_id", this.xt);
        wi.j(jSONObject, "is_track_limited", this.cw);
        wi.j(jSONObject, "take_ms", this.f24016r);
        wi.j(jSONObject, "time", this.up);
        wi.j(jSONObject, "query_times", this.f24015m);
        wi.j(jSONObject, "hw_id_version_code", this.ae);
        return jSONObject;
    }

    na(String str, String str2, Boolean bool, Long l6, Long l7, Integer num, Long l8) {
        this.f24014j = str;
        this.xt = str2;
        this.cw = bool;
        this.f24016r = l6;
        this.up = l7;
        this.f24015m = num;
        this.ae = l8;
    }

    public String toString() {
        return xt().toString();
    }

    @Nullable
    @AnyThread
    static na j(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new na(jSONObject.optString("id", null), jSONObject.optString("req_id", null), jSONObject.has("is_track_limited") ? Boolean.valueOf(jSONObject.optBoolean("is_track_limited")) : null, jSONObject.has("take_ms") ? Long.valueOf(jSONObject.optLong("take_ms", -1L)) : null, jSONObject.has("time") ? Long.valueOf(jSONObject.optLong("time", -1L)) : null, jSONObject.has("query_times") ? Integer.valueOf(jSONObject.optInt("query_times", -1)) : null, jSONObject.has("hw_id_version_code") ? Long.valueOf(jSONObject.optLong("hw_id_version_code", -1L)) : null);
        } catch (JSONException e6) {
            uc.j(e6);
            return null;
        }
    }
}
