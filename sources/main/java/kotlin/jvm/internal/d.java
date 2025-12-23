package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class d extends kotlin.collections.s0 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final double[] f43999a;

    /* renamed from: b, reason: collision with root package name */
    private int f44000b;

    public d(@NotNull double[] array) {
        g0.p(array, "array");
        this.f43999a = array;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f44000b < this.f43999a.length;
    }

    @Override // kotlin.collections.s0
    public double nextDouble() {
        try {
            double[] dArr = this.f43999a;
            int i6 = this.f44000b;
            this.f44000b = i6 + 1;
            return dArr[i6];
        } catch (ArrayIndexOutOfBoundsException e6) {
            this.f44000b--;
            throw new NoSuchElementException(e6.getMessage());
        }
    }
}
