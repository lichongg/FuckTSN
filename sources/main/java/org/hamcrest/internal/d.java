package org.hamcrest.internal;

import java.util.Iterator;
import org.hamcrest.l;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class d<T> implements Iterator<l> {

    /* renamed from: a, reason: collision with root package name */
    private Iterator<T> f51312a;

    @Override // java.util.Iterator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public l next() {
        return new c(this.f51312a.next());
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f51312a.hasNext();
    }

    @Override // java.util.Iterator
    public void remove() {
        this.f51312a.remove();
    }

    public d(Iterator<T> it) {
        this.f51312a = it;
    }
}
