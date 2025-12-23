package androidx.room;

import java.util.concurrent.Callable;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.g0;
import kotlin.jvm.functions.Function2;
import kotlin.n1;
import kotlinx.coroutines.r0;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@DebugMetadata(c = "androidx.room.CoroutinesRoom$Companion$execute$4$job$1", f = "CoroutinesRoom.android.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\Downloads\app\classes.dex */
final class CoroutinesRoom$Companion$execute$4$job$1 extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {
    final /* synthetic */ Callable<R> $callable;
    final /* synthetic */ kotlinx.coroutines.p<R> $continuation;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    CoroutinesRoom$Companion$execute$4$job$1(Callable<R> callable, kotlinx.coroutines.p<? super R> pVar, kotlin.coroutines.e<? super CoroutinesRoom$Companion$execute$4$job$1> eVar) {
        super(2, eVar);
        this.$callable = callable;
        this.$continuation = pVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
        return new CoroutinesRoom$Companion$execute$4$job$1(this.$callable, this.$continuation, eVar);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(r0 r0Var, kotlin.coroutines.e<? super n1> eVar) {
        return ((CoroutinesRoom$Companion$execute$4$job$1) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        kotlin.coroutines.intrinsics.a.l();
        if (this.label == 0) {
            g0.n(obj);
            try {
                Object call = this.$callable.call();
                kotlin.coroutines.e eVar = this.$continuation;
                Result.a aVar = Result.Companion;
                eVar.resumeWith(Result.m130constructorimpl(call));
            } catch (Throwable th) {
                kotlin.coroutines.e eVar2 = this.$continuation;
                Result.a aVar2 = Result.Companion;
                eVar2.resumeWith(Result.m130constructorimpl(g0.a(th)));
            }
            return n1.f44123a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
