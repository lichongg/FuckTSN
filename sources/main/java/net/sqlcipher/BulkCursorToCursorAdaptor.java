package net.sqlcipher;

import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.os.RemoteException;
import com.umeng.analytics.pro.bm;
import java.util.Map;
import net.sqlcipher.AbstractCursor;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class BulkCursorToCursorAdaptor extends AbstractWindowedCursor {
    private static final String TAG = "BulkCursor";
    private IBulkCursor mBulkCursor;
    private String[] mColumns;
    private int mCount;
    private AbstractCursor.SelfContentObserver mObserverBridge;
    private boolean mWantsAllOnMoveCalls;

    public static int findRowIdColumnIndex(String[] strArr) {
        int length = strArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            if (strArr[i6].equals(bm.f41039d)) {
                return i6;
            }
        }
        return -1;
    }

    public synchronized IContentObserver getObserver() {
        if (this.mObserverBridge == null) {
            this.mObserverBridge = new AbstractCursor.SelfContentObserver(this);
        }
        return null;
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.CrossProcessCursor
    public boolean onMove(int i6, int i7) {
        try {
            CursorWindow cursorWindow = this.mWindow;
            if (cursorWindow != null) {
                if (i7 >= cursorWindow.getStartPosition() && i7 < this.mWindow.getStartPosition() + this.mWindow.getNumRows()) {
                    if (this.mWantsAllOnMoveCalls) {
                        this.mBulkCursor.onMove(i7);
                    }
                }
                this.mWindow = this.mBulkCursor.getWindow(i7);
            } else {
                this.mWindow = this.mBulkCursor.getWindow(i7);
            }
            return this.mWindow != null;
        } catch (RemoteException unused) {
            return false;
        }
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public boolean requery() {
        try {
            int requery = this.mBulkCursor.requery(getObserver(), new CursorWindow(false));
            this.mCount = requery;
            if (requery == -1) {
                deactivate();
                return false;
            }
            this.mPos = -1;
            this.mWindow = null;
            super.requery();
            return true;
        } catch (Exception e6) {
            e6.getMessage();
            deactivate();
            return false;
        }
    }

    public void set(IBulkCursor iBulkCursor) {
        this.mBulkCursor = iBulkCursor;
        try {
            this.mCount = iBulkCursor.count();
            this.mWantsAllOnMoveCalls = this.mBulkCursor.getWantsAllOnMoveCalls();
            String[] columnNames = this.mBulkCursor.getColumnNames();
            this.mColumns = columnNames;
            this.mRowIdColumnIndex = findRowIdColumnIndex(columnNames);
        } catch (RemoteException unused) {
        }
    }

    @Override // net.sqlcipher.AbstractCursor
    public boolean deleteRow() {
        try {
            boolean deleteRow = this.mBulkCursor.deleteRow(this.mPos);
            if (deleteRow) {
                this.mWindow = null;
                int count = this.mBulkCursor.count();
                this.mCount = count;
                int i6 = this.mPos;
                if (i6 < count) {
                    this.mPos = -1;
                    moveToPosition(i6);
                } else {
                    this.mPos = count;
                }
                onChange(true);
            }
            return deleteRow;
        } catch (RemoteException unused) {
            return false;
        }
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public String[] getColumnNames() {
        if (this.mColumns == null) {
            try {
                this.mColumns = this.mBulkCursor.getColumnNames();
            } catch (RemoteException unused) {
                return null;
            }
        }
        return this.mColumns;
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public int getCount() {
        return this.mCount;
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public Bundle getExtras() {
        try {
            return this.mBulkCursor.getExtras();
        } catch (RemoteException e6) {
            throw new RuntimeException(e6);
        }
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public Bundle respond(Bundle bundle) {
        try {
            return this.mBulkCursor.respond(bundle);
        } catch (RemoteException unused) {
            return Bundle.EMPTY;
        }
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        super.close();
        try {
            this.mBulkCursor.close();
        } catch (RemoteException unused) {
        }
        this.mWindow = null;
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
            if (this.mUpdatedRows.size() <= 0) {
                return false;
            }
            try {
                boolean updateRows = this.mBulkCursor.updateRows(this.mUpdatedRows);
                if (updateRows) {
                    this.mUpdatedRows.clear();
                    onChange(true);
                }
                return updateRows;
            } catch (RemoteException unused) {
                return false;
            }
        }
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public void deactivate() {
        super.deactivate();
        try {
            this.mBulkCursor.deactivate();
        } catch (RemoteException unused) {
        }
        this.mWindow = null;
    }

    public void set(IBulkCursor iBulkCursor, int i6, int i7) {
        this.mBulkCursor = iBulkCursor;
        this.mColumns = null;
        this.mCount = i6;
        this.mRowIdColumnIndex = i7;
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public void registerContentObserver(ContentObserver contentObserver) {
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public void unregisterContentObserver(ContentObserver contentObserver) {
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
    }

    @Override // net.sqlcipher.AbstractWindowedCursor, net.sqlcipher.AbstractCursor, android.database.Cursor
    public void copyStringToBuffer(int i6, CharArrayBuffer charArrayBuffer) {
    }
}
