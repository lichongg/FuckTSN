package kotlinx.coroutines.internal;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.PublishedApi;
import kotlin.Result;
import kotlin.jvm.JvmField;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.e2;
import kotlinx.coroutines.g3;
import kotlinx.coroutines.n1;
import kotlinx.coroutines.p3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@PublishedApi
@SourceDebugExtension({"SMAP\nDispatchedContinuation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DispatchedContinuation.kt\nkotlinx/coroutines/internal/DispatchedContinuation\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 DispatchedContinuation.kt\nkotlinx/coroutines/internal/DispatchedContinuationKt\n+ 4 DispatchedTask.kt\nkotlinx/coroutines/DispatchedTaskKt\n+ 5 CoroutineContext.kt\nkotlinx/coroutines/CoroutineContextKt\n*L\n1#1,317:1\n243#1,8:381\n255#1:389\n256#1,2:400\n258#1:404\n1#2:318\n1#2:324\n1#2:365\n297#3,5:319\n302#3,12:325\n314#3:359\n297#3,5:360\n302#3,12:366\n314#3:419\n200#4,3:337\n203#4,14:345\n200#4,3:378\n203#4,14:405\n95#5,5:340\n107#5,10:390\n118#5,2:402\n107#5,13:420\n*S KotlinDebug\n*F\n+ 1 DispatchedContinuation.kt\nkotlinx/coroutines/internal/DispatchedContinuation\n*L\n224#1:381,8\n225#1:389\n225#1:400,2\n225#1:404\n202#1:324\n223#1:365\n202#1:319,5\n202#1:325,12\n202#1:359\n223#1:360,5\n223#1:366,12\n223#1:419\n202#1:337,3\n202#1:345,14\n223#1:378,3\n223#1:405,14\n203#1:340,5\n225#1:390,10\n225#1:402,2\n255#1:420,13\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class l<T> extends kotlinx.coroutines.d1<T> implements kotlin.coroutines.jvm.internal.c, kotlin.coroutines.e<T> {

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private static final AtomicReferenceFieldUpdater f49276h = AtomicReferenceFieldUpdater.newUpdater(l.class, Object.class, "_reusableCancellableContinuation");

    @Volatile
    @Nullable
    private volatile Object _reusableCancellableContinuation;

    /* renamed from: d, reason: collision with root package name */
    @JvmField
    @NotNull
    public final kotlinx.coroutines.m0 f49277d;

    /* renamed from: e, reason: collision with root package name */
    @JvmField
    @NotNull
    public final kotlin.coroutines.e<T> f49278e;

    /* renamed from: f, reason: collision with root package name */
    @JvmField
    @Nullable
    public Object f49279f;

    /* renamed from: g, reason: collision with root package name */
    @JvmField
    @NotNull
    public final Object f49280g;

    /* JADX WARN: Multi-variable type inference failed */
    public l(@NotNull kotlinx.coroutines.m0 m0Var, @NotNull kotlin.coroutines.e<? super T> eVar) {
        super(-1);
        s0 s0Var;
        this.f49277d = m0Var;
        this.f49278e = eVar;
        s0Var = m.f49281a;
        this.f49279f = s0Var;
        this.f49280g = y0.b(getContext());
    }

    @Override // kotlin.coroutines.jvm.internal.c
    @Nullable
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    private final kotlinx.coroutines.q<?> n() {
        Object obj = f49276h.get(this);
        if (obj instanceof kotlinx.coroutines.q) {
            return (kotlinx.coroutines.q) obj;
        }
        return null;
    }

    @Override // kotlinx.coroutines.d1
    public void d(@Nullable Object obj, @NotNull Throwable th) {
        if (obj instanceof kotlinx.coroutines.e0) {
            ((kotlinx.coroutines.e0) obj).f48563b.invoke(th);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.c
    @Nullable
    public kotlin.coroutines.jvm.internal.c getCallerFrame() {
        kotlin.coroutines.e<T> eVar = this.f49278e;
        if (eVar instanceof kotlin.coroutines.jvm.internal.c) {
            return (kotlin.coroutines.jvm.internal.c) eVar;
        }
        return null;
    }

    @Override // kotlin.coroutines.e
    @NotNull
    public kotlin.coroutines.i getContext() {
        return this.f49278e.getContext();
    }

    @Override // kotlinx.coroutines.d1
    @Nullable
    public Object j() {
        s0 s0Var;
        Object obj = this.f49279f;
        s0Var = m.f49281a;
        this.f49279f = s0Var;
        return obj;
    }

    public final void k() {
        while (f49276h.get(this) == m.f49282b) {
        }
    }

    @Nullable
    public final kotlinx.coroutines.q<T> l() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f49276h;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                f49276h.set(this, m.f49282b);
                return null;
            }
            if (obj instanceof kotlinx.coroutines.q) {
                if (androidx.concurrent.futures.a.a(f49276h, this, obj, m.f49282b)) {
                    return (kotlinx.coroutines.q) obj;
                }
            } else if (obj != m.f49282b && !(obj instanceof Throwable)) {
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        }
    }

    public final void m(@NotNull kotlin.coroutines.i iVar, T t5) {
        this.f49279f = t5;
        this.f48477c = 1;
        this.f49277d.dispatchYield(iVar, this);
    }

    public final boolean q() {
        return f49276h.get(this) != null;
    }

    @Override // kotlin.coroutines.e
    public void resumeWith(@NotNull Object obj) {
        kotlin.coroutines.i context = this.f49278e.getContext();
        Object d6 = kotlinx.coroutines.i0.d(obj, null, 1, null);
        if (this.f49277d.isDispatchNeeded(context)) {
            this.f49279f = d6;
            this.f48477c = 0;
            this.f49277d.dispatch(context, this);
            return;
        }
        n1 b6 = g3.f49210a.b();
        if (b6.D()) {
            this.f49279f = d6;
            this.f48477c = 0;
            b6.w(this);
            return;
        }
        b6.z(true);
        try {
            kotlin.coroutines.i context2 = getContext();
            Object c6 = y0.c(context2, this.f49280g);
            try {
                this.f49278e.resumeWith(obj);
                kotlin.n1 n1Var = kotlin.n1.f44123a;
                while (b6.N()) {
                }
            } finally {
                y0.a(context2, c6);
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    public final boolean s(@NotNull Throwable th) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f49276h;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            s0 s0Var = m.f49282b;
            if (kotlin.jvm.internal.g0.g(obj, s0Var)) {
                if (androidx.concurrent.futures.a.a(f49276h, this, s0Var, th)) {
                    return true;
                }
            } else {
                if (obj instanceof Throwable) {
                    return true;
                }
                if (androidx.concurrent.futures.a.a(f49276h, this, obj, null)) {
                    return false;
                }
            }
        }
    }

    @NotNull
    public String toString() {
        return "DispatchedContinuation[" + this.f49277d + ", " + kotlinx.coroutines.u0.c(this.f49278e) + ']';
    }

    public final void w(@NotNull Object obj) {
        kotlin.coroutines.e<T> eVar = this.f49278e;
        Object obj2 = this.f49280g;
        kotlin.coroutines.i context = eVar.getContext();
        Object c6 = y0.c(context, obj2);
        p3<?> g6 = c6 != y0.f49325a ? kotlinx.coroutines.l0.g(eVar, context, c6) : null;
        try {
            this.f49278e.resumeWith(obj);
            kotlin.n1 n1Var = kotlin.n1.f44123a;
        } finally {
            kotlin.jvm.internal.d0.d(1);
            if (g6 == null || g6.A1()) {
                y0.a(context, c6);
            }
            kotlin.jvm.internal.d0.c(1);
        }
    }

    @Nullable
    public final Throwable x(@NotNull kotlinx.coroutines.p<?> pVar) {
        s0 s0Var;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f49276h;
        do {
            Object obj = atomicReferenceFieldUpdater.get(this);
            s0Var = m.f49282b;
            if (obj != s0Var) {
                if (obj instanceof Throwable) {
                    if (androidx.concurrent.futures.a.a(f49276h, this, obj, null)) {
                        return (Throwable) obj;
                    }
                    throw new IllegalArgumentException("Failed requirement.");
                }
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        } while (!androidx.concurrent.futures.a.a(f49276h, this, s0Var, pVar));
        return null;
    }

    private final void r(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Function1<Object, kotlin.n1> function1, Object obj) {
        while (true) {
            function1.invoke(atomicReferenceFieldUpdater.get(obj));
        }
    }

    public final void t() {
        k();
        kotlinx.coroutines.q<?> n6 = n();
        if (n6 != null) {
            n6.s();
        }
    }

    public final void u(@NotNull Object obj, @Nullable Function1<? super Throwable, kotlin.n1> function1) {
        p3<?> p3Var;
        Object b6 = kotlinx.coroutines.i0.b(obj, function1);
        if (this.f49277d.isDispatchNeeded(getContext())) {
            this.f49279f = b6;
            this.f48477c = 1;
            this.f49277d.dispatch(getContext(), this);
            return;
        }
        n1 b7 = g3.f49210a.b();
        if (b7.D()) {
            this.f49279f = b6;
            this.f48477c = 1;
            b7.w(this);
            return;
        }
        b7.z(true);
        try {
            e2 e2Var = (e2) getContext().get(e2.f48569s0);
            if (e2Var != null && !e2Var.isActive()) {
                CancellationException H = e2Var.H();
                d(b6, H);
                Result.a aVar = Result.Companion;
                resumeWith(Result.m130constructorimpl(kotlin.g0.a(H)));
            } else {
                kotlin.coroutines.e<T> eVar = this.f49278e;
                Object obj2 = this.f49280g;
                kotlin.coroutines.i context = eVar.getContext();
                Object c6 = y0.c(context, obj2);
                if (c6 != y0.f49325a) {
                    p3Var = kotlinx.coroutines.l0.g(eVar, context, c6);
                } else {
                    p3Var = null;
                }
                try {
                    this.f49278e.resumeWith(obj);
                    kotlin.n1 n1Var = kotlin.n1.f44123a;
                } finally {
                    kotlin.jvm.internal.d0.d(1);
                    if (p3Var == null || p3Var.A1()) {
                        y0.a(context, c6);
                    }
                    kotlin.jvm.internal.d0.c(1);
                }
            }
            while (b7.N()) {
            }
            kotlin.jvm.internal.d0.d(1);
        } catch (Throwable th) {
            try {
                i(th, null);
                kotlin.jvm.internal.d0.d(1);
            } catch (Throwable th2) {
                kotlin.jvm.internal.d0.d(1);
                b7.t(true);
                kotlin.jvm.internal.d0.c(1);
                throw th2;
            }
        }
        b7.t(true);
        kotlin.jvm.internal.d0.c(1);
    }

    public final boolean v(@Nullable Object obj) {
        e2 e2Var = (e2) getContext().get(e2.f48569s0);
        if (e2Var != null && !e2Var.isActive()) {
            CancellationException H = e2Var.H();
            d(obj, H);
            Result.a aVar = Result.Companion;
            resumeWith(Result.m130constructorimpl(kotlin.g0.a(H)));
            return true;
        }
        return false;
    }

    public static /* synthetic */ void p() {
    }

    @Override // kotlinx.coroutines.d1
    @NotNull
    public kotlin.coroutines.e<T> e() {
        return this;
    }
}
