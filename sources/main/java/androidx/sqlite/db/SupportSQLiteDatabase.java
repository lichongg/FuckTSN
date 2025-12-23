package androidx.sqlite.db;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteTransactionListener;
import android.os.CancellationSignal;
import android.util.Pair;
import java.io.Closeable;
import java.util.List;
import java.util.Locale;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public interface SupportSQLiteDatabase extends Closeable {
    void beginTransaction();

    void beginTransactionNonExclusive();

    void beginTransactionReadOnly();

    void beginTransactionWithListener(@NotNull SQLiteTransactionListener sQLiteTransactionListener);

    void beginTransactionWithListenerNonExclusive(@NotNull SQLiteTransactionListener sQLiteTransactionListener);

    void beginTransactionWithListenerReadOnly(@NotNull SQLiteTransactionListener sQLiteTransactionListener);

    @NotNull
    SupportSQLiteStatement compileStatement(@NotNull String str);

    int delete(@NotNull String str, @Nullable String str2, @Nullable Object[] objArr);

    void disableWriteAheadLogging();

    boolean enableWriteAheadLogging();

    void endTransaction();

    void execPerConnectionSQL(@NotNull String str, @SuppressLint({"ArrayReturn"}) @Nullable Object[] objArr);

    void execSQL(@NotNull String str) throws SQLException;

    void execSQL(@NotNull String str, @NotNull Object[] objArr) throws SQLException;

    @Nullable
    List<Pair<String, String>> getAttachedDbs();

    long getMaximumSize();

    long getPageSize();

    @Nullable
    String getPath();

    int getVersion();

    boolean inTransaction();

    long insert(@NotNull String str, int i6, @NotNull ContentValues contentValues) throws SQLException;

    boolean isDatabaseIntegrityOk();

    boolean isDbLockedByCurrentThread();

    boolean isExecPerConnectionSQLSupported();

    boolean isOpen();

    boolean isReadOnly();

    boolean isWriteAheadLoggingEnabled();

    boolean needUpgrade(int i6);

    @NotNull
    Cursor query(@NotNull SupportSQLiteQuery supportSQLiteQuery);

    @NotNull
    Cursor query(@NotNull SupportSQLiteQuery supportSQLiteQuery, @Nullable CancellationSignal cancellationSignal);

    @NotNull
    Cursor query(@NotNull String str);

    @NotNull
    Cursor query(@NotNull String str, @NotNull Object[] objArr);

    void setForeignKeyConstraintsEnabled(boolean z5);

    void setLocale(@NotNull Locale locale);

    void setMaxSqlCacheSize(int i6);

    long setMaximumSize(long j6);

    void setPageSize(long j6);

    void setTransactionSuccessful();

    void setVersion(int i6);

    int update(@NotNull String str, int i6, @NotNull ContentValues contentValues, @Nullable String str2, @Nullable Object[] objArr);

    boolean yieldIfContendedSafely();

    boolean yieldIfContendedSafely(long j6);
}
