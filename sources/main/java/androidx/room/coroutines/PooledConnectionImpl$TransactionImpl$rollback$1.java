package androidx.room.coroutines;

import androidx.room.coroutines.PooledConnectionImpl;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@DebugMetadata(c = "androidx.room.coroutines.PooledConnectionImpl$TransactionImpl", f = "ConnectionPoolImpl.kt", i = {0, 0}, l = {573}, m = "rollback", n = {"result", "$this$withLock_u24default$iv"}, s = {"L$0", "L$2"})
/* loaded from: D:\Downloads\app\classes.dex */
final class PooledConnectionImpl$TransactionImpl$rollback$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PooledConnectionImpl.TransactionImpl<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PooledConnectionImpl$TransactionImpl$rollback$1(PooledConnectionImpl.TransactionImpl<T> transactionImpl, kotlin.coroutines.e<? super PooledConnectionImpl$TransactionImpl$rollback$1> eVar) {
        super(eVar);
        this.this$0 = transactionImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.rollback(null, this);
    }
}
