package kotlinx.coroutines.flow.internal;

import kotlin.BuilderInference;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.g0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import kotlinx.coroutines.r0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nFlowCoroutine.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FlowCoroutine.kt\nkotlinx/coroutines/flow/internal/FlowCoroutineKt\n+ 2 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,63:1\n107#2:64\n*S KotlinDebug\n*F\n+ 1 FlowCoroutine.kt\nkotlinx/coroutines/flow/internal/FlowCoroutineKt\n*L\n50#1:64\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class n {

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 FlowCoroutine.kt\nkotlinx/coroutines/flow/internal/FlowCoroutineKt\n*L\n1#1,113:1\n51#2,2:114\n*E\n"})
    public static final class a<R> implements kotlinx.coroutines.flow.i<R> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function3 f49021a;

        public a(Function3 function3) {
            this.f49021a = function3;
        }

        @Override // kotlinx.coroutines.flow.i
        @Nullable
        public Object collect(@NotNull kotlinx.coroutines.flow.j<? super R> jVar, @NotNull kotlin.coroutines.e<? super n1> eVar) {
            Object a6 = n.a(new b(this.f49021a, jVar, null), eVar);
            return a6 == kotlin.coroutines.intrinsics.a.l() ? a6 : n1.f44123a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.flow.internal.FlowCoroutineKt$scopedFlow$1$1", f = "FlowCoroutine.kt", i = {}, l = {51}, m = "invokeSuspend", n = {}, s = {})
    static final class b extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f49022a;

        /* renamed from: b, reason: collision with root package name */
        private /* synthetic */ Object f49023b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Function3<r0, kotlinx.coroutines.flow.j<? super R>, kotlin.coroutines.e<? super n1>, Object> f49024c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.j<R> f49025d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        b(Function3<? super r0, ? super kotlinx.coroutines.flow.j<? super R>, ? super kotlin.coroutines.e<? super n1>, ? extends Object> function3, kotlinx.coroutines.flow.j<? super R> jVar, kotlin.coroutines.e<? super b> eVar) {
            super(2, eVar);
            this.f49024c = function3;
            this.f49025d = jVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.e<n1> create(@Nullable Object obj, @NotNull kotlin.coroutines.e<?> eVar) {
            b bVar = new b(this.f49024c, this.f49025d, eVar);
            bVar.f49023b = obj;
            return bVar;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull r0 r0Var, @Nullable kotlin.coroutines.e<? super n1> eVar) {
            return ((b) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f49022a;
            if (i6 != 0) {
                if (i6 == 1) {
                    g0.n(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                g0.n(obj);
                r0 r0Var = (r0) this.f49023b;
                Function3<r0, kotlinx.coroutines.flow.j<? super R>, kotlin.coroutines.e<? super n1>, Object> function3 = this.f49024c;
                Object obj2 = this.f49025d;
                this.f49022a = 1;
                if (function3.invoke(r0Var, obj2, this) == l6) {
                    return l6;
                }
            }
            return n1.f44123a;
        }
    }

    @Nullable
    public static final <R> Object a(@BuilderInference @NotNull Function2<? super r0, ? super kotlin.coroutines.e<? super R>, ? extends Object> function2, @NotNull kotlin.coroutines.e<? super R> eVar) {
        m mVar = new m(eVar.getContext(), eVar);
        Object e6 = o4.b.e(mVar, mVar, function2);
        if (e6 == kotlin.coroutines.intrinsics.a.l()) {
            kotlin.coroutines.jvm.internal.e.c(eVar);
        }
        return e6;
    }

    @NotNull
    public static final <R> kotlinx.coroutines.flow.i<R> b(@BuilderInference @NotNull Function3<? super r0, ? super kotlinx.coroutines.flow.j<? super R>, ? super kotlin.coroutines.e<? super n1>, ? extends Object> function3) {
        return new a(function3);
    }
}
