package io.netty.util.internal.shaded.org.jctools.queues;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface MessagePassingQueue<T> {
    public static final int UNBOUNDED_CAPACITY = -1;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface Consumer<T> {
        void accept(T t5);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface ExitCondition {
        boolean keepRunning();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface Supplier<T> {
        T get();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface WaitStrategy {
        int idle(int i6);
    }

    int capacity();

    void clear();

    int drain(Consumer<T> consumer);

    int drain(Consumer<T> consumer, int i6);

    void drain(Consumer<T> consumer, WaitStrategy waitStrategy, ExitCondition exitCondition);

    int fill(Supplier<T> supplier);

    int fill(Supplier<T> supplier, int i6);

    void fill(Supplier<T> supplier, WaitStrategy waitStrategy, ExitCondition exitCondition);

    boolean isEmpty();

    boolean offer(T t5);

    T peek();

    T poll();

    boolean relaxedOffer(T t5);

    T relaxedPeek();

    T relaxedPoll();

    int size();
}
