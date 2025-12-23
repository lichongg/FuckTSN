package androidx.room.util;

import androidx.room.PooledConnection;
import androidx.room.TransactionScope;
import kotlin.coroutines.e;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.g0;
import kotlin.jvm.functions.Function2;
import kotlin.n1;

/* JADX INFO: Add missing generic type declarations: [R] */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@DebugMetadata(c = "androidx.room.util.DBUtil__DBUtilKt$internalPerform$2$result$1", f = "DBUtil.kt", i = {}, l = {59}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\Downloads\app\classes.dex */
public final class DBUtil__DBUtilKt$internalPerform$2$result$1<R> extends SuspendLambda implements Function2<TransactionScope<R>, e<? super R>, Object> {
    final /* synthetic */ Function2<PooledConnection, e<? super R>, Object> $block;
    private /* synthetic */ Object L$0;
    int label;

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(TransactionScope<R> transactionScope, e<? super R> eVar) {
        return ((DBUtil__DBUtilKt$internalPerform$2$result$1) create(transactionScope, eVar)).invokeSuspend(n1.f44123a);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DBUtil__DBUtilKt$internalPerform$2$result$1(Function2<? super PooledConnection, ? super e<? super R>, ? extends Object> function2, e<? super DBUtil__DBUtilKt$internalPerform$2$result$1> eVar) {
        super(2, eVar);
        this.$block = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final e<n1> create(Object obj, e<?> eVar) {
        DBUtil__DBUtilKt$internalPerform$2$result$1 dBUtil__DBUtilKt$internalPerform$2$result$1 = new DBUtil__DBUtilKt$internalPerform$2$result$1(this.$block, eVar);
        dBUtil__DBUtilKt$internalPerform$2$result$1.L$0 = obj;
        return dBUtil__DBUtilKt$internalPerform$2$result$1;
    }

    public final Object invokeSuspend$$forInline(Object obj) {
        return this.$block.invoke((TransactionScope) this.L$0, this);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object l6 = a.l();
        int i6 = this.label;
        if (i6 != 0) {
            if (i6 == 1) {
                g0.n(obj);
                return obj;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        g0.n(obj);
        TransactionScope transactionScope = (TransactionScope) this.L$0;
        Function2<PooledConnection, e<? super R>, Object> function2 = this.$block;
        this.label = 1;
        Object invoke = function2.invoke(transactionScope, this);
        if (invoke == l6) {
            return l6;
        }
        return invoke;
    }
}
