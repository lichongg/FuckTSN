package org.apache.commons.net.nntp;

import java.util.Iterator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
class c implements Iterator<a>, Iterable<a> {

    /* renamed from: a, reason: collision with root package name */
    private final Iterator<String> f50874a;

    @Override // java.util.Iterator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public a next() {
        return f.P0(this.f50874a.next());
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f50874a.hasNext();
    }

    @Override // java.util.Iterator
    public void remove() {
        this.f50874a.remove();
    }

    public c(Iterable<String> iterable) {
        this.f50874a = iterable.iterator();
    }

    @Override // java.lang.Iterable
    public Iterator<a> iterator() {
        return this;
    }
}
