package io.netty.handler.codec.dns;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.DatagramPacket;
import io.netty.handler.codec.MessageToMessageDecoder;
import java.net.InetSocketAddress;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@ChannelHandler.Sharable
/* loaded from: D:\Downloads\app\classes7.dex */
public class DatagramDnsResponseDecoder extends MessageToMessageDecoder<DatagramPacket> {
    private final DnsResponseDecoder<InetSocketAddress> responseDecoder;

    public DatagramDnsResponseDecoder() {
        this(DnsRecordDecoder.DEFAULT);
    }

    @Override // io.netty.handler.codec.MessageToMessageDecoder
    protected /* bridge */ /* synthetic */ void decode(ChannelHandlerContext channelHandlerContext, DatagramPacket datagramPacket, List list) throws Exception {
        decode2(channelHandlerContext, datagramPacket, (List<Object>) list);
    }

    public DatagramDnsResponseDecoder(DnsRecordDecoder dnsRecordDecoder) {
        this.responseDecoder = new DnsResponseDecoder<InetSocketAddress>(dnsRecordDecoder) { // from class: io.netty.handler.codec.dns.DatagramDnsResponseDecoder.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // io.netty.handler.codec.dns.DnsResponseDecoder
            public DnsResponse newResponse(InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, int i6, DnsOpCode dnsOpCode, DnsResponseCode dnsResponseCode) {
                return new DatagramDnsResponse(inetSocketAddress, inetSocketAddress2, i6, dnsOpCode, dnsResponseCode);
            }
        };
    }

    /* renamed from: decode, reason: avoid collision after fix types in other method */
    protected void decode2(ChannelHandlerContext channelHandlerContext, DatagramPacket datagramPacket, List<Object> list) throws Exception {
        list.add(this.responseDecoder.decode(datagramPacket.sender(), datagramPacket.recipient(), datagramPacket.content()));
    }
}
