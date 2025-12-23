package kotlin.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class c<T> implements Iterator<T>, m3.a {

    /* renamed from: a, reason: collision with root package name */
    private int f43627a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private T f43628b;

    private final boolean f() {
        this.f43627a = 3;
        a();
        return this.f43627a == 1;
    }

    protected abstract void a();

    protected final void c() {
        this.f43627a = 2;
    }

    protected final void e(T t5) {
        this.f43628b = t5;
        this.f43627a = 1;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        int i6 = this.f43627a;
        if (i6 == 0) {
            return f();
        }
        if (i6 == 1) {
            return true;
        }
        if (i6 == 2) {
            return false;
        }
        throw new IllegalArgumentException("hasNext called when the iterator is in the FAILED state.");
    }

    @Override // java.util.Iterator
    public T next() {
        int i6 = this.f43627a;
        if (i6 == 1) {
            this.f43627a = 0;
            return this.f43628b;
        }
        if (i6 == 2 || !f()) {
            throw new NoSuchElementException();
        }
        this.f43627a = 0;
        return this.f43628b;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
