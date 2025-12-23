package com.acse.ottn;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AndroidRuntimeException;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.acse.ottn.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class n4 extends i {
    public static ThreadLocal<f> A = new ThreadLocal<>();
    public static final ThreadLocal<ArrayList<n4>> B = new a();
    public static final ThreadLocal<ArrayList<n4>> C = new b();
    public static final ThreadLocal<ArrayList<n4>> D = new c();
    public static final ThreadLocal<ArrayList<n4>> E = new d();
    public static final ThreadLocal<ArrayList<n4>> F = new e();
    public static final Interpolator G = new AccelerateDecelerateInterpolator();
    public static final m4 H = new s1();
    public static final m4 I = new c1();
    public static long J = 10;
    public static final int K = 1;
    public static final int L = 2;
    public static final int M = -1;

    /* renamed from: u, reason: collision with root package name */
    public static final long f4932u = 10;

    /* renamed from: v, reason: collision with root package name */
    public static final int f4933v = 0;

    /* renamed from: w, reason: collision with root package name */
    public static final int f4934w = 1;

    /* renamed from: x, reason: collision with root package name */
    public static final int f4935x = 0;

    /* renamed from: y, reason: collision with root package name */
    public static final int f4936y = 1;

    /* renamed from: z, reason: collision with root package name */
    public static final int f4937z = 2;

    /* renamed from: b, reason: collision with root package name */
    public long f4938b;

    /* renamed from: h, reason: collision with root package name */
    public long f4944h;

    /* renamed from: s, reason: collision with root package name */
    public h3[] f4955s;

    /* renamed from: t, reason: collision with root package name */
    public HashMap<String, h3> f4956t;

    /* renamed from: c, reason: collision with root package name */
    public long f4939c = -1;

    /* renamed from: d, reason: collision with root package name */
    public boolean f4940d = false;

    /* renamed from: e, reason: collision with root package name */
    public int f4941e = 0;

    /* renamed from: f, reason: collision with root package name */
    public float f4942f = 0.0f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f4943g = false;

    /* renamed from: i, reason: collision with root package name */
    public int f4945i = 0;

    /* renamed from: j, reason: collision with root package name */
    public boolean f4946j = false;

    /* renamed from: k, reason: collision with root package name */
    public boolean f4947k = false;

    /* renamed from: l, reason: collision with root package name */
    public boolean f4948l = false;

    /* renamed from: m, reason: collision with root package name */
    public long f4949m = 300;

    /* renamed from: n, reason: collision with root package name */
    public long f4950n = 0;

    /* renamed from: o, reason: collision with root package name */
    public int f4951o = 0;

    /* renamed from: p, reason: collision with root package name */
    public int f4952p = 1;

    /* renamed from: q, reason: collision with root package name */
    public Interpolator f4953q = G;

    /* renamed from: r, reason: collision with root package name */
    public ArrayList<g> f4954r = null;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class a extends ThreadLocal<ArrayList<n4>> {
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ArrayList<n4> initialValue() {
            return new ArrayList<>();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class b extends ThreadLocal<ArrayList<n4>> {
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ArrayList<n4> initialValue() {
            return new ArrayList<>();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class c extends ThreadLocal<ArrayList<n4>> {
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ArrayList<n4> initialValue() {
            return new ArrayList<>();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class d extends ThreadLocal<ArrayList<n4>> {
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ArrayList<n4> initialValue() {
            return new ArrayList<>();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class e extends ThreadLocal<ArrayList<n4>> {
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ArrayList<n4> initialValue() {
            return new ArrayList<>();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class f extends Handler {
        public f() {
        }

        public /* synthetic */ f(a aVar) {
            this();
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            boolean z5;
            ArrayList arrayList = (ArrayList) n4.B.get();
            ArrayList arrayList2 = (ArrayList) n4.D.get();
            int i6 = message.what;
            if (i6 != 0) {
                if (i6 == 1) {
                    z5 = true;
                } else {
                    return;
                }
            } else {
                ArrayList arrayList3 = (ArrayList) n4.C.get();
                if (arrayList.size() <= 0 && arrayList2.size() <= 0) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                while (arrayList3.size() > 0) {
                    ArrayList arrayList4 = (ArrayList) arrayList3.clone();
                    arrayList3.clear();
                    int size = arrayList4.size();
                    for (int i7 = 0; i7 < size; i7++) {
                        n4 n4Var = (n4) arrayList4.get(i7);
                        if (n4Var.f4950n == 0) {
                            n4Var.G();
                        } else {
                            arrayList2.add(n4Var);
                        }
                    }
                }
            }
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            ArrayList arrayList5 = (ArrayList) n4.F.get();
            ArrayList arrayList6 = (ArrayList) n4.E.get();
            int size2 = arrayList2.size();
            for (int i8 = 0; i8 < size2; i8++) {
                n4 n4Var2 = (n4) arrayList2.get(i8);
                if (n4Var2.d(currentAnimationTimeMillis)) {
                    arrayList5.add(n4Var2);
                }
            }
            int size3 = arrayList5.size();
            if (size3 > 0) {
                for (int i9 = 0; i9 < size3; i9++) {
                    n4 n4Var3 = (n4) arrayList5.get(i9);
                    n4Var3.G();
                    n4Var3.f4946j = true;
                    arrayList2.remove(n4Var3);
                }
                arrayList5.clear();
            }
            int size4 = arrayList.size();
            int i10 = 0;
            while (i10 < size4) {
                n4 n4Var4 = (n4) arrayList.get(i10);
                if (n4Var4.c(currentAnimationTimeMillis)) {
                    arrayList6.add(n4Var4);
                }
                if (arrayList.size() == size4) {
                    i10++;
                } else {
                    size4--;
                    arrayList6.remove(n4Var4);
                }
            }
            if (arrayList6.size() > 0) {
                for (int i11 = 0; i11 < arrayList6.size(); i11++) {
                    ((n4) arrayList6.get(i11)).t();
                }
                arrayList6.clear();
            }
            if (z5) {
                if (!arrayList.isEmpty() || !arrayList2.isEmpty()) {
                    sendEmptyMessageDelayed(1, Math.max(0L, n4.J - (AnimationUtils.currentAnimationTimeMillis() - currentAnimationTimeMillis)));
                }
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface g {
        void a(n4 n4Var);
    }

    public static void g(long j6) {
        J = j6;
    }

    public void e(long j6) {
        D();
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        if (this.f4945i != 1) {
            this.f4939c = j6;
            this.f4945i = 2;
        }
        this.f4938b = currentAnimationTimeMillis - j6;
        c(currentAnimationTimeMillis);
    }

    @Override // com.acse.ottn.i
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public n4 a(long j6) {
        if (j6 >= 0) {
            this.f4949m = j6;
            return this;
        }
        throw new IllegalArgumentException("Animators cannot have negative duration: " + j6);
    }

    @Override // com.acse.ottn.i
    public void k() {
        a(false);
    }

    public static void r() {
        B.get().clear();
        C.get().clear();
        D.get().clear();
    }

    public static int w() {
        return B.get().size();
    }

    public static long y() {
        return J;
    }

    public int A() {
        return this.f4951o;
    }

    public int B() {
        return this.f4952p;
    }

    public h3[] C() {
        return this.f4955s;
    }

    public void D() {
        if (this.f4948l) {
            return;
        }
        int length = this.f4955s.length;
        for (int i6 = 0; i6 < length; i6++) {
            this.f4955s[i6].d();
        }
        this.f4948l = true;
    }

    public void E() {
        ArrayList<g> arrayList = this.f4954r;
        if (arrayList == null) {
            return;
        }
        arrayList.clear();
        this.f4954r = null;
    }

    public void F() {
        this.f4940d = !this.f4940d;
        if (this.f4945i != 1) {
            a(true);
            return;
        }
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        this.f4938b = currentAnimationTimeMillis - (this.f4949m - (currentAnimationTimeMillis - this.f4938b));
    }

    public void b(int... iArr) {
        if (iArr == null || iArr.length == 0) {
            return;
        }
        h3[] h3VarArr = this.f4955s;
        if (h3VarArr == null || h3VarArr.length == 0) {
            b(h3.a("", iArr));
        } else {
            h3VarArr[0].a(iArr);
        }
        this.f4948l = false;
    }

    @Override // com.acse.ottn.i
    public long c() {
        return this.f4949m;
    }

    @Override // com.acse.ottn.i
    public void cancel() {
        ArrayList<i.a> arrayList;
        if (this.f4945i != 0 || C.get().contains(this) || D.get().contains(this)) {
            if (this.f4946j && (arrayList = this.f4629a) != null) {
                Iterator it = ((ArrayList) arrayList.clone()).iterator();
                while (it.hasNext()) {
                    ((i.a) it.next()).d(this);
                }
            }
            t();
        }
    }

    public final boolean d(long j6) {
        if (!this.f4943g) {
            this.f4943g = true;
            this.f4944h = j6;
            return false;
        }
        long j7 = j6 - this.f4944h;
        long j8 = this.f4950n;
        if (j7 <= j8) {
            return false;
        }
        this.f4938b = j6 - (j7 - j8);
        this.f4945i = 1;
        return true;
    }

    @Override // com.acse.ottn.i
    public boolean g() {
        return this.f4947k;
    }

    public final void t() {
        ArrayList<i.a> arrayList;
        B.get().remove(this);
        C.get().remove(this);
        D.get().remove(this);
        this.f4945i = 0;
        if (this.f4946j && (arrayList = this.f4629a) != null) {
            ArrayList arrayList2 = (ArrayList) arrayList.clone();
            int size = arrayList2.size();
            for (int i6 = 0; i6 < size; i6++) {
                ((i.a) arrayList2.get(i6)).b(this);
            }
        }
        this.f4946j = false;
        this.f4947k = false;
    }

    public String toString() {
        String str = "ValueAnimator@" + Integer.toHexString(hashCode());
        if (this.f4955s != null) {
            for (int i6 = 0; i6 < this.f4955s.length; i6++) {
                str = str + "\n    " + this.f4955s[i6].toString();
            }
        }
        return str;
    }

    public float u() {
        return this.f4942f;
    }

    public Object v() {
        h3[] h3VarArr = this.f4955s;
        if (h3VarArr == null || h3VarArr.length <= 0) {
            return null;
        }
        return h3VarArr[0].b();
    }

    public long x() {
        if (!this.f4948l || this.f4945i == 0) {
            return 0L;
        }
        return AnimationUtils.currentAnimationTimeMillis() - this.f4938b;
    }

    public Interpolator z() {
        return this.f4953q;
    }

    public final void G() {
        ArrayList<i.a> arrayList;
        D();
        B.get().add(this);
        if (this.f4950n > 0 && (arrayList = this.f4629a) != null) {
            ArrayList arrayList2 = (ArrayList) arrayList.clone();
            int size = arrayList2.size();
            for (int i6 = 0; i6 < size; i6++) {
                ((i.a) arrayList2.get(i6)).a(this);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x007c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean c(long r10) {
        /*
            r9 = this;
            int r0 = r9.f4945i
            r1 = 0
            r3 = 1
            if (r0 != 0) goto L1a
            r9.f4945i = r3
            long r4 = r9.f4939c
            int r0 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r0 >= 0) goto L12
            r9.f4938b = r10
            goto L1a
        L12:
            long r4 = r10 - r4
            r9.f4938b = r4
            r4 = -1
            r9.f4939c = r4
        L1a:
            int r0 = r9.f4945i
            r4 = 2
            r5 = 0
            if (r0 == r3) goto L23
            if (r0 == r4) goto L23
            return r5
        L23:
            long r6 = r9.f4949m
            r0 = 1065353216(0x3f800000, float:1.0)
            int r8 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r8 <= 0) goto L32
            long r1 = r9.f4938b
            long r10 = r10 - r1
            float r10 = (float) r10
            float r11 = (float) r6
            float r10 = r10 / r11
            goto L34
        L32:
            r10 = 1065353216(0x3f800000, float:1.0)
        L34:
            int r11 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r11 < 0) goto L77
            int r11 = r9.f4941e
            int r1 = r9.f4951o
            if (r11 < r1) goto L47
            r11 = -1
            if (r1 != r11) goto L42
            goto L47
        L42:
            float r10 = java.lang.Math.min(r10, r0)
            goto L78
        L47:
            java.util.ArrayList<com.acse.ottn.i$a> r11 = r9.f4629a
            if (r11 == 0) goto L60
            int r11 = r11.size()
            r1 = 0
        L50:
            if (r1 >= r11) goto L60
            java.util.ArrayList<com.acse.ottn.i$a> r2 = r9.f4629a
            java.lang.Object r2 = r2.get(r1)
            com.acse.ottn.i$a r2 = (com.acse.ottn.i.a) r2
            r2.c(r9)
            int r1 = r1 + 1
            goto L50
        L60:
            int r11 = r9.f4952p
            if (r11 != r4) goto L69
            boolean r11 = r9.f4940d
            r11 = r11 ^ r3
            r9.f4940d = r11
        L69:
            int r11 = r9.f4941e
            int r1 = (int) r10
            int r11 = r11 + r1
            r9.f4941e = r11
            float r10 = r10 % r0
            long r1 = r9.f4938b
            long r3 = r9.f4949m
            long r1 = r1 + r3
            r9.f4938b = r1
        L77:
            r3 = 0
        L78:
            boolean r11 = r9.f4940d
            if (r11 == 0) goto L7e
            float r10 = r0 - r10
        L7e:
            r9.a(r10)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.acse.ottn.n4.c(long):boolean");
    }

    @Override // com.acse.ottn.i
    public boolean f() {
        return this.f4945i == 1 || this.f4946j;
    }

    @Override // com.acse.ottn.i
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public n4 clone() {
        n4 n4Var = (n4) super.clone();
        ArrayList<g> arrayList = this.f4954r;
        if (arrayList != null) {
            n4Var.f4954r = new ArrayList<>();
            int size = arrayList.size();
            for (int i6 = 0; i6 < size; i6++) {
                n4Var.f4954r.add(arrayList.get(i6));
            }
        }
        n4Var.f4939c = -1L;
        n4Var.f4940d = false;
        n4Var.f4941e = 0;
        n4Var.f4948l = false;
        n4Var.f4945i = 0;
        n4Var.f4943g = false;
        h3[] h3VarArr = this.f4955s;
        if (h3VarArr != null) {
            int length = h3VarArr.length;
            n4Var.f4955s = new h3[length];
            n4Var.f4956t = new HashMap<>(length);
            for (int i7 = 0; i7 < length; i7++) {
                h3 clone = h3VarArr[i7].clone();
                n4Var.f4955s[i7] = clone;
                n4Var.f4956t.put(clone.c(), clone);
            }
        }
        return n4Var;
    }

    public static n4 a(int... iArr) {
        n4 n4Var = new n4();
        n4Var.b(iArr);
        return n4Var;
    }

    public static n4 a(float... fArr) {
        n4 n4Var = new n4();
        n4Var.b(fArr);
        return n4Var;
    }

    public void b(float... fArr) {
        if (fArr == null || fArr.length == 0) {
            return;
        }
        h3[] h3VarArr = this.f4955s;
        if (h3VarArr == null || h3VarArr.length == 0) {
            b(h3.a("", fArr));
        } else {
            h3VarArr[0].a(fArr);
        }
        this.f4948l = false;
    }

    @Override // com.acse.ottn.i
    public long e() {
        return this.f4950n;
    }

    public static n4 a(h3... h3VarArr) {
        n4 n4Var = new n4();
        n4Var.b(h3VarArr);
        return n4Var;
    }

    public static n4 a(m4 m4Var, Object... objArr) {
        n4 n4Var = new n4();
        n4Var.a(objArr);
        n4Var.a(m4Var);
        return n4Var;
    }

    public void b(h3... h3VarArr) {
        int length = h3VarArr.length;
        this.f4955s = h3VarArr;
        this.f4956t = new HashMap<>(length);
        for (h3 h3Var : h3VarArr) {
            this.f4956t.put(h3Var.c(), h3Var);
        }
        this.f4948l = false;
    }

    public void a(Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            return;
        }
        h3[] h3VarArr = this.f4955s;
        if (h3VarArr == null || h3VarArr.length == 0) {
            b(h3.a("", (m4) null, objArr));
        } else {
            h3VarArr[0].a(objArr);
        }
        this.f4948l = false;
    }

    @Override // com.acse.ottn.i
    public void b(long j6) {
        this.f4950n = j6;
    }

    public Object a(String str) {
        h3 h3Var = this.f4956t.get(str);
        if (h3Var != null) {
            return h3Var.b();
        }
        return null;
    }

    public void b(int i6) {
        this.f4952p = i6;
    }

    public void b(g gVar) {
        ArrayList<g> arrayList = this.f4954r;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(gVar);
        if (this.f4954r.size() == 0) {
            this.f4954r = null;
        }
    }

    public void a(int i6) {
        this.f4951o = i6;
    }

    public void a(g gVar) {
        if (this.f4954r == null) {
            this.f4954r = new ArrayList<>();
        }
        this.f4954r.add(gVar);
    }

    @Override // com.acse.ottn.i
    public void b() {
        if (!B.get().contains(this) && !C.get().contains(this)) {
            this.f4943g = false;
            G();
        } else if (!this.f4948l) {
            D();
        }
        int i6 = this.f4951o;
        if (i6 > 0 && (i6 & 1) == 1) {
            a(0.0f);
        } else {
            a(1.0f);
        }
        t();
    }

    @Override // com.acse.ottn.i
    public void a(Interpolator interpolator) {
        if (interpolator != null) {
            this.f4953q = interpolator;
        } else {
            this.f4953q = new LinearInterpolator();
        }
    }

    public void a(m4 m4Var) {
        h3[] h3VarArr;
        if (m4Var == null || (h3VarArr = this.f4955s) == null || h3VarArr.length <= 0) {
            return;
        }
        h3VarArr[0].a(m4Var);
    }

    public final void a(boolean z5) {
        if (Looper.myLooper() != null) {
            this.f4940d = z5;
            this.f4941e = 0;
            this.f4945i = 0;
            this.f4947k = true;
            this.f4943g = false;
            C.get().add(this);
            if (this.f4950n == 0) {
                e(x());
                this.f4945i = 0;
                this.f4946j = true;
                ArrayList<i.a> arrayList = this.f4629a;
                if (arrayList != null) {
                    ArrayList arrayList2 = (ArrayList) arrayList.clone();
                    int size = arrayList2.size();
                    for (int i6 = 0; i6 < size; i6++) {
                        ((i.a) arrayList2.get(i6)).a(this);
                    }
                }
            }
            f fVar = A.get();
            if (fVar == null) {
                fVar = new f(null);
                A.set(fVar);
            }
            fVar.sendEmptyMessage(0);
            return;
        }
        throw new AndroidRuntimeException("Animators may only be run on Looper threads");
    }

    public void a(float f6) {
        float interpolation = this.f4953q.getInterpolation(f6);
        this.f4942f = interpolation;
        int length = this.f4955s.length;
        for (int i6 = 0; i6 < length; i6++) {
            this.f4955s[i6].a(interpolation);
        }
        ArrayList<g> arrayList = this.f4954r;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i7 = 0; i7 < size; i7++) {
                this.f4954r.get(i7).a(this);
            }
        }
    }
}
