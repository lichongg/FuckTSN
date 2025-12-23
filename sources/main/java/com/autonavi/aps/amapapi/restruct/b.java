package com.autonavi.aps.amapapi.restruct;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import com.umeng.analytics.pro.bi;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class b implements SensorEventListener {

    /* renamed from: a, reason: collision with root package name */
    SensorManager f10008a;

    /* renamed from: b, reason: collision with root package name */
    Sensor f10009b;

    /* renamed from: c, reason: collision with root package name */
    Sensor f10010c;

    /* renamed from: d, reason: collision with root package name */
    Sensor f10011d;

    /* renamed from: s, reason: collision with root package name */
    private Context f10026s;

    /* renamed from: e, reason: collision with root package name */
    public boolean f10012e = false;

    /* renamed from: f, reason: collision with root package name */
    public double f10013f = 0.0d;

    /* renamed from: g, reason: collision with root package name */
    public float f10014g = 0.0f;

    /* renamed from: t, reason: collision with root package name */
    private float f10027t = 1013.25f;

    /* renamed from: u, reason: collision with root package name */
    private float f10028u = 0.0f;

    /* renamed from: h, reason: collision with root package name */
    Handler f10015h = new Handler();

    /* renamed from: i, reason: collision with root package name */
    double f10016i = 0.0d;

    /* renamed from: j, reason: collision with root package name */
    double f10017j = 0.0d;

    /* renamed from: k, reason: collision with root package name */
    double f10018k = 0.0d;

    /* renamed from: l, reason: collision with root package name */
    double f10019l = 0.0d;

    /* renamed from: m, reason: collision with root package name */
    double[] f10020m = new double[3];

    /* renamed from: n, reason: collision with root package name */
    volatile double f10021n = 0.0d;

    /* renamed from: o, reason: collision with root package name */
    long f10022o = 0;

    /* renamed from: p, reason: collision with root package name */
    long f10023p = 0;

    /* renamed from: q, reason: collision with root package name */
    final int f10024q = 100;

    /* renamed from: r, reason: collision with root package name */
    final int f10025r = 30;

    public final void a() {
        SensorManager sensorManager = this.f10008a;
        if (sensorManager == null || this.f10012e) {
            return;
        }
        this.f10012e = true;
        try {
            Sensor sensor = this.f10009b;
            if (sensor != null) {
                sensorManager.registerListener(this, sensor, 3, this.f10015h);
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "AMapSensorManager", "registerListener mPressure");
        }
        try {
            Sensor sensor2 = this.f10010c;
            if (sensor2 != null) {
                this.f10008a.registerListener(this, sensor2, 3, this.f10015h);
            }
        } catch (Throwable th2) {
            com.autonavi.aps.amapapi.utils.b.a(th2, "AMapSensorManager", "registerListener mRotationVector");
        }
        try {
            Sensor sensor3 = this.f10011d;
            if (sensor3 != null) {
                this.f10008a.registerListener(this, sensor3, 3, this.f10015h);
            }
        } catch (Throwable th3) {
            com.autonavi.aps.amapapi.utils.b.a(th3, "AMapSensorManager", "registerListener mAcceleroMeterVector");
        }
    }

    public final void b() {
        SensorManager sensorManager = this.f10008a;
        if (sensorManager == null || !this.f10012e) {
            return;
        }
        this.f10012e = false;
        try {
            Sensor sensor = this.f10009b;
            if (sensor != null) {
                sensorManager.unregisterListener(this, sensor);
            }
        } catch (Throwable unused) {
        }
        try {
            Sensor sensor2 = this.f10010c;
            if (sensor2 != null) {
                this.f10008a.unregisterListener(this, sensor2);
            }
        } catch (Throwable unused2) {
        }
        try {
            Sensor sensor3 = this.f10011d;
            if (sensor3 != null) {
                this.f10008a.unregisterListener(this, sensor3);
            }
        } catch (Throwable unused3) {
        }
    }

    public final double c() {
        return this.f10013f;
    }

    private void c(float[] fArr) {
        if (fArr != null) {
            float[] fArr2 = new float[9];
            SensorManager.getRotationMatrixFromVector(fArr2, fArr);
            SensorManager.getOrientation(fArr2, new float[3]);
            float degrees = (float) Math.toDegrees(r3[0]);
            this.f10028u = degrees;
            if (degrees <= 0.0f) {
                degrees += 360.0f;
            }
            this.f10028u = (float) Math.floor(degrees);
        }
    }

    public final float d() {
        return this.f10028u;
    }

    public final double e() {
        return this.f10019l;
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent == null) {
            return;
        }
        try {
            int type = sensorEvent.sensor.getType();
            if (type == 1) {
                if (this.f10011d != null) {
                    a((float[]) sensorEvent.values.clone());
                }
            } else {
                if (type != 6) {
                    if (type == 11 && this.f10010c != null) {
                        c((float[]) sensorEvent.values.clone());
                        return;
                    }
                    return;
                }
                if (this.f10009b != null) {
                    float[] fArr = (float[]) sensorEvent.values.clone();
                    this.f10014g = fArr[0];
                    b(fArr);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public b(Context context) {
        this.f10026s = null;
        this.f10008a = null;
        this.f10009b = null;
        this.f10010c = null;
        this.f10011d = null;
        try {
            this.f10026s = context;
            if (this.f10008a == null) {
                this.f10008a = (SensorManager) context.getSystemService(bi.ac);
            }
            try {
                this.f10009b = this.f10008a.getDefaultSensor(6);
            } catch (Throwable unused) {
            }
            try {
                this.f10010c = this.f10008a.getDefaultSensor(11);
            } catch (Throwable unused2) {
            }
            try {
                this.f10011d = this.f10008a.getDefaultSensor(1);
            } catch (Throwable unused3) {
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "AMapSensorManager", "<init>");
        }
    }

    public final void f() {
        try {
            b();
            this.f10009b = null;
            this.f10010c = null;
            this.f10008a = null;
            this.f10011d = null;
            this.f10012e = false;
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "AMapSensorManager", "destroy");
        }
    }

    private void b(float[] fArr) {
        if (fArr != null) {
            this.f10013f = com.autonavi.aps.amapapi.utils.j.a(SensorManager.getAltitude(this.f10027t, fArr[0]));
        }
    }

    private void a(float[] fArr) {
        double[] dArr = this.f10020m;
        double d6 = dArr[0] * 0.800000011920929d;
        float f6 = fArr[0];
        double d7 = d6 + (f6 * 0.19999999f);
        dArr[0] = d7;
        double d8 = dArr[1] * 0.800000011920929d;
        float f7 = fArr[1];
        double d9 = d8 + (f7 * 0.19999999f);
        dArr[1] = d9;
        double d10 = dArr[2] * 0.800000011920929d;
        float f8 = fArr[2];
        double d11 = d10 + (0.19999999f * f8);
        dArr[2] = d11;
        this.f10016i = f6 - d7;
        this.f10017j = f7 - d9;
        this.f10018k = f8 - d11;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f10022o < 100) {
            return;
        }
        double d12 = this.f10016i;
        double d13 = this.f10017j;
        double d14 = (d12 * d12) + (d13 * d13);
        double d15 = this.f10018k;
        double sqrt = Math.sqrt(d14 + (d15 * d15));
        this.f10023p++;
        this.f10022o = currentTimeMillis;
        this.f10021n += sqrt;
        if (this.f10023p >= 30) {
            this.f10019l = this.f10021n / this.f10023p;
            this.f10021n = 0.0d;
            this.f10023p = 0L;
        }
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i6) {
    }
}
