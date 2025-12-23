package com.bumptech.glide.repackaged.com.google.common.collect;

import java.util.NoSuchElementException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
abstract class a<E> extends v0<E> {

    /* renamed from: a, reason: collision with root package name */
    private final int f15876a;

    /* renamed from: b, reason: collision with root package name */
    private int f15877b;

    protected abstract E a(int i6);

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.f15877b < this.f15876a;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f15877b > 0;
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f15877b;
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f15877b - 1;
    }

    protected a(int i6, int i7) {
        com.bumptech.glide.repackaged.com.google.common.base.d.k(i7, i6);
        this.f15876a = i6;
        this.f15877b = i7;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final E next() {
        if (hasNext()) {
            int i6 = this.f15877b;
            this.f15877b = i6 + 1;
            return a(i6);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final E previous() {
        if (hasPrevious()) {
            int i6 = this.f15877b - 1;
            this.f15877b = i6;
            return a(i6);
        }
        throw new NoSuchElementException();
    }
}
