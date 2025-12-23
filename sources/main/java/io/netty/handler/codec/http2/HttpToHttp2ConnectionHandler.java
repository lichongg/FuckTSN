package io.netty.handler.codec.http2;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http2.Http2CodecUtil;
import io.netty.handler.codec.http2.HttpConversionUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class HttpToHttp2ConnectionHandler extends Http2ConnectionHandler {
    private int currentStreamId;
    private final boolean validateHeaders;

    protected HttpToHttp2ConnectionHandler(Http2ConnectionDecoder http2ConnectionDecoder, Http2ConnectionEncoder http2ConnectionEncoder, Http2Settings http2Settings, boolean z5) {
        super(http2ConnectionDecoder, http2ConnectionEncoder, http2Settings);
        this.validateHeaders = z5;
    }

    private int getStreamId(HttpHeaders httpHeaders) throws Exception {
        return httpHeaders.getInt(HttpConversionUtil.ExtensionHeaderNames.STREAM_ID.text(), connection().local().incrementAndGetNextStreamId());
    }

    private static void writeHeaders(ChannelHandlerContext channelHandlerContext, Http2ConnectionEncoder http2ConnectionEncoder, int i6, HttpHeaders httpHeaders, Http2Headers http2Headers, boolean z5, Http2CodecUtil.SimpleChannelPromiseAggregator simpleChannelPromiseAggregator) {
        http2ConnectionEncoder.writeHeaders(channelHandlerContext, i6, http2Headers, httpHeaders.getInt(HttpConversionUtil.ExtensionHeaderNames.STREAM_DEPENDENCY_ID.text(), 0), httpHeaders.getShort(HttpConversionUtil.ExtensionHeaderNames.STREAM_WEIGHT.text(), (short) 16), false, 0, z5, simpleChannelPromiseAggregator.newPromise());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a3 A[Catch: all -> 0x00ac, TRY_LEAVE, TryCatch #3 {all -> 0x00ac, blocks: (B:34:0x0092, B:36:0x00a3), top: B:33:0x0092 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c0  */
    /* JADX WARN: Type inference failed for: r0v16, types: [io.netty.handler.codec.http2.Http2Headers] */
    @Override // io.netty.handler.codec.http2.Http2ConnectionHandler, io.netty.channel.ChannelOutboundHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void write(io.netty.channel.ChannelHandlerContext r11, java.lang.Object r12, io.netty.channel.ChannelPromise r13) {
        /*
            Method dump skipped, instructions count: 210
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.http2.HttpToHttp2ConnectionHandler.write(io.netty.channel.ChannelHandlerContext, java.lang.Object, io.netty.channel.ChannelPromise):void");
    }

    protected HttpToHttp2ConnectionHandler(Http2ConnectionDecoder http2ConnectionDecoder, Http2ConnectionEncoder http2ConnectionEncoder, Http2Settings http2Settings, boolean z5, boolean z6) {
        super(http2ConnectionDecoder, http2ConnectionEncoder, http2Settings, z6);
        this.validateHeaders = z5;
    }
}
