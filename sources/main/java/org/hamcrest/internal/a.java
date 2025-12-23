package org.hamcrest.internal;

import java.lang.reflect.Array;
import java.util.Iterator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class a implements Iterator<Object> {

    /* renamed from: a, reason: collision with root package name */
    private final Object f51306a;

    /* renamed from: b, reason: collision with root package name */
    private int f51307b = 0;

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f51307b < Array.getLength(this.f51306a);
    }

    @Override // java.util.Iterator
    public Object next() {
        Object obj = this.f51306a;
        int i6 = this.f51307b;
        this.f51307b = i6 + 1;
        return Array.get(obj, i6);
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("cannot remove items from an array");
    }

    public a(Object obj) {
        if (obj.getClass().isArray()) {
            this.f51306a = obj;
            return;
        }
        throw new IllegalArgumentException("not an array");
    }
}
