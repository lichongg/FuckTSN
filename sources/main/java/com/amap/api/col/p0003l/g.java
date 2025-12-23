package com.amap.api.col.p0003l;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.WindowManager;
import com.amap.api.maps.model.Marker;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.stub.StubApp;
import com.umeng.analytics.pro.bi;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class g implements SensorEventListener {

    /* renamed from: a, reason: collision with root package name */
    private SensorManager f6270a;

    /* renamed from: b, reason: collision with root package name */
    private Sensor f6271b;

    /* renamed from: c, reason: collision with root package name */
    private Sensor f6272c;

    /* renamed from: d, reason: collision with root package name */
    private Sensor f6273d;

    /* renamed from: e, reason: collision with root package name */
    private Context f6274e;

    /* renamed from: f, reason: collision with root package name */
    private IAMapDelegate f6275f;

    /* renamed from: g, reason: collision with root package name */
    private Marker f6276g;

    /* renamed from: h, reason: collision with root package name */
    private float f6277h;

    /* renamed from: i, reason: collision with root package name */
    private float[] f6278i = new float[3];

    /* renamed from: j, reason: collision with root package name */
    private float[] f6279j = new float[3];

    /* renamed from: k, reason: collision with root package name */
    private float[] f6280k = new float[3];

    /* renamed from: l, reason: collision with root package name */
    private float[] f6281l = new float[9];

    /* renamed from: m, reason: collision with root package name */
    private boolean f6282m = true;

    private float b(float[] fArr, float[] fArr2) {
        if (!SensorManager.getRotationMatrix(this.f6281l, null, fArr, fArr2)) {
            return 0.0f;
        }
        SensorManager.getOrientation(this.f6281l, this.f6280k);
        this.f6280k[0] = (float) Math.toDegrees(r3[0]);
        return this.f6280k[0];
    }

    private static int c(Context context) {
        WindowManager windowManager;
        if (context == null || (windowManager = (WindowManager) context.getSystemService("window")) == null) {
            return 0;
        }
        try {
            int rotation = windowManager.getDefaultDisplay().getRotation();
            if (rotation == 1) {
                return 90;
            }
            if (rotation != 2) {
                return rotation != 3 ? 0 : -90;
            }
            return 180;
        } catch (Throwable unused) {
            return 0;
        }
    }

    private float g(float f6) {
        float c6 = (f6 + c(this.f6274e)) % 360.0f;
        if (c6 > 180.0f) {
            c6 -= 360.0f;
        } else if (c6 < -180.0f) {
            c6 += 360.0f;
        }
        if (Float.isNaN(c6)) {
            return 0.0f;
        }
        return c6;
    }

    private void i(float f6) {
        Marker marker = this.f6276g;
        if (marker != null) {
            try {
                if (!this.f6282m) {
                    marker.setRotateAngle(360.0f - f6);
                } else {
                    this.f6275f.moveCamera(p.q(f6));
                    this.f6276g.setRotateAngle(-f6);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private boolean j() {
        SensorManager sensorManager = this.f6270a;
        if (sensorManager == null) {
            return false;
        }
        for (Sensor sensor : sensorManager.getSensorList(-1)) {
            int type = sensor.getType();
            sensor.getStringType();
            if (type == 3) {
                return true;
            }
        }
        return false;
    }

    public final void d() {
        Sensor sensor;
        Sensor sensor2;
        SensorManager sensorManager = this.f6270a;
        if (sensorManager != null && (sensor2 = this.f6271b) != null) {
            sensorManager.registerListener(this, sensor2, 3);
        }
        SensorManager sensorManager2 = this.f6270a;
        if (sensorManager2 == null || (sensor = this.f6272c) == null || this.f6273d == null) {
            return;
        }
        sensorManager2.registerListener(this, sensor, 3);
        this.f6270a.registerListener(this, this.f6273d, 3);
    }

    public final void e(Marker marker) {
        this.f6276g = marker;
    }

    public final void f(boolean z5) {
        this.f6282m = z5;
    }

    public final void h() {
        Sensor sensor;
        Sensor sensor2;
        SensorManager sensorManager = this.f6270a;
        if (sensorManager != null && (sensor2 = this.f6271b) != null) {
            sensorManager.unregisterListener(this, sensor2);
        }
        SensorManager sensorManager2 = this.f6270a;
        if (sensorManager2 == null || (sensor = this.f6272c) == null || this.f6273d == null) {
            return;
        }
        sensorManager2.unregisterListener(this, sensor);
        this.f6270a.unregisterListener(this, this.f6273d);
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        try {
            if (this.f6275f.getGLMapEngine() == null || this.f6275f.getGLMapEngine().getAnimateionsCount() <= 0) {
                int type = sensorEvent.sensor.getType();
                if (type == 3) {
                    float f6 = sensorEvent.values[0];
                    float a6 = a(f6);
                    if (Math.abs(this.f6277h - f6) < 3.0f) {
                        return;
                    }
                    this.f6277h = a6;
                    i(a6);
                    return;
                }
                if (type == 1) {
                    this.f6278i = (float[]) sensorEvent.values.clone();
                } else if (type == 2) {
                    this.f6279j = (float[]) sensorEvent.values.clone();
                }
                float b6 = b(this.f6278i, this.f6279j);
                if (Math.abs(this.f6277h - b6) < 3.0f) {
                    return;
                }
                this.f6277h = b6;
                i(b6);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public g(Context context, IAMapDelegate iAMapDelegate) {
        this.f6274e = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f6275f = iAMapDelegate;
        try {
            SensorManager sensorManager = (SensorManager) context.getSystemService(bi.ac);
            this.f6270a = sensorManager;
            if (sensorManager != null && j()) {
                this.f6271b = this.f6270a.getDefaultSensor(3);
            } else {
                this.f6272c = this.f6270a.getDefaultSensor(1);
                this.f6273d = this.f6270a.getDefaultSensor(2);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private float a(float f6) {
        return g(f6);
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i6) {
    }
}
