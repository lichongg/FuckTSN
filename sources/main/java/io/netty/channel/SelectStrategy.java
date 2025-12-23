package io.netty.channel;

import io.netty.util.IntSupplier;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface SelectStrategy {
    public static final int BUSY_WAIT = -3;
    public static final int CONTINUE = -2;
    public static final int SELECT = -1;

    int calculateStrategy(IntSupplier intSupplier, boolean z5) throws Exception;
}
