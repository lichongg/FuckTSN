package org.apache.commons.net.nntp;

import java.util.Iterator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
class k implements Iterator<j>, Iterable<j> {

    /* renamed from: a, reason: collision with root package name */
    private final Iterator<String> f50942a;

    @Override // java.util.Iterator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public j next() {
        return f.S0(this.f50942a.next());
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f50942a.hasNext();
    }

    @Override // java.util.Iterator
    public void remove() {
        this.f50942a.remove();
    }

    public k(Iterable<String> iterable) {
        this.f50942a = iterable.iterator();
    }

    @Override // java.lang.Iterable
    public Iterator<j> iterator() {
        return this;
    }
}
