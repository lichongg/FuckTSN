package com.bxkj.student.run.app.step.accelerometer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class a implements b {

    /* renamed from: c, reason: collision with root package name */
    private d f20049c;

    /* renamed from: f, reason: collision with root package name */
    private c f20052f;

    /* renamed from: a, reason: collision with root package name */
    private int f20047a = 0;

    /* renamed from: b, reason: collision with root package name */
    private int f20048b = 0;

    /* renamed from: d, reason: collision with root package name */
    private long f20050d = 0;

    /* renamed from: e, reason: collision with root package name */
    private long f20051e = 0;

    /* renamed from: g, reason: collision with root package name */
    private boolean f20053g = false;

    @Override // com.bxkj.student.run.app.step.accelerometer.b
    public void a() {
        this.f20050d = this.f20051e;
        long currentTimeMillis = System.currentTimeMillis();
        this.f20051e = currentTimeMillis;
        if (currentTimeMillis - this.f20050d > 3000) {
            this.f20047a = 1;
            return;
        }
        int i6 = this.f20047a;
        if (i6 < 9) {
            this.f20047a = i6 + 1;
            return;
        }
        if (i6 != 9) {
            if (!this.f20053g) {
                this.f20048b++;
            }
            d();
        } else {
            int i7 = i6 + 1;
            this.f20047a = i7;
            if (!this.f20053g) {
                this.f20048b += i7;
            }
            d();
        }
    }

    public c b() {
        return this.f20052f;
    }

    public void c(d listener) {
        this.f20049c = listener;
    }

    public void d() {
        d dVar = this.f20049c;
        if (dVar != null) {
            dVar.a(this.f20048b);
        }
    }

    public a e(boolean pause) {
        this.f20053g = pause;
        return this;
    }

    public void f(int initValue) {
        this.f20048b = initValue;
        this.f20047a = 0;
        this.f20050d = 0L;
        this.f20051e = 0L;
        d();
    }

    public a() {
        c cVar = new c();
        this.f20052f = cVar;
        cVar.d(this);
    }
}
