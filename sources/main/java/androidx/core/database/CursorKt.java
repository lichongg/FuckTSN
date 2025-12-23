package androidx.core.database;

import android.database.Cursor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class CursorKt {
    @Nullable
    public static final byte[] getBlobOrNull(@NotNull Cursor cursor, int i6) {
        if (cursor.isNull(i6)) {
            return null;
        }
        return cursor.getBlob(i6);
    }

    @Nullable
    public static final Double getDoubleOrNull(@NotNull Cursor cursor, int i6) {
        if (cursor.isNull(i6)) {
            return null;
        }
        return Double.valueOf(cursor.getDouble(i6));
    }

    @Nullable
    public static final Float getFloatOrNull(@NotNull Cursor cursor, int i6) {
        if (cursor.isNull(i6)) {
            return null;
        }
        return Float.valueOf(cursor.getFloat(i6));
    }

    @Nullable
    public static final Integer getIntOrNull(@NotNull Cursor cursor, int i6) {
        if (cursor.isNull(i6)) {
            return null;
        }
        return Integer.valueOf(cursor.getInt(i6));
    }

    @Nullable
    public static final Long getLongOrNull(@NotNull Cursor cursor, int i6) {
        if (cursor.isNull(i6)) {
            return null;
        }
        return Long.valueOf(cursor.getLong(i6));
    }

    @Nullable
    public static final Short getShortOrNull(@NotNull Cursor cursor, int i6) {
        if (cursor.isNull(i6)) {
            return null;
        }
        return Short.valueOf(cursor.getShort(i6));
    }

    @Nullable
    public static final String getStringOrNull(@NotNull Cursor cursor, int i6) {
        if (cursor.isNull(i6)) {
            return null;
        }
        return cursor.getString(i6);
    }
}
