package net.sqlcipher.database;

import androidx.sqlite.db.SupportSQLiteProgram;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class SQLiteProgram extends SQLiteClosable implements SupportSQLiteProgram {
    private static final String TAG = "SQLiteProgram";
    boolean mClosed = false;
    private SQLiteCompiledSql mCompiledSql;

    @Deprecated
    protected SQLiteDatabase mDatabase;
    final String mSql;

    @Deprecated
    protected long nHandle;

    @Deprecated
    protected long nStatement;

    private final native void native_clear_bindings();

    protected final native void native_bind_blob(int i6, byte[] bArr);

    protected final native void native_bind_double(int i6, double d6);

    protected final native void native_bind_long(int i6, long j6);

    protected final native void native_bind_null(int i6);

    protected final native void native_bind_string(int i6, String str);

    @Deprecated
    protected final native void native_compile(String str);

    @Deprecated
    protected final native void native_finalize();

    private void releaseCompiledSqlIfNotInCache() {
        if (this.mCompiledSql == null) {
            return;
        }
        synchronized (this.mDatabase.mCompiledQueries) {
            try {
                if (this.mDatabase.mCompiledQueries.containsValue(this.mCompiledSql)) {
                    this.mCompiledSql.release();
                } else {
                    this.mCompiledSql.releaseSqlStatement();
                    this.mCompiledSql = null;
                    this.nStatement = 0L;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindBlob(int i6, byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("the bind value at index " + i6 + " is null");
        }
        if (this.mClosed) {
            throw new IllegalStateException("program already closed");
        }
        if (this.mDatabase.isOpen()) {
            acquireReference();
            try {
                native_bind_blob(i6, bArr);
                return;
            } finally {
                releaseReference();
            }
        }
        throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindDouble(int i6, double d6) {
        if (this.mClosed) {
            throw new IllegalStateException("program already closed");
        }
        if (this.mDatabase.isOpen()) {
            acquireReference();
            try {
                native_bind_double(i6, d6);
                return;
            } finally {
                releaseReference();
            }
        }
        throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindLong(int i6, long j6) {
        if (this.mClosed) {
            throw new IllegalStateException("program already closed");
        }
        if (this.mDatabase.isOpen()) {
            acquireReference();
            try {
                native_bind_long(i6, j6);
                return;
            } finally {
                releaseReference();
            }
        }
        throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindNull(int i6) {
        if (this.mClosed) {
            throw new IllegalStateException("program already closed");
        }
        if (this.mDatabase.isOpen()) {
            acquireReference();
            try {
                native_bind_null(i6);
                return;
            } finally {
                releaseReference();
            }
        }
        throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindString(int i6, String str) {
        if (str == null) {
            throw new IllegalArgumentException("the bind value at index " + i6 + " is null");
        }
        if (this.mClosed) {
            throw new IllegalStateException("program already closed");
        }
        if (this.mDatabase.isOpen()) {
            acquireReference();
            try {
                native_bind_string(i6, str);
                return;
            } finally {
                releaseReference();
            }
        }
        throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void clearBindings() {
        if (this.mClosed) {
            throw new IllegalStateException("program already closed");
        }
        if (this.mDatabase.isOpen()) {
            acquireReference();
            try {
                native_clear_bindings();
                return;
            } finally {
                releaseReference();
            }
        }
        throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (!this.mClosed && this.mDatabase.isOpen()) {
            this.mDatabase.lock();
            try {
                releaseReference();
                this.mDatabase.unlock();
                this.mClosed = true;
            } catch (Throwable th) {
                this.mDatabase.unlock();
                throw th;
            }
        }
    }

    String getSqlString() {
        return this.mSql;
    }

    public final long getUniqueId() {
        return this.nStatement;
    }

    SQLiteProgram(SQLiteDatabase sQLiteDatabase, String str) {
        this.nHandle = 0L;
        this.nStatement = 0L;
        this.mDatabase = sQLiteDatabase;
        String trim = str.trim();
        this.mSql = trim;
        sQLiteDatabase.acquireReference();
        sQLiteDatabase.addSQLiteClosable(this);
        this.nHandle = sQLiteDatabase.mNativeHandle;
        trim = trim.length() >= 6 ? trim.substring(0, 6) : trim;
        if (!trim.equalsIgnoreCase("INSERT") && !trim.equalsIgnoreCase("UPDATE") && !trim.equalsIgnoreCase("REPLAC") && !trim.equalsIgnoreCase("DELETE") && !trim.equalsIgnoreCase("SELECT")) {
            SQLiteCompiledSql sQLiteCompiledSql = new SQLiteCompiledSql(sQLiteDatabase, str);
            this.mCompiledSql = sQLiteCompiledSql;
            this.nStatement = sQLiteCompiledSql.nStatement;
            return;
        }
        SQLiteCompiledSql compiledStatementForSql = sQLiteDatabase.getCompiledStatementForSql(str);
        this.mCompiledSql = compiledStatementForSql;
        if (compiledStatementForSql == null) {
            SQLiteCompiledSql sQLiteCompiledSql2 = new SQLiteCompiledSql(sQLiteDatabase, str);
            this.mCompiledSql = sQLiteCompiledSql2;
            sQLiteCompiledSql2.acquire();
            sQLiteDatabase.addToCompiledQueries(str, this.mCompiledSql);
            if (SQLiteDebug.DEBUG_ACTIVE_CURSOR_FINALIZATION) {
                long j6 = this.mCompiledSql.nStatement;
            }
        } else if (!compiledStatementForSql.acquire()) {
            long j7 = this.mCompiledSql.nStatement;
            this.mCompiledSql = new SQLiteCompiledSql(sQLiteDatabase, str);
            if (SQLiteDebug.DEBUG_ACTIVE_CURSOR_FINALIZATION) {
                long j8 = this.mCompiledSql.nStatement;
            }
        }
        this.nStatement = this.mCompiledSql.nStatement;
    }

    @Override // net.sqlcipher.database.SQLiteClosable
    protected void onAllReferencesReleased() {
        releaseCompiledSqlIfNotInCache();
        this.mDatabase.releaseReference();
        this.mDatabase.removeSQLiteClosable(this);
    }

    @Override // net.sqlcipher.database.SQLiteClosable
    protected void onAllReferencesReleasedFromContainer() {
        releaseCompiledSqlIfNotInCache();
        this.mDatabase.releaseReference();
    }

    @Deprecated
    protected void compile(String str, boolean z5) {
    }
}
