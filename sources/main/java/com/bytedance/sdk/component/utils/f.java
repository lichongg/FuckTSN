package com.bytedance.sdk.component.utils;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.stub.StubApp;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class f implements SensorEventListener {
    private static v ry;
    private volatile long ae;
    private Sensor av;
    private Sensor az;

    /* renamed from: c, reason: collision with root package name */
    private float f26862c;
    private float cw;
    private Context ff;

    /* renamed from: i, reason: collision with root package name */
    private Sensor f26867i;

    /* renamed from: k, reason: collision with root package name */
    private boolean f26869k;
    private int mi;

    /* renamed from: n, reason: collision with root package name */
    private float f26872n;
    private tj qv;

    /* renamed from: r, reason: collision with root package name */
    private float f26875r;
    private float rh;

    /* renamed from: s, reason: collision with root package name */
    private float f26876s;
    private float up;

    /* renamed from: w, reason: collision with root package name */
    private float f26878w;
    private JSONObject wq;
    private Sensor ws;

    /* renamed from: x, reason: collision with root package name */
    private int f26879x;
    private cw xq;
    private volatile long xt;

    /* renamed from: j, reason: collision with root package name */
    private final long f26868j = 2000;

    /* renamed from: m, reason: collision with root package name */
    private boolean f26871m = false;
    private float tl = 13.0f;

    /* renamed from: g, reason: collision with root package name */
    private float f26865g = 50.0f;
    private int oq = 0;
    private j vl = null;
    private xt jy = null;
    private final long kt = 500;
    private volatile long tj = 0;

    /* renamed from: f, reason: collision with root package name */
    private volatile boolean f26864f = false;

    /* renamed from: v, reason: collision with root package name */
    private volatile boolean f26877v = false;
    private final float ch = 1.0E-9f;

    /* renamed from: a, reason: collision with root package name */
    private float[] f26860a = new float[3];

    /* renamed from: l, reason: collision with root package name */
    private long f26870l = 0;

    /* renamed from: p, reason: collision with root package name */
    private float f26873p = 0.0f;

    /* renamed from: h, reason: collision with root package name */
    private float f26866h = 4.0f;
    private float la = 0.0f;
    private float[] gq = new float[3];
    private final float rn = 0.0f;
    private boolean uf = false;
    private boolean ed = false;
    private boolean gx = false;
    private boolean nd = false;
    private int ol = 0;
    private int hh = 0;

    /* renamed from: z, reason: collision with root package name */
    private int f26880z = 0;
    private int hl = 0;

    /* renamed from: b, reason: collision with root package name */
    private int f26861b = 0;

    /* renamed from: e, reason: collision with root package name */
    private int f26863e = 0;

    /* renamed from: q, reason: collision with root package name */
    private boolean f26874q = false;
    private int qb = 0;
    private int ya = 0;
    private float sm = 0.0f;

    public interface cw {
        void j();
    }

    public interface j {
        void j(int i6);
    }

    public interface xt {
        void j(float f6, float f7, float f8);
    }

    private void ae() {
        this.ol = 0;
        this.hh = 0;
        this.f26880z = 0;
    }

    private boolean cw() {
        int i6;
        tj tjVar = this.qv;
        boolean z5 = false;
        if (tjVar == null) {
            return false;
        }
        try {
            if (this.mi == 0) {
                if (this.az == null) {
                    this.az = tjVar.j(15);
                }
                this.f26871m = false;
                z5 = this.qv.j(this, this.az, 1);
            }
            int i7 = this.mi;
            if (i7 == 3 || i7 == 2 || i7 == 4 || i7 == 7) {
                if (this.av == null) {
                    this.av = this.qv.j(4);
                }
                float f6 = this.f26866h;
                if (f6 != 0.0f && ((i6 = this.mi) == 2 || i6 == 4)) {
                    this.sm = (float) Math.pow(f6, 2.0d);
                    if (this.f26867i == null) {
                        this.f26867i = this.qv.j(10);
                    }
                    this.qv.j(this, this.f26867i, 1);
                }
                z5 = this.qv.j(this, this.av, 1);
            }
            ae();
        } catch (Throwable unused) {
        }
        return z5;
    }

    private float j(double d6) {
        if (d6 <= 0.0d || d6 > 180.0d) {
            d6 = 50.0d;
        }
        return (float) d6;
    }

    private int m(float f6) {
        return f6 < 0.0f ? 1 : 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean r() {
        if (this.qv == null || this.f26874q) {
            return false;
        }
        int i6 = this.f26879x;
        if (i6 == 1) {
            return xt();
        }
        if (i6 == 2) {
            return cw();
        }
        return false;
    }

    private void up() {
        tj tjVar = this.qv;
        if (tjVar == null) {
            return;
        }
        tjVar.j(this);
    }

    private boolean xt() {
        tj tjVar = this.qv;
        if (tjVar == null) {
            return false;
        }
        try {
            if (this.oq == 4) {
                return cw();
            }
            if (this.ws == null) {
                this.ws = tjVar.j(1);
            }
            boolean j6 = this.qv.j(this, this.ws, 3);
            m();
            return j6;
        } catch (Throwable unused) {
            return false;
        }
    }

    private void g() {
        this.vl.j(getType());
        this.xt = System.currentTimeMillis();
    }

    private int getType() {
        return this.f26879x == 2 ? 2 : 1;
    }

    private boolean j(float f6, float f7) {
        return f7 > 0.0f && f6 > f7;
    }

    private void m() {
        this.tj = 0L;
        this.f26864f = false;
        this.f26877v = false;
        this.ol = 0;
        this.hh = 0;
        this.f26880z = 0;
        this.hl = 0;
        this.f26861b = 0;
        this.f26863e = 0;
    }

    private void oq() {
        this.vl.j(getType());
        this.xt = System.currentTimeMillis();
        this.tj = 0L;
        this.f26877v = false;
    }

    private boolean tl() {
        return this.f26878w > this.tl;
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        cw cwVar = this.xq;
        if (cwVar != null) {
            cwVar.j();
        }
        int type = sensorEvent.sensor.getType();
        float[] fArr = sensorEvent.values;
        float abs = Math.abs(fArr[0]);
        float abs2 = Math.abs(fArr[1]);
        float abs3 = Math.abs(fArr[2]);
        if (type == 1) {
            if (this.vl == null || System.currentTimeMillis() - this.xt <= 2000) {
                return;
            }
            int i6 = this.oq;
            if (i6 == 1) {
                double sqrt = Math.sqrt(Math.pow(abs, 2.0d) + Math.pow(abs2, 2.0d) + Math.pow(abs3, 2.0d));
                j(sqrt > ((double) this.tl), sqrt);
                return;
            } else if (i6 == 2) {
                xt(Math.sqrt((Math.pow((double) abs, 2.0d) + Math.pow((double) abs2, 2.0d)) + Math.pow((double) abs3, 2.0d)) > ((double) this.tl), sensorEvent);
                return;
            } else if (i6 == 3) {
                j(Math.sqrt((Math.pow((double) abs, 2.0d) + Math.pow((double) abs2, 2.0d)) + Math.pow((double) abs3, 2.0d)) > ((double) this.tl), sensorEvent);
                return;
            } else {
                double j6 = j(abs, abs2, abs3);
                j(j6 > ((double) this.tl), j6);
                return;
            }
        }
        if (type == 4) {
            int i7 = this.mi;
            if (i7 == 3) {
                xt(sensorEvent);
                return;
            } else {
                if (i7 == 2 || i7 == 4 || i7 == 7) {
                    j(sensorEvent);
                    return;
                }
                return;
            }
        }
        if (type == 10) {
            float[] fArr2 = sensorEvent.values;
            this.la = (float) (Math.pow(fArr2[0], 2.0d) + Math.pow(fArr2[1], 2.0d) + Math.pow(fArr2[2], 2.0d));
            return;
        }
        if (type != 15) {
            return;
        }
        float abs4 = Math.abs(fArr[0]);
        float abs5 = Math.abs(fArr[1]);
        float abs6 = Math.abs(fArr[2]);
        xt xtVar = this.jy;
        if (xtVar != null) {
            xtVar.j(fArr[0], fArr[1], fArr[2]);
        }
        if (abs4 == 0.0f && abs5 == 0.0f && abs6 == 0.0f) {
            return;
        }
        if (!this.f26871m) {
            this.f26871m = true;
            this.cw = abs4;
            this.f26875r = abs5;
            this.up = abs6;
            return;
        }
        float abs7 = Math.abs(abs4 - this.cw) * 180.0f;
        float abs8 = Math.abs(abs5 - this.f26875r) * 180.0f;
        float abs9 = Math.abs(abs6 - this.up) * 180.0f;
        if (!this.uf) {
            float f6 = this.f26865g;
            if ((abs7 > f6 || abs8 > f6 || abs9 > f6) && this.vl != null && System.currentTimeMillis() - this.ae > 2000) {
                this.vl.j(getType());
                this.ae = System.currentTimeMillis();
                this.f26871m = false;
                return;
            }
            return;
        }
        boolean z5 = this.ed && abs7 > this.f26862c;
        boolean z6 = this.gx && abs8 > this.f26872n;
        boolean z7 = this.nd && abs9 > this.rh;
        if ((z5 || z6 || z7) && this.vl != null && System.currentTimeMillis() - this.ae > 2000) {
            this.vl.j(getType());
            this.ae = System.currentTimeMillis();
            this.f26871m = false;
        }
    }

    public f(Context context, int i6, boolean z5) {
        this.qv = null;
        this.f26869k = z5;
        this.f26879x = i6;
        if (context != null) {
            Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
            this.ff = origApplicationContext;
            if (origApplicationContext != null) {
                vl.j("xgc_cus", "cus:" + z5);
                if (z5) {
                    this.qv = tj.j(this.ff);
                }
            }
        }
    }

    private boolean j(int i6, int i7) {
        return (i6 | i7) == 3;
    }

    public void up(int i6) {
        this.oq = i6;
    }

    private void ae(float f6) {
        if (!j(this.mi == 7, f6) || System.currentTimeMillis() - this.ae <= 2000) {
            return;
        }
        xt(false);
        this.vl.j(getType());
        this.ae = System.currentTimeMillis();
    }

    private boolean j(int i6, int i7, int i8) {
        return i7 == 3 && (i6 | i8) == 3;
    }

    private void up(float f6) {
        if (System.currentTimeMillis() - this.tj >= 500) {
            this.f26864f = false;
            oq();
        } else if (f6 >= this.f26878w) {
            this.f26864f = true;
            oq();
        }
    }

    public void j(boolean z5) {
        Context context;
        StringBuilder sb = new StringBuilder("cus:");
        sb.append(z5);
        sb.append(" m:");
        sb.append(this.f26869k);
        sb.append(" equ:");
        sb.append(this.qv != null);
        vl.j("xgcc", sb.toString());
        if (!z5) {
            tj tjVar = this.qv;
            if (tjVar != null) {
                tjVar.j(this);
                this.qv = null;
                return;
            }
            return;
        }
        if (this.f26869k || this.qv != null || (context = this.ff) == null) {
            return;
        }
        this.qv = tj.j(context);
    }

    public void r(int i6) {
        this.f26874q = true;
        xt(i6);
    }

    private void r(float f6) {
        if (!j(this.mi == 4, f6) || System.currentTimeMillis() - this.ae <= 2000) {
            return;
        }
        this.vl.j(getType());
        this.ae = System.currentTimeMillis();
    }

    public void xt(int i6) {
        up();
        v vVar = ry;
        if (vVar != null) {
            vVar.j(i6, hashCode());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00c5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void xt(android.hardware.SensorEvent r10) {
        /*
            Method dump skipped, instructions count: 233
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.utils.f.xt(android.hardware.SensorEvent):void");
    }

    public void m(int i6) {
        tj tjVar = this.qv;
        if (tjVar == null) {
            return;
        }
        if (i6 == 3 || i6 == 2 || i6 == 4 || i6 == 7) {
            if (this.av == null && tjVar != null) {
                this.av = tjVar.j(4);
            }
            if (this.av != null) {
                this.mi = i6;
                return;
            }
        }
        this.mi = 0;
    }

    public void j(j jVar) {
        this.vl = jVar;
    }

    public void j(xt xtVar) {
        this.jy = xtVar;
    }

    public static void j(v vVar) {
        ry = vVar;
    }

    public boolean j(int i6) {
        v vVar;
        if (i6 > 0 && (vVar = ry) != null && !vVar.j(i6)) {
            ry.j(i6, hashCode(), new Runnable() { // from class: com.bytedance.sdk.component.utils.f.1
                @Override // java.lang.Runnable
                public void run() {
                    f.this.r();
                }
            });
            return true;
        }
        return r();
    }

    public void cw(int i6) {
        this.f26874q = false;
        j(i6);
    }

    private void j(SensorEvent sensorEvent) {
        if (this.f26870l != 0) {
            float[] fArr = sensorEvent.values;
            float f6 = fArr[0];
            float f7 = fArr[1];
            float f8 = fArr[2];
            float f9 = (sensorEvent.timestamp - r0) * 1.0E-9f;
            float f10 = this.f26873p;
            if (f10 != 0.0f) {
                if (xt(f10, f6) && xt(this.f26873p, f7) && xt(this.f26873p, f8)) {
                    j(f6, f7, f8, f9);
                } else {
                    xt(true);
                }
            } else {
                float f11 = this.sm;
                if (f11 != 0.0f && this.la >= f11) {
                    xt(true);
                } else {
                    j(f6, f7, f8, f9);
                }
            }
            if (this.mi == 7) {
                ae(this.f26865g);
            } else {
                r(this.f26865g);
            }
            xt xtVar = this.jy;
            if (xtVar != null) {
                float[] fArr2 = this.gq;
                xtVar.j(fArr2[0], fArr2[1], fArr2[2]);
            }
        }
        this.f26870l = sensorEvent.timestamp;
    }

    public void cw(JSONObject jSONObject) {
        if (this.f26879x != 1) {
            return;
        }
        if (jSONObject == null) {
            this.qb = 0;
            this.ya = 0;
        } else {
            this.qb = jSONObject.optInt("double_direct_conf", 0);
            this.ya = jSONObject.optInt("double_direct_match", 0);
        }
    }

    public void cw(float f6) {
        this.f26878w = f6;
    }

    private boolean xt(float f6, float f7) {
        return Math.abs(f7) < f6;
    }

    private void xt(boolean z5) {
        float[] fArr = this.gq;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
    }

    private boolean j(boolean z5, float f6) {
        float abs = Math.abs((float) Math.toDegrees(this.gq[0]));
        float abs2 = Math.abs((float) Math.toDegrees(this.gq[1]));
        float abs3 = Math.abs((float) Math.toDegrees(this.gq[2]));
        if (this.uf) {
            boolean z6 = this.ed && j(abs, this.f26862c);
            boolean z7 = this.gx && j(abs2, this.f26872n);
            boolean z8 = this.nd && j(abs3, this.rh);
            if (z6 || z7 || z8) {
                return j(z5, z6, z7, z8);
            }
        } else {
            boolean j6 = j(abs, f6);
            boolean j7 = j(abs2, f6);
            boolean j8 = j(abs3, f6);
            if (j6 || j7 || j8) {
                return j(z5, j6, j7, j8);
            }
        }
        return false;
    }

    public void xt(float f6) {
        this.f26865g = f6;
    }

    public void xt(JSONObject jSONObject) {
        if (this.f26879x != 2) {
            return;
        }
        if (jSONObject == null) {
            this.ya = 0;
        } else {
            this.ya = jSONObject.optInt("double_direct_match", 0);
        }
    }

    private void xt(boolean z5, SensorEvent sensorEvent) {
        if (z5) {
            float[] fArr = sensorEvent.values;
            int j6 = j(fArr[0], this.ol);
            int j7 = j(fArr[1], this.hh);
            int j8 = j(fArr[2], this.f26880z);
            if (xt(j6, j7, j8, true)) {
                j(j6, j7, j8, true);
                g();
            } else if (this.ya == 1) {
                this.ol = j6;
                this.hh = j7;
                this.f26880z = j8;
            } else {
                this.ol = j6 | this.ol;
                this.hh |= j7;
                this.f26880z = j8 | this.f26880z;
            }
        }
    }

    private void j(float f6, float f7, float f8, float f9) {
        float[] fArr = this.gq;
        fArr[0] = fArr[0] + (f6 * f9);
        fArr[1] = fArr[1] + (f7 * f9);
        fArr[2] = fArr[2] + (f8 * f9);
    }

    public void j(float f6) {
        this.tl = f6;
    }

    public void j(cw cwVar) {
        this.xq = cwVar;
    }

    public void j(JSONObject jSONObject) {
        if (this.f26879x != 2) {
            return;
        }
        this.wq = jSONObject;
        if (jSONObject == null) {
            this.ed = false;
            this.gx = false;
            this.nd = false;
        } else {
            this.ed = jSONObject.has("x_threshold");
            this.f26862c = j(this.wq.optDouble("x_threshold", 50.0d));
            this.gx = this.wq.has("y_threshold");
            this.f26872n = j(this.wq.optDouble("y_threshold", 50.0d));
            this.nd = this.wq.has("z_threshold");
            this.rh = j(this.wq.optDouble("z_threshold", 50.0d));
        }
        this.uf = this.ed || this.gx || this.nd;
    }

    private boolean xt(int i6, int i7, int i8, boolean z5) {
        boolean j6;
        boolean j7;
        boolean j8;
        int i9 = this.qb;
        if (i9 == 1) {
            int i10 = this.f26880z;
            return z5 ? j(i8, i10) : j(i8, i10, this.f26863e);
        }
        if (i9 == 2) {
            int i11 = this.hh;
            return z5 ? j(i7, i11) : j(i7, i11, this.f26861b);
        }
        if (i9 == 4) {
            int i12 = this.ol;
            return z5 ? j(i6, i12) : j(i6, i12, this.hl);
        }
        if (i9 == 7) {
            return z5 ? j(i6, this.ol) && j(i7, this.hh) && j(i8, this.f26880z) : j(i6, this.ol, this.hl) && j(i7, this.hh, this.f26861b) && j(i8, this.f26880z, this.f26863e);
        }
        if (z5) {
            j6 = j(i6, this.ol);
            j7 = j(i7, this.hh);
            j8 = j(i8, this.f26880z);
        } else {
            j6 = j(i6, this.ol, this.hl);
            j7 = j(i7, this.hh, this.f26861b);
            j8 = j(i8, this.f26880z, this.f26863e);
        }
        return j6 || j7 || j8;
    }

    public boolean j() {
        return this.f26864f;
    }

    private float j(float f6, float f7, float f8) {
        return Math.max(Math.max(f7, f6), f8);
    }

    private void j(boolean z5, double d6) {
        if (!tl() && z5) {
            g();
            return;
        }
        if (z5) {
            this.tj = System.currentTimeMillis();
            this.f26877v = true;
            up((float) d6);
        } else {
            if (!this.f26877v || System.currentTimeMillis() - this.tj < 500) {
                return;
            }
            this.f26864f = false;
            oq();
        }
    }

    private void j(boolean z5, SensorEvent sensorEvent) {
        if (z5) {
            float[] fArr = sensorEvent.values;
            int j6 = j(fArr[0], this.ol);
            int j7 = j(fArr[1], this.hh);
            int j8 = j(fArr[2], this.f26880z);
            if (xt(j6, j7, j8, false)) {
                j(j6, j7, j8, true);
                g();
                return;
            }
            this.ol |= j6;
            if (j6 <= 0) {
                j6 = this.hl;
            }
            this.hl = j6;
            this.hh |= j7;
            if (j7 <= 0) {
                j7 = this.f26861b;
            }
            this.f26861b = j7;
            this.f26880z |= j8;
            if (j8 <= 0) {
                j8 = this.f26863e;
            }
            this.f26863e = j8;
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i6) {
    }

    private boolean j(boolean z5, boolean z6, boolean z7, boolean z8) {
        if (!z5) {
            xt(false);
            return true;
        }
        int m6 = z6 ? m(this.gq[0]) : 0;
        int m7 = z7 ? m(this.gq[1]) : 0;
        int m8 = z8 ? m(this.gq[2]) : 0;
        if (this.mi != 7) {
            xt(false);
        }
        if (!j(m6, this.ol) && !j(m7, this.hh) && !j(m8, this.f26880z)) {
            if (this.ya != 1) {
                j(m6, m7, m8, false);
            } else if (z6 || z7 || z8) {
                this.ol = m6;
                this.hh = m7;
                this.f26880z = m8;
            }
            return false;
        }
        j(m6, m7, m8, true);
        return true;
    }

    private void j(int i6, int i7, int i8, boolean z5) {
        if (z5) {
            this.ol = 0;
            this.hh = 0;
            this.f26880z = 0;
            this.hl = 0;
            this.f26861b = 0;
            this.f26863e = 0;
            return;
        }
        if (i6 == 0) {
            i6 = this.ol;
        }
        this.ol = i6;
        if (i7 == 0) {
            i7 = this.hh;
        }
        this.hh = i7;
        if (i8 == 0) {
            i8 = this.f26880z;
        }
        this.f26880z = i8;
    }

    private int j(float f6, int i6) {
        if (f6 != 0.0f) {
            return m(f6);
        }
        if (i6 == 0) {
            return 0;
        }
        return i6 == 2 ? 1 : 2;
    }
}
