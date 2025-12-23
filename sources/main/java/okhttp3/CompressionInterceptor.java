package okhttp3;

import java.util.ArrayList;
import kotlin.collections.f0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.text.u;
import okhttp3.Interceptor;
import okhttp3.internal.http.HttpHeaders;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nCompressionInterceptor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CompressionInterceptor.kt\nokhttp3/CompressionInterceptor\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,96:1\n11561#2:97\n11896#2,3:98\n*S KotlinDebug\n*F\n+ 1 CompressionInterceptor.kt\nokhttp3/CompressionInterceptor\n*L\n39#1:97\n39#1:98,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public class CompressionInterceptor implements Interceptor {

    @NotNull
    private final String acceptEncoding;

    @NotNull
    private final DecompressionAlgorithm[] algorithms;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface DecompressionAlgorithm {
        @NotNull
        Source decompress(@NotNull BufferedSource bufferedSource);

        @NotNull
        String getEncoding();
    }

    public CompressionInterceptor(@NotNull DecompressionAlgorithm... algorithms) {
        g0.p(algorithms, "algorithms");
        this.algorithms = algorithms;
        ArrayList arrayList = new ArrayList(algorithms.length);
        for (DecompressionAlgorithm decompressionAlgorithm : algorithms) {
            arrayList.add(decompressionAlgorithm.getEncoding());
        }
        this.acceptEncoding = f0.r3(arrayList, ", ", null, null, 0, null, null, 62, null);
    }

    @NotNull
    public final Response decompress$okhttp(@NotNull Response response) {
        DecompressionAlgorithm lookupDecompressor$okhttp;
        g0.p(response, "response");
        if (!HttpHeaders.promisesBody(response)) {
            return response;
        }
        ResponseBody body = response.body();
        String header$default = Response.header$default(response, "Content-Encoding", null, 2, null);
        return (header$default == null || (lookupDecompressor$okhttp = lookupDecompressor$okhttp(header$default)) == null) ? response : response.newBuilder().removeHeader("Content-Encoding").removeHeader("Content-Length").body(ResponseBody.Companion.create(Okio.buffer(lookupDecompressor$okhttp.decompress(body.source())), body.contentType(), -1L)).build();
    }

    @NotNull
    public final String getAcceptEncoding$okhttp() {
        return this.acceptEncoding;
    }

    @NotNull
    public final DecompressionAlgorithm[] getAlgorithms() {
        return this.algorithms;
    }

    @Override // okhttp3.Interceptor
    @NotNull
    public Response intercept(@NotNull Interceptor.Chain chain) {
        g0.p(chain, "chain");
        return ((this.algorithms.length == 0) || chain.request().header("Accept-Encoding") != null) ? chain.proceed(chain.request()) : decompress$okhttp(chain.proceed(chain.request().newBuilder().header("Accept-Encoding", this.acceptEncoding).build()));
    }

    @Nullable
    public final DecompressionAlgorithm lookupDecompressor$okhttp(@NotNull String encoding) {
        g0.p(encoding, "encoding");
        for (DecompressionAlgorithm decompressionAlgorithm : this.algorithms) {
            if (u.a2(decompressionAlgorithm.getEncoding(), encoding, true)) {
                return decompressionAlgorithm;
            }
        }
        return null;
    }
}
