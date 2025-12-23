package kotlinx.coroutines.channels;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.u0;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class v<E> extends kotlinx.coroutines.channels.a<E> {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private kotlin.coroutines.e<? super n1> f48465e;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* synthetic */ class a extends FunctionReferenceImpl implements Function3<v<?>, kotlinx.coroutines.selects.m<?>, Object, n1> {

        /* renamed from: a, reason: collision with root package name */
        public static final a f48466a = new a();

        a() {
            super(3, v.class, "onSendRegFunction", "onSendRegFunction(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ n1 invoke(v<?> vVar, kotlinx.coroutines.selects.m<?> mVar, Object obj) {
            c(vVar, mVar, obj);
            return n1.f44123a;
        }

        public final void c(@NotNull v<?> vVar, @NotNull kotlinx.coroutines.selects.m<?> mVar, @Nullable Object obj) {
            vVar.D1(mVar, obj);
        }
    }

    public v(@NotNull kotlin.coroutines.i iVar, @NotNull j<E> jVar, @NotNull Function2<? super c<E>, ? super kotlin.coroutines.e<? super n1>, ? extends Object> function2) {
        super(iVar, jVar, false);
        this.f48465e = kotlin.coroutines.intrinsics.a.c(function2, this, this);
    }

    @Override // kotlinx.coroutines.l2
    protected void f1() {
        o4.a.c(this.f48465e, this);
    }

    @Override // kotlinx.coroutines.channels.k, kotlinx.coroutines.channels.c0
    @NotNull
    public kotlinx.coroutines.selects.i<E, c0<E>> i() {
        a aVar = a.f48466a;
        g0.n(aVar, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        return new kotlinx.coroutines.selects.j(this, (Function3) u0.q(aVar, 3), super.i().b(), null, 8, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D1(kotlinx.coroutines.selects.m<?> mVar, Object obj) {
        f1();
        super.i().c().invoke(this, mVar, obj);
    }

    @Override // kotlinx.coroutines.channels.k, kotlinx.coroutines.channels.c0
    public boolean S(@Nullable Throwable th) {
        boolean S = super.S(th);
        start();
        return S;
    }

    @Override // kotlinx.coroutines.channels.k, kotlinx.coroutines.channels.c0
    @Nullable
    public Object T(E e6, @NotNull kotlin.coroutines.e<? super n1> eVar) {
        start();
        Object T = super.T(e6, eVar);
        if (T == kotlin.coroutines.intrinsics.a.l()) {
            return T;
        }
        return n1.f44123a;
    }

    @Override // kotlinx.coroutines.channels.k, kotlinx.coroutines.channels.c0
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @ReplaceWith(expression = "trySend(element).isSuccess", imports = {}))
    public boolean offer(E e6) {
        start();
        return super.offer(e6);
    }

    @Override // kotlinx.coroutines.channels.k, kotlinx.coroutines.channels.c0
    @NotNull
    public Object r(E e6) {
        start();
        return super.r(e6);
    }

    public static /* synthetic */ void C1() {
    }
}
