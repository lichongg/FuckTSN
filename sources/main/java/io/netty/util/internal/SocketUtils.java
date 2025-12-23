package io.netty.util.internal;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.nio.channels.DatagramChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Enumeration;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class SocketUtils {
    public static void bind(final Socket socket, final SocketAddress socketAddress) throws IOException {
        try {
            AccessController.doPrivileged(new PrivilegedExceptionAction<Void>() { // from class: io.netty.util.internal.SocketUtils.2
                @Override // java.security.PrivilegedExceptionAction
                public Void run() throws IOException {
                    socket.bind(socketAddress);
                    return null;
                }
            });
        } catch (PrivilegedActionException e6) {
            throw ((IOException) e6.getCause());
        }
    }

    public static void connect(final Socket socket, final SocketAddress socketAddress, final int i6) throws IOException {
        try {
            AccessController.doPrivileged(new PrivilegedExceptionAction<Void>() { // from class: io.netty.util.internal.SocketUtils.1
                @Override // java.security.PrivilegedExceptionAction
                public Void run() throws IOException {
                    socket.connect(socketAddress, i6);
                    return null;
                }
            });
        } catch (PrivilegedActionException e6) {
            throw ((IOException) e6.getCause());
        }
    }

    public static SocketChannel accept(final ServerSocketChannel serverSocketChannel) throws IOException {
        try {
            return (SocketChannel) AccessController.doPrivileged(new PrivilegedExceptionAction<SocketChannel>() { // from class: io.netty.util.internal.SocketUtils.5
                @Override // java.security.PrivilegedExceptionAction
                public SocketChannel run() throws IOException {
                    return serverSocketChannel.accept();
                }
            });
        } catch (PrivilegedActionException e6) {
            throw ((IOException) e6.getCause());
        }
    }

    public static InetAddress addressByName(final String str) throws UnknownHostException {
        try {
            return (InetAddress) AccessController.doPrivileged(new PrivilegedExceptionAction<InetAddress>() { // from class: io.netty.util.internal.SocketUtils.8
                @Override // java.security.PrivilegedExceptionAction
                public InetAddress run() throws UnknownHostException {
                    return InetAddress.getByName(str);
                }
            });
        } catch (PrivilegedActionException e6) {
            throw ((UnknownHostException) e6.getCause());
        }
    }

    public static Enumeration<InetAddress> addressesFromNetworkInterface(final NetworkInterface networkInterface) {
        return (Enumeration) AccessController.doPrivileged(new PrivilegedAction<Enumeration<InetAddress>>() { // from class: io.netty.util.internal.SocketUtils.11
            @Override // java.security.PrivilegedAction
            public Enumeration<InetAddress> run() {
                return networkInterface.getInetAddresses();
            }
        });
    }

    public static InetAddress[] allAddressesByName(final String str) throws UnknownHostException {
        try {
            return (InetAddress[]) AccessController.doPrivileged(new PrivilegedExceptionAction<InetAddress[]>() { // from class: io.netty.util.internal.SocketUtils.9
                @Override // java.security.PrivilegedExceptionAction
                public InetAddress[] run() throws UnknownHostException {
                    return InetAddress.getAllByName(str);
                }
            });
        } catch (PrivilegedActionException e6) {
            throw ((UnknownHostException) e6.getCause());
        }
    }

    public static byte[] hardwareAddressFromNetworkInterface(final NetworkInterface networkInterface) throws SocketException {
        try {
            return (byte[]) AccessController.doPrivileged(new PrivilegedExceptionAction<byte[]>() { // from class: io.netty.util.internal.SocketUtils.13
                @Override // java.security.PrivilegedExceptionAction
                public byte[] run() throws SocketException {
                    return networkInterface.getHardwareAddress();
                }
            });
        } catch (PrivilegedActionException e6) {
            throw ((SocketException) e6.getCause());
        }
    }

    public static SocketAddress localSocketAddress(final ServerSocket serverSocket) {
        return (SocketAddress) AccessController.doPrivileged(new PrivilegedAction<SocketAddress>() { // from class: io.netty.util.internal.SocketUtils.7
            @Override // java.security.PrivilegedAction
            public SocketAddress run() {
                return serverSocket.getLocalSocketAddress();
            }
        });
    }

    public static InetAddress loopbackAddress() {
        return (InetAddress) AccessController.doPrivileged(new PrivilegedAction<InetAddress>() { // from class: io.netty.util.internal.SocketUtils.12
            @Override // java.security.PrivilegedAction
            public InetAddress run() {
                if (PlatformDependent.javaVersion() >= 7) {
                    return InetAddress.getLoopbackAddress();
                }
                try {
                    return InetAddress.getByName(null);
                } catch (UnknownHostException e6) {
                    throw new IllegalStateException(e6);
                }
            }
        });
    }

    public static InetSocketAddress socketAddress(final String str, final int i6) {
        return (InetSocketAddress) AccessController.doPrivileged(new PrivilegedAction<InetSocketAddress>() { // from class: io.netty.util.internal.SocketUtils.10
            @Override // java.security.PrivilegedAction
            public InetSocketAddress run() {
                return new InetSocketAddress(str, i6);
            }
        });
    }

    private SocketUtils() {
    }

    public static void bind(final SocketChannel socketChannel, final SocketAddress socketAddress) throws IOException {
        try {
            AccessController.doPrivileged(new PrivilegedExceptionAction<Void>() { // from class: io.netty.util.internal.SocketUtils.4
                @Override // java.security.PrivilegedExceptionAction
                public Void run() throws IOException {
                    socketChannel.bind(socketAddress);
                    return null;
                }
            });
        } catch (PrivilegedActionException e6) {
            throw ((IOException) e6.getCause());
        }
    }

    public static boolean connect(final SocketChannel socketChannel, final SocketAddress socketAddress) throws IOException {
        try {
            return ((Boolean) AccessController.doPrivileged(new PrivilegedExceptionAction<Boolean>() { // from class: io.netty.util.internal.SocketUtils.3
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.security.PrivilegedExceptionAction
                public Boolean run() throws IOException {
                    return Boolean.valueOf(socketChannel.connect(socketAddress));
                }
            })).booleanValue();
        } catch (PrivilegedActionException e6) {
            throw ((IOException) e6.getCause());
        }
    }

    public static void bind(final DatagramChannel datagramChannel, final SocketAddress socketAddress) throws IOException {
        try {
            AccessController.doPrivileged(new PrivilegedExceptionAction<Void>() { // from class: io.netty.util.internal.SocketUtils.6
                @Override // java.security.PrivilegedExceptionAction
                public Void run() throws IOException {
                    datagramChannel.bind(socketAddress);
                    return null;
                }
            });
        } catch (PrivilegedActionException e6) {
            throw ((IOException) e6.getCause());
        }
    }
}
