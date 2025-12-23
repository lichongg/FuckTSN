package io.netty.channel.unix;

import java.net.InetSocketAddress;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class DatagramSocketAddress extends InetSocketAddress {
    private static final long serialVersionUID = 3094819287843178401L;
    private final DatagramSocketAddress localAddress;
    private final int receivedAmount;

    public DatagramSocketAddress localAddress() {
        return this.localAddress;
    }

    public int receivedAmount() {
        return this.receivedAmount;
    }

    DatagramSocketAddress(String str, int i6, int i7, DatagramSocketAddress datagramSocketAddress) {
        super(str, i6);
        this.receivedAmount = i7;
        this.localAddress = datagramSocketAddress;
    }
}
