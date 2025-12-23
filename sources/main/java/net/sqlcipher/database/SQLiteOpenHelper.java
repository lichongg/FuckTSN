package net.sqlcipher.database;

import android.content.Context;
import java.io.File;
import net.sqlcipher.DatabaseErrorHandler;
import net.sqlcipher.DefaultDatabaseErrorHandler;
import net.sqlcipher.database.SQLiteDatabase;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class SQLiteOpenHelper {
    private static final String TAG = "SQLiteOpenHelper";
    private final Context mContext;
    private SQLiteDatabase mDatabase;
    private boolean mDeferSetWriteAheadLoggingEnabled;
    private boolean mEnableWriteAheadLogging;
    private final DatabaseErrorHandler mErrorHandler;
    private final SQLiteDatabase.CursorFactory mFactory;
    private final SQLiteDatabaseHook mHook;
    private boolean mIsInitializing;
    private final String mName;
    private final int mNewVersion;

    public SQLiteOpenHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i6) {
        this(context, str, cursorFactory, i6, null, new DefaultDatabaseErrorHandler());
    }

    public synchronized void close() {
        if (this.mIsInitializing) {
            throw new IllegalStateException("Closed during initialization");
        }
        SQLiteDatabase sQLiteDatabase = this.mDatabase;
        if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
            this.mDatabase.close();
            this.mDatabase = null;
        }
    }

    public synchronized SQLiteDatabase getReadableDatabase(String str) {
        return getReadableDatabase(str == null ? null : str.toCharArray());
    }

    public synchronized SQLiteDatabase getWritableDatabase(String str) {
        return getWritableDatabase(str == null ? null : str.toCharArray());
    }

    public abstract void onCreate(SQLiteDatabase sQLiteDatabase);

    public abstract void onUpgrade(SQLiteDatabase sQLiteDatabase, int i6, int i7);

    public void setWriteAheadLoggingEnabled(boolean z5) {
        synchronized (this) {
            try {
                if (this.mEnableWriteAheadLogging != z5) {
                    SQLiteDatabase sQLiteDatabase = this.mDatabase;
                    if (sQLiteDatabase == null || !sQLiteDatabase.isOpen() || this.mDatabase.isReadOnly()) {
                        this.mDeferSetWriteAheadLoggingEnabled = z5;
                    } else {
                        if (z5) {
                            this.mDatabase.enableWriteAheadLogging();
                        } else {
                            this.mDatabase.disableWriteAheadLogging();
                        }
                        this.mEnableWriteAheadLogging = z5;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public SQLiteOpenHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i6, SQLiteDatabaseHook sQLiteDatabaseHook) {
        this(context, str, cursorFactory, i6, sQLiteDatabaseHook, new DefaultDatabaseErrorHandler());
    }

    public String getDatabaseName() {
        return this.mName;
    }

    public synchronized SQLiteDatabase getReadableDatabase(char[] cArr) {
        return getReadableDatabase(cArr == null ? null : SQLiteDatabase.getBytes(cArr));
    }

    public synchronized SQLiteDatabase getWritableDatabase(char[] cArr) {
        return getWritableDatabase(cArr == null ? null : SQLiteDatabase.getBytes(cArr));
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i6, int i7) {
        throw new SQLiteException("Can't downgrade database from version " + i6 + " to " + i7);
    }

    public SQLiteOpenHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i6, SQLiteDatabaseHook sQLiteDatabaseHook, DatabaseErrorHandler databaseErrorHandler) {
        this.mDatabase = null;
        this.mIsInitializing = false;
        if (i6 < 1) {
            throw new IllegalArgumentException("Version must be >= 1, was " + i6);
        }
        if (databaseErrorHandler != null) {
            this.mContext = context;
            this.mName = str;
            this.mFactory = cursorFactory;
            this.mNewVersion = i6;
            this.mHook = sQLiteDatabaseHook;
            this.mErrorHandler = databaseErrorHandler;
            return;
        }
        throw new IllegalArgumentException("DatabaseErrorHandler param value can't be null.");
    }

    public synchronized SQLiteDatabase getReadableDatabase(byte[] bArr) {
        SQLiteDatabase sQLiteDatabase = this.mDatabase;
        if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
            return this.mDatabase;
        }
        if (!this.mIsInitializing) {
            try {
                return getWritableDatabase(bArr);
            } catch (SQLiteException e6) {
                if (this.mName != null) {
                    try {
                        this.mIsInitializing = true;
                        String path = this.mContext.getDatabasePath(this.mName).getPath();
                        File file = new File(path);
                        File file2 = new File(this.mContext.getDatabasePath(this.mName).getParent());
                        if (!file2.exists()) {
                            file2.mkdirs();
                        }
                        if (!file.exists()) {
                            this.mIsInitializing = false;
                            SQLiteDatabase writableDatabase = getWritableDatabase(bArr);
                            this.mIsInitializing = true;
                            writableDatabase.close();
                        }
                        SQLiteDatabase openDatabase = SQLiteDatabase.openDatabase(path, bArr, this.mFactory, 1, this.mHook, this.mErrorHandler);
                        if (openDatabase.getVersion() == this.mNewVersion) {
                            onOpen(openDatabase);
                            this.mDatabase = openDatabase;
                            this.mIsInitializing = false;
                            return openDatabase;
                        }
                        throw new SQLiteException("Can't upgrade read-only database from version " + openDatabase.getVersion() + " to " + this.mNewVersion + ": " + path);
                    } finally {
                    }
                } else {
                    throw e6;
                }
            }
        } else {
            throw new IllegalStateException("getReadableDatabase called recursively");
        }
    }

    public synchronized SQLiteDatabase getWritableDatabase(byte[] bArr) {
        SQLiteDatabase openOrCreateDatabase;
        SQLiteDatabase sQLiteDatabase = this.mDatabase;
        if (sQLiteDatabase != null && sQLiteDatabase.isOpen() && !this.mDatabase.isReadOnly()) {
            return this.mDatabase;
        }
        if (!this.mIsInitializing) {
            SQLiteDatabase sQLiteDatabase2 = this.mDatabase;
            if (sQLiteDatabase2 != null) {
                sQLiteDatabase2.lock();
            }
            SQLiteDatabase sQLiteDatabase3 = null;
            try {
                this.mIsInitializing = true;
                String str = this.mName;
                if (str == null) {
                    openOrCreateDatabase = SQLiteDatabase.create((SQLiteDatabase.CursorFactory) null, "");
                } else {
                    String path = this.mContext.getDatabasePath(str).getPath();
                    File file = new File(path);
                    if (!file.exists()) {
                        file.getParentFile().mkdirs();
                    }
                    openOrCreateDatabase = SQLiteDatabase.openOrCreateDatabase(path, bArr, this.mFactory, this.mHook, this.mErrorHandler);
                }
                sQLiteDatabase3 = openOrCreateDatabase;
                if (this.mDeferSetWriteAheadLoggingEnabled) {
                    this.mEnableWriteAheadLogging = sQLiteDatabase3.enableWriteAheadLogging();
                }
                onConfigure(sQLiteDatabase3);
                int version = sQLiteDatabase3.getVersion();
                if (version != this.mNewVersion) {
                    sQLiteDatabase3.beginTransaction();
                    try {
                        if (version == 0) {
                            onCreate(sQLiteDatabase3);
                        } else {
                            int i6 = this.mNewVersion;
                            if (version > i6) {
                                onDowngrade(sQLiteDatabase3, version, i6);
                            } else {
                                onUpgrade(sQLiteDatabase3, version, i6);
                            }
                        }
                        sQLiteDatabase3.setVersion(this.mNewVersion);
                        sQLiteDatabase3.setTransactionSuccessful();
                        sQLiteDatabase3.endTransaction();
                    } catch (Throwable th) {
                        sQLiteDatabase3.endTransaction();
                        throw th;
                    }
                }
                onOpen(sQLiteDatabase3);
                this.mIsInitializing = false;
                SQLiteDatabase sQLiteDatabase4 = this.mDatabase;
                if (sQLiteDatabase4 != null) {
                    try {
                        sQLiteDatabase4.close();
                    } catch (Exception unused) {
                    }
                    this.mDatabase.unlock();
                }
                this.mDatabase = sQLiteDatabase3;
                return sQLiteDatabase3;
            } catch (Throwable th2) {
                this.mIsInitializing = false;
                SQLiteDatabase sQLiteDatabase5 = this.mDatabase;
                if (sQLiteDatabase5 != null) {
                    sQLiteDatabase5.unlock();
                }
                if (sQLiteDatabase3 != null) {
                    sQLiteDatabase3.close();
                }
                throw th2;
            }
        }
        throw new IllegalStateException("getWritableDatabase called recursively");
    }

    public void onConfigure(SQLiteDatabase sQLiteDatabase) {
    }

    public void onOpen(SQLiteDatabase sQLiteDatabase) {
    }
}
