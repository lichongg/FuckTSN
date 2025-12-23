package kotlin.io.path;

import java.nio.file.FileSystemException;
import java.nio.file.Path;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class IllegalFileNameException extends FileSystemException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IllegalFileNameException(@NotNull Path file, @Nullable Path path, @Nullable String str) {
        super(file.toString(), path != null ? path.toString() : null, str);
        kotlin.jvm.internal.g0.p(file, "file");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public IllegalFileNameException(@NotNull Path file) {
        this(file, null, null);
        kotlin.jvm.internal.g0.p(file, "file");
    }
}
