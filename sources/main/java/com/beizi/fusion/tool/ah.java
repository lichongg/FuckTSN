package com.beizi.fusion.tool;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.widget.TwistView;
import com.stub.StubApp;
import com.tencent.bugly.BuglyStrategy;
import com.umeng.analytics.pro.bi;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class ah {

    /* renamed from: a, reason: collision with root package name */
    private static final String f13598a = "ah";

    /* renamed from: c, reason: collision with root package name */
    private static SensorManager f13599c;

    /* renamed from: n, reason: collision with root package name */
    private static String f13600n;

    /* renamed from: o, reason: collision with root package name */
    private static String f13601o;

    /* renamed from: p, reason: collision with root package name */
    private static String f13602p;

    /* renamed from: q, reason: collision with root package name */
    private static String f13603q;

    /* renamed from: b, reason: collision with root package name */
    private Context f13604b;

    /* renamed from: j, reason: collision with root package name */
    private long f13611j;

    /* renamed from: k, reason: collision with root package name */
    private double f13612k;

    /* renamed from: l, reason: collision with root package name */
    private double f13613l;

    /* renamed from: m, reason: collision with root package name */
    private TwistView f13614m;

    /* renamed from: u, reason: collision with root package name */
    private Boolean f13618u;

    /* renamed from: d, reason: collision with root package name */
    private long f13605d = 0;

    /* renamed from: e, reason: collision with root package name */
    private double f13606e = -999.0d;

    /* renamed from: f, reason: collision with root package name */
    private double f13607f = -999.0d;

    /* renamed from: g, reason: collision with root package name */
    private boolean f13608g = false;

    /* renamed from: h, reason: collision with root package name */
    private boolean f13609h = false;

    /* renamed from: i, reason: collision with root package name */
    private int f13610i = 0;

    /* renamed from: r, reason: collision with root package name */
    private boolean f13615r = false;

    /* renamed from: s, reason: collision with root package name */
    private boolean f13616s = false;

    /* renamed from: t, reason: collision with root package name */
    private a f13617t = null;

    /* renamed from: v, reason: collision with root package name */
    private final SensorEventListener f13619v = new SensorEventListener() { // from class: com.beizi.fusion.tool.ah.1
        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            try {
                if (System.currentTimeMillis() - ah.this.f13605d < 80) {
                    return;
                }
                ah.this.f13605d = System.currentTimeMillis();
                float[] fArr = sensorEvent.values;
                double d6 = fArr[0] / 9.8d;
                double d7 = fArr[1] / 9.8d;
                double d8 = fArr[2] / 9.8d;
                double degrees = Math.toDegrees(Math.atan2(d6, d7));
                double d9 = degrees <= 0.0d ? (-degrees) - 180.0d : 180.0d - degrees;
                double degrees2 = Math.toDegrees(Math.atan2(d6, d8));
                double d10 = degrees2 <= 0.0d ? (-degrees2) - 180.0d : 180.0d - degrees2;
                double degrees3 = Math.toDegrees(Math.atan2(d8, Math.sqrt((d6 * d6) + (d7 * d7)))) + 90.0d;
                if (degrees3 > 45.0d && degrees3 < 135.0d && (Math.abs((Math.sin(d7) / 3.141592653589793d) * 180.0d) >= 45.0d || !ah.this.f13608g)) {
                    if (ah.this.f13607f != -999.0d && ah.this.f13609h) {
                        if ((d9 >= ah.this.f13607f && d9 - ah.this.f13607f > ah.this.f13612k && d9 - ah.this.f13607f <= 180.0d) || (d9 < ah.this.f13607f && ah.this.f13607f > 0.0d && (360.0d - ah.this.f13607f) + d9 > ah.this.f13612k && (360.0d - ah.this.f13607f) + d9 <= 180.0d)) {
                            aa.c(ah.f13598a, "11111发生垂直状态滚动 rollStatus:" + ah.this.f13610i);
                            ah.this.f13610i = 1;
                            ah.this.i();
                            return;
                        }
                        if (d9 < ah.this.f13607f || ((d9 - ah.this.f13607f >= ah.this.f13613l || Math.abs(d9 - ah.this.f13607f) > 180.0d) && (Math.abs(d9 - ah.this.f13607f) < 180.0d || (-(360.0d - Math.abs(d9 - ah.this.f13607f))) >= ah.this.f13613l))) {
                            if (d9 >= ah.this.f13607f) {
                                return;
                            }
                            if ((d9 - ah.this.f13607f >= ah.this.f13613l || Math.abs(d9 - ah.this.f13607f) > 180.0d) && (Math.abs(d9 - ah.this.f13607f) < 180.0d || 360.0d - Math.abs(d9 - ah.this.f13607f) >= ah.this.f13613l)) {
                                return;
                            }
                        }
                        if (ah.this.f13610i == 1) {
                            ah.this.f13610i = 2;
                            aa.a(ah.f13598a, "发生垂直状态回滚");
                            ah.this.i();
                            return;
                        }
                        return;
                    }
                    ah.this.f13607f = d9;
                    ah.this.f13609h = true;
                    ah.this.f13608g = false;
                    return;
                }
                if (ah.this.f13606e != -999.0d && ah.this.f13608g) {
                    if ((d10 >= ah.this.f13606e && d10 - ah.this.f13606e > ah.this.f13612k && d10 - ah.this.f13606e <= 180.0d) || (d10 < ah.this.f13606e && ah.this.f13606e > 0.0d && (360.0d - ah.this.f13606e) + d10 > ah.this.f13612k && (360.0d - ah.this.f13606e) + d10 <= 180.0d)) {
                        aa.c(ah.f13598a, "11111发生水平状态滚动 rollStatus:" + ah.this.f13610i);
                        ah.this.f13610i = 1;
                        ah.this.i();
                        return;
                    }
                    if (d10 < ah.this.f13606e || ((d10 - ah.this.f13606e >= ah.this.f13613l || Math.abs(d10 - ah.this.f13606e) > 180.0d) && (Math.abs(d10 - ah.this.f13606e) < 180.0d || (-(360.0d - Math.abs(d10 - ah.this.f13606e))) >= ah.this.f13613l))) {
                        if (d10 >= ah.this.f13606e) {
                            return;
                        }
                        if ((d10 - ah.this.f13606e >= ah.this.f13613l || Math.abs(d10 - ah.this.f13606e) > 180.0d) && (Math.abs(d10 - ah.this.f13606e) < 180.0d || 360.0d - Math.abs(d10 - ah.this.f13606e) >= ah.this.f13613l)) {
                            return;
                        }
                    }
                    aa.a(ah.f13598a, "2222发生水平状态回滚 rollStatus:" + ah.this.f13610i);
                    if (ah.this.f13610i == 1) {
                        ah.this.f13610i = 2;
                        aa.a(ah.f13598a, "发生水平状态回滚");
                        ah.this.i();
                        return;
                    }
                    return;
                }
                ah.this.f13606e = d10;
                ah.this.f13608g = true;
                ah.this.f13609h = false;
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

        void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        TwistView twistView = this.f13614m;
        if (twistView != null) {
            twistView.updateRollStatus(this.f13610i);
        }
    }

    public ah(Context context) {
        this.f13604b = context;
        f13599c = (SensorManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService(bi.ac);
    }

    public void c() {
        this.f13616s = false;
    }

    public void b() {
        SensorManager sensorManager = f13599c;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this.f13619v);
        }
        TwistView twistView = this.f13614m;
        if (twistView != null) {
            twistView.destroyView();
            this.f13614m = null;
        }
        this.f13616s = false;
        this.f13615r = false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x00d5, code lost:
    
        if (r4 >= 400) goto L48;
     */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00f0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(android.view.ViewGroup r11, int r12, int r13, com.beizi.fusion.model.AdSpacesBean.BuyerBean.RollViewBean r14) {
        /*
            Method dump skipped, instructions count: 493
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.fusion.tool.ah.a(android.view.ViewGroup, int, int, com.beizi.fusion.model.AdSpacesBean$BuyerBean$RollViewBean):void");
    }

    public void b(double d6) {
        this.f13613l = d6;
    }

    public void a() {
        SensorManager sensorManager = f13599c;
        if (sensorManager != null) {
            sensorManager.registerListener(this.f13619v, sensorManager.getDefaultSensor(1), BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH);
        }
    }

    public void a(AdSpacesBean.BuyerBean.RollViewBean rollViewBean) {
        if (rollViewBean == null) {
            return;
        }
        try {
            aa.a(f13598a, "setRollParams getRollTime:" + rollViewBean.getRollTime() + ";getRollPlusAmplitude:" + rollViewBean.getRollPlusAmplitude() + ";getRollMinusAmplitude:" + rollViewBean.getRollMinusAmplitude());
            a(rollViewBean.getRollTime());
            a(rollViewBean.getRollPlusAmplitude());
            b(rollViewBean.getRollMinusAmplitude());
            TwistView twistView = this.f13614m;
            if (twistView != null) {
                twistView.setDurationAnimation(rollViewBean.getRollTime());
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public void a(AdSpacesBean.BuyerBean.CoolRollViewBean coolRollViewBean) {
        if (coolRollViewBean == null) {
            return;
        }
        try {
            aa.a(f13598a, "setRollCoolParams getRollTime:" + coolRollViewBean.getRollTime() + ";getRollPlusAmplitude:" + coolRollViewBean.getRollPlusAmplitude() + ";getRollMinusAmplitude:" + coolRollViewBean.getRollMinusAmplitude());
            a(coolRollViewBean.getRollTime());
            a(coolRollViewBean.getRollPlusAmplitude());
            b(coolRollViewBean.getRollMinusAmplitude());
            TwistView twistView = this.f13614m;
            if (twistView != null) {
                twistView.setDurationAnimation(coolRollViewBean.getRollTime());
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public void a(long j6) {
        this.f13611j = j6;
    }

    public void a(double d6) {
        this.f13612k = d6;
    }

    public void a(a aVar) {
        this.f13617t = aVar;
    }

    public void a(Boolean bool) {
        this.f13618u = bool;
    }
}
