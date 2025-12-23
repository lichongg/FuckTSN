package kotlinx.coroutines.flow;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.u0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final /* synthetic */ class q {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final Function1<Object, Object> f49144a = b.f49147a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final Function2<Object, Object, Boolean> f49145b = a.f49146a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a extends Lambda implements Function2<Object, Object, Boolean> {

        /* renamed from: a, reason: collision with root package name */
        public static final a f49146a = new a();

        a() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(@Nullable Object obj, @Nullable Object obj2) {
            return Boolean.valueOf(kotlin.jvm.internal.g0.g(obj, obj2));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <T> i<T> a(@NotNull i<? extends T> iVar) {
        return iVar instanceof h0 ? iVar : d(iVar, f49144a, f49145b);
    }

    @NotNull
    public static final <T> i<T> b(@NotNull i<? extends T> iVar, @NotNull Function2<? super T, ? super T, Boolean> function2) {
        Function1<Object, Object> function1 = f49144a;
        kotlin.jvm.internal.g0.n(function2, "null cannot be cast to non-null type kotlin.Function2<kotlin.Any?, kotlin.Any?, kotlin.Boolean>");
        return d(iVar, function1, (Function2) u0.q(function2, 2));
    }

    @NotNull
    public static final <T, K> i<T> c(@NotNull i<? extends T> iVar, @NotNull Function1<? super T, ? extends K> function1) {
        return d(iVar, function1, f49145b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T> i<T> d(i<? extends T> iVar, Function1<? super T, ? extends Object> function1, Function2<Object, Object, Boolean> function2) {
        if (iVar instanceof g) {
            g gVar = (g) iVar;
            if (gVar.f48873b == function1 && gVar.f48874c == function2) {
                return iVar;
            }
        }
        return new g(iVar, function1, function2);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class b extends Lambda implements Function1<Object, Object> {

        /* renamed from: a, reason: collision with root package name */
        public static final b f49147a = new b();

        b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        @Nullable
        public final Object invoke(@Nullable Object obj) {
            return obj;
        }
    }
}
