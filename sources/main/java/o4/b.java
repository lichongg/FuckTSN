package o4;

import kotlin.Result;
import kotlin.coroutines.e;
import kotlin.coroutines.i;
import kotlin.g0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.u0;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.d0;
import kotlinx.coroutines.internal.o0;
import kotlinx.coroutines.internal.y0;
import kotlinx.coroutines.m2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nUndispatched.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Undispatched.kt\nkotlinx/coroutines/intrinsics/UndispatchedKt\n+ 2 ProbesSupport.kt\nkotlinx/coroutines/internal/ProbesSupportKt\n+ 3 CoroutineContext.kt\nkotlinx/coroutines/CoroutineContextKt\n+ 4 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n*L\n1#1,127:1\n55#1:128\n56#1,11:130\n55#1:141\n56#1,2:143\n58#1,9:150\n55#1:159\n56#1,2:161\n58#1,9:168\n97#1,4:178\n114#1,6:182\n120#1,5:190\n97#1,4:195\n114#1,6:199\n120#1,5:207\n11#2:129\n11#2:142\n11#2:160\n11#2:177\n95#3,5:145\n95#3,5:163\n61#4,2:188\n61#4,2:205\n61#4,2:212\n61#4,2:214\n*S KotlinDebug\n*F\n+ 1 Undispatched.kt\nkotlinx/coroutines/intrinsics/UndispatchedKt\n*L\n18#1:128\n18#1:130,11\n29#1:141\n29#1:143,2\n29#1:150,9\n42#1:159\n42#1:161,2\n42#1:168,9\n77#1:178,4\n77#1:182,6\n77#1:190,5\n88#1:195,4\n88#1:199,6\n88#1:207,5\n18#1:129\n29#1:142\n42#1:160\n55#1:177\n30#1:145,5\n43#1:163,5\n77#1:188,2\n88#1:205,2\n119#1:212,2\n120#1:214,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class b {
    @Nullable
    public static final <T, R> Object e(@NotNull o0<? super T> o0Var, R r5, @NotNull Function2<? super R, ? super e<? super T>, ? extends Object> function2) {
        Object d0Var;
        try {
            d0Var = ((Function2) u0.q(function2, 2)).invoke(r5, o0Var);
        } catch (Throwable th) {
            d0Var = new d0(th, false, 2, null);
        }
        if (d0Var == kotlin.coroutines.intrinsics.a.l()) {
            return kotlin.coroutines.intrinsics.a.l();
        }
        Object U0 = o0Var.U0(d0Var);
        if (U0 == m2.f49384b) {
            return kotlin.coroutines.intrinsics.a.l();
        }
        if (U0 instanceof d0) {
            throw ((d0) U0).f48476a;
        }
        return m2.h(U0);
    }

    @Nullable
    public static final <T, R> Object f(@NotNull o0<? super T> o0Var, R r5, @NotNull Function2<? super R, ? super e<? super T>, ? extends Object> function2) {
        Object d0Var;
        try {
            d0Var = ((Function2) u0.q(function2, 2)).invoke(r5, o0Var);
        } catch (Throwable th) {
            d0Var = new d0(th, false, 2, null);
        }
        if (d0Var == kotlin.coroutines.intrinsics.a.l()) {
            return kotlin.coroutines.intrinsics.a.l();
        }
        Object U0 = o0Var.U0(d0Var);
        if (U0 == m2.f49384b) {
            return kotlin.coroutines.intrinsics.a.l();
        }
        if (U0 instanceof d0) {
            Throwable th2 = ((d0) U0).f48476a;
            if (!(th2 instanceof TimeoutCancellationException)) {
                throw th2;
            }
            if (((TimeoutCancellationException) th2).coroutine != o0Var) {
                throw th2;
            }
            if (d0Var instanceof d0) {
                throw ((d0) d0Var).f48476a;
            }
        } else {
            d0Var = m2.h(U0);
        }
        return d0Var;
    }

    public static final <T> void a(@NotNull Function1<? super e<? super T>, ? extends Object> function1, @NotNull e<? super T> eVar) {
        e a6 = kotlin.coroutines.jvm.internal.e.a(eVar);
        try {
            i context = eVar.getContext();
            Object c6 = y0.c(context, null);
            try {
                Object invoke = ((Function1) u0.q(function1, 1)).invoke(a6);
                if (invoke != kotlin.coroutines.intrinsics.a.l()) {
                    Result.a aVar = Result.Companion;
                    a6.resumeWith(Result.m130constructorimpl(invoke));
                }
            } finally {
                y0.a(context, c6);
            }
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            a6.resumeWith(Result.m130constructorimpl(g0.a(th)));
        }
    }

    public static final <R, T> void b(@NotNull Function2<? super R, ? super e<? super T>, ? extends Object> function2, R r5, @NotNull e<? super T> eVar) {
        e a6 = kotlin.coroutines.jvm.internal.e.a(eVar);
        try {
            i context = eVar.getContext();
            Object c6 = y0.c(context, null);
            try {
                Object invoke = ((Function2) u0.q(function2, 2)).invoke(r5, a6);
                if (invoke != kotlin.coroutines.intrinsics.a.l()) {
                    Result.a aVar = Result.Companion;
                    a6.resumeWith(Result.m130constructorimpl(invoke));
                }
            } finally {
                y0.a(context, c6);
            }
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            a6.resumeWith(Result.m130constructorimpl(g0.a(th)));
        }
    }

    public static final <T> void c(@NotNull Function1<? super e<? super T>, ? extends Object> function1, @NotNull e<? super T> eVar) {
        e a6 = kotlin.coroutines.jvm.internal.e.a(eVar);
        try {
            Object invoke = ((Function1) u0.q(function1, 1)).invoke(a6);
            if (invoke != kotlin.coroutines.intrinsics.a.l()) {
                Result.a aVar = Result.Companion;
                a6.resumeWith(Result.m130constructorimpl(invoke));
            }
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            a6.resumeWith(Result.m130constructorimpl(g0.a(th)));
        }
    }

    private static final <T> void d(e<? super T> eVar, Function1<? super e<? super T>, ? extends Object> function1) {
        e a6 = kotlin.coroutines.jvm.internal.e.a(eVar);
        try {
            Object invoke = function1.invoke(a6);
            if (invoke != kotlin.coroutines.intrinsics.a.l()) {
                Result.a aVar = Result.Companion;
                a6.resumeWith(Result.m130constructorimpl(invoke));
            }
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            a6.resumeWith(Result.m130constructorimpl(g0.a(th)));
        }
    }

    private static final <T> Object g(o0<? super T> o0Var, Function1<? super Throwable, Boolean> function1, Function0<? extends Object> function0) {
        Object d0Var;
        try {
            d0Var = function0.invoke();
        } catch (Throwable th) {
            d0Var = new d0(th, false, 2, null);
        }
        if (d0Var == kotlin.coroutines.intrinsics.a.l()) {
            return kotlin.coroutines.intrinsics.a.l();
        }
        Object U0 = o0Var.U0(d0Var);
        if (U0 == m2.f49384b) {
            return kotlin.coroutines.intrinsics.a.l();
        }
        if (U0 instanceof d0) {
            d0 d0Var2 = (d0) U0;
            if (!function1.invoke(d0Var2.f48476a).booleanValue()) {
                if (d0Var instanceof d0) {
                    throw ((d0) d0Var).f48476a;
                }
                return d0Var;
            }
            throw d0Var2.f48476a;
        }
        return m2.h(U0);
    }
}
