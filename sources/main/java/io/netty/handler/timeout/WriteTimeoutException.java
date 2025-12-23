package io.netty.handler.timeout;

import io.netty.util.internal.PlatformDependent;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class WriteTimeoutException extends TimeoutException {
    public static final WriteTimeoutException INSTANCE;
    private static final long serialVersionUID = -144786655770296065L;

    private WriteTimeoutException() {
    }

    private WriteTimeoutException(boolean z5) {
        super(z5);
    }

    static {
        WriteTimeoutException writeTimeoutException;
        if (PlatformDependent.javaVersion() >= 7) {
            writeTimeoutException = new WriteTimeoutException(true);
        } else {
            writeTimeoutException = new WriteTimeoutException();
        }
        INSTANCE = writeTimeoutException;
    }
}
