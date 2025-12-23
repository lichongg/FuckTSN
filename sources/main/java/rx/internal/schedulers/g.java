package rx.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import rx.h;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class g extends rx.h {

    /* renamed from: a, reason: collision with root package name */
    private final ThreadFactory f54029a;

    @Override // rx.h
    public h.a a() {
        return new h(this.f54029a);
    }

    public g(ThreadFactory threadFactory) {
        this.f54029a = threadFactory;
    }
}
