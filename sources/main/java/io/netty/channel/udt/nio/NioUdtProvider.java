package io.netty.channel.udt.nio;

import com.barchart.udt.SocketUDT;
import com.barchart.udt.TypeUDT;
import com.barchart.udt.nio.ChannelUDT;
import com.barchart.udt.nio.KindUDT;
import com.barchart.udt.nio.RendezvousChannelUDT;
import com.barchart.udt.nio.SelectorProviderUDT;
import com.barchart.udt.nio.ServerSocketChannelUDT;
import com.barchart.udt.nio.SocketChannelUDT;
import io.netty.channel.Channel;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelFactory;
import io.netty.channel.udt.UdtChannel;
import io.netty.channel.udt.UdtServerChannel;
import java.io.IOException;
import java.nio.channels.spi.SelectorProvider;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Deprecated
/* loaded from: D:\Downloads\app\classes7.dex */
public final class NioUdtProvider<T extends UdtChannel> implements ChannelFactory<T> {
    public static final ChannelFactory<UdtServerChannel> BYTE_ACCEPTOR = new NioUdtProvider(TypeUDT.STREAM, KindUDT.ACCEPTOR);
    public static final ChannelFactory<UdtChannel> BYTE_CONNECTOR = new NioUdtProvider(TypeUDT.STREAM, KindUDT.CONNECTOR);
    public static final SelectorProvider BYTE_PROVIDER = SelectorProviderUDT.STREAM;
    public static final ChannelFactory<UdtChannel> BYTE_RENDEZVOUS = new NioUdtProvider(TypeUDT.STREAM, KindUDT.RENDEZVOUS);
    public static final ChannelFactory<UdtServerChannel> MESSAGE_ACCEPTOR = new NioUdtProvider(TypeUDT.DATAGRAM, KindUDT.ACCEPTOR);
    public static final ChannelFactory<UdtChannel> MESSAGE_CONNECTOR = new NioUdtProvider(TypeUDT.DATAGRAM, KindUDT.CONNECTOR);
    public static final SelectorProvider MESSAGE_PROVIDER = SelectorProviderUDT.DATAGRAM;
    public static final ChannelFactory<UdtChannel> MESSAGE_RENDEZVOUS = new NioUdtProvider(TypeUDT.DATAGRAM, KindUDT.RENDEZVOUS);
    private final KindUDT kind;
    private final TypeUDT type;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: io.netty.channel.udt.nio.NioUdtProvider$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$barchart$udt$TypeUDT;
        static final /* synthetic */ int[] $SwitchMap$com$barchart$udt$nio$KindUDT;

        static {
            int[] iArr = new int[KindUDT.values().length];
            $SwitchMap$com$barchart$udt$nio$KindUDT = iArr;
            try {
                iArr[KindUDT.ACCEPTOR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$barchart$udt$nio$KindUDT[KindUDT.CONNECTOR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$barchart$udt$nio$KindUDT[KindUDT.RENDEZVOUS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[TypeUDT.values().length];
            $SwitchMap$com$barchart$udt$TypeUDT = iArr2;
            try {
                iArr2[TypeUDT.DATAGRAM.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$barchart$udt$TypeUDT[TypeUDT.STREAM.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static ChannelUDT channelUDT(Channel channel) {
        if (channel instanceof NioUdtByteAcceptorChannel) {
            return ((NioUdtByteAcceptorChannel) channel).mo128javaChannel();
        }
        if (channel instanceof NioUdtByteRendezvousChannel) {
            return ((NioUdtByteRendezvousChannel) channel).mo128javaChannel();
        }
        if (channel instanceof NioUdtByteConnectorChannel) {
            return ((NioUdtByteConnectorChannel) channel).mo128javaChannel();
        }
        if (channel instanceof NioUdtMessageAcceptorChannel) {
            return ((NioUdtMessageAcceptorChannel) channel).mo128javaChannel();
        }
        if (channel instanceof NioUdtMessageRendezvousChannel) {
            return ((NioUdtMessageRendezvousChannel) channel).mo128javaChannel();
        }
        if (channel instanceof NioUdtMessageConnectorChannel) {
            return ((NioUdtMessageConnectorChannel) channel).mo128javaChannel();
        }
        return null;
    }

    public KindUDT kind() {
        return this.kind;
    }

    @Override // io.netty.channel.ChannelFactory, io.netty.bootstrap.ChannelFactory
    public T newChannel() {
        int i6 = AnonymousClass1.$SwitchMap$com$barchart$udt$nio$KindUDT[this.kind.ordinal()];
        if (i6 == 1) {
            int i7 = AnonymousClass1.$SwitchMap$com$barchart$udt$TypeUDT[this.type.ordinal()];
            if (i7 == 1) {
                return new NioUdtMessageAcceptorChannel();
            }
            if (i7 == 2) {
                return new NioUdtByteAcceptorChannel();
            }
            throw new IllegalStateException("wrong type=" + this.type);
        }
        if (i6 == 2) {
            int i8 = AnonymousClass1.$SwitchMap$com$barchart$udt$TypeUDT[this.type.ordinal()];
            if (i8 == 1) {
                return new NioUdtMessageConnectorChannel();
            }
            if (i8 == 2) {
                return new NioUdtByteConnectorChannel();
            }
            throw new IllegalStateException("wrong type=" + this.type);
        }
        if (i6 != 3) {
            throw new IllegalStateException("wrong kind=" + this.kind);
        }
        int i9 = AnonymousClass1.$SwitchMap$com$barchart$udt$TypeUDT[this.type.ordinal()];
        if (i9 == 1) {
            return new NioUdtMessageRendezvousChannel();
        }
        if (i9 == 2) {
            return new NioUdtByteRendezvousChannel();
        }
        throw new IllegalStateException("wrong type=" + this.type);
    }

    public TypeUDT type() {
        return this.type;
    }

    private NioUdtProvider(TypeUDT typeUDT, KindUDT kindUDT) {
        this.type = typeUDT;
        this.kind = kindUDT;
    }

    static ServerSocketChannelUDT newAcceptorChannelUDT(TypeUDT typeUDT) {
        try {
            return SelectorProviderUDT.from(typeUDT).openServerSocketChannel();
        } catch (IOException e6) {
            throw new ChannelException("failed to open a server socket channel", e6);
        }
    }

    static SocketChannelUDT newConnectorChannelUDT(TypeUDT typeUDT) {
        try {
            return SelectorProviderUDT.from(typeUDT).openSocketChannel();
        } catch (IOException e6) {
            throw new ChannelException("failed to open a socket channel", e6);
        }
    }

    static RendezvousChannelUDT newRendezvousChannelUDT(TypeUDT typeUDT) {
        try {
            return SelectorProviderUDT.from(typeUDT).openRendezvousChannel();
        } catch (IOException e6) {
            throw new ChannelException("failed to open a rendezvous channel", e6);
        }
    }

    public static SocketUDT socketUDT(Channel channel) {
        ChannelUDT channelUDT = channelUDT(channel);
        if (channelUDT == null) {
            return null;
        }
        return channelUDT.socketUDT();
    }
}
