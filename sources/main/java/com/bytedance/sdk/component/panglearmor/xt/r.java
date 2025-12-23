package com.bytedance.sdk.component.panglearmor.xt;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.bytedance.sdk.component.oq.ae;
import com.bytedance.sdk.component.oq.g;
import com.bytedance.sdk.component.panglearmor.m;
import com.bytedance.sdk.component.utils.ws;
import com.stub.StubApp;
import com.umeng.analytics.pro.bi;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r implements SensorEventListener {

    /* renamed from: j, reason: collision with root package name */
    private static volatile r f26711j;
    private Sensor az;
    private volatile j mi;
    private Sensor ws;
    private volatile boolean xt = false;
    private final List<Float> cw = new ArrayList(1);

    /* renamed from: r, reason: collision with root package name */
    private final List<Float> f26715r = new ArrayList(1);
    private final List<Float> up = new ArrayList(1);

    /* renamed from: m, reason: collision with root package name */
    private final List<Float> f26714m = new ArrayList(1);
    private final List<Float> ae = new ArrayList(1);
    private final List<Float> tl = new ArrayList(1);

    /* renamed from: g, reason: collision with root package name */
    private final int f26712g = 0;
    private final int oq = 1;
    private final int qv = 2;
    private final int vl = 16;
    private final int jy = 32;
    private long av = 0;

    /* renamed from: i, reason: collision with root package name */
    private volatile boolean f26713i = false;

    /* renamed from: w, reason: collision with root package name */
    private volatile AtomicInteger f26716w = new AtomicInteger(0);
    private volatile int kt = 0;

    public interface j {
        void j(JSONObject jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ae() {
        this.cw.clear();
        this.f26715r.clear();
        this.up.clear();
        this.f26714m.clear();
        this.ae.clear();
        this.tl.clear();
    }

    private synchronized void m() {
        if (!this.xt && this.cw.size() > 0 && this.f26714m.size() > 0) {
            this.xt = true;
            up();
            ae.xt(new g("har") { // from class: com.bytedance.sdk.component.panglearmor.xt.r.1
                @Override // java.lang.Runnable
                public void run() {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        float[] j6 = cw.j(r.this.cw, r.this.f26715r, r.this.up, r.this.f26714m, r.this.ae, r.this.tl);
                        r.this.j(j6);
                        long currentTimeMillis = System.currentTimeMillis();
                        long m6 = up.j().m();
                        long ae = up.j().ae();
                        int cw = (int) (((up.j().cw() / 1000) / 60) / 60);
                        if (cw <= 0) {
                            cw = 1;
                        }
                        jSONObject.put("azimuth_unit", m6);
                        jSONObject.put("angle_unit", ae);
                        LinkedList<JSONObject> j7 = xt.j().j(0L);
                        jSONObject.put("active", Arrays.toString(cw.j(j7, cw)));
                        com.bytedance.sdk.component.panglearmor.xt.j.j().j(cw);
                        jSONObject.put("screen", Arrays.toString(com.bytedance.sdk.component.panglearmor.xt.j.j().cw()));
                        jSONObject.put("network", Arrays.toString(com.bytedance.sdk.component.panglearmor.xt.j.j().xt()));
                        jSONObject.put("support_net", com.bytedance.sdk.component.panglearmor.xt.j.j().r());
                        jSONObject.put("sim_status", com.bytedance.sdk.component.panglearmor.xt.j.j().up());
                        int[][] j8 = cw.j(j7, m6, ae);
                        jSONObject.put("ax", Arrays.toString(j8[0]));
                        jSONObject.put("ay", Arrays.toString(j8[1]));
                        jSONObject.put("az", Arrays.toString(j8[2]));
                        int[][] j9 = cw.j(xt.j().j(10800000L), m6, ae);
                        jSONObject.put("ax3", Arrays.toString(j9[0]));
                        jSONObject.put("ay3", Arrays.toString(j9[1]));
                        jSONObject.put("az3", Arrays.toString(j9[2]));
                        int[][] j10 = cw.j(xt.j().j(21600000L), m6, ae);
                        jSONObject.put("ax6", Arrays.toString(j10[0]));
                        jSONObject.put("ay6", Arrays.toString(j10[1]));
                        jSONObject.put("az6", Arrays.toString(j10[2]));
                        jSONObject.put("angleAvg", Arrays.toString(j6));
                        jSONObject.put("timestamp", currentTimeMillis);
                    } catch (Exception unused) {
                        jSONObject = null;
                    }
                    if (r.this.mi != null) {
                        r.this.mi.j(jSONObject);
                    }
                    r.this.ae();
                    r.this.f26713i = false;
                }
            });
        } else {
            if (this.f26716w.get() > 3) {
                up();
                ae();
                this.f26713i = false;
            }
        }
    }

    private void up() {
        this.f26716w = new AtomicInteger(0);
        SensorManager sensorManager = (SensorManager) StubApp.getOrigApplicationContext(m.r().getApplicationContext()).getSystemService(bi.ac);
        if (sensorManager != null) {
            Sensor sensor = this.ws;
            if (sensor != null) {
                sensorManager.unregisterListener(this, sensor);
            }
            Sensor sensor2 = this.az;
            if (sensor2 != null) {
                sensorManager.unregisterListener(this, sensor2);
            }
        }
    }

    public boolean cw() {
        return this.f26713i;
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        this.f26716w.incrementAndGet();
        int type = sensorEvent.sensor.getType();
        if (type == 1) {
            if (this.cw.size() > 0) {
                m();
                return;
            }
            this.cw.add(Float.valueOf(sensorEvent.values[0]));
            this.f26715r.add(Float.valueOf(sensorEvent.values[1]));
            this.up.add(Float.valueOf(sensorEvent.values[2]));
            return;
        }
        if (type != 2) {
            return;
        }
        if (this.f26714m.size() > 0) {
            m();
            return;
        }
        this.f26714m.add(Float.valueOf(sensorEvent.values[0]));
        this.ae.add(Float.valueOf(sensorEvent.values[1]));
        this.tl.add(Float.valueOf(sensorEvent.values[2]));
    }

    public long r() {
        return this.av;
    }

    public synchronized boolean xt() {
        int i6;
        int i7;
        boolean registerListener;
        boolean registerListener2;
        try {
            this.kt = 0;
            if (this.f26713i) {
                return false;
            }
            if (this.ws == null || this.az == null) {
                this.kt |= this.ws == null ? 2 : 0;
                int i8 = this.kt;
                if (this.az == null) {
                    i6 = i8;
                    i7 = 16;
                } else {
                    i6 = i8;
                    i7 = 0;
                }
            } else {
                this.f26713i = false;
                SensorManager sensorManager = (SensorManager) StubApp.getOrigApplicationContext(m.r().getApplicationContext()).getSystemService(bi.ac);
                i7 = 1;
                if (sensorManager != null) {
                    try {
                        registerListener = sensorManager.registerListener(this, this.ws, 1);
                        registerListener2 = sensorManager.registerListener(this, this.az, 1);
                    } catch (Exception unused) {
                        i6 = this.kt;
                        i7 = 32;
                    }
                    if (registerListener && registerListener2) {
                        this.f26713i = true;
                        this.xt = false;
                        return this.f26713i;
                    }
                    this.kt |= 32;
                    up();
                    ae();
                    return this.f26713i;
                }
                i6 = this.kt;
            }
            this.kt = i6 | i7;
            return this.f26713i;
        } catch (Throwable th) {
            throw th;
        }
    }

    private r() {
        this.ws = null;
        this.az = null;
        SensorManager sensorManager = (SensorManager) StubApp.getOrigApplicationContext(m.r().getApplicationContext()).getSystemService(bi.ac);
        if (sensorManager != null) {
            try {
                this.ws = sensorManager.getDefaultSensor(1);
                this.az = sensorManager.getDefaultSensor(2);
            } catch (Exception unused) {
            }
        }
    }

    public static r j() {
        if (f26711j == null) {
            synchronized (r.class) {
                try {
                    if (f26711j == null) {
                        f26711j = new r();
                    }
                } finally {
                }
            }
        }
        return f26711j;
    }

    public void j(j jVar) {
        this.mi = jVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(float[] fArr) {
        this.av = System.currentTimeMillis();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(bi.aL, r());
            jSONObject.put("val", new JSONArray(fArr));
            xt.j().j(jSONObject, "sp_angle");
            xt.j().j(ws.cw(m.r()));
        } catch (JSONException e6) {
            throw new RuntimeException(e6);
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i6) {
    }
}
