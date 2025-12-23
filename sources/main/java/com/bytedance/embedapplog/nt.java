package com.bytedance.embedapplog;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\Downloads\app\classes3.dex */
public class nt {

    /* renamed from: j, reason: collision with root package name */
    private static final y f24018j = new y();
    private static final Map<String, String> xt = new ConcurrentHashMap();

    public static String j(String str) {
        Map<String, String> map = xt;
        String str2 = map.get(str);
        if (str2 != null) {
            return str2;
        }
        String j6 = f24018j.j(str);
        if (j6 != null) {
            map.put(str, j6);
        }
        return j6;
    }
}
