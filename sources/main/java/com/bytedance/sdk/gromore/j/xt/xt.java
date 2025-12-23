package com.bytedance.sdk.gromore.j.xt;

import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt {
    public static Map<String, Object> j(Map<String, Object> map, Map<String, Object> map2) {
        if (map == null) {
            return map2;
        }
        if (map2 != null) {
            map.putAll(map2);
        }
        return map;
    }
}
