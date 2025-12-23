package androidx.room.util;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.RestrictTo;
import androidx.room.PooledConnection;
import androidx.room.RoomDatabase;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteQuery;
import java.io.File;
import java.io.IOException;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.coroutines.e;
import kotlin.coroutines.i;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: D:\Downloads\app\classes.dex */
public final class DBUtil {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final void dropFtsSyncTriggers(@NotNull SQLiteConnection sQLiteConnection) {
        DBUtil__DBUtilKt.dropFtsSyncTriggers(sQLiteConnection);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final void foreignKeyCheck(@NotNull SQLiteConnection sQLiteConnection, @NotNull String str) {
        DBUtil__DBUtilKt.foreignKeyCheck(sQLiteConnection, str);
    }

    @Deprecated(message = "This is only used in the generated code and shouldn't be called directly.")
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @NotNull
    public static final Cursor query(@NotNull RoomDatabase roomDatabase, @NotNull SupportSQLiteQuery supportSQLiteQuery, boolean z5) {
        return DBUtil__DBUtil_androidKt.query(roomDatabase, supportSQLiteQuery, z5);
    }

    @Deprecated(message = "Replaced by dropFtsSyncTriggers(connection: SQLiteConnection)")
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final void dropFtsSyncTriggers(@NotNull SupportSQLiteDatabase supportSQLiteDatabase) {
        DBUtil__DBUtil_androidKt.dropFtsSyncTriggers(supportSQLiteDatabase);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final void foreignKeyCheck(@NotNull SupportSQLiteDatabase supportSQLiteDatabase, @NotNull String str) {
        DBUtil__DBUtil_androidKt.foreignKeyCheck(supportSQLiteDatabase, str);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @NotNull
    public static final Cursor query(@NotNull RoomDatabase roomDatabase, @NotNull SupportSQLiteQuery supportSQLiteQuery, boolean z5, @Nullable CancellationSignal cancellationSignal) {
        return DBUtil__DBUtil_androidKt.query(roomDatabase, supportSQLiteQuery, z5, cancellationSignal);
    }

    @Deprecated(message = "Use constructor", replaceWith = @ReplaceWith(expression = "CancellationSignal()", imports = {"android.os.CancellationSignal"}))
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @NotNull
    public static final CancellationSignal createCancellationSignal() {
        return DBUtil__DBUtil_androidKt.createCancellationSignal();
    }

    @Nullable
    public static final Object getCoroutineContext(@NotNull RoomDatabase roomDatabase, boolean z5, @NotNull e<? super i> eVar) {
        return DBUtil__DBUtil_androidKt.getCoroutineContext(roomDatabase, z5, eVar);
    }

    @Nullable
    public static final <R> Object internalPerform(@NotNull RoomDatabase roomDatabase, boolean z5, boolean z6, @NotNull Function2<? super PooledConnection, ? super e<? super R>, ? extends Object> function2, @NotNull e<? super R> eVar) {
        return DBUtil__DBUtilKt.internalPerform(roomDatabase, z5, z6, function2, eVar);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final <R> R performBlocking(@NotNull RoomDatabase roomDatabase, boolean z5, boolean z6, @NotNull Function1<? super SQLiteConnection, ? extends R> function1) {
        return (R) DBUtil__DBUtil_androidKt.performBlocking(roomDatabase, z5, z6, function1);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Nullable
    public static final <R> Object performInTransactionSuspending(@NotNull RoomDatabase roomDatabase, @NotNull Function1<? super e<? super R>, ? extends Object> function1, @NotNull e<? super R> eVar) {
        return DBUtil__DBUtil_androidKt.performInTransactionSuspending(roomDatabase, function1, eVar);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Nullable
    public static final <R> Object performSuspending(@NotNull RoomDatabase roomDatabase, boolean z5, boolean z6, @NotNull Function1<? super SQLiteConnection, ? extends R> function1, @NotNull e<? super R> eVar) {
        return DBUtil__DBUtil_androidKt.performSuspending(roomDatabase, z5, z6, function1, eVar);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final int readVersion(@NotNull File file) throws IOException {
        return DBUtil__DBUtil_androidKt.readVersion(file);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @NotNull
    public static final SQLiteConnection toSQLiteConnection(@NotNull SupportSQLiteDatabase supportSQLiteDatabase) {
        return DBUtil__DBUtil_androidKt.toSQLiteConnection(supportSQLiteDatabase);
    }
}
