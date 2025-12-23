package net.sqlcipher.database;

import android.util.Log;
import java.util.ArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class SQLiteDebug {
    public static final boolean DEBUG_SQL_STATEMENTS = Log.isLoggable("SQLiteStatements", 2);
    public static final boolean DEBUG_SQL_TIME = Log.isLoggable("SQLiteTime", 2);
    public static final boolean DEBUG_SQL_CACHE = Log.isLoggable("SQLiteCompiledSql", 2);
    public static final boolean DEBUG_ACTIVE_CURSOR_FINALIZATION = Log.isLoggable("SQLiteCursorClosing", 2);
    public static final boolean DEBUG_LOCK_TIME_TRACKING = Log.isLoggable("SQLiteLockTime", 2);
    public static final boolean DEBUG_LOCK_TIME_TRACKING_STACK_TRACE = Log.isLoggable("SQLiteLockStackTrace", 2);
    private static int sNumActiveCursorsFinalized = 0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class PagerStats {

        @Deprecated
        public long databaseBytes;
        public ArrayList<DbStats> dbStats;
        public int largestMemAlloc;
        public int memoryUsed;

        @Deprecated
        public int numPagers;
        public int pageCacheOverflo;

        @Deprecated
        public long referencedBytes;

        @Deprecated
        public long totalBytes;
    }

    public static native long getHeapAllocatedSize();

    public static native void getHeapDirtyPages(int[] iArr);

    public static native long getHeapFreeSize();

    public static native long getHeapSize();

    public static native void getPagerStats(PagerStats pagerStats);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class DbStats {
        public String dbName;
        public long dbSize;
        public int lookaside;
        public long pageSize;

        public DbStats(String str, long j6, long j7, int i6) {
            this.dbName = str;
            this.pageSize = j7;
            this.dbSize = (j6 * j7) / 1024;
            this.lookaside = i6;
        }
    }

    public static PagerStats getDatabaseInfo() {
        PagerStats pagerStats = new PagerStats();
        getPagerStats(pagerStats);
        pagerStats.dbStats = SQLiteDatabase.getDbStats();
        return pagerStats;
    }

    public static int getNumActiveCursorsFinalized() {
        return sNumActiveCursorsFinalized;
    }

    static synchronized void notifyActiveCursorFinalized() {
        synchronized (SQLiteDebug.class) {
            sNumActiveCursorsFinalized++;
        }
    }
}
