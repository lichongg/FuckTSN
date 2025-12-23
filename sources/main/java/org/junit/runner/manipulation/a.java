package org.junit.runner.manipulation;

import java.util.Iterator;
import org.junit.runner.Description;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f51506a = new C0993a();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: org.junit.runner.manipulation.a$a, reason: collision with other inner class name */
    static class C0993a extends a {
        @Override // org.junit.runner.manipulation.a
        public boolean e(Description description) {
            return true;
        }

        @Override // org.junit.runner.manipulation.a
        public String b() {
            return "all tests";
        }

        C0993a() {
        }

        @Override // org.junit.runner.manipulation.a
        public void a(Object obj) throws NoTestsRemainException {
        }

        @Override // org.junit.runner.manipulation.a
        public a c(a aVar) {
            return aVar;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class b extends a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Description f51507b;

        b(Description description) {
            this.f51507b = description;
        }

        @Override // org.junit.runner.manipulation.a
        public String b() {
            return String.format("Method %s", this.f51507b.getDisplayName());
        }

        @Override // org.junit.runner.manipulation.a
        public boolean e(Description description) {
            if (description.isTest()) {
                return this.f51507b.equals(description);
            }
            Iterator<Description> it = description.getChildren().iterator();
            while (it.hasNext()) {
                if (e(it.next())) {
                    return true;
                }
            }
            return false;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c extends a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f51508b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f51509c;

        c(a aVar, a aVar2) {
            this.f51508b = aVar;
            this.f51509c = aVar2;
        }

        @Override // org.junit.runner.manipulation.a
        public String b() {
            return this.f51508b.b() + " and " + this.f51509c.b();
        }

        @Override // org.junit.runner.manipulation.a
        public boolean e(Description description) {
            return this.f51508b.e(description) && this.f51509c.e(description);
        }
    }

    public abstract String b();

    public abstract boolean e(Description description);

    public static a d(Description description) {
        return new b(description);
    }

    public void a(Object obj) throws NoTestsRemainException {
        if (obj instanceof org.junit.runner.manipulation.b) {
            ((org.junit.runner.manipulation.b) obj).b(this);
        }
    }

    public a c(a aVar) {
        return (aVar == this || aVar == f51506a) ? this : new c(this, aVar);
    }
}
