package androidx.room.util;

import androidx.annotation.RestrictTo;
import androidx.sqlite.SQLiteStatement;
import java.util.ArrayList;
import kotlin.collections.f0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nStatementUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StatementUtil.kt\nandroidx/room/util/SQLiteStatementUtil__StatementUtilKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,112:1\n1#2:113\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
final /* synthetic */ class SQLiteStatementUtil__StatementUtilKt {
    public static final int columnIndexOfCommon(@NotNull SQLiteStatement sQLiteStatement, @NotNull String name) {
        g0.p(sQLiteStatement, "<this>");
        g0.p(name, "name");
        if (sQLiteStatement instanceof MappedColumnsSQLiteStatementWrapper) {
            return ((MappedColumnsSQLiteStatementWrapper) sQLiteStatement).getColumnIndex(name);
        }
        int columnCount = sQLiteStatement.getColumnCount();
        for (int i6 = 0; i6 < columnCount; i6++) {
            if (g0.g(name, sQLiteStatement.getColumnName(i6))) {
                return i6;
            }
        }
        return -1;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final int getColumnIndex(@NotNull SQLiteStatement stmt, @NotNull String name) {
        g0.p(stmt, "stmt");
        g0.p(name, "name");
        return SQLiteStatementUtil.columnIndexOf(stmt, name);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final int getColumnIndexOrThrow(@NotNull SQLiteStatement stmt, @NotNull String name) {
        g0.p(stmt, "stmt");
        g0.p(name, "name");
        int columnIndexOf = SQLiteStatementUtil.columnIndexOf(stmt, name);
        if (columnIndexOf >= 0) {
            return columnIndexOf;
        }
        int columnCount = stmt.getColumnCount();
        ArrayList arrayList = new ArrayList(columnCount);
        for (int i6 = 0; i6 < columnCount; i6++) {
            arrayList.add(stmt.getColumnName(i6));
        }
        throw new IllegalArgumentException("Column '" + name + "' does not exist. Available columns: [" + f0.r3(arrayList, null, null, null, 0, null, null, 63, null) + ']');
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @NotNull
    public static final SQLiteStatement wrapMappedColumns(@NotNull SQLiteStatement statement, @NotNull String[] columnNames, @NotNull int[] mapping) {
        g0.p(statement, "statement");
        g0.p(columnNames, "columnNames");
        g0.p(mapping, "mapping");
        return new MappedColumnsSQLiteStatementWrapper(statement, columnNames, mapping);
    }
}
