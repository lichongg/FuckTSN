package io.netty.util.internal.shaded.org.jctools.queues;

import io.netty.util.internal.shaded.org.jctools.util.Pow2;
import io.netty.util.internal.shaded.org.jctools.util.RangeUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
abstract class MpscChunkedArrayQueueColdProducerFields<E> extends BaseMpscLinkedArrayQueue<E> {
    protected final long maxQueueCapacity;

    public MpscChunkedArrayQueueColdProducerFields(int i6, int i7) {
        super(i6);
        RangeUtil.checkGreaterThanOrEqual(i7, 4, "maxCapacity");
        RangeUtil.checkLessThan(Pow2.roundToPowerOfTwo(i6), Pow2.roundToPowerOfTwo(i7), "initialCapacity");
        this.maxQueueCapacity = Pow2.roundToPowerOfTwo(i7) << 1;
    }
}
