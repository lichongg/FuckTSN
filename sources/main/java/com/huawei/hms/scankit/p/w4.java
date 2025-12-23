package com.huawei.hms.scankit.p;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class w4 {

    /* renamed from: f, reason: collision with root package name */
    public static final w4 f34967f = new w4(MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_STREAM_RECEIVED_WINDOW, 3);

    /* renamed from: a, reason: collision with root package name */
    private final int[] f34968a;

    /* renamed from: b, reason: collision with root package name */
    private final int[] f34969b;

    /* renamed from: c, reason: collision with root package name */
    private final x4 f34970c;

    /* renamed from: d, reason: collision with root package name */
    private final x4 f34971d;

    /* renamed from: e, reason: collision with root package name */
    private final int f34972e;

    x4 a() {
        return this.f34971d;
    }

    x4 b(int i6, int i7) {
        if (i6 < 0) {
            throw new IllegalArgumentException();
        }
        if (i7 == 0) {
            return this.f34970c;
        }
        int[] iArr = new int[i6 + 1];
        iArr[0] = i7;
        return new x4(this, iArr);
    }

    x4 c() {
        return this.f34970c;
    }

    int a(int i6, int i7) {
        return (i6 + i7) % this.f34972e;
    }

    int c(int i6) {
        if (i6 != 0) {
            return this.f34969b[i6];
        }
        throw new IllegalArgumentException();
    }

    int d(int i6, int i7) {
        int i8 = this.f34972e;
        return ((i6 + i8) - i7) % i8;
    }

    private w4(int i6, int i7) {
        this.f34972e = i6;
        this.f34968a = new int[i6];
        this.f34969b = new int[i6];
        int i8 = 1;
        for (int i9 = 0; i9 < i6; i9++) {
            this.f34968a[i9] = i8;
            i8 = (i8 * i7) % i6;
        }
        for (int i10 = 0; i10 < i6 - 1; i10++) {
            this.f34969b[this.f34968a[i10]] = i10;
        }
        this.f34970c = new x4(this, new int[]{0});
        this.f34971d = new x4(this, new int[]{1});
    }

    int a(int i6) {
        return this.f34968a[i6];
    }

    int c(int i6, int i7) {
        if (i6 <= 0 || i7 <= 0) {
            return 0;
        }
        int[] iArr = this.f34968a;
        int[] iArr2 = this.f34969b;
        return iArr[(iArr2[i6] + iArr2[i7]) % (this.f34972e - 1)];
    }

    int b(int i6) {
        if (i6 != 0) {
            return this.f34968a[(this.f34972e - this.f34969b[i6]) - 1];
        }
        throw new ArithmeticException();
    }

    int b() {
        return this.f34972e;
    }
}
