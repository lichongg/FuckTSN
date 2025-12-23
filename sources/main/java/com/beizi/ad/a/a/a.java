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
import org.apache.commons.net.ftp.l;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class a {

    /* renamed from: g, reason: collision with root package name */
    private static final String f11267g = "a";

    /* renamed from: q, reason: collision with root package name */
    private static SensorManager f11268q;
    private float A;
    private InterfaceC0102a B;
    private String E;
    private AnimatorSet J;
    private boolean K;
    private String L;
    private float M;
    private float N;
    private float O;
    private float P;
    private float Q;
    private float R;

    /* renamed from: h, reason: collision with root package name */
    private Context f11275h;

    /* renamed from: i, reason: collision with root package name */
    private AdSpacesBean.BuyerBean.EulerAngleViewBean f11276i;

    /* renamed from: j, reason: collision with root package name */
    private AdSpacesBean.BuyerBean.EulerAngleViewBean f11277j;

    /* renamed from: k, reason: collision with root package name */
    private AdSpacesBean.BuyerBean.EulerAngleViewRuleBean f11278k;

    /* renamed from: l, reason: collision with root package name */
    private AdSpacesBean.BuyerBean.EulerAngleViewRuleBean f11279l;

    /* renamed from: m, reason: collision with root package name */
    private AdSpacesBean.BuyerBean.EulerAngleViewRuleBean f11280m;

    /* renamed from: n, reason: collision with root package name */
    private AdSpacesBean.BuyerBean.EulerAngleRenderBean f11281n;

    /* renamed from: r, reason: collision with root package name */
    private Sensor f11284r;

    /* renamed from: v, reason: collision with root package name */
    private String f11288v;

    /* renamed from: w, reason: collision with root package name */
    private String f11289w;

    /* renamed from: x, reason: collision with root package name */
    private String f11290x;

    /* renamed from: o, reason: collision with root package name */
    private float f11282o = 1.0E-9f;

    /* renamed from: p, reason: collision with root package name */
    private float[] f11283p = new float[3];

    /* renamed from: s, reason: collision with root package name */
    private double f11285s = 0.0d;

    /* renamed from: t, reason: collision with root package name */
    private double f11286t = 0.0d;

    /* renamed from: u, reason: collision with root package name */
    private double f11287u = 0.0d;

    /* renamed from: y, reason: collision with root package name */
    private boolean f11291y = false;

    /* renamed from: z, reason: collision with root package name */
    private int f11292z = 0;
    private boolean C = true;
    private boolean D = false;

    /* renamed from: a, reason: collision with root package name */
    String f11269a = "x";

    /* renamed from: b, reason: collision with root package name */
    String f11270b = "y";

    /* renamed from: c, reason: collision with root package name */
    String f11271c = bi.aG;

    /* renamed from: d, reason: collision with root package name */
    String f11272d = "0";

    /* renamed from: e, reason: collision with root package name */
    String f11273e = "1";

    /* renamed from: f, reason: collision with root package name */
    String f11274f = "2";
    private int F = l.f50696w;
    private float G = 60.0f;
    private float H = 60.0f;
    private float I = 30.0f;
    private SensorEventListener S = new SensorEventListener() { // from class: com.beizi.ad.a.a.a.4
        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            try {
                a.this.a(sensorEvent);
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i6) {
        }
    };

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.beizi.ad.a.a.a$a, reason: collision with other inner class name */
    public interface InterfaceC0102a {
        void a();
    }

    private boolean h() {
        try {
            AdSpacesBean.BuyerBean.EulerAngleViewRuleBean eulerAngleViewRuleBean = this.f11280m;
            if (eulerAngleViewRuleBean != null && eulerAngleViewRuleBean != null && eulerAngleViewRuleBean.getRules() != null && this.f11280m.getRules().size() > 0) {
                if (this.f11280m.getStyle() != null) {
                    return true;
                }
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        return false;
    }

    private boolean i() {
        try {
            AdSpacesBean.BuyerBean.EulerAngleViewRuleBean eulerAngleViewRuleBean = this.f11280m;
            if (eulerAngleViewRuleBean == null) {
                return false;
            }
            long coolTime = eulerAngleViewRuleBean.getCoolTime();
            long longValue = ((Long) m.d(this.f11275h, this.E, 0L)).longValue();
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

    private boolean j() {
        try {
            AdSpacesBean.BuyerBean.EulerAngleViewRuleBean eulerAngleViewRuleBean = this.f11280m;
            if (eulerAngleViewRuleBean == null) {
                return false;
            }
            return System.currentTimeMillis() - q.a(this.f11275h) < eulerAngleViewRuleBean.getUserProtectTime();
        } catch (Exception e6) {
            e6.printStackTrace();
            return false;
        }
    }

    private void k() {
        this.A = 0.0f;
        float[] fArr = this.f11283p;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        this.M = 0.0f;
        this.N = 0.0f;
        this.O = 0.0f;
        this.P = 0.0f;
        this.Q = 0.0f;
        this.R = 0.0f;
    }

    private boolean n() {
        try {
            if (this.f11285s > 0.0d) {
                if (this.f11274f.equals(this.f11288v)) {
                    if (this.f11283p[0] > 0.0f && Math.abs(r1) >= this.f11285s) {
                        return true;
                    }
                } else if (this.f11273e.equals(this.f11288v)) {
                    if (this.f11283p[0] < 0.0f && Math.abs(r1) >= this.f11285s) {
                        return true;
                    }
                } else if (this.f11272d.equals(this.f11288v)) {
                    if (Math.abs(this.f11283p[0]) >= this.f11285s) {
                        return true;
                    }
                } else if ("3".equals(this.f11288v) && Math.abs(this.M) >= this.f11285s && Math.abs(this.P) > this.f11285s) {
                    return true;
                }
            }
            if (this.f11286t > 0.0d) {
                if (this.f11274f.equals(this.f11289w)) {
                    if (this.f11283p[1] < 0.0f && Math.abs(r1) >= this.f11286t) {
                        return true;
                    }
                } else if (this.f11273e.equals(this.f11289w)) {
                    if (this.f11283p[1] > 0.0f && Math.abs(r1) >= this.f11286t) {
                        return true;
                    }
                } else if (this.f11272d.equals(this.f11289w)) {
                    if (Math.abs(this.f11283p[1]) >= this.f11286t) {
                        return true;
                    }
                } else if ("3".equals(this.f11289w) && Math.abs(this.N) >= this.f11286t && Math.abs(this.Q) > this.f11286t) {
                    return true;
                }
            }
            if (this.f11287u > 0.0d) {
                if (this.f11274f.equals(this.f11290x)) {
                    if (this.f11283p[2] > 0.0f && Math.abs(r1) >= this.f11287u) {
                        return true;
                    }
                } else if (this.f11273e.equals(this.f11290x)) {
                    if (this.f11283p[2] < 0.0f && Math.abs(r1) >= this.f11287u) {
                        return true;
                    }
                } else if (this.f11272d.equals(this.f11290x)) {
                    if (Math.abs(this.f11283p[2]) >= this.f11287u) {
                        return true;
                    }
                } else if ("3".equals(this.f11290x) && Math.abs(this.O) >= this.f11287u && Math.abs(this.R) > this.f11287u) {
                    return true;
                }
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        return false;
    }

    private boolean e() {
        List<AdSpacesBean.BuyerBean.EulerAngleRuleBean> rules;
        AdSpacesBean.BuyerBean.EulerAngleViewRuleBean eulerAngleViewRuleBean = this.f11279l;
        if (eulerAngleViewRuleBean != null && (rules = eulerAngleViewRuleBean.getRules()) != null && rules.size() != 0) {
            for (AdSpacesBean.BuyerBean.EulerAngleRuleBean eulerAngleRuleBean : rules) {
                if (eulerAngleRuleBean != null) {
                    String axis = eulerAngleRuleBean.getAxis();
                    double angle = eulerAngleRuleBean.getAngle();
                    if (!TextUtils.isEmpty(axis) && angle > 0.0d) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private void g() {
        List<AdSpacesBean.BuyerBean.EulerAngleRuleBean> rules;
        try {
            AdSpacesBean.BuyerBean.EulerAngleViewRuleBean eulerAngleViewRuleBean = this.f11278k;
            if (eulerAngleViewRuleBean != null && (rules = eulerAngleViewRuleBean.getRules()) != null && rules.size() != 0) {
                int passivationTime = this.f11278k.getPassivationTime();
                final double d6 = 0.0d;
                final double d7 = 0.0d;
                final double d8 = 0.0d;
                for (AdSpacesBean.BuyerBean.EulerAngleRuleBean eulerAngleRuleBean : rules) {
                    if (eulerAngleRuleBean != null) {
                        if (this.f11269a.equalsIgnoreCase(eulerAngleRuleBean.getAxis())) {
                            if (passivationTime <= 0 || eulerAngleRuleBean.getPangle() <= 0.0d) {
                                this.f11285s = eulerAngleRuleBean.getAngle();
                            } else {
                                this.f11285s = eulerAngleRuleBean.getPangle();
                            }
                            double angle = eulerAngleRuleBean.getAngle();
                            this.f11288v = eulerAngleRuleBean.getDirection();
                            d6 = angle;
                        } else if (this.f11270b.equalsIgnoreCase(eulerAngleRuleBean.getAxis())) {
                            if (passivationTime <= 0 || eulerAngleRuleBean.getPangle() <= 0.0d) {
                                this.f11286t = eulerAngleRuleBean.getAngle();
                            } else {
                                this.f11286t = eulerAngleRuleBean.getPangle();
                            }
                            d7 = eulerAngleRuleBean.getAngle();
                            this.f11289w = eulerAngleRuleBean.getDirection();
                        } else if (this.f11271c.equalsIgnoreCase(eulerAngleRuleBean.getAxis())) {
                            if (passivationTime <= 0 || eulerAngleRuleBean.getPangle() <= 0.0d) {
                                this.f11287u = eulerAngleRuleBean.getAngle();
                            } else {
                                this.f11287u = eulerAngleRuleBean.getPangle();
                            }
                            d8 = eulerAngleRuleBean.getAngle();
                            this.f11290x = eulerAngleRuleBean.getDirection();
                        }
                    }
                }
                if (passivationTime > 0) {
                    new Handler().postDelayed(new Runnable() { // from class: com.beizi.ad.a.a.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                a.this.A = 0.0f;
                                a.this.f11283p[0] = 0.0f;
                                a.this.f11283p[1] = 0.0f;
                                a.this.f11283p[2] = 0.0f;
                                a.this.f11285s = d6;
                                a.this.f11286t = d7;
                                a.this.f11287u = d8;
                            } catch (Exception e6) {
                                e6.printStackTrace();
                            }
                        }
                    }, a(passivationTime));
                }
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void l() {
        try {
            if (f11268q == null) {
                f11268q = (SensorManager) StubApp.getOrigApplicationContext(this.f11275h.getApplicationContext()).getSystemService(bi.ac);
            }
            if (this.f11284r == null) {
                this.f11284r = f11268q.getDefaultSensor(4);
            }
            f11268q.registerListener(this.S, this.f11284r, 1);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void m() {
        try {
            com.beizi.ad.lance.a.m.a(f11267g, "enter unRegisterListener");
            SensorManager sensorManager = f11268q;
            if (sensorManager != null) {
                sensorManager.unregisterListener(this.S);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void o() {
        try {
            if (this.B != null && this.C) {
                com.beizi.ad.lance.a.m.a(f11267g, "onEulerAngleHappened");
                b();
                if (!this.f11291y) {
                    m.c(this.f11275h, this.E, Long.valueOf(System.currentTimeMillis()));
                }
                this.B.a();
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public String c() {
        return this.L;
    }

    public a(Context context, AdSpacesBean.BuyerBean.EulerAngleViewBean eulerAngleViewBean, String str, String str2) {
        this.E = null;
        this.K = false;
        this.f11275h = context;
        this.f11276i = eulerAngleViewBean;
        this.E = "beizi_cool_" + str;
        AdSpacesBean.BuyerBean.OrderDataEulerAngleViewBean a6 = a(this.f11276i.getOrderData(), str2);
        if (a6 != null && a6.getEulerAngleRule() != null) {
            this.f11277j = a6.getEulerAngleRule();
        }
        AdSpacesBean.BuyerBean.EulerAngleViewBean eulerAngleViewBean2 = this.f11276i;
        if (eulerAngleViewBean2 != null) {
            this.f11280m = eulerAngleViewBean2.getCoolRule();
        }
        AdSpacesBean.BuyerBean.EulerAngleViewBean eulerAngleViewBean3 = this.f11277j;
        if (eulerAngleViewBean3 != null) {
            this.f11279l = eulerAngleViewBean3.getNomalRule();
            this.f11281n = this.f11277j.getRender();
        } else {
            AdSpacesBean.BuyerBean.EulerAngleViewBean eulerAngleViewBean4 = this.f11276i;
            if (eulerAngleViewBean4 != null) {
                this.f11279l = eulerAngleViewBean4.getNomalRule();
                this.f11281n = this.f11276i.getRender();
            }
        }
        if (!e()) {
            this.K = false;
            return;
        }
        this.K = true;
        f();
        l();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023 A[Catch: Exception -> 0x0011, TryCatch #0 {Exception -> 0x0011, blocks: (B:2:0x0000, B:4:0x0007, B:7:0x000e, B:8:0x001f, B:10:0x0023, B:13:0x002b, B:15:0x0013, B:17:0x0019, B:18:0x001d), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x002b A[Catch: Exception -> 0x0011, TRY_LEAVE, TryCatch #0 {Exception -> 0x0011, blocks: (B:2:0x0000, B:4:0x0007, B:7:0x000e, B:8:0x001f, B:10:0x0023, B:13:0x002b, B:15:0x0013, B:17:0x0019, B:18:0x001d), top: B:1:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void f() {
        /*
            r2 = this;
            boolean r0 = r2.j()     // Catch: java.lang.Exception -> L11
            r1 = 0
            if (r0 != 0) goto L13
            boolean r0 = r2.i()     // Catch: java.lang.Exception -> L11
            if (r0 == 0) goto Le
            goto L13
        Le:
            r2.f11291y = r1     // Catch: java.lang.Exception -> L11
            goto L1f
        L11:
            r0 = move-exception
            goto L33
        L13:
            boolean r0 = r2.h()     // Catch: java.lang.Exception -> L11
            if (r0 == 0) goto L1d
            r0 = 1
            r2.f11291y = r0     // Catch: java.lang.Exception -> L11
            goto L1f
        L1d:
            r2.f11291y = r1     // Catch: java.lang.Exception -> L11
        L1f:
            boolean r0 = r2.f11291y     // Catch: java.lang.Exception -> L11
            if (r0 == 0) goto L2b
            com.beizi.fusion.model.AdSpacesBean$BuyerBean$EulerAngleViewRuleBean r0 = r2.f11280m     // Catch: java.lang.Exception -> L11
            r2.f11278k = r0     // Catch: java.lang.Exception -> L11
            r2.g()     // Catch: java.lang.Exception -> L11
            return
        L2b:
            com.beizi.fusion.model.AdSpacesBean$BuyerBean$EulerAngleViewRuleBean r0 = r2.f11279l     // Catch: java.lang.Exception -> L11
            r2.f11278k = r0     // Catch: java.lang.Exception -> L11
            r2.g()     // Catch: java.lang.Exception -> L11
            return
        L33:
            r0.printStackTrace()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.ad.a.a.a.f():void");
    }

    public void b() {
        this.C = false;
        k();
        m();
    }

    public void d() {
        try {
            m();
            this.f11276i = null;
            this.f11277j = null;
            this.f11278k = null;
            this.f11279l = null;
            this.f11280m = null;
            this.f11281n = null;
            this.f11275h = null;
            this.B = null;
            f11268q = null;
            this.f11284r = null;
            AnimatorSet animatorSet = this.J;
            if (animatorSet != null) {
                animatorSet.removeAllListeners();
            }
            this.J = null;
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private AdSpacesBean.BuyerBean.OrderDataEulerAngleViewBean a(List<AdSpacesBean.BuyerBean.OrderDataEulerAngleViewBean> list, String str) {
        if (list != null && str != null) {
            for (AdSpacesBean.BuyerBean.OrderDataEulerAngleViewBean orderDataEulerAngleViewBean : list) {
                List<String> orderList = orderDataEulerAngleViewBean.getOrderList();
                if (orderList != null && orderList.contains(str)) {
                    return orderDataEulerAngleViewBean;
                }
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x006f A[Catch: Exception -> 0x0041, TryCatch #0 {Exception -> 0x0041, blocks: (B:8:0x000e, B:10:0x001a, B:13:0x003a, B:16:0x0045, B:18:0x004b, B:20:0x0052, B:22:0x006f, B:23:0x0075, B:26:0x00b7, B:28:0x00be, B:30:0x00c4, B:32:0x00cb, B:34:0x00d1, B:35:0x00ee, B:37:0x00f4, B:38:0x0111, B:40:0x0119, B:41:0x0137, B:43:0x013d, B:44:0x0158, B:46:0x017a, B:48:0x017e, B:49:0x0180, B:51:0x014e, B:53:0x0154, B:54:0x012a, B:56:0x0130, B:58:0x0105, B:60:0x010b, B:62:0x00e2, B:64:0x00e8, B:4:0x01c1), top: B:7:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00d1 A[Catch: Exception -> 0x0041, TryCatch #0 {Exception -> 0x0041, blocks: (B:8:0x000e, B:10:0x001a, B:13:0x003a, B:16:0x0045, B:18:0x004b, B:20:0x0052, B:22:0x006f, B:23:0x0075, B:26:0x00b7, B:28:0x00be, B:30:0x00c4, B:32:0x00cb, B:34:0x00d1, B:35:0x00ee, B:37:0x00f4, B:38:0x0111, B:40:0x0119, B:41:0x0137, B:43:0x013d, B:44:0x0158, B:46:0x017a, B:48:0x017e, B:49:0x0180, B:51:0x014e, B:53:0x0154, B:54:0x012a, B:56:0x0130, B:58:0x0105, B:60:0x010b, B:62:0x00e2, B:64:0x00e8, B:4:0x01c1), top: B:7:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00f4 A[Catch: Exception -> 0x0041, TryCatch #0 {Exception -> 0x0041, blocks: (B:8:0x000e, B:10:0x001a, B:13:0x003a, B:16:0x0045, B:18:0x004b, B:20:0x0052, B:22:0x006f, B:23:0x0075, B:26:0x00b7, B:28:0x00be, B:30:0x00c4, B:32:0x00cb, B:34:0x00d1, B:35:0x00ee, B:37:0x00f4, B:38:0x0111, B:40:0x0119, B:41:0x0137, B:43:0x013d, B:44:0x0158, B:46:0x017a, B:48:0x017e, B:49:0x0180, B:51:0x014e, B:53:0x0154, B:54:0x012a, B:56:0x0130, B:58:0x0105, B:60:0x010b, B:62:0x00e2, B:64:0x00e8, B:4:0x01c1), top: B:7:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0119 A[Catch: Exception -> 0x0041, TryCatch #0 {Exception -> 0x0041, blocks: (B:8:0x000e, B:10:0x001a, B:13:0x003a, B:16:0x0045, B:18:0x004b, B:20:0x0052, B:22:0x006f, B:23:0x0075, B:26:0x00b7, B:28:0x00be, B:30:0x00c4, B:32:0x00cb, B:34:0x00d1, B:35:0x00ee, B:37:0x00f4, B:38:0x0111, B:40:0x0119, B:41:0x0137, B:43:0x013d, B:44:0x0158, B:46:0x017a, B:48:0x017e, B:49:0x0180, B:51:0x014e, B:53:0x0154, B:54:0x012a, B:56:0x0130, B:58:0x0105, B:60:0x010b, B:62:0x00e2, B:64:0x00e8, B:4:0x01c1), top: B:7:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x013d A[Catch: Exception -> 0x0041, TryCatch #0 {Exception -> 0x0041, blocks: (B:8:0x000e, B:10:0x001a, B:13:0x003a, B:16:0x0045, B:18:0x004b, B:20:0x0052, B:22:0x006f, B:23:0x0075, B:26:0x00b7, B:28:0x00be, B:30:0x00c4, B:32:0x00cb, B:34:0x00d1, B:35:0x00ee, B:37:0x00f4, B:38:0x0111, B:40:0x0119, B:41:0x0137, B:43:0x013d, B:44:0x0158, B:46:0x017a, B:48:0x017e, B:49:0x0180, B:51:0x014e, B:53:0x0154, B:54:0x012a, B:56:0x0130, B:58:0x0105, B:60:0x010b, B:62:0x00e2, B:64:0x00e8, B:4:0x01c1), top: B:7:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x017a A[Catch: Exception -> 0x0041, TryCatch #0 {Exception -> 0x0041, blocks: (B:8:0x000e, B:10:0x001a, B:13:0x003a, B:16:0x0045, B:18:0x004b, B:20:0x0052, B:22:0x006f, B:23:0x0075, B:26:0x00b7, B:28:0x00be, B:30:0x00c4, B:32:0x00cb, B:34:0x00d1, B:35:0x00ee, B:37:0x00f4, B:38:0x0111, B:40:0x0119, B:41:0x0137, B:43:0x013d, B:44:0x0158, B:46:0x017a, B:48:0x017e, B:49:0x0180, B:51:0x014e, B:53:0x0154, B:54:0x012a, B:56:0x0130, B:58:0x0105, B:60:0x010b, B:62:0x00e2, B:64:0x00e8, B:4:0x01c1), top: B:7:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x017e A[Catch: Exception -> 0x0041, TryCatch #0 {Exception -> 0x0041, blocks: (B:8:0x000e, B:10:0x001a, B:13:0x003a, B:16:0x0045, B:18:0x004b, B:20:0x0052, B:22:0x006f, B:23:0x0075, B:26:0x00b7, B:28:0x00be, B:30:0x00c4, B:32:0x00cb, B:34:0x00d1, B:35:0x00ee, B:37:0x00f4, B:38:0x0111, B:40:0x0119, B:41:0x0137, B:43:0x013d, B:44:0x0158, B:46:0x017a, B:48:0x017e, B:49:0x0180, B:51:0x014e, B:53:0x0154, B:54:0x012a, B:56:0x0130, B:58:0x0105, B:60:0x010b, B:62:0x00e2, B:64:0x00e8, B:4:0x01c1), top: B:7:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x014e A[Catch: Exception -> 0x0041, TryCatch #0 {Exception -> 0x0041, blocks: (B:8:0x000e, B:10:0x001a, B:13:0x003a, B:16:0x0045, B:18:0x004b, B:20:0x0052, B:22:0x006f, B:23:0x0075, B:26:0x00b7, B:28:0x00be, B:30:0x00c4, B:32:0x00cb, B:34:0x00d1, B:35:0x00ee, B:37:0x00f4, B:38:0x0111, B:40:0x0119, B:41:0x0137, B:43:0x013d, B:44:0x0158, B:46:0x017a, B:48:0x017e, B:49:0x0180, B:51:0x014e, B:53:0x0154, B:54:0x012a, B:56:0x0130, B:58:0x0105, B:60:0x010b, B:62:0x00e2, B:64:0x00e8, B:4:0x01c1), top: B:7:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x012a A[Catch: Exception -> 0x0041, TryCatch #0 {Exception -> 0x0041, blocks: (B:8:0x000e, B:10:0x001a, B:13:0x003a, B:16:0x0045, B:18:0x004b, B:20:0x0052, B:22:0x006f, B:23:0x0075, B:26:0x00b7, B:28:0x00be, B:30:0x00c4, B:32:0x00cb, B:34:0x00d1, B:35:0x00ee, B:37:0x00f4, B:38:0x0111, B:40:0x0119, B:41:0x0137, B:43:0x013d, B:44:0x0158, B:46:0x017a, B:48:0x017e, B:49:0x0180, B:51:0x014e, B:53:0x0154, B:54:0x012a, B:56:0x0130, B:58:0x0105, B:60:0x010b, B:62:0x00e2, B:64:0x00e8, B:4:0x01c1), top: B:7:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0105 A[Catch: Exception -> 0x0041, TryCatch #0 {Exception -> 0x0041, blocks: (B:8:0x000e, B:10:0x001a, B:13:0x003a, B:16:0x0045, B:18:0x004b, B:20:0x0052, B:22:0x006f, B:23:0x0075, B:26:0x00b7, B:28:0x00be, B:30:0x00c4, B:32:0x00cb, B:34:0x00d1, B:35:0x00ee, B:37:0x00f4, B:38:0x0111, B:40:0x0119, B:41:0x0137, B:43:0x013d, B:44:0x0158, B:46:0x017a, B:48:0x017e, B:49:0x0180, B:51:0x014e, B:53:0x0154, B:54:0x012a, B:56:0x0130, B:58:0x0105, B:60:0x010b, B:62:0x00e2, B:64:0x00e8, B:4:0x01c1), top: B:7:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00e2 A[Catch: Exception -> 0x0041, TryCatch #0 {Exception -> 0x0041, blocks: (B:8:0x000e, B:10:0x001a, B:13:0x003a, B:16:0x0045, B:18:0x004b, B:20:0x0052, B:22:0x006f, B:23:0x0075, B:26:0x00b7, B:28:0x00be, B:30:0x00c4, B:32:0x00cb, B:34:0x00d1, B:35:0x00ee, B:37:0x00f4, B:38:0x0111, B:40:0x0119, B:41:0x0137, B:43:0x013d, B:44:0x0158, B:46:0x017a, B:48:0x017e, B:49:0x0180, B:51:0x014e, B:53:0x0154, B:54:0x012a, B:56:0x0130, B:58:0x0105, B:60:0x010b, B:62:0x00e2, B:64:0x00e8, B:4:0x01c1), top: B:7:0x000e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int[] b(android.view.ViewGroup r20) {
        /*
            Method dump skipped, instructions count: 478
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.ad.a.a.a.b(android.view.ViewGroup):int[]");
    }

    public int a(int i6) {
        return (int) ((Math.random() * i6) + 1.0d);
    }

    public void a() {
        if (this.D || !this.K) {
            return;
        }
        this.C = true;
        k();
        f();
        l();
    }

    public void a(InterfaceC0102a interfaceC0102a) {
        this.B = interfaceC0102a;
    }

    public void a(ViewGroup viewGroup) {
        AdSpacesBean.BuyerBean.EulerAngleStyleBean style;
        List<String> imgs;
        if (viewGroup != null) {
            try {
                if (this.f11275h != null && this.K) {
                    final ImageView imageView = new ImageView(this.f11275h);
                    imageView.setVisibility(0);
                    imageView.setImageResource(R.mipmap.beizi_interaction_icon_euler_angle);
                    AdSpacesBean.BuyerBean.EulerAngleViewRuleBean eulerAngleViewRuleBean = this.f11278k;
                    if (eulerAngleViewRuleBean != null && (style = eulerAngleViewRuleBean.getStyle()) != null && (imgs = style.getImgs()) != null && imgs.size() > 0) {
                        this.L = imgs.get(0);
                    }
                    if (!TextUtils.isEmpty(this.L)) {
                        i.a(this.f11275h).b(this.L, new i.a() { // from class: com.beizi.ad.a.a.a.2
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
        a aVar;
        ImageView imageView2;
        try {
            ArrayList arrayList = new ArrayList();
            try {
                if (TextUtils.isEmpty(this.f11288v)) {
                    aVar = this;
                    imageView2 = imageView;
                } else if (this.f11274f.equals(this.f11288v)) {
                    aVar = this;
                    imageView2 = imageView;
                    aVar.a(imageView2, arrayList, "rotationX", 0.0f, -this.G);
                    aVar.a(imageView2, arrayList, "rotationX", -aVar.G, 0.0f);
                } else {
                    aVar = this;
                    imageView2 = imageView;
                    if (aVar.f11273e.equals(aVar.f11288v)) {
                        aVar.a(imageView2, arrayList, "rotationX", 0.0f, aVar.G);
                        aVar.a(imageView2, arrayList, "rotationX", aVar.G, 0.0f);
                    } else {
                        aVar.a(imageView2, arrayList, "rotationX", 0.0f, aVar.G);
                        aVar.a(imageView2, arrayList, "rotationX", aVar.G, 0.0f);
                        aVar.a(imageView2, arrayList, "rotationX", 0.0f, -aVar.G);
                        aVar.a(imageView2, arrayList, "rotationX", -aVar.G, 0.0f);
                    }
                }
                if (!TextUtils.isEmpty(aVar.f11289w)) {
                    if (aVar.f11274f.equals(aVar.f11289w)) {
                        aVar.a(imageView2, arrayList, "rotationY", 0.0f, -aVar.H);
                        aVar.a(imageView2, arrayList, "rotationY", -aVar.H, 0.0f);
                    } else if (aVar.f11273e.equals(aVar.f11289w)) {
                        aVar.a(imageView2, arrayList, "rotationY", 0.0f, aVar.H);
                        aVar.a(imageView2, arrayList, "rotationY", aVar.H, 0.0f);
                    } else {
                        aVar.a(imageView2, arrayList, "rotationY", 0.0f, aVar.H);
                        aVar.a(imageView2, arrayList, "rotationY", aVar.H, 0.0f);
                        aVar.a(imageView2, arrayList, "rotationY", 0.0f, -aVar.H);
                        aVar.a(imageView2, arrayList, "rotationY", -aVar.H, 0.0f);
                    }
                }
                if (!TextUtils.isEmpty(aVar.f11290x)) {
                    if (aVar.f11274f.equals(aVar.f11290x)) {
                        aVar.a(imageView2, arrayList, "rotation", 0.0f, -aVar.I);
                        aVar.a(imageView2, arrayList, "rotation", -aVar.I, 0.0f);
                    } else if (aVar.f11273e.equals(aVar.f11290x)) {
                        aVar.a(imageView2, arrayList, "rotation", 0.0f, aVar.I);
                        aVar.a(imageView2, arrayList, "rotation", aVar.I, 0.0f);
                    } else {
                        aVar.a(imageView2, arrayList, "rotation", 0.0f, aVar.I);
                        aVar.a(imageView2, arrayList, "rotation", aVar.I, 0.0f);
                        aVar.a(imageView2, arrayList, "rotation", 0.0f, -aVar.I);
                        aVar.a(imageView2, arrayList, "rotation", -aVar.I, 0.0f);
                    }
                }
                if (aVar.J != null) {
                    aVar.J = null;
                }
                if (arrayList.size() > 0) {
                    AnimatorSet animatorSet = new AnimatorSet();
                    aVar.J = animatorSet;
                    animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.beizi.ad.a.a.a.3
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            try {
                                if (a.this.J != null) {
                                    a.this.J.start();
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
                    aVar.J.playSequentially(arrayList);
                    aVar.J.start();
                }
            } catch (Exception e6) {
                e = e6;
                e.printStackTrace();
            }
        } catch (Exception e7) {
            e = e7;
        }
    }

    private void a(ImageView imageView, List<Animator> list, String str, float f6, float f7) {
        try {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, str, f6, f7);
            ofFloat.setDuration(this.F);
            list.add(ofFloat);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SensorEvent sensorEvent) {
        if (sensorEvent != null) {
            try {
                if (this.C) {
                    Sensor sensor = sensorEvent.sensor;
                    float[] fArr = sensorEvent.values;
                    int type = sensor.getType();
                    if (fArr != null && type == 4) {
                        float f6 = this.A;
                        if (f6 != 0.0f) {
                            float f7 = fArr[0];
                            float f8 = fArr[1];
                            float f9 = fArr[2];
                            float f10 = (sensorEvent.timestamp - f6) * this.f11282o;
                            this.f11283p[0] = (float) (r1[0] + Math.toDegrees(f7 * f10));
                            this.f11283p[1] = (float) (r1[1] + Math.toDegrees(f8 * f10));
                            this.f11283p[2] = (float) (r1[2] + Math.toDegrees(f9 * f10));
                            float[] fArr2 = this.f11283p;
                            float f11 = fArr2[0];
                            if (f11 > 0.0f) {
                                if (f11 > this.P) {
                                    this.P = f11;
                                }
                            } else if (f11 < this.M) {
                                this.M = f11;
                            }
                            float f12 = fArr2[1];
                            if (f12 > 0.0f) {
                                if (f12 > this.Q) {
                                    this.Q = f12;
                                }
                            } else if (f12 < this.N) {
                                this.N = f12;
                            }
                            float f13 = fArr2[2];
                            if (f13 > 0.0f) {
                                if (f13 > this.R) {
                                    this.R = f13;
                                }
                            } else if (f13 < this.O) {
                                this.O = f13;
                            }
                            com.beizi.ad.lance.a.m.a(f11267g, "rotate  x: " + String.format("%.4f", Float.valueOf(this.f11283p[0])) + ",y: " + String.format("%.4f", Float.valueOf(this.f11283p[1])) + ",z: " + String.format("%.4f", Float.valueOf(this.f11283p[2])) + ",x : " + this.f11285s + ",y : " + this.f11286t + ",z : " + this.f11287u);
                            if (n()) {
                                o();
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
}
