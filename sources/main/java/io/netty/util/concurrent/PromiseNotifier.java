package io.netty.util.concurrent;

import io.netty.util.concurrent.Future;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PromiseNotificationUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class PromiseNotifier<V, F extends Future<V>> implements GenericFutureListener<F> {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) PromiseNotifier.class);
    private final boolean logNotifyFailure;
    private final Promise<? super V>[] promises;

    @SafeVarargs
    public PromiseNotifier(Promise<? super V>... promiseArr) {
        this(true, promiseArr);
    }

    @SafeVarargs
    public PromiseNotifier(boolean z5, Promise<? super V>... promiseArr) {
        ObjectUtil.checkNotNull(promiseArr, "promises");
        for (Promise<? super V> promise : promiseArr) {
            if (promise == null) {
                throw new IllegalArgumentException("promises contains null Promise");
            }
        }
        this.promises = (Promise[]) promiseArr.clone();
        this.logNotifyFailure = z5;
    }

    @Override // io.netty.util.concurrent.GenericFutureListener
    public void operationComplete(F f6) throws Exception {
        InternalLogger internalLogger = this.logNotifyFailure ? logger : null;
        int i6 = 0;
        if (f6.isSuccess()) {
            Object obj = f6.get();
            Promise<? super V>[] promiseArr = this.promises;
            int length = promiseArr.length;
            while (i6 < length) {
                PromiseNotificationUtil.trySuccess(promiseArr[i6], obj, internalLogger);
                i6++;
            }
            return;
        }
        if (f6.isCancelled()) {
            Promise<? super V>[] promiseArr2 = this.promises;
            int length2 = promiseArr2.length;
            while (i6 < length2) {
                PromiseNotificationUtil.tryCancel(promiseArr2[i6], internalLogger);
                i6++;
            }
            return;
        }
        Throwable cause = f6.cause();
        Promise<? super V>[] promiseArr3 = this.promises;
        int length3 = promiseArr3.length;
        while (i6 < length3) {
            PromiseNotificationUtil.tryFailure(promiseArr3[i6], cause, internalLogger);
            i6++;
        }
    }
}
