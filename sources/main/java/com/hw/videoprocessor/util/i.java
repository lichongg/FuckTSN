package com.hw.videoprocessor.util;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class i implements k {

    /* renamed from: a, reason: collision with root package name */
    private float[] f35497a;

    /* renamed from: b, reason: collision with root package name */
    private int f35498b;

    /* renamed from: c, reason: collision with root package name */
    private k f35499c;

    /* renamed from: d, reason: collision with root package name */
    private float f35500d;

    @Override // com.hw.videoprocessor.util.k
    public void a(float f6) {
        k kVar = this.f35499c;
        if (kVar != null) {
            kVar.a((f6 * this.f35497a[this.f35498b]) + this.f35500d);
        }
    }

    public void b(int i6) {
        this.f35498b = i6;
        this.f35500d = 0.0f;
        for (int i7 = 0; i7 < i6; i7++) {
            this.f35500d += this.f35497a[i7];
        }
    }

    public void c(k kVar) {
        this.f35499c = kVar;
    }

    public i(float[] fArr, k kVar) {
        this.f35497a = fArr;
        this.f35499c = kVar;
    }
}
