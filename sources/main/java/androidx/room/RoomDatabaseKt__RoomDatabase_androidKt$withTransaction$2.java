package androidx.room;

import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.g0;
import kotlin.jvm.functions.Function1;
import kotlin.n1;

/* JADX INFO: Add missing generic type declarations: [R] */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@DebugMetadata(c = "androidx.room.RoomDatabaseKt__RoomDatabase_androidKt$withTransaction$2", f = "RoomDatabase.android.kt", i = {}, l = {2001}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\Downloads\app\classes.dex */
final class RoomDatabaseKt__RoomDatabase_androidKt$withTransaction$2<R> extends SuspendLambda implements Function1<kotlin.coroutines.e<? super R>, Object> {
    final /* synthetic */ Function1<kotlin.coroutines.e<? super R>, Object> $block;
    final /* synthetic */ RoomDatabase $this_withTransaction;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    RoomDatabaseKt__RoomDatabase_androidKt$withTransaction$2(RoomDatabase roomDatabase, Function1<? super kotlin.coroutines.e<? super R>, ? extends Object> function1, kotlin.coroutines.e<? super RoomDatabaseKt__RoomDatabase_androidKt$withTransaction$2> eVar) {
        super(1, eVar);
        this.$this_withTransaction = roomDatabase;
        this.$block = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.e<n1> create(kotlin.coroutines.e<?> eVar) {
        return new RoomDatabaseKt__RoomDatabase_androidKt$withTransaction$2(this.$this_withTransaction, this.$block, eVar);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(kotlin.coroutines.e<? super R> eVar) {
        return ((RoomDatabaseKt__RoomDatabase_androidKt$withTransaction$2) create(eVar)).invokeSuspend(n1.f44123a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object l6 = kotlin.coroutines.intrinsics.a.l();
        int i6 = this.label;
        try {
            if (i6 != 0) {
                if (i6 == 1) {
                    g0.n(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                g0.n(obj);
                this.$this_withTransaction.beginTransaction();
                Function1<kotlin.coroutines.e<? super R>, Object> function1 = this.$block;
                this.label = 1;
                obj = function1.invoke(this);
                if (obj == l6) {
                    return l6;
                }
            }
            this.$this_withTransaction.setTransactionSuccessful();
            return obj;
        } finally {
            this.$this_withTransaction.endTransaction();
        }
    }
}
