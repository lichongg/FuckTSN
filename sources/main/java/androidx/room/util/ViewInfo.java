package androidx.room.util;

import androidx.annotation.RestrictTo;
import androidx.room.driver.SupportSQLiteConnection;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.Deprecated;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: D:\Downloads\app\classes.dex */
public final class ViewInfo {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @JvmField
    @NotNull
    public final String name;

    @JvmField
    @Nullable
    public final String sql;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Companion {
        public /* synthetic */ Companion(v vVar) {
            this();
        }

        @Deprecated(message = "No longer used by generated code.")
        @JvmStatic
        @NotNull
        public final ViewInfo read(@NotNull SupportSQLiteDatabase database, @NotNull String viewName) {
            g0.p(database, "database");
            g0.p(viewName, "viewName");
            return read(new SupportSQLiteConnection(database), viewName);
        }

        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final ViewInfo read(@NotNull SQLiteConnection connection, @NotNull String viewName) {
            g0.p(connection, "connection");
            g0.p(viewName, "viewName");
            return SchemaInfoUtilKt.readViewInfo(connection, viewName);
        }
    }

    @JvmStatic
    @NotNull
    public static final ViewInfo read(@NotNull SQLiteConnection sQLiteConnection, @NotNull String str) {
        return Companion.read(sQLiteConnection, str);
    }

    public ViewInfo(@NotNull String name, @Nullable String str) {
        g0.p(name, "name");
        this.name = name;
        this.sql = str;
    }

    @Deprecated(message = "No longer used by generated code.")
    @JvmStatic
    @NotNull
    public static final ViewInfo read(@NotNull SupportSQLiteDatabase supportSQLiteDatabase, @NotNull String str) {
        return Companion.read(supportSQLiteDatabase, str);
    }

    public boolean equals(@Nullable Object obj) {
        return ViewInfoKt.equalsCommon(this, obj);
    }

    public int hashCode() {
        return ViewInfoKt.hashCodeCommon(this);
    }

    @NotNull
    public String toString() {
        return ViewInfoKt.toStringCommon(this);
    }
}
