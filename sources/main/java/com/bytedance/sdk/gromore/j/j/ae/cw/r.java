package com.bytedance.sdk.gromore.j.j.ae.cw;

import android.os.Bundle;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r {
    public static Bundle j(com.bytedance.msdk.api.cw.j jVar) {
        Bundle bundle = new Bundle();
        if (jVar != null) {
            float xt = jVar.xt();
            String cw = jVar.cw();
            Map<String, Object> r5 = jVar.r();
            if (r5 == null) {
                r5 = new HashMap<>();
            }
            Object obj = r5.get(MediationConstant.KEY_EXTRA_INFO);
            if (obj instanceof Bundle) {
                Bundle bundle2 = (Bundle) obj;
                bundle2.putFloat(TTRewardVideoAd.REWARD_EXTRA_KEY_REWARD_AMOUNT, xt);
                bundle2.putString(TTRewardVideoAd.REWARD_EXTRA_KEY_REWARD_NAME, cw);
                return bundle2;
            }
            bundle.putString(TTRewardVideoAd.REWARD_EXTRA_KEY_REWARD_NAME, cw);
            bundle.putFloat(TTRewardVideoAd.REWARD_EXTRA_KEY_REWARD_AMOUNT, xt);
            Object obj2 = r5.get(MediationConstant.KEY_IS_GROMORE_SERVER_SIDE_VERIFY);
            if (obj2 instanceof Boolean) {
                bundle.putBoolean(MediationConstant.KEY_IS_GROMORE_SERVER_SIDE_VERIFY, ((Boolean) obj2).booleanValue());
            }
            Object obj3 = r5.get("transId");
            if (obj3 instanceof String) {
                bundle.putString("transId", (String) obj3);
            }
            Object obj4 = r5.get(MediationConstant.KEY_REASON);
            if (obj4 instanceof Integer) {
                bundle.putInt(MediationConstant.KEY_REASON, ((Integer) obj4).intValue());
            }
            Object obj5 = r5.get("gromoreExtra");
            if (obj5 instanceof String) {
                bundle.putString("gromoreExtra", (String) obj5);
            }
            Object obj6 = r5.get("errorCode");
            if (obj6 instanceof Integer) {
                bundle.putInt("errorCode", ((Integer) obj6).intValue());
            }
            Object obj7 = r5.get(MediationConstant.KEY_ERROR_MSG);
            if (obj7 instanceof String) {
                bundle.putString(MediationConstant.KEY_ERROR_MSG, (String) obj7);
            }
            Object obj8 = r5.get(MediationConstant.KEY_ADN_NAME);
            if (obj8 instanceof String) {
                bundle.putString(MediationConstant.KEY_ADN_NAME, (String) obj8);
            }
        }
        return bundle;
    }
}
