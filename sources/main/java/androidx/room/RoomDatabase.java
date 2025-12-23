package androidx.room;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.CancellationSignal;
import android.os.Looper;
import androidx.annotation.IntRange;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.exifinterface.media.ExifInterface;
import androidx.room.concurrent.CloseBarrier;
import androidx.room.coroutines.RunBlockingUninterruptible_androidKt;
import androidx.room.driver.SupportSQLiteConnection;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.support.AutoCloser;
import androidx.room.support.AutoClosingRoomOpenHelperFactory;
import androidx.room.support.PrePackagedCopyOpenHelperFactory;
import androidx.room.support.QueryInterceptorOpenHelperFactory;
import androidx.room.util.DBUtil;
import androidx.room.util.KClassUtil;
import androidx.room.util.MigrationUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteDriver;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.NotImplementedError;
import kotlin.Pair;
import kotlin.PublishedApi;
import kotlin.ReplaceWith;
import kotlin.collections.f0;
import kotlin.collections.i1;
import kotlin.collections.u1;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmSuppressWildcards;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import kotlin.o0;
import kotlinx.coroutines.r0;
import kotlinx.coroutines.s0;
import kotlinx.coroutines.v1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nRoomDatabase.android.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RoomDatabase.android.kt\nandroidx/room/RoomDatabase\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,2151:1\n357#1,15:2152\n357#1,15:2167\n477#2:2182\n423#2:2183\n1246#3,4:2184\n1187#3,2:2188\n1261#3,2:2190\n1557#3:2192\n1628#3,3:2193\n1264#3:2196\n1557#3:2197\n1628#3,3:2198\n*S KotlinDebug\n*F\n+ 1 RoomDatabase.android.kt\nandroidx/room/RoomDatabase\n*L\n271#1:2152,15\n275#1:2167,15\n343#1:2182\n343#1:2183\n343#1:2184,4\n452#1:2188,2\n452#1:2190,2\n453#1:2192\n453#1:2193,3\n452#1:2196\n478#1:2197\n478#1:2198,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
public abstract class RoomDatabase {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final int MAX_BIND_PARAMETER_CNT = 999;
    private boolean allowMainThreadQueries;

    @Nullable
    private AutoCloser autoCloser;
    private RoomConnectionManager connectionManager;
    private r0 coroutineScope;
    private Executor internalQueryExecutor;
    private InvalidationTracker internalTracker;
    private Executor internalTransactionExecutor;

    @JvmField
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Nullable
    protected List<? extends Callback> mCallbacks;

    @JvmField
    @Nullable
    protected volatile SupportSQLiteDatabase mDatabase;
    private kotlin.coroutines.i transactionContext;

    @NotNull
    private final CloseBarrier closeBarrier = new CloseBarrier(new RoomDatabase$closeBarrier$1(this));

    @NotNull
    private final ThreadLocal<Integer> suspendingTransactionId = new ThreadLocal<>();

    @NotNull
    private final Map<kotlin.reflect.d<?>, Object> typeConverters = new LinkedHashMap();
    private boolean useTempTrackingTable = true;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nRoomDatabase.android.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RoomDatabase.android.kt\nandroidx/room/RoomDatabase$Builder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,2151:1\n1#2:2152\n*E\n"})
    public static class Builder<T extends RoomDatabase> {
        private boolean allowDestructiveMigrationForAllTables;
        private boolean allowDestructiveMigrationOnDowngrade;
        private boolean allowMainThreadQueries;

        @Nullable
        private TimeUnit autoCloseTimeUnit;
        private long autoCloseTimeout;

        @NotNull
        private final List<AutoMigrationSpec> autoMigrationSpecs;

        @NotNull
        private final List<Callback> callbacks;

        @NotNull
        private final Context context;

        @Nullable
        private String copyFromAssetPath;

        @Nullable
        private File copyFromFile;

        @Nullable
        private Callable<InputStream> copyFromInputStream;

        @Nullable
        private SQLiteDriver driver;

        @Nullable
        private final Function0<T> factory;
        private boolean inMemoryTrackingTableMode;

        @NotNull
        private JournalMode journalMode;

        @NotNull
        private final kotlin.reflect.d<T> klass;

        @NotNull
        private final MigrationContainer migrationContainer;

        @NotNull
        private final Set<Integer> migrationStartAndEndVersions;

        @NotNull
        private Set<Integer> migrationsNotRequiredFrom;

        @Nullable
        private Intent multiInstanceInvalidationIntent;

        @Nullable
        private final String name;

        @Nullable
        private PrepackagedDatabaseCallback prepackagedDatabaseCallback;

        @Nullable
        private QueryCallback queryCallback;

        @Nullable
        private kotlin.coroutines.i queryCallbackCoroutineContext;

        @Nullable
        private Executor queryCallbackExecutor;

        @Nullable
        private kotlin.coroutines.i queryCoroutineContext;

        @Nullable
        private Executor queryExecutor;
        private boolean requireMigration;

        @Nullable
        private SupportSQLiteOpenHelper.Factory supportOpenHelperFactory;

        @Nullable
        private Executor transactionExecutor;

        @NotNull
        private final List<Object> typeConverters;

        /* JADX WARN: Multi-variable type inference failed */
        @PublishedApi
        public Builder(@NotNull kotlin.reflect.d<T> klass, @Nullable String str, @Nullable Function0<? extends T> function0, @NotNull Context context) {
            g0.p(klass, "klass");
            g0.p(context, "context");
            this.callbacks = new ArrayList();
            this.typeConverters = new ArrayList();
            this.journalMode = JournalMode.AUTOMATIC;
            this.autoCloseTimeout = -1L;
            this.migrationContainer = new MigrationContainer();
            this.migrationsNotRequiredFrom = new LinkedHashSet();
            this.migrationStartAndEndVersions = new LinkedHashSet();
            this.autoMigrationSpecs = new ArrayList();
            this.requireMigration = true;
            this.inMemoryTrackingTableMode = true;
            this.klass = klass;
            this.context = context;
            this.name = str;
            this.factory = function0;
        }

        @NotNull
        public Builder<T> allowMainThreadQueries() {
            this.allowMainThreadQueries = true;
            return this;
        }

        @NotNull
        public Builder<T> createFromAsset(@NotNull String databaseFilePath) {
            g0.p(databaseFilePath, "databaseFilePath");
            this.copyFromAssetPath = databaseFilePath;
            return this;
        }

        @NotNull
        public Builder<T> createFromFile(@NotNull File databaseFile) {
            g0.p(databaseFile, "databaseFile");
            this.copyFromFile = databaseFile;
            return this;
        }

        @SuppressLint({"BuilderSetStyle"})
        @NotNull
        public Builder<T> createFromInputStream(@NotNull Callable<InputStream> inputStreamCallable) {
            g0.p(inputStreamCallable, "inputStreamCallable");
            this.copyFromInputStream = inputStreamCallable;
            return this;
        }

        @Deprecated(message = "Replace by overloaded version with parameter to indicate if all tables should be dropped or not.", replaceWith = @ReplaceWith(expression = "fallbackToDestructiveMigration(false)", imports = {}))
        @NotNull
        public Builder<T> fallbackToDestructiveMigration() {
            this.requireMigration = false;
            this.allowDestructiveMigrationOnDowngrade = true;
            return this;
        }

        @Deprecated(message = "Replace by overloaded version with parameter to indicate if all tables should be dropped or not.", replaceWith = @ReplaceWith(expression = "fallbackToDestructiveMigrationFrom(false, startVersions)", imports = {}))
        @NotNull
        public Builder<T> fallbackToDestructiveMigrationFrom(@NotNull int... startVersions) {
            g0.p(startVersions, "startVersions");
            for (int i6 : startVersions) {
                this.migrationsNotRequiredFrom.add(Integer.valueOf(i6));
            }
            return this;
        }

        @Deprecated(message = "Replace by overloaded version with parameter to indicate if all tables should be dropped or not.", replaceWith = @ReplaceWith(expression = "fallbackToDestructiveMigrationOnDowngrade(false)", imports = {}))
        @NotNull
        public Builder<T> fallbackToDestructiveMigrationOnDowngrade() {
            this.requireMigration = true;
            this.allowDestructiveMigrationOnDowngrade = true;
            return this;
        }

        @NotNull
        public Builder<T> setQueryCallback(@NotNull QueryCallback queryCallback, @NotNull Executor executor) {
            g0.p(queryCallback, "queryCallback");
            g0.p(executor, "executor");
            this.queryCallback = queryCallback;
            this.queryCallbackExecutor = executor;
            this.queryCallbackCoroutineContext = null;
            return this;
        }

        @NotNull
        public Builder<T> addAutoMigrationSpec(@NotNull AutoMigrationSpec autoMigrationSpec) {
            g0.p(autoMigrationSpec, "autoMigrationSpec");
            this.autoMigrationSpecs.add(autoMigrationSpec);
            return this;
        }

        @NotNull
        public Builder<T> addCallback(@NotNull Callback callback) {
            g0.p(callback, "callback");
            this.callbacks.add(callback);
            return this;
        }

        @NotNull
        public Builder<T> addMigrations(@NotNull Migration... migrations) {
            g0.p(migrations, "migrations");
            for (Migration migration : migrations) {
                this.migrationStartAndEndVersions.add(Integer.valueOf(migration.startVersion));
                this.migrationStartAndEndVersions.add(Integer.valueOf(migration.endVersion));
            }
            this.migrationContainer.addMigrations((Migration[]) Arrays.copyOf(migrations, migrations.length));
            return this;
        }

        @NotNull
        public Builder<T> addTypeConverter(@NotNull Object typeConverter) {
            g0.p(typeConverter, "typeConverter");
            this.typeConverters.add(typeConverter);
            return this;
        }

        @NotNull
        public T build() {
            SupportSQLiteOpenHelper.Factory factory;
            SupportSQLiteOpenHelper.Factory factory2;
            T t5;
            kotlin.coroutines.i iVar;
            Executor executor = this.queryExecutor;
            if (executor == null && this.transactionExecutor == null) {
                Executor iOThreadExecutor = ArchTaskExecutor.getIOThreadExecutor();
                this.transactionExecutor = iOThreadExecutor;
                this.queryExecutor = iOThreadExecutor;
            } else if (executor != null && this.transactionExecutor == null) {
                this.transactionExecutor = executor;
            } else if (executor == null) {
                this.queryExecutor = this.transactionExecutor;
            }
            RoomDatabaseKt.validateMigrationsNotRequired(this.migrationStartAndEndVersions, this.migrationsNotRequiredFrom);
            SQLiteDriver sQLiteDriver = this.driver;
            if (sQLiteDriver == null && this.supportOpenHelperFactory == null) {
                factory = new FrameworkSQLiteOpenHelperFactory();
            } else if (sQLiteDriver == null) {
                factory = this.supportOpenHelperFactory;
            } else {
                if (this.supportOpenHelperFactory != null) {
                    throw new IllegalArgumentException("A RoomDatabase cannot be configured with both a SQLiteDriver and a SupportOpenHelper.Factory.");
                }
                factory = null;
            }
            boolean z5 = this.autoCloseTimeout > 0;
            boolean z6 = (this.copyFromAssetPath == null && this.copyFromFile == null && this.copyFromInputStream == null) ? false : true;
            boolean z7 = this.queryCallback != null;
            if (factory != null) {
                if (z5) {
                    if (this.name == null) {
                        throw new IllegalArgumentException("Cannot create auto-closing database for an in-memory database.");
                    }
                    long j6 = this.autoCloseTimeout;
                    TimeUnit timeUnit = this.autoCloseTimeUnit;
                    if (timeUnit == null) {
                        throw new IllegalArgumentException("Required value was null.");
                    }
                    factory = new AutoClosingRoomOpenHelperFactory(factory, new AutoCloser(j6, timeUnit, null, 4, null));
                }
                if (z6) {
                    if (this.name == null) {
                        throw new IllegalArgumentException("Cannot create from asset or file for an in-memory database.");
                    }
                    String str = this.copyFromAssetPath;
                    int i6 = str == null ? 0 : 1;
                    File file = this.copyFromFile;
                    int i7 = file == null ? 0 : 1;
                    Callable<InputStream> callable = this.copyFromInputStream;
                    if (i6 + i7 + (callable != null ? 1 : 0) != 1) {
                        throw new IllegalArgumentException("More than one of createFromAsset(), createFromInputStream(), and createFromFile() were called on this Builder, but the database can only be created using one of the three configurations.");
                    }
                    factory = new PrePackagedCopyOpenHelperFactory(str, file, callable, factory);
                }
                if (z7) {
                    Executor executor2 = this.queryCallbackExecutor;
                    if ((executor2 == null || (iVar = v1.c(executor2)) == null) && (iVar = this.queryCallbackCoroutineContext) == null) {
                        throw new IllegalArgumentException("Required value was null.");
                    }
                    r0 a6 = s0.a(iVar);
                    QueryCallback queryCallback = this.queryCallback;
                    if (queryCallback == null) {
                        throw new IllegalArgumentException("Required value was null.");
                    }
                    factory = new QueryInterceptorOpenHelperFactory(factory, a6, queryCallback);
                }
                factory2 = factory;
            } else {
                factory2 = null;
            }
            if (factory2 == null) {
                if (z5) {
                    throw new IllegalArgumentException("Auto Closing Database is not supported when an SQLiteDriver is configured.");
                }
                if (z6) {
                    throw new IllegalArgumentException("Pre-Package Database is not supported when an SQLiteDriver is configured.");
                }
                if (z7) {
                    throw new IllegalArgumentException("Query Callback is not supported when an SQLiteDriver is configured.");
                }
            }
            Context context = this.context;
            String str2 = this.name;
            MigrationContainer migrationContainer = this.migrationContainer;
            List<Callback> list = this.callbacks;
            boolean z8 = this.allowMainThreadQueries;
            JournalMode resolve$room_runtime_release = this.journalMode.resolve$room_runtime_release(context);
            Executor executor3 = this.queryExecutor;
            if (executor3 == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            Executor executor4 = this.transactionExecutor;
            if (executor4 == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            DatabaseConfiguration databaseConfiguration = new DatabaseConfiguration(context, str2, factory2, migrationContainer, list, z8, resolve$room_runtime_release, executor3, executor4, this.multiInstanceInvalidationIntent, this.requireMigration, this.allowDestructiveMigrationOnDowngrade, this.migrationsNotRequiredFrom, this.copyFromAssetPath, this.copyFromFile, this.copyFromInputStream, this.prepackagedDatabaseCallback, this.typeConverters, this.autoMigrationSpecs, this.allowDestructiveMigrationForAllTables, this.driver, this.queryCoroutineContext);
            databaseConfiguration.setUseTempTrackingTable$room_runtime_release(this.inMemoryTrackingTableMode);
            Function0<T> function0 = this.factory;
            if (function0 == null || (t5 = function0.invoke()) == null) {
                t5 = (T) KClassUtil.findAndInstantiateDatabaseImpl$default(l3.a.e(this.klass), null, 2, null);
            }
            t5.init(databaseConfiguration);
            return t5;
        }

        @SuppressLint({"BuilderSetStyle"})
        @NotNull
        public Builder<T> createFromAsset(@NotNull String databaseFilePath, @NotNull PrepackagedDatabaseCallback callback) {
            g0.p(databaseFilePath, "databaseFilePath");
            g0.p(callback, "callback");
            this.prepackagedDatabaseCallback = callback;
            this.copyFromAssetPath = databaseFilePath;
            return this;
        }

        @SuppressLint({"BuilderSetStyle", "StreamFiles"})
        @NotNull
        public Builder<T> createFromFile(@NotNull File databaseFile, @NotNull PrepackagedDatabaseCallback callback) {
            g0.p(databaseFile, "databaseFile");
            g0.p(callback, "callback");
            this.prepackagedDatabaseCallback = callback;
            this.copyFromFile = databaseFile;
            return this;
        }

        @SuppressLint({"BuilderSetStyle", "LambdaLast"})
        @NotNull
        public Builder<T> createFromInputStream(@NotNull Callable<InputStream> inputStreamCallable, @NotNull PrepackagedDatabaseCallback callback) {
            g0.p(inputStreamCallable, "inputStreamCallable");
            g0.p(callback, "callback");
            this.prepackagedDatabaseCallback = callback;
            this.copyFromInputStream = inputStreamCallable;
            return this;
        }

        @NotNull
        public Builder<T> enableMultiInstanceInvalidation() {
            this.multiInstanceInvalidationIntent = this.name != null ? new Intent(this.context, (Class<?>) MultiInstanceInvalidationService.class) : null;
            return this;
        }

        @NotNull
        public Builder<T> openHelperFactory(@Nullable SupportSQLiteOpenHelper.Factory factory) {
            this.supportOpenHelperFactory = factory;
            return this;
        }

        @ExperimentalRoomApi
        @NotNull
        public Builder<T> setAutoCloseTimeout(@IntRange(from = 0) long j6, @NotNull TimeUnit autoCloseTimeUnit) {
            g0.p(autoCloseTimeUnit, "autoCloseTimeUnit");
            if (j6 < 0) {
                throw new IllegalArgumentException("autoCloseTimeout must be >= 0");
            }
            this.autoCloseTimeout = j6;
            this.autoCloseTimeUnit = autoCloseTimeUnit;
            return this;
        }

        @NotNull
        public final Builder<T> setDriver(@NotNull SQLiteDriver driver) {
            g0.p(driver, "driver");
            this.driver = driver;
            return this;
        }

        @ExperimentalRoomApi
        @NotNull
        public final Builder<T> setInMemoryTrackingMode(boolean z5) {
            this.inMemoryTrackingTableMode = z5;
            return this;
        }

        @NotNull
        public Builder<T> setJournalMode(@NotNull JournalMode journalMode) {
            g0.p(journalMode, "journalMode");
            this.journalMode = journalMode;
            return this;
        }

        @ExperimentalRoomApi
        @NotNull
        public Builder<T> setMultiInstanceInvalidationServiceIntent(@NotNull Intent invalidationServiceIntent) {
            g0.p(invalidationServiceIntent, "invalidationServiceIntent");
            if (this.name == null) {
                invalidationServiceIntent = null;
            }
            this.multiInstanceInvalidationIntent = invalidationServiceIntent;
            return this;
        }

        @NotNull
        public final Builder<T> setQueryCoroutineContext(@NotNull kotlin.coroutines.i context) {
            g0.p(context, "context");
            if (this.queryExecutor != null || this.transactionExecutor != null) {
                throw new IllegalArgumentException("This builder has already been configured with an Executor. A RoomDatabase canonly be configured with either an Executor or a CoroutineContext.");
            }
            if (context.get(kotlin.coroutines.f.f43765o0) == null) {
                throw new IllegalArgumentException("It is required that the coroutine context contain a dispatcher.");
            }
            this.queryCoroutineContext = context;
            return this;
        }

        @NotNull
        public Builder<T> setQueryExecutor(@NotNull Executor executor) {
            g0.p(executor, "executor");
            if (this.queryCoroutineContext != null) {
                throw new IllegalArgumentException("This builder has already been configured with a CoroutineContext. A RoomDatabasecan only be configured with either an Executor or a CoroutineContext.");
            }
            this.queryExecutor = executor;
            return this;
        }

        @NotNull
        public Builder<T> setTransactionExecutor(@NotNull Executor executor) {
            g0.p(executor, "executor");
            if (this.queryCoroutineContext != null) {
                throw new IllegalArgumentException("This builder has already been configured with a CoroutineContext. A RoomDatabasecan only be configured with either an Executor or a CoroutineContext.");
            }
            this.transactionExecutor = executor;
            return this;
        }

        @NotNull
        public final Builder<T> fallbackToDestructiveMigration(boolean z5) {
            this.requireMigration = false;
            this.allowDestructiveMigrationOnDowngrade = true;
            this.allowDestructiveMigrationForAllTables = z5;
            return this;
        }

        @NotNull
        public Builder<T> fallbackToDestructiveMigrationFrom(boolean z5, @NotNull int... startVersions) {
            g0.p(startVersions, "startVersions");
            for (int i6 : startVersions) {
                this.migrationsNotRequiredFrom.add(Integer.valueOf(i6));
            }
            this.allowDestructiveMigrationForAllTables = z5;
            return this;
        }

        @NotNull
        public final Builder<T> fallbackToDestructiveMigrationOnDowngrade(boolean z5) {
            this.requireMigration = true;
            this.allowDestructiveMigrationOnDowngrade = true;
            this.allowDestructiveMigrationForAllTables = z5;
            return this;
        }

        @NotNull
        public final Builder<T> setQueryCallback(@NotNull kotlin.coroutines.i context, @NotNull QueryCallback queryCallback) {
            g0.p(context, "context");
            g0.p(queryCallback, "queryCallback");
            this.queryCallback = queryCallback;
            this.queryCallbackExecutor = null;
            this.queryCallbackCoroutineContext = context;
            return this;
        }

        public Builder(@NotNull Context context, @NotNull Class<T> klass, @Nullable String str) {
            g0.p(context, "context");
            g0.p(klass, "klass");
            this.callbacks = new ArrayList();
            this.typeConverters = new ArrayList();
            this.journalMode = JournalMode.AUTOMATIC;
            this.autoCloseTimeout = -1L;
            this.migrationContainer = new MigrationContainer();
            this.migrationsNotRequiredFrom = new LinkedHashSet();
            this.migrationStartAndEndVersions = new LinkedHashSet();
            this.autoMigrationSpecs = new ArrayList();
            this.requireMigration = true;
            this.inMemoryTrackingTableMode = true;
            this.klass = l3.a.i(klass);
            this.context = context;
            this.name = str;
            this.factory = null;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static abstract class Callback {
        public void onCreate(@NotNull SupportSQLiteDatabase db) {
            g0.p(db, "db");
        }

        public void onDestructiveMigration(@NotNull SupportSQLiteDatabase db) {
            g0.p(db, "db");
        }

        public void onOpen(@NotNull SupportSQLiteDatabase db) {
            g0.p(db, "db");
        }

        public void onCreate(@NotNull SQLiteConnection connection) {
            g0.p(connection, "connection");
            if (connection instanceof SupportSQLiteConnection) {
                onCreate(((SupportSQLiteConnection) connection).getDb());
            }
        }

        public void onDestructiveMigration(@NotNull SQLiteConnection connection) {
            g0.p(connection, "connection");
            if (connection instanceof SupportSQLiteConnection) {
                onDestructiveMigration(((SupportSQLiteConnection) connection).getDb());
            }
        }

        public void onOpen(@NotNull SQLiteConnection connection) {
            g0.p(connection, "connection");
            if (connection instanceof SupportSQLiteConnection) {
                onOpen(((SupportSQLiteConnection) connection).getDb());
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.v vVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class JournalMode {
        private static final /* synthetic */ kotlin.enums.a $ENTRIES;
        private static final /* synthetic */ JournalMode[] $VALUES;
        public static final JournalMode AUTOMATIC = new JournalMode("AUTOMATIC", 0);
        public static final JournalMode TRUNCATE = new JournalMode("TRUNCATE", 1);
        public static final JournalMode WRITE_AHEAD_LOGGING = new JournalMode("WRITE_AHEAD_LOGGING", 2);

        private static final /* synthetic */ JournalMode[] $values() {
            return new JournalMode[]{AUTOMATIC, TRUNCATE, WRITE_AHEAD_LOGGING};
        }

        static {
            JournalMode[] $values = $values();
            $VALUES = $values;
            $ENTRIES = kotlin.enums.c.c($values);
        }

        @NotNull
        public static kotlin.enums.a<JournalMode> getEntries() {
            return $ENTRIES;
        }

        public static JournalMode valueOf(String str) {
            return (JournalMode) Enum.valueOf(JournalMode.class, str);
        }

        public static JournalMode[] values() {
            return (JournalMode[]) $VALUES.clone();
        }

        @NotNull
        public final JournalMode resolve$room_runtime_release(@NotNull Context context) {
            g0.p(context, "context");
            if (this != AUTOMATIC) {
                return this;
            }
            Object systemService = context.getSystemService(TTDownloadField.TT_ACTIVITY);
            ActivityManager activityManager = systemService instanceof ActivityManager ? (ActivityManager) systemService : null;
            return (activityManager == null || activityManager.isLowRamDevice()) ? TRUNCATE : WRITE_AHEAD_LOGGING;
        }

        private JournalMode(String str, int i6) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nRoomDatabase.android.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RoomDatabase.android.kt\nandroidx/room/RoomDatabase$MigrationContainer\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,2151:1\n13402#2,2:2152\n1863#3,2:2154\n381#4,7:2156\n*S KotlinDebug\n*F\n+ 1 RoomDatabase.android.kt\nandroidx/room/RoomDatabase$MigrationContainer\n*L\n1788#1:2152,2\n1798#1:2154,2\n1811#1:2156,7\n*E\n"})
    public static class MigrationContainer {

        @NotNull
        private final Map<Integer, TreeMap<Integer, Migration>> migrations = new LinkedHashMap();

        public void addMigrations(@NotNull List<? extends Migration> migrations) {
            g0.p(migrations, "migrations");
            Iterator<T> it = migrations.iterator();
            while (it.hasNext()) {
                addMigration((Migration) it.next());
            }
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final void addMigration(@NotNull Migration migration) {
            g0.p(migration, "migration");
            int i6 = migration.startVersion;
            int i7 = migration.endVersion;
            Map<Integer, TreeMap<Integer, Migration>> map = this.migrations;
            Integer valueOf = Integer.valueOf(i6);
            TreeMap<Integer, Migration> treeMap = map.get(valueOf);
            if (treeMap == null) {
                treeMap = new TreeMap<>();
                map.put(valueOf, treeMap);
            }
            TreeMap<Integer, Migration> treeMap2 = treeMap;
            if (treeMap2.containsKey(Integer.valueOf(i7))) {
                Objects.toString(treeMap2.get(Integer.valueOf(i7)));
                migration.toString();
            }
            treeMap2.put(Integer.valueOf(i7), migration);
        }

        @NotNull
        public Map<Integer, Map<Integer, Migration>> getMigrations() {
            return this.migrations;
        }

        @Nullable
        public final Pair<Map<Integer, Migration>, Iterable<Integer>> getSortedDescendingNodes$room_runtime_release(int i6) {
            TreeMap<Integer, Migration> treeMap = this.migrations.get(Integer.valueOf(i6));
            if (treeMap == null) {
                return null;
            }
            return o0.a(treeMap, treeMap.descendingKeySet());
        }

        @Nullable
        public final Pair<Map<Integer, Migration>, Iterable<Integer>> getSortedNodes$room_runtime_release(int i6) {
            TreeMap<Integer, Migration> treeMap = this.migrations.get(Integer.valueOf(i6));
            if (treeMap == null) {
                return null;
            }
            return o0.a(treeMap, treeMap.keySet());
        }

        public final boolean contains(int i6, int i7) {
            return MigrationUtil.contains(this, i6, i7);
        }

        @Nullable
        public List<Migration> findMigrationPath(int i6, int i7) {
            return MigrationUtil.findMigrationPath(this, i6, i7);
        }

        public void addMigrations(@NotNull Migration... migrations) {
            g0.p(migrations, "migrations");
            for (Migration migration : migrations) {
                addMigration(migration);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static abstract class PrepackagedDatabaseCallback {
        public void onOpenPrepackagedDatabase(@NotNull SupportSQLiteDatabase db) {
            g0.p(db, "db");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface QueryCallback {
        void onQuery(@NotNull String str, @NotNull List<? extends Object> list);
    }

    private final /* synthetic */ <T extends SupportSQLiteOpenHelper> T unwrapOpenHelper(SupportSQLiteOpenHelper supportSQLiteOpenHelper) {
        if (supportSQLiteOpenHelper == null) {
            return null;
        }
        while (true) {
            g0.y(3, ExifInterface.GPS_DIRECTION_TRUE);
            if (androidx.activity.k.a(supportSQLiteOpenHelper)) {
                return (T) supportSQLiteOpenHelper;
            }
            if (!(supportSQLiteOpenHelper instanceof DelegatingOpenHelper)) {
                return null;
            }
            supportSQLiteOpenHelper = (T) ((DelegatingOpenHelper) supportSQLiteOpenHelper).getDelegate();
        }
    }

    @WorkerThread
    public abstract void clearAllTables();

    @NotNull
    protected abstract InvalidationTracker createInvalidationTracker();

    @Deprecated(message = "No longer called by generated implementation")
    @Nullable
    public <T> T getTypeConverter(@NotNull Class<T> klass) {
        g0.p(klass, "klass");
        return (T) this.typeConverters.get(l3.a.i(klass));
    }

    @Deprecated(message = "No longer called by generated")
    protected void internalInitInvalidationTracker(@NotNull SupportSQLiteDatabase db) {
        g0.p(db, "db");
        internalInitInvalidationTracker(new SupportSQLiteConnection(db));
    }

    @JvmOverloads
    @NotNull
    public final Cursor query(@NotNull SupportSQLiteQuery query) {
        g0.p(query, "query");
        return query$default(this, query, null, 2, null);
    }

    public void runInTransaction(@NotNull final Runnable body) {
        g0.p(body, "body");
        runInTransaction(new Function0() { // from class: androidx.room.j
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                n1 runInTransaction$lambda$10;
                runInTransaction$lambda$10 = RoomDatabase.runInTransaction$lambda$10(body);
                return runInTransaction$lambda$10;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 beginTransaction$lambda$8(RoomDatabase roomDatabase, SupportSQLiteDatabase it) {
        g0.p(it, "it");
        roomDatabase.internalBeginTransaction();
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SupportSQLiteOpenHelper createConnectionManager$lambda$1(RoomDatabase roomDatabase, DatabaseConfiguration config) {
        g0.p(config, "config");
        return roomDatabase.createOpenHelper(config);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 endTransaction$lambda$9(RoomDatabase roomDatabase, SupportSQLiteDatabase it) {
        g0.p(it, "it");
        roomDatabase.internalEndTransaction();
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onClosed() {
        r0 r0Var = this.coroutineScope;
        RoomConnectionManager roomConnectionManager = null;
        if (r0Var == null) {
            g0.S("coroutineScope");
            r0Var = null;
        }
        s0.f(r0Var, null, 1, null);
        getInvalidationTracker().stop$room_runtime_release();
        RoomConnectionManager roomConnectionManager2 = this.connectionManager;
        if (roomConnectionManager2 == null) {
            g0.S("connectionManager");
        } else {
            roomConnectionManager = roomConnectionManager2;
        }
        roomConnectionManager.close();
    }

    public static /* synthetic */ Cursor query$default(RoomDatabase roomDatabase, SupportSQLiteQuery supportSQLiteQuery, CancellationSignal cancellationSignal, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: query");
        }
        if ((i6 & 2) != 0) {
            cancellationSignal = null;
        }
        return roomDatabase.query(supportSQLiteQuery, cancellationSignal);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object runInTransaction$lambda$12(Function0 function0, SQLiteConnection it) {
        g0.p(it, "it");
        return function0.invoke();
    }

    public final void addTypeConverter$room_runtime_release(@NotNull kotlin.reflect.d<?> kclass, @NotNull Object converter) {
        g0.p(kclass, "kclass");
        g0.p(converter, "converter");
        this.typeConverters.put(kclass, converter);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void assertNotMainThread() {
        if (!this.allowMainThreadQueries && isMainThread$room_runtime_release()) {
            throw new IllegalStateException("Cannot access database on the main thread since it may potentially lock the UI for a long period of time.");
        }
    }

    public void close() {
        this.closeBarrier.close$room_runtime_release();
    }

    @NotNull
    public SupportSQLiteStatement compileStatement(@NotNull String sql) {
        g0.p(sql, "sql");
        assertNotMainThread();
        assertNotSuspendingTransaction();
        return getOpenHelper().getWritableDatabase().compileStatement(sql);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @NotNull
    public List<Migration> createAutoMigrations(@NotNull Map<kotlin.reflect.d<? extends AutoMigrationSpec>, ? extends AutoMigrationSpec> autoMigrationSpecs) {
        g0.p(autoMigrationSpecs, "autoMigrationSpecs");
        LinkedHashMap linkedHashMap = new LinkedHashMap(i1.j(autoMigrationSpecs.size()));
        Iterator<T> it = autoMigrationSpecs.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(l3.a.e((kotlin.reflect.d) entry.getKey()), entry.getValue());
        }
        return getAutoMigrations(linkedHashMap);
    }

    @NotNull
    public final RoomConnectionManager createConnectionManager$room_runtime_release(@NotNull DatabaseConfiguration configuration) {
        RoomOpenDelegate roomOpenDelegate;
        g0.p(configuration, "configuration");
        try {
            RoomOpenDelegateMarker createOpenDelegate = createOpenDelegate();
            g0.n(createOpenDelegate, "null cannot be cast to non-null type androidx.room.RoomOpenDelegate");
            roomOpenDelegate = (RoomOpenDelegate) createOpenDelegate;
        } catch (NotImplementedError unused) {
            roomOpenDelegate = null;
        }
        return roomOpenDelegate == null ? new RoomConnectionManager(configuration, (Function1<? super DatabaseConfiguration, ? extends SupportSQLiteOpenHelper>) new Function1() { // from class: androidx.room.n
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                SupportSQLiteOpenHelper createConnectionManager$lambda$1;
                createConnectionManager$lambda$1 = RoomDatabase.createConnectionManager$lambda$1(RoomDatabase.this, (DatabaseConfiguration) obj);
                return createConnectionManager$lambda$1;
            }
        }) : new RoomConnectionManager(configuration, roomOpenDelegate);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @NotNull
    protected RoomOpenDelegateMarker createOpenDelegate() {
        throw new NotImplementedError(null, 1, null);
    }

    @Deprecated(message = "No longer implemented by generated")
    @NotNull
    protected SupportSQLiteOpenHelper createOpenHelper(@NotNull DatabaseConfiguration config) {
        g0.p(config, "config");
        throw new NotImplementedError(null, 1, null);
    }

    @Deprecated(message = "endTransaction() is deprecated", replaceWith = @ReplaceWith(expression = "runInTransaction(Runnable)", imports = {}))
    public void endTransaction() {
        AutoCloser autoCloser = this.autoCloser;
        if (autoCloser == null) {
            internalEndTransaction();
        } else {
            autoCloser.executeRefCountingFunction(new Function1() { // from class: androidx.room.k
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    n1 endTransaction$lambda$9;
                    endTransaction$lambda$9 = RoomDatabase.endTransaction$lambda$9(RoomDatabase.this, (SupportSQLiteDatabase) obj);
                    return endTransaction$lambda$9;
                }
            });
        }
    }

    @JvmSuppressWildcards
    @NotNull
    @Deprecated(message = "No longer implemented by generated")
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public List<Migration> getAutoMigrations(@NotNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
        g0.p(autoMigrationSpecs, "autoMigrationSpecs");
        return f0.J();
    }

    @NotNull
    public final CloseBarrier getCloseBarrier$room_runtime_release() {
        return this.closeBarrier;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @NotNull
    public final r0 getCoroutineScope() {
        r0 r0Var = this.coroutineScope;
        if (r0Var != null) {
            return r0Var;
        }
        g0.S("coroutineScope");
        return null;
    }

    @NotNull
    public InvalidationTracker getInvalidationTracker() {
        InvalidationTracker invalidationTracker = this.internalTracker;
        if (invalidationTracker != null) {
            return invalidationTracker;
        }
        g0.S("internalTracker");
        return null;
    }

    @NotNull
    public SupportSQLiteOpenHelper getOpenHelper() {
        RoomConnectionManager roomConnectionManager = this.connectionManager;
        if (roomConnectionManager == null) {
            g0.S("connectionManager");
            roomConnectionManager = null;
        }
        SupportSQLiteOpenHelper supportOpenHelper$room_runtime_release = roomConnectionManager.getSupportOpenHelper$room_runtime_release();
        if (supportOpenHelper$room_runtime_release != null) {
            return supportOpenHelper$room_runtime_release;
        }
        throw new IllegalStateException("Cannot return a SupportSQLiteOpenHelper since no SupportSQLiteOpenHelper.Factory was configured with Room.");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @NotNull
    public final kotlin.coroutines.i getQueryContext() {
        r0 r0Var = this.coroutineScope;
        if (r0Var == null) {
            g0.S("coroutineScope");
            r0Var = null;
        }
        return r0Var.getCoroutineContext();
    }

    @NotNull
    public Executor getQueryExecutor() {
        Executor executor = this.internalQueryExecutor;
        if (executor != null) {
            return executor;
        }
        g0.S("internalQueryExecutor");
        return null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @NotNull
    public final ThreadLocal<Integer> getSuspendingTransactionId() {
        return this.suspendingTransactionId;
    }

    @NotNull
    public final kotlin.coroutines.i getTransactionContext$room_runtime_release() {
        kotlin.coroutines.i iVar = this.transactionContext;
        if (iVar != null) {
            return iVar;
        }
        g0.S("transactionContext");
        return null;
    }

    @NotNull
    public Executor getTransactionExecutor() {
        Executor executor = this.internalTransactionExecutor;
        if (executor != null) {
            return executor;
        }
        g0.S("internalTransactionExecutor");
        return null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @NotNull
    public final <T> T getTypeConverter(@NotNull kotlin.reflect.d<T> klass) {
        g0.p(klass, "klass");
        T t5 = (T) this.typeConverters.get(klass);
        g0.n(t5, "null cannot be cast to non-null type T of androidx.room.RoomDatabase.getTypeConverter");
        return t5;
    }

    public final boolean getUseTempTrackingTable$room_runtime_release() {
        return this.useTempTrackingTable;
    }

    public final boolean inCompatibilityMode$room_runtime_release() {
        RoomConnectionManager roomConnectionManager = this.connectionManager;
        if (roomConnectionManager == null) {
            g0.S("connectionManager");
            roomConnectionManager = null;
        }
        return roomConnectionManager.getSupportOpenHelper$room_runtime_release() != null;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0160 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x010d A[LOOP:0: B:45:0x010d->B:49:0x0116, LOOP_START, PHI: r0
  0x010d: PHI (r0v29 androidx.sqlite.db.SupportSQLiteOpenHelper) = (r0v28 androidx.sqlite.db.SupportSQLiteOpenHelper), (r0v31 androidx.sqlite.db.SupportSQLiteOpenHelper) binds: [B:26:0x0109, B:49:0x0116] A[DONT_GENERATE, DONT_INLINE]] */
    @androidx.annotation.CallSuper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void init(@org.jetbrains.annotations.NotNull androidx.room.DatabaseConfiguration r8) {
        /*
            Method dump skipped, instructions count: 353
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.RoomDatabase.init(androidx.room.DatabaseConfiguration):void");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    protected final void internalInitInvalidationTracker(@NotNull SQLiteConnection connection) {
        g0.p(connection, "connection");
        getInvalidationTracker().internalInit$room_runtime_release(connection);
    }

    public boolean isOpen() {
        AutoCloser autoCloser = this.autoCloser;
        if (autoCloser != null) {
            return autoCloser.isActive();
        }
        RoomConnectionManager roomConnectionManager = this.connectionManager;
        if (roomConnectionManager == null) {
            g0.S("connectionManager");
            roomConnectionManager = null;
        }
        return roomConnectionManager.isSupportDatabaseOpen();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final boolean isOpenInternal() {
        RoomConnectionManager roomConnectionManager = this.connectionManager;
        if (roomConnectionManager == null) {
            g0.S("connectionManager");
            roomConnectionManager = null;
        }
        return roomConnectionManager.isSupportDatabaseOpen();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected final void performClear(boolean z5, @NotNull String... tableNames) {
        g0.p(tableNames, "tableNames");
        assertNotMainThread();
        assertNotSuspendingTransaction();
        RunBlockingUninterruptible_androidKt.runBlockingUninterruptible(new RoomDatabase$performClear$1(this, z5, tableNames, null));
    }

    @NotNull
    public Cursor query(@NotNull String query, @Nullable Object[] objArr) {
        g0.p(query, "query");
        assertNotMainThread();
        assertNotSuspendingTransaction();
        return getOpenHelper().getWritableDatabase().query(new SimpleSQLiteQuery(query, objArr));
    }

    public <V> V runInTransaction(@NotNull final Callable<V> body) {
        g0.p(body, "body");
        return (V) runInTransaction(new Function0() { // from class: androidx.room.l
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Object call;
                call = body.call();
                return call;
            }
        });
    }

    public final void setUseTempTrackingTable$room_runtime_release(boolean z5) {
        this.useTempTrackingTable = z5;
    }

    @Nullable
    public final <R> Object useConnection$room_runtime_release(boolean z5, @NotNull Function2<? super Transactor, ? super kotlin.coroutines.e<? super R>, ? extends Object> function2, @NotNull kotlin.coroutines.e<? super R> eVar) {
        RoomConnectionManager roomConnectionManager = this.connectionManager;
        if (roomConnectionManager == null) {
            g0.S("connectionManager");
            roomConnectionManager = null;
        }
        return roomConnectionManager.useConnection(z5, function2, eVar);
    }

    private final void internalBeginTransaction() {
        assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = getOpenHelper().getWritableDatabase();
        if (!writableDatabase.inTransaction()) {
            getInvalidationTracker().syncBlocking$room_runtime_release();
        }
        if (writableDatabase.isWriteAheadLoggingEnabled()) {
            writableDatabase.beginTransactionNonExclusive();
        } else {
            writableDatabase.beginTransaction();
        }
    }

    private final void internalEndTransaction() {
        getOpenHelper().getWritableDatabase().endTransaction();
        if (!inTransaction()) {
            getInvalidationTracker().refreshVersionsAsync();
        }
    }

    private final <T> T runInTransaction(final Function0<? extends T> function0) {
        if (inCompatibilityMode$room_runtime_release()) {
            beginTransaction();
            try {
                T invoke = function0.invoke();
                setTransactionSuccessful();
                return invoke;
            } finally {
                endTransaction();
            }
        }
        return (T) DBUtil.performBlocking(this, false, true, new Function1() { // from class: androidx.room.m
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Object runInTransaction$lambda$12;
                runInTransaction$lambda$12 = RoomDatabase.runInTransaction$lambda$12(Function0.this, (SQLiteConnection) obj);
                return runInTransaction$lambda$12;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 runInTransaction$lambda$10(Runnable runnable) {
        runnable.run();
        return n1.f44123a;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void assertNotSuspendingTransaction() {
        if (inCompatibilityMode$room_runtime_release() && !inTransaction() && this.suspendingTransactionId.get() != null) {
            throw new IllegalStateException("Cannot access database on a different coroutine context inherited from a suspending transaction.");
        }
    }

    @Deprecated(message = "beginTransaction() is deprecated", replaceWith = @ReplaceWith(expression = "runInTransaction(Runnable)", imports = {}))
    public void beginTransaction() {
        assertNotMainThread();
        AutoCloser autoCloser = this.autoCloser;
        if (autoCloser == null) {
            internalBeginTransaction();
        } else {
            autoCloser.executeRefCountingFunction(new Function1() { // from class: androidx.room.o
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    n1 beginTransaction$lambda$8;
                    beginTransaction$lambda$8 = RoomDatabase.beginTransaction$lambda$8(RoomDatabase.this, (SupportSQLiteDatabase) obj);
                    return beginTransaction$lambda$8;
                }
            });
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @NotNull
    public Set<kotlin.reflect.d<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecClasses() {
        Set<Class<? extends AutoMigrationSpec>> requiredAutoMigrationSpecs = getRequiredAutoMigrationSpecs();
        ArrayList arrayList = new ArrayList(f0.d0(requiredAutoMigrationSpecs, 10));
        Iterator<T> it = requiredAutoMigrationSpecs.iterator();
        while (it.hasNext()) {
            arrayList.add(l3.a.i((Class) it.next()));
        }
        return f0.f6(arrayList);
    }

    @Deprecated(message = "No longer implemented by generated")
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @NotNull
    public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
        return u1.k();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @NotNull
    protected Map<kotlin.reflect.d<?>, List<kotlin.reflect.d<?>>> getRequiredTypeConverterClasses() {
        Set<Map.Entry<Class<?>, List<Class<?>>>> entrySet = getRequiredTypeConverters().entrySet();
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.t.u(i1.j(f0.d0(entrySet, 10)), 16));
        Iterator<T> it = entrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Class cls = (Class) entry.getKey();
            List list = (List) entry.getValue();
            kotlin.reflect.d i6 = l3.a.i(cls);
            List list2 = list;
            ArrayList arrayList = new ArrayList(f0.d0(list2, 10));
            Iterator it2 = list2.iterator();
            while (it2.hasNext()) {
                arrayList.add(l3.a.i((Class) it2.next()));
            }
            Pair a6 = o0.a(i6, arrayList);
            linkedHashMap.put(a6.getFirst(), a6.getSecond());
        }
        return linkedHashMap;
    }

    @NotNull
    public final Map<kotlin.reflect.d<?>, List<kotlin.reflect.d<?>>> getRequiredTypeConverterClassesMap$room_runtime_release() {
        return getRequiredTypeConverterClasses();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @NotNull
    protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        return i1.z();
    }

    public boolean inTransaction() {
        if (isOpenInternal() && getOpenHelper().getWritableDatabase().inTransaction()) {
            return true;
        }
        return false;
    }

    public final boolean isMainThread$room_runtime_release() {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            return true;
        }
        return false;
    }

    @Deprecated(message = "setTransactionSuccessful() is deprecated", replaceWith = @ReplaceWith(expression = "runInTransaction(Runnable)", imports = {}))
    public void setTransactionSuccessful() {
        getOpenHelper().getWritableDatabase().setTransactionSuccessful();
    }

    @JvmOverloads
    @NotNull
    public Cursor query(@NotNull SupportSQLiteQuery query, @Nullable CancellationSignal cancellationSignal) {
        g0.p(query, "query");
        assertNotMainThread();
        assertNotSuspendingTransaction();
        if (cancellationSignal != null) {
            return getOpenHelper().getWritableDatabase().query(query, cancellationSignal);
        }
        return getOpenHelper().getWritableDatabase().query(query);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "This property is always null and will be removed in a future version.")
    protected static /* synthetic */ void getMCallbacks$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "This property is always null and will be removed in a future version.")
    protected static /* synthetic */ void getMDatabase$annotations() {
    }
}
