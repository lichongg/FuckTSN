package io.netty.util.concurrent;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface EventExecutorChooserFactory {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface EventExecutorChooser {
        EventExecutor next();
    }

    EventExecutorChooser newChooser(EventExecutor[] eventExecutorArr);
}
