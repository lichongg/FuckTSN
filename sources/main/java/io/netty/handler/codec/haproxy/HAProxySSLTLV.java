package io.netty.handler.codec.haproxy;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.haproxy.HAProxyTLV;
import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class HAProxySSLTLV extends HAProxyTLV {
    private final byte clientBitField;
    private final List<HAProxyTLV> tlvs;
    private final int verify;

    HAProxySSLTLV(int i6, byte b6, List<HAProxyTLV> list, ByteBuf byteBuf) {
        super(HAProxyTLV.Type.PP2_TYPE_SSL, (byte) 32, byteBuf);
        this.verify = i6;
        this.tlvs = Collections.unmodifiableList(list);
        this.clientBitField = b6;
    }

    public List<HAProxyTLV> encapsulatedTLVs() {
        return this.tlvs;
    }

    public boolean isPP2ClientCertConn() {
        return (this.clientBitField & 2) != 0;
    }

    public boolean isPP2ClientCertSess() {
        return (this.clientBitField & 4) != 0;
    }

    public boolean isPP2ClientSSL() {
        return (this.clientBitField & 1) != 0;
    }

    public int verify() {
        return this.verify;
    }
}
