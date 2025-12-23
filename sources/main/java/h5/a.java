package h5;

import org.junit.runner.f;
import org.junit.runner.g;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class a extends f {

    /* renamed from: a, reason: collision with root package name */
    private final Object f43048a;

    /* renamed from: b, reason: collision with root package name */
    private final Class<?> f43049b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f43050c;

    /* renamed from: d, reason: collision with root package name */
    private volatile g f43051d;

    public a(Class<?> cls, boolean z5) {
        this.f43048a = new Object();
        this.f43049b = cls;
        this.f43050c = z5;
    }

    @Override // org.junit.runner.f
    public g h() {
        if (this.f43051d == null) {
            synchronized (this.f43048a) {
                try {
                    if (this.f43051d == null) {
                        this.f43051d = new org.junit.internal.builders.a(this.f43050c).g(this.f43049b);
                    }
                } finally {
                }
            }
        }
        return this.f43051d;
    }

    public a(Class<?> cls) {
        this(cls, true);
    }
}
