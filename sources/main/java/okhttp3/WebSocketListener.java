package okhttp3;

import kotlin.jvm.internal.g0;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class WebSocketListener {
    public void onMessage(@NotNull WebSocket webSocket, @NotNull String text) {
        g0.p(webSocket, "webSocket");
        g0.p(text, "text");
    }

    public void onClosed(@NotNull WebSocket webSocket, int i6, @NotNull String reason) {
        g0.p(webSocket, "webSocket");
        g0.p(reason, "reason");
    }

    public void onClosing(@NotNull WebSocket webSocket, int i6, @NotNull String reason) {
        g0.p(webSocket, "webSocket");
        g0.p(reason, "reason");
    }

    public void onFailure(@NotNull WebSocket webSocket, @NotNull Throwable t5, @Nullable Response response) {
        g0.p(webSocket, "webSocket");
        g0.p(t5, "t");
    }

    public void onMessage(@NotNull WebSocket webSocket, @NotNull ByteString bytes) {
        g0.p(webSocket, "webSocket");
        g0.p(bytes, "bytes");
    }

    public void onOpen(@NotNull WebSocket webSocket, @NotNull Response response) {
        g0.p(webSocket, "webSocket");
        g0.p(response, "response");
    }
}
