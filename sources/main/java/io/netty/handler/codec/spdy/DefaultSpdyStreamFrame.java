package io.netty.handler.codec.spdy;

import io.netty.util.internal.ObjectUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class DefaultSpdyStreamFrame implements SpdyStreamFrame {
    private boolean last;
    private int streamId;

    @Override // io.netty.handler.codec.spdy.SpdyStreamFrame
    public boolean isLast() {
        return this.last;
    }

    @Override // io.netty.handler.codec.spdy.SpdyStreamFrame, io.netty.handler.codec.spdy.SpdyDataFrame
    public SpdyStreamFrame setLast(boolean z5) {
        this.last = z5;
        return this;
    }

    @Override // io.netty.handler.codec.spdy.SpdyStreamFrame, io.netty.handler.codec.spdy.SpdyDataFrame
    public SpdyStreamFrame setStreamId(int i6) {
        ObjectUtil.checkPositive(i6, "streamId");
        this.streamId = i6;
        return this;
    }

    @Override // io.netty.handler.codec.spdy.SpdyStreamFrame
    public int streamId() {
        return this.streamId;
    }

    protected DefaultSpdyStreamFrame(int i6) {
        setStreamId(i6);
    }
}
