package okhttp3.internal;

import kotlin.jvm.internal.g0;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;
import okio.Timeout;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class UnreadableResponseBody extends ResponseBody implements Source {
    private final long contentLength;

    @Nullable
    private final MediaType mediaType;

    @Override // okhttp3.ResponseBody
    public long contentLength() {
        return this.contentLength;
    }

    @Override // okhttp3.ResponseBody
    @Nullable
    public MediaType contentType() {
        return this.mediaType;
    }

    @Override // okio.Source
    public long read(@NotNull Buffer sink, long j6) {
        g0.p(sink, "sink");
        throw new IllegalStateException("Unreadable ResponseBody! These Response objects have bodies that are stripped:\n * Response.cacheResponse\n * Response.networkResponse\n * Response.priorResponse\n * EventSourceListener\n * WebSocketListener\n(It is safe to call contentType() and contentLength() on these response bodies.)");
    }

    @Override // okio.Source
    @NotNull
    public Timeout timeout() {
        return Timeout.NONE;
    }

    public UnreadableResponseBody(@Nullable MediaType mediaType, long j6) {
        this.mediaType = mediaType;
        this.contentLength = j6;
    }

    @Override // okhttp3.ResponseBody
    @NotNull
    public BufferedSource source() {
        return Okio.buffer(this);
    }

    @Override // okhttp3.ResponseBody, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }
}
