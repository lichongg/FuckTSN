package net.sqlcipher;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class CursorWrapper extends android.database.CursorWrapper implements Cursor {
    private final Cursor mCursor;

    @Override // android.database.CursorWrapper, android.database.Cursor, net.sqlcipher.Cursor
    public int getType(int i6) {
        return this.mCursor.getType(i6);
    }

    @Override // android.database.CursorWrapper
    public Cursor getWrappedCursor() {
        return this.mCursor;
    }

    public CursorWrapper(Cursor cursor) {
        super(cursor);
        this.mCursor = cursor;
    }
}
