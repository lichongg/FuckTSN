package rx.internal.operators;

import rx.b;
import rx.exceptions.AssemblyStackTraceException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class t0<T> implements b.j0 {

    /* renamed from: c, reason: collision with root package name */
    public static volatile boolean f53518c;

    /* renamed from: a, reason: collision with root package name */
    final b.j0 f53519a;

    /* renamed from: b, reason: collision with root package name */
    final String f53520b = s0.a();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a implements rx.d {

        /* renamed from: a, reason: collision with root package name */
        final rx.d f53521a;

        /* renamed from: b, reason: collision with root package name */
        final String f53522b;

        @Override // rx.d
        public void a(rx.m mVar) {
            this.f53521a.a(mVar);
        }

        @Override // rx.d
        public void onCompleted() {
            this.f53521a.onCompleted();
        }

        @Override // rx.d
        public void onError(Throwable th) {
            new AssemblyStackTraceException(this.f53522b).attachTo(th);
            this.f53521a.onError(th);
        }

        public a(rx.d dVar, String str) {
            this.f53521a = dVar;
            this.f53522b = str;
        }
    }

    @Override // rx.functions.b
    public void call(rx.d dVar) {
        this.f53519a.call(new a(dVar, this.f53520b));
    }

    public t0(b.j0 j0Var) {
        this.f53519a = j0Var;
    }
}
