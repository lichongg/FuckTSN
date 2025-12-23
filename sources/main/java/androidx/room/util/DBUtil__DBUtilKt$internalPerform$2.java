package androidx.room.util;

import androidx.room.InvalidationTracker;
import androidx.room.PooledConnection;
import androidx.room.RoomDatabase;
import androidx.room.Transactor;
import kotlin.coroutines.e;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.d0;
import kotlin.n1;

/* JADX INFO: Add missing generic type declarations: [R] */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@DebugMetadata(c = "androidx.room.util.DBUtil__DBUtilKt$internalPerform$2", f = "DBUtil.kt", i = {0, 0, 1, 1, 2, 3}, l = {56, 57, 59, 60, 65}, m = "invokeSuspend", n = {"transactor", "type", "transactor", "type", "transactor", "result"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$0"})
/* loaded from: D:\Downloads\app\classes.dex */
public final class DBUtil__DBUtilKt$internalPerform$2<R> extends SuspendLambda implements Function2<Transactor, e<? super R>, Object> {
    final /* synthetic */ Function2<PooledConnection, e<? super R>, Object> $block;
    final /* synthetic */ boolean $inTransaction;
    final /* synthetic */ boolean $isReadOnly;
    final /* synthetic */ RoomDatabase $this_internalPerform;
    /* synthetic */ Object L$0;
    Object L$1;
    int label;

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Transactor transactor, e<? super R> eVar) {
        return ((DBUtil__DBUtilKt$internalPerform$2) create(transactor, eVar)).invokeSuspend(n1.f44123a);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DBUtil__DBUtilKt$internalPerform$2(boolean z5, boolean z6, RoomDatabase roomDatabase, Function2<? super PooledConnection, ? super e<? super R>, ? extends Object> function2, e<? super DBUtil__DBUtilKt$internalPerform$2> eVar) {
        super(2, eVar);
        this.$inTransaction = z5;
        this.$isReadOnly = z6;
        this.$this_internalPerform = roomDatabase;
        this.$block = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final e<n1> create(Object obj, e<?> eVar) {
        DBUtil__DBUtilKt$internalPerform$2 dBUtil__DBUtilKt$internalPerform$2 = new DBUtil__DBUtilKt$internalPerform$2(this.$inTransaction, this.$isReadOnly, this.$this_internalPerform, this.$block, eVar);
        dBUtil__DBUtilKt$internalPerform$2.L$0 = obj;
        return dBUtil__DBUtilKt$internalPerform$2;
    }

    public final Object invokeSuspend$$forInline(Object obj) {
        Transactor transactor = (Transactor) this.L$0;
        if (!this.$inTransaction) {
            return this.$block.invoke(transactor, this);
        }
        boolean z5 = this.$isReadOnly;
        Transactor.SQLiteTransactionType sQLiteTransactionType = z5 ? Transactor.SQLiteTransactionType.DEFERRED : Transactor.SQLiteTransactionType.IMMEDIATE;
        if (!z5) {
            d0.e(0);
            Object inTransaction = transactor.inTransaction(this);
            d0.e(1);
            if (!((Boolean) inTransaction).booleanValue()) {
                InvalidationTracker invalidationTracker = this.$this_internalPerform.getInvalidationTracker();
                d0.e(0);
                invalidationTracker.sync$room_runtime_release(this);
                d0.e(1);
            }
        }
        DBUtil__DBUtilKt$internalPerform$2$result$1 dBUtil__DBUtilKt$internalPerform$2$result$1 = new DBUtil__DBUtilKt$internalPerform$2$result$1(this.$block, null);
        d0.e(0);
        Object withTransaction = transactor.withTransaction(sQLiteTransactionType, dBUtil__DBUtilKt$internalPerform$2$result$1, this);
        d0.e(1);
        if (!this.$isReadOnly) {
            d0.e(0);
            Object inTransaction2 = transactor.inTransaction(this);
            d0.e(1);
            if (!((Boolean) inTransaction2).booleanValue()) {
                this.$this_internalPerform.getInvalidationTracker().refreshAsync();
            }
        }
        return withTransaction;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00a5, code lost:
    
        if (r9 == r0) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x008b, code lost:
    
        if (r9.sync$room_runtime_release(r8) == r0) goto L51;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00c1  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            Method dump skipped, instructions count: 216
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.util.DBUtil__DBUtilKt$internalPerform$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
