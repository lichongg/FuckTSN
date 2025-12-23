package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class a extends kotlin.collections.c0 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final boolean[] f43992a;

    /* renamed from: b, reason: collision with root package name */
    private int f43993b;

    public a(@NotNull boolean[] array) {
        g0.p(array, "array");
        this.f43992a = array;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f43993b < this.f43992a.length;
    }

    @Override // kotlin.collections.c0
    public boolean nextBoolean() {
        try {
            boolean[] zArr = this.f43992a;
            int i6 = this.f43993b;
            this.f43993b = i6 + 1;
            return zArr[i6];
        } catch (ArrayIndexOutOfBoundsException e6) {
            this.f43993b--;
            throw new NoSuchElementException(e6.getMessage());
        }
    }
}
