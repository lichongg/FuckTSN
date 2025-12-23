package androidx.room.util;

import androidx.annotation.RestrictTo;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import kotlin.jdk7.a;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JvmName(name = "SQLiteConnectionUtil")
/* loaded from: D:\Downloads\app\classes.dex */
public final class SQLiteConnectionUtil {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final long getLastInsertedRowId(@NotNull SQLiteConnection connection) {
        g0.p(connection, "connection");
        if (getTotalChangedRows(connection) == 0) {
            return -1L;
        }
        SQLiteStatement prepare = connection.prepare("SELECT last_insert_rowid()");
        try {
            prepare.step();
            long j6 = prepare.getLong(0);
            a.c(prepare, null);
            return j6;
        } finally {
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final int getTotalChangedRows(@NotNull SQLiteConnection connection) {
        g0.p(connection, "connection");
        SQLiteStatement prepare = connection.prepare("SELECT changes()");
        try {
            prepare.step();
            int i6 = (int) prepare.getLong(0);
            a.c(prepare, null);
            return i6;
        } finally {
        }
    }
}
