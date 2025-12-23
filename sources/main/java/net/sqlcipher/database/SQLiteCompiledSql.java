package net.sqlcipher.database;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
class SQLiteCompiledSql {
    private static final String TAG = "SQLiteCompiledSql";
    SQLiteDatabase mDatabase;
    private String mSqlStmt;
    long nHandle;
    long nStatement = 0;
    private boolean mInUse = false;

    private final native void native_compile(String str);

    private final native void native_finalize();

    synchronized boolean acquire() {
        if (this.mInUse) {
            return false;
        }
        this.mInUse = true;
        boolean z5 = SQLiteDebug.DEBUG_ACTIVE_CURSOR_FINALIZATION;
        return true;
    }

    synchronized void release() {
        boolean z5 = SQLiteDebug.DEBUG_ACTIVE_CURSOR_FINALIZATION;
        this.mInUse = false;
    }

    private void compile(String str, boolean z5) {
        if (!this.mDatabase.isOpen()) {
            throw new IllegalStateException("database " + this.mDatabase.getPath() + " already closed");
        }
        if (z5) {
            this.mDatabase.lock();
            try {
                native_compile(str);
            } finally {
                this.mDatabase.unlock();
            }
        }
    }

    protected void finalize() throws Throwable {
        try {
            if (this.nStatement == 0) {
                return;
            }
            boolean z5 = SQLiteDebug.DEBUG_ACTIVE_CURSOR_FINALIZATION;
            releaseSqlStatement();
        } finally {
            super.finalize();
        }
    }

    void releaseSqlStatement() {
        if (this.nStatement != 0) {
            boolean z5 = SQLiteDebug.DEBUG_ACTIVE_CURSOR_FINALIZATION;
            try {
                this.mDatabase.lock();
                native_finalize();
                this.nStatement = 0L;
            } finally {
                this.mDatabase.unlock();
            }
        }
    }

    SQLiteCompiledSql(SQLiteDatabase sQLiteDatabase, String str) {
        this.nHandle = 0L;
        this.mSqlStmt = null;
        if (sQLiteDatabase.isOpen()) {
            this.mDatabase = sQLiteDatabase;
            this.mSqlStmt = str;
            this.nHandle = sQLiteDatabase.mNativeHandle;
            compile(str, true);
            return;
        }
        throw new IllegalStateException("database " + sQLiteDatabase.getPath() + " already closed");
    }
}
