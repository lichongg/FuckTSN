package androidx.room.util;

import androidx.room.util.TableInfo;
import com.snail.antifake.deviceid.e;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import kotlin.collections.f0;
import kotlin.comparisons.a;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import kotlin.text.u;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nTableInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TableInfo.kt\nandroidx/room/util/TableInfoKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n*L\n1#1,397:1\n1053#2:398\n1053#2:399\n1188#3,3:400\n*S KotlinDebug\n*F\n+ 1 TableInfo.kt\nandroidx/room/util/TableInfoKt\n*L\n192#1:398\n194#1:399\n261#1:400,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
public final class TableInfoKt {
    public static final boolean equalsCommon(@NotNull TableInfo tableInfo, @Nullable Object obj) {
        Set<TableInfo.Index> set;
        g0.p(tableInfo, "<this>");
        if (tableInfo == obj) {
            return true;
        }
        if (!(obj instanceof TableInfo)) {
            return false;
        }
        TableInfo tableInfo2 = (TableInfo) obj;
        if (!g0.g(tableInfo.name, tableInfo2.name) || !g0.g(tableInfo.columns, tableInfo2.columns) || !g0.g(tableInfo.foreignKeys, tableInfo2.foreignKeys)) {
            return false;
        }
        Set<TableInfo.Index> set2 = tableInfo.indices;
        if (set2 == null || (set = tableInfo2.indices) == null) {
            return true;
        }
        return g0.g(set2, set);
    }

    public static final int hashCodeCommon(@NotNull TableInfo tableInfo) {
        g0.p(tableInfo, "<this>");
        return (((tableInfo.name.hashCode() * 31) + tableInfo.columns.hashCode()) * 31) + tableInfo.foreignKeys.hashCode();
    }

    private static final void joinToStringEndWithIndent(Collection<?> collection) {
        u.o(f0.r3(collection, ",", null, null, 0, null, null, 62, null), null, 1, null);
        u.o(" }", null, 1, null);
    }

    private static final void joinToStringMiddleWithIndent(Collection<?> collection) {
        u.o(f0.r3(collection, ",", null, null, 0, null, null, 62, null), null, 1, null);
        u.o("},", null, 1, null);
    }

    @NotNull
    public static final String toStringCommon(@NotNull TableInfo tableInfo) {
        List J;
        g0.p(tableInfo, "<this>");
        StringBuilder sb = new StringBuilder();
        sb.append("\n            |TableInfo {\n            |    name = '");
        sb.append(tableInfo.name);
        sb.append("',\n            |    columns = {");
        sb.append(formatString(f0.z5(tableInfo.columns.values(), new Comparator() { // from class: androidx.room.util.TableInfoKt$toStringCommon$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t5, T t6) {
                return a.l(((TableInfo.Column) t5).name, ((TableInfo.Column) t6).name);
            }
        })));
        sb.append("\n            |    foreignKeys = {");
        sb.append(formatString(tableInfo.foreignKeys));
        sb.append("\n            |    indices = {");
        Set<TableInfo.Index> set = tableInfo.indices;
        if (set == null || (J = f0.z5(set, new Comparator() { // from class: androidx.room.util.TableInfoKt$toStringCommon$$inlined$sortedBy$2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t5, T t6) {
                return a.l(((TableInfo.Index) t5).name, ((TableInfo.Index) t6).name);
            }
        })) == null) {
            J = f0.J();
        }
        sb.append(formatString(J));
        sb.append("\n            |}\n        ");
        return u.x(sb.toString(), null, 1, null);
    }

    public static final boolean defaultValueEqualsCommon(@NotNull String current, @Nullable String str) {
        g0.p(current, "current");
        if (g0.g(current, str)) {
            return true;
        }
        if (!containsSurroundingParenthesis(current)) {
            return false;
        }
        String substring = current.substring(1, current.length() - 1);
        g0.o(substring, "substring(...)");
        return g0.g(u.Z5(substring).toString(), str);
    }

    @NotNull
    public static final String formatString(@NotNull Collection<?> collection) {
        g0.p(collection, "collection");
        if (collection.isEmpty()) {
            return " }";
        }
        return u.o(f0.r3(collection, ",\n", e.f37542d, e.f37542d, 0, null, null, 56, null), null, 1, null) + "},";
    }

    private static final boolean containsSurroundingParenthesis(String str) {
        if (str.length() == 0) {
            return false;
        }
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (i6 < str.length()) {
            char charAt = str.charAt(i6);
            int i9 = i8 + 1;
            if (i8 == 0 && charAt != '(') {
                return false;
            }
            if (charAt != '(') {
                if (charAt == ')' && i7 - 1 == 0 && i8 != str.length() - 1) {
                    return false;
                }
            } else {
                i7++;
            }
            i6++;
            i8 = i9;
        }
        if (i7 != 0) {
            return false;
        }
        return true;
    }

    public static final int hashCodeCommon(@NotNull TableInfo.Column column) {
        g0.p(column, "<this>");
        return (((((column.name.hashCode() * 31) + column.affinity) * 31) + (column.notNull ? 1231 : 1237)) * 31) + column.primaryKeyPosition;
    }

    public static final boolean equalsCommon(@NotNull TableInfo.Column column, @Nullable Object obj) {
        g0.p(column, "<this>");
        if (column == obj) {
            return true;
        }
        if (!(obj instanceof TableInfo.Column)) {
            return false;
        }
        TableInfo.Column column2 = (TableInfo.Column) obj;
        if (column.isPrimaryKey() != column2.isPrimaryKey() || !g0.g(column.name, column2.name) || column.notNull != column2.notNull) {
            return false;
        }
        String str = column.defaultValue;
        String str2 = column2.defaultValue;
        if (column.createdFrom == 1 && column2.createdFrom == 2 && str != null && !defaultValueEqualsCommon(str, str2)) {
            return false;
        }
        if (column.createdFrom == 2 && column2.createdFrom == 1 && str2 != null && !defaultValueEqualsCommon(str2, str)) {
            return false;
        }
        int i6 = column.createdFrom;
        return (i6 == 0 || i6 != column2.createdFrom || (str == null ? str2 == null : defaultValueEqualsCommon(str, str2))) && column.affinity == column2.affinity;
    }

    public static final int hashCodeCommon(@NotNull TableInfo.ForeignKey foreignKey) {
        g0.p(foreignKey, "<this>");
        return (((((((foreignKey.referenceTable.hashCode() * 31) + foreignKey.onDelete.hashCode()) * 31) + foreignKey.onUpdate.hashCode()) * 31) + foreignKey.columnNames.hashCode()) * 31) + foreignKey.referenceColumnNames.hashCode();
    }

    public static final int hashCodeCommon(@NotNull TableInfo.Index index) {
        g0.p(index, "<this>");
        return ((((((u.H2(index.name, TableInfo.Index.DEFAULT_PREFIX, false, 2, null) ? -1184239155 : index.name.hashCode()) * 31) + (index.unique ? 1 : 0)) * 31) + index.columns.hashCode()) * 31) + index.orders.hashCode();
    }

    public static final boolean equalsCommon(@NotNull TableInfo.ForeignKey foreignKey, @Nullable Object obj) {
        g0.p(foreignKey, "<this>");
        if (foreignKey == obj) {
            return true;
        }
        if (!(obj instanceof TableInfo.ForeignKey)) {
            return false;
        }
        TableInfo.ForeignKey foreignKey2 = (TableInfo.ForeignKey) obj;
        if (g0.g(foreignKey.referenceTable, foreignKey2.referenceTable) && g0.g(foreignKey.onDelete, foreignKey2.onDelete) && g0.g(foreignKey.onUpdate, foreignKey2.onUpdate) && g0.g(foreignKey.columnNames, foreignKey2.columnNames)) {
            return g0.g(foreignKey.referenceColumnNames, foreignKey2.referenceColumnNames);
        }
        return false;
    }

    @NotNull
    public static final String toStringCommon(@NotNull TableInfo.Column column) {
        g0.p(column, "<this>");
        StringBuilder sb = new StringBuilder();
        sb.append("\n            |Column {\n            |   name = '");
        sb.append(column.name);
        sb.append("',\n            |   type = '");
        sb.append(column.type);
        sb.append("',\n            |   affinity = '");
        sb.append(column.affinity);
        sb.append("',\n            |   notNull = '");
        sb.append(column.notNull);
        sb.append("',\n            |   primaryKeyPosition = '");
        sb.append(column.primaryKeyPosition);
        sb.append("',\n            |   defaultValue = '");
        String str = column.defaultValue;
        if (str == null) {
            str = "undefined";
        }
        sb.append(str);
        sb.append("'\n            |}\n        ");
        return u.o(u.x(sb.toString(), null, 1, null), null, 1, null);
    }

    public static final boolean equalsCommon(@NotNull TableInfo.Index index, @Nullable Object obj) {
        g0.p(index, "<this>");
        if (index == obj) {
            return true;
        }
        if (!(obj instanceof TableInfo.Index)) {
            return false;
        }
        TableInfo.Index index2 = (TableInfo.Index) obj;
        if (index.unique != index2.unique || !g0.g(index.columns, index2.columns) || !g0.g(index.orders, index2.orders)) {
            return false;
        }
        if (u.H2(index.name, TableInfo.Index.DEFAULT_PREFIX, false, 2, null)) {
            return u.H2(index2.name, TableInfo.Index.DEFAULT_PREFIX, false, 2, null);
        }
        return g0.g(index.name, index2.name);
    }

    @NotNull
    public static final String toStringCommon(@NotNull TableInfo.ForeignKey foreignKey) {
        g0.p(foreignKey, "<this>");
        StringBuilder sb = new StringBuilder();
        sb.append("\n            |ForeignKey {\n            |   referenceTable = '");
        sb.append(foreignKey.referenceTable);
        sb.append("',\n            |   onDelete = '");
        sb.append(foreignKey.onDelete);
        sb.append("',\n            |   onUpdate = '");
        sb.append(foreignKey.onUpdate);
        sb.append("',\n            |   columnNames = {");
        joinToStringMiddleWithIndent(f0.v5(foreignKey.columnNames));
        n1 n1Var = n1.f44123a;
        sb.append(n1Var);
        sb.append("\n            |   referenceColumnNames = {");
        joinToStringEndWithIndent(f0.v5(foreignKey.referenceColumnNames));
        sb.append(n1Var);
        sb.append("\n            |}\n        ");
        return u.o(u.x(sb.toString(), null, 1, null), null, 1, null);
    }

    @NotNull
    public static final String toStringCommon(@NotNull TableInfo.Index index) {
        g0.p(index, "<this>");
        StringBuilder sb = new StringBuilder();
        sb.append("\n            |Index {\n            |   name = '");
        sb.append(index.name);
        sb.append("',\n            |   unique = '");
        sb.append(index.unique);
        sb.append("',\n            |   columns = {");
        joinToStringMiddleWithIndent(index.columns);
        n1 n1Var = n1.f44123a;
        sb.append(n1Var);
        sb.append("\n            |   orders = {");
        joinToStringEndWithIndent(index.orders);
        sb.append(n1Var);
        sb.append("\n            |}\n        ");
        return u.o(u.x(sb.toString(), null, 1, null), null, 1, null);
    }
}
