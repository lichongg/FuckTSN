package androidx.work;

import androidx.work.ListenableWorker;
import kotlin.coroutines.e;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.g0;
import kotlin.jvm.functions.Function2;
import kotlin.n1;
import kotlinx.coroutines.r0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@DebugMetadata(c = "androidx.work.CoroutineWorker$startWork$1", f = "CoroutineWorker.kt", i = {}, l = {68}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\Downloads\app\classes.dex */
final class CoroutineWorker$startWork$1 extends SuspendLambda implements Function2<r0, e<? super n1>, Object> {
    int label;
    final /* synthetic */ CoroutineWorker this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CoroutineWorker$startWork$1(CoroutineWorker coroutineWorker, e<? super CoroutineWorker$startWork$1> eVar) {
        super(2, eVar);
        this.this$0 = coroutineWorker;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final e<n1> create(@Nullable Object obj, @NotNull e<?> eVar) {
        return new CoroutineWorker$startWork$1(this.this$0, eVar);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull r0 r0Var, @Nullable e<? super n1> eVar) {
        return ((CoroutineWorker$startWork$1) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object l6 = kotlin.coroutines.intrinsics.a.l();
        int i6 = this.label;
        try {
            if (i6 != 0) {
                if (i6 == 1) {
                    g0.n(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                g0.n(obj);
                CoroutineWorker coroutineWorker = this.this$0;
                this.label = 1;
                obj = coroutineWorker.doWork(this);
                if (obj == l6) {
                    return l6;
                }
            }
            this.this$0.getFuture$work_runtime_ktx_release().set((ListenableWorker.Result) obj);
        } catch (Throwable th) {
            this.this$0.getFuture$work_runtime_ktx_release().setException(th);
        }
        return n1.f44123a;
    }
}
