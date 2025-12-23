package com.bytedance.adsdk.xt.xt.r;

import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes3.dex */
public enum r implements up {
    LEFT_PAREN("("),
    RIGHT_PAREN(")"),
    LEFT_BRACKET("["),
    RIGHT_BRACKET("]"),
    COMMA(",");


    /* renamed from: m, reason: collision with root package name */
    private static final Map<String, r> f23963m;
    private final String ae;

    public static boolean j(up upVar) {
        return upVar instanceof r;
    }

    static {
        HashMap hashMap = new HashMap(128);
        f23963m = hashMap;
        for (r rVar : hashMap.values()) {
            f23963m.put(rVar.j(), rVar);
        }
    }

    public String j() {
        return this.ae;
    }

    r(String str) {
        this.ae = str;
    }
}
