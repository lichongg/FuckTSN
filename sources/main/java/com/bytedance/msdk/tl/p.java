package com.bytedance.msdk.tl;

import java.util.List;

/* loaded from: D:\Downloads\app\classes3.dex */
public class p {
    public static <T> boolean j(List<T> list) {
        return list == null || list.size() == 0;
    }

    public static <T> boolean xt(List<T> list) {
        return list == null || list.size() == 0 || list.get(0) == null;
    }
}
