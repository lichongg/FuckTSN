package kotlinx.coroutines.flow.internal;

import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.u0;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final Function3<kotlinx.coroutines.flow.j<Object>, Object, kotlin.coroutines.e<? super n1>, Object> f49032a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* synthetic */ class a extends FunctionReferenceImpl implements Function3<kotlinx.coroutines.flow.j<? super Object>, Object, kotlin.coroutines.e<? super n1>, Object>, kotlin.coroutines.jvm.internal.k {

        /* renamed from: a, reason: collision with root package name */
        public static final a f49033a = new a();

        a() {
            super(3, kotlinx.coroutines.flow.j.class, "emit", "emit(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Object invoke(@NotNull kotlinx.coroutines.flow.j<Object> jVar, @Nullable Object obj, @NotNull kotlin.coroutines.e<? super n1> eVar) {
            return jVar.emit(obj, eVar);
        }
    }

    static {
        a aVar = a.f49033a;
        g0.n(aVar, "null cannot be cast to non-null type kotlin.Function3<kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>, kotlin.Any?, kotlin.coroutines.Continuation<kotlin.Unit>, kotlin.Any?>");
        f49032a = (Function3) u0.q(aVar, 3);
    }

    private static /* synthetic */ void b() {
    }
}
