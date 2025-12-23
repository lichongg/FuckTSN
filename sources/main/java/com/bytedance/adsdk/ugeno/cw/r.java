package com.bytedance.adsdk.ugeno.cw;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes3.dex */
public class r {

    /* renamed from: j, reason: collision with root package name */
    private static Map<String, xt> f23621j = new HashMap();

    public static void j(List<xt> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (xt xtVar : list) {
            if (xtVar != null) {
                f23621j.put(xtVar.j(), xtVar);
            }
        }
    }

    public static xt j(String str) {
        return f23621j.get(str);
    }
}
