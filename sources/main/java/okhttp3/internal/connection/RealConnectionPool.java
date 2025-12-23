package okhttp3.internal.connection;

import androidx.activity.k;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import kotlin.collections.f0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlin.n1;
import okhttp3.Address;
import okhttp3.ConnectionPool;
import okhttp3.Route;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.platform.Platform;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nRealConnectionPool.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RealConnectionPool.kt\nokhttp3/internal/connection/RealConnectionPool\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 Lockable.kt\nokhttp3/internal/concurrent/LockableKt\n*L\n1#1,326:1\n1#2:327\n1788#3,3:328\n1791#3:332\n63#4:331\n63#4:333\n63#4:334\n55#4,4:335\n55#4,4:339\n63#4:343\n63#4:344\n63#4:345\n55#4,4:346\n*S KotlinDebug\n*F\n+ 1 RealConnectionPool.kt\nokhttp3/internal/connection/RealConnectionPool\n*L\n64#1:328,3\n64#1:332\n65#1:331\n92#1:333\n111#1:334\n127#1:335,4\n139#1:339,4\n157#1:343\n201#1:344\n247#1:345\n287#1:346,4\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class RealConnectionPool {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private final TaskQueue cleanupQueue;

    @NotNull
    private final RealConnectionPool$cleanupTask$1 cleanupTask;

    @NotNull
    private final ConnectionListener connectionListener;

    @NotNull
    private final ConcurrentLinkedQueue<RealConnection> connections;
    private final long keepAliveDurationNs;
    private final int maxIdleConnections;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Companion {
        public /* synthetic */ Companion(v vVar) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final RealConnectionPool get(@NotNull ConnectionPool connectionPool) {
            g0.p(connectionPool, "connectionPool");
            return connectionPool.getDelegate$okhttp();
        }
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [okhttp3.internal.connection.RealConnectionPool$cleanupTask$1] */
    public RealConnectionPool(@NotNull TaskRunner taskRunner, int i6, long j6, @NotNull TimeUnit timeUnit, @NotNull ConnectionListener connectionListener) {
        g0.p(taskRunner, "taskRunner");
        g0.p(timeUnit, "timeUnit");
        g0.p(connectionListener, "connectionListener");
        this.maxIdleConnections = i6;
        this.connectionListener = connectionListener;
        this.keepAliveDurationNs = timeUnit.toNanos(j6);
        this.cleanupQueue = taskRunner.newQueue();
        final String str = _UtilJvmKt.okHttpName + " ConnectionPool connection closer";
        this.cleanupTask = new Task(str) { // from class: okhttp3.internal.connection.RealConnectionPool$cleanupTask$1
            @Override // okhttp3.internal.concurrent.Task
            public long runOnce() {
                return RealConnectionPool.this.closeConnections(System.nanoTime());
            }
        };
        this.connections = new ConcurrentLinkedQueue<>();
        if (j6 > 0) {
            return;
        }
        throw new IllegalArgumentException(("keepAliveDuration <= 0: " + j6).toString());
    }

    private final int pruneAndGetAllocationCount(RealConnection realConnection, long j6) {
        if (_UtilJvmKt.assertionsEnabled && !Thread.holdsLock(realConnection)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + realConnection);
        }
        List<Reference<RealCall>> calls = realConnection.getCalls();
        int i6 = 0;
        while (i6 < calls.size()) {
            Reference<RealCall> reference = calls.get(i6);
            if (reference.get() != null) {
                i6++;
            } else {
                g0.n(reference, "null cannot be cast to non-null type okhttp3.internal.connection.RealCall.CallReference");
                Platform.Companion.get().logCloseableLeak("A connection to " + realConnection.route().address().url() + " was leaked. Did you forget to close a response body?", ((RealCall.CallReference) reference).getCallStackTrace());
                calls.remove(i6);
                if (calls.isEmpty()) {
                    realConnection.setIdleAtNs(j6 - this.keepAliveDurationNs);
                    return 0;
                }
            }
        }
        return calls.size();
    }

    @Nullable
    public final RealConnection callAcquirePooledConnection$okhttp(boolean z5, @NotNull Address address, @NotNull RealCall call, @Nullable List<Route> list, boolean z6) {
        boolean z7;
        boolean noNewExchanges;
        Socket releaseConnectionNoEvents$okhttp;
        g0.p(address, "address");
        g0.p(call, "call");
        Iterator<RealConnection> it = this.connections.iterator();
        g0.o(it, "iterator(...)");
        while (it.hasNext()) {
            RealConnection next = it.next();
            g0.m(next);
            synchronized (next) {
                z7 = false;
                if (z6) {
                    try {
                        if (!next.isMultiplexed$okhttp()) {
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (next.isEligible$okhttp(address, list)) {
                    call.acquireConnectionNoEvents(next);
                    z7 = true;
                }
            }
            if (z7) {
                if (next.isHealthy(z5)) {
                    return next;
                }
                synchronized (next) {
                    noNewExchanges = next.getNoNewExchanges();
                    next.setNoNewExchanges(true);
                    releaseConnectionNoEvents$okhttp = call.releaseConnectionNoEvents$okhttp();
                }
                if (releaseConnectionNoEvents$okhttp != null) {
                    _UtilJvmKt.closeQuietly(releaseConnectionNoEvents$okhttp);
                    this.connectionListener.connectionClosed(next);
                } else if (!noNewExchanges) {
                    this.connectionListener.noNewExchanges(next);
                }
            }
        }
        return null;
    }

    public final long closeConnections(long j6) {
        long j7 = (j6 - this.keepAliveDurationNs) + 1;
        Iterator<RealConnection> it = this.connections.iterator();
        g0.o(it, "iterator(...)");
        RealConnection realConnection = null;
        long j8 = Long.MAX_VALUE;
        int i6 = 0;
        RealConnection realConnection2 = null;
        RealConnection realConnection3 = null;
        int i7 = 0;
        while (it.hasNext()) {
            RealConnection next = it.next();
            g0.m(next);
            synchronized (next) {
                if (pruneAndGetAllocationCount(next, j6) > 0) {
                    i7++;
                } else {
                    long idleAtNs = next.getIdleAtNs();
                    if (idleAtNs < j7) {
                        realConnection2 = next;
                        j7 = idleAtNs;
                    }
                    i6++;
                    if (idleAtNs < j8) {
                        realConnection3 = next;
                        j8 = idleAtNs;
                    }
                }
                n1 n1Var = n1.f44123a;
            }
        }
        if (realConnection2 != null) {
            realConnection = realConnection2;
        } else if (i6 > this.maxIdleConnections) {
            j7 = j8;
            realConnection = realConnection3;
        } else {
            j7 = -1;
        }
        if (realConnection == null) {
            if (realConnection3 != null) {
                return (j8 + this.keepAliveDurationNs) - j6;
            }
            if (i7 > 0) {
                return this.keepAliveDurationNs;
            }
            return -1L;
        }
        synchronized (realConnection) {
            if (!realConnection.getCalls().isEmpty()) {
                return 0L;
            }
            if (realConnection.getIdleAtNs() != j7) {
                return 0L;
            }
            realConnection.setNoNewExchanges(true);
            this.connections.remove(realConnection);
            _UtilJvmKt.closeQuietly(realConnection.socket());
            this.connectionListener.connectionClosed(realConnection);
            if (this.connections.isEmpty()) {
                this.cleanupQueue.cancelAll();
            }
            return 0L;
        }
    }

    public final boolean connectionBecameIdle(@NotNull RealConnection connection) {
        g0.p(connection, "connection");
        if (_UtilJvmKt.assertionsEnabled && !Thread.holdsLock(connection)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + connection);
        }
        if (!connection.getNoNewExchanges() && this.maxIdleConnections != 0) {
            scheduleCloser();
            return false;
        }
        connection.setNoNewExchanges(true);
        this.connections.remove(connection);
        if (this.connections.isEmpty()) {
            this.cleanupQueue.cancelAll();
        }
        return true;
    }

    public final int connectionCount() {
        return this.connections.size();
    }

    public final void evictAll() {
        Socket socket;
        Iterator<RealConnection> it = this.connections.iterator();
        g0.o(it, "iterator(...)");
        while (it.hasNext()) {
            RealConnection next = it.next();
            g0.m(next);
            synchronized (next) {
                if (next.getCalls().isEmpty()) {
                    it.remove();
                    next.setNoNewExchanges(true);
                    socket = next.socket();
                } else {
                    socket = null;
                }
            }
            if (socket != null) {
                _UtilJvmKt.closeQuietly(socket);
                this.connectionListener.connectionClosed(next);
            }
        }
        if (this.connections.isEmpty()) {
            this.cleanupQueue.cancelAll();
        }
    }

    @NotNull
    public final ConnectionListener getConnectionListener$okhttp() {
        return this.connectionListener;
    }

    public final long getKeepAliveDurationNs$okhttp() {
        return this.keepAliveDurationNs;
    }

    public final int idleConnectionCount() {
        boolean isEmpty;
        ConcurrentLinkedQueue<RealConnection> concurrentLinkedQueue = this.connections;
        int i6 = 0;
        if (k.a(concurrentLinkedQueue) && concurrentLinkedQueue.isEmpty()) {
            return 0;
        }
        for (RealConnection realConnection : concurrentLinkedQueue) {
            g0.m(realConnection);
            synchronized (realConnection) {
                isEmpty = realConnection.getCalls().isEmpty();
            }
            if (isEmpty && (i6 = i6 + 1) < 0) {
                f0.a0();
            }
        }
        return i6;
    }

    public final void put(@NotNull RealConnection connection) {
        g0.p(connection, "connection");
        if (!_UtilJvmKt.assertionsEnabled || Thread.holdsLock(connection)) {
            this.connections.add(connection);
            scheduleCloser();
            return;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + connection);
    }

    public final void scheduleCloser() {
        TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
    }
}
