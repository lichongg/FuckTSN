package androidx.room;

import androidx.room.BaseRoomConnectionManager;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenDelegate;
import androidx.room.coroutines.AndroidSQLiteDriverConnectionPool;
import androidx.room.coroutines.ConnectionPool;
import androidx.room.coroutines.ConnectionPoolKt;
import androidx.room.driver.SupportSQLiteConnection;
import androidx.room.driver.SupportSQLiteConnectionPool;
import androidx.room.driver.SupportSQLiteDriver;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteDriver;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.driver.AndroidSQLiteDriver;
import java.util.List;
import kotlin.collections.f0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import net.sqlcipher.database.SQLiteDatabase;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class RoomConnectionManager extends BaseRoomConnectionManager {

    @NotNull
    private final List<RoomDatabase.Callback> callbacks;

    @NotNull
    private final DatabaseConfiguration configuration;

    @NotNull
    private final ConnectionPool connectionPool;

    @NotNull
    private final RoomOpenDelegate openDelegate;

    @Nullable
    private SupportSQLiteDatabase supportDatabase;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class NoOpOpenDelegate extends RoomOpenDelegate {
        public NoOpOpenDelegate() {
            super(-1, "", "");
        }

        @Override // androidx.room.RoomOpenDelegate
        public void createAllTables(@NotNull SQLiteConnection connection) {
            g0.p(connection, "connection");
            throw new IllegalStateException("NOP delegate should never be called");
        }

        @Override // androidx.room.RoomOpenDelegate
        public void dropAllTables(@NotNull SQLiteConnection connection) {
            g0.p(connection, "connection");
            throw new IllegalStateException("NOP delegate should never be called");
        }

        @Override // androidx.room.RoomOpenDelegate
        public void onCreate(@NotNull SQLiteConnection connection) {
            g0.p(connection, "connection");
            throw new IllegalStateException("NOP delegate should never be called");
        }

        @Override // androidx.room.RoomOpenDelegate
        public void onOpen(@NotNull SQLiteConnection connection) {
            g0.p(connection, "connection");
            throw new IllegalStateException("NOP delegate should never be called");
        }

        @Override // androidx.room.RoomOpenDelegate
        public void onPostMigrate(@NotNull SQLiteConnection connection) {
            g0.p(connection, "connection");
            throw new IllegalStateException("NOP delegate should never be called");
        }

        @Override // androidx.room.RoomOpenDelegate
        public void onPreMigrate(@NotNull SQLiteConnection connection) {
            g0.p(connection, "connection");
            throw new IllegalStateException("NOP delegate should never be called");
        }

        @Override // androidx.room.RoomOpenDelegate
        @NotNull
        public RoomOpenDelegate.ValidationResult onValidateSchema(@NotNull SQLiteConnection connection) {
            g0.p(connection, "connection");
            throw new IllegalStateException("NOP delegate should never be called");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public final class SupportOpenHelperCallback extends SupportSQLiteOpenHelper.Callback {
        public SupportOpenHelperCallback(int i6) {
            super(i6);
        }

        @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
        public void onCreate(@NotNull SupportSQLiteDatabase db) {
            g0.p(db, "db");
            RoomConnectionManager.this.onCreate(new SupportSQLiteConnection(db));
        }

        @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
        public void onDowngrade(@NotNull SupportSQLiteDatabase db, int i6, int i7) {
            g0.p(db, "db");
            onUpgrade(db, i6, i7);
        }

        @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
        public void onOpen(@NotNull SupportSQLiteDatabase db) {
            g0.p(db, "db");
            RoomConnectionManager.this.onOpen(new SupportSQLiteConnection(db));
            RoomConnectionManager.this.supportDatabase = db;
        }

        @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
        public void onUpgrade(@NotNull SupportSQLiteDatabase db, int i6, int i7) {
            g0.p(db, "db");
            RoomConnectionManager.this.onMigrate(new SupportSQLiteConnection(db), i6, i7);
        }
    }

    public RoomConnectionManager(@NotNull DatabaseConfiguration config, @NotNull RoomOpenDelegate openDelegate) {
        ConnectionPool newSingleConnectionPool;
        g0.p(config, "config");
        g0.p(openDelegate, "openDelegate");
        this.configuration = config;
        this.openDelegate = openDelegate;
        List<RoomDatabase.Callback> list = config.callbacks;
        this.callbacks = list == null ? f0.J() : list;
        SQLiteDriver sQLiteDriver = config.sqliteDriver;
        if (sQLiteDriver != null) {
            boolean z5 = sQLiteDriver instanceof AndroidSQLiteDriver;
            String str = SQLiteDatabase.MEMORY;
            if (z5) {
                BaseRoomConnectionManager.DriverWrapper driverWrapper = new BaseRoomConnectionManager.DriverWrapper(this, sQLiteDriver);
                String str2 = config.name;
                newSingleConnectionPool = new AndroidSQLiteDriverConnectionPool(driverWrapper, str2 != null ? str2 : str);
            } else {
                newSingleConnectionPool = config.name == null ? ConnectionPoolKt.newSingleConnectionPool(new BaseRoomConnectionManager.DriverWrapper(this, sQLiteDriver), SQLiteDatabase.MEMORY) : ConnectionPoolKt.newConnectionPool(new BaseRoomConnectionManager.DriverWrapper(this, sQLiteDriver), config.name, getMaxNumberOfReaders(config.journalMode), getMaxNumberOfWriters(config.journalMode));
            }
            this.connectionPool = newSingleConnectionPool;
        } else {
            if (config.sqliteOpenHelperFactory == null) {
                throw new IllegalArgumentException("SQLiteManager was constructed with both null driver and open helper factory!");
            }
            this.connectionPool = new SupportSQLiteConnectionPool(new SupportSQLiteDriver(config.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.Companion.builder(config.context).name(config.name).callback(new SupportOpenHelperCallback(openDelegate.getVersion())).build())));
        }
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 _init_$lambda$1(RoomConnectionManager roomConnectionManager, SupportSQLiteDatabase db) {
        g0.p(db, "db");
        roomConnectionManager.supportDatabase = db;
        return n1.f44123a;
    }

    private final DatabaseConfiguration installOnOpenCallback(DatabaseConfiguration databaseConfiguration, final Function1<? super SupportSQLiteDatabase, n1> function1) {
        List<RoomDatabase.Callback> list = databaseConfiguration.callbacks;
        if (list == null) {
            list = f0.J();
        }
        return DatabaseConfiguration.copy$default(databaseConfiguration, null, null, null, null, f0.J4(list, new RoomDatabase.Callback() { // from class: androidx.room.RoomConnectionManager$installOnOpenCallback$newCallbacks$1
            @Override // androidx.room.RoomDatabase.Callback
            public void onOpen(SupportSQLiteDatabase db) {
                g0.p(db, "db");
                function1.invoke(db);
            }
        }), false, null, null, null, null, false, false, null, null, null, null, null, null, null, false, null, null, 4194287, null);
    }

    public final void close() {
        this.connectionPool.close();
    }

    @Override // androidx.room.BaseRoomConnectionManager
    @NotNull
    protected List<RoomDatabase.Callback> getCallbacks() {
        return this.callbacks;
    }

    @Override // androidx.room.BaseRoomConnectionManager
    @NotNull
    protected DatabaseConfiguration getConfiguration() {
        return this.configuration;
    }

    @Override // androidx.room.BaseRoomConnectionManager
    @NotNull
    protected RoomOpenDelegate getOpenDelegate() {
        return this.openDelegate;
    }

    @Nullable
    public final SupportSQLiteOpenHelper getSupportOpenHelper$room_runtime_release() {
        SupportSQLiteDriver supportDriver$room_runtime_release;
        ConnectionPool connectionPool = this.connectionPool;
        SupportSQLiteConnectionPool supportSQLiteConnectionPool = connectionPool instanceof SupportSQLiteConnectionPool ? (SupportSQLiteConnectionPool) connectionPool : null;
        if (supportSQLiteConnectionPool == null || (supportDriver$room_runtime_release = supportSQLiteConnectionPool.getSupportDriver$room_runtime_release()) == null) {
            return null;
        }
        return supportDriver$room_runtime_release.getOpenHelper();
    }

    public final boolean isSupportDatabaseOpen() {
        SupportSQLiteDatabase supportSQLiteDatabase = this.supportDatabase;
        if (supportSQLiteDatabase != null) {
            return supportSQLiteDatabase.isOpen();
        }
        return false;
    }

    @Override // androidx.room.BaseRoomConnectionManager
    @NotNull
    public String resolveFileName$room_runtime_release(@NotNull String fileName) {
        g0.p(fileName, "fileName");
        if (g0.g(fileName, SQLiteDatabase.MEMORY)) {
            return fileName;
        }
        String absolutePath = getConfiguration().context.getDatabasePath(fileName).getAbsolutePath();
        g0.m(absolutePath);
        return absolutePath;
    }

    @Override // androidx.room.BaseRoomConnectionManager
    @Nullable
    public <R> Object useConnection(boolean z5, @NotNull Function2<? super Transactor, ? super kotlin.coroutines.e<? super R>, ? extends Object> function2, @NotNull kotlin.coroutines.e<? super R> eVar) {
        return this.connectionPool.useConnection(z5, function2, eVar);
    }

    private final void init() {
        boolean z5;
        if (getConfiguration().journalMode == RoomDatabase.JournalMode.WRITE_AHEAD_LOGGING) {
            z5 = true;
        } else {
            z5 = false;
        }
        SupportSQLiteOpenHelper supportOpenHelper$room_runtime_release = getSupportOpenHelper$room_runtime_release();
        if (supportOpenHelper$room_runtime_release != null) {
            supportOpenHelper$room_runtime_release.setWriteAheadLoggingEnabled(z5);
        }
    }

    public RoomConnectionManager(@NotNull DatabaseConfiguration config, @NotNull Function1<? super DatabaseConfiguration, ? extends SupportSQLiteOpenHelper> supportOpenHelperFactory) {
        g0.p(config, "config");
        g0.p(supportOpenHelperFactory, "supportOpenHelperFactory");
        this.configuration = config;
        this.openDelegate = new NoOpOpenDelegate();
        List<RoomDatabase.Callback> list = config.callbacks;
        this.callbacks = list == null ? f0.J() : list;
        this.connectionPool = new SupportSQLiteConnectionPool(new SupportSQLiteDriver(supportOpenHelperFactory.invoke(installOnOpenCallback(config, new Function1() { // from class: androidx.room.i
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 _init_$lambda$1;
                _init_$lambda$1 = RoomConnectionManager._init_$lambda$1(RoomConnectionManager.this, (SupportSQLiteDatabase) obj);
                return _init_$lambda$1;
            }
        }))));
        init();
    }
}
