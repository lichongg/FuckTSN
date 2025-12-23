package com.huawei.hms.scankit.p;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class e2 {

    /* renamed from: g, reason: collision with root package name */
    private static final int[] f34205g = {210, org.apache.commons.net.telnet.f.f51105u, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_SAVED_HOST_TIME, 244, 270, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEOCODEC_PIXEL_ALIGN};

    /* renamed from: h, reason: collision with root package name */
    private static final int[] f34206h = {21, 25, 29, 33, 37, 41};

    /* renamed from: a, reason: collision with root package name */
    private final s f34207a;

    /* renamed from: b, reason: collision with root package name */
    private v6 f34208b;

    /* renamed from: c, reason: collision with root package name */
    private g3 f34209c;

    /* renamed from: d, reason: collision with root package name */
    private g3 f34210d;

    /* renamed from: e, reason: collision with root package name */
    private g3 f34211e;

    /* renamed from: f, reason: collision with root package name */
    private g3 f34212f;

    public final g3[] a(Map<l1, ?> map) throws a {
        v6 v6Var = map == null ? null : (v6) map.get(l1.f34512j);
        this.f34208b = v6Var;
        return new h3(this.f34207a, v6Var).a(map);
    }

    public e2(s sVar) {
        this.f34207a = sVar;
    }

    private float b(int i6, int i7, s sVar) throws a {
        int c6 = sVar.c();
        int[] iArr = new int[5];
        for (int i8 = 0; i8 < 5; i8++) {
            iArr[i8] = 0;
        }
        int i9 = i6;
        while (i9 >= 0 && sVar.b(i7, i9)) {
            iArr[2] = iArr[2] + 1;
            i9--;
        }
        if (i9 >= 0) {
            while (i9 >= 0 && !sVar.b(i7, i9)) {
                iArr[1] = iArr[1] + 1;
                i9--;
            }
            if (i9 >= 0) {
                while (i9 >= 0 && sVar.b(i7, i9)) {
                    iArr[0] = iArr[0] + 1;
                    i9--;
                }
                int i10 = i6 + 1;
                while (i10 < c6 && sVar.b(i7, i10)) {
                    iArr[2] = iArr[2] + 1;
                    i10++;
                }
                if (i10 != c6) {
                    while (i10 < c6 && !sVar.b(i7, i10)) {
                        iArr[3] = iArr[3] + 1;
                        i10++;
                    }
                    if (i10 != c6) {
                        while (i10 < c6 && sVar.b(i7, i10)) {
                            iArr[4] = iArr[4] + 1;
                            i10++;
                        }
                        return ((((iArr[0] + iArr[1]) + iArr[2]) + iArr[3]) + iArr[4]) / 6.0f;
                    }
                    throw a.a();
                }
                throw a.a();
            }
            throw a.a();
        }
        throw a.a();
    }

    public final int a(g3[] g3VarArr, g3 g3Var) throws a {
        this.f34209c = g3VarArr[0];
        this.f34210d = g3VarArr[1];
        g3 g3Var2 = g3VarArr[2];
        this.f34211e = g3Var2;
        if (g3Var == null) {
            this.f34212f = new g3((g3Var2.b() - this.f34210d.b()) + this.f34209c.b(), (this.f34211e.c() - this.f34210d.c()) + this.f34209c.c(), 6.0f);
        } else {
            this.f34212f = g3Var;
        }
        float a6 = a(this.f34210d, this.f34211e, this.f34209c, this.f34207a);
        if (a6 >= 1.0f) {
            int a7 = a(this.f34210d, this.f34211e, this.f34209c, a6);
            if (a7 < 0 || a7 > 7) {
                throw a.a();
            }
            return a7;
        }
        throw a.a();
    }

    public final j2 a(int i6) throws a {
        s a6;
        int i7 = i6 - 1;
        double d6 = f34205g[i7];
        float cos = (float) ((Math.cos(0.7853981633974483d) * d6) + 300.0d);
        float cos2 = (float) (300.0d - (d6 * Math.cos(0.7853981633974483d)));
        s a7 = a(this.f34207a, a(this.f34210d, this.f34211e, this.f34209c, this.f34212f, new u6(cos2, cos2), new u6(cos, cos2), new u6(cos2, cos), new u6(cos, cos)), 600);
        int i8 = f34206h[i7];
        s sVar = new s(i8, i8);
        switch (i6) {
            case 1:
                a6 = e8.a(sVar, a7, i8, 300.0d);
                break;
            case 2:
                a6 = h8.a(sVar, a7, i8, 300.0d);
                break;
            case 3:
                a6 = g8.a(sVar, a7, i8, 300.0d);
                break;
            case 4:
                a6 = d8.a(sVar, a7, i8, 300.0d);
                break;
            case 5:
                a6 = c8.a(sVar, a7, i8, 300.0d);
                break;
            case 6:
                a6 = f8.a(sVar, a7, i8, 300.0d);
                break;
            default:
                throw a.a();
        }
        return new j2(a6, new u6[]{this.f34209c, this.f34210d, this.f34211e, this.f34212f});
    }

    private static d6 a(u6 u6Var, u6 u6Var2, u6 u6Var3, u6 u6Var4, u6 u6Var5, u6 u6Var6, u6 u6Var7, u6 u6Var8) throws a {
        return d6.a(u6Var5.b(), u6Var5.c(), u6Var6.b(), u6Var6.c(), u6Var8.b(), u6Var8.c(), u6Var7.b(), u6Var7.c(), u6Var.b(), u6Var.c(), u6Var2.b(), u6Var2.c(), u6Var4.b(), u6Var4.c(), u6Var3.b(), u6Var3.c());
    }

    private static s a(s sVar, d6 d6Var, int i6) throws a {
        return s3.a().a(sVar, i6, i6, d6Var, false);
    }

    private static int a(u6 u6Var, u6 u6Var2, u6 u6Var3, float f6) throws a {
        float a6 = ((u6.a(u6Var, u6Var2) / f6) + (u6.a(u6Var, u6Var3) / f6)) / 2.0f;
        if (a6 >= 28.1f && a6 <= 31.1f) {
            return 1;
        }
        if (a6 >= 31.7f && a6 <= 34.7f) {
            return 2;
        }
        if (a6 >= 35.9f && a6 <= 38.9f) {
            return 3;
        }
        if (a6 >= 41.7f && a6 <= 44.7f) {
            return 4;
        }
        if (a6 >= 46.3f && a6 <= 49.3f) {
            return 5;
        }
        if (a6 < 54.4f || a6 > 57.4f) {
            return Math.round((a6 - 25.0f) / 4.0f);
        }
        return 6;
    }

    protected final float a(u6 u6Var, u6 u6Var2, u6 u6Var3, s sVar) throws a {
        return (((((a((int) u6Var.b(), (int) u6Var.c(), sVar) + a((int) u6Var2.b(), (int) u6Var2.c(), sVar)) + a((int) u6Var3.b(), (int) u6Var3.c(), sVar)) + b((int) u6Var.c(), (int) u6Var.b(), sVar)) + b((int) u6Var2.c(), (int) u6Var2.b(), sVar)) + b((int) u6Var3.c(), (int) u6Var3.b(), sVar)) / 6.0f;
    }

    private float a(int i6, int i7, s sVar) throws a {
        int e6 = sVar.e();
        int[] iArr = new int[5];
        for (int i8 = 0; i8 < 5; i8++) {
            iArr[i8] = 0;
        }
        int i9 = i6;
        while (i9 >= 0 && sVar.b(i9, i7)) {
            iArr[2] = iArr[2] + 1;
            i9--;
        }
        if (i9 >= 0) {
            while (i9 >= 0 && !sVar.b(i9, i7)) {
                iArr[1] = iArr[1] + 1;
                i9--;
            }
            if (i9 >= 0) {
                while (i9 >= 0 && sVar.b(i9, i7)) {
                    iArr[0] = iArr[0] + 1;
                    i9--;
                }
                int i10 = i6 + 1;
                while (i10 < e6 && sVar.b(i10, i7)) {
                    iArr[2] = iArr[2] + 1;
                    i10++;
                }
                if (i10 != e6) {
                    while (i10 < e6 && !sVar.b(i10, i7)) {
                        iArr[3] = iArr[3] + 1;
                        i10++;
                    }
                    if (i10 != e6) {
                        while (i10 < e6 && sVar.b(i10, i7)) {
                            iArr[4] = iArr[4] + 1;
                            i10++;
                        }
                        return ((((iArr[0] + iArr[1]) + iArr[2]) + iArr[3]) + iArr[4]) / 6.0f;
                    }
                    throw a.a();
                }
                throw a.a();
            }
            throw a.a();
        }
        throw a.a();
    }
}
