package rx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import rx.Emitter;
import rx.a;
import rx.annotations.Beta;
import rx.annotations.Experimental;
import rx.exceptions.OnErrorFailedException;
import rx.functions.a0;
import rx.functions.o;
import rx.functions.p;
import rx.functions.q;
import rx.functions.r;
import rx.functions.s;
import rx.functions.t;
import rx.functions.u;
import rx.functions.v;
import rx.functions.w;
import rx.functions.x;
import rx.functions.y;
import rx.internal.operators.EmptyObservableHolder;
import rx.internal.operators.NeverObservableHolder;
import rx.internal.operators.a1;
import rx.internal.operators.a2;
import rx.internal.operators.a3;
import rx.internal.operators.a4;
import rx.internal.operators.b0;
import rx.internal.operators.b1;
import rx.internal.operators.b2;
import rx.internal.operators.b3;
import rx.internal.operators.b4;
import rx.internal.operators.c0;
import rx.internal.operators.c1;
import rx.internal.operators.c2;
import rx.internal.operators.c3;
import rx.internal.operators.c4;
import rx.internal.operators.d0;
import rx.internal.operators.d1;
import rx.internal.operators.d2;
import rx.internal.operators.d3;
import rx.internal.operators.d4;
import rx.internal.operators.e0;
import rx.internal.operators.e1;
import rx.internal.operators.e2;
import rx.internal.operators.e3;
import rx.internal.operators.e4;
import rx.internal.operators.f0;
import rx.internal.operators.f1;
import rx.internal.operators.f2;
import rx.internal.operators.f3;
import rx.internal.operators.f4;
import rx.internal.operators.g0;
import rx.internal.operators.g1;
import rx.internal.operators.g2;
import rx.internal.operators.g3;
import rx.internal.operators.g4;
import rx.internal.operators.h0;
import rx.internal.operators.h1;
import rx.internal.operators.h2;
import rx.internal.operators.h3;
import rx.internal.operators.i0;
import rx.internal.operators.i1;
import rx.internal.operators.i2;
import rx.internal.operators.i3;
import rx.internal.operators.j0;
import rx.internal.operators.j1;
import rx.internal.operators.j2;
import rx.internal.operators.j3;
import rx.internal.operators.k0;
import rx.internal.operators.k1;
import rx.internal.operators.k2;
import rx.internal.operators.k3;
import rx.internal.operators.l0;
import rx.internal.operators.l1;
import rx.internal.operators.l2;
import rx.internal.operators.l3;
import rx.internal.operators.m0;
import rx.internal.operators.m1;
import rx.internal.operators.m2;
import rx.internal.operators.m3;
import rx.internal.operators.n0;
import rx.internal.operators.n1;
import rx.internal.operators.n2;
import rx.internal.operators.n3;
import rx.internal.operators.o0;
import rx.internal.operators.o1;
import rx.internal.operators.o2;
import rx.internal.operators.o3;
import rx.internal.operators.p0;
import rx.internal.operators.p1;
import rx.internal.operators.p3;
import rx.internal.operators.q0;
import rx.internal.operators.q1;
import rx.internal.operators.q2;
import rx.internal.operators.q3;
import rx.internal.operators.r0;
import rx.internal.operators.r1;
import rx.internal.operators.r2;
import rx.internal.operators.r3;
import rx.internal.operators.s1;
import rx.internal.operators.s2;
import rx.internal.operators.s3;
import rx.internal.operators.t1;
import rx.internal.operators.t2;
import rx.internal.operators.t3;
import rx.internal.operators.u1;
import rx.internal.operators.u2;
import rx.internal.operators.u3;
import rx.internal.operators.v0;
import rx.internal.operators.v1;
import rx.internal.operators.v2;
import rx.internal.operators.v3;
import rx.internal.operators.w0;
import rx.internal.operators.w1;
import rx.internal.operators.w2;
import rx.internal.operators.w3;
import rx.internal.operators.x0;
import rx.internal.operators.x1;
import rx.internal.operators.x2;
import rx.internal.operators.x3;
import rx.internal.operators.y0;
import rx.internal.operators.y1;
import rx.internal.operators.y2;
import rx.internal.operators.y3;
import rx.internal.operators.z;
import rx.internal.operators.z1;
import rx.internal.operators.z2;
import rx.internal.operators.z3;
import rx.internal.util.InternalObservableUtils;
import rx.internal.util.n;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class e<T> {

    /* renamed from: a, reason: collision with root package name */
    final a<T> f52396a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a<T> extends rx.functions.b<l<? super T>> {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface b<R, T> extends p<l<? super R>, l<? super T>> {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface c<T, R> extends p<e<T>, e<R>> {
    }

    public static <T> e<T> B5(e<? extends e<? extends T>> eVar) {
        return (e<T>) eVar.a3(k3.a(false));
    }

    public static <T> e<T> C5(e<? extends e<? extends T>> eVar) {
        return (e<T>) eVar.a3(k3.a(true));
    }

    public static e<Long> J2(long j6, TimeUnit timeUnit, h hVar) {
        return H2(j6, j6, timeUnit, hVar);
    }

    public static <T, Resource> e<T> L6(o<Resource> oVar, p<? super Resource, ? extends e<? extends T>> pVar, rx.functions.b<? super Resource> bVar) {
        return M6(oVar, pVar, bVar, false);
    }

    public static <T> e<T> N2(T t5, T t6) {
        return y2(new Object[]{t5, t6});
    }

    public static <T> e<T> O2(T t5, T t6, T t7) {
        return y2(new Object[]{t5, t6, t7});
    }

    public static <T> e<T> P2(T t5, T t6, T t7, T t8) {
        return y2(new Object[]{t5, t6, t7, t8});
    }

    public static <T> e<T> Q2(T t5, T t6, T t7, T t8, T t9) {
        return y2(new Object[]{t5, t6, t7, t8, t9});
    }

    public static <T> e<T> R0(e<? extends T> eVar, e<? extends T> eVar2) {
        return N0(Arrays.asList(eVar, eVar2));
    }

    public static <T> e<T> R2(T t5, T t6, T t7, T t8, T t9, T t10) {
        return y2(new Object[]{t5, t6, t7, t8, t9, t10});
    }

    public static <T> e<T> S0(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3) {
        return N0(Arrays.asList(eVar, eVar2, eVar3));
    }

    public static <T> e<T> S2(T t5, T t6, T t7, T t8, T t9, T t10, T t11) {
        return y2(new Object[]{t5, t6, t7, t8, t9, t10, t11});
    }

    public static <T> e<T> T0(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4) {
        return N0(Arrays.asList(eVar, eVar2, eVar3, eVar4));
    }

    public static <T> e<T> U0(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4, e<? extends T> eVar5) {
        return N0(Arrays.asList(eVar, eVar2, eVar3, eVar4, eVar5));
    }

    public static <T> e<T> V0(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4, e<? extends T> eVar5, e<? extends T> eVar6) {
        return N0(Arrays.asList(eVar, eVar2, eVar3, eVar4, eVar5, eVar6));
    }

    public static <T> e<T> W0(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4, e<? extends T> eVar5, e<? extends T> eVar6, e<? extends T> eVar7) {
        return N0(Arrays.asList(eVar, eVar2, eVar3, eVar4, eVar5, eVar6, eVar7));
    }

    public static <T> e<T> j3(e<? extends T> eVar, e<? extends T> eVar2) {
        return r3(new e[]{eVar, eVar2});
    }

    public static <T> e<T> k3(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3) {
        return r3(new e[]{eVar, eVar2, eVar3});
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> e<R> l0(e<? extends T1> eVar, e<? extends T2> eVar2, e<? extends T3> eVar3, e<? extends T4> eVar4, e<? extends T5> eVar5, e<? extends T6> eVar6, e<? extends T7> eVar7, v<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> vVar) {
        return i0(Arrays.asList(eVar, eVar2, eVar3, eVar4, eVar5, eVar6, eVar7), a0.l(vVar));
    }

    public static <T> e<T> l3(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4) {
        return r3(new e[]{eVar, eVar2, eVar3, eVar4});
    }

    public static <T1, T2, T3, T4, T5, T6, R> e<R> m0(e<? extends T1> eVar, e<? extends T2> eVar2, e<? extends T3> eVar3, e<? extends T4> eVar4, e<? extends T5> eVar5, e<? extends T6> eVar6, u<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> uVar) {
        return i0(Arrays.asList(eVar, eVar2, eVar3, eVar4, eVar5, eVar6), a0.k(uVar));
    }

    public static <T> e<T> m3(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4, e<? extends T> eVar5) {
        return r3(new e[]{eVar, eVar2, eVar3, eVar4, eVar5});
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> e<R> m7(e<? extends T1> eVar, e<? extends T2> eVar2, e<? extends T3> eVar3, e<? extends T4> eVar4, e<? extends T5> eVar5, e<? extends T6> eVar6, e<? extends T7> eVar7, v<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> vVar) {
        return M2(new e[]{eVar, eVar2, eVar3, eVar4, eVar5, eVar6, eVar7}).a3(new f4(vVar));
    }

    public static <T1, T2, T3, T4, T5, R> e<R> n0(e<? extends T1> eVar, e<? extends T2> eVar2, e<? extends T3> eVar3, e<? extends T4> eVar4, e<? extends T5> eVar5, t<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> tVar) {
        return i0(Arrays.asList(eVar, eVar2, eVar3, eVar4, eVar5), a0.j(tVar));
    }

    public static <T> e<T> n3(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4, e<? extends T> eVar5, e<? extends T> eVar6) {
        return r3(new e[]{eVar, eVar2, eVar3, eVar4, eVar5, eVar6});
    }

    public static <T1, T2, T3, T4, T5, T6, R> e<R> n7(e<? extends T1> eVar, e<? extends T2> eVar2, e<? extends T3> eVar3, e<? extends T4> eVar4, e<? extends T5> eVar5, e<? extends T6> eVar6, u<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> uVar) {
        return M2(new e[]{eVar, eVar2, eVar3, eVar4, eVar5, eVar6}).a3(new f4(uVar));
    }

    public static <T1, T2, T3, T4, R> e<R> o0(e<? extends T1> eVar, e<? extends T2> eVar2, e<? extends T3> eVar3, e<? extends T4> eVar4, s<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> sVar) {
        return i0(Arrays.asList(eVar, eVar2, eVar3, eVar4), a0.i(sVar));
    }

    public static <T> e<T> o3(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4, e<? extends T> eVar5, e<? extends T> eVar6, e<? extends T> eVar7) {
        return r3(new e[]{eVar, eVar2, eVar3, eVar4, eVar5, eVar6, eVar7});
    }

    public static <T1, T2, T3, T4, T5, R> e<R> o7(e<? extends T1> eVar, e<? extends T2> eVar2, e<? extends T3> eVar3, e<? extends T4> eVar4, e<? extends T5> eVar5, t<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> tVar) {
        return M2(new e[]{eVar, eVar2, eVar3, eVar4, eVar5}).a3(new f4(tVar));
    }

    public static <T1, T2, T3, R> e<R> p0(e<? extends T1> eVar, e<? extends T2> eVar2, e<? extends T3> eVar3, r<? super T1, ? super T2, ? super T3, ? extends R> rVar) {
        return i0(Arrays.asList(eVar, eVar2, eVar3), a0.h(rVar));
    }

    public static <T1, T2, T3, T4, R> e<R> p7(e<? extends T1> eVar, e<? extends T2> eVar2, e<? extends T3> eVar3, e<? extends T4> eVar4, s<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> sVar) {
        return M2(new e[]{eVar, eVar2, eVar3, eVar4}).a3(new f4(sVar));
    }

    public static <T1, T2, R> e<R> q0(e<? extends T1> eVar, e<? extends T2> eVar2, q<? super T1, ? super T2, ? extends R> qVar) {
        return i0(Arrays.asList(eVar, eVar2), a0.g(qVar));
    }

    public static <T1, T2, T3, R> e<R> q7(e<? extends T1> eVar, e<? extends T2> eVar2, e<? extends T3> eVar3, r<? super T1, ? super T2, ? super T3, ? extends R> rVar) {
        return M2(new e[]{eVar, eVar2, eVar3}).a3(new f4(rVar));
    }

    public static <T1, T2, R> e<R> r7(e<? extends T1> eVar, e<? extends T2> eVar2, q<? super T1, ? super T2, ? extends R> qVar) {
        return M2(new e[]{eVar, eVar2}).a3(new f4(qVar));
    }

    public static <T> e<T> v3(e<? extends e<? extends T>> eVar) {
        return (e<T>) eVar.a3(o2.a(true));
    }

    public static <T> e<T> w3(e<? extends e<? extends T>> eVar, int i6) {
        return (e<T>) eVar.a3(o2.b(true, i6));
    }

    public static <T> e<T> y2(T[] tArr) {
        int length = tArr.length;
        return length == 0 ? S1() : length == 1 ? M2(tArr[0]) : I6(new l0(tArr));
    }

    public final e<T> J3(h hVar, int i6) {
        return L3(hVar, false, i6);
    }

    public final e<e<T>> U6(long j6, TimeUnit timeUnit, int i6, h hVar) {
        return Q6(j6, j6, timeUnit, i6, hVar);
    }

    public final e<T> W2() {
        return H5(1).Q4();
    }

    public final e<List<T>> X(long j6, TimeUnit timeUnit, h hVar) {
        return T(j6, j6, timeUnit, hVar);
    }

    public final e<T> X1() {
        return D5(1).Q4();
    }

    public final e<T> Y2(T t5) {
        return H5(1).S4(t5);
    }

    public final e<T> Z1(T t5) {
        return D5(1).S4(t5);
    }

    public final <R> e<R> c1(p<? super T, ? extends e<? extends R>> pVar, int i6) {
        if (i6 >= 1) {
            return a3(new g2(pVar, i6, Integer.MAX_VALUE));
        }
        throw new IllegalArgumentException("capacityHint > 0 required but it was " + i6);
    }

    public final <R> e<R> d1(p<? super T, ? extends e<? extends R>> pVar, int i6, int i7) {
        if (i6 < 1) {
            throw new IllegalArgumentException("capacityHint > 0 required but it was " + i6);
        }
        if (i7 >= 1) {
            return a3(new g2(pVar, i6, i7));
        }
        throw new IllegalArgumentException("maxConcurrent > 0 required but it was " + i6);
    }

    public final e<T> e6(long j6, TimeUnit timeUnit) {
        return g6(j6, timeUnit, null, rx.schedulers.c.a());
    }

    public final e<Integer> h1() {
        return e4(0, InternalObservableUtils.COUNTER);
    }

    public final e<T> h2(p<? super T, ? extends rx.b> pVar) {
        return j2(pVar, false, Integer.MAX_VALUE);
    }

    public final e<T> h6(long j6, TimeUnit timeUnit, h hVar) {
        return g6(j6, timeUnit, null, hVar);
    }

    public final <U, V> e<T> i6(o<? extends e<U>> oVar, p<? super T, ? extends e<V>> pVar) {
        return j6(oVar, pVar, null);
    }

    public final <V> e<T> k6(p<? super T, ? extends e<V>> pVar) {
        return j6(null, pVar, null);
    }

    public final <V> e<T> l6(p<? super T, ? extends e<V>> pVar, e<? extends T> eVar) {
        return j6(null, pVar, eVar);
    }

    public final <R> e<R> o2(p<? super T, ? extends i<? extends R>> pVar) {
        return q2(pVar, false, Integer.MAX_VALUE);
    }

    public static e<Long> H2(long j6, long j7, TimeUnit timeUnit, h hVar) {
        return I6(new i1(j6, j7, timeUnit, hVar));
    }

    public static <T> e<T> I6(a<T> aVar) {
        return new e<>(rx.plugins.c.G(aVar));
    }

    public static <T> e<Boolean> M4(e<? extends T> eVar, e<? extends T> eVar2) {
        return N4(eVar, eVar2, InternalObservableUtils.OBJECT_EQUALS);
    }

    public static <T, Resource> e<T> M6(o<Resource> oVar, p<? super Resource, ? extends e<? extends T>> pVar, rx.functions.b<? super Resource> bVar, boolean z5) {
        return I6(new m1(oVar, pVar, bVar, z5));
    }

    public static <T> e<T> T1(Throwable th) {
        return I6(new e1(th));
    }

    public static <T> e<T> T2(T t5, T t6, T t7, T t8, T t9, T t10, T t11, T t12) {
        return y2(new Object[]{t5, t6, t7, t8, t9, t10, t11, t12});
    }

    public static <T> e<T> U2(T t5, T t6, T t7, T t8, T t9, T t10, T t11, T t12, T t13) {
        return y2(new Object[]{t5, t6, t7, t8, t9, t10, t11, t12, t13});
    }

    public static <T> e<T> V2(T t5, T t6, T t7, T t8, T t9, T t10, T t11, T t12, T t13, T t14) {
        return y2(new Object[]{t5, t6, t7, t8, t9, t10, t11, t12, t13, t14});
    }

    public static <T> e<T> X0(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4, e<? extends T> eVar5, e<? extends T> eVar6, e<? extends T> eVar7, e<? extends T> eVar8) {
        return N0(Arrays.asList(eVar, eVar2, eVar3, eVar4, eVar5, eVar6, eVar7, eVar8));
    }

    public static <T> e<T> Y0(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4, e<? extends T> eVar5, e<? extends T> eVar6, e<? extends T> eVar7, e<? extends T> eVar8, e<? extends T> eVar9) {
        return N0(Arrays.asList(eVar, eVar2, eVar3, eVar4, eVar5, eVar6, eVar7, eVar8, eVar9));
    }

    public static e<Integer> b4(int i6, int i7) {
        if (i7 < 0) {
            throw new IllegalArgumentException("Count can not be negative");
        }
        if (i7 == 0) {
            return S1();
        }
        if (i6 <= Integer.MIN_VALUE - i7) {
            return i7 == 1 ? M2(Integer.valueOf(i6)) : I6(new v0(i6, (i7 - 1) + i6));
        }
        throw new IllegalArgumentException("start + count can not exceed Integer.MAX_VALUE");
    }

    private <R> e<R> d3(p<? super T, ? extends R> pVar, p<? super Throwable, ? extends R> pVar2, o<? extends R> oVar) {
        return a3(new l2(pVar, pVar2, oVar));
    }

    public static <T, R> e<R> h0(Iterable<? extends e<? extends T>> iterable, y<? extends R> yVar) {
        return I6(new rx.internal.operators.y(iterable, yVar));
    }

    public static <T, R> e<R> i0(List<? extends e<? extends T>> list, y<? extends R> yVar) {
        return I6(new rx.internal.operators.y(list, yVar));
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> e<R> j0(e<? extends T1> eVar, e<? extends T2> eVar2, e<? extends T3> eVar3, e<? extends T4> eVar4, e<? extends T5> eVar5, e<? extends T6> eVar6, e<? extends T7> eVar7, e<? extends T8> eVar8, e<? extends T9> eVar9, x<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> xVar) {
        return i0(Arrays.asList(eVar, eVar2, eVar3, eVar4, eVar5, eVar6, eVar7, eVar8, eVar9), a0.n(xVar));
    }

    @Deprecated
    public static <T> e<T> j1(a<T> aVar) {
        return new e<>(rx.plugins.c.G(aVar));
    }

    public static <R> e<R> j7(Iterable<? extends e<?>> iterable, y<? extends R> yVar) {
        ArrayList arrayList = new ArrayList();
        Iterator<? extends e<?>> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return M2(arrayList.toArray(new e[arrayList.size()])).a3(new f4(yVar));
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> e<R> k0(e<? extends T1> eVar, e<? extends T2> eVar2, e<? extends T3> eVar3, e<? extends T4> eVar4, e<? extends T5> eVar5, e<? extends T6> eVar6, e<? extends T7> eVar7, e<? extends T8> eVar8, w<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> wVar) {
        return i0(Arrays.asList(eVar, eVar2, eVar3, eVar4, eVar5, eVar6, eVar7, eVar8), a0.m(wVar));
    }

    public static <T> e<T> k1(rx.functions.b<Emitter<T>> bVar, Emitter.BackpressureMode backpressureMode) {
        return I6(new rx.internal.operators.a0(bVar, backpressureMode));
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> e<R> k7(e<? extends T1> eVar, e<? extends T2> eVar2, e<? extends T3> eVar3, e<? extends T4> eVar4, e<? extends T5> eVar5, e<? extends T6> eVar6, e<? extends T7> eVar7, e<? extends T8> eVar8, e<? extends T9> eVar9, x<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> xVar) {
        return M2(new e[]{eVar, eVar2, eVar3, eVar4, eVar5, eVar6, eVar7, eVar8, eVar9}).a3(new f4(xVar));
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> e<R> l7(e<? extends T1> eVar, e<? extends T2> eVar2, e<? extends T3> eVar3, e<? extends T4> eVar4, e<? extends T5> eVar5, e<? extends T6> eVar6, e<? extends T7> eVar7, e<? extends T8> eVar8, w<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> wVar) {
        return M2(new e[]{eVar, eVar2, eVar3, eVar4, eVar5, eVar6, eVar7, eVar8}).a3(new f4(wVar));
    }

    public static <T> e<T> p3(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4, e<? extends T> eVar5, e<? extends T> eVar6, e<? extends T> eVar7, e<? extends T> eVar8) {
        return r3(new e[]{eVar, eVar2, eVar3, eVar4, eVar5, eVar6, eVar7, eVar8});
    }

    public static e<Long> p6(long j6, TimeUnit timeUnit, h hVar) {
        return I6(new h1(j6, timeUnit, hVar));
    }

    public static <T> e<T> q3(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4, e<? extends T> eVar5, e<? extends T> eVar6, e<? extends T> eVar7, e<? extends T> eVar8, e<? extends T> eVar9) {
        return r3(new e[]{eVar, eVar2, eVar3, eVar4, eVar5, eVar6, eVar7, eVar8, eVar9});
    }

    public static <T, R> e<R> r0(Iterable<? extends e<? extends T>> iterable, y<? extends R> yVar) {
        return I6(new rx.internal.operators.y(null, iterable, yVar, rx.internal.util.j.f54163d, true));
    }

    public static <T> e<T> r1(o<e<T>> oVar) {
        return I6(new b0(oVar));
    }

    static <T> m s5(l<? super T> lVar, e<T> eVar) {
        if (lVar == null) {
            throw new IllegalArgumentException("subscriber can not be null");
        }
        if (eVar.f52396a == null) {
            throw new IllegalStateException("onSubscribe function can not be null.");
        }
        lVar.onStart();
        if (!(lVar instanceof rx.observers.e)) {
            lVar = new rx.observers.e(lVar);
        }
        try {
            rx.plugins.c.O(eVar, eVar.f52396a).call(lVar);
            return rx.plugins.c.N(lVar);
        } catch (Throwable th) {
            rx.exceptions.a.e(th);
            if (lVar.isUnsubscribed()) {
                rx.plugins.c.I(rx.plugins.c.L(th));
            } else {
                try {
                    lVar.onError(rx.plugins.c.L(th));
                } catch (Throwable th2) {
                    rx.exceptions.a.e(th2);
                    OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                    rx.plugins.c.L(onErrorFailedException);
                    throw onErrorFailedException;
                }
            }
            return rx.subscriptions.f.e();
        }
    }

    public static <T> e<T> u2(Iterable<? extends T> iterable) {
        return I6(new n0(iterable));
    }

    public static <T> e<T> z2(Callable<? extends T> callable) {
        return I6(new m0(callable));
    }

    public final <K> e<rx.observables.d<K, T>> A2(p<? super T, ? extends K> pVar) {
        return (e<rx.observables.d<K, T>>) a3(new j2(pVar));
    }

    public final <K, V> e<Map<K, Collection<V>>> A6(p<? super T, ? extends K> pVar, p<? super T, ? extends V> pVar2) {
        return I6(new k1(this, pVar, pVar2));
    }

    public final <K, R> e<rx.observables.d<K, R>> B2(p<? super T, ? extends K> pVar, p<? super T, ? extends R> pVar2) {
        return a3(new j2(pVar, pVar2));
    }

    public final <K, V> e<Map<K, Collection<V>>> B6(p<? super T, ? extends K> pVar, p<? super T, ? extends V> pVar2, o<? extends Map<K, Collection<V>>> oVar) {
        return I6(new k1(this, pVar, pVar2, oVar));
    }

    public final <U> e<T> C1(p<? super T, ? extends U> pVar) {
        return (e<T>) a3(new a2(pVar));
    }

    @Experimental
    public final <K, R> e<rx.observables.d<K, R>> C2(p<? super T, ? extends K> pVar, p<? super T, ? extends R> pVar2, int i6, boolean z5, p<rx.functions.b<Object>, Map<K, Object>> pVar3) {
        if (pVar3 != null) {
            return a3(new j2(pVar, pVar2, i6, z5, pVar3));
        }
        throw new NullPointerException("evictingMapFactory cannot be null");
    }

    public final <K, V> e<Map<K, Collection<V>>> C6(p<? super T, ? extends K> pVar, p<? super T, ? extends V> pVar2, o<? extends Map<K, Collection<V>>> oVar, p<? super K, ? extends Collection<V>> pVar3) {
        return I6(new k1(this, pVar, pVar2, oVar, pVar3));
    }

    @Deprecated
    public final <K, R> e<rx.observables.d<K, R>> D2(p<? super T, ? extends K> pVar, p<? super T, ? extends R> pVar2, p<rx.functions.b<K>, Map<K, Object>> pVar3) {
        if (pVar3 != null) {
            return a3(new i2(pVar, pVar2, pVar3));
        }
        throw new NullPointerException("evictingMapFactory cannot be null");
    }

    public final e<T> D5(int i6) {
        return (e<T>) a3(new l3(i6));
    }

    public i<T> D6() {
        return new i<>(a1.a(this));
    }

    public final <U> e<T> E1(p<? super T, ? extends U> pVar) {
        return (e<T>) a3(new b2(pVar));
    }

    public final <T2, D1, D2, R> e<R> E2(e<T2> eVar, p<? super T, ? extends e<D1>> pVar, p<? super T2, ? extends e<D2>> pVar2, q<? super T, ? super e<T2>, ? extends R> qVar) {
        return I6(new o0(this, eVar, pVar, pVar2, qVar));
    }

    public final e<List<T>> E6() {
        return (e<List<T>>) a3(new w3(10));
    }

    public final e<T> F1(q<? super T, ? super T, Boolean> qVar) {
        return (e<T>) a3(new b2(qVar));
    }

    public final e<T> F5(long j6, TimeUnit timeUnit, h hVar) {
        return (e<T>) a3(new o3(j6, timeUnit, hVar));
    }

    public final e<List<T>> F6(int i6) {
        return (e<List<T>>) a3(new w3(i6));
    }

    public final e<T> G1(rx.functions.a aVar) {
        return (e<T>) a3(new c2(aVar));
    }

    public final e<List<T>> G6(q<? super T, ? super T, Integer> qVar) {
        return (e<List<T>>) a3(new w3(qVar, 10));
    }

    public final e<T> H5(int i6) {
        return i6 == 0 ? F2() : i6 == 1 ? I6(new d1(this)) : (e<T>) a3(new m3(i6));
    }

    public final e<List<T>> H6(q<? super T, ? super T, Integer> qVar, int i6) {
        return (e<List<T>>) a3(new w3(qVar, i6));
    }

    public final e<T> I1(f<? super T> fVar) {
        return I6(new g0(this, fVar));
    }

    public final e<T> I3(h hVar) {
        return J3(hVar, rx.internal.util.j.f54163d);
    }

    public final e<T> I4(long j6, TimeUnit timeUnit, h hVar) {
        return (e<T>) a3(new z2(j6, timeUnit, hVar));
    }

    public final e<T> J1(rx.functions.b<Notification<? super T>> bVar) {
        return I6(new g0(this, new rx.internal.util.a(bVar)));
    }

    public final <U> e<T> J4(e<U> eVar) {
        return (e<T>) a3(new y2(eVar));
    }

    public final e<T> J5(int i6, long j6, TimeUnit timeUnit, h hVar) {
        return (e<T>) a3(new n3(i6, j6, timeUnit, hVar));
    }

    public final e<Boolean> K2() {
        return a3(InternalObservableUtils.IS_EMPTY);
    }

    public final e<T> K3(h hVar, boolean z5) {
        return L3(hVar, z5, rx.internal.util.j.f54163d);
    }

    public final <R> e<R> K4(R r5, q<R, ? super T, R> qVar) {
        return a3(new a3(r5, qVar));
    }

    public final e<T> K6(h hVar) {
        return (e<T>) a3(new x3(hVar));
    }

    public final <TRight, TLeftDuration, TRightDuration, R> e<R> L2(e<TRight> eVar, p<T, e<TLeftDuration>> pVar, p<TRight, e<TRightDuration>> pVar2, q<T, TRight, R> qVar) {
        return I6(new p0(this, eVar, pVar, pVar2, qVar));
    }

    public final e<T> L3(h hVar, boolean z5, int i6) {
        return this instanceof rx.internal.util.k ? ((rx.internal.util.k) this).A7(hVar) : (e<T>) a3(new q2(hVar, z5, i6));
    }

    public final e<T> L4(q<T, T, T> qVar) {
        return (e<T>) a3(new a3(qVar));
    }

    public final e<T> L5(long j6, TimeUnit timeUnit, h hVar) {
        return (e<T>) a3(new n3(j6, timeUnit, hVar));
    }

    public final e<T> M1(rx.functions.b<? super Long> bVar) {
        return (e<T>) a3(new d2(bVar));
    }

    public final e<T> N1(rx.functions.a aVar) {
        return (e<T>) a3(new e2(aVar));
    }

    public final e<T> O3(long j6) {
        return (e<T>) a3(new r2(j6));
    }

    public final e<e<T>> O6(int i6, int i7) {
        if (i6 <= 0) {
            throw new IllegalArgumentException("count > 0 required but it was " + i6);
        }
        if (i7 > 0) {
            return (e<e<T>>) a3(new a4(i6, i7));
        }
        throw new IllegalArgumentException("skip > 0 required but it was " + i7);
    }

    public final e<T> P1(rx.functions.a aVar) {
        return (e<T>) a3(new f2(aVar));
    }

    public final e<T> P3(long j6, rx.functions.a aVar) {
        return (e<T>) a3(new r2(j6, aVar));
    }

    public final e<T> Q1(int i6) {
        return (e<T>) a3(new h2(i6));
    }

    public final e<T> Q3(long j6, rx.functions.a aVar, a.d dVar) {
        return (e<T>) a3(new r2(j6, aVar, dVar));
    }

    public final e<e<T>> Q6(long j6, long j7, TimeUnit timeUnit, int i6, h hVar) {
        return (e<e<T>>) a3(new c4(j6, j7, timeUnit, i6, hVar));
    }

    public final e<List<T>> R(int i6, int i7) {
        return (e<List<T>>) a3(new r1(i6, i7));
    }

    public final e<T> R1(int i6, T t5) {
        return (e<T>) a3(new h2(i6, t5));
    }

    public final <E> e<T> R5(e<? extends E> eVar) {
        return (e<T>) a3(new p3(eVar));
    }

    public final e<T> S3(rx.functions.b<? super T> bVar) {
        return (e<T>) a3(new s2(bVar));
    }

    public final e<T> S4(T t5) {
        return (e<T>) a3(new d3(t5));
    }

    public final e<T> S5(p<? super T, Boolean> pVar) {
        return (e<T>) a3(new q3(pVar));
    }

    public final e<List<T>> T(long j6, long j7, TimeUnit timeUnit, h hVar) {
        return (e<List<T>>) a3(new t1(j6, j7, timeUnit, Integer.MAX_VALUE, hVar));
    }

    public final e<T> T5(p<? super T, Boolean> pVar) {
        return (e<T>) a3(new r3(pVar));
    }

    public final e<Boolean> U1(p<? super T, Boolean> pVar) {
        return a3(new o1(pVar, false));
    }

    public final e<T> U4(int i6) {
        return (e<T>) a3(new e3(i6));
    }

    public final e<List<T>> V(long j6, TimeUnit timeUnit, int i6) {
        return (e<List<T>>) a3(new t1(j6, j6, timeUnit, i6, rx.schedulers.c.a()));
    }

    public final e<T> V1(p<? super T, Boolean> pVar) {
        return I6(new h0(this, pVar));
    }

    public final e<T> V3(p<? super Throwable, ? extends e<? extends T>> pVar) {
        return (e<T>) a3(new u2(pVar));
    }

    public final e<List<T>> W(long j6, TimeUnit timeUnit, int i6, h hVar) {
        return (e<List<T>>) a3(new t1(j6, j6, timeUnit, i6, hVar));
    }

    @Deprecated
    public final e<T> W1(rx.functions.a aVar) {
        return (e<T>) a3(new c2(aVar));
    }

    public final e<T> W4(long j6, TimeUnit timeUnit, h hVar) {
        return I6(new b1(this, j6, timeUnit, hVar));
    }

    public final <U> e<e<T>> W6(e<U> eVar) {
        return (e<e<T>>) a3(new y3(eVar));
    }

    public final e<T> X4(int i6) {
        return (e<T>) a3(new f3(i6));
    }

    public final e<T> X5(long j6, TimeUnit timeUnit, h hVar) {
        return (e<T>) a3(new s3(j6, timeUnit, hVar));
    }

    public final <TOpening, TClosing> e<e<T>> X6(e<? extends TOpening> eVar, p<? super TOpening, ? extends e<? extends TClosing>> pVar) {
        return (e<e<T>>) a3(new b4(eVar, pVar));
    }

    public final <B> e<List<T>> Y(e<B> eVar) {
        return Z(eVar, 16);
    }

    public final e<T> Y3() {
        return I6(new f0(this));
    }

    public final <TClosing> e<e<T>> Y6(o<? extends e<? extends TClosing>> oVar) {
        return (e<e<T>>) a3(new z3(oVar));
    }

    public final <B> e<List<T>> Z(e<B> eVar, int i6) {
        return (e<List<T>>) a3(new q1(eVar, i6));
    }

    public final <R> e<R> Z0(p<? super T, ? extends e<? extends R>> pVar) {
        return this instanceof rx.internal.util.k ? ((rx.internal.util.k) this).z7(pVar) : I6(new z(this, pVar, 2, 0));
    }

    public final e<T> Z4(long j6, TimeUnit timeUnit, h hVar) {
        return (e<T>) a3(new g3(j6, timeUnit, hVar));
    }

    public final <R> e<R> Z6(Iterable<e<?>> iterable, y<R> yVar) {
        return I6(new e4(this, null, iterable, yVar));
    }

    public final <TOpening, TClosing> e<List<T>> a0(e<? extends TOpening> eVar, p<? super TOpening, ? extends e<? extends TClosing>> pVar) {
        return (e<List<T>>) a3(new s1(eVar, pVar));
    }

    public final <R> e<R> a1(p<? super T, ? extends e<? extends R>> pVar) {
        return this instanceof rx.internal.util.k ? ((rx.internal.util.k) this).z7(pVar) : I6(new z(this, pVar, 2, 2));
    }

    public final <R> e<R> a3(b<? extends R, ? super T> bVar) {
        return I6(new q0(this.f52396a, bVar));
    }

    public final <U> e<T> a5(e<U> eVar) {
        return (e<T>) a3(new h3(eVar));
    }

    public final <T1, T2, T3, T4, T5, T6, T7, T8, R> e<R> a7(e<T1> eVar, e<T2> eVar2, e<T3> eVar3, e<T4> eVar4, e<T5> eVar5, e<T6> eVar6, e<T7> eVar7, e<T8> eVar8, x<? super T, ? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, R> xVar) {
        return I6(new e4(this, new e[]{eVar, eVar2, eVar3, eVar4, eVar5, eVar6, eVar7, eVar8}, null, a0.n(xVar)));
    }

    public final <TClosing> e<List<T>> b0(o<? extends e<? extends TClosing>> oVar) {
        return (e<List<T>>) a3(new q1(oVar, 16));
    }

    public final <R> e<R> b1(p<? super T, ? extends e<? extends R>> pVar) {
        return c1(pVar, rx.internal.util.j.f54163d);
    }

    public final e<T> b5(p<? super T, Boolean> pVar) {
        return (e<T>) a3(new i3(i3.a(pVar)));
    }

    public final <T1, T2, T3, T4, T5, T6, T7, R> e<R> b7(e<T1> eVar, e<T2> eVar2, e<T3> eVar3, e<T4> eVar4, e<T5> eVar5, e<T6> eVar6, e<T7> eVar7, w<? super T, ? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, R> wVar) {
        return I6(new e4(this, new e[]{eVar, eVar2, eVar3, eVar4, eVar5, eVar6, eVar7}, null, a0.m(wVar)));
    }

    public final <R> e<R> c3(p<? super T, ? extends R> pVar) {
        return I6(new r0(this, pVar));
    }

    public final <T1, T2, T3, T4, T5, T6, R> e<R> c7(e<T1> eVar, e<T2> eVar2, e<T3> eVar3, e<T4> eVar4, e<T5> eVar5, e<T6> eVar6, v<? super T, ? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, R> vVar) {
        return I6(new e4(this, new e[]{eVar, eVar2, eVar3, eVar4, eVar5, eVar6}, null, a0.l(vVar)));
    }

    public final e<Boolean> d(p<? super T, Boolean> pVar) {
        return a3(new n1(pVar));
    }

    public final e<T> d4(int i6) {
        if (i6 > 0) {
            return (e<T>) a3(q2.a(i6));
        }
        throw new IllegalArgumentException("n > 0 required but it was " + i6);
    }

    public final e<rx.schedulers.e<T>> d6(h hVar) {
        return (e<rx.schedulers.e<T>>) a3(new t3(hVar));
    }

    public final <T1, T2, T3, T4, T5, R> e<R> d7(e<T1> eVar, e<T2> eVar2, e<T3> eVar3, e<T4> eVar4, e<T5> eVar5, u<? super T, ? super T1, ? super T2, ? super T3, ? super T4, ? super T5, R> uVar) {
        return I6(new e4(this, new e[]{eVar, eVar2, eVar3, eVar4, eVar5}, null, a0.k(uVar)));
    }

    public final <R> e<R> e1(p<? super T, ? extends Iterable<? extends R>> pVar) {
        return k0.a(this, pVar, rx.internal.util.j.f54163d);
    }

    public final <R> e<R> e4(R r5, q<R, ? super T, R> qVar) {
        return I6(new y0(this, r5, qVar));
    }

    public final <T1, T2, T3, T4, R> e<R> e7(e<T1> eVar, e<T2> eVar2, e<T3> eVar3, e<T4> eVar4, t<? super T, ? super T1, ? super T2, ? super T3, ? super T4, R> tVar) {
        return I6(new e4(this, new e[]{eVar, eVar2, eVar3, eVar4}, null, a0.j(tVar)));
    }

    public final <R> e<R> f0(Class<R> cls) {
        return a3(new u1(cls));
    }

    public final <U, R> e<R> f2(p<? super T, ? extends e<? extends U>> pVar, q<? super T, ? super U, ? extends R> qVar) {
        return h3(a3(new m2(pVar, qVar)));
    }

    public final e<T> f4(q<T, T, T> qVar) {
        return I6(new x0(this, qVar));
    }

    public final <T1, T2, T3, R> e<R> f7(e<T1> eVar, e<T2> eVar2, e<T3> eVar3, s<? super T, ? super T1, ? super T2, ? super T3, R> sVar) {
        return I6(new e4(this, new e[]{eVar, eVar2, eVar3}, null, a0.i(sVar)));
    }

    public final <R> e<R> g0(o<R> oVar, rx.functions.c<R, ? super T> cVar) {
        return I6(new rx.internal.operators.x(this, oVar, cVar));
    }

    public final <U, R> e<R> g2(p<? super T, ? extends e<? extends U>> pVar, q<? super T, ? super U, ? extends R> qVar, int i6) {
        return i3(a3(new m2(pVar, qVar)), i6);
    }

    public final e<T> g6(long j6, TimeUnit timeUnit, e<? extends T> eVar, h hVar) {
        return I6(new g1(this, j6, timeUnit, hVar, eVar));
    }

    public final <T1, T2, R> e<R> g7(e<T1> eVar, e<T2> eVar2, r<? super T, ? super T1, ? super T2, R> rVar) {
        return I6(new e4(this, new e[]{eVar, eVar2}, null, a0.h(rVar)));
    }

    public final <U, R> e<R> h7(e<? extends U> eVar, q<? super T, ? super U, ? extends R> qVar) {
        return a3(new d4(eVar, qVar));
    }

    public final e<Long> i1() {
        return e4(0L, InternalObservableUtils.LONG_COUNTER);
    }

    public final <R> e<R> i7(e<?>[] eVarArr, y<R> yVar) {
        return I6(new e4(this, eVarArr, null, yVar));
    }

    public final e<T> j2(p<? super T, ? extends rx.b> pVar, boolean z5, int i6) {
        return I6(new i0(this, pVar, z5, i6));
    }

    public final <U, V> e<T> j6(o<? extends e<U>> oVar, p<? super T, ? extends e<V>> pVar, e<? extends T> eVar) {
        if (pVar != null) {
            return I6(new f1(this, oVar != null ? r1(oVar) : null, pVar, eVar));
        }
        throw new NullPointerException("timeoutSelector is null");
    }

    public final <R> e<R> k2(p<? super T, ? extends Iterable<? extends R>> pVar) {
        return l2(pVar, rx.internal.util.j.f54163d);
    }

    public final e<T> o1(long j6, TimeUnit timeUnit, h hVar) {
        return (e<T>) a3(new w1(j6, timeUnit, hVar));
    }

    public final <U> e<T> p1(p<? super T, ? extends e<U>> pVar) {
        return (e<T>) a3(new v1(pVar));
    }

    public final <R> e<R> p4(p<? super e<T>, ? extends e<R>> pVar, int i6, long j6, TimeUnit timeUnit, h hVar) {
        if (i6 >= 0) {
            return w2.H7(InternalObservableUtils.createReplaySupplier(this, i6, j6, timeUnit, hVar), pVar);
        }
        throw new IllegalArgumentException("bufferSize < 0");
    }

    public final <R> e<R> q2(p<? super T, ? extends i<? extends R>> pVar, boolean z5, int i6) {
        return I6(new j0(this, pVar, z5, i6));
    }

    public final m q5(f<? super T> fVar) {
        if (fVar instanceof l) {
            return r5((l) fVar);
        }
        if (fVar != null) {
            return r5(new rx.internal.util.g(fVar));
        }
        throw new NullPointerException("observer is null");
    }

    public final e<rx.schedulers.f<T>> r6(h hVar) {
        return (e<rx.schedulers.f<T>>) a3(new u3(hVar));
    }

    public final e<T> t1(long j6, TimeUnit timeUnit, h hVar) {
        return (e<T>) a3(new x1(j6, timeUnit, hVar));
    }

    public final m t5(rx.functions.b<? super T> bVar) {
        if (bVar != null) {
            return r5(new rx.internal.util.c(bVar, InternalObservableUtils.ERROR_NOT_IMPLEMENTED, rx.functions.m.a()));
        }
        throw new IllegalArgumentException("onNext can not be null");
    }

    public final m u5(rx.functions.b<? super T> bVar, rx.functions.b<Throwable> bVar2) {
        if (bVar == null) {
            throw new IllegalArgumentException("onNext can not be null");
        }
        if (bVar2 != null) {
            return r5(new rx.internal.util.c(bVar, bVar2, rx.functions.m.a()));
        }
        throw new IllegalArgumentException("onError can not be null");
    }

    public final <T2, R> e<R> u7(Iterable<? extends T2> iterable, q<? super T, ? super T2, ? extends R> qVar) {
        return a3(new g4(iterable, qVar));
    }

    public final <U> e<T> v1(p<? super T, ? extends e<U>> pVar) {
        return (e<T>) a3(new y1(this, pVar));
    }

    public final m v5(rx.functions.b<? super T> bVar, rx.functions.b<Throwable> bVar2, rx.functions.a aVar) {
        if (bVar == null) {
            throw new IllegalArgumentException("onNext can not be null");
        }
        if (bVar2 == null) {
            throw new IllegalArgumentException("onError can not be null");
        }
        if (aVar != null) {
            return r5(new rx.internal.util.c(bVar, bVar2, aVar));
        }
        throw new IllegalArgumentException("onComplete can not be null");
    }

    public final e<T> w5(h hVar) {
        return x5(hVar, !(this.f52396a instanceof rx.internal.operators.a0));
    }

    public final <K> e<Map<K, T>> w6(p<? super T, ? extends K> pVar) {
        return I6(new j1(this, pVar, n.c()));
    }

    public final e<T> x1(long j6, TimeUnit timeUnit, h hVar) {
        return I6(new c0(this, j6, timeUnit, hVar));
    }

    public final rx.observables.c<T> x4(int i6, long j6, TimeUnit timeUnit, h hVar) {
        if (i6 >= 0) {
            return w2.F7(this, j6, timeUnit, hVar, i6);
        }
        throw new IllegalArgumentException("bufferSize < 0");
    }

    public final e<T> x5(h hVar, boolean z5) {
        return this instanceof rx.internal.util.k ? ((rx.internal.util.k) this).A7(hVar) : I6(new j3(this, hVar, z5));
    }

    public final <K, V> e<Map<K, V>> x6(p<? super T, ? extends K> pVar, p<? super T, ? extends V> pVar2) {
        return I6(new j1(this, pVar, pVar2));
    }

    public final e<T> y5(e<? extends T> eVar) {
        if (eVar != null) {
            return I6(new c1(this, eVar));
        }
        throw new NullPointerException("alternate is null");
    }

    public final <K, V> e<Map<K, V>> y6(p<? super T, ? extends K> pVar, p<? super T, ? extends V> pVar2, o<? extends Map<K, V>> oVar) {
        return I6(new j1(this, pVar, pVar2, oVar));
    }

    public final <U> e<T> z1(o<? extends e<U>> oVar) {
        return I6(new e0(this, oVar));
    }

    public final <K> e<Map<K, Collection<T>>> z6(p<? super T, ? extends K> pVar) {
        return I6(new k1(this, pVar, n.c()));
    }

    protected e(a<T> aVar) {
        this.f52396a = aVar;
    }

    public static <T> e<T> A(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4, e<? extends T> eVar5, e<? extends T> eVar6) {
        return I6(rx.internal.operators.w.f(eVar, eVar2, eVar3, eVar4, eVar5, eVar6));
    }

    public static <T> e<T> A0(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4, e<? extends T> eVar5, e<? extends T> eVar6, e<? extends T> eVar7) {
        return u0(S2(eVar, eVar2, eVar3, eVar4, eVar5, eVar6, eVar7));
    }

    public static <T> e<T> A3(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4, e<? extends T> eVar5) {
        return v3(Q2(eVar, eVar2, eVar3, eVar4, eVar5));
    }

    public static <T> e<T> B(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4, e<? extends T> eVar5, e<? extends T> eVar6, e<? extends T> eVar7) {
        return I6(rx.internal.operators.w.g(eVar, eVar2, eVar3, eVar4, eVar5, eVar6, eVar7));
    }

    public static <T> e<T> B0(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4, e<? extends T> eVar5, e<? extends T> eVar6, e<? extends T> eVar7, e<? extends T> eVar8) {
        return u0(T2(eVar, eVar2, eVar3, eVar4, eVar5, eVar6, eVar7, eVar8));
    }

    public static <T> e<T> B3(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4, e<? extends T> eVar5, e<? extends T> eVar6) {
        return v3(R2(eVar, eVar2, eVar3, eVar4, eVar5, eVar6));
    }

    public static <T> e<T> C0(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4, e<? extends T> eVar5, e<? extends T> eVar6, e<? extends T> eVar7, e<? extends T> eVar8, e<? extends T> eVar9) {
        return u0(U2(eVar, eVar2, eVar3, eVar4, eVar5, eVar6, eVar7, eVar8, eVar9));
    }

    public static <T> e<T> C3(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4, e<? extends T> eVar5, e<? extends T> eVar6, e<? extends T> eVar7) {
        return v3(S2(eVar, eVar2, eVar3, eVar4, eVar5, eVar6, eVar7));
    }

    public static <T> e<T> D0(Iterable<? extends e<? extends T>> iterable) {
        return E0(u2(iterable));
    }

    public static <T> e<T> D3(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4, e<? extends T> eVar5, e<? extends T> eVar6, e<? extends T> eVar7, e<? extends T> eVar8) {
        return v3(T2(eVar, eVar2, eVar3, eVar4, eVar5, eVar6, eVar7, eVar8));
    }

    public static <T> e<T> E0(e<? extends e<? extends T>> eVar) {
        return (e<T>) eVar.a1(n.c());
    }

    public static <T> e<T> E3(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4, e<? extends T> eVar5, e<? extends T> eVar6, e<? extends T> eVar7, e<? extends T> eVar8, e<? extends T> eVar9) {
        return v3(U2(eVar, eVar2, eVar3, eVar4, eVar5, eVar6, eVar7, eVar8, eVar9));
    }

    public static <T> e<T> F0(e<? extends T> eVar, e<? extends T> eVar2) {
        return E0(N2(eVar, eVar2));
    }

    public static <T> e<T> G(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4, e<? extends T> eVar5, e<? extends T> eVar6, e<? extends T> eVar7, e<? extends T> eVar8) {
        return I6(rx.internal.operators.w.h(eVar, eVar2, eVar3, eVar4, eVar5, eVar6, eVar7, eVar8));
    }

    public static <T> e<T> G0(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3) {
        return E0(O2(eVar, eVar2, eVar3));
    }

    public static e<Long> G2(long j6, long j7, TimeUnit timeUnit) {
        return H2(j6, j7, timeUnit, rx.schedulers.c.a());
    }

    public static <T> e<T> H(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4, e<? extends T> eVar5, e<? extends T> eVar6, e<? extends T> eVar7, e<? extends T> eVar8, e<? extends T> eVar9) {
        return I6(rx.internal.operators.w.i(eVar, eVar2, eVar3, eVar4, eVar5, eVar6, eVar7, eVar8, eVar9));
    }

    public static <T> e<T> H0(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4) {
        return E0(P2(eVar, eVar2, eVar3, eVar4));
    }

    public static <T> e<T> H3() {
        return NeverObservableHolder.instance();
    }

    public static <T> e<T> I0(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4, e<? extends T> eVar5) {
        return E0(Q2(eVar, eVar2, eVar3, eVar4, eVar5));
    }

    public static e<Long> I2(long j6, TimeUnit timeUnit) {
        return H2(j6, j6, timeUnit, rx.schedulers.c.a());
    }

    public static <T> e<T> J0(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4, e<? extends T> eVar5, e<? extends T> eVar6) {
        return E0(R2(eVar, eVar2, eVar3, eVar4, eVar5, eVar6));
    }

    public static <T> e<T> K0(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4, e<? extends T> eVar5, e<? extends T> eVar6, e<? extends T> eVar7) {
        return E0(S2(eVar, eVar2, eVar3, eVar4, eVar5, eVar6, eVar7));
    }

    public static <T> e<T> L0(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4, e<? extends T> eVar5, e<? extends T> eVar6, e<? extends T> eVar7, e<? extends T> eVar8) {
        return E0(T2(eVar, eVar2, eVar3, eVar4, eVar5, eVar6, eVar7, eVar8));
    }

    public static <T> e<T> M0(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4, e<? extends T> eVar5, e<? extends T> eVar6, e<? extends T> eVar7, e<? extends T> eVar8, e<? extends T> eVar9) {
        return E0(U2(eVar, eVar2, eVar3, eVar4, eVar5, eVar6, eVar7, eVar8, eVar9));
    }

    public static <T> e<T> M2(T t5) {
        return rx.internal.util.k.w7(t5);
    }

    public static <T> e<T> N0(Iterable<? extends e<? extends T>> iterable) {
        return u2(iterable).b1(n.c());
    }

    public static <T> e<Boolean> N4(e<? extends T> eVar, e<? extends T> eVar2, q<? super T, ? super T, Boolean> qVar) {
        return b3.b(eVar, eVar2, qVar);
    }

    public static <T> e<T> O0(Iterable<? extends e<? extends T>> iterable, int i6) {
        return u2(iterable).c1(n.c(), i6);
    }

    public static <T> e<T> P0(e<? extends e<? extends T>> eVar) {
        return (e<T>) eVar.b1(n.c());
    }

    public static <T> e<T> Q0(e<? extends e<? extends T>> eVar, int i6) {
        return (e<T>) eVar.c1(n.c(), i6);
    }

    public static <T> e<T> S1() {
        return EmptyObservableHolder.instance();
    }

    public static e<Integer> c4(int i6, int i7, h hVar) {
        return b4(i6, i7).w5(hVar);
    }

    public static <T> e<T> e(Iterable<? extends e<? extends T>> iterable) {
        return I6(rx.internal.operators.w.a(iterable));
    }

    public static <T> e<T> f(e<? extends T> eVar, e<? extends T> eVar2) {
        return I6(rx.internal.operators.w.b(eVar, eVar2));
    }

    public static <T> e<T> f3(Iterable<? extends e<? extends T>> iterable) {
        return h3(u2(iterable));
    }

    public static <T> e<T> g(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3) {
        return I6(rx.internal.operators.w.c(eVar, eVar2, eVar3));
    }

    public static <T> e<T> g3(Iterable<? extends e<? extends T>> iterable, int i6) {
        return i3(u2(iterable), i6);
    }

    public static <T> e<T> h3(e<? extends e<? extends T>> eVar) {
        if (eVar.getClass() == rx.internal.util.k.class) {
            return ((rx.internal.util.k) eVar).z7(n.c());
        }
        return (e<T>) eVar.a3(o2.a(false));
    }

    public static <T> e<T> i3(e<? extends e<? extends T>> eVar, int i6) {
        if (eVar.getClass() == rx.internal.util.k.class) {
            return ((rx.internal.util.k) eVar).z7(n.c());
        }
        return (e<T>) eVar.a3(o2.b(false, i6));
    }

    public static <T> e<T> j(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4) {
        return I6(rx.internal.operators.w.d(eVar, eVar2, eVar3, eVar4));
    }

    @Beta
    public static <S, T> e<T> l1(rx.observables.a<S, T> aVar) {
        return I6(aVar);
    }

    public static <S, T> e<T> m1(rx.observables.e<S, T> eVar) {
        return I6(eVar);
    }

    @Deprecated
    public static e<Long> m6(long j6, long j7, TimeUnit timeUnit) {
        return H2(j6, j7, timeUnit, rx.schedulers.c.a());
    }

    @Deprecated
    public static e<Long> n6(long j6, long j7, TimeUnit timeUnit, h hVar) {
        return H2(j6, j7, timeUnit, hVar);
    }

    public static e<Long> o6(long j6, TimeUnit timeUnit) {
        return p6(j6, timeUnit, rx.schedulers.c.a());
    }

    public static <T> e<T> r3(e<? extends T>[] eVarArr) {
        return h3(y2(eVarArr));
    }

    public static <T> e<T> s(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4, e<? extends T> eVar5) {
        return I6(rx.internal.operators.w.e(eVar, eVar2, eVar3, eVar4, eVar5));
    }

    public static <T> e<T> s3(e<? extends T>[] eVarArr, int i6) {
        return i3(y2(eVarArr), i6);
    }

    public static <R> e<R> s7(e<? extends e<?>> eVar, y<? extends R> yVar) {
        return eVar.v6().c3(InternalObservableUtils.TO_ARRAY).a3(new f4(yVar));
    }

    public static <T> e<T> t0(Iterable<? extends e<? extends T>> iterable) {
        return u0(u2(iterable));
    }

    public static <T> e<T> t3(Iterable<? extends e<? extends T>> iterable) {
        return v3(u2(iterable));
    }

    public static <R> e<R> t7(e<?>[] eVarArr, y<? extends R> yVar) {
        return M2(eVarArr).a3(new f4(yVar));
    }

    public static <T> e<T> u0(e<? extends e<? extends T>> eVar) {
        return (e<T>) eVar.Z0(n.c());
    }

    public static <T> e<T> u3(Iterable<? extends e<? extends T>> iterable, int i6) {
        return w3(u2(iterable), i6);
    }

    public static <T> e<T> v0(e<? extends T> eVar, e<? extends T> eVar2) {
        return u0(N2(eVar, eVar2));
    }

    public static <T> e<T> v2(Future<? extends T> future) {
        return I6(l1.a(future));
    }

    public static <T> e<T> w0(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3) {
        return u0(O2(eVar, eVar2, eVar3));
    }

    public static <T> e<T> w2(Future<? extends T> future, long j6, TimeUnit timeUnit) {
        return I6(l1.b(future, j6, timeUnit));
    }

    public static <T> e<T> x0(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4) {
        return u0(P2(eVar, eVar2, eVar3, eVar4));
    }

    public static <T> e<T> x2(Future<? extends T> future, h hVar) {
        return I6(l1.a(future)).w5(hVar);
    }

    public static <T> e<T> x3(e<? extends T> eVar, e<? extends T> eVar2) {
        return v3(N2(eVar, eVar2));
    }

    public static <T> e<T> y0(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4, e<? extends T> eVar5) {
        return u0(Q2(eVar, eVar2, eVar3, eVar4, eVar5));
    }

    public static <T> e<T> y3(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3) {
        return v3(O2(eVar, eVar2, eVar3));
    }

    public static <T> e<T> z0(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4, e<? extends T> eVar5, e<? extends T> eVar6) {
        return u0(R2(eVar, eVar2, eVar3, eVar4, eVar5, eVar6));
    }

    public static <T> e<T> z3(e<? extends T> eVar, e<? extends T> eVar2, e<? extends T> eVar3, e<? extends T> eVar4) {
        return v3(P2(eVar, eVar2, eVar3, eVar4));
    }

    public final <T2> e<T2> A1() {
        return (e<T2>) a3(z1.a());
    }

    public final rx.observables.c<T> A4(long j6, TimeUnit timeUnit, h hVar) {
        return w2.E7(this, j6, timeUnit, hVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> e<R> A5(p<? super T, ? extends e<? extends R>> pVar) {
        return C5(c3(pVar));
    }

    public final e<T> B1() {
        return (e<T>) a3(a2.a());
    }

    public final rx.observables.c<T> B4(h hVar) {
        return w2.I7(u4(), hVar);
    }

    public final e<T> C4() {
        return w0.h(this);
    }

    public final e<T> D1() {
        return (e<T>) a3(b2.a());
    }

    public final e<T> D4(long j6) {
        return w0.i(this, j6);
    }

    public final e<T> E4(q<Integer, Throwable, Boolean> qVar) {
        return (e<T>) G3().a3(new x2(qVar));
    }

    public final e<T> E5(long j6, TimeUnit timeUnit) {
        return F5(j6, timeUnit, rx.schedulers.c.a());
    }

    public final e<T> F2() {
        return (e<T>) a3(k2.a());
    }

    public final e<T> F3(e<? extends T> eVar) {
        return j3(this, eVar);
    }

    public final e<T> F4(p<? super e<? extends Throwable>, ? extends e<?>> pVar) {
        return w0.j(this, InternalObservableUtils.createRetryDematerializer(pVar));
    }

    public final e<e<T>> G3() {
        return M2(this);
    }

    public final e<T> G4(p<? super e<? extends Throwable>, ? extends e<?>> pVar, h hVar) {
        return w0.k(this, InternalObservableUtils.createRetryDematerializer(pVar), hVar);
    }

    public final e<T> G5(p<? super T, Boolean> pVar) {
        return V1(pVar).D5(1);
    }

    public final e<T> H1(rx.functions.a aVar) {
        return I6(new g0(this, new rx.internal.util.b(rx.functions.m.a(), rx.functions.m.a(), aVar)));
    }

    public final e<T> H4(long j6, TimeUnit timeUnit) {
        return I4(j6, timeUnit, rx.schedulers.c.a());
    }

    public final e<T> I5(int i6, long j6, TimeUnit timeUnit) {
        return J5(i6, j6, timeUnit, rx.schedulers.c.a());
    }

    public final m J6(l<? super T> lVar) {
        try {
            lVar.onStart();
            rx.plugins.c.O(this, this.f52396a).call(lVar);
            return rx.plugins.c.N(lVar);
        } catch (Throwable th) {
            rx.exceptions.a.e(th);
            try {
                lVar.onError(rx.plugins.c.L(th));
                return rx.subscriptions.f.e();
            } catch (Throwable th2) {
                rx.exceptions.a.e(th2);
                OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                rx.plugins.c.L(onErrorFailedException);
                throw onErrorFailedException;
            }
        }
    }

    public final e<T> K1(rx.functions.b<? super Throwable> bVar) {
        return I6(new g0(this, new rx.internal.util.b(rx.functions.m.a(), bVar, rx.functions.m.a())));
    }

    public final e<T> K5(long j6, TimeUnit timeUnit) {
        return L5(j6, timeUnit, rx.schedulers.c.a());
    }

    public final e<T> L1(rx.functions.b<? super T> bVar) {
        return I6(new g0(this, new rx.internal.util.b(bVar, rx.functions.m.a(), rx.functions.m.a())));
    }

    public final <R> e<R> M3(Class<R> cls) {
        return V1(InternalObservableUtils.isInstanceOf(cls)).f0(cls);
    }

    public final e<List<T>> M5(int i6) {
        return H5(i6).v6();
    }

    public final e<T> N(e<? extends T> eVar) {
        return f(this, eVar);
    }

    public final e<T> N3() {
        return (e<T>) a3(r2.a());
    }

    public final e<List<T>> N5(int i6, long j6, TimeUnit timeUnit) {
        return I5(i6, j6, timeUnit).v6();
    }

    public final e<e<T>> N6(int i6) {
        return O6(i6, i6);
    }

    public final e<T> O1(rx.functions.a aVar) {
        return I6(new g0(this, new rx.internal.util.b(rx.functions.m.a(), rx.functions.m.c(aVar), aVar)));
    }

    public final e<T> O4() {
        return (e<T>) a3(c3.a());
    }

    public final e<List<T>> O5(int i6, long j6, TimeUnit timeUnit, h hVar) {
        return J5(i6, j6, timeUnit, hVar).v6();
    }

    public final e<T> P() {
        return (e<T>) a3(p1.a());
    }

    public final e<T> P4() {
        return a4().B7();
    }

    public final e<List<T>> P5(long j6, TimeUnit timeUnit) {
        return K5(j6, timeUnit).v6();
    }

    public final e<e<T>> P6(long j6, long j7, TimeUnit timeUnit) {
        return Q6(j6, j7, timeUnit, Integer.MAX_VALUE, rx.schedulers.c.a());
    }

    public final e<List<T>> Q(int i6) {
        return R(i6, i6);
    }

    public final e<T> Q4() {
        return (e<T>) a3(d3.a());
    }

    public final e<List<T>> Q5(long j6, TimeUnit timeUnit, h hVar) {
        return L5(j6, timeUnit, hVar).v6();
    }

    public final e<T> R3() {
        return (e<T>) a3(s2.a());
    }

    public final e<T> R4(p<? super T, Boolean> pVar) {
        return V1(pVar).Q4();
    }

    public final e<e<T>> R6(long j6, long j7, TimeUnit timeUnit, h hVar) {
        return Q6(j6, j7, timeUnit, Integer.MAX_VALUE, hVar);
    }

    public final e<List<T>> S(long j6, long j7, TimeUnit timeUnit) {
        return T(j6, j7, timeUnit, rx.schedulers.c.a());
    }

    public final e<e<T>> S6(long j6, TimeUnit timeUnit) {
        return R6(j6, j6, timeUnit, rx.schedulers.c.a());
    }

    public final e<T> T3() {
        return (e<T>) a3(t2.a());
    }

    public final e<T> T4(T t5, p<? super T, Boolean> pVar) {
        return V1(pVar).S4(t5);
    }

    public final e<e<T>> T6(long j6, TimeUnit timeUnit, int i6) {
        return U6(j6, timeUnit, i6, rx.schedulers.c.a());
    }

    public final e<List<T>> U(long j6, TimeUnit timeUnit) {
        return W(j6, timeUnit, Integer.MAX_VALUE, rx.schedulers.c.a());
    }

    public final e<T> U3(e<? extends T> eVar) {
        return (e<T>) a3(u2.b(eVar));
    }

    public final e<T> V4(long j6, TimeUnit timeUnit) {
        return W4(j6, timeUnit, rx.schedulers.c.a());
    }

    public final rx.observers.a<T> V5(long j6) {
        l5.a g6 = l5.a.g(j6);
        q5(g6);
        return g6;
    }

    public final e<e<T>> V6(long j6, TimeUnit timeUnit, h hVar) {
        return U6(j6, timeUnit, Integer.MAX_VALUE, hVar);
    }

    public final e<T> W3(p<? super Throwable, ? extends T> pVar) {
        return (e<T>) a3(u2.c(pVar));
    }

    public final e<T> W5(long j6, TimeUnit timeUnit) {
        return X5(j6, timeUnit, rx.schedulers.c.a());
    }

    public final e<T> X2(p<? super T, Boolean> pVar) {
        return V1(pVar).H5(1).Q4();
    }

    public final e<T> X3(e<? extends T> eVar) {
        return (e<T>) a3(u2.a(eVar));
    }

    public final e<T> Y1(p<? super T, Boolean> pVar) {
        return G5(pVar).Q4();
    }

    public final e<T> Y4(long j6, TimeUnit timeUnit) {
        return Z4(j6, timeUnit, rx.schedulers.c.a());
    }

    public final e<T> Y5(long j6, TimeUnit timeUnit) {
        return H4(j6, timeUnit);
    }

    public final e<T> Z2(T t5, p<? super T, Boolean> pVar) {
        return V1(pVar).H5(1).S4(t5);
    }

    public final <R> e<R> Z3(p<? super e<T>, ? extends e<R>> pVar) {
        return v2.C7(this, pVar);
    }

    public final e<T> Z5(long j6, TimeUnit timeUnit, h hVar) {
        return I4(j6, timeUnit, hVar);
    }

    public final e<T> a2(T t5, p<? super T, Boolean> pVar) {
        return G5(pVar).S4(t5);
    }

    public final rx.observables.c<T> a4() {
        return v2.E7(this);
    }

    public final e<T> a6(long j6, TimeUnit timeUnit) {
        return n1(j6, timeUnit);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> e<R> b2(p<? super T, ? extends e<? extends R>> pVar) {
        if (getClass() == rx.internal.util.k.class) {
            return ((rx.internal.util.k) this).z7(pVar);
        }
        return h3(c3(pVar));
    }

    public final e<T> b3(int i6) {
        return D5(i6);
    }

    public final e<T> b6(long j6, TimeUnit timeUnit, h hVar) {
        return o1(j6, timeUnit, hVar);
    }

    public final e<T> c0() {
        return rx.internal.operators.h.w7(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> e<R> c2(p<? super T, ? extends e<? extends R>> pVar, int i6) {
        if (getClass() == rx.internal.util.k.class) {
            return ((rx.internal.util.k) this).z7(pVar);
        }
        return i3(c3(pVar), i6);
    }

    public final e<T> c5() {
        return (e<T>) E6().k2(n.c());
    }

    public final e<rx.schedulers.e<T>> c6() {
        return d6(rx.schedulers.c.a());
    }

    @Deprecated
    public final e<T> d0(int i6) {
        return e0(i6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> e<R> d2(p<? super T, ? extends e<? extends R>> pVar, p<? super Throwable, ? extends e<? extends R>> pVar2, o<? extends e<? extends R>> oVar) {
        return h3(d3(pVar, pVar2, oVar));
    }

    public final e<T> d5(q<? super T, ? super T, Integer> qVar) {
        return (e<T>) G6(qVar).k2(n.c());
    }

    public final e<T> e0(int i6) {
        return rx.internal.operators.h.x7(this, i6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> e<R> e2(p<? super T, ? extends e<? extends R>> pVar, p<? super Throwable, ? extends e<? extends R>> pVar2, o<? extends e<? extends R>> oVar, int i6) {
        return i3(d3(pVar, pVar2, oVar), i6);
    }

    public final e<Notification<T>> e3() {
        return (e<Notification<T>>) a3(n2.a());
    }

    public final e<T> e5(Iterable<T> iterable) {
        return v0(u2(iterable), this);
    }

    public final e<T> f1(e<? extends T> eVar) {
        return v0(this, eVar);
    }

    public final e<T> f5(T t5) {
        return v0(M2(t5), this);
    }

    public final e<T> f6(long j6, TimeUnit timeUnit, e<? extends T> eVar) {
        return g6(j6, timeUnit, eVar, rx.schedulers.c.a());
    }

    public final e<Boolean> g1(Object obj) {
        return U1(InternalObservableUtils.equalsWith(obj));
    }

    public final e<T> g4() {
        return w0.b(this);
    }

    public final e<T> g5(T t5, T t6) {
        return v0(N2(t5, t6), this);
    }

    public final e<T> h4(long j6) {
        return w0.c(this, j6);
    }

    public final e<T> h5(T t5, T t6, T t7) {
        return v0(O2(t5, t6, t7), this);
    }

    public final e<T> i2(p<? super T, ? extends rx.b> pVar, boolean z5) {
        return j2(pVar, z5, Integer.MAX_VALUE);
    }

    public final e<T> i4(long j6, h hVar) {
        return w0.d(this, j6, hVar);
    }

    public final e<T> i5(T t5, T t6, T t7, T t8) {
        return v0(P2(t5, t6, t7, t8), this);
    }

    public final e<T> j4(h hVar) {
        return w0.e(this, hVar);
    }

    public final e<T> j5(T t5, T t6, T t7, T t8, T t9) {
        return v0(Q2(t5, t6, t7, t8, t9), this);
    }

    public final e<T> k4(p<? super e<? extends Void>, ? extends e<?>> pVar) {
        return w0.f(this, InternalObservableUtils.createRepeatDematerializer(pVar));
    }

    public final e<T> k5(T t5, T t6, T t7, T t8, T t9, T t10) {
        return v0(R2(t5, t6, t7, t8, t9, t10), this);
    }

    public final <R> e<R> l2(p<? super T, ? extends Iterable<? extends R>> pVar, int i6) {
        return k0.a(this, pVar, i6);
    }

    public final e<T> l4(p<? super e<? extends Void>, ? extends e<?>> pVar, h hVar) {
        return w0.g(this, InternalObservableUtils.createRepeatDematerializer(pVar), hVar);
    }

    public final e<T> l5(T t5, T t6, T t7, T t8, T t9, T t10, T t11) {
        return v0(S2(t5, t6, t7, t8, t9, t10, t11), this);
    }

    public final <U, R> e<R> m2(p<? super T, ? extends Iterable<? extends U>> pVar, q<? super T, ? super U, ? extends R> qVar) {
        return f2(m2.a(pVar), qVar);
    }

    public final <R> e<R> m4(p<? super e<T>, ? extends e<R>> pVar) {
        return w2.H7(InternalObservableUtils.createReplaySupplier(this), pVar);
    }

    public final e<T> m5(T t5, T t6, T t7, T t8, T t9, T t10, T t11, T t12) {
        return v0(T2(t5, t6, t7, t8, t9, t10, t11, t12), this);
    }

    public final e<T> n1(long j6, TimeUnit timeUnit) {
        return o1(j6, timeUnit, rx.schedulers.c.a());
    }

    public final <U, R> e<R> n2(p<? super T, ? extends Iterable<? extends U>> pVar, q<? super T, ? super U, ? extends R> qVar, int i6) {
        return g2(m2.a(pVar), qVar, i6);
    }

    public final <R> e<R> n4(p<? super e<T>, ? extends e<R>> pVar, int i6) {
        return w2.H7(InternalObservableUtils.createReplaySupplier(this, i6), pVar);
    }

    public final e<T> n5(T t5, T t6, T t7, T t8, T t9, T t10, T t11, T t12, T t13) {
        return v0(U2(t5, t6, t7, t8, t9, t10, t11, t12, t13), this);
    }

    public final <R> e<R> o4(p<? super e<T>, ? extends e<R>> pVar, int i6, long j6, TimeUnit timeUnit) {
        return p4(pVar, i6, j6, timeUnit, rx.schedulers.c.a());
    }

    public final e<T> o5(e<T> eVar) {
        return v0(eVar, this);
    }

    public final <R> e<R> p2(p<? super T, ? extends i<? extends R>> pVar, boolean z5) {
        return q2(pVar, z5, Integer.MAX_VALUE);
    }

    public final m p5() {
        return r5(new rx.internal.util.c(rx.functions.m.a(), InternalObservableUtils.ERROR_NOT_IMPLEMENTED, rx.functions.m.a()));
    }

    public final e<T> q1(T t5) {
        return y5(M2(t5));
    }

    public final <R> e<R> q4(p<? super e<T>, ? extends e<R>> pVar, int i6, h hVar) {
        return w2.H7(InternalObservableUtils.createReplaySupplier(this, i6), InternalObservableUtils.createReplaySelectorAndObserveOn(pVar, hVar));
    }

    public final e<rx.schedulers.f<T>> q6() {
        return r6(rx.schedulers.c.a());
    }

    public final void r2(rx.functions.b<? super T> bVar) {
        t5(bVar);
    }

    public final <R> e<R> r4(p<? super e<T>, ? extends e<R>> pVar, long j6, TimeUnit timeUnit) {
        return s4(pVar, j6, timeUnit, rx.schedulers.c.a());
    }

    public final m r5(l<? super T> lVar) {
        return s5(lVar, this);
    }

    public <R> e<R> s0(c<? super T, ? extends R> cVar) {
        return (e) cVar.call(this);
    }

    public final e<T> s1(long j6, TimeUnit timeUnit) {
        return t1(j6, timeUnit, rx.schedulers.c.a());
    }

    public final void s2(rx.functions.b<? super T> bVar, rx.functions.b<Throwable> bVar2) {
        u5(bVar, bVar2);
    }

    public final <R> e<R> s4(p<? super e<T>, ? extends e<R>> pVar, long j6, TimeUnit timeUnit, h hVar) {
        return w2.H7(InternalObservableUtils.createReplaySupplier(this, j6, timeUnit, hVar), pVar);
    }

    public final <R> R s6(p<? super e<T>, R> pVar) {
        return pVar.call(this);
    }

    public final void t2(rx.functions.b<? super T> bVar, rx.functions.b<Throwable> bVar2, rx.functions.a aVar) {
        v5(bVar, bVar2, aVar);
    }

    public final <R> e<R> t4(p<? super e<T>, ? extends e<R>> pVar, h hVar) {
        return w2.H7(InternalObservableUtils.createReplaySupplier(this), InternalObservableUtils.createReplaySelectorAndObserveOn(pVar, hVar));
    }

    public final rx.observables.b<T> t6() {
        return rx.observables.b.g(this);
    }

    public final <U, V> e<T> u1(o<? extends e<U>> oVar, p<? super T, ? extends e<V>> pVar) {
        return (e<T>) z1(oVar).a3(new y1(this, pVar));
    }

    public final rx.observables.c<T> u4() {
        return w2.C7(this);
    }

    public rx.b u6() {
        return rx.b.J(this);
    }

    public final rx.observables.c<T> v4(int i6) {
        return w2.D7(this, i6);
    }

    public final e<List<T>> v6() {
        return (e<List<T>>) a3(v3.a());
    }

    public final <T2, R> e<R> v7(e<? extends T2> eVar, q<? super T, ? super T2, ? extends R> qVar) {
        return r7(this, eVar, qVar);
    }

    public final e<T> w1(long j6, TimeUnit timeUnit) {
        return x1(j6, timeUnit, rx.schedulers.c.a());
    }

    public final rx.observables.c<T> w4(int i6, long j6, TimeUnit timeUnit) {
        return x4(i6, j6, timeUnit, rx.schedulers.c.a());
    }

    public final <U> e<T> y1(e<U> eVar) {
        eVar.getClass();
        return I6(new d0(this, eVar));
    }

    public final rx.observables.c<T> y4(int i6, h hVar) {
        return w2.I7(v4(i6), hVar);
    }

    public final rx.observables.c<T> z4(long j6, TimeUnit timeUnit) {
        return A4(j6, timeUnit, rx.schedulers.c.a());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> e<R> z5(p<? super T, ? extends e<? extends R>> pVar) {
        return B5(c3(pVar));
    }

    public final rx.observers.a<T> U5() {
        l5.a g6 = l5.a.g(Long.MAX_VALUE);
        q5(g6);
        return g6;
    }
}
