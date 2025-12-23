package kotlinx.coroutines;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nCancellableContinuation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 CompletionHandler.kt\nkotlinx/coroutines/CompletionHandlerKt\n*L\n1#1,386:1\n1#2:387\n19#3:388\n*S KotlinDebug\n*F\n+ 1 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n380#1:388\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class s {
    private static final <T> Object d(Function1<? super p<? super T>, kotlin.n1> function1, kotlin.coroutines.e<? super T> eVar) {
        kotlin.jvm.internal.d0.e(0);
        q qVar = new q(kotlin.coroutines.intrinsics.a.e(eVar), 1);
        qVar.Q();
        function1.invoke(qVar);
        Object x5 = qVar.x();
        if (x5 == kotlin.coroutines.intrinsics.a.l()) {
            kotlin.coroutines.jvm.internal.e.c(eVar);
        }
        kotlin.jvm.internal.d0.e(1);
        return x5;
    }

    private static final <T> Object f(Function1<? super q<? super T>, kotlin.n1> function1, kotlin.coroutines.e<? super T> eVar) {
        kotlin.jvm.internal.d0.e(0);
        q b6 = b(kotlin.coroutines.intrinsics.a.e(eVar));
        try {
            function1.invoke(b6);
            Object x5 = b6.x();
            if (x5 == kotlin.coroutines.intrinsics.a.l()) {
                kotlin.coroutines.jvm.internal.e.c(eVar);
            }
            kotlin.jvm.internal.d0.e(1);
            return x5;
        } catch (Throwable th) {
            b6.N();
            throw th;
        }
    }

    @InternalCoroutinesApi
    public static final void a(@NotNull p<?> pVar, @NotNull j1 j1Var) {
        pVar.I(new k1(j1Var));
    }

    @NotNull
    public static final <T> q<T> b(@NotNull kotlin.coroutines.e<? super T> eVar) {
        if (!(eVar instanceof kotlinx.coroutines.internal.l)) {
            return new q<>(eVar, 1);
        }
        q<T> l6 = ((kotlinx.coroutines.internal.l) eVar).l();
        if (l6 != null) {
            if (!l6.R()) {
                l6 = null;
            }
            if (l6 != null) {
                return l6;
            }
        }
        return new q<>(eVar, 2);
    }

    @Nullable
    public static final <T> Object c(@NotNull Function1<? super p<? super T>, kotlin.n1> function1, @NotNull kotlin.coroutines.e<? super T> eVar) {
        q qVar = new q(kotlin.coroutines.intrinsics.a.e(eVar), 1);
        qVar.Q();
        function1.invoke(qVar);
        Object x5 = qVar.x();
        if (x5 == kotlin.coroutines.intrinsics.a.l()) {
            kotlin.coroutines.jvm.internal.e.c(eVar);
        }
        return x5;
    }

    @Nullable
    public static final <T> Object e(@NotNull Function1<? super q<? super T>, kotlin.n1> function1, @NotNull kotlin.coroutines.e<? super T> eVar) {
        q b6 = b(kotlin.coroutines.intrinsics.a.e(eVar));
        try {
            function1.invoke(b6);
            Object x5 = b6.x();
            if (x5 == kotlin.coroutines.intrinsics.a.l()) {
                kotlin.coroutines.jvm.internal.e.c(eVar);
            }
            return x5;
        } catch (Throwable th) {
            b6.N();
            throw th;
        }
    }
}
