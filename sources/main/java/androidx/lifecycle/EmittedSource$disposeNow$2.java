package androidx.lifecycle;

import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.g0;
import kotlin.jvm.functions.Function2;
import kotlin.n1;
import kotlinx.coroutines.r0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@DebugMetadata(c = "androidx.lifecycle.EmittedSource$disposeNow$2", f = "CoroutineLiveData.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\Downloads\app\classes.dex */
final class EmittedSource$disposeNow$2 extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {
    int label;
    final /* synthetic */ EmittedSource this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    EmittedSource$disposeNow$2(EmittedSource emittedSource, kotlin.coroutines.e<? super EmittedSource$disposeNow$2> eVar) {
        super(2, eVar);
        this.this$0 = emittedSource;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final kotlin.coroutines.e<n1> create(@Nullable Object obj, @NotNull kotlin.coroutines.e<?> eVar) {
        return new EmittedSource$disposeNow$2(this.this$0, eVar);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull r0 r0Var, @Nullable kotlin.coroutines.e<? super n1> eVar) {
        return ((EmittedSource$disposeNow$2) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        kotlin.coroutines.intrinsics.a.l();
        if (this.label == 0) {
            g0.n(obj);
            this.this$0.removeSource();
            return n1.f44123a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
