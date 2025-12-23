package com.bytedance.adsdk.xt.xt.r;

import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes3.dex */
public enum j implements up {
    TRUE,
    FALSE,
    NULL;


    /* renamed from: r, reason: collision with root package name */
    private static final Map<String, j> f23957r = new HashMap(128);

    static {
        for (j jVar : values()) {
            f23957r.put(jVar.name().toLowerCase(), jVar);
        }
    }

    public static j j(String str) {
        return f23957r.get(str.toLowerCase());
    }
}
