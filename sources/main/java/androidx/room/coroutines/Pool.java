package androidx.room.coroutines;

import androidx.collection.CircularArray;
import androidx.sqlite.SQLiteConnection;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.collections.f0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import kotlinx.coroutines.sync.f;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nConnectionPoolImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConnectionPoolImpl.kt\nandroidx/room/coroutines/Pool\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ReentrantLock.kt\nandroidx/room/concurrent/ReentrantLockKt\n+ 4 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,556:1\n1#2:557\n28#3,5:558\n28#3,5:563\n28#3,3:568\n32#3:573\n28#3,3:574\n32#3:580\n13402#4,2:571\n13467#4,3:577\n*S KotlinDebug\n*F\n+ 1 ConnectionPoolImpl.kt\nandroidx/room/coroutines/Pool\n*L\n233#1:558,5\n259#1:563,5\n264#1:568,3\n264#1:573\n272#1:574,3\n272#1:580\n266#1:571,2\n285#1:577,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
final class Pool {

    @NotNull
    private final CircularArray<ConnectionWithLock> availableConnections;
    private final int capacity;

    @NotNull
    private final Function0<SQLiteConnection> connectionFactory;

    @NotNull
    private final kotlinx.coroutines.sync.d connectionPermits;

    @NotNull
    private final ConnectionWithLock[] connections;
    private boolean isClosed;

    @NotNull
    private final ReentrantLock lock;
    private int size;

    /* JADX WARN: Multi-variable type inference failed */
    public Pool(int i6, @NotNull Function0<? extends SQLiteConnection> connectionFactory) {
        g0.p(connectionFactory, "connectionFactory");
        this.capacity = i6;
        this.connectionFactory = connectionFactory;
        this.lock = new ReentrantLock();
        this.connections = new ConnectionWithLock[i6];
        this.connectionPermits = f.b(i6, 0, 2, null);
        this.availableConnections = new CircularArray<>(i6);
    }

    private final void tryOpenNewConnectionLocked() {
        if (this.size >= this.capacity) {
            return;
        }
        ConnectionWithLock connectionWithLock = new ConnectionWithLock(this.connectionFactory.invoke(), null, 2, 0 == true ? 1 : 0);
        ConnectionWithLock[] connectionWithLockArr = this.connections;
        int i6 = this.size;
        this.size = i6 + 1;
        connectionWithLockArr[i6] = connectionWithLock;
        this.availableConnections.addLast(connectionWithLock);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004f A[Catch: all -> 0x005b, TryCatch #1 {all -> 0x005b, blocks: (B:13:0x004b, B:15:0x004f, B:17:0x0057, B:18:0x005d, B:22:0x006b, B:23:0x0077), top: B:12:0x004b, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006b A[Catch: all -> 0x005b, TRY_ENTER, TryCatch #1 {all -> 0x005b, blocks: (B:13:0x004b, B:15:0x004f, B:17:0x0057, B:18:0x005d, B:22:0x006b, B:23:0x0077), top: B:12:0x004b, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object acquire(@org.jetbrains.annotations.NotNull kotlin.coroutines.e<? super androidx.room.coroutines.ConnectionWithLock> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof androidx.room.coroutines.Pool$acquire$1
            if (r0 == 0) goto L13
            r0 = r5
            androidx.room.coroutines.Pool$acquire$1 r0 = (androidx.room.coroutines.Pool$acquire$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.room.coroutines.Pool$acquire$1 r0 = new androidx.room.coroutines.Pool$acquire$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r0 = r0.L$0
            androidx.room.coroutines.Pool r0 = (androidx.room.coroutines.Pool) r0
            kotlin.g0.n(r5)
            goto L46
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L35:
            kotlin.g0.n(r5)
            kotlinx.coroutines.sync.d r5 = r4.connectionPermits
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = r5.c(r0)
            if (r5 != r1) goto L45
            return r1
        L45:
            r0 = r4
        L46:
            java.util.concurrent.locks.ReentrantLock r5 = r0.lock     // Catch: java.lang.Throwable -> L69
            r5.lock()     // Catch: java.lang.Throwable -> L69
            boolean r1 = r0.isClosed     // Catch: java.lang.Throwable -> L5b
            if (r1 != 0) goto L6b
            androidx.collection.CircularArray<androidx.room.coroutines.ConnectionWithLock> r1 = r0.availableConnections     // Catch: java.lang.Throwable -> L5b
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L5b
            if (r1 == 0) goto L5d
            r0.tryOpenNewConnectionLocked()     // Catch: java.lang.Throwable -> L5b
            goto L5d
        L5b:
            r1 = move-exception
            goto L78
        L5d:
            androidx.collection.CircularArray<androidx.room.coroutines.ConnectionWithLock> r1 = r0.availableConnections     // Catch: java.lang.Throwable -> L5b
            java.lang.Object r1 = r1.popFirst()     // Catch: java.lang.Throwable -> L5b
            androidx.room.coroutines.ConnectionWithLock r1 = (androidx.room.coroutines.ConnectionWithLock) r1     // Catch: java.lang.Throwable -> L5b
            r5.unlock()     // Catch: java.lang.Throwable -> L69
            return r1
        L69:
            r5 = move-exception
            goto L7c
        L6b:
            java.lang.String r1 = "Connection pool is closed"
            r2 = 21
            androidx.sqlite.SQLite.throwSQLiteException(r2, r1)     // Catch: java.lang.Throwable -> L5b
            kotlin.KotlinNothingValueException r1 = new kotlin.KotlinNothingValueException     // Catch: java.lang.Throwable -> L5b
            r1.<init>()     // Catch: java.lang.Throwable -> L5b
            throw r1     // Catch: java.lang.Throwable -> L5b
        L78:
            r5.unlock()     // Catch: java.lang.Throwable -> L69
            throw r1     // Catch: java.lang.Throwable -> L69
        L7c:
            kotlinx.coroutines.sync.d r0 = r0.connectionPermits
            r0.release()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.coroutines.Pool.acquire(kotlin.coroutines.e):java.lang.Object");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:9|10|11|12|13|14|(1:(1:33)(2:30|(1:32)))(1:16)|17|18|19|20|(1:22)(10:24|12|13|14|(0)(0)|17|18|19|20|(0)(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0068, code lost:
    
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x006d, code lost:
    
        r12 = r12;
        r11 = r11;
        r2 = r0;
        r0 = r2;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0076 A[Catch: all -> 0x007a, TryCatch #2 {all -> 0x007a, blocks: (B:14:0x0072, B:16:0x0076, B:30:0x007e, B:33:0x0085), top: B:13:0x0072 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0060 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0061 -> B:12:0x0063). Please report as a decompilation issue!!! */
    @org.jetbrains.annotations.Nullable
    /* renamed from: acquireWithTimeout-KLykuaI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m35acquireWithTimeoutKLykuaI(long r9, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<kotlin.n1> r11, @org.jetbrains.annotations.NotNull kotlin.coroutines.e<? super androidx.room.coroutines.ConnectionWithLock> r12) {
        /*
            r8 = this;
            boolean r0 = r12 instanceof androidx.room.coroutines.Pool$acquireWithTimeout$1
            if (r0 == 0) goto L13
            r0 = r12
            androidx.room.coroutines.Pool$acquireWithTimeout$1 r0 = (androidx.room.coroutines.Pool$acquireWithTimeout$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.room.coroutines.Pool$acquireWithTimeout$1 r0 = new androidx.room.coroutines.Pool$acquireWithTimeout$1
            r0.<init>(r8, r12)
        L18:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L42
            if (r2 != r3) goto L3a
            long r9 = r0.J$0
            java.lang.Object r11 = r0.L$2
            kotlin.jvm.internal.Ref$ObjectRef r11 = (kotlin.jvm.internal.Ref.ObjectRef) r11
            java.lang.Object r2 = r0.L$1
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2
            java.lang.Object r5 = r0.L$0
            androidx.room.coroutines.Pool r5 = (androidx.room.coroutines.Pool) r5
            kotlin.g0.n(r12)     // Catch: java.lang.Throwable -> L38
            goto L63
        L38:
            r12 = move-exception
            goto L6d
        L3a:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L42:
            kotlin.g0.n(r12)
            r5 = r8
        L46:
            kotlin.jvm.internal.Ref$ObjectRef r12 = new kotlin.jvm.internal.Ref$ObjectRef
            r12.<init>()
            androidx.room.coroutines.Pool$acquireWithTimeout$2 r2 = new androidx.room.coroutines.Pool$acquireWithTimeout$2     // Catch: java.lang.Throwable -> L68
            r2.<init>(r12, r5, r4)     // Catch: java.lang.Throwable -> L68
            r0.L$0 = r5     // Catch: java.lang.Throwable -> L68
            r0.L$1 = r11     // Catch: java.lang.Throwable -> L68
            r0.L$2 = r12     // Catch: java.lang.Throwable -> L68
            r0.J$0 = r9     // Catch: java.lang.Throwable -> L68
            r0.label = r3     // Catch: java.lang.Throwable -> L68
            java.lang.Object r2 = kotlinx.coroutines.n3.d(r9, r2, r0)     // Catch: java.lang.Throwable -> L68
            if (r2 != r1) goto L61
            return r1
        L61:
            r2 = r11
            r11 = r12
        L63:
            r12 = r11
            r11 = r2
            r2 = r0
            r0 = r4
            goto L72
        L68:
            r2 = move-exception
            r7 = r2
            r2 = r11
            r11 = r12
            r12 = r7
        L6d:
            r7 = r12
            r12 = r11
            r11 = r2
            r2 = r0
            r0 = r7
        L72:
            boolean r6 = r0 instanceof kotlinx.coroutines.TimeoutCancellationException     // Catch: java.lang.Throwable -> L7a
            if (r6 == 0) goto L7c
            r11.invoke()     // Catch: java.lang.Throwable -> L7a
            goto L83
        L7a:
            r9 = move-exception
            goto L86
        L7c:
            if (r0 != 0) goto L85
            T r12 = r12.element     // Catch: java.lang.Throwable -> L7a
            if (r12 == 0) goto L83
            return r12
        L83:
            r0 = r2
            goto L46
        L85:
            throw r0     // Catch: java.lang.Throwable -> L7a
        L86:
            T r10 = r12.element
            androidx.room.coroutines.ConnectionWithLock r10 = (androidx.room.coroutines.ConnectionWithLock) r10
            if (r10 == 0) goto L8f
            r5.recycle(r10)
        L8f:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.coroutines.Pool.m35acquireWithTimeoutKLykuaI(long, kotlin.jvm.functions.Function0, kotlin.coroutines.e):java.lang.Object");
    }

    public final void close() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            this.isClosed = true;
            for (ConnectionWithLock connectionWithLock : this.connections) {
                if (connectionWithLock != null) {
                    connectionWithLock.close();
                }
            }
            n1 n1Var = n1.f44123a;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final void dump(@NotNull StringBuilder builder) {
        g0.p(builder, "builder");
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            List j6 = f0.j();
            int size = this.availableConnections.size();
            for (int i6 = 0; i6 < size; i6++) {
                j6.add(this.availableConnections.get(i6));
            }
            List b6 = f0.b(j6);
            builder.append('\t' + super.toString() + " (");
            builder.append("capacity=" + this.capacity + ", ");
            builder.append("permits=" + this.connectionPermits.b() + ", ");
            builder.append("queue=(size=" + b6.size() + ")[" + f0.r3(b6, null, null, null, 0, null, null, 63, null) + "], ");
            builder.append(")");
            builder.append('\n');
            ConnectionWithLock[] connectionWithLockArr = this.connections;
            int length = connectionWithLockArr.length;
            int i7 = 0;
            for (int i8 = 0; i8 < length; i8++) {
                ConnectionWithLock connectionWithLock = connectionWithLockArr[i8];
                i7++;
                StringBuilder sb = new StringBuilder();
                sb.append("\t\t[");
                sb.append(i7);
                sb.append("] - ");
                sb.append(connectionWithLock != null ? connectionWithLock.toString() : null);
                builder.append(sb.toString());
                builder.append('\n');
                if (connectionWithLock != null) {
                    connectionWithLock.dump(builder);
                }
            }
            n1 n1Var = n1.f44123a;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final int getCapacity() {
        return this.capacity;
    }

    @NotNull
    public final Function0<SQLiteConnection> getConnectionFactory() {
        return this.connectionFactory;
    }

    public final void recycle(@NotNull ConnectionWithLock connection) {
        g0.p(connection, "connection");
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            this.availableConnections.addLast(connection);
            n1 n1Var = n1.f44123a;
            reentrantLock.unlock();
            this.connectionPermits.release();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }
}
