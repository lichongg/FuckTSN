package kotlin.coroutines;

import kotlin.SinceKotlin;
import kotlin.coroutines.f;
import kotlin.coroutines.i;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SinceKotlin(version = "1.3")
/* loaded from: D:\Downloads\app\classes8.dex */
public interface i {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        @NotNull
        public static i b(@NotNull i iVar, @NotNull i context) {
            g0.p(context, "context");
            return context == EmptyCoroutineContext.INSTANCE ? iVar : (i) context.fold(iVar, new Function2() { // from class: kotlin.coroutines.h
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    i c6;
                    c6 = i.a.c((i) obj, (i.b) obj2);
                    return c6;
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static i c(i acc, b element) {
            g0.p(acc, "acc");
            g0.p(element, "element");
            i minusKey = acc.minusKey(element.getKey());
            EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
            if (minusKey == emptyCoroutineContext) {
                return element;
            }
            f.b bVar = f.f43765o0;
            f fVar = (f) minusKey.get(bVar);
            if (fVar == null) {
                return new CombinedContext(minusKey, element);
            }
            i minusKey2 = minusKey.minusKey(bVar);
            return minusKey2 == emptyCoroutineContext ? new CombinedContext(element, fVar) : new CombinedContext(new CombinedContext(minusKey2, element), fVar);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface b extends i {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static final class a {
            public static <R> R a(@NotNull b bVar, R r5, @NotNull Function2<? super R, ? super b, ? extends R> operation) {
                g0.p(operation, "operation");
                return operation.invoke(r5, bVar);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Nullable
            public static <E extends b> E b(@NotNull b bVar, @NotNull c<E> key) {
                g0.p(key, "key");
                if (!g0.g(bVar.getKey(), key)) {
                    return null;
                }
                g0.n(bVar, "null cannot be cast to non-null type E of kotlin.coroutines.CoroutineContext.Element.get");
                return bVar;
            }

            @NotNull
            public static i c(@NotNull b bVar, @NotNull c<?> key) {
                g0.p(key, "key");
                return g0.g(bVar.getKey(), key) ? EmptyCoroutineContext.INSTANCE : bVar;
            }

            @NotNull
            public static i d(@NotNull b bVar, @NotNull i context) {
                g0.p(context, "context");
                return a.b(bVar, context);
            }
        }

        @Override // kotlin.coroutines.i
        <R> R fold(R r5, @NotNull Function2<? super R, ? super b, ? extends R> function2);

        @Override // kotlin.coroutines.i
        @Nullable
        <E extends b> E get(@NotNull c<E> cVar);

        @NotNull
        c<?> getKey();

        @Override // kotlin.coroutines.i
        @NotNull
        i minusKey(@NotNull c<?> cVar);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface c<E extends b> {
    }

    <R> R fold(R r5, @NotNull Function2<? super R, ? super b, ? extends R> function2);

    @Nullable
    <E extends b> E get(@NotNull c<E> cVar);

    @NotNull
    i minusKey(@NotNull c<?> cVar);

    @NotNull
    i plus(@NotNull i iVar);
}
