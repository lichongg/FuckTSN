package rx.observers;

import androidx.camera.view.p;
import java.util.concurrent.atomic.AtomicReference;
import rx.m;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public abstract class b implements rx.d, m {

    /* renamed from: b, reason: collision with root package name */
    static final a f54394b = new a();

    /* renamed from: a, reason: collision with root package name */
    private final AtomicReference<m> f54395a = new AtomicReference<>();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a implements m {
        @Override // rx.m
        public boolean isUnsubscribed() {
            return true;
        }

        a() {
        }

        @Override // rx.m
        public void unsubscribe() {
        }
    }

    @Override // rx.d
    public final void a(m mVar) {
        if (p.a(this.f54395a, null, mVar)) {
            onStart();
            return;
        }
        mVar.unsubscribe();
        if (this.f54395a.get() != f54394b) {
            rx.plugins.c.I(new IllegalStateException("Subscription already set!"));
        }
    }

    protected final void b() {
        this.f54395a.set(f54394b);
    }

    @Override // rx.m
    public final boolean isUnsubscribed() {
        return this.f54395a.get() == f54394b;
    }

    @Override // rx.m
    public final void unsubscribe() {
        m andSet;
        m mVar = this.f54395a.get();
        a aVar = f54394b;
        if (mVar == aVar || (andSet = this.f54395a.getAndSet(aVar)) == null || andSet == aVar) {
            return;
        }
        andSet.unsubscribe();
    }

    protected void onStart() {
    }
}
