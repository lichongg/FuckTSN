package com.huawei.hms.scankit.p;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.huawei.hms.common.util.Logger;
import com.huawei.hms.framework.common.ContainerUtils;
import com.umeng.analytics.pro.bi;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Map;
import org.slf4j.Marker;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class s1 {

    /* renamed from: b, reason: collision with root package name */
    private static final String[] f34767b = {"CTRL_PS", " ", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.LONGITUDE_WEST, "X", "Y", "Z", "CTRL_LL", "CTRL_ML", "CTRL_DL", "CTRL_BS"};

    /* renamed from: c, reason: collision with root package name */
    private static final String[] f34768c = {"CTRL_PS", " ", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", com.kuaishou.weapon.p0.t.f36143d, com.kuaishou.weapon.p0.t.f36152m, "n", "o", "p", "q", com.kuaishou.weapon.p0.t.f36150k, "s", bi.aL, "u", "v", IAdInterListener.AdReqParam.WIDTH, "x", "y", bi.aG, "CTRL_US", "CTRL_ML", "CTRL_DL", "CTRL_BS"};

    /* renamed from: d, reason: collision with root package name */
    private static final String[] f34769d = {"CTRL_PS", " ", "\u0001", "\u0002", "\u0003", "\u0004", "\u0005", "\u0006", "\u0007", "\b", "\t", com.snail.antifake.deviceid.e.f37542d, "\u000b", "\f", "\r", "\u001b", "\u001c", "\u001d", "\u001e", "\u001f", "@", "\\", "^", "_", "`", Logger.f33116c, "~", "\u007f", "CTRL_LL", "CTRL_UL", "CTRL_PL", "CTRL_BS"};

    /* renamed from: e, reason: collision with root package name */
    private static final String[] f34770e = {"", "\r", org.apache.commons.net.g.f50795q, ". ", ", ", ": ", "!", "\"", "#", "$", "%", ContainerUtils.FIELD_DELIMITER, "'", "(", ")", "*", Marker.ANY_NON_NULL_MARKER, ",", "-", ".", "/", ":", ";", "<", ContainerUtils.KEY_VALUE_DELIMITER, ">", "?", "[", "]", "{", "}", "CTRL_UL"};

    /* renamed from: f, reason: collision with root package name */
    private static final String[] f34771f = {"CTRL_PS", " ", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ",", ".", "CTRL_UL", "CTRL_US"};

    /* renamed from: a, reason: collision with root package name */
    private g f34772a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private enum b {
        UPPER,
        LOWER,
        MIXED,
        DIGIT,
        PUNCT,
        BINARY
    }

    private static int a(int i6, boolean z5) {
        return ((z5 ? 88 : 112) + (i6 * 16)) * i6;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f34773a;

        static {
            int[] iArr = new int[b.values().length];
            f34773a = iArr;
            try {
                iArr[b.UPPER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f34773a[b.LOWER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f34773a[b.MIXED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f34773a[b.PUNCT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f34773a[b.DIGIT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private boolean[] b(boolean[] zArr) throws com.huawei.hms.scankit.p.a {
        int i6;
        o3 o3Var;
        g gVar = this.f34772a;
        if (gVar == null) {
            throw com.huawei.hms.scankit.p.a.a();
        }
        if (gVar.f() <= 2) {
            o3Var = o3.f34647j;
            i6 = 6;
        } else {
            i6 = 8;
            if (this.f34772a.f() <= 8) {
                o3Var = o3.f34651n;
            } else if (this.f34772a.f() <= 22) {
                o3Var = o3.f34646i;
                i6 = 10;
            } else {
                o3Var = o3.f34645h;
                i6 = 12;
            }
        }
        int e6 = this.f34772a.e();
        int length = zArr.length / i6;
        if (length < e6) {
            throw com.huawei.hms.scankit.p.a.a();
        }
        int length2 = zArr.length % i6;
        int[] iArr = new int[length];
        int i7 = 0;
        while (i7 < length) {
            iArr[i7] = a(zArr, length2, i6);
            i7++;
            length2 += i6;
        }
        try {
            new p6(o3Var).a(iArr, length - e6);
            return a(e6, i6, iArr);
        } catch (com.huawei.hms.scankit.p.a e7) {
            throw com.huawei.hms.scankit.p.a.a(e7.getMessage());
        }
    }

    public w1 a(g gVar, Map<l1, ?> map) throws com.huawei.hms.scankit.p.a {
        this.f34772a = gVar;
        boolean[] b6 = b(a(gVar.a()));
        w1 w1Var = new w1(a(b6), a(b6, map), null, null);
        w1Var.a(b6.length);
        return w1Var;
    }

    private static String a(boolean[] zArr, Map<l1, ?> map) throws com.huawei.hms.scankit.p.a {
        b bVar = b.UPPER;
        StringBuilder a6 = a(zArr, bVar, bVar);
        int length = a6.length();
        byte[] bArr = new byte[length];
        for (int i6 = 0; i6 < length; i6++) {
            bArr[i6] = (byte) a6.charAt(i6);
        }
        try {
            return new String(bArr, c7.a(bArr, map));
        } catch (UnsupportedEncodingException unused) {
            throw com.huawei.hms.scankit.p.a.a();
        }
    }

    private static StringBuilder a(boolean[] zArr, b bVar, b bVar2) {
        int length = zArr.length;
        StringBuilder sb = new StringBuilder(20);
        int i6 = 0;
        while (i6 < length) {
            if (bVar2 != b.BINARY) {
                int i7 = bVar2 == b.DIGIT ? 4 : 5;
                if (length - i6 < i7) {
                    break;
                }
                int a6 = a(zArr, i6, i7);
                i6 += i7;
                String a7 = a(bVar2, a6);
                if (a7.startsWith("CTRL_")) {
                    bVar = a(a7.charAt(5));
                    if (a7.charAt(6) != 'L') {
                        b bVar3 = bVar2;
                        bVar2 = bVar;
                        bVar = bVar3;
                    }
                } else {
                    sb.append(a7);
                }
                bVar2 = bVar;
            } else {
                if (length - i6 < 5) {
                    break;
                }
                int a8 = a(zArr, i6, 5);
                int i8 = i6 + 5;
                if (a8 == 0) {
                    if (length - i8 < 11) {
                        break;
                    }
                    a8 = a(zArr, i8, 11) + 31;
                    i8 = i6 + 16;
                }
                int i9 = 0;
                while (true) {
                    if (i9 >= a8) {
                        i6 = i8;
                        break;
                    }
                    if (length - i8 < 8) {
                        i6 = length;
                        break;
                    }
                    sb.append((char) a(zArr, i8, 8));
                    i8 += 8;
                    i9++;
                }
                bVar2 = bVar;
            }
        }
        return sb;
    }

    private static b a(char c6) {
        if (c6 == 'B') {
            return b.BINARY;
        }
        if (c6 == 'D') {
            return b.DIGIT;
        }
        if (c6 == 'P') {
            return b.PUNCT;
        }
        if (c6 == 'L') {
            return b.LOWER;
        }
        if (c6 != 'M') {
            return b.UPPER;
        }
        return b.MIXED;
    }

    private static String a(b bVar, int i6) {
        int i7 = a.f34773a[bVar.ordinal()];
        if (i7 == 1) {
            return f34767b[i6];
        }
        if (i7 == 2) {
            return f34768c[i6];
        }
        if (i7 == 3) {
            return f34769d[i6];
        }
        if (i7 == 4) {
            return f34770e[i6];
        }
        if (i7 == 5) {
            return f34771f[i6];
        }
        throw new IllegalStateException("Bad table");
    }

    private boolean[] a(int i6, int i7, int[] iArr) throws com.huawei.hms.scankit.p.a {
        int i8 = 1 << i7;
        int i9 = i8 - 1;
        int i10 = 0;
        for (int i11 = 0; i11 < i6; i11++) {
            int i12 = iArr[i11];
            if (i12 == 0 || i12 == i9) {
                throw com.huawei.hms.scankit.p.a.a();
            }
            if (i12 == 1 || i12 == i8 - 2) {
                i10++;
            }
        }
        boolean[] zArr = new boolean[(i6 * i7) - i10];
        int i13 = 0;
        for (int i14 = 0; i14 < i6; i14++) {
            int i15 = iArr[i14];
            if (i15 == 1 || i15 == i8 - 2) {
                Arrays.fill(zArr, i13, (i13 + i7) - 1, i15 > 1);
                i13 += i7 - 1;
            } else {
                int i16 = i7 - 1;
                while (i16 >= 0) {
                    int i17 = i13 + 1;
                    zArr[i13] = ((1 << i16) & i15) != 0;
                    i16--;
                    i13 = i17;
                }
            }
        }
        return zArr;
    }

    private boolean[] a(s sVar) {
        g gVar = this.f34772a;
        boolean z5 = gVar != null && gVar.g();
        g gVar2 = this.f34772a;
        int f6 = gVar2 != null ? gVar2.f() : 0;
        int i6 = (z5 ? 11 : 14) + (f6 * 4);
        int[] iArr = new int[i6];
        boolean[] zArr = new boolean[a(f6, z5)];
        int i7 = 2;
        if (z5) {
            for (int i8 = 0; i8 < i6; i8++) {
                iArr[i8] = i8;
            }
        } else {
            int i9 = i6 / 2;
            int i10 = ((i6 + 1) + (((i9 - 1) / 15) * 2)) / 2;
            for (int i11 = 0; i11 < i9; i11++) {
                int i12 = (i11 / 15) + i11;
                iArr[(i9 - i11) - 1] = (i10 - i12) - 1;
                iArr[i9 + i11] = i12 + i10 + 1;
            }
        }
        int i13 = 0;
        int i14 = 0;
        while (i13 < f6) {
            int i15 = ((f6 - i13) * 4) + (z5 ? 9 : 12);
            int i16 = i13 * 2;
            int i17 = (i6 - 1) - i16;
            int i18 = 0;
            while (i18 < i15) {
                int i19 = i18 * 2;
                int i20 = 0;
                while (i20 < i7) {
                    int i21 = i16 + i20;
                    int i22 = i16 + i18;
                    zArr[i14 + i19 + i20] = sVar.b(iArr[i21], iArr[i22]);
                    int i23 = i17 - i20;
                    zArr[(i15 * 2) + i14 + i19 + i20] = sVar.b(iArr[i22], iArr[i23]);
                    int i24 = i17 - i18;
                    zArr[(i15 * 4) + i14 + i19 + i20] = sVar.b(iArr[i23], iArr[i24]);
                    zArr[(i15 * 6) + i14 + i19 + i20] = sVar.b(iArr[i24], iArr[i21]);
                    i20++;
                    i7 = 2;
                }
                i18++;
                i7 = 2;
            }
            i14 += i15 * 8;
            i13++;
            i7 = 2;
        }
        return zArr;
    }

    private static int a(boolean[] zArr, int i6, int i7) {
        int i8 = 0;
        for (int i9 = i6; i9 < i6 + i7; i9++) {
            i8 <<= 1;
            if (zArr[i9]) {
                i8 |= 1;
            }
        }
        return i8;
    }

    private static byte a(boolean[] zArr, int i6) {
        int a6;
        int length = zArr.length - i6;
        if (length >= 8) {
            a6 = a(zArr, i6, 8);
        } else {
            a6 = a(zArr, i6, length) << (8 - length);
        }
        return (byte) a6;
    }

    static byte[] a(boolean[] zArr) {
        int length = (zArr.length + 7) / 8;
        byte[] bArr = new byte[length];
        for (int i6 = 0; i6 < length; i6++) {
            bArr[i6] = a(zArr, i6 * 8);
        }
        return bArr;
    }
}
