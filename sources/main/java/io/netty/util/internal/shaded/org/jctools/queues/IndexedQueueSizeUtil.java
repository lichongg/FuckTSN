package io.netty.util.internal.shaded.org.jctools.queues;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class IndexedQueueSizeUtil {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface IndexedQueue {
        long lvConsumerIndex();

        long lvProducerIndex();
    }

    public static boolean isEmpty(IndexedQueue indexedQueue) {
        if (indexedQueue.lvConsumerIndex() == indexedQueue.lvProducerIndex()) {
            return true;
        }
        return false;
    }

    public static int size(IndexedQueue indexedQueue) {
        long lvProducerIndex;
        long lvConsumerIndex;
        long lvConsumerIndex2 = indexedQueue.lvConsumerIndex();
        while (true) {
            lvProducerIndex = indexedQueue.lvProducerIndex();
            lvConsumerIndex = indexedQueue.lvConsumerIndex();
            if (lvConsumerIndex2 == lvConsumerIndex) {
                break;
            }
            lvConsumerIndex2 = lvConsumerIndex;
        }
        long j6 = lvProducerIndex - lvConsumerIndex;
        if (j6 > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) j6;
    }
}
