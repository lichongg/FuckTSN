package junit.framework;

import java.util.Iterator;
import java.util.List;
import org.junit.Ignore;
import org.junit.runner.Description;
import org.junit.runner.manipulation.NoTestsRemainException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class c implements f, org.junit.runner.manipulation.b, org.junit.runner.manipulation.c, org.junit.runner.b {

    /* renamed from: a, reason: collision with root package name */
    private final Class<?> f43478a;

    /* renamed from: b, reason: collision with root package name */
    private final org.junit.runner.g f43479b;

    /* renamed from: c, reason: collision with root package name */
    private final JUnit4TestAdapterCache f43480c;

    public c(Class<?> cls) {
        this(cls, JUnit4TestAdapterCache.getDefault());
    }

    public c(Class<?> cls, JUnit4TestAdapterCache jUnit4TestAdapterCache) {
        this.f43480c = jUnit4TestAdapterCache;
        this.f43478a = cls;
        this.f43479b = org.junit.runner.f.b(cls).h();
    }

    private boolean g(Description description) {
        return description.getAnnotation(Ignore.class) != null;
    }

    @Override // junit.framework.f
    public void a(j jVar) {
        this.f43479b.a(this.f43480c.getNotifier(jVar, this));
    }

    @Override // org.junit.runner.manipulation.b
    public void b(org.junit.runner.manipulation.a aVar) throws NoTestsRemainException {
        aVar.a(this.f43479b);
    }

    @Override // junit.framework.f
    public int c() {
        return this.f43479b.c();
    }

    @Override // org.junit.runner.manipulation.c
    public void d(org.junit.runner.manipulation.d dVar) {
        dVar.a(this.f43479b);
    }

    public Class<?> e() {
        return this.f43478a;
    }

    public List<f> f() {
        return this.f43480c.asTestList(getDescription());
    }

    @Override // org.junit.runner.b
    public Description getDescription() {
        return h(this.f43479b.getDescription());
    }

    public String toString() {
        return this.f43478a.getName();
    }

    private Description h(Description description) {
        if (g(description)) {
            return Description.EMPTY;
        }
        Description childlessCopy = description.childlessCopy();
        Iterator<Description> it = description.getChildren().iterator();
        while (it.hasNext()) {
            Description h6 = h(it.next());
            if (!h6.isEmpty()) {
                childlessCopy.addChild(h6);
            }
        }
        return childlessCopy;
    }
}
