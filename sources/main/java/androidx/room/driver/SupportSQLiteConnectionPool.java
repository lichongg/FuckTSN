package androidx.room.driver;

import androidx.room.Transactor;
import androidx.room.coroutines.ConnectionPool;
import kotlin.coroutines.e;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.g0;
import net.sqlcipher.database.SQLiteDatabase;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class SupportSQLiteConnectionPool implements ConnectionPool {

    @NotNull
    private final SupportSQLiteDriver supportDriver;

    public SupportSQLiteConnectionPool(@NotNull SupportSQLiteDriver supportDriver) {
        g0.p(supportDriver, "supportDriver");
        this.supportDriver = supportDriver;
    }

    private final SupportSQLitePooledConnection getSupportConnection() {
        String databaseName = this.supportDriver.getOpenHelper().getDatabaseName();
        if (databaseName == null) {
            databaseName = SQLiteDatabase.MEMORY;
        }
        return new SupportSQLitePooledConnection(this.supportDriver.open(databaseName));
    }

    @Override // androidx.room.coroutines.ConnectionPool, java.lang.AutoCloseable
    public void close() {
        this.supportDriver.getOpenHelper().close();
    }

    @NotNull
    public final SupportSQLiteDriver getSupportDriver$room_runtime_release() {
        return this.supportDriver;
    }

    @Override // androidx.room.coroutines.ConnectionPool
    @Nullable
    public <R> Object useConnection(boolean z5, @NotNull Function2<? super Transactor, ? super e<? super R>, ? extends Object> function2, @NotNull e<? super R> eVar) {
        return function2.invoke(getSupportConnection(), eVar);
    }
}
