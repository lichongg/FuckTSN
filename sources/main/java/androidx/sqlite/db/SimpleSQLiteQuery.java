package androidx.sqlite.db;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class SimpleSQLiteQuery implements SupportSQLiteQuery {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @Nullable
    private final Object[] bindArgs;

    @NotNull
    private final String query;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Companion {
        public /* synthetic */ Companion(v vVar) {
            this();
        }

        @JvmStatic
        public final void bind(@NotNull SupportSQLiteProgram statement, @Nullable Object[] objArr) {
            g0.p(statement, "statement");
            if (objArr == null) {
                return;
            }
            int length = objArr.length;
            int i6 = 0;
            while (i6 < length) {
                Object obj = objArr[i6];
                i6++;
                bind(statement, i6, obj);
            }
        }

        private Companion() {
        }

        private final void bind(SupportSQLiteProgram supportSQLiteProgram, int i6, Object obj) {
            if (obj == null) {
                supportSQLiteProgram.bindNull(i6);
                return;
            }
            if (obj instanceof byte[]) {
                supportSQLiteProgram.bindBlob(i6, (byte[]) obj);
                return;
            }
            if (obj instanceof Float) {
                supportSQLiteProgram.bindDouble(i6, ((Number) obj).floatValue());
                return;
            }
            if (obj instanceof Double) {
                supportSQLiteProgram.bindDouble(i6, ((Number) obj).doubleValue());
                return;
            }
            if (obj instanceof Long) {
                supportSQLiteProgram.bindLong(i6, ((Number) obj).longValue());
                return;
            }
            if (obj instanceof Integer) {
                supportSQLiteProgram.bindLong(i6, ((Number) obj).intValue());
                return;
            }
            if (obj instanceof Short) {
                supportSQLiteProgram.bindLong(i6, ((Number) obj).shortValue());
                return;
            }
            if (obj instanceof Byte) {
                supportSQLiteProgram.bindLong(i6, ((Number) obj).byteValue());
                return;
            }
            if (obj instanceof String) {
                supportSQLiteProgram.bindString(i6, (String) obj);
                return;
            }
            if (obj instanceof Boolean) {
                supportSQLiteProgram.bindLong(i6, ((Boolean) obj).booleanValue() ? 1L : 0L);
                return;
            }
            throw new IllegalArgumentException("Cannot bind " + obj + " at index " + i6 + " Supported types: Null, ByteArray, Float, Double, Long, Int, Short, Byte, String");
        }
    }

    public SimpleSQLiteQuery(@NotNull String query, @Nullable Object[] objArr) {
        g0.p(query, "query");
        this.query = query;
        this.bindArgs = objArr;
    }

    @JvmStatic
    public static final void bind(@NotNull SupportSQLiteProgram supportSQLiteProgram, @Nullable Object[] objArr) {
        Companion.bind(supportSQLiteProgram, objArr);
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public void bindTo(@NotNull SupportSQLiteProgram statement) {
        g0.p(statement, "statement");
        Companion.bind(statement, this.bindArgs);
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public int getArgCount() {
        Object[] objArr = this.bindArgs;
        if (objArr != null) {
            return objArr.length;
        }
        return 0;
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    @NotNull
    public String getSql() {
        return this.query;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SimpleSQLiteQuery(@NotNull String query) {
        this(query, null);
        g0.p(query, "query");
    }
}
