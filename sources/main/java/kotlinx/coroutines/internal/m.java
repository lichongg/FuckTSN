package kotlinx.coroutines.internal;

import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.e2;
import kotlinx.coroutines.g3;
import kotlinx.coroutines.p3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nDispatchedContinuation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DispatchedContinuation.kt\nkotlinx/coroutines/internal/DispatchedContinuationKt\n+ 2 DispatchedContinuation.kt\nkotlinx/coroutines/internal/DispatchedContinuation\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 DispatchedTask.kt\nkotlinx/coroutines/DispatchedTaskKt\n+ 5 CoroutineContext.kt\nkotlinx/coroutines/CoroutineContextKt\n*L\n1#1,317:1\n297#1,5:325\n302#1,12:331\n314#1:387\n301#1:389\n302#1,12:391\n314#1:420\n217#2,7:318\n224#2:346\n243#2,8:347\n225#2:355\n255#2:356\n256#2,2:367\n258#2:371\n227#2:372\n229#2:388\n1#3:330\n1#3:390\n1#3:421\n200#4,3:343\n203#4,14:373\n200#4,17:403\n200#4,17:422\n107#5,10:357\n118#5,2:369\n*S KotlinDebug\n*F\n+ 1 DispatchedContinuation.kt\nkotlinx/coroutines/internal/DispatchedContinuationKt\n*L\n282#1:325,5\n282#1:331,12\n282#1:387\n287#1:389\n287#1:391,12\n287#1:420\n282#1:318,7\n282#1:346\n282#1:347,8\n282#1:355\n282#1:356\n282#1:367,2\n282#1:371\n282#1:372\n282#1:388\n282#1:330\n287#1:390\n282#1:343,3\n282#1:373,14\n287#1:403,17\n313#1:422,17\n282#1:357,10\n282#1:369,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final s0 f49281a = new s0("UNDEFINED");

    /* renamed from: b, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final s0 f49282b = new s0("REUSABLE_CLAIMED");

    private static final boolean b(l<?> lVar, Object obj, int i6, boolean z5, Function0<n1> function0) {
        kotlinx.coroutines.n1 b6 = g3.f49210a.b();
        if (z5 && b6.I()) {
            return false;
        }
        if (b6.D()) {
            lVar.f49279f = obj;
            lVar.f48477c = i6;
            b6.w(lVar);
            return true;
        }
        b6.z(true);
        try {
            function0.invoke();
            do {
            } while (b6.N());
            kotlin.jvm.internal.d0.d(1);
        } catch (Throwable th) {
            try {
                lVar.i(th, null);
                kotlin.jvm.internal.d0.d(1);
            } catch (Throwable th2) {
                kotlin.jvm.internal.d0.d(1);
                b6.t(true);
                kotlin.jvm.internal.d0.c(1);
                throw th2;
            }
        }
        b6.t(true);
        kotlin.jvm.internal.d0.c(1);
        return false;
    }

    static /* synthetic */ boolean c(l lVar, Object obj, int i6, boolean z5, Function0 function0, int i7, Object obj2) {
        if ((i7 & 4) != 0) {
            z5 = false;
        }
        kotlinx.coroutines.n1 b6 = g3.f49210a.b();
        if (z5 && b6.I()) {
            return false;
        }
        if (b6.D()) {
            lVar.f49279f = obj;
            lVar.f48477c = i6;
            b6.w(lVar);
            return true;
        }
        b6.z(true);
        try {
            function0.invoke();
            do {
            } while (b6.N());
            kotlin.jvm.internal.d0.d(1);
        } catch (Throwable th) {
            try {
                lVar.i(th, null);
                kotlin.jvm.internal.d0.d(1);
            } catch (Throwable th2) {
                kotlin.jvm.internal.d0.d(1);
                b6.t(true);
                kotlin.jvm.internal.d0.c(1);
                throw th2;
            }
        }
        b6.t(true);
        kotlin.jvm.internal.d0.c(1);
        return false;
    }

    @InternalCoroutinesApi
    public static final <T> void d(@NotNull kotlin.coroutines.e<? super T> eVar, @NotNull Object obj, @Nullable Function1<? super Throwable, n1> function1) {
        if (!(eVar instanceof l)) {
            eVar.resumeWith(obj);
            return;
        }
        l lVar = (l) eVar;
        Object b6 = kotlinx.coroutines.i0.b(obj, function1);
        if (lVar.f49277d.isDispatchNeeded(lVar.getContext())) {
            lVar.f49279f = b6;
            lVar.f48477c = 1;
            lVar.f49277d.dispatch(lVar.getContext(), lVar);
            return;
        }
        kotlinx.coroutines.n1 b7 = g3.f49210a.b();
        if (b7.D()) {
            lVar.f49279f = b6;
            lVar.f48477c = 1;
            b7.w(lVar);
            return;
        }
        b7.z(true);
        try {
            e2 e2Var = (e2) lVar.getContext().get(e2.f48569s0);
            if (e2Var == null || e2Var.isActive()) {
                kotlin.coroutines.e<T> eVar2 = lVar.f49278e;
                Object obj2 = lVar.f49280g;
                kotlin.coroutines.i context = eVar2.getContext();
                Object c6 = y0.c(context, obj2);
                p3<?> g6 = c6 != y0.f49325a ? kotlinx.coroutines.l0.g(eVar2, context, c6) : null;
                try {
                    lVar.f49278e.resumeWith(obj);
                    n1 n1Var = n1.f44123a;
                } finally {
                    if (g6 == null || g6.A1()) {
                        y0.a(context, c6);
                    }
                }
            } else {
                CancellationException H = e2Var.H();
                lVar.d(b6, H);
                Result.a aVar = Result.Companion;
                lVar.resumeWith(Result.m130constructorimpl(kotlin.g0.a(H)));
            }
            while (b7.N()) {
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    public static /* synthetic */ void e(kotlin.coroutines.e eVar, Object obj, Function1 function1, int i6, Object obj2) {
        if ((i6 & 2) != 0) {
            function1 = null;
        }
        d(eVar, obj, function1);
    }

    public static final boolean f(@NotNull l<? super n1> lVar) {
        n1 n1Var = n1.f44123a;
        kotlinx.coroutines.n1 b6 = g3.f49210a.b();
        if (b6.I()) {
            return false;
        }
        if (b6.D()) {
            lVar.f49279f = n1Var;
            lVar.f48477c = 1;
            b6.w(lVar);
            return true;
        }
        b6.z(true);
        try {
            lVar.run();
            do {
            } while (b6.N());
        } finally {
            try {
                return false;
            } finally {
            }
        }
        return false;
    }
}
