package androidx.sqlite.db.framework;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.database.sqlite.SQLiteStatement;
import android.database.sqlite.SQLiteTransactionListener;
import android.os.Build;
import android.os.CancellationSignal;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.RequiresApi;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Locale;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlin.s;
import kotlin.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nFrameworkSQLiteDatabase.android.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FrameworkSQLiteDatabase.android.kt\nandroidx/sqlite/db/framework/FrameworkSQLiteDatabase\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,369:1\n1#2:370\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
public final class FrameworkSQLiteDatabase implements SupportSQLiteDatabase {

    @NotNull
    private static final s<Method> beginTransactionMethod$delegate;

    @NotNull
    private static final s<Method> getThreadSessionMethod$delegate;

    @NotNull
    private final SQLiteDatabase delegate;

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final String[] CONFLICT_VALUES = {"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};

    @NotNull
    private static final String[] EMPTY_STRING_ARRAY = new String[0];

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(30)
    public static final class Api30Impl {

        @NotNull
        public static final Api30Impl INSTANCE = new Api30Impl();

        public final void execPerConnectionSQL(@NotNull SQLiteDatabase sQLiteDatabase, @NotNull String sql, @Nullable Object[] objArr) {
            g0.p(sQLiteDatabase, "sQLiteDatabase");
            g0.p(sql, "sql");
            sQLiteDatabase.execPerConnectionSQL(sql, objArr);
        }

        private Api30Impl() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Companion {
        public /* synthetic */ Companion(v vVar) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Method getBeginTransactionMethod() {
            return (Method) FrameworkSQLiteDatabase.beginTransactionMethod$delegate.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Method getGetThreadSessionMethod() {
            return (Method) FrameworkSQLiteDatabase.getThreadSessionMethod$delegate.getValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Method beginTransactionMethod_delegate$lambda$8() {
        Class<?> returnType;
        try {
            Method getThreadSessionMethod = Companion.getGetThreadSessionMethod();
            if (getThreadSessionMethod == null || (returnType = getThreadSessionMethod.getReturnType()) == null) {
                return null;
            }
            Class<?> cls = Integer.TYPE;
            return returnType.getDeclaredMethod("beginTransaction", cls, SQLiteTransactionListener.class, cls, CancellationSignal.class);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Method getThreadSessionMethod_delegate$lambda$7() {
        try {
            Method declaredMethod = SQLiteDatabase.class.getDeclaredMethod("getThreadSession", null);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    @SuppressLint({"BanUncheckedReflection"})
    private final void internalBeginTransactionWithListenerReadOnly(SQLiteTransactionListener sQLiteTransactionListener) {
        Companion companion = Companion;
        if (companion.getBeginTransactionMethod() == null || companion.getGetThreadSessionMethod() == null) {
            if (sQLiteTransactionListener != null) {
                beginTransactionWithListener(sQLiteTransactionListener);
                return;
            } else {
                beginTransaction();
                return;
            }
        }
        Method beginTransactionMethod = companion.getBeginTransactionMethod();
        g0.m(beginTransactionMethod);
        Method getThreadSessionMethod = companion.getGetThreadSessionMethod();
        g0.m(getThreadSessionMethod);
        Object invoke = getThreadSessionMethod.invoke(this.delegate, null);
        if (invoke == null) {
            throw new IllegalStateException("Required value was null.");
        }
        beginTransactionMethod.invoke(invoke, 0, sQLiteTransactionListener, 0, null);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionReadOnly() {
        internalBeginTransactionWithListenerReadOnly(null);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void execSQL(@NotNull String sql) throws SQLException {
        g0.p(sql, "sql");
        this.delegate.execSQL(sql);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    @NotNull
    public Cursor query(@NotNull String query) {
        g0.p(query, "query");
        return query(new SimpleSQLiteQuery(query));
    }

    /* renamed from: setMaximumSize, reason: collision with other method in class */
    public void m42setMaximumSize(long j6) {
        this.delegate.setMaximumSize(j6);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean yieldIfContendedSafely() {
        return this.delegate.yieldIfContendedSafely();
    }

    static {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        getThreadSessionMethod$delegate = t.b(lazyThreadSafetyMode, new Function0() { // from class: androidx.sqlite.db.framework.d
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Method threadSessionMethod_delegate$lambda$7;
                threadSessionMethod_delegate$lambda$7 = FrameworkSQLiteDatabase.getThreadSessionMethod_delegate$lambda$7();
                return threadSessionMethod_delegate$lambda$7;
            }
        });
        beginTransactionMethod$delegate = t.b(lazyThreadSafetyMode, new Function0() { // from class: androidx.sqlite.db.framework.e
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Method beginTransactionMethod_delegate$lambda$8;
                beginTransactionMethod_delegate$lambda$8 = FrameworkSQLiteDatabase.beginTransactionMethod_delegate$lambda$8();
                return beginTransactionMethod_delegate$lambda$8;
            }
        });
    }

    public FrameworkSQLiteDatabase(@NotNull SQLiteDatabase delegate) {
        g0.p(delegate, "delegate");
        this.delegate = delegate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SQLiteCursor query$lambda$0(SupportSQLiteQuery supportSQLiteQuery, SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        g0.m(sQLiteQuery);
        supportSQLiteQuery.bindTo(new FrameworkSQLiteProgram(sQLiteQuery));
        return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Cursor query$lambda$2(SupportSQLiteQuery supportSQLiteQuery, SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        g0.m(sQLiteQuery);
        supportSQLiteQuery.bindTo(new FrameworkSQLiteProgram(sQLiteQuery));
        return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransaction() {
        this.delegate.beginTransaction();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionNonExclusive() {
        this.delegate.beginTransactionNonExclusive();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionWithListener(@NotNull SQLiteTransactionListener transactionListener) {
        g0.p(transactionListener, "transactionListener");
        this.delegate.beginTransactionWithListener(transactionListener);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionWithListenerNonExclusive(@NotNull SQLiteTransactionListener transactionListener) {
        g0.p(transactionListener, "transactionListener");
        this.delegate.beginTransactionWithListenerNonExclusive(transactionListener);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionWithListenerReadOnly(@NotNull SQLiteTransactionListener transactionListener) {
        g0.p(transactionListener, "transactionListener");
        internalBeginTransactionWithListenerReadOnly(transactionListener);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.delegate.close();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    @NotNull
    public SupportSQLiteStatement compileStatement(@NotNull String sql) {
        g0.p(sql, "sql");
        SQLiteStatement compileStatement = this.delegate.compileStatement(sql);
        g0.o(compileStatement, "compileStatement(...)");
        return new FrameworkSQLiteStatement(compileStatement);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public int delete(@NotNull String table, @Nullable String str, @Nullable Object[] objArr) {
        g0.p(table, "table");
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM ");
        sb.append(table);
        if (str != null && str.length() != 0) {
            sb.append(" WHERE ");
            sb.append(str);
        }
        SupportSQLiteStatement compileStatement = compileStatement(sb.toString());
        SimpleSQLiteQuery.Companion.bind(compileStatement, objArr);
        return compileStatement.executeUpdateDelete();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void disableWriteAheadLogging() {
        this.delegate.disableWriteAheadLogging();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean enableWriteAheadLogging() {
        return this.delegate.enableWriteAheadLogging();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void endTransaction() {
        this.delegate.endTransaction();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void execPerConnectionSQL(@NotNull String sql, @Nullable Object[] objArr) {
        g0.p(sql, "sql");
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 30) {
            Api30Impl.INSTANCE.execPerConnectionSQL(this.delegate, sql, objArr);
            return;
        }
        throw new UnsupportedOperationException("execPerConnectionSQL is not supported on a SDK version lower than 30, current version is: " + i6);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void execSQL(@NotNull String sql, @NotNull Object[] bindArgs) throws SQLException {
        g0.p(sql, "sql");
        g0.p(bindArgs, "bindArgs");
        this.delegate.execSQL(sql, bindArgs);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    @Nullable
    public List<Pair<String, String>> getAttachedDbs() {
        return this.delegate.getAttachedDbs();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long getMaximumSize() {
        return this.delegate.getMaximumSize();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long getPageSize() {
        return this.delegate.getPageSize();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    @Nullable
    public String getPath() {
        return this.delegate.getPath();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public int getVersion() {
        return this.delegate.getVersion();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean inTransaction() {
        return this.delegate.inTransaction();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long insert(@NotNull String table, int i6, @NotNull ContentValues values) throws SQLException {
        g0.p(table, "table");
        g0.p(values, "values");
        return this.delegate.insertWithOnConflict(table, null, values, i6);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isDatabaseIntegrityOk() {
        return this.delegate.isDatabaseIntegrityOk();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isDbLockedByCurrentThread() {
        return this.delegate.isDbLockedByCurrentThread();
    }

    public final boolean isDelegate(@NotNull SQLiteDatabase sqLiteDatabase) {
        g0.p(sqLiteDatabase, "sqLiteDatabase");
        return g0.g(this.delegate, sqLiteDatabase);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isExecPerConnectionSQLSupported() {
        return Build.VERSION.SDK_INT >= 30;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isOpen() {
        return this.delegate.isOpen();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isReadOnly() {
        return this.delegate.isReadOnly();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isWriteAheadLoggingEnabled() {
        return this.delegate.isWriteAheadLoggingEnabled();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean needUpgrade(int i6) {
        return this.delegate.needUpgrade(i6);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    @NotNull
    public Cursor query(@NotNull String query, @NotNull Object[] bindArgs) {
        g0.p(query, "query");
        g0.p(bindArgs, "bindArgs");
        return query(new SimpleSQLiteQuery(query, bindArgs));
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setForeignKeyConstraintsEnabled(boolean z5) {
        this.delegate.setForeignKeyConstraintsEnabled(z5);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setLocale(@NotNull Locale locale) {
        g0.p(locale, "locale");
        this.delegate.setLocale(locale);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setMaxSqlCacheSize(int i6) {
        this.delegate.setMaxSqlCacheSize(i6);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long setMaximumSize(long j6) {
        this.delegate.setMaximumSize(j6);
        return this.delegate.getMaximumSize();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setPageSize(long j6) {
        this.delegate.setPageSize(j6);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setTransactionSuccessful() {
        this.delegate.setTransactionSuccessful();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setVersion(int i6) {
        this.delegate.setVersion(i6);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public int update(@NotNull String table, int i6, @NotNull ContentValues values, @Nullable String str, @Nullable Object[] objArr) {
        g0.p(table, "table");
        g0.p(values, "values");
        if (values.size() == 0) {
            throw new IllegalArgumentException("Empty values");
        }
        int size = values.size();
        int length = objArr == null ? size : objArr.length + size;
        Object[] objArr2 = new Object[length];
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE ");
        sb.append(CONFLICT_VALUES[i6]);
        sb.append(table);
        sb.append(" SET ");
        int i7 = 0;
        for (String str2 : values.keySet()) {
            sb.append(i7 > 0 ? "," : "");
            sb.append(str2);
            objArr2[i7] = values.get(str2);
            sb.append("=?");
            i7++;
        }
        if (objArr != null) {
            for (int i8 = size; i8 < length; i8++) {
                objArr2[i8] = objArr[i8 - size];
            }
        }
        if (!TextUtils.isEmpty(str)) {
            sb.append(" WHERE ");
            sb.append(str);
        }
        SupportSQLiteStatement compileStatement = compileStatement(sb.toString());
        SimpleSQLiteQuery.Companion.bind(compileStatement, objArr2);
        return compileStatement.executeUpdateDelete();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean yieldIfContendedSafely(long j6) {
        return this.delegate.yieldIfContendedSafely(j6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Cursor query$lambda$1(Function4 function4, SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        return (Cursor) function4.invoke(sQLiteDatabase, sQLiteCursorDriver, str, sQLiteQuery);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    @NotNull
    public Cursor query(@NotNull final SupportSQLiteQuery query) {
        g0.p(query, "query");
        final Function4 function4 = new Function4() { // from class: androidx.sqlite.db.framework.b
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                SQLiteCursor query$lambda$0;
                query$lambda$0 = FrameworkSQLiteDatabase.query$lambda$0(SupportSQLiteQuery.this, (SQLiteDatabase) obj, (SQLiteCursorDriver) obj2, (String) obj3, (SQLiteQuery) obj4);
                return query$lambda$0;
            }
        };
        Cursor rawQueryWithFactory = this.delegate.rawQueryWithFactory(new SQLiteDatabase.CursorFactory() { // from class: androidx.sqlite.db.framework.c
            @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
            public final Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
                Cursor query$lambda$1;
                query$lambda$1 = FrameworkSQLiteDatabase.query$lambda$1(Function4.this, sQLiteDatabase, sQLiteCursorDriver, str, sQLiteQuery);
                return query$lambda$1;
            }
        }, query.getSql(), EMPTY_STRING_ARRAY, null);
        g0.o(rawQueryWithFactory, "rawQueryWithFactory(...)");
        return rawQueryWithFactory;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    @NotNull
    public Cursor query(@NotNull final SupportSQLiteQuery query, @Nullable CancellationSignal cancellationSignal) {
        g0.p(query, "query");
        SQLiteDatabase sQLiteDatabase = this.delegate;
        SQLiteDatabase.CursorFactory cursorFactory = new SQLiteDatabase.CursorFactory() { // from class: androidx.sqlite.db.framework.a
            @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
            public final Cursor newCursor(SQLiteDatabase sQLiteDatabase2, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
                Cursor query$lambda$2;
                query$lambda$2 = FrameworkSQLiteDatabase.query$lambda$2(SupportSQLiteQuery.this, sQLiteDatabase2, sQLiteCursorDriver, str, sQLiteQuery);
                return query$lambda$2;
            }
        };
        String sql = query.getSql();
        String[] strArr = EMPTY_STRING_ARRAY;
        g0.m(cancellationSignal);
        Cursor rawQueryWithFactory = sQLiteDatabase.rawQueryWithFactory(cursorFactory, sql, strArr, null, cancellationSignal);
        g0.o(rawQueryWithFactory, "rawQueryWithFactory(...)");
        return rawQueryWithFactory;
    }
}
