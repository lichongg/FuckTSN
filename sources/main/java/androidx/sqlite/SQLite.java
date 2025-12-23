package androidx.sqlite;

import android.database.SQLException;
import kotlin.jdk7.a;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JvmName(name = "SQLite")
@SourceDebugExtension({"SMAP\nSQLite.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SQLite.kt\nandroidx/sqlite/SQLite\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,69:1\n1#2:70\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
public final class SQLite {
    public static final int SQLITE_DATA_BLOB = 4;
    public static final int SQLITE_DATA_FLOAT = 2;
    public static final int SQLITE_DATA_INTEGER = 1;
    public static final int SQLITE_DATA_NULL = 5;
    public static final int SQLITE_DATA_TEXT = 3;

    public static final void execSQL(@NotNull SQLiteConnection sQLiteConnection, @NotNull String sql) {
        g0.p(sQLiteConnection, "<this>");
        g0.p(sql, "sql");
        SQLiteStatement prepare = sQLiteConnection.prepare(sql);
        try {
            prepare.step();
            a.c(prepare, null);
        } finally {
        }
    }

    @NotNull
    public static final Void throwSQLiteException(int i6, @Nullable String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("Error code: " + i6);
        if (str != null) {
            sb.append(", message: " + str);
        }
        throw new SQLException(sb.toString());
    }
}
