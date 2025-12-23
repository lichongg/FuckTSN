package io.netty.util.concurrent;

import java.util.Arrays;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class DefaultFutureListeners {
    private GenericFutureListener<? extends Future<?>>[] listeners;
    private int progressiveSize;
    private int size = 2;

    public void add(GenericFutureListener<? extends Future<?>> genericFutureListener) {
        GenericFutureListener<? extends Future<?>>[] genericFutureListenerArr = this.listeners;
        int i6 = this.size;
        if (i6 == genericFutureListenerArr.length) {
            genericFutureListenerArr = (GenericFutureListener[]) Arrays.copyOf(genericFutureListenerArr, i6 << 1);
            this.listeners = genericFutureListenerArr;
        }
        genericFutureListenerArr[i6] = genericFutureListener;
        this.size = i6 + 1;
        if (genericFutureListener instanceof GenericProgressiveFutureListener) {
            this.progressiveSize++;
        }
    }

    public GenericFutureListener<? extends Future<?>>[] listeners() {
        return this.listeners;
    }

    public int progressiveSize() {
        return this.progressiveSize;
    }

    public void remove(GenericFutureListener<? extends Future<?>> genericFutureListener) {
        GenericFutureListener<? extends Future<?>>[] genericFutureListenerArr = this.listeners;
        int i6 = this.size;
        for (int i7 = 0; i7 < i6; i7++) {
            if (genericFutureListenerArr[i7] == genericFutureListener) {
                int i8 = (i6 - i7) - 1;
                if (i8 > 0) {
                    System.arraycopy(genericFutureListenerArr, i7 + 1, genericFutureListenerArr, i7, i8);
                }
                int i9 = i6 - 1;
                genericFutureListenerArr[i9] = null;
                this.size = i9;
                if (genericFutureListener instanceof GenericProgressiveFutureListener) {
                    this.progressiveSize--;
                    return;
                }
                return;
            }
        }
    }

    public int size() {
        return this.size;
    }

    DefaultFutureListeners(GenericFutureListener<? extends Future<?>> genericFutureListener, GenericFutureListener<? extends Future<?>> genericFutureListener2) {
        this.listeners = new GenericFutureListener[]{genericFutureListener, genericFutureListener2};
        if (genericFutureListener instanceof GenericProgressiveFutureListener) {
            this.progressiveSize++;
        }
        if (genericFutureListener2 instanceof GenericProgressiveFutureListener) {
            this.progressiveSize++;
        }
    }
}
