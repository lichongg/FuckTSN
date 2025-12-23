package kotlinx.coroutines.flow;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Add missing generic type declarations: [R] */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt\n*L\n1#1,113:1\n238#2,2:114\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FlowKt__ZipKt$combine$$inlined$unsafeFlow$2<R> implements i<R> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ i[] f48822a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Function2 f48823b;

    @Nullable
    public Object f(@NotNull j jVar, @NotNull kotlin.coroutines.e eVar) {
        kotlin.jvm.internal.d0.e(4);
        new ContinuationImpl(eVar) { // from class: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$unsafeFlow$2.1
            int label;
            /* synthetic */ Object result;

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return FlowKt__ZipKt$combine$$inlined$unsafeFlow$2.this.collect(null, this);
            }
        };
        kotlin.jvm.internal.d0.e(5);
        i[] iVarArr = this.f48822a;
        kotlin.jvm.internal.g0.w();
        FlowKt__ZipKt$combine$5$1 flowKt__ZipKt$combine$5$1 = new FlowKt__ZipKt$combine$5$1(this.f48822a);
        kotlin.jvm.internal.g0.w();
        FlowKt__ZipKt$combine$5$2 flowKt__ZipKt$combine$5$2 = new FlowKt__ZipKt$combine$5$2(this.f48823b, null);
        kotlin.jvm.internal.d0.e(0);
        kotlinx.coroutines.flow.internal.k.a(jVar, iVarArr, flowKt__ZipKt$combine$5$1, flowKt__ZipKt$combine$5$2, eVar);
        kotlin.jvm.internal.d0.e(1);
        return n1.f44123a;
    }

    public FlowKt__ZipKt$combine$$inlined$unsafeFlow$2(i[] iVarArr, Function2 function2) {
        this.f48822a = iVarArr;
        this.f48823b = function2;
    }

    @Override // kotlinx.coroutines.flow.i
    @Nullable
    public Object collect(@NotNull j<? super R> jVar, @NotNull kotlin.coroutines.e<? super n1> eVar) {
        i[] iVarArr = this.f48822a;
        kotlin.jvm.internal.g0.w();
        FlowKt__ZipKt$combine$5$1 flowKt__ZipKt$combine$5$1 = new FlowKt__ZipKt$combine$5$1(this.f48822a);
        kotlin.jvm.internal.g0.w();
        Object a6 = kotlinx.coroutines.flow.internal.k.a(jVar, iVarArr, flowKt__ZipKt$combine$5$1, new FlowKt__ZipKt$combine$5$2(this.f48823b, null), eVar);
        return a6 == kotlin.coroutines.intrinsics.a.l() ? a6 : n1.f44123a;
    }
}
