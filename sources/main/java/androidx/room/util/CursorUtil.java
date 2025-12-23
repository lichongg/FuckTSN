package androidx.room.util;

import android.database.Cursor;
import android.database.CursorWrapper;
import android.database.MatrixCursor;
import android.os.Build;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import kotlin.collections.n;
import kotlin.io.b;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.g0;
import kotlin.text.u;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
@JvmName(name = "CursorUtil")
@SourceDebugExtension({"SMAP\nCursorUtil.android.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CursorUtil.android.kt\nandroidx/room/util/CursorUtil\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,177:1\n146#1:178\n13467#2,3:179\n1#3:182\n*S KotlinDebug\n*F\n+ 1 CursorUtil.android.kt\nandroidx/room/util/CursorUtil\n*L\n39#1:178\n128#1:179,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
public final class CursorUtil {
    private static final int findColumnIndexBySuffix(Cursor cursor, String str) {
        if (Build.VERSION.SDK_INT > 25 || str.length() == 0) {
            return -1;
        }
        String[] columnNames = cursor.getColumnNames();
        g0.m(columnNames);
        return findColumnIndexBySuffix(columnNames, str);
    }

    @NotNull
    public static final Cursor copyAndClose(@NotNull Cursor c6) {
        g0.p(c6, "c");
        Cursor cursor = c6;
        try {
            Cursor cursor2 = cursor;
            MatrixCursor matrixCursor = new MatrixCursor(cursor2.getColumnNames(), cursor2.getCount());
            while (cursor2.moveToNext()) {
                Object[] objArr = new Object[cursor2.getColumnCount()];
                int columnCount = c6.getColumnCount();
                for (int i6 = 0; i6 < columnCount; i6++) {
                    int type = cursor2.getType(i6);
                    if (type == 0) {
                        objArr[i6] = null;
                    } else if (type == 1) {
                        objArr[i6] = Long.valueOf(cursor2.getLong(i6));
                    } else if (type == 2) {
                        objArr[i6] = Double.valueOf(cursor2.getDouble(i6));
                    } else if (type == 3) {
                        objArr[i6] = cursor2.getString(i6);
                    } else {
                        if (type != 4) {
                            throw new IllegalStateException();
                        }
                        objArr[i6] = cursor2.getBlob(i6);
                    }
                }
                matrixCursor.addRow(objArr);
            }
            b.a(cursor, null);
            return matrixCursor;
        } finally {
        }
    }

    public static final int getColumnIndex(@NotNull Cursor c6, @NotNull String name) {
        g0.p(c6, "c");
        g0.p(name, "name");
        int columnIndex = c6.getColumnIndex(name);
        if (columnIndex >= 0) {
            return columnIndex;
        }
        int columnIndex2 = c6.getColumnIndex('`' + name + '`');
        return columnIndex2 >= 0 ? columnIndex2 : findColumnIndexBySuffix(c6, name);
    }

    public static final int getColumnIndexOrThrow(@NotNull Cursor c6, @NotNull String name) {
        String str;
        g0.p(c6, "c");
        g0.p(name, "name");
        int columnIndex = getColumnIndex(c6, name);
        if (columnIndex >= 0) {
            return columnIndex;
        }
        try {
            String[] columnNames = c6.getColumnNames();
            g0.o(columnNames, "getColumnNames(...)");
            str = n.Eh(columnNames, null, null, null, 0, null, null, 63, null);
        } catch (Exception unused) {
            str = "unknown";
        }
        throw new IllegalArgumentException("column '" + name + "' does not exist. Available columns: " + str);
    }

    public static final <R> R useCursor(@NotNull Cursor cursor, @NotNull Function1<? super Cursor, ? extends R> block) {
        g0.p(cursor, "<this>");
        g0.p(block, "block");
        Cursor cursor2 = cursor;
        try {
            R invoke = block.invoke(cursor2);
            d0.d(1);
            b.a(cursor2, null);
            d0.c(1);
            return invoke;
        } finally {
        }
    }

    @NotNull
    public static final Cursor wrapMappedColumns(@NotNull final Cursor cursor, @NotNull final String[] columnNames, @NotNull final int[] mapping) {
        g0.p(cursor, "cursor");
        g0.p(columnNames, "columnNames");
        g0.p(mapping, "mapping");
        if (columnNames.length == mapping.length) {
            return new CursorWrapper(cursor) { // from class: androidx.room.util.CursorUtil$wrapMappedColumns$2
                @Override // android.database.CursorWrapper, android.database.Cursor
                public int getColumnIndex(String columnName) {
                    g0.p(columnName, "columnName");
                    String[] strArr = columnNames;
                    int[] iArr = mapping;
                    int length = strArr.length;
                    int i6 = 0;
                    int i7 = 0;
                    while (i6 < length) {
                        int i8 = i7 + 1;
                        if (u.a2(strArr[i6], columnName, true)) {
                            return iArr[i7];
                        }
                        i6++;
                        i7 = i8;
                    }
                    return super.getColumnIndex(columnName);
                }
            };
        }
        throw new IllegalStateException("Expected columnNames.length == mapping.length");
    }

    @VisibleForTesting
    public static final int findColumnIndexBySuffix(@NotNull String[] columnNames, @NotNull String name) {
        g0.p(columnNames, "columnNames");
        g0.p(name, "name");
        String str = '.' + name;
        String str2 = '.' + name + '`';
        int length = columnNames.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            String str3 = columnNames[i6];
            int i8 = i7 + 1;
            if (str3.length() >= name.length() + 2 && (u.Z1(str3, str, false, 2, null) || (str3.charAt(0) == '`' && u.Z1(str3, str2, false, 2, null)))) {
                return i7;
            }
            i6++;
            i7 = i8;
        }
        return -1;
    }
}
