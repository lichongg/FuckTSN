package com.bytedance.sdk.component.adexpress.dynamic.r;

import android.text.TextUtils;
import com.bxkj.base.v2.common.utils.g0;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {
    public static String j(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        StringBuilder sb = new StringBuilder("https://sf3-fe-tos.pglstatp-toutiao.com/obj/ad-pattern/static/images/");
        if (str.indexOf(".") > 0) {
            sb.append(str);
            return sb.toString();
        }
        sb.append(str);
        sb.append(g0.f16898c);
        return sb.toString();
    }
}
