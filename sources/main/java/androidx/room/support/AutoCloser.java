package androidx.room.support;

import android.os.SystemClock;
import androidx.annotation.GuardedBy;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlin.n1;
import kotlinx.coroutines.e2;
import kotlinx.coroutines.r0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nAutoCloser.android.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AutoCloser.android.kt\nandroidx/room/support/AutoCloser\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,221:1\n1#2:222\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
public final class AutoCloser {

    @NotNull
    public static final String BUG_LINK = "https://issuetracker.google.com/issues/new?component=413107&template=1096568";

    @NotNull
    public static final Companion Companion = new Companion(null);

    @Nullable
    private e2 autoCloseJob;
    private final long autoCloseTimeoutInMs;
    private r0 coroutineScope;

    @GuardedBy("lock")
    @Nullable
    private SupportSQLiteDatabase delegateDatabase;
    private SupportSQLiteOpenHelper delegateOpenHelper;

    @NotNull
    private AtomicLong lastDecrementRefCountTimeStamp;

    @NotNull
    private final Object lock;
    private boolean manuallyClosed;

    @Nullable
    private Function0<n1> onAutoCloseCallback;

    @NotNull
    private final AtomicInteger referenceCount;

    @NotNull
    private final Watch watch;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Companion {
        public /* synthetic */ Companion(v vVar) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface Watch {
        long getMillis();
    }

    public AutoCloser(long j6, @NotNull TimeUnit timeUnit, @NotNull Watch watch) {
        g0.p(timeUnit, "timeUnit");
        g0.p(watch, "watch");
        this.watch = watch;
        this.lock = new Object();
        this.autoCloseTimeoutInMs = timeUnit.toMillis(j6);
        this.referenceCount = new AtomicInteger(0);
        this.lastDecrementRefCountTimeStamp = new AtomicLong(watch.getMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void autoCloseDatabase() {
        synchronized (this.lock) {
            try {
                if (this.watch.getMillis() - this.lastDecrementRefCountTimeStamp.get() < this.autoCloseTimeoutInMs) {
                    return;
                }
                if (this.referenceCount.get() != 0) {
                    return;
                }
                Function0<n1> function0 = this.onAutoCloseCallback;
                if (function0 == null) {
                    throw new IllegalStateException("onAutoCloseCallback is null but it should  have been set before use. Please file a bug against Room at: https://issuetracker.google.com/issues/new?component=413107&template=1096568");
                }
                function0.invoke();
                SupportSQLiteDatabase supportSQLiteDatabase = this.delegateDatabase;
                if (supportSQLiteDatabase != null && supportSQLiteDatabase.isOpen()) {
                    supportSQLiteDatabase.close();
                }
                this.delegateDatabase = null;
                n1 n1Var = n1.f44123a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void closeDatabaseIfOpen() {
        synchronized (this.lock) {
            try {
                this.manuallyClosed = true;
                e2 e2Var = this.autoCloseJob;
                if (e2Var != null) {
                    e2.a.b(e2Var, null, 1, null);
                }
                this.autoCloseJob = null;
                SupportSQLiteDatabase supportSQLiteDatabase = this.delegateDatabase;
                if (supportSQLiteDatabase != null) {
                    supportSQLiteDatabase.close();
                }
                this.delegateDatabase = null;
                n1 n1Var = n1.f44123a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void decrementCountAndScheduleClose() {
        r0 r0Var;
        e2 f6;
        int decrementAndGet = this.referenceCount.decrementAndGet();
        if (decrementAndGet < 0) {
            throw new IllegalStateException("Unbalanced reference count.");
        }
        this.lastDecrementRefCountTimeStamp.set(this.watch.getMillis());
        if (decrementAndGet == 0) {
            r0 r0Var2 = this.coroutineScope;
            if (r0Var2 == null) {
                g0.S("coroutineScope");
                r0Var = null;
            } else {
                r0Var = r0Var2;
            }
            f6 = kotlinx.coroutines.k.f(r0Var, null, null, new AutoCloser$decrementCountAndScheduleClose$2(this, null), 3, null);
            this.autoCloseJob = f6;
        }
    }

    public final <V> V executeRefCountingFunction(@NotNull Function1<? super SupportSQLiteDatabase, ? extends V> block) {
        g0.p(block, "block");
        try {
            return block.invoke(incrementCountAndEnsureDbIsOpen());
        } finally {
            decrementCountAndScheduleClose();
        }
    }

    @Nullable
    public final Function0<n1> getAutoCloseCallbackForTest$room_runtime_release() {
        return this.onAutoCloseCallback;
    }

    @Nullable
    public final SupportSQLiteDatabase getDelegateDatabase$room_runtime_release() {
        return this.delegateDatabase;
    }

    public final int getRefCountForTest$room_runtime_release() {
        return this.referenceCount.get();
    }

    @NotNull
    public final SupportSQLiteDatabase incrementCountAndEnsureDbIsOpen() {
        e2 e2Var = this.autoCloseJob;
        SupportSQLiteOpenHelper supportSQLiteOpenHelper = null;
        if (e2Var != null) {
            e2.a.b(e2Var, null, 1, null);
        }
        this.autoCloseJob = null;
        this.referenceCount.incrementAndGet();
        if (this.manuallyClosed) {
            throw new IllegalStateException("Attempting to open already closed database.");
        }
        synchronized (this.lock) {
            SupportSQLiteDatabase supportSQLiteDatabase = this.delegateDatabase;
            if (supportSQLiteDatabase != null && supportSQLiteDatabase.isOpen()) {
                return supportSQLiteDatabase;
            }
            SupportSQLiteOpenHelper supportSQLiteOpenHelper2 = this.delegateOpenHelper;
            if (supportSQLiteOpenHelper2 == null) {
                g0.S("delegateOpenHelper");
            } else {
                supportSQLiteOpenHelper = supportSQLiteOpenHelper2;
            }
            SupportSQLiteDatabase writableDatabase = supportSQLiteOpenHelper.getWritableDatabase();
            this.delegateDatabase = writableDatabase;
            return writableDatabase;
        }
    }

    public final void initCoroutineScope(@NotNull r0 coroutineScope) {
        g0.p(coroutineScope, "coroutineScope");
        this.coroutineScope = coroutineScope;
    }

    public final void initOpenHelper(@NotNull SupportSQLiteOpenHelper delegateOpenHelper) {
        g0.p(delegateOpenHelper, "delegateOpenHelper");
        if (delegateOpenHelper instanceof AutoClosingRoomOpenHelper) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        this.delegateOpenHelper = delegateOpenHelper;
    }

    public final boolean isActive() {
        return !this.manuallyClosed;
    }

    public final void setAutoCloseCallback(@NotNull Function0<n1> onAutoClose) {
        g0.p(onAutoClose, "onAutoClose");
        this.onAutoCloseCallback = onAutoClose;
    }

    public final void setDelegateDatabase$room_runtime_release(@Nullable SupportSQLiteDatabase supportSQLiteDatabase) {
        this.delegateDatabase = supportSQLiteDatabase;
    }

    public /* synthetic */ AutoCloser(long j6, TimeUnit timeUnit, Watch watch, int i6, v vVar) {
        this(j6, timeUnit, (i6 & 4) != 0 ? new Watch() { // from class: androidx.room.support.a
            @Override // androidx.room.support.AutoCloser.Watch
            public final long getMillis() {
                long uptimeMillis;
                uptimeMillis = SystemClock.uptimeMillis();
                return uptimeMillis;
            }
        } : watch);
    }
}
