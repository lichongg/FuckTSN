package androidx.work.multiprocess;

import androidx.work.ListenableWorker;
import kotlin.coroutines.e;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.g0;
import kotlin.jvm.functions.Function2;
import kotlin.n1;
import kotlinx.coroutines.r0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@DebugMetadata(c = "androidx.work.multiprocess.RemoteCoroutineWorker$startRemoteWork$1", f = "RemoteCoroutineWorker.kt", i = {}, l = {75}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\Downloads\app\classes.dex */
final class RemoteCoroutineWorker$startRemoteWork$1 extends SuspendLambda implements Function2<r0, e<? super n1>, Object> {
    int label;
    final /* synthetic */ RemoteCoroutineWorker this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RemoteCoroutineWorker$startRemoteWork$1(RemoteCoroutineWorker remoteCoroutineWorker, e<? super RemoteCoroutineWorker$startRemoteWork$1> eVar) {
        super(2, eVar);
        this.this$0 = remoteCoroutineWorker;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final e<n1> create(@Nullable Object obj, @NotNull e<?> eVar) {
        return new RemoteCoroutineWorker$startRemoteWork$1(this.this$0, eVar);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull r0 r0Var, @Nullable e<? super n1> eVar) {
        return ((RemoteCoroutineWorker$startRemoteWork$1) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object l6 = a.l();
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
                RemoteCoroutineWorker remoteCoroutineWorker = this.this$0;
                this.label = 1;
                obj = remoteCoroutineWorker.doRemoteWork(this);
                if (obj == l6) {
                    return l6;
                }
            }
            this.this$0.future.set((ListenableWorker.Result) obj);
        } catch (Throwable th) {
            this.this$0.future.setException(th);
        }
        return n1.f44123a;
    }
}
