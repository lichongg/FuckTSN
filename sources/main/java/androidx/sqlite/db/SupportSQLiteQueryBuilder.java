package androidx.sqlite.db;

import java.util.regex.Pattern;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nSupportSQLiteQueryBuilder.android.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SupportSQLiteQueryBuilder.android.kt\nandroidx/sqlite/db/SupportSQLiteQueryBuilder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,169:1\n1#2:170\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
public final class SupportSQLiteQueryBuilder {

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final Pattern limitPattern = Pattern.compile("\\s*\\d+\\s*(,\\s*\\d+\\s*)?");

    @Nullable
    private Object[] bindArgs;

    @Nullable
    private String[] columns;
    private boolean distinct;

    @Nullable
    private String groupBy;

    @Nullable
    private String having;

    @Nullable
    private String limit;

    @Nullable
    private String orderBy;

    @Nullable
    private String selection;

    @NotNull
    private final String table;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Companion {
        public /* synthetic */ Companion(v vVar) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final SupportSQLiteQueryBuilder builder(@NotNull String tableName) {
            g0.p(tableName, "tableName");
            return new SupportSQLiteQueryBuilder(tableName, null);
        }
    }

    public /* synthetic */ SupportSQLiteQueryBuilder(String str, v vVar) {
        this(str);
    }

    private final void appendColumns(StringBuilder sb, String[] strArr) {
        int length = strArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            String str = strArr[i6];
            if (i6 > 0) {
                sb.append(", ");
            }
            sb.append(str);
        }
        sb.append(' ');
    }

    @NotNull
    public final SupportSQLiteQueryBuilder distinct() {
        this.distinct = true;
        return this;
    }

    private SupportSQLiteQueryBuilder(String str) {
        this.table = str;
    }

    private final void appendClause(StringBuilder sb, String str, String str2) {
        if (str2 == null || str2.length() == 0) {
            return;
        }
        sb.append(str);
        sb.append(str2);
    }

    @JvmStatic
    @NotNull
    public static final SupportSQLiteQueryBuilder builder(@NotNull String str) {
        return Companion.builder(str);
    }

    @NotNull
    public final SupportSQLiteQueryBuilder columns(@Nullable String[] strArr) {
        this.columns = strArr;
        return this;
    }

    @NotNull
    public final SupportSQLiteQuery create() {
        String str;
        String str2 = this.groupBy;
        if ((str2 == null || str2.length() == 0) && (str = this.having) != null && str.length() != 0) {
            throw new IllegalArgumentException("HAVING clauses are only permitted when using a groupBy clause");
        }
        StringBuilder sb = new StringBuilder(120);
        sb.append("SELECT ");
        if (this.distinct) {
            sb.append("DISTINCT ");
        }
        String[] strArr = this.columns;
        if (strArr == null || strArr.length == 0) {
            sb.append("* ");
        } else {
            g0.m(strArr);
            appendColumns(sb, strArr);
        }
        sb.append("FROM ");
        sb.append(this.table);
        appendClause(sb, " WHERE ", this.selection);
        appendClause(sb, " GROUP BY ", this.groupBy);
        appendClause(sb, " HAVING ", this.having);
        appendClause(sb, " ORDER BY ", this.orderBy);
        appendClause(sb, " LIMIT ", this.limit);
        return new SimpleSQLiteQuery(sb.toString(), this.bindArgs);
    }

    @NotNull
    public final SupportSQLiteQueryBuilder groupBy(@Nullable String str) {
        this.groupBy = str;
        return this;
    }

    @NotNull
    public final SupportSQLiteQueryBuilder having(@Nullable String str) {
        this.having = str;
        return this;
    }

    @NotNull
    public final SupportSQLiteQueryBuilder limit(@NotNull String limit) {
        g0.p(limit, "limit");
        boolean matches = limitPattern.matcher(limit).matches();
        if (limit.length() == 0 || matches) {
            this.limit = limit;
            return this;
        }
        throw new IllegalArgumentException(("invalid LIMIT clauses:" + limit).toString());
    }

    @NotNull
    public final SupportSQLiteQueryBuilder orderBy(@Nullable String str) {
        this.orderBy = str;
        return this;
    }

    @NotNull
    public final SupportSQLiteQueryBuilder selection(@Nullable String str, @Nullable Object[] objArr) {
        this.selection = str;
        this.bindArgs = objArr;
        return this;
    }
}
