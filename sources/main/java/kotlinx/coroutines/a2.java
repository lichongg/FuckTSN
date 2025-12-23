package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class a2 {

    /* renamed from: a, reason: collision with root package name */
    private static final int f48082a = 0;

    /* renamed from: b, reason: collision with root package name */
    private static final int f48083b = 1;

    /* renamed from: c, reason: collision with root package name */
    private static final int f48084c = 2;

    /* renamed from: d, reason: collision with root package name */
    private static final int f48085d = 3;

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.InterruptibleKt$runInterruptible$2", f = "Interruptible.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class a<T> extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super T>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f48086a;

        /* renamed from: b, reason: collision with root package name */
        private /* synthetic */ Object f48087b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Function0<T> f48088c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(Function0<? extends T> function0, kotlin.coroutines.e<? super a> eVar) {
            super(2, eVar);
            this.f48088c = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.e<kotlin.n1> create(@Nullable Object obj, @NotNull kotlin.coroutines.e<?> eVar) {
            a aVar = new a(this.f48088c, eVar);
            aVar.f48087b = obj;
            return aVar;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull r0 r0Var, @Nullable kotlin.coroutines.e<? super T> eVar) {
            return ((a) create(r0Var, eVar)).invokeSuspend(kotlin.n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.l();
            if (this.f48086a == 0) {
                kotlin.g0.n(obj);
                return a2.d(((r0) this.f48087b).getCoroutineContext(), this.f48088c);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Nullable
    public static final <T> Object b(@NotNull kotlin.coroutines.i iVar, @NotNull Function0<? extends T> function0, @NotNull kotlin.coroutines.e<? super T> eVar) {
        return i.h(iVar, new a(function0, null), eVar);
    }

    public static /* synthetic */ Object c(kotlin.coroutines.i iVar, Function0 function0, kotlin.coroutines.e eVar, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            iVar = EmptyCoroutineContext.INSTANCE;
        }
        return b(iVar, function0, eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> T d(kotlin.coroutines.i iVar, Function0<? extends T> function0) {
        try {
            l3 l3Var = new l3(h2.B(iVar));
            l3Var.f();
            try {
                return function0.invoke();
            } finally {
                l3Var.a();
            }
        } catch (InterruptedException e6) {
            throw new CancellationException("Blocking call was interrupted due to parent cancellation").initCause(e6);
        }
    }
}
