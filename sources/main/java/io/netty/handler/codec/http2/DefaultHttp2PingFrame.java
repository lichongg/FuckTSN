package io.netty.handler.codec.http2;

import io.netty.util.internal.StringUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class DefaultHttp2PingFrame implements Http2PingFrame {
    private final boolean ack;
    private final long content;

    public DefaultHttp2PingFrame(long j6) {
        this(j6, false);
    }

    public DefaultHttp2PingFrame(long j6, boolean z5) {
        this.content = j6;
        this.ack = z5;
    }

    @Override // io.netty.handler.codec.http2.Http2PingFrame
    public boolean ack() {
        return this.ack;
    }

    @Override // io.netty.handler.codec.http2.Http2PingFrame
    public long content() {
        return this.content;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Http2PingFrame)) {
            return false;
        }
        Http2PingFrame http2PingFrame = (Http2PingFrame) obj;
        return this.ack == http2PingFrame.ack() && this.content == http2PingFrame.content();
    }

    @Override // io.netty.handler.codec.http2.Http2Frame
    public String name() {
        return "PING";
    }

    public String toString() {
        return StringUtil.simpleClassName(this) + "(content=" + this.content + ", ack=" + this.ack + ')';
    }

    public int hashCode() {
        return (super.hashCode() * 31) + (this.ack ? 1 : 0);
    }
}
