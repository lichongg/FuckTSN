package io.netty.channel.epoll;

import io.netty.channel.epoll.NativeDatagramPacketArray;
import io.netty.channel.unix.Errors;
import io.netty.channel.unix.FileDescriptor;
import io.netty.channel.unix.Socket;
import io.netty.util.internal.NativeLibraryLoader;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.ThrowableUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.util.Locale;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class Native {
    public static final int EPOLLERR;
    public static final int EPOLLET;
    public static final int EPOLLIN;
    public static final int EPOLLOUT;
    public static final int EPOLLRDHUP;
    public static final boolean IS_SUPPORTING_SENDMMSG;
    public static final boolean IS_SUPPORTING_TCP_FASTOPEN;
    public static final String KERNEL_VERSION;
    public static final int TCP_MD5SIG_MAXKEYLEN;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) Native.class);

    private static native int epollBusyWait0(int i6, long j6, int i7);

    private static native int epollCreate();

    private static native int epollCtlAdd0(int i6, int i7, int i8);

    private static native int epollCtlDel0(int i6, int i7);

    private static native int epollCtlMod0(int i6, int i7, int i8);

    private static native int epollWait0(int i6, long j6, int i7, int i8, int i9, int i10);

    private static native int eventFd();

    public static native void eventFdRead(int i6);

    public static native void eventFdWrite(int i6, long j6);

    public static native int offsetofEpollData();

    @Deprecated
    public static int sendmmsg(int i6, NativeDatagramPacketArray.NativeDatagramPacket[] nativeDatagramPacketArr, int i7, int i8) throws IOException {
        return sendmmsg(i6, Socket.isIPv6Preferred(), nativeDatagramPacketArr, i7, i8);
    }

    private static native int sendmmsg0(int i6, boolean z5, NativeDatagramPacketArray.NativeDatagramPacket[] nativeDatagramPacketArr, int i7, int i8);

    public static native int sizeofEpollEvent();

    private static native int splice0(int i6, long j6, int i7, long j7, long j8);

    private static native int timerFd();

    static native void timerFdRead(int i6);

    static {
        try {
            offsetofEpollData();
        } catch (UnsatisfiedLinkError unused) {
            loadNativeLibrary();
        }
        Socket.initialize();
        EPOLLIN = NativeStaticallyReferencedJniMethods.epollin();
        EPOLLOUT = NativeStaticallyReferencedJniMethods.epollout();
        EPOLLRDHUP = NativeStaticallyReferencedJniMethods.epollrdhup();
        EPOLLET = NativeStaticallyReferencedJniMethods.epollet();
        EPOLLERR = NativeStaticallyReferencedJniMethods.epollerr();
        IS_SUPPORTING_SENDMMSG = NativeStaticallyReferencedJniMethods.isSupportingSendmmsg();
        IS_SUPPORTING_TCP_FASTOPEN = NativeStaticallyReferencedJniMethods.isSupportingTcpFastopen();
        TCP_MD5SIG_MAXKEYLEN = NativeStaticallyReferencedJniMethods.tcpMd5SigMaxKeyLen();
        KERNEL_VERSION = NativeStaticallyReferencedJniMethods.kernelVersion();
    }

    private static void loadNativeLibrary() {
        if (!SystemPropertyUtil.get("os.name").toLowerCase(Locale.UK).trim().startsWith("linux")) {
            throw new IllegalStateException("Only supported on Linux");
        }
        String str = "netty_transport_native_epoll_" + PlatformDependent.normalizedArch();
        ClassLoader classLoader = PlatformDependent.getClassLoader(Native.class);
        try {
            NativeLibraryLoader.load(str, classLoader);
        } catch (UnsatisfiedLinkError e6) {
            try {
                NativeLibraryLoader.load("netty_transport_native_epoll", classLoader);
                logger.debug("Failed to load {}", str, e6);
            } catch (UnsatisfiedLinkError e7) {
                ThrowableUtil.addSuppressed(e6, e7);
                throw e6;
            }
        }
    }

    public static FileDescriptor newEpollCreate() {
        return new FileDescriptor(epollCreate());
    }

    public static FileDescriptor newEventFd() {
        return new FileDescriptor(eventFd());
    }

    public static FileDescriptor newTimerFd() {
        return new FileDescriptor(timerFd());
    }

    static int sendmmsg(int i6, boolean z5, NativeDatagramPacketArray.NativeDatagramPacket[] nativeDatagramPacketArr, int i7, int i8) throws IOException {
        int sendmmsg0 = sendmmsg0(i6, z5, nativeDatagramPacketArr, i7, i8);
        return sendmmsg0 >= 0 ? sendmmsg0 : Errors.ioResult("sendmmsg", sendmmsg0);
    }

    private Native() {
    }

    public static int epollBusyWait(FileDescriptor fileDescriptor, EpollEventArray epollEventArray) throws IOException {
        int epollBusyWait0 = epollBusyWait0(fileDescriptor.intValue(), epollEventArray.memoryAddress(), epollEventArray.length());
        if (epollBusyWait0 >= 0) {
            return epollBusyWait0;
        }
        throw Errors.newIOException("epoll_wait", epollBusyWait0);
    }

    public static void epollCtlAdd(int i6, int i7, int i8) throws IOException {
        int epollCtlAdd0 = epollCtlAdd0(i6, i7, i8);
        if (epollCtlAdd0 >= 0) {
        } else {
            throw Errors.newIOException("epoll_ctl", epollCtlAdd0);
        }
    }

    public static void epollCtlDel(int i6, int i7) throws IOException {
        int epollCtlDel0 = epollCtlDel0(i6, i7);
        if (epollCtlDel0 >= 0) {
        } else {
            throw Errors.newIOException("epoll_ctl", epollCtlDel0);
        }
    }

    public static void epollCtlMod(int i6, int i7, int i8) throws IOException {
        int epollCtlMod0 = epollCtlMod0(i6, i7, i8);
        if (epollCtlMod0 >= 0) {
        } else {
            throw Errors.newIOException("epoll_ctl", epollCtlMod0);
        }
    }

    public static int epollWait(FileDescriptor fileDescriptor, EpollEventArray epollEventArray, FileDescriptor fileDescriptor2, int i6, int i7) throws IOException {
        int epollWait0 = epollWait0(fileDescriptor.intValue(), epollEventArray.memoryAddress(), epollEventArray.length(), fileDescriptor2.intValue(), i6, i7);
        if (epollWait0 >= 0) {
            return epollWait0;
        }
        throw Errors.newIOException("epoll_wait", epollWait0);
    }

    public static int splice(int i6, long j6, int i7, long j7, long j8) throws IOException {
        int splice0 = splice0(i6, j6, i7, j7, j8);
        if (splice0 >= 0) {
            return splice0;
        }
        return Errors.ioResult("splice", splice0);
    }
}
