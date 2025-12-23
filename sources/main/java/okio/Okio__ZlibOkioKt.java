package okio;

import java.io.IOException;
import kotlin.jvm.internal.g0;
import okio.internal.ZipFilesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
final /* synthetic */ class Okio__ZlibOkioKt {
    @NotNull
    public static final FileSystem openZip(@NotNull FileSystem fileSystem, @NotNull Path zipPath) throws IOException {
        g0.p(fileSystem, "<this>");
        g0.p(zipPath, "zipPath");
        return ZipFilesKt.openZip$default(zipPath, fileSystem, null, 4, null);
    }
}
