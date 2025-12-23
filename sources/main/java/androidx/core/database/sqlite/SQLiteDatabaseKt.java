package androidx.core.database.sqlite;

import android.database.sqlite.SQLiteDatabase;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.d0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class SQLiteDatabaseKt {
    public static /* synthetic */ Object transaction$default(SQLiteDatabase sQLiteDatabase, boolean z5, Function1 function1, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            z5 = true;
        }
        if (z5) {
            sQLiteDatabase.beginTransaction();
        } else {
            sQLiteDatabase.beginTransactionNonExclusive();
        }
        try {
            Object invoke = function1.invoke(sQLiteDatabase);
            sQLiteDatabase.setTransactionSuccessful();
            return invoke;
        } finally {
            d0.d(1);
            sQLiteDatabase.endTransaction();
            d0.c(1);
        }
    }

    public static final <T> T transaction(@NotNull SQLiteDatabase sQLiteDatabase, boolean z5, @NotNull Function1<? super SQLiteDatabase, ? extends T> function1) {
        if (z5) {
            sQLiteDatabase.beginTransaction();
        } else {
            sQLiteDatabase.beginTransactionNonExclusive();
        }
        try {
            T invoke = function1.invoke(sQLiteDatabase);
            sQLiteDatabase.setTransactionSuccessful();
            return invoke;
        } finally {
            d0.d(1);
            sQLiteDatabase.endTransaction();
            d0.c(1);
        }
    }
}
