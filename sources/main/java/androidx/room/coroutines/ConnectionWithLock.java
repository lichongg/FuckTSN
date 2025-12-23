package androidx.room.coroutines;

import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import java.util.Iterator;
import kotlin.collections.f0;
import kotlin.coroutines.i;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlin.l;
import kotlin.n1;
import kotlin.text.u;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nConnectionPoolImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConnectionPoolImpl.kt\nandroidx/room/coroutines/ConnectionWithLock\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,556:1\n1#2:557\n1863#3,2:558\n*S KotlinDebug\n*F\n+ 1 ConnectionPoolImpl.kt\nandroidx/room/coroutines/ConnectionWithLock\n*L\n317#1:558,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
final class ConnectionWithLock implements SQLiteConnection, kotlinx.coroutines.sync.a {

    @Nullable
    private i acquireCoroutineContext;

    @Nullable
    private Throwable acquireThrowable;

    @NotNull
    private final SQLiteConnection delegate;

    @NotNull
    private final kotlinx.coroutines.sync.a lock;

    public ConnectionWithLock(@NotNull SQLiteConnection delegate, @NotNull kotlinx.coroutines.sync.a lock) {
        g0.p(delegate, "delegate");
        g0.p(lock, "lock");
        this.delegate = delegate;
        this.lock = lock;
    }

    @NotNull
    public final ConnectionWithLock markReleased() {
        this.acquireCoroutineContext = null;
        this.acquireThrowable = null;
        return this;
    }

    @Override // androidx.sqlite.SQLiteConnection, java.lang.AutoCloseable
    public void close() {
        this.delegate.close();
    }

    public final void dump(@NotNull StringBuilder builder) {
        g0.p(builder, "builder");
        if (this.acquireCoroutineContext == null && this.acquireThrowable == null) {
            builder.append("\t\tStatus: Free connection");
            builder.append('\n');
            return;
        }
        builder.append("\t\tStatus: Acquired connection");
        builder.append('\n');
        i iVar = this.acquireCoroutineContext;
        if (iVar != null) {
            builder.append("\t\tCoroutine: " + iVar);
            builder.append('\n');
        }
        Throwable th = this.acquireThrowable;
        if (th != null) {
            builder.append("\t\tAcquired:");
            builder.append('\n');
            Iterator it = f0.g2(u.c4(l.i(th)), 1).iterator();
            while (it.hasNext()) {
                builder.append("\t\t" + ((String) it.next()));
                builder.append('\n');
            }
        }
    }

    @Override // kotlinx.coroutines.sync.a
    @NotNull
    public kotlinx.coroutines.selects.i<Object, kotlinx.coroutines.sync.a> getOnLock() {
        return this.lock.getOnLock();
    }

    @Override // kotlinx.coroutines.sync.a
    public boolean holdsLock(@NotNull Object owner) {
        g0.p(owner, "owner");
        return this.lock.holdsLock(owner);
    }

    @Override // kotlinx.coroutines.sync.a
    public boolean isLocked() {
        return this.lock.isLocked();
    }

    @Override // kotlinx.coroutines.sync.a
    @Nullable
    public Object lock(@Nullable Object obj, @NotNull kotlin.coroutines.e<? super n1> eVar) {
        return this.lock.lock(obj, eVar);
    }

    @NotNull
    public final ConnectionWithLock markAcquired(@NotNull i context) {
        g0.p(context, "context");
        this.acquireCoroutineContext = context;
        this.acquireThrowable = new Throwable();
        return this;
    }

    @Override // androidx.sqlite.SQLiteConnection
    @NotNull
    public SQLiteStatement prepare(@NotNull String sql) {
        g0.p(sql, "sql");
        return this.delegate.prepare(sql);
    }

    @NotNull
    public String toString() {
        return this.delegate.toString();
    }

    @Override // kotlinx.coroutines.sync.a
    public boolean tryLock(@Nullable Object obj) {
        return this.lock.tryLock(obj);
    }

    @Override // kotlinx.coroutines.sync.a
    public void unlock(@Nullable Object obj) {
        this.lock.unlock(obj);
    }

    public /* synthetic */ ConnectionWithLock(SQLiteConnection sQLiteConnection, kotlinx.coroutines.sync.a aVar, int i6, v vVar) {
        this(sQLiteConnection, (i6 & 2) != 0 ? kotlinx.coroutines.sync.c.b(false, 1, null) : aVar);
    }
}
