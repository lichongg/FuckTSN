package net.sqlcipher;

import android.database.CharArrayBuffer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class AbstractWindowedCursor extends AbstractCursor {
    protected CursorWindow mWindow;

    @Override // net.sqlcipher.AbstractCursor, android.database.CrossProcessCursor
    public CursorWindow getWindow() {
        return this.mWindow;
    }

    public boolean hasWindow() {
        return this.mWindow != null;
    }

    public void setWindow(CursorWindow cursorWindow) {
        CursorWindow cursorWindow2 = this.mWindow;
        if (cursorWindow2 != null) {
            cursorWindow2.close();
        }
        this.mWindow = cursorWindow;
    }

    @Override // net.sqlcipher.AbstractCursor
    protected void checkPosition() {
        super.checkPosition();
        if (this.mWindow != null) {
        } else {
            throw new StaleDataException("Access closed cursor");
        }
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public void copyStringToBuffer(int i6, CharArrayBuffer charArrayBuffer) {
        checkPosition();
        synchronized (this.mUpdatedRows) {
            try {
                if (isFieldUpdated(i6)) {
                    super.copyStringToBuffer(i6, charArrayBuffer);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.mWindow.copyStringToBuffer(this.mPos, i6, charArrayBuffer);
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public byte[] getBlob(int i6) {
        checkPosition();
        synchronized (this.mUpdatedRows) {
            try {
                if (isFieldUpdated(i6)) {
                    return (byte[]) getUpdatedField(i6);
                }
                return this.mWindow.getBlob(this.mPos, i6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public double getDouble(int i6) {
        checkPosition();
        synchronized (this.mUpdatedRows) {
            try {
                if (isFieldUpdated(i6)) {
                    return ((Number) getUpdatedField(i6)).doubleValue();
                }
                return this.mWindow.getDouble(this.mPos, i6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public float getFloat(int i6) {
        checkPosition();
        synchronized (this.mUpdatedRows) {
            try {
                if (isFieldUpdated(i6)) {
                    return ((Number) getUpdatedField(i6)).floatValue();
                }
                return this.mWindow.getFloat(this.mPos, i6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public int getInt(int i6) {
        checkPosition();
        synchronized (this.mUpdatedRows) {
            try {
                if (isFieldUpdated(i6)) {
                    return ((Number) getUpdatedField(i6)).intValue();
                }
                return this.mWindow.getInt(this.mPos, i6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public long getLong(int i6) {
        checkPosition();
        synchronized (this.mUpdatedRows) {
            try {
                if (isFieldUpdated(i6)) {
                    return ((Number) getUpdatedField(i6)).longValue();
                }
                return this.mWindow.getLong(this.mPos, i6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public short getShort(int i6) {
        checkPosition();
        synchronized (this.mUpdatedRows) {
            try {
                if (isFieldUpdated(i6)) {
                    return ((Number) getUpdatedField(i6)).shortValue();
                }
                return this.mWindow.getShort(this.mPos, i6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public String getString(int i6) {
        checkPosition();
        synchronized (this.mUpdatedRows) {
            try {
                if (isFieldUpdated(i6)) {
                    return (String) getUpdatedField(i6);
                }
                return this.mWindow.getString(this.mPos, i6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor, net.sqlcipher.Cursor
    public int getType(int i6) {
        checkPosition();
        return this.mWindow.getType(this.mPos, i6);
    }

    public boolean isBlob(int i6) {
        boolean z5;
        checkPosition();
        synchronized (this.mUpdatedRows) {
            try {
                if (isFieldUpdated(i6)) {
                    Object updatedField = getUpdatedField(i6);
                    if (updatedField != null && !(updatedField instanceof byte[])) {
                        z5 = false;
                        return z5;
                    }
                    z5 = true;
                    return z5;
                }
                return this.mWindow.isBlob(this.mPos, i6);
            } finally {
            }
        }
    }

    public boolean isFloat(int i6) {
        boolean z5;
        checkPosition();
        synchronized (this.mUpdatedRows) {
            try {
                if (isFieldUpdated(i6)) {
                    Object updatedField = getUpdatedField(i6);
                    if (updatedField == null || (!(updatedField instanceof Float) && !(updatedField instanceof Double))) {
                        z5 = false;
                        return z5;
                    }
                    z5 = true;
                    return z5;
                }
                return this.mWindow.isFloat(this.mPos, i6);
            } finally {
            }
        }
    }

    public boolean isLong(int i6) {
        boolean z5;
        checkPosition();
        synchronized (this.mUpdatedRows) {
            try {
                if (isFieldUpdated(i6)) {
                    Object updatedField = getUpdatedField(i6);
                    if (updatedField == null || (!(updatedField instanceof Integer) && !(updatedField instanceof Long))) {
                        z5 = false;
                        return z5;
                    }
                    z5 = true;
                    return z5;
                }
                return this.mWindow.isLong(this.mPos, i6);
            } finally {
            }
        }
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public boolean isNull(int i6) {
        boolean z5;
        checkPosition();
        synchronized (this.mUpdatedRows) {
            try {
                if (isFieldUpdated(i6)) {
                    if (getUpdatedField(i6) == null) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    return z5;
                }
                return this.mWindow.isNull(this.mPos, i6);
            } finally {
            }
        }
    }

    public boolean isString(int i6) {
        boolean z5;
        checkPosition();
        synchronized (this.mUpdatedRows) {
            try {
                if (isFieldUpdated(i6)) {
                    Object updatedField = getUpdatedField(i6);
                    if (updatedField != null && !(updatedField instanceof String)) {
                        z5 = false;
                        return z5;
                    }
                    z5 = true;
                    return z5;
                }
                return this.mWindow.isString(this.mPos, i6);
            } finally {
            }
        }
    }
}
