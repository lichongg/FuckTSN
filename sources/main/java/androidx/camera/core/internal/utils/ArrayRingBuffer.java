package androidx.camera.core.internal.utils;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.internal.utils.RingBuffer;
import java.util.ArrayDeque;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public class ArrayRingBuffer<T> implements RingBuffer<T> {
    private static final String TAG = "ZslRingBuffer";

    @GuardedBy("mLock")
    private final ArrayDeque<T> mBuffer;
    private final Object mLock;

    @Nullable
    final RingBuffer.OnRemoveCallback<T> mOnRemoveCallback;
    private final int mRingBufferCapacity;

    public ArrayRingBuffer(int i6) {
        this(i6, null);
    }

    public ArrayRingBuffer(int i6, @Nullable RingBuffer.OnRemoveCallback<T> onRemoveCallback) {
        this.mLock = new Object();
        this.mRingBufferCapacity = i6;
        this.mBuffer = new ArrayDeque<>(i6);
        this.mOnRemoveCallback = onRemoveCallback;
    }

    @Override // androidx.camera.core.internal.utils.RingBuffer
    @NonNull
    public T dequeue() {
        T removeLast;
        synchronized (this.mLock) {
            removeLast = this.mBuffer.removeLast();
        }
        return removeLast;
    }

    @Override // androidx.camera.core.internal.utils.RingBuffer
    public void enqueue(@NonNull T t5) {
        T dequeue;
        synchronized (this.mLock) {
            try {
                dequeue = this.mBuffer.size() >= this.mRingBufferCapacity ? dequeue() : null;
                this.mBuffer.addFirst(t5);
            } catch (Throwable th) {
                throw th;
            }
        }
        RingBuffer.OnRemoveCallback<T> onRemoveCallback = this.mOnRemoveCallback;
        if (onRemoveCallback == null || dequeue == null) {
            return;
        }
        onRemoveCallback.onRemove(dequeue);
    }

    @Override // androidx.camera.core.internal.utils.RingBuffer
    public int getMaxCapacity() {
        return this.mRingBufferCapacity;
    }

    @Override // androidx.camera.core.internal.utils.RingBuffer
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mLock) {
            isEmpty = this.mBuffer.isEmpty();
        }
        return isEmpty;
    }
}
