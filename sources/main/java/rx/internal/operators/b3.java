package rx.internal.operators;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class b3 {

    /* renamed from: a, reason: collision with root package name */
    static final Object f52589a = new Object();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a implements rx.functions.q<Object, Object, Boolean> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.functions.q f52590a;

        a(rx.functions.q qVar) {
            this.f52590a = qVar;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // rx.functions.q
        public Boolean call(Object obj, Object obj2) {
            Object obj3 = b3.f52589a;
            boolean z5 = obj == obj3;
            boolean z6 = obj2 == obj3;
            return (z5 && z6) ? Boolean.TRUE : (z5 || z6) ? Boolean.FALSE : (Boolean) this.f52590a.call(obj, obj2);
        }
    }

    static <T> rx.e<Object> a(rx.e<T> eVar) {
        return rx.e.v0(eVar, rx.e.M2(f52589a));
    }

    private b3() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> rx.e<Boolean> b(rx.e<? extends T> eVar, rx.e<? extends T> eVar2, rx.functions.q<? super T, ? super T, Boolean> qVar) {
        return rx.e.r7(a(eVar), a(eVar2), new a(qVar)).d(rx.internal.util.n.c());
    }
}
