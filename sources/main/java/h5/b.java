package h5;

import org.junit.runner.f;
import org.junit.runner.g;
import org.junit.runner.manipulation.NoTestsRemainException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class b extends f {

    /* renamed from: a, reason: collision with root package name */
    private final f f43052a;

    /* renamed from: b, reason: collision with root package name */
    private final org.junit.runner.manipulation.a f43053b;

    @Override // org.junit.runner.f
    public g h() {
        try {
            g h6 = this.f43052a.h();
            this.f43053b.a(h6);
            return h6;
        } catch (NoTestsRemainException unused) {
            return new org.junit.internal.runners.b(org.junit.runner.manipulation.a.class, new Exception(String.format("No tests found matching %s from %s", this.f43053b.b(), this.f43052a.toString())));
        }
    }

    public b(f fVar, org.junit.runner.manipulation.a aVar) {
        this.f43052a = fVar;
        this.f43053b = aVar;
    }
}
