package io.netty.handler.codec.http2;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SuppressJava6Requirement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class Http2Exception extends Exception {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long serialVersionUID = -6941186345430164209L;
    private final Http2Error error;
    private final ShutdownHint shutdownHint;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class ClosedStreamCreationException extends Http2Exception {
        private static final long serialVersionUID = -6746542974372246206L;

        public ClosedStreamCreationException(Http2Error http2Error) {
            super(http2Error);
        }

        public ClosedStreamCreationException(Http2Error http2Error, String str) {
            super(http2Error, str);
        }

        public ClosedStreamCreationException(Http2Error http2Error, String str, Throwable th) {
            super(http2Error, str, th);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class CompositeStreamException extends Http2Exception implements Iterable<StreamException> {
        private static final long serialVersionUID = 7091134858213711015L;
        private final List<StreamException> exceptions;

        public CompositeStreamException(Http2Error http2Error, int i6) {
            super(http2Error, ShutdownHint.NO_SHUTDOWN);
            this.exceptions = new ArrayList(i6);
        }

        public void add(StreamException streamException) {
            this.exceptions.add(streamException);
        }

        @Override // java.lang.Iterable
        public Iterator<StreamException> iterator() {
            return this.exceptions.iterator();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class HeaderListSizeException extends StreamException {
        private static final long serialVersionUID = -8807603212183882637L;
        private final boolean decode;

        public boolean duringDecode() {
            return this.decode;
        }

        HeaderListSizeException(int i6, Http2Error http2Error, String str, boolean z5) {
            super(i6, http2Error, str);
            this.decode = z5;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum ShutdownHint {
        NO_SHUTDOWN,
        GRACEFUL_SHUTDOWN,
        HARD_SHUTDOWN
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class StreamException extends Http2Exception {
        private static final long serialVersionUID = 602472544416984384L;
        private final int streamId;

        StreamException(int i6, Http2Error http2Error, String str) {
            super(http2Error, str, ShutdownHint.NO_SHUTDOWN);
            this.streamId = i6;
        }

        public int streamId() {
            return this.streamId;
        }

        StreamException(int i6, Http2Error http2Error, String str, Throwable th) {
            super(http2Error, str, th, ShutdownHint.NO_SHUTDOWN);
            this.streamId = i6;
        }
    }

    public Http2Exception(Http2Error http2Error) {
        this(http2Error, ShutdownHint.HARD_SHUTDOWN);
    }

    public static Http2Exception connectionError(Http2Error http2Error, String str, Object... objArr) {
        return new Http2Exception(http2Error, String.format(str, objArr));
    }

    public static Http2Exception streamError(int i6, Http2Error http2Error, String str, Object... objArr) {
        return i6 == 0 ? connectionError(http2Error, str, objArr) : new StreamException(i6, http2Error, String.format(str, objArr));
    }

    public Http2Exception(Http2Error http2Error, ShutdownHint shutdownHint) {
        this.error = (Http2Error) ObjectUtil.checkNotNull(http2Error, "error");
        this.shutdownHint = (ShutdownHint) ObjectUtil.checkNotNull(shutdownHint, "shutdownHint");
    }

    public static Http2Exception closedStreamError(Http2Error http2Error, String str, Object... objArr) {
        return new ClosedStreamCreationException(http2Error, String.format(str, objArr));
    }

    public static Http2Exception connectionError(Http2Error http2Error, Throwable th, String str, Object... objArr) {
        return new Http2Exception(http2Error, String.format(str, objArr), th);
    }

    public static Http2Exception headerListSizeError(int i6, Http2Error http2Error, boolean z5, String str, Object... objArr) {
        return i6 == 0 ? connectionError(http2Error, str, objArr) : new HeaderListSizeException(i6, http2Error, String.format(str, objArr), z5);
    }

    public static boolean isStreamError(Http2Exception http2Exception) {
        return http2Exception instanceof StreamException;
    }

    public Http2Error error() {
        return this.error;
    }

    public ShutdownHint shutdownHint() {
        return this.shutdownHint;
    }

    static Http2Exception newStatic(Http2Error http2Error, String str, ShutdownHint shutdownHint) {
        if (PlatformDependent.javaVersion() >= 7) {
            return new Http2Exception(http2Error, str, shutdownHint, true);
        }
        return new Http2Exception(http2Error, str, shutdownHint);
    }

    public static Http2Exception streamError(int i6, Http2Error http2Error, Throwable th, String str, Object... objArr) {
        if (i6 == 0) {
            return connectionError(http2Error, th, str, objArr);
        }
        return new StreamException(i6, http2Error, String.format(str, objArr), th);
    }

    public static int streamId(Http2Exception http2Exception) {
        if (isStreamError(http2Exception)) {
            return ((StreamException) http2Exception).streamId();
        }
        return 0;
    }

    public Http2Exception(Http2Error http2Error, String str) {
        this(http2Error, str, ShutdownHint.HARD_SHUTDOWN);
    }

    public Http2Exception(Http2Error http2Error, String str, ShutdownHint shutdownHint) {
        super(str);
        this.error = (Http2Error) ObjectUtil.checkNotNull(http2Error, "error");
        this.shutdownHint = (ShutdownHint) ObjectUtil.checkNotNull(shutdownHint, "shutdownHint");
    }

    public Http2Exception(Http2Error http2Error, String str, Throwable th) {
        this(http2Error, str, th, ShutdownHint.HARD_SHUTDOWN);
    }

    public Http2Exception(Http2Error http2Error, String str, Throwable th, ShutdownHint shutdownHint) {
        super(str, th);
        this.error = (Http2Error) ObjectUtil.checkNotNull(http2Error, "error");
        this.shutdownHint = (ShutdownHint) ObjectUtil.checkNotNull(shutdownHint, "shutdownHint");
    }

    @SuppressJava6Requirement(reason = "uses Java 7+ Exception.<init>(String, Throwable, boolean, boolean) but is guarded by version checks")
    private Http2Exception(Http2Error http2Error, String str, ShutdownHint shutdownHint, boolean z5) {
        super(str, null, false, true);
        this.error = (Http2Error) ObjectUtil.checkNotNull(http2Error, "error");
        this.shutdownHint = (ShutdownHint) ObjectUtil.checkNotNull(shutdownHint, "shutdownHint");
    }
}
