package io.netty.util.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class StringUtil {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final char CARRIAGE_RETURN = '\r';
    public static final char COMMA = ',';
    private static final int CSV_NUMBER_ESCAPE_CHARACTERS = 7;
    public static final char DOUBLE_QUOTE = '\"';
    public static final String EMPTY_STRING = "";
    public static final char LINE_FEED = '\n';
    private static final char PACKAGE_SEPARATOR_CHAR = '.';
    public static final char SPACE = ' ';
    public static final char TAB = '\t';
    public static final String NEWLINE = SystemPropertyUtil.get("line.separator", com.snail.antifake.deviceid.e.f37542d);
    private static final String[] BYTE2HEX_PAD = new String[256];
    private static final String[] BYTE2HEX_NOPAD = new String[256];

    public static String byteToHexString(int i6) {
        return BYTE2HEX_NOPAD[i6 & 255];
    }

    public static String byteToHexStringPadded(int i6) {
        return BYTE2HEX_PAD[i6 & 255];
    }

    public static byte[] decodeHexDump(CharSequence charSequence, int i6, int i7) {
        if (i7 < 0 || (i7 & 1) != 0) {
            throw new IllegalArgumentException("length: " + i7);
        }
        if (i7 == 0) {
            return EmptyArrays.EMPTY_BYTES;
        }
        byte[] bArr = new byte[i7 >>> 1];
        for (int i8 = 0; i8 < i7; i8 += 2) {
            bArr[i8 >>> 1] = decodeHexByte(charSequence, i6 + i8);
        }
        return bArr;
    }

    public static CharSequence escapeCsv(CharSequence charSequence) {
        return escapeCsv(charSequence, false);
    }

    private static int indexOfFirstNonOwsChar(CharSequence charSequence, int i6) {
        int i7 = 0;
        while (i7 < i6 && isOws(charSequence.charAt(i7))) {
            i7++;
        }
        return i7;
    }

    public static String simpleClassName(Object obj) {
        return obj == null ? "null_object" : simpleClassName(obj.getClass());
    }

    public static String toHexString(byte[] bArr) {
        return toHexString(bArr, 0, bArr.length);
    }

    public static String toHexStringPadded(byte[] bArr) {
        return toHexStringPadded(bArr, 0, bArr.length);
    }

    static {
        String str;
        int i6 = 0;
        while (true) {
            String[] strArr = BYTE2HEX_PAD;
            if (i6 >= strArr.length) {
                return;
            }
            String hexString = Integer.toHexString(i6);
            if (i6 > 15) {
                str = hexString;
            } else {
                str = '0' + hexString;
            }
            strArr[i6] = str;
            BYTE2HEX_NOPAD[i6] = hexString;
            i6++;
        }
    }

    public static <T extends Appendable> T byteToHexString(T t5, int i6) {
        try {
            t5.append(byteToHexString(i6));
            return t5;
        } catch (IOException e6) {
            PlatformDependent.throwException(e6);
            return t5;
        }
    }

    public static <T extends Appendable> T byteToHexStringPadded(T t5, int i6) {
        try {
            t5.append(byteToHexStringPadded(i6));
            return t5;
        } catch (IOException e6) {
            PlatformDependent.throwException(e6);
            return t5;
        }
    }

    public static boolean commonSuffixOfLength(String str, String str2, int i6) {
        return str != null && str2 != null && i6 >= 0 && str.regionMatches(str.length() - i6, str2, str2.length() - i6, i6);
    }

    public static int decodeHexNibble(char c6) {
        if (c6 >= '0' && c6 <= '9') {
            return c6 - '0';
        }
        if (c6 >= 'A' && c6 <= 'F') {
            return c6 - '7';
        }
        if (c6 < 'a' || c6 > 'f') {
            return -1;
        }
        return c6 - 'W';
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00bb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.CharSequence escapeCsv(java.lang.CharSequence r7, boolean r8) {
        /*
            Method dump skipped, instructions count: 224
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.internal.StringUtil.escapeCsv(java.lang.CharSequence, boolean):java.lang.CharSequence");
    }

    private static int indexOfLastNonOwsChar(CharSequence charSequence, int i6, int i7) {
        int i8 = i7 - 1;
        while (i8 > i6 && isOws(charSequence.charAt(i8))) {
            i8--;
        }
        return i8;
    }

    private static boolean isDoubleQuote(char c6) {
        return c6 == '\"';
    }

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private static boolean isOws(char c6) {
        return c6 == ' ' || c6 == '\t';
    }

    public static int length(String str) {
        if (str == null) {
            return 0;
        }
        return str.length();
    }

    private static IllegalArgumentException newInvalidEscapedCsvFieldException(CharSequence charSequence, int i6) {
        return new IllegalArgumentException("invalid escaped CSV field: " + ((Object) charSequence) + " index: " + i6);
    }

    public static String toHexString(byte[] bArr, int i6, int i7) {
        return ((StringBuilder) toHexString(new StringBuilder(i7 << 1), bArr, i6, i7)).toString();
    }

    public static String toHexStringPadded(byte[] bArr, int i6, int i7) {
        return ((StringBuilder) toHexStringPadded(new StringBuilder(i7 << 1), bArr, i6, i7)).toString();
    }

    public static CharSequence unescapeCsv(CharSequence charSequence) {
        int length = ((CharSequence) ObjectUtil.checkNotNull(charSequence, "value")).length();
        if (length == 0) {
            return charSequence;
        }
        int i6 = length - 1;
        if (!isDoubleQuote(charSequence.charAt(0)) || !isDoubleQuote(charSequence.charAt(i6)) || length == 1) {
            validateCsvFormat(charSequence);
            return charSequence;
        }
        StringBuilder stringBuilder = InternalThreadLocalMap.get().stringBuilder();
        int i7 = 1;
        while (i7 < i6) {
            char charAt = charSequence.charAt(i7);
            if (charAt == '\"') {
                int i8 = i7 + 1;
                if (!isDoubleQuote(charSequence.charAt(i8)) || i8 == i6) {
                    throw newInvalidEscapedCsvFieldException(charSequence, i7);
                }
                i7 = i8;
            }
            stringBuilder.append(charAt);
            i7++;
        }
        return stringBuilder.toString();
    }

    public static List<CharSequence> unescapeCsvFields(CharSequence charSequence) {
        ArrayList arrayList = new ArrayList(2);
        StringBuilder stringBuilder = InternalThreadLocalMap.get().stringBuilder();
        int length = charSequence.length() - 1;
        int i6 = 0;
        boolean z5 = false;
        while (i6 <= length) {
            char charAt = charSequence.charAt(i6);
            if (!z5) {
                if (charAt != '\n' && charAt != '\r') {
                    if (charAt != '\"') {
                        if (charAt != ',') {
                            stringBuilder.append(charAt);
                        } else {
                            arrayList.add(stringBuilder.toString());
                            stringBuilder.setLength(0);
                        }
                    } else if (stringBuilder.length() == 0) {
                        z5 = true;
                    }
                }
                throw newInvalidEscapedCsvFieldException(charSequence, i6);
            }
            if (charAt != '\"') {
                stringBuilder.append(charAt);
            } else {
                if (i6 == length) {
                    arrayList.add(stringBuilder.toString());
                    return arrayList;
                }
                int i7 = i6 + 1;
                char charAt2 = charSequence.charAt(i7);
                if (charAt2 == '\"') {
                    stringBuilder.append('\"');
                    i6 = i7;
                } else {
                    if (charAt2 != ',') {
                        throw newInvalidEscapedCsvFieldException(charSequence, i6);
                    }
                    arrayList.add(stringBuilder.toString());
                    stringBuilder.setLength(0);
                    i6 = i7;
                    z5 = false;
                }
            }
            i6++;
        }
        if (z5) {
            throw newInvalidEscapedCsvFieldException(charSequence, length);
        }
        arrayList.add(stringBuilder.toString());
        return arrayList;
    }

    private StringUtil() {
    }

    public static byte decodeHexByte(CharSequence charSequence, int i6) {
        int decodeHexNibble = decodeHexNibble(charSequence.charAt(i6));
        int decodeHexNibble2 = decodeHexNibble(charSequence.charAt(i6 + 1));
        if (decodeHexNibble != -1 && decodeHexNibble2 != -1) {
            return (byte) ((decodeHexNibble << 4) + decodeHexNibble2);
        }
        throw new IllegalArgumentException(String.format("invalid hex byte '%s' at index %d of '%s'", charSequence.subSequence(i6, i6 + 2), Integer.valueOf(i6), charSequence));
    }

    public static boolean endsWith(CharSequence charSequence, char c6) {
        int length = charSequence.length();
        if (length > 0 && charSequence.charAt(length - 1) == c6) {
            return true;
        }
        return false;
    }

    public static int indexOfNonWhiteSpace(CharSequence charSequence, int i6) {
        while (i6 < charSequence.length()) {
            if (!Character.isWhitespace(charSequence.charAt(i6))) {
                return i6;
            }
            i6++;
        }
        return -1;
    }

    public static boolean isSurrogate(char c6) {
        if (c6 >= 55296 && c6 <= 57343) {
            return true;
        }
        return false;
    }

    public static String simpleClassName(Class<?> cls) {
        String name = ((Class) ObjectUtil.checkNotNull(cls, "clazz")).getName();
        int lastIndexOf = name.lastIndexOf(46);
        return lastIndexOf > -1 ? name.substring(lastIndexOf + 1) : name;
    }

    public static String substringAfter(String str, char c6) {
        int indexOf = str.indexOf(c6);
        if (indexOf >= 0) {
            return str.substring(indexOf + 1);
        }
        return null;
    }

    public static <T extends Appendable> T toHexString(T t5, byte[] bArr) {
        return (T) toHexString(t5, bArr, 0, bArr.length);
    }

    public static <T extends Appendable> T toHexStringPadded(T t5, byte[] bArr) {
        return (T) toHexStringPadded(t5, bArr, 0, bArr.length);
    }

    public static CharSequence trimOws(CharSequence charSequence) {
        int length = charSequence.length();
        if (length != 0) {
            int indexOfFirstNonOwsChar = indexOfFirstNonOwsChar(charSequence, length);
            int indexOfLastNonOwsChar = indexOfLastNonOwsChar(charSequence, indexOfFirstNonOwsChar, length);
            if (indexOfFirstNonOwsChar != 0 || indexOfLastNonOwsChar != length - 1) {
                return charSequence.subSequence(indexOfFirstNonOwsChar, indexOfLastNonOwsChar + 1);
            }
        }
        return charSequence;
    }

    private static void validateCsvFormat(CharSequence charSequence) {
        int length = charSequence.length();
        for (int i6 = 0; i6 < length; i6++) {
            char charAt = charSequence.charAt(i6);
            if (charAt == '\n' || charAt == '\r' || charAt == '\"' || charAt == ',') {
                throw newInvalidEscapedCsvFieldException(charSequence, i6);
            }
        }
    }

    public static <T extends Appendable> T toHexString(T t5, byte[] bArr, int i6, int i7) {
        if (i7 == 0) {
            return t5;
        }
        int i8 = i7 + i6;
        int i9 = i8 - 1;
        while (i6 < i9 && bArr[i6] == 0) {
            i6++;
        }
        int i10 = i6 + 1;
        byteToHexString(t5, bArr[i6]);
        toHexStringPadded(t5, bArr, i10, i8 - i10);
        return t5;
    }

    public static <T extends Appendable> T toHexStringPadded(T t5, byte[] bArr, int i6, int i7) {
        int i8 = i7 + i6;
        while (i6 < i8) {
            byteToHexStringPadded(t5, bArr[i6]);
            i6++;
        }
        return t5;
    }

    public static byte[] decodeHexDump(CharSequence charSequence) {
        return decodeHexDump(charSequence, 0, charSequence.length());
    }
}
