package io.netty.channel.kqueue;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class KQueueStaticallyReferencedJniMethods {
    static native short evAdd();

    static native short evClear();

    static native short evDelete();

    static native short evDisable();

    static native short evEOF();

    static native short evEnable();

    static native short evError();

    static native short evfiltRead();

    static native short evfiltSock();

    static native short evfiltUser();

    static native short evfiltWrite();

    static native short noteConnReset();

    static native short noteDisconnected();

    static native short noteReadClosed();

    private KQueueStaticallyReferencedJniMethods() {
    }
}
