package androidx.room;

import androidx.room.Transactor;
import androidx.sqlite.SQLiteStatement;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class TransactorKt {
    @Nullable
    public static final <R> Object deferredTransaction(@NotNull Transactor transactor, @NotNull Function2<? super TransactionScope<R>, ? super kotlin.coroutines.e<? super R>, ? extends Object> function2, @NotNull kotlin.coroutines.e<? super R> eVar) {
        return transactor.withTransaction(Transactor.SQLiteTransactionType.DEFERRED, function2, eVar);
    }

    @Nullable
    public static final <R> Object exclusiveTransaction(@NotNull Transactor transactor, @NotNull Function2<? super TransactionScope<R>, ? super kotlin.coroutines.e<? super R>, ? extends Object> function2, @NotNull kotlin.coroutines.e<? super R> eVar) {
        return transactor.withTransaction(Transactor.SQLiteTransactionType.EXCLUSIVE, function2, eVar);
    }

    @Nullable
    public static final Object execSQL(@NotNull PooledConnection pooledConnection, @NotNull String str, @NotNull kotlin.coroutines.e<? super n1> eVar) {
        Object usePrepared = pooledConnection.usePrepared(str, new Function1() { // from class: androidx.room.w
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                boolean execSQL$lambda$0;
                execSQL$lambda$0 = TransactorKt.execSQL$lambda$0((SQLiteStatement) obj);
                return Boolean.valueOf(execSQL$lambda$0);
            }
        }, eVar);
        return usePrepared == kotlin.coroutines.intrinsics.a.l() ? usePrepared : n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean execSQL$lambda$0(SQLiteStatement it) {
        g0.p(it, "it");
        return it.step();
    }

    @Nullable
    public static final <R> Object immediateTransaction(@NotNull Transactor transactor, @NotNull Function2<? super TransactionScope<R>, ? super kotlin.coroutines.e<? super R>, ? extends Object> function2, @NotNull kotlin.coroutines.e<? super R> eVar) {
        return transactor.withTransaction(Transactor.SQLiteTransactionType.IMMEDIATE, function2, eVar);
    }
}
