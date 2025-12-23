package androidx.room.support;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.database.SQLException;
import android.database.sqlite.SQLiteTransactionListener;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.util.Pair;
import androidx.annotation.RequiresApi;
import androidx.room.DelegatingOpenHelper;
import androidx.room.support.AutoClosingRoomOpenHelper;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteProgram;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.Deprecated;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class AutoClosingRoomOpenHelper implements SupportSQLiteOpenHelper, DelegatingOpenHelper {

    @NotNull
    private final AutoCloser autoCloser;

    @NotNull
    private final AutoClosingSupportSQLiteDatabase autoClosingDb;

    @NotNull
    private final SupportSQLiteOpenHelper delegate;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class AutoClosingSupportSQLiteDatabase implements SupportSQLiteDatabase {

        @NotNull
        private final AutoCloser autoCloser;

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void execSQL(@NotNull final String sql) throws SQLException {
            g0.p(sql, "sql");
            this.autoCloser.executeRefCountingFunction(new Function1() { // from class: androidx.room.support.h
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    n1 execSQL$lambda$7;
                    execSQL$lambda$7 = AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.execSQL$lambda$7(sql, (SupportSQLiteDatabase) obj);
                    return execSQL$lambda$7;
                }
            });
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        @NotNull
        public Cursor query(@NotNull String query) {
            g0.p(query, "query");
            try {
                return new KeepAliveCursor(this.autoCloser.incrementCountAndEnsureDbIsOpen().query(query), this.autoCloser);
            } catch (Throwable th) {
                this.autoCloser.decrementCountAndScheduleClose();
                throw th;
            }
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean yieldIfContendedSafely() {
            return ((Boolean) this.autoCloser.executeRefCountingFunction(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$yieldIfContendedSafely$1.INSTANCE)).booleanValue();
        }

        public AutoClosingSupportSQLiteDatabase(@NotNull AutoCloser autoCloser) {
            g0.p(autoCloser, "autoCloser");
            this.autoCloser = autoCloser;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Object _set_pageSize_$lambda$3(long j6, SupportSQLiteDatabase db) {
            g0.p(db, "db");
            db.setPageSize(j6);
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final n1 _set_version_$lambda$1(int i6, SupportSQLiteDatabase db) {
            g0.p(db, "db");
            db.setVersion(i6);
            return n1.f44123a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final int delete$lambda$5(String str, String str2, Object[] objArr, SupportSQLiteDatabase db) {
            g0.p(db, "db");
            return db.delete(str, str2, objArr);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final n1 execSQL$lambda$7(String str, SupportSQLiteDatabase db) {
            g0.p(db, "db");
            db.execSQL(str);
            return n1.f44123a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final n1 execSQL$lambda$8(String str, Object[] objArr, SupportSQLiteDatabase db) {
            g0.p(db, "db");
            db.execSQL(str, objArr);
            return n1.f44123a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final long insert$lambda$4(String str, int i6, ContentValues contentValues, SupportSQLiteDatabase db) {
            g0.p(db, "db");
            return db.insert(str, i6, contentValues);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean needUpgrade$lambda$9(int i6, SupportSQLiteDatabase db) {
            g0.p(db, "db");
            return db.needUpgrade(i6);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Object pokeOpen$lambda$0(SupportSQLiteDatabase it) {
            g0.p(it, "it");
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final n1 setForeignKeyConstraintsEnabled$lambda$12(boolean z5, SupportSQLiteDatabase db) {
            g0.p(db, "db");
            db.setForeignKeyConstraintsEnabled(z5);
            return n1.f44123a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final n1 setLocale$lambda$10(Locale locale, SupportSQLiteDatabase db) {
            g0.p(db, "db");
            db.setLocale(locale);
            return n1.f44123a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final n1 setMaxSqlCacheSize$lambda$11(int i6, SupportSQLiteDatabase db) {
            g0.p(db, "db");
            db.setMaxSqlCacheSize(i6);
            return n1.f44123a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final long setMaximumSize$lambda$2(long j6, SupportSQLiteDatabase db) {
            g0.p(db, "db");
            return db.setMaximumSize(j6);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final int update$lambda$6(String str, int i6, ContentValues contentValues, String str2, Object[] objArr, SupportSQLiteDatabase db) {
            g0.p(db, "db");
            return db.update(str, i6, contentValues, str2, objArr);
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void beginTransaction() {
            try {
                this.autoCloser.incrementCountAndEnsureDbIsOpen().beginTransaction();
            } catch (Throwable th) {
                this.autoCloser.decrementCountAndScheduleClose();
                throw th;
            }
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void beginTransactionNonExclusive() {
            try {
                this.autoCloser.incrementCountAndEnsureDbIsOpen().beginTransactionNonExclusive();
            } catch (Throwable th) {
                this.autoCloser.decrementCountAndScheduleClose();
                throw th;
            }
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void beginTransactionWithListener(@NotNull SQLiteTransactionListener transactionListener) {
            g0.p(transactionListener, "transactionListener");
            try {
                this.autoCloser.incrementCountAndEnsureDbIsOpen().beginTransactionWithListener(transactionListener);
            } catch (Throwable th) {
                this.autoCloser.decrementCountAndScheduleClose();
                throw th;
            }
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void beginTransactionWithListenerNonExclusive(@NotNull SQLiteTransactionListener transactionListener) {
            g0.p(transactionListener, "transactionListener");
            try {
                this.autoCloser.incrementCountAndEnsureDbIsOpen().beginTransactionWithListenerNonExclusive(transactionListener);
            } catch (Throwable th) {
                this.autoCloser.decrementCountAndScheduleClose();
                throw th;
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.autoCloser.closeDatabaseIfOpen();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        @NotNull
        public SupportSQLiteStatement compileStatement(@NotNull String sql) {
            g0.p(sql, "sql");
            return new AutoClosingSupportSQLiteStatement(sql, this.autoCloser);
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public int delete(@NotNull final String table, @Nullable final String str, @Nullable final Object[] objArr) {
            g0.p(table, "table");
            return ((Number) this.autoCloser.executeRefCountingFunction(new Function1() { // from class: androidx.room.support.d
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    int delete$lambda$5;
                    delete$lambda$5 = AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.delete$lambda$5(table, str, objArr, (SupportSQLiteDatabase) obj);
                    return Integer.valueOf(delete$lambda$5);
                }
            })).intValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void disableWriteAheadLogging() {
            throw new UnsupportedOperationException("Enable/disable write ahead logging on the OpenHelper instead of on the database directly.");
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean enableWriteAheadLogging() {
            throw new UnsupportedOperationException("Enable/disable write ahead logging on the OpenHelper instead of on the database directly.");
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void endTransaction() {
            try {
                SupportSQLiteDatabase delegateDatabase$room_runtime_release = this.autoCloser.getDelegateDatabase$room_runtime_release();
                g0.m(delegateDatabase$room_runtime_release);
                delegateDatabase$room_runtime_release.endTransaction();
            } finally {
                this.autoCloser.decrementCountAndScheduleClose();
            }
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void execSQL(@NotNull final String sql, @NotNull final Object[] bindArgs) throws SQLException {
            g0.p(sql, "sql");
            g0.p(bindArgs, "bindArgs");
            this.autoCloser.executeRefCountingFunction(new Function1() { // from class: androidx.room.support.i
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    n1 execSQL$lambda$8;
                    execSQL$lambda$8 = AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.execSQL$lambda$8(sql, bindArgs, (SupportSQLiteDatabase) obj);
                    return execSQL$lambda$8;
                }
            });
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        @Nullable
        public List<Pair<String, String>> getAttachedDbs() {
            return (List) this.autoCloser.executeRefCountingFunction(new PropertyReference1Impl() { // from class: androidx.room.support.AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$attachedDbs$1
                @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.p
                public Object get(Object obj) {
                    return ((SupportSQLiteDatabase) obj).getAttachedDbs();
                }
            });
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public long getMaximumSize() {
            return ((Number) this.autoCloser.executeRefCountingFunction(new PropertyReference1Impl() { // from class: androidx.room.support.AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$maximumSize$1
                @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.p
                public Object get(Object obj) {
                    return Long.valueOf(((SupportSQLiteDatabase) obj).getMaximumSize());
                }
            })).longValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public long getPageSize() {
            return ((Number) this.autoCloser.executeRefCountingFunction(new MutablePropertyReference1Impl() { // from class: androidx.room.support.AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$pageSize$1
                @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.p
                public Object get(Object obj) {
                    return Long.valueOf(((SupportSQLiteDatabase) obj).getPageSize());
                }

                @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.l
                public void set(Object obj, Object obj2) {
                    ((SupportSQLiteDatabase) obj).setPageSize(((Number) obj2).longValue());
                }
            })).longValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        @Nullable
        public String getPath() {
            return (String) this.autoCloser.executeRefCountingFunction(new PropertyReference1Impl() { // from class: androidx.room.support.AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$path$1
                @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.p
                public Object get(Object obj) {
                    return ((SupportSQLiteDatabase) obj).getPath();
                }
            });
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public int getVersion() {
            return ((Number) this.autoCloser.executeRefCountingFunction(new MutablePropertyReference1Impl() { // from class: androidx.room.support.AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$version$1
                @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.p
                public Object get(Object obj) {
                    return Integer.valueOf(((SupportSQLiteDatabase) obj).getVersion());
                }

                @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.l
                public void set(Object obj, Object obj2) {
                    ((SupportSQLiteDatabase) obj).setVersion(((Number) obj2).intValue());
                }
            })).intValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean inTransaction() {
            if (this.autoCloser.getDelegateDatabase$room_runtime_release() == null) {
                return false;
            }
            return ((Boolean) this.autoCloser.executeRefCountingFunction(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$inTransaction$1.INSTANCE)).booleanValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public long insert(@NotNull final String table, final int i6, @NotNull final ContentValues values) throws SQLException {
            g0.p(table, "table");
            g0.p(values, "values");
            return ((Number) this.autoCloser.executeRefCountingFunction(new Function1() { // from class: androidx.room.support.k
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    long insert$lambda$4;
                    insert$lambda$4 = AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.insert$lambda$4(table, i6, values, (SupportSQLiteDatabase) obj);
                    return Long.valueOf(insert$lambda$4);
                }
            })).longValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean isDatabaseIntegrityOk() {
            return ((Boolean) this.autoCloser.executeRefCountingFunction(new PropertyReference1Impl() { // from class: androidx.room.support.AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$isDatabaseIntegrityOk$1
                @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.p
                public Object get(Object obj) {
                    return Boolean.valueOf(((SupportSQLiteDatabase) obj).isDatabaseIntegrityOk());
                }
            })).booleanValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean isDbLockedByCurrentThread() {
            if (this.autoCloser.getDelegateDatabase$room_runtime_release() == null) {
                return false;
            }
            return ((Boolean) this.autoCloser.executeRefCountingFunction(new PropertyReference1Impl() { // from class: androidx.room.support.AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$isDbLockedByCurrentThread$1
                @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.p
                public Object get(Object obj) {
                    return Boolean.valueOf(((SupportSQLiteDatabase) obj).isDbLockedByCurrentThread());
                }
            })).booleanValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean isOpen() {
            SupportSQLiteDatabase delegateDatabase$room_runtime_release = this.autoCloser.getDelegateDatabase$room_runtime_release();
            if (delegateDatabase$room_runtime_release != null) {
                return delegateDatabase$room_runtime_release.isOpen();
            }
            return false;
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean isReadOnly() {
            return ((Boolean) this.autoCloser.executeRefCountingFunction(new PropertyReference1Impl() { // from class: androidx.room.support.AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$isReadOnly$1
                @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.p
                public Object get(Object obj) {
                    return Boolean.valueOf(((SupportSQLiteDatabase) obj).isReadOnly());
                }
            })).booleanValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean isWriteAheadLoggingEnabled() {
            return ((Boolean) this.autoCloser.executeRefCountingFunction(new PropertyReference1Impl() { // from class: androidx.room.support.AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$isWriteAheadLoggingEnabled$1
                @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.p
                public Object get(Object obj) {
                    return Boolean.valueOf(((SupportSQLiteDatabase) obj).isWriteAheadLoggingEnabled());
                }
            })).booleanValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean needUpgrade(final int i6) {
            return ((Boolean) this.autoCloser.executeRefCountingFunction(new Function1() { // from class: androidx.room.support.m
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    boolean needUpgrade$lambda$9;
                    needUpgrade$lambda$9 = AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.needUpgrade$lambda$9(i6, (SupportSQLiteDatabase) obj);
                    return Boolean.valueOf(needUpgrade$lambda$9);
                }
            })).booleanValue();
        }

        public final void pokeOpen() {
            this.autoCloser.executeRefCountingFunction(new Function1() { // from class: androidx.room.support.j
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Object pokeOpen$lambda$0;
                    pokeOpen$lambda$0 = AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.pokeOpen$lambda$0((SupportSQLiteDatabase) obj);
                    return pokeOpen$lambda$0;
                }
            });
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void setForeignKeyConstraintsEnabled(final boolean z5) {
            this.autoCloser.executeRefCountingFunction(new Function1() { // from class: androidx.room.support.n
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    n1 foreignKeyConstraintsEnabled$lambda$12;
                    foreignKeyConstraintsEnabled$lambda$12 = AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.setForeignKeyConstraintsEnabled$lambda$12(z5, (SupportSQLiteDatabase) obj);
                    return foreignKeyConstraintsEnabled$lambda$12;
                }
            });
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void setLocale(@NotNull final Locale locale) {
            g0.p(locale, "locale");
            this.autoCloser.executeRefCountingFunction(new Function1() { // from class: androidx.room.support.c
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    n1 locale$lambda$10;
                    locale$lambda$10 = AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.setLocale$lambda$10(locale, (SupportSQLiteDatabase) obj);
                    return locale$lambda$10;
                }
            });
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void setMaxSqlCacheSize(final int i6) {
            this.autoCloser.executeRefCountingFunction(new Function1() { // from class: androidx.room.support.b
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    n1 maxSqlCacheSize$lambda$11;
                    maxSqlCacheSize$lambda$11 = AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.setMaxSqlCacheSize$lambda$11(i6, (SupportSQLiteDatabase) obj);
                    return maxSqlCacheSize$lambda$11;
                }
            });
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public long setMaximumSize(final long j6) {
            return ((Number) this.autoCloser.executeRefCountingFunction(new Function1() { // from class: androidx.room.support.e
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    long maximumSize$lambda$2;
                    maximumSize$lambda$2 = AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.setMaximumSize$lambda$2(j6, (SupportSQLiteDatabase) obj);
                    return Long.valueOf(maximumSize$lambda$2);
                }
            })).longValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void setPageSize(final long j6) {
            this.autoCloser.executeRefCountingFunction(new Function1() { // from class: androidx.room.support.l
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Object _set_pageSize_$lambda$3;
                    _set_pageSize_$lambda$3 = AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase._set_pageSize_$lambda$3(j6, (SupportSQLiteDatabase) obj);
                    return _set_pageSize_$lambda$3;
                }
            });
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void setTransactionSuccessful() {
            SupportSQLiteDatabase delegateDatabase$room_runtime_release = this.autoCloser.getDelegateDatabase$room_runtime_release();
            g0.m(delegateDatabase$room_runtime_release);
            delegateDatabase$room_runtime_release.setTransactionSuccessful();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void setVersion(final int i6) {
            this.autoCloser.executeRefCountingFunction(new Function1() { // from class: androidx.room.support.f
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    n1 _set_version_$lambda$1;
                    _set_version_$lambda$1 = AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase._set_version_$lambda$1(i6, (SupportSQLiteDatabase) obj);
                    return _set_version_$lambda$1;
                }
            });
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public int update(@NotNull final String table, final int i6, @NotNull final ContentValues values, @Nullable final String str, @Nullable final Object[] objArr) {
            g0.p(table, "table");
            g0.p(values, "values");
            return ((Number) this.autoCloser.executeRefCountingFunction(new Function1() { // from class: androidx.room.support.g
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    int update$lambda$6;
                    update$lambda$6 = AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.update$lambda$6(table, i6, values, str, objArr, (SupportSQLiteDatabase) obj);
                    return Integer.valueOf(update$lambda$6);
                }
            })).intValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public /* synthetic */ void beginTransactionReadOnly() {
            g.a.a(this);
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public /* synthetic */ void beginTransactionWithListenerReadOnly(SQLiteTransactionListener sQLiteTransactionListener) {
            g.a.b(this, sQLiteTransactionListener);
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public /* synthetic */ void execPerConnectionSQL(String str, Object[] objArr) {
            g.a.c(this, str, objArr);
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public /* synthetic */ boolean isExecPerConnectionSQLSupported() {
            return g.a.d(this);
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean yieldIfContendedSafely(long j6) {
            return ((Boolean) this.autoCloser.executeRefCountingFunction(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$yieldIfContendedSafely$2.INSTANCE)).booleanValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        @NotNull
        public Cursor query(@NotNull String query, @NotNull Object[] bindArgs) {
            g0.p(query, "query");
            g0.p(bindArgs, "bindArgs");
            try {
                return new KeepAliveCursor(this.autoCloser.incrementCountAndEnsureDbIsOpen().query(query, bindArgs), this.autoCloser);
            } catch (Throwable th) {
                this.autoCloser.decrementCountAndScheduleClose();
                throw th;
            }
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        @NotNull
        public Cursor query(@NotNull SupportSQLiteQuery query) {
            g0.p(query, "query");
            try {
                return new KeepAliveCursor(this.autoCloser.incrementCountAndEnsureDbIsOpen().query(query), this.autoCloser);
            } catch (Throwable th) {
                this.autoCloser.decrementCountAndScheduleClose();
                throw th;
            }
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        @RequiresApi(api = 24)
        @NotNull
        public Cursor query(@NotNull SupportSQLiteQuery query, @Nullable CancellationSignal cancellationSignal) {
            g0.p(query, "query");
            try {
                return new KeepAliveCursor(this.autoCloser.incrementCountAndEnsureDbIsOpen().query(query, cancellationSignal), this.autoCloser);
            } catch (Throwable th) {
                this.autoCloser.decrementCountAndScheduleClose();
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class AutoClosingSupportSQLiteStatement implements SupportSQLiteStatement {
        private static final int COLUMN_TYPE_BLOB = 4;
        private static final int COLUMN_TYPE_DOUBLE = 2;
        private static final int COLUMN_TYPE_LONG = 1;
        private static final int COLUMN_TYPE_NULL = 5;
        private static final int COLUMN_TYPE_STRING = 3;

        @NotNull
        public static final Companion Companion = new Companion(null);

        @NotNull
        private final AutoCloser autoCloser;

        @NotNull
        private int[] bindingTypes;

        @NotNull
        private byte[][] blobBindings;

        @NotNull
        private double[] doubleBindings;

        @NotNull
        private long[] longBindings;

        @NotNull
        private final String sql;

        @NotNull
        private String[] stringBindings;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static final class Companion {
            public /* synthetic */ Companion(v vVar) {
                this();
            }

            private Companion() {
            }
        }

        private final void ensureCapacity(int i6, int i7) {
            int i8 = i7 + 1;
            int[] iArr = this.bindingTypes;
            if (iArr.length < i8) {
                int[] copyOf = Arrays.copyOf(iArr, i8);
                g0.o(copyOf, "copyOf(...)");
                this.bindingTypes = copyOf;
            }
            if (i6 == 1) {
                long[] jArr = this.longBindings;
                if (jArr.length < i8) {
                    long[] copyOf2 = Arrays.copyOf(jArr, i8);
                    g0.o(copyOf2, "copyOf(...)");
                    this.longBindings = copyOf2;
                    return;
                }
                return;
            }
            if (i6 == 2) {
                double[] dArr = this.doubleBindings;
                if (dArr.length < i8) {
                    double[] copyOf3 = Arrays.copyOf(dArr, i8);
                    g0.o(copyOf3, "copyOf(...)");
                    this.doubleBindings = copyOf3;
                    return;
                }
                return;
            }
            if (i6 == 3) {
                String[] strArr = this.stringBindings;
                if (strArr.length < i8) {
                    Object[] copyOf4 = Arrays.copyOf(strArr, i8);
                    g0.o(copyOf4, "copyOf(...)");
                    this.stringBindings = (String[]) copyOf4;
                    return;
                }
                return;
            }
            if (i6 != 4) {
                return;
            }
            byte[][] bArr = this.blobBindings;
            if (bArr.length < i8) {
                Object[] copyOf5 = Arrays.copyOf(bArr, i8);
                g0.o(copyOf5, "copyOf(...)");
                this.blobBindings = (byte[][]) copyOf5;
            }
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public void bindDouble(int i6, double d6) {
            ensureCapacity(2, i6);
            this.bindingTypes[i6] = 2;
            this.doubleBindings[i6] = d6;
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public void bindLong(int i6, long j6) {
            ensureCapacity(1, i6);
            this.bindingTypes[i6] = 1;
            this.longBindings[i6] = j6;
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public void bindNull(int i6) {
            ensureCapacity(5, i6);
            this.bindingTypes[i6] = 5;
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public void clearBindings() {
            this.bindingTypes = new int[0];
            this.longBindings = new long[0];
            this.doubleBindings = new double[0];
            this.stringBindings = new String[0];
            this.blobBindings = new byte[0][];
        }

        public AutoClosingSupportSQLiteStatement(@NotNull String sql, @NotNull AutoCloser autoCloser) {
            g0.p(sql, "sql");
            g0.p(autoCloser, "autoCloser");
            this.sql = sql;
            this.autoCloser = autoCloser;
            this.bindingTypes = new int[0];
            this.longBindings = new long[0];
            this.doubleBindings = new double[0];
            this.stringBindings = new String[0];
            this.blobBindings = new byte[0][];
        }

        private final void bindTo(SupportSQLiteProgram supportSQLiteProgram) {
            int length = this.bindingTypes.length;
            for (int i6 = 1; i6 < length; i6++) {
                int i7 = this.bindingTypes[i6];
                if (i7 == 1) {
                    supportSQLiteProgram.bindLong(i6, this.longBindings[i6]);
                } else if (i7 == 2) {
                    supportSQLiteProgram.bindDouble(i6, this.doubleBindings[i6]);
                } else if (i7 == 3) {
                    String str = this.stringBindings[i6];
                    g0.m(str);
                    supportSQLiteProgram.bindString(i6, str);
                } else if (i7 == 4) {
                    byte[] bArr = this.blobBindings[i6];
                    g0.m(bArr);
                    supportSQLiteProgram.bindBlob(i6, bArr);
                } else if (i7 == 5) {
                    supportSQLiteProgram.bindNull(i6);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final n1 execute$lambda$0(SupportSQLiteStatement statement) {
            g0.p(statement, "statement");
            statement.execute();
            return n1.f44123a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final long executeInsert$lambda$2(SupportSQLiteStatement obj) {
            g0.p(obj, "obj");
            return obj.executeInsert();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final int executeUpdateDelete$lambda$1(SupportSQLiteStatement obj) {
            g0.p(obj, "obj");
            return obj.executeUpdateDelete();
        }

        private final <T> T executeWithRefCount(final Function1<? super SupportSQLiteStatement, ? extends T> function1) {
            return (T) this.autoCloser.executeRefCountingFunction(new Function1() { // from class: androidx.room.support.r
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Object executeWithRefCount$lambda$5;
                    executeWithRefCount$lambda$5 = AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteStatement.executeWithRefCount$lambda$5(AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteStatement.this, function1, (SupportSQLiteDatabase) obj);
                    return executeWithRefCount$lambda$5;
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Object executeWithRefCount$lambda$5(AutoClosingSupportSQLiteStatement autoClosingSupportSQLiteStatement, Function1 function1, SupportSQLiteDatabase db) {
            g0.p(db, "db");
            SupportSQLiteStatement compileStatement = db.compileStatement(autoClosingSupportSQLiteStatement.sql);
            autoClosingSupportSQLiteStatement.bindTo(compileStatement);
            return function1.invoke(compileStatement);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final long simpleQueryForLong$lambda$3(SupportSQLiteStatement obj) {
            g0.p(obj, "obj");
            return obj.simpleQueryForLong();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String simpleQueryForString$lambda$4(SupportSQLiteStatement obj) {
            g0.p(obj, "obj");
            return obj.simpleQueryForString();
        }

        @Override // androidx.sqlite.db.SupportSQLiteStatement
        public void execute() {
            executeWithRefCount(new Function1() { // from class: androidx.room.support.t
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    n1 execute$lambda$0;
                    execute$lambda$0 = AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteStatement.execute$lambda$0((SupportSQLiteStatement) obj);
                    return execute$lambda$0;
                }
            });
        }

        @Override // androidx.sqlite.db.SupportSQLiteStatement
        public long executeInsert() {
            return ((Number) executeWithRefCount(new Function1() { // from class: androidx.room.support.s
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    long executeInsert$lambda$2;
                    executeInsert$lambda$2 = AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteStatement.executeInsert$lambda$2((SupportSQLiteStatement) obj);
                    return Long.valueOf(executeInsert$lambda$2);
                }
            })).longValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteStatement
        public int executeUpdateDelete() {
            return ((Number) executeWithRefCount(new Function1() { // from class: androidx.room.support.q
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    int executeUpdateDelete$lambda$1;
                    executeUpdateDelete$lambda$1 = AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteStatement.executeUpdateDelete$lambda$1((SupportSQLiteStatement) obj);
                    return Integer.valueOf(executeUpdateDelete$lambda$1);
                }
            })).intValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteStatement
        public long simpleQueryForLong() {
            return ((Number) executeWithRefCount(new Function1() { // from class: androidx.room.support.o
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    long simpleQueryForLong$lambda$3;
                    simpleQueryForLong$lambda$3 = AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteStatement.simpleQueryForLong$lambda$3((SupportSQLiteStatement) obj);
                    return Long.valueOf(simpleQueryForLong$lambda$3);
                }
            })).longValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteStatement
        @Nullable
        public String simpleQueryForString() {
            return (String) executeWithRefCount(new Function1() { // from class: androidx.room.support.p
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    String simpleQueryForString$lambda$4;
                    simpleQueryForString$lambda$4 = AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteStatement.simpleQueryForString$lambda$4((SupportSQLiteStatement) obj);
                    return simpleQueryForString$lambda$4;
                }
            });
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public void bindBlob(int i6, @NotNull byte[] value) {
            g0.p(value, "value");
            ensureCapacity(4, i6);
            this.bindingTypes[i6] = 4;
            this.blobBindings[i6] = value;
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public void bindString(int i6, @NotNull String value) {
            g0.p(value, "value");
            ensureCapacity(3, i6);
            this.bindingTypes[i6] = 3;
            this.stringBindings[i6] = value;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            clearBindings();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class KeepAliveCursor implements Cursor {

        @NotNull
        private final AutoCloser autoCloser;

        @NotNull
        private final Cursor delegate;

        public KeepAliveCursor(@NotNull Cursor delegate, @NotNull AutoCloser autoCloser) {
            g0.p(delegate, "delegate");
            g0.p(autoCloser, "autoCloser");
            this.delegate = delegate;
            this.autoCloser = autoCloser;
        }

        @Override // android.database.Cursor, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.delegate.close();
            this.autoCloser.decrementCountAndScheduleClose();
        }

        @Override // android.database.Cursor
        public void copyStringToBuffer(int i6, CharArrayBuffer charArrayBuffer) {
            this.delegate.copyStringToBuffer(i6, charArrayBuffer);
        }

        @Override // android.database.Cursor
        @Deprecated(message = "Deprecated in Java")
        public void deactivate() {
            this.delegate.deactivate();
        }

        @Override // android.database.Cursor
        public byte[] getBlob(int i6) {
            return this.delegate.getBlob(i6);
        }

        @Override // android.database.Cursor
        public int getColumnCount() {
            return this.delegate.getColumnCount();
        }

        @Override // android.database.Cursor
        public int getColumnIndex(String str) {
            return this.delegate.getColumnIndex(str);
        }

        @Override // android.database.Cursor
        public int getColumnIndexOrThrow(String str) {
            return this.delegate.getColumnIndexOrThrow(str);
        }

        @Override // android.database.Cursor
        public String getColumnName(int i6) {
            return this.delegate.getColumnName(i6);
        }

        @Override // android.database.Cursor
        public String[] getColumnNames() {
            return this.delegate.getColumnNames();
        }

        @Override // android.database.Cursor
        public int getCount() {
            return this.delegate.getCount();
        }

        @Override // android.database.Cursor
        public double getDouble(int i6) {
            return this.delegate.getDouble(i6);
        }

        @Override // android.database.Cursor
        public Bundle getExtras() {
            return this.delegate.getExtras();
        }

        @Override // android.database.Cursor
        public float getFloat(int i6) {
            return this.delegate.getFloat(i6);
        }

        @Override // android.database.Cursor
        public int getInt(int i6) {
            return this.delegate.getInt(i6);
        }

        @Override // android.database.Cursor
        public long getLong(int i6) {
            return this.delegate.getLong(i6);
        }

        @Override // android.database.Cursor
        public Uri getNotificationUri() {
            return this.delegate.getNotificationUri();
        }

        @Override // android.database.Cursor
        public int getPosition() {
            return this.delegate.getPosition();
        }

        @Override // android.database.Cursor
        public short getShort(int i6) {
            return this.delegate.getShort(i6);
        }

        @Override // android.database.Cursor
        public String getString(int i6) {
            return this.delegate.getString(i6);
        }

        @Override // android.database.Cursor
        public int getType(int i6) {
            return this.delegate.getType(i6);
        }

        @Override // android.database.Cursor
        public boolean getWantsAllOnMoveCalls() {
            return this.delegate.getWantsAllOnMoveCalls();
        }

        @Override // android.database.Cursor
        public boolean isAfterLast() {
            return this.delegate.isAfterLast();
        }

        @Override // android.database.Cursor
        public boolean isBeforeFirst() {
            return this.delegate.isBeforeFirst();
        }

        @Override // android.database.Cursor
        public boolean isClosed() {
            return this.delegate.isClosed();
        }

        @Override // android.database.Cursor
        public boolean isFirst() {
            return this.delegate.isFirst();
        }

        @Override // android.database.Cursor
        public boolean isLast() {
            return this.delegate.isLast();
        }

        @Override // android.database.Cursor
        public boolean isNull(int i6) {
            return this.delegate.isNull(i6);
        }

        @Override // android.database.Cursor
        public boolean move(int i6) {
            return this.delegate.move(i6);
        }

        @Override // android.database.Cursor
        public boolean moveToFirst() {
            return this.delegate.moveToFirst();
        }

        @Override // android.database.Cursor
        public boolean moveToLast() {
            return this.delegate.moveToLast();
        }

        @Override // android.database.Cursor
        public boolean moveToNext() {
            return this.delegate.moveToNext();
        }

        @Override // android.database.Cursor
        public boolean moveToPosition(int i6) {
            return this.delegate.moveToPosition(i6);
        }

        @Override // android.database.Cursor
        public boolean moveToPrevious() {
            return this.delegate.moveToPrevious();
        }

        @Override // android.database.Cursor
        public void registerContentObserver(ContentObserver contentObserver) {
            this.delegate.registerContentObserver(contentObserver);
        }

        @Override // android.database.Cursor
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            this.delegate.registerDataSetObserver(dataSetObserver);
        }

        @Override // android.database.Cursor
        @Deprecated(message = "Deprecated in Java")
        public boolean requery() {
            return this.delegate.requery();
        }

        @Override // android.database.Cursor
        public Bundle respond(Bundle bundle) {
            return this.delegate.respond(bundle);
        }

        @Override // android.database.Cursor
        public void setExtras(Bundle bundle) {
            this.delegate.setExtras(bundle);
        }

        @Override // android.database.Cursor
        public void setNotificationUri(ContentResolver contentResolver, Uri uri) {
            this.delegate.setNotificationUri(contentResolver, uri);
        }

        @Override // android.database.Cursor
        public void unregisterContentObserver(ContentObserver contentObserver) {
            this.delegate.unregisterContentObserver(contentObserver);
        }

        @Override // android.database.Cursor
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            this.delegate.unregisterDataSetObserver(dataSetObserver);
        }
    }

    public AutoClosingRoomOpenHelper(@NotNull SupportSQLiteOpenHelper delegate, @NotNull AutoCloser autoCloser) {
        g0.p(delegate, "delegate");
        g0.p(autoCloser, "autoCloser");
        this.delegate = delegate;
        this.autoCloser = autoCloser;
        this.autoClosingDb = new AutoClosingSupportSQLiteDatabase(autoCloser);
        autoCloser.initOpenHelper(getDelegate());
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.autoClosingDb.close();
    }

    @NotNull
    public final AutoCloser getAutoCloser$room_runtime_release() {
        return this.autoCloser;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    @Nullable
    public String getDatabaseName() {
        return this.delegate.getDatabaseName();
    }

    @Override // androidx.room.DelegatingOpenHelper
    @NotNull
    public SupportSQLiteOpenHelper getDelegate() {
        return this.delegate;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    @NotNull
    public SupportSQLiteDatabase getReadableDatabase() {
        this.autoClosingDb.pokeOpen();
        return this.autoClosingDb;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    @NotNull
    public SupportSQLiteDatabase getWritableDatabase() {
        this.autoClosingDb.pokeOpen();
        return this.autoClosingDb;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public void setWriteAheadLoggingEnabled(boolean z5) {
        this.delegate.setWriteAheadLoggingEnabled(z5);
    }
}
