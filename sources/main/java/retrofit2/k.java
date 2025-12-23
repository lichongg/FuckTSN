package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import okhttp3.Call;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.f0;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
abstract class k<ResponseT, ReturnT> extends e0<ReturnT> {

    /* renamed from: a, reason: collision with root package name */
    private final b0 f52144a;

    /* renamed from: b, reason: collision with root package name */
    private final Call.Factory f52145b;

    /* renamed from: c, reason: collision with root package name */
    private final g<ResponseBody, ResponseT> f52146c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a<ResponseT, ReturnT> extends k<ResponseT, ReturnT> {

        /* renamed from: d, reason: collision with root package name */
        private final retrofit2.c<ResponseT, ReturnT> f52147d;

        @Override // retrofit2.k
        protected ReturnT c(retrofit2.b<ResponseT> bVar, Object[] objArr) {
            return this.f52147d.b(bVar);
        }

        a(b0 b0Var, Call.Factory factory, g<ResponseBody, ResponseT> gVar, retrofit2.c<ResponseT, ReturnT> cVar) {
            super(b0Var, factory, gVar);
            this.f52147d = cVar;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class b<ResponseT> extends k<ResponseT, Object> {

        /* renamed from: d, reason: collision with root package name */
        private final retrofit2.c<ResponseT, retrofit2.b<ResponseT>> f52148d;

        /* renamed from: e, reason: collision with root package name */
        private final boolean f52149e;

        @Override // retrofit2.k
        protected Object c(retrofit2.b<ResponseT> bVar, Object[] objArr) {
            retrofit2.b<ResponseT> b6 = this.f52148d.b(bVar);
            kotlin.coroutines.e eVar = (kotlin.coroutines.e) objArr[objArr.length - 1];
            try {
                return this.f52149e ? m.b(b6, eVar) : m.a(b6, eVar);
            } catch (Exception e6) {
                return m.e(e6, eVar);
            }
        }

        b(b0 b0Var, Call.Factory factory, g<ResponseBody, ResponseT> gVar, retrofit2.c<ResponseT, retrofit2.b<ResponseT>> cVar, boolean z5) {
            super(b0Var, factory, gVar);
            this.f52148d = cVar;
            this.f52149e = z5;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class c<ResponseT> extends k<ResponseT, Object> {

        /* renamed from: d, reason: collision with root package name */
        private final retrofit2.c<ResponseT, retrofit2.b<ResponseT>> f52150d;

        @Override // retrofit2.k
        protected Object c(retrofit2.b<ResponseT> bVar, Object[] objArr) {
            retrofit2.b<ResponseT> b6 = this.f52150d.b(bVar);
            kotlin.coroutines.e eVar = (kotlin.coroutines.e) objArr[objArr.length - 1];
            try {
                return m.c(b6, eVar);
            } catch (Exception e6) {
                return m.e(e6, eVar);
            }
        }

        c(b0 b0Var, Call.Factory factory, g<ResponseBody, ResponseT> gVar, retrofit2.c<ResponseT, retrofit2.b<ResponseT>> cVar) {
            super(b0Var, factory, gVar);
            this.f52150d = cVar;
        }
    }

    @Nullable
    protected abstract ReturnT c(retrofit2.b<ResponseT> bVar, Object[] objArr);

    static <ResponseT, ReturnT> k<ResponseT, ReturnT> f(d0 d0Var, Method method, b0 b0Var) {
        Type genericReturnType;
        boolean z5;
        boolean z6 = b0Var.f52060k;
        Annotation[] annotations = method.getAnnotations();
        if (z6) {
            Type[] genericParameterTypes = method.getGenericParameterTypes();
            Type f6 = f0.f(0, (ParameterizedType) genericParameterTypes[genericParameterTypes.length - 1]);
            if (f0.h(f6) == c0.class && (f6 instanceof ParameterizedType)) {
                f6 = f0.g(0, (ParameterizedType) f6);
                z5 = true;
            } else {
                z5 = false;
            }
            genericReturnType = new f0.b(null, retrofit2.b.class, f6);
            annotations = SkipCallbackExecutorImpl.ensurePresent(annotations);
        } else {
            genericReturnType = method.getGenericReturnType();
            z5 = false;
        }
        retrofit2.c d6 = d(d0Var, method, genericReturnType, annotations);
        Type a6 = d6.a();
        if (a6 == Response.class) {
            throw f0.m(method, "'" + f0.h(a6).getName() + "' is not a valid response body type. Did you mean ResponseBody?", new Object[0]);
        }
        if (a6 == c0.class) {
            throw f0.m(method, "Response must include generic type (e.g., Response<String>)", new Object[0]);
        }
        if (b0Var.f52052c.equals("HEAD") && !Void.class.equals(a6)) {
            throw f0.m(method, "HEAD method must use Void as response type.", new Object[0]);
        }
        g e6 = e(d0Var, method, a6);
        Call.Factory factory = d0Var.f52098b;
        return !z6 ? new a(b0Var, factory, e6, d6) : z5 ? new c(b0Var, factory, e6, d6) : new b(b0Var, factory, e6, d6, false);
    }

    @Override // retrofit2.e0
    @Nullable
    final ReturnT a(Object[] objArr) {
        return c(new n(this.f52144a, objArr, this.f52145b, this.f52146c), objArr);
    }

    k(b0 b0Var, Call.Factory factory, g<ResponseBody, ResponseT> gVar) {
        this.f52144a = b0Var;
        this.f52145b = factory;
        this.f52146c = gVar;
    }

    private static <ResponseT, ReturnT> retrofit2.c<ResponseT, ReturnT> d(d0 d0Var, Method method, Type type, Annotation[] annotationArr) {
        try {
            return (retrofit2.c<ResponseT, ReturnT>) d0Var.b(type, annotationArr);
        } catch (RuntimeException e6) {
            throw f0.n(method, e6, "Unable to create call adapter for %s", type);
        }
    }

    private static <ResponseT> g<ResponseBody, ResponseT> e(d0 d0Var, Method method, Type type) {
        try {
            return d0Var.n(type, method.getAnnotations());
        } catch (RuntimeException e6) {
            throw f0.n(method, e6, "Unable to create converter for %s", type);
        }
    }
}
