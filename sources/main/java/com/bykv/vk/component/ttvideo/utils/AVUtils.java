package com.bykv.vk.component.ttvideo.utils;

/* loaded from: D:\Downloads\app\classes3.dex */
public class AVUtils {

    public static class ScaleInfo {

        /* renamed from: h, reason: collision with root package name */
        public int f22929h;

        /* renamed from: w, reason: collision with root package name */
        public int f22930w;

        /* renamed from: x, reason: collision with root package name */
        public int f22931x;

        /* renamed from: y, reason: collision with root package name */
        public int f22932y;
    }

    public static final ScaleInfo getScaleInfoFromSize(float f6, float f7, float f8, float f9) {
        ScaleInfo scaleInfo = new ScaleInfo();
        float f10 = f6 / f7;
        scaleInfo.f22930w = (int) f8;
        int i6 = (int) (f8 / f10);
        scaleInfo.f22929h = i6;
        if (i6 < f9) {
            scaleInfo.f22929h = (int) f9;
            scaleInfo.f22930w = (int) (f10 * f9);
        }
        int i7 = scaleInfo.f22929h;
        int i8 = ((int) (i7 - f9)) >> 1;
        scaleInfo.f22932y = i8;
        int i9 = scaleInfo.f22930w;
        int i10 = ((int) (i9 - f8)) >> 1;
        scaleInfo.f22931x = i10;
        if (i7 > f9) {
            scaleInfo.f22932y = 0 - i8;
        }
        if (i9 > f8) {
            scaleInfo.f22931x = 0 - i10;
        }
        return scaleInfo;
    }
}
