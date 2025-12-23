package xyz.adscope.amps.tool.persistent.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import com.stub.StubApp;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class AMPSSqliteOpenHelper extends SQLiteOpenHelper {
    private static final String DATA_BASE_NAME = "amps_ad.db";
    private static final int DATA_BASE_VERSION = 1;
    private static AMPSSqliteOpenHelper mSQLiteOpenHelper;

    private AMPSSqliteOpenHelper(@Nullable Context context) {
        super(context, DATA_BASE_NAME, (SQLiteDatabase.CursorFactory) null, 1);
    }

    public static AMPSSqliteOpenHelper getInstance(Context context) {
        if (mSQLiteOpenHelper == null) {
            synchronized (AMPSSqliteOpenHelper.class) {
                try {
                    if (mSQLiteOpenHelper == null) {
                        mSQLiteOpenHelper = new AMPSSqliteOpenHelper(StubApp.getOrigApplicationContext(context.getApplicationContext()));
                    }
                } finally {
                }
            }
        }
        return mSQLiteOpenHelper;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i6, int i7) {
    }
}
