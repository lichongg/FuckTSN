package junit.framework;

import org.junit.runner.Description;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class d implements f, org.junit.runner.b {

    /* renamed from: a, reason: collision with root package name */
    private final Description f43481a;

    @Override // junit.framework.f
    public int c() {
        return 1;
    }

    @Override // junit.framework.f
    public void a(j jVar) {
        throw new RuntimeException("This test stub created only for informational purposes.");
    }

    @Override // org.junit.runner.b
    public Description getDescription() {
        return this.f43481a;
    }

    d(Description description) {
        this.f43481a = description;
    }

    public String toString() {
        return getDescription().toString();
    }
}
