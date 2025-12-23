package com.bxkj.student.run.app.offline;

import androidx.room.InvalidationTracker;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenDelegate;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import com.bxkj.student.run.app.offline.dao.RunDao;
import com.bxkj.student.run.app.offline.dao.RunDao_Impl;
import com.umeng.analytics.AnalyticsConfig;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.o0;
import kotlin.reflect.d;
import kotlin.s;
import kotlin.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class RunDatabase_Impl extends RunDatabase {

    @NotNull
    private final s<RunDao> _runDao = t.c(new Function0() { // from class: com.bxkj.student.run.app.offline.b
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            RunDao_Impl _runDao$lambda$0;
            _runDao$lambda$0 = RunDatabase_Impl._runDao$lambda$0(RunDatabase_Impl.this);
            return _runDao$lambda$0;
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final RunDao_Impl _runDao$lambda$0(RunDatabase_Impl runDatabase_Impl) {
        return new RunDao_Impl(runDatabase_Impl);
    }

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() {
        super.performClear(false, "runDb");
    }

    @Override // androidx.room.RoomDatabase
    @NotNull
    public List<Migration> createAutoMigrations(@NotNull Map<d<? extends AutoMigrationSpec>, ? extends AutoMigrationSpec> autoMigrationSpecs) {
        g0.p(autoMigrationSpecs, "autoMigrationSpecs");
        return new ArrayList();
    }

    @Override // androidx.room.RoomDatabase
    @NotNull
    protected InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new LinkedHashMap(), new LinkedHashMap(), "runDb");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.room.RoomDatabase
    @NotNull
    public RoomOpenDelegate createOpenDelegate() {
        return new RoomOpenDelegate() { // from class: com.bxkj.student.run.app.offline.RunDatabase_Impl$createOpenDelegate$_openDelegate$1
            {
                super(2, "6086b83f23b783fbba0999d9978a4461", "5d22fe996d3088d7515d411b76facb7e");
            }

            @Override // androidx.room.RoomOpenDelegate
            public void createAllTables(SQLiteConnection connection) {
                g0.p(connection, "connection");
                SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `runDb` (`identify` TEXT NOT NULL, `userNumber` TEXT NOT NULL, `sportsType` TEXT NOT NULL, `sportsSet` TEXT NOT NULL, `startTime` TEXT NOT NULL, `endTime` TEXT NOT NULL, `countTime` TEXT NOT NULL, `distance` TEXT NOT NULL, `latLngList` TEXT NOT NULL, `stepList` TEXT NOT NULL, `passLatLngList` TEXT NOT NULL, `points` TEXT NOT NULL, `isFaceOut` TEXT NOT NULL, `faceDetectCount` TEXT NOT NULL, `uploadType` TEXT NOT NULL, PRIMARY KEY(`identify`))");
                SQLite.execSQL(connection, RoomMasterTable.CREATE_QUERY);
                SQLite.execSQL(connection, "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '6086b83f23b783fbba0999d9978a4461')");
            }

            @Override // androidx.room.RoomOpenDelegate
            public void dropAllTables(SQLiteConnection connection) {
                g0.p(connection, "connection");
                SQLite.execSQL(connection, "DROP TABLE IF EXISTS `runDb`");
            }

            @Override // androidx.room.RoomOpenDelegate
            public void onCreate(SQLiteConnection connection) {
                g0.p(connection, "connection");
            }

            @Override // androidx.room.RoomOpenDelegate
            public void onOpen(SQLiteConnection connection) {
                g0.p(connection, "connection");
                RunDatabase_Impl.this.internalInitInvalidationTracker(connection);
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
                linkedHashMap.put("latLngList", new TableInfo.Column("latLngList", "TEXT", true, 0, null, 1));
                linkedHashMap.put("stepList", new TableInfo.Column("stepList", "TEXT", true, 0, null, 1));
                linkedHashMap.put("passLatLngList", new TableInfo.Column("passLatLngList", "TEXT", true, 0, null, 1));
                linkedHashMap.put("points", new TableInfo.Column("points", "TEXT", true, 0, null, 1));
                linkedHashMap.put("isFaceOut", new TableInfo.Column("isFaceOut", "TEXT", true, 0, null, 1));
                linkedHashMap.put("faceDetectCount", new TableInfo.Column("faceDetectCount", "TEXT", true, 0, null, 1));
                linkedHashMap.put("uploadType", new TableInfo.Column("uploadType", "TEXT", true, 0, null, 1));
                TableInfo tableInfo = new TableInfo("runDb", linkedHashMap, new LinkedHashSet(), new LinkedHashSet());
                TableInfo read = TableInfo.Companion.read(connection, "runDb");
                if (tableInfo.equals(read)) {
                    return new RoomOpenDelegate.ValidationResult(true, null);
                }
                return new RoomOpenDelegate.ValidationResult(false, "runDb(com.bxkj.student.run.app.offline.table.RunDb).\n Expected:\n" + tableInfo + "\n Found:\n" + read);
            }
        };
    }

    @Override // androidx.room.RoomDatabase
    @NotNull
    public Set<d<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecClasses() {
        return new LinkedHashSet();
    }

    @Override // androidx.room.RoomDatabase
    @NotNull
    protected Map<d<?>, List<d<?>>> getRequiredTypeConverterClasses() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(o0.d(RunDao.class), RunDao_Impl.Companion.getRequiredConverters());
        return linkedHashMap;
    }

    @Override // com.bxkj.student.run.app.offline.RunDatabase
    @Nullable
    public RunDao runDao() {
        return this._runDao.getValue();
    }
}
