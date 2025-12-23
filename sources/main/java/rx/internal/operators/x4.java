package rx.internal.operators;

import rx.i;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class x4<T> implements i.t<T> {

    /* renamed from: a, reason: collision with root package name */
    private final rx.i<? extends T> f53816a;

    /* renamed from: b, reason: collision with root package name */
    final rx.functions.p<Throwable, ? extends rx.i<? extends T>> f53817b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a implements rx.functions.p<Throwable, rx.i<? extends T>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.i f53818a;

        a(rx.i iVar) {
            this.f53818a = iVar;
        }

        @Override // rx.functions.p
        public rx.i<? extends T> call(Throwable th) {
            return this.f53818a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends rx.k<T> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ rx.k f53819b;

        b(rx.k kVar) {
            this.f53819b = kVar;
        }

        @Override // rx.k
        public void d(T t5) {
            this.f53819b.d(t5);
        }

        @Override // rx.k
        public void onError(Throwable th) {
            try {
                x4.this.f53817b.call(th).j0(this.f53819b);
            } catch (Throwable th2) {
                rx.exceptions.a.h(th2, this.f53819b);
            }
        }
    }

    public static <T> x4<T> a(rx.i<? extends T> iVar, rx.functions.p<Throwable, ? extends rx.i<? extends T>> pVar) {
        return new x4<>(iVar, pVar);
    }

    public static <T> x4<T> b(rx.i<? extends T> iVar, rx.i<? extends T> iVar2) {
        if (iVar2 != null) {
            return new x4<>(iVar, new a(iVar2));
        }
        throw new NullPointerException("resumeSingleInCaseOfError must not be null");
    }

    @Override // rx.functions.b
    public void call(rx.k<? super T> kVar) {
        b bVar = new b(kVar);
        kVar.b(bVar);
        this.f53816a.j0(bVar);
    }

    private x4(rx.i<? extends T> iVar, rx.functions.p<Throwable, ? extends rx.i<? extends T>> pVar) {
        if (iVar != null) {
            if (pVar != null) {
                this.f53816a = iVar;
                this.f53817b = pVar;
                return;
            }
            throw new NullPointerException("resumeFunctionInCaseOfError must not be null");
        }
        throw new NullPointerException("originalSingle must not be null");
    }
}
