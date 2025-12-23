package com.bytedance.sdk.openadsdk.core.ugeno;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.rn.h;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class ae {

    /* renamed from: j, reason: collision with root package name */
    private static volatile ae f30519j;
    private com.bytedance.sdk.component.r.j.xt xt = h.j("ugeno_template_file");

    public static ae j() {
        if (f30519j == null) {
            synchronized (ae.class) {
                try {
                    if (f30519j == null) {
                        f30519j = new ae();
                    }
                } finally {
                }
            }
        }
        return f30519j;
    }

    private ae() {
    }

    public boolean xt(String str, String str2) {
        if (j(str, str2) != null) {
            return true;
        }
        return false;
    }

    public void j(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str3)) {
            return;
        }
        this.xt.j("ugeno_".concat(String.valueOf(str)), str3);
        this.xt.j("ugeno__md5_".concat(String.valueOf(str)), str2);
    }

    public JSONObject j(String str, String str2) {
        String xt = this.xt.xt("ugeno_".concat(String.valueOf(str)), "");
        if (TextUtils.isEmpty(xt)) {
            return null;
        }
        String xt2 = this.xt.xt("ugeno__md5_".concat(String.valueOf(str)), "");
        if (!TextUtils.isEmpty(xt2) && TextUtils.equals(xt2, str2)) {
            try {
                return new JSONObject(xt);
            } catch (JSONException e6) {
                vl.j(e6);
            }
        }
        return null;
    }
}
