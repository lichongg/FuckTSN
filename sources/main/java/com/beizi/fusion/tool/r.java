package com.beizi.fusion.tool;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.widget.EulerAngleView;
import com.stub.StubApp;
import com.umeng.analytics.pro.bi;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class r {

    /* renamed from: j, reason: collision with root package name */
    private static SensorManager f13735j;
    private float A;
    private float B;
    private float C;
    private float D;
    private float E;

    /* renamed from: a, reason: collision with root package name */
    private Context f13736a;

    /* renamed from: b, reason: collision with root package name */
    private AdSpacesBean.BuyerBean.EulerAngleViewBean f13737b;

    /* renamed from: c, reason: collision with root package name */
    private AdSpacesBean.BuyerBean.EulerAngleViewBean f13738c;

    /* renamed from: d, reason: collision with root package name */
    private AdSpacesBean.BuyerBean.EulerAngleViewRuleBean f13739d;

    /* renamed from: e, reason: collision with root package name */
    private AdSpacesBean.BuyerBean.EulerAngleViewRuleBean f13740e;

    /* renamed from: f, reason: collision with root package name */
    private AdSpacesBean.BuyerBean.EulerAngleViewRuleBean f13741f;

    /* renamed from: g, reason: collision with root package name */
    private AdSpacesBean.BuyerBean.EulerAngleRenderBean f13742g;

    /* renamed from: k, reason: collision with root package name */
    private Sensor f13745k;

    /* renamed from: o, reason: collision with root package name */
    private String f13749o;

    /* renamed from: p, reason: collision with root package name */
    private String f13750p;

    /* renamed from: q, reason: collision with root package name */
    private String f13751q;

    /* renamed from: t, reason: collision with root package name */
    private float f13754t;

    /* renamed from: u, reason: collision with root package name */
    private EulerAngleView f13755u;

    /* renamed from: v, reason: collision with root package name */
    private a f13756v;

    /* renamed from: x, reason: collision with root package name */
    private String f13758x;

    /* renamed from: y, reason: collision with root package name */
    private Boolean f13759y;

    /* renamed from: z, reason: collision with root package name */
    private float f13760z;

    /* renamed from: h, reason: collision with root package name */
    private float f13743h = 1.0E-9f;

    /* renamed from: i, reason: collision with root package name */
    private float[] f13744i = new float[3];

    /* renamed from: l, reason: collision with root package name */
    private double f13746l = 0.0d;

    /* renamed from: m, reason: collision with root package name */
    private double f13747m = 0.0d;

    /* renamed from: n, reason: collision with root package name */
    private double f13748n = 0.0d;

    /* renamed from: r, reason: collision with root package name */
    private boolean f13752r = false;

    /* renamed from: s, reason: collision with root package name */
    private int f13753s = 0;

    /* renamed from: w, reason: collision with root package name */
    private boolean f13757w = false;
    private SensorEventListener F = new SensorEventListener() { // from class: com.beizi.fusion.tool.r.1
        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            try {
                r.this.a(sensorEvent);
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i6) {
        }
    };

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void a();
    }

    private boolean e() {
        try {
            if (this.f13746l > 0.0d) {
                if ("2".equals(this.f13749o)) {
                    if (this.f13744i[0] > 0.0f && Math.abs(r1) >= this.f13746l) {
                        return true;
                    }
                } else if ("1".equals(this.f13749o)) {
                    if (this.f13744i[0] < 0.0f && Math.abs(r1) >= this.f13746l) {
                        return true;
                    }
                } else if ("0".equals(this.f13749o)) {
                    if (Math.abs(this.f13744i[0]) >= this.f13746l) {
                        return true;
                    }
                } else if ("3".equals(this.f13749o) && Math.abs(this.f13760z) >= this.f13746l && Math.abs(this.C) > this.f13746l) {
                    return true;
                }
            }
            if (this.f13747m > 0.0d) {
                if ("2".equals(this.f13750p)) {
                    if (this.f13744i[1] < 0.0f && Math.abs(r1) >= this.f13747m) {
                        return true;
                    }
                } else if ("1".equals(this.f13750p)) {
                    if (this.f13744i[1] > 0.0f && Math.abs(r1) >= this.f13747m) {
                        return true;
                    }
                } else if ("0".equals(this.f13750p)) {
                    if (Math.abs(this.f13744i[1]) >= this.f13747m) {
                        return true;
                    }
                } else if ("3".equals(this.f13750p) && Math.abs(this.A) >= this.f13747m && Math.abs(this.D) > this.f13747m) {
                    return true;
                }
            }
            if (this.f13748n > 0.0d) {
                if ("2".equals(this.f13751q)) {
                    if (this.f13744i[2] > 0.0f && Math.abs(r1) >= this.f13748n) {
                        return true;
                    }
                } else if ("1".equals(this.f13751q)) {
                    if (this.f13744i[2] < 0.0f && Math.abs(r1) >= this.f13748n) {
                        return true;
                    }
                } else if ("0".equals(this.f13751q)) {
                    if (Math.abs(this.f13744i[2]) >= this.f13748n) {
                        return true;
                    }
                } else if ("3".equals(this.f13751q) && Math.abs(this.B) >= this.f13748n && Math.abs(this.E) > this.f13748n) {
                    return true;
                }
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        return false;
    }

    private boolean b(long j6) {
        try {
            return System.currentTimeMillis() - ap.o(this.f13736a).longValue() < j6;
        } catch (Exception e6) {
            e6.printStackTrace();
            return false;
        }
    }

    private void c() {
        try {
            AdSpacesBean.BuyerBean.EulerAngleViewBean eulerAngleViewBean = this.f13737b;
            if (eulerAngleViewBean != null) {
                this.f13741f = eulerAngleViewBean.getCoolRule();
            }
            AdSpacesBean.BuyerBean.EulerAngleViewBean eulerAngleViewBean2 = this.f13738c;
            if (eulerAngleViewBean2 != null) {
                this.f13740e = eulerAngleViewBean2.getNomalRule();
                this.f13742g = this.f13738c.getRender();
            } else {
                AdSpacesBean.BuyerBean.EulerAngleViewBean eulerAngleViewBean3 = this.f13737b;
                if (eulerAngleViewBean3 != null) {
                    this.f13740e = eulerAngleViewBean3.getNomalRule();
                    this.f13742g = this.f13737b.getRender();
                }
            }
            AdSpacesBean.BuyerBean.EulerAngleViewRuleBean eulerAngleViewRuleBean = this.f13741f;
            if (eulerAngleViewRuleBean == null) {
                this.f13752r = true;
                this.f13739d = this.f13740e;
            } else if (a(eulerAngleViewRuleBean.getCoolTime())) {
                this.f13752r = false;
                this.f13739d = this.f13741f;
            } else if (b(this.f13741f.getUserProtectTime())) {
                this.f13752r = false;
                this.f13739d = this.f13741f;
            } else {
                this.f13752r = true;
                this.f13739d = this.f13740e;
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void d() {
        List<AdSpacesBean.BuyerBean.EulerAngleRuleBean> rules;
        try {
            AdSpacesBean.BuyerBean.EulerAngleViewRuleBean eulerAngleViewRuleBean = this.f13739d;
            if (eulerAngleViewRuleBean != null && (rules = eulerAngleViewRuleBean.getRules()) != null && rules.size() != 0) {
                int passivationTime = this.f13739d.getPassivationTime();
                final double d6 = 0.0d;
                final double d7 = 0.0d;
                final double d8 = 0.0d;
                for (AdSpacesBean.BuyerBean.EulerAngleRuleBean eulerAngleRuleBean : rules) {
                    if (eulerAngleRuleBean != null) {
                        if ("x".equalsIgnoreCase(eulerAngleRuleBean.getAxis())) {
                            if (passivationTime <= 0 || eulerAngleRuleBean.getPangle() <= 0.0d) {
                                this.f13746l = eulerAngleRuleBean.getAngle();
                            } else {
                                this.f13746l = eulerAngleRuleBean.getPangle();
                            }
                            double angle = eulerAngleRuleBean.getAngle();
                            this.f13749o = eulerAngleRuleBean.getDirection();
                            d6 = angle;
                        } else if ("y".equalsIgnoreCase(eulerAngleRuleBean.getAxis())) {
                            if (passivationTime <= 0 || eulerAngleRuleBean.getPangle() <= 0.0d) {
                                this.f13747m = eulerAngleRuleBean.getAngle();
                            } else {
                                this.f13747m = eulerAngleRuleBean.getPangle();
                            }
                            d7 = eulerAngleRuleBean.getAngle();
                            this.f13750p = eulerAngleRuleBean.getDirection();
                        } else if (bi.aG.equalsIgnoreCase(eulerAngleRuleBean.getAxis())) {
                            if (passivationTime <= 0 || eulerAngleRuleBean.getPangle() <= 0.0d) {
                                this.f13748n = eulerAngleRuleBean.getAngle();
                            } else {
                                this.f13748n = eulerAngleRuleBean.getPangle();
                            }
                            d8 = eulerAngleRuleBean.getAngle();
                            this.f13751q = eulerAngleRuleBean.getDirection();
                        }
                    }
                }
                if (passivationTime > 0) {
                    new Handler().postDelayed(new Runnable() { // from class: com.beizi.fusion.tool.r.2
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                r.this.f13752r = true;
                                r.this.f13754t = 0.0f;
                                r.this.f13744i[0] = 0.0f;
                                r.this.f13744i[1] = 0.0f;
                                r.this.f13744i[2] = 0.0f;
                                r.this.f13746l = d6;
                                r.this.f13747m = d7;
                                r.this.f13748n = d8;
                            } catch (Exception e6) {
                                e6.printStackTrace();
                            }
                        }
                    }, af.b(passivationTime));
                }
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void f() {
        try {
            if (this.f13756v == null || this.f13757w || !ar.b(this.f13755u)) {
                return;
            }
            this.f13757w = true;
            if (this.f13752r && this.f13741f != null) {
                an.a(this.f13736a, this.f13758x, (Object) Long.valueOf(System.currentTimeMillis()));
            }
            this.f13756v.a();
            b();
            aa.a("ShakeUtil", "onEulerAngleHappened");
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public r(Context context, String str, AdSpacesBean.BuyerBean.EulerAngleViewBean eulerAngleViewBean, AdSpacesBean.BuyerBean.EulerAngleViewBean eulerAngleViewBean2) {
        this.f13758x = null;
        f13735j = (SensorManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService(bi.ac);
        this.f13736a = context;
        this.f13737b = eulerAngleViewBean;
        this.f13738c = eulerAngleViewBean2;
        this.f13758x = "splash_cool_" + str;
        c();
        d();
    }

    public void b() {
        try {
            aa.a("BeiZis", "enter unRegisterListener");
            SensorManager sensorManager = f13735j;
            if (sensorManager != null) {
                sensorManager.unregisterListener(this.F);
            }
            EulerAngleView eulerAngleView = this.f13755u;
            if (eulerAngleView != null) {
                eulerAngleView.onDestroy();
            }
            this.f13755u = null;
            this.f13736a = null;
            this.f13756v = null;
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private boolean a(long j6) {
        try {
            long longValue = ((Long) an.b(this.f13736a, this.f13758x, 0L)).longValue();
            if (longValue != 0) {
                if (System.currentTimeMillis() - longValue < j6) {
                    return true;
                }
            }
            return false;
        } catch (Exception e6) {
            e6.printStackTrace();
            return false;
        }
    }

    public void a() {
        try {
            SensorManager sensorManager = f13735j;
            if (sensorManager != null) {
                Sensor defaultSensor = sensorManager.getDefaultSensor(4);
                this.f13745k = defaultSensor;
                if (defaultSensor != null) {
                    f13735j.registerListener(this.F, defaultSensor, 1);
                }
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public void a(ViewGroup viewGroup, int i6, int i7) {
        AdSpacesBean.BuyerBean.EulerAngleRenderBean eulerAngleRenderBean;
        String str;
        String str2;
        String str3;
        String str4;
        int parseInt;
        int parseInt2;
        int parseInt3;
        int parseInt4;
        try {
            if (this.f13736a != null && (eulerAngleRenderBean = this.f13742g) != null && viewGroup != null) {
                if (eulerAngleRenderBean != null) {
                    str = eulerAngleRenderBean.getCenterX();
                    str2 = this.f13742g.getCenterY();
                    str3 = this.f13742g.getWidth();
                    str4 = this.f13742g.getHeight();
                } else {
                    str = null;
                    str2 = null;
                    str3 = null;
                    str4 = null;
                }
                if (TextUtils.isEmpty(str) || "0".equals(str)) {
                    str = "85%";
                }
                if (TextUtils.isEmpty(str2) || "0".equals(str2)) {
                    str2 = "50%";
                }
                if (TextUtils.isEmpty(str3) || "0".equals(str3)) {
                    str3 = "120";
                }
                if (TextUtils.isEmpty(str4) || "0".equals(str4)) {
                    str4 = "120";
                }
                float i8 = ap.i(this.f13736a);
                int i9 = 100;
                if (str.endsWith("%")) {
                    parseInt = (Integer.parseInt(str.substring(0, str.indexOf("%"))) * i6) / 100;
                } else {
                    parseInt = Integer.parseInt(str);
                }
                if (str2.endsWith("%")) {
                    parseInt2 = (Integer.parseInt(str2.substring(0, str2.indexOf("%"))) * i7) / 100;
                } else {
                    parseInt2 = Integer.parseInt(str2);
                }
                if (str3.endsWith("%")) {
                    parseInt3 = (((int) i8) * Integer.parseInt(str3.substring(0, str3.indexOf("%")))) / 100;
                } else {
                    parseInt3 = Integer.parseInt(str3);
                }
                if (str4.endsWith("%")) {
                    parseInt4 = (Integer.parseInt(str4.substring(0, str4.indexOf("%"))) * parseInt3) / 100;
                } else {
                    parseInt4 = Integer.parseInt(str4);
                }
                if (parseInt3 == 0) {
                    parseInt3 = 100;
                }
                if (parseInt4 != 0) {
                    i9 = parseInt4;
                }
                if (parseInt2 == 0) {
                    parseInt2 = ap.a(this.f13736a, i7) / 2;
                }
                if (parseInt == 0) {
                    parseInt = ap.a(this.f13736a, i6) / 2;
                }
                int a6 = ap.a(this.f13736a, parseInt3);
                int a7 = ap.a(this.f13736a, i9);
                int a8 = ap.a(this.f13736a, parseInt);
                int a9 = ap.a(this.f13736a, parseInt2);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                EulerAngleView eulerAngleView = new EulerAngleView(this.f13736a);
                this.f13755u = eulerAngleView;
                eulerAngleView.setEulerAngleViewRuleBean(this.f13739d);
                this.f13755u.setEulerAngleRenderBean(this.f13742g);
                this.f13755u.setAnimationViewWidthAndHeight(a6, a7);
                this.f13755u.setDownloadApp(this.f13759y);
                this.f13755u.buildEulerAngleView();
                this.f13755u.measure(0, 0);
                int measuredWidth = this.f13755u.getMeasuredWidth();
                int measuredHeight = this.f13755u.getMeasuredHeight();
                aa.a("BeiZis", "centerYInt = " + a9 + ",centerXInt = " + a8 + ",adWidthDp = " + i6 + ",adHeightDp = " + i7 + ",widthInt = " + a6 + ",heightInt = " + a7 + ",viewWidth = " + measuredWidth + ",viewHeight = " + measuredHeight);
                layoutParams.topMargin = a9 - (measuredHeight / 2);
                layoutParams.leftMargin = a8 - (measuredWidth / 2);
                viewGroup.addView(this.f13755u, layoutParams);
                this.f13755u.startContinuousRotations();
            }
        } catch (NumberFormatException e6) {
            e6.printStackTrace();
        }
    }

    public void a(a aVar) {
        this.f13756v = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SensorEvent sensorEvent) {
        if (sensorEvent != null) {
            try {
                if (this.f13757w) {
                    return;
                }
                Sensor sensor = sensorEvent.sensor;
                float[] fArr = sensorEvent.values;
                int type = sensor.getType();
                if (fArr != null && type == 4) {
                    float f6 = this.f13754t;
                    if (f6 != 0.0f) {
                        float f7 = fArr[0];
                        float f8 = fArr[1];
                        float f9 = fArr[2];
                        float f10 = (sensorEvent.timestamp - f6) * this.f13743h;
                        this.f13744i[0] = (float) (r3[0] + Math.toDegrees(f7 * f10));
                        this.f13744i[1] = (float) (r3[1] + Math.toDegrees(f8 * f10));
                        this.f13744i[2] = (float) (r3[2] + Math.toDegrees(f9 * f10));
                        float[] fArr2 = this.f13744i;
                        float f11 = fArr2[0];
                        if (f11 > 0.0f) {
                            if (f11 > this.C) {
                                this.C = f11;
                            }
                        } else if (f11 < this.f13760z) {
                            this.f13760z = f11;
                        }
                        float f12 = fArr2[1];
                        if (f12 > 0.0f) {
                            if (f12 > this.D) {
                                this.D = f12;
                            }
                        } else if (f12 < this.A) {
                            this.A = f12;
                        }
                        float f13 = fArr2[2];
                        if (f13 > 0.0f) {
                            if (f13 > this.E) {
                                this.E = f13;
                            }
                        } else if (f13 < this.B) {
                            this.B = f13;
                        }
                        EulerAngleView eulerAngleView = this.f13755u;
                        if (eulerAngleView != null) {
                            eulerAngleView.setAngle(this.f13746l, this.f13747m, this.f13748n);
                            EulerAngleView eulerAngleView2 = this.f13755u;
                            float[] fArr3 = this.f13744i;
                            eulerAngleView2.setCurrentProgress(fArr3[0], fArr3[1], fArr3[2]);
                        }
                        aa.a("ShakeUtil", "rotate  x: " + String.format("%.4f", Float.valueOf(this.f13744i[0])) + ",y: " + String.format("%.4f", Float.valueOf(this.f13744i[1])) + ",z: " + String.format("%.4f", Float.valueOf(this.f13744i[2])) + ",x : " + this.f13746l + ",y : " + this.f13747m + ",z : " + this.f13748n);
                        if (e()) {
                            f();
                        }
                    }
                    this.f13754t = sensorEvent.timestamp;
                }
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }
    }

    public void a(Boolean bool) {
        this.f13759y = bool;
    }
}
