package androidx.room.coroutines;

import androidx.room.Transactor;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.g0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.n1;
import kotlinx.coroutines.r0;

/* JADX INFO: Add missing generic type declarations: [R] */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@DebugMetadata(c = "androidx.room.coroutines.ConnectionPoolImpl$useConnection$4", f = "ConnectionPoolImpl.kt", i = {}, l = {143}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\Downloads\app\classes.dex */
final class ConnectionPoolImpl$useConnection$4<R> extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super R>, Object> {
    final /* synthetic */ Function2<Transactor, kotlin.coroutines.e<? super R>, Object> $block;
    final /* synthetic */ Ref.ObjectRef<PooledConnectionImpl> $connection;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    ConnectionPoolImpl$useConnection$4(Function2<? super Transactor, ? super kotlin.coroutines.e<? super R>, ? extends Object> function2, Ref.ObjectRef<PooledConnectionImpl> objectRef, kotlin.coroutines.e<? super ConnectionPoolImpl$useConnection$4> eVar) {
        super(2, eVar);
        this.$block = function2;
        this.$connection = objectRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
        return new ConnectionPoolImpl$useConnection$4(this.$block, this.$connection, eVar);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(r0 r0Var, kotlin.coroutines.e<? super R> eVar) {
        return ((ConnectionPoolImpl$useConnection$4) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object l6 = kotlin.coroutines.intrinsics.a.l();
        int i6 = this.label;
        if (i6 != 0) {
            if (i6 == 1) {
                g0.n(obj);
                return obj;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        g0.n(obj);
        Function2<Transactor, kotlin.coroutines.e<? super R>, Object> function2 = this.$block;
        PooledConnectionImpl pooledConnectionImpl = this.$connection.element;
        this.label = 1;
        Object invoke = function2.invoke(pooledConnectionImpl, this);
        if (invoke == l6) {
            return l6;
        }
        return invoke;
    }
}
