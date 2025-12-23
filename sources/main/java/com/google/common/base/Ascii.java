package com.google.common.base;

import com.google.common.annotations.GwtCompatible;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtCompatible
/* loaded from: D:\Downloads\app\classes5.dex */
public final class Ascii {
    public static final byte ACK = 6;
    public static final byte BEL = 7;
    public static final byte BS = 8;
    public static final byte CAN = 24;
    private static final char CASE_MASK = ' ';
    public static final byte CR = 13;
    public static final byte DC1 = 17;
    public static final byte DC2 = 18;
    public static final byte DC3 = 19;
    public static final byte DC4 = 20;
    public static final byte DEL = Byte.MAX_VALUE;
    public static final byte DLE = 16;
    public static final byte EM = 25;
    public static final byte ENQ = 5;
    public static final byte EOT = 4;
    public static final byte ESC = 27;
    public static final byte ETB = 23;
    public static final byte ETX = 3;
    public static final byte FF = 12;
    public static final byte FS = 28;
    public static final byte GS = 29;
    public static final byte HT = 9;
    public static final byte LF = 10;
    public static final char MAX = 127;
    public static final char MIN = 0;
    public static final byte NAK = 21;
    public static final byte NL = 10;
    public static final byte NUL = 0;
    public static final byte RS = 30;
    public static final byte SI = 15;
    public static final byte SO = 14;
    public static final byte SOH = 1;
    public static final byte SP = 32;
    public static final byte SPACE = 32;
    public static final byte STX = 2;
    public static final byte SUB = 26;
    public static final byte SYN = 22;
    public static final byte US = 31;
    public static final byte VT = 11;
    public static final byte XOFF = 19;
    public static final byte XON = 17;

    public static String toLowerCase(String str) {
        int length = str.length();
        int i6 = 0;
        while (i6 < length) {
            if (isUpperCase(str.charAt(i6))) {
                char[] charArray = str.toCharArray();
                while (i6 < length) {
                    char c6 = charArray[i6];
                    if (isUpperCase(c6)) {
                        charArray[i6] = (char) (c6 ^ ' ');
                    }
                    i6++;
                }
                return String.valueOf(charArray);
            }
            i6++;
        }
        return str;
    }

    public static String toUpperCase(String str) {
        int length = str.length();
        int i6 = 0;
        while (i6 < length) {
            if (isLowerCase(str.charAt(i6))) {
                char[] charArray = str.toCharArray();
                while (i6 < length) {
                    char c6 = charArray[i6];
                    if (isLowerCase(c6)) {
                        charArray[i6] = (char) (c6 ^ ' ');
                    }
                    i6++;
                }
                return String.valueOf(charArray);
            }
            i6++;
        }
        return str;
    }

    private static int getAlphaIndex(char c6) {
        return (char) ((c6 | ' ') - 97);
    }

    public static boolean isLowerCase(char c6) {
        return c6 >= 'a' && c6 <= 'z';
    }

    public static boolean isUpperCase(char c6) {
        return c6 >= 'A' && c6 <= 'Z';
    }

    private Ascii() {
    }

    public static boolean equalsIgnoreCase(CharSequence charSequence, CharSequence charSequence2) {
        int alphaIndex;
        int length = charSequence.length();
        if (charSequence == charSequence2) {
            return true;
        }
        if (length != charSequence2.length()) {
            return false;
        }
        for (int i6 = 0; i6 < length; i6++) {
            char charAt = charSequence.charAt(i6);
            char charAt2 = charSequence2.charAt(i6);
            if (charAt != charAt2 && ((alphaIndex = getAlphaIndex(charAt)) >= 26 || alphaIndex != getAlphaIndex(charAt2))) {
                return false;
            }
        }
        return true;
    }

    public static String truncate(CharSequence charSequence, int i6, String str) {
        boolean z5;
        Preconditions.checkNotNull(charSequence);
        int length = i6 - str.length();
        if (length >= 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        Preconditions.checkArgument(z5, "maxLength (%s) must be >= length of the truncation indicator (%s)", i6, str.length());
        int length2 = charSequence.length();
        String str2 = charSequence;
        if (length2 <= i6) {
            String charSequence2 = charSequence.toString();
            int length3 = charSequence2.length();
            str2 = charSequence2;
            if (length3 <= i6) {
                return charSequence2;
            }
        }
        StringBuilder sb = new StringBuilder(i6);
        sb.append((CharSequence) str2, 0, length);
        sb.append(str);
        return sb.toString();
    }

    public static String toLowerCase(CharSequence charSequence) {
        if (charSequence instanceof String) {
            return toLowerCase((String) charSequence);
        }
        int length = charSequence.length();
        char[] cArr = new char[length];
        for (int i6 = 0; i6 < length; i6++) {
            cArr[i6] = toLowerCase(charSequence.charAt(i6));
        }
        return String.valueOf(cArr);
    }

    public static String toUpperCase(CharSequence charSequence) {
        if (charSequence instanceof String) {
            return toUpperCase((String) charSequence);
        }
        int length = charSequence.length();
        char[] cArr = new char[length];
        for (int i6 = 0; i6 < length; i6++) {
            cArr[i6] = toUpperCase(charSequence.charAt(i6));
        }
        return String.valueOf(cArr);
    }

    public static char toLowerCase(char c6) {
        return isUpperCase(c6) ? (char) (c6 ^ ' ') : c6;
    }

    public static char toUpperCase(char c6) {
        return isLowerCase(c6) ? (char) (c6 ^ ' ') : c6;
    }
}
