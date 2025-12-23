package io.netty.channel.epoll;

import io.netty.channel.ChannelException;
import io.netty.channel.DefaultFileRegion;
import io.netty.channel.epoll.NativeDatagramPacketArray;
import io.netty.channel.socket.InternetProtocolFamily;
import io.netty.channel.unix.Errors;
import io.netty.channel.unix.NativeInetAddress;
import io.netty.channel.unix.PeerCredentials;
import io.netty.channel.unix.Socket;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SocketUtils;
import java.io.IOException;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.Enumeration;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class LinuxSocket extends Socket {
    static final InetAddress INET6_ANY = unsafeInetAddrByName("::");
    private static final InetAddress INET_ANY = unsafeInetAddrByName("0.0.0.0");
    private static final long MAX_UINT32_T = 4294967295L;

    private static native int getInterface(int i6, boolean z5);

    private static native int getIpMulticastLoop(int i6, boolean z5) throws IOException;

    private static native PeerCredentials getPeerCredentials(int i6) throws IOException;

    private static native int getSoBusyPoll(int i6) throws IOException;

    private static native int getTcpDeferAccept(int i6) throws IOException;

    private static native void getTcpInfo(int i6, long[] jArr) throws IOException;

    private static native int getTcpKeepCnt(int i6) throws IOException;

    private static native int getTcpKeepIdle(int i6) throws IOException;

    private static native int getTcpKeepIntvl(int i6) throws IOException;

    private static native int getTcpNotSentLowAt(int i6) throws IOException;

    private static native int getTcpUserTimeout(int i6) throws IOException;

    private static native int getTimeToLive(int i6) throws IOException;

    private static int interfaceIndex(NetworkInterface networkInterface) {
        if (PlatformDependent.javaVersion() >= 7) {
            return networkInterface.getIndex();
        }
        return -1;
    }

    private static native int isIpFreeBind(int i6) throws IOException;

    private static native int isIpRecvOrigDestAddr(int i6) throws IOException;

    private static native int isIpTransparent(int i6) throws IOException;

    private static native int isTcpCork(int i6) throws IOException;

    private static native int isTcpFastOpenConnect(int i6) throws IOException;

    private static native int isTcpQuickAck(int i6) throws IOException;

    private static native void joinGroup(int i6, boolean z5, byte[] bArr, byte[] bArr2, int i7, int i8) throws IOException;

    private static native void joinSsmGroup(int i6, boolean z5, byte[] bArr, byte[] bArr2, int i7, int i8, byte[] bArr3) throws IOException;

    private static native void leaveGroup(int i6, boolean z5, byte[] bArr, byte[] bArr2, int i7, int i8) throws IOException;

    private static native void leaveSsmGroup(int i6, boolean z5, byte[] bArr, byte[] bArr2, int i7, int i8, byte[] bArr3) throws IOException;

    public static LinuxSocket newSocketDgram(boolean z5) {
        return new LinuxSocket(Socket.newSocketDgram0(z5));
    }

    public static LinuxSocket newSocketStream(boolean z5) {
        return new LinuxSocket(Socket.newSocketStream0(z5));
    }

    private static native long sendFile(int i6, DefaultFileRegion defaultFileRegion, long j6, long j7, long j8) throws IOException;

    private static native void setInterface(int i6, boolean z5, byte[] bArr, int i7, int i8) throws IOException;

    private static native void setIpFreeBind(int i6, int i7) throws IOException;

    private static native void setIpMulticastLoop(int i6, boolean z5, int i7) throws IOException;

    private static native void setIpRecvOrigDestAddr(int i6, int i7) throws IOException;

    private static native void setIpTransparent(int i6, int i7) throws IOException;

    private static native void setSoBusyPoll(int i6, int i7) throws IOException;

    private static native void setTcpCork(int i6, int i7) throws IOException;

    private static native void setTcpDeferAccept(int i6, int i7) throws IOException;

    private static native void setTcpFastOpen(int i6, int i7) throws IOException;

    private static native void setTcpFastOpenConnect(int i6, int i7) throws IOException;

    private static native void setTcpKeepCnt(int i6, int i7) throws IOException;

    private static native void setTcpKeepIdle(int i6, int i7) throws IOException;

    private static native void setTcpKeepIntvl(int i6, int i7) throws IOException;

    private static native void setTcpMd5Sig(int i6, boolean z5, byte[] bArr, int i7, byte[] bArr2) throws IOException;

    private static native void setTcpNotSentLowAt(int i6, int i7) throws IOException;

    private static native void setTcpQuickAck(int i6, int i7) throws IOException;

    private static native void setTcpUserTimeout(int i6, int i7) throws IOException;

    private static native void setTimeToLive(int i6, int i7) throws IOException;

    InetAddress getInterface() throws IOException {
        NetworkInterface networkInterface = getNetworkInterface();
        if (networkInterface == null) {
            return null;
        }
        Enumeration<InetAddress> addressesFromNetworkInterface = SocketUtils.addressesFromNetworkInterface(networkInterface);
        if (addressesFromNetworkInterface.hasMoreElements()) {
            return addressesFromNetworkInterface.nextElement();
        }
        return null;
    }

    PeerCredentials getPeerCredentials() throws IOException {
        return getPeerCredentials(intValue());
    }

    int getSoBusyPoll() throws IOException {
        return getSoBusyPoll(intValue());
    }

    int getTcpDeferAccept() throws IOException {
        return getTcpDeferAccept(intValue());
    }

    void getTcpInfo(EpollTcpInfo epollTcpInfo) throws IOException {
        getTcpInfo(intValue(), epollTcpInfo.info);
    }

    int getTcpKeepCnt() throws IOException {
        return getTcpKeepCnt(intValue());
    }

    int getTcpKeepIdle() throws IOException {
        return getTcpKeepIdle(intValue());
    }

    int getTcpKeepIntvl() throws IOException {
        return getTcpKeepIntvl(intValue());
    }

    long getTcpNotSentLowAt() throws IOException {
        return getTcpNotSentLowAt(intValue()) & 4294967295L;
    }

    int getTcpUserTimeout() throws IOException {
        return getTcpUserTimeout(intValue());
    }

    int getTimeToLive() throws IOException {
        return getTimeToLive(intValue());
    }

    boolean isIpFreeBind() throws IOException {
        return isIpFreeBind(intValue()) != 0;
    }

    boolean isIpRecvOrigDestAddr() throws IOException {
        return isIpRecvOrigDestAddr(intValue()) != 0;
    }

    boolean isIpTransparent() throws IOException {
        return isIpTransparent(intValue()) != 0;
    }

    boolean isTcpCork() throws IOException {
        return isTcpCork(intValue()) != 0;
    }

    boolean isTcpFastOpenConnect() throws IOException {
        return isTcpFastOpenConnect(intValue()) != 0;
    }

    boolean isTcpQuickAck() throws IOException {
        return isTcpQuickAck(intValue()) != 0;
    }

    void joinGroup(InetAddress inetAddress, NetworkInterface networkInterface, InetAddress inetAddress2) throws IOException {
        NativeInetAddress newInstance = NativeInetAddress.newInstance(inetAddress);
        NativeInetAddress newInstance2 = NativeInetAddress.newInstance(deriveInetAddress(networkInterface, inetAddress instanceof Inet6Address));
        if (inetAddress2 == null) {
            joinGroup(intValue(), this.ipv6, newInstance.address(), newInstance2.address(), newInstance.scopeId(), interfaceIndex(networkInterface));
        } else {
            joinSsmGroup(intValue(), this.ipv6, newInstance.address(), newInstance2.address(), newInstance.scopeId(), interfaceIndex(networkInterface), NativeInetAddress.newInstance(inetAddress2).address());
        }
    }

    void leaveGroup(InetAddress inetAddress, NetworkInterface networkInterface, InetAddress inetAddress2) throws IOException {
        NativeInetAddress newInstance = NativeInetAddress.newInstance(inetAddress);
        NativeInetAddress newInstance2 = NativeInetAddress.newInstance(deriveInetAddress(networkInterface, inetAddress instanceof Inet6Address));
        if (inetAddress2 == null) {
            leaveGroup(intValue(), this.ipv6, newInstance.address(), newInstance2.address(), newInstance.scopeId(), interfaceIndex(networkInterface));
        } else {
            leaveSsmGroup(intValue(), this.ipv6, newInstance.address(), newInstance2.address(), newInstance.scopeId(), interfaceIndex(networkInterface), NativeInetAddress.newInstance(inetAddress2).address());
        }
    }

    long sendFile(DefaultFileRegion defaultFileRegion, long j6, long j7, long j8) throws IOException {
        defaultFileRegion.open();
        long sendFile = sendFile(intValue(), defaultFileRegion, j6, j7, j8);
        return sendFile >= 0 ? sendFile : Errors.ioResult("sendfile", (int) sendFile);
    }

    void setInterface(InetAddress inetAddress) throws IOException {
        NativeInetAddress newInstance = NativeInetAddress.newInstance(inetAddress);
        setInterface(intValue(), this.ipv6, newInstance.address(), newInstance.scopeId(), interfaceIndex(inetAddress));
    }

    void setIpFreeBind(boolean z5) throws IOException {
        setIpFreeBind(intValue(), z5 ? 1 : 0);
    }

    void setIpRecvOrigDestAddr(boolean z5) throws IOException {
        setIpRecvOrigDestAddr(intValue(), z5 ? 1 : 0);
    }

    void setIpTransparent(boolean z5) throws IOException {
        setIpTransparent(intValue(), z5 ? 1 : 0);
    }

    void setSoBusyPoll(int i6) throws IOException {
        setSoBusyPoll(intValue(), i6);
    }

    void setTcpCork(boolean z5) throws IOException {
        setTcpCork(intValue(), z5 ? 1 : 0);
    }

    void setTcpDeferAccept(int i6) throws IOException {
        setTcpDeferAccept(intValue(), i6);
    }

    void setTcpFastOpen(int i6) throws IOException {
        setTcpFastOpen(intValue(), i6);
    }

    void setTcpFastOpenConnect(boolean z5) throws IOException {
        setTcpFastOpenConnect(intValue(), z5 ? 1 : 0);
    }

    void setTcpKeepCnt(int i6) throws IOException {
        setTcpKeepCnt(intValue(), i6);
    }

    void setTcpKeepIdle(int i6) throws IOException {
        setTcpKeepIdle(intValue(), i6);
    }

    void setTcpKeepIntvl(int i6) throws IOException {
        setTcpKeepIntvl(intValue(), i6);
    }

    void setTcpMd5Sig(InetAddress inetAddress, byte[] bArr) throws IOException {
        NativeInetAddress newInstance = NativeInetAddress.newInstance(inetAddress);
        setTcpMd5Sig(intValue(), this.ipv6, newInstance.address(), newInstance.scopeId(), bArr);
    }

    void setTcpNotSentLowAt(long j6) throws IOException {
        if (j6 < 0 || j6 > 4294967295L) {
            throw new IllegalArgumentException("tcpNotSentLowAt must be a uint32_t");
        }
        setTcpNotSentLowAt(intValue(), (int) j6);
    }

    void setTcpQuickAck(boolean z5) throws IOException {
        setTcpQuickAck(intValue(), z5 ? 1 : 0);
    }

    void setTcpUserTimeout(int i6) throws IOException {
        setTcpUserTimeout(intValue(), i6);
    }

    void setTimeToLive(int i6) throws IOException {
        setTimeToLive(intValue(), i6);
    }

    private static InetAddress deriveInetAddress(NetworkInterface networkInterface, boolean z5) {
        InetAddress inetAddress = z5 ? INET6_ANY : INET_ANY;
        if (networkInterface != null) {
            Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
            while (inetAddresses.hasMoreElements()) {
                InetAddress nextElement = inetAddresses.nextElement();
                if ((nextElement instanceof Inet6Address) == z5) {
                    return nextElement;
                }
            }
        }
        return inetAddress;
    }

    private InternetProtocolFamily family() {
        return this.ipv6 ? InternetProtocolFamily.IPv6 : InternetProtocolFamily.IPv4;
    }

    private static InetAddress inetAddress(int i6) {
        try {
            return InetAddress.getByAddress(new byte[]{(byte) ((i6 >>> 24) & 255), (byte) ((i6 >>> 16) & 255), (byte) ((i6 >>> 8) & 255), (byte) (i6 & 255)});
        } catch (UnknownHostException unused) {
            return null;
        }
    }

    private static int interfaceIndex(InetAddress inetAddress) throws IOException {
        NetworkInterface byInetAddress;
        if (PlatformDependent.javaVersion() < 7 || (byInetAddress = NetworkInterface.getByInetAddress(inetAddress)) == null) {
            return -1;
        }
        return byInetAddress.getIndex();
    }

    public static LinuxSocket newSocketDgram() {
        return newSocketDgram(Socket.isIPv6Preferred());
    }

    public static LinuxSocket newSocketDomain() {
        return new LinuxSocket(Socket.newSocketDomain0());
    }

    public static LinuxSocket newSocketStream() {
        return newSocketStream(Socket.isIPv6Preferred());
    }

    LinuxSocket(int i6) {
        super(i6);
    }

    private static InetAddress unsafeInetAddrByName(String str) {
        try {
            return InetAddress.getByName(str);
        } catch (UnknownHostException e6) {
            throw new ChannelException(e6);
        }
    }

    NetworkInterface getNetworkInterface() throws IOException {
        int i6 = getInterface(intValue(), this.ipv6);
        if (this.ipv6) {
            if (PlatformDependent.javaVersion() < 7) {
                return null;
            }
            return NetworkInterface.getByIndex(i6);
        }
        InetAddress inetAddress = inetAddress(i6);
        if (inetAddress == null) {
            return null;
        }
        return NetworkInterface.getByInetAddress(inetAddress);
    }

    boolean isLoopbackModeDisabled() throws IOException {
        if (getIpMulticastLoop(intValue(), this.ipv6) == 0) {
            return true;
        }
        return false;
    }

    int sendmmsg(NativeDatagramPacketArray.NativeDatagramPacket[] nativeDatagramPacketArr, int i6, int i7) throws IOException {
        return Native.sendmmsg(intValue(), this.ipv6, nativeDatagramPacketArr, i6, i7);
    }

    void setLoopbackModeDisabled(boolean z5) throws IOException {
        setIpMulticastLoop(intValue(), this.ipv6, !z5 ? 1 : 0);
    }

    void setNetworkInterface(NetworkInterface networkInterface) throws IOException {
        boolean z5;
        InetAddress inetAddress;
        if (family() == InternetProtocolFamily.IPv6) {
            z5 = true;
        } else {
            z5 = false;
        }
        InetAddress deriveInetAddress = deriveInetAddress(networkInterface, z5);
        if (family() == InternetProtocolFamily.IPv4) {
            inetAddress = INET_ANY;
        } else {
            inetAddress = INET6_ANY;
        }
        if (!deriveInetAddress.equals(inetAddress)) {
            NativeInetAddress newInstance = NativeInetAddress.newInstance(deriveInetAddress);
            setInterface(intValue(), this.ipv6, newInstance.address(), newInstance.scopeId(), interfaceIndex(networkInterface));
        } else {
            throw new IOException("NetworkInterface does not support " + family());
        }
    }
}
