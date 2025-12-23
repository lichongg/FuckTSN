package io.netty.util.concurrent;

import io.netty.util.concurrent.ProgressiveFuture;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface GenericProgressiveFutureListener<F extends ProgressiveFuture<?>> extends GenericFutureListener<F> {
    void operationProgressed(F f6, long j6, long j7) throws Exception;
}
