package androidx.room.util;

import androidx.annotation.RestrictTo;
import androidx.sqlite.SQLiteStatement;
import org.jetbrains.annotations.NotNull;

/* loaded from: D:\Downloads\app\classes.dex */
public final class SQLiteStatementUtil {
    public static final int columnIndexOf(@NotNull SQLiteStatement sQLiteStatement, @NotNull String str) {
        return SQLiteStatementUtil__StatementUtil_androidKt.columnIndexOf(sQLiteStatement, str);
    }

    public static final int columnIndexOfCommon(@NotNull SQLiteStatement sQLiteStatement, @NotNull String str) {
        return SQLiteStatementUtil__StatementUtilKt.columnIndexOfCommon(sQLiteStatement, str);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final int getColumnIndex(@NotNull SQLiteStatement sQLiteStatement, @NotNull String str) {
        return SQLiteStatementUtil__StatementUtilKt.getColumnIndex(sQLiteStatement, str);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final int getColumnIndexOrThrow(@NotNull SQLiteStatement sQLiteStatement, @NotNull String str) {
        return SQLiteStatementUtil__StatementUtilKt.getColumnIndexOrThrow(sQLiteStatement, str);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @NotNull
    public static final SQLiteStatement wrapMappedColumns(@NotNull SQLiteStatement sQLiteStatement, @NotNull String[] strArr, @NotNull int[] iArr) {
        return SQLiteStatementUtil__StatementUtilKt.wrapMappedColumns(sQLiteStatement, strArr, iArr);
    }
}
