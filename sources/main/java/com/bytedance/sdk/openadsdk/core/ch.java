package com.bytedance.sdk.openadsdk.core;

import android.os.SystemClock;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class ch {
    private long cw;

    /* renamed from: j, reason: collision with root package name */
    private String f28006j;

    /* renamed from: r, reason: collision with root package name */
    private Map<String, Long> f28007r = new HashMap();
    private long xt;

    public static ch j(String str) {
        return new ch(str, SystemClock.elapsedRealtime());
    }

    public long xt(String str) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j6 = elapsedRealtime - this.cw;
        this.cw = elapsedRealtime;
        this.f28007r.put(str, Long.valueOf(j6));
        return j6;
    }

    public long j() {
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.xt;
        this.f28007r.put(this.f28006j, Long.valueOf(elapsedRealtime));
        return elapsedRealtime;
    }

    private ch(String str, long j6) {
        this.f28006j = str;
        this.xt = j6;
        this.cw = j6;
    }

    public void j(String str, long j6) {
        this.f28007r.put(str, Long.valueOf(j6));
    }

    public void j(JSONObject jSONObject, long j6) {
        if (jSONObject == null) {
            return;
        }
        for (Map.Entry<String, Long> entry : this.f28007r.entrySet()) {
            String key = entry.getKey();
            Long value = entry.getValue();
            if (!TextUtils.isEmpty(key) && value.longValue() > j6) {
                try {
                    jSONObject.put(key, value);
                } catch (JSONException unused) {
                }
            }
        }
    }

    public long xt() {
        return SystemClock.elapsedRealtime() - this.xt;
    }

    public JSONObject j(long j6) {
        JSONObject jSONObject = new JSONObject();
        j(jSONObject, j6);
        return jSONObject;
    }
}
