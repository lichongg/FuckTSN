package androidx.room.util;

import android.os.Build;
import androidx.sqlite.SQLiteStatement;
import kotlin.jvm.internal.g0;
import kotlin.text.u;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
final /* synthetic */ class SQLiteStatementUtil__StatementUtil_androidKt {
    public static final int columnIndexOf(@NotNull SQLiteStatement sQLiteStatement, @NotNull String name) {
        g0.p(sQLiteStatement, "<this>");
        g0.p(name, "name");
        int columnIndexOfCommon = SQLiteStatementUtil.columnIndexOfCommon(sQLiteStatement, name);
        if (columnIndexOfCommon >= 0) {
            return columnIndexOfCommon;
        }
        int columnIndexOfCommon2 = SQLiteStatementUtil.columnIndexOfCommon(sQLiteStatement, '`' + name + '`');
        return columnIndexOfCommon2 >= 0 ? columnIndexOfCommon2 : findColumnIndexBySuffix$SQLiteStatementUtil__StatementUtil_androidKt(sQLiteStatement, name);
    }

    private static final int findColumnIndexBySuffix$SQLiteStatementUtil__StatementUtil_androidKt(SQLiteStatement sQLiteStatement, String str) {
        if (Build.VERSION.SDK_INT <= 25 && str.length() != 0) {
            int columnCount = sQLiteStatement.getColumnCount();
            String str2 = '.' + str;
            String str3 = '.' + str + '`';
            for (int i6 = 0; i6 < columnCount; i6++) {
                String columnName = sQLiteStatement.getColumnName(i6);
                if (columnName.length() >= str.length() + 2 && (u.Z1(columnName, str2, false, 2, null) || (columnName.charAt(0) == '`' && u.Z1(columnName, str3, false, 2, null)))) {
                    return i6;
                }
            }
        }
        return -1;
    }
}
