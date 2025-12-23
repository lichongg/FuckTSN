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
public class r4 extends q4 {

    /* renamed from: n, reason: collision with root package name */
    public static final int f5032n = 0;

    /* renamed from: o, reason: collision with root package name */
    public static final int f5033o = 1;

    /* renamed from: p, reason: collision with root package name */
    public static final int f5034p = 2;

    /* renamed from: q, reason: collision with root package name */
    public static final int f5035q = 4;

    /* renamed from: r, reason: collision with root package name */
    public static final int f5036r = 8;

    /* renamed from: s, reason: collision with root package name */
    public static final int f5037s = 16;

    /* renamed from: t, reason: collision with root package name */
    public static final int f5038t = 32;

    /* renamed from: u, reason: collision with root package name */
    public static final int f5039u = 64;

    /* renamed from: v, reason: collision with root package name */
    public static final int f5040v = 128;

    /* renamed from: w, reason: collision with root package name */
    public static final int f5041w = 256;

    /* renamed from: x, reason: collision with root package name */
    public static final int f5042x = 512;

    /* renamed from: y, reason: collision with root package name */
    public static final int f5043y = 511;

    /* renamed from: b, reason: collision with root package name */
    public final WeakReference<View> f5044b;

    /* renamed from: c, reason: collision with root package name */
    public long f5045c;

    /* renamed from: g, reason: collision with root package name */
    public Interpolator f5049g;

    /* renamed from: d, reason: collision with root package name */
    public boolean f5046d = false;

    /* renamed from: e, reason: collision with root package name */
    public long f5047e = 0;

    /* renamed from: f, reason: collision with root package name */
    public boolean f5048f = false;

    /* renamed from: h, reason: collision with root package name */
    public boolean f5050h = false;

    /* renamed from: i, reason: collision with root package name */
    public i.a f5051i = null;

    /* renamed from: j, reason: collision with root package name */
    public b f5052j = new b(this, null);

    /* renamed from: k, reason: collision with root package name */
    public ArrayList<c> f5053k = new ArrayList<>();

    /* renamed from: l, reason: collision with root package name */
    public Runnable f5054l = new a();

    /* renamed from: m, reason: collision with root package name */
    public HashMap<i, d> f5055m = new HashMap<>();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            r4.this.e();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class b implements i.a, n4.g {
        public b() {
        }

        @Override // com.acse.ottn.i.a
        public void a(i iVar) {
            if (r4.this.f5051i != null) {
                r4.this.f5051i.a(iVar);
            }
        }

        public /* synthetic */ b(r4 r4Var, a aVar) {
            this();
        }

        @Override // com.acse.ottn.i.a
        public void b(i iVar) {
            if (r4.this.f5051i != null) {
                r4.this.f5051i.b(iVar);
            }
            r4.this.f5055m.remove(iVar);
            if (r4.this.f5055m.isEmpty()) {
                r4.this.f5051i = null;
            }
        }

        @Override // com.acse.ottn.i.a
        public void c(i iVar) {
            if (r4.this.f5051i != null) {
                r4.this.f5051i.c(iVar);
            }
        }

        @Override // com.acse.ottn.i.a
        public void d(i iVar) {
            if (r4.this.f5051i != null) {
                r4.this.f5051i.d(iVar);
            }
        }

        @Override // com.acse.ottn.n4.g
        public void a(n4 n4Var) {
            View view;
            float u5 = n4Var.u();
            d dVar = (d) r4.this.f5055m.get(n4Var);
            if ((dVar.f5061a & 511) != 0 && (view = (View) r4.this.f5044b.get()) != null) {
                view.invalidate();
            }
            ArrayList<c> arrayList = dVar.f5062b;
            if (arrayList != null) {
                int size = arrayList.size();
                for (int i6 = 0; i6 < size; i6++) {
                    c cVar = arrayList.get(i6);
                    r4.this.c(cVar.f5058a, cVar.f5059b + (cVar.f5060c * u5));
                }
            }
            View view2 = (View) r4.this.f5044b.get();
            if (view2 != null) {
                view2.invalidate();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public int f5061a;

        /* renamed from: b, reason: collision with root package name */
        public ArrayList<c> f5062b;

        public boolean a(int i6) {
            ArrayList<c> arrayList;
            if ((this.f5061a & i6) != 0 && (arrayList = this.f5062b) != null) {
                int size = arrayList.size();
                for (int i7 = 0; i7 < size; i7++) {
                    if (this.f5062b.get(i7).f5058a == i6) {
                        this.f5062b.remove(i7);
                        this.f5061a = (~i6) & this.f5061a;
                        return true;
                    }
                }
            }
            return false;
        }

        public d(int i6, ArrayList<c> arrayList) {
            this.f5061a = i6;
            this.f5062b = arrayList;
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
        public int f5058a;

        /* renamed from: b, reason: collision with root package name */
        public float f5059b;

        /* renamed from: c, reason: collision with root package name */
        public float f5060c;

        public c(int i6, float f6, float f7) {
            this.f5058a = i6;
            this.f5059b = f6;
            this.f5060c = f7;
        }
    }

    @Override // com.acse.ottn.q4
    public long b() {
        return this.f5046d ? this.f5045c : new n4().c();
    }

    @Override // com.acse.ottn.q4
    public long c() {
        if (this.f5048f) {
            return this.f5047e;
        }
        return 0L;
    }

    @Override // com.acse.ottn.q4
    public void d() {
        e();
    }

    public final void e() {
        n4 a6 = n4.a(1.0f);
        ArrayList arrayList = (ArrayList) this.f5053k.clone();
        this.f5053k.clear();
        int size = arrayList.size();
        int i6 = 0;
        for (int i7 = 0; i7 < size; i7++) {
            i6 |= ((c) arrayList.get(i7)).f5058a;
        }
        this.f5055m.put(a6, new d(i6, arrayList));
        a6.a((n4.g) this.f5052j);
        a6.a((i.a) this.f5052j);
        if (this.f5048f) {
            a6.b(this.f5047e);
        }
        if (this.f5046d) {
            a6.a(this.f5045c);
        }
        if (this.f5050h) {
            a6.a(this.f5049g);
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

    public r4(View view) {
        this.f5044b = new WeakReference<>(view);
    }

    @Override // com.acse.ottn.q4
    public q4 d(float f6) {
        b(16, f6);
        return this;
    }

    @Override // com.acse.ottn.q4
    public q4 a(long j6) {
        if (j6 >= 0) {
            this.f5046d = true;
            this.f5045c = j6;
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
            this.f5048f = true;
            this.f5047e = j6;
            return this;
        }
        throw new IllegalArgumentException("Animators cannot have negative duration: " + j6);
    }

    public final void c(int i6, float f6) {
        View view = this.f5044b.get();
        if (view != null) {
            if (i6 == 1) {
                view.setTranslationX(f6);
                return;
            }
            if (i6 == 2) {
                view.setTranslationY(f6);
                return;
            }
            if (i6 == 4) {
                view.setScaleX(f6);
                return;
            }
            if (i6 == 8) {
                view.setScaleY(f6);
                return;
            }
            if (i6 == 16) {
                view.setRotation(f6);
                return;
            }
            if (i6 == 32) {
                view.setRotationX(f6);
                return;
            }
            if (i6 == 64) {
                view.setRotationY(f6);
                return;
            }
            if (i6 == 128) {
                view.setX(f6);
            } else if (i6 == 256) {
                view.setY(f6);
            } else {
                if (i6 != 512) {
                    return;
                }
                view.setAlpha(f6);
            }
        }
    }

    @Override // com.acse.ottn.q4
    public q4 a(Interpolator interpolator) {
        this.f5050h = true;
        this.f5049g = interpolator;
        return this;
    }

    @Override // com.acse.ottn.q4
    public q4 b(float f6) {
        b(512, f6);
        return this;
    }

    @Override // com.acse.ottn.q4
    public q4 a(i.a aVar) {
        this.f5051i = aVar;
        return this;
    }

    public final void b(int i6, float f6) {
        a(i6, a(i6), f6);
    }

    @Override // com.acse.ottn.q4
    public void a() {
        if (this.f5055m.size() > 0) {
            Iterator it = ((HashMap) this.f5055m.clone()).keySet().iterator();
            while (it.hasNext()) {
                ((i) it.next()).cancel();
            }
        }
        this.f5053k.clear();
        View view = this.f5044b.get();
        if (view != null) {
            view.removeCallbacks(this.f5054l);
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
        if (this.f5055m.size() > 0) {
            Iterator<i> it = this.f5055m.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    iVar = null;
                    break;
                }
                iVar = it.next();
                d dVar = this.f5055m.get(iVar);
                if (dVar.a(i6) && dVar.f5061a == 0) {
                    break;
                }
            }
            if (iVar != null) {
                iVar.cancel();
            }
        }
        this.f5053k.add(new c(i6, f6, f7));
        View view = this.f5044b.get();
        if (view != null) {
            view.removeCallbacks(this.f5054l);
            view.post(this.f5054l);
        }
    }

    public final float a(int i6) {
        View view = this.f5044b.get();
        if (view == null) {
            return 0.0f;
        }
        if (i6 == 1) {
            return view.getTranslationX();
        }
        if (i6 == 2) {
            return view.getTranslationY();
        }
        if (i6 == 4) {
            return view.getScaleX();
        }
        if (i6 == 8) {
            return view.getScaleY();
        }
        if (i6 == 16) {
            return view.getRotation();
        }
        if (i6 == 32) {
            return view.getRotationX();
        }
        if (i6 == 64) {
            return view.getRotationY();
        }
        if (i6 == 128) {
            return view.getX();
        }
        if (i6 == 256) {
            return view.getY();
        }
        if (i6 != 512) {
            return 0.0f;
        }
        return view.getAlpha();
    }
}
