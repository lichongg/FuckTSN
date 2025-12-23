package com.bytedance.adsdk.xt.xt.up;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j {
    public static boolean cw(char c6) {
        return c6 >= '0' && c6 <= '9';
    }

    public static boolean j(char c6) {
        return c6 == ' ';
    }

    public static boolean r(char c6) {
        return '+' == c6 || '-' == c6 || '*' == c6 || '/' == c6 || '%' == c6 || '=' == c6 || '>' == c6 || '<' == c6 || '!' == c6 || '&' == c6 || '|' == c6 || '?' == c6 || ':' == c6;
    }

    public static boolean xt(char c6) {
        if (c6 < 'A' || c6 > 'Z') {
            return c6 >= 'a' && c6 <= 'z';
        }
        return true;
    }
}
