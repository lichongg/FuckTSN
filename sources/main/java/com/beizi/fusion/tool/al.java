package com.beizi.fusion.tool;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Pair;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.update.ShakeArcView;
import com.beizi.fusion.widget.ShakeView;
import com.stub.StubApp;
import com.tencent.bugly.BuglyStrategy;
import com.umeng.analytics.pro.bi;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class al {

    /* renamed from: c, reason: collision with root package name */
    private static SensorManager f13644c;
    private int A;
    private boolean B;
    private Map C;
    private boolean D;
    private double E;
    private float J;
    private int M;
    private Sensor N;
    private float O;
    private float R;
    private float S;
    private float T;
    private float U;
    private float V;
    private float W;
    private boolean X;
    private boolean Y;
    private long Z;

    /* renamed from: a, reason: collision with root package name */
    ShakeView f13645a;

    /* renamed from: d, reason: collision with root package name */
    private Context f13647d;

    /* renamed from: e, reason: collision with root package name */
    private double f13648e;

    /* renamed from: f, reason: collision with root package name */
    private double f13649f;

    /* renamed from: g, reason: collision with root package name */
    private double f13650g;

    /* renamed from: h, reason: collision with root package name */
    private int f13651h;

    /* renamed from: i, reason: collision with root package name */
    private int f13652i;

    /* renamed from: j, reason: collision with root package name */
    private int f13653j;

    /* renamed from: k, reason: collision with root package name */
    private int f13654k;

    /* renamed from: x, reason: collision with root package name */
    private boolean f13667x;

    /* renamed from: y, reason: collision with root package name */
    private double f13668y;

    /* renamed from: z, reason: collision with root package name */
    private int f13669z;

    /* renamed from: l, reason: collision with root package name */
    private int f13655l = 0;

    /* renamed from: m, reason: collision with root package name */
    private int f13656m = 0;

    /* renamed from: n, reason: collision with root package name */
    private float f13657n = -100.0f;

    /* renamed from: o, reason: collision with root package name */
    private float f13658o = -100.0f;

    /* renamed from: p, reason: collision with root package name */
    private float f13659p = -100.0f;

    /* renamed from: q, reason: collision with root package name */
    private int f13660q = 0;

    /* renamed from: r, reason: collision with root package name */
    private a f13661r = null;

    /* renamed from: s, reason: collision with root package name */
    private boolean f13662s = false;

    /* renamed from: t, reason: collision with root package name */
    private int f13663t = 200;

    /* renamed from: u, reason: collision with root package name */
    private long f13664u = 0;

    /* renamed from: v, reason: collision with root package name */
    private ShakeArcView f13665v = null;

    /* renamed from: w, reason: collision with root package name */
    private int f13666w = 0;
    private float[] F = new float[3];
    private float[] G = new float[3];
    private final SensorEventListener H = new SensorEventListener() { // from class: com.beizi.fusion.tool.al.1
        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            if (sensorEvent == null) {
                return;
            }
            try {
                Sensor sensor = sensorEvent.sensor;
                if (sensor == null) {
                    return;
                }
                int type = sensor.getType();
                if (type == 1) {
                    al.this.a(sensorEvent);
                    return;
                }
                if (type == 2) {
                    al.this.G = (float[]) sensorEvent.values.clone();
                } else if (type == 4) {
                    al.this.b(sensorEvent);
                }
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i6) {
        }
    };
    private float I = 0.0f;
    private float K = 0.0f;
    private float L = 0.0f;

    /* renamed from: b, reason: collision with root package name */
    final float f13646b = 0.85f;
    private float P = 1.0E-9f;
    private float[] Q = new float[3];

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void b();
    }

    private void f() {
        int i6;
        ShakeArcView shakeArcView = this.f13665v;
        if (shakeArcView == null || (i6 = this.f13666w) == 0) {
            return;
        }
        if (i6 != 1) {
            if (i6 == 2) {
                shakeArcView.setMaxProgress(this.f13651h);
            }
        } else {
            if (this.f13652i > 0) {
                double d6 = this.f13650g;
                if (d6 > 0.0d) {
                    shakeArcView.setMaxProgress(d6);
                    return;
                }
            }
            shakeArcView.setMaxProgress(this.f13648e);
        }
    }

    private void g() {
        if (((Boolean) f(this.f13654k).second).booleanValue()) {
            u.a(new Runnable() { // from class: com.beizi.fusion.tool.al.2
                @Override // java.lang.Runnable
                public void run() {
                    al.this.a();
                }
            }, this.f13653j + (((Integer) r0.first).intValue() * 10));
        }
    }

    private Map h() {
        HashMap hashMap = new HashMap();
        hashMap.put("actionType", 1);
        Map map = this.C;
        if (map == null) {
            Double i6 = i();
            i6.doubleValue();
            hashMap.put("maxAcc", i6);
            if (this.B) {
                hashMap.put("angle", Integer.valueOf(j()));
                return hashMap;
            }
        } else {
            double doubleValue = map.containsKey("maxAcc") ? ((Double) this.C.get("maxAcc")).doubleValue() : 0.0d;
            if (doubleValue <= 0.0d) {
                doubleValue = i().doubleValue();
            }
            hashMap.put("maxAcc", Double.valueOf(doubleValue));
            if (this.B) {
                int round = this.C.containsKey("angle") ? (int) Math.round(((Double) this.C.get("angle")).doubleValue()) : 0;
                if (round > 0) {
                    hashMap.put("angle", Integer.valueOf(round));
                    return hashMap;
                }
                hashMap.put("angle", Integer.valueOf(j()));
            }
        }
        return hashMap;
    }

    private void l() {
        float[] fArr = new float[9];
        SensorManager.getRotationMatrix(fArr, null, this.F, this.G);
        float[] fArr2 = {r2, 0.0f, 0.0f};
        SensorManager.getOrientation(fArr, fArr2);
        float degrees = (float) Math.toDegrees(fArr2[0]);
        if (degrees == 0.0f) {
            return;
        }
        float f6 = this.I;
        if (f6 == 0.0f) {
            this.I = degrees;
            return;
        }
        float f7 = degrees - f6;
        if (Math.abs(f7) > 180.0f) {
            this.I = fArr2[0];
            return;
        }
        float f8 = this.J + f7;
        this.J = f8;
        if (f8 < this.K) {
            this.K = f8;
        }
        if (f8 > this.L) {
            this.L = f8;
        }
        double abs = Math.abs(this.L - this.K);
        if (abs <= 360.0d) {
            if (abs > 180.0d) {
                this.E = 360.0d - abs;
            } else {
                this.E = abs;
            }
        }
        double d6 = this.E;
        if (d6 > 120.0d) {
            this.E = d6 - new Random().nextInt(30);
        }
        this.I = fArr2[0];
    }

    public void c(double d6) {
        this.f13650g = d6;
    }

    public void d(int i6) {
        this.f13654k = i6;
        if (i6 > 0) {
            g();
        }
    }

    public void e(int i6) {
        this.f13652i = i6;
    }

    private Double i() {
        return Double.valueOf(Double.parseDouble(String.format("%.2f", Double.valueOf((new Random().nextInt(1500) / 100.0d) + 15.0d))));
    }

    private int j() {
        int nextInt = this.A + new Random().nextInt(150 - this.A);
        return nextInt > 120 ? nextInt - new Random().nextInt(30) : nextInt;
    }

    private Map k() {
        HashMap hashMap = new HashMap();
        hashMap.put("actionType", 1);
        hashMap.put("maxAcc", Double.valueOf(Double.parseDouble(String.format("%.2f", Double.valueOf(this.f13668y)))));
        if (this.B) {
            hashMap.put("angle", Long.valueOf(Math.round(this.E)));
        }
        return hashMap;
    }

    private void m() {
        try {
            SensorManager sensorManager = f13644c;
            if (sensorManager != null) {
                Sensor defaultSensor = sensorManager.getDefaultSensor(4);
                this.N = defaultSensor;
                if (defaultSensor != null) {
                    f13644c.registerListener(this.H, defaultSensor, 1);
                } else {
                    this.X = true;
                }
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public void b(double d6) {
        this.f13649f = d6;
    }

    public void c(int i6) {
        this.f13653j = i6;
    }

    public Map e() {
        int i6 = this.f13669z;
        if (i6 == 0) {
            return null;
        }
        if (i6 == 2) {
            return h();
        }
        if (i6 == 1) {
            return this.D ? k() : h();
        }
        return null;
    }

    public al(Context context) {
        this.f13647d = context;
        f13644c = (SensorManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService(bi.ac);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SensorEvent sensorEvent) {
        float[] fArr;
        char c6;
        double d6;
        int i6;
        if (sensorEvent == null || (fArr = sensorEvent.values) == null || fArr.length < 3) {
            return;
        }
        float f6 = fArr[0];
        float f7 = fArr[1];
        float f8 = fArr[2];
        if (this.f13657n == -100.0f) {
            this.f13657n = f6;
        }
        if (this.f13658o == -100.0f) {
            this.f13658o = f7;
        }
        if (this.f13659p == -100.0f) {
            this.f13659p = f8;
        }
        double abs = Math.abs(f6 - this.f13657n) / 9.8d;
        double abs2 = Math.abs(f7 - this.f13658o) / 9.8d;
        double abs3 = Math.abs(f8 - this.f13659p) / 9.8d;
        double d7 = this.f13650g;
        if (abs > d7) {
            c6 = 0;
            this.f13656m++;
            this.f13657n = f6;
        } else {
            c6 = 0;
        }
        if (abs2 > d7) {
            this.f13656m++;
            this.f13658o = f7;
        }
        if (abs3 > d7) {
            this.f13656m++;
            this.f13659p = f8;
        }
        if (this.D && this.B) {
            float[] fArr2 = (float[]) sensorEvent.values.clone();
            this.F = fArr2;
            float f9 = fArr2[c6] * 0.85f;
            float[] fArr3 = sensorEvent.values;
            fArr2[c6] = f9 + (fArr3[c6] * 0.14999998f);
            fArr2[1] = (fArr2[1] * 0.85f) + (fArr3[1] * 0.14999998f);
            fArr2[2] = (fArr2[2] * 0.85f) + (fArr3[2] * 0.14999998f);
            l();
        }
        double a6 = a(f6, f7, f8, this.f13648e);
        if (a6 > this.f13648e) {
            if (this.D && this.f13660q == 0) {
                double a7 = a(f6, f7, f8);
                d6 = abs;
                if (this.f13668y < a7) {
                    this.f13668y = a7;
                }
            } else {
                d6 = abs;
            }
            this.f13660q = 1;
        } else {
            d6 = abs;
        }
        if (this.f13660q == 1 && b(f6, f7, f8, this.f13649f)) {
            this.f13660q = 2;
            this.f13655l++;
        }
        a(d6, abs2, abs3, a6);
        int i7 = this.f13651h;
        if ((i7 <= 0 || this.f13655l < i7) && ((i6 = this.f13652i) <= 0 || this.f13656m < i6)) {
            return;
        }
        if (this.D && this.B && this.E < this.A) {
            this.f13655l--;
            return;
        }
        aa.b("ShakeUtil", "mShakeCount = " + this.f13655l + ",dstShakeCount = " + this.f13651h + ",mRotateCount = " + this.f13656m + ",dstRotateCount = " + this.f13652i);
        this.Y = true;
        if (this.X) {
            a();
        }
    }

    public void b(int i6) {
        this.f13651h = i6;
    }

    public void c() {
        aa.a("BeiZis", "enter unRegisterShakeListenerAndSetDefault");
        SensorManager sensorManager = f13644c;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this.H);
        }
        d();
        ShakeView shakeView = this.f13645a;
        if (shakeView != null) {
            shakeView.stopShake();
        }
    }

    protected void d() {
        this.f13662s = false;
        this.f13655l = 0;
        this.f13656m = 0;
        this.f13657n = -100.0f;
        this.f13658o = -100.0f;
        this.f13659p = -100.0f;
        this.f13660q = 0;
        this.f13661r = null;
        this.f13647d = null;
        this.f13645a = null;
        this.f13663t = 200;
        this.f13665v = null;
        this.R = 0.0f;
        this.S = 0.0f;
        this.T = 0.0f;
        this.U = 0.0f;
        this.V = 0.0f;
        this.W = 0.0f;
        this.O = 0.0f;
        this.Y = false;
        if (this.M > 0) {
            this.X = false;
        }
    }

    private boolean b(float f6, float f7, float f8, double d6) {
        return Math.sqrt((Math.pow(((double) f6) / 9.8d, 2.0d) + Math.pow(((double) f7) / 9.8d, 2.0d)) + Math.pow(((double) f8) / 9.8d, 2.0d)) < d6;
    }

    public void b() {
        SensorManager sensorManager = f13644c;
        if (sensorManager != null) {
            sensorManager.registerListener(this.H, sensorManager.getDefaultSensor(1), BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH);
        }
    }

    public static Pair<Integer, Boolean> f(int i6) {
        int random = (int) ((Math.random() * 100.0d) + 1.0d);
        if (random <= i6) {
            return new Pair<>(Integer.valueOf(random), Boolean.TRUE);
        }
        return new Pair<>(Integer.valueOf(random), Boolean.FALSE);
    }

    public void g(int i6) {
        this.f13663t = i6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(SensorEvent sensorEvent) {
        if (sensorEvent != null) {
            try {
                if (!this.f13662s && System.currentTimeMillis() - this.Z >= 50) {
                    Sensor sensor = sensorEvent.sensor;
                    float[] fArr = sensorEvent.values;
                    int type = sensor.getType();
                    if (fArr != null && type == 4) {
                        this.Z = System.currentTimeMillis();
                        float f6 = this.O;
                        if (f6 != 0.0f) {
                            float f7 = fArr[0];
                            float f8 = fArr[1];
                            float f9 = fArr[2];
                            float f10 = (sensorEvent.timestamp - f6) * this.P;
                            this.Q[0] = (float) (r1[0] + Math.toDegrees(f7 * f10));
                            this.Q[1] = (float) (r1[1] + Math.toDegrees(f8 * f10));
                            this.Q[2] = (float) (r1[2] + Math.toDegrees(f9 * f10));
                            float[] fArr2 = this.Q;
                            float f11 = fArr2[0];
                            if (f11 > 0.0f) {
                                if (f11 > this.U) {
                                    this.U = f11;
                                }
                            } else if (f11 < this.R) {
                                this.R = f11;
                            }
                            float f12 = fArr2[1];
                            if (f12 > 0.0f) {
                                if (f12 > this.V) {
                                    this.V = f12;
                                }
                            } else if (f12 < this.S) {
                                this.S = f12;
                            }
                            float f13 = fArr2[2];
                            if (f13 > 0.0f) {
                                if (f13 > this.W) {
                                    this.W = f13;
                                }
                            } else if (f13 < this.T) {
                                this.T = f13;
                            }
                            if ((Math.abs(this.R) > this.M && Math.abs(this.U) > this.M) || ((Math.abs(this.S) > this.M && Math.abs(this.V) > this.M) || (Math.abs(this.T) > this.M && Math.abs(this.W) > this.M))) {
                                aa.a("ShakeUtil", "rotate  xMin: " + String.format("%.4f", Float.valueOf(this.R)) + ",xMax: " + String.format("%.4f", Float.valueOf(this.U)) + ",yMin: " + String.format("%.4f", Float.valueOf(this.S)) + ",yMax: " + String.format("%.4f", Float.valueOf(this.V)) + ",zMin: " + String.format("%.4f", Float.valueOf(this.T)) + ",zMax: " + String.format("%.4f", Float.valueOf(this.W)));
                                this.X = true;
                            }
                            if (this.Y && this.X) {
                                a();
                            }
                        }
                        this.O = sensorEvent.timestamp;
                    }
                }
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }
    }

    public void h(int i6) {
        this.M = i6;
        if (i6 > 0) {
            m();
        } else {
            this.X = true;
        }
    }

    public void a(AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean) {
        if (shakeViewBean == null) {
            return;
        }
        aa.c("ShakeUtil", "setShakeParams mShakeCount:" + shakeViewBean.getShakeCount() + ";mRotateCount:" + shakeViewBean.getRotatCount());
        try {
            this.f13657n = -100.0f;
            this.f13658o = -100.0f;
            this.f13659p = -100.0f;
            this.f13655l = 0;
            this.f13656m = 0;
            this.f13660q = 0;
            b(shakeViewBean.getShakeCount());
            a(shakeViewBean.getShakeStartAmplitude());
            b(shakeViewBean.getShakeEndAmplitude());
            c(shakeViewBean.getRotatAmplitude());
            e(shakeViewBean.getRotatCount());
            c(shakeViewBean.getRandomClickTime());
            d(shakeViewBean.getRandomClickNum());
            g(shakeViewBean.getAnimationInterval());
            f();
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public void a(AdSpacesBean.BuyerBean.CoolShakeViewBean coolShakeViewBean) {
        if (coolShakeViewBean == null) {
            return;
        }
        aa.c("ShakeUtil", "setShakeCoolParams mShakeCount:" + coolShakeViewBean.getShakeCount() + ";mRotateCount:" + coolShakeViewBean.getRotatCount());
        try {
            b(coolShakeViewBean.getShakeCount());
            a(coolShakeViewBean.getShakeStartAmplitude());
            b(coolShakeViewBean.getShakeEndAmplitude());
            c(coolShakeViewBean.getRotatAmplitude());
            e(coolShakeViewBean.getRotatCount());
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public void a(AdSpacesBean.BuyerBean.AliaseShakeViewBean aliaseShakeViewBean) {
        if (aliaseShakeViewBean == null) {
            return;
        }
        aa.c("ShakeUtil", "setShakeAliaseParams mShakeCount:" + aliaseShakeViewBean.getShakeCount() + ";mRotateCount:" + aliaseShakeViewBean.getRotatCount());
        try {
            b(aliaseShakeViewBean.getShakeCount());
            a(aliaseShakeViewBean.getShakeStartAmplitude());
            b(aliaseShakeViewBean.getShakeEndAmplitude());
            c(aliaseShakeViewBean.getRotatAmplitude());
            e(aliaseShakeViewBean.getRotatCount());
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public void a(ShakeArcView shakeArcView, int i6) {
        aa.c("ShakeUtil", "setShakeFeedback feedback:" + i6);
        a(shakeArcView);
        a(i6);
        f();
    }

    private void a(double d6, double d7, double d8, double d9) {
        ShakeArcView shakeArcView = this.f13665v;
        if (shakeArcView == null) {
            return;
        }
        if (this.f13666w == 2) {
            shakeArcView.setCurrentProgress(this.f13655l);
            return;
        }
        if (this.f13652i > 0 && this.f13650g > 0.0d) {
            if (d6 < d7 || d6 < d8) {
                d6 = (d7 < d6 || d7 < d8) ? (d8 < d6 || d8 < d7) ? 0.0d : d8 : d7;
            }
            double doubleValue = new BigDecimal(d6).setScale(2, 4).doubleValue();
            if (doubleValue >= 0.1d) {
                this.f13665v.setCurrentProgress(doubleValue);
                return;
            } else {
                if (doubleValue < 0.1d) {
                    this.f13665v.setCurrentProgress(0.0d);
                    return;
                }
                return;
            }
        }
        int i6 = this.f13651h;
        if (i6 > 0 && this.f13655l >= i6) {
            shakeArcView.setCurrentProgress(this.f13648e);
            return;
        }
        double doubleValue2 = new BigDecimal(d9).setScale(2, 4).doubleValue();
        if (doubleValue2 >= 1.1d) {
            this.f13665v.setCurrentProgress(doubleValue2);
        } else if (doubleValue2 < 1.1d) {
            this.f13665v.setCurrentProgress(0.0d);
        }
    }

    public void a(int i6) {
        this.f13666w = i6;
    }

    public void a(double d6) {
        this.f13648e = d6;
    }

    public void a(a aVar) {
        this.f13661r = aVar;
    }

    public void a(ShakeArcView shakeArcView) {
        this.f13665v = shakeArcView;
    }

    private double a(float f6, float f7, float f8, double d6) {
        return Math.sqrt(Math.pow(f6 / 9.8d, 2.0d) + Math.pow(f7 / 9.8d, 2.0d) + Math.pow(f8 / 9.8d, 2.0d));
    }

    protected synchronized void a() {
        StringBuilder sb = new StringBuilder();
        sb.append("enter callBackShakeHappened and mShakeStateListener != null ? ");
        sb.append(this.f13661r != null);
        sb.append(",!isCallBack = ");
        sb.append(!this.f13662s);
        aa.a("BeiZis", sb.toString());
        if (this.f13661r != null && !this.f13662s) {
            aa.a("BeiZis", "callback onShakeHappened()");
            ShakeArcView shakeArcView = this.f13665v;
            if (shakeArcView != null && !ar.b(shakeArcView)) {
                aa.b("ShakeUtil", "mShakeCount onShakeHappened mShakeArcView is not show");
                this.f13657n = -100.0f;
                this.f13658o = -100.0f;
                this.f13659p = -100.0f;
                this.f13655l = 0;
                this.f13656m = 0;
                this.f13660q = 0;
                return;
            }
            this.f13662s = true;
            this.f13661r.b();
            ShakeView shakeView = this.f13645a;
            if (shakeView != null) {
                shakeView.stopShake();
                c();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x00cb, code lost:
    
        if (r3 >= 400) goto L44;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00e6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.View a(int r10, int r11, com.beizi.fusion.model.AdSpacesBean.BuyerBean.PercentPositionBean r12) {
        /*
            Method dump skipped, instructions count: 453
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.fusion.tool.al.a(int, int, com.beizi.fusion.model.AdSpacesBean$BuyerBean$PercentPositionBean):android.view.View");
    }

    public void a(int i6, int i7, boolean z5, Map map) {
        Sensor defaultSensor;
        try {
            this.f13669z = i6;
            this.A = i7;
            this.B = z5;
            this.C = map;
            if (i7 <= 0) {
                this.A = 35;
            }
            if (i6 == 1) {
                if (map == null) {
                    this.D = true;
                    return;
                } else if (!map.containsKey("forceUnreal")) {
                    this.D = true;
                    return;
                } else {
                    Object obj = map.get("forceUnreal");
                    if (!(obj instanceof Boolean ? ((Boolean) obj).booleanValue() : false)) {
                        this.D = true;
                    }
                }
            }
            if (this.D && z5 && (defaultSensor = f13644c.getDefaultSensor(2)) != null) {
                f13644c.registerListener(this.H, defaultSensor, 1);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private double a(float f6, float f7, float f8) {
        return Math.sqrt(Math.pow(f6, 2.0d) + Math.pow(f7, 2.0d) + Math.pow(f8, 2.0d));
    }

    public void a(Boolean bool) {
        this.f13667x = bool.booleanValue();
    }
}
