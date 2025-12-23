package rx;

import rx.exceptions.MissingBackpressureException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final d f52235a;

    /* renamed from: b, reason: collision with root package name */
    public static final d f52236b;

    /* renamed from: c, reason: collision with root package name */
    public static final d f52237c;

    /* renamed from: d, reason: collision with root package name */
    public static final d f52238d;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class c implements d {

        /* renamed from: a, reason: collision with root package name */
        static final c f52241a = new c();

        @Override // rx.a.d
        public boolean a() throws MissingBackpressureException {
            throw new MissingBackpressureException("Overflowed buffer");
        }

        private c() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface d {
        boolean a() throws MissingBackpressureException;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: rx.a$a, reason: collision with other inner class name */
    static final class C1011a implements d {

        /* renamed from: a, reason: collision with root package name */
        static final C1011a f52239a = new C1011a();

        @Override // rx.a.d
        public boolean a() {
            return false;
        }

        private C1011a() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class b implements d {

        /* renamed from: a, reason: collision with root package name */
        static final b f52240a = new b();

        @Override // rx.a.d
        public boolean a() {
            return true;
        }

        private b() {
        }
    }

    static {
        c cVar = c.f52241a;
        f52235a = cVar;
        f52236b = cVar;
        f52237c = b.f52240a;
        f52238d = C1011a.f52239a;
    }

    private a() {
        throw new IllegalStateException("No instances!");
    }
}
