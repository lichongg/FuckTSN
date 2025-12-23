package com.bxkj.student.run.app.step;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class c implements SensorEventListener {

    /* renamed from: a, reason: collision with root package name */
    double[] f20073a = new double[3];

    /* renamed from: b, reason: collision with root package name */
    final int f20074b = 4;

    /* renamed from: c, reason: collision with root package name */
    float[] f20075c = new float[4];

    /* renamed from: d, reason: collision with root package name */
    int f20076d = 0;

    /* renamed from: e, reason: collision with root package name */
    boolean f20077e = false;

    /* renamed from: f, reason: collision with root package name */
    int f20078f = 0;

    /* renamed from: g, reason: collision with root package name */
    int f20079g = 0;

    /* renamed from: h, reason: collision with root package name */
    boolean f20080h = false;

    /* renamed from: i, reason: collision with root package name */
    float f20081i = 0.0f;

    /* renamed from: j, reason: collision with root package name */
    float f20082j = 0.0f;

    /* renamed from: k, reason: collision with root package name */
    long f20083k = 0;

    /* renamed from: l, reason: collision with root package name */
    long f20084l = 0;

    /* renamed from: m, reason: collision with root package name */
    long f20085m = 0;

    /* renamed from: n, reason: collision with root package name */
    float f20086n = 0.0f;

    /* renamed from: o, reason: collision with root package name */
    float f20087o = 0.0f;

    /* renamed from: p, reason: collision with root package name */
    final float f20088p = 1.3f;

    /* renamed from: q, reason: collision with root package name */
    float f20089q = 2.0f;

    /* renamed from: r, reason: collision with root package name */
    int f20090r = 250;

    /* renamed from: s, reason: collision with root package name */
    private b f20091s;

    public float a(float[] value, int n6) {
        float f6 = 0.0f;
        for (int i6 = 0; i6 < n6; i6++) {
            f6 += value[i6];
        }
        float f7 = f6 / 4.0f;
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

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent event) {
        for (int i6 = 0; i6 < 3; i6++) {
            this.f20073a[i6] = event.values[i6];
        }
        b bVar = this.f20091s;
        if (bVar != null) {
            bVar.b(this.f20073a);
        }
        double[] dArr = this.f20073a;
        double d6 = dArr[0];
        double d7 = dArr[1];
        double d8 = (d6 * d6) + (d7 * d7);
        double d9 = dArr[2];
        float sqrt = (float) Math.sqrt(d8 + (d9 * d9));
        this.f20086n = sqrt;
        b(sqrt);
    }

    public void b(float values) {
        float f6 = this.f20087o;
        if (f6 == 0.0f) {
            this.f20087o = values;
        } else if (c(values, f6)) {
            this.f20084l = this.f20083k;
            long currentTimeMillis = System.currentTimeMillis();
            this.f20085m = currentTimeMillis;
            if (currentTimeMillis - this.f20084l >= this.f20090r && this.f20081i - this.f20082j >= this.f20089q) {
                this.f20083k = currentTimeMillis;
                b bVar = this.f20091s;
                if (bVar != null) {
                    bVar.a();
                }
            }
            long j6 = this.f20085m;
            if (j6 - this.f20084l >= this.f20090r) {
                float f7 = this.f20081i;
                float f8 = this.f20082j;
                if (f7 - f8 >= 1.3f) {
                    this.f20083k = j6;
                    this.f20089q = e(f7 - f8);
                }
            }
        }
        this.f20087o = values;
    }

    public boolean c(float newValue, float oldValue) {
        boolean z5 = this.f20077e;
        this.f20080h = z5;
        if (newValue >= oldValue) {
            this.f20077e = true;
            this.f20078f++;
        } else {
            this.f20079g = this.f20078f;
            this.f20078f = 0;
            this.f20077e = false;
        }
        boolean z6 = this.f20077e;
        if (!z6 && z5 && (this.f20079g >= 2 || oldValue >= 20.0f)) {
            this.f20081i = oldValue;
            return true;
        }
        if (!z5 && z6) {
            this.f20082j = oldValue;
        }
        return false;
    }

    public void d(b listener) {
        this.f20091s = listener;
    }

    public float e(float value) {
        float f6 = this.f20089q;
        int i6 = this.f20076d;
        if (i6 < 4) {
            this.f20075c[i6] = value;
            this.f20076d = i6 + 1;
            return f6;
        }
        float a6 = a(this.f20075c, 4);
        for (int i7 = 1; i7 < 4; i7++) {
            float[] fArr = this.f20075c;
            fArr[i7 - 1] = fArr[i7];
        }
        this.f20075c[3] = value;
        return a6;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }
}
