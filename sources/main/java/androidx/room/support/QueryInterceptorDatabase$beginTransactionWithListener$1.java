package androidx.room.support;

import androidx.room.RoomDatabase;
import kotlin.collections.f0;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.g0;
import kotlin.jvm.functions.Function2;
import kotlin.n1;
import kotlinx.coroutines.r0;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@DebugMetadata(c = "androidx.room.support.QueryInterceptorDatabase$beginTransactionWithListener$1", f = "QueryInterceptorDatabase.android.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\Downloads\app\classes.dex */
final class QueryInterceptorDatabase$beginTransactionWithListener$1 extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {
    int label;
    final /* synthetic */ QueryInterceptorDatabase this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    QueryInterceptorDatabase$beginTransactionWithListener$1(QueryInterceptorDatabase queryInterceptorDatabase, kotlin.coroutines.e<? super QueryInterceptorDatabase$beginTransactionWithListener$1> eVar) {
        super(2, eVar);
        this.this$0 = queryInterceptorDatabase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
        return new QueryInterceptorDatabase$beginTransactionWithListener$1(this.this$0, eVar);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(r0 r0Var, kotlin.coroutines.e<? super n1> eVar) {
        return ((QueryInterceptorDatabase$beginTransactionWithListener$1) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        RoomDatabase.QueryCallback queryCallback;
        kotlin.coroutines.intrinsics.a.l();
        if (this.label == 0) {
            g0.n(obj);
            queryCallback = this.this$0.queryCallback;
            queryCallback.onQuery("BEGIN EXCLUSIVE TRANSACTION", f0.J());
            return n1.f44123a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
