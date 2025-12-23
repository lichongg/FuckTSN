package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import okhttp3.Request;
import okio.Timeout;
import retrofit2.c;
import retrofit2.h;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class h extends c.a {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private final Executor f52130a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements c<Object, retrofit2.b<?>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Type f52131a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Executor f52132b;

        a(Type type, Executor executor) {
            this.f52131a = type;
            this.f52132b = executor;
        }

        @Override // retrofit2.c
        public Type a() {
            return this.f52131a;
        }

        @Override // retrofit2.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public retrofit2.b<Object> b(retrofit2.b<Object> bVar) {
            Executor executor = this.f52132b;
            return executor == null ? bVar : new b(executor, bVar);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class b<T> implements retrofit2.b<T> {

        /* renamed from: a, reason: collision with root package name */
        final Executor f52134a;

        /* renamed from: b, reason: collision with root package name */
        final retrofit2.b<T> f52135b;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a implements d<T> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ d f52136a;

            a(d dVar) {
                this.f52136a = dVar;
            }

            public static /* synthetic */ void d(a aVar, d dVar, c0 c0Var) {
                if (b.this.f52135b.isCanceled()) {
                    dVar.a(b.this, new IOException("Canceled"));
                } else {
                    dVar.b(b.this, c0Var);
                }
            }

            @Override // retrofit2.d
            public void a(retrofit2.b<T> bVar, final Throwable th) {
                Executor executor = b.this.f52134a;
                final d dVar = this.f52136a;
                executor.execute(new Runnable() { // from class: retrofit2.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        dVar.a(h.b.this, th);
                    }
                });
            }

            @Override // retrofit2.d
            public void b(retrofit2.b<T> bVar, final c0<T> c0Var) {
                Executor executor = b.this.f52134a;
                final d dVar = this.f52136a;
                executor.execute(new Runnable() { // from class: retrofit2.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        h.b.a.d(h.b.a.this, dVar, c0Var);
                    }
                });
            }
        }

        @Override // retrofit2.b
        public void cancel() {
            this.f52135b.cancel();
        }

        @Override // retrofit2.b
        public retrofit2.b<T> clone() {
            return new b(this.f52134a, this.f52135b.clone());
        }

        @Override // retrofit2.b
        public c0<T> execute() throws IOException {
            return this.f52135b.execute();
        }

        @Override // retrofit2.b
        public boolean isCanceled() {
            return this.f52135b.isCanceled();
        }

        @Override // retrofit2.b
        public boolean isExecuted() {
            return this.f52135b.isExecuted();
        }

        @Override // retrofit2.b
        public void j(d<T> dVar) {
            Objects.requireNonNull(dVar, "callback == null");
            this.f52135b.j(new a(dVar));
        }

        @Override // retrofit2.b
        public Request request() {
            return this.f52135b.request();
        }

        @Override // retrofit2.b
        public Timeout timeout() {
            return this.f52135b.timeout();
        }

        b(Executor executor, retrofit2.b<T> bVar) {
            this.f52134a = executor;
            this.f52135b = bVar;
        }
    }

    h(@Nullable Executor executor) {
        this.f52130a = executor;
    }

    @Override // retrofit2.c.a
    @Nullable
    public c<?, ?> a(Type type, Annotation[] annotationArr, d0 d0Var) {
        Executor executor = null;
        if (c.a.c(type) != retrofit2.b.class) {
            return null;
        }
        if (type instanceof ParameterizedType) {
            Type g6 = f0.g(0, (ParameterizedType) type);
            if (!f0.l(annotationArr, SkipCallbackExecutor.class)) {
                executor = this.f52130a;
            }
            return new a(g6, executor);
        }
        throw new IllegalArgumentException("Call return type must be parameterized as Call<Foo> or Call<? extends Foo>");
    }
}
