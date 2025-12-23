package io.netty.channel.socket.nio;

import io.netty.channel.ChannelException;
import io.netty.channel.ChannelOption;
import java.io.IOException;
import java.net.SocketOption;
import java.net.StandardSocketOptions;
import java.nio.channels.Channel;
import java.nio.channels.NetworkChannel;
import java.nio.channels.ServerSocketChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class NioChannelOption<T> extends ChannelOption<T> {
    private final SocketOption<T> option;

    public static <T> ChannelOption<T> of(SocketOption<T> socketOption) {
        return new NioChannelOption(socketOption);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private NioChannelOption(java.net.SocketOption<T> r2) {
        /*
            r1 = this;
            java.lang.String r0 = io.netty.channel.socket.nio.f.a(r2)
            r1.<init>(r0)
            r1.option = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.socket.nio.NioChannelOption.<init>(java.net.SocketOption):void");
    }

    static <T> T getOption(Channel channel, NioChannelOption<T> nioChannelOption) {
        Set supportedOptions;
        SocketOption<T> socketOption;
        Object option;
        NetworkChannel a6 = a.a(channel);
        supportedOptions = a6.supportedOptions();
        if (!supportedOptions.contains(((NioChannelOption) nioChannelOption).option)) {
            return null;
        }
        if (a6 instanceof ServerSocketChannel) {
            SocketOption<T> socketOption2 = ((NioChannelOption) nioChannelOption).option;
            socketOption = StandardSocketOptions.IP_TOS;
            if (socketOption2 == socketOption) {
                return null;
            }
        }
        try {
            option = a6.getOption(((NioChannelOption) nioChannelOption).option);
            return (T) option;
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    static ChannelOption[] getOptions(Channel channel) {
        Set supportedOptions;
        SocketOption socketOption;
        NetworkChannel a6 = a.a(channel);
        supportedOptions = a6.supportedOptions();
        int i6 = 0;
        if (a6 instanceof ServerSocketChannel) {
            ArrayList arrayList = new ArrayList(supportedOptions.size());
            Iterator it = supportedOptions.iterator();
            while (it.hasNext()) {
                SocketOption a7 = c.a(it.next());
                socketOption = StandardSocketOptions.IP_TOS;
                if (a7 != socketOption) {
                    arrayList.add(new NioChannelOption(a7));
                }
            }
            return (ChannelOption[]) arrayList.toArray(new ChannelOption[0]);
        }
        ChannelOption[] channelOptionArr = new ChannelOption[supportedOptions.size()];
        Iterator it2 = supportedOptions.iterator();
        while (it2.hasNext()) {
            channelOptionArr[i6] = new NioChannelOption(c.a(it2.next()));
            i6++;
        }
        return channelOptionArr;
    }

    static <T> boolean setOption(Channel channel, NioChannelOption<T> nioChannelOption, T t5) {
        Set supportedOptions;
        SocketOption<T> socketOption;
        NetworkChannel a6 = a.a(channel);
        supportedOptions = a6.supportedOptions();
        if (!supportedOptions.contains(((NioChannelOption) nioChannelOption).option)) {
            return false;
        }
        if (a6 instanceof ServerSocketChannel) {
            SocketOption<T> socketOption2 = ((NioChannelOption) nioChannelOption).option;
            socketOption = StandardSocketOptions.IP_TOS;
            if (socketOption2 == socketOption) {
                return false;
            }
        }
        try {
            a6.setOption(((NioChannelOption) nioChannelOption).option, t5);
            return true;
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }
}
