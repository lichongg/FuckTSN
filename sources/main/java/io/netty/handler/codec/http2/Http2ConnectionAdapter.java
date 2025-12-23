package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.http2.Http2Connection;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class Http2ConnectionAdapter implements Http2Connection.Listener {
    @Override // io.netty.handler.codec.http2.Http2Connection.Listener
    public void onStreamActive(Http2Stream http2Stream) {
    }

    @Override // io.netty.handler.codec.http2.Http2Connection.Listener
    public void onStreamAdded(Http2Stream http2Stream) {
    }

    @Override // io.netty.handler.codec.http2.Http2Connection.Listener
    public void onStreamClosed(Http2Stream http2Stream) {
    }

    @Override // io.netty.handler.codec.http2.Http2Connection.Listener
    public void onStreamHalfClosed(Http2Stream http2Stream) {
    }

    @Override // io.netty.handler.codec.http2.Http2Connection.Listener
    public void onStreamRemoved(Http2Stream http2Stream) {
    }

    @Override // io.netty.handler.codec.http2.Http2Connection.Listener
    public void onGoAwayReceived(int i6, long j6, ByteBuf byteBuf) {
    }

    @Override // io.netty.handler.codec.http2.Http2Connection.Listener
    public void onGoAwaySent(int i6, long j6, ByteBuf byteBuf) {
    }
}
