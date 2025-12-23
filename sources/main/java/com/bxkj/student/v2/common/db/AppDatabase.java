package com.bxkj.student.v2.common.db;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bxkj.student.App;
import com.bxkj.student.v2.common.db.dao.g;
import com.bxkj.student.v2.common.db.dao.l;
import com.bxkj.student.v2.common.db.dao.q0;
import com.bxkj.student.v2.common.db.dao.x;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SupportFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Database(entities = {m0.d.class, m0.c.class, m0.e.class, m0.b.class, m0.a.class}, exportSchema = true, version = 14)
@SourceDebugExtension({"SMAP\nAppDatabase.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppDatabase.kt\ncom/bxkj/student/v2/common/db/AppDatabase\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,219:1\n1#2:220\n*E\n"})
/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class AppDatabase extends RoomDatabase {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private static AppDatabase f20687b;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f20686a = new a(null);

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final AppDatabase$Companion$MIGRATION_2_3$1 f20688c = new Migration() { // from class: com.bxkj.student.v2.common.db.AppDatabase$Companion$MIGRATION_2_3$1
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase database) {
            g0.p(database, "database");
            database.execSQL("CREATE TABLE IF NOT EXISTS `menu` (`mkey` TEXT NOT NULL, `name` TEXT NOT NULL, `icon` TEXT NOT NULL, `iconS` TEXT NOT NULL, `isShow` TEXT NOT NULL, `isEnabled` TEXT NOT NULL, `isLogin` INTEGER NOT NULL, `linkUrl` TEXT NOT NULL, `type` TEXT NOT NULL, `lastUploadTime` TEXT NOT NULL, `sort` TEXT NOT NULL, `isShowIndex` TEXT NOT NULL, `homeSort` TEXT NOT NULL, PRIMARY KEY(`mkey`))");
        }
    };

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final AppDatabase$Companion$MIGRATION_3_4$1 f20689d = new Migration() { // from class: com.bxkj.student.v2.common.db.AppDatabase$Companion$MIGRATION_3_4$1
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase database) {
            g0.p(database, "database");
            database.execSQL("ALTER  TABLE  `sports` ADD COLUMN  `isException` TEXT NOT NULL  DEFAULT ''");
            database.execSQL("ALTER  TABLE  `sports` ADD COLUMN  `startFace` TEXT NOT NULL  DEFAULT ''");
            database.execSQL("ALTER  TABLE  `sports` ADD COLUMN  `midFace` TEXT NOT NULL  DEFAULT ''");
            database.execSQL("ALTER  TABLE  `sports` ADD COLUMN  `endFace` TEXT NOT NULL  DEFAULT ''");
            database.execSQL("ALTER  TABLE  `sports` ADD COLUMN  `isValid` TEXT NOT NULL  DEFAULT '0'");
        }
    };

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final AppDatabase$Companion$MIGRATION_4_5$1 f20690e = new Migration() { // from class: com.bxkj.student.v2.common.db.AppDatabase$Companion$MIGRATION_4_5$1
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase database) {
            g0.p(database, "database");
            database.execSQL("ALTER  TABLE  `sports` ADD COLUMN  `gpsDistance` TEXT NOT NULL  DEFAULT ''");
        }
    };

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final AppDatabase$Companion$MIGRATION_5_6$1 f20691f = new Migration() { // from class: com.bxkj.student.v2.common.db.AppDatabase$Companion$MIGRATION_5_6$1
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase database) {
            g0.p(database, "database");
            database.execSQL("CREATE TABLE IF NOT EXISTS `face` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `identify` TEXT NOT NULL, `type` TEXT NOT NULL, `facePath` TEXT NOT NULL)");
        }
    };

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private static final AppDatabase$Companion$MIGRATION_6_7$1 f20692g = new Migration() { // from class: com.bxkj.student.v2.common.db.AppDatabase$Companion$MIGRATION_6_7$1
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase database) {
            g0.p(database, "database");
            database.execSQL("CREATE TABLE IF NOT EXISTS `sports_set` ( `userId` TEXT NOT NULL, `type` TEXT NOT NULL, `content` TEXT NOT NULL, PRIMARY KEY(`userId`, `type`),UNIQUE(`userId`, `type`))");
            database.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_sports_set_userId_type` ON `sports_set`(`userId`, `type`)");
        }
    };

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private static final AppDatabase$Companion$MIGRATION_7_8$1 f20693h = new Migration() { // from class: com.bxkj.student.v2.common.db.AppDatabase$Companion$MIGRATION_7_8$1
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase database) {
            g0.p(database, "database");
            database.execSQL("ALTER  TABLE  `sports` ADD COLUMN  `faceCheckingDistance` TEXT NOT NULL  DEFAULT '0.0'");
            database.execSQL("ALTER  TABLE  `sports` ADD COLUMN  `pauseLatLng` TEXT NOT NULL  DEFAULT ''");
        }
    };

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    private static final AppDatabase$Companion$MIGRATION_8_9$1 f20694i = new Migration() { // from class: com.bxkj.student.v2.common.db.AppDatabase$Companion$MIGRATION_8_9$1
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase database) {
            g0.p(database, "database");
            database.execSQL("ALTER  TABLE  `sports` ADD COLUMN  `isOpenDevelop` TEXT NOT NULL  DEFAULT '0'");
        }
    };

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    private static final AppDatabase$Companion$MIGRATION_9_10$1 f20695j = new Migration() { // from class: com.bxkj.student.v2.common.db.AppDatabase$Companion$MIGRATION_9_10$1
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase database) {
            g0.p(database, "database");
            database.execSQL("ALTER  TABLE  `sports` ADD COLUMN  `confirmCount` INTEGER NOT NULL  DEFAULT 0");
        }
    };

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    private static final AppDatabase$Companion$MIGRATION_10_11$1 f20696k = new Migration() { // from class: com.bxkj.student.v2.common.db.AppDatabase$Companion$MIGRATION_10_11$1
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase database) {
            g0.p(database, "database");
            database.execSQL("ALTER  TABLE  `menu` ADD COLUMN  `isShowH5Title` TEXT NOT NULL  DEFAULT '1'");
        }
    };

    /* renamed from: l, reason: collision with root package name */
    @NotNull
    private static final AppDatabase$Companion$MIGRATION_11_12$1 f20697l = new Migration() { // from class: com.bxkj.student.v2.common.db.AppDatabase$Companion$MIGRATION_11_12$1
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase database) {
            g0.p(database, "database");
            database.execSQL("ALTER  TABLE  `face` ADD COLUMN  `coordinates` TEXT   DEFAULT ''");
            database.execSQL("ALTER  TABLE  `face` ADD COLUMN  `timeStamp` TEXT   DEFAULT ''");
        }
    };

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    private static final AppDatabase$Companion$MIGRATION_12_13$1 f20698m = new Migration() { // from class: com.bxkj.student.v2.common.db.AppDatabase$Companion$MIGRATION_12_13$1
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase database) {
            g0.p(database, "database");
            database.execSQL("CREATE TABLE IF NOT EXISTS `environment` ( `deviceId` TEXT NOT NULL, `safe` TEXT DEFAULT '', `oppo` TEXT DEFAULT '', PRIMARY KEY(`deviceId`),UNIQUE(`deviceId`))");
            database.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_environment_deviceId` ON `environment`(`deviceId`)");
        }
    };

    /* renamed from: n, reason: collision with root package name */
    @NotNull
    private static final AppDatabase$Companion$MIGRATION_13_14$1 f20699n = new Migration() { // from class: com.bxkj.student.v2.common.db.AppDatabase$Companion$MIGRATION_13_14$1
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase database) {
            g0.p(database, "database");
            database.execSQL("CREATE INDEX IF NOT EXISTS `index_menu_type` ON `menu`(`type`)");
            database.execSQL("CREATE INDEX IF NOT EXISTS `index_menu_isShowIndex` ON `menu`(`isShowIndex`)");
            database.execSQL("CREATE INDEX IF NOT EXISTS `index_menu_mkey` ON `menu`(`mkey`)");
            database.execSQL("CREATE INDEX IF NOT EXISTS `index_menu_sort` ON `menu`(`sort`)");
            database.execSQL("CREATE INDEX IF NOT EXISTS `index_menu_homeSort` ON `menu`(`homeSort`)");
            database.execSQL("CREATE INDEX IF NOT EXISTS `index_menu_type_sort` ON `menu`(`type`, `sort`)");
            database.execSQL("CREATE INDEX IF NOT EXISTS `index_menu_isShowIndex_homeSort` ON `menu`(`isShowIndex`, `homeSort`)");
        }
    };

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nAppDatabase.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppDatabase.kt\ncom/bxkj/student/v2/common/db/AppDatabase$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,219:1\n1#2:220\n*E\n"})
    public static final class a {
        public /* synthetic */ a(v vVar) {
            this();
        }

        @NotNull
        public final AppDatabase b() {
            AppDatabase appDatabase;
            synchronized (this) {
                c0.b bVar = c0.b.f1042a;
                App.a aVar = App.f17573d;
                char[] charArray = bVar.k(aVar.a()).toCharArray();
                g0.o(charArray, "toCharArray(...)");
                byte[] bytes = SQLiteDatabase.getBytes(charArray);
                g0.o(bytes, "getBytes(...)");
                appDatabase = (AppDatabase) Room.databaseBuilder(aVar.a(), AppDatabase.class, "TSNStudent.db").openHelperFactory(new SupportFactory(bytes)).addMigrations(AppDatabase.f20688c).addMigrations(AppDatabase.f20689d).addMigrations(AppDatabase.f20690e).addMigrations(AppDatabase.f20691f).addMigrations(AppDatabase.f20692g).addMigrations(AppDatabase.f20693h).addMigrations(AppDatabase.f20694i).addMigrations(AppDatabase.f20695j).addMigrations(AppDatabase.f20696k).addMigrations(AppDatabase.f20697l).addMigrations(AppDatabase.f20698m).addMigrations(AppDatabase.f20699n).fallbackToDestructiveMigration().build();
            }
            return appDatabase;
        }

        private a() {
        }

        @NotNull
        public final AppDatabase a() {
            AppDatabase appDatabase = AppDatabase.f20687b;
            if (appDatabase == null) {
                AppDatabase b6 = b();
                a aVar = AppDatabase.f20686a;
                AppDatabase.f20687b = b6;
                return b6;
            }
            return appDatabase;
        }
    }

    @Nullable
    public abstract com.bxkj.student.v2.common.db.dao.b u();

    @Nullable
    public abstract g v();

    @Nullable
    public abstract l w();

    @Nullable
    public abstract x x();

    @Nullable
    public abstract q0 y();

    @Override // androidx.room.RoomDatabase
    public void close() {
        AppDatabase appDatabase = f20687b;
        if (appDatabase != null) {
            if (!isOpen()) {
                appDatabase = null;
            }
            if (appDatabase != null) {
                super.close();
                f20687b = null;
            }
        }
    }
}
