package com.bytedance.adsdk.xt.xt.r;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.slf4j.Marker;

/* loaded from: D:\Downloads\app\classes3.dex */
public enum cw implements up {
    QUESTION("?", 0),
    COLON(":", 0),
    DOUBLE_AMP("&&", 1),
    DOUBLE_BAR("||", 1),
    EQ("==", 2),
    GT(">", 2),
    LT("<", 2),
    LT_EQ("<=", 2),
    GT_EQ(">=", 2),
    NOT_EQ("!=", 2),
    PLUS(Marker.ANY_NON_NULL_MARKER, 3),
    MINUS("-", 3),
    MULTI("*", 4),
    DIVISION("/", 4),
    MOD("%", 4);

    private final int mi;

    /* renamed from: w, reason: collision with root package name */
    private final String f23955w;
    private static final Map<String, cw> av = new HashMap(128);

    /* renamed from: i, reason: collision with root package name */
    private static final Set<cw> f23951i = new HashSet();

    public static cw j(String str) {
        return av.get(str);
    }

    static {
        for (cw cwVar : values()) {
            av.put(cwVar.j(), cwVar);
            f23951i.add(cwVar);
        }
    }

    public static boolean j(up upVar) {
        return upVar instanceof cw;
    }

    public int xt() {
        return this.mi;
    }

    cw(String str, int i6) {
        this.f23955w = str;
        this.mi = i6;
    }

    public String j() {
        return this.f23955w;
    }
}
