package kotlin;

import kotlin.Result;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class k<T, R> extends j<T, R> implements kotlin.coroutines.e<R> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private Function3<? super j<?, ?>, Object, ? super kotlin.coroutines.e<Object>, ? extends Object> f44100a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private Object f44101b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    private kotlin.coroutines.e<Object> f44102c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private Object f44103d;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nContinuation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Continuation.kt\nkotlin/coroutines/ContinuationKt$Continuation$1\n+ 2 DeepRecursive.kt\nkotlin/DeepRecursiveScopeImpl\n*L\n1#1,161:1\n182#2,6:162\n*E\n"})
    public static final class a implements kotlin.coroutines.e<Object> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlin.coroutines.i f44104a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ k f44105b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Function3 f44106c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ kotlin.coroutines.e f44107d;

        public a(kotlin.coroutines.i iVar, k kVar, Function3 function3, kotlin.coroutines.e eVar) {
            this.f44104a = iVar;
            this.f44105b = kVar;
            this.f44106c = function3;
            this.f44107d = eVar;
        }

        @Override // kotlin.coroutines.e
        public kotlin.coroutines.i getContext() {
            return this.f44104a;
        }

        @Override // kotlin.coroutines.e
        public void resumeWith(Object obj) {
            this.f44105b.f44100a = this.f44106c;
            this.f44105b.f44102c = this.f44107d;
            this.f44105b.f44103d = obj;
        }
    }

    @Override // kotlin.coroutines.e
    public void resumeWith(@NotNull Object obj) {
        this.f44102c = null;
        this.f44103d = obj;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public k(@NotNull Function3<? super j<T, R>, ? super T, ? super kotlin.coroutines.e<? super R>, ? extends Object> block, T t5) {
        super(null);
        Object obj;
        kotlin.jvm.internal.g0.p(block, "block");
        this.f44100a = block;
        this.f44101b = t5;
        kotlin.jvm.internal.g0.n(this, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        this.f44102c = this;
        obj = i.f43800a;
        this.f44103d = obj;
    }

    private final kotlin.coroutines.e<Object> i(Function3<? super j<?, ?>, Object, ? super kotlin.coroutines.e<Object>, ? extends Object> function3, kotlin.coroutines.e<Object> eVar) {
        return new a(EmptyCoroutineContext.INSTANCE, this, function3, eVar);
    }

    @Override // kotlin.j
    @Nullable
    public Object b(T t5, @NotNull kotlin.coroutines.e<? super R> eVar) {
        kotlin.jvm.internal.g0.n(eVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        this.f44102c = eVar;
        this.f44101b = t5;
        Object l6 = kotlin.coroutines.intrinsics.a.l();
        if (l6 == kotlin.coroutines.intrinsics.a.l()) {
            kotlin.coroutines.jvm.internal.e.c(eVar);
        }
        return l6;
    }

    @Override // kotlin.coroutines.e
    @NotNull
    public kotlin.coroutines.i getContext() {
        return EmptyCoroutineContext.INSTANCE;
    }

    public final R j() {
        Object obj;
        Object obj2;
        while (true) {
            R r5 = (R) this.f44103d;
            kotlin.coroutines.e<Object> eVar = this.f44102c;
            if (eVar == null) {
                g0.n(r5);
                return r5;
            }
            obj = i.f43800a;
            if (Result.m132equalsimpl0(obj, r5)) {
                try {
                    Function3<? super j<?, ?>, Object, ? super kotlin.coroutines.e<Object>, ? extends Object> function3 = this.f44100a;
                    Object obj3 = this.f44101b;
                    Object k6 = !(function3 instanceof BaseContinuationImpl) ? kotlin.coroutines.intrinsics.a.k(function3, this, obj3, eVar) : ((Function3) kotlin.jvm.internal.u0.q(function3, 3)).invoke(this, obj3, eVar);
                    if (k6 != kotlin.coroutines.intrinsics.a.l()) {
                        Result.a aVar = Result.Companion;
                        eVar.resumeWith(Result.m130constructorimpl(k6));
                    }
                } catch (Throwable th) {
                    Result.a aVar2 = Result.Companion;
                    eVar.resumeWith(Result.m130constructorimpl(g0.a(th)));
                }
            } else {
                obj2 = i.f43800a;
                this.f44103d = obj2;
                eVar.resumeWith(r5);
            }
        }
    }

    @Override // kotlin.j
    @Nullable
    public <U, S> Object c(@NotNull h<U, S> hVar, U u5, @NotNull kotlin.coroutines.e<? super S> eVar) {
        Function3<j<U, S>, U, kotlin.coroutines.e<? super S>, Object> a6 = hVar.a();
        kotlin.jvm.internal.g0.n(a6, "null cannot be cast to non-null type @[ExtensionFunctionType] kotlin.coroutines.SuspendFunction2<kotlin.DeepRecursiveScope<*, *>, kotlin.Any?, kotlin.Any?>");
        Function3<? super j<?, ?>, Object, ? super kotlin.coroutines.e<Object>, ? extends Object> function3 = this.f44100a;
        if (a6 != function3) {
            this.f44100a = a6;
            kotlin.jvm.internal.g0.n(eVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            this.f44102c = i(function3, eVar);
        } else {
            kotlin.jvm.internal.g0.n(eVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            this.f44102c = eVar;
        }
        this.f44101b = u5;
        Object l6 = kotlin.coroutines.intrinsics.a.l();
        if (l6 == kotlin.coroutines.intrinsics.a.l()) {
            kotlin.coroutines.jvm.internal.e.c(eVar);
        }
        return l6;
    }
}
