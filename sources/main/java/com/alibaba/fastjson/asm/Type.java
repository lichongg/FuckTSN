package com.alibaba.fastjson.asm;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class Type {
    private final char[] buf;
    private final int len;
    private final int off;
    protected final int sort;
    public static final Type VOID_TYPE = new Type(0, null, 1443168256, 1);
    public static final Type BOOLEAN_TYPE = new Type(1, null, 1509950721, 1);
    public static final Type CHAR_TYPE = new Type(2, null, 1124075009, 1);
    public static final Type BYTE_TYPE = new Type(3, null, 1107297537, 1);
    public static final Type SHORT_TYPE = new Type(4, null, 1392510721, 1);
    public static final Type INT_TYPE = new Type(5, null, 1224736769, 1);
    public static final Type FLOAT_TYPE = new Type(6, null, 1174536705, 1);
    public static final Type LONG_TYPE = new Type(7, null, 1241579778, 1);
    public static final Type DOUBLE_TYPE = new Type(8, null, 1141048066, 1);

    public static int getArgumentsAndReturnSizes(String str) {
        int i6;
        int i7 = 1;
        int i8 = 1;
        int i9 = 1;
        while (true) {
            i6 = i8 + 1;
            char charAt = str.charAt(i8);
            if (charAt == ')') {
                break;
            }
            if (charAt == 'L') {
                while (true) {
                    i8 = i6 + 1;
                    if (str.charAt(i6) == ';') {
                        break;
                    }
                    i6 = i8;
                }
                i9++;
            } else {
                i9 = (charAt == 'D' || charAt == 'J') ? i9 + 2 : i9 + 1;
                i8 = i6;
            }
        }
        char charAt2 = str.charAt(i6);
        int i10 = i9 << 2;
        if (charAt2 == 'V') {
            i7 = 0;
        } else if (charAt2 == 'D' || charAt2 == 'J') {
            i7 = 2;
        }
        return i10 | i7;
    }

    public static Type getType(String str) {
        return getType(str.toCharArray(), 0);
    }

    private static Type getType(char[] cArr, int i6) {
        char c6;
        char c7 = cArr[i6];
        if (c7 == 'F') {
            return FLOAT_TYPE;
        }
        if (c7 == 'S') {
            return SHORT_TYPE;
        }
        if (c7 == 'V') {
            return VOID_TYPE;
        }
        if (c7 == 'I') {
            return INT_TYPE;
        }
        if (c7 == 'J') {
            return LONG_TYPE;
        }
        if (c7 == 'Z') {
            return BOOLEAN_TYPE;
        }
        if (c7 != '[') {
            switch (c7) {
                case 'B':
                    return BYTE_TYPE;
                case 'C':
                    return CHAR_TYPE;
                case 'D':
                    return DOUBLE_TYPE;
                default:
                    int i7 = 1;
                    while (cArr[i6 + i7] != ';') {
                        i7++;
                    }
                    return new Type(10, cArr, i6 + 1, i7 - 1);
            }
        }
        int i8 = 1;
        while (true) {
            c6 = cArr[i6 + i8];
            if (c6 != '[') {
                break;
            }
            i8++;
        }
        if (c6 == 'L') {
            do {
                i8++;
            } while (cArr[i6 + i8] != ';');
        }
        return new Type(9, cArr, i6, i8 + 1);
    }

    String getDescriptor() {
        return new String(this.buf, this.off, this.len);
    }

    public String getInternalName() {
        return new String(this.buf, this.off, this.len);
    }

    private Type(int i6, char[] cArr, int i7, int i8) {
        this.sort = i6;
        this.buf = cArr;
        this.off = i7;
        this.len = i8;
    }
}
