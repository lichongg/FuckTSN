package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.PublishedApi;
import kotlin.jvm.JvmName;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.e2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@PublishedApi
@SourceDebugExtension({"SMAP\nCancellableContinuationImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CancellableContinuationImpl.kt\nkotlinx/coroutines/CancellableContinuationImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 CancellableContinuationImpl.kt\nkotlinx/coroutines/CancellableContinuationImplKt\n+ 4 CompletionHandler.kt\nkotlinx/coroutines/CompletionHandlerKt\n+ 5 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n*L\n1#1,662:1\n230#1,2:666\n232#1,8:669\n230#1,10:677\n230#1,10:688\n1#2:663\n24#3:664\n24#3:665\n22#3:687\n21#3:698\n22#3,3:699\n21#3:702\n22#3,3:703\n22#3:711\n21#3,4:712\n22#4:668\n13#4:710\n61#5,2:706\n61#5,2:708\n61#5,2:716\n*S KotlinDebug\n*F\n+ 1 CancellableContinuationImpl.kt\nkotlinx/coroutines/CancellableContinuationImpl\n*L\n246#1:666,2\n246#1:669,8\n249#1:677,10\n254#1:688,10\n72#1:664\n158#1:665\n252#1:687\n277#1:698\n278#1:699,3\n287#1:702\n288#1:703,3\n389#1:711\n392#1:712,4\n246#1:668\n350#1:710\n329#1:706,2\n339#1:708,2\n613#1:716,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public class q<T> extends d1<T> implements p<T>, kotlin.coroutines.jvm.internal.c, r3 {

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final AtomicIntegerFieldUpdater f49420f = AtomicIntegerFieldUpdater.newUpdater(q.class, "_decisionAndIndex");

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private static final AtomicReferenceFieldUpdater f49421g = AtomicReferenceFieldUpdater.newUpdater(q.class, Object.class, "_state");

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private static final AtomicReferenceFieldUpdater f49422h = AtomicReferenceFieldUpdater.newUpdater(q.class, Object.class, "_parentHandle");

    @Volatile
    private volatile int _decisionAndIndex;

    @Volatile
    @Nullable
    private volatile Object _parentHandle;

    @Volatile
    @Nullable
    private volatile Object _state;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final kotlin.coroutines.e<T> f49423d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private final kotlin.coroutines.i f49424e;

    @Override // kotlinx.coroutines.p
    @Nullable
    public Object C(T t5, @Nullable Object obj) {
        return W(t5, obj, null);
    }

    @Override // kotlin.coroutines.jvm.internal.c
    @Nullable
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    private final void D(Object obj) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f49421g;
        while (true) {
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (!(obj2 instanceof d)) {
                if (obj2 instanceof n ? true : obj2 instanceof kotlinx.coroutines.internal.p0) {
                    K(obj, obj2);
                } else {
                    if (obj2 instanceof d0) {
                        d0 d0Var = (d0) obj2;
                        if (!d0Var.b()) {
                            K(obj, obj2);
                        }
                        if (obj2 instanceof t) {
                            Throwable th = d0Var.f48476a;
                            if (obj instanceof n) {
                                m((n) obj, th);
                                return;
                            } else {
                                kotlin.jvm.internal.g0.n(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.Segment<*>");
                                q((kotlinx.coroutines.internal.p0) obj, th);
                                return;
                            }
                        }
                        return;
                    }
                    if (obj2 instanceof c0) {
                        c0 c0Var = (c0) obj2;
                        if (c0Var.f48106b != null) {
                            K(obj, obj2);
                        }
                        if (obj instanceof kotlinx.coroutines.internal.p0) {
                            return;
                        }
                        kotlin.jvm.internal.g0.n(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
                        n nVar = (n) obj;
                        if (c0Var.h()) {
                            m(nVar, c0Var.f48109e);
                            return;
                        } else {
                            if (androidx.concurrent.futures.a.a(f49421g, this, obj2, c0.g(c0Var, null, nVar, null, null, null, 29, null))) {
                                return;
                            }
                        }
                    } else {
                        if (obj instanceof kotlinx.coroutines.internal.p0) {
                            return;
                        }
                        kotlin.jvm.internal.g0.n(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
                        if (androidx.concurrent.futures.a.a(f49421g, this, obj2, new c0(obj2, (n) obj, null, null, null, 28, null))) {
                            return;
                        }
                    }
                }
            } else if (androidx.concurrent.futures.a.a(f49421g, this, obj2, obj)) {
                return;
            }
        }
    }

    private final boolean E() {
        if (!e1.d(this.f48477c)) {
            return false;
        }
        kotlin.coroutines.e<T> eVar = this.f49423d;
        kotlin.jvm.internal.g0.n(eVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        return ((kotlinx.coroutines.internal.l) eVar).q();
    }

    private final n H(Function1<? super Throwable, kotlin.n1> function1) {
        return function1 instanceof n ? (n) function1 : new b2(function1);
    }

    private final void K(Object obj, Object obj2) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + obj + ", already has " + obj2).toString());
    }

    private final void S(Object obj, int i6, Function1<? super Throwable, kotlin.n1> function1) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f49421g;
        while (true) {
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (!(obj2 instanceof t2)) {
                Object obj3 = obj;
                Function1<? super Throwable, kotlin.n1> function12 = function1;
                if (obj2 instanceof t) {
                    t tVar = (t) obj2;
                    if (tVar.c()) {
                        if (function12 != null) {
                            p(function12, tVar.f48476a);
                            return;
                        }
                        return;
                    }
                }
                k(obj3);
                throw new KotlinNothingValueException();
            }
            Object obj4 = obj;
            int i7 = i6;
            Function1<? super Throwable, kotlin.n1> function13 = function1;
            if (androidx.concurrent.futures.a.a(f49421g, this, obj2, U((t2) obj2, obj4, i7, function13, null))) {
                t();
                u(i7);
                return;
            } else {
                obj = obj4;
                i6 = i7;
                function1 = function13;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void T(q qVar, Object obj, int i6, Function1 function1, int i7, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resumeImpl");
        }
        if ((i7 & 4) != 0) {
            function1 = null;
        }
        qVar.S(obj, i6, function1);
    }

    private final Object U(t2 t2Var, Object obj, int i6, Function1<? super Throwable, kotlin.n1> function1, Object obj2) {
        if (obj instanceof d0) {
            return obj;
        }
        if ((e1.c(i6) || obj2 != null) && !(function1 == null && !(t2Var instanceof n) && obj2 == null)) {
            return new c0(obj, t2Var instanceof n ? (n) t2Var : null, function1, obj2, null, 16, null);
        }
        return obj;
    }

    private final boolean V() {
        int i6;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f49420f;
        do {
            i6 = atomicIntegerFieldUpdater.get(this);
            int i7 = i6 >> 29;
            if (i7 != 0) {
                if (i7 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed");
            }
        } while (!f49420f.compareAndSet(this, i6, 1073741824 + (536870911 & i6)));
        return true;
    }

    private final kotlinx.coroutines.internal.s0 W(Object obj, Object obj2, Function1<? super Throwable, kotlin.n1> function1) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f49421g;
        while (true) {
            Object obj3 = atomicReferenceFieldUpdater.get(this);
            if (!(obj3 instanceof t2)) {
                Object obj4 = obj2;
                if ((obj3 instanceof c0) && obj4 != null && ((c0) obj3).f48108d == obj4) {
                    return r.f49434g;
                }
                return null;
            }
            Object obj5 = obj;
            Object obj6 = obj2;
            Function1<? super Throwable, kotlin.n1> function12 = function1;
            if (androidx.concurrent.futures.a.a(f49421g, this, obj3, U((t2) obj3, obj5, this.f48477c, function12, obj6))) {
                t();
                return r.f49434g;
            }
            obj = obj5;
            function1 = function12;
            obj2 = obj6;
        }
    }

    private final boolean X() {
        int i6;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f49420f;
        do {
            i6 = atomicIntegerFieldUpdater.get(this);
            int i7 = i6 >> 29;
            if (i7 != 0) {
                if (i7 == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended");
            }
        } while (!f49420f.compareAndSet(this, i6, 536870912 + (536870911 & i6)));
        return true;
    }

    private final Void k(Object obj) {
        throw new IllegalStateException(("Already resumed, but proposed with update " + obj).toString());
    }

    private final void q(kotlinx.coroutines.internal.p0<?> p0Var, Throwable th) {
        int i6 = f49420f.get(this) & 536870911;
        if (i6 == 536870911) {
            throw new IllegalStateException("The index for Segment.onCancellation(..) is broken");
        }
        try {
            p0Var.q(i6, th, getContext());
        } catch (Throwable th2) {
            o0.b(getContext(), new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    private final j1 w() {
        return (j1) f49422h.get(this);
    }

    @Override // kotlinx.coroutines.p
    public void B(@NotNull Object obj) {
        u(this.f48477c);
    }

    @Override // kotlinx.coroutines.p
    @Nullable
    public Object J(@NotNull Throwable th) {
        return W(new d0(th, false, 2, null), null, null);
    }

    @NotNull
    protected String L() {
        return "CancellableContinuation";
    }

    public final void N() {
        Throwable x5;
        kotlin.coroutines.e<T> eVar = this.f49423d;
        kotlinx.coroutines.internal.l lVar = eVar instanceof kotlinx.coroutines.internal.l ? (kotlinx.coroutines.internal.l) eVar : null;
        if (lVar == null || (x5 = lVar.x(this)) == null) {
            return;
        }
        s();
        a(x5);
    }

    @Override // kotlinx.coroutines.p
    public void P(@NotNull m0 m0Var, T t5) {
        kotlin.coroutines.e<T> eVar = this.f49423d;
        kotlinx.coroutines.internal.l lVar = eVar instanceof kotlinx.coroutines.internal.l ? (kotlinx.coroutines.internal.l) eVar : null;
        T(this, t5, (lVar != null ? lVar.f49277d : null) == m0Var ? 4 : this.f48477c, null, 4, null);
    }

    @JvmName(name = "resetStateReusable")
    public final boolean R() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f49421g;
        Object obj = atomicReferenceFieldUpdater.get(this);
        if ((obj instanceof c0) && ((c0) obj).f48108d != null) {
            s();
            return false;
        }
        f49420f.set(this, 536870911);
        atomicReferenceFieldUpdater.set(this, d.f48474a);
        return true;
    }

    @Override // kotlinx.coroutines.p
    public boolean a(@Nullable Throwable th) {
        Object obj;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f49421g;
        do {
            obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof t2)) {
                return false;
            }
        } while (!androidx.concurrent.futures.a.a(f49421g, this, obj, new t(this, th, (obj instanceof n) || (obj instanceof kotlinx.coroutines.internal.p0))));
        t2 t2Var = (t2) obj;
        if (t2Var instanceof n) {
            m((n) obj, th);
        } else if (t2Var instanceof kotlinx.coroutines.internal.p0) {
            q((kotlinx.coroutines.internal.p0) obj, th);
        }
        t();
        u(this.f48477c);
        return true;
    }

    @Override // kotlinx.coroutines.r3
    public void b(@NotNull kotlinx.coroutines.internal.p0<?> p0Var, int i6) {
        int i7;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f49420f;
        do {
            i7 = atomicIntegerFieldUpdater.get(this);
            if ((i7 & 536870911) != 536870911) {
                throw new IllegalStateException("invokeOnCancellation should be called at most once");
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i7, ((i7 >> 29) << 29) + i6));
        D(p0Var);
    }

    @Override // kotlinx.coroutines.d1
    public void d(@Nullable Object obj, @NotNull Throwable th) {
        Throwable th2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f49421g;
        while (true) {
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 instanceof t2) {
                throw new IllegalStateException("Not completed");
            }
            if (obj2 instanceof d0) {
                return;
            }
            if (obj2 instanceof c0) {
                c0 c0Var = (c0) obj2;
                if (c0Var.h()) {
                    throw new IllegalStateException("Must be called at most once");
                }
                Throwable th3 = th;
                th2 = th3;
                if (androidx.concurrent.futures.a.a(f49421g, this, obj2, c0.g(c0Var, null, null, null, null, th3, 15, null))) {
                    c0Var.i(this, th2);
                    return;
                }
            } else {
                th2 = th;
                if (androidx.concurrent.futures.a.a(f49421g, this, obj2, new c0(obj2, null, null, null, th2, 14, null))) {
                    return;
                }
            }
            th = th2;
        }
    }

    @Override // kotlinx.coroutines.d1
    @NotNull
    public final kotlin.coroutines.e<T> e() {
        return this.f49423d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.d1
    public <T> T g(@Nullable Object obj) {
        return obj instanceof c0 ? (T) ((c0) obj).f48105a : obj;
    }

    @Override // kotlin.coroutines.jvm.internal.c
    @Nullable
    public kotlin.coroutines.jvm.internal.c getCallerFrame() {
        kotlin.coroutines.e<T> eVar = this.f49423d;
        if (eVar instanceof kotlin.coroutines.jvm.internal.c) {
            return (kotlin.coroutines.jvm.internal.c) eVar;
        }
        return null;
    }

    @Override // kotlin.coroutines.e
    @NotNull
    public kotlin.coroutines.i getContext() {
        return this.f49424e;
    }

    @Override // kotlinx.coroutines.p
    public void h(@NotNull m0 m0Var, @NotNull Throwable th) {
        kotlin.coroutines.e<T> eVar = this.f49423d;
        kotlinx.coroutines.internal.l lVar = eVar instanceof kotlinx.coroutines.internal.l ? (kotlinx.coroutines.internal.l) eVar : null;
        T(this, new d0(th, false, 2, null), (lVar != null ? lVar.f49277d : null) == m0Var ? 4 : this.f48477c, null, 4, null);
    }

    @Override // kotlinx.coroutines.p
    public void o(T t5, @Nullable Function1<? super Throwable, kotlin.n1> function1) {
        S(t5, this.f48477c, function1);
    }

    @NotNull
    public String toString() {
        return L() + '(' + u0.c(this.f49423d) + "){" + z() + "}@" + u0.b(this);
    }

    @Nullable
    public final Object y() {
        return f49421g.get(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public q(@NotNull kotlin.coroutines.e<? super T> eVar, int i6) {
        super(i6);
        this.f49423d = eVar;
        this.f49424e = eVar.getContext();
        this._decisionAndIndex = 536870911;
        this._state = d.f48474a;
    }

    private final j1 A() {
        e2 e2Var = (e2) getContext().get(e2.f48569s0);
        if (e2Var == null) {
            return null;
        }
        j1 g6 = e2.a.g(e2Var, true, false, new u(this), 2, null);
        androidx.concurrent.futures.a.a(f49422h, this, null, g6);
        return g6;
    }

    private final void F(AtomicIntegerFieldUpdater atomicIntegerFieldUpdater, Function1<? super Integer, kotlin.n1> function1, Object obj) {
        while (true) {
            function1.invoke(Integer.valueOf(atomicIntegerFieldUpdater.get(obj)));
        }
    }

    private final void G(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Function1<Object, kotlin.n1> function1, Object obj) {
        while (true) {
            function1.invoke(atomicReferenceFieldUpdater.get(obj));
        }
    }

    private final void Y(AtomicIntegerFieldUpdater atomicIntegerFieldUpdater, Function1<? super Integer, Integer> function1, Object obj) {
        int i6;
        do {
            i6 = atomicIntegerFieldUpdater.get(obj);
        } while (!atomicIntegerFieldUpdater.compareAndSet(obj, i6, function1.invoke(Integer.valueOf(i6)).intValue()));
    }

    private final void l(Function1<? super Throwable, kotlin.n1> function1, Throwable th) {
        try {
            function1.invoke(th);
        } catch (Throwable th2) {
            o0.b(getContext(), new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    private final void n(Function0<kotlin.n1> function0) {
        try {
            function0.invoke();
        } catch (Throwable th) {
            o0.b(getContext(), new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th));
        }
    }

    private final boolean r(Throwable th) {
        if (!E()) {
            return false;
        }
        kotlin.coroutines.e<T> eVar = this.f49423d;
        kotlin.jvm.internal.g0.n(eVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        return ((kotlinx.coroutines.internal.l) eVar).s(th);
    }

    private final void t() {
        if (!E()) {
            s();
        }
    }

    private final void u(int i6) {
        if (V()) {
            return;
        }
        e1.a(this, i6);
    }

    private final String z() {
        Object y5 = y();
        if (y5 instanceof t2) {
            return "Active";
        }
        if (y5 instanceof t) {
            return "Cancelled";
        }
        return "Completed";
    }

    @Override // kotlinx.coroutines.p
    public void I(@NotNull Function1<? super Throwable, kotlin.n1> function1) {
        D(H(function1));
    }

    public final void M(@NotNull Throwable th) {
        if (r(th)) {
            return;
        }
        a(th);
        t();
    }

    @Override // kotlinx.coroutines.p
    @Nullable
    public Object O(T t5, @Nullable Object obj, @Nullable Function1<? super Throwable, kotlin.n1> function1) {
        return W(t5, obj, function1);
    }

    @Override // kotlinx.coroutines.p
    public void Q() {
        j1 A = A();
        if (A != null && isCompleted()) {
            A.dispose();
            f49422h.set(this, s2.f49445a);
        }
    }

    @Override // kotlinx.coroutines.d1
    @Nullable
    public Throwable f(@Nullable Object obj) {
        Throwable f6 = super.f(obj);
        if (f6 != null) {
            return f6;
        }
        return null;
    }

    @Override // kotlinx.coroutines.p
    public boolean isActive() {
        return y() instanceof t2;
    }

    @Override // kotlinx.coroutines.p
    public boolean isCancelled() {
        return y() instanceof t;
    }

    @Override // kotlinx.coroutines.p
    public boolean isCompleted() {
        return !(y() instanceof t2);
    }

    @Override // kotlinx.coroutines.d1
    @Nullable
    public Object j() {
        return y();
    }

    public final void m(@NotNull n nVar, @Nullable Throwable th) {
        try {
            nVar.l(th);
        } catch (Throwable th2) {
            o0.b(getContext(), new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    public final void p(@NotNull Function1<? super Throwable, kotlin.n1> function1, @NotNull Throwable th) {
        try {
            function1.invoke(th);
        } catch (Throwable th2) {
            o0.b(getContext(), new CompletionHandlerException("Exception in resume onCancellation handler for " + this, th2));
        }
    }

    @Override // kotlin.coroutines.e
    public void resumeWith(@NotNull Object obj) {
        T(this, i0.c(obj, this), this.f48477c, null, 4, null);
    }

    public final void s() {
        j1 w5 = w();
        if (w5 == null) {
            return;
        }
        w5.dispose();
        f49422h.set(this, s2.f49445a);
    }

    @NotNull
    public Throwable v(@NotNull e2 e2Var) {
        return e2Var.H();
    }

    @PublishedApi
    @Nullable
    public final Object x() {
        e2 e2Var;
        boolean E = E();
        if (X()) {
            if (w() == null) {
                A();
            }
            if (E) {
                N();
            }
            return kotlin.coroutines.intrinsics.a.l();
        }
        if (E) {
            N();
        }
        Object y5 = y();
        if (!(y5 instanceof d0)) {
            if (e1.c(this.f48477c) && (e2Var = (e2) getContext().get(e2.f48569s0)) != null && !e2Var.isActive()) {
                CancellationException H = e2Var.H();
                d(y5, H);
                throw H;
            }
            return g(y5);
        }
        throw ((d0) y5).f48476a;
    }
}
