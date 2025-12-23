package com.huawei.hms.scankit.p;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Arrays;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class a8 {

    /* renamed from: e, reason: collision with root package name */
    private static final int[] f33994e = {31892, 34236, 39577, 42195, 48118, 51042, 55367, 58893, 63784, 68472, 70749, 76311, 79154, 84390, 87683, 92361, 96236, 102084, 102881, 110507, 110734, 117786, 119615, 126325, 127568, 133589, 136944, 141498, 145311, 150283, 152622, 158308, 161089, 167017};

    /* renamed from: f, reason: collision with root package name */
    private static final a8[] f33995f = b();

    /* renamed from: a, reason: collision with root package name */
    private final int f33996a;

    /* renamed from: b, reason: collision with root package name */
    private final int[] f33997b;

    /* renamed from: c, reason: collision with root package name */
    private final b[] f33998c;

    /* renamed from: d, reason: collision with root package name */
    private final int f33999d;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final int f34000a;

        /* renamed from: b, reason: collision with root package name */
        private final int f34001b;

        public int a() {
            return this.f34000a;
        }

        public int b() {
            return this.f34001b;
        }

        a(int i6, int i7) {
            this.f34000a = i6;
            this.f34001b = i7;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final int f34002a;

        /* renamed from: b, reason: collision with root package name */
        private final a[] f34003b;

        public a[] a() {
            return this.f34003b;
        }

        public int b() {
            return this.f34002a;
        }

        b(int i6, a... aVarArr) {
            this.f34002a = i6;
            this.f34003b = aVarArr;
        }
    }

    public static a8 b(int i6) {
        if (i6 < 1 || i6 > 40) {
            throw new IllegalArgumentException();
        }
        return f33995f[i6 - 1];
    }

    public b a(c3 c3Var) {
        return this.f33998c[c3Var.ordinal()];
    }

    static a8 a(int i6) {
        int i7 = Integer.MAX_VALUE;
        int i8 = 0;
        int i9 = 0;
        while (true) {
            int[] iArr = f33994e;
            if (i8 >= iArr.length) {
                if (i7 <= 3) {
                    return b(i9);
                }
                return null;
            }
            int i10 = iArr[i8];
            if (i10 == i6) {
                return b(i8 + 7);
            }
            int c6 = m3.c(i6, i10);
            if (c6 < i7) {
                i9 = i8 + 7;
                i7 = c6;
            }
            i8++;
        }
    }

    private static a8[] c() {
        return new a8[]{new a8(1, new int[0], new b(7, new a(1, 19)), new b(10, new a(1, 16)), new b(13, new a(1, 13)), new b(17, new a(1, 9))), new a8(2, new int[]{6, 18}, new b(10, new a(1, 34)), new b(16, new a(1, 28)), new b(22, new a(1, 22)), new b(28, new a(1, 16))), new a8(3, new int[]{6, 22}, new b(15, new a(1, 55)), new b(26, new a(1, 44)), new b(18, new a(2, 17)), new b(22, new a(2, 13))), new a8(4, new int[]{6, 26}, new b(20, new a(1, 80)), new b(18, new a(2, 32)), new b(26, new a(2, 24)), new b(16, new a(4, 9))), new a8(5, new int[]{6, 30}, new b(26, new a(1, 108)), new b(24, new a(2, 43)), new b(18, new a(2, 15), new a(2, 16)), new b(22, new a(2, 11), new a(2, 12))), new a8(6, new int[]{6, 34}, new b(18, new a(2, 68)), new b(16, new a(4, 27)), new b(24, new a(4, 19)), new b(28, new a(4, 15))), new a8(7, new int[]{6, 22, 38}, new b(20, new a(2, 78)), new b(18, new a(4, 31)), new b(18, new a(2, 14), new a(4, 15)), new b(26, new a(4, 13), new a(1, 14)))};
    }

    private static a8[] d() {
        return new a8[]{new a8(8, new int[]{6, 24, 42}, new b(24, new a(2, 97)), new b(22, new a(2, 38), new a(2, 39)), new b(22, new a(4, 18), new a(2, 19)), new b(26, new a(4, 14), new a(2, 15))), new a8(9, new int[]{6, 26, 46}, new b(30, new a(2, 116)), new b(22, new a(3, 36), new a(2, 37)), new b(20, new a(4, 16), new a(4, 17)), new b(24, new a(4, 12), new a(4, 13))), new a8(10, new int[]{6, 28, 50}, new b(18, new a(2, 68), new a(2, 69)), new b(26, new a(4, 43), new a(1, 44)), new b(24, new a(6, 19), new a(2, 20)), new b(28, new a(6, 15), new a(2, 16))), new a8(11, new int[]{6, 30, 54}, new b(20, new a(4, 81)), new b(30, new a(1, 50), new a(4, 51)), new b(28, new a(4, 22), new a(4, 23)), new b(24, new a(3, 12), new a(8, 13))), new a8(12, new int[]{6, 32, 58}, new b(24, new a(2, 92), new a(2, 93)), new b(22, new a(6, 36), new a(2, 37)), new b(26, new a(4, 20), new a(6, 21)), new b(28, new a(7, 14), new a(4, 15)))};
    }

    private static a8[] e() {
        return new a8[]{new a8(13, new int[]{6, 34, 62}, new b(26, new a(4, 107)), new b(22, new a(8, 37), new a(1, 38)), new b(24, new a(8, 20), new a(4, 21)), new b(22, new a(12, 11), new a(4, 12))), new a8(14, new int[]{6, 26, 46, 66}, new b(30, new a(3, 115), new a(1, 116)), new b(24, new a(4, 40), new a(5, 41)), new b(20, new a(11, 16), new a(5, 17)), new b(24, new a(11, 12), new a(5, 13))), new a8(15, new int[]{6, 26, 48, 70}, new b(22, new a(5, 87), new a(1, 88)), new b(24, new a(5, 41), new a(5, 42)), new b(30, new a(5, 24), new a(7, 25)), new b(24, new a(11, 12), new a(7, 13))), new a8(16, new int[]{6, 26, 50, 74}, new b(24, new a(5, 98), new a(1, 99)), new b(28, new a(7, 45), new a(3, 46)), new b(24, new a(15, 19), new a(2, 20)), new b(30, new a(3, 15), new a(13, 16))), new a8(17, new int[]{6, 30, 54, 78}, new b(28, new a(1, 107), new a(5, 108)), new b(28, new a(10, 46), new a(1, 47)), new b(28, new a(1, 22), new a(15, 23)), new b(28, new a(2, 14), new a(17, 15)))};
    }

    private static a8[] f() {
        return new a8[]{new a8(18, new int[]{6, 30, 56, 82}, new b(30, new a(5, 120), new a(1, 121)), new b(26, new a(9, 43), new a(4, 44)), new b(28, new a(17, 22), new a(1, 23)), new b(28, new a(2, 14), new a(19, 15))), new a8(19, new int[]{6, 30, 58, 86}, new b(28, new a(3, 113), new a(4, 114)), new b(26, new a(3, 44), new a(11, 45)), new b(26, new a(17, 21), new a(4, 22)), new b(26, new a(9, 13), new a(16, 14))), new a8(20, new int[]{6, 34, 62, 90}, new b(28, new a(3, 107), new a(5, 108)), new b(26, new a(3, 41), new a(13, 42)), new b(30, new a(15, 24), new a(5, 25)), new b(28, new a(15, 15), new a(10, 16))), new a8(21, new int[]{6, 28, 50, 72, 94}, new b(28, new a(4, 116), new a(4, 117)), new b(26, new a(17, 42)), new b(28, new a(17, 22), new a(6, 23)), new b(30, new a(19, 16), new a(6, 17))), new a8(22, new int[]{6, 26, 50, 74, 98}, new b(28, new a(2, 111), new a(7, 112)), new b(28, new a(17, 46)), new b(30, new a(7, 24), new a(16, 25)), new b(24, new a(34, 13)))};
    }

    private static a8[] g() {
        return new a8[]{new a8(23, new int[]{6, 30, 54, 78, 102}, new b(30, new a(4, 121), new a(5, 122)), new b(28, new a(4, 47), new a(14, 48)), new b(30, new a(11, 24), new a(14, 25)), new b(30, new a(16, 15), new a(14, 16))), new a8(24, new int[]{6, 28, 54, 80, 106}, new b(30, new a(6, 117), new a(4, 118)), new b(28, new a(6, 45), new a(14, 46)), new b(30, new a(11, 24), new a(16, 25)), new b(30, new a(30, 16), new a(2, 17))), new a8(25, new int[]{6, 32, 58, 84, 110}, new b(26, new a(8, 106), new a(4, 107)), new b(28, new a(8, 47), new a(13, 48)), new b(30, new a(7, 24), new a(22, 25)), new b(30, new a(22, 15), new a(13, 16))), new a8(26, new int[]{6, 30, 58, 86, 114}, new b(28, new a(10, 114), new a(2, 115)), new b(28, new a(19, 46), new a(4, 47)), new b(28, new a(28, 22), new a(6, 23)), new b(30, new a(33, 16), new a(4, 17))), new a8(27, new int[]{6, 34, 62, 90, 118}, new b(30, new a(8, 122), new a(4, 123)), new b(28, new a(22, 45), new a(3, 46)), new b(30, new a(8, 23), new a(26, 24)), new b(30, new a(12, 15), new a(28, 16)))};
    }

    private static a8[] h() {
        return new a8[]{new a8(28, new int[]{6, 26, 50, 74, 98, 122}, new b(30, new a(3, 117), new a(10, 118)), new b(28, new a(3, 45), new a(23, 46)), new b(30, new a(4, 24), new a(31, 25)), new b(30, new a(11, 15), new a(31, 16))), new a8(29, new int[]{6, 30, 54, 78, 102, 126}, new b(30, new a(7, 116), new a(7, 117)), new b(28, new a(21, 45), new a(7, 46)), new b(30, new a(1, 23), new a(37, 24)), new b(30, new a(19, 15), new a(26, 16))), new a8(30, new int[]{6, 26, 52, 78, 104, MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE}, new b(30, new a(5, 115), new a(10, 116)), new b(28, new a(19, 47), new a(10, 48)), new b(30, new a(15, 24), new a(25, 25)), new b(30, new a(23, 15), new a(25, 16))), new a8(31, new int[]{6, 30, 56, 82, 108, MediaPlayer.MEDIA_PLAYER_OPTION_SET_MAX_FPS}, new b(30, new a(13, 115), new a(3, 116)), new b(28, new a(2, 46), new a(29, 47)), new b(30, new a(42, 24), new a(1, 25)), new b(30, new a(23, 15), new a(28, 16))), new a8(32, new int[]{6, 34, 60, 86, 112, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_END_TIME}, new b(30, new a(17, 115)), new b(28, new a(10, 46), new a(23, 47)), new b(30, new a(10, 24), new a(35, 25)), new b(30, new a(19, 15), new a(35, 16)))};
    }

    private static a8[] i() {
        return new a8[]{new a8(33, new int[]{6, 30, 58, 86, 114, MediaPlayer.MEDIA_PLAYER_OPTION_META_DATA_INFO}, new b(30, new a(17, 115), new a(1, 116)), new b(28, new a(14, 46), new a(21, 47)), new b(30, new a(29, 24), new a(19, 25)), new b(30, new a(11, 15), new a(46, 16))), new a8(34, new int[]{6, 34, 62, 90, 118, MediaPlayer.MEDIA_PLAYER_OPTION_LAZY_SEEK}, new b(30, new a(13, 115), new a(6, 116)), new b(28, new a(14, 46), new a(23, 47)), new b(30, new a(44, 24), new a(7, 25)), new b(30, new a(59, 16), new a(1, 17))), new a8(35, new int[]{6, 30, 54, 78, 102, 126, 150}, new b(30, new a(12, 121), new a(7, 122)), new b(28, new a(12, 47), new a(26, 48)), new b(30, new a(39, 24), new a(14, 25)), new b(30, new a(22, 15), new a(41, 16))), new a8(36, new int[]{6, 24, 50, 76, 102, 128, 154}, new b(30, new a(6, 121), new a(14, 122)), new b(28, new a(6, 47), new a(34, 48)), new b(30, new a(46, 24), new a(10, 25)), new b(30, new a(2, 15), new a(64, 16))), new a8(37, new int[]{6, 28, 54, 80, 106, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_SIDE_DATA, 158}, new b(30, new a(17, 122), new a(4, 123)), new b(28, new a(29, 46), new a(14, 47)), new b(30, new a(49, 24), new a(10, 25)), new b(30, new a(24, 15), new a(46, 16)))};
    }

    private static a8[] j() {
        return new a8[]{new a8(38, new int[]{6, 32, 58, 84, 110, MediaPlayer.MEDIA_PLAYER_OPTION_SET_PIPE_DECLARE_LENGTH, 162}, new b(30, new a(4, 122), new a(18, 123)), new b(28, new a(13, 46), new a(32, 47)), new b(30, new a(48, 24), new a(14, 25)), new b(30, new a(42, 15), new a(32, 16))), new a8(39, new int[]{6, 26, 54, 82, 110, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_END_TIME, 166}, new b(30, new a(20, 117), new a(4, 118)), new b(28, new a(40, 47), new a(7, 48)), new b(30, new a(43, 24), new a(22, 25)), new b(30, new a(10, 15), new a(67, 16))), new a8(40, new int[]{6, 30, 58, 86, 114, MediaPlayer.MEDIA_PLAYER_OPTION_META_DATA_INFO, 170}, new b(30, new a(19, 118), new a(6, 119)), new b(28, new a(18, 47), new a(31, 48)), new b(30, new a(34, 24), new a(34, 25)), new b(30, new a(20, 15), new a(61, 16)))};
    }

    public int k() {
        return (this.f33996a * 4) + 17;
    }

    public int l() {
        return this.f33999d;
    }

    public int m() {
        return this.f33996a;
    }

    public String toString() {
        return String.valueOf(this.f33996a);
    }

    private a8(int i6, int[] iArr, b... bVarArr) {
        this.f33996a = i6;
        this.f33997b = iArr;
        this.f33998c = bVarArr;
        int b6 = bVarArr[0].b();
        int i7 = 0;
        for (a aVar : bVarArr[0].a()) {
            i7 += aVar.a() * (aVar.b() + b6);
        }
        this.f33999d = i7;
    }

    private static a8[] b() {
        return (a8[]) a(c(), d(), e(), f(), g(), h(), i(), j());
    }

    s a() {
        int k6 = k();
        s sVar = new s(k6);
        sVar.a(0, 0, 9, 9);
        int i6 = k6 - 8;
        sVar.a(i6, 0, 8, 9);
        sVar.a(0, i6, 9, 8);
        int length = this.f33997b.length;
        for (int i7 = 0; i7 < length; i7++) {
            int i8 = this.f33997b[i7] - 2;
            for (int i9 = 0; i9 < length; i9++) {
                if ((i7 != 0 || (i9 != 0 && i9 != length - 1)) && (i7 != length - 1 || i9 != 0)) {
                    sVar.a(this.f33997b[i9] - 2, i8, 5, 5);
                }
            }
        }
        int i10 = k6 - 17;
        sVar.a(6, 9, 1, i10);
        sVar.a(9, 6, i10, 1);
        if (this.f33996a > 6) {
            int i11 = k6 - 11;
            sVar.a(i11, 0, 3, 6);
            sVar.a(0, i11, 6, 3);
        }
        return sVar;
    }

    private static <T> T[] a(T[] tArr, T[]... tArr2) {
        int length = tArr.length;
        for (T[] tArr3 : tArr2) {
            length += tArr3.length;
        }
        T[] tArr4 = (T[]) Arrays.copyOf(tArr, length);
        int length2 = tArr.length;
        for (T[] tArr5 : tArr2) {
            System.arraycopy(tArr5, 0, tArr4, length2, tArr5.length);
            length2 += tArr5.length;
        }
        return tArr4;
    }
}
