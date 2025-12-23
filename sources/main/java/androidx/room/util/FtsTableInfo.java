package androidx.room.util;

import androidx.annotation.RestrictTo;
import androidx.room.driver.SupportSQLiteConnection;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.db.SupportSQLiteDatabase;
import java.util.Set;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: D:\Downloads\app\classes.dex */
public final class FtsTableInfo {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @JvmField
    @NotNull
    public final Set<String> columns;

    @JvmField
    @NotNull
    public final String name;

    @JvmField
    @NotNull
    public final Set<String> options;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Companion {
        public /* synthetic */ Companion(v vVar) {
            this();
        }

        @JvmStatic
        @NotNull
        public final FtsTableInfo read(@NotNull SupportSQLiteDatabase database, @NotNull String tableName) {
            g0.p(database, "database");
            g0.p(tableName, "tableName");
            return read(new SupportSQLiteConnection(database), tableName);
        }

        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final FtsTableInfo read(@NotNull SQLiteConnection connection, @NotNull String tableName) {
            g0.p(connection, "connection");
            g0.p(tableName, "tableName");
            return new FtsTableInfo(tableName, SchemaInfoUtilKt.readFtsColumns(connection, tableName), SchemaInfoUtilKt.readFtsOptions(connection, tableName));
        }
    }

    public FtsTableInfo(@NotNull String name, @NotNull Set<String> columns, @NotNull Set<String> options) {
        g0.p(name, "name");
        g0.p(columns, "columns");
        g0.p(options, "options");
        this.name = name;
        this.columns = columns;
        this.options = options;
    }

    @JvmStatic
    @NotNull
    public static final FtsTableInfo read(@NotNull SQLiteConnection sQLiteConnection, @NotNull String str) {
        return Companion.read(sQLiteConnection, str);
    }

    @JvmStatic
    @NotNull
    public static final FtsTableInfo read(@NotNull SupportSQLiteDatabase supportSQLiteDatabase, @NotNull String str) {
        return Companion.read(supportSQLiteDatabase, str);
    }

    public boolean equals(@Nullable Object obj) {
        return FtsTableInfoKt.equalsCommon(this, obj);
    }

    public int hashCode() {
        return FtsTableInfoKt.hashCodeCommon(this);
    }

    @NotNull
    public String toString() {
        return FtsTableInfoKt.toStringCommon(this);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FtsTableInfo(@NotNull String name, @NotNull Set<String> columns, @NotNull String createSql) {
        this(name, columns, SchemaInfoUtilKt.parseFtsOptions(createSql));
        g0.p(name, "name");
        g0.p(columns, "columns");
        g0.p(createSql, "createSql");
    }
}
