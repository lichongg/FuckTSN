package androidx.lifecycle;

import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.g0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.n1;
import kotlinx.coroutines.r0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@DebugMetadata(c = "androidx.lifecycle.BlockRunner$maybeRun$1", f = "CoroutineLiveData.kt", i = {}, l = {177}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\Downloads\app\classes.dex */
final class BlockRunner$maybeRun$1 extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ BlockRunner<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BlockRunner$maybeRun$1(BlockRunner<T> blockRunner, kotlin.coroutines.e<? super BlockRunner$maybeRun$1> eVar) {
        super(2, eVar);
        this.this$0 = blockRunner;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final kotlin.coroutines.e<n1> create(@Nullable Object obj, @NotNull kotlin.coroutines.e<?> eVar) {
        BlockRunner$maybeRun$1 blockRunner$maybeRun$1 = new BlockRunner$maybeRun$1(this.this$0, eVar);
        blockRunner$maybeRun$1.L$0 = obj;
        return blockRunner$maybeRun$1;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull r0 r0Var, @Nullable kotlin.coroutines.e<? super n1> eVar) {
        return ((BlockRunner$maybeRun$1) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        CoroutineLiveData coroutineLiveData;
        Function2 function2;
        Function0 function0;
        Object l6 = kotlin.coroutines.intrinsics.a.l();
        int i6 = this.label;
        if (i6 != 0) {
            if (i6 == 1) {
                g0.n(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            g0.n(obj);
            r0 r0Var = (r0) this.L$0;
            coroutineLiveData = ((BlockRunner) this.this$0).liveData;
            LiveDataScopeImpl liveDataScopeImpl = new LiveDataScopeImpl(coroutineLiveData, r0Var.getCoroutineContext());
            function2 = ((BlockRunner) this.this$0).block;
            this.label = 1;
            if (function2.invoke(liveDataScopeImpl, this) == l6) {
                return l6;
            }
        }
        function0 = ((BlockRunner) this.this$0).onDone;
        function0.invoke();
        return n1.f44123a;
    }
}
