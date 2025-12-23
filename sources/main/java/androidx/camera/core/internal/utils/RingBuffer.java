package androidx.camera.core.internal.utils;

import androidx.annotation.NonNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public interface RingBuffer<T> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface OnRemoveCallback<T> {
        void onRemove(@NonNull T t5);
    }

    @NonNull
    T dequeue();

    void enqueue(@NonNull T t5);

    int getMaxCapacity();

    boolean isEmpty();
}
