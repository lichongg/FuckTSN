package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.e1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class j extends e1 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final long[] f44013a;

    /* renamed from: b, reason: collision with root package name */
    private int f44014b;

    public j(@NotNull long[] array) {
        g0.p(array, "array");
        this.f44013a = array;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f44014b < this.f44013a.length;
    }

    @Override // kotlin.collections.e1
    public long nextLong() {
        try {
            long[] jArr = this.f44013a;
            int i6 = this.f44014b;
            this.f44014b = i6 + 1;
            return jArr[i6];
        } catch (ArrayIndexOutOfBoundsException e6) {
            this.f44014b--;
            throw new NoSuchElementException(e6.getMessage());
        }
    }
}
