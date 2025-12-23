package org.hamcrest.internal;

import org.hamcrest.g;
import org.hamcrest.l;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class c<T> implements l {

    /* renamed from: a, reason: collision with root package name */
    private T f51311a;

    @Override // org.hamcrest.l
    public void describeTo(g gVar) {
        gVar.c(this.f51311a);
    }

    public c(T t5) {
        this.f51311a = t5;
    }
}
