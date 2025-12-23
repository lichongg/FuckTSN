package kotlin.io;

import java.io.File;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class NoSuchFileException extends FileSystemException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NoSuchFileException(@NotNull File file, @Nullable File file2, @Nullable String str) {
        super(file, file2, str);
        g0.p(file, "file");
    }

    public /* synthetic */ NoSuchFileException(File file, File file2, String str, int i6, v vVar) {
        this(file, (i6 & 2) != 0 ? null : file2, (i6 & 4) != 0 ? null : str);
    }
}
