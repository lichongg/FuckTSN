package com.bytedance.adsdk.ugeno.up;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes3.dex */
public class oq {

    /* renamed from: j, reason: collision with root package name */
    private static Map<String, ae> f23762j = new HashMap();

    public static void j(List<ae> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (ae aeVar : list) {
            if (aeVar != null) {
                f23762j.put(aeVar.j(), aeVar);
            }
        }
    }

    public static ae j(String str) {
        return f23762j.get(str);
    }
}
