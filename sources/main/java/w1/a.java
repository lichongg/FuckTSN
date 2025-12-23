package w1;

import android.text.TextUtils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final String f54736a = "Anonymizer";

    public static String a(String str) {
        return (str == null || str.length() <= 0) ? "" : str.length() <= 1 ? "*" : str.length() < 8 ? d(str, 0, 1) : d(str, 0, 4);
    }

    public static String b(String str) {
        return (str == null || str.length() <= 0) ? "" : str.length() <= 2 ? b.b(str, '*') : (str.length() < 11 || str.length() >= 20) ? d(str, 6, 4) : d(str, 4, 4);
    }

    public static String c(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        if (str.length() <= 4) {
            return b.b(str, '*');
        }
        String[] f6 = b.f(str, 4);
        return b.d("", b.e(f6, 0), b.c(b.e(f6, 1), "0123456789", "*"));
    }

    public static String d(String str, int i6, int i7) {
        int length;
        if (str == null || str.length() <= 0) {
            return "";
        }
        if (i6 < 0) {
            i6 = 0;
        }
        if (i7 < 0) {
            i7 = 0;
        }
        if (str.length() <= i6 + i7) {
            length = str.length() - 1;
            i6 = 1;
        } else {
            length = str.length() - i7;
        }
        String[] g6 = b.g(str, i6, length);
        return b.d("", b.e(g6, 0), b.b(b.e(g6, 1), '*'), b.e(g6, 2));
    }

    public static String e(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        if (str.length() <= 1) {
            return "*";
        }
        int indexOf = str.indexOf(64);
        if (indexOf < 0) {
            String[] f6 = b.f(str, 1);
            return b.d("", b.e(f6, 0), b.b(b.e(f6, 1), '*'));
        }
        String[] h6 = b.h(str, indexOf, indexOf + 1, str.lastIndexOf(46));
        return b.d("", b.b(b.e(h6, 0), '*'), b.e(h6, 1), b.b(b.e(h6, 2), '*'), b.e(h6, 3));
    }

    public static String f(String str) {
        return (str == null || str.length() <= 0) ? "" : d(str, str.length() - 12, 0);
    }

    public static String g(String str) {
        return (str == null || str.length() <= 0) ? "" : d(str, str.length() - 4, 0);
    }

    public static String h(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf < 0) {
            return b.b(str, '*');
        }
        String[] f6 = b.f(str, lastIndexOf + 1);
        return b.d("", b.e(f6, 0), b.b(b.e(f6, 1), '*'));
    }

    public static String i(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        String[] l6 = b.l(str, ':');
        if (l6.length <= 1) {
            return b.b(str, '*');
        }
        if (l6.length != 8) {
            String[] f6 = b.f(str, str.indexOf(58) + 1);
            return b.d("", b.e(f6, 0), b.c(b.e(f6, 1), "0123456789ABCDEFabcdef", "*"));
        }
        l6[2] = j(l6[2]);
        for (int i6 = 3; i6 < l6.length; i6++) {
            l6[i6] = b.b(l6[i6], '*');
        }
        return b.d(":", l6);
    }

    public static String k(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        int a6 = b.a(str, '-', 2);
        if (a6 < 0) {
            return b.c(str, "0123456789ABCDEFabcdef", "*");
        }
        String[] f6 = b.f(str, a6);
        return b.d("", b.e(f6, 0), b.c(b.e(f6, 1), "0123456789ABCDEFabcdef", "*"));
    }

    public static String l(String str) {
        return (str == null || str.length() <= 0) ? "" : str.length() <= 1 ? "*" : d(str, 1, 0);
    }

    public static String m(String str) {
        return (str == null || str.length() <= 0) ? "" : str.length() <= 2 ? b.b(str, '*') : (str.length() < 8 || str.length() >= 11) ? d(str, 3, 4) : d(str, 2, 2);
    }

    public static String j(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.length() <= 2) {
            return b.b(str, '*');
        }
        String[] f6 = b.f(str, str.length() - 2);
        return b.d("", b.e(f6, 0), b.b(b.e(f6, 1), '*'));
    }
}
