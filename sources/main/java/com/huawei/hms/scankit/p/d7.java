package com.huawei.hms.scankit.p;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class d7 {

    /* renamed from: i, reason: collision with root package name */
    static final d7[] f34149i;

    /* renamed from: j, reason: collision with root package name */
    private static d7[] f34150j;

    /* renamed from: a, reason: collision with root package name */
    private final boolean f34151a;

    /* renamed from: b, reason: collision with root package name */
    private final int f34152b;

    /* renamed from: c, reason: collision with root package name */
    private final int f34153c;

    /* renamed from: d, reason: collision with root package name */
    public final int f34154d;

    /* renamed from: e, reason: collision with root package name */
    public final int f34155e;

    /* renamed from: f, reason: collision with root package name */
    private final int f34156f;

    /* renamed from: g, reason: collision with root package name */
    private final int f34157g;

    /* renamed from: h, reason: collision with root package name */
    private final int f34158h;

    public d7(boolean z5, int i6, int i7, int i8, int i9, int i10) {
        this(z5, i6, i7, i8, i9, i10, i6, i7);
    }

    public static d7 a(int i6, e7 e7Var, l2 l2Var, l2 l2Var2, boolean z5) {
        for (d7 d7Var : f34150j) {
            if (!(e7Var == e7.FORCE_SQUARE && d7Var.f34151a) && ((e7Var != e7.FORCE_RECTANGLE || d7Var.f34151a) && ((l2Var == null || (d7Var.h() >= l2Var.b() && d7Var.g() >= l2Var.a())) && ((l2Var2 == null || (d7Var.h() <= l2Var2.b() && d7Var.g() <= l2Var2.a())) && i6 <= d7Var.f34152b)))) {
                return d7Var;
            }
        }
        if (!z5) {
            return null;
        }
        throw new IllegalArgumentException("Can't find a symbol arrangement that matches the message. Data codewords: " + i6);
    }

    public final int b() {
        return this.f34153c;
    }

    static {
        d7[] d7VarArr = {new d7(false, 3, 5, 8, 8, 1), new d7(false, 5, 7, 10, 10, 1), new d7(true, 5, 7, 16, 6, 1), new d7(false, 8, 10, 12, 12, 1), new d7(true, 10, 11, 14, 6, 2), new d7(false, 12, 12, 14, 14, 1), new d7(true, 16, 14, 24, 10, 1), new d7(false, 18, 14, 16, 16, 1), new d7(false, 22, 18, 18, 18, 1), new d7(true, 22, 18, 16, 10, 2), new d7(false, 30, 20, 20, 20, 1), new d7(true, 32, 24, 16, 14, 2), new d7(false, 36, 24, 22, 22, 1), new d7(false, 44, 28, 24, 24, 1), new d7(true, 49, 28, 22, 14, 2), new d7(false, 62, 36, 14, 14, 4), new d7(false, 86, 42, 16, 16, 4), new d7(false, 114, 48, 18, 18, 4), new d7(false, 144, 56, 20, 20, 4), new d7(false, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_BITRATE, 68, 22, 22, 4), new d7(false, 204, 84, 24, 24, 4, 102, 42), new d7(false, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEOCODEC_PIXEL_ALIGN, 112, 14, 14, 16, 140, 56), new d7(false, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_PTS_SYNCED_SEI_NOTIFICATION, 144, 16, 16, 16, 92, 36), new d7(false, MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_HTTP_RES_FINISH_TIME, 192, 18, 18, 16, 114, 48), new d7(false, 576, 224, 20, 20, 16, 144, 56), new d7(false, 696, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HTTP_REQ_FINSIH_TIME, 22, 22, 16, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_BITRATE, 68), new d7(false, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_EARLY_INIT_RENDER, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_DEVICE_WAIT_START_TIME, 24, 24, 16, MediaPlayer.MEDIA_PLAYER_OPTION_SET_PIPE_DECLARE_LENGTH, 56), new d7(false, 1050, TTAdConstant.INTERACTION_TYPE_CODE, 18, 18, 36, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED, 68), new d7(false, 1304, 496, 20, 20, 36, 163, 62), new i1()};
        f34149i = d7VarArr;
        f34150j = d7VarArr;
    }

    d7(boolean z5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
        this.f34151a = z5;
        this.f34152b = i6;
        this.f34153c = i7;
        this.f34154d = i8;
        this.f34155e = i9;
        this.f34156f = i10;
        this.f34157g = i11;
        this.f34158h = i12;
    }

    private int c() {
        int i6 = this.f34156f;
        int i7 = 1;
        if (i6 != 1) {
            i7 = 2;
            if (i6 != 2 && i6 != 4) {
                if (i6 == 16) {
                    return 4;
                }
                if (i6 == 36) {
                    return 6;
                }
                throw new IllegalStateException("Cannot handle this number of data regions");
            }
        }
        return i7;
    }

    private int i() {
        int i6 = this.f34156f;
        if (i6 == 1 || i6 == 2) {
            return 1;
        }
        if (i6 == 4) {
            return 2;
        }
        if (i6 == 16) {
            return 4;
        }
        if (i6 == 36) {
            return 6;
        }
        throw new IllegalStateException("Cannot handle this number of data regions");
    }

    public final int b(int i6) {
        return this.f34158h;
    }

    public int d() {
        return this.f34152b / this.f34157g;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f34151a ? "Rectangular Symbol:" : "Square Symbol:");
        sb.append(" data region ");
        sb.append(this.f34154d);
        sb.append('x');
        sb.append(this.f34155e);
        sb.append(", symbol size ");
        sb.append(h());
        sb.append('x');
        sb.append(g());
        sb.append(", symbol data size ");
        sb.append(f());
        sb.append('x');
        sb.append(e());
        sb.append(", codewords ");
        sb.append(this.f34152b);
        sb.append('+');
        sb.append(this.f34153c);
        return sb.toString();
    }

    public final int e() {
        return i() * this.f34155e;
    }

    public final int f() {
        return c() * this.f34154d;
    }

    public final int g() {
        return e() + (i() * 2);
    }

    public final int h() {
        return f() + (c() * 2);
    }

    public final int a() {
        return this.f34152b;
    }

    public int a(int i6) {
        return this.f34157g;
    }
}
