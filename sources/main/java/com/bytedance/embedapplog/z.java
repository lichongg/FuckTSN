package com.bytedance.embedapplog;

import android.content.SharedPreferences;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
class z extends l {
    private final rn up;

    z(rn rnVar) {
        super(true, false, false);
        this.up = rnVar;
    }

    @Override // com.bytedance.embedapplog.l
    protected boolean j(JSONObject jSONObject) {
        SharedPreferences r5 = this.up.r();
        String string = r5.getString("install_id", null);
        String string2 = r5.getString("device_id", null);
        String string3 = r5.getString("ssid", null);
        wq.j(jSONObject, "install_id", string);
        wq.j(jSONObject, "device_id", string2);
        wq.j(jSONObject, "ssid", string3);
        long j6 = 0;
        long j7 = r5.getLong("register_time", 0L);
        if ((wq.xt(string) && wq.xt(string2)) || j7 == 0) {
            j6 = j7;
        } else {
            r5.edit().putLong("register_time", 0L).apply();
        }
        jSONObject.put("register_time", j6);
        return true;
    }
}
