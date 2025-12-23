package okhttp3;

import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.ConnectionListener;
import okhttp3.internal.connection.RealConnectionPool;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class ConnectionPool {

    @NotNull
    private final RealConnectionPool delegate;

    public ConnectionPool(@NotNull RealConnectionPool delegate) {
        g0.p(delegate, "delegate");
        this.delegate = delegate;
    }

    public final int connectionCount() {
        return this.delegate.connectionCount();
    }

    public final void evictAll() {
        this.delegate.evictAll();
    }

    @NotNull
    public final ConnectionListener getConnectionListener$okhttp() {
        return this.delegate.getConnectionListener$okhttp();
    }

    @NotNull
    public final RealConnectionPool getDelegate$okhttp() {
        return this.delegate;
    }

    public final int idleConnectionCount() {
        return this.delegate.idleConnectionCount();
    }

    public /* synthetic */ ConnectionPool(int i6, long j6, TimeUnit timeUnit, TaskRunner taskRunner, ConnectionListener connectionListener, int i7, v vVar) {
        this((i7 & 1) != 0 ? 5 : i6, (i7 & 2) != 0 ? 5L : j6, (i7 & 4) != 0 ? TimeUnit.MINUTES : timeUnit, (i7 & 8) != 0 ? TaskRunner.INSTANCE : taskRunner, (i7 & 16) != 0 ? ConnectionListener.Companion.getNONE() : connectionListener);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ConnectionPool(int i6, long j6, @NotNull TimeUnit timeUnit, @NotNull TaskRunner taskRunner, @NotNull ConnectionListener connectionListener) {
        this(new RealConnectionPool(taskRunner, i6, j6, timeUnit, connectionListener));
        g0.p(timeUnit, "timeUnit");
        g0.p(taskRunner, "taskRunner");
        g0.p(connectionListener, "connectionListener");
    }

    public /* synthetic */ ConnectionPool(int i6, long j6, TimeUnit timeUnit, ConnectionListener connectionListener, int i7, v vVar) {
        this((i7 & 1) != 0 ? 5 : i6, (i7 & 2) != 0 ? 5L : j6, (i7 & 4) != 0 ? TimeUnit.MINUTES : timeUnit, (i7 & 8) != 0 ? ConnectionListener.Companion.getNONE() : connectionListener);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ConnectionPool(int i6, long j6, @NotNull TimeUnit timeUnit, @NotNull ConnectionListener connectionListener) {
        this(i6, j6, timeUnit, TaskRunner.INSTANCE, connectionListener);
        g0.p(timeUnit, "timeUnit");
        g0.p(connectionListener, "connectionListener");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ConnectionPool(int i6, long j6, @NotNull TimeUnit timeUnit) {
        this(i6, j6, timeUnit, TaskRunner.INSTANCE, ConnectionListener.Companion.getNONE());
        g0.p(timeUnit, "timeUnit");
    }

    public ConnectionPool() {
        this(5, 5L, TimeUnit.MINUTES);
    }
}
