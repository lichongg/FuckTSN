package androidx.room.coroutines;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@DebugMetadata(c = "androidx.room.coroutines.Pool", f = "ConnectionPoolImpl.kt", i = {0, 0, 0, 0}, l = {209}, m = "acquireWithTimeout-KLykuaI", n = {"this", "onTimeout", "connection", "timeout"}, s = {"L$0", "L$1", "L$2", "J$0"})
/* loaded from: D:\Downloads\app\classes.dex */
final class Pool$acquireWithTimeout$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ Pool this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Pool$acquireWithTimeout$1(Pool pool, kotlin.coroutines.e<? super Pool$acquireWithTimeout$1> eVar) {
        super(eVar);
        this.this$0 = pool;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.m35acquireWithTimeoutKLykuaI(0L, null, this);
    }
}
