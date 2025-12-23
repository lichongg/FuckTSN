package net.sqlcipher.database;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class SQLiteClosable {
    private int mReferenceCount = 1;
    private Object mLock = new Object();

    protected abstract void onAllReferencesReleased();

    private String getObjInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getName());
        sb.append(" (");
        if (this instanceof SQLiteDatabase) {
            sb.append("database = ");
            sb.append(((SQLiteDatabase) this).getPath());
        } else if ((this instanceof SQLiteProgram) || (this instanceof SQLiteStatement) || (this instanceof SQLiteQuery)) {
            sb.append("mSql = ");
            sb.append(((SQLiteProgram) this).mSql);
        }
        sb.append(") ");
        return sb.toString();
    }

    public void acquireReference() {
        synchronized (this.mLock) {
            try {
                int i6 = this.mReferenceCount;
                if (i6 <= 0) {
                    throw new IllegalStateException("attempt to re-open an already-closed object: " + getObjInfo());
                }
                this.mReferenceCount = i6 + 1;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void releaseReference() {
        synchronized (this.mLock) {
            try {
                int i6 = this.mReferenceCount - 1;
                this.mReferenceCount = i6;
                if (i6 == 0) {
                    onAllReferencesReleased();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void releaseReferenceFromContainer() {
        synchronized (this.mLock) {
            try {
                int i6 = this.mReferenceCount - 1;
                this.mReferenceCount = i6;
                if (i6 == 0) {
                    onAllReferencesReleasedFromContainer();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    protected void onAllReferencesReleasedFromContainer() {
    }
}
