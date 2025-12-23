package xyz.adscope.ad;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.render.interaction.InteractionModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.render.interaction.form.EulerAngleModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.render.interaction.form.axis.AxisModel;
import xyz.adscope.ad.n3;
import xyz.adscope.ad.p6;
import xyz.adscope.common.v2.tool.str.StringUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public final class q1 extends p6 {

    /* renamed from: l, reason: collision with root package name */
    private final Map<String, p6.c> f55874l;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class b {

        /* renamed from: a, reason: collision with root package name */
        private final double f55875a;

        /* renamed from: b, reason: collision with root package name */
        private final String f55876b;

        /* renamed from: c, reason: collision with root package name */
        private double f55877c;

        /* synthetic */ b(String str, String str2, a aVar) {
            this(str, str2);
        }

        private b(String str, String str2) {
            this.f55875a = StringUtil.parseDouble(str);
            this.f55876b = str2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str) {
            double parseDouble = StringUtil.parseDouble(str);
            if (parseDouble <= 0.0d) {
                parseDouble = this.f55875a;
            }
            this.f55877c = parseDouble;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class c implements p6.c {

        /* renamed from: a, reason: collision with root package name */
        private final int f55878a;

        /* renamed from: b, reason: collision with root package name */
        private final b f55879b;

        /* renamed from: c, reason: collision with root package name */
        private final b f55880c;

        /* renamed from: d, reason: collision with root package name */
        private final b f55881d;

        /* renamed from: e, reason: collision with root package name */
        private final String f55882e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f55883f;

        /* renamed from: g, reason: collision with root package name */
        private long f55884g;

        /* renamed from: h, reason: collision with root package name */
        private int f55885h;

        /* renamed from: i, reason: collision with root package name */
        private boolean f55886i;

        /* renamed from: j, reason: collision with root package name */
        private boolean f55887j;

        /* renamed from: k, reason: collision with root package name */
        private long f55888k;

        /* renamed from: l, reason: collision with root package name */
        private double f55889l;

        /* renamed from: m, reason: collision with root package name */
        private double f55890m;

        /* renamed from: n, reason: collision with root package name */
        private double f55891n;

        /* renamed from: o, reason: collision with root package name */
        private float f55892o;

        /* renamed from: p, reason: collision with root package name */
        private float f55893p;

        /* renamed from: q, reason: collision with root package name */
        private float f55894q;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a extends k6 {
            a(int i6, int i7, long j6) {
                super(i6, i7, j6);
            }

            @Override // xyz.adscope.ad.k6
            protected void a(ValueAnimator valueAnimator) {
                if (c.this.f55885h == 1) {
                    c.this.a(((Integer) valueAnimator.getAnimatedValue()).intValue() / 10.0d);
                }
            }

            @Override // xyz.adscope.ad.k6
            protected void b(Animator animator) {
                c.this.a();
            }

            @Override // xyz.adscope.ad.k6
            protected void d(Animator animator) {
                c.this.a(0.0d);
                c cVar = c.this;
                cVar.a(cVar.f55882e);
            }
        }

        /* synthetic */ c(q1 q1Var, String str, String str2, String str3, String str4, String str5, String str6, String str7, a aVar) {
            this(str, str2, str3, str4, str5, str6, str7);
        }

        private c(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
            this.f55878a = 1;
            this.f55883f = false;
            this.f55886i = false;
            this.f55887j = false;
            this.f55888k = 0L;
            this.f55892o = 0.0f;
            this.f55893p = 0.0f;
            this.f55894q = 0.0f;
            a aVar = null;
            this.f55879b = new b(str, str2, aVar);
            this.f55880c = new b(str3, str4, aVar);
            this.f55881d = new b(str5, str6, aVar);
            this.f55882e = str7;
        }

        private void b(SensorEvent sensorEvent) {
            Sensor sensor;
            float[] fArr;
            if (sensorEvent == null || (sensor = sensorEvent.sensor) == null || sensor.getType() != 4 || (fArr = sensorEvent.values) == null) {
                return;
            }
            if (this.f55888k != 0) {
                float f6 = fArr[0];
                float f7 = fArr[1];
                float f8 = fArr[2];
                float f9 = (sensorEvent.timestamp - r1) * 1.0E-9f;
                this.f55892o += (float) Math.toDegrees(f6 * f9);
                this.f55893p += (float) Math.toDegrees(f7 * f9);
                float degrees = this.f55894q + ((float) Math.toDegrees(f8 * f9));
                this.f55894q = degrees;
                a(this.f55892o, this.f55893p, degrees);
                if (a(this.f55889l, this.f55892o, this.f55879b.f55876b) || a(this.f55890m, this.f55893p, this.f55880c.f55876b) || a(this.f55891n, this.f55894q, this.f55881d.f55876b)) {
                    this.f55887j = false;
                    q1.this.h();
                }
            }
            this.f55888k = sensorEvent.timestamp;
        }

        @Override // xyz.adscope.ad.p6.c
        public void a(SensorEvent sensorEvent) {
            if (this.f55886i) {
                b();
            } else {
                a();
            }
            if (!this.f55887j) {
                this.f55887j = true;
                a(this.f55879b.f55876b, this.f55880c.f55876b, this.f55881d.f55876b);
            }
            b(sensorEvent);
        }

        private boolean a(double d6, float f6, String str) {
            if (d6 > 0.0d) {
                if ("2".equals(str)) {
                    return f6 > 0.0f && ((double) Math.abs(f6)) >= d6;
                }
                if ("1".equals(str)) {
                    return f6 < 0.0f && ((double) Math.abs(f6)) >= d6;
                }
                if ("0".equals(str) && Math.abs(f6) >= d6) {
                    return true;
                }
            }
            return false;
        }

        private void b() {
            if (this.f55883f) {
                return;
            }
            this.f55883f = true;
            long j6 = this.f55884g;
            if (j6 > 0) {
                new a(10, 1, j6).c();
            } else {
                a();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(long j6, int i6) {
            this.f55884g = j6;
            this.f55885h = i6;
            this.f55886i = true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str, String str2) {
            if ("X".equals(str)) {
                this.f55879b.a(str2);
            }
            if ("Y".equals(str)) {
                this.f55880c.a(str2);
            }
            if ("Z".equals(str)) {
                this.f55881d.a(str2);
            }
        }

        private void a(float f6, float f7, float f8) {
            if (q1.this.f55165e == null || !(q1.this.f55165e instanceof w5)) {
                return;
            }
            double[] dArr = {a(this.f55889l, f6, this.f55879b.f55876b, false), a(this.f55890m, f7, this.f55880c.f55876b, true), a(this.f55891n, f8, this.f55881d.f55876b, false)};
            Arrays.sort(dArr);
            ((w5) q1.this.f55165e).setCurrentProgress(dArr[2]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str) {
            if (q1.this.f55165e == null || !(q1.this.f55165e instanceof c4)) {
                return;
            }
            ((c4) q1.this.f55165e).a(str);
        }

        private void a(String str, String str2, String str3) {
            if (q1.this.f55165e == null || !(q1.this.f55165e instanceof w5)) {
                return;
            }
            ((w5) q1.this.f55165e).b(str, str2, str3);
        }

        private double a(double d6, float f6, String str, boolean z5) {
            if (d6 <= 0.0d || ((!"2".equals(str) || (!z5 ? f6 > 0.0f : f6 < 0.0f)) && ((!"1".equals(str) || (!z5 ? f6 < 0.0f : f6 > 0.0f)) && !"0".equals(str)))) {
                return 0.0d;
            }
            return (Math.abs(f6) * 100.0f) / d6;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            this.f55889l = this.f55879b.f55875a;
            this.f55890m = this.f55880c.f55875a;
            this.f55891n = this.f55881d.f55875a;
            this.f55892o = 0.0f;
            this.f55893p = 0.0f;
            this.f55894q = 0.0f;
            a("Normal");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(double d6) {
            this.f55889l = this.f55879b.f55875a + ((this.f55879b.f55877c - this.f55879b.f55875a) * d6);
            this.f55890m = this.f55880c.f55875a + ((this.f55880c.f55877c - this.f55880c.f55875a) * d6);
            this.f55891n = this.f55881d.f55875a + ((this.f55881d.f55877c - this.f55881d.f55875a) * d6);
        }
    }

    private c a(EulerAngleModel eulerAngleModel, String str) {
        if (eulerAngleModel == null) {
            return null;
        }
        AxisModel a6 = eulerAngleModel.a();
        AxisModel b6 = eulerAngleModel.b();
        AxisModel c6 = eulerAngleModel.c();
        return "Cooling".equalsIgnoreCase(str) ? new c(this, a(a6, str), b(a6, str), a(b6, str), b(b6, str), a(c6, str), b(c6, str), str, null) : new c(this, a(a6, "Normal"), b(a6, "Normal"), a(b6, "Normal"), b(b6, "Normal"), a(c6, "Normal"), b(c6, "Normal"), str, null);
    }

    private String b(AxisModel axisModel, String str) {
        return (axisModel == null || axisModel.b() == null) ? "" : "Cooling".equalsIgnoreCase(str) ? axisModel.b().a() : axisModel.b().b();
    }

    private void k() {
        c a6;
        InteractionModel interactionModel = this.f55167g;
        if (interactionModel == null || (a6 = a(interactionModel.d(), "Cooling")) == null) {
            return;
        }
        this.f55874l.put("Cooling", a6);
    }

    private void l() {
        c a6;
        InteractionModel interactionModel = this.f55167g;
        if (interactionModel == null || (a6 = a(interactionModel.d(), "Normal")) == null) {
            return;
        }
        this.f55874l.put("Normal", a6);
    }

    private void m() {
        c a6;
        InteractionModel interactionModel = this.f55167g;
        if (interactionModel == null || (a6 = a(interactionModel.d(), "Passive")) == null) {
            return;
        }
        EulerAngleModel d6 = this.f55167g.d();
        AxisModel a7 = d6.a();
        AxisModel b6 = d6.b();
        AxisModel c6 = d6.c();
        a6.a("X", a(a7, "Passive"));
        a6.a("Y", a(b6, "Passive"));
        a6.a("Z", a(c6, "Passive"));
        a6.a(this.f55167g.g(), this.f55167g.h());
        this.f55874l.put("Passive", a6);
    }

    @Override // xyz.adscope.ad.g1
    protected void d() {
        this.f55874l.clear();
        l();
        m();
        k();
    }

    @Override // xyz.adscope.ad.p6
    protected n3.a e() {
        return n3.a.EULER_INTERACTIVE_TRIGGER;
    }

    @Override // xyz.adscope.ad.p6
    protected Sensor f() {
        SensorManager sensorManager = this.f55801i;
        if (sensorManager != null) {
            return sensorManager.getDefaultSensor(4);
        }
        return null;
    }

    @Override // xyz.adscope.ad.p6
    protected p6.c g() {
        if (this.f55167g == null) {
            return null;
        }
        x6 orCreateImplement = e7.a().getOrCreateImplement(this.f55163c);
        return (orCreateImplement.a(this.f55167g.i()) || orCreateImplement.a(this.f55168h, this.f55167g.b())) ? this.f55874l.get("Cooling") : this.f55167g.g() > 0 ? this.f55874l.get("Passive") : this.f55874l.get("Normal");
    }

    @Override // xyz.adscope.ad.p6
    protected void h() {
        this.f55874l.clear();
        super.h();
    }

    public q1(Context context, String str) {
        super(context, str);
        this.f55874l = new HashMap();
    }

    private String a(AxisModel axisModel, String str) {
        if (axisModel != null && axisModel.a() != null) {
            if ("Cooling".equalsIgnoreCase(str)) {
                return axisModel.a().a();
            }
            if ("Normal".equalsIgnoreCase(str)) {
                return axisModel.a().b();
            }
            return axisModel.a().c();
        }
        return "";
    }
}
