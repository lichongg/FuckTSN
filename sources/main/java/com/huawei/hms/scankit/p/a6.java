package com.huawei.hms.scankit.p;

import androidx.annotation.NonNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class a6 implements g4 {

    /* renamed from: a, reason: collision with root package name */
    private final float f33990a;

    /* renamed from: b, reason: collision with root package name */
    private final float f33991b;

    @Override // com.huawei.hms.scankit.p.g4
    public void a(@NonNull w5 w5Var) {
        float f6 = this.f33990a;
        float f7 = this.f33991b;
        if (f6 != f7) {
            f6 = n6.a(f6 - f7) + this.f33991b;
        }
        w5Var.b(f6);
        w5Var.a(f6);
    }

    public a6(float f6, float f7) {
        this.f33991b = f6;
        this.f33990a = f7;
    }
}
