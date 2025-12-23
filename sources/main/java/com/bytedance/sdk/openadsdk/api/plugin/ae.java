package com.bytedance.sdk.openadsdk.api.plugin;

import android.os.SystemClock;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class ae {
    private long cw;

    /* renamed from: j, reason: collision with root package name */
    private String f27553j;

    /* renamed from: r, reason: collision with root package name */
    private Map<String, Long> f27554r = new HashMap();
    private long xt;

    public static ae j(String str) {
        return new ae(str, SystemClock.elapsedRealtime());
    }

    public long j() {
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.xt;
        this.f27554r.put(this.f27553j, Long.valueOf(elapsedRealtime));
        return elapsedRealtime;
    }

    private ae(String str, long j6) {
        this.f27553j = str;
        this.xt = j6;
        this.cw = j6;
    }

    public long xt(String str) {
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.cw;
        this.cw = SystemClock.elapsedRealtime();
        this.f27554r.put(str, Long.valueOf(elapsedRealtime));
        return elapsedRealtime;
    }

    public void j(JSONObject jSONObject, long j6) {
        if (jSONObject == null) {
            return;
        }
        for (Map.Entry<String, Long> entry : this.f27554r.entrySet()) {
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
}
