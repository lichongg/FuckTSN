package kotlinx.coroutines.flow.internal;

import kotlin.Result;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.i;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import kotlinx.coroutines.h2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nSafeCollector.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.kt\nkotlinx/coroutines/flow/internal/SafeCollector\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,156:1\n1#2:157\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class SafeCollector<T> extends ContinuationImpl implements kotlinx.coroutines.flow.j<T>, kotlin.coroutines.jvm.internal.c {

    @JvmField
    @NotNull
    public final kotlin.coroutines.i collectContext;

    @JvmField
    public final int collectContextSize;

    @JvmField
    @NotNull
    public final kotlinx.coroutines.flow.j<T> collector;

    @Nullable
    private kotlin.coroutines.e<? super n1> completion;

    @Nullable
    private kotlin.coroutines.i lastEmissionContext;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a extends Lambda implements Function2<Integer, i.b, Integer> {

        /* renamed from: a, reason: collision with root package name */
        public static final a f48900a = new a();

        a() {
            super(2);
        }

        @NotNull
        public final Integer a(int i6, @NotNull i.b bVar) {
            return Integer.valueOf(i6 + 1);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Integer invoke(Integer num, i.b bVar) {
            return a(num.intValue(), bVar);
        }
    }

    @Override // kotlinx.coroutines.flow.j
    @Nullable
    public Object emit(T t5, @NotNull kotlin.coroutines.e<? super n1> eVar) {
        try {
            Object emit = emit(eVar, (kotlin.coroutines.e<? super n1>) t5);
            if (emit == kotlin.coroutines.intrinsics.a.l()) {
                kotlin.coroutines.jvm.internal.e.c(eVar);
            }
            return emit == kotlin.coroutines.intrinsics.a.l() ? emit : n1.f44123a;
        } catch (Throwable th) {
            this.lastEmissionContext = new l(th, eVar.getContext());
            throw th;
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl, kotlin.coroutines.jvm.internal.c
    @Nullable
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SafeCollector(@NotNull kotlinx.coroutines.flow.j<? super T> jVar, @NotNull kotlin.coroutines.i iVar) {
        super(q.f49026a, EmptyCoroutineContext.INSTANCE);
        this.collector = jVar;
        this.collectContext = iVar;
        this.collectContextSize = ((Number) iVar.fold(0, a.f48900a)).intValue();
    }

    private final void checkContext(kotlin.coroutines.i iVar, kotlin.coroutines.i iVar2, T t5) {
        if (iVar2 instanceof l) {
            exceptionTransparencyViolated((l) iVar2, t5);
        }
        SafeCollector_commonKt.a(this, iVar);
    }

    private final void exceptionTransparencyViolated(l lVar, Object obj) {
        throw new IllegalStateException(kotlin.text.u.v("\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception " + lVar.f49019a + ", but then emission attempt of value '" + obj + "' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ").toString());
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl, kotlin.coroutines.jvm.internal.c
    @Nullable
    public kotlin.coroutines.jvm.internal.c getCallerFrame() {
        kotlin.coroutines.e<? super n1> eVar = this.completion;
        if (eVar instanceof kotlin.coroutines.jvm.internal.c) {
            return (kotlin.coroutines.jvm.internal.c) eVar;
        }
        return null;
    }

    @Override // kotlin.coroutines.jvm.internal.ContinuationImpl, kotlin.coroutines.e
    @NotNull
    public kotlin.coroutines.i getContext() {
        kotlin.coroutines.i iVar = this.lastEmissionContext;
        return iVar == null ? EmptyCoroutineContext.INSTANCE : iVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public Object invokeSuspend(@NotNull Object obj) {
        Throwable m133exceptionOrNullimpl = Result.m133exceptionOrNullimpl(obj);
        if (m133exceptionOrNullimpl != null) {
            this.lastEmissionContext = new l(m133exceptionOrNullimpl, getContext());
        }
        kotlin.coroutines.e<? super n1> eVar = this.completion;
        if (eVar != null) {
            eVar.resumeWith(obj);
        }
        return kotlin.coroutines.intrinsics.a.l();
    }

    @Override // kotlin.coroutines.jvm.internal.ContinuationImpl, kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public void releaseIntercepted() {
        super.releaseIntercepted();
    }

    private final Object emit(kotlin.coroutines.e<? super n1> eVar, T t5) {
        Function3 function3;
        kotlin.coroutines.i context = eVar.getContext();
        h2.z(context);
        kotlin.coroutines.i iVar = this.lastEmissionContext;
        if (iVar != context) {
            checkContext(context, iVar, t5);
            this.lastEmissionContext = context;
        }
        this.completion = eVar;
        function3 = t.f49032a;
        kotlinx.coroutines.flow.j<T> jVar = this.collector;
        g0.n(jVar, "null cannot be cast to non-null type kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>");
        g0.n(this, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Unit>");
        Object invoke = function3.invoke(jVar, t5, this);
        if (!g0.g(invoke, kotlin.coroutines.intrinsics.a.l())) {
            this.completion = null;
        }
        return invoke;
    }
}
