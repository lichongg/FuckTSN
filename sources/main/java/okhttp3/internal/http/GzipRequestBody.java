package okhttp3.internal.http;

import kotlin.io.b;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;
import okio.GzipSink;
import okio.Okio;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nGzipRequestBody.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GzipRequestBody.kt\nokhttp3/internal/http/GzipRequestBody\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,37:1\n1#2:38\n*E\n"})
/* loaded from: D:\Downloads\app\classes3.dex */
public final class GzipRequestBody extends RequestBody {

    @NotNull
    private final RequestBody delegate;

    public GzipRequestBody(@NotNull RequestBody delegate) {
        g0.p(delegate, "delegate");
        this.delegate = delegate;
    }

    @Override // okhttp3.RequestBody
    public long contentLength() {
        return -1L;
    }

    @Override // okhttp3.RequestBody
    @Nullable
    public MediaType contentType() {
        return this.delegate.contentType();
    }

    @NotNull
    public final RequestBody getDelegate() {
        return this.delegate;
    }

    @Override // okhttp3.RequestBody
    public boolean isOneShot() {
        return this.delegate.isOneShot();
    }

    @Override // okhttp3.RequestBody
    public void writeTo(@NotNull BufferedSink sink) {
        g0.p(sink, "sink");
        BufferedSink buffer = Okio.buffer(new GzipSink(sink));
        try {
            this.delegate.writeTo(buffer);
            n1 n1Var = n1.f44123a;
            b.a(buffer, null);
        } finally {
        }
    }
}
