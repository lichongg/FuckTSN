package io.netty.util.internal.shaded.org.jctools.queues;

import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue;
import io.netty.util.internal.shaded.org.jctools.util.PortableJvmInfo;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class MpscUnboundedArrayQueue<E> extends BaseMpscLinkedArrayQueue<E> {

    /* renamed from: p0, reason: collision with root package name */
    long f43100p0;

    /* renamed from: p1, reason: collision with root package name */
    long f43101p1;
    long p10;
    long p11;
    long p12;
    long p13;
    long p14;
    long p15;
    long p16;
    long p17;

    /* renamed from: p2, reason: collision with root package name */
    long f43102p2;

    /* renamed from: p3, reason: collision with root package name */
    long f43103p3;

    /* renamed from: p4, reason: collision with root package name */
    long f43104p4;
    long p5;
    long p6;
    long p7;

    @Override // io.netty.util.internal.shaded.org.jctools.queues.BaseMpscLinkedArrayQueue, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public int capacity() {
        return -1;
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.BaseMpscLinkedArrayQueue, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public int drain(MessagePassingQueue.Consumer<E> consumer) {
        return drain(consumer, 4096);
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.BaseMpscLinkedArrayQueue, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public int fill(MessagePassingQueue.Supplier<E> supplier) {
        long j6 = 0;
        do {
            int fill = fill(supplier, PortableJvmInfo.RECOMENDED_OFFER_BATCH);
            if (fill == 0) {
                return (int) j6;
            }
            j6 += fill;
        } while (j6 <= 4096);
        return (int) j6;
    }

    public MpscUnboundedArrayQueue(int i6) {
        super(i6);
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.BaseMpscLinkedArrayQueue
    protected long availableInQueue(long j6, long j7) {
        return 2147483647L;
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.BaseMpscLinkedArrayQueue
    protected int getNextBufferSize(E[] eArr) {
        return LinkedArrayQueueUtil.length(eArr);
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.BaseMpscLinkedArrayQueue
    protected long getCurrentBufferCapacity(long j6) {
        return j6;
    }
}
