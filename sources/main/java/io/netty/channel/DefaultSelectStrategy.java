package io.netty.channel;

import io.netty.util.IntSupplier;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class DefaultSelectStrategy implements SelectStrategy {
    static final SelectStrategy INSTANCE = new DefaultSelectStrategy();

    @Override // io.netty.channel.SelectStrategy
    public int calculateStrategy(IntSupplier intSupplier, boolean z5) throws Exception {
        if (z5) {
            return intSupplier.get();
        }
        return -1;
    }

    private DefaultSelectStrategy() {
    }
}
