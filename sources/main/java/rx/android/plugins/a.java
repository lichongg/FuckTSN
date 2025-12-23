package rx.android.plugins;

import androidx.camera.view.p;
import java.util.concurrent.atomic.AtomicReference;
import rx.annotations.Experimental;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    private static final a f52250b = new a();

    /* renamed from: a, reason: collision with root package name */
    private final AtomicReference<b> f52251a = new AtomicReference<>();

    public static a a() {
        return f52250b;
    }

    public b b() {
        if (this.f52251a.get() == null) {
            p.a(this.f52251a, null, b.a());
        }
        return this.f52251a.get();
    }

    public void c(b bVar) {
        if (p.a(this.f52251a, null, bVar)) {
            return;
        }
        throw new IllegalStateException("Another strategy was already registered: " + this.f52251a.get());
    }

    @Experimental
    public void d() {
        this.f52251a.set(null);
    }

    a() {
    }
}
