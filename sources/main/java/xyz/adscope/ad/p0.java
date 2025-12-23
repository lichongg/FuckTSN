package xyz.adscope.ad;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import java.util.HashMap;
import java.util.Map;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.render.interaction.InteractionModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.render.interaction.form.ShakeModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.render.interaction.form.par.StatusParamModel;
import xyz.adscope.ad.n3;
import xyz.adscope.ad.p6;
import xyz.adscope.common.v2.tool.str.StringUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public final class p0 extends p6 {

    /* renamed from: l, reason: collision with root package name */
    private final Map<String, p6.c> f55762l;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class b implements p6.c {

        /* renamed from: a, reason: collision with root package name */
        private final int f55763a;

        /* renamed from: b, reason: collision with root package name */
        private final int f55764b;

        /* renamed from: c, reason: collision with root package name */
        private final String f55765c;

        /* renamed from: d, reason: collision with root package name */
        private final double f55766d;

        /* renamed from: e, reason: collision with root package name */
        private final double f55767e;

        /* renamed from: f, reason: collision with root package name */
        private final String f55768f;

        /* renamed from: g, reason: collision with root package name */
        private double f55769g;

        /* renamed from: h, reason: collision with root package name */
        private double f55770h;

        /* renamed from: i, reason: collision with root package name */
        private int f55771i;

        /* renamed from: j, reason: collision with root package name */
        private double f55772j;

        /* renamed from: k, reason: collision with root package name */
        private double f55773k;

        /* renamed from: l, reason: collision with root package name */
        private int f55774l;

        /* renamed from: m, reason: collision with root package name */
        private boolean f55775m;

        /* renamed from: n, reason: collision with root package name */
        private boolean f55776n;

        /* renamed from: o, reason: collision with root package name */
        private long f55777o;

        /* renamed from: p, reason: collision with root package name */
        private int f55778p;

        /* renamed from: q, reason: collision with root package name */
        private int f55779q;

        /* renamed from: r, reason: collision with root package name */
        private double f55780r;

        /* renamed from: s, reason: collision with root package name */
        private c f55781s;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a extends k6 {
            a(int i6, int i7, long j6) {
                super(i6, i7, j6);
            }

            @Override // xyz.adscope.ad.k6
            protected void a(ValueAnimator valueAnimator) {
                if (b.this.f55778p == 1) {
                    b.this.a(((Integer) valueAnimator.getAnimatedValue()).intValue() / 10.0d);
                }
            }

            @Override // xyz.adscope.ad.k6
            protected void b(Animator animator) {
                b.this.f55779q = 0;
                b.this.a();
            }

            @Override // xyz.adscope.ad.k6
            protected void d(Animator animator) {
                b.this.f55779q = 0;
                b.this.a(0.0d);
                b bVar = b.this;
                bVar.a(bVar.f55768f);
            }
        }

        /* synthetic */ b(p0 p0Var, double d6, double d7, int i6, String str, String str2, a aVar) {
            this(d6, d7, i6, str, str2);
        }

        private b(double d6, double d7, int i6, String str, String str2) {
            this.f55763a = 1;
            this.f55775m = false;
            this.f55776n = false;
            this.f55779q = 0;
            this.f55780r = 0.0d;
            this.f55781s = c.SHAKE_STATUS_STANDBY;
            this.f55768f = str2;
            this.f55767e = d6;
            this.f55766d = d7;
            this.f55764b = i6;
            this.f55765c = str;
            this.f55774l = i6;
            this.f55772j = d6;
            this.f55773k = d7;
        }

        private void b(SensorEvent sensorEvent) {
            Sensor sensor;
            float[] fArr;
            if (sensorEvent == null || (sensor = sensorEvent.sensor) == null || sensor.getType() != 1 || (fArr = sensorEvent.values) == null) {
                return;
            }
            float f6 = fArr[0];
            float f7 = fArr[1];
            float f8 = fArr[2];
            double a6 = a(f6, f7, f8, "XYZ");
            double a7 = a(f6, f7, f8, this.f55765c);
            if (a6 < 1.1d || this.f55780r == 0.0d) {
                this.f55780r = Math.min(a7, 1.0d);
            }
            double d6 = a7 - this.f55780r;
            double d7 = this.f55772j - 1.0d;
            double d8 = this.f55773k - 1.0d;
            if (d6 >= d7) {
                this.f55781s = c.SHAKE_STATUS_START;
                return;
            }
            if (d6 > d8 || this.f55781s != c.SHAKE_STATUS_START) {
                return;
            }
            this.f55779q++;
            c();
            this.f55781s = c.SHAKE_STATUS_STANDBY;
            int i6 = this.f55774l;
            if (i6 <= 0 || this.f55779q < i6) {
                return;
            }
            p0.this.h();
        }

        private void c() {
            if (p0.this.f55165e == null || !(p0.this.f55165e instanceof f6)) {
                return;
            }
            ((f6) p0.this.f55165e).setMaxProgress(this.f55774l);
            ((f6) p0.this.f55165e).setProgress(this.f55779q);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(double d6, double d7, int i6) {
            this.f55769g = d6;
            this.f55770h = d7;
            this.f55771i = i6;
            if (i6 <= 0) {
                i6 = this.f55764b;
            }
            this.f55774l = i6;
            if (d6 <= 0.0d) {
                d6 = this.f55767e;
            }
            this.f55772j = d6;
            if (d7 <= 0.0d) {
                d7 = this.f55766d;
            }
            this.f55773k = d7;
            this.f55775m = true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(long j6, int i6) {
            this.f55777o = j6;
            this.f55778p = i6;
        }

        @Override // xyz.adscope.ad.p6.c
        public void a(SensorEvent sensorEvent) {
            if (this.f55775m) {
                b();
            } else {
                a();
            }
            b(sensorEvent);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str) {
            if (p0.this.f55165e == null || !(p0.this.f55165e instanceof c4)) {
                return;
            }
            ((c4) p0.this.f55165e).a(str);
        }

        private void b() {
            if (this.f55776n) {
                return;
            }
            this.f55776n = true;
            long j6 = this.f55777o;
            if (j6 > 0) {
                new a(10, 1, j6).c();
            } else {
                a();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            this.f55772j = this.f55767e;
            this.f55773k = this.f55766d;
            this.f55774l = this.f55764b;
            a("Normal");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(double d6) {
            double d7 = this.f55767e;
            this.f55772j = d7 + ((this.f55769g - d7) * d6);
            double d8 = this.f55766d;
            this.f55773k = d8 + ((this.f55770h - d8) * d6);
            this.f55774l = this.f55771i;
        }

        private double a(float f6, float f7, float f8, String str) {
            String upperCase = str.toUpperCase();
            double pow = upperCase.contains("X") ? 0.0d + Math.pow(f6 / 9.80665f, 2.0d) : 0.0d;
            if (upperCase.contains("Y")) {
                pow += Math.pow(f7 / 9.80665f, 2.0d);
            }
            if (upperCase.contains("Z")) {
                pow += Math.pow(f8 / 9.80665f, 2.0d);
            }
            return Math.sqrt(pow);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    enum c {
        SHAKE_STATUS_START,
        SHAKE_STATUS_STANDBY
    }

    private b a(ShakeModel shakeModel, String str) {
        if (shakeModel == null) {
            return null;
        }
        StatusParamModel d6 = shakeModel.d();
        StatusParamModel c6 = shakeModel.c();
        StatusParamModel b6 = shakeModel.b();
        StatusParamModel a6 = shakeModel.a();
        return new b(this, d6 != null ? StringUtil.parseDouble(a(d6, str)) : -1.0d, c6 != null ? StringUtil.parseDouble(a(c6, str)) : -1.0d, b6 != null ? StringUtil.parseInt(a(b6, str)) : 0, a6 != null ? a(a6, str) : "", str, null);
    }

    private void k() {
        b a6;
        InteractionModel interactionModel = this.f55167g;
        if (interactionModel == null || (a6 = a(interactionModel.j(), "Cooling")) == null) {
            return;
        }
        this.f55762l.put("Cooling", a6);
    }

    private void l() {
        b a6;
        InteractionModel interactionModel = this.f55167g;
        if (interactionModel == null || (a6 = a(interactionModel.j(), "Normal")) == null) {
            return;
        }
        this.f55762l.put("Normal", a6);
    }

    private void m() {
        ShakeModel j6;
        b a6;
        double d6;
        int i6;
        InteractionModel interactionModel = this.f55167g;
        if (interactionModel == null || (a6 = a((j6 = interactionModel.j()), "Passive")) == null) {
            return;
        }
        StatusParamModel d7 = j6.d();
        StatusParamModel c6 = j6.c();
        StatusParamModel b6 = j6.b();
        double parseDoubleOrDefault = d7 != null ? StringUtil.parseDoubleOrDefault(d7.c(), -1.0d) : -1.0d;
        double parseDoubleOrDefault2 = c6 != null ? StringUtil.parseDoubleOrDefault(c6.c(), -1.0d) : -1.0d;
        if (b6 != null) {
            d6 = parseDoubleOrDefault;
            i6 = StringUtil.parseInt(b6.c());
        } else {
            d6 = parseDoubleOrDefault;
            i6 = 0;
        }
        a6.a(d6, parseDoubleOrDefault2, i6);
        a6.a(this.f55167g.g(), this.f55167g.h());
        this.f55762l.put("Passive", a6);
    }

    @Override // xyz.adscope.ad.g1
    protected void d() {
        this.f55762l.clear();
        l();
        m();
        k();
    }

    @Override // xyz.adscope.ad.p6
    protected n3.a e() {
        return n3.a.SHAKE_INTERACTIVE_TRIGGER;
    }

    @Override // xyz.adscope.ad.p6
    protected Sensor f() {
        SensorManager sensorManager = this.f55801i;
        if (sensorManager != null) {
            return sensorManager.getDefaultSensor(1);
        }
        return null;
    }

    @Override // xyz.adscope.ad.p6
    protected p6.c g() {
        if (this.f55167g == null) {
            return null;
        }
        x6 orCreateImplement = e7.a().getOrCreateImplement(this.f55163c);
        return (orCreateImplement.a(this.f55167g.i()) || orCreateImplement.a(this.f55168h, this.f55167g.b())) ? this.f55762l.get("Cooling") : this.f55167g.g() > 0 ? this.f55762l.get("Passive") : this.f55762l.get("Normal");
    }

    @Override // xyz.adscope.ad.p6
    protected void h() {
        this.f55762l.clear();
        super.h();
    }

    public p0(Context context, String str) {
        super(context, str);
        this.f55762l = new HashMap();
    }

    private String a(StatusParamModel statusParamModel, String str) {
        if ("Cooling".equalsIgnoreCase(str)) {
            return statusParamModel.a();
        }
        return statusParamModel.b();
    }
}
