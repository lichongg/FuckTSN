package com.acse.ottn;

import android.view.View;
import android.view.animation.Interpolator;
import com.acse.ottn.i;
import com.acse.ottn.n4;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class t4 extends q4 {

    /* renamed from: o, reason: collision with root package name */
    public static final int f5322o = 0;

    /* renamed from: p, reason: collision with root package name */
    public static final int f5323p = 1;

    /* renamed from: q, reason: collision with root package name */
    public static final int f5324q = 2;

    /* renamed from: r, reason: collision with root package name */
    public static final int f5325r = 4;

    /* renamed from: s, reason: collision with root package name */
    public static final int f5326s = 8;

    /* renamed from: t, reason: collision with root package name */
    public static final int f5327t = 16;

    /* renamed from: u, reason: collision with root package name */
    public static final int f5328u = 32;

    /* renamed from: v, reason: collision with root package name */
    public static final int f5329v = 64;

    /* renamed from: w, reason: collision with root package name */
    public static final int f5330w = 128;

    /* renamed from: x, reason: collision with root package name */
    public static final int f5331x = 256;

    /* renamed from: y, reason: collision with root package name */
    public static final int f5332y = 512;

    /* renamed from: z, reason: collision with root package name */
    public static final int f5333z = 511;

    /* renamed from: b, reason: collision with root package name */
    public final l f5334b;

    /* renamed from: c, reason: collision with root package name */
    public final WeakReference<View> f5335c;

    /* renamed from: d, reason: collision with root package name */
    public long f5336d;

    /* renamed from: h, reason: collision with root package name */
    public Interpolator f5340h;

    /* renamed from: e, reason: collision with root package name */
    public boolean f5337e = false;

    /* renamed from: f, reason: collision with root package name */
    public long f5338f = 0;

    /* renamed from: g, reason: collision with root package name */
    public boolean f5339g = false;

    /* renamed from: i, reason: collision with root package name */
    public boolean f5341i = false;

    /* renamed from: j, reason: collision with root package name */
    public i.a f5342j = null;

    /* renamed from: k, reason: collision with root package name */
    public b f5343k = new b(this, null);

    /* renamed from: l, reason: collision with root package name */
    public ArrayList<c> f5344l = new ArrayList<>();

    /* renamed from: m, reason: collision with root package name */
    public Runnable f5345m = new a();

    /* renamed from: n, reason: collision with root package name */
    public HashMap<i, d> f5346n = new HashMap<>();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            t4.this.e();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class b implements i.a, n4.g {
        public b() {
        }

        @Override // com.acse.ottn.i.a
        public void a(i iVar) {
            if (t4.this.f5342j != null) {
                t4.this.f5342j.a(iVar);
            }
        }

        public /* synthetic */ b(t4 t4Var, a aVar) {
            this();
        }

        @Override // com.acse.ottn.i.a
        public void b(i iVar) {
            if (t4.this.f5342j != null) {
                t4.this.f5342j.b(iVar);
            }
            t4.this.f5346n.remove(iVar);
            if (t4.this.f5346n.isEmpty()) {
                t4.this.f5342j = null;
            }
        }

        @Override // com.acse.ottn.i.a
        public void c(i iVar) {
            if (t4.this.f5342j != null) {
                t4.this.f5342j.c(iVar);
            }
        }

        @Override // com.acse.ottn.i.a
        public void d(i iVar) {
            if (t4.this.f5342j != null) {
                t4.this.f5342j.d(iVar);
            }
        }

        @Override // com.acse.ottn.n4.g
        public void a(n4 n4Var) {
            View view;
            float u5 = n4Var.u();
            d dVar = (d) t4.this.f5346n.get(n4Var);
            if ((dVar.f5352a & 511) != 0 && (view = (View) t4.this.f5335c.get()) != null) {
                view.invalidate();
            }
            ArrayList<c> arrayList = dVar.f5353b;
            if (arrayList != null) {
                int size = arrayList.size();
                for (int i6 = 0; i6 < size; i6++) {
                    c cVar = arrayList.get(i6);
                    t4.this.c(cVar.f5349a, cVar.f5350b + (cVar.f5351c * u5));
                }
            }
            View view2 = (View) t4.this.f5335c.get();
            if (view2 != null) {
                view2.invalidate();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public int f5352a;

        /* renamed from: b, reason: collision with root package name */
        public ArrayList<c> f5353b;

        public boolean a(int i6) {
            ArrayList<c> arrayList;
            if ((this.f5352a & i6) != 0 && (arrayList = this.f5353b) != null) {
                int size = arrayList.size();
                for (int i7 = 0; i7 < size; i7++) {
                    if (this.f5353b.get(i7).f5349a == i6) {
                        this.f5353b.remove(i7);
                        this.f5352a = (~i6) & this.f5352a;
                        return true;
                    }
                }
            }
            return false;
        }

        public d(int i6, ArrayList<c> arrayList) {
            this.f5352a = i6;
            this.f5353b = arrayList;
        }
    }

    @Override // com.acse.ottn.q4
    public q4 e(float f6) {
        a(32, f6);
        return this;
    }

    @Override // com.acse.ottn.q4
    public q4 i(float f6) {
        a(4, f6);
        return this;
    }

    @Override // com.acse.ottn.q4
    public q4 j(float f6) {
        b(4, f6);
        return this;
    }

    @Override // com.acse.ottn.q4
    public q4 m(float f6) {
        a(1, f6);
        return this;
    }

    @Override // com.acse.ottn.q4
    public q4 n(float f6) {
        b(1, f6);
        return this;
    }

    @Override // com.acse.ottn.q4
    public q4 o(float f6) {
        a(2, f6);
        return this;
    }

    @Override // com.acse.ottn.q4
    public q4 p(float f6) {
        b(2, f6);
        return this;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public int f5349a;

        /* renamed from: b, reason: collision with root package name */
        public float f5350b;

        /* renamed from: c, reason: collision with root package name */
        public float f5351c;

        public c(int i6, float f6, float f7) {
            this.f5349a = i6;
            this.f5350b = f6;
            this.f5351c = f7;
        }
    }

    @Override // com.acse.ottn.q4
    public long b() {
        return this.f5337e ? this.f5336d : new n4().c();
    }

    @Override // com.acse.ottn.q4
    public long c() {
        if (this.f5339g) {
            return this.f5338f;
        }
        return 0L;
    }

    @Override // com.acse.ottn.q4
    public void d() {
        e();
    }

    public final void e() {
        n4 a6 = n4.a(1.0f);
        ArrayList arrayList = (ArrayList) this.f5344l.clone();
        this.f5344l.clear();
        int size = arrayList.size();
        int i6 = 0;
        for (int i7 = 0; i7 < size; i7++) {
            i6 |= ((c) arrayList.get(i7)).f5349a;
        }
        this.f5346n.put(a6, new d(i6, arrayList));
        a6.a((n4.g) this.f5343k);
        a6.a((i.a) this.f5343k);
        if (this.f5339g) {
            a6.b(this.f5338f);
        }
        if (this.f5337e) {
            a6.a(this.f5336d);
        }
        if (this.f5341i) {
            a6.a(this.f5340h);
        }
        a6.k();
    }

    @Override // com.acse.ottn.q4
    public q4 f(float f6) {
        b(32, f6);
        return this;
    }

    @Override // com.acse.ottn.q4
    public q4 g(float f6) {
        a(64, f6);
        return this;
    }

    @Override // com.acse.ottn.q4
    public q4 h(float f6) {
        b(64, f6);
        return this;
    }

    @Override // com.acse.ottn.q4
    public q4 k(float f6) {
        a(8, f6);
        return this;
    }

    @Override // com.acse.ottn.q4
    public q4 l(float f6) {
        b(8, f6);
        return this;
    }

    @Override // com.acse.ottn.q4
    public q4 q(float f6) {
        a(128, f6);
        return this;
    }

    @Override // com.acse.ottn.q4
    public q4 r(float f6) {
        b(128, f6);
        return this;
    }

    @Override // com.acse.ottn.q4
    public q4 s(float f6) {
        a(256, f6);
        return this;
    }

    @Override // com.acse.ottn.q4
    public q4 t(float f6) {
        b(256, f6);
        return this;
    }

    public t4(View view) {
        this.f5335c = new WeakReference<>(view);
        this.f5334b = l.a(view);
    }

    @Override // com.acse.ottn.q4
    public q4 d(float f6) {
        b(16, f6);
        return this;
    }

    @Override // com.acse.ottn.q4
    public q4 a(long j6) {
        if (j6 >= 0) {
            this.f5337e = true;
            this.f5336d = j6;
            return this;
        }
        throw new IllegalArgumentException("Animators cannot have negative duration: " + j6);
    }

    @Override // com.acse.ottn.q4
    public q4 c(float f6) {
        a(16, f6);
        return this;
    }

    @Override // com.acse.ottn.q4
    public q4 b(long j6) {
        if (j6 >= 0) {
            this.f5339g = true;
            this.f5338f = j6;
            return this;
        }
        throw new IllegalArgumentException("Animators cannot have negative duration: " + j6);
    }

    public final void c(int i6, float f6) {
        if (i6 == 1) {
            this.f5334b.i(f6);
            return;
        }
        if (i6 == 2) {
            this.f5334b.j(f6);
            return;
        }
        if (i6 == 4) {
            this.f5334b.g(f6);
            return;
        }
        if (i6 == 8) {
            this.f5334b.h(f6);
            return;
        }
        if (i6 == 16) {
            this.f5334b.d(f6);
            return;
        }
        if (i6 == 32) {
            this.f5334b.e(f6);
            return;
        }
        if (i6 == 64) {
            this.f5334b.f(f6);
            return;
        }
        if (i6 == 128) {
            this.f5334b.k(f6);
        } else if (i6 == 256) {
            this.f5334b.l(f6);
        } else {
            if (i6 != 512) {
                return;
            }
            this.f5334b.a(f6);
        }
    }

    @Override // com.acse.ottn.q4
    public q4 a(Interpolator interpolator) {
        this.f5341i = true;
        this.f5340h = interpolator;
        return this;
    }

    @Override // com.acse.ottn.q4
    public q4 b(float f6) {
        b(512, f6);
        return this;
    }

    @Override // com.acse.ottn.q4
    public q4 a(i.a aVar) {
        this.f5342j = aVar;
        return this;
    }

    public final void b(int i6, float f6) {
        a(i6, a(i6), f6);
    }

    @Override // com.acse.ottn.q4
    public void a() {
        if (this.f5346n.size() > 0) {
            Iterator it = ((HashMap) this.f5346n.clone()).keySet().iterator();
            while (it.hasNext()) {
                ((i) it.next()).cancel();
            }
        }
        this.f5344l.clear();
        View view = this.f5335c.get();
        if (view != null) {
            view.removeCallbacks(this.f5345m);
        }
    }

    @Override // com.acse.ottn.q4
    public q4 a(float f6) {
        a(512, f6);
        return this;
    }

    public final void a(int i6, float f6) {
        float a6 = a(i6);
        a(i6, a6, f6 - a6);
    }

    public final void a(int i6, float f6, float f7) {
        i iVar;
        if (this.f5346n.size() > 0) {
            Iterator<i> it = this.f5346n.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    iVar = null;
                    break;
                }
                iVar = it.next();
                d dVar = this.f5346n.get(iVar);
                if (dVar.a(i6) && dVar.f5352a == 0) {
                    break;
                }
            }
            if (iVar != null) {
                iVar.cancel();
            }
        }
        this.f5344l.add(new c(i6, f6, f7));
        View view = this.f5335c.get();
        if (view != null) {
            view.removeCallbacks(this.f5345m);
            view.post(this.f5345m);
        }
    }

    public final float a(int i6) {
        if (i6 == 1) {
            return this.f5334b.k();
        }
        if (i6 == 2) {
            return this.f5334b.l();
        }
        if (i6 == 4) {
            return this.f5334b.g();
        }
        if (i6 == 8) {
            return this.f5334b.h();
        }
        if (i6 == 16) {
            return this.f5334b.d();
        }
        if (i6 == 32) {
            return this.f5334b.e();
        }
        if (i6 == 64) {
            return this.f5334b.f();
        }
        if (i6 == 128) {
            return this.f5334b.m();
        }
        if (i6 == 256) {
            return this.f5334b.n();
        }
        if (i6 != 512) {
            return 0.0f;
        }
        return this.f5334b.a();
    }
}
