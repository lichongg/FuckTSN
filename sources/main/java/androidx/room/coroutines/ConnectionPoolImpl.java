package androidx.room.coroutines;

import android.database.SQLException;
import androidx.room.concurrent.ThreadLocal_jvmAndroidKt;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteDriver;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.KotlinNothingValueException;
import kotlin.coroutines.i;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import kotlin.time.DurationUnit;
import kotlin.time.h;
import kotlin.time.j;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nConnectionPoolImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConnectionPoolImpl.kt\nandroidx/room/coroutines/ConnectionPoolImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,556:1\n1#2:557\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
public final class ConnectionPoolImpl implements ConnectionPool {

    @NotNull
    private final AtomicBoolean _isClosed;

    @NotNull
    private final SQLiteDriver driver;

    @NotNull
    private final Pool readers;

    @NotNull
    private final ThreadLocal<PooledConnectionImpl> threadLocal;
    private boolean throwOnTimeout;
    private long timeout;

    @NotNull
    private final Pool writers;

    public ConnectionPoolImpl(@NotNull final SQLiteDriver driver, @NotNull final String fileName) {
        g0.p(driver, "driver");
        g0.p(fileName, "fileName");
        this.threadLocal = new ThreadLocal<>();
        this._isClosed = new AtomicBoolean(false);
        h.a aVar = h.f48019b;
        this.timeout = j.w(30, DurationUnit.SECONDS);
        this.driver = driver;
        Pool pool = new Pool(1, new Function0() { // from class: androidx.room.coroutines.d
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                SQLiteConnection open;
                open = SQLiteDriver.this.open(fileName);
                return open;
            }
        });
        this.readers = pool;
        this.writers = pool;
    }

    private final i createConnectionContext(PooledConnectionImpl pooledConnectionImpl) {
        return new ConnectionElement(pooledConnectionImpl).plus(ThreadLocal_jvmAndroidKt.asContextElement(this.threadLocal, pooledConnectionImpl));
    }

    private final boolean isClosed() {
        return this._isClosed.get();
    }

    private final void onTimeout(boolean z5) {
        String str = z5 ? "reader" : "writer";
        StringBuilder sb = new StringBuilder();
        sb.append("Timed out attempting to acquire a " + str + " connection.");
        sb.append('\n');
        sb.append('\n');
        sb.append("Writer pool:");
        sb.append('\n');
        this.writers.dump(sb);
        sb.append("Reader pool:");
        sb.append('\n');
        this.readers.dump(sb);
        try {
            SQLite.throwSQLiteException(5, sb.toString());
            throw new KotlinNothingValueException();
        } catch (SQLException e6) {
            if (this.throwOnTimeout) {
                throw e6;
            }
            e6.printStackTrace();
        }
    }

    @Override // androidx.room.coroutines.ConnectionPool, java.lang.AutoCloseable
    public void close() {
        if (this._isClosed.compareAndSet(false, true)) {
            this.readers.close();
            this.writers.close();
        }
    }

    public final boolean getThrowOnTimeout$room_runtime_release() {
        return this.throwOnTimeout;
    }

    /* renamed from: getTimeout-UwyO8pc$room_runtime_release, reason: not valid java name */
    public final long m33getTimeoutUwyO8pc$room_runtime_release() {
        return this.timeout;
    }

    public final void setThrowOnTimeout$room_runtime_release(boolean z5) {
        this.throwOnTimeout = z5;
    }

    /* renamed from: setTimeout-LRDsOJo$room_runtime_release, reason: not valid java name */
    public final void m34setTimeoutLRDsOJo$room_runtime_release(long j6) {
        this.timeout = j6;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0155 A[Catch: all -> 0x0166, TRY_LEAVE, TryCatch #1 {all -> 0x0166, blocks: (B:16:0x014f, B:18:0x0155), top: B:15:0x014f }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x012c A[Catch: all -> 0x0167, TRY_LEAVE, TryCatch #2 {all -> 0x0167, blocks: (B:43:0x0111, B:47:0x0121, B:49:0x012c, B:53:0x016c, B:54:0x0173, B:89:0x00ec), top: B:88:0x00ec }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x016c A[Catch: all -> 0x0167, TRY_ENTER, TryCatch #2 {all -> 0x0167, blocks: (B:43:0x0111, B:47:0x0121, B:49:0x012c, B:53:0x016c, B:54:0x0173, B:89:0x00ec), top: B:88:0x00ec }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /* JADX WARN: Type inference failed for: r13v14, types: [T, androidx.room.coroutines.PooledConnectionImpl] */
    @Override // androidx.room.coroutines.ConnectionPool
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public <R> java.lang.Object useConnection(final boolean r13, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super androidx.room.Transactor, ? super kotlin.coroutines.e<? super R>, ? extends java.lang.Object> r14, @org.jetbrains.annotations.NotNull kotlin.coroutines.e<? super R> r15) {
        /*
            Method dump skipped, instructions count: 416
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.coroutines.ConnectionPoolImpl.useConnection(boolean, kotlin.jvm.functions.Function2, kotlin.coroutines.e):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SQLiteConnection _init_$lambda$4(SQLiteDriver sQLiteDriver, String str) {
        SQLiteConnection open = sQLiteDriver.open(str);
        SQLite.execSQL(open, "PRAGMA query_only = 1");
        return open;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 useConnection$lambda$6(ConnectionPoolImpl connectionPoolImpl, boolean z5) {
        connectionPoolImpl.onTimeout(z5);
        return n1.f44123a;
    }

    public ConnectionPoolImpl(@NotNull final SQLiteDriver driver, @NotNull final String fileName, int i6, int i7) {
        g0.p(driver, "driver");
        g0.p(fileName, "fileName");
        this.threadLocal = new ThreadLocal<>();
        this._isClosed = new AtomicBoolean(false);
        h.a aVar = h.f48019b;
        this.timeout = j.w(30, DurationUnit.SECONDS);
        if (i6 <= 0) {
            throw new IllegalArgumentException("Maximum number of readers must be greater than 0");
        }
        if (i7 > 0) {
            this.driver = driver;
            this.readers = new Pool(i6, new Function0() { // from class: androidx.room.coroutines.b
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    SQLiteConnection _init_$lambda$4;
                    _init_$lambda$4 = ConnectionPoolImpl._init_$lambda$4(SQLiteDriver.this, fileName);
                    return _init_$lambda$4;
                }
            });
            this.writers = new Pool(i7, new Function0() { // from class: androidx.room.coroutines.c
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    SQLiteConnection open;
                    open = SQLiteDriver.this.open(fileName);
                    return open;
                }
            });
            return;
        }
        throw new IllegalArgumentException("Maximum number of writers must be greater than 0");
    }
}
