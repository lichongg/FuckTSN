package net.sqlcipher;

import android.database.CrossProcessCursor;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class CrossProcessCursorWrapper extends CursorWrapper implements CrossProcessCursor {
    @Override // android.database.CrossProcessCursor
    public android.database.CursorWindow getWindow() {
        return null;
    }

    @Override // android.database.CrossProcessCursor
    public boolean onMove(int i6, int i7) {
        return true;
    }

    public CrossProcessCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    @Override // android.database.CrossProcessCursor
    public void fillWindow(int i6, android.database.CursorWindow cursorWindow) {
        DatabaseUtils.cursorFillWindow(this, i6, cursorWindow);
    }
}
