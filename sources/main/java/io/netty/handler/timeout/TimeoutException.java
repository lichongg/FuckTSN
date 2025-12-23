package io.netty.handler.timeout;

import io.netty.channel.ChannelException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class TimeoutException extends ChannelException {
    private static final long serialVersionUID = 4673641882869672533L;

    TimeoutException() {
    }

    TimeoutException(boolean z5) {
        super(null, null, z5);
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        return this;
    }
}
