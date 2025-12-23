package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final boolean f46295a;

    /* renamed from: b, reason: collision with root package name */
    static final /* synthetic */ boolean f46296b = false;

    static {
        String str;
        try {
            str = System.getProperty("kotlin.jvm.serialization.use8to7");
        } catch (SecurityException unused) {
            str = null;
        }
        f46295a = "true".equals(str);
    }

    private static /* synthetic */ void a(int i6) {
        String str = (i6 == 1 || i6 == 3 || i6 == 6 || i6 == 8 || i6 == 10 || i6 == 12 || i6 == 14) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i6 == 1 || i6 == 3 || i6 == 6 || i6 == 8 || i6 == 10 || i6 == 12 || i6 == 14) ? 2 : 3];
        if (i6 == 1 || i6 == 3 || i6 == 6 || i6 == 8 || i6 == 10 || i6 == 12 || i6 == 14) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/BitEncoding";
        } else {
            objArr[0] = "data";
        }
        if (i6 == 1) {
            objArr[1] = "encodeBytes";
        } else if (i6 == 3) {
            objArr[1] = "encode8to7";
        } else if (i6 == 6) {
            objArr[1] = "splitBytesToStringArray";
        } else if (i6 == 8) {
            objArr[1] = "decodeBytes";
        } else if (i6 == 10) {
            objArr[1] = "dropMarker";
        } else if (i6 == 12) {
            objArr[1] = "combineStringArrayIntoBytes";
        } else if (i6 != 14) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/BitEncoding";
        } else {
            objArr[1] = "decode7to8";
        }
        switch (i6) {
            case 1:
            case 3:
            case 6:
            case 8:
            case 10:
            case 12:
            case 14:
                break;
            case 2:
                objArr[2] = "encode8to7";
                break;
            case 4:
                objArr[2] = "addModuloByte";
                break;
            case 5:
                objArr[2] = "splitBytesToStringArray";
                break;
            case 7:
                objArr[2] = "decodeBytes";
                break;
            case 9:
                objArr[2] = "dropMarker";
                break;
            case 11:
                objArr[2] = "combineStringArrayIntoBytes";
                break;
            case 13:
                objArr[2] = "decode7to8";
                break;
            default:
                objArr[2] = "encodeBytes";
                break;
        }
        String format = String.format(str, objArr);
        if (i6 != 1 && i6 != 3 && i6 != 6 && i6 != 8 && i6 != 10 && i6 != 12 && i6 != 14) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    private static void b(@NotNull byte[] bArr, int i6) {
        if (bArr == null) {
            a(4);
        }
        int length = bArr.length;
        for (int i7 = 0; i7 < length; i7++) {
            bArr[i7] = (byte) ((bArr[i7] + i6) & 127);
        }
    }

    @NotNull
    private static byte[] c(@NotNull String[] strArr) {
        if (strArr == null) {
            a(11);
        }
        int i6 = 0;
        for (String str : strArr) {
            i6 += str.length();
        }
        byte[] bArr = new byte[i6];
        int i7 = 0;
        for (String str2 : strArr) {
            int length = str2.length();
            int i8 = 0;
            while (i8 < length) {
                bArr[i7] = (byte) str2.charAt(i8);
                i8++;
                i7++;
            }
        }
        return bArr;
    }

    @NotNull
    private static byte[] d(@NotNull byte[] bArr) {
        if (bArr == null) {
            a(13);
        }
        int length = (bArr.length * 7) / 8;
        byte[] bArr2 = new byte[length];
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < length; i8++) {
            int i9 = i6 + 1;
            int i10 = i7 + 1;
            bArr2[i8] = (byte) (((bArr[i6] & 255) >>> i7) + ((bArr[i9] & ((1 << i10) - 1)) << (7 - i7)));
            if (i7 == 6) {
                i6 += 2;
                i7 = 0;
            } else {
                i6 = i9;
                i7 = i10;
            }
        }
        return bArr2;
    }

    @NotNull
    public static byte[] e(@NotNull String[] strArr) {
        if (strArr == null) {
            a(7);
        }
        if (strArr.length > 0 && !strArr[0].isEmpty()) {
            char charAt = strArr[0].charAt(0);
            if (charAt == 0) {
                byte[] a6 = i.a(f(strArr));
                if (a6 == null) {
                    a(8);
                }
                return a6;
            }
            if (charAt == 65535) {
                strArr = f(strArr);
            }
        }
        byte[] c6 = c(strArr);
        b(c6, 127);
        return d(c6);
    }

    @NotNull
    private static String[] f(@NotNull String[] strArr) {
        if (strArr == null) {
            a(9);
        }
        String[] strArr2 = (String[]) strArr.clone();
        strArr2[0] = strArr2[0].substring(1);
        return strArr2;
    }

    private a() {
    }
}
