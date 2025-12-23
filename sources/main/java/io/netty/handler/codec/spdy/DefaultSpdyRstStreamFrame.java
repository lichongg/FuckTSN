package io.netty.handler.codec.spdy;

import io.netty.util.internal.StringUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class DefaultSpdyRstStreamFrame extends DefaultSpdyStreamFrame implements SpdyRstStreamFrame {
    private SpdyStreamStatus status;

    public DefaultSpdyRstStreamFrame(int i6, int i7) {
        this(i6, SpdyStreamStatus.valueOf(i7));
    }

    public DefaultSpdyRstStreamFrame(int i6, SpdyStreamStatus spdyStreamStatus) {
        super(i6);
        setStatus(spdyStreamStatus);
    }

    @Override // io.netty.handler.codec.spdy.DefaultSpdyStreamFrame, io.netty.handler.codec.spdy.SpdyStreamFrame, io.netty.handler.codec.spdy.SpdyDataFrame
    public SpdyRstStreamFrame setLast(boolean z5) {
        super.setLast(z5);
        return this;
    }

    @Override // io.netty.handler.codec.spdy.SpdyRstStreamFrame
    public SpdyRstStreamFrame setStatus(SpdyStreamStatus spdyStreamStatus) {
        this.status = spdyStreamStatus;
        return this;
    }

    @Override // io.netty.handler.codec.spdy.DefaultSpdyStreamFrame, io.netty.handler.codec.spdy.SpdyStreamFrame, io.netty.handler.codec.spdy.SpdyDataFrame
    public SpdyRstStreamFrame setStreamId(int i6) {
        super.setStreamId(i6);
        return this;
    }

    @Override // io.netty.handler.codec.spdy.SpdyRstStreamFrame
    public SpdyStreamStatus status() {
        return this.status;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(StringUtil.simpleClassName(this));
        String str = StringUtil.NEWLINE;
        sb.append(str);
        sb.append("--> Stream-ID = ");
        sb.append(streamId());
        sb.append(str);
        sb.append("--> Status: ");
        sb.append(status());
        return sb.toString();
    }
}
