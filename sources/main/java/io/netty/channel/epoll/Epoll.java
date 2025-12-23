package io.netty.channel.epoll;

import io.netty.channel.unix.FileDescriptor;
import io.netty.util.internal.SystemPropertyUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class Epoll {
    private static final Throwable UNAVAILABILITY_CAUSE;

    static {
        UnsupportedOperationException th;
        FileDescriptor fileDescriptor;
        FileDescriptor newEventFd;
        if (SystemPropertyUtil.getBoolean("io.netty.transport.noNative", false)) {
            th = new UnsupportedOperationException("Native transport was explicit disabled with -Dio.netty.transport.noNative=true");
        } else {
            th = null;
            try {
                try {
                    fileDescriptor = Native.newEpollCreate();
                } catch (Throwable th2) {
                    fileDescriptor = null;
                    th = th2;
                }
            } catch (Exception unused) {
            }
            try {
                newEventFd = Native.newEventFd();
                if (fileDescriptor != null) {
                    try {
                        fileDescriptor.close();
                    } catch (Exception unused2) {
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                if (fileDescriptor != null) {
                    fileDescriptor.close();
                }
                UNAVAILABILITY_CAUSE = th;
            }
            if (newEventFd != null) {
                newEventFd.close();
            }
        }
        UNAVAILABILITY_CAUSE = th;
    }

    public static void ensureAvailability() {
        Throwable th = UNAVAILABILITY_CAUSE;
        if (th != null) {
            throw ((Error) new UnsatisfiedLinkError("failed to load the required native library").initCause(th));
        }
    }

    public static boolean isAvailable() {
        return UNAVAILABILITY_CAUSE == null;
    }

    public static Throwable unavailabilityCause() {
        return UNAVAILABILITY_CAUSE;
    }

    private Epoll() {
    }
}
