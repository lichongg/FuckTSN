package h5;

import java.util.Comparator;
import org.junit.runner.Description;
import org.junit.runner.f;
import org.junit.runner.g;
import org.junit.runner.manipulation.d;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class c extends f {

    /* renamed from: a, reason: collision with root package name */
    private final f f43054a;

    /* renamed from: b, reason: collision with root package name */
    private final Comparator<Description> f43055b;

    @Override // org.junit.runner.f
    public g h() {
        g h6 = this.f43054a.h();
        new d(this.f43055b).a(h6);
        return h6;
    }

    public c(f fVar, Comparator<Description> comparator) {
        this.f43054a = fVar;
        this.f43055b = comparator;
    }
}
