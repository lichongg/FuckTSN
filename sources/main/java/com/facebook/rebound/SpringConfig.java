package com.facebook.rebound;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class SpringConfig {

    /* renamed from: c, reason: collision with root package name */
    public static SpringConfig f32502c = b(40.0d, 7.0d);

    /* renamed from: a, reason: collision with root package name */
    public double f32503a;

    /* renamed from: b, reason: collision with root package name */
    public double f32504b;

    public static SpringConfig a(double d6, double d7) {
        BouncyConversion bouncyConversion = new BouncyConversion(d7, d6);
        return b(bouncyConversion.g(), bouncyConversion.f());
    }

    public static SpringConfig b(double d6, double d7) {
        return new SpringConfig(OrigamiValueConverter.d(d6), OrigamiValueConverter.a(d7));
    }

    public SpringConfig(double d6, double d7) {
        this.f32504b = d6;
        this.f32503a = d7;
    }
}
