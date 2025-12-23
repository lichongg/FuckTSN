package androidx.room.util;

import androidx.annotation.RestrictTo;
import androidx.room.ColumnInfo;
import androidx.room.driver.SupportSQLiteConnection;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.db.SupportSQLiteDatabase;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.annotation.AnnotationRetention;
import kotlin.collections.u1;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: D:\Downloads\app\classes.dex */
public final class TableInfo {
    public static final int CREATED_FROM_DATABASE = 2;
    public static final int CREATED_FROM_ENTITY = 1;
    public static final int CREATED_FROM_UNKNOWN = 0;

    @NotNull
    public static final Companion Companion = new Companion(null);

    @JvmField
    @NotNull
    public final Map<String, Column> columns;

    @JvmField
    @NotNull
    public final Set<ForeignKey> foreignKeys;

    @JvmField
    @Nullable
    public final Set<Index> indices;

    @JvmField
    @NotNull
    public final String name;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final class Column {

        @NotNull
        public static final Companion Companion = new Companion(null);

        @JvmField
        public final int affinity;

        @JvmField
        public final int createdFrom;

        @JvmField
        @Nullable
        public final String defaultValue;

        @JvmField
        @NotNull
        public final String name;

        @JvmField
        public final boolean notNull;

        @JvmField
        public final int primaryKeyPosition;

        @JvmField
        @NotNull
        public final String type;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static final class Companion {
            public /* synthetic */ Companion(v vVar) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final boolean defaultValueEquals(@NotNull String current, @Nullable String str) {
                g0.p(current, "current");
                return TableInfoKt.defaultValueEqualsCommon(current, str);
            }
        }

        public Column(@NotNull String name, @NotNull String type, boolean z5, int i6, @Nullable String str, int i7) {
            g0.p(name, "name");
            g0.p(type, "type");
            this.name = name;
            this.type = type;
            this.notNull = z5;
            this.primaryKeyPosition = i6;
            this.defaultValue = str;
            this.createdFrom = i7;
            this.affinity = SchemaInfoUtilKt.findAffinity(type);
        }

        @JvmStatic
        public static final boolean defaultValueEquals(@NotNull String str, @Nullable String str2) {
            return Companion.defaultValueEquals(str, str2);
        }

        public final boolean isPrimaryKey() {
            return this.primaryKeyPosition > 0;
        }

        public boolean equals(@Nullable Object obj) {
            return TableInfoKt.equalsCommon(this, obj);
        }

        public int hashCode() {
            return TableInfoKt.hashCodeCommon(this);
        }

        @NotNull
        public String toString() {
            return TableInfoKt.toStringCommon(this);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        @Deprecated(message = "No longer used by generated code.")
        public Column(@NotNull String name, @NotNull String type, boolean z5, int i6) {
            this(name, type, z5, i6, null, 0);
            g0.p(name, "name");
            g0.p(type, "type");
        }

        @ColumnInfo.SQLiteTypeAffinity
        public static /* synthetic */ void getAffinity$annotations() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Companion {
        public /* synthetic */ Companion(v vVar) {
            this();
        }

        @Deprecated(message = "No longer used by generated code.")
        @JvmStatic
        @NotNull
        public final TableInfo read(@NotNull SupportSQLiteDatabase database, @NotNull String tableName) {
            g0.p(database, "database");
            g0.p(tableName, "tableName");
            return read(new SupportSQLiteConnection(database), tableName);
        }

        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final TableInfo read(@NotNull SQLiteConnection connection, @NotNull String tableName) {
            g0.p(connection, "connection");
            g0.p(tableName, "tableName");
            return SchemaInfoUtilKt.readTableInfo(connection, tableName);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface CreatedFrom {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final class ForeignKey {

        @JvmField
        @NotNull
        public final List<String> columnNames;

        @JvmField
        @NotNull
        public final String onDelete;

        @JvmField
        @NotNull
        public final String onUpdate;

        @JvmField
        @NotNull
        public final List<String> referenceColumnNames;

        @JvmField
        @NotNull
        public final String referenceTable;

        public ForeignKey(@NotNull String referenceTable, @NotNull String onDelete, @NotNull String onUpdate, @NotNull List<String> columnNames, @NotNull List<String> referenceColumnNames) {
            g0.p(referenceTable, "referenceTable");
            g0.p(onDelete, "onDelete");
            g0.p(onUpdate, "onUpdate");
            g0.p(columnNames, "columnNames");
            g0.p(referenceColumnNames, "referenceColumnNames");
            this.referenceTable = referenceTable;
            this.onDelete = onDelete;
            this.onUpdate = onUpdate;
            this.columnNames = columnNames;
            this.referenceColumnNames = referenceColumnNames;
        }

        public boolean equals(@Nullable Object obj) {
            return TableInfoKt.equalsCommon(this, obj);
        }

        public int hashCode() {
            return TableInfoKt.hashCodeCommon(this);
        }

        @NotNull
        public String toString() {
            return TableInfoKt.toStringCommon(this);
        }
    }

    public TableInfo(@NotNull String name, @NotNull Map<String, Column> columns, @NotNull Set<ForeignKey> foreignKeys, @Nullable Set<Index> set) {
        g0.p(name, "name");
        g0.p(columns, "columns");
        g0.p(foreignKeys, "foreignKeys");
        this.name = name;
        this.columns = columns;
        this.foreignKeys = foreignKeys;
        this.indices = set;
    }

    @JvmStatic
    @NotNull
    public static final TableInfo read(@NotNull SQLiteConnection sQLiteConnection, @NotNull String str) {
        return Companion.read(sQLiteConnection, str);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @SourceDebugExtension({"SMAP\nTableInfo.android.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TableInfo.android.kt\nandroidx/room/util/TableInfo$Index\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,209:1\n1#2:210\n*E\n"})
    public static final class Index {

        @NotNull
        public static final Companion Companion = new Companion(null);

        @NotNull
        public static final String DEFAULT_PREFIX = "index_";

        @JvmField
        @NotNull
        public final List<String> columns;

        @JvmField
        @NotNull
        public final String name;

        @JvmField
        @NotNull
        public List<String> orders;

        @JvmField
        public final boolean unique;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static final class Companion {
            public /* synthetic */ Companion(v vVar) {
                this();
            }

            private Companion() {
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [java.util.Collection] */
        /* JADX WARN: Type inference failed for: r5v2 */
        /* JADX WARN: Type inference failed for: r5v4, types: [java.util.ArrayList] */
        public Index(@NotNull String name, boolean z5, @NotNull List<String> columns, @NotNull List<String> orders) {
            g0.p(name, "name");
            g0.p(columns, "columns");
            g0.p(orders, "orders");
            this.name = name;
            this.unique = z5;
            this.columns = columns;
            this.orders = orders;
            List<String> list = orders;
            if (list.isEmpty()) {
                int size = columns.size();
                list = new ArrayList(size);
                for (int i6 = 0; i6 < size; i6++) {
                    list.add("ASC");
                }
            }
            this.orders = (List) list;
        }

        public boolean equals(@Nullable Object obj) {
            return TableInfoKt.equalsCommon(this, obj);
        }

        public int hashCode() {
            return TableInfoKt.hashCodeCommon(this);
        }

        @NotNull
        public String toString() {
            return TableInfoKt.toStringCommon(this);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        @kotlin.Deprecated(message = "No longer used by generated code.")
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public Index(@org.jetbrains.annotations.NotNull java.lang.String r5, boolean r6, @org.jetbrains.annotations.NotNull java.util.List<java.lang.String> r7) {
            /*
                r4 = this;
                java.lang.String r0 = "name"
                kotlin.jvm.internal.g0.p(r5, r0)
                java.lang.String r0 = "columns"
                kotlin.jvm.internal.g0.p(r7, r0)
                int r0 = r7.size()
                java.util.ArrayList r1 = new java.util.ArrayList
                r1.<init>(r0)
                r2 = 0
            L14:
                if (r2 >= r0) goto L1e
                java.lang.String r3 = "ASC"
                r1.add(r3)
                int r2 = r2 + 1
                goto L14
            L1e:
                r4.<init>(r5, r6, r7, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.util.TableInfo.Index.<init>(java.lang.String, boolean, java.util.List):void");
        }
    }

    @Deprecated(message = "No longer used by generated code.")
    @JvmStatic
    @NotNull
    public static final TableInfo read(@NotNull SupportSQLiteDatabase supportSQLiteDatabase, @NotNull String str) {
        return Companion.read(supportSQLiteDatabase, str);
    }

    public boolean equals(@Nullable Object obj) {
        return TableInfoKt.equalsCommon(this, obj);
    }

    public int hashCode() {
        return TableInfoKt.hashCodeCommon(this);
    }

    @NotNull
    public String toString() {
        return TableInfoKt.toStringCommon(this);
    }

    public /* synthetic */ TableInfo(String str, Map map, Set set, Set set2, int i6, v vVar) {
        this(str, map, set, (i6 & 8) != 0 ? null : set2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated(message = "No longer used by generated code.")
    public TableInfo(@NotNull String name, @NotNull Map<String, Column> columns, @NotNull Set<ForeignKey> foreignKeys) {
        this(name, columns, foreignKeys, u1.k());
        g0.p(name, "name");
        g0.p(columns, "columns");
        g0.p(foreignKeys, "foreignKeys");
    }
}
