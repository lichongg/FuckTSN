package org.junit.experimental.results;

import org.hamcrest.g;
import org.hamcrest.j;
import org.hamcrest.o;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class c {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a extends o<org.junit.experimental.results.b> {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f51353c;

        a(int i6) {
            this.f51353c = i6;
        }

        @Override // org.hamcrest.l
        public void describeTo(g gVar) {
            gVar.b("has " + this.f51353c + " failures");
        }

        @Override // org.hamcrest.o
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public boolean e(org.junit.experimental.results.b bVar) {
            if (bVar.a() == this.f51353c) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class b extends org.hamcrest.b<Object> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f51354a;

        b(String str) {
            this.f51354a = str;
        }

        @Override // org.hamcrest.l
        public void describeTo(g gVar) {
            gVar.b("has single failure containing " + this.f51354a);
        }

        @Override // org.hamcrest.j
        public boolean c(Object obj) {
            if (obj.toString().contains(this.f51354a) && c.a(1).c(obj)) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: org.junit.experimental.results.c$c, reason: collision with other inner class name */
    static class C0985c extends org.hamcrest.b<org.junit.experimental.results.b> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f51355a;

        C0985c(String str) {
            this.f51355a = str;
        }

        @Override // org.hamcrest.l
        public void describeTo(g gVar) {
            gVar.b("has failure containing " + this.f51355a);
        }

        @Override // org.hamcrest.j
        public boolean c(Object obj) {
            return obj.toString().contains(this.f51355a);
        }
    }

    public static j<org.junit.experimental.results.b> d() {
        return a(0);
    }

    public static j<org.junit.experimental.results.b> a(int i6) {
        return new a(i6);
    }

    public static j<org.junit.experimental.results.b> b(String str) {
        return new C0985c(str);
    }

    public static j<Object> c(String str) {
        return new b(str);
    }
}
