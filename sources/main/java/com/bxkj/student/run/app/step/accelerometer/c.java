package com.bxkj.student.run.app.step.accelerometer;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class c implements SensorEventListener {

    /* renamed from: a, reason: collision with root package name */
    float[] f20054a = new float[3];

    /* renamed from: b, reason: collision with root package name */
    final int f20055b = 4;

    /* renamed from: c, reason: collision with root package name */
    float[] f20056c = new float[4];

    /* renamed from: d, reason: collision with root package name */
    int f20057d = 0;

    /* renamed from: e, reason: collision with root package name */
    boolean f20058e = false;

    /* renamed from: f, reason: collision with root package name */
    int f20059f = 0;

    /* renamed from: g, reason: collision with root package name */
    int f20060g = 0;

    /* renamed from: h, reason: collision with root package name */
    boolean f20061h = false;

    /* renamed from: i, reason: collision with root package name */
    float f20062i = 0.0f;

    /* renamed from: j, reason: collision with root package name */
    float f20063j = 0.0f;

    /* renamed from: k, reason: collision with root package name */
    long f20064k = 0;

    /* renamed from: l, reason: collision with root package name */
    long f20065l = 0;

    /* renamed from: m, reason: collision with root package name */
    long f20066m = 0;

    /* renamed from: n, reason: collision with root package name */
    float f20067n = 0.0f;

    /* renamed from: o, reason: collision with root package name */
    float f20068o = 0.0f;

    /* renamed from: p, reason: collision with root package name */
    final float f20069p = 1.3f;

    /* renamed from: q, reason: collision with root package name */
    float f20070q = 2.0f;

    /* renamed from: r, reason: collision with root package name */
    int f20071r = 250;

    /* renamed from: s, reason: collision with root package name */
    private b f20072s;

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
            this.f20054a[i6] = event.values[i6];
        }
        float[] fArr = this.f20054a;
        float f6 = fArr[0];
        float f7 = fArr[1];
        float f8 = fArr[2];
        float sqrt = (float) Math.sqrt((f6 * f6) + (f7 * f7) + (f8 * f8));
        this.f20067n = sqrt;
        b(sqrt);
    }

    public void b(float values) {
        float f6 = this.f20068o;
        if (f6 == 0.0f) {
            this.f20068o = values;
        } else if (c(values, f6)) {
            this.f20065l = this.f20064k;
            long currentTimeMillis = System.currentTimeMillis();
            this.f20066m = currentTimeMillis;
            if (currentTimeMillis - this.f20065l >= this.f20071r && this.f20062i - this.f20063j >= this.f20070q) {
                this.f20064k = currentTimeMillis;
                this.f20072s.a();
            }
            long j6 = this.f20066m;
            if (j6 - this.f20065l >= this.f20071r) {
                float f7 = this.f20062i;
                float f8 = this.f20063j;
                if (f7 - f8 >= 1.3f) {
                    this.f20064k = j6;
                    this.f20070q = e(f7 - f8);
                }
            }
        }
        this.f20068o = values;
    }

    public boolean c(float newValue, float oldValue) {
        boolean z5 = this.f20058e;
        this.f20061h = z5;
        if (newValue >= oldValue) {
            this.f20058e = true;
            this.f20059f++;
        } else {
            this.f20060g = this.f20059f;
            this.f20059f = 0;
            this.f20058e = false;
        }
        boolean z6 = this.f20058e;
        if (!z6 && z5 && (this.f20060g >= 2 || oldValue >= 20.0f)) {
            this.f20062i = oldValue;
            return true;
        }
        if (!z5 && z6) {
            this.f20063j = oldValue;
        }
        return false;
    }

    public void d(b listener) {
        this.f20072s = listener;
    }

    public float e(float value) {
        float f6 = this.f20070q;
        int i6 = this.f20057d;
        if (i6 < 4) {
            this.f20056c[i6] = value;
            this.f20057d = i6 + 1;
            return f6;
        }
        float a6 = a(this.f20056c, 4);
        for (int i7 = 1; i7 < 4; i7++) {
            float[] fArr = this.f20056c;
            fArr[i7 - 1] = fArr[i7];
        }
        this.f20056c[3] = value;
        return a6;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }
}
