package com.bytedance.sdk.component.utils;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.umeng.analytics.pro.bi;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\Downloads\app\classes4.dex */
public class tj implements SensorEventListener {

    /* renamed from: j, reason: collision with root package name */
    private static volatile tj f26896j;
    private volatile Sensor cw;

    /* renamed from: m, reason: collision with root package name */
    private volatile Sensor f26898m;

    /* renamed from: r, reason: collision with root package name */
    private volatile Sensor f26899r;
    private volatile Sensor up;
    private final SensorManager xt;
    private final AtomicBoolean ae = new AtomicBoolean(false);
    private final AtomicBoolean tl = new AtomicBoolean(false);

    /* renamed from: g, reason: collision with root package name */
    private final AtomicBoolean f26897g = new AtomicBoolean(false);
    private final AtomicBoolean oq = new AtomicBoolean(false);
    private final Map<SensorEventListener, Object> qv = new ConcurrentHashMap();

    public static tj j(Context context) {
        if (f26896j == null) {
            synchronized (tj.class) {
                try {
                    if (f26896j == null) {
                        f26896j = new tj(context);
                    }
                } finally {
                }
            }
        }
        return f26896j;
    }

    private Sensor cw() {
        if (this.f26899r == null) {
            synchronized (tj.class) {
                try {
                    if (this.f26899r == null) {
                        this.f26899r = this.xt.getDefaultSensor(15);
                    }
                } finally {
                }
            }
        }
        return this.f26899r;
    }

    private Sensor r() {
        if (this.up == null) {
            synchronized (tj.class) {
                try {
                    if (this.up == null) {
                        this.up = this.xt.getDefaultSensor(4);
                    }
                } finally {
                }
            }
        }
        return this.up;
    }

    private Sensor up() {
        if (this.f26898m == null) {
            synchronized (tj.class) {
                try {
                    if (this.f26898m == null) {
                        this.f26898m = this.xt.getDefaultSensor(10);
                    }
                } finally {
                }
            }
        }
        return this.f26898m;
    }

    private Sensor xt() {
        if (this.cw == null) {
            synchronized (tj.class) {
                try {
                    if (this.cw == null) {
                        this.cw = this.xt.getDefaultSensor(1);
                    }
                } finally {
                }
            }
        }
        return this.cw;
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        SensorEventListener key;
        for (Map.Entry<SensorEventListener, Object> entry : this.qv.entrySet()) {
            if (entry != null && (key = entry.getKey()) != null) {
                key.onSensorChanged(sensorEvent);
            }
        }
    }

    private tj(Context context) {
        this.xt = (SensorManager) context.getSystemService(bi.ac);
    }

    public Sensor j(int i6) {
        if (i6 == 1) {
            return xt();
        }
        if (i6 == 4) {
            return r();
        }
        if (i6 == 10) {
            return up();
        }
        if (i6 != 15) {
            return null;
        }
        return cw();
    }

    public boolean j(SensorEventListener sensorEventListener, Sensor sensor, int i6) {
        this.qv.put(sensorEventListener, 0);
        if (sensor == this.cw) {
            if (!this.ae.getAndSet(true)) {
                return this.xt.registerListener(this, sensor, i6);
            }
        } else if (sensor == this.f26899r) {
            if (!this.tl.getAndSet(true)) {
                return this.xt.registerListener(this, sensor, i6);
            }
        } else if (sensor == this.up) {
            if (!this.f26897g.getAndSet(true)) {
                return this.xt.registerListener(this, sensor, i6);
            }
        } else if (sensor == this.f26898m && !this.oq.getAndSet(true)) {
            return this.xt.registerListener(this, sensor, i6);
        }
        return true;
    }

    public void j(SensorEventListener sensorEventListener) {
        this.qv.remove(sensorEventListener);
        vl.j("TMe", "--==---- unreg shake size: " + this.qv.size());
        if (this.qv.isEmpty()) {
            try {
                this.xt.unregisterListener(this);
            } catch (Throwable th) {
                vl.j(th);
            }
            this.ae.set(false);
            this.tl.set(false);
            this.f26897g.set(false);
            this.oq.set(false);
        }
    }

    public int j() {
        return this.qv.size();
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i6) {
    }
}
