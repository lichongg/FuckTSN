package net.sqlcipher.database;

import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class SupportHelper implements SupportSQLiteOpenHelper {
    private final boolean clearPassphrase;
    private byte[] passphrase;
    private SQLiteOpenHelper standardHelper;

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public SupportSQLiteDatabase getWritableDatabase() {
        try {
            SQLiteDatabase writableDatabase = this.standardHelper.getWritableDatabase(this.passphrase);
            if (this.clearPassphrase && this.passphrase != null) {
                int i6 = 0;
                while (true) {
                    byte[] bArr = this.passphrase;
                    if (i6 >= bArr.length) {
                        break;
                    }
                    bArr[i6] = 0;
                    i6++;
                }
            }
            return writableDatabase;
        } catch (SQLiteException e6) {
            byte[] bArr2 = this.passphrase;
            if (bArr2 != null) {
                boolean z5 = true;
                for (byte b6 : bArr2) {
                    z5 = z5 && b6 == 0;
                }
                if (z5) {
                    throw new IllegalStateException("The passphrase appears to be cleared. This happens by default the first time you use the factory to open a database, so we can remove the cleartext passphrase from memory. If you close the database yourself, please use a fresh SupportFactory to reopen it. If something else (e.g., Room) closed the database, and you cannot control that, use SupportFactory boolean constructor option to opt out of the automatic password clearing step. See the project README for more information.", e6);
                }
            }
            throw e6;
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.standardHelper.close();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public String getDatabaseName() {
        return this.standardHelper.getDatabaseName();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public void setWriteAheadLoggingEnabled(boolean z5) {
        this.standardHelper.setWriteAheadLoggingEnabled(z5);
    }

    SupportHelper(final SupportSQLiteOpenHelper.Configuration configuration, byte[] bArr, SQLiteDatabaseHook sQLiteDatabaseHook, boolean z5) {
        SQLiteDatabase.loadLibs(configuration.context);
        this.passphrase = bArr;
        this.clearPassphrase = z5;
        this.standardHelper = new SQLiteOpenHelper(configuration.context, configuration.name, null, configuration.callback.version, sQLiteDatabaseHook) { // from class: net.sqlcipher.database.SupportHelper.1
            @Override // net.sqlcipher.database.SQLiteOpenHelper
            public void onConfigure(SQLiteDatabase sQLiteDatabase) {
                configuration.callback.onConfigure(sQLiteDatabase);
            }

            @Override // net.sqlcipher.database.SQLiteOpenHelper
            public void onCreate(SQLiteDatabase sQLiteDatabase) {
                configuration.callback.onCreate(sQLiteDatabase);
            }

            @Override // net.sqlcipher.database.SQLiteOpenHelper
            public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i6, int i7) {
                configuration.callback.onDowngrade(sQLiteDatabase, i6, i7);
            }

            @Override // net.sqlcipher.database.SQLiteOpenHelper
            public void onOpen(SQLiteDatabase sQLiteDatabase) {
                configuration.callback.onOpen(sQLiteDatabase);
            }

            @Override // net.sqlcipher.database.SQLiteOpenHelper
            public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i6, int i7) {
                configuration.callback.onUpgrade(sQLiteDatabase, i6, i7);
            }
        };
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public SupportSQLiteDatabase getReadableDatabase() {
        return getWritableDatabase();
    }
}
