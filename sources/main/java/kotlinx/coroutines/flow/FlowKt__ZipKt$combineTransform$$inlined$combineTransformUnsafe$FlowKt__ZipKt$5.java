package kotlinx.coroutines.flow;

import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Add missing generic type declarations: [R] */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$5", f = "Zip.kt", i = {}, l = {273}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nZip.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt$combineTransformUnsafe$1\n*L\n1#1,332:1\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$5<R> extends SuspendLambda implements Function2<j<? super R>, kotlin.coroutines.e<? super n1>, Object> {
    final /* synthetic */ i[] $flows;
    final /* synthetic */ Function7 $transform$inlined;
    private /* synthetic */ Object L$0;
    int label;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$5$1", f = "Zip.kt", i = {}, l = {333}, m = "invokeSuspend", n = {}, s = {})
    @SourceDebugExtension({"SMAP\nZip.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt$combineTransformUnsafe$1$1\n+ 2 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt\n*L\n1#1,332:1\n221#2,8:333\n*E\n"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$5$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function3<j<? super R>, Object[], kotlin.coroutines.e<? super n1>, Object> {
        final /* synthetic */ Function7 $transform$inlined;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(kotlin.coroutines.e eVar, Function7 function7) {
            super(3, eVar);
            this.$transform$inlined = function7;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        public final Object invoke(@NotNull j<? super R> jVar, @NotNull Object[] objArr, @Nullable kotlin.coroutines.e<? super n1> eVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(eVar, this.$transform$inlined);
            anonymousClass1.L$0 = jVar;
            anonymousClass1.L$1 = objArr;
            return anonymousClass1.invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.label;
            if (i6 != 0) {
                if (i6 == 1) {
                    kotlin.g0.n(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                kotlin.g0.n(obj);
                j jVar = (j) this.L$0;
                Object[] objArr = (Object[]) this.L$1;
                Function7 function7 = this.$transform$inlined;
                Object obj2 = objArr[0];
                Object obj3 = objArr[1];
                Object obj4 = objArr[2];
                Object obj5 = objArr[3];
                Object obj6 = objArr[4];
                this.label = 1;
                kotlin.jvm.internal.d0.e(6);
                Object invoke = function7.invoke(jVar, obj2, obj3, obj4, obj5, obj6, this);
                kotlin.jvm.internal.d0.e(7);
                if (invoke == l6) {
                    return l6;
                }
            }
            return n1.f44123a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$5(i[] iVarArr, kotlin.coroutines.e eVar, Function7 function7) {
        super(2, eVar);
        this.$flows = iVarArr;
        this.$transform$inlined = function7;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final kotlin.coroutines.e<n1> create(@Nullable Object obj, @NotNull kotlin.coroutines.e<?> eVar) {
        FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$5 flowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$5 = new FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$5(this.$flows, eVar, this.$transform$inlined);
        flowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$5.L$0 = obj;
        return flowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$5;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull j<? super R> jVar, @Nullable kotlin.coroutines.e<? super n1> eVar) {
        return ((FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$5) create(jVar, eVar)).invokeSuspend(n1.f44123a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object l6 = kotlin.coroutines.intrinsics.a.l();
        int i6 = this.label;
        if (i6 != 0) {
            if (i6 == 1) {
                kotlin.g0.n(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            kotlin.g0.n(obj);
            j jVar = (j) this.L$0;
            i[] iVarArr = this.$flows;
            Function0 r5 = FlowKt__ZipKt.r();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(null, this.$transform$inlined);
            this.label = 1;
            if (kotlinx.coroutines.flow.internal.k.a(jVar, iVarArr, r5, anonymousClass1, this) == l6) {
                return l6;
            }
        }
        return n1.f44123a;
    }
}
