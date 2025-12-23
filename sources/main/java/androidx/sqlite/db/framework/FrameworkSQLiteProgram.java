package androidx.sqlite.db.framework;

import android.database.sqlite.SQLiteProgram;
import androidx.sqlite.db.SupportSQLiteProgram;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public class FrameworkSQLiteProgram implements SupportSQLiteProgram {

    @NotNull
    private final SQLiteProgram delegate;

    public FrameworkSQLiteProgram(@NotNull SQLiteProgram delegate) {
        g0.p(delegate, "delegate");
        this.delegate = delegate;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindDouble(int i6, double d6) {
        this.delegate.bindDouble(i6, d6);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindLong(int i6, long j6) {
        this.delegate.bindLong(i6, j6);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindNull(int i6) {
        this.delegate.bindNull(i6);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void clearBindings() {
        this.delegate.clearBindings();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.delegate.close();
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindBlob(int i6, @NotNull byte[] value) {
        g0.p(value, "value");
        this.delegate.bindBlob(i6, value);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindString(int i6, @NotNull String value) {
        g0.p(value, "value");
        this.delegate.bindString(i6, value);
    }
}
