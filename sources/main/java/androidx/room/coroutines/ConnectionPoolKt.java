package androidx.room.coroutines;

import androidx.sqlite.SQLiteDriver;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class ConnectionPoolKt {
    @NotNull
    public static final ConnectionPool newConnectionPool(@NotNull SQLiteDriver driver, @NotNull String fileName, int i6, int i7) {
        g0.p(driver, "driver");
        g0.p(fileName, "fileName");
        return new ConnectionPoolImpl(driver, fileName, i6, i7);
    }

    @NotNull
    public static final ConnectionPool newSingleConnectionPool(@NotNull SQLiteDriver driver, @NotNull String fileName) {
        g0.p(driver, "driver");
        g0.p(fileName, "fileName");
        return new ConnectionPoolImpl(driver, fileName);
    }
}
