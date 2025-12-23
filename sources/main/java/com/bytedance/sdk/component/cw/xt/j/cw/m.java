package com.bytedance.sdk.component.cw.xt.j.cw;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class m {
    public static boolean j(String str) {
        return str.equals("POST") || str.equals("PATCH") || str.equals("PUT") || str.equals("DELETE") || str.equals("MOVE");
    }

    public static boolean r(String str) {
        return str.equals("PROPFIND");
    }

    public static boolean up(String str) {
        return !str.equals("PROPFIND");
    }

    public static boolean xt(String str) {
        return str.equals("POST") || str.equals("PUT") || str.equals("PATCH") || str.equals("PROPPATCH") || str.equals("REPORT");
    }

    public static boolean cw(String str) {
        if (!xt(str) && !str.equals("OPTIONS") && !str.equals("DELETE") && !str.equals("PROPFIND") && !str.equals("MKCOL") && !str.equals("LOCK")) {
            return false;
        }
        return true;
    }
}
