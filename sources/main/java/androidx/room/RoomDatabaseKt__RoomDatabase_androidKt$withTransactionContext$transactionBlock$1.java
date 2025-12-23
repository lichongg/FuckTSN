package androidx.room;

import kotlin.coroutines.i;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.g0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.n1;
import kotlinx.coroutines.r0;

/* JADX INFO: Add missing generic type declarations: [R] */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@DebugMetadata(c = "androidx.room.RoomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1", f = "RoomDatabase.android.kt", i = {0}, l = {2015}, m = "invokeSuspend", n = {"transactionElement"}, s = {"L$0"})
/* loaded from: D:\Downloads\app\classes.dex */
final class RoomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1<R> extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super R>, Object> {
    final /* synthetic */ Function1<kotlin.coroutines.e<? super R>, Object> $block;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    RoomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1(Function1<? super kotlin.coroutines.e<? super R>, ? extends Object> function1, kotlin.coroutines.e<? super RoomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1> eVar) {
        super(2, eVar);
        this.$block = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
        RoomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1 roomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1 = new RoomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1(this.$block, eVar);
        roomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1.L$0 = obj;
        return roomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(r0 r0Var, kotlin.coroutines.e<? super R> eVar) {
        return ((RoomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        TransactionElement transactionElement;
        Throwable th;
        Object l6 = kotlin.coroutines.intrinsics.a.l();
        int i6 = this.label;
        if (i6 != 0) {
            if (i6 == 1) {
                transactionElement = (TransactionElement) this.L$0;
                try {
                    g0.n(obj);
                } catch (Throwable th2) {
                    th = th2;
                    transactionElement.release();
                    throw th;
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            g0.n(obj);
            i.b bVar = ((r0) this.L$0).getCoroutineContext().get(TransactionElement.Key);
            kotlin.jvm.internal.g0.m(bVar);
            TransactionElement transactionElement2 = (TransactionElement) bVar;
            transactionElement2.acquire();
            try {
                Function1<kotlin.coroutines.e<? super R>, Object> function1 = this.$block;
                this.L$0 = transactionElement2;
                this.label = 1;
                Object invoke = function1.invoke(this);
                if (invoke == l6) {
                    return l6;
                }
                transactionElement = transactionElement2;
                obj = invoke;
            } catch (Throwable th3) {
                transactionElement = transactionElement2;
                th = th3;
                transactionElement.release();
                throw th;
            }
        }
        transactionElement.release();
        return obj;
    }
}
