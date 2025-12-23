package net.sqlcipher;

import java.io.File;
import net.sqlcipher.database.SQLiteDatabase;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class DefaultDatabaseErrorHandler implements DatabaseErrorHandler {
    private final String TAG = DefaultDatabaseErrorHandler.class.getSimpleName();

    private void deleteDatabaseFile(String str) {
        if (str.equalsIgnoreCase(SQLiteDatabase.MEMORY) || str.trim().length() == 0) {
            return;
        }
        try {
            new File(str).delete();
        } catch (Exception e6) {
            e6.getMessage();
        }
    }

    @Override // net.sqlcipher.DatabaseErrorHandler
    public void onCorruption(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.getPath();
        if (sQLiteDatabase.isOpen()) {
            try {
                sQLiteDatabase.close();
            } catch (Exception unused) {
            }
        }
        deleteDatabaseFile(sQLiteDatabase.getPath());
    }
}
