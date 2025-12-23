package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.CompletableFuture;
import javax.annotation.Nullable;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import retrofit2.c;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@IgnoreJRERequirement
/* loaded from: D:\Downloads\app\classes7.dex */
final class f extends c.a {

    /* renamed from: a, reason: collision with root package name */
    static final c.a f52115a = new f();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @IgnoreJRERequirement
    private static final class a<R> implements retrofit2.c<R, CompletableFuture<R>> {

        /* renamed from: a, reason: collision with root package name */
        private final Type f52116a;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @IgnoreJRERequirement
        /* renamed from: retrofit2.f$a$a, reason: collision with other inner class name */
        private class C1009a implements d<R> {

            /* renamed from: a, reason: collision with root package name */
            private final CompletableFuture<R> f52117a;

            public C1009a(CompletableFuture<R> completableFuture) {
                this.f52117a = completableFuture;
            }

            @Override // retrofit2.d
            public void a(retrofit2.b<R> bVar, Throwable th) {
                this.f52117a.completeExceptionally(th);
            }

            @Override // retrofit2.d
            public void b(retrofit2.b<R> bVar, c0<R> c0Var) {
                if (c0Var.g()) {
                    this.f52117a.complete(c0Var.a());
                } else {
                    this.f52117a.completeExceptionally(new HttpException(c0Var));
                }
            }
        }

        @Override // retrofit2.c
        public Type a() {
            return this.f52116a;
        }

        @Override // retrofit2.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public CompletableFuture<R> b(retrofit2.b<R> bVar) {
            b bVar2 = new b(bVar);
            bVar.j(new C1009a(bVar2));
            return bVar2;
        }

        a(Type type) {
            this.f52116a = type;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @IgnoreJRERequirement
    private static final class b<T> extends CompletableFuture<T> {

        /* renamed from: a, reason: collision with root package name */
        private final retrofit2.b<?> f52119a;

        @Override // java.util.concurrent.CompletableFuture, java.util.concurrent.Future
        public boolean cancel(boolean z5) {
            if (z5) {
                this.f52119a.cancel();
            }
            return super.cancel(z5);
        }

        b(retrofit2.b<?> bVar) {
            this.f52119a = bVar;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @IgnoreJRERequirement
    private static final class c<R> implements retrofit2.c<R, CompletableFuture<c0<R>>> {

        /* renamed from: a, reason: collision with root package name */
        private final Type f52120a;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @IgnoreJRERequirement
        private class a implements d<R> {

            /* renamed from: a, reason: collision with root package name */
            private final CompletableFuture<c0<R>> f52121a;

            public a(CompletableFuture<c0<R>> completableFuture) {
                this.f52121a = completableFuture;
            }

            @Override // retrofit2.d
            public void a(retrofit2.b<R> bVar, Throwable th) {
                this.f52121a.completeExceptionally(th);
            }

            @Override // retrofit2.d
            public void b(retrofit2.b<R> bVar, c0<R> c0Var) {
                this.f52121a.complete(c0Var);
            }
        }

        @Override // retrofit2.c
        public Type a() {
            return this.f52120a;
        }

        @Override // retrofit2.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public CompletableFuture<c0<R>> b(retrofit2.b<R> bVar) {
            b bVar2 = new b(bVar);
            bVar.j(new a(bVar2));
            return bVar2;
        }

        c(Type type) {
            this.f52120a = type;
        }
    }

    f() {
    }

    @Override // retrofit2.c.a
    @Nullable
    public retrofit2.c<?, ?> a(Type type, Annotation[] annotationArr, d0 d0Var) {
        if (c.a.c(type) != e.a()) {
            return null;
        }
        if (type instanceof ParameterizedType) {
            Type b6 = c.a.b(0, (ParameterizedType) type);
            if (c.a.c(b6) != c0.class) {
                return new a(b6);
            }
            if (b6 instanceof ParameterizedType) {
                return new c(c.a.b(0, (ParameterizedType) b6));
            }
            throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
        }
        throw new IllegalStateException("CompletableFuture return type must be parameterized as CompletableFuture<Foo> or CompletableFuture<? extends Foo>");
    }
}
