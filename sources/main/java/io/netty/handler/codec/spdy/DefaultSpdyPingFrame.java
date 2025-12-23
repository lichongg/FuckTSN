package io.netty.handler.codec.spdy;

import io.netty.util.internal.StringUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class DefaultSpdyPingFrame implements SpdyPingFrame {
    private int id;

    @Override // io.netty.handler.codec.spdy.SpdyPingFrame
    public int id() {
        return this.id;
    }

    @Override // io.netty.handler.codec.spdy.SpdyPingFrame
    public SpdyPingFrame setId(int i6) {
        this.id = i6;
        return this;
    }

    public String toString() {
        return StringUtil.simpleClassName(this) + StringUtil.NEWLINE + "--> ID = " + id();
    }

    public DefaultSpdyPingFrame(int i6) {
        setId(i6);
    }
}
