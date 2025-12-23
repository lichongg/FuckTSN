package com.bytedance.sdk.openadsdk.core.component.reward.up;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.oq;
import com.bytedance.sdk.openadsdk.core.tj.ae;
import com.huawei.hms.framework.common.ContainerUtils;
import java.util.Iterator;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {
    public static String j(String str) {
        if (!vl.cw() || TextUtils.isEmpty(str)) {
            return str;
        }
        ae aeVar = new ae(oq.i().l());
        StringBuilder sb = new StringBuilder(str);
        Iterator<String> it = aeVar.xt().iterator();
        while (it.hasNext()) {
            if (sb.toString().contains(it.next())) {
                if (sb.toString().contains("?")) {
                    sb.append(ContainerUtils.FIELD_DELIMITER);
                    sb.append(aeVar.j());
                } else {
                    sb.append("?");
                    sb.append(aeVar.j());
                }
            }
        }
        return sb.toString();
    }
}
