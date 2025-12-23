package io.netty.util.concurrent;

import io.netty.util.concurrent.Future;
import java.util.EventListener;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface GenericFutureListener<F extends Future<?>> extends EventListener {
    void operationComplete(F f6) throws Exception;
}
