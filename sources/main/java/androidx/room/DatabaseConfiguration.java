package androidx.room;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.RestrictTo;
import androidx.room.RoomDatabase;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.util.MigrationUtil;
import androidx.sqlite.SQLiteDriver;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.collections.f0;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public class DatabaseConfiguration {

    @JvmField
    public final boolean allowDestructiveMigrationForAllTables;

    @JvmField
    public final boolean allowDestructiveMigrationOnDowngrade;

    @JvmField
    public final boolean allowMainThreadQueries;

    @JvmField
    @NotNull
    public final List<AutoMigrationSpec> autoMigrationSpecs;

    @JvmField
    @Nullable
    public final List<RoomDatabase.Callback> callbacks;

    @JvmField
    @NotNull
    public final Context context;

    @JvmField
    @Nullable
    public final String copyFromAssetPath;

    @JvmField
    @Nullable
    public final File copyFromFile;

    @JvmField
    @Nullable
    public final Callable<InputStream> copyFromInputStream;

    @JvmField
    @NotNull
    public final RoomDatabase.JournalMode journalMode;

    @JvmField
    @NotNull
    public final RoomDatabase.MigrationContainer migrationContainer;

    @Nullable
    private final Set<Integer> migrationNotRequiredFrom;

    @JvmField
    public final boolean multiInstanceInvalidation;

    @JvmField
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Nullable
    public final Intent multiInstanceInvalidationServiceIntent;

    @JvmField
    @Nullable
    public final String name;

    @JvmField
    @Nullable
    public final RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback;

    @JvmField
    @Nullable
    public final kotlin.coroutines.i queryCoroutineContext;

    @JvmField
    @NotNull
    public final Executor queryExecutor;

    @JvmField
    public final boolean requireMigration;

    @JvmField
    @Nullable
    public final SQLiteDriver sqliteDriver;

    @JvmField
    @Nullable
    public final SupportSQLiteOpenHelper.Factory sqliteOpenHelperFactory;

    @JvmField
    @NotNull
    public final Executor transactionExecutor;

    @JvmField
    @NotNull
    public final List<Object> typeConverters;
    private boolean useTempTrackingTable;

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"LambdaLast"})
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public DatabaseConfiguration(@NotNull Context context, @Nullable String str, @Nullable SupportSQLiteOpenHelper.Factory factory, @NotNull RoomDatabase.MigrationContainer migrationContainer, @Nullable List<? extends RoomDatabase.Callback> list, boolean z5, @NotNull RoomDatabase.JournalMode journalMode, @NotNull Executor queryExecutor, @NotNull Executor transactionExecutor, @Nullable Intent intent, boolean z6, boolean z7, @Nullable Set<Integer> set, @Nullable String str2, @Nullable File file, @Nullable Callable<InputStream> callable, @Nullable RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback, @NotNull List<? extends Object> typeConverters, @NotNull List<? extends AutoMigrationSpec> autoMigrationSpecs, boolean z8, @Nullable SQLiteDriver sQLiteDriver, @Nullable kotlin.coroutines.i iVar) {
        g0.p(context, "context");
        g0.p(migrationContainer, "migrationContainer");
        g0.p(journalMode, "journalMode");
        g0.p(queryExecutor, "queryExecutor");
        g0.p(transactionExecutor, "transactionExecutor");
        g0.p(typeConverters, "typeConverters");
        g0.p(autoMigrationSpecs, "autoMigrationSpecs");
        this.context = context;
        this.name = str;
        this.sqliteOpenHelperFactory = factory;
        this.migrationContainer = migrationContainer;
        this.callbacks = list;
        this.allowMainThreadQueries = z5;
        this.journalMode = journalMode;
        this.queryExecutor = queryExecutor;
        this.transactionExecutor = transactionExecutor;
        this.multiInstanceInvalidationServiceIntent = intent;
        this.requireMigration = z6;
        this.allowDestructiveMigrationOnDowngrade = z7;
        this.migrationNotRequiredFrom = set;
        this.copyFromAssetPath = str2;
        this.copyFromFile = file;
        this.copyFromInputStream = callable;
        this.prepackagedDatabaseCallback = prepackagedDatabaseCallback;
        this.typeConverters = typeConverters;
        this.autoMigrationSpecs = autoMigrationSpecs;
        this.allowDestructiveMigrationForAllTables = z8;
        this.sqliteDriver = sQLiteDriver;
        this.queryCoroutineContext = iVar;
        this.multiInstanceInvalidation = intent != null;
        this.useTempTrackingTable = true;
    }

    public static /* synthetic */ DatabaseConfiguration copy$default(DatabaseConfiguration databaseConfiguration, Context context, String str, SupportSQLiteOpenHelper.Factory factory, RoomDatabase.MigrationContainer migrationContainer, List list, boolean z5, RoomDatabase.JournalMode journalMode, Executor executor, Executor executor2, Intent intent, boolean z6, boolean z7, Set set, String str2, File file, Callable callable, RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback, List list2, List list3, boolean z8, SQLiteDriver sQLiteDriver, kotlin.coroutines.i iVar, int i6, Object obj) {
        kotlin.coroutines.i iVar2;
        SQLiteDriver sQLiteDriver2;
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: copy");
        }
        Context context2 = (i6 & 1) != 0 ? databaseConfiguration.context : context;
        String str3 = (i6 & 2) != 0 ? databaseConfiguration.name : str;
        SupportSQLiteOpenHelper.Factory factory2 = (i6 & 4) != 0 ? databaseConfiguration.sqliteOpenHelperFactory : factory;
        RoomDatabase.MigrationContainer migrationContainer2 = (i6 & 8) != 0 ? databaseConfiguration.migrationContainer : migrationContainer;
        List list4 = (i6 & 16) != 0 ? databaseConfiguration.callbacks : list;
        boolean z9 = (i6 & 32) != 0 ? databaseConfiguration.allowMainThreadQueries : z5;
        RoomDatabase.JournalMode journalMode2 = (i6 & 64) != 0 ? databaseConfiguration.journalMode : journalMode;
        Executor executor3 = (i6 & 128) != 0 ? databaseConfiguration.queryExecutor : executor;
        Executor executor4 = (i6 & 256) != 0 ? databaseConfiguration.transactionExecutor : executor2;
        Intent intent2 = (i6 & 512) != 0 ? databaseConfiguration.multiInstanceInvalidationServiceIntent : intent;
        boolean z10 = (i6 & 1024) != 0 ? databaseConfiguration.requireMigration : z6;
        boolean z11 = (i6 & 2048) != 0 ? databaseConfiguration.allowDestructiveMigrationOnDowngrade : z7;
        Set set2 = (i6 & 4096) != 0 ? databaseConfiguration.migrationNotRequiredFrom : set;
        String str4 = (i6 & 8192) != 0 ? databaseConfiguration.copyFromAssetPath : str2;
        Context context3 = context2;
        File file2 = (i6 & 16384) != 0 ? databaseConfiguration.copyFromFile : file;
        Callable callable2 = (i6 & 32768) != 0 ? databaseConfiguration.copyFromInputStream : callable;
        RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback2 = (i6 & 65536) != 0 ? databaseConfiguration.prepackagedDatabaseCallback : prepackagedDatabaseCallback;
        List list5 = (i6 & 131072) != 0 ? databaseConfiguration.typeConverters : list2;
        List list6 = (i6 & 262144) != 0 ? databaseConfiguration.autoMigrationSpecs : list3;
        boolean z12 = (i6 & 524288) != 0 ? databaseConfiguration.allowDestructiveMigrationForAllTables : z8;
        SQLiteDriver sQLiteDriver3 = (i6 & 1048576) != 0 ? databaseConfiguration.sqliteDriver : sQLiteDriver;
        if ((i6 & 2097152) != 0) {
            sQLiteDriver2 = sQLiteDriver3;
            iVar2 = databaseConfiguration.queryCoroutineContext;
        } else {
            iVar2 = iVar;
            sQLiteDriver2 = sQLiteDriver3;
        }
        return databaseConfiguration.copy(context3, str3, factory2, migrationContainer2, list4, z9, journalMode2, executor3, executor4, intent2, z10, z11, set2, str4, file2, callable2, prepackagedDatabaseCallback2, list5, list6, z12, sQLiteDriver2, iVar2);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @NotNull
    public final DatabaseConfiguration copy(@NotNull Context context, @Nullable String str, @Nullable SupportSQLiteOpenHelper.Factory factory, @NotNull RoomDatabase.MigrationContainer migrationContainer, @Nullable List<? extends RoomDatabase.Callback> list, boolean z5, @NotNull RoomDatabase.JournalMode journalMode, @NotNull Executor queryExecutor, @NotNull Executor transactionExecutor, @Nullable Intent intent, boolean z6, boolean z7, @Nullable Set<Integer> set, @Nullable String str2, @Nullable File file, @Nullable Callable<InputStream> callable, @Nullable RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback, @NotNull List<? extends Object> typeConverters, @NotNull List<? extends AutoMigrationSpec> autoMigrationSpecs, boolean z8, @Nullable SQLiteDriver sQLiteDriver, @Nullable kotlin.coroutines.i iVar) {
        g0.p(context, "context");
        g0.p(migrationContainer, "migrationContainer");
        g0.p(journalMode, "journalMode");
        g0.p(queryExecutor, "queryExecutor");
        g0.p(transactionExecutor, "transactionExecutor");
        g0.p(typeConverters, "typeConverters");
        g0.p(autoMigrationSpecs, "autoMigrationSpecs");
        return new DatabaseConfiguration(context, str, factory, migrationContainer, list, z5, journalMode, queryExecutor, transactionExecutor, intent, z6, z7, set, str2, file, callable, prepackagedDatabaseCallback, typeConverters, autoMigrationSpecs, z8, sQLiteDriver, iVar);
    }

    @Nullable
    public final Set<Integer> getMigrationNotRequiredFrom$room_runtime_release() {
        return this.migrationNotRequiredFrom;
    }

    public final boolean getUseTempTrackingTable$room_runtime_release() {
        return this.useTempTrackingTable;
    }

    @Deprecated(message = "Use [isMigrationRequired(int, int)] which takes\n      [allowDestructiveMigrationOnDowngrade] into account.", replaceWith = @ReplaceWith(expression = "isMigrationRequired(version, version + 1)", imports = {}))
    public boolean isMigrationRequiredFrom(int i6) {
        return isMigrationRequired(i6, i6 + 1);
    }

    public final void setUseTempTrackingTable$room_runtime_release(boolean z5) {
        this.useTempTrackingTable = z5;
    }

    public boolean isMigrationRequired(int i6, int i7) {
        return MigrationUtil.isMigrationRequired(this, i6, i7);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated(message = "This constructor is deprecated.")
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public DatabaseConfiguration(@NotNull Context context, @Nullable String str, @NotNull SupportSQLiteOpenHelper.Factory sqliteOpenHelperFactory, @NotNull RoomDatabase.MigrationContainer migrationContainer, @Nullable List<? extends RoomDatabase.Callback> list, boolean z5, @NotNull RoomDatabase.JournalMode journalMode, @NotNull Executor queryExecutor, boolean z6, @Nullable Set<Integer> set) {
        this(context, str, sqliteOpenHelperFactory, migrationContainer, list, z5, journalMode, queryExecutor, queryExecutor, null, z6, false, set, null, null, null, null, f0.J(), f0.J(), false, null, null);
        g0.p(context, "context");
        g0.p(sqliteOpenHelperFactory, "sqliteOpenHelperFactory");
        g0.p(migrationContainer, "migrationContainer");
        g0.p(journalMode, "journalMode");
        g0.p(queryExecutor, "queryExecutor");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated(message = "This constructor is deprecated.")
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public DatabaseConfiguration(@NotNull Context context, @Nullable String str, @NotNull SupportSQLiteOpenHelper.Factory sqliteOpenHelperFactory, @NotNull RoomDatabase.MigrationContainer migrationContainer, @Nullable List<? extends RoomDatabase.Callback> list, boolean z5, @NotNull RoomDatabase.JournalMode journalMode, @NotNull Executor queryExecutor, @NotNull Executor transactionExecutor, boolean z6, boolean z7, boolean z8, @Nullable Set<Integer> set) {
        this(context, str, sqliteOpenHelperFactory, migrationContainer, list, z5, journalMode, queryExecutor, transactionExecutor, z6 ? new Intent(context, (Class<?>) MultiInstanceInvalidationService.class) : null, z7, z8, set, null, null, null, null, f0.J(), f0.J(), false, null, null);
        g0.p(context, "context");
        g0.p(sqliteOpenHelperFactory, "sqliteOpenHelperFactory");
        g0.p(migrationContainer, "migrationContainer");
        g0.p(journalMode, "journalMode");
        g0.p(queryExecutor, "queryExecutor");
        g0.p(transactionExecutor, "transactionExecutor");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated(message = "This constructor is deprecated.")
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public DatabaseConfiguration(@NotNull Context context, @Nullable String str, @NotNull SupportSQLiteOpenHelper.Factory sqliteOpenHelperFactory, @NotNull RoomDatabase.MigrationContainer migrationContainer, @Nullable List<? extends RoomDatabase.Callback> list, boolean z5, @NotNull RoomDatabase.JournalMode journalMode, @NotNull Executor queryExecutor, @NotNull Executor transactionExecutor, boolean z6, boolean z7, boolean z8, @Nullable Set<Integer> set, @Nullable String str2, @Nullable File file) {
        this(context, str, sqliteOpenHelperFactory, migrationContainer, list, z5, journalMode, queryExecutor, transactionExecutor, z6 ? new Intent(context, (Class<?>) MultiInstanceInvalidationService.class) : null, z7, z8, set, str2, file, null, null, f0.J(), f0.J(), false, null, null);
        g0.p(context, "context");
        g0.p(sqliteOpenHelperFactory, "sqliteOpenHelperFactory");
        g0.p(migrationContainer, "migrationContainer");
        g0.p(journalMode, "journalMode");
        g0.p(queryExecutor, "queryExecutor");
        g0.p(transactionExecutor, "transactionExecutor");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated(message = "This constructor is deprecated.")
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public DatabaseConfiguration(@NotNull Context context, @Nullable String str, @NotNull SupportSQLiteOpenHelper.Factory sqliteOpenHelperFactory, @NotNull RoomDatabase.MigrationContainer migrationContainer, @Nullable List<? extends RoomDatabase.Callback> list, boolean z5, @NotNull RoomDatabase.JournalMode journalMode, @NotNull Executor queryExecutor, @NotNull Executor transactionExecutor, boolean z6, boolean z7, boolean z8, @Nullable Set<Integer> set, @Nullable String str2, @Nullable File file, @Nullable Callable<InputStream> callable) {
        this(context, str, sqliteOpenHelperFactory, migrationContainer, list, z5, journalMode, queryExecutor, transactionExecutor, z6 ? new Intent(context, (Class<?>) MultiInstanceInvalidationService.class) : null, z7, z8, set, str2, file, callable, null, f0.J(), f0.J(), false, null, null);
        g0.p(context, "context");
        g0.p(sqliteOpenHelperFactory, "sqliteOpenHelperFactory");
        g0.p(migrationContainer, "migrationContainer");
        g0.p(journalMode, "journalMode");
        g0.p(queryExecutor, "queryExecutor");
        g0.p(transactionExecutor, "transactionExecutor");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated(message = "This constructor is deprecated.")
    @SuppressLint({"LambdaLast"})
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public DatabaseConfiguration(@NotNull Context context, @Nullable String str, @NotNull SupportSQLiteOpenHelper.Factory sqliteOpenHelperFactory, @NotNull RoomDatabase.MigrationContainer migrationContainer, @Nullable List<? extends RoomDatabase.Callback> list, boolean z5, @NotNull RoomDatabase.JournalMode journalMode, @NotNull Executor queryExecutor, @NotNull Executor transactionExecutor, boolean z6, boolean z7, boolean z8, @Nullable Set<Integer> set, @Nullable String str2, @Nullable File file, @Nullable Callable<InputStream> callable, @Nullable RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback) {
        this(context, str, sqliteOpenHelperFactory, migrationContainer, list, z5, journalMode, queryExecutor, transactionExecutor, z6 ? new Intent(context, (Class<?>) MultiInstanceInvalidationService.class) : null, z7, z8, set, str2, file, callable, prepackagedDatabaseCallback, f0.J(), f0.J(), false, null, null);
        g0.p(context, "context");
        g0.p(sqliteOpenHelperFactory, "sqliteOpenHelperFactory");
        g0.p(migrationContainer, "migrationContainer");
        g0.p(journalMode, "journalMode");
        g0.p(queryExecutor, "queryExecutor");
        g0.p(transactionExecutor, "transactionExecutor");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated(message = "This constructor is deprecated.")
    @SuppressLint({"LambdaLast"})
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public DatabaseConfiguration(@NotNull Context context, @Nullable String str, @NotNull SupportSQLiteOpenHelper.Factory sqliteOpenHelperFactory, @NotNull RoomDatabase.MigrationContainer migrationContainer, @Nullable List<? extends RoomDatabase.Callback> list, boolean z5, @NotNull RoomDatabase.JournalMode journalMode, @NotNull Executor queryExecutor, @NotNull Executor transactionExecutor, boolean z6, boolean z7, boolean z8, @Nullable Set<Integer> set, @Nullable String str2, @Nullable File file, @Nullable Callable<InputStream> callable, @Nullable RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback, @NotNull List<? extends Object> typeConverters) {
        this(context, str, sqliteOpenHelperFactory, migrationContainer, list, z5, journalMode, queryExecutor, transactionExecutor, z6 ? new Intent(context, (Class<?>) MultiInstanceInvalidationService.class) : null, z7, z8, set, str2, file, callable, prepackagedDatabaseCallback, typeConverters, f0.J(), false, null, null);
        g0.p(context, "context");
        g0.p(sqliteOpenHelperFactory, "sqliteOpenHelperFactory");
        g0.p(migrationContainer, "migrationContainer");
        g0.p(journalMode, "journalMode");
        g0.p(queryExecutor, "queryExecutor");
        g0.p(transactionExecutor, "transactionExecutor");
        g0.p(typeConverters, "typeConverters");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated(message = "This constructor is deprecated.")
    @SuppressLint({"LambdaLast"})
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public DatabaseConfiguration(@NotNull Context context, @Nullable String str, @NotNull SupportSQLiteOpenHelper.Factory sqliteOpenHelperFactory, @NotNull RoomDatabase.MigrationContainer migrationContainer, @Nullable List<? extends RoomDatabase.Callback> list, boolean z5, @NotNull RoomDatabase.JournalMode journalMode, @NotNull Executor queryExecutor, @NotNull Executor transactionExecutor, boolean z6, boolean z7, boolean z8, @Nullable Set<Integer> set, @Nullable String str2, @Nullable File file, @Nullable Callable<InputStream> callable, @Nullable RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback, @NotNull List<? extends Object> typeConverters, @NotNull List<? extends AutoMigrationSpec> autoMigrationSpecs) {
        this(context, str, sqliteOpenHelperFactory, migrationContainer, list, z5, journalMode, queryExecutor, transactionExecutor, z6 ? new Intent(context, (Class<?>) MultiInstanceInvalidationService.class) : null, z7, z8, set, str2, file, callable, null, typeConverters, autoMigrationSpecs, false, null, null);
        g0.p(context, "context");
        g0.p(sqliteOpenHelperFactory, "sqliteOpenHelperFactory");
        g0.p(migrationContainer, "migrationContainer");
        g0.p(journalMode, "journalMode");
        g0.p(queryExecutor, "queryExecutor");
        g0.p(transactionExecutor, "transactionExecutor");
        g0.p(typeConverters, "typeConverters");
        g0.p(autoMigrationSpecs, "autoMigrationSpecs");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated(message = "This constructor is deprecated.")
    @SuppressLint({"LambdaLast"})
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public DatabaseConfiguration(@NotNull Context context, @Nullable String str, @NotNull SupportSQLiteOpenHelper.Factory sqliteOpenHelperFactory, @NotNull RoomDatabase.MigrationContainer migrationContainer, @Nullable List<? extends RoomDatabase.Callback> list, boolean z5, @NotNull RoomDatabase.JournalMode journalMode, @NotNull Executor queryExecutor, @NotNull Executor transactionExecutor, @Nullable Intent intent, boolean z6, boolean z7, @Nullable Set<Integer> set, @Nullable String str2, @Nullable File file, @Nullable Callable<InputStream> callable, @Nullable RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback, @NotNull List<? extends Object> typeConverters, @NotNull List<? extends AutoMigrationSpec> autoMigrationSpecs) {
        this(context, str, sqliteOpenHelperFactory, migrationContainer, list, z5, journalMode, queryExecutor, transactionExecutor, intent, z6, z7, set, str2, file, callable, null, typeConverters, autoMigrationSpecs, false, null, null);
        g0.p(context, "context");
        g0.p(sqliteOpenHelperFactory, "sqliteOpenHelperFactory");
        g0.p(migrationContainer, "migrationContainer");
        g0.p(journalMode, "journalMode");
        g0.p(queryExecutor, "queryExecutor");
        g0.p(transactionExecutor, "transactionExecutor");
        g0.p(typeConverters, "typeConverters");
        g0.p(autoMigrationSpecs, "autoMigrationSpecs");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated(message = "This constructor is deprecated.")
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public DatabaseConfiguration(@NotNull Context context, @Nullable String str, @NotNull SupportSQLiteOpenHelper.Factory sqliteOpenHelperFactory, @NotNull RoomDatabase.MigrationContainer migrationContainer, @Nullable List<? extends RoomDatabase.Callback> list, boolean z5, @NotNull RoomDatabase.JournalMode journalMode, @NotNull Executor queryExecutor, @NotNull Executor transactionExecutor, @Nullable Intent intent, boolean z6, boolean z7, @Nullable Set<Integer> set, @Nullable String str2, @Nullable File file, @Nullable Callable<InputStream> callable, @Nullable RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback, @NotNull List<? extends Object> typeConverters, @NotNull List<? extends AutoMigrationSpec> autoMigrationSpecs, boolean z8) {
        this(context, str, sqliteOpenHelperFactory, migrationContainer, list, z5, journalMode, queryExecutor, transactionExecutor, intent, z6, z7, set, str2, file, callable, null, typeConverters, autoMigrationSpecs, z8, null, null);
        g0.p(context, "context");
        g0.p(sqliteOpenHelperFactory, "sqliteOpenHelperFactory");
        g0.p(migrationContainer, "migrationContainer");
        g0.p(journalMode, "journalMode");
        g0.p(queryExecutor, "queryExecutor");
        g0.p(transactionExecutor, "transactionExecutor");
        g0.p(typeConverters, "typeConverters");
        g0.p(autoMigrationSpecs, "autoMigrationSpecs");
    }
}
