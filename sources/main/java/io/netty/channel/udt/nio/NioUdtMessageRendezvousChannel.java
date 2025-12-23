package io.netty.channel.udt.nio;

import com.barchart.udt.TypeUDT;
import com.barchart.udt.nio.SocketChannelUDT;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Deprecated
/* loaded from: D:\Downloads\app\classes7.dex */
public class NioUdtMessageRendezvousChannel extends NioUdtMessageConnectorChannel {
    public NioUdtMessageRendezvousChannel() {
        super((SocketChannelUDT) NioUdtProvider.newRendezvousChannelUDT(TypeUDT.DATAGRAM));
    }
}
