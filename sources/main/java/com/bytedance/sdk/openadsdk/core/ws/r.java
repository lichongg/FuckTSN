package com.bytedance.sdk.openadsdk.core.ws;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.rn.h;
import com.bytedance.sdk.openadsdk.core.v;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r {
    public static boolean j(String str) {
        String xt;
        int wi;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            xt = h.j("fsswiper_freq").xt(str, "");
        } catch (Exception unused) {
        }
        if (!TextUtils.isEmpty(xt) && (wi = v.xt().wi()) > 0) {
            return new JSONObject(xt).optInt(j(), 0) >= wi;
        }
        return false;
    }

    private static void cw(String str) {
        JSONObject jSONObject;
        if (!TextUtils.isEmpty(str)) {
            com.bytedance.sdk.component.r.j.xt j6 = h.j("fsswiper_freq");
            try {
                String xt = j6.xt(str, "");
                if (TextUtils.isEmpty(xt)) {
                    jSONObject = new JSONObject();
                } else {
                    jSONObject = new JSONObject(xt);
                }
                String j7 = j();
                int optInt = jSONObject.optInt(j7, 0);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(j7, optInt + 1);
                j6.j(str, jSONObject2.toString());
            } catch (Exception unused) {
            }
        }
    }

    public static void xt(String str) {
        cw(str);
    }

    @SuppressLint({"SimpleDateFormat"})
    private static String j() {
        try {
            return new SimpleDateFormat("yyyyMMdd").format(new Date(System.currentTimeMillis()));
        } catch (Exception unused) {
            return null;
        }
    }
}
