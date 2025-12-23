package com.huawei.secure.android.common.util;

import android.text.TextUtils;
import io.netty.util.internal.StringUtil;
import java.util.Locale;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final String f35258a = "EncodeUtil";

    /* renamed from: b, reason: collision with root package name */
    private static final char[] f35259b = {StringUtil.COMMA, '.', '-', '_'};

    /* renamed from: c, reason: collision with root package name */
    private static final String[] f35260c = new String[256];

    static {
        for (char c6 = 0; c6 < 255; c6 = (char) (c6 + 1)) {
            if ((c6 < '0' || c6 > '9') && ((c6 < 'A' || c6 > 'Z') && (c6 < 'a' || c6 > 'z'))) {
                f35260c[c6] = f(c6).intern();
            } else {
                f35260c[c6] = null;
            }
        }
    }

    private static boolean e(char c6, char[] cArr) {
        for (char c7 : cArr) {
            if (c6 == c7) {
                return true;
            }
        }
        return false;
    }

    private static String b(char c6) {
        return c6 < 255 ? f35260c[c6] : f(c6);
    }

    private static String d(char[] cArr, String str) {
        StringBuilder sb = new StringBuilder();
        for (int i6 = 0; i6 < str.length(); i6++) {
            sb.append(c(cArr, Character.valueOf(str.charAt(i6))));
        }
        return sb.toString();
    }

    public static String h(String str) {
        return i(str, f35259b);
    }

    private static Character a(j0 j0Var) {
        j0Var.f();
        Character h6 = j0Var.h();
        if (h6 == null) {
            j0Var.m();
            return null;
        }
        if (h6.charValue() != '\\') {
            j0Var.m();
            return null;
        }
        Character h7 = j0Var.h();
        if (h7 == null) {
            j0Var.m();
            return null;
        }
        if (h7.charValue() == 'b') {
            return '\b';
        }
        if (h7.charValue() == 't') {
            return '\t';
        }
        if (h7.charValue() == 'n') {
            return '\n';
        }
        if (h7.charValue() == 'v') {
            return (char) 11;
        }
        if (h7.charValue() == 'f') {
            return '\f';
        }
        if (h7.charValue() == 'r') {
            return Character.valueOf(StringUtil.CARRIAGE_RETURN);
        }
        if (h7.charValue() == '\"') {
            return '\"';
        }
        if (h7.charValue() == '\'') {
            return '\'';
        }
        if (h7.charValue() == '\\') {
            return '\\';
        }
        int i6 = 0;
        if (Character.toLowerCase(h7.charValue()) == 'x') {
            StringBuilder sb = new StringBuilder();
            while (i6 < 2) {
                Character i7 = j0Var.i();
                if (i7 != null) {
                    sb.append(i7);
                    i6++;
                } else {
                    j0Var.m();
                    return null;
                }
            }
            try {
                int parseInt = Integer.parseInt(sb.toString(), 16);
                if (Character.isValidCodePoint(parseInt)) {
                    return Character.valueOf((char) parseInt);
                }
            } catch (NumberFormatException unused) {
                j0Var.m();
                return null;
            }
        } else if (Character.toLowerCase(h7.charValue()) == 'u') {
            StringBuilder sb2 = new StringBuilder();
            while (i6 < 4) {
                Character i8 = j0Var.i();
                if (i8 != null) {
                    sb2.append(i8);
                    i6++;
                } else {
                    j0Var.m();
                    return null;
                }
            }
            try {
                int parseInt2 = Integer.parseInt(sb2.toString(), 16);
                if (Character.isValidCodePoint(parseInt2)) {
                    return Character.valueOf((char) parseInt2);
                }
            } catch (NumberFormatException unused2) {
                j0Var.m();
                return null;
            }
        } else if (j0.g(h7)) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(h7);
            Character h8 = j0Var.h();
            if (!j0.g(h8)) {
                j0Var.a(h8);
            } else {
                sb3.append(h8);
                Character h9 = j0Var.h();
                if (!j0.g(h9)) {
                    j0Var.a(h9);
                } else {
                    sb3.append(h9);
                }
            }
            try {
                int parseInt3 = Integer.parseInt(sb3.toString(), 8);
                if (Character.isValidCodePoint(parseInt3)) {
                    return Character.valueOf((char) parseInt3);
                }
            } catch (NumberFormatException unused3) {
                j0Var.m();
                return null;
            }
        }
        return h7;
    }

    private static String c(char[] cArr, Character ch) {
        if (e(ch.charValue(), cArr)) {
            return "" + ch;
        }
        if (b(ch.charValue()) == null) {
            return "" + ch;
        }
        String hexString = Integer.toHexString(ch.charValue());
        if (ch.charValue() < 256) {
            return "\\x" + "00".substring(hexString.length()) + hexString.toUpperCase(Locale.ENGLISH);
        }
        return "\\u" + "0000".substring(hexString.length()) + hexString.toUpperCase(Locale.ENGLISH);
    }

    private static String f(char c6) {
        return Integer.toHexString(c6);
    }

    public static String g(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            StringBuilder sb = new StringBuilder();
            j0 j0Var = new j0(str);
            while (j0Var.b()) {
                Character a6 = a(j0Var);
                if (a6 != null) {
                    sb.append(a6);
                } else {
                    sb.append(j0Var.h());
                }
            }
            return sb.toString();
        } catch (Exception e6) {
            e6.getMessage();
            return "";
        }
    }

    public static String i(String str, char[] cArr) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return d(cArr, str);
        } catch (Exception e6) {
            e6.getMessage();
            return "";
        }
    }
}
