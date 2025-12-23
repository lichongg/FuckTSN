package com.bxkj.student.v2.common.db;

import androidx.room.InvalidationTracker;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenDelegate;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import com.bxkj.student.v2.common.db.dao.EnvironmentDao_Impl;
import com.bxkj.student.v2.common.db.dao.FaceDao_Impl;
import com.bxkj.student.v2.common.db.dao.MenuDao_Impl;
import com.bxkj.student.v2.common.db.dao.SportsDao_Impl;
import com.bxkj.student.v2.common.db.dao.SportsSetDao_Impl;
import com.bxkj.student.v2.common.db.dao.g;
import com.bxkj.student.v2.common.db.dao.l;
import com.bxkj.student.v2.common.db.dao.q0;
import com.bxkj.student.v2.common.db.dao.x;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.f0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.o0;
import kotlin.s;
import kotlin.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class AppDatabase_Impl extends AppDatabase {

    /* renamed from: o, reason: collision with root package name */
    @NotNull
    private final s<x> f20700o = t.c(new Function0() { // from class: com.bxkj.student.v2.common.db.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            SportsDao_Impl H;
            H = AppDatabase_Impl.H(AppDatabase_Impl.this);
            return H;
        }
    });

    /* renamed from: p, reason: collision with root package name */
    @NotNull
    private final s<l> f20701p = t.c(new Function0() { // from class: com.bxkj.student.v2.common.db.b
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            MenuDao_Impl G;
            G = AppDatabase_Impl.G(AppDatabase_Impl.this);
            return G;
        }
    });

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    private final s<q0> f20702q = t.c(new Function0() { // from class: com.bxkj.student.v2.common.db.c
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            SportsSetDao_Impl I;
            I = AppDatabase_Impl.I(AppDatabase_Impl.this);
            return I;
        }
    });

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    private final s<g> f20703r = t.c(new Function0() { // from class: com.bxkj.student.v2.common.db.d
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            FaceDao_Impl F;
            F = AppDatabase_Impl.F(AppDatabase_Impl.this);
            return F;
        }
    });

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    private final s<com.bxkj.student.v2.common.db.dao.b> f20704s = t.c(new Function0() { // from class: com.bxkj.student.v2.common.db.e
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            EnvironmentDao_Impl E;
            E = AppDatabase_Impl.E(AppDatabase_Impl.this);
            return E;
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final EnvironmentDao_Impl E(AppDatabase_Impl appDatabase_Impl) {
        return new EnvironmentDao_Impl(appDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FaceDao_Impl F(AppDatabase_Impl appDatabase_Impl) {
        return new FaceDao_Impl(appDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MenuDao_Impl G(AppDatabase_Impl appDatabase_Impl) {
        return new MenuDao_Impl(appDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SportsDao_Impl H(AppDatabase_Impl appDatabase_Impl) {
        return new SportsDao_Impl(appDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SportsSetDao_Impl I(AppDatabase_Impl appDatabase_Impl) {
        return new SportsSetDao_Impl(appDatabase_Impl);
    }

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() {
        super.performClear(false, "sports", "menu", "sports_set", OptionalModuleUtils.FACE, "environment");
    }

    @Override // androidx.room.RoomDatabase
    @NotNull
    public List<Migration> createAutoMigrations(@NotNull Map<kotlin.reflect.d<? extends AutoMigrationSpec>, ? extends AutoMigrationSpec> autoMigrationSpecs) {
        g0.p(autoMigrationSpecs, "autoMigrationSpecs");
        return new ArrayList();
    }

    @Override // androidx.room.RoomDatabase
    @NotNull
    protected InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new LinkedHashMap(), new LinkedHashMap(), "sports", "menu", "sports_set", OptionalModuleUtils.FACE, "environment");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.room.RoomDatabase
    @NotNull
    public RoomOpenDelegate createOpenDelegate() {
        return new RoomOpenDelegate() { // from class: com.bxkj.student.v2.common.db.AppDatabase_Impl$createOpenDelegate$_openDelegate$1
            {
                super(14, "91f74cc0c49032adee345fdc0c13306f", "ca426420d3fc1be4bcbac83af4de4e8b");
            }

            @Override // androidx.room.RoomOpenDelegate
            public void createAllTables(SQLiteConnection connection) {
                g0.p(connection, "connection");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `sports` (`identify` TEXT NOT NULL, `userNumber` TEXT NOT NULL, `sportsType` TEXT NOT NULL, `sportsSet` TEXT NOT NULL, `startTime` TEXT NOT NULL, `endTime` TEXT NOT NULL, `countTime` TEXT NOT NULL, `distance` TEXT NOT NULL, `gpsDistance` TEXT NOT NULL, `latLngList` TEXT NOT NULL, `stepList` TEXT NOT NULL, `passLatLngList` TEXT NOT NULL, `isFaceOut` TEXT NOT NULL, `faceDetectCount` TEXT NOT NULL, `uploadType` TEXT NOT NULL, `isException` TEXT NOT NULL, `startFace` TEXT NOT NULL, `midFace` TEXT NOT NULL, `endFace` TEXT NOT NULL, `isValid` TEXT NOT NULL DEFAULT '0', `faceCheckingDistance` TEXT NOT NULL, `pauseLatLng` TEXT NOT NULL, `isOpenDevelop` TEXT NOT NULL DEFAULT '0', `confirmCount` INTEGER NOT NULL, PRIMARY KEY(`identify`))");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `menu` (`mkey` TEXT NOT NULL, `name` TEXT NOT NULL, `icon` TEXT NOT NULL, `iconS` TEXT NOT NULL, `isShow` TEXT NOT NULL, `isEnabled` TEXT NOT NULL, `isLogin` INTEGER NOT NULL, `linkUrl` TEXT NOT NULL, `type` TEXT NOT NULL, `lastUploadTime` TEXT NOT NULL, `sort` TEXT NOT NULL, `isShowIndex` TEXT NOT NULL, `homeSort` TEXT NOT NULL, `isShowH5Title` TEXT NOT NULL, PRIMARY KEY(`mkey`))");
                SQLite.execSQL(connection, "CREATE INDEX IF NOT EXISTS `index_menu_type` ON `menu` (`type`)");
                SQLite.execSQL(connection, "CREATE INDEX IF NOT EXISTS `index_menu_isShowIndex` ON `menu` (`isShowIndex`)");
                SQLite.execSQL(connection, "CREATE INDEX IF NOT EXISTS `index_menu_mkey` ON `menu` (`mkey`)");
                SQLite.execSQL(connection, "CREATE INDEX IF NOT EXISTS `index_menu_sort` ON `menu` (`sort`)");
                SQLite.execSQL(connection, "CREATE INDEX IF NOT EXISTS `index_menu_homeSort` ON `menu` (`homeSort`)");
                SQLite.execSQL(connection, "CREATE INDEX IF NOT EXISTS `index_menu_type_sort` ON `menu` (`type`, `sort`)");
                SQLite.execSQL(connection, "CREATE INDEX IF NOT EXISTS `index_menu_isShowIndex_homeSort` ON `menu` (`isShowIndex`, `homeSort`)");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `sports_set` (`userId` TEXT NOT NULL, `type` TEXT NOT NULL, `content` TEXT NOT NULL, PRIMARY KEY(`userId`, `type`))");
                SQLite.execSQL(connection, "CREATE UNIQUE INDEX IF NOT EXISTS `index_sports_set_userId_type` ON `sports_set` (`userId`, `type`)");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `face` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `identify` TEXT NOT NULL, `type` TEXT NOT NULL, `facePath` TEXT NOT NULL, `coordinates` TEXT, `timeStamp` TEXT)");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `environment` (`deviceId` TEXT NOT NULL, `safe` TEXT, `oppo` TEXT, PRIMARY KEY(`deviceId`))");
                SQLite.execSQL(connection, "CREATE UNIQUE INDEX IF NOT EXISTS `index_environment_deviceId` ON `environment` (`deviceId`)");
                SQLite.execSQL(connection, RoomMasterTable.CREATE_QUERY);
                SQLite.execSQL(connection, "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '91f74cc0c49032adee345fdc0c13306f')");
            }

            @Override // androidx.room.RoomOpenDelegate
            public void dropAllTables(SQLiteConnection connection) {
                g0.p(connection, "connection");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `sports`");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `menu`");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `sports_set`");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `face`");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `environment`");
            }

            @Override // androidx.room.RoomOpenDelegate
            public void onCreate(SQLiteConnection connection) {
                g0.p(connection, "connection");
            }

            @Override // androidx.room.RoomOpenDelegate
            public void onOpen(SQLiteConnection connection) {
                g0.p(connection, "connection");
                AppDatabase_Impl.this.internalInitInvalidationTracker(connection);
            }

            @Override // androidx.room.RoomOpenDelegate
            public void onPostMigrate(SQLiteConnection connection) {
                g0.p(connection, "connection");
            }

            @Override // androidx.room.RoomOpenDelegate
            public void onPreMigrate(SQLiteConnection connection) {
                g0.p(connection, "connection");
                DBUtil.dropFtsSyncTriggers(connection);
            }

            @Override // androidx.room.RoomOpenDelegate
            public RoomOpenDelegate.ValidationResult onValidateSchema(SQLiteConnection connection) {
                g0.p(connection, "connection");
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("identify", new TableInfo.Column("identify", "TEXT", true, 1, null, 1));
                linkedHashMap.put("userNumber", new TableInfo.Column("userNumber", "TEXT", true, 0, null, 1));
                linkedHashMap.put("sportsType", new TableInfo.Column("sportsType", "TEXT", true, 0, null, 1));
                linkedHashMap.put("sportsSet", new TableInfo.Column("sportsSet", "TEXT", true, 0, null, 1));
                linkedHashMap.put(AnalyticsConfig.RTD_START_TIME, new TableInfo.Column(AnalyticsConfig.RTD_START_TIME, "TEXT", true, 0, null, 1));
                linkedHashMap.put("endTime", new TableInfo.Column("endTime", "TEXT", true, 0, null, 1));
                linkedHashMap.put("countTime", new TableInfo.Column("countTime", "TEXT", true, 0, null, 1));
                linkedHashMap.put("distance", new TableInfo.Column("distance", "TEXT", true, 0, null, 1));
                linkedHashMap.put("gpsDistance", new TableInfo.Column("gpsDistance", "TEXT", true, 0, null, 1));
                linkedHashMap.put("latLngList", new TableInfo.Column("latLngList", "TEXT", true, 0, null, 1));
                linkedHashMap.put("stepList", new TableInfo.Column("stepList", "TEXT", true, 0, null, 1));
                linkedHashMap.put("passLatLngList", new TableInfo.Column("passLatLngList", "TEXT", true, 0, null, 1));
                linkedHashMap.put("isFaceOut", new TableInfo.Column("isFaceOut", "TEXT", true, 0, null, 1));
                linkedHashMap.put("faceDetectCount", new TableInfo.Column("faceDetectCount", "TEXT", true, 0, null, 1));
                linkedHashMap.put("uploadType", new TableInfo.Column("uploadType", "TEXT", true, 0, null, 1));
                linkedHashMap.put("isException", new TableInfo.Column("isException", "TEXT", true, 0, null, 1));
                linkedHashMap.put("startFace", new TableInfo.Column("startFace", "TEXT", true, 0, null, 1));
                linkedHashMap.put("midFace", new TableInfo.Column("midFace", "TEXT", true, 0, null, 1));
                linkedHashMap.put("endFace", new TableInfo.Column("endFace", "TEXT", true, 0, null, 1));
                linkedHashMap.put("isValid", new TableInfo.Column("isValid", "TEXT", true, 0, "'0'", 1));
                linkedHashMap.put("faceCheckingDistance", new TableInfo.Column("faceCheckingDistance", "TEXT", true, 0, null, 1));
                linkedHashMap.put("pauseLatLng", new TableInfo.Column("pauseLatLng", "TEXT", true, 0, null, 1));
                linkedHashMap.put("isOpenDevelop", new TableInfo.Column("isOpenDevelop", "TEXT", true, 0, "'0'", 1));
                linkedHashMap.put("confirmCount", new TableInfo.Column("confirmCount", "INTEGER", true, 0, null, 1));
                TableInfo tableInfo = new TableInfo("sports", linkedHashMap, new LinkedHashSet(), new LinkedHashSet());
                TableInfo.Companion companion = TableInfo.Companion;
                TableInfo read = companion.read(connection, "sports");
                if (!tableInfo.equals(read)) {
                    return new RoomOpenDelegate.ValidationResult(false, "sports(com.bxkj.student.v2.common.db.table.SportsDb).\n Expected:\n" + tableInfo + "\n Found:\n" + read);
                }
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                linkedHashMap2.put("mkey", new TableInfo.Column("mkey", "TEXT", true, 1, null, 1));
                linkedHashMap2.put(CommonNetImpl.NAME, new TableInfo.Column(CommonNetImpl.NAME, "TEXT", true, 0, null, 1));
                linkedHashMap2.put("icon", new TableInfo.Column("icon", "TEXT", true, 0, null, 1));
                linkedHashMap2.put("iconS", new TableInfo.Column("iconS", "TEXT", true, 0, null, 1));
                linkedHashMap2.put("isShow", new TableInfo.Column("isShow", "TEXT", true, 0, null, 1));
                linkedHashMap2.put("isEnabled", new TableInfo.Column("isEnabled", "TEXT", true, 0, null, 1));
                linkedHashMap2.put("isLogin", new TableInfo.Column("isLogin", "INTEGER", true, 0, null, 1));
                linkedHashMap2.put("linkUrl", new TableInfo.Column("linkUrl", "TEXT", true, 0, null, 1));
                linkedHashMap2.put("type", new TableInfo.Column("type", "TEXT", true, 0, null, 1));
                linkedHashMap2.put("lastUploadTime", new TableInfo.Column("lastUploadTime", "TEXT", true, 0, null, 1));
                linkedHashMap2.put("sort", new TableInfo.Column("sort", "TEXT", true, 0, null, 1));
                linkedHashMap2.put("isShowIndex", new TableInfo.Column("isShowIndex", "TEXT", true, 0, null, 1));
                linkedHashMap2.put("homeSort", new TableInfo.Column("homeSort", "TEXT", true, 0, null, 1));
                linkedHashMap2.put("isShowH5Title", new TableInfo.Column("isShowH5Title", "TEXT", true, 0, null, 1));
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                LinkedHashSet linkedHashSet2 = new LinkedHashSet();
                linkedHashSet2.add(new TableInfo.Index("index_menu_type", false, f0.l("type"), f0.l("ASC")));
                linkedHashSet2.add(new TableInfo.Index("index_menu_isShowIndex", false, f0.l("isShowIndex"), f0.l("ASC")));
                linkedHashSet2.add(new TableInfo.Index("index_menu_mkey", false, f0.l("mkey"), f0.l("ASC")));
                linkedHashSet2.add(new TableInfo.Index("index_menu_sort", false, f0.l("sort"), f0.l("ASC")));
                linkedHashSet2.add(new TableInfo.Index("index_menu_homeSort", false, f0.l("homeSort"), f0.l("ASC")));
                linkedHashSet2.add(new TableInfo.Index("index_menu_type_sort", false, f0.Q("type", "sort"), f0.Q("ASC", "ASC")));
                linkedHashSet2.add(new TableInfo.Index("index_menu_isShowIndex_homeSort", false, f0.Q("isShowIndex", "homeSort"), f0.Q("ASC", "ASC")));
                TableInfo tableInfo2 = new TableInfo("menu", linkedHashMap2, linkedHashSet, linkedHashSet2);
                TableInfo read2 = companion.read(connection, "menu");
                if (!tableInfo2.equals(read2)) {
                    return new RoomOpenDelegate.ValidationResult(false, "menu(com.bxkj.student.v2.common.db.table.MenuDb).\n Expected:\n" + tableInfo2 + "\n Found:\n" + read2);
                }
                LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                linkedHashMap3.put("userId", new TableInfo.Column("userId", "TEXT", true, 1, null, 1));
                linkedHashMap3.put("type", new TableInfo.Column("type", "TEXT", true, 2, null, 1));
                linkedHashMap3.put("content", new TableInfo.Column("content", "TEXT", true, 0, null, 1));
                LinkedHashSet linkedHashSet3 = new LinkedHashSet();
                LinkedHashSet linkedHashSet4 = new LinkedHashSet();
                linkedHashSet4.add(new TableInfo.Index("index_sports_set_userId_type", true, f0.Q("userId", "type"), f0.Q("ASC", "ASC")));
                TableInfo tableInfo3 = new TableInfo("sports_set", linkedHashMap3, linkedHashSet3, linkedHashSet4);
                TableInfo read3 = companion.read(connection, "sports_set");
                if (!tableInfo3.equals(read3)) {
                    return new RoomOpenDelegate.ValidationResult(false, "sports_set(com.bxkj.student.v2.common.db.table.SportsSetDb).\n Expected:\n" + tableInfo3 + "\n Found:\n" + read3);
                }
                LinkedHashMap linkedHashMap4 = new LinkedHashMap();
                linkedHashMap4.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                linkedHashMap4.put("identify", new TableInfo.Column("identify", "TEXT", true, 0, null, 1));
                linkedHashMap4.put("type", new TableInfo.Column("type", "TEXT", true, 0, null, 1));
                linkedHashMap4.put("facePath", new TableInfo.Column("facePath", "TEXT", true, 0, null, 1));
                linkedHashMap4.put("coordinates", new TableInfo.Column("coordinates", "TEXT", false, 0, null, 1));
                linkedHashMap4.put("timeStamp", new TableInfo.Column("timeStamp", "TEXT", false, 0, null, 1));
                TableInfo tableInfo4 = new TableInfo(OptionalModuleUtils.FACE, linkedHashMap4, new LinkedHashSet(), new LinkedHashSet());
                TableInfo read4 = companion.read(connection, OptionalModuleUtils.FACE);
                if (!tableInfo4.equals(read4)) {
                    return new RoomOpenDelegate.ValidationResult(false, "face(com.bxkj.student.v2.common.db.table.FaceDb).\n Expected:\n" + tableInfo4 + "\n Found:\n" + read4);
                }
                LinkedHashMap linkedHashMap5 = new LinkedHashMap();
                linkedHashMap5.put("deviceId", new TableInfo.Column("deviceId", "TEXT", true, 1, null, 1));
                linkedHashMap5.put("safe", new TableInfo.Column("safe", "TEXT", false, 0, null, 1));
                linkedHashMap5.put("oppo", new TableInfo.Column("oppo", "TEXT", false, 0, null, 1));
                LinkedHashSet linkedHashSet5 = new LinkedHashSet();
                LinkedHashSet linkedHashSet6 = new LinkedHashSet();
                linkedHashSet6.add(new TableInfo.Index("index_environment_deviceId", true, f0.l("deviceId"), f0.l("ASC")));
                TableInfo tableInfo5 = new TableInfo("environment", linkedHashMap5, linkedHashSet5, linkedHashSet6);
                TableInfo read5 = companion.read(connection, "environment");
                if (tableInfo5.equals(read5)) {
                    return new RoomOpenDelegate.ValidationResult(true, null);
                }
                return new RoomOpenDelegate.ValidationResult(false, "environment(com.bxkj.student.v2.common.db.table.EnvironmentDb).\n Expected:\n" + tableInfo5 + "\n Found:\n" + read5);
            }
        };
    }

    @Override // androidx.room.RoomDatabase
    @NotNull
    public Set<kotlin.reflect.d<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecClasses() {
        return new LinkedHashSet();
    }

    @Override // androidx.room.RoomDatabase
    @NotNull
    protected Map<kotlin.reflect.d<?>, List<kotlin.reflect.d<?>>> getRequiredTypeConverterClasses() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(o0.d(x.class), SportsDao_Impl.f20719c.a());
        linkedHashMap.put(o0.d(l.class), MenuDao_Impl.f20716c.a());
        linkedHashMap.put(o0.d(q0.class), SportsSetDao_Impl.f20722c.a());
        linkedHashMap.put(o0.d(g.class), FaceDao_Impl.f20713c.a());
        linkedHashMap.put(o0.d(com.bxkj.student.v2.common.db.dao.b.class), EnvironmentDao_Impl.f20710c.a());
        return linkedHashMap;
    }

    @Override // com.bxkj.student.v2.common.db.AppDatabase
    @Nullable
    public com.bxkj.student.v2.common.db.dao.b u() {
        return this.f20704s.getValue();
    }

    @Override // com.bxkj.student.v2.common.db.AppDatabase
    @Nullable
    public g v() {
        return this.f20703r.getValue();
    }

    @Override // com.bxkj.student.v2.common.db.AppDatabase
    @Nullable
    public l w() {
        return this.f20701p.getValue();
    }

    @Override // com.bxkj.student.v2.common.db.AppDatabase
    @Nullable
    public x x() {
        return this.f20700o.getValue();
    }

    @Override // com.bxkj.student.v2.common.db.AppDatabase
    @Nullable
    public q0 y() {
        return this.f20702q.getValue();
    }
}
