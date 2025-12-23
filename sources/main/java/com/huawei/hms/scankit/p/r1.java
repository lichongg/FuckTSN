package com.huawei.hms.scankit.p;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
final class r1 {

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f34728a = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ $%*+-./:".toCharArray();

    static w1 a(byte[] bArr, b8 b8Var, b3 b3Var, Map<l1, ?> map) throws com.huawei.hms.scankit.p.a {
        int i6;
        int i7;
        w wVar = new w(bArr);
        StringBuilder sb = new StringBuilder(50);
        ArrayList arrayList = new ArrayList(1);
        int i8 = -1;
        int i9 = -1;
        int i10 = 0;
        while (true) {
            try {
                int[] iArr = {i10, i8, i9};
                u4 a6 = wVar.a() < 4 ? u4.TERMINATOR : u4.a(wVar.a(4));
                a(a6, wVar, sb, b8Var, iArr, null, arrayList, map);
                int i11 = iArr[0] == 1 ? 1 : 0;
                i6 = iArr[1];
                i7 = iArr[2];
                if (a6 == u4.TERMINATOR) {
                    break;
                }
                i10 = i11;
                i8 = i6;
                i9 = i7;
            } catch (IllegalArgumentException unused) {
                throw com.huawei.hms.scankit.p.a.a();
            }
        }
        return new w1(bArr, sb.toString(), arrayList.isEmpty() ? null : arrayList, b3Var != null ? b3Var.toString() : null, i6, i7);
    }

    private static void c(w wVar, StringBuilder sb, int i6) throws com.huawei.hms.scankit.p.a {
        while (i6 >= 3) {
            if (wVar.a() < 10) {
                throw com.huawei.hms.scankit.p.a.a();
            }
            int a6 = wVar.a(10);
            if (a6 >= 1000) {
                throw com.huawei.hms.scankit.p.a.a();
            }
            sb.append(a(a6 / 100));
            sb.append(a((a6 / 10) % 10));
            sb.append(a(a6 % 10));
            i6 -= 3;
        }
        if (i6 == 2) {
            if (wVar.a() < 7) {
                throw com.huawei.hms.scankit.p.a.a();
            }
            int a7 = wVar.a(7);
            if (a7 >= 100) {
                throw com.huawei.hms.scankit.p.a.a();
            }
            sb.append(a(a7 / 10));
            sb.append(a(a7 % 10));
            return;
        }
        if (i6 == 1) {
            if (wVar.a() < 4) {
                throw com.huawei.hms.scankit.p.a.a();
            }
            int a8 = wVar.a(4);
            if (a8 >= 10) {
                throw com.huawei.hms.scankit.p.a.a();
            }
            sb.append(a(a8));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f34729a;

        static {
            int[] iArr = new int[u4.values().length];
            f34729a = iArr;
            try {
                iArr[u4.NUMERIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f34729a[u4.ALPHANUMERIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f34729a[u4.BYTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f34729a[u4.KANJI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f34729a[u4.TERMINATOR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f34729a[u4.FNC1_FIRST_POSITION.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f34729a[u4.FNC1_SECOND_POSITION.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f34729a[u4.STRUCTURED_APPEND.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f34729a[u4.ECI.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f34729a[u4.HANZI.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    private static void b(w wVar, StringBuilder sb, int i6) throws com.huawei.hms.scankit.p.a {
        if (i6 * 13 > wVar.a()) {
            throw com.huawei.hms.scankit.p.a.a();
        }
        byte[] bArr = new byte[i6 * 2];
        int i7 = 0;
        while (i6 > 0) {
            int a6 = wVar.a(13);
            int i8 = (a6 % 192) | ((a6 / 192) << 8);
            int i9 = i8 + (i8 < 7936 ? 33088 : 49472);
            if (w7.a(bArr, i7)) {
                int i10 = i7 + 1;
                if (w7.a(bArr, i10)) {
                    bArr[i7] = (byte) (i9 >> 8);
                    bArr[i10] = (byte) i9;
                    i7 += 2;
                    i6--;
                }
            }
            throw new ArrayIndexOutOfBoundsException();
        }
        try {
            sb.append(new String(bArr, "SJIS"));
        } catch (UnsupportedEncodingException unused) {
            throw com.huawei.hms.scankit.p.a.a();
        }
    }

    private static void a(u4 u4Var, w wVar, StringBuilder sb, b8 b8Var, int[] iArr, o0 o0Var, List<byte[]> list, Map<l1, ?> map) throws com.huawei.hms.scankit.p.a {
        int[] iArr2 = a.f34729a;
        switch (iArr2[u4Var.ordinal()]) {
            case 5:
                return;
            case 6:
            case 7:
                iArr[0] = 1;
                return;
            case 8:
                if (wVar.a() >= 16) {
                    iArr[1] = wVar.a(8);
                    iArr[2] = wVar.a(8);
                    return;
                }
                throw com.huawei.hms.scankit.p.a.a();
            case 9:
                if (o0.a(a(wVar)) == null) {
                    throw com.huawei.hms.scankit.p.a.a();
                }
                return;
            case 10:
                int a6 = wVar.a(4);
                int a7 = wVar.a(u4Var.a(b8Var));
                if (a6 == 1) {
                    a(wVar, sb, a7);
                    return;
                }
                return;
            default:
                int a8 = wVar.a(u4Var.a(b8Var));
                int i6 = iArr2[u4Var.ordinal()];
                if (i6 == 1) {
                    c(wVar, sb, a8);
                    return;
                }
                if (i6 == 2) {
                    a(wVar, sb, a8, iArr[0] == 1);
                    return;
                } else if (i6 == 3) {
                    a(wVar, sb, a8, o0Var, list, map);
                    return;
                } else {
                    if (i6 == 4) {
                        b(wVar, sb, a8);
                        return;
                    }
                    throw com.huawei.hms.scankit.p.a.a();
                }
        }
    }

    private static void a(w wVar, StringBuilder sb, int i6) throws com.huawei.hms.scankit.p.a {
        if (i6 * 13 <= wVar.a()) {
            byte[] bArr = new byte[i6 * 2];
            int i7 = 0;
            while (i6 > 0) {
                int a6 = wVar.a(13);
                int i8 = (a6 % 96) | ((a6 / 96) << 8);
                int i9 = i8 + (i8 < 959 ? 41377 : 42657);
                if (w7.a(bArr, i7)) {
                    int i10 = i7 + 1;
                    if (w7.a(bArr, i10)) {
                        bArr[i7] = (byte) ((i9 >> 8) & 255);
                        bArr[i10] = (byte) (i9 & 255);
                        i7 += 2;
                        i6--;
                    }
                }
                throw new ArrayIndexOutOfBoundsException();
            }
            try {
                sb.append(new String(bArr, "GB2312"));
                return;
            } catch (UnsupportedEncodingException unused) {
                throw com.huawei.hms.scankit.p.a.a();
            }
        }
        throw com.huawei.hms.scankit.p.a.a();
    }

    private static void a(w wVar, StringBuilder sb, int i6, o0 o0Var, Collection<byte[]> collection, Map<l1, ?> map) throws com.huawei.hms.scankit.p.a {
        String name;
        if (i6 * 8 <= wVar.a()) {
            byte[] bArr = new byte[i6];
            for (int i7 = 0; i7 < i6; i7++) {
                bArr[i7] = (byte) wVar.a(8);
            }
            if (o0Var == null) {
                name = c7.a(bArr, map);
            } else {
                name = o0Var.name();
            }
            try {
                sb.append(new String(bArr, name));
                collection.add(bArr);
                return;
            } catch (UnsupportedEncodingException unused) {
                throw com.huawei.hms.scankit.p.a.a();
            }
        }
        throw com.huawei.hms.scankit.p.a.a();
    }

    private static char a(int i6) throws com.huawei.hms.scankit.p.a {
        char[] cArr = f34728a;
        if (i6 < cArr.length) {
            return cArr[i6];
        }
        throw com.huawei.hms.scankit.p.a.a();
    }

    private static void a(w wVar, StringBuilder sb, int i6, boolean z5) throws com.huawei.hms.scankit.p.a {
        while (i6 > 1) {
            if (wVar.a() >= 11) {
                int a6 = wVar.a(11);
                sb.append(a(a6 / 45));
                sb.append(a(a6 % 45));
                i6 -= 2;
            } else {
                throw com.huawei.hms.scankit.p.a.a();
            }
        }
        if (i6 == 1) {
            if (wVar.a() >= 6) {
                sb.append(a(wVar.a(6)));
            } else {
                throw com.huawei.hms.scankit.p.a.a();
            }
        }
        if (z5) {
            for (int length = sb.length(); length < sb.length(); length++) {
                if (sb.charAt(length) == '%') {
                    if (length < sb.length() - 1) {
                        int i7 = length + 1;
                        if (sb.charAt(i7) == '%') {
                            sb.deleteCharAt(i7);
                        }
                    }
                    sb.setCharAt(length, (char) 29);
                }
            }
        }
    }

    private static int a(w wVar) throws com.huawei.hms.scankit.p.a {
        int a6 = wVar.a(8);
        if ((a6 & 128) == 0) {
            return a6 & 127;
        }
        if ((a6 & 192) == 128) {
            return wVar.a(8) | ((a6 & 63) << 8);
        }
        if ((a6 & 224) == 192) {
            return wVar.a(16) | ((a6 & 31) << 16);
        }
        throw com.huawei.hms.scankit.p.a.a();
    }
}
