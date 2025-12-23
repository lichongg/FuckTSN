package com.huawei.hms.scankit.p;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import io.netty.util.internal.StringUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class o3 {

    /* renamed from: h, reason: collision with root package name */
    public static final o3 f34645h = new o3(TTAdConstant.INIT_FAILED_CREATE_INITIALIZER_FAILED, 4096, 1);

    /* renamed from: i, reason: collision with root package name */
    public static final o3 f34646i = new o3(1033, 1024, 1);

    /* renamed from: j, reason: collision with root package name */
    public static final o3 f34647j;

    /* renamed from: k, reason: collision with root package name */
    public static final o3 f34648k;

    /* renamed from: l, reason: collision with root package name */
    public static final o3 f34649l;

    /* renamed from: m, reason: collision with root package name */
    public static final o3 f34650m;

    /* renamed from: n, reason: collision with root package name */
    public static final o3 f34651n;

    /* renamed from: o, reason: collision with root package name */
    public static final o3 f34652o;

    /* renamed from: a, reason: collision with root package name */
    private final int[] f34653a;

    /* renamed from: b, reason: collision with root package name */
    private final int[] f34654b;

    /* renamed from: c, reason: collision with root package name */
    private final p3 f34655c;

    /* renamed from: d, reason: collision with root package name */
    private final p3 f34656d;

    /* renamed from: e, reason: collision with root package name */
    private final int f34657e;

    /* renamed from: f, reason: collision with root package name */
    private final int f34658f;

    /* renamed from: g, reason: collision with root package name */
    private final int f34659g;

    static int a(int i6, int i7) {
        return i6 ^ i7;
    }

    p3 b() {
        return this.f34656d;
    }

    int c(int i6) {
        if (i6 != 0) {
            return this.f34654b[i6];
        }
        throw new IllegalArgumentException();
    }

    static {
        o3 o3Var = new o3(67, 64, 1);
        f34647j = o3Var;
        f34648k = new o3(19, 16, 1);
        f34649l = new o3(MediaPlayer.MEDIA_PLAYER_OPTION_FRC_LEVEL, 256, 0);
        o3 o3Var2 = new o3(301, 256, 1);
        f34650m = o3Var2;
        f34651n = o3Var2;
        f34652o = o3Var;
    }

    int a(int i6) {
        if (w7.a(this.f34653a, i6)) {
            return this.f34653a[i6];
        }
        return -1;
    }

    p3 b(int i6, int i7) {
        if (i6 < 0) {
            throw new IllegalArgumentException();
        }
        if (i7 == 0) {
            return this.f34655c;
        }
        int[] iArr = new int[i6 + 1];
        iArr[0] = i7;
        return new p3(this, iArr);
    }

    p3 d() {
        return this.f34655c;
    }

    public String toString() {
        return "GF(0x" + Integer.toHexString(this.f34658f) + StringUtil.COMMA + this.f34657e + ')';
    }

    public o3(int i6, int i7, int i8) {
        this.f34658f = i6;
        this.f34657e = i7;
        this.f34659g = i8;
        this.f34653a = new int[i7];
        this.f34654b = new int[i7];
        int i9 = 1;
        for (int i10 = 0; i10 < i7; i10++) {
            this.f34653a[i10] = i9;
            i9 *= 2;
            if (i9 >= i7) {
                i9 = (i9 ^ i6) & (i7 - 1);
            }
        }
        for (int i11 = 0; i11 < i7 - 1; i11++) {
            this.f34654b[this.f34653a[i11]] = i11;
        }
        this.f34655c = new p3(this, new int[]{0});
        this.f34656d = new p3(this, new int[]{1});
    }

    int c(int i6, int i7) {
        if (i6 == 0 || i7 == 0) {
            return 0;
        }
        int[] iArr = this.f34653a;
        int[] iArr2 = this.f34654b;
        return iArr[(iArr2[i6] + iArr2[i7]) % (this.f34657e - 1)];
    }

    public int a() {
        return this.f34659g;
    }

    public int c() {
        return this.f34657e;
    }

    int b(int i6) {
        if (i6 != 0) {
            return this.f34653a[(this.f34657e - this.f34654b[i6]) - 1];
        }
        throw new ArithmeticException();
    }
}
