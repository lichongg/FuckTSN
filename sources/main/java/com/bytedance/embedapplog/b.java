package com.bytedance.embedapplog;

import android.content.Context;
import android.telephony.TelephonyManager;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
class b extends l {
    private final Context up;

    b(Context context) {
        super(true, false);
        this.up = context;
    }

    @Override // com.bytedance.embedapplog.l
    protected boolean j(JSONObject jSONObject) {
        wq.j(jSONObject, "sim_region", ((TelephonyManager) this.up.getSystemService("phone")).getSimCountryIso());
        return true;
    }
}
