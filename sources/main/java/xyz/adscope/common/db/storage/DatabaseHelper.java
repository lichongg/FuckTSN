package xyz.adscope.common.db.storage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import com.stub.StubApp;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class DatabaseHelper extends SQLiteOpenHelper {

    /* renamed from: a, reason: collision with root package name */
    private static DatabaseHelper f56313a;

    private DatabaseHelper(@Nullable Context context) {
        super(context, "common_base.db", (SQLiteDatabase.CursorFactory) null, 1);
    }

    public static DatabaseHelper getInstance(Context context) {
        if (f56313a == null) {
            synchronized (DatabaseHelper.class) {
                try {
                    if (f56313a == null) {
                        f56313a = new DatabaseHelper(StubApp.getOrigApplicationContext(context.getApplicationContext()));
                    }
                } finally {
                }
            }
        }
        return f56313a;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i6, int i7) {
    }
}
