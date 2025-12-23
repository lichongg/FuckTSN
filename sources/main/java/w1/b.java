package w1;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class b {
    public static String[] k(String[] strArr, String[] strArr2) {
        if (strArr.length <= 0) {
            return strArr2.length <= 0 ? new String[0] : strArr2;
        }
        if (strArr2.length <= 0) {
            return strArr;
        }
        String[] strArr3 = new String[strArr.length + strArr2.length];
        System.arraycopy(strArr, 0, strArr3, 0, strArr.length);
        System.arraycopy(strArr2, 0, strArr3, strArr.length, strArr2.length);
        return strArr3;
    }

    public static String[] l(String str, char c6) {
        if (str == null) {
            return new String[0];
        }
        if (str.length() <= 0) {
            return new String[]{str};
        }
        int i6 = 1;
        for (int i7 = 0; i7 < str.length(); i7++) {
            if (str.charAt(i7) == c6) {
                i6++;
            }
        }
        if (i6 <= 1) {
            return new String[]{str};
        }
        String[] strArr = new String[i6];
        StringBuilder sb = new StringBuilder(str.length());
        int i8 = 0;
        for (int i9 = 0; i9 < str.length() && i8 < i6; i9++) {
            char charAt = str.charAt(i9);
            if (charAt == c6) {
                strArr[i8] = sb.toString();
                sb.setLength(0);
                i8++;
            } else {
                sb.append(charAt);
            }
        }
        strArr[i8] = sb.toString();
        return strArr;
    }

    public static String b(String str, char c6) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        int length = str.length();
        char[] cArr = new char[length];
        for (int i6 = 0; i6 < length; i6++) {
            cArr[i6] = c6;
        }
        return new String(cArr);
    }

    public static String c(String str, String str2, String str3) {
        if (str == null || str.length() <= 0 || str2.length() <= 0 || str3.length() <= 0) {
            return str;
        }
        char[] charArray = str.toCharArray();
        char[] cArr = new char[str.length()];
        char charAt = str3.charAt(str3.length() - 1);
        for (int i6 = 0; i6 < charArray.length; i6++) {
            char c6 = charArray[i6];
            int lastIndexOf = str2.lastIndexOf(c6);
            if (lastIndexOf < 0) {
                cArr[i6] = c6;
            } else {
                cArr[i6] = lastIndexOf >= str3.length() ? charAt : str3.charAt(lastIndexOf);
            }
        }
        return new String(cArr);
    }

    public static String d(String str, String... strArr) {
        if (strArr == null || strArr.length <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(strArr[0]);
        for (int i6 = 1; i6 < strArr.length; i6++) {
            if (strArr[i6] != null) {
                sb.append(str);
                sb.append(strArr[i6]);
            }
        }
        return sb.toString();
    }

    public static String e(String[] strArr, int i6) {
        return (strArr == null || strArr.length <= 0 || i6 < 0 || i6 >= strArr.length) ? "" : strArr[i6];
    }

    public static String[] f(String str, int i6) {
        return str == null ? new String[]{"", ""} : (i6 < 0 || i6 > str.length()) ? new String[]{str, ""} : new String[]{str.substring(0, i6), str.substring(i6)};
    }

    public static String[] i(String str, int... iArr) {
        if (str == null) {
            return new String[]{""};
        }
        if (str.length() <= 1 || iArr.length <= 0) {
            return new String[]{str};
        }
        if (iArr.length <= 1) {
            return f(str, iArr[0]);
        }
        int i6 = iArr[0];
        int length = iArr.length - 1;
        int[] iArr2 = new int[length];
        int i7 = 0;
        while (i7 < length) {
            int i8 = i7 + 1;
            iArr2[i7] = iArr[i8] - i6;
            i7 = i8;
        }
        String[] f6 = f(str, i6);
        return m(e(f6, 0), i(e(f6, 1), iArr2));
    }

    public static int a(String str, char c6, int i6) {
        int length = str.length() - 1;
        while (length >= 0 && (str.charAt(length) != c6 || i6 - 1 > 0)) {
            length--;
        }
        return length;
    }

    public static String[] g(String str, int i6, int i7) {
        String[] f6 = f(str, i6);
        return m(e(f6, 0), f(e(f6, 1), i7 - i6));
    }

    public static String[] h(String str, int i6, int i7, int i8) {
        String[] f6 = f(str, i6);
        return m(e(f6, 0), g(e(f6, 1), i7 - i6, i8 - i6));
    }

    public static String[] j(String[] strArr, String str) {
        return k(strArr, new String[]{str});
    }

    public static String[] m(String str, String[] strArr) {
        return k(new String[]{str}, strArr);
    }
}
