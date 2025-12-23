package com.huawei.hms.scankit.p;

import com.alibaba.fastjson.asm.Opcodes;
import com.google.common.base.Ascii;
import io.netty.util.internal.StringUtil;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
final class o1 {

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f34627a = {'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    /* renamed from: b, reason: collision with root package name */
    private static final char[] f34628b;

    /* renamed from: c, reason: collision with root package name */
    private static final char[] f34629c;

    /* renamed from: d, reason: collision with root package name */
    private static final char[] f34630d;

    /* renamed from: e, reason: collision with root package name */
    private static final char[] f34631e;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private enum b {
        PAD_ENCODE,
        ASCII_ENCODE,
        C40_ENCODE,
        TEXT_ENCODE,
        ANSIX12_ENCODE,
        EDIFACT_ENCODE,
        BASE256_ENCODE,
        UPPER_ENCODE
    }

    static w1 a(byte[] bArr, Map<l1, ?> map) throws com.huawei.hms.scankit.p.a {
        w wVar = new w(bArr);
        StringBuilder sb = new StringBuilder(100);
        StringBuilder sb2 = new StringBuilder(0);
        ArrayList arrayList = new ArrayList(1);
        b bVar = b.ASCII_ENCODE;
        do {
            b bVar2 = b.ASCII_ENCODE;
            if (bVar == bVar2) {
                bVar = a(wVar, sb, sb2);
            } else {
                int i6 = a.f34632a[bVar.ordinal()];
                if (i6 == 1) {
                    b(wVar, sb);
                } else if (i6 == 2) {
                    d(wVar, sb);
                } else if (i6 == 3) {
                    a(wVar, sb);
                } else if (i6 == 4) {
                    c(wVar, sb);
                } else {
                    if (i6 != 5) {
                        throw com.huawei.hms.scankit.p.a.a("AIScanException");
                    }
                    a(wVar, sb, arrayList);
                }
                bVar = bVar2;
            }
            if (bVar == b.PAD_ENCODE) {
                break;
            }
        } while (wVar.a() > 0);
        if (sb2.length() > 0) {
            sb.append((CharSequence) sb2);
        }
        int length = sb.length();
        byte[] bArr2 = new byte[length];
        for (int i7 = 0; i7 < length; i7++) {
            bArr2[i7] = (byte) sb.charAt(i7);
        }
        try {
            String str = new String(bArr2, c7.a(bArr2, map));
            if (arrayList.isEmpty()) {
                arrayList = null;
            }
            return new w1(bArr, str, arrayList, null);
        } catch (UnsupportedEncodingException unused) {
            throw com.huawei.hms.scankit.p.a.a();
        }
    }

    private static void b(w wVar, StringBuilder sb) throws com.huawei.hms.scankit.p.a {
        int a6;
        int[] iArr = new int[3];
        boolean z5 = false;
        int i6 = 0;
        while (wVar.a() != 8 && (a6 = wVar.a(8)) != 254) {
            a(a6, wVar.a(8), iArr);
            for (int i7 = 0; i7 < 3; i7++) {
                int[] b6 = b(sb, i6, iArr[i7], z5);
                i6 = b6[0];
                z5 = b6[1] == 1;
            }
            if (wVar.a() <= 0) {
                return;
            }
        }
    }

    private static void d(w wVar, StringBuilder sb) throws com.huawei.hms.scankit.p.a {
        int a6;
        int[] iArr = new int[3];
        boolean z5 = false;
        int i6 = 0;
        while (wVar.a() != 8 && (a6 = wVar.a(8)) != 254) {
            a(a6, wVar.a(8), iArr);
            for (int i7 = 0; i7 < 3; i7++) {
                int[] a7 = a(sb, i6, iArr[i7], z5);
                i6 = a7[0];
                z5 = a7[1] == 1;
            }
            if (wVar.a() <= 0) {
                return;
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f34632a;

        static {
            int[] iArr = new int[b.values().length];
            f34632a = iArr;
            try {
                iArr[b.C40_ENCODE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f34632a[b.TEXT_ENCODE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f34632a[b.ANSIX12_ENCODE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f34632a[b.EDIFACT_ENCODE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f34632a[b.BASE256_ENCODE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    static {
        char[] cArr = {'!', '\"', '#', kotlin.text.v0.f47959c, '%', kotlin.text.v0.f47960d, '\'', '(', ')', '*', '+', StringUtil.COMMA, '-', '.', '/', ':', ';', kotlin.text.v0.f47961e, '=', kotlin.text.v0.f47962f, '?', '@', '[', '\\', ']', '^', '_'};
        f34628b = cArr;
        f34629c = new char[]{'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        f34630d = cArr;
        f34631e = new char[]{'`', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '{', '|', '}', '~', Ascii.MAX};
    }

    private static void c(w wVar, StringBuilder sb) {
        while (wVar.a() > 16) {
            for (int i6 = 0; i6 < 4; i6++) {
                int a6 = wVar.a(6);
                if (a6 == 31) {
                    int b6 = 8 - wVar.b();
                    if (b6 != 8) {
                        wVar.a(b6);
                        return;
                    }
                    return;
                }
                if ((a6 & 32) == 0) {
                    a6 |= 64;
                }
                sb.append((char) a6);
            }
            if (wVar.a() <= 0) {
                return;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static int[] b(StringBuilder sb, int i6, int i7, boolean z5) throws com.huawei.hms.scankit.p.a {
        int i8;
        boolean z6;
        if (i6 == 0) {
            if (i7 >= 3) {
                char[] cArr = f34627a;
                if (i7 < cArr.length) {
                    char c6 = cArr[i7];
                    if (z5) {
                        c6 = (char) (c6 + 128);
                    }
                    sb.append(c6);
                    i8 = 0;
                    return new int[]{i6, i8};
                }
                throw com.huawei.hms.scankit.p.a.a("AIScanException");
            }
            i6 = i7 + 1;
            i8 = z5;
            return new int[]{i6, i8};
        }
        if (i6 == 1) {
            if (z5) {
                i7 += 128;
            }
            sb.append((char) i7);
        } else {
            if (i6 == 2) {
                char[] cArr2 = f34628b;
                if (i7 < cArr2.length) {
                    char c7 = cArr2[i7];
                    if (z5) {
                        c7 = (char) (c7 + 128);
                    }
                    sb.append(c7);
                    z6 = false;
                } else if (i7 == 27) {
                    sb.append((char) 29);
                    z6 = z5;
                } else {
                    if (i7 != 30) {
                        throw com.huawei.hms.scankit.p.a.a("AIScanException");
                    }
                    z6 = true;
                }
                i6 = 0;
                i8 = z6;
                return new int[]{i6, i8};
            }
            if (i6 == 3) {
                sb.append((char) (z5 ? i7 + 224 : i7 + 96));
            } else {
                throw com.huawei.hms.scankit.p.a.a("AIScanException");
            }
        }
        i6 = 0;
        i8 = 0;
        return new int[]{i6, i8};
    }

    private static b a(w wVar, StringBuilder sb, StringBuilder sb2) throws com.huawei.hms.scankit.p.a {
        boolean z5 = false;
        do {
            int a6 = wVar.a(8);
            if (a6 == 0) {
                throw com.huawei.hms.scankit.p.a.a("AIScanException");
            }
            if (a6 <= 128) {
                if (z5) {
                    a6 += 128;
                }
                sb.append((char) (a6 - 1));
                return b.ASCII_ENCODE;
            }
            if (a6 == 129) {
                return b.PAD_ENCODE;
            }
            if (a6 <= 229) {
                int i6 = a6 - 130;
                if (i6 < 10) {
                    sb.append('0');
                }
                sb.append(i6);
            } else {
                b a7 = a(a6, sb, sb2, wVar);
                if (a7 != null) {
                    if (a7 != b.UPPER_ENCODE) {
                        return a7;
                    }
                    z5 = true;
                }
            }
        } while (wVar.a() > 0);
        return b.ASCII_ENCODE;
    }

    private static b a(int i6, StringBuilder sb, StringBuilder sb2, w wVar) throws com.huawei.hms.scankit.p.a {
        switch (i6) {
            case 230:
                return b.C40_ENCODE;
            case 231:
                return b.BASE256_ENCODE;
            case 232:
                sb.append((char) 29);
                return null;
            case 233:
            case org.apache.commons.net.ftp.l.O /* 234 */:
            case 241:
                return null;
            case 235:
                return b.UPPER_ENCODE;
            case org.apache.commons.net.telnet.f.f51105u /* 236 */:
                sb.append("[)>\u001e05\u001d");
                sb2.insert(0, "\u001e\u0004");
                return null;
            case org.apache.commons.net.telnet.f.f51104t /* 237 */:
                sb.append("[)>\u001e06\u001d");
                sb2.insert(0, "\u001e\u0004");
                return null;
            case org.apache.commons.net.telnet.f.f51103s /* 238 */:
                return b.ANSIX12_ENCODE;
            case org.apache.commons.net.telnet.f.f51102r /* 239 */:
                return b.TEXT_ENCODE;
            case 240:
                return b.EDIFACT_ENCODE;
            default:
                if (i6 == 254 && wVar.a() == 0) {
                    return null;
                }
                throw com.huawei.hms.scankit.p.a.a("AIScanException");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static int[] a(StringBuilder sb, int i6, int i7, boolean z5) throws com.huawei.hms.scankit.p.a {
        int i8;
        boolean z6;
        if (i6 == 0) {
            if (i7 >= 3) {
                char[] cArr = f34629c;
                if (i7 < cArr.length) {
                    char c6 = cArr[i7];
                    if (z5) {
                        c6 = (char) (c6 + 128);
                    }
                    sb.append(c6);
                    i8 = 0;
                    return new int[]{i6, i8};
                }
                throw com.huawei.hms.scankit.p.a.a("AIScanException");
            }
            i6 = i7 + 1;
            i8 = z5;
            return new int[]{i6, i8};
        }
        if (i6 == 1) {
            if (z5) {
                i7 = (char) (i7 + 128);
            }
            sb.append(i7);
        } else {
            if (i6 == 2) {
                char[] cArr2 = f34630d;
                if (i7 < cArr2.length) {
                    char c7 = cArr2[i7];
                    if (z5) {
                        c7 = (char) (c7 + 128);
                    }
                    sb.append(c7);
                    z6 = false;
                } else if (i7 == 27) {
                    sb.append((char) 29);
                    z6 = z5;
                } else {
                    if (i7 != 30) {
                        throw com.huawei.hms.scankit.p.a.a("AIScanException");
                    }
                    z6 = true;
                }
                i6 = 0;
                i8 = z6;
                return new int[]{i6, i8};
            }
            if (i6 == 3) {
                char[] cArr3 = f34631e;
                if (i7 < cArr3.length) {
                    char c8 = cArr3[i7];
                    if (z5) {
                        c8 = (char) (c8 + 128);
                    }
                    sb.append(c8);
                } else {
                    throw com.huawei.hms.scankit.p.a.a("AIScanException");
                }
            } else {
                throw com.huawei.hms.scankit.p.a.a("AIScanException");
            }
        }
        i6 = 0;
        i8 = 0;
        return new int[]{i6, i8};
    }

    private static void a(w wVar, StringBuilder sb) throws com.huawei.hms.scankit.p.a {
        int a6;
        int[] iArr = new int[3];
        while (wVar.a() != 8 && (a6 = wVar.a(8)) != 254) {
            a(a6, wVar.a(8), iArr);
            for (int i6 = 0; i6 < 3; i6++) {
                int i7 = iArr[i6];
                if (i7 == 0) {
                    sb.append(StringUtil.CARRIAGE_RETURN);
                } else if (i7 == 1) {
                    sb.append('*');
                } else if (i7 == 2) {
                    sb.append(kotlin.text.v0.f47962f);
                } else if (i7 == 3) {
                    sb.append(' ');
                } else if (i7 < 14) {
                    sb.append((char) (i7 + 44));
                } else if (i7 < 40) {
                    sb.append((char) (i7 + 51));
                } else {
                    throw com.huawei.hms.scankit.p.a.a("AIScanException");
                }
            }
            if (wVar.a() <= 0) {
                return;
            }
        }
    }

    private static void a(int i6, int i7, int[] iArr) {
        int i8 = ((i6 << 8) + i7) - 1;
        int i9 = i8 / 1600;
        iArr[0] = i9;
        int i10 = i8 - (i9 * 1600);
        int i11 = i10 / 40;
        iArr[1] = i11;
        iArr[2] = i10 - (i11 * 40);
    }

    private static void a(w wVar, StringBuilder sb, Collection<byte[]> collection) throws com.huawei.hms.scankit.p.a {
        int c6 = wVar.c();
        int i6 = c6 + 2;
        int a6 = a(wVar.a(8), c6 + 1);
        if (a6 == 0) {
            a6 = wVar.a() / 8;
        } else if (a6 >= 250) {
            a6 = ((a6 - 249) * 250) + a(wVar.a(8), i6);
            i6 = c6 + 3;
        }
        if (a6 >= 0) {
            byte[] bArr = new byte[a6];
            int i7 = 0;
            while (i7 < a6) {
                if (wVar.a() >= 8) {
                    bArr[i7] = (byte) a(wVar.a(8), i6);
                    i7++;
                    i6++;
                } else {
                    throw com.huawei.hms.scankit.p.a.a("AIScanException");
                }
            }
            collection.add(bArr);
            try {
                sb.append(new String(bArr, "ISO8859_1"));
                return;
            } catch (UnsupportedEncodingException e6) {
                throw new IllegalStateException("Platform does not support required encoding: " + e6);
            }
        }
        throw com.huawei.hms.scankit.p.a.a("AIScanException");
    }

    private static int a(int i6, int i7) {
        int i8 = i6 - (((i7 * Opcodes.FCMPL) % 255) + 1);
        return i8 >= 0 ? i8 : i8 + 256;
    }
}
