package kotlin.collections;

import java.util.Iterator;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class c1<T> implements Iterator<a1<? extends T>>, m3.a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final Iterator<T> f43629a;

    /* renamed from: b, reason: collision with root package name */
    private int f43630b;

    /* JADX WARN: Multi-variable type inference failed */
    public c1(@NotNull Iterator<? extends T> iterator) {
        kotlin.jvm.internal.g0.p(iterator, "iterator");
        this.f43629a = iterator;
    }

    @Override // java.util.Iterator
    @NotNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final a1<T> next() {
        int i6 = this.f43630b;
        this.f43630b = i6 + 1;
        if (i6 < 0) {
            h0.b0();
        }
        return new a1<>(i6, this.f43629a.next());
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f43629a.hasNext();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
