package com.bytedance.embedapplog;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.umeng.analytics.pro.bi;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
class e extends l {

    /* renamed from: m, reason: collision with root package name */
    private final rn f23984m;
    private final Context up;

    e(Context context, rn rnVar) {
        super(true, false);
        this.up = context;
        this.f23984m = rnVar;
    }

    @Override // com.bytedance.embedapplog.l
    protected boolean j(JSONObject jSONObject) {
        TelephonyManager telephonyManager = (TelephonyManager) this.up.getSystemService("phone");
        if (telephonyManager != null) {
            try {
                wq.j(jSONObject, bi.P, telephonyManager.getNetworkOperatorName());
                wq.j(jSONObject, "mcc_mnc", telephonyManager.getNetworkOperator());
                wq.j(jSONObject, "udid", this.f23984m.nd() ? xp.j(telephonyManager) : this.f23984m.gx());
                return true;
            } catch (Exception e6) {
                uc.xt(e6);
            }
        }
        return false;
    }
}
