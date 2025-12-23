package io.netty.handler.codec.spdy;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class DefaultSpdyWindowUpdateFrame implements SpdyWindowUpdateFrame {
    private int deltaWindowSize;
    private int streamId;

    @Override // io.netty.handler.codec.spdy.SpdyWindowUpdateFrame
    public int deltaWindowSize() {
        return this.deltaWindowSize;
    }

    @Override // io.netty.handler.codec.spdy.SpdyWindowUpdateFrame
    public SpdyWindowUpdateFrame setDeltaWindowSize(int i6) {
        ObjectUtil.checkPositive(i6, "deltaWindowSize");
        this.deltaWindowSize = i6;
        return this;
    }

    @Override // io.netty.handler.codec.spdy.SpdyWindowUpdateFrame
    public SpdyWindowUpdateFrame setStreamId(int i6) {
        ObjectUtil.checkPositiveOrZero(i6, "streamId");
        this.streamId = i6;
        return this;
    }

    @Override // io.netty.handler.codec.spdy.SpdyWindowUpdateFrame
    public int streamId() {
        return this.streamId;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(StringUtil.simpleClassName(this));
        String str = StringUtil.NEWLINE;
        sb.append(str);
        sb.append("--> Stream-ID = ");
        sb.append(streamId());
        sb.append(str);
        sb.append("--> Delta-Window-Size = ");
        sb.append(deltaWindowSize());
        return sb.toString();
    }

    public DefaultSpdyWindowUpdateFrame(int i6, int i7) {
        setStreamId(i6);
        setDeltaWindowSize(i7);
    }
}
