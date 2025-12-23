package androidx.sqlite.db;

import java.io.Closeable;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public interface SupportSQLiteProgram extends Closeable {
    void bindBlob(int i6, @NotNull byte[] bArr);

    void bindDouble(int i6, double d6);

    void bindLong(int i6, long j6);

    void bindNull(int i6);

    void bindString(int i6, @NotNull String str);

    void clearBindings();
}
