package androidx.room.migration;

import androidx.room.driver.SupportSQLiteConnection;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.NotImplementedError;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public abstract class Migration {

    @JvmField
    public final int endVersion;

    @JvmField
    public final int startVersion;

    public void migrate(@NotNull SupportSQLiteDatabase db) {
        g0.p(db, "db");
        throw new NotImplementedError("Migration functionality with a SupportSQLiteDatabase (without a provided SQLiteDriver) requires overriding the migrate(SupportSQLiteDatabase) function.");
    }

    public Migration(int i6, int i7) {
        this.startVersion = i6;
        this.endVersion = i7;
    }

    public void migrate(@NotNull SQLiteConnection connection) {
        g0.p(connection, "connection");
        if (connection instanceof SupportSQLiteConnection) {
            migrate(((SupportSQLiteConnection) connection).getDb());
            return;
        }
        throw new NotImplementedError("Migration functionality with a provided SQLiteDriver requires overriding the migrate(SQLiteConnection) function.");
    }
}
