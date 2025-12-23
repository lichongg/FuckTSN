package androidx.room.migration;

import androidx.room.driver.SupportSQLiteConnection;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final /* synthetic */ class a {
    public static void a(AutoMigrationSpec autoMigrationSpec, @NotNull SQLiteConnection connection) {
        g0.p(connection, "connection");
        if (connection instanceof SupportSQLiteConnection) {
            autoMigrationSpec.onPostMigrate(((SupportSQLiteConnection) connection).getDb());
        }
    }

    public static void b(AutoMigrationSpec autoMigrationSpec, @NotNull SupportSQLiteDatabase db) {
        g0.p(db, "db");
    }
}
