package com.bytedance.sdk.openadsdk.core.tl;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.v;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw {
    public static String j(String str) {
        String i6 = v.xt().i();
        if (TextUtils.isEmpty(i6)) {
            return "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/csj_assets/".concat(String.valueOf(str));
        }
        return i6 + str;
    }
}
