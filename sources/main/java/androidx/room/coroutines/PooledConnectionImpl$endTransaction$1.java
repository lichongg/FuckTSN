package androidx.room.coroutines;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@DebugMetadata(c = "androidx.room.coroutines.PooledConnectionImpl", f = "ConnectionPoolImpl.kt", i = {0, 0, 0}, l = {562}, m = "endTransaction", n = {"this", "$this$withLock_u24default$iv", "success"}, s = {"L$0", "L$1", "Z$0"})
/* loaded from: D:\Downloads\app\classes.dex */
final class PooledConnectionImpl$endTransaction$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PooledConnectionImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PooledConnectionImpl$endTransaction$1(PooledConnectionImpl pooledConnectionImpl, kotlin.coroutines.e<? super PooledConnectionImpl$endTransaction$1> eVar) {
        super(eVar);
        this.this$0 = pooledConnectionImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object endTransaction;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        endTransaction = this.this$0.endTransaction(false, this);
        return endTransaction;
    }
}
