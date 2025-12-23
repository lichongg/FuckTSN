package com.huawei.hms.scankit.p;

import android.view.animation.Interpolator;
import androidx.annotation.NonNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class j5 implements f4 {

    /* renamed from: a, reason: collision with root package name */
    private final int f34453a;

    /* renamed from: b, reason: collision with root package name */
    private final int f34454b;

    /* renamed from: c, reason: collision with root package name */
    private final long f34455c;

    /* renamed from: d, reason: collision with root package name */
    private final long f34456d;

    /* renamed from: e, reason: collision with root package name */
    private final float f34457e;

    /* renamed from: f, reason: collision with root package name */
    private final Interpolator f34458f;

    private int a(@NonNull w5 w5Var) {
        int i6 = this.f34454b;
        return i6 == -1 ? w5Var.e() : i6;
    }

    private int b(@NonNull w5 w5Var) {
        int i6 = this.f34453a;
        return i6 == -1 ? w5Var.a() : i6;
    }

    @Override // com.huawei.hms.scankit.p.f4
    public void a(@NonNull w5 w5Var, long j6) {
        if (j6 < this.f34455c || j6 > this.f34456d || Float.compare(this.f34457e, 0.0f) == 0) {
            return;
        }
        w5Var.a((int) (b(w5Var) + (c(w5Var) * this.f34458f.getInterpolation((j6 - this.f34455c) / this.f34457e))));
    }

    public j5(int i6, int i7, long j6, long j7, @NonNull Interpolator interpolator) {
        this.f34453a = i6;
        this.f34454b = i7;
        this.f34455c = j6;
        this.f34456d = j7;
        this.f34457e = j7 - j6;
        this.f34458f = interpolator;
    }

    private int c(@NonNull w5 w5Var) {
        return a(w5Var) - b(w5Var);
    }
}
