package com.beizi.ad.a.a;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.beizi.ad.internal.h.i;
import com.beizi.ad.internal.h.m;
import com.beizi.ad.lance.a.q;
import com.beizi.fusion.R;
import com.beizi.fusion.model.AdSpacesBean;
import com.stub.StubApp;
import com.umeng.analytics.pro.bi;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class e {
    private long A;
    private String D;
    private AnimatorSet G;
    private String H;
    private boolean I;
    private int K;
    private Sensor L;
    private float M;
    private float P;
    private float Q;
    private float R;
    private float S;
    private float T;
    private float U;
    private boolean V;
    private boolean W;
    private long X;
    private boolean Y;

    /* renamed from: a, reason: collision with root package name */
    private Context f11369a;

    /* renamed from: b, reason: collision with root package name */
    private AdSpacesBean.BuyerBean.ShakeViewBean f11370b;

    /* renamed from: c, reason: collision with root package name */
    private AdSpacesBean.BuyerBean.ShakeViewBean f11371c;

    /* renamed from: d, reason: collision with root package name */
    private AdSpacesBean.BuyerBean.AliaseShakeViewBean f11372d;

    /* renamed from: e, reason: collision with root package name */
    private AdSpacesBean.BuyerBean.CoolShakeViewBean f11373e;

    /* renamed from: f, reason: collision with root package name */
    private AdSpacesBean.BuyerBean.PercentPositionBean f11374f;

    /* renamed from: l, reason: collision with root package name */
    private SensorManager f11380l;

    /* renamed from: m, reason: collision with root package name */
    private Sensor f11381m;

    /* renamed from: s, reason: collision with root package name */
    private double f11387s;

    /* renamed from: t, reason: collision with root package name */
    private double f11388t;

    /* renamed from: u, reason: collision with root package name */
    private double f11389u;

    /* renamed from: v, reason: collision with root package name */
    private int f11390v;

    /* renamed from: w, reason: collision with root package name */
    private int f11391w;

    /* renamed from: g, reason: collision with root package name */
    private double f11375g = 9.8d;

    /* renamed from: h, reason: collision with root package name */
    private int f11376h = -100;

    /* renamed from: i, reason: collision with root package name */
    private int f11377i = 0;

    /* renamed from: j, reason: collision with root package name */
    private int f11378j = 1;

    /* renamed from: k, reason: collision with root package name */
    private int f11379k = 2;

    /* renamed from: n, reason: collision with root package name */
    private a f11382n = null;

    /* renamed from: o, reason: collision with root package name */
    private float f11383o = -100;

    /* renamed from: p, reason: collision with root package name */
    private float f11384p = -100;

    /* renamed from: q, reason: collision with root package name */
    private float f11385q = -100;

    /* renamed from: r, reason: collision with root package name */
    private int f11386r = 0;

    /* renamed from: x, reason: collision with root package name */
    private int f11392x = 0;

    /* renamed from: y, reason: collision with root package name */
    private int f11393y = 0;

    /* renamed from: z, reason: collision with root package name */
    private boolean f11394z = true;
    private boolean B = false;
    private boolean C = false;
    private int E = 80;
    private float F = 30.0f;
    private final SensorEventListener J = new SensorEventListener() { // from class: com.beizi.ad.a.a.e.4
        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            Sensor sensor;
            if (sensorEvent == null || (sensor = sensorEvent.sensor) == null) {
                return;
            }
            int type = sensor.getType();
            if (type == 1) {
                e.this.a(sensorEvent);
            } else if (type == 4) {
                e.this.b(sensorEvent);
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i6) {
        }
    };
    private float N = 1.0E-9f;
    private float[] O = new float[3];

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void a();
    }

    private boolean g() {
        AdSpacesBean.BuyerBean.CoolShakeViewBean coolShakeViewBean;
        try {
            coolShakeViewBean = this.f11373e;
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        if (coolShakeViewBean == null) {
            return false;
        }
        if (coolShakeViewBean.getShakeCount() <= 0) {
            return this.f11373e.getRotatCount() > 0;
        }
        return true;
    }

    private boolean h() {
        try {
            AdSpacesBean.BuyerBean.AliaseShakeViewBean aliaseShakeViewBean = this.f11372d;
            if (aliaseShakeViewBean != null && aliaseShakeViewBean != null && aliaseShakeViewBean.getPassivationTime() > 0) {
                if (this.f11372d.getShakeCount() > 0) {
                    return true;
                }
                if (this.f11372d.getRotatCount() > 0) {
                    return true;
                }
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        return false;
    }

    private boolean m() {
        try {
            AdSpacesBean.BuyerBean.CoolShakeViewBean coolShakeViewBean = this.f11373e;
            if (coolShakeViewBean == null) {
                return false;
            }
            long coolTime = coolShakeViewBean.getCoolTime();
            long longValue = ((Long) m.d(this.f11369a, this.D, 0L)).longValue();
            if (longValue != 0) {
                if (System.currentTimeMillis() - longValue < coolTime) {
                    return true;
                }
            }
            return false;
        } catch (Exception e6) {
            e6.printStackTrace();
            return false;
        }
    }

    private boolean n() {
        try {
            AdSpacesBean.BuyerBean.CoolShakeViewBean coolShakeViewBean = this.f11373e;
            if (coolShakeViewBean == null) {
                return false;
            }
            return System.currentTimeMillis() - q.a(this.f11369a) < coolShakeViewBean.getUserProtectTime();
        } catch (Exception e6) {
            e6.printStackTrace();
            return false;
        }
    }

    private void q() {
        this.f11392x = 0;
        this.f11393y = 0;
        int i6 = this.f11376h;
        this.f11383o = i6;
        this.f11384p = i6;
        this.f11385q = i6;
        this.f11386r = this.f11377i;
        this.P = 0.0f;
        this.Q = 0.0f;
        this.R = 0.0f;
        this.S = 0.0f;
        this.T = 0.0f;
        this.U = 0.0f;
        this.M = 0.0f;
        this.W = false;
        if (this.K > 0) {
            this.V = false;
        }
        this.Y = false;
    }

    private synchronized void r() {
        try {
        } catch (Exception e6) {
            e6.printStackTrace();
        } finally {
        }
        if (this.f11382n != null && this.f11394z) {
            if (this.Y) {
                return;
            }
            this.Y = true;
            com.beizi.ad.lance.a.m.a("ShakeUtil", "callBackResult");
            b();
            if (!this.B) {
                m.c(this.f11369a, this.D, Long.valueOf(System.currentTimeMillis()));
            }
            this.f11382n.a();
        }
    }

    public String c() {
        return this.H;
    }

    private boolean f() {
        double d6;
        double d7;
        int i6;
        AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean = this.f11371c;
        if (shakeViewBean != null) {
            d6 = shakeViewBean.getShakeStartAmplitude();
            d7 = this.f11371c.getShakeEndAmplitude();
            i6 = this.f11371c.getShakeCount();
        } else {
            AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean2 = this.f11370b;
            if (shakeViewBean2 != null) {
                d6 = shakeViewBean2.getShakeStartAmplitude();
                d7 = this.f11370b.getShakeEndAmplitude();
                i6 = this.f11370b.getShakeCount();
            } else {
                d6 = 0.0d;
                d7 = 0.0d;
                i6 = 0;
            }
        }
        return d6 > 0.0d && d7 > 0.0d && i6 > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        try {
            com.beizi.ad.lance.a.m.a("ShakeUtil", "setShakeSensitivityNormal");
            q();
            AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean = this.f11371c;
            if (shakeViewBean != null) {
                b(shakeViewBean.getShakeCount());
                a(this.f11371c.getShakeStartAmplitude());
                b(this.f11371c.getShakeEndAmplitude());
                c(this.f11371c.getRotatAmplitude());
                c(this.f11371c.getRotatCount());
                return;
            }
            AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean2 = this.f11370b;
            if (shakeViewBean2 != null) {
                b(shakeViewBean2.getShakeCount());
                a(this.f11370b.getShakeStartAmplitude());
                b(this.f11370b.getShakeEndAmplitude());
                c(this.f11370b.getRotatAmplitude());
                c(this.f11370b.getRotatCount());
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void k() {
        try {
            if (this.f11372d == null) {
                return;
            }
            com.beizi.ad.lance.a.m.a("ShakeUtil", "setShakeSensitivityAliase");
            b(this.f11372d.getShakeCount());
            a(this.f11372d.getShakeStartAmplitude());
            b(this.f11372d.getShakeEndAmplitude());
            c(this.f11372d.getRotatAmplitude());
            c(this.f11372d.getRotatCount());
            new Handler().postDelayed(new Runnable() { // from class: com.beizi.ad.a.a.e.1
                @Override // java.lang.Runnable
                public void run() {
                    e.this.j();
                }
            }, a(this.f11372d.getPassivationTime()));
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void l() {
        try {
            if (this.f11373e == null) {
                return;
            }
            com.beizi.ad.lance.a.m.a("ShakeUtil", "setShakeSensitivityCool");
            b(this.f11373e.getShakeCount());
            a(this.f11373e.getShakeStartAmplitude());
            b(this.f11373e.getShakeEndAmplitude());
            c(this.f11373e.getRotatAmplitude());
            c(this.f11373e.getRotatCount());
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void o() {
        try {
            com.beizi.ad.lance.a.m.a("ShakeUtil", "registerShakeListener");
            this.C = true;
            q();
            if (this.f11380l == null) {
                this.f11380l = (SensorManager) StubApp.getOrigApplicationContext(this.f11369a.getApplicationContext()).getSystemService(bi.ac);
            }
            if (this.f11381m == null) {
                this.f11381m = this.f11380l.getDefaultSensor(1);
            }
            this.f11380l.registerListener(this.J, this.f11381m, 2);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void p() {
        try {
            com.beizi.ad.lance.a.m.a("ShakeUtil", "unRegisterShakeListener");
            this.C = false;
            SensorManager sensorManager = this.f11380l;
            if (sensorManager != null) {
                sensorManager.unregisterListener(this.J);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void s() {
        try {
            SensorManager sensorManager = this.f11380l;
            if (sensorManager != null) {
                Sensor defaultSensor = sensorManager.getDefaultSensor(4);
                this.L = defaultSensor;
                if (defaultSensor != null) {
                    this.f11380l.registerListener(this.J, defaultSensor, 1);
                } else {
                    this.V = true;
                }
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public void c(double d6) {
        this.f11389u = d6;
    }

    public void e() {
        if (this.K > 0) {
            s();
        } else {
            this.V = true;
        }
    }

    public e(Context context, AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean, String str, String str2) {
        this.D = null;
        this.I = false;
        try {
            this.f11369a = context;
            this.f11370b = shakeViewBean;
            this.D = "beizi_cool_" + str;
            AdSpacesBean.BuyerBean.OrderDataShakeViewBean a6 = a(shakeViewBean.getOrderData(), str2);
            if (a6 != null && a6.getShakeView() != null) {
                this.f11371c = a6.getShakeView();
            }
            AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean2 = this.f11370b;
            if (shakeViewBean2 != null) {
                this.f11373e = shakeViewBean2.getCoolShakeView();
                this.K = shakeViewBean.getRegulatoryAngle();
            }
            AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean3 = this.f11371c;
            if (shakeViewBean3 != null) {
                this.f11372d = shakeViewBean3.getAliaseShakeView();
                this.f11374f = this.f11371c.getPosition();
                List<String> imageURL = this.f11371c.getImageURL();
                if (imageURL != null && imageURL.size() > 0) {
                    this.H = imageURL.get(0);
                }
                this.K = this.f11371c.getRegulatoryAngle();
            } else {
                AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean4 = this.f11370b;
                if (shakeViewBean4 != null) {
                    this.f11372d = shakeViewBean4.getAliaseShakeView();
                    this.f11374f = this.f11370b.getPosition();
                    List<String> imageURL2 = this.f11370b.getImageURL();
                    if (imageURL2 != null && imageURL2.size() > 0) {
                        this.H = imageURL2.get(0);
                    }
                }
            }
            if (!f()) {
                this.I = false;
                return;
            }
            this.I = true;
            i();
            o();
            e();
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026 A[Catch: Exception -> 0x0014, TryCatch #0 {Exception -> 0x0014, blocks: (B:2:0x0000, B:4:0x000a, B:7:0x0011, B:8:0x0022, B:10:0x0026, B:13:0x002a, B:15:0x0030, B:17:0x0034, B:19:0x0016, B:21:0x001c, B:22:0x0020), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x002a A[Catch: Exception -> 0x0014, TryCatch #0 {Exception -> 0x0014, blocks: (B:2:0x0000, B:4:0x000a, B:7:0x0011, B:8:0x0022, B:10:0x0026, B:13:0x002a, B:15:0x0030, B:17:0x0034, B:19:0x0016, B:21:0x001c, B:22:0x0020), top: B:1:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void i() {
        /*
            r2 = this;
            r2.q()     // Catch: java.lang.Exception -> L14
            boolean r0 = r2.n()     // Catch: java.lang.Exception -> L14
            r1 = 0
            if (r0 != 0) goto L16
            boolean r0 = r2.m()     // Catch: java.lang.Exception -> L14
            if (r0 == 0) goto L11
            goto L16
        L11:
            r2.B = r1     // Catch: java.lang.Exception -> L14
            goto L22
        L14:
            r0 = move-exception
            goto L38
        L16:
            boolean r0 = r2.g()     // Catch: java.lang.Exception -> L14
            if (r0 == 0) goto L20
            r0 = 1
            r2.B = r0     // Catch: java.lang.Exception -> L14
            goto L22
        L20:
            r2.B = r1     // Catch: java.lang.Exception -> L14
        L22:
            boolean r0 = r2.B     // Catch: java.lang.Exception -> L14
            if (r0 == 0) goto L2a
            r2.l()     // Catch: java.lang.Exception -> L14
            return
        L2a:
            boolean r0 = r2.h()     // Catch: java.lang.Exception -> L14
            if (r0 == 0) goto L34
            r2.k()     // Catch: java.lang.Exception -> L14
            return
        L34:
            r2.j()     // Catch: java.lang.Exception -> L14
            return
        L38:
            r0.printStackTrace()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.ad.a.a.e.i():void");
    }

    public void a() {
        try {
            if (!this.C && this.I) {
                this.f11394z = true;
                i();
                o();
                e();
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public void b() {
        try {
            this.f11394z = false;
            p();
            q();
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public void c(int i6) {
        this.f11391w = i6;
    }

    public void d() {
        try {
            p();
            this.f11370b = null;
            this.f11371c = null;
            this.f11373e = null;
            this.f11372d = null;
            this.f11374f = null;
            this.f11369a = null;
            this.f11380l = null;
            this.f11381m = null;
            this.f11382n = null;
            AnimatorSet animatorSet = this.G;
            if (animatorSet != null) {
                animatorSet.removeAllListeners();
            }
            this.G = null;
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0073 A[Catch: Exception -> 0x0045, TryCatch #0 {Exception -> 0x0045, blocks: (B:8:0x0010, B:10:0x001c, B:13:0x003e, B:16:0x0049, B:18:0x004f, B:20:0x0056, B:22:0x0073, B:23:0x0079, B:26:0x00b7, B:28:0x00be, B:30:0x00c4, B:32:0x00cb, B:34:0x00d1, B:35:0x00ee, B:37:0x00f4, B:38:0x0111, B:40:0x0119, B:41:0x0137, B:43:0x013d, B:44:0x0158, B:46:0x017a, B:48:0x017e, B:49:0x0180, B:51:0x014e, B:53:0x0154, B:54:0x012a, B:56:0x0130, B:58:0x0105, B:60:0x010b, B:62:0x00e2, B:64:0x00e8, B:4:0x01c1), top: B:7:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00d1 A[Catch: Exception -> 0x0045, TryCatch #0 {Exception -> 0x0045, blocks: (B:8:0x0010, B:10:0x001c, B:13:0x003e, B:16:0x0049, B:18:0x004f, B:20:0x0056, B:22:0x0073, B:23:0x0079, B:26:0x00b7, B:28:0x00be, B:30:0x00c4, B:32:0x00cb, B:34:0x00d1, B:35:0x00ee, B:37:0x00f4, B:38:0x0111, B:40:0x0119, B:41:0x0137, B:43:0x013d, B:44:0x0158, B:46:0x017a, B:48:0x017e, B:49:0x0180, B:51:0x014e, B:53:0x0154, B:54:0x012a, B:56:0x0130, B:58:0x0105, B:60:0x010b, B:62:0x00e2, B:64:0x00e8, B:4:0x01c1), top: B:7:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00f4 A[Catch: Exception -> 0x0045, TryCatch #0 {Exception -> 0x0045, blocks: (B:8:0x0010, B:10:0x001c, B:13:0x003e, B:16:0x0049, B:18:0x004f, B:20:0x0056, B:22:0x0073, B:23:0x0079, B:26:0x00b7, B:28:0x00be, B:30:0x00c4, B:32:0x00cb, B:34:0x00d1, B:35:0x00ee, B:37:0x00f4, B:38:0x0111, B:40:0x0119, B:41:0x0137, B:43:0x013d, B:44:0x0158, B:46:0x017a, B:48:0x017e, B:49:0x0180, B:51:0x014e, B:53:0x0154, B:54:0x012a, B:56:0x0130, B:58:0x0105, B:60:0x010b, B:62:0x00e2, B:64:0x00e8, B:4:0x01c1), top: B:7:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0119 A[Catch: Exception -> 0x0045, TryCatch #0 {Exception -> 0x0045, blocks: (B:8:0x0010, B:10:0x001c, B:13:0x003e, B:16:0x0049, B:18:0x004f, B:20:0x0056, B:22:0x0073, B:23:0x0079, B:26:0x00b7, B:28:0x00be, B:30:0x00c4, B:32:0x00cb, B:34:0x00d1, B:35:0x00ee, B:37:0x00f4, B:38:0x0111, B:40:0x0119, B:41:0x0137, B:43:0x013d, B:44:0x0158, B:46:0x017a, B:48:0x017e, B:49:0x0180, B:51:0x014e, B:53:0x0154, B:54:0x012a, B:56:0x0130, B:58:0x0105, B:60:0x010b, B:62:0x00e2, B:64:0x00e8, B:4:0x01c1), top: B:7:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x013d A[Catch: Exception -> 0x0045, TryCatch #0 {Exception -> 0x0045, blocks: (B:8:0x0010, B:10:0x001c, B:13:0x003e, B:16:0x0049, B:18:0x004f, B:20:0x0056, B:22:0x0073, B:23:0x0079, B:26:0x00b7, B:28:0x00be, B:30:0x00c4, B:32:0x00cb, B:34:0x00d1, B:35:0x00ee, B:37:0x00f4, B:38:0x0111, B:40:0x0119, B:41:0x0137, B:43:0x013d, B:44:0x0158, B:46:0x017a, B:48:0x017e, B:49:0x0180, B:51:0x014e, B:53:0x0154, B:54:0x012a, B:56:0x0130, B:58:0x0105, B:60:0x010b, B:62:0x00e2, B:64:0x00e8, B:4:0x01c1), top: B:7:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x017a A[Catch: Exception -> 0x0045, TryCatch #0 {Exception -> 0x0045, blocks: (B:8:0x0010, B:10:0x001c, B:13:0x003e, B:16:0x0049, B:18:0x004f, B:20:0x0056, B:22:0x0073, B:23:0x0079, B:26:0x00b7, B:28:0x00be, B:30:0x00c4, B:32:0x00cb, B:34:0x00d1, B:35:0x00ee, B:37:0x00f4, B:38:0x0111, B:40:0x0119, B:41:0x0137, B:43:0x013d, B:44:0x0158, B:46:0x017a, B:48:0x017e, B:49:0x0180, B:51:0x014e, B:53:0x0154, B:54:0x012a, B:56:0x0130, B:58:0x0105, B:60:0x010b, B:62:0x00e2, B:64:0x00e8, B:4:0x01c1), top: B:7:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x017e A[Catch: Exception -> 0x0045, TryCatch #0 {Exception -> 0x0045, blocks: (B:8:0x0010, B:10:0x001c, B:13:0x003e, B:16:0x0049, B:18:0x004f, B:20:0x0056, B:22:0x0073, B:23:0x0079, B:26:0x00b7, B:28:0x00be, B:30:0x00c4, B:32:0x00cb, B:34:0x00d1, B:35:0x00ee, B:37:0x00f4, B:38:0x0111, B:40:0x0119, B:41:0x0137, B:43:0x013d, B:44:0x0158, B:46:0x017a, B:48:0x017e, B:49:0x0180, B:51:0x014e, B:53:0x0154, B:54:0x012a, B:56:0x0130, B:58:0x0105, B:60:0x010b, B:62:0x00e2, B:64:0x00e8, B:4:0x01c1), top: B:7:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x014e A[Catch: Exception -> 0x0045, TryCatch #0 {Exception -> 0x0045, blocks: (B:8:0x0010, B:10:0x001c, B:13:0x003e, B:16:0x0049, B:18:0x004f, B:20:0x0056, B:22:0x0073, B:23:0x0079, B:26:0x00b7, B:28:0x00be, B:30:0x00c4, B:32:0x00cb, B:34:0x00d1, B:35:0x00ee, B:37:0x00f4, B:38:0x0111, B:40:0x0119, B:41:0x0137, B:43:0x013d, B:44:0x0158, B:46:0x017a, B:48:0x017e, B:49:0x0180, B:51:0x014e, B:53:0x0154, B:54:0x012a, B:56:0x0130, B:58:0x0105, B:60:0x010b, B:62:0x00e2, B:64:0x00e8, B:4:0x01c1), top: B:7:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x012a A[Catch: Exception -> 0x0045, TryCatch #0 {Exception -> 0x0045, blocks: (B:8:0x0010, B:10:0x001c, B:13:0x003e, B:16:0x0049, B:18:0x004f, B:20:0x0056, B:22:0x0073, B:23:0x0079, B:26:0x00b7, B:28:0x00be, B:30:0x00c4, B:32:0x00cb, B:34:0x00d1, B:35:0x00ee, B:37:0x00f4, B:38:0x0111, B:40:0x0119, B:41:0x0137, B:43:0x013d, B:44:0x0158, B:46:0x017a, B:48:0x017e, B:49:0x0180, B:51:0x014e, B:53:0x0154, B:54:0x012a, B:56:0x0130, B:58:0x0105, B:60:0x010b, B:62:0x00e2, B:64:0x00e8, B:4:0x01c1), top: B:7:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0105 A[Catch: Exception -> 0x0045, TryCatch #0 {Exception -> 0x0045, blocks: (B:8:0x0010, B:10:0x001c, B:13:0x003e, B:16:0x0049, B:18:0x004f, B:20:0x0056, B:22:0x0073, B:23:0x0079, B:26:0x00b7, B:28:0x00be, B:30:0x00c4, B:32:0x00cb, B:34:0x00d1, B:35:0x00ee, B:37:0x00f4, B:38:0x0111, B:40:0x0119, B:41:0x0137, B:43:0x013d, B:44:0x0158, B:46:0x017a, B:48:0x017e, B:49:0x0180, B:51:0x014e, B:53:0x0154, B:54:0x012a, B:56:0x0130, B:58:0x0105, B:60:0x010b, B:62:0x00e2, B:64:0x00e8, B:4:0x01c1), top: B:7:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00e2 A[Catch: Exception -> 0x0045, TryCatch #0 {Exception -> 0x0045, blocks: (B:8:0x0010, B:10:0x001c, B:13:0x003e, B:16:0x0049, B:18:0x004f, B:20:0x0056, B:22:0x0073, B:23:0x0079, B:26:0x00b7, B:28:0x00be, B:30:0x00c4, B:32:0x00cb, B:34:0x00d1, B:35:0x00ee, B:37:0x00f4, B:38:0x0111, B:40:0x0119, B:41:0x0137, B:43:0x013d, B:44:0x0158, B:46:0x017a, B:48:0x017e, B:49:0x0180, B:51:0x014e, B:53:0x0154, B:54:0x012a, B:56:0x0130, B:58:0x0105, B:60:0x010b, B:62:0x00e2, B:64:0x00e8, B:4:0x01c1), top: B:7:0x0010 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int[] b(android.view.ViewGroup r20) {
        /*
            Method dump skipped, instructions count: 478
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.ad.a.a.e.b(android.view.ViewGroup):int[]");
    }

    private AdSpacesBean.BuyerBean.OrderDataShakeViewBean a(List<AdSpacesBean.BuyerBean.OrderDataShakeViewBean> list, String str) {
        if (list != null && str != null) {
            for (AdSpacesBean.BuyerBean.OrderDataShakeViewBean orderDataShakeViewBean : list) {
                List<String> orderList = orderDataShakeViewBean.getOrderList();
                if (orderList != null && orderList.contains(str)) {
                    return orderDataShakeViewBean;
                }
            }
        }
        return null;
    }

    public void a(ViewGroup viewGroup) {
        if (viewGroup != null) {
            try {
                if (this.f11369a != null && this.I) {
                    final ImageView imageView = new ImageView(this.f11369a);
                    imageView.setVisibility(0);
                    imageView.setImageResource(R.mipmap.beizi_interaction_icon_shake);
                    if (!TextUtils.isEmpty(this.H)) {
                        i.a(this.f11369a).b(this.H, new i.a() { // from class: com.beizi.ad.a.a.e.2
                            @Override // com.beizi.ad.internal.h.i.a
                            public void a() {
                            }

                            @Override // com.beizi.ad.internal.h.i.a
                            public void a(Bitmap bitmap) {
                                try {
                                    ImageView imageView2 = imageView;
                                    if (imageView2 == null || bitmap == null) {
                                        return;
                                    }
                                    imageView2.setImageBitmap(bitmap);
                                } catch (Exception e6) {
                                    e6.printStackTrace();
                                }
                            }
                        });
                    }
                    int[] b6 = b(viewGroup);
                    if (viewGroup instanceof RelativeLayout) {
                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                        int i6 = b6[0];
                        if (i6 > 0) {
                            layoutParams.width = i6;
                        }
                        int i7 = b6[1];
                        if (i7 > 0) {
                            layoutParams.height = i7;
                        }
                        layoutParams.leftMargin = b6[2];
                        layoutParams.topMargin = b6[3];
                        layoutParams.addRule(17);
                        viewGroup.addView(imageView, layoutParams);
                    } else if (viewGroup instanceof FrameLayout) {
                        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2, 17);
                        int i8 = b6[0];
                        if (i8 > 0) {
                            layoutParams2.width = i8;
                        }
                        int i9 = b6[1];
                        if (i9 > 0) {
                            layoutParams2.height = i9;
                        }
                        layoutParams2.leftMargin = b6[2];
                        layoutParams2.topMargin = b6[3];
                        viewGroup.addView(imageView, layoutParams2);
                    } else if (viewGroup instanceof LinearLayout) {
                        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2, 17.0f);
                        int i10 = b6[0];
                        if (i10 > 0) {
                            layoutParams3.width = i10;
                        }
                        int i11 = b6[1];
                        if (i11 > 0) {
                            layoutParams3.height = i11;
                        }
                        layoutParams3.leftMargin = b6[2];
                        layoutParams3.topMargin = b6[3];
                        viewGroup.addView(imageView, layoutParams3);
                    } else {
                        ViewGroup.LayoutParams layoutParams4 = new ViewGroup.LayoutParams(-1, -2);
                        int i12 = b6[0];
                        if (i12 > 0) {
                            layoutParams4.width = i12;
                        }
                        int i13 = b6[1];
                        if (i13 > 0) {
                            layoutParams4.height = i13;
                        }
                        viewGroup.addView(imageView, layoutParams4);
                    }
                    a(imageView);
                }
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }
    }

    public void a(ImageView imageView) {
        try {
            ArrayList arrayList = new ArrayList();
            try {
                a(imageView, arrayList, "rotation", 0.0f, this.F);
                a(imageView, arrayList, "rotation", this.F, 0.0f);
                a(imageView, arrayList, "rotation", 0.0f, -this.F);
                a(imageView, arrayList, "rotation", -this.F, 0.0f);
                if (arrayList.size() > 0) {
                    AnimatorSet animatorSet = new AnimatorSet();
                    this.G = animatorSet;
                    animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.beizi.ad.a.a.e.3
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            try {
                                if (e.this.G != null) {
                                    e.this.G.start();
                                }
                            } catch (Exception e6) {
                                e6.printStackTrace();
                            }
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationRepeat(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                        }
                    });
                    this.G.playSequentially(arrayList);
                    this.G.start();
                }
            } catch (Exception e6) {
                e = e6;
                e.printStackTrace();
            }
        } catch (Exception e7) {
            e = e7;
        }
    }

    public void b(double d6) {
        this.f11388t = d6;
    }

    public void b(int i6) {
        this.f11390v = i6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(SensorEvent sensorEvent) {
        if (sensorEvent != null) {
            try {
                if (!this.Y && System.currentTimeMillis() - this.X >= 50) {
                    Sensor sensor = sensorEvent.sensor;
                    float[] fArr = sensorEvent.values;
                    int type = sensor.getType();
                    if (fArr != null && type == 4) {
                        this.X = System.currentTimeMillis();
                        float f6 = this.M;
                        if (f6 != 0.0f) {
                            float f7 = fArr[0];
                            float f8 = fArr[1];
                            float f9 = fArr[2];
                            float f10 = (sensorEvent.timestamp - f6) * this.N;
                            this.O[0] = (float) (r1[0] + Math.toDegrees(f7 * f10));
                            this.O[1] = (float) (r1[1] + Math.toDegrees(f8 * f10));
                            this.O[2] = (float) (r1[2] + Math.toDegrees(f9 * f10));
                            float[] fArr2 = this.O;
                            float f11 = fArr2[0];
                            if (f11 > 0.0f) {
                                if (f11 > this.S) {
                                    this.S = f11;
                                }
                            } else if (f11 < this.P) {
                                this.P = f11;
                            }
                            float f12 = fArr2[1];
                            if (f12 > 0.0f) {
                                if (f12 > this.T) {
                                    this.T = f12;
                                }
                            } else if (f12 < this.Q) {
                                this.Q = f12;
                            }
                            float f13 = fArr2[2];
                            if (f13 > 0.0f) {
                                if (f13 > this.U) {
                                    this.U = f13;
                                }
                            } else if (f13 < this.R) {
                                this.R = f13;
                            }
                            if ((Math.abs(this.P) > this.K && Math.abs(this.S) > this.K) || ((Math.abs(this.Q) > this.K && Math.abs(this.T) > this.K) || (Math.abs(this.R) > this.K && Math.abs(this.U) > this.K))) {
                                com.beizi.ad.lance.a.m.a("ShakeUtil", "rotate  xMin: " + String.format("%.4f", Float.valueOf(this.P)) + ",xMax: " + String.format("%.4f", Float.valueOf(this.S)) + ",yMin: " + String.format("%.4f", Float.valueOf(this.Q)) + ",yMax: " + String.format("%.4f", Float.valueOf(this.T)) + ",zMin: " + String.format("%.4f", Float.valueOf(this.R)) + ",zMax: " + String.format("%.4f", Float.valueOf(this.U)));
                                this.V = true;
                            }
                            if (this.W && this.V) {
                                r();
                            }
                        }
                        this.M = sensorEvent.timestamp;
                    }
                }
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }
    }

    private void a(ImageView imageView, List<Animator> list, String str, float f6, float f7) {
        try {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, str, f6, f7);
            ofFloat.setDuration(this.E);
            list.add(ofFloat);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public int a(int i6) {
        return (int) ((Math.random() * i6) + 1.0d);
    }

    public void a(double d6) {
        this.f11387s = d6;
    }

    public void a(a aVar) {
        this.f11382n = aVar;
    }

    private double a(float f6, float f7, float f8) {
        try {
            return Math.sqrt(Math.pow(f6 / this.f11375g, 2.0d) + Math.pow(f7 / this.f11375g, 2.0d) + Math.pow(f8 / this.f11375g, 2.0d));
        } catch (Exception e6) {
            e6.printStackTrace();
            return 0.0d;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SensorEvent sensorEvent) {
        float[] fArr;
        try {
            if (System.currentTimeMillis() - this.A >= 100 && sensorEvent != null && this.f11394z && (fArr = sensorEvent.values) != null && fArr.length >= 3) {
                this.A = System.currentTimeMillis();
                double a6 = a(fArr[0], fArr[1], fArr[2]);
                if (a6 > this.f11387s) {
                    this.f11386r = this.f11378j;
                } else if (a6 <= this.f11388t && this.f11386r == this.f11378j) {
                    this.f11386r = this.f11379k;
                    this.f11392x++;
                }
                int i6 = this.f11390v;
                if (i6 <= 0 || this.f11392x < i6) {
                    return;
                }
                this.W = true;
                com.beizi.ad.lance.a.m.b("ShakeUtil", " current: " + String.format("%.4f", Double.valueOf(a6)) + ", execute: " + this.f11392x + ", count: " + this.f11390v + "_" + this.f11391w + ", shake: " + this.f11387s + "_" + this.f11388t);
                if (this.W && this.V) {
                    r();
                }
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }
}
