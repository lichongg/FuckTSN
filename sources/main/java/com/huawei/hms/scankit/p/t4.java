package com.huawei.hms.scankit.p;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.huawei.hms.hmsscankit.WriterException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
final class t4 {

    /* renamed from: a, reason: collision with root package name */
    private static final int[][] f34831a = {new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1, 1, 1}};

    /* renamed from: b, reason: collision with root package name */
    private static final int[][] f34832b = {new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 1, 0, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}};

    /* renamed from: c, reason: collision with root package name */
    private static final int[][] f34833c = {new int[]{-1, -1, -1, -1, -1, -1, -1}, new int[]{6, 18, -1, -1, -1, -1, -1}, new int[]{6, 22, -1, -1, -1, -1, -1}, new int[]{6, 26, -1, -1, -1, -1, -1}, new int[]{6, 30, -1, -1, -1, -1, -1}, new int[]{6, 34, -1, -1, -1, -1, -1}, new int[]{6, 22, 38, -1, -1, -1, -1}, new int[]{6, 24, 42, -1, -1, -1, -1}, new int[]{6, 26, 46, -1, -1, -1, -1}, new int[]{6, 28, 50, -1, -1, -1, -1}, new int[]{6, 30, 54, -1, -1, -1, -1}, new int[]{6, 32, 58, -1, -1, -1, -1}, new int[]{6, 34, 62, -1, -1, -1, -1}, new int[]{6, 26, 46, 66, -1, -1, -1}, new int[]{6, 26, 48, 70, -1, -1, -1}, new int[]{6, 26, 50, 74, -1, -1, -1}, new int[]{6, 30, 54, 78, -1, -1, -1}, new int[]{6, 30, 56, 82, -1, -1, -1}, new int[]{6, 30, 58, 86, -1, -1, -1}, new int[]{6, 34, 62, 90, -1, -1, -1}, new int[]{6, 28, 50, 72, 94, -1, -1}, new int[]{6, 26, 50, 74, 98, -1, -1}, new int[]{6, 30, 54, 78, 102, -1, -1}, new int[]{6, 28, 54, 80, 106, -1, -1}, new int[]{6, 32, 58, 84, 110, -1, -1}, new int[]{6, 30, 58, 86, 114, -1, -1}, new int[]{6, 34, 62, 90, 118, -1, -1}, new int[]{6, 26, 50, 74, 98, 122, -1}, new int[]{6, 30, 54, 78, 102, 126, -1}, new int[]{6, 26, 52, 78, 104, MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE, -1}, new int[]{6, 30, 56, 82, 108, MediaPlayer.MEDIA_PLAYER_OPTION_SET_MAX_FPS, -1}, new int[]{6, 34, 60, 86, 112, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_END_TIME, -1}, new int[]{6, 30, 58, 86, 114, MediaPlayer.MEDIA_PLAYER_OPTION_META_DATA_INFO, -1}, new int[]{6, 34, 62, 90, 118, MediaPlayer.MEDIA_PLAYER_OPTION_LAZY_SEEK, -1}, new int[]{6, 30, 54, 78, 102, 126, 150}, new int[]{6, 24, 50, 76, 102, 128, 154}, new int[]{6, 28, 54, 80, 106, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_SIDE_DATA, 158}, new int[]{6, 32, 58, 84, 110, MediaPlayer.MEDIA_PLAYER_OPTION_SET_PIPE_DECLARE_LENGTH, 162}, new int[]{6, 26, 54, 82, 110, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_END_TIME, 166}, new int[]{6, 30, 58, 86, 114, MediaPlayer.MEDIA_PLAYER_OPTION_META_DATA_INFO, 170}};

    /* renamed from: d, reason: collision with root package name */
    private static final int[][] f34834d = {new int[]{8, 0}, new int[]{8, 1}, new int[]{8, 2}, new int[]{8, 3}, new int[]{8, 4}, new int[]{8, 5}, new int[]{8, 7}, new int[]{8, 8}, new int[]{7, 8}, new int[]{5, 8}, new int[]{4, 8}, new int[]{3, 8}, new int[]{2, 8}, new int[]{1, 8}, new int[]{0, 8}};

    static void a(c0 c0Var) {
        c0Var.a((byte) -1);
    }

    private static boolean b(int i6) {
        return i6 == -1;
    }

    static void c(b8 b8Var, c0 c0Var) throws WriterException {
        if (b8Var.f() < 7) {
            return;
        }
        r rVar = new r();
        a(b8Var, rVar);
        int i6 = 17;
        for (int i7 = 0; i7 < 6; i7++) {
            for (int i8 = 0; i8 < 3; i8++) {
                boolean b6 = rVar.b(i6);
                i6--;
                c0Var.a(i7, (c0Var.b() - 11) + i8, b6);
                c0Var.a((c0Var.b() - 11) + i8, i7, b6);
            }
        }
    }

    private static void d(c0 c0Var) {
        int i6 = 8;
        while (i6 < c0Var.c() - 8) {
            int i7 = i6 + 1;
            int i8 = i7 % 2;
            if (b(c0Var.a(i6, 6))) {
                c0Var.a(i6, 6, i8);
            }
            if (b(c0Var.a(6, i6))) {
                c0Var.a(6, i6, i8);
            }
            i6 = i7;
        }
    }

    static void a(r rVar, b3 b3Var, b8 b8Var, int i6, c0 c0Var) throws WriterException {
        a(c0Var);
        a(b8Var, c0Var);
        a(b3Var, i6, c0Var);
        c(b8Var, c0Var);
        a(rVar, i6, c0Var);
    }

    private static void b(c0 c0Var) throws WriterException {
        if (c0Var.a(8, c0Var.b() - 8) == 0) {
            throw new WriterException();
        }
        c0Var.a(8, c0Var.b() - 8, 1);
    }

    private static void b(int i6, int i7, c0 c0Var) {
        for (int i8 = 0; i8 < 5; i8++) {
            int[] iArr = f34832b[i8];
            for (int i9 = 0; i9 < 5; i9++) {
                c0Var.a(i6 + i9, i7 + i8, iArr[i9]);
            }
        }
    }

    static void a(b8 b8Var, c0 c0Var) throws WriterException {
        c(c0Var);
        b(c0Var);
        b(b8Var, c0Var);
        d(c0Var);
    }

    private static void b(b8 b8Var, c0 c0Var) {
        if (b8Var.f() < 2) {
            return;
        }
        int f6 = b8Var.f() - 1;
        int[][] iArr = f34833c;
        if (f6 < iArr.length) {
            int[] iArr2 = iArr[f6];
            for (int i6 : iArr2) {
                if (i6 >= 0) {
                    for (int i7 : iArr2) {
                        if (i7 >= 0 && b(c0Var.a(i7, i6))) {
                            b(i7 - 2, i6 - 2, c0Var);
                        }
                    }
                }
            }
        }
    }

    private static void c(int i6, int i7, c0 c0Var) {
        for (int i8 = 0; i8 < 7; i8++) {
            int[] iArr = f34831a[i8];
            for (int i9 = 0; i9 < 7; i9++) {
                c0Var.a(i6 + i9, i7 + i8, iArr[i9]);
            }
        }
    }

    private static void d(int i6, int i7, c0 c0Var) throws WriterException {
        for (int i8 = 0; i8 < 7; i8++) {
            int i9 = i7 + i8;
            if (b(c0Var.a(i6, i9))) {
                c0Var.a(i6, i9, 0);
            } else {
                throw new WriterException();
            }
        }
    }

    private static void c(c0 c0Var) throws WriterException {
        int length = f34831a[0].length;
        c(0, 0, c0Var);
        c(c0Var.c() - length, 0, c0Var);
        c(0, c0Var.c() - length, c0Var);
        a(0, 7, c0Var);
        a(c0Var.c() - 8, 7, c0Var);
        a(0, c0Var.c() - 8, c0Var);
        d(7, 0, c0Var);
        d(c0Var.b() - 8, 0, c0Var);
        d(7, c0Var.b() - 7, c0Var);
    }

    static void a(b3 b3Var, int i6, c0 c0Var) throws WriterException {
        r rVar = new r();
        a(b3Var, i6, rVar);
        for (int i7 = 0; i7 < rVar.e(); i7++) {
            boolean b6 = rVar.b((rVar.e() - 1) - i7);
            int[] iArr = f34834d[i7];
            c0Var.a(iArr[0], iArr[1], b6);
            if (i7 < 8) {
                c0Var.a((c0Var.c() - i7) - 1, 8, b6);
            } else {
                c0Var.a(8, (c0Var.b() - 7) + (i7 - 8), b6);
            }
        }
    }

    static void a(r rVar, int i6, c0 c0Var) throws WriterException {
        boolean z5;
        int c6 = c0Var.c() - 1;
        int b6 = c0Var.b() - 1;
        int i7 = 0;
        int i8 = -1;
        while (c6 > 0) {
            if (c6 == 6) {
                c6--;
            }
            while (b6 >= 0 && b6 < c0Var.b()) {
                for (int i9 = 0; i9 < 2; i9++) {
                    int i10 = c6 - i9;
                    if (b(c0Var.a(i10, b6))) {
                        if (i7 < rVar.e()) {
                            z5 = rVar.b(i7);
                            i7++;
                        } else {
                            z5 = false;
                        }
                        if (i6 != -1 && r4.a(i6, i10, b6)) {
                            z5 = !z5;
                        }
                        c0Var.a(i10, b6, z5);
                    }
                }
                b6 += i8;
            }
            i8 = -i8;
            b6 += i8;
            c6 -= 2;
        }
        if (i7 == rVar.e()) {
            return;
        }
        throw new WriterException("Not all bits consumed: " + i7 + '/' + rVar.e());
    }

    static int a(int i6) {
        return 32 - Integer.numberOfLeadingZeros(i6);
    }

    static int a(int i6, int i7) {
        if (i7 != 0) {
            int a6 = a(i7);
            int i8 = i6 << (a6 - 1);
            while (a(i8) >= a6) {
                i8 ^= i7 << (a(i8) - a6);
            }
            return i8;
        }
        throw new IllegalArgumentException("0 polynomial");
    }

    static void a(b3 b3Var, int i6, r rVar) throws WriterException {
        if (h6.a(i6)) {
            int a6 = (b3Var.a() << 3) | i6;
            rVar.a(a6, 5);
            rVar.a(a(a6, 1335), 10);
            r rVar2 = new r();
            rVar2.a(21522, 15);
            rVar.b(rVar2);
            if (rVar.e() == 15) {
                return;
            }
            throw new WriterException("should not happen but we got: " + rVar.e());
        }
        throw new WriterException("Invalid mask pattern");
    }

    static void a(b8 b8Var, r rVar) throws WriterException {
        rVar.a(b8Var.f(), 6);
        rVar.a(a(b8Var.f(), 7973), 12);
        if (rVar.e() == 18) {
            return;
        }
        throw new WriterException("should not happen but we got: " + rVar.e());
    }

    private static void a(int i6, int i7, c0 c0Var) throws WriterException {
        for (int i8 = 0; i8 < 8; i8++) {
            int i9 = i6 + i8;
            if (b(c0Var.a(i9, i7))) {
                c0Var.a(i9, i7, 0);
            } else {
                throw new WriterException();
            }
        }
    }
}
