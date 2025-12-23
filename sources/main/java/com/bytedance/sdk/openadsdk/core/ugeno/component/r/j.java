package com.bytedance.sdk.openadsdk.core.ugeno.component.r;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bytedance.adsdk.ugeno.cw.av;
import com.bytedance.adsdk.ugeno.widget.frame.UGFrameLayout;
import com.bytedance.adsdk.ugeno.xt.cw;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j extends com.bytedance.adsdk.ugeno.widget.cw.j {
    public void j(long j6, long j7) {
        av avVar;
        JSONObject cw;
        if (!j(12) || (avVar = this.ka.get(12)) == null || (cw = avVar.cw()) == null) {
            return;
        }
        cw.optString("type");
        JSONArray optJSONArray = cw.optJSONArray("actions");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            return;
        }
        for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i6);
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("type");
                int optInt = optJSONObject.optInt(NotificationCompat.CATEGORY_PROGRESS) * 1000;
                if (optInt > j7) {
                    optInt = (int) j7;
                }
                if (j6 == optInt && TextUtils.equals(optString, "onShow")) {
                    cw xt = xt(this);
                    String optString2 = optJSONObject.optString("nodeId");
                    if (xt != null) {
                        xt.r(optString2).xt(0);
                    }
                }
            }
        }
    }

    @Override // com.bytedance.adsdk.ugeno.xt.cw
    /* renamed from: qb, reason: merged with bridge method [inline-methods] */
    public UGFrameLayout j() {
        UGFrameLayout uGFrameLayout = new UGFrameLayout(this.xt);
        uGFrameLayout.j(this);
        return uGFrameLayout;
    }

    public j(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.widget.cw.j, com.bytedance.adsdk.ugeno.xt.j, com.bytedance.adsdk.ugeno.xt.cw
    public void xt() {
        super.xt();
    }
}
