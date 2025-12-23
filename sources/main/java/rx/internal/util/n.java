package rx.internal.util;

import rx.functions.p;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public final class n {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    enum a implements p<Object, Boolean> {
        INSTANCE;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // rx.functions.p
        public Boolean call(Object obj) {
            return Boolean.FALSE;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    enum b implements p<Object, Boolean> {
        INSTANCE;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // rx.functions.p
        public Boolean call(Object obj) {
            return Boolean.TRUE;
        }
    }

    public static <T> p<? super T, Boolean> a() {
        return a.INSTANCE;
    }

    public static <T> p<? super T, Boolean> b() {
        return b.INSTANCE;
    }

    public static <T> p<T, T> c() {
        return c.INSTANCE;
    }

    private n() {
        throw new IllegalStateException("No instances!");
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    enum c implements p<Object, Object> {
        INSTANCE;

        @Override // rx.functions.p
        public Object call(Object obj) {
            return obj;
        }
    }
}
