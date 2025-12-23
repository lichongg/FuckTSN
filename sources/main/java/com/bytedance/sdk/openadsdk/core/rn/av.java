package com.bytedance.sdk.openadsdk.core.rn;

import android.text.TextUtils;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public class av {
    public static String j(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        return map.get(TextUtils.isEmpty(map.get("content-type")) ? "Content-Type" : "content-type");
    }
}
