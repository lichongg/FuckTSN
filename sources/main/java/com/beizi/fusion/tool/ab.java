package com.beizi.fusion.tool;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.text.TextUtils;
import android.view.View;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.widget.ShakeView;
import com.stub.StubApp;
import com.tencent.bugly.BuglyStrategy;
import com.umeng.analytics.pro.bi;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class ab {

    /* renamed from: b, reason: collision with root package name */
    private static SensorManager f13537b;
    private float A;
    private float D;
    private float E;
    private float F;
    private float G;
    private float H;
    private float I;
    private boolean J;
    private boolean K;
    private long L;

    /* renamed from: a, reason: collision with root package name */
    ShakeView f13538a;

    /* renamed from: c, reason: collision with root package name */
    private Context f13539c;

    /* renamed from: d, reason: collision with root package name */
    private double f13540d;

    /* renamed from: e, reason: collision with root package name */
    private double f13541e;

    /* renamed from: f, reason: collision with root package name */
    private double f13542f;

    /* renamed from: g, reason: collision with root package name */
    private int f13543g;

    /* renamed from: h, reason: collision with root package name */
    private int f13544h;

    /* renamed from: t, reason: collision with root package name */
    private AdSpacesBean.BuyerBean.CoolShakeViewBean f13556t;

    /* renamed from: u, reason: collision with root package name */
    private String f13557u;

    /* renamed from: w, reason: collision with root package name */
    private boolean f13559w;

    /* renamed from: y, reason: collision with root package name */
    private int f13561y;

    /* renamed from: z, reason: collision with root package name */
    private Sensor f13562z;

    /* renamed from: i, reason: collision with root package name */
    private int f13545i = 0;

    /* renamed from: j, reason: collision with root package name */
    private int f13546j = 0;

    /* renamed from: k, reason: collision with root package name */
    private float f13547k = -100.0f;

    /* renamed from: l, reason: collision with root package name */
    private float f13548l = -100.0f;

    /* renamed from: m, reason: collision with root package name */
    private float f13549m = -100.0f;

    /* renamed from: n, reason: collision with root package name */
    private int f13550n = 0;

    /* renamed from: o, reason: collision with root package name */
    private a f13551o = null;

    /* renamed from: p, reason: collision with root package name */
    private boolean f13552p = false;

    /* renamed from: q, reason: collision with root package name */
    private int f13553q = 200;

    /* renamed from: r, reason: collision with root package name */
    private View f13554r = null;

    /* renamed from: s, reason: collision with root package name */
    private long f13555s = 0;

    /* renamed from: v, reason: collision with root package name */
    private boolean f13558v = false;

    /* renamed from: x, reason: collision with root package name */
    private final SensorEventListener f13560x = new SensorEventListener() { // from class: com.beizi.fusion.tool.ab.1
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
                    ab.this.a(sensorEvent);
                } else if (type == 4) {
                    ab.this.b(sensorEvent);
                }
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i6) {
        }
    };
    private float B = 1.0E-9f;
    private float[] C = new float[3];

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void a();
    }

    public void c(double d6) {
        this.f13542f = d6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SensorEvent sensorEvent) {
        int i6;
        if (System.currentTimeMillis() - this.f13555s >= 200) {
            if (!ar.a(this.f13554r)) {
                d();
                return;
            }
            if (this.f13558v && this.f13556t != null && !TextUtils.isEmpty(this.f13557u) && ak.a().b(this.f13557u) > 0) {
                a(this.f13556t);
            }
            float[] fArr = sensorEvent.values;
            if (fArr != null && fArr.length >= 3) {
                float f6 = fArr[0];
                float f7 = fArr[1];
                float f8 = fArr[2];
                if (this.f13547k == -100.0f) {
                    this.f13547k = f6;
                }
                if (this.f13548l == -100.0f) {
                    this.f13548l = f7;
                }
                if (this.f13549m == -100.0f) {
                    this.f13549m = f8;
                }
                double abs = Math.abs(f6 - this.f13547k) / 9.8d;
                double abs2 = Math.abs(f7 - this.f13548l) / 9.8d;
                double abs3 = Math.abs(f8 - this.f13549m) / 9.8d;
                double d6 = this.f13542f;
                if (abs > d6) {
                    this.f13546j++;
                    this.f13547k = f6;
                }
                if (abs2 > d6) {
                    this.f13546j++;
                    this.f13548l = f7;
                }
                if (abs3 > d6) {
                    this.f13546j++;
                    this.f13549m = f8;
                }
                if (a(f6, f7, f8, this.f13540d)) {
                    this.f13550n = 1;
                }
                if (this.f13550n == 1 && b(f6, f7, f8, this.f13541e)) {
                    this.f13550n = 2;
                    this.f13545i++;
                }
                int i7 = this.f13543g;
                if ((i7 > 0 && this.f13545i >= i7) || ((i6 = this.f13544h) > 0 && this.f13546j >= i6)) {
                    this.K = true;
                    aa.b("ShakeUtil", "mShakeCount = " + this.f13545i + ",dstShakeCount = " + this.f13543g + ",mRotateCount = " + this.f13546j + ",dstRotateCount = " + this.f13544h);
                    if (this.K && this.J) {
                        a();
                    }
                }
                this.f13555s = System.currentTimeMillis();
            }
        }
    }

    private void e() {
        try {
            SensorManager sensorManager = f13537b;
            if (sensorManager != null) {
                Sensor defaultSensor = sensorManager.getDefaultSensor(4);
                this.f13562z = defaultSensor;
                if (defaultSensor != null) {
                    f13537b.registerListener(this.f13560x, defaultSensor, 1);
                } else {
                    this.J = true;
                }
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public void b(double d6) {
        this.f13541e = d6;
    }

    public void c() {
        aa.a("BeiZis", "enter unRegisterShakeListenerAndSetDefault");
        SensorManager sensorManager = f13537b;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this.f13560x);
        }
        d();
        ShakeView shakeView = this.f13538a;
        if (shakeView != null) {
            shakeView.stopShake();
        }
        this.f13551o = null;
        this.f13539c = null;
        this.f13538a = null;
    }

    public void d() {
        this.f13547k = -100.0f;
        this.f13548l = -100.0f;
        this.f13549m = -100.0f;
        this.f13550n = 0;
        this.f13553q = 200;
        this.f13545i = 0;
        this.f13546j = 0;
        this.f13552p = false;
        this.D = 0.0f;
        this.E = 0.0f;
        this.F = 0.0f;
        this.G = 0.0f;
        this.H = 0.0f;
        this.I = 0.0f;
        this.A = 0.0f;
        this.K = false;
        if (this.f13561y > 0) {
            this.J = false;
        }
    }

    public ab(Context context) {
        this.f13539c = context;
        f13537b = (SensorManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService(bi.ac);
    }

    public void b(int i6) {
        this.f13544h = i6;
    }

    public void b(AdSpacesBean.BuyerBean.CoolShakeViewBean coolShakeViewBean) {
        this.f13556t = coolShakeViewBean;
    }

    private boolean b(float f6, float f7, float f8, double d6) {
        return Math.sqrt((Math.pow(((double) f6) / 9.8d, 2.0d) + Math.pow(((double) f7) / 9.8d, 2.0d)) + Math.pow(((double) f8) / 9.8d, 2.0d)) < d6;
    }

    public void b() {
        SensorManager sensorManager = f13537b;
        if (sensorManager != null) {
            sensorManager.registerListener(this.f13560x, sensorManager.getDefaultSensor(1), BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(SensorEvent sensorEvent) {
        if (sensorEvent != null) {
            try {
                if (!this.f13552p && System.currentTimeMillis() - this.L >= 50) {
                    Sensor sensor = sensorEvent.sensor;
                    float[] fArr = sensorEvent.values;
                    int type = sensor.getType();
                    if (fArr != null && type == 4) {
                        this.L = System.currentTimeMillis();
                        float f6 = this.A;
                        if (f6 != 0.0f) {
                            float f7 = fArr[0];
                            float f8 = fArr[1];
                            float f9 = fArr[2];
                            float f10 = (sensorEvent.timestamp - f6) * this.B;
                            this.C[0] = (float) (r1[0] + Math.toDegrees(f7 * f10));
                            this.C[1] = (float) (r1[1] + Math.toDegrees(f8 * f10));
                            this.C[2] = (float) (r1[2] + Math.toDegrees(f9 * f10));
                            float[] fArr2 = this.C;
                            float f11 = fArr2[0];
                            if (f11 > 0.0f) {
                                if (f11 > this.G) {
                                    this.G = f11;
                                }
                            } else if (f11 < this.D) {
                                this.D = f11;
                            }
                            float f12 = fArr2[1];
                            if (f12 > 0.0f) {
                                if (f12 > this.H) {
                                    this.H = f12;
                                }
                            } else if (f12 < this.E) {
                                this.E = f12;
                            }
                            float f13 = fArr2[2];
                            if (f13 > 0.0f) {
                                if (f13 > this.I) {
                                    this.I = f13;
                                }
                            } else if (f13 < this.F) {
                                this.F = f13;
                            }
                            if ((Math.abs(this.D) > this.f13561y && Math.abs(this.G) > this.f13561y) || ((Math.abs(this.E) > this.f13561y && Math.abs(this.H) > this.f13561y) || (Math.abs(this.F) > this.f13561y && Math.abs(this.I) > this.f13561y))) {
                                aa.a("ShakeUtil", "rotate  xMin: " + String.format("%.4f", Float.valueOf(this.D)) + ",xMax: " + String.format("%.4f", Float.valueOf(this.G)) + ",yMin: " + String.format("%.4f", Float.valueOf(this.E)) + ",yMax: " + String.format("%.4f", Float.valueOf(this.H)) + ",zMin: " + String.format("%.4f", Float.valueOf(this.F)) + ",zMax: " + String.format("%.4f", Float.valueOf(this.I)));
                                this.J = true;
                            }
                            if (this.K && this.J) {
                                a();
                            }
                        }
                        this.A = sensorEvent.timestamp;
                    }
                }
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }
    }

    public void c(int i6) {
        this.f13561y = i6;
        if (i6 > 0) {
            e();
        } else {
            this.J = true;
        }
    }

    public void a(AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean) {
        if (shakeViewBean == null) {
            return;
        }
        aa.a("BeiZis", "setShakeParams shakeCount:" + shakeViewBean.getShakeCount() + ";rotatCount:" + shakeViewBean.getRotatCount());
        try {
            this.f13558v = true;
            a(shakeViewBean.getShakeCount());
            a(shakeViewBean.getShakeStartAmplitude());
            b(shakeViewBean.getShakeEndAmplitude());
            c(shakeViewBean.getRotatAmplitude());
            b(shakeViewBean.getRotatCount());
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
            this.f13558v = false;
            a(coolShakeViewBean.getShakeCount());
            a(coolShakeViewBean.getShakeStartAmplitude());
            b(coolShakeViewBean.getShakeEndAmplitude());
            c(coolShakeViewBean.getRotatAmplitude());
            b(coolShakeViewBean.getRotatCount());
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public void a(AdSpacesBean.BuyerBean.CoolShakeViewBean coolShakeViewBean, String str) {
        b(coolShakeViewBean);
        a(str);
    }

    public void a(double d6) {
        this.f13540d = d6;
    }

    public void a(int i6) {
        this.f13543g = i6;
    }

    public void a(a aVar) {
        this.f13551o = aVar;
    }

    public void a(String str) {
        this.f13557u = str;
    }

    private boolean a(float f6, float f7, float f8, double d6) {
        return Math.sqrt((Math.pow(((double) f6) / 9.8d, 2.0d) + Math.pow(((double) f7) / 9.8d, 2.0d)) + Math.pow(((double) f8) / 9.8d, 2.0d)) > d6;
    }

    protected synchronized void a() {
        StringBuilder sb = new StringBuilder();
        sb.append("enter callBackShakeHappened and mShakeStateListener != null ? ");
        sb.append(this.f13551o != null);
        sb.append(",!isCallBack = ");
        sb.append(!this.f13552p);
        aa.a("BeiZis", sb.toString());
        if (this.f13551o != null && !this.f13552p) {
            aa.a("BeiZis", "callback onShakeHappened()");
            this.f13552p = true;
            this.f13551o.a();
        }
    }

    public void a(View view) {
        this.f13554r = view;
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
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.fusion.tool.ab.a(int, int, com.beizi.fusion.model.AdSpacesBean$BuyerBean$PercentPositionBean):android.view.View");
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x00c0, code lost:
    
        if (r3 >= 400) goto L44;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00db  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.View a(int r10, int r11, com.beizi.fusion.model.AdSpacesBean.BuyerBean.PercentPositionBean r12, java.lang.String r13) {
        /*
            Method dump skipped, instructions count: 465
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.fusion.tool.ab.a(int, int, com.beizi.fusion.model.AdSpacesBean$BuyerBean$PercentPositionBean, java.lang.String):android.view.View");
    }

    public void a(Boolean bool) {
        this.f13559w = bool.booleanValue();
    }

    public void a(boolean z5) {
        this.f13552p = !z5;
    }
}
