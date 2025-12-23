package rx.internal.util.atomic;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.internal.util.unsafe.p;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
abstract class a<E> extends AbstractQueue<E> {

    /* renamed from: a, reason: collision with root package name */
    protected final AtomicReferenceArray<E> f54104a;

    /* renamed from: b, reason: collision with root package name */
    protected final int f54105b;

    protected final int a(long j6) {
        return this.f54105b & ((int) j6);
    }

    protected final int d(long j6, int i6) {
        return ((int) j6) & i6;
    }

    protected final E e(int i6) {
        return this.f54104a.get(i6);
    }

    protected final E g(int i6) {
        return j(this.f54104a, i6);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    protected final void m(int i6, E e6) {
        this.f54104a.lazySet(i6, e6);
    }

    protected final void o(int i6, E e6) {
        this.f54104a.lazySet(i6, e6);
    }

    public a(int i6) {
        int b6 = p.b(i6);
        this.f54105b = b6 - 1;
        this.f54104a = new AtomicReferenceArray<>(b6);
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    protected final E f(AtomicReferenceArray<E> atomicReferenceArray, int i6) {
        return atomicReferenceArray.get(i6);
    }

    protected final E j(AtomicReferenceArray<E> atomicReferenceArray, int i6) {
        return atomicReferenceArray.get(i6);
    }

    protected final void n(AtomicReferenceArray<E> atomicReferenceArray, int i6, E e6) {
        atomicReferenceArray.lazySet(i6, e6);
    }

    protected final void p(AtomicReferenceArray<E> atomicReferenceArray, int i6, E e6) {
        atomicReferenceArray.lazySet(i6, e6);
    }

    protected final void q(AtomicReferenceArray<E> atomicReferenceArray, int i6, E e6) {
        atomicReferenceArray.set(i6, e6);
    }
}
