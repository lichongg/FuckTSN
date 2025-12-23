package io.netty.handler.codec.socks;

import io.netty.buffer.ByteBuf;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class SocksInitRequest extends SocksRequest {
    private final List<SocksAuthScheme> authSchemes;

    public SocksInitRequest(List<SocksAuthScheme> list) {
        super(SocksRequestType.INIT);
        if (list == null) {
            throw new NullPointerException("authSchemes");
        }
        this.authSchemes = list;
    }

    public List<SocksAuthScheme> authSchemes() {
        return Collections.unmodifiableList(this.authSchemes);
    }

    @Override // io.netty.handler.codec.socks.SocksMessage
    public void encodeAsByteBuf(ByteBuf byteBuf) {
        byteBuf.writeByte(protocolVersion().byteValue());
        byteBuf.writeByte(this.authSchemes.size());
        Iterator<SocksAuthScheme> it = this.authSchemes.iterator();
        while (it.hasNext()) {
            byteBuf.writeByte(it.next().byteValue());
        }
    }
}
