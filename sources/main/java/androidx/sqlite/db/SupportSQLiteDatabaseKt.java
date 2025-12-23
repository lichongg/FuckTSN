package androidx.sqlite.db;

import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.d0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JvmName(name = "SupportSQLiteDatabaseKt")
/* loaded from: D:\Downloads\app\classes.dex */
public final class SupportSQLiteDatabaseKt {
    public static /* synthetic */ Object transaction$default(SupportSQLiteDatabase supportSQLiteDatabase, boolean z5, Function1 function1, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            z5 = true;
        }
        if (z5) {
            supportSQLiteDatabase.beginTransaction();
        } else {
            supportSQLiteDatabase.beginTransactionNonExclusive();
        }
        try {
            Object invoke = function1.invoke(supportSQLiteDatabase);
            d0.d(1);
            supportSQLiteDatabase.setTransactionSuccessful();
            supportSQLiteDatabase.endTransaction();
            d0.c(1);
            return invoke;
        } finally {
        }
    }

    public static final <T> T transaction(@NotNull SupportSQLiteDatabase supportSQLiteDatabase, boolean z5, @NotNull Function1<? super SupportSQLiteDatabase, ? extends T> function1) {
        if (z5) {
            supportSQLiteDatabase.beginTransaction();
        } else {
            supportSQLiteDatabase.beginTransactionNonExclusive();
        }
        try {
            T invoke = function1.invoke(supportSQLiteDatabase);
            d0.d(1);
            supportSQLiteDatabase.setTransactionSuccessful();
            supportSQLiteDatabase.endTransaction();
            d0.c(1);
            return invoke;
        } finally {
        }
    }
}
