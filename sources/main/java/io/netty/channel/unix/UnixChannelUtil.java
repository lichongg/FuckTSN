package io.netty.channel.unix;

import io.netty.buffer.ByteBuf;
import io.netty.util.internal.PlatformDependent;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class UnixChannelUtil {
    public static boolean isBufferCopyNeededForWrite(ByteBuf byteBuf) {
        return isBufferCopyNeededForWrite(byteBuf, Limits.IOV_MAX);
    }

    public static InetSocketAddress computeRemoteAddr(InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2) {
        if (inetSocketAddress2 == null) {
            return inetSocketAddress;
        }
        if (PlatformDependent.javaVersion() >= 7) {
            try {
                return new InetSocketAddress(InetAddress.getByAddress(inetSocketAddress.getHostString(), inetSocketAddress2.getAddress().getAddress()), inetSocketAddress2.getPort());
            } catch (UnknownHostException unused) {
            }
        }
        return inetSocketAddress2;
    }

    static boolean isBufferCopyNeededForWrite(ByteBuf byteBuf, int i6) {
        if (byteBuf.hasMemoryAddress()) {
            return false;
        }
        return !byteBuf.isDirect() || byteBuf.nioBufferCount() > i6;
    }

    private UnixChannelUtil() {
    }
}
