package kotlin.coroutines;

import kotlin.SinceKotlin;
import kotlin.coroutines.i;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SinceKotlin(version = "1.3")
/* loaded from: D:\Downloads\app\classes8.dex */
public interface f extends i.b {

    /* renamed from: o0, reason: collision with root package name */
    @NotNull
    public static final b f43765o0 = b.f43766a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public static <R> R a(@NotNull f fVar, R r5, @NotNull Function2<? super R, ? super i.b, ? extends R> operation) {
            g0.p(operation, "operation");
            return (R) i.b.a.a(fVar, r5, operation);
        }

        @Nullable
        public static <E extends i.b> E b(@NotNull f fVar, @NotNull i.c<E> key) {
            g0.p(key, "key");
            if (!(key instanceof kotlin.coroutines.b)) {
                if (f.f43765o0 != key) {
                    return null;
                }
                g0.n(fVar, "null cannot be cast to non-null type E of kotlin.coroutines.ContinuationInterceptor.get");
                return fVar;
            }
            kotlin.coroutines.b bVar = (kotlin.coroutines.b) key;
            if (bVar.a(fVar.getKey())) {
                E e6 = (E) bVar.b(fVar);
                if (androidx.activity.k.a(e6)) {
                    return e6;
                }
            }
            return null;
        }

        @NotNull
        public static i c(@NotNull f fVar, @NotNull i.c<?> key) {
            g0.p(key, "key");
            if (!(key instanceof kotlin.coroutines.b)) {
                return f.f43765o0 == key ? EmptyCoroutineContext.INSTANCE : fVar;
            }
            kotlin.coroutines.b bVar = (kotlin.coroutines.b) key;
            return (!bVar.a(fVar.getKey()) || bVar.b(fVar) == null) ? fVar : EmptyCoroutineContext.INSTANCE;
        }

        @NotNull
        public static i d(@NotNull f fVar, @NotNull i context) {
            g0.p(context, "context");
            return i.b.a.d(fVar, context);
        }

        public static void e(@NotNull f fVar, @NotNull e<?> continuation) {
            g0.p(continuation, "continuation");
        }
    }

    @Override // kotlin.coroutines.i.b, kotlin.coroutines.i
    @Nullable
    <E extends i.b> E get(@NotNull i.c<E> cVar);

    @NotNull
    <T> e<T> interceptContinuation(@NotNull e<? super T> eVar);

    @Override // kotlin.coroutines.i.b, kotlin.coroutines.i
    @NotNull
    i minusKey(@NotNull i.c<?> cVar);

    void releaseInterceptedContinuation(@NotNull e<?> eVar);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class b implements i.c<f> {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ b f43766a = new b();

        private b() {
        }
    }
}
