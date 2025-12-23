package o4;

import kotlin.Result;
import kotlin.coroutines.e;
import kotlin.g0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.internal.m;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nCancellable.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Cancellable.kt\nkotlinx/coroutines/intrinsics/CancellableKt\n*L\n1#1,68:1\n49#1,6:69\n49#1,6:75\n49#1,6:81\n*S KotlinDebug\n*F\n+ 1 Cancellable.kt\nkotlinx/coroutines/intrinsics/CancellableKt\n*L\n17#1:69,6\n29#1:75,6\n38#1:81,6\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class a {
    private static final void a(e<?> eVar, Throwable th) {
        Result.a aVar = Result.Companion;
        eVar.resumeWith(Result.m130constructorimpl(g0.a(th)));
        throw th;
    }

    public static /* synthetic */ void f(Function2 function2, Object obj, e eVar, Function1 function1, int i6, Object obj2) {
        if ((i6 & 4) != 0) {
            function1 = null;
        }
        e(function2, obj, eVar, function1);
    }

    private static final void b(e<?> eVar, Function0<n1> function0) {
        try {
            function0.invoke();
        } catch (Throwable th) {
            a(eVar, th);
        }
    }

    public static final void c(@NotNull e<? super n1> eVar, @NotNull e<?> eVar2) {
        try {
            e e6 = kotlin.coroutines.intrinsics.a.e(eVar);
            Result.a aVar = Result.Companion;
            m.e(e6, Result.m130constructorimpl(n1.f44123a), null, 2, null);
        } catch (Throwable th) {
            a(eVar2, th);
        }
    }

    @InternalCoroutinesApi
    public static final <T> void d(@NotNull Function1<? super e<? super T>, ? extends Object> function1, @NotNull e<? super T> eVar) {
        try {
            e e6 = kotlin.coroutines.intrinsics.a.e(kotlin.coroutines.intrinsics.a.b(function1, eVar));
            Result.a aVar = Result.Companion;
            m.e(e6, Result.m130constructorimpl(n1.f44123a), null, 2, null);
        } catch (Throwable th) {
            a(eVar, th);
        }
    }

    public static final <R, T> void e(@NotNull Function2<? super R, ? super e<? super T>, ? extends Object> function2, R r5, @NotNull e<? super T> eVar, @Nullable Function1<? super Throwable, n1> function1) {
        try {
            e e6 = kotlin.coroutines.intrinsics.a.e(kotlin.coroutines.intrinsics.a.c(function2, r5, eVar));
            Result.a aVar = Result.Companion;
            m.d(e6, Result.m130constructorimpl(n1.f44123a), function1);
        } catch (Throwable th) {
            a(eVar, th);
        }
    }
}
