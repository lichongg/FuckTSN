package net.sqlcipher.database;

import android.database.DataSetObserver;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import com.umeng.analytics.pro.bm;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import net.sqlcipher.AbstractWindowedCursor;
import net.sqlcipher.CursorWindow;
import net.sqlcipher.SQLException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class SQLiteCursor extends AbstractWindowedCursor {
    static final int NO_COUNT = -1;
    static final String TAG = "Cursor";
    private String[] mColumns;
    private SQLiteDatabase mDatabase;
    private SQLiteCursorDriver mDriver;
    private String mEditTable;
    protected MainThreadNotificationHandler mNotificationHandler;
    private SQLiteQuery mQuery;
    private int mCount = -1;
    private int mCursorWindowCapacity = 0;
    private boolean fillWindowForwardOnly = false;
    private int mMaxRead = Integer.MAX_VALUE;
    private int mInitialRead = Integer.MAX_VALUE;
    private int mCursorState = 0;
    private ReentrantLock mLock = null;
    private boolean mPendingData = false;
    private Throwable mStackTrace = new DatabaseObjectNotClosedException().fillInStackTrace();
    private Map<String, Integer> mColumnNameMap = null;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    protected static class MainThreadNotificationHandler extends Handler {
        private final WeakReference<SQLiteCursor> wrappedCursor;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            SQLiteCursor sQLiteCursor = this.wrappedCursor.get();
            if (sQLiteCursor != null) {
                sQLiteCursor.notifyDataSetChange();
            }
        }

        MainThreadNotificationHandler(SQLiteCursor sQLiteCursor) {
            this.wrappedCursor = new WeakReference<>(sQLiteCursor);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class QueryThread implements Runnable {
        private final int mThreadState;

        QueryThread(int i6) {
            this.mThreadState = i6;
        }

        private void sendMessage() {
            SQLiteCursor sQLiteCursor = SQLiteCursor.this;
            MainThreadNotificationHandler mainThreadNotificationHandler = sQLiteCursor.mNotificationHandler;
            if (mainThreadNotificationHandler == null) {
                sQLiteCursor.mPendingData = true;
            } else {
                mainThreadNotificationHandler.sendEmptyMessage(1);
                SQLiteCursor.this.mPendingData = false;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            CursorWindow cursorWindow = ((AbstractWindowedCursor) SQLiteCursor.this).mWindow;
            Process.setThreadPriority(Process.myTid(), 10);
            while (true) {
                if (SQLiteCursor.this.mLock == null) {
                    SQLiteCursor.this.mLock = new ReentrantLock(true);
                }
                SQLiteCursor.this.mLock.lock();
                if (SQLiteCursor.this.mCursorState != this.mThreadState) {
                    return;
                }
                try {
                    int fillWindow = SQLiteCursor.this.mQuery.fillWindow(cursorWindow, SQLiteCursor.this.mMaxRead, SQLiteCursor.this.mCount);
                    if (fillWindow == 0) {
                        return;
                    }
                    if (fillWindow != -1) {
                        SQLiteCursor.this.mCount = fillWindow;
                        sendMessage();
                        return;
                    } else {
                        SQLiteCursor.this.mCount += SQLiteCursor.this.mMaxRead;
                        sendMessage();
                    }
                } catch (Exception unused) {
                    return;
                } finally {
                    SQLiteCursor.this.mLock.unlock();
                }
            }
        }
    }

    private void deactivateCommon() {
        this.mCursorState = 0;
        CursorWindow cursorWindow = this.mWindow;
        if (cursorWindow != null) {
            cursorWindow.close();
            this.mWindow = null;
        }
    }

    private void fillWindow(int i6) {
        if (this.mWindow == null) {
            this.mWindow = new CursorWindow(true);
        } else {
            this.mCursorState++;
            queryThreadLock();
            try {
                this.mWindow.clear();
            } finally {
                queryThreadUnlock();
            }
        }
        int cursorPickFillWindowStartPosition = this.fillWindowForwardOnly ? i6 : this.mCount == -1 ? cursorPickFillWindowStartPosition(i6, 0) : cursorPickFillWindowStartPosition(i6, this.mCursorWindowCapacity);
        this.mWindow.setStartPosition(cursorPickFillWindowStartPosition);
        this.mWindow.setRequiredPosition(i6);
        this.mCount = this.mQuery.fillWindow(this.mWindow, this.mInitialRead, 0);
        if (this.mCursorWindowCapacity == 0) {
            this.mCursorWindowCapacity = this.mWindow.getNumRows();
        }
        if (this.mCount == -1) {
            this.mCount = cursorPickFillWindowStartPosition + this.mInitialRead;
            new Thread(new QueryThread(this.mCursorState), "query thread").start();
        }
    }

    private void queryThreadLock() {
        ReentrantLock reentrantLock = this.mLock;
        if (reentrantLock != null) {
            reentrantLock.lock();
        }
    }

    private void queryThreadUnlock() {
        ReentrantLock reentrantLock = this.mLock;
        if (reentrantLock != null) {
            reentrantLock.unlock();
        }
    }

    public int cursorPickFillWindowStartPosition(int i6, int i7) {
        return Math.max(i6 - (i7 / 3), 0);
    }

    @Override // net.sqlcipher.AbstractCursor
    protected void finalize() {
        try {
            if (this.mWindow != null) {
                this.mQuery.mSql.getClass();
                close();
                SQLiteDebug.notifyActiveCursorFinalized();
            }
        } finally {
            super.finalize();
        }
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public int getColumnIndex(String str) {
        if (this.mColumnNameMap == null) {
            String[] strArr = this.mColumns;
            int length = strArr.length;
            HashMap hashMap = new HashMap(length, 1.0f);
            for (int i6 = 0; i6 < length; i6++) {
                hashMap.put(strArr[i6], Integer.valueOf(i6));
            }
            this.mColumnNameMap = hashMap;
        }
        if (str.lastIndexOf(46) != -1) {
            new Exception();
        }
        Integer num = this.mColumnNameMap.get(str);
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public String[] getColumnNames() {
        return this.mColumns;
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public int getCount() {
        if (this.mCount == -1) {
            fillWindow(0);
        }
        return this.mCount;
    }

    public SQLiteDatabase getDatabase() {
        return this.mDatabase;
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.CrossProcessCursor
    public boolean onMove(int i6, int i7) {
        CursorWindow cursorWindow = this.mWindow;
        if (cursorWindow != null && i7 >= cursorWindow.getStartPosition() && i7 < this.mWindow.getStartPosition() + this.mWindow.getNumRows()) {
            return true;
        }
        fillWindow(i7);
        return true;
    }

    public void setFillWindowForwardOnly(boolean z5) {
        this.fillWindowForwardOnly = z5;
    }

    public void setLoadStyle(int i6, int i7) {
        this.mMaxRead = i7;
        this.mInitialRead = i6;
        this.mLock = new ReentrantLock(true);
    }

    public void setSelectionArguments(String[] strArr) {
        this.mDriver.setBindArguments(strArr);
    }

    @Override // net.sqlcipher.AbstractWindowedCursor
    public void setWindow(CursorWindow cursorWindow) {
        if (this.mWindow != null) {
            this.mCursorState++;
            queryThreadLock();
            try {
                this.mWindow.close();
                queryThreadUnlock();
                this.mCount = -1;
            } catch (Throwable th) {
                queryThreadUnlock();
                throw th;
            }
        }
        this.mWindow = cursorWindow;
    }

    @Override // net.sqlcipher.AbstractCursor
    public boolean supportsUpdates() {
        return !TextUtils.isEmpty(this.mEditTable);
    }

    public SQLiteCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        this.mDatabase = sQLiteDatabase;
        this.mDriver = sQLiteCursorDriver;
        this.mEditTable = str;
        this.mQuery = sQLiteQuery;
        try {
            sQLiteDatabase.lock();
            int columnCountLocked = this.mQuery.columnCountLocked();
            this.mColumns = new String[columnCountLocked];
            for (int i6 = 0; i6 < columnCountLocked; i6++) {
                String columnNameLocked = this.mQuery.columnNameLocked(i6);
                this.mColumns[i6] = columnNameLocked;
                if (bm.f41039d.equals(columnNameLocked)) {
                    this.mRowIdColumnIndex = i6;
                }
            }
        } finally {
            sQLiteDatabase.unlock();
        }
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        super.close();
        deactivateCommon();
        this.mQuery.close();
        this.mDriver.cursorClosed();
    }

    @Override // net.sqlcipher.AbstractCursor
    public boolean commitUpdates(Map<? extends Long, ? extends Map<String, Object>> map) {
        if (!supportsUpdates()) {
            return false;
        }
        synchronized (this.mUpdatedRows) {
            if (map != null) {
                try {
                    this.mUpdatedRows.putAll(map);
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (this.mUpdatedRows.size() == 0) {
                return true;
            }
            this.mDatabase.beginTransaction();
            try {
                StringBuilder sb = new StringBuilder(128);
                for (Map.Entry<Long, Map<String, Object>> entry : this.mUpdatedRows.entrySet()) {
                    Map<String, Object> value = entry.getValue();
                    Long key = entry.getKey();
                    if (key != null && value != null) {
                        if (value.size() != 0) {
                            long longValue = key.longValue();
                            Iterator<Map.Entry<String, Object>> it = value.entrySet().iterator();
                            sb.setLength(0);
                            sb.append("UPDATE " + this.mEditTable + " SET ");
                            Object[] objArr = new Object[value.size()];
                            int i6 = 0;
                            while (it.hasNext()) {
                                Map.Entry<String, Object> next = it.next();
                                sb.append(next.getKey());
                                sb.append("=?");
                                objArr[i6] = next.getValue();
                                if (it.hasNext()) {
                                    sb.append(", ");
                                }
                                i6++;
                            }
                            sb.append(" WHERE " + this.mColumns[this.mRowIdColumnIndex] + '=' + longValue);
                            sb.append(';');
                            this.mDatabase.execSQL(sb.toString(), objArr);
                            this.mDatabase.rowUpdated(this.mEditTable, longValue);
                        }
                    } else {
                        throw new IllegalStateException("null rowId or values found! rowId = " + key + ", values = " + value);
                    }
                }
                this.mDatabase.setTransactionSuccessful();
                this.mDatabase.endTransaction();
                this.mUpdatedRows.clear();
                onChange(true);
                return true;
            } catch (Throwable th2) {
                this.mDatabase.endTransaction();
                throw th2;
            }
        }
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public void deactivate() {
        super.deactivate();
        deactivateCommon();
        this.mDriver.cursorDeactivated();
    }

    @Override // net.sqlcipher.AbstractCursor
    public boolean deleteRow() {
        boolean z5;
        checkPosition();
        if (this.mRowIdColumnIndex == -1 || this.mCurrentRowID == null) {
            return false;
        }
        this.mDatabase.lock();
        try {
            try {
                this.mDatabase.delete(this.mEditTable, this.mColumns[this.mRowIdColumnIndex] + "=?", new String[]{this.mCurrentRowID.toString()});
                z5 = true;
            } finally {
                this.mDatabase.unlock();
            }
        } catch (SQLException unused) {
            z5 = false;
        }
        int i6 = this.mPos;
        requery();
        moveToPosition(i6);
        if (!z5) {
            return false;
        }
        onChange(true);
        return true;
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        super.registerDataSetObserver(dataSetObserver);
        if ((Integer.MAX_VALUE != this.mMaxRead || Integer.MAX_VALUE != this.mInitialRead) && this.mNotificationHandler == null) {
            queryThreadLock();
            try {
                this.mNotificationHandler = new MainThreadNotificationHandler(this);
                if (this.mPendingData) {
                    notifyDataSetChange();
                    this.mPendingData = false;
                }
            } finally {
                queryThreadUnlock();
            }
        }
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public boolean requery() {
        if (isClosed()) {
            return false;
        }
        this.mDatabase.lock();
        try {
            CursorWindow cursorWindow = this.mWindow;
            if (cursorWindow != null) {
                cursorWindow.clear();
            }
            this.mPos = -1;
            this.mDriver.cursorRequeried(this);
            this.mCount = -1;
            this.mCursorState++;
            queryThreadLock();
            try {
                this.mQuery.requery();
                this.mDatabase.unlock();
                return super.requery();
            } finally {
                queryThreadUnlock();
            }
        } catch (Throwable th) {
            this.mDatabase.unlock();
            throw th;
        }
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.CrossProcessCursor
    public void fillWindow(int i6, android.database.CursorWindow cursorWindow) {
        int cursorPickFillWindowStartPosition;
        if (this.mWindow == null) {
            this.mWindow = new CursorWindow(true);
        } else {
            this.mCursorState++;
            queryThreadLock();
            try {
                this.mWindow.clear();
            } finally {
                queryThreadUnlock();
            }
        }
        if (this.fillWindowForwardOnly) {
            cursorPickFillWindowStartPosition = i6;
        } else if (this.mCount == -1) {
            cursorPickFillWindowStartPosition = cursorPickFillWindowStartPosition(i6, 0);
        } else {
            cursorPickFillWindowStartPosition = cursorPickFillWindowStartPosition(i6, this.mCursorWindowCapacity);
        }
        this.mWindow.setStartPosition(cursorPickFillWindowStartPosition);
        this.mWindow.setRequiredPosition(i6);
        this.mCount = this.mQuery.fillWindow(this.mWindow, this.mInitialRead, 0);
        if (this.mCursorWindowCapacity == 0) {
            this.mCursorWindowCapacity = this.mWindow.getNumRows();
        }
        if (this.mCount == -1) {
            this.mCount = cursorPickFillWindowStartPosition + this.mInitialRead;
            new Thread(new QueryThread(this.mCursorState), "query thread").start();
        }
    }
}
