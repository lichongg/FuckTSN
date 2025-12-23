package androidx.room;

import android.database.Cursor;
import androidx.annotation.RestrictTo;
import androidx.room.RoomDatabase;
import androidx.room.driver.SupportSQLiteConnection;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Pair;
import kotlin.collections.f0;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Deprecated(message = "Replaced by RoomConnectionManager and no longer used in generated code.")
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
@SourceDebugExtension({"SMAP\nRoomOpenHelper.android.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RoomOpenHelper.android.kt\nandroidx/room/RoomOpenHelper\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 CursorUtil.android.kt\nandroidx/room/util/CursorUtil\n*L\n1#1,278:1\n1863#2,2:279\n1863#2,2:281\n1863#2,2:283\n1863#2,2:285\n146#3:287\n*S KotlinDebug\n*F\n+ 1 RoomOpenHelper.android.kt\nandroidx/room/RoomOpenHelper\n*L\n81#1:279,2\n90#1:281,2\n112#1:283,2\n135#1:285,2\n143#1:287\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
public class RoomOpenHelper extends SupportSQLiteOpenHelper.Callback {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @Nullable
    private final List<RoomDatabase.Callback> callbacks;

    @Nullable
    private DatabaseConfiguration configuration;

    @NotNull
    private final Delegate delegate;

    @NotNull
    private final String identityHash;

    @NotNull
    private final String legacyHash;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nRoomOpenHelper.android.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RoomOpenHelper.android.kt\nandroidx/room/RoomOpenHelper$Companion\n+ 2 CursorUtil.android.kt\nandroidx/room/util/CursorUtil\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,278:1\n146#2:279\n146#2:280\n146#2:281\n1863#3,2:282\n*S KotlinDebug\n*F\n+ 1 RoomOpenHelper.android.kt\nandroidx/room/RoomOpenHelper$Companion\n*L\n242#1:279\n249#1:280\n256#1:281\n268#1:282,2\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.v vVar) {
            this();
        }

        private Companion() {
        }

        public final void dropAllTables$room_runtime_release(@NotNull SupportSQLiteDatabase db) {
            g0.p(db, "db");
            Cursor query = db.query("SELECT name, type FROM sqlite_master WHERE type = 'table' OR type = 'view'");
            try {
                Cursor cursor = query;
                List j6 = f0.j();
                while (cursor.moveToNext()) {
                    String string = cursor.getString(0);
                    g0.m(string);
                    if (!kotlin.text.u.H2(string, "sqlite_", false, 2, null) && !g0.g(string, "android_metadata")) {
                        j6.add(o0.a(string, Boolean.valueOf(g0.g(cursor.getString(1), "view"))));
                    }
                }
                List<Pair> b6 = f0.b(j6);
                kotlin.io.b.a(query, null);
                for (Pair pair : b6) {
                    String str = (String) pair.component1();
                    if (((Boolean) pair.component2()).booleanValue()) {
                        db.execSQL("DROP VIEW IF EXISTS " + str);
                    } else {
                        db.execSQL("DROP TABLE IF EXISTS " + str);
                    }
                }
            } finally {
            }
        }

        public final boolean hasEmptySchema$room_runtime_release(@NotNull SupportSQLiteDatabase db) {
            g0.p(db, "db");
            Cursor query = db.query("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'");
            try {
                Cursor cursor = query;
                boolean z5 = false;
                if (cursor.moveToFirst()) {
                    if (cursor.getInt(0) == 0) {
                        z5 = true;
                    }
                }
                kotlin.io.b.a(query, null);
                return z5;
            } finally {
            }
        }

        public final boolean hasRoomMasterTable$room_runtime_release(@NotNull SupportSQLiteDatabase db) {
            g0.p(db, "db");
            Cursor query = db.query("SELECT 1 FROM sqlite_master WHERE type = 'table' AND name='room_master_table'");
            try {
                Cursor cursor = query;
                boolean z5 = false;
                if (cursor.moveToFirst()) {
                    if (cursor.getInt(0) != 0) {
                        z5 = true;
                    }
                }
                kotlin.io.b.a(query, null);
                return z5;
            } finally {
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @Deprecated(message = "Replaced by OpenDelegate  and no longer used in generated code.")
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static abstract class Delegate {

        @JvmField
        public final int version;

        public abstract void createAllTables(@NotNull SupportSQLiteDatabase supportSQLiteDatabase);

        public abstract void dropAllTables(@NotNull SupportSQLiteDatabase supportSQLiteDatabase);

        public abstract void onCreate(@NotNull SupportSQLiteDatabase supportSQLiteDatabase);

        public abstract void onOpen(@NotNull SupportSQLiteDatabase supportSQLiteDatabase);

        public void onPostMigrate(@NotNull SupportSQLiteDatabase db) {
            g0.p(db, "db");
        }

        public void onPreMigrate(@NotNull SupportSQLiteDatabase db) {
            g0.p(db, "db");
        }

        @NotNull
        public ValidationResult onValidateSchema(@NotNull SupportSQLiteDatabase db) {
            g0.p(db, "db");
            validateMigration(db);
            return new ValidationResult(true, null);
        }

        @Deprecated(message = "Use [onValidateSchema(SupportSQLiteDatabase)]")
        protected void validateMigration(@NotNull SupportSQLiteDatabase db) {
            g0.p(db, "db");
            throw new UnsupportedOperationException("validateMigration is deprecated");
        }

        public Delegate(int i6) {
            this.version = i6;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomOpenHelper(@NotNull DatabaseConfiguration configuration, @NotNull Delegate delegate, @NotNull String identityHash, @NotNull String legacyHash) {
        super(delegate.version);
        g0.p(configuration, "configuration");
        g0.p(delegate, "delegate");
        g0.p(identityHash, "identityHash");
        g0.p(legacyHash, "legacyHash");
        this.callbacks = configuration.callbacks;
        this.configuration = configuration;
        this.delegate = delegate;
        this.identityHash = identityHash;
        this.legacyHash = legacyHash;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @Deprecated(message = "Replaced by OpenDelegate.ValidationResult and no longer used in generated code.")
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static class ValidationResult {

        @JvmField
        @Nullable
        public final String expectedFoundMsg;

        @JvmField
        public final boolean isValid;

        public ValidationResult(boolean z5, @Nullable String str) {
            this.isValid = z5;
            this.expectedFoundMsg = str;
        }
    }

    private final void checkIdentity(SupportSQLiteDatabase supportSQLiteDatabase) {
        if (!Companion.hasRoomMasterTable$room_runtime_release(supportSQLiteDatabase)) {
            ValidationResult onValidateSchema = this.delegate.onValidateSchema(supportSQLiteDatabase);
            if (onValidateSchema.isValid) {
                this.delegate.onPostMigrate(supportSQLiteDatabase);
                updateIdentity(supportSQLiteDatabase);
                return;
            } else {
                throw new IllegalStateException("Pre-packaged database has an invalid schema: " + onValidateSchema.expectedFoundMsg);
            }
        }
        Cursor query = supportSQLiteDatabase.query(new SimpleSQLiteQuery(RoomMasterTable.READ_QUERY));
        try {
            Cursor cursor = query;
            String string = cursor.moveToFirst() ? cursor.getString(0) : null;
            kotlin.io.b.a(query, null);
            if (g0.g(this.identityHash, string) || g0.g(this.legacyHash, string)) {
                return;
            }
            throw new IllegalStateException("Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number. Expected identity hash: " + this.identityHash + ", found: " + string);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                kotlin.io.b.a(query, th);
                throw th2;
            }
        }
    }

    private final void createMasterTableIfNotExists(SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.execSQL(RoomMasterTable.CREATE_QUERY);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public void onConfigure(@NotNull SupportSQLiteDatabase db) {
        g0.p(db, "db");
        super.onConfigure(db);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public void onCreate(@NotNull SupportSQLiteDatabase db) {
        g0.p(db, "db");
        boolean hasEmptySchema$room_runtime_release = Companion.hasEmptySchema$room_runtime_release(db);
        this.delegate.createAllTables(db);
        if (!hasEmptySchema$room_runtime_release) {
            ValidationResult onValidateSchema = this.delegate.onValidateSchema(db);
            if (!onValidateSchema.isValid) {
                throw new IllegalStateException("Pre-packaged database has an invalid schema: " + onValidateSchema.expectedFoundMsg);
            }
        }
        updateIdentity(db);
        this.delegate.onCreate(db);
        List<RoomDatabase.Callback> list = this.callbacks;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                ((RoomDatabase.Callback) it.next()).onCreate(db);
            }
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public void onDowngrade(@NotNull SupportSQLiteDatabase db, int i6, int i7) {
        g0.p(db, "db");
        onUpgrade(db, i6, i7);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public void onOpen(@NotNull SupportSQLiteDatabase db) {
        g0.p(db, "db");
        super.onOpen(db);
        checkIdentity(db);
        this.delegate.onOpen(db);
        List<RoomDatabase.Callback> list = this.callbacks;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                ((RoomDatabase.Callback) it.next()).onOpen(db);
            }
        }
        this.configuration = null;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public void onUpgrade(@NotNull SupportSQLiteDatabase db, int i6, int i7) {
        List<Migration> findMigrationPath;
        g0.p(db, "db");
        DatabaseConfiguration databaseConfiguration = this.configuration;
        if (databaseConfiguration != null && (findMigrationPath = databaseConfiguration.migrationContainer.findMigrationPath(i6, i7)) != null) {
            this.delegate.onPreMigrate(db);
            Iterator<T> it = findMigrationPath.iterator();
            while (it.hasNext()) {
                ((Migration) it.next()).migrate(new SupportSQLiteConnection(db));
            }
            ValidationResult onValidateSchema = this.delegate.onValidateSchema(db);
            if (onValidateSchema.isValid) {
                this.delegate.onPostMigrate(db);
                updateIdentity(db);
                return;
            } else {
                throw new IllegalStateException("Migration didn't properly handle: " + onValidateSchema.expectedFoundMsg);
            }
        }
        DatabaseConfiguration databaseConfiguration2 = this.configuration;
        if (databaseConfiguration2 == null || databaseConfiguration2.isMigrationRequired(i6, i7)) {
            throw new IllegalStateException("A migration from " + i6 + " to " + i7 + " was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(Migration ...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* methods.");
        }
        if (databaseConfiguration2.allowDestructiveMigrationForAllTables) {
            Companion.dropAllTables$room_runtime_release(db);
        } else {
            this.delegate.dropAllTables(db);
        }
        List<RoomDatabase.Callback> list = this.callbacks;
        if (list != null) {
            Iterator<T> it2 = list.iterator();
            while (it2.hasNext()) {
                ((RoomDatabase.Callback) it2.next()).onDestructiveMigration(db);
            }
        }
        this.delegate.createAllTables(db);
    }

    private final void updateIdentity(SupportSQLiteDatabase supportSQLiteDatabase) {
        createMasterTableIfNotExists(supportSQLiteDatabase);
        supportSQLiteDatabase.execSQL(RoomMasterTable.createInsertQuery(this.identityHash));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RoomOpenHelper(@NotNull DatabaseConfiguration configuration, @NotNull Delegate delegate, @NotNull String legacyHash) {
        this(configuration, delegate, "", legacyHash);
        g0.p(configuration, "configuration");
        g0.p(delegate, "delegate");
        g0.p(legacyHash, "legacyHash");
    }
}
