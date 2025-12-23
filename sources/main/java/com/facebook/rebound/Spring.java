package com.facebook.rebound;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class Spring {

    /* renamed from: o, reason: collision with root package name */
    private static int f32471o = 0;

    /* renamed from: p, reason: collision with root package name */
    private static final double f32472p = 0.064d;

    /* renamed from: q, reason: collision with root package name */
    private static final double f32473q = 0.001d;

    /* renamed from: a, reason: collision with root package name */
    private SpringConfig f32474a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f32475b;

    /* renamed from: c, reason: collision with root package name */
    private final String f32476c;

    /* renamed from: d, reason: collision with root package name */
    private final PhysicsState f32477d;

    /* renamed from: e, reason: collision with root package name */
    private final PhysicsState f32478e;

    /* renamed from: f, reason: collision with root package name */
    private final PhysicsState f32479f;

    /* renamed from: g, reason: collision with root package name */
    private double f32480g;

    /* renamed from: h, reason: collision with root package name */
    private double f32481h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f32482i = true;

    /* renamed from: j, reason: collision with root package name */
    private double f32483j = 0.005d;

    /* renamed from: k, reason: collision with root package name */
    private double f32484k = 0.005d;

    /* renamed from: l, reason: collision with root package name */
    private CopyOnWriteArraySet<SpringListener> f32485l = new CopyOnWriteArraySet<>();

    /* renamed from: m, reason: collision with root package name */
    private double f32486m = 0.0d;

    /* renamed from: n, reason: collision with root package name */
    private final BaseSpringSystem f32487n;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.facebook.rebound.Spring$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class PhysicsState {

        /* renamed from: a, reason: collision with root package name */
        double f32488a;

        /* renamed from: b, reason: collision with root package name */
        double f32489b;

        private PhysicsState() {
        }

        /* synthetic */ PhysicsState(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public Spring v(double d6) {
        return w(d6, true);
    }

    private double g(PhysicsState physicsState) {
        return Math.abs(this.f32481h - physicsState.f32488a);
    }

    private void o(double d6) {
        PhysicsState physicsState = this.f32477d;
        double d7 = physicsState.f32488a * d6;
        PhysicsState physicsState2 = this.f32478e;
        double d8 = 1.0d - d6;
        physicsState.f32488a = d7 + (physicsState2.f32488a * d8);
        physicsState.f32489b = (physicsState.f32489b * d6) + (physicsState2.f32489b * d8);
    }

    public Spring A(double d6) {
        this.f32483j = d6;
        return this;
    }

    public Spring B(SpringConfig springConfig) {
        if (springConfig == null) {
            throw new IllegalArgumentException("springConfig is required");
        }
        this.f32474a = springConfig;
        return this;
    }

    public Spring C(double d6) {
        PhysicsState physicsState = this.f32477d;
        if (d6 == physicsState.f32489b) {
            return this;
        }
        physicsState.f32489b = d6;
        this.f32487n.a(i());
        return this;
    }

    public boolean E() {
        return this.f32482i;
    }

    public Spring a(SpringListener springListener) {
        if (springListener == null) {
            throw new IllegalArgumentException("newListener is required");
        }
        this.f32485l.add(springListener);
        return this;
    }

    void b(double d6) {
        double d7;
        boolean z5;
        boolean z6;
        boolean p5 = p();
        if (p5 && this.f32482i) {
            return;
        }
        double d8 = f32472p;
        if (d6 <= f32472p) {
            d8 = d6;
        }
        this.f32486m += d8;
        SpringConfig springConfig = this.f32474a;
        double d9 = springConfig.f32504b;
        double d10 = springConfig.f32503a;
        PhysicsState physicsState = this.f32477d;
        double d11 = physicsState.f32488a;
        double d12 = physicsState.f32489b;
        PhysicsState physicsState2 = this.f32479f;
        double d13 = physicsState2.f32488a;
        double d14 = physicsState2.f32489b;
        while (true) {
            d7 = this.f32486m;
            if (d7 < f32473q) {
                break;
            }
            double d15 = d7 - f32473q;
            this.f32486m = d15;
            if (d15 < f32473q) {
                PhysicsState physicsState3 = this.f32478e;
                physicsState3.f32488a = d11;
                physicsState3.f32489b = d12;
            }
            double d16 = this.f32481h;
            double d17 = ((d16 - d13) * d9) - (d10 * d12);
            double d18 = (d12 * f32473q * 0.5d) + d11;
            double d19 = d12 + (d17 * f32473q * 0.5d);
            double d20 = ((d16 - d18) * d9) - (d10 * d19);
            double d21 = d11 + (d19 * f32473q * 0.5d);
            double d22 = d12 + (d20 * f32473q * 0.5d);
            double d23 = ((d16 - d21) * d9) - (d10 * d22);
            double d24 = d11 + (d22 * f32473q);
            double d25 = d12 + (d23 * f32473q);
            d11 += (d12 + ((d19 + d22) * 2.0d) + d25) * 0.16666666666666666d * f32473q;
            d12 += (d17 + ((d20 + d23) * 2.0d) + (((d16 - d24) * d9) - (d10 * d25))) * 0.16666666666666666d * f32473q;
            d13 = d24;
            d14 = d25;
        }
        PhysicsState physicsState4 = this.f32479f;
        physicsState4.f32488a = d13;
        physicsState4.f32489b = d14;
        PhysicsState physicsState5 = this.f32477d;
        physicsState5.f32488a = d11;
        physicsState5.f32489b = d12;
        if (d7 > 0.0d) {
            o(d7 / f32473q);
        }
        boolean z7 = true;
        if (p() || (this.f32475b && r())) {
            if (d9 > 0.0d) {
                double d26 = this.f32481h;
                this.f32480g = d26;
                this.f32477d.f32488a = d26;
            } else {
                double d27 = this.f32477d.f32488a;
                this.f32481h = d27;
                this.f32480g = d27;
            }
            C(0.0d);
            z5 = true;
        } else {
            z5 = p5;
        }
        if (this.f32482i) {
            this.f32482i = false;
            z6 = true;
        } else {
            z6 = false;
        }
        if (z5) {
            this.f32482i = true;
        } else {
            z7 = false;
        }
        Iterator<SpringListener> it = this.f32485l.iterator();
        while (it.hasNext()) {
            SpringListener next = it.next();
            if (z6) {
                next.onSpringActivate(this);
            }
            next.onSpringUpdate(this);
            if (z7) {
                next.onSpringAtRest(this);
            }
        }
    }

    public void d() {
        this.f32485l.clear();
        this.f32487n.e(this);
    }

    public double e() {
        return g(this.f32477d);
    }

    public double f() {
        return this.f32477d.f32488a;
    }

    public double h() {
        return this.f32481h;
    }

    public String i() {
        return this.f32476c;
    }

    public double j() {
        return this.f32484k;
    }

    public double k() {
        return this.f32483j;
    }

    public SpringConfig l() {
        return this.f32474a;
    }

    public double m() {
        return this.f32480g;
    }

    public double n() {
        return this.f32477d.f32489b;
    }

    public boolean p() {
        if (Math.abs(this.f32477d.f32489b) <= this.f32483j) {
            return g(this.f32477d) <= this.f32484k || this.f32474a.f32504b == 0.0d;
        }
        return false;
    }

    public boolean q() {
        return this.f32475b;
    }

    public boolean r() {
        if (this.f32474a.f32504b <= 0.0d) {
            return false;
        }
        if (this.f32480g >= this.f32481h || f() <= this.f32481h) {
            return this.f32480g > this.f32481h && f() < this.f32481h;
        }
        return true;
    }

    public Spring s() {
        this.f32485l.clear();
        return this;
    }

    public Spring t(SpringListener springListener) {
        if (springListener == null) {
            throw new IllegalArgumentException("listenerToRemove is required");
        }
        this.f32485l.remove(springListener);
        return this;
    }

    public Spring u() {
        PhysicsState physicsState = this.f32477d;
        double d6 = physicsState.f32488a;
        this.f32481h = d6;
        this.f32479f.f32488a = d6;
        physicsState.f32489b = 0.0d;
        return this;
    }

    public Spring w(double d6, boolean z5) {
        this.f32480g = d6;
        this.f32477d.f32488a = d6;
        this.f32487n.a(i());
        Iterator<SpringListener> it = this.f32485l.iterator();
        while (it.hasNext()) {
            it.next().onSpringUpdate(this);
        }
        if (z5) {
            u();
        }
        return this;
    }

    public Spring x(double d6) {
        if (this.f32481h != d6 || !p()) {
            this.f32480g = f();
            this.f32481h = d6;
            this.f32487n.a(i());
            Iterator<SpringListener> it = this.f32485l.iterator();
            while (it.hasNext()) {
                it.next().onSpringEndStateChange(this);
            }
        }
        return this;
    }

    public Spring y(boolean z5) {
        this.f32475b = z5;
        return this;
    }

    public Spring z(double d6) {
        this.f32484k = d6;
        return this;
    }

    Spring(BaseSpringSystem baseSpringSystem) {
        AnonymousClass1 anonymousClass1 = null;
        this.f32477d = new PhysicsState(anonymousClass1);
        this.f32478e = new PhysicsState(anonymousClass1);
        this.f32479f = new PhysicsState(anonymousClass1);
        if (baseSpringSystem != null) {
            this.f32487n = baseSpringSystem;
            StringBuilder sb = new StringBuilder();
            sb.append("spring:");
            int i6 = f32471o;
            f32471o = i6 + 1;
            sb.append(i6);
            this.f32476c = sb.toString();
            B(SpringConfig.f32502c);
            return;
        }
        throw new IllegalArgumentException("Spring cannot be created outside of a BaseSpringSystem");
    }

    public boolean D() {
        if (p() && E()) {
            return false;
        }
        return true;
    }

    public boolean c(double d6) {
        if (Math.abs(f() - d6) <= j()) {
            return true;
        }
        return false;
    }
}
