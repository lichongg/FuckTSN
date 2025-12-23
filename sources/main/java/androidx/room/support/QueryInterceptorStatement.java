package androidx.room.support;

import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.f0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlinx.coroutines.r0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nQueryInterceptorStatement.android.kt\nKotlin\n*S Kotlin\n*F\n+ 1 QueryInterceptorStatement.android.kt\nandroidx/room/support/QueryInterceptorStatement\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,103:1\n1#2:104\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
public final class QueryInterceptorStatement implements SupportSQLiteStatement {

    @NotNull
    private final List<Object> bindArgsCache;

    @NotNull
    private final SupportSQLiteStatement delegate;

    @NotNull
    private final RoomDatabase.QueryCallback queryCallback;

    @NotNull
    private final r0 queryCallbackScope;

    @NotNull
    private final String sqlStatement;

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindNull(int i6) {
        saveArgsToCache(i6, null);
        this.delegate.bindNull(i6);
    }

    public QueryInterceptorStatement(@NotNull SupportSQLiteStatement delegate, @NotNull String sqlStatement, @NotNull r0 queryCallbackScope, @NotNull RoomDatabase.QueryCallback queryCallback) {
        g0.p(delegate, "delegate");
        g0.p(sqlStatement, "sqlStatement");
        g0.p(queryCallbackScope, "queryCallbackScope");
        g0.p(queryCallback, "queryCallback");
        this.delegate = delegate;
        this.sqlStatement = sqlStatement;
        this.queryCallbackScope = queryCallbackScope;
        this.queryCallback = queryCallback;
        this.bindArgsCache = new ArrayList();
    }

    private final void saveArgsToCache(int i6, Object obj) {
        int i7 = i6 - 1;
        if (i7 >= this.bindArgsCache.size()) {
            int size = (i7 - this.bindArgsCache.size()) + 1;
            for (int i8 = 0; i8 < size; i8++) {
                this.bindArgsCache.add(null);
            }
        }
        this.bindArgsCache.set(i7, obj);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void clearBindings() {
        this.bindArgsCache.clear();
        this.delegate.clearBindings();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.delegate.close();
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public void execute() {
        kotlinx.coroutines.k.f(this.queryCallbackScope, null, null, new QueryInterceptorStatement$execute$1(this, f0.a6(this.bindArgsCache), null), 3, null);
        this.delegate.execute();
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public long executeInsert() {
        kotlinx.coroutines.k.f(this.queryCallbackScope, null, null, new QueryInterceptorStatement$executeInsert$1(this, f0.a6(this.bindArgsCache), null), 3, null);
        return this.delegate.executeInsert();
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public int executeUpdateDelete() {
        kotlinx.coroutines.k.f(this.queryCallbackScope, null, null, new QueryInterceptorStatement$executeUpdateDelete$1(this, f0.a6(this.bindArgsCache), null), 3, null);
        return this.delegate.executeUpdateDelete();
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public long simpleQueryForLong() {
        kotlinx.coroutines.k.f(this.queryCallbackScope, null, null, new QueryInterceptorStatement$simpleQueryForLong$1(this, f0.a6(this.bindArgsCache), null), 3, null);
        return this.delegate.simpleQueryForLong();
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    @Nullable
    public String simpleQueryForString() {
        kotlinx.coroutines.k.f(this.queryCallbackScope, null, null, new QueryInterceptorStatement$simpleQueryForString$1(this, f0.a6(this.bindArgsCache), null), 3, null);
        return this.delegate.simpleQueryForString();
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindBlob(int i6, @NotNull byte[] value) {
        g0.p(value, "value");
        saveArgsToCache(i6, value);
        this.delegate.bindBlob(i6, value);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindDouble(int i6, double d6) {
        saveArgsToCache(i6, Double.valueOf(d6));
        this.delegate.bindDouble(i6, d6);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindLong(int i6, long j6) {
        saveArgsToCache(i6, Long.valueOf(j6));
        this.delegate.bindLong(i6, j6);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindString(int i6, @NotNull String value) {
        g0.p(value, "value");
        saveArgsToCache(i6, value);
        this.delegate.bindString(i6, value);
    }
}
