package okhttp3.internal;

import kotlin.jvm.internal.g0;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class UnreadableResponseBodyKt {
    @NotNull
    public static final Response stripBody(@NotNull Response response) {
        g0.p(response, "<this>");
        return response.newBuilder().body(new UnreadableResponseBody(response.body().contentType(), response.body().contentLength())).build();
    }
}
