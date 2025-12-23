package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceArray;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class n0<T> {

    @NotNull
    private volatile AtomicReferenceArray<T> array;

    public final int a() {
        return this.array.length();
    }

    @Nullable
    public final T b(int i6) {
        AtomicReferenceArray<T> atomicReferenceArray = this.array;
        if (i6 < atomicReferenceArray.length()) {
            return atomicReferenceArray.get(i6);
        }
        return null;
    }

    public final void c(int i6, @Nullable T t5) {
        AtomicReferenceArray<T> atomicReferenceArray = this.array;
        int length = atomicReferenceArray.length();
        if (i6 < length) {
            atomicReferenceArray.set(i6, t5);
            return;
        }
        AtomicReferenceArray<T> atomicReferenceArray2 = new AtomicReferenceArray<>(kotlin.ranges.t.u(i6 + 1, length * 2));
        for (int i7 = 0; i7 < length; i7++) {
            atomicReferenceArray2.set(i7, atomicReferenceArray.get(i7));
        }
        atomicReferenceArray2.set(i6, t5);
        this.array = atomicReferenceArray2;
    }

    public n0(int i6) {
        this.array = new AtomicReferenceArray<>(i6);
    }
}
