package kotlin.jvm.internal;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class g<T> implements Iterator<T>, m3.a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final T[] f44011a;

    /* renamed from: b, reason: collision with root package name */
    private int f44012b;

    public g(@NotNull T[] array) {
        g0.p(array, "array");
        this.f44011a = array;
    }

    @NotNull
    public final T[] a() {
        return this.f44011a;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f44012b < this.f44011a.length;
    }

    @Override // java.util.Iterator
    public T next() {
        try {
            T[] tArr = this.f44011a;
            int i6 = this.f44012b;
            this.f44012b = i6 + 1;
            return tArr[i6];
        } catch (ArrayIndexOutOfBoundsException e6) {
            this.f44012b--;
            throw new NoSuchElementException(e6.getMessage());
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
