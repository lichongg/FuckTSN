package com.bxkj.student.v2.ui.sports.v3.service.step;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class a implements SensorEventListener {

    /* renamed from: d, reason: collision with root package name */
    private int f22062d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f22063e;

    /* renamed from: f, reason: collision with root package name */
    private int f22064f;

    /* renamed from: g, reason: collision with root package name */
    private int f22065g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f22066h;

    /* renamed from: i, reason: collision with root package name */
    private float f22067i;

    /* renamed from: j, reason: collision with root package name */
    private float f22068j;

    /* renamed from: k, reason: collision with root package name */
    private long f22069k;

    /* renamed from: l, reason: collision with root package name */
    private long f22070l;

    /* renamed from: m, reason: collision with root package name */
    private long f22071m;

    /* renamed from: n, reason: collision with root package name */
    private float f22072n;

    /* renamed from: o, reason: collision with root package name */
    private float f22073o;

    /* renamed from: s, reason: collision with root package name */
    @Nullable
    private com.bxkj.student.run.app.step.b f22077s;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private double[] f22059a = new double[3];

    /* renamed from: b, reason: collision with root package name */
    private final int f22060b = 4;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private float[] f22061c = new float[4];

    /* renamed from: p, reason: collision with root package name */
    private final float f22074p = 1.3f;

    /* renamed from: q, reason: collision with root package name */
    private float f22075q = 2.0f;

    /* renamed from: r, reason: collision with root package name */
    private int f22076r = 250;

    public final void A(float f6) {
        this.f22072n = f6;
    }

    public final void B(float f6) {
        this.f22073o = f6;
    }

    public final void C(boolean z5) {
        this.f22066h = z5;
    }

    public final void D(@NotNull double[] dArr) {
        g0.p(dArr, "<set-?>");
        this.f22059a = dArr;
    }

    public final void E(float f6) {
        this.f22067i = f6;
    }

    public final void F(int i6) {
        this.f22062d = i6;
    }

    public final void G(@NotNull float[] fArr) {
        g0.p(fArr, "<set-?>");
        this.f22061c = fArr;
    }

    public final void H(float f6) {
        this.f22075q = f6;
    }

    public final void I(int i6) {
        this.f22076r = i6;
    }

    public final void J(long j6) {
        this.f22070l = j6;
    }

    public final void K(long j6) {
        this.f22071m = j6;
    }

    public final void L(long j6) {
        this.f22069k = j6;
    }

    public final void M(float f6) {
        this.f22068j = f6;
    }

    public final float a(@NotNull float[] value, int i6) {
        g0.p(value, "value");
        float f6 = 0.0f;
        for (int i7 = 0; i7 < i6; i7++) {
            f6 += value[i7];
        }
        float f7 = f6 / this.f22060b;
        if (f7 >= 8.0f) {
            return 4.3f;
        }
        if (f7 >= 7.0f && f7 < 8.0f) {
            return 3.3f;
        }
        if (f7 < 4.0f || f7 >= 7.0f) {
            return (f7 < 3.0f || f7 >= 4.0f) ? 1.3f : 2.0f;
        }
        return 2.3f;
    }

    public final void b(float f6) {
        float f7 = this.f22073o;
        if (f7 == 0.0f) {
            this.f22073o = f6;
        } else if (c(f6, f7)) {
            this.f22070l = this.f22069k;
            long currentTimeMillis = System.currentTimeMillis();
            this.f22071m = currentTimeMillis;
            if (currentTimeMillis - this.f22070l >= this.f22076r && this.f22067i - this.f22068j >= this.f22075q) {
                this.f22069k = currentTimeMillis;
                com.bxkj.student.run.app.step.b bVar = this.f22077s;
                if (bVar != null) {
                    g0.m(bVar);
                    bVar.a();
                }
            }
            long j6 = this.f22071m;
            if (j6 - this.f22070l >= this.f22076r) {
                float f8 = this.f22067i;
                float f9 = this.f22068j;
                if (f8 - f9 >= this.f22074p) {
                    this.f22069k = j6;
                    this.f22075q = w(f8 - f9);
                }
            }
        }
        this.f22073o = f6;
    }

    public final boolean c(float f6, float f7) {
        boolean z5 = this.f22063e;
        this.f22066h = z5;
        if (f6 >= f7) {
            this.f22063e = true;
            this.f22064f++;
        } else {
            this.f22065g = this.f22064f;
            this.f22064f = 0;
            this.f22063e = false;
        }
        boolean z6 = this.f22063e;
        if (!z6 && z5 && (this.f22065g >= 2 || f7 >= 20.0f)) {
            this.f22067i = f7;
            return true;
        }
        if (!z5 && z6) {
            this.f22068j = f7;
        }
        return false;
    }

    public final int d() {
        return this.f22064f;
    }

    public final int e() {
        return this.f22065g;
    }

    public final float f() {
        return this.f22072n;
    }

    public final float g() {
        return this.f22073o;
    }

    public final float h() {
        return this.f22074p;
    }

    public final boolean i() {
        return this.f22066h;
    }

    @NotNull
    public final double[] j() {
        return this.f22059a;
    }

    public final float k() {
        return this.f22067i;
    }

    public final int l() {
        return this.f22062d;
    }

    @NotNull
    public final float[] m() {
        return this.f22061c;
    }

    public final float n() {
        return this.f22075q;
    }

    public final int o() {
        return this.f22076r;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(@NotNull Sensor sensor, int i6) {
        g0.p(sensor, "sensor");
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(@NotNull SensorEvent event) {
        g0.p(event, "event");
        for (int i6 = 0; i6 < 3; i6++) {
            this.f22059a[i6] = event.values[i6];
        }
        com.bxkj.student.run.app.step.b bVar = this.f22077s;
        if (bVar != null) {
            g0.m(bVar);
            bVar.b(this.f22059a);
        }
        double[] dArr = this.f22059a;
        double d6 = dArr[0];
        double d7 = dArr[1];
        double d8 = (d6 * d6) + (d7 * d7);
        double d9 = dArr[2];
        float sqrt = (float) Math.sqrt(d8 + (d9 * d9));
        this.f22072n = sqrt;
        b(sqrt);
    }

    public final long p() {
        return this.f22070l;
    }

    public final long q() {
        return this.f22071m;
    }

    public final long r() {
        return this.f22069k;
    }

    public final float s() {
        return this.f22068j;
    }

    public final int t() {
        return this.f22060b;
    }

    public final void u(@Nullable com.bxkj.student.run.app.step.b bVar) {
        this.f22077s = bVar;
    }

    public final boolean v() {
        return this.f22063e;
    }

    public final float w(float f6) {
        float f7 = this.f22075q;
        int i6 = this.f22062d;
        int i7 = this.f22060b;
        if (i6 < i7) {
            this.f22061c[i6] = f6;
            this.f22062d = i6 + 1;
            return f7;
        }
        float a6 = a(this.f22061c, i7);
        int i8 = this.f22060b;
        for (int i9 = 1; i9 < i8; i9++) {
            float[] fArr = this.f22061c;
            fArr[i9 - 1] = fArr[i9];
        }
        this.f22061c[this.f22060b - 1] = f6;
        return a6;
    }

    public final void x(int i6) {
        this.f22064f = i6;
    }

    public final void y(int i6) {
        this.f22065g = i6;
    }

    public final void z(boolean z5) {
        this.f22063e = z5;
    }
}
