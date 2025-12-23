package io.netty.channel.epoll;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.unix.IovArray;
import io.netty.channel.unix.Limits;
import io.netty.channel.unix.NativeInetAddress;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class NativeDatagramPacketArray implements ChannelOutboundBuffer.MessageProcessor {
    private int count;
    private final NativeDatagramPacket[] packets = new NativeDatagramPacket[Limits.UIO_MAX_IOV];
    private final IovArray iovArray = new IovArray();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class NativeDatagramPacket {
        private byte[] addr;
        private int count;
        private long memoryAddress;
        private int port;
        private int scopeId;

        /* JADX INFO: Access modifiers changed from: private */
        public void init(long j6, int i6, InetSocketAddress inetSocketAddress) {
            this.memoryAddress = j6;
            this.count = i6;
            InetAddress address = inetSocketAddress.getAddress();
            if (address instanceof Inet6Address) {
                this.addr = address.getAddress();
                this.scopeId = ((Inet6Address) address).getScopeId();
            } else {
                this.addr = NativeInetAddress.ipv4MappedIpv6Address(address.getAddress());
                this.scopeId = 0;
            }
            this.port = inetSocketAddress.getPort();
        }

        NativeDatagramPacket() {
        }
    }

    void clear() {
        this.count = 0;
        this.iovArray.clear();
    }

    boolean add(DatagramPacket datagramPacket) {
        if (this.count == this.packets.length) {
            return false;
        }
        ByteBuf content = datagramPacket.content();
        if (content.readableBytes() == 0) {
            return true;
        }
        NativeDatagramPacket nativeDatagramPacket = this.packets[this.count];
        InetSocketAddress recipient = datagramPacket.recipient();
        int count = this.iovArray.count();
        if (!this.iovArray.add(content)) {
            return false;
        }
        nativeDatagramPacket.init(this.iovArray.memoryAddress(count), this.iovArray.count() - count, recipient);
        this.count++;
        return true;
    }

    int count() {
        return this.count;
    }

    NativeDatagramPacket[] packets() {
        return this.packets;
    }

    @Override // io.netty.channel.ChannelOutboundBuffer.MessageProcessor
    public boolean processMessage(Object obj) {
        return (obj instanceof DatagramPacket) && add((DatagramPacket) obj);
    }

    void release() {
        this.iovArray.release();
    }

    NativeDatagramPacketArray() {
        int i6 = 0;
        while (true) {
            NativeDatagramPacket[] nativeDatagramPacketArr = this.packets;
            if (i6 < nativeDatagramPacketArr.length) {
                nativeDatagramPacketArr[i6] = new NativeDatagramPacket();
                i6++;
            } else {
                return;
            }
        }
    }
}
