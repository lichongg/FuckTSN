package io.netty.handler.codec.socksx.v5;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.EncoderException;
import io.netty.util.CharsetUtil;
import io.netty.util.NetUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface Socks5AddressEncoder {
    public static final Socks5AddressEncoder DEFAULT = new Socks5AddressEncoder() { // from class: io.netty.handler.codec.socksx.v5.Socks5AddressEncoder.1
        @Override // io.netty.handler.codec.socksx.v5.Socks5AddressEncoder
        public void encodeAddress(Socks5AddressType socks5AddressType, String str, ByteBuf byteBuf) throws Exception {
            byte byteValue = socks5AddressType.byteValue();
            if (byteValue == Socks5AddressType.IPv4.byteValue()) {
                if (str != null) {
                    byteBuf.writeBytes(NetUtil.createByteArrayFromIpAddressString(str));
                    return;
                } else {
                    byteBuf.writeInt(0);
                    return;
                }
            }
            if (byteValue == Socks5AddressType.DOMAIN.byteValue()) {
                if (str != null) {
                    byteBuf.writeByte(str.length());
                    byteBuf.writeCharSequence(str, CharsetUtil.US_ASCII);
                    return;
                } else {
                    byteBuf.writeByte(0);
                    return;
                }
            }
            if (byteValue == Socks5AddressType.IPv6.byteValue()) {
                if (str != null) {
                    byteBuf.writeBytes(NetUtil.createByteArrayFromIpAddressString(str));
                    return;
                } else {
                    byteBuf.writeLong(0L);
                    byteBuf.writeLong(0L);
                    return;
                }
            }
            throw new EncoderException("unsupported addrType: " + (socks5AddressType.byteValue() & 255));
        }
    };

    void encodeAddress(Socks5AddressType socks5AddressType, String str, ByteBuf byteBuf) throws Exception;
}
