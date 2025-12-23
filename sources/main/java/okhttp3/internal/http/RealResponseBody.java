package okhttp3.internal.http;

import kotlin.jvm.internal.g0;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.BufferedSource;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class RealResponseBody extends ResponseBody {
    private final long contentLength;

    @Nullable
    private final String contentTypeString;

    @NotNull
    private final BufferedSource source;

    public RealResponseBody(@Nullable String str, long j6, @NotNull BufferedSource source) {
        g0.p(source, "source");
        this.contentTypeString = str;
        this.contentLength = j6;
        this.source = source;
    }

    @Override // okhttp3.ResponseBody
    public long contentLength() {
        return this.contentLength;
    }

    @Override // okhttp3.ResponseBody
    @Nullable
    public MediaType contentType() {
        String str = this.contentTypeString;
        if (str != null) {
            return MediaType.Companion.parse(str);
        }
        return null;
    }

    @Override // okhttp3.ResponseBody
    @NotNull
    public BufferedSource source() {
        return this.source;
    }
}
