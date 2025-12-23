package androidx.room.migration;

import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.db.SupportSQLiteDatabase;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public interface AutoMigrationSpec {
    void onPostMigrate(@NotNull SQLiteConnection sQLiteConnection);

    void onPostMigrate(@NotNull SupportSQLiteDatabase supportSQLiteDatabase);
}
