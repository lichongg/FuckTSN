package io.netty.handler.logging;

import io.netty.util.internal.logging.InternalLogLevel;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public enum LogLevel {
    TRACE(InternalLogLevel.TRACE),
    DEBUG(InternalLogLevel.DEBUG),
    INFO(InternalLogLevel.INFO),
    WARN(InternalLogLevel.WARN),
    ERROR(InternalLogLevel.ERROR);

    private final InternalLogLevel internalLevel;

    public InternalLogLevel toInternalLevel() {
        return this.internalLevel;
    }

    LogLevel(InternalLogLevel internalLogLevel) {
        this.internalLevel = internalLogLevel;
    }
}
