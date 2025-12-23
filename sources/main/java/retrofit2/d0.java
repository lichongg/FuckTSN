package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.a;
import retrofit2.c;
import retrofit2.g;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class d0 {

    /* renamed from: a, reason: collision with root package name */
    private final Map<Method, e0<?>> f52097a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    final Call.Factory f52098b;

    /* renamed from: c, reason: collision with root package name */
    final HttpUrl f52099c;

    /* renamed from: d, reason: collision with root package name */
    final List<g.a> f52100d;

    /* renamed from: e, reason: collision with root package name */
    final List<c.a> f52101e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    final Executor f52102f;

    /* renamed from: g, reason: collision with root package name */
    final boolean f52103g;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements InvocationHandler {

        /* renamed from: a, reason: collision with root package name */
        private final z f52104a = z.g();

        /* renamed from: b, reason: collision with root package name */
        private final Object[] f52105b = new Object[0];

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Class f52106c;

        a(Class cls) {
            this.f52106c = cls;
        }

        @Override // java.lang.reflect.InvocationHandler
        @Nullable
        public Object invoke(Object obj, Method method, @Nullable Object[] objArr) throws Throwable {
            if (method.getDeclaringClass() == Object.class) {
                return method.invoke(this, objArr);
            }
            if (objArr == null) {
                objArr = this.f52105b;
            }
            if (this.f52104a.i(method)) {
                return this.f52104a.h(method, this.f52106c, obj, objArr);
            }
            return d0.this.h(method).a(objArr);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final z f52108a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        private Call.Factory f52109b;

        /* renamed from: c, reason: collision with root package name */
        @Nullable
        private HttpUrl f52110c;

        /* renamed from: d, reason: collision with root package name */
        private final List<g.a> f52111d;

        /* renamed from: e, reason: collision with root package name */
        private final List<c.a> f52112e;

        /* renamed from: f, reason: collision with root package name */
        @Nullable
        private Executor f52113f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f52114g;

        b(z zVar) {
            this.f52111d = new ArrayList();
            this.f52112e = new ArrayList();
            this.f52108a = zVar;
        }

        public b a(c.a aVar) {
            List<c.a> list = this.f52112e;
            Objects.requireNonNull(aVar, "factory == null");
            list.add(aVar);
            return this;
        }

        public b b(g.a aVar) {
            List<g.a> list = this.f52111d;
            Objects.requireNonNull(aVar, "factory == null");
            list.add(aVar);
            return this;
        }

        public b c(String str) {
            Objects.requireNonNull(str, "baseUrl == null");
            return e(HttpUrl.get(str));
        }

        public b d(URL url) {
            Objects.requireNonNull(url, "baseUrl == null");
            return e(HttpUrl.get(url.toString()));
        }

        public b e(HttpUrl httpUrl) {
            Objects.requireNonNull(httpUrl, "baseUrl == null");
            if ("".equals(httpUrl.pathSegments().get(r0.size() - 1))) {
                this.f52110c = httpUrl;
                return this;
            }
            throw new IllegalArgumentException("baseUrl must end in /: " + httpUrl);
        }

        public d0 f() {
            if (this.f52110c == null) {
                throw new IllegalStateException("Base URL required.");
            }
            Call.Factory factory = this.f52109b;
            if (factory == null) {
                factory = new OkHttpClient();
            }
            Call.Factory factory2 = factory;
            Executor executor = this.f52113f;
            if (executor == null) {
                executor = this.f52108a.c();
            }
            Executor executor2 = executor;
            ArrayList arrayList = new ArrayList(this.f52112e);
            arrayList.addAll(this.f52108a.a(executor2));
            ArrayList arrayList2 = new ArrayList(this.f52111d.size() + 1 + this.f52108a.e());
            arrayList2.add(new retrofit2.a());
            arrayList2.addAll(this.f52111d);
            arrayList2.addAll(this.f52108a.d());
            return new d0(factory2, this.f52110c, Collections.unmodifiableList(arrayList2), Collections.unmodifiableList(arrayList), executor2, this.f52114g);
        }

        public List<c.a> g() {
            return this.f52112e;
        }

        public b h(Call.Factory factory) {
            Objects.requireNonNull(factory, "factory == null");
            this.f52109b = factory;
            return this;
        }

        public b i(Executor executor) {
            Objects.requireNonNull(executor, "executor == null");
            this.f52113f = executor;
            return this;
        }

        public b j(OkHttpClient okHttpClient) {
            Objects.requireNonNull(okHttpClient, "client == null");
            return h(okHttpClient);
        }

        public List<g.a> k() {
            return this.f52111d;
        }

        public b l(boolean z5) {
            this.f52114g = z5;
            return this;
        }

        public b() {
            this(z.g());
        }

        b(d0 d0Var) {
            this.f52111d = new ArrayList();
            this.f52112e = new ArrayList();
            z g6 = z.g();
            this.f52108a = g6;
            this.f52109b = d0Var.f52098b;
            this.f52110c = d0Var.f52099c;
            int size = d0Var.f52100d.size() - g6.e();
            for (int i6 = 1; i6 < size; i6++) {
                this.f52111d.add(d0Var.f52100d.get(i6));
            }
            int size2 = d0Var.f52101e.size() - this.f52108a.b();
            for (int i7 = 0; i7 < size2; i7++) {
                this.f52112e.add(d0Var.f52101e.get(i7));
            }
            this.f52113f = d0Var.f52102f;
            this.f52114g = d0Var.f52103g;
        }
    }

    public c<?, ?> b(Type type, Annotation[] annotationArr) {
        return j(null, type, annotationArr);
    }

    public <T> g<T, RequestBody> m(Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        return k(null, type, annotationArr, annotationArr2);
    }

    public <T> g<ResponseBody, T> n(Type type, Annotation[] annotationArr) {
        return l(null, type, annotationArr);
    }

    public HttpUrl a() {
        return this.f52099c;
    }

    public List<c.a> c() {
        return this.f52101e;
    }

    public Call.Factory d() {
        return this.f52098b;
    }

    @Nullable
    public Executor e() {
        return this.f52102f;
    }

    public List<g.a> f() {
        return this.f52100d;
    }

    e0<?> h(Method method) {
        e0<?> e0Var;
        e0<?> e0Var2 = this.f52097a.get(method);
        if (e0Var2 != null) {
            return e0Var2;
        }
        synchronized (this.f52097a) {
            try {
                e0Var = this.f52097a.get(method);
                if (e0Var == null) {
                    e0Var = e0.b(this, method);
                    this.f52097a.put(method, e0Var);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return e0Var;
    }

    public b i() {
        return new b(this);
    }

    public c<?, ?> j(@Nullable c.a aVar, Type type, Annotation[] annotationArr) {
        Objects.requireNonNull(type, "returnType == null");
        Objects.requireNonNull(annotationArr, "annotations == null");
        int indexOf = this.f52101e.indexOf(aVar) + 1;
        int size = this.f52101e.size();
        for (int i6 = indexOf; i6 < size; i6++) {
            c<?, ?> a6 = this.f52101e.get(i6).a(type, annotationArr, this);
            if (a6 != null) {
                return a6;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate call adapter for ");
        sb.append(type);
        sb.append(".\n");
        if (aVar != null) {
            sb.append("  Skipped:");
            for (int i7 = 0; i7 < indexOf; i7++) {
                sb.append("\n   * ");
                sb.append(this.f52101e.get(i7).getClass().getName());
            }
            sb.append('\n');
        }
        sb.append("  Tried:");
        int size2 = this.f52101e.size();
        while (indexOf < size2) {
            sb.append("\n   * ");
            sb.append(this.f52101e.get(indexOf).getClass().getName());
            indexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    public <T> g<T, RequestBody> k(@Nullable g.a aVar, Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(annotationArr, "parameterAnnotations == null");
        Objects.requireNonNull(annotationArr2, "methodAnnotations == null");
        int indexOf = this.f52100d.indexOf(aVar) + 1;
        int size = this.f52100d.size();
        for (int i6 = indexOf; i6 < size; i6++) {
            g<T, RequestBody> gVar = (g<T, RequestBody>) this.f52100d.get(i6).requestBodyConverter(type, annotationArr, annotationArr2, this);
            if (gVar != null) {
                return gVar;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate RequestBody converter for ");
        sb.append(type);
        sb.append(".\n");
        if (aVar != null) {
            sb.append("  Skipped:");
            for (int i7 = 0; i7 < indexOf; i7++) {
                sb.append("\n   * ");
                sb.append(this.f52100d.get(i7).getClass().getName());
            }
            sb.append('\n');
        }
        sb.append("  Tried:");
        int size2 = this.f52100d.size();
        while (indexOf < size2) {
            sb.append("\n   * ");
            sb.append(this.f52100d.get(indexOf).getClass().getName());
            indexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    public <T> g<ResponseBody, T> l(@Nullable g.a aVar, Type type, Annotation[] annotationArr) {
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(annotationArr, "annotations == null");
        int indexOf = this.f52100d.indexOf(aVar) + 1;
        int size = this.f52100d.size();
        for (int i6 = indexOf; i6 < size; i6++) {
            g<ResponseBody, T> gVar = (g<ResponseBody, T>) this.f52100d.get(i6).responseBodyConverter(type, annotationArr, this);
            if (gVar != null) {
                return gVar;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate ResponseBody converter for ");
        sb.append(type);
        sb.append(".\n");
        if (aVar != null) {
            sb.append("  Skipped:");
            for (int i7 = 0; i7 < indexOf; i7++) {
                sb.append("\n   * ");
                sb.append(this.f52100d.get(i7).getClass().getName());
            }
            sb.append('\n');
        }
        sb.append("  Tried:");
        int size2 = this.f52100d.size();
        while (indexOf < size2) {
            sb.append("\n   * ");
            sb.append(this.f52100d.get(indexOf).getClass().getName());
            indexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    public <T> g<T, String> o(Type type, Annotation[] annotationArr) {
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(annotationArr, "annotations == null");
        int size = this.f52100d.size();
        for (int i6 = 0; i6 < size; i6++) {
            g<T, String> gVar = (g<T, String>) this.f52100d.get(i6).stringConverter(type, annotationArr, this);
            if (gVar != null) {
                return gVar;
            }
        }
        return a.d.f52003a;
    }

    d0(Call.Factory factory, HttpUrl httpUrl, List<g.a> list, List<c.a> list2, @Nullable Executor executor, boolean z5) {
        this.f52098b = factory;
        this.f52099c = httpUrl;
        this.f52100d = list;
        this.f52101e = list2;
        this.f52102f = executor;
        this.f52103g = z5;
    }

    private void p(Class<?> cls) {
        if (cls.isInterface()) {
            ArrayDeque arrayDeque = new ArrayDeque(1);
            arrayDeque.add(cls);
            while (!arrayDeque.isEmpty()) {
                Class<?> cls2 = (Class) arrayDeque.removeFirst();
                if (cls2.getTypeParameters().length != 0) {
                    StringBuilder sb = new StringBuilder("Type parameters are unsupported on ");
                    sb.append(cls2.getName());
                    if (cls2 != cls) {
                        sb.append(" which is an interface of ");
                        sb.append(cls.getName());
                    }
                    throw new IllegalArgumentException(sb.toString());
                }
                Collections.addAll(arrayDeque, cls2.getInterfaces());
            }
            if (this.f52103g) {
                z g6 = z.g();
                for (Method method : cls.getDeclaredMethods()) {
                    if (!g6.i(method) && !Modifier.isStatic(method.getModifiers())) {
                        h(method);
                    }
                }
                return;
            }
            return;
        }
        throw new IllegalArgumentException("API declarations must be interfaces.");
    }

    public <T> T g(Class<T> cls) {
        p(cls);
        return (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new a(cls));
    }
}
