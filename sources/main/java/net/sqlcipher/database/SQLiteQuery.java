package net.sqlcipher.database;

import android.os.SystemClock;
import net.sqlcipher.CursorWindow;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class SQLiteQuery extends SQLiteProgram {
    private static final String TAG = "Cursor";
    private String[] mBindArgs;
    private Object[] mObjectBindArgs;
    private int mOffsetIndex;

    SQLiteQuery(SQLiteDatabase sQLiteDatabase, String str, int i6, String[] strArr) {
        super(sQLiteDatabase, str);
        this.mOffsetIndex = i6;
        this.mBindArgs = strArr;
    }

    private final native int native_column_count();

    private final native String native_column_name(int i6);

    private final native int native_fill_window(CursorWindow cursorWindow, int i6, int i7, int i8, int i9, int i10);

    public void bindArguments(Object[] objArr) {
        if (objArr == null || objArr.length <= 0) {
            return;
        }
        for (int i6 = 0; i6 < objArr.length; i6++) {
            Object obj = objArr[i6];
            if (obj == null) {
                bindNull(i6 + 1);
            } else if (obj instanceof Double) {
                bindDouble(i6 + 1, ((Double) obj).doubleValue());
            } else if (obj instanceof Float) {
                bindDouble(i6 + 1, ((Number) obj).floatValue());
            } else if (obj instanceof Long) {
                bindLong(i6 + 1, ((Long) obj).longValue());
            } else if (obj instanceof Integer) {
                bindLong(i6 + 1, ((Number) obj).intValue());
            } else if (obj instanceof Boolean) {
                bindLong(i6 + 1, ((Boolean) obj).booleanValue() ? 1L : 0L);
            } else if (obj instanceof byte[]) {
                bindBlob(i6 + 1, (byte[]) obj);
            } else {
                bindString(i6 + 1, obj.toString());
            }
        }
    }

    @Override // net.sqlcipher.database.SQLiteProgram, androidx.sqlite.db.SupportSQLiteProgram
    public void bindDouble(int i6, double d6) {
        this.mBindArgs[i6 - 1] = Double.toString(d6);
        if (this.mClosed) {
            return;
        }
        super.bindDouble(i6, d6);
    }

    @Override // net.sqlcipher.database.SQLiteProgram, androidx.sqlite.db.SupportSQLiteProgram
    public void bindLong(int i6, long j6) {
        this.mBindArgs[i6 - 1] = Long.toString(j6);
        if (this.mClosed) {
            return;
        }
        super.bindLong(i6, j6);
    }

    @Override // net.sqlcipher.database.SQLiteProgram, androidx.sqlite.db.SupportSQLiteProgram
    public void bindNull(int i6) {
        this.mBindArgs[i6 - 1] = null;
        if (this.mClosed) {
            return;
        }
        super.bindNull(i6);
    }

    @Override // net.sqlcipher.database.SQLiteProgram, androidx.sqlite.db.SupportSQLiteProgram
    public void bindString(int i6, String str) {
        this.mBindArgs[i6 - 1] = str;
        if (this.mClosed) {
            return;
        }
        super.bindString(i6, str);
    }

    void requery() {
        String[] strArr = this.mBindArgs;
        if (strArr != null) {
            int length = strArr.length;
            try {
                Object[] objArr = this.mObjectBindArgs;
                if (objArr != null) {
                    bindArguments(objArr);
                    return;
                }
                int i6 = 0;
                while (i6 < length) {
                    int i7 = i6 + 1;
                    super.bindString(i7, this.mBindArgs[i6]);
                    i6 = i7;
                }
            } catch (SQLiteMisuseException e6) {
                StringBuilder sb = new StringBuilder("mSql " + this.mSql);
                for (int i8 = 0; i8 < length; i8++) {
                    sb.append(" ");
                    sb.append(this.mBindArgs[i8]);
                }
                sb.append(" ");
                throw new IllegalStateException(sb.toString(), e6);
            }
        }
    }

    public String toString() {
        return "SQLiteQuery: " + this.mSql;
    }

    int columnCountLocked() {
        acquireReference();
        try {
            return native_column_count();
        } finally {
            releaseReference();
        }
    }

    String columnNameLocked(int i6) {
        acquireReference();
        try {
            return native_column_name(i6);
        } finally {
            releaseReference();
        }
    }

    int fillWindow(CursorWindow cursorWindow, int i6, int i7) {
        SQLiteQuery sQLiteQuery;
        CursorWindow cursorWindow2;
        SystemClock.uptimeMillis();
        this.mDatabase.lock();
        try {
            try {
                try {
                    acquireReference();
                    try {
                        cursorWindow.acquireReference();
                        sQLiteQuery = this;
                        cursorWindow2 = cursorWindow;
                    } catch (IllegalStateException unused) {
                        sQLiteQuery = this;
                        cursorWindow2 = cursorWindow;
                    } catch (SQLiteDatabaseCorruptException e6) {
                        e = e6;
                        sQLiteQuery = this;
                    } catch (Throwable th) {
                        th = th;
                        Throwable th2 = th;
                        cursorWindow.releaseReference();
                        throw th2;
                    }
                    try {
                        int native_fill_window = sQLiteQuery.native_fill_window(cursorWindow2, cursorWindow.getStartPosition(), cursorWindow.getRequiredPosition(), this.mOffsetIndex, i6, i7);
                        boolean z5 = SQLiteDebug.DEBUG_SQL_STATEMENTS;
                        cursorWindow2.releaseReference();
                        releaseReference();
                        sQLiteQuery.mDatabase.unlock();
                        return native_fill_window;
                    } catch (IllegalStateException unused2) {
                        cursorWindow2.releaseReference();
                        releaseReference();
                        sQLiteQuery.mDatabase.unlock();
                        return 0;
                    } catch (SQLiteDatabaseCorruptException e7) {
                        e = e7;
                        SQLiteDatabaseCorruptException sQLiteDatabaseCorruptException = e;
                        sQLiteQuery.mDatabase.onCorruption();
                        throw sQLiteDatabaseCorruptException;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    Throwable th4 = th;
                    releaseReference();
                    this.mDatabase.unlock();
                    throw th4;
                }
            } catch (Throwable th5) {
                th = th5;
                Throwable th42 = th;
                releaseReference();
                this.mDatabase.unlock();
                throw th42;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    SQLiteQuery(SQLiteDatabase sQLiteDatabase, String str, int i6, Object[] objArr) {
        super(sQLiteDatabase, str);
        this.mOffsetIndex = i6;
        this.mObjectBindArgs = objArr;
        this.mBindArgs = new String[objArr != null ? objArr.length : 0];
    }
}
