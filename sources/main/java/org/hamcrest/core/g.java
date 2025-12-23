package org.hamcrest.core;

import org.hamcrest.Factory;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class g<T> extends org.hamcrest.b<T> {

    /* renamed from: a, reason: collision with root package name */
    private final String f51290a;

    public g() {
        this("ANYTHING");
    }

    @Override // org.hamcrest.j
    public boolean c(Object obj) {
        return true;
    }

    public g(String str) {
        this.f51290a = str;
    }

    @Factory
    public static org.hamcrest.j<Object> d() {
        return new g();
    }

    @Factory
    public static org.hamcrest.j<Object> e(String str) {
        return new g(str);
    }

    @Override // org.hamcrest.l
    public void describeTo(org.hamcrest.g gVar) {
        gVar.b(this.f51290a);
    }
}
