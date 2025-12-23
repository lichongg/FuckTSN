package androidx.room.driver;

import androidx.annotation.RestrictTo;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes.dex */
public final class SupportSQLiteConnection implements SQLiteConnection {

    @NotNull
    private final SupportSQLiteDatabase db;

    public SupportSQLiteConnection(@NotNull SupportSQLiteDatabase db) {
        g0.p(db, "db");
        this.db = db;
    }

    @Override // androidx.sqlite.SQLiteConnection, java.lang.AutoCloseable
    public void close() {
        this.db.close();
    }

    @NotNull
    public final SupportSQLiteDatabase getDb() {
        return this.db;
    }

    @Override // androidx.sqlite.SQLiteConnection
    @NotNull
    public SupportSQLiteStatement prepare(@NotNull String sql) {
        g0.p(sql, "sql");
        return SupportSQLiteStatement.Companion.create(this.db, sql);
    }
}
