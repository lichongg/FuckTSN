package androidx.room;

import androidx.annotation.RestrictTo;
import androidx.room.BaseRoomConnectionManager;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenDelegate;
import androidx.room.concurrent.ExclusiveLock;
import androidx.room.migration.Migration;
import androidx.room.util.MigrationUtil;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteDriver;
import androidx.sqlite.SQLiteStatement;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.Result;
import kotlin.collections.f0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import kotlin.o0;
import net.sqlcipher.database.SQLiteDatabase;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@SourceDebugExtension({"SMAP\nRoomConnectionManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RoomConnectionManager.kt\nandroidx/room/BaseRoomConnectionManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,362:1\n1#2:363\n1863#3,2:364\n1863#3,2:366\n1863#3,2:368\n1863#3,2:370\n1863#3,2:372\n*S KotlinDebug\n*F\n+ 1 RoomConnectionManager.kt\nandroidx/room/BaseRoomConnectionManager\n*L\n209#1:364,2\n253#1:366,2\n342#1:368,2\n346#1:370,2\n350#1:372,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
public abstract class BaseRoomConnectionManager {
    public static final int BUSY_TIMEOUT_MS = 3000;

    @NotNull
    public static final Companion Companion = new Companion(null);
    private boolean isConfigured;
    private boolean isInitializing;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.v vVar) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    protected final class DriverWrapper implements SQLiteDriver {

        @NotNull
        private final SQLiteDriver actual;
        final /* synthetic */ BaseRoomConnectionManager this$0;

        public DriverWrapper(@NotNull BaseRoomConnectionManager baseRoomConnectionManager, SQLiteDriver actual) {
            g0.p(actual, "actual");
            this.this$0 = baseRoomConnectionManager;
            this.actual = actual;
        }

        private final SQLiteConnection openLocked(final String str) {
            ExclusiveLock exclusiveLock = new ExclusiveLock(str, (this.this$0.isConfigured || this.this$0.isInitializing || g0.g(str, SQLiteDatabase.MEMORY)) ? false : true);
            final BaseRoomConnectionManager baseRoomConnectionManager = this.this$0;
            return (SQLiteConnection) exclusiveLock.withLock(new Function0() { // from class: androidx.room.d
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    SQLiteConnection openLocked$lambda$1;
                    openLocked$lambda$1 = BaseRoomConnectionManager.DriverWrapper.openLocked$lambda$1(BaseRoomConnectionManager.this, this, str);
                    return openLocked$lambda$1;
                }
            }, new Function1() { // from class: androidx.room.BaseRoomConnectionManager$DriverWrapper$openLocked$2
                @Override // kotlin.jvm.functions.Function1
                public final Void invoke(Throwable error) {
                    g0.p(error, "error");
                    throw new IllegalStateException("Unable to open database '" + str + "'. Was a proper path / name used in Room's database builder?", error);
                }
            });
        }

        @Override // androidx.sqlite.SQLiteDriver
        @NotNull
        public SQLiteConnection open(@NotNull String fileName) {
            g0.p(fileName, "fileName");
            return openLocked(this.this$0.resolveFileName$room_runtime_release(fileName));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final SQLiteConnection openLocked$lambda$1(BaseRoomConnectionManager baseRoomConnectionManager, DriverWrapper driverWrapper, String str) {
            if (!baseRoomConnectionManager.isInitializing) {
                SQLiteConnection open = driverWrapper.actual.open(str);
                if (baseRoomConnectionManager.isConfigured) {
                    baseRoomConnectionManager.configurationConnection(open);
                    return open;
                }
                try {
                    baseRoomConnectionManager.isInitializing = true;
                    baseRoomConnectionManager.configureDatabase(open);
                    return open;
                } finally {
                    baseRoomConnectionManager.isInitializing = false;
                }
            }
            throw new IllegalStateException("Recursive database initialization detected. Did you try to use the database instance during initialization? Maybe in one of the callbacks?");
        }
    }

    @NotNull
    protected abstract List<RoomDatabase.Callback> getCallbacks();

    @NotNull
    protected abstract DatabaseConfiguration getConfiguration();

    @NotNull
    protected abstract RoomOpenDelegate getOpenDelegate();

    @Nullable
    public abstract <R> Object useConnection(boolean z5, @NotNull Function2<? super Transactor, ? super kotlin.coroutines.e<? super R>, ? extends Object> function2, @NotNull kotlin.coroutines.e<? super R> eVar);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RoomDatabase.JournalMode.values().length];
            try {
                iArr[RoomDatabase.JournalMode.TRUNCATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RoomDatabase.JournalMode.WRITE_AHEAD_LOGGING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final void configureBusyTimeout(SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("PRAGMA busy_timeout");
        try {
            prepare.step();
            long j6 = prepare.getLong(0);
            kotlin.jdk7.a.c(prepare, null);
            if (j6 < 3000) {
                SQLite.execSQL(sQLiteConnection, "PRAGMA busy_timeout = 3000");
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                kotlin.jdk7.a.c(prepare, th);
                throw th2;
            }
        }
    }

    private final void createMasterTableIfNotExists(SQLiteConnection sQLiteConnection) {
        SQLite.execSQL(sQLiteConnection, RoomMasterTable.CREATE_QUERY);
    }

    private final boolean hasEmptySchema(SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'");
        try {
            boolean z5 = false;
            if (prepare.step()) {
                if (prepare.getLong(0) == 0) {
                    z5 = true;
                }
            }
            kotlin.jdk7.a.c(prepare, null);
            return z5;
        } finally {
        }
    }

    private final boolean hasRoomMasterTable(SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("SELECT 1 FROM sqlite_master WHERE type = 'table' AND name = 'room_master_table'");
        try {
            boolean z5 = false;
            if (prepare.step()) {
                if (prepare.getLong(0) != 0) {
                    z5 = true;
                }
            }
            kotlin.jdk7.a.c(prepare, null);
            return z5;
        } finally {
        }
    }

    protected final int getMaxNumberOfReaders(@NotNull RoomDatabase.JournalMode journalMode) {
        g0.p(journalMode, "<this>");
        int i6 = WhenMappings.$EnumSwitchMapping$0[journalMode.ordinal()];
        if (i6 == 1) {
            return 1;
        }
        if (i6 == 2) {
            return 4;
        }
        throw new IllegalStateException(("Can't get max number of reader for journal mode '" + journalMode + '\'').toString());
    }

    protected final int getMaxNumberOfWriters(@NotNull RoomDatabase.JournalMode journalMode) {
        g0.p(journalMode, "<this>");
        int i6 = WhenMappings.$EnumSwitchMapping$0[journalMode.ordinal()];
        if (i6 == 1 || i6 == 2) {
            return 1;
        }
        throw new IllegalStateException(("Can't get max number of writers for journal mode '" + journalMode + '\'').toString());
    }

    protected final void onCreate(@NotNull SQLiteConnection connection) {
        g0.p(connection, "connection");
        boolean hasEmptySchema = hasEmptySchema(connection);
        getOpenDelegate().createAllTables(connection);
        if (!hasEmptySchema) {
            RoomOpenDelegate.ValidationResult onValidateSchema = getOpenDelegate().onValidateSchema(connection);
            if (!onValidateSchema.isValid) {
                throw new IllegalStateException(("Pre-packaged database has an invalid schema: " + onValidateSchema.expectedFoundMsg).toString());
            }
        }
        updateIdentity(connection);
        getOpenDelegate().onCreate(connection);
        invokeCreateCallback(connection);
    }

    protected final void onMigrate(@NotNull SQLiteConnection connection, int i6, int i7) {
        g0.p(connection, "connection");
        List<Migration> findMigrationPath = MigrationUtil.findMigrationPath(getConfiguration().migrationContainer, i6, i7);
        if (findMigrationPath == null) {
            if (!MigrationUtil.isMigrationRequired(getConfiguration(), i6, i7)) {
                dropAllTables(connection);
                invokeDestructiveMigrationCallback(connection);
                getOpenDelegate().createAllTables(connection);
                return;
            } else {
                throw new IllegalStateException(("A migration from " + i6 + " to " + i7 + " was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* functions.").toString());
            }
        }
        getOpenDelegate().onPreMigrate(connection);
        Iterator<T> it = findMigrationPath.iterator();
        while (it.hasNext()) {
            ((Migration) it.next()).migrate(connection);
        }
        RoomOpenDelegate.ValidationResult onValidateSchema = getOpenDelegate().onValidateSchema(connection);
        if (onValidateSchema.isValid) {
            getOpenDelegate().onPostMigrate(connection);
            updateIdentity(connection);
        } else {
            throw new IllegalStateException(("Migration didn't properly handle: " + onValidateSchema.expectedFoundMsg).toString());
        }
    }

    protected final void onOpen(@NotNull SQLiteConnection connection) {
        g0.p(connection, "connection");
        checkIdentity(connection);
        getOpenDelegate().onOpen(connection);
        invokeOpenCallback(connection);
        this.isConfigured = true;
    }

    @NotNull
    public String resolveFileName$room_runtime_release(@NotNull String fileName) {
        g0.p(fileName, "fileName");
        return fileName;
    }

    private final void checkIdentity(SQLiteConnection sQLiteConnection) {
        Object m130constructorimpl;
        RoomOpenDelegate.ValidationResult onValidateSchema;
        String str;
        if (hasRoomMasterTable(sQLiteConnection)) {
            SQLiteStatement prepare = sQLiteConnection.prepare(RoomMasterTable.READ_QUERY);
            try {
                if (prepare.step()) {
                    str = prepare.getText(0);
                } else {
                    str = null;
                }
                kotlin.jdk7.a.c(prepare, null);
                if (!g0.g(getOpenDelegate().getIdentityHash(), str) && !g0.g(getOpenDelegate().getLegacyIdentityHash(), str)) {
                    throw new IllegalStateException(("Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number. Expected identity hash: " + getOpenDelegate().getIdentityHash() + ", found: " + str).toString());
                }
                return;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    kotlin.jdk7.a.c(prepare, th);
                    throw th2;
                }
            }
        }
        SQLite.execSQL(sQLiteConnection, "BEGIN EXCLUSIVE TRANSACTION");
        try {
            Result.a aVar = Result.Companion;
            onValidateSchema = getOpenDelegate().onValidateSchema(sQLiteConnection);
        } catch (Throwable th3) {
            Result.a aVar2 = Result.Companion;
            m130constructorimpl = Result.m130constructorimpl(kotlin.g0.a(th3));
        }
        if (onValidateSchema.isValid) {
            getOpenDelegate().onPostMigrate(sQLiteConnection);
            updateIdentity(sQLiteConnection);
            m130constructorimpl = Result.m130constructorimpl(n1.f44123a);
            if (Result.m137isSuccessimpl(m130constructorimpl)) {
                SQLite.execSQL(sQLiteConnection, "END TRANSACTION");
            }
            Throwable m133exceptionOrNullimpl = Result.m133exceptionOrNullimpl(m130constructorimpl);
            if (m133exceptionOrNullimpl == null) {
                Result.m129boximpl(m130constructorimpl);
                return;
            } else {
                SQLite.execSQL(sQLiteConnection, "ROLLBACK TRANSACTION");
                throw m133exceptionOrNullimpl;
            }
        }
        throw new IllegalStateException(("Pre-packaged database has an invalid schema: " + onValidateSchema.expectedFoundMsg).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void configurationConnection(SQLiteConnection sQLiteConnection) {
        configureSynchronousFlag(sQLiteConnection);
        configureBusyTimeout(sQLiteConnection);
        getOpenDelegate().onOpen(sQLiteConnection);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void configureDatabase(SQLiteConnection sQLiteConnection) {
        Object m130constructorimpl;
        configureJournalMode(sQLiteConnection);
        configureSynchronousFlag(sQLiteConnection);
        configureBusyTimeout(sQLiteConnection);
        SQLiteStatement prepare = sQLiteConnection.prepare("PRAGMA user_version");
        try {
            prepare.step();
            int i6 = (int) prepare.getLong(0);
            kotlin.jdk7.a.c(prepare, null);
            if (i6 != getOpenDelegate().getVersion()) {
                SQLite.execSQL(sQLiteConnection, "BEGIN EXCLUSIVE TRANSACTION");
                try {
                    Result.a aVar = Result.Companion;
                    if (i6 == 0) {
                        onCreate(sQLiteConnection);
                    } else {
                        onMigrate(sQLiteConnection, i6, getOpenDelegate().getVersion());
                    }
                    SQLite.execSQL(sQLiteConnection, "PRAGMA user_version = " + getOpenDelegate().getVersion());
                    m130constructorimpl = Result.m130constructorimpl(n1.f44123a);
                } catch (Throwable th) {
                    Result.a aVar2 = Result.Companion;
                    m130constructorimpl = Result.m130constructorimpl(kotlin.g0.a(th));
                }
                if (Result.m137isSuccessimpl(m130constructorimpl)) {
                    SQLite.execSQL(sQLiteConnection, "END TRANSACTION");
                }
                Throwable m133exceptionOrNullimpl = Result.m133exceptionOrNullimpl(m130constructorimpl);
                if (m133exceptionOrNullimpl != null) {
                    SQLite.execSQL(sQLiteConnection, "ROLLBACK TRANSACTION");
                    throw m133exceptionOrNullimpl;
                }
            }
            onOpen(sQLiteConnection);
        } finally {
        }
    }

    private final void configureJournalMode(SQLiteConnection sQLiteConnection) {
        if (getConfiguration().journalMode == RoomDatabase.JournalMode.WRITE_AHEAD_LOGGING) {
            SQLite.execSQL(sQLiteConnection, "PRAGMA journal_mode = WAL");
        } else {
            SQLite.execSQL(sQLiteConnection, "PRAGMA journal_mode = TRUNCATE");
        }
    }

    private final void configureSynchronousFlag(SQLiteConnection sQLiteConnection) {
        if (getConfiguration().journalMode == RoomDatabase.JournalMode.WRITE_AHEAD_LOGGING) {
            SQLite.execSQL(sQLiteConnection, "PRAGMA synchronous = NORMAL");
        } else {
            SQLite.execSQL(sQLiteConnection, "PRAGMA synchronous = FULL");
        }
    }

    private final void dropAllTables(SQLiteConnection sQLiteConnection) {
        if (getConfiguration().allowDestructiveMigrationForAllTables) {
            SQLiteStatement prepare = sQLiteConnection.prepare("SELECT name, type FROM sqlite_master WHERE type = 'table' OR type = 'view'");
            try {
                List j6 = f0.j();
                while (prepare.step()) {
                    String text = prepare.getText(0);
                    if (!kotlin.text.u.H2(text, "sqlite_", false, 2, null) && !g0.g(text, "android_metadata")) {
                        j6.add(o0.a(text, Boolean.valueOf(g0.g(prepare.getText(1), "view"))));
                    }
                }
                List<Pair> b6 = f0.b(j6);
                kotlin.jdk7.a.c(prepare, null);
                for (Pair pair : b6) {
                    String str = (String) pair.component1();
                    if (((Boolean) pair.component2()).booleanValue()) {
                        SQLite.execSQL(sQLiteConnection, "DROP VIEW IF EXISTS " + str);
                    } else {
                        SQLite.execSQL(sQLiteConnection, "DROP TABLE IF EXISTS " + str);
                    }
                }
            } finally {
            }
        } else {
            getOpenDelegate().dropAllTables(sQLiteConnection);
        }
    }

    private final void invokeCreateCallback(SQLiteConnection sQLiteConnection) {
        Iterator<T> it = getCallbacks().iterator();
        while (it.hasNext()) {
            ((RoomDatabase.Callback) it.next()).onCreate(sQLiteConnection);
        }
    }

    private final void invokeDestructiveMigrationCallback(SQLiteConnection sQLiteConnection) {
        Iterator<T> it = getCallbacks().iterator();
        while (it.hasNext()) {
            ((RoomDatabase.Callback) it.next()).onDestructiveMigration(sQLiteConnection);
        }
    }

    private final void invokeOpenCallback(SQLiteConnection sQLiteConnection) {
        Iterator<T> it = getCallbacks().iterator();
        while (it.hasNext()) {
            ((RoomDatabase.Callback) it.next()).onOpen(sQLiteConnection);
        }
    }

    private final void updateIdentity(SQLiteConnection sQLiteConnection) {
        createMasterTableIfNotExists(sQLiteConnection);
        SQLite.execSQL(sQLiteConnection, RoomMasterTable.createInsertQuery(getOpenDelegate().getIdentityHash()));
    }
}
