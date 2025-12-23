package io.netty.channel.unix;

import io.netty.channel.ChannelException;
import io.netty.util.CharsetUtil;
import io.netty.util.NetUtil;
import java.io.IOException;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.PortUnreachableException;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class Socket extends FileDescriptor {
    protected final boolean ipv6;
    public static final int UDS_SUN_PATH_SIZE = LimitsStaticallyReferencedJniMethods.udsSunPathSize();
    private static final AtomicBoolean INITIALIZED = new AtomicBoolean();

    private static native int accept(int i6, byte[] bArr);

    private static native int bind(int i6, boolean z5, byte[] bArr, int i7, int i8);

    private static native int bindDomainSocket(int i6, byte[] bArr);

    private static native int connect(int i6, boolean z5, byte[] bArr, int i7, int i8);

    private static native int connectDomainSocket(int i6, byte[] bArr);

    private static native int disconnect(int i6, boolean z5);

    private static native int finishConnect(int i6);

    private static native int getReceiveBufferSize(int i6) throws IOException;

    private static native int getSendBufferSize(int i6) throws IOException;

    private static native int getSoError(int i6) throws IOException;

    private static native int getSoLinger(int i6) throws IOException;

    private static native int getTrafficClass(int i6, boolean z5) throws IOException;

    public static void initialize() {
        if (INITIALIZED.compareAndSet(false, true)) {
            initialize(NetUtil.isIpV4StackPreferred());
        }
    }

    private static native void initialize(boolean z5);

    private static native int isBroadcast(int i6) throws IOException;

    private static native boolean isIPv6(int i6);

    public static native boolean isIPv6Preferred();

    private static native int isKeepAlive(int i6) throws IOException;

    private static native int isReuseAddress(int i6) throws IOException;

    private static native int isReusePort(int i6) throws IOException;

    private static native int isTcpNoDelay(int i6) throws IOException;

    private static native int listen(int i6, int i7);

    private static native byte[] localAddress(int i6);

    protected static int newSocketDgram0() {
        return newSocketDgram0(isIPv6Preferred());
    }

    private static native int newSocketDgramFd(boolean z5);

    private static native int newSocketDomainFd();

    protected static int newSocketStream0() {
        return newSocketStream0(isIPv6Preferred());
    }

    private static native int newSocketStreamFd(boolean z5);

    private static native int recvFd(int i6);

    private static native DatagramSocketAddress recvFrom(int i6, ByteBuffer byteBuffer, int i7, int i8) throws IOException;

    private static native DatagramSocketAddress recvFromAddress(int i6, long j6, int i7, int i8) throws IOException;

    private static native byte[] remoteAddress(int i6);

    private static native int sendFd(int i6, int i7);

    private static native int sendTo(int i6, boolean z5, ByteBuffer byteBuffer, int i7, int i8, byte[] bArr, int i9, int i10);

    private static native int sendToAddress(int i6, boolean z5, long j6, int i7, int i8, byte[] bArr, int i9, int i10);

    private static native int sendToAddresses(int i6, boolean z5, long j6, int i7, byte[] bArr, int i8, int i9);

    private static native void setBroadcast(int i6, int i7) throws IOException;

    private static native void setKeepAlive(int i6, int i7) throws IOException;

    private static native void setReceiveBufferSize(int i6, int i7) throws IOException;

    private static native void setReuseAddress(int i6, int i7) throws IOException;

    private static native void setReusePort(int i6, int i7) throws IOException;

    private static native void setSendBufferSize(int i6, int i7) throws IOException;

    private static native void setSoLinger(int i6, int i7) throws IOException;

    private static native void setTcpNoDelay(int i6, int i7) throws IOException;

    private static native void setTrafficClass(int i6, boolean z5, int i7) throws IOException;

    private static native int shutdown(int i6, boolean z5, boolean z6);

    public final int accept(byte[] bArr) throws IOException {
        int accept = accept(this.fd, bArr);
        if (accept >= 0) {
            return accept;
        }
        if (accept == Errors.ERRNO_EAGAIN_NEGATIVE || accept == Errors.ERRNO_EWOULDBLOCK_NEGATIVE) {
            return -1;
        }
        throw Errors.newIOException("accept", accept);
    }

    public final void bind(SocketAddress socketAddress) throws IOException {
        if (socketAddress instanceof InetSocketAddress) {
            InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddress;
            NativeInetAddress newInstance = NativeInetAddress.newInstance(inetSocketAddress.getAddress());
            int bind = bind(this.fd, this.ipv6, newInstance.address, newInstance.scopeId, inetSocketAddress.getPort());
            if (bind < 0) {
                throw Errors.newIOException("bind", bind);
            }
            return;
        }
        if (socketAddress instanceof DomainSocketAddress) {
            int bindDomainSocket = bindDomainSocket(this.fd, ((DomainSocketAddress) socketAddress).path().getBytes(CharsetUtil.UTF_8));
            if (bindDomainSocket < 0) {
                throw Errors.newIOException("bind", bindDomainSocket);
            }
        } else {
            throw new Error("Unexpected SocketAddress implementation " + socketAddress);
        }
    }

    public final boolean connect(SocketAddress socketAddress) throws IOException {
        int connectDomainSocket;
        if (socketAddress instanceof InetSocketAddress) {
            InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddress;
            NativeInetAddress newInstance = NativeInetAddress.newInstance(inetSocketAddress.getAddress());
            connectDomainSocket = connect(this.fd, this.ipv6, newInstance.address, newInstance.scopeId, inetSocketAddress.getPort());
        } else {
            if (!(socketAddress instanceof DomainSocketAddress)) {
                throw new Error("Unexpected SocketAddress implementation " + socketAddress);
            }
            connectDomainSocket = connectDomainSocket(this.fd, ((DomainSocketAddress) socketAddress).path().getBytes(CharsetUtil.UTF_8));
        }
        if (connectDomainSocket >= 0) {
            return true;
        }
        if (connectDomainSocket == Errors.ERRNO_EINPROGRESS_NEGATIVE) {
            return false;
        }
        Errors.throwConnectException("connect", connectDomainSocket);
        return true;
    }

    public final void disconnect() throws IOException {
        int disconnect = disconnect(this.fd, this.ipv6);
        if (disconnect < 0) {
            Errors.throwConnectException("disconnect", disconnect);
        }
    }

    public final boolean finishConnect() throws IOException {
        int finishConnect = finishConnect(this.fd);
        if (finishConnect >= 0) {
            return true;
        }
        if (finishConnect == Errors.ERRNO_EINPROGRESS_NEGATIVE) {
            return false;
        }
        Errors.throwConnectException("finishConnect", finishConnect);
        return true;
    }

    public final int getReceiveBufferSize() throws IOException {
        return getReceiveBufferSize(this.fd);
    }

    public final int getSendBufferSize() throws IOException {
        return getSendBufferSize(this.fd);
    }

    public final int getSoError() throws IOException {
        return getSoError(this.fd);
    }

    public final int getSoLinger() throws IOException {
        return getSoLinger(this.fd);
    }

    public final int getTrafficClass() throws IOException {
        return getTrafficClass(this.fd, this.ipv6);
    }

    public final boolean isBroadcast() throws IOException {
        return isBroadcast(this.fd) != 0;
    }

    public final boolean isKeepAlive() throws IOException {
        return isKeepAlive(this.fd) != 0;
    }

    public final boolean isReuseAddress() throws IOException {
        return isReuseAddress(this.fd) != 0;
    }

    public final boolean isReusePort() throws IOException {
        return isReusePort(this.fd) != 0;
    }

    public final boolean isTcpNoDelay() throws IOException {
        return isTcpNoDelay(this.fd) != 0;
    }

    public final void listen(int i6) throws IOException {
        int listen = listen(this.fd, i6);
        if (listen < 0) {
            throw Errors.newIOException("listen", listen);
        }
    }

    public final InetSocketAddress localAddress() {
        byte[] localAddress = localAddress(this.fd);
        if (localAddress == null) {
            return null;
        }
        return NativeInetAddress.address(localAddress, 0, localAddress.length);
    }

    public final int recvFd() throws IOException {
        int recvFd = recvFd(this.fd);
        if (recvFd > 0) {
            return recvFd;
        }
        if (recvFd == 0) {
            return -1;
        }
        if (recvFd == Errors.ERRNO_EAGAIN_NEGATIVE || recvFd == Errors.ERRNO_EWOULDBLOCK_NEGATIVE) {
            return 0;
        }
        throw Errors.newIOException("recvFd", recvFd);
    }

    public final DatagramSocketAddress recvFrom(ByteBuffer byteBuffer, int i6, int i7) throws IOException {
        return recvFrom(this.fd, byteBuffer, i6, i7);
    }

    public final DatagramSocketAddress recvFromAddress(long j6, int i6, int i7) throws IOException {
        return recvFromAddress(this.fd, j6, i6, i7);
    }

    public final InetSocketAddress remoteAddress() {
        byte[] remoteAddress = remoteAddress(this.fd);
        if (remoteAddress == null) {
            return null;
        }
        return NativeInetAddress.address(remoteAddress, 0, remoteAddress.length);
    }

    public final int sendFd(int i6) throws IOException {
        int sendFd = sendFd(this.fd, i6);
        if (sendFd >= 0) {
            return sendFd;
        }
        if (sendFd == Errors.ERRNO_EAGAIN_NEGATIVE || sendFd == Errors.ERRNO_EWOULDBLOCK_NEGATIVE) {
            return -1;
        }
        throw Errors.newIOException("sendFd", sendFd);
    }

    public final int sendTo(ByteBuffer byteBuffer, int i6, int i7, InetAddress inetAddress, int i8) throws IOException {
        byte[] ipv4MappedIpv6Address;
        int i9;
        if (inetAddress instanceof Inet6Address) {
            ipv4MappedIpv6Address = inetAddress.getAddress();
            i9 = ((Inet6Address) inetAddress).getScopeId();
        } else {
            ipv4MappedIpv6Address = NativeInetAddress.ipv4MappedIpv6Address(inetAddress.getAddress());
            i9 = 0;
        }
        int sendTo = sendTo(this.fd, this.ipv6, byteBuffer, i6, i7, ipv4MappedIpv6Address, i9, i8);
        if (sendTo >= 0) {
            return sendTo;
        }
        if (sendTo != Errors.ERROR_ECONNREFUSED_NEGATIVE) {
            return Errors.ioResult("sendTo", sendTo);
        }
        throw new PortUnreachableException("sendTo failed");
    }

    public final int sendToAddress(long j6, int i6, int i7, InetAddress inetAddress, int i8) throws IOException {
        byte[] ipv4MappedIpv6Address;
        int i9;
        if (inetAddress instanceof Inet6Address) {
            ipv4MappedIpv6Address = inetAddress.getAddress();
            i9 = ((Inet6Address) inetAddress).getScopeId();
        } else {
            ipv4MappedIpv6Address = NativeInetAddress.ipv4MappedIpv6Address(inetAddress.getAddress());
            i9 = 0;
        }
        int sendToAddress = sendToAddress(this.fd, this.ipv6, j6, i6, i7, ipv4MappedIpv6Address, i9, i8);
        if (sendToAddress >= 0) {
            return sendToAddress;
        }
        if (sendToAddress != Errors.ERROR_ECONNREFUSED_NEGATIVE) {
            return Errors.ioResult("sendToAddress", sendToAddress);
        }
        throw new PortUnreachableException("sendToAddress failed");
    }

    public final int sendToAddresses(long j6, int i6, InetAddress inetAddress, int i7) throws IOException {
        byte[] ipv4MappedIpv6Address;
        int i8;
        if (inetAddress instanceof Inet6Address) {
            ipv4MappedIpv6Address = inetAddress.getAddress();
            i8 = ((Inet6Address) inetAddress).getScopeId();
        } else {
            ipv4MappedIpv6Address = NativeInetAddress.ipv4MappedIpv6Address(inetAddress.getAddress());
            i8 = 0;
        }
        int sendToAddresses = sendToAddresses(this.fd, this.ipv6, j6, i6, ipv4MappedIpv6Address, i8, i7);
        if (sendToAddresses >= 0) {
            return sendToAddresses;
        }
        if (sendToAddresses != Errors.ERROR_ECONNREFUSED_NEGATIVE) {
            return Errors.ioResult("sendToAddresses", sendToAddresses);
        }
        throw new PortUnreachableException("sendToAddresses failed");
    }

    public final void setBroadcast(boolean z5) throws IOException {
        setBroadcast(this.fd, z5 ? 1 : 0);
    }

    public final void setKeepAlive(boolean z5) throws IOException {
        setKeepAlive(this.fd, z5 ? 1 : 0);
    }

    public final void setReceiveBufferSize(int i6) throws IOException {
        setReceiveBufferSize(this.fd, i6);
    }

    public final void setReuseAddress(boolean z5) throws IOException {
        setReuseAddress(this.fd, z5 ? 1 : 0);
    }

    public final void setReusePort(boolean z5) throws IOException {
        setReusePort(this.fd, z5 ? 1 : 0);
    }

    public final void setSendBufferSize(int i6) throws IOException {
        setSendBufferSize(this.fd, i6);
    }

    public final void setSoLinger(int i6) throws IOException {
        setSoLinger(this.fd, i6);
    }

    public final void setTcpNoDelay(boolean z5) throws IOException {
        setTcpNoDelay(this.fd, z5 ? 1 : 0);
    }

    public final void setTrafficClass(int i6) throws IOException {
        setTrafficClass(this.fd, this.ipv6, i6);
    }

    public final void shutdown() throws IOException {
        shutdown(true, true);
    }

    public static Socket newSocketDgram() {
        return new Socket(newSocketDgram0());
    }

    protected static int newSocketDgram0(boolean z5) {
        int newSocketDgramFd = newSocketDgramFd(z5);
        if (newSocketDgramFd >= 0) {
            return newSocketDgramFd;
        }
        throw new ChannelException(Errors.newIOException("newSocketDgram", newSocketDgramFd));
    }

    public static Socket newSocketDomain() {
        return new Socket(newSocketDomain0());
    }

    public static Socket newSocketStream() {
        return new Socket(newSocketStream0());
    }

    protected static int newSocketStream0(boolean z5) {
        int newSocketStreamFd = newSocketStreamFd(z5);
        if (newSocketStreamFd >= 0) {
            return newSocketStreamFd;
        }
        throw new ChannelException(Errors.newIOException("newSocketStream", newSocketStreamFd));
    }

    public final boolean isInputShutdown() {
        return FileDescriptor.isInputShutdown(this.state);
    }

    public final boolean isOutputShutdown() {
        return FileDescriptor.isOutputShutdown(this.state);
    }

    public final boolean isShutdown() {
        int i6 = this.state;
        return FileDescriptor.isInputShutdown(i6) && FileDescriptor.isOutputShutdown(i6);
    }

    public final void shutdown(boolean z5, boolean z6) throws IOException {
        int i6;
        int inputShutdown;
        do {
            i6 = this.state;
            if (FileDescriptor.isClosed(i6)) {
                throw new ClosedChannelException();
            }
            inputShutdown = (!z5 || FileDescriptor.isInputShutdown(i6)) ? i6 : FileDescriptor.inputShutdown(i6);
            if (z6 && !FileDescriptor.isOutputShutdown(inputShutdown)) {
                inputShutdown = FileDescriptor.outputShutdown(inputShutdown);
            }
            if (inputShutdown == i6) {
                return;
            }
        } while (!casState(i6, inputShutdown));
        int shutdown = shutdown(this.fd, z5, z6);
        if (shutdown < 0) {
            Errors.ioResult("shutdown", shutdown);
        }
    }

    @Override // io.netty.channel.unix.FileDescriptor
    public String toString() {
        return "Socket{fd=" + this.fd + '}';
    }

    public Socket(int i6) {
        super(i6);
        this.ipv6 = isIPv6(i6);
    }

    protected static int newSocketDomain0() {
        int newSocketDomainFd = newSocketDomainFd();
        if (newSocketDomainFd >= 0) {
            return newSocketDomainFd;
        }
        throw new ChannelException(Errors.newIOException("newSocketDomain", newSocketDomainFd));
    }
}
