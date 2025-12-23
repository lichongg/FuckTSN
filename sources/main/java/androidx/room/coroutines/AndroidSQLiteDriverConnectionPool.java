package androidx.room.coroutines;

import androidx.room.Transactor;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteDriver;
import androidx.sqlite.driver.AndroidSQLiteConnection;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.g0;
import kotlin.s;
import kotlin.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class AndroidSQLiteDriverConnectionPool implements ConnectionPool {

    @NotNull
    private final s androidConnection$delegate;

    @NotNull
    private final SQLiteDriver driver;

    @NotNull
    private final String fileName;

    public AndroidSQLiteDriverConnectionPool(@NotNull SQLiteDriver driver, @NotNull String fileName) {
        g0.p(driver, "driver");
        g0.p(fileName, "fileName");
        this.driver = driver;
        this.fileName = fileName;
        this.androidConnection$delegate = t.c(new Function0() { // from class: androidx.room.coroutines.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                AndroidSQLiteDriverPooledConnection androidConnection_delegate$lambda$0;
                androidConnection_delegate$lambda$0 = AndroidSQLiteDriverConnectionPool.androidConnection_delegate$lambda$0(AndroidSQLiteDriverConnectionPool.this);
                return androidConnection_delegate$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AndroidSQLiteDriverPooledConnection androidConnection_delegate$lambda$0(AndroidSQLiteDriverConnectionPool androidSQLiteDriverConnectionPool) {
        SQLiteConnection open = androidSQLiteDriverConnectionPool.driver.open(androidSQLiteDriverConnectionPool.fileName);
        g0.n(open, "null cannot be cast to non-null type androidx.sqlite.driver.AndroidSQLiteConnection");
        return new AndroidSQLiteDriverPooledConnection((AndroidSQLiteConnection) open);
    }

    private final AndroidSQLiteDriverPooledConnection getAndroidConnection() {
        return (AndroidSQLiteDriverPooledConnection) this.androidConnection$delegate.getValue();
    }

    @Override // androidx.room.coroutines.ConnectionPool, java.lang.AutoCloseable
    public void close() {
        getAndroidConnection().getDelegate().close();
    }

    @Override // androidx.room.coroutines.ConnectionPool
    @Nullable
    public <R> Object useConnection(boolean z5, @NotNull Function2<? super Transactor, ? super kotlin.coroutines.e<? super R>, ? extends Object> function2, @NotNull kotlin.coroutines.e<? super R> eVar) {
        return function2.invoke(getAndroidConnection(), eVar);
    }
}
