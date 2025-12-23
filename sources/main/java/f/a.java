package f;

import androidx.annotation.IntRange;
import androidx.sqlite.SQLiteStatement;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final /* synthetic */ class a {
    public static void b(SQLiteStatement sQLiteStatement, @IntRange(from = 1) int i6, float f6) {
        sQLiteStatement.mo37bindDouble(i6, f6);
    }

    public static void c(SQLiteStatement sQLiteStatement, @IntRange(from = 1) int i6, int i7) {
        sQLiteStatement.mo38bindLong(i6, i7);
    }

    public static void a(SQLiteStatement sQLiteStatement, @IntRange(from = 1) int i6, boolean z5) {
        sQLiteStatement.mo38bindLong(i6, z5 ? 1L : 0L);
    }

    public static boolean d(SQLiteStatement sQLiteStatement, @IntRange(from = 0) int i6) {
        if (sQLiteStatement.getLong(i6) != 0) {
            return true;
        }
        return false;
    }

    @NotNull
    public static List e(SQLiteStatement sQLiteStatement) {
        int columnCount = sQLiteStatement.getColumnCount();
        ArrayList arrayList = new ArrayList(columnCount);
        for (int i6 = 0; i6 < columnCount; i6++) {
            arrayList.add(sQLiteStatement.getColumnName(i6));
        }
        return arrayList;
    }

    public static float f(SQLiteStatement sQLiteStatement, @IntRange(from = 0) int i6) {
        return (float) sQLiteStatement.getDouble(i6);
    }

    public static int g(SQLiteStatement sQLiteStatement, @IntRange(from = 0) int i6) {
        return (int) sQLiteStatement.getLong(i6);
    }
}
