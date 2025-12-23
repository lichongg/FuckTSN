package androidx.room.support;

import androidx.sqlite.db.SupportSQLiteProgram;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class QueryInterceptorProgram implements SupportSQLiteProgram {

    @NotNull
    private final List<Object> bindArgsCache = new ArrayList();

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindNull(int i6) {
        saveArgsToCache(i6, null);
    }

    private final void saveArgsToCache(int i6, Object obj) {
        int size;
        int i7 = i6 - 1;
        if (i7 >= this.bindArgsCache.size() && (size = this.bindArgsCache.size()) <= i7) {
            while (true) {
                this.bindArgsCache.add(null);
                if (size == i7) {
                    break;
                } else {
                    size++;
                }
            }
        }
        this.bindArgsCache.set(i7, obj);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void clearBindings() {
        this.bindArgsCache.clear();
    }

    @NotNull
    public final List<Object> getBindArgsCache$room_runtime_release() {
        return this.bindArgsCache;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindBlob(int i6, @NotNull byte[] value) {
        g0.p(value, "value");
        saveArgsToCache(i6, value);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindDouble(int i6, double d6) {
        saveArgsToCache(i6, Double.valueOf(d6));
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindLong(int i6, long j6) {
        saveArgsToCache(i6, Long.valueOf(j6));
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindString(int i6, @NotNull String value) {
        g0.p(value, "value");
        saveArgsToCache(i6, value);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }
}
