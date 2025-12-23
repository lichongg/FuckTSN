package com.kuaishou.weapon.p0;

import org.json.JSONArray;

/* loaded from: D:\Downloads\app\classes6.dex */
public class dj {

    /* renamed from: a, reason: collision with root package name */
    private static final String f36014a = "bGlidmErKw==";

    /* renamed from: b, reason: collision with root package name */
    private static final String f36015b = "WnBvc2VkQnJpZGdlLmphcg==";

    /* renamed from: c, reason: collision with root package name */
    private static final String f36016c = "bGlienBvc2VkX2FydC5zbw==";

    public static Integer a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        try {
            if (jSONArray.length() <= 0) {
                return null;
            }
            String str = new String(c.a(f36015b.getBytes(), 2));
            byte[] a6 = c.a(f36016c.getBytes(), 2);
            return (a6 == null || !a(jSONArray, str, new String(a6))) ? null : 1;
        } catch (Exception unused) {
            return null;
        }
    }

    public static Integer b(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        try {
            if (jSONArray.length() <= 0) {
                return null;
            }
            String str = new String(c.a(f36014a.getBytes(), 2));
            return (str.length() <= 1 || !a(jSONArray, str)) ? null : 1;
        } catch (Exception unused) {
            return null;
        }
    }

    private static boolean a(JSONArray jSONArray, String str, String str2) {
        try {
            if (jSONArray.length() > 0) {
                for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                    String str3 = (String) jSONArray.get(i6);
                    if (str3.contains(str) || str3.contains(str2)) {
                        return true;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    private static boolean a(JSONArray jSONArray, String str) {
        try {
            if (jSONArray.length() > 0) {
                for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                    if (((String) jSONArray.get(i6)).contains(str)) {
                        return true;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }
}
