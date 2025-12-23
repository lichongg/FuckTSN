package com.hw.videoprocessor.util;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private k f35501a;

    /* renamed from: b, reason: collision with root package name */
    private float f35502b;

    /* renamed from: c, reason: collision with root package name */
    private float f35503c;

    /* renamed from: d, reason: collision with root package name */
    private int f35504d;

    /* renamed from: e, reason: collision with root package name */
    private int f35505e;

    /* renamed from: f, reason: collision with root package name */
    private Float f35506f;

    public void a(float f6) {
        this.f35503c = f6;
        k kVar = this.f35501a;
        if (kVar != null) {
            kVar.a((this.f35502b + f6) / 2.0f);
        }
        c.k("mAudioProgress:" + this.f35503c, new Object[0]);
    }

    public void b(long j6) {
        if (this.f35501a == null) {
            return;
        }
        Float f6 = this.f35506f;
        if (f6 != null) {
            j6 = (long) (j6 * f6.floatValue());
        }
        float f7 = ((j6 / 1000.0f) - this.f35504d) / (this.f35505e - r3);
        this.f35502b = f7;
        if (f7 < 0.0f) {
            f7 = 0.0f;
        }
        this.f35502b = f7;
        if (f7 > 1.0f) {
            f7 = 1.0f;
        }
        this.f35502b = f7;
        this.f35501a.a((f7 + this.f35503c) / 2.0f);
        c.k("mEncodeProgress:" + this.f35502b, new Object[0]);
    }

    public void c(int i6) {
        this.f35505e = i6;
    }

    public void d(Float f6) {
        this.f35506f = f6;
    }

    public void e(int i6) {
        this.f35504d = i6;
    }

    public j(k kVar) {
        this.f35501a = kVar;
    }
}
