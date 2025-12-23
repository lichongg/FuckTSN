package com.huawei.hms.scankit.p;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
final class p1 {

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f34675a = "0123456789abcdefghijklmnopqrstuvwxyz !-./:=?T".toCharArray();

    /* renamed from: b, reason: collision with root package name */
    private static final char[] f34676b = "0123456789ABCDEF".toCharArray();

    static w1 a(byte[] bArr, a8 a8Var, c3 c3Var, Map<l1, ?> map) throws com.huawei.hms.scankit.p.a {
        v4 a6;
        w wVar = new w(bArr);
        StringBuilder sb = new StringBuilder(50);
        ArrayList arrayList = new ArrayList(1);
        int i6 = -1;
        o0 o0Var = null;
        int i7 = -1;
        boolean z5 = false;
        do {
            try {
                a6 = wVar.a() < 4 ? v4.TERMINATOR : v4.a(wVar.a(4));
                switch (a.f34677a[a6.ordinal()]) {
                    case 1:
                        break;
                    case 2:
                    case 3:
                        z5 = true;
                        break;
                    case 4:
                        if (wVar.a() < 16) {
                            throw com.huawei.hms.scankit.p.a.a();
                        }
                        int a7 = wVar.a(8);
                        i7 = wVar.a(8);
                        i6 = a7;
                        break;
                    case 5:
                        o0Var = a(wVar);
                        break;
                    case 6:
                        a(a8Var, wVar, sb, a6);
                        break;
                    default:
                        a(a(a8Var, map, wVar, sb), arrayList, o0Var, z5, a6);
                        break;
                }
            } catch (IllegalArgumentException unused) {
                throw com.huawei.hms.scankit.p.a.a();
            }
        } while (a6 != v4.TERMINATOR);
        String sb2 = sb.toString();
        if (arrayList.isEmpty()) {
            arrayList = null;
        }
        return new w1(bArr, sb2, arrayList, c3Var != null ? c3Var.toString() : null, i6, i7);
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
            bArr[i7] = (byte) (i9 >> 8);
            bArr[i7 + 1] = (byte) i9;
            i7 += 2;
            i6--;
        }
        try {
            sb.append(new String(bArr, "SJIS"));
        } catch (UnsupportedEncodingException unused) {
            throw com.huawei.hms.scankit.p.a.a();
        }
    }

    private static void c(w wVar, StringBuilder sb, int i6, boolean z5) throws com.huawei.hms.scankit.p.a {
        while (i6 > 1) {
            if (wVar.a() < 8) {
                throw com.huawei.hms.scankit.p.a.a();
            }
            int a6 = wVar.a(8);
            sb.append(b(a6 / 16));
            sb.append(b(a6 % 16));
            i6 -= 2;
        }
        if (i6 == 1) {
            if (wVar.a() < 4) {
                throw com.huawei.hms.scankit.p.a.a();
            }
            sb.append(b(wVar.a(4)));
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

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f34677a;

        static {
            int[] iArr = new int[v4.values().length];
            f34677a = iArr;
            try {
                iArr[v4.TERMINATOR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f34677a[v4.FNC1_FIRST_POSITION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f34677a[v4.FNC1_SECOND_POSITION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f34677a[v4.STRUCTURED_APPEND.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f34677a[v4.ECI.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f34677a[v4.HANZI.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f34677a[v4.NUMERIC.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f34677a[v4.ALPHANUMERIC.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f34677a[v4.HEXADECIMAL.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f34677a[v4.HEXABYTE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f34677a[v4.BYTE.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f34677a[v4.KANJI.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    private static char b(int i6) throws com.huawei.hms.scankit.p.a {
        char[] cArr = f34676b;
        if (i6 < cArr.length) {
            return cArr[i6];
        }
        throw com.huawei.hms.scankit.p.a.a();
    }

    private static void b(w wVar, StringBuilder sb, int i6, boolean z5) throws com.huawei.hms.scankit.p.a {
        while (i6 > 1) {
            if (wVar.a() >= 8) {
                int a6 = wVar.a(8);
                sb.append(b(a6 / 16));
                sb.append(b(a6 % 16));
                i6 -= 2;
            } else {
                throw com.huawei.hms.scankit.p.a.a();
            }
        }
        if (i6 == 1) {
            if (wVar.a() >= 4) {
                sb.append(b(wVar.a(4)));
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

    private static void c(w wVar, StringBuilder sb, int i6) throws com.huawei.hms.scankit.p.a {
        while (i6 >= 3) {
            if (wVar.a() >= 10) {
                int a6 = wVar.a(10);
                if (a6 < 1000) {
                    sb.append(a(a6 / 100));
                    sb.append(a((a6 / 10) % 10));
                    sb.append(a(a6 % 10));
                    i6 -= 3;
                } else {
                    throw com.huawei.hms.scankit.p.a.a();
                }
            } else {
                throw com.huawei.hms.scankit.p.a.a();
            }
        }
        if (i6 == 2) {
            if (wVar.a() >= 7) {
                int a7 = wVar.a(7);
                if (a7 < 100) {
                    sb.append(a(a7 / 10));
                    sb.append(a(a7 % 10));
                    return;
                }
                throw com.huawei.hms.scankit.p.a.a();
            }
            throw com.huawei.hms.scankit.p.a.a();
        }
        if (i6 == 1) {
            if (wVar.a() >= 4) {
                int a8 = wVar.a(4);
                if (a8 < 10) {
                    sb.append(a(a8));
                    return;
                }
                throw com.huawei.hms.scankit.p.a.a();
            }
            throw com.huawei.hms.scankit.p.a.a();
        }
    }

    private static z0 a(a8 a8Var, Map<l1, ?> map, w wVar, StringBuilder sb) {
        return new z0(a8Var, map, wVar, sb);
    }

    private static void a(z0 z0Var, List<byte[]> list, o0 o0Var, boolean z5, v4 v4Var) throws com.huawei.hms.scankit.p.a {
        a(new h7(z0Var.f35059b, z0Var.f35060c, z0Var.f35061d, list), o0Var, z5, v4Var, z0Var.f35060c.a(v4Var.a(z0Var.f35058a)));
    }

    private static o0 a(w wVar) throws com.huawei.hms.scankit.p.a {
        o0 a6 = o0.a(b(wVar));
        a(a6);
        return a6;
    }

    private static int b(w wVar) throws com.huawei.hms.scankit.p.a {
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

    private static void a(o0 o0Var) throws com.huawei.hms.scankit.p.a {
        if (o0Var == null) {
            throw com.huawei.hms.scankit.p.a.a();
        }
    }

    private static void a(a8 a8Var, w wVar, StringBuilder sb, v4 v4Var) throws com.huawei.hms.scankit.p.a {
        int a6 = wVar.a(4);
        int a7 = wVar.a(v4Var.a(a8Var));
        if (a6 == 1) {
            a(wVar, sb, a7);
        }
    }

    private static void a(h7 h7Var, o0 o0Var, boolean z5, v4 v4Var, int i6) throws com.huawei.hms.scankit.p.a {
        switch (a.f34677a[v4Var.ordinal()]) {
            case 7:
                c(h7Var.f34350b, h7Var.f34351c, i6);
                return;
            case 8:
                a(h7Var.f34350b, h7Var.f34351c, i6, z5);
                return;
            case 9:
                c(h7Var.f34350b, h7Var.f34351c, i6, z5);
                return;
            case 10:
                b(h7Var.f34350b, h7Var.f34351c, i6, z5);
                return;
            case 11:
                a(new b0(h7Var.f34350b, h7Var.f34351c), i6, o0Var, h7Var.f34352d, h7Var.f34349a);
                return;
            case 12:
                b(h7Var.f34350b, h7Var.f34351c, i6);
                return;
            default:
                throw com.huawei.hms.scankit.p.a.a();
        }
    }

    private static void a(w wVar, StringBuilder sb, int i6) throws com.huawei.hms.scankit.p.a {
        if (i6 * 13 <= wVar.a()) {
            byte[] bArr = new byte[i6 * 2];
            int i7 = 0;
            while (i6 > 0) {
                int a6 = wVar.a(13);
                int i8 = (a6 % 96) | ((a6 / 96) << 8);
                int i9 = i8 + (i8 < 2560 ? 41377 : 42657);
                bArr[i7] = (byte) ((i9 >> 8) & 255);
                bArr[i7 + 1] = (byte) (i9 & 255);
                i7 += 2;
                i6--;
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

    private static void a(b0 b0Var, int i6, o0 o0Var, Collection<byte[]> collection, Map<l1, ?> map) throws com.huawei.hms.scankit.p.a {
        String name;
        if (i6 * 8 <= b0Var.f34004a.a()) {
            byte[] bArr = new byte[i6];
            for (int i7 = 0; i7 < i6; i7++) {
                bArr[i7] = (byte) b0Var.f34004a.a(8);
            }
            if (o0Var == null) {
                name = c7.a(bArr, map);
            } else {
                name = o0Var.name();
            }
            try {
                b0Var.f34005b.append(new String(bArr, name));
                collection.add(bArr);
                return;
            } catch (UnsupportedEncodingException unused) {
                throw com.huawei.hms.scankit.p.a.a();
            }
        }
        throw com.huawei.hms.scankit.p.a.a();
    }

    private static char a(int i6) throws com.huawei.hms.scankit.p.a {
        char[] cArr = f34675a;
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
}
