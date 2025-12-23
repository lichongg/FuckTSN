package io.netty.channel.epoll;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class NativeStaticallyReferencedJniMethods {
    static native int epollerr();

    static native int epollet();

    static native int epollin();

    static native int epollout();

    static native int epollrdhup();

    static native int iovMax();

    static native boolean isSupportingSendmmsg();

    static native boolean isSupportingTcpFastopen();

    static native String kernelVersion();

    static native long ssizeMax();

    static native int tcpMd5SigMaxKeyLen();

    static native int uioMaxIov();

    private NativeStaticallyReferencedJniMethods() {
    }
}
