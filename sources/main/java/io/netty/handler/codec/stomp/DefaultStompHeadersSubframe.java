package io.netty.handler.codec.stomp;

import io.netty.handler.codec.DecoderResult;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class DefaultStompHeadersSubframe implements StompHeadersSubframe {
    protected final StompCommand command;
    protected DecoderResult decoderResult;
    protected final DefaultStompHeaders headers;

    public DefaultStompHeadersSubframe(StompCommand stompCommand) {
        this(stompCommand, null);
    }

    DefaultStompHeadersSubframe(StompCommand stompCommand, DefaultStompHeaders defaultStompHeaders) {
        this.decoderResult = DecoderResult.SUCCESS;
        if (stompCommand == null) {
            throw new NullPointerException("command");
        }
        this.command = stompCommand;
        this.headers = defaultStompHeaders == null ? new DefaultStompHeaders() : defaultStompHeaders;
    }

    @Override // io.netty.handler.codec.stomp.StompHeadersSubframe
    public StompCommand command() {
        return this.command;
    }

    @Override // io.netty.handler.codec.DecoderResultProvider
    public DecoderResult decoderResult() {
        return this.decoderResult;
    }

    @Override // io.netty.handler.codec.stomp.StompHeadersSubframe
    public StompHeaders headers() {
        return this.headers;
    }

    @Override // io.netty.handler.codec.DecoderResultProvider
    public void setDecoderResult(DecoderResult decoderResult) {
        this.decoderResult = decoderResult;
    }

    public String toString() {
        return "StompFrame{command=" + this.command + ", headers=" + this.headers + '}';
    }
}
