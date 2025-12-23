package io.netty.handler.timeout;

import io.netty.util.internal.PlatformDependent;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class ReadTimeoutException extends TimeoutException {
    public static final ReadTimeoutException INSTANCE;
    private static final long serialVersionUID = 169287984113283421L;

    ReadTimeoutException() {
    }

    private ReadTimeoutException(boolean z5) {
        super(z5);
    }

    static {
        ReadTimeoutException readTimeoutException;
        if (PlatformDependent.javaVersion() >= 7) {
            readTimeoutException = new ReadTimeoutException(true);
        } else {
            readTimeoutException = new ReadTimeoutException();
        }
        INSTANCE = readTimeoutException;
    }
}
