package kotlinx.coroutines;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ExperimentalStdlibApi;
import kotlin.coroutines.f;
import kotlin.coroutines.i;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class m0 extends kotlin.coroutines.a implements kotlin.coroutines.f {

    @NotNull
    public static final a Key = new a(null);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @ExperimentalStdlibApi
    public static final class a extends kotlin.coroutines.b<kotlin.coroutines.f, m0> {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: kotlinx.coroutines.m0$a$a, reason: collision with other inner class name */
        static final class C0955a extends Lambda implements Function1<i.b, m0> {

            /* renamed from: a, reason: collision with root package name */
            public static final C0955a f49381a = new C0955a();

            C0955a() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final m0 invoke(@NotNull i.b bVar) {
                if (bVar instanceof m0) {
                    return (m0) bVar;
                }
                return null;
            }
        }

        public /* synthetic */ a(kotlin.jvm.internal.v vVar) {
            this();
        }

        private a() {
            super(kotlin.coroutines.f.f43765o0, C0955a.f49381a);
        }
    }

    public abstract void dispatch(@NotNull kotlin.coroutines.i iVar, @NotNull Runnable runnable);

    public boolean isDispatchNeeded(@NotNull kotlin.coroutines.i iVar) {
        return true;
    }

    public m0() {
        super(kotlin.coroutines.f.f43765o0);
    }

    @Override // kotlin.coroutines.f
    @NotNull
    public final <T> kotlin.coroutines.e<T> interceptContinuation(@NotNull kotlin.coroutines.e<? super T> eVar) {
        return new kotlinx.coroutines.internal.l(this, eVar);
    }

    @Override // kotlin.coroutines.f
    public final void releaseInterceptedContinuation(@NotNull kotlin.coroutines.e<?> eVar) {
        kotlin.jvm.internal.g0.n(eVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        ((kotlinx.coroutines.internal.l) eVar).t();
    }

    @NotNull
    public String toString() {
        return u0.a(this) + '@' + u0.b(this);
    }

    @InternalCoroutinesApi
    public void dispatchYield(@NotNull kotlin.coroutines.i iVar, @NotNull Runnable runnable) {
        dispatch(iVar, runnable);
    }

    @Override // kotlin.coroutines.a, kotlin.coroutines.i.b, kotlin.coroutines.i
    @Nullable
    public <E extends i.b> E get(@NotNull i.c<E> cVar) {
        return (E) f.a.b(this, cVar);
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public m0 limitedParallelism(int i6) {
        kotlinx.coroutines.internal.t.a(i6);
        return new kotlinx.coroutines.internal.s(this, i6);
    }

    @Override // kotlin.coroutines.a, kotlin.coroutines.i.b, kotlin.coroutines.i
    @NotNull
    public kotlin.coroutines.i minusKey(@NotNull i.c<?> cVar) {
        return f.a.c(this, cVar);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Operator '+' on two CoroutineDispatcher objects is meaningless. CoroutineDispatcher is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The dispatcher to the right of `+` just replaces the dispatcher to the left.")
    @NotNull
    public final m0 plus(@NotNull m0 m0Var) {
        return m0Var;
    }
}
