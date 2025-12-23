package io.netty.handler.codec.http.websocketx;

import io.netty.handler.codec.CorruptedFrameException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class CorruptedWebSocketFrameException extends CorruptedFrameException {
    private static final long serialVersionUID = 3918055132492988338L;
    private final WebSocketCloseStatus closeStatus;

    public CorruptedWebSocketFrameException() {
        this(WebSocketCloseStatus.PROTOCOL_ERROR, null, null);
    }

    public CorruptedWebSocketFrameException(WebSocketCloseStatus webSocketCloseStatus, String str, Throwable th) {
        super(str == null ? webSocketCloseStatus.reasonText() : str, th);
        this.closeStatus = webSocketCloseStatus;
    }

    public WebSocketCloseStatus closeStatus() {
        return this.closeStatus;
    }

    public CorruptedWebSocketFrameException(WebSocketCloseStatus webSocketCloseStatus, String str) {
        this(webSocketCloseStatus, str, null);
    }

    public CorruptedWebSocketFrameException(WebSocketCloseStatus webSocketCloseStatus, Throwable th) {
        this(webSocketCloseStatus, null, th);
    }
}
