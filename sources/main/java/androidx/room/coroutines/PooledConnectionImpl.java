package androidx.room.coroutines;

import android.database.SQLException;
import androidx.room.TransactionScope;
import androidx.room.Transactor;
import androidx.room.concurrent.ThreadLocal_jvmAndroidKt;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.KotlinNothingValueException;
import kotlin.collections.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nConnectionPoolImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConnectionPoolImpl.kt\nandroidx/room/coroutines/PooledConnectionImpl\n+ 2 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,556:1\n481#1,11:557\n481#1,11:578\n481#1,11:589\n120#2,8:568\n129#2:577\n120#2,10:600\n120#2,10:610\n1#3:576\n*S KotlinDebug\n*F\n+ 1 ConnectionPoolImpl.kt\nandroidx/room/coroutines/PooledConnectionImpl\n*L\n360#1:557,11\n369#1:578,11\n371#1:589,11\n361#1:568,8\n361#1:577\n420#1:600,10\n437#1:610,10\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
final class PooledConnectionImpl implements Transactor, RawConnectionAccessor {

    @NotNull
    private final AtomicBoolean _isRecycled;

    @NotNull
    private final ConnectionWithLock delegate;
    private final boolean isReadOnly;

    @NotNull
    private final m<TransactionItem> transactionStack;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nConnectionPoolImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConnectionPoolImpl.kt\nandroidx/room/coroutines/PooledConnectionImpl$StatementWrapper\n*L\n1#1,556:1\n543#1,10:557\n543#1,10:567\n543#1,10:577\n543#1,10:587\n543#1,10:597\n543#1,10:607\n543#1,10:617\n543#1,10:627\n543#1,10:637\n543#1,10:647\n543#1,10:657\n543#1,10:667\n543#1,10:677\n543#1,10:687\n543#1,10:697\n543#1,10:707\n543#1,10:717\n*S KotlinDebug\n*F\n+ 1 ConnectionPoolImpl.kt\nandroidx/room/coroutines/PooledConnectionImpl$StatementWrapper\n*L\n500#1:557,10\n504#1:567,10\n508#1:577,10\n512#1:587,10\n516#1:597,10\n518#1:607,10\n520#1:617,10\n522#1:627,10\n524#1:637,10\n526#1:647,10\n528#1:657,10\n530#1:667,10\n532#1:677,10\n534#1:687,10\n536#1:697,10\n538#1:707,10\n540#1:717,10\n*E\n"})
    private final class StatementWrapper implements SQLiteStatement {

        @NotNull
        private final SQLiteStatement delegate;
        final /* synthetic */ PooledConnectionImpl this$0;
        private final long threadId;

        public StatementWrapper(@NotNull PooledConnectionImpl pooledConnectionImpl, SQLiteStatement delegate) {
            g0.p(delegate, "delegate");
            this.this$0 = pooledConnectionImpl;
            this.delegate = delegate;
            this.threadId = ThreadLocal_jvmAndroidKt.currentThreadId();
        }

        private final <R> R withStateCheck(Function0<? extends R> function0) {
            if (this.this$0.isRecycled()) {
                SQLite.throwSQLiteException(21, "Statement is recycled");
                throw new KotlinNothingValueException();
            }
            if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                return function0.invoke();
            }
            SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: bindDouble */
        public void mo37bindDouble(int i6, double d6) {
            if (this.this$0.isRecycled()) {
                SQLite.throwSQLiteException(21, "Statement is recycled");
                throw new KotlinNothingValueException();
            }
            if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                this.delegate.mo37bindDouble(i6, d6);
            } else {
                SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
                throw new KotlinNothingValueException();
            }
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: bindLong */
        public void mo38bindLong(int i6, long j6) {
            if (this.this$0.isRecycled()) {
                SQLite.throwSQLiteException(21, "Statement is recycled");
                throw new KotlinNothingValueException();
            }
            if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                this.delegate.mo38bindLong(i6, j6);
            } else {
                SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
                throw new KotlinNothingValueException();
            }
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: bindNull */
        public void mo39bindNull(int i6) {
            if (this.this$0.isRecycled()) {
                SQLite.throwSQLiteException(21, "Statement is recycled");
                throw new KotlinNothingValueException();
            }
            if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                this.delegate.mo39bindNull(i6);
            } else {
                SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
                throw new KotlinNothingValueException();
            }
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: clearBindings */
        public void mo41clearBindings() {
            if (this.this$0.isRecycled()) {
                SQLite.throwSQLiteException(21, "Statement is recycled");
                throw new KotlinNothingValueException();
            }
            if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                this.delegate.mo41clearBindings();
            } else {
                SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
                throw new KotlinNothingValueException();
            }
        }

        @Override // androidx.sqlite.SQLiteStatement, java.lang.AutoCloseable
        public void close() {
            if (this.this$0.isRecycled()) {
                SQLite.throwSQLiteException(21, "Statement is recycled");
                throw new KotlinNothingValueException();
            }
            if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                this.delegate.close();
            } else {
                SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
                throw new KotlinNothingValueException();
            }
        }

        @Override // androidx.sqlite.SQLiteStatement
        @NotNull
        public byte[] getBlob(int i6) {
            if (this.this$0.isRecycled()) {
                SQLite.throwSQLiteException(21, "Statement is recycled");
                throw new KotlinNothingValueException();
            }
            if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                return this.delegate.getBlob(i6);
            }
            SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public int getColumnCount() {
            if (this.this$0.isRecycled()) {
                SQLite.throwSQLiteException(21, "Statement is recycled");
                throw new KotlinNothingValueException();
            }
            if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                return this.delegate.getColumnCount();
            }
            SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        @NotNull
        public String getColumnName(int i6) {
            if (this.this$0.isRecycled()) {
                SQLite.throwSQLiteException(21, "Statement is recycled");
                throw new KotlinNothingValueException();
            }
            if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                return this.delegate.getColumnName(i6);
            }
            SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public int getColumnType(int i6) {
            if (this.this$0.isRecycled()) {
                SQLite.throwSQLiteException(21, "Statement is recycled");
                throw new KotlinNothingValueException();
            }
            if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                return this.delegate.getColumnType(i6);
            }
            SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public double getDouble(int i6) {
            if (this.this$0.isRecycled()) {
                SQLite.throwSQLiteException(21, "Statement is recycled");
                throw new KotlinNothingValueException();
            }
            if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                return this.delegate.getDouble(i6);
            }
            SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public long getLong(int i6) {
            if (this.this$0.isRecycled()) {
                SQLite.throwSQLiteException(21, "Statement is recycled");
                throw new KotlinNothingValueException();
            }
            if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                return this.delegate.getLong(i6);
            }
            SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        @NotNull
        public String getText(int i6) {
            if (this.this$0.isRecycled()) {
                SQLite.throwSQLiteException(21, "Statement is recycled");
                throw new KotlinNothingValueException();
            }
            if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                return this.delegate.getText(i6);
            }
            SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public boolean isNull(int i6) {
            if (this.this$0.isRecycled()) {
                SQLite.throwSQLiteException(21, "Statement is recycled");
                throw new KotlinNothingValueException();
            }
            if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                return this.delegate.isNull(i6);
            }
            SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public void reset() {
            if (this.this$0.isRecycled()) {
                SQLite.throwSQLiteException(21, "Statement is recycled");
                throw new KotlinNothingValueException();
            }
            if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                this.delegate.reset();
            } else {
                SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
                throw new KotlinNothingValueException();
            }
        }

        @Override // androidx.sqlite.SQLiteStatement
        public boolean step() {
            if (this.this$0.isRecycled()) {
                SQLite.throwSQLiteException(21, "Statement is recycled");
                throw new KotlinNothingValueException();
            }
            if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                return this.delegate.step();
            }
            SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: bindBlob */
        public void mo36bindBlob(int i6, @NotNull byte[] value) {
            g0.p(value, "value");
            if (!this.this$0.isRecycled()) {
                if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                    this.delegate.mo36bindBlob(i6, value);
                    return;
                } else {
                    SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
                    throw new KotlinNothingValueException();
                }
            }
            SQLite.throwSQLiteException(21, "Statement is recycled");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public /* synthetic */ void bindBoolean(int i6, boolean z5) {
            f.a.a(this, i6, z5);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public /* synthetic */ void bindFloat(int i6, float f6) {
            f.a.b(this, i6, f6);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public /* synthetic */ void bindInt(int i6, int i7) {
            f.a.c(this, i6, i7);
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: bindText */
        public void mo40bindText(int i6, @NotNull String value) {
            g0.p(value, "value");
            if (!this.this$0.isRecycled()) {
                if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                    this.delegate.mo40bindText(i6, value);
                    return;
                } else {
                    SQLite.throwSQLiteException(21, "Attempted to use statement on a different thread");
                    throw new KotlinNothingValueException();
                }
            }
            SQLite.throwSQLiteException(21, "Statement is recycled");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public /* synthetic */ boolean getBoolean(int i6) {
            return f.a.d(this, i6);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public /* synthetic */ List getColumnNames() {
            return f.a.e(this);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public /* synthetic */ float getFloat(int i6) {
            return f.a.f(this, i6);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public /* synthetic */ int getInt(int i6) {
            return f.a.g(this, i6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nConnectionPoolImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConnectionPoolImpl.kt\nandroidx/room/coroutines/PooledConnectionImpl$TransactionImpl\n+ 2 ConnectionPoolImpl.kt\nandroidx/room/coroutines/PooledConnectionImpl\n+ 3 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n*L\n1#1,556:1\n481#2,11:557\n481#2,11:568\n120#3,10:579\n*S KotlinDebug\n*F\n+ 1 ConnectionPoolImpl.kt\nandroidx/room/coroutines/PooledConnectionImpl$TransactionImpl\n*L\n469#1:557,11\n471#1:568,11\n475#1:579,10\n*E\n"})
    final class TransactionImpl<T> implements TransactionScope<T>, RawConnectionAccessor {
        public TransactionImpl() {
        }

        @Override // androidx.room.coroutines.RawConnectionAccessor
        @NotNull
        public SQLiteConnection getRawConnection() {
            return PooledConnectionImpl.this.getRawConnection();
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x003c  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
        @Override // androidx.room.TransactionScope
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.Object rollback(T r8, @org.jetbrains.annotations.NotNull kotlin.coroutines.e<?> r9) {
            /*
                r7 = this;
                boolean r0 = r9 instanceof androidx.room.coroutines.PooledConnectionImpl$TransactionImpl$rollback$1
                if (r0 == 0) goto L13
                r0 = r9
                androidx.room.coroutines.PooledConnectionImpl$TransactionImpl$rollback$1 r0 = (androidx.room.coroutines.PooledConnectionImpl$TransactionImpl$rollback$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                androidx.room.coroutines.PooledConnectionImpl$TransactionImpl$rollback$1 r0 = new androidx.room.coroutines.PooledConnectionImpl$TransactionImpl$rollback$1
                r0.<init>(r7, r9)
            L18:
                java.lang.Object r9 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
                int r2 = r0.label
                r3 = 1
                r4 = 0
                if (r2 == 0) goto L3c
                if (r2 == r3) goto L2e
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r9)
                throw r8
            L2e:
                java.lang.Object r8 = r0.L$2
                kotlinx.coroutines.sync.a r8 = (kotlinx.coroutines.sync.a) r8
                java.lang.Object r1 = r0.L$1
                androidx.room.coroutines.PooledConnectionImpl r1 = (androidx.room.coroutines.PooledConnectionImpl) r1
                java.lang.Object r0 = r0.L$0
                kotlin.g0.n(r9)
                goto L7d
            L3c:
                kotlin.g0.n(r9)
                androidx.room.coroutines.PooledConnectionImpl r9 = androidx.room.coroutines.PooledConnectionImpl.this
                boolean r2 = androidx.room.coroutines.PooledConnectionImpl.access$isRecycled(r9)
                r5 = 21
                if (r2 != 0) goto Lad
                kotlin.coroutines.i r2 = r0.getContext()
                androidx.room.coroutines.ConnectionElement$Key r6 = androidx.room.coroutines.ConnectionElement.Key
                kotlin.coroutines.i$b r2 = r2.get(r6)
                androidx.room.coroutines.ConnectionElement r2 = (androidx.room.coroutines.ConnectionElement) r2
                if (r2 == 0) goto La2
                androidx.room.coroutines.PooledConnectionImpl r2 = r2.getConnectionWrapper()
                if (r2 != r9) goto La2
                kotlin.collections.m r2 = androidx.room.coroutines.PooledConnectionImpl.access$getTransactionStack$p(r9)
                boolean r2 = r2.isEmpty()
                if (r2 != 0) goto L9a
                androidx.room.coroutines.ConnectionWithLock r2 = r9.getDelegate()
                r0.L$0 = r8
                r0.L$1 = r9
                r0.L$2 = r2
                r0.label = r3
                java.lang.Object r0 = r2.lock(r4, r0)
                if (r0 != r1) goto L7a
                return r1
            L7a:
                r0 = r8
                r1 = r9
                r8 = r2
            L7d:
                kotlin.collections.m r9 = androidx.room.coroutines.PooledConnectionImpl.access$getTransactionStack$p(r1)     // Catch: java.lang.Throwable -> L95
                java.lang.Object r9 = r9.last()     // Catch: java.lang.Throwable -> L95
                androidx.room.coroutines.PooledConnectionImpl$TransactionItem r9 = (androidx.room.coroutines.PooledConnectionImpl.TransactionItem) r9     // Catch: java.lang.Throwable -> L95
                r9.setShouldRollback(r3)     // Catch: java.lang.Throwable -> L95
                kotlin.n1 r9 = kotlin.n1.f44123a     // Catch: java.lang.Throwable -> L95
                r8.unlock(r4)
                androidx.room.coroutines.ConnectionPool$RollbackException r8 = new androidx.room.coroutines.ConnectionPool$RollbackException
                r8.<init>(r0)
                throw r8
            L95:
                r9 = move-exception
                r8.unlock(r4)
                throw r9
            L9a:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r9 = "Not in a transaction"
                r8.<init>(r9)
                throw r8
            La2:
                java.lang.String r8 = "Attempted to use connection on a different coroutine"
                androidx.sqlite.SQLite.throwSQLiteException(r5, r8)
                kotlin.KotlinNothingValueException r8 = new kotlin.KotlinNothingValueException
                r8.<init>()
                throw r8
            Lad:
                java.lang.String r8 = "Connection is recycled"
                androidx.sqlite.SQLite.throwSQLiteException(r5, r8)
                kotlin.KotlinNothingValueException r8 = new kotlin.KotlinNothingValueException
                r8.<init>()
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.coroutines.PooledConnectionImpl.TransactionImpl.rollback(java.lang.Object, kotlin.coroutines.e):java.lang.Object");
        }

        @Override // androidx.room.PooledConnection
        @Nullable
        public <R> Object usePrepared(@NotNull String str, @NotNull Function1<? super SQLiteStatement, ? extends R> function1, @NotNull kotlin.coroutines.e<? super R> eVar) {
            return PooledConnectionImpl.this.usePrepared(str, function1, eVar);
        }

        @Override // androidx.room.TransactionScope
        @Nullable
        public <R> Object withNestedTransaction(@NotNull Function2<? super TransactionScope<R>, ? super kotlin.coroutines.e<? super R>, ? extends Object> function2, @NotNull kotlin.coroutines.e<? super R> eVar) {
            PooledConnectionImpl pooledConnectionImpl = PooledConnectionImpl.this;
            if (pooledConnectionImpl.isRecycled()) {
                SQLite.throwSQLiteException(21, "Connection is recycled");
                throw new KotlinNothingValueException();
            }
            ConnectionElement connectionElement = (ConnectionElement) eVar.getContext().get(ConnectionElement.Key);
            if (connectionElement != null && connectionElement.getConnectionWrapper() == pooledConnectionImpl) {
                return pooledConnectionImpl.transaction(null, function2, eVar);
            }
            SQLite.throwSQLiteException(21, "Attempted to use connection on a different coroutine");
            throw new KotlinNothingValueException();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class TransactionItem {
        private final int id;
        private boolean shouldRollback;

        public final int getId() {
            return this.id;
        }

        public final boolean getShouldRollback() {
            return this.shouldRollback;
        }

        public final void setShouldRollback(boolean z5) {
            this.shouldRollback = z5;
        }

        public TransactionItem(int i6, boolean z5) {
            this.id = i6;
            this.shouldRollback = z5;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Transactor.SQLiteTransactionType.values().length];
            try {
                iArr[Transactor.SQLiteTransactionType.DEFERRED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Transactor.SQLiteTransactionType.IMMEDIATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Transactor.SQLiteTransactionType.EXCLUSIVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public PooledConnectionImpl(@NotNull ConnectionWithLock delegate, boolean z5) {
        g0.p(delegate, "delegate");
        this.delegate = delegate;
        this.isReadOnly = z5;
        this.transactionStack = new m<>();
        this._isRecycled = new AtomicBoolean(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0063 A[Catch: all -> 0x007b, TryCatch #0 {all -> 0x007b, blocks: (B:11:0x0055, B:13:0x0063, B:19:0x0073, B:20:0x00ae, B:24:0x007d, B:25:0x0082, B:26:0x0083, B:27:0x008b, B:28:0x0093), top: B:10:0x0055 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0093 A[Catch: all -> 0x007b, TryCatch #0 {all -> 0x007b, blocks: (B:11:0x0055, B:13:0x0063, B:19:0x0073, B:20:0x00ae, B:24:0x007d, B:25:0x0082, B:26:0x0083, B:27:0x008b, B:28:0x0093), top: B:10:0x0055 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Type inference failed for: r6v14, types: [kotlinx.coroutines.sync.a] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object beginTransaction(androidx.room.Transactor.SQLiteTransactionType r6, kotlin.coroutines.e<? super kotlin.n1> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof androidx.room.coroutines.PooledConnectionImpl$beginTransaction$1
            if (r0 == 0) goto L13
            r0 = r7
            androidx.room.coroutines.PooledConnectionImpl$beginTransaction$1 r0 = (androidx.room.coroutines.PooledConnectionImpl$beginTransaction$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.room.coroutines.PooledConnectionImpl$beginTransaction$1 r0 = new androidx.room.coroutines.PooledConnectionImpl$beginTransaction$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L40
            if (r2 != r3) goto L38
            java.lang.Object r6 = r0.L$2
            kotlinx.coroutines.sync.a r6 = (kotlinx.coroutines.sync.a) r6
            java.lang.Object r1 = r0.L$1
            androidx.room.Transactor$SQLiteTransactionType r1 = (androidx.room.Transactor.SQLiteTransactionType) r1
            java.lang.Object r0 = r0.L$0
            androidx.room.coroutines.PooledConnectionImpl r0 = (androidx.room.coroutines.PooledConnectionImpl) r0
            kotlin.g0.n(r7)
            r7 = r6
            r6 = r1
            goto L55
        L38:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L40:
            kotlin.g0.n(r7)
            androidx.room.coroutines.ConnectionWithLock r7 = r5.delegate
            r0.L$0 = r5
            r0.L$1 = r6
            r0.L$2 = r7
            r0.label = r3
            java.lang.Object r0 = r7.lock(r4, r0)
            if (r0 != r1) goto L54
            return r1
        L54:
            r0 = r5
        L55:
            kotlin.collections.m<androidx.room.coroutines.PooledConnectionImpl$TransactionItem> r1 = r0.transactionStack     // Catch: java.lang.Throwable -> L7b
            int r1 = r1.size()     // Catch: java.lang.Throwable -> L7b
            kotlin.collections.m<androidx.room.coroutines.PooledConnectionImpl$TransactionItem> r2 = r0.transactionStack     // Catch: java.lang.Throwable -> L7b
            boolean r2 = r2.isEmpty()     // Catch: java.lang.Throwable -> L7b
            if (r2 == 0) goto L93
            int[] r2 = androidx.room.coroutines.PooledConnectionImpl.WhenMappings.$EnumSwitchMapping$0     // Catch: java.lang.Throwable -> L7b
            int r6 = r6.ordinal()     // Catch: java.lang.Throwable -> L7b
            r6 = r2[r6]     // Catch: java.lang.Throwable -> L7b
            if (r6 == r3) goto L8b
            r2 = 2
            if (r6 == r2) goto L83
            r2 = 3
            if (r6 != r2) goto L7d
            androidx.room.coroutines.ConnectionWithLock r6 = r0.delegate     // Catch: java.lang.Throwable -> L7b
            java.lang.String r2 = "BEGIN EXCLUSIVE TRANSACTION"
            androidx.sqlite.SQLite.execSQL(r6, r2)     // Catch: java.lang.Throwable -> L7b
            goto Lae
        L7b:
            r6 = move-exception
            goto Lbf
        L7d:
            kotlin.NoWhenBranchMatchedException r6 = new kotlin.NoWhenBranchMatchedException     // Catch: java.lang.Throwable -> L7b
            r6.<init>()     // Catch: java.lang.Throwable -> L7b
            throw r6     // Catch: java.lang.Throwable -> L7b
        L83:
            androidx.room.coroutines.ConnectionWithLock r6 = r0.delegate     // Catch: java.lang.Throwable -> L7b
            java.lang.String r2 = "BEGIN IMMEDIATE TRANSACTION"
            androidx.sqlite.SQLite.execSQL(r6, r2)     // Catch: java.lang.Throwable -> L7b
            goto Lae
        L8b:
            androidx.room.coroutines.ConnectionWithLock r6 = r0.delegate     // Catch: java.lang.Throwable -> L7b
            java.lang.String r2 = "BEGIN DEFERRED TRANSACTION"
            androidx.sqlite.SQLite.execSQL(r6, r2)     // Catch: java.lang.Throwable -> L7b
            goto Lae
        L93:
            androidx.room.coroutines.ConnectionWithLock r6 = r0.delegate     // Catch: java.lang.Throwable -> L7b
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L7b
            r2.<init>()     // Catch: java.lang.Throwable -> L7b
            java.lang.String r3 = "SAVEPOINT '"
            r2.append(r3)     // Catch: java.lang.Throwable -> L7b
            r2.append(r1)     // Catch: java.lang.Throwable -> L7b
            r3 = 39
            r2.append(r3)     // Catch: java.lang.Throwable -> L7b
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L7b
            androidx.sqlite.SQLite.execSQL(r6, r2)     // Catch: java.lang.Throwable -> L7b
        Lae:
            kotlin.collections.m<androidx.room.coroutines.PooledConnectionImpl$TransactionItem> r6 = r0.transactionStack     // Catch: java.lang.Throwable -> L7b
            androidx.room.coroutines.PooledConnectionImpl$TransactionItem r0 = new androidx.room.coroutines.PooledConnectionImpl$TransactionItem     // Catch: java.lang.Throwable -> L7b
            r2 = 0
            r0.<init>(r1, r2)     // Catch: java.lang.Throwable -> L7b
            r6.addLast(r0)     // Catch: java.lang.Throwable -> L7b
            kotlin.n1 r6 = kotlin.n1.f44123a     // Catch: java.lang.Throwable -> L7b
            r7.unlock(r4)
            return r6
        Lbf:
            r7.unlock(r4)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.coroutines.PooledConnectionImpl.beginTransaction(androidx.room.Transactor$SQLiteTransactionType, kotlin.coroutines.e):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x005a A[Catch: all -> 0x007c, TryCatch #0 {all -> 0x007c, blocks: (B:11:0x0052, B:13:0x005a, B:15:0x0066, B:17:0x006c, B:19:0x0074, B:20:0x00c9, B:24:0x007e, B:25:0x009c, B:27:0x00a4, B:28:0x00ac, B:29:0x00cf, B:30:0x00d6), top: B:10:0x0052 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00cf A[Catch: all -> 0x007c, TRY_ENTER, TryCatch #0 {all -> 0x007c, blocks: (B:11:0x0052, B:13:0x005a, B:15:0x0066, B:17:0x006c, B:19:0x0074, B:20:0x00c9, B:24:0x007e, B:25:0x009c, B:27:0x00a4, B:28:0x00ac, B:29:0x00cf, B:30:0x00d6), top: B:10:0x0052 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object endTransaction(boolean r6, kotlin.coroutines.e<? super kotlin.n1> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof androidx.room.coroutines.PooledConnectionImpl$endTransaction$1
            if (r0 == 0) goto L13
            r0 = r7
            androidx.room.coroutines.PooledConnectionImpl$endTransaction$1 r0 = (androidx.room.coroutines.PooledConnectionImpl$endTransaction$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.room.coroutines.PooledConnectionImpl$endTransaction$1 r0 = new androidx.room.coroutines.PooledConnectionImpl$endTransaction$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            boolean r6 = r0.Z$0
            java.lang.Object r1 = r0.L$1
            kotlinx.coroutines.sync.a r1 = (kotlinx.coroutines.sync.a) r1
            java.lang.Object r0 = r0.L$0
            androidx.room.coroutines.PooledConnectionImpl r0 = (androidx.room.coroutines.PooledConnectionImpl) r0
            kotlin.g0.n(r7)
            goto L52
        L34:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3c:
            kotlin.g0.n(r7)
            androidx.room.coroutines.ConnectionWithLock r7 = r5.delegate
            r0.L$0 = r5
            r0.L$1 = r7
            r0.Z$0 = r6
            r0.label = r3
            java.lang.Object r0 = r7.lock(r4, r0)
            if (r0 != r1) goto L50
            return r1
        L50:
            r0 = r5
            r1 = r7
        L52:
            kotlin.collections.m<androidx.room.coroutines.PooledConnectionImpl$TransactionItem> r7 = r0.transactionStack     // Catch: java.lang.Throwable -> L7c
            boolean r7 = r7.isEmpty()     // Catch: java.lang.Throwable -> L7c
            if (r7 != 0) goto Lcf
            kotlin.collections.m<androidx.room.coroutines.PooledConnectionImpl$TransactionItem> r7 = r0.transactionStack     // Catch: java.lang.Throwable -> L7c
            java.lang.Object r7 = kotlin.collections.f0.Q0(r7)     // Catch: java.lang.Throwable -> L7c
            androidx.room.coroutines.PooledConnectionImpl$TransactionItem r7 = (androidx.room.coroutines.PooledConnectionImpl.TransactionItem) r7     // Catch: java.lang.Throwable -> L7c
            r2 = 39
            if (r6 == 0) goto L9c
            boolean r6 = r7.getShouldRollback()     // Catch: java.lang.Throwable -> L7c
            if (r6 != 0) goto L9c
            kotlin.collections.m<androidx.room.coroutines.PooledConnectionImpl$TransactionItem> r6 = r0.transactionStack     // Catch: java.lang.Throwable -> L7c
            boolean r6 = r6.isEmpty()     // Catch: java.lang.Throwable -> L7c
            if (r6 == 0) goto L7e
            androidx.room.coroutines.ConnectionWithLock r6 = r0.delegate     // Catch: java.lang.Throwable -> L7c
            java.lang.String r7 = "END TRANSACTION"
            androidx.sqlite.SQLite.execSQL(r6, r7)     // Catch: java.lang.Throwable -> L7c
            goto Lc9
        L7c:
            r6 = move-exception
            goto Ld7
        L7e:
            androidx.room.coroutines.ConnectionWithLock r6 = r0.delegate     // Catch: java.lang.Throwable -> L7c
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L7c
            r0.<init>()     // Catch: java.lang.Throwable -> L7c
            java.lang.String r3 = "RELEASE SAVEPOINT '"
            r0.append(r3)     // Catch: java.lang.Throwable -> L7c
            int r7 = r7.getId()     // Catch: java.lang.Throwable -> L7c
            r0.append(r7)     // Catch: java.lang.Throwable -> L7c
            r0.append(r2)     // Catch: java.lang.Throwable -> L7c
            java.lang.String r7 = r0.toString()     // Catch: java.lang.Throwable -> L7c
            androidx.sqlite.SQLite.execSQL(r6, r7)     // Catch: java.lang.Throwable -> L7c
            goto Lc9
        L9c:
            kotlin.collections.m<androidx.room.coroutines.PooledConnectionImpl$TransactionItem> r6 = r0.transactionStack     // Catch: java.lang.Throwable -> L7c
            boolean r6 = r6.isEmpty()     // Catch: java.lang.Throwable -> L7c
            if (r6 == 0) goto Lac
            androidx.room.coroutines.ConnectionWithLock r6 = r0.delegate     // Catch: java.lang.Throwable -> L7c
            java.lang.String r7 = "ROLLBACK TRANSACTION"
            androidx.sqlite.SQLite.execSQL(r6, r7)     // Catch: java.lang.Throwable -> L7c
            goto Lc9
        Lac:
            androidx.room.coroutines.ConnectionWithLock r6 = r0.delegate     // Catch: java.lang.Throwable -> L7c
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L7c
            r0.<init>()     // Catch: java.lang.Throwable -> L7c
            java.lang.String r3 = "ROLLBACK TRANSACTION TO SAVEPOINT '"
            r0.append(r3)     // Catch: java.lang.Throwable -> L7c
            int r7 = r7.getId()     // Catch: java.lang.Throwable -> L7c
            r0.append(r7)     // Catch: java.lang.Throwable -> L7c
            r0.append(r2)     // Catch: java.lang.Throwable -> L7c
            java.lang.String r7 = r0.toString()     // Catch: java.lang.Throwable -> L7c
            androidx.sqlite.SQLite.execSQL(r6, r7)     // Catch: java.lang.Throwable -> L7c
        Lc9:
            kotlin.n1 r6 = kotlin.n1.f44123a     // Catch: java.lang.Throwable -> L7c
            r1.unlock(r4)
            return r6
        Lcf:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L7c
            java.lang.String r7 = "Not in a transaction"
            r6.<init>(r7)     // Catch: java.lang.Throwable -> L7c
            throw r6     // Catch: java.lang.Throwable -> L7c
        Ld7:
            r1.unlock(r4)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.coroutines.PooledConnectionImpl.endTransaction(boolean, kotlin.coroutines.e):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isRecycled() {
        return this._isRecycled.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(11:0|1|(2:3|(7:5|6|(1:(1:(1:(2:25|26)(1:(2:13|14)(4:16|17|18|19)))(6:27|28|29|(1:31)|32|(1:35)(1:34)))(1:58))(5:66|(1:68)|69|(1:71)|35)|59|60|(4:62|(0)|32|(0))|35))|72|6|(0)(0)|59|60|(0)|35|(2:(0)|(1:54))) */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00d7, code lost:
    
        kotlin.l.a(r13, r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00db, code lost:
    
        throw r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00ac, code lost:
    
        r12 = r12.getResult();
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00b2, code lost:
    
        r0.L$0 = r12;
        r0.L$1 = null;
        r0.label = 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00bc, code lost:
    
        if (r13.endTransaction(false, r0) == r1) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00bf, code lost:
    
        return r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00c2, code lost:
    
        throw r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00c3, code lost:
    
        r14 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00c4, code lost:
    
        r9 = r12;
        r12 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00c6, code lost:
    
        r0.L$0 = r9;
        r0.L$1 = r12;
        r0.label = 5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00d0, code lost:
    
        if (r13.endTransaction(false, r0) != r1) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00d3, code lost:
    
        r14 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00d4, code lost:
    
        r13 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00a4, code lost:
    
        r13 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00a5, code lost:
    
        r13 = r12;
        r12 = r13;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00d2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00ac A[Catch: all -> 0x00c0, TRY_LEAVE, TryCatch #1 {all -> 0x00c0, blocks: (B:39:0x00a8, B:41:0x00ac), top: B:38:0x00a8 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00c2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final <R> java.lang.Object transaction(androidx.room.Transactor.SQLiteTransactionType r12, kotlin.jvm.functions.Function2<? super androidx.room.TransactionScope<R>, ? super kotlin.coroutines.e<? super R>, ? extends java.lang.Object> r13, kotlin.coroutines.e<? super R> r14) {
        /*
            Method dump skipped, instructions count: 220
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.coroutines.PooledConnectionImpl.transaction(androidx.room.Transactor$SQLiteTransactionType, kotlin.jvm.functions.Function2, kotlin.coroutines.e):java.lang.Object");
    }

    @NotNull
    public final ConnectionWithLock getDelegate() {
        return this.delegate;
    }

    @Override // androidx.room.coroutines.RawConnectionAccessor
    @NotNull
    public SQLiteConnection getRawConnection() {
        return this.delegate;
    }

    public final boolean isReadOnly() {
        return this.isReadOnly;
    }

    public final void markRecycled() {
        if (this._isRecycled.compareAndSet(false, true)) {
            try {
                SQLite.execSQL(this.delegate, "ROLLBACK TRANSACTION");
            } catch (SQLException unused) {
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Type inference failed for: r7v12, types: [kotlinx.coroutines.sync.a] */
    @Override // androidx.room.PooledConnection
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public <R> java.lang.Object usePrepared(@org.jetbrains.annotations.NotNull java.lang.String r7, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super androidx.sqlite.SQLiteStatement, ? extends R> r8, @org.jetbrains.annotations.NotNull kotlin.coroutines.e<? super R> r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof androidx.room.coroutines.PooledConnectionImpl$usePrepared$1
            if (r0 == 0) goto L13
            r0 = r9
            androidx.room.coroutines.PooledConnectionImpl$usePrepared$1 r0 = (androidx.room.coroutines.PooledConnectionImpl$usePrepared$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.room.coroutines.PooledConnectionImpl$usePrepared$1 r0 = new androidx.room.coroutines.PooledConnectionImpl$usePrepared$1
            r0.<init>(r6, r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L44
            if (r2 != r3) goto L3c
            java.lang.Object r7 = r0.L$3
            kotlinx.coroutines.sync.a r7 = (kotlinx.coroutines.sync.a) r7
            java.lang.Object r8 = r0.L$2
            kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8
            java.lang.Object r1 = r0.L$1
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r0 = r0.L$0
            androidx.room.coroutines.PooledConnectionImpl r0 = (androidx.room.coroutines.PooledConnectionImpl) r0
            kotlin.g0.n(r9)
            r9 = r7
            r7 = r1
            goto L77
        L3c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L44:
            kotlin.g0.n(r9)
            boolean r9 = access$isRecycled(r6)
            r2 = 21
            if (r9 != 0) goto La5
            kotlin.coroutines.i r9 = r0.getContext()
            androidx.room.coroutines.ConnectionElement$Key r5 = androidx.room.coroutines.ConnectionElement.Key
            kotlin.coroutines.i$b r9 = r9.get(r5)
            androidx.room.coroutines.ConnectionElement r9 = (androidx.room.coroutines.ConnectionElement) r9
            if (r9 == 0) goto L9a
            androidx.room.coroutines.PooledConnectionImpl r9 = r9.getConnectionWrapper()
            if (r9 != r6) goto L9a
            androidx.room.coroutines.ConnectionWithLock r9 = r6.delegate
            r0.L$0 = r6
            r0.L$1 = r7
            r0.L$2 = r8
            r0.L$3 = r9
            r0.label = r3
            java.lang.Object r0 = r9.lock(r4, r0)
            if (r0 != r1) goto L76
            return r1
        L76:
            r0 = r6
        L77:
            androidx.room.coroutines.PooledConnectionImpl$StatementWrapper r1 = new androidx.room.coroutines.PooledConnectionImpl$StatementWrapper     // Catch: java.lang.Throwable -> L8d
            androidx.room.coroutines.ConnectionWithLock r2 = r0.delegate     // Catch: java.lang.Throwable -> L8d
            androidx.sqlite.SQLiteStatement r7 = r2.prepare(r7)     // Catch: java.lang.Throwable -> L8d
            r1.<init>(r0, r7)     // Catch: java.lang.Throwable -> L8d
            java.lang.Object r7 = r8.invoke(r1)     // Catch: java.lang.Throwable -> L8f
            kotlin.jdk7.a.c(r1, r4)     // Catch: java.lang.Throwable -> L8d
            r9.unlock(r4)
            return r7
        L8d:
            r7 = move-exception
            goto L96
        L8f:
            r7 = move-exception
            throw r7     // Catch: java.lang.Throwable -> L91
        L91:
            r8 = move-exception
            kotlin.jdk7.a.c(r1, r7)     // Catch: java.lang.Throwable -> L8d
            throw r8     // Catch: java.lang.Throwable -> L8d
        L96:
            r9.unlock(r4)
            throw r7
        L9a:
            java.lang.String r7 = "Attempted to use connection on a different coroutine"
            androidx.sqlite.SQLite.throwSQLiteException(r2, r7)
            kotlin.KotlinNothingValueException r7 = new kotlin.KotlinNothingValueException
            r7.<init>()
            throw r7
        La5:
            java.lang.String r7 = "Connection is recycled"
            androidx.sqlite.SQLite.throwSQLiteException(r2, r7)
            kotlin.KotlinNothingValueException r7 = new kotlin.KotlinNothingValueException
            r7.<init>()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.coroutines.PooledConnectionImpl.usePrepared(java.lang.String, kotlin.jvm.functions.Function1, kotlin.coroutines.e):java.lang.Object");
    }

    private final <R> Object withStateCheck(Function0<? extends R> function0, kotlin.coroutines.e<? super R> eVar) {
        if (isRecycled()) {
            SQLite.throwSQLiteException(21, "Connection is recycled");
            throw new KotlinNothingValueException();
        }
        d0.e(3);
        throw null;
    }

    @Override // androidx.room.Transactor
    @Nullable
    public Object inTransaction(@NotNull kotlin.coroutines.e<? super Boolean> eVar) {
        if (!isRecycled()) {
            ConnectionElement connectionElement = (ConnectionElement) eVar.getContext().get(ConnectionElement.Key);
            if (connectionElement != null && connectionElement.getConnectionWrapper() == this) {
                return kotlin.coroutines.jvm.internal.a.a(!this.transactionStack.isEmpty());
            }
            SQLite.throwSQLiteException(21, "Attempted to use connection on a different coroutine");
            throw new KotlinNothingValueException();
        }
        SQLite.throwSQLiteException(21, "Connection is recycled");
        throw new KotlinNothingValueException();
    }

    @Override // androidx.room.Transactor
    @Nullable
    public <R> Object withTransaction(@NotNull Transactor.SQLiteTransactionType sQLiteTransactionType, @NotNull Function2<? super TransactionScope<R>, ? super kotlin.coroutines.e<? super R>, ? extends Object> function2, @NotNull kotlin.coroutines.e<? super R> eVar) {
        if (!isRecycled()) {
            ConnectionElement connectionElement = (ConnectionElement) eVar.getContext().get(ConnectionElement.Key);
            if (connectionElement != null && connectionElement.getConnectionWrapper() == this) {
                return transaction(sQLiteTransactionType, function2, eVar);
            }
            SQLite.throwSQLiteException(21, "Attempted to use connection on a different coroutine");
            throw new KotlinNothingValueException();
        }
        SQLite.throwSQLiteException(21, "Connection is recycled");
        throw new KotlinNothingValueException();
    }
}
