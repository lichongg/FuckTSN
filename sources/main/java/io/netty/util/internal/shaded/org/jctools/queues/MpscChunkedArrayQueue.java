package io.netty.util.internal.shaded.org.jctools.queues;

import io.netty.util.internal.shaded.org.jctools.util.Pow2;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class MpscChunkedArrayQueue<E> extends MpscChunkedArrayQueueColdProducerFields<E> {

    /* renamed from: p0, reason: collision with root package name */
    long f43095p0;

    /* renamed from: p1, reason: collision with root package name */
    long f43096p1;
    long p10;
    long p11;
    long p12;
    long p13;
    long p14;
    long p15;
    long p16;
    long p17;

    /* renamed from: p2, reason: collision with root package name */
    long f43097p2;

    /* renamed from: p3, reason: collision with root package name */
    long f43098p3;

    /* renamed from: p4, reason: collision with root package name */
    long f43099p4;
    long p5;
    long p6;
    long p7;

    public MpscChunkedArrayQueue(int i6) {
        super(Math.max(2, Math.min(1024, Pow2.roundToPowerOfTwo(i6 / 8))), i6);
    }

    public MpscChunkedArrayQueue(int i6, int i7) {
        super(i6, i7);
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.BaseMpscLinkedArrayQueue
    protected long availableInQueue(long j6, long j7) {
        return this.maxQueueCapacity - (j6 - j7);
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.BaseMpscLinkedArrayQueue, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public int capacity() {
        return (int) (this.maxQueueCapacity / 2);
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
