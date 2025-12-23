package io.netty.channel.unix;

import io.netty.util.internal.EmptyArrays;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ConnectException;
import java.net.NoRouteToHostException;
import java.nio.channels.AlreadyConnectedException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.ConnectionPendingException;
import java.nio.channels.NotYetConnectedException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class Errors {
    public static final int ERRNO_ENOENT_NEGATIVE = -ErrorsStaticallyReferencedJniMethods.errnoENOENT();
    public static final int ERRNO_ENOTCONN_NEGATIVE = -ErrorsStaticallyReferencedJniMethods.errnoENOTCONN();
    public static final int ERRNO_EBADF_NEGATIVE = -ErrorsStaticallyReferencedJniMethods.errnoEBADF();
    public static final int ERRNO_EPIPE_NEGATIVE = -ErrorsStaticallyReferencedJniMethods.errnoEPIPE();
    public static final int ERRNO_ECONNRESET_NEGATIVE = -ErrorsStaticallyReferencedJniMethods.errnoECONNRESET();
    public static final int ERRNO_EAGAIN_NEGATIVE = -ErrorsStaticallyReferencedJniMethods.errnoEAGAIN();
    public static final int ERRNO_EWOULDBLOCK_NEGATIVE = -ErrorsStaticallyReferencedJniMethods.errnoEWOULDBLOCK();
    public static final int ERRNO_EINPROGRESS_NEGATIVE = -ErrorsStaticallyReferencedJniMethods.errnoEINPROGRESS();
    public static final int ERROR_ECONNREFUSED_NEGATIVE = -ErrorsStaticallyReferencedJniMethods.errorECONNREFUSED();
    public static final int ERROR_EISCONN_NEGATIVE = -ErrorsStaticallyReferencedJniMethods.errorEISCONN();
    public static final int ERROR_EALREADY_NEGATIVE = -ErrorsStaticallyReferencedJniMethods.errorEALREADY();
    public static final int ERROR_ENETUNREACH_NEGATIVE = -ErrorsStaticallyReferencedJniMethods.errorENETUNREACH();
    private static final String[] ERRORS = new String[512];

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class NativeConnectException extends ConnectException {
        private static final long serialVersionUID = -5532328671712318161L;
        private final int expectedErr;

        NativeConnectException(String str, int i6) {
            super(str + "(..) failed: " + Errors.ERRORS[-i6]);
            this.expectedErr = i6;
        }

        int expectedErr() {
            return this.expectedErr;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class NativeIoException extends IOException {
        private static final long serialVersionUID = 8222160204268655526L;
        private final int expectedErr;
        private final boolean fillInStackTrace;

        public NativeIoException(String str, int i6) {
            this(str, i6, true);
        }

        @Override // java.lang.Throwable
        public synchronized Throwable fillInStackTrace() {
            if (!this.fillInStackTrace) {
                return this;
            }
            return super.fillInStackTrace();
        }

        public NativeIoException(String str, int i6, boolean z5) {
            super(str + "(..) failed: " + Errors.ERRORS[-i6]);
            this.expectedErr = i6;
            this.fillInStackTrace = z5;
        }

        public int expectedErr() {
            return this.expectedErr;
        }
    }

    @Deprecated
    public static int ioResult(String str, int i6, NativeIoException nativeIoException, ClosedChannelException closedChannelException) throws IOException {
        if (i6 == ERRNO_EAGAIN_NEGATIVE || i6 == ERRNO_EWOULDBLOCK_NEGATIVE) {
            return 0;
        }
        if (i6 == nativeIoException.expectedErr()) {
            throw nativeIoException;
        }
        if (i6 == ERRNO_EBADF_NEGATIVE) {
            throw closedChannelException;
        }
        if (i6 == ERRNO_ENOTCONN_NEGATIVE) {
            throw new NotYetConnectedException();
        }
        if (i6 == ERRNO_ENOENT_NEGATIVE) {
            throw new FileNotFoundException();
        }
        throw newIOException(str, i6);
    }

    public static NativeIoException newConnectionResetException(String str, int i6) {
        NativeIoException nativeIoException = new NativeIoException(str, i6, false);
        nativeIoException.setStackTrace(EmptyArrays.EMPTY_STACK_TRACE);
        return nativeIoException;
    }

    public static NativeIoException newIOException(String str, int i6) {
        return new NativeIoException(str, i6);
    }

    static void throwConnectException(String str, int i6) throws IOException {
        if (i6 == ERROR_EALREADY_NEGATIVE) {
            throw new ConnectionPendingException();
        }
        if (i6 == ERROR_ENETUNREACH_NEGATIVE) {
            throw new NoRouteToHostException();
        }
        if (i6 == ERROR_EISCONN_NEGATIVE) {
            throw new AlreadyConnectedException();
        }
        if (i6 == ERRNO_ENOENT_NEGATIVE) {
            throw new FileNotFoundException();
        }
        throw new ConnectException(str + "(..) failed: " + ERRORS[-i6]);
    }

    static {
        int i6 = 0;
        while (true) {
            String[] strArr = ERRORS;
            if (i6 < strArr.length) {
                strArr[i6] = ErrorsStaticallyReferencedJniMethods.strError(i6);
                i6++;
            } else {
                return;
            }
        }
    }

    private Errors() {
    }

    public static int ioResult(String str, int i6) throws IOException {
        if (i6 == ERRNO_EAGAIN_NEGATIVE || i6 == ERRNO_EWOULDBLOCK_NEGATIVE) {
            return 0;
        }
        if (i6 != ERRNO_EBADF_NEGATIVE) {
            if (i6 != ERRNO_ENOTCONN_NEGATIVE) {
                if (i6 == ERRNO_ENOENT_NEGATIVE) {
                    throw new FileNotFoundException();
                }
                throw new NativeIoException(str, i6, false);
            }
            throw new NotYetConnectedException();
        }
        throw new ClosedChannelException();
    }
}
