package okhttp3.internal.cache;

import java.io.IOException;
import okio.Sink;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface CacheRequest {
    void abort();

    @NotNull
    Sink body() throws IOException;
}
