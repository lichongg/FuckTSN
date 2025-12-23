package io.netty.handler.codec.http2;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class DefaultHttp2WindowUpdateFrame extends AbstractHttp2StreamFrame implements Http2WindowUpdateFrame {
    private final int windowUpdateIncrement;

    @Override // io.netty.handler.codec.http2.Http2Frame
    public String name() {
        return "WINDOW_UPDATE";
    }

    @Override // io.netty.handler.codec.http2.Http2WindowUpdateFrame
    public int windowSizeIncrement() {
        return this.windowUpdateIncrement;
    }

    public DefaultHttp2WindowUpdateFrame(int i6) {
        this.windowUpdateIncrement = i6;
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2StreamFrame, io.netty.handler.codec.http2.Http2StreamFrame
    public DefaultHttp2WindowUpdateFrame stream(Http2FrameStream http2FrameStream) {
        super.stream(http2FrameStream);
        return this;
    }
}
