package com.amap.api.col.p0003l;

import android.graphics.Bitmap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class s2 {

    /* renamed from: d, reason: collision with root package name */
    private static boolean f7208d;

    /* renamed from: e, reason: collision with root package name */
    private static boolean f7209e;

    /* renamed from: f, reason: collision with root package name */
    private static boolean f7210f;

    /* renamed from: a, reason: collision with root package name */
    private boolean f7211a = false;

    /* renamed from: b, reason: collision with root package name */
    private int f7212b = 0;

    /* renamed from: c, reason: collision with root package name */
    private int f7213c = 20;

    public final boolean c(Bitmap bitmap) {
        if (bitmap != null) {
            try {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                int i6 = -1;
                for (int i7 = (int) (width / 4.0f); i7 < (width * 3) / 4.0f; i7++) {
                    for (int i8 = (int) (height / 4.0f); i8 < (height * 3) / 4.0f; i8++) {
                        int pixel = bitmap.getPixel(i7, i8);
                        if (i6 == -1) {
                            i6 = pixel;
                        }
                        if (pixel != i6) {
                            return false;
                        }
                        if (pixel != -16777216) {
                            return false;
                        }
                    }
                }
            } finally {
                try {
                } finally {
                }
            }
        }
        return true;
    }

    public static void a(boolean z5) {
        f7208d = z5;
    }

    public static boolean b() {
        return f7208d;
    }

    public static void d(boolean z5) {
        f7209e = z5;
    }

    public static boolean e() {
        return f7209e;
    }

    public static void f(boolean z5) {
        f7210f = z5;
    }

    public static boolean g() {
        return f7210f;
    }

    public static void k() {
        v5.p(new Exception("BlackScreen"), "PureScreenCheckTool", "uploadInfo");
    }

    public final boolean h() {
        return this.f7211a;
    }

    public final void i() {
        this.f7212b++;
    }

    public final boolean j() {
        return this.f7212b >= this.f7213c;
    }
}
