package com.google.android.gms.common.sqlite;

import android.database.AbstractWindowedCursor;
import android.database.CrossProcessCursor;
import android.database.Cursor;
import android.database.CursorWindow;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KeepForSdk
/* loaded from: D:\Downloads\app\classes5.dex */
public class CursorWrapper extends android.database.CursorWrapper implements CrossProcessCursor {
    private AbstractWindowedCursor zza;

    @Override // android.database.CrossProcessCursor
    @KeepForSdk
    public void fillWindow(int i6, @NonNull CursorWindow cursorWindow) {
        this.zza.fillWindow(i6, cursorWindow);
    }

    @Override // android.database.CrossProcessCursor
    @Nullable
    @ResultIgnorabilityUnspecified
    @KeepForSdk
    public CursorWindow getWindow() {
        return this.zza.getWindow();
    }

    @Override // android.database.CursorWrapper
    @NonNull
    public final /* synthetic */ Cursor getWrappedCursor() {
        return this.zza;
    }

    @Override // android.database.CrossProcessCursor
    @ResultIgnorabilityUnspecified
    public final boolean onMove(int i6, int i7) {
        return this.zza.onMove(i6, i7);
    }

    @KeepForSdk
    public void setWindow(@Nullable CursorWindow cursorWindow) {
        this.zza.setWindow(cursorWindow);
    }

    @KeepForSdk
    public CursorWrapper(@NonNull Cursor cursor) {
        super(cursor);
        for (int i6 = 0; i6 < 10 && (cursor instanceof android.database.CursorWrapper); i6++) {
            cursor = ((android.database.CursorWrapper) cursor).getWrappedCursor();
        }
        if (cursor instanceof AbstractWindowedCursor) {
            this.zza = (AbstractWindowedCursor) cursor;
            return;
        }
        throw new IllegalArgumentException("Unknown type: ".concat(cursor.getClass().getName()));
    }
}
