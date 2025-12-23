package g;

import android.annotation.SuppressLint;
import android.database.sqlite.SQLiteTransactionListener;
import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final /* synthetic */ class a {
    public static boolean d(SupportSQLiteDatabase supportSQLiteDatabase) {
        return false;
    }

    public static void b(SupportSQLiteDatabase supportSQLiteDatabase, @NotNull SQLiteTransactionListener transactionListener) {
        g0.p(transactionListener, "transactionListener");
        supportSQLiteDatabase.beginTransactionWithListener(transactionListener);
    }

    public static void c(SupportSQLiteDatabase supportSQLiteDatabase, @NotNull String sql, @SuppressLint({"ArrayReturn"}) @Nullable Object[] objArr) {
        g0.p(sql, "sql");
        throw new UnsupportedOperationException();
    }

    public static void a(SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.beginTransaction();
    }
}
