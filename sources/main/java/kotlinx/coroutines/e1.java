package kotlinx.coroutines;

import kotlin.PublishedApi;
import kotlin.Result;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nDispatchedTask.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DispatchedTask.kt\nkotlinx/coroutines/DispatchedTaskKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 DispatchedContinuation.kt\nkotlinx/coroutines/internal/DispatchedContinuation\n+ 4 CoroutineContext.kt\nkotlinx/coroutines/CoroutineContextKt\n+ 5 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n*L\n1#1,222:1\n200#1,17:240\n1#2:223\n255#3:224\n256#3,2:235\n258#3:239\n107#4,10:225\n118#4,2:237\n61#5,2:257\n*S KotlinDebug\n*F\n+ 1 DispatchedTask.kt\nkotlinx/coroutines/DispatchedTaskKt\n*L\n190#1:240,17\n178#1:224\n178#1:235,2\n178#1:239\n178#1:225,10\n178#1:237,2\n220#1:257,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class e1 {

    /* renamed from: a, reason: collision with root package name */
    public static final int f48564a = 0;

    /* renamed from: b, reason: collision with root package name */
    public static final int f48565b = 1;

    /* renamed from: c, reason: collision with root package name */
    public static final int f48566c = 2;

    /* renamed from: d, reason: collision with root package name */
    public static final int f48567d = 4;

    /* renamed from: e, reason: collision with root package name */
    public static final int f48568e = -1;

    public static final boolean c(int i6) {
        return i6 == 1 || i6 == 2;
    }

    public static final boolean d(int i6) {
        return i6 == 2;
    }

    public static final void h(@NotNull d1<?> d1Var, @NotNull n1 n1Var, @NotNull Function0<kotlin.n1> function0) {
        n1Var.z(true);
        try {
            function0.invoke();
            do {
            } while (n1Var.N());
            kotlin.jvm.internal.d0.d(1);
        } catch (Throwable th) {
            try {
                d1Var.i(th, null);
                kotlin.jvm.internal.d0.d(1);
            } catch (Throwable th2) {
                kotlin.jvm.internal.d0.d(1);
                n1Var.t(true);
                kotlin.jvm.internal.d0.c(1);
                throw th2;
            }
        }
        n1Var.t(true);
        kotlin.jvm.internal.d0.c(1);
    }

    private static final void f(d1<?> d1Var) {
        n1 b6 = g3.f49210a.b();
        if (b6.D()) {
            b6.w(d1Var);
            return;
        }
        b6.z(true);
        try {
            e(d1Var, d1Var.e(), true);
            do {
            } while (b6.N());
        } finally {
            try {
            } finally {
            }
        }
    }

    public static final void g(@NotNull kotlin.coroutines.e<?> eVar, @NotNull Throwable th) {
        Result.a aVar = Result.Companion;
        eVar.resumeWith(Result.m130constructorimpl(kotlin.g0.a(th)));
    }

    public static final <T> void a(@NotNull d1<? super T> d1Var, int i6) {
        boolean z5;
        kotlin.coroutines.e<? super T> e6 = d1Var.e();
        if (i6 == 4) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (!z5 && (e6 instanceof kotlinx.coroutines.internal.l) && c(i6) == c(d1Var.f48477c)) {
            m0 m0Var = ((kotlinx.coroutines.internal.l) e6).f49277d;
            kotlin.coroutines.i context = e6.getContext();
            if (m0Var.isDispatchNeeded(context)) {
                m0Var.dispatch(context, d1Var);
                return;
            } else {
                f(d1Var);
                return;
            }
        }
        e(d1Var, e6, z5);
    }

    public static final <T> void e(@NotNull d1<? super T> d1Var, @NotNull kotlin.coroutines.e<? super T> eVar, boolean z5) {
        Object g6;
        p3<?> p3Var;
        Object j6 = d1Var.j();
        Throwable f6 = d1Var.f(j6);
        if (f6 != null) {
            Result.a aVar = Result.Companion;
            g6 = kotlin.g0.a(f6);
        } else {
            Result.a aVar2 = Result.Companion;
            g6 = d1Var.g(j6);
        }
        Object m130constructorimpl = Result.m130constructorimpl(g6);
        if (z5) {
            kotlin.jvm.internal.g0.n(eVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTaskKt.resume>");
            kotlinx.coroutines.internal.l lVar = (kotlinx.coroutines.internal.l) eVar;
            kotlin.coroutines.e<T> eVar2 = lVar.f49278e;
            Object obj = lVar.f49280g;
            kotlin.coroutines.i context = eVar2.getContext();
            Object c6 = kotlinx.coroutines.internal.y0.c(context, obj);
            if (c6 != kotlinx.coroutines.internal.y0.f49325a) {
                p3Var = l0.g(eVar2, context, c6);
            } else {
                p3Var = null;
            }
            try {
                lVar.f49278e.resumeWith(m130constructorimpl);
                kotlin.n1 n1Var = kotlin.n1.f44123a;
                if (p3Var != null && !p3Var.A1()) {
                    return;
                }
                kotlinx.coroutines.internal.y0.a(context, c6);
                return;
            } catch (Throwable th) {
                if (p3Var == null || p3Var.A1()) {
                    kotlinx.coroutines.internal.y0.a(context, c6);
                }
                throw th;
            }
        }
        eVar.resumeWith(m130constructorimpl);
    }

    @PublishedApi
    public static /* synthetic */ void b() {
    }
}
