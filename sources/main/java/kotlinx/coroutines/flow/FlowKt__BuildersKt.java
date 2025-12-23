package kotlinx.coroutines.flow;

import java.util.Iterator;
import kotlin.BuilderInference;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nBuilders.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Builders.kt\nkotlinx/coroutines/flow/FlowKt__BuildersKt\n+ 2 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,354:1\n107#2:355\n107#2:356\n107#2:357\n107#2:358\n107#2:359\n107#2:360\n107#2:361\n107#2:362\n107#2:363\n107#2:364\n107#2:365\n107#2:366\n*S KotlinDebug\n*F\n+ 1 Builders.kt\nkotlinx/coroutines/flow/FlowKt__BuildersKt\n*L\n68#1:355\n82#1:356\n89#1:357\n98#1:358\n107#1:359\n122#1:360\n131#1:361\n153#1:362\n164#1:363\n175#1:364\n184#1:365\n193#1:366\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
final /* synthetic */ class FlowKt__BuildersKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Builders.kt\nkotlinx/coroutines/flow/FlowKt__BuildersKt\n*L\n1#1,113:1\n69#2,2:114\n*E\n"})
    public static final class a<T> implements i<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function0 f48590a;

        public a(Function0 function0) {
            this.f48590a = function0;
        }

        @Override // kotlinx.coroutines.flow.i
        @Nullable
        public Object collect(@NotNull j<? super T> jVar, @NotNull kotlin.coroutines.e<? super n1> eVar) {
            Object emit = jVar.emit((Object) this.f48590a.invoke(), eVar);
            return emit == kotlin.coroutines.intrinsics.a.l() ? emit : n1.f44123a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Builders.kt\nkotlinx/coroutines/flow/FlowKt__BuildersKt\n*L\n1#1,113:1\n136#2,2:114\n*E\n"})
    public static final class b<T> implements i<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f48591a;

        public b(Object obj) {
            this.f48591a = obj;
        }

        @Override // kotlinx.coroutines.flow.i
        @Nullable
        public Object collect(@NotNull j<? super T> jVar, @NotNull kotlin.coroutines.e<? super n1> eVar) {
            Object emit = jVar.emit((Object) this.f48591a, eVar);
            return emit == kotlin.coroutines.intrinsics.a.l() ? emit : n1.f44123a;
        }
    }

    @NotNull
    public static final <T> i<T> a(@NotNull Iterable<? extends T> iterable) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$3(iterable);
    }

    @NotNull
    public static final <T> i<T> b(@NotNull Iterator<? extends T> it) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$4(it);
    }

    @NotNull
    public static final <T> i<T> c(@NotNull Function0<? extends T> function0) {
        return new a(function0);
    }

    @NotNull
    public static final <T> i<T> d(@NotNull Function1<? super kotlin.coroutines.e<? super T>, ? extends Object> function1) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$2(function1);
    }

    @NotNull
    public static final i<Integer> e(@NotNull kotlin.ranges.m mVar) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$9(mVar);
    }

    @NotNull
    public static final i<Long> f(@NotNull kotlin.ranges.p pVar) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$10(pVar);
    }

    @NotNull
    public static final <T> i<T> g(@NotNull kotlin.sequences.m<? extends T> mVar) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$5(mVar);
    }

    @NotNull
    public static final i<Integer> h(@NotNull int[] iArr) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$7(iArr);
    }

    @NotNull
    public static final i<Long> i(@NotNull long[] jArr) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$8(jArr);
    }

    @NotNull
    public static final <T> i<T> j(@NotNull T[] tArr) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$6(tArr);
    }

    @NotNull
    public static final <T> i<T> k(@BuilderInference @NotNull Function2<? super kotlinx.coroutines.channels.z<? super T>, ? super kotlin.coroutines.e<? super n1>, ? extends Object> function2) {
        return new kotlinx.coroutines.flow.b(function2, null, 0, null, 14, null);
    }

    @NotNull
    public static final <T> i<T> l(@BuilderInference @NotNull Function2<? super kotlinx.coroutines.channels.z<? super T>, ? super kotlin.coroutines.e<? super n1>, ? extends Object> function2) {
        return new f(function2, null, 0, null, 14, null);
    }

    @NotNull
    public static final <T> i<T> m() {
        return h.f48889a;
    }

    @NotNull
    public static final <T> i<T> n(@BuilderInference @NotNull Function2<? super j<? super T>, ? super kotlin.coroutines.e<? super n1>, ? extends Object> function2) {
        return new w(function2);
    }

    @NotNull
    public static final <T> i<T> o(T t5) {
        return new b(t5);
    }

    @NotNull
    public static final <T> i<T> p(@NotNull T... tArr) {
        return new FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1(tArr);
    }
}
