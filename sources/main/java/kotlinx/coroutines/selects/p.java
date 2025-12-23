package kotlinx.coroutines.selects;

import kotlin.PublishedApi;
import kotlin.Result;
import kotlin.g0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.d0;
import kotlin.n1;
import kotlinx.coroutines.m0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class p {
    @PublishedApi
    private static final <R> Object f(Function1<? super c<? super R>, n1> function1, kotlin.coroutines.e<? super R> eVar) {
        d0.e(0);
        d dVar = new d(eVar);
        try {
            function1.invoke(dVar);
        } catch (Throwable th) {
            dVar.Q(th);
        }
        Object P = dVar.P();
        if (P == kotlin.coroutines.intrinsics.a.l()) {
            kotlin.coroutines.jvm.internal.e.c(eVar);
        }
        d0.e(1);
        return P;
    }

    @PublishedApi
    private static final <R> Object h(Function1<? super c<? super R>, n1> function1, kotlin.coroutines.e<? super R> eVar) {
        d0.e(0);
        r rVar = new r(eVar);
        try {
            function1.invoke(rVar);
        } catch (Throwable th) {
            rVar.R(th);
        }
        Object S = rVar.S();
        if (S == kotlin.coroutines.intrinsics.a.l()) {
            kotlin.coroutines.jvm.internal.e.c(eVar);
        }
        d0.e(1);
        return S;
    }

    @PublishedApi
    @Nullable
    public static final <R> Object e(@NotNull Function1<? super c<? super R>, n1> function1, @NotNull kotlin.coroutines.e<? super R> eVar) {
        d dVar = new d(eVar);
        try {
            function1.invoke(dVar);
        } catch (Throwable th) {
            dVar.Q(th);
        }
        Object P = dVar.P();
        if (P == kotlin.coroutines.intrinsics.a.l()) {
            kotlin.coroutines.jvm.internal.e.c(eVar);
        }
        return P;
    }

    @PublishedApi
    @Nullable
    public static final <R> Object g(@NotNull Function1<? super c<? super R>, n1> function1, @NotNull kotlin.coroutines.e<? super R> eVar) {
        r rVar = new r(eVar);
        try {
            function1.invoke(rVar);
        } catch (Throwable th) {
            rVar.R(th);
        }
        Object S = rVar.S();
        if (S == kotlin.coroutines.intrinsics.a.l()) {
            kotlin.coroutines.jvm.internal.e.c(eVar);
        }
        return S;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> void c(kotlinx.coroutines.p<? super T> pVar, T t5) {
        m0 m0Var = (m0) pVar.getContext().get(m0.Key);
        if (m0Var != null) {
            pVar.P(m0Var, t5);
        } else {
            Result.a aVar = Result.Companion;
            pVar.resumeWith(Result.m130constructorimpl(t5));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(kotlinx.coroutines.p<?> pVar, Throwable th) {
        m0 m0Var = (m0) pVar.getContext().get(m0.Key);
        if (m0Var != null) {
            pVar.h(m0Var, th);
        } else {
            Result.a aVar = Result.Companion;
            pVar.resumeWith(Result.m130constructorimpl(g0.a(th)));
        }
    }
}
