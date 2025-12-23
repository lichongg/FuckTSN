package net.sqlcipher;

import android.content.ContentResolver;
import android.database.CharArrayBuffer;
import android.database.ContentObservable;
import android.database.ContentObserver;
import android.database.CrossProcessCursor;
import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class AbstractCursor implements CrossProcessCursor, Cursor {
    private static final String TAG = "Cursor";
    protected ContentResolver mContentResolver;
    private Uri mNotifyUri;
    private ContentObserver mSelfObserver;
    private boolean mSelfObserverRegistered;
    DataSetObservable mDataSetObservable = new DataSetObservable();
    ContentObservable mContentObservable = new ContentObservable();
    private Bundle mExtras = Bundle.EMPTY;
    protected boolean mClosed = false;
    private final Object mSelfObserverLock = new Object();
    protected int mPos = -1;
    protected int mRowIdColumnIndex = -1;
    protected Long mCurrentRowID = null;
    protected HashMap<Long, Map<String, Object>> mUpdatedRows = new HashMap<>();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    protected static class SelfContentObserver extends ContentObserver {
        WeakReference<AbstractCursor> mCursor;

        public SelfContentObserver(AbstractCursor abstractCursor) {
            super(null);
            this.mCursor = new WeakReference<>(abstractCursor);
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return false;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z5) {
            AbstractCursor abstractCursor = this.mCursor.get();
            if (abstractCursor != null) {
                abstractCursor.onChange(false);
            }
        }
    }

    protected void checkPosition() {
        if (-1 == this.mPos || getCount() == this.mPos) {
            throw new CursorIndexOutOfBoundsException(this.mPos, getCount());
        }
    }

    @Override // android.database.Cursor, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.mClosed = true;
        this.mContentObservable.unregisterAll();
        deactivateInternal();
    }

    public boolean commitUpdates(Map<? extends Long, ? extends Map<String, Object>> map) {
        return false;
    }

    public boolean deleteRow() {
        return false;
    }

    @Override // android.database.Cursor
    public abstract String[] getColumnNames();

    @Override // android.database.Cursor
    public abstract int getCount();

    @Override // android.database.Cursor
    public abstract double getDouble(int i6);

    @Override // android.database.Cursor
    public abstract float getFloat(int i6);

    @Override // android.database.Cursor
    public abstract int getInt(int i6);

    @Override // android.database.Cursor
    public abstract long getLong(int i6);

    @Override // android.database.Cursor
    public abstract short getShort(int i6);

    @Override // android.database.Cursor
    public abstract String getString(int i6);

    @Override // android.database.Cursor, net.sqlcipher.Cursor
    public abstract int getType(int i6);

    @Override // android.database.Cursor
    public boolean getWantsAllOnMoveCalls() {
        return false;
    }

    @Override // android.database.CrossProcessCursor
    public CursorWindow getWindow() {
        return null;
    }

    @Override // android.database.Cursor
    public abstract boolean isNull(int i6);

    @Override // android.database.Cursor
    public final boolean moveToFirst() {
        return moveToPosition(0);
    }

    @Override // android.database.CrossProcessCursor
    public boolean onMove(int i6, int i7) {
        return true;
    }

    public boolean updateToNull(int i6) {
        return update(i6, null);
    }

    public void abortUpdates() {
        synchronized (this.mUpdatedRows) {
            this.mUpdatedRows.clear();
        }
    }

    public boolean commitUpdates() {
        return commitUpdates(null);
    }

    public void deactivateInternal() {
        ContentObserver contentObserver = this.mSelfObserver;
        if (contentObserver != null) {
            this.mContentResolver.unregisterContentObserver(contentObserver);
            this.mSelfObserverRegistered = false;
        }
        this.mDataSetObservable.notifyInvalidated();
    }

    protected void finalize() {
        ContentObserver contentObserver = this.mSelfObserver;
        if (contentObserver == null || !this.mSelfObserverRegistered) {
            return;
        }
        this.mContentResolver.unregisterContentObserver(contentObserver);
    }

    @Override // android.database.Cursor
    public byte[] getBlob(int i6) {
        throw new UnsupportedOperationException("getBlob is not supported");
    }

    @Override // android.database.Cursor
    public int getColumnIndex(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf != -1) {
            new Exception();
            str = str.substring(lastIndexOf + 1);
        }
        String[] columnNames = getColumnNames();
        int length = columnNames.length;
        for (int i6 = 0; i6 < length; i6++) {
            if (columnNames[i6].equalsIgnoreCase(str)) {
                return i6;
            }
        }
        return -1;
    }

    protected DataSetObservable getDataSetObservable() {
        return this.mDataSetObservable;
    }

    @Override // android.database.Cursor
    public Bundle getExtras() {
        return this.mExtras;
    }

    @Override // android.database.Cursor
    public Uri getNotificationUri() {
        return this.mNotifyUri;
    }

    @Override // android.database.Cursor
    public final int getPosition() {
        return this.mPos;
    }

    protected Object getUpdatedField(int i6) {
        return this.mUpdatedRows.get(this.mCurrentRowID).get(getColumnNames()[i6]);
    }

    public boolean hasUpdates() {
        boolean z5;
        synchronized (this.mUpdatedRows) {
            z5 = this.mUpdatedRows.size() > 0;
        }
        return z5;
    }

    @Override // android.database.Cursor
    public boolean isClosed() {
        return this.mClosed;
    }

    protected boolean isFieldUpdated(int i6) {
        Map<String, Object> map;
        return this.mRowIdColumnIndex != -1 && this.mUpdatedRows.size() > 0 && (map = this.mUpdatedRows.get(this.mCurrentRowID)) != null && map.containsKey(getColumnNames()[i6]);
    }

    @Override // android.database.Cursor
    public final boolean isFirst() {
        return this.mPos == 0 && getCount() != 0;
    }

    @Override // android.database.Cursor
    public final boolean move(int i6) {
        return moveToPosition(this.mPos + i6);
    }

    @Override // android.database.Cursor
    public final boolean moveToNext() {
        return moveToPosition(this.mPos + 1);
    }

    @Override // android.database.Cursor
    public final boolean moveToPrevious() {
        return moveToPosition(this.mPos - 1);
    }

    protected void notifyDataSetChange() {
        this.mDataSetObservable.notifyChanged();
    }

    protected void onChange(boolean z5) {
        synchronized (this.mSelfObserverLock) {
            try {
                this.mContentObservable.dispatchChange(z5);
                Uri uri = this.mNotifyUri;
                if (uri != null && z5) {
                    this.mContentResolver.notifyChange(uri, this.mSelfObserver);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.database.Cursor
    public void registerContentObserver(ContentObserver contentObserver) {
        this.mContentObservable.registerObserver(contentObserver);
    }

    @Override // android.database.Cursor
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        this.mDataSetObservable.registerObserver(dataSetObserver);
    }

    @Override // android.database.Cursor
    public boolean requery() {
        ContentObserver contentObserver = this.mSelfObserver;
        if (contentObserver != null && !this.mSelfObserverRegistered) {
            this.mContentResolver.registerContentObserver(this.mNotifyUri, true, contentObserver);
            this.mSelfObserverRegistered = true;
        }
        this.mDataSetObservable.notifyChanged();
        return true;
    }

    @Override // android.database.Cursor
    public Bundle respond(Bundle bundle) {
        return Bundle.EMPTY;
    }

    @Override // android.database.Cursor
    public void setExtras(Bundle bundle) {
        if (bundle == null) {
            bundle = Bundle.EMPTY;
        }
        this.mExtras = bundle;
    }

    @Override // android.database.Cursor
    public void setNotificationUri(ContentResolver contentResolver, Uri uri) {
        synchronized (this.mSelfObserverLock) {
            try {
                this.mNotifyUri = uri;
                this.mContentResolver = contentResolver;
                ContentObserver contentObserver = this.mSelfObserver;
                if (contentObserver != null) {
                    contentResolver.unregisterContentObserver(contentObserver);
                }
                SelfContentObserver selfContentObserver = new SelfContentObserver(this);
                this.mSelfObserver = selfContentObserver;
                this.mContentResolver.registerContentObserver(this.mNotifyUri, true, selfContentObserver);
                this.mSelfObserverRegistered = true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean supportsUpdates() {
        return this.mRowIdColumnIndex != -1;
    }

    @Override // android.database.Cursor
    public void unregisterContentObserver(ContentObserver contentObserver) {
        if (this.mClosed) {
            return;
        }
        this.mContentObservable.unregisterObserver(contentObserver);
    }

    @Override // android.database.Cursor
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        this.mDataSetObservable.unregisterObserver(dataSetObserver);
    }

    @Override // android.database.Cursor
    public void copyStringToBuffer(int i6, CharArrayBuffer charArrayBuffer) {
        String string = getString(i6);
        if (string != null) {
            char[] cArr = charArrayBuffer.data;
            if (cArr != null && cArr.length >= string.length()) {
                string.getChars(0, string.length(), cArr, 0);
            } else {
                charArrayBuffer.data = string.toCharArray();
            }
            charArrayBuffer.sizeCopied = string.length();
            return;
        }
        charArrayBuffer.sizeCopied = 0;
    }

    @Override // android.database.Cursor
    public void deactivate() {
        deactivateInternal();
    }

    @Override // android.database.CrossProcessCursor
    public void fillWindow(int i6, android.database.CursorWindow cursorWindow) {
        DatabaseUtils.cursorFillWindow(this, i6, cursorWindow);
    }

    @Override // android.database.Cursor
    public int getColumnCount() {
        return getColumnNames().length;
    }

    @Override // android.database.Cursor
    public int getColumnIndexOrThrow(String str) {
        int columnIndex = getColumnIndex(str);
        if (columnIndex >= 0) {
            return columnIndex;
        }
        throw new IllegalArgumentException("column '" + str + "' does not exist");
    }

    @Override // android.database.Cursor
    public String getColumnName(int i6) {
        return getColumnNames()[i6];
    }

    @Override // android.database.Cursor
    public final boolean isAfterLast() {
        if (getCount() == 0 || this.mPos == getCount()) {
            return true;
        }
        return false;
    }

    @Override // android.database.Cursor
    public final boolean isBeforeFirst() {
        if (getCount() == 0 || this.mPos == -1) {
            return true;
        }
        return false;
    }

    @Override // android.database.Cursor
    public final boolean isLast() {
        int count = getCount();
        if (this.mPos == count - 1 && count != 0) {
            return true;
        }
        return false;
    }

    @Override // android.database.Cursor
    public final boolean moveToLast() {
        return moveToPosition(getCount() - 1);
    }

    @Override // android.database.Cursor
    public final boolean moveToPosition(int i6) {
        int count = getCount();
        if (i6 >= count) {
            this.mPos = count;
            return false;
        }
        if (i6 < 0) {
            this.mPos = -1;
            return false;
        }
        int i7 = this.mPos;
        if (i6 == i7) {
            return true;
        }
        boolean onMove = onMove(i7, i6);
        if (!onMove) {
            this.mPos = -1;
            return onMove;
        }
        this.mPos = i6;
        int i8 = this.mRowIdColumnIndex;
        if (i8 != -1) {
            this.mCurrentRowID = Long.valueOf(getLong(i8));
        }
        return onMove;
    }

    public boolean update(int i6, Object obj) {
        if (!supportsUpdates()) {
            return false;
        }
        Long valueOf = Long.valueOf(getLong(this.mRowIdColumnIndex));
        synchronized (this.mUpdatedRows) {
            try {
                Map<String, Object> map = this.mUpdatedRows.get(valueOf);
                if (map == null) {
                    map = new HashMap<>();
                    this.mUpdatedRows.put(valueOf, map);
                }
                map.put(getColumnNames()[i6], obj);
            } catch (Throwable th) {
                throw th;
            }
        }
        return true;
    }

    public boolean updateBlob(int i6, byte[] bArr) {
        return update(i6, bArr);
    }

    public boolean updateDouble(int i6, double d6) {
        return update(i6, Double.valueOf(d6));
    }

    public boolean updateFloat(int i6, float f6) {
        return update(i6, Float.valueOf(f6));
    }

    public boolean updateInt(int i6, int i7) {
        return update(i6, Integer.valueOf(i7));
    }

    public boolean updateLong(int i6, long j6) {
        return update(i6, Long.valueOf(j6));
    }

    public boolean updateShort(int i6, short s5) {
        return update(i6, Short.valueOf(s5));
    }

    public boolean updateString(int i6, String str) {
        return update(i6, str);
    }
}
