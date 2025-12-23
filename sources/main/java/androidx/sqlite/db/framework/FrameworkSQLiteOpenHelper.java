package androidx.sqlite.db.framework;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import androidx.sqlite.db.SupportSQLiteCompat;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper;
import androidx.sqlite.util.ProcessLock;
import java.io.File;
import java.util.UUID;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlin.s;
import kotlin.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class FrameworkSQLiteOpenHelper implements SupportSQLiteOpenHelper {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final String TAG = "SupportSQLite";
    private final boolean allowDataLossOnRecovery;

    @NotNull
    private final SupportSQLiteOpenHelper.Callback callback;

    @NotNull
    private final Context context;

    @NotNull
    private final s<OpenHelper> lazyDelegate;

    @Nullable
    private final String name;
    private final boolean useNoBackupDirectory;
    private boolean writeAheadLoggingEnabled;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Companion {
        public /* synthetic */ Companion(v vVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class DBRefHolder {

        @Nullable
        private FrameworkSQLiteDatabase db;

        @Nullable
        public final FrameworkSQLiteDatabase getDb() {
            return this.db;
        }

        public final void setDb(@Nullable FrameworkSQLiteDatabase frameworkSQLiteDatabase) {
            this.db = frameworkSQLiteDatabase;
        }

        public DBRefHolder(@Nullable FrameworkSQLiteDatabase frameworkSQLiteDatabase) {
            this.db = frameworkSQLiteDatabase;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class OpenHelper extends SQLiteOpenHelper {

        @NotNull
        public static final Companion Companion = new Companion(null);
        private final boolean allowDataLossOnRecovery;

        @NotNull
        private final SupportSQLiteOpenHelper.Callback callback;

        @NotNull
        private final Context context;

        @NotNull
        private final DBRefHolder dbRef;

        @NotNull
        private final ProcessLock lock;
        private boolean migrated;
        private boolean opened;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        private static final class CallbackException extends RuntimeException {

            @NotNull
            private final CallbackName callbackName;

            @NotNull
            private final Throwable cause;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public CallbackException(@NotNull CallbackName callbackName, @NotNull Throwable cause) {
                super(cause);
                g0.p(callbackName, "callbackName");
                g0.p(cause, "cause");
                this.callbackName = callbackName;
                this.cause = cause;
            }

            @NotNull
            public final CallbackName getCallbackName() {
                return this.callbackName;
            }

            @Override // java.lang.Throwable
            @NotNull
            public Throwable getCause() {
                return this.cause;
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static final class CallbackName {
            private static final /* synthetic */ kotlin.enums.a $ENTRIES;
            private static final /* synthetic */ CallbackName[] $VALUES;
            public static final CallbackName ON_CONFIGURE = new CallbackName("ON_CONFIGURE", 0);
            public static final CallbackName ON_CREATE = new CallbackName("ON_CREATE", 1);
            public static final CallbackName ON_UPGRADE = new CallbackName("ON_UPGRADE", 2);
            public static final CallbackName ON_DOWNGRADE = new CallbackName("ON_DOWNGRADE", 3);
            public static final CallbackName ON_OPEN = new CallbackName("ON_OPEN", 4);

            private static final /* synthetic */ CallbackName[] $values() {
                return new CallbackName[]{ON_CONFIGURE, ON_CREATE, ON_UPGRADE, ON_DOWNGRADE, ON_OPEN};
            }

            static {
                CallbackName[] $values = $values();
                $VALUES = $values;
                $ENTRIES = kotlin.enums.c.c($values);
            }

            @NotNull
            public static kotlin.enums.a<CallbackName> getEntries() {
                return $ENTRIES;
            }

            public static CallbackName valueOf(String str) {
                return (CallbackName) Enum.valueOf(CallbackName.class, str);
            }

            public static CallbackName[] values() {
                return (CallbackName[]) $VALUES.clone();
            }

            private CallbackName(String str, int i6) {
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @SourceDebugExtension({"SMAP\nFrameworkSQLiteOpenHelper.android.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FrameworkSQLiteOpenHelper.android.kt\nandroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$OpenHelper$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,337:1\n1#2:338\n*E\n"})
        public static final class Companion {
            public /* synthetic */ Companion(v vVar) {
                this();
            }

            private Companion() {
            }

            @NotNull
            public final FrameworkSQLiteDatabase getWrappedDb(@NotNull DBRefHolder refHolder, @NotNull SQLiteDatabase sqLiteDatabase) {
                g0.p(refHolder, "refHolder");
                g0.p(sqLiteDatabase, "sqLiteDatabase");
                FrameworkSQLiteDatabase db = refHolder.getDb();
                if (db != null && db.isDelegate(sqLiteDatabase)) {
                    return db;
                }
                FrameworkSQLiteDatabase frameworkSQLiteDatabase = new FrameworkSQLiteDatabase(sqLiteDatabase);
                refHolder.setDb(frameworkSQLiteDatabase);
                return frameworkSQLiteDatabase;
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[CallbackName.values().length];
                try {
                    iArr[CallbackName.ON_CONFIGURE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[CallbackName.ON_CREATE.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[CallbackName.ON_UPGRADE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[CallbackName.ON_DOWNGRADE.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[CallbackName.ON_OPEN.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OpenHelper(@NotNull Context context, @Nullable String str, @NotNull final DBRefHolder dbRef, @NotNull final SupportSQLiteOpenHelper.Callback callback, boolean z5) {
            super(context, str, null, callback.version, new DatabaseErrorHandler() { // from class: androidx.sqlite.db.framework.g
                @Override // android.database.DatabaseErrorHandler
                public final void onCorruption(SQLiteDatabase sQLiteDatabase) {
                    FrameworkSQLiteOpenHelper.OpenHelper._init_$lambda$0(SupportSQLiteOpenHelper.Callback.this, dbRef, sQLiteDatabase);
                }
            });
            String str2;
            g0.p(context, "context");
            g0.p(dbRef, "dbRef");
            g0.p(callback, "callback");
            this.context = context;
            this.dbRef = dbRef;
            this.callback = callback;
            this.allowDataLossOnRecovery = z5;
            if (str == null) {
                str2 = UUID.randomUUID().toString();
                g0.o(str2, "toString(...)");
            } else {
                str2 = str;
            }
            this.lock = new ProcessLock(str2, context.getCacheDir(), false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void _init_$lambda$0(SupportSQLiteOpenHelper.Callback callback, DBRefHolder dBRefHolder, SQLiteDatabase sQLiteDatabase) {
            Companion companion = Companion;
            g0.m(sQLiteDatabase);
            callback.onCorruption(companion.getWrappedDb(dBRefHolder, sQLiteDatabase));
        }

        private final SQLiteDatabase getWritableOrReadableDatabase(boolean z5) {
            if (z5) {
                SQLiteDatabase writableDatabase = super.getWritableDatabase();
                g0.m(writableDatabase);
                return writableDatabase;
            }
            SQLiteDatabase readableDatabase = super.getReadableDatabase();
            g0.m(readableDatabase);
            return readableDatabase;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
        public void close() {
            try {
                ProcessLock.lock$default(this.lock, false, 1, null);
                super.close();
                this.dbRef.setDb(null);
                this.opened = false;
            } finally {
                this.lock.unlock();
            }
        }

        public final boolean getAllowDataLossOnRecovery() {
            return this.allowDataLossOnRecovery;
        }

        @NotNull
        public final SupportSQLiteOpenHelper.Callback getCallback() {
            return this.callback;
        }

        @NotNull
        public final Context getContext() {
            return this.context;
        }

        @NotNull
        public final DBRefHolder getDbRef() {
            return this.dbRef;
        }

        @NotNull
        public final SupportSQLiteDatabase getSupportDatabase(boolean z5) {
            SupportSQLiteDatabase wrappedDb;
            try {
                this.lock.lock((this.opened || getDatabaseName() == null) ? false : true);
                this.migrated = false;
                SQLiteDatabase innerGetDatabase = innerGetDatabase(z5);
                if (this.migrated) {
                    close();
                    wrappedDb = getSupportDatabase(z5);
                } else {
                    wrappedDb = getWrappedDb(innerGetDatabase);
                }
                this.lock.unlock();
                return wrappedDb;
            } catch (Throwable th) {
                this.lock.unlock();
                throw th;
            }
        }

        @NotNull
        public final FrameworkSQLiteDatabase getWrappedDb(@NotNull SQLiteDatabase sqLiteDatabase) {
            g0.p(sqLiteDatabase, "sqLiteDatabase");
            return Companion.getWrappedDb(this.dbRef, sqLiteDatabase);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onConfigure(@NotNull SQLiteDatabase db) {
            g0.p(db, "db");
            if (!this.migrated && this.callback.version != db.getVersion()) {
                db.setMaxSqlCacheSize(1);
            }
            try {
                this.callback.onConfigure(getWrappedDb(db));
            } catch (Throwable th) {
                throw new CallbackException(CallbackName.ON_CONFIGURE, th);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(@NotNull SQLiteDatabase sqLiteDatabase) {
            g0.p(sqLiteDatabase, "sqLiteDatabase");
            try {
                this.callback.onCreate(getWrappedDb(sqLiteDatabase));
            } catch (Throwable th) {
                throw new CallbackException(CallbackName.ON_CREATE, th);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(@NotNull SQLiteDatabase db, int i6, int i7) {
            g0.p(db, "db");
            this.migrated = true;
            try {
                this.callback.onDowngrade(getWrappedDb(db), i6, i7);
            } catch (Throwable th) {
                throw new CallbackException(CallbackName.ON_DOWNGRADE, th);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onOpen(@NotNull SQLiteDatabase db) {
            g0.p(db, "db");
            if (!this.migrated) {
                try {
                    this.callback.onOpen(getWrappedDb(db));
                } catch (Throwable th) {
                    throw new CallbackException(CallbackName.ON_OPEN, th);
                }
            }
            this.opened = true;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(@NotNull SQLiteDatabase sqLiteDatabase, int i6, int i7) {
            g0.p(sqLiteDatabase, "sqLiteDatabase");
            this.migrated = true;
            try {
                this.callback.onUpgrade(getWrappedDb(sqLiteDatabase), i6, i7);
            } catch (Throwable th) {
                throw new CallbackException(CallbackName.ON_UPGRADE, th);
            }
        }

        private final SQLiteDatabase innerGetDatabase(boolean z5) {
            File parentFile;
            String databaseName = getDatabaseName();
            boolean z6 = this.opened;
            if (databaseName != null && !z6 && (parentFile = this.context.getDatabasePath(databaseName).getParentFile()) != null) {
                parentFile.mkdirs();
                if (!parentFile.isDirectory()) {
                    parentFile.toString();
                }
            }
            try {
                return getWritableOrReadableDatabase(z5);
            } catch (Throwable unused) {
                try {
                    Thread.sleep(500L);
                } catch (InterruptedException unused2) {
                }
                try {
                    return getWritableOrReadableDatabase(z5);
                } catch (Throwable th) {
                    th = th;
                    if (th instanceof CallbackException) {
                        CallbackException callbackException = (CallbackException) th;
                        Throwable cause = callbackException.getCause();
                        int i6 = WhenMappings.$EnumSwitchMapping$0[callbackException.getCallbackName().ordinal()];
                        if (i6 != 1) {
                            if (i6 != 2) {
                                if (i6 != 3) {
                                    if (i6 != 4) {
                                        if (i6 == 5) {
                                            if (cause instanceof SQLiteException) {
                                                th = cause;
                                            } else {
                                                throw cause;
                                            }
                                        } else {
                                            throw new NoWhenBranchMatchedException();
                                        }
                                    } else {
                                        throw cause;
                                    }
                                } else {
                                    throw cause;
                                }
                            } else {
                                throw cause;
                            }
                        } else {
                            throw cause;
                        }
                    }
                    if ((th instanceof SQLiteException) && databaseName != null && this.allowDataLossOnRecovery) {
                        this.context.deleteDatabase(databaseName);
                        try {
                            return getWritableOrReadableDatabase(z5);
                        } catch (CallbackException e6) {
                            throw e6.getCause();
                        }
                    }
                    throw th;
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FrameworkSQLiteOpenHelper(@NotNull Context context, @Nullable String str, @NotNull SupportSQLiteOpenHelper.Callback callback) {
        this(context, str, callback, false, false, 24, null);
        g0.p(context, "context");
        g0.p(callback, "callback");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FrameworkSQLiteOpenHelper(@NotNull Context context, @Nullable String str, @NotNull SupportSQLiteOpenHelper.Callback callback, boolean z5) {
        this(context, str, callback, z5, false, 16, null);
        g0.p(context, "context");
        g0.p(callback, "callback");
    }

    private final OpenHelper getDelegate() {
        return this.lazyDelegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OpenHelper lazyDelegate$lambda$0(FrameworkSQLiteOpenHelper frameworkSQLiteOpenHelper) {
        OpenHelper openHelper;
        if (Build.VERSION.SDK_INT < 23 || frameworkSQLiteOpenHelper.name == null || !frameworkSQLiteOpenHelper.useNoBackupDirectory) {
            openHelper = new OpenHelper(frameworkSQLiteOpenHelper.context, frameworkSQLiteOpenHelper.name, new DBRefHolder(null), frameworkSQLiteOpenHelper.callback, frameworkSQLiteOpenHelper.allowDataLossOnRecovery);
        } else {
            openHelper = new OpenHelper(frameworkSQLiteOpenHelper.context, new File(SupportSQLiteCompat.Api21Impl.getNoBackupFilesDir(frameworkSQLiteOpenHelper.context), frameworkSQLiteOpenHelper.name).getAbsolutePath(), new DBRefHolder(null), frameworkSQLiteOpenHelper.callback, frameworkSQLiteOpenHelper.allowDataLossOnRecovery);
        }
        openHelper.setWriteAheadLoggingEnabled(frameworkSQLiteOpenHelper.writeAheadLoggingEnabled);
        return openHelper;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.lazyDelegate.isInitialized()) {
            getDelegate().close();
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    @Nullable
    public String getDatabaseName() {
        return this.name;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public void setWriteAheadLoggingEnabled(boolean z5) {
        if (this.lazyDelegate.isInitialized()) {
            getDelegate().setWriteAheadLoggingEnabled(z5);
        }
        this.writeAheadLoggingEnabled = z5;
    }

    @JvmOverloads
    public FrameworkSQLiteOpenHelper(@NotNull Context context, @Nullable String str, @NotNull SupportSQLiteOpenHelper.Callback callback, boolean z5, boolean z6) {
        g0.p(context, "context");
        g0.p(callback, "callback");
        this.context = context;
        this.name = str;
        this.callback = callback;
        this.useNoBackupDirectory = z5;
        this.allowDataLossOnRecovery = z6;
        this.lazyDelegate = t.c(new Function0() { // from class: androidx.sqlite.db.framework.f
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                FrameworkSQLiteOpenHelper.OpenHelper lazyDelegate$lambda$0;
                lazyDelegate$lambda$0 = FrameworkSQLiteOpenHelper.lazyDelegate$lambda$0(FrameworkSQLiteOpenHelper.this);
                return lazyDelegate$lambda$0;
            }
        });
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    @NotNull
    public SupportSQLiteDatabase getReadableDatabase() {
        return getDelegate().getSupportDatabase(false);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    @NotNull
    public SupportSQLiteDatabase getWritableDatabase() {
        return getDelegate().getSupportDatabase(true);
    }

    public /* synthetic */ FrameworkSQLiteOpenHelper(Context context, String str, SupportSQLiteOpenHelper.Callback callback, boolean z5, boolean z6, int i6, v vVar) {
        this(context, str, callback, (i6 & 8) != 0 ? false : z5, (i6 & 16) != 0 ? false : z6);
    }
}
