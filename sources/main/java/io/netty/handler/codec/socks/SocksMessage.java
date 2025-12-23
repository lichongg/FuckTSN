package io.netty.handler.codec.socks;

import io.netty.buffer.ByteBuf;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class SocksMessage {
    private final SocksProtocolVersion protocolVersion = SocksProtocolVersion.SOCKS5;
    private final SocksMessageType type;

    @Deprecated
    public abstract void encodeAsByteBuf(ByteBuf byteBuf);

    public SocksProtocolVersion protocolVersion() {
        return this.protocolVersion;
    }

    public SocksMessageType type() {
        return this.type;
    }

    protected SocksMessage(SocksMessageType socksMessageType) {
        if (socksMessageType != null) {
            this.type = socksMessageType;
            return;
        }
        throw new NullPointerException("type");
    }
}
