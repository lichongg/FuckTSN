package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.d0;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n*L\n1#1,113:1\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class SafeCollector_commonKt$unsafeFlow$1<T> implements kotlinx.coroutines.flow.i<T> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Function2<kotlinx.coroutines.flow.j<? super T>, kotlin.coroutines.e<? super n1>, Object> f48902a;

    @Nullable
    public Object f(@NotNull kotlinx.coroutines.flow.j<? super T> jVar, @NotNull final kotlin.coroutines.e<? super n1> eVar) {
        d0.e(4);
        new ContinuationImpl(eVar) { // from class: kotlinx.coroutines.flow.internal.SafeCollector_commonKt$unsafeFlow$1$collect$1
            int label;
            /* synthetic */ Object result;

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return SafeCollector_commonKt$unsafeFlow$1.this.collect(null, this);
            }
        };
        d0.e(5);
        this.f48902a.invoke(jVar, eVar);
        return n1.f44123a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SafeCollector_commonKt$unsafeFlow$1(Function2<? super kotlinx.coroutines.flow.j<? super T>, ? super kotlin.coroutines.e<? super n1>, ? extends Object> function2) {
        this.f48902a = function2;
    }

    @Override // kotlinx.coroutines.flow.i
    @Nullable
    public Object collect(@NotNull kotlinx.coroutines.flow.j<? super T> jVar, @NotNull kotlin.coroutines.e<? super n1> eVar) {
        Object invoke = this.f48902a.invoke(jVar, eVar);
        return invoke == kotlin.coroutines.intrinsics.a.l() ? invoke : n1.f44123a;
    }
}
