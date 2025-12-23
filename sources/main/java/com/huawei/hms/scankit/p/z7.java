package com.huawei.hms.scankit.p;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class z7 {

    /* renamed from: h, reason: collision with root package name */
    private static final int[][] f35076h = {new int[]{1, 10, 10, 8, 8, 5, 1, 3}, new int[]{2, 12, 12, 10, 10, 7, 1, 5}, new int[]{3, 14, 14, 12, 12, 10, 1, 8}, new int[]{4, 16, 16, 14, 14, 12, 1, 12}, new int[]{5, 18, 18, 16, 16, 14, 1, 18}, new int[]{6, 20, 20, 18, 18, 18, 1, 22}, new int[]{7, 22, 22, 20, 20, 20, 1, 30}, new int[]{8, 24, 24, 22, 22, 24, 1, 36}, new int[]{9, 26, 26, 24, 24, 28, 1, 44}, new int[]{10, 32, 32, 14, 14, 36, 1, 62}, new int[]{11, 36, 36, 16, 16, 42, 1, 86}, new int[]{12, 40, 40, 18, 18, 48, 1, 114}, new int[]{13, 44, 44, 20, 20, 56, 1, 144}, new int[]{14, 48, 48, 22, 22, 68, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_BITRATE}, new int[]{15, 52, 52, 24, 24, 42, 2, 102}, new int[]{16, 64, 64, 14, 14, 56, 2, 140}, new int[]{17, 72, 72, 16, 16, 36, 4, 92}, new int[]{18, 80, 80, 18, 18, 48, 4, 114}, new int[]{19, 88, 88, 20, 20, 56, 4, 144}, new int[]{20, 96, 96, 22, 22, 68, 4, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_BITRATE}, new int[]{21, 104, 104, 24, 24, 56, 6, MediaPlayer.MEDIA_PLAYER_OPTION_SET_PIPE_DECLARE_LENGTH}, new int[]{22, 120, 120, 18, 18, 68, 6, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED}, new int[]{23, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_SIDE_DATA, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_SIDE_DATA, 20, 20, 62, 8, 163}, new int[]{24, 144, 144, 22, 22, 62, 8, 156, 2, 155}, new int[]{25, 8, 18, 6, 16, 7, 1, 5}, new int[]{26, 8, 32, 6, 14, 11, 1, 10}, new int[]{27, 12, 26, 10, 24, 14, 1, 16}, new int[]{28, 12, 36, 10, 16, 18, 1, 22}, new int[]{29, 16, 36, 14, 16, 24, 1, 32}, new int[]{30, 16, 48, 14, 22, 28, 1, 49}};

    /* renamed from: i, reason: collision with root package name */
    private static final z7[] f35077i = a();

    /* renamed from: a, reason: collision with root package name */
    private final int f35078a;

    /* renamed from: b, reason: collision with root package name */
    private final int f35079b;

    /* renamed from: c, reason: collision with root package name */
    private final int f35080c;

    /* renamed from: d, reason: collision with root package name */
    private final int f35081d;

    /* renamed from: e, reason: collision with root package name */
    private final int f35082e;

    /* renamed from: f, reason: collision with root package name */
    private final c f35083f;

    /* renamed from: g, reason: collision with root package name */
    private final int f35084g;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final int f35085a;

        /* renamed from: b, reason: collision with root package name */
        private final int f35086b;

        /* synthetic */ b(int i6, int i7, a aVar) {
            this(i6, i7);
        }

        private b(int i6, int i7) {
            this.f35085a = i6;
            this.f35086b = i7;
        }

        int a() {
            return this.f35085a;
        }

        int b() {
            return this.f35086b;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class c {

        /* renamed from: a, reason: collision with root package name */
        private final int f35087a;

        /* renamed from: b, reason: collision with root package name */
        private final b[] f35088b;

        /* synthetic */ c(int i6, b bVar, a aVar) {
            this(i6, bVar);
        }

        /* synthetic */ c(int i6, b bVar, b bVar2, a aVar) {
            this(i6, bVar, bVar2);
        }

        b[] a() {
            return this.f35088b;
        }

        int b() {
            return this.f35087a;
        }

        private c(int i6, b bVar) {
            this.f35087a = i6;
            this.f35088b = new b[]{bVar};
        }

        private c(int i6, b bVar, b bVar2) {
            this.f35087a = i6;
            this.f35088b = new b[]{bVar, bVar2};
        }
    }

    public static z7 a(int i6, int i7) throws com.huawei.hms.scankit.p.a {
        if ((i6 & 1) != 0 || (i7 & 1) != 0) {
            throw com.huawei.hms.scankit.p.a.a();
        }
        for (z7 z7Var : f35077i) {
            if (z7Var.f35079b == i6 && z7Var.f35080c == i7) {
                return z7Var;
            }
        }
        throw com.huawei.hms.scankit.p.a.a();
    }

    public int b() {
        return this.f35082e;
    }

    public int c() {
        return this.f35081d;
    }

    c d() {
        return this.f35083f;
    }

    public int e() {
        return this.f35080c;
    }

    public int f() {
        return this.f35079b;
    }

    public int g() {
        return this.f35084g;
    }

    public int h() {
        return this.f35078a;
    }

    public String toString() {
        return String.valueOf(this.f35078a);
    }

    private z7(int i6, int i7, int i8, int i9, int i10, c cVar) {
        this.f35078a = i6;
        this.f35079b = i7;
        this.f35080c = i8;
        this.f35081d = i9;
        this.f35082e = i10;
        this.f35083f = cVar;
        int b6 = cVar.b();
        int i11 = 0;
        for (b bVar : cVar.a()) {
            i11 += bVar.a() * (bVar.b() + b6);
        }
        this.f35084g = i11;
    }

    private static z7[] a() {
        z7[] z7VarArr = new z7[f35076h.length];
        int i6 = 0;
        while (true) {
            int[][] iArr = f35076h;
            if (i6 >= iArr.length) {
                return z7VarArr;
            }
            int[] iArr2 = iArr[i6];
            a aVar = null;
            if (i6 == 23) {
                z7VarArr[i6] = new z7(iArr2[0], iArr2[1], iArr2[2], iArr2[3], iArr2[4], new c(iArr2[5], new b(iArr2[6], iArr2[7], aVar), new b(iArr2[8], iArr2[9], aVar), aVar));
            } else {
                z7VarArr[i6] = new z7(iArr2[0], iArr2[1], iArr2[2], iArr2[3], iArr2[4], new c(iArr2[5], new b(iArr2[6], iArr2[7], aVar), aVar));
            }
            i6++;
        }
    }
}
