package io.netty.util.internal;

import io.netty.util.concurrent.Promise;
import io.netty.util.internal.logging.InternalLogger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class PromiseNotificationUtil {
    public static void tryCancel(Promise<?> promise, InternalLogger internalLogger) {
        if (promise.cancel(false) || internalLogger == null) {
            return;
        }
        Throwable cause = promise.cause();
        if (cause == null) {
            internalLogger.warn("Failed to cancel promise because it has succeeded already: {}", promise);
        } else {
            internalLogger.warn("Failed to cancel promise because it has failed already: {}, unnotified cause:", promise, cause);
        }
    }

    private PromiseNotificationUtil() {
    }

    public static void tryFailure(Promise<?> promise, Throwable th, InternalLogger internalLogger) {
        if (!promise.tryFailure(th) && internalLogger != null) {
            Throwable cause = promise.cause();
            if (cause == null) {
                internalLogger.warn("Failed to mark a promise as failure because it has succeeded already: {}", promise, th);
            } else {
                internalLogger.warn("Failed to mark a promise as failure because it has failed already: {}, unnotified cause: {}", promise, ThrowableUtil.stackTraceToString(cause), th);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <V> void trySuccess(Promise<? super V> promise, V v5, InternalLogger internalLogger) {
        if (!promise.trySuccess(v5) && internalLogger != null) {
            Throwable cause = promise.cause();
            if (cause == null) {
                internalLogger.warn("Failed to mark a promise as success because it has succeeded already: {}", promise);
            } else {
                internalLogger.warn("Failed to mark a promise as success because it has failed already: {}, unnotified cause:", promise, cause);
            }
        }
    }
}
