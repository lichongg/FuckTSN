package kotlinx.coroutines;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.n0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nCoroutineExceptionHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineExceptionHandler.kt\nkotlinx/coroutines/CoroutineExceptionHandlerKt\n+ 2 Exceptions.kt\nkotlinx/coroutines/ExceptionsKt\n*L\n1#1,110:1\n75#2:111\n*S KotlinDebug\n*F\n+ 1 CoroutineExceptionHandler.kt\nkotlinx/coroutines/CoroutineExceptionHandlerKt\n*L\n38#1:111\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class o0 {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nCoroutineExceptionHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineExceptionHandler.kt\nkotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1\n*L\n1#1,110:1\n*E\n"})
    public static final class a extends kotlin.coroutines.a implements n0 {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function2<kotlin.coroutines.i, Throwable, kotlin.n1> f49405a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(Function2<? super kotlin.coroutines.i, ? super Throwable, kotlin.n1> function2, n0.b bVar) {
            super(bVar);
            this.f49405a = function2;
        }

        @Override // kotlinx.coroutines.n0
        public void s(@NotNull kotlin.coroutines.i iVar, @NotNull Throwable th) {
            this.f49405a.invoke(iVar, th);
        }
    }

    @NotNull
    public static final n0 a(@NotNull Function2<? super kotlin.coroutines.i, ? super Throwable, kotlin.n1> function2) {
        return new a(function2, n0.f49394r0);
    }

    @InternalCoroutinesApi
    public static final void b(@NotNull kotlin.coroutines.i iVar, @NotNull Throwable th) {
        try {
            n0 n0Var = (n0) iVar.get(n0.f49394r0);
            if (n0Var != null) {
                n0Var.s(iVar, th);
            } else {
                kotlinx.coroutines.internal.j.a(iVar, th);
            }
        } catch (Throwable th2) {
            kotlinx.coroutines.internal.j.a(iVar, c(th, th2));
        }
    }

    @NotNull
    public static final Throwable c(@NotNull Throwable th, @NotNull Throwable th2) {
        if (th == th2) {
            return th;
        }
        RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
        kotlin.l.a(runtimeException, th);
        return runtimeException;
    }
}
