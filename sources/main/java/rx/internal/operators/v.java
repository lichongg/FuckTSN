package rx.internal.operators;

import java.io.Serializable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f53594a = new a();

    /* renamed from: b, reason: collision with root package name */
    private static final Object f53595b = new b();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a implements Serializable {
        private static final long serialVersionUID = 1;

        public String toString() {
            return "Notification=>Completed";
        }

        a() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class b implements Serializable {
        private static final long serialVersionUID = 2;

        public String toString() {
            return "Notification=>NULL";
        }

        b() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class c implements Serializable {
        private static final long serialVersionUID = 3;

        /* renamed from: a, reason: collision with root package name */
        final Throwable f53596a;

        public String toString() {
            return "Notification=>Error:" + this.f53596a;
        }

        public c(Throwable th) {
            this.f53596a = th;
        }
    }

    public static <T> boolean a(rx.f<? super T> fVar, Object obj) {
        if (obj == f53594a) {
            fVar.onCompleted();
            return true;
        }
        if (obj == f53595b) {
            fVar.onNext(null);
            return false;
        }
        if (obj == null) {
            throw new IllegalArgumentException("The lite notification can not be null");
        }
        if (obj.getClass() == c.class) {
            fVar.onError(((c) obj).f53596a);
            return true;
        }
        fVar.onNext(obj);
        return false;
    }

    public static Object b() {
        return f53594a;
    }

    public static Object c(Throwable th) {
        return new c(th);
    }

    public static Throwable d(Object obj) {
        return ((c) obj).f53596a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T e(Object obj) {
        if (obj == f53595b) {
            return null;
        }
        return obj;
    }

    public static boolean f(Object obj) {
        return obj == f53594a;
    }

    public static boolean g(Object obj) {
        return obj instanceof c;
    }

    public static boolean h(Object obj) {
        return (obj == null || g(obj) || f(obj)) ? false : true;
    }

    public static boolean i(Object obj) {
        return obj == f53595b;
    }

    public static <T> Object j(T t5) {
        return t5 == null ? f53595b : t5;
    }

    private v() {
    }
}
