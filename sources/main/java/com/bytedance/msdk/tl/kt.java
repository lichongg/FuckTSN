package com.bytedance.msdk.tl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\Downloads\app\classes3.dex */
public class kt {

    /* renamed from: j, reason: collision with root package name */
    private static Map<Integer, Integer> f25219j = new ConcurrentHashMap();

    public static Integer j(int i6) {
        Integer num = f25219j.get(Integer.valueOf(i6));
        if (num != null) {
            return num;
        }
        Integer valueOf = Integer.valueOf(i6);
        f25219j.put(Integer.valueOf(i6), valueOf);
        return valueOf;
    }
}
