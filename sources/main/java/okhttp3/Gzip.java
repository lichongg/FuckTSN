package okhttp3;

import kotlin.jvm.internal.g0;
import okhttp3.CompressionInterceptor;
import okio.BufferedSource;
import okio.GzipSource;
import okio.Source;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class Gzip implements CompressionInterceptor.DecompressionAlgorithm {

    @NotNull
    public static final Gzip INSTANCE = new Gzip();

    @Override // okhttp3.CompressionInterceptor.DecompressionAlgorithm
    @NotNull
    public Source decompress(@NotNull BufferedSource compressedSource) {
        g0.p(compressedSource, "compressedSource");
        return new GzipSource(compressedSource);
    }

    @Override // okhttp3.CompressionInterceptor.DecompressionAlgorithm
    @NotNull
    public String getEncoding() {
        return "gzip";
    }

    private Gzip() {
    }
}
