package kotlinx.coroutines.flow;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n*L\n1#1,113:1\n51#2,5:114\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FlowKt__TransformKt$filterIsInstance$$inlined$filter$1 implements i<Object> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ i f48765a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n*L\n1#1,222:1\n22#2:223\n36#2:224\n23#2:225\n*E\n"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1$2, reason: invalid class name */
    public static final class AnonymousClass2<T> implements j {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ j f48766a;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1$2", f = "Transform.kt", i = {}, l = {223}, m = "emit", n = {}, s = {})
        @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,222:1\n*E\n"})
        /* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends ContinuationImpl {
            Object L$0;
            Object L$1;
            int label;
            /* synthetic */ Object result;

            public AnonymousClass1(kotlin.coroutines.e eVar) {
                super(eVar);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return AnonymousClass2.this.emit(null, this);
            }
        }

        @Nullable
        public final Object a(Object obj, @NotNull kotlin.coroutines.e eVar) {
            kotlin.jvm.internal.d0.e(4);
            new AnonymousClass1(eVar);
            kotlin.jvm.internal.d0.e(5);
            j jVar = this.f48766a;
            kotlin.jvm.internal.g0.y(3, "R");
            if (androidx.activity.k.a(obj)) {
                kotlin.jvm.internal.d0.e(0);
                jVar.emit(obj, eVar);
                kotlin.jvm.internal.d0.e(1);
            }
            return n1.f44123a;
        }

        public AnonymousClass2(j jVar) {
            this.f48766a = jVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
        @Override // kotlinx.coroutines.flow.j
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object emit(java.lang.Object r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.e r7) {
            /*
                r5 = this;
                boolean r0 = r7 instanceof kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1.AnonymousClass2.AnonymousClass1
                if (r0 == 0) goto L13
                r0 = r7
                kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1$2$1 r0 = (kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1.AnonymousClass2.AnonymousClass1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1$2$1 r0 = new kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1$2$1
                r0.<init>(r7)
            L18:
                java.lang.Object r7 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L31
                if (r2 != r3) goto L29
                kotlin.g0.n(r7)
                goto L4b
            L29:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L31:
                kotlin.g0.n(r7)
                kotlinx.coroutines.flow.j r7 = r5.f48766a
                r2 = 3
                java.lang.String r4 = "R"
                kotlin.jvm.internal.g0.y(r2, r4)
                boolean r2 = androidx.activity.k.a(r6)
                if (r2 == 0) goto L4b
                r0.label = r3
                java.lang.Object r6 = r7.emit(r6, r0)
                if (r6 != r1) goto L4b
                return r1
            L4b:
                kotlin.n1 r6 = kotlin.n1.f44123a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.e):java.lang.Object");
        }
    }

    @Nullable
    public Object f(@NotNull j jVar, @NotNull kotlin.coroutines.e eVar) {
        kotlin.jvm.internal.d0.e(4);
        new ContinuationImpl(eVar) { // from class: kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1.1
            int label;
            /* synthetic */ Object result;

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return FlowKt__TransformKt$filterIsInstance$$inlined$filter$1.this.collect(null, this);
            }
        };
        kotlin.jvm.internal.d0.e(5);
        i iVar = this.f48765a;
        kotlin.jvm.internal.g0.w();
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(jVar);
        kotlin.jvm.internal.d0.e(0);
        iVar.collect(anonymousClass2, eVar);
        kotlin.jvm.internal.d0.e(1);
        return n1.f44123a;
    }

    public FlowKt__TransformKt$filterIsInstance$$inlined$filter$1(i iVar) {
        this.f48765a = iVar;
    }

    @Override // kotlinx.coroutines.flow.i
    @Nullable
    public Object collect(@NotNull j<? super Object> jVar, @NotNull kotlin.coroutines.e eVar) {
        i iVar = this.f48765a;
        kotlin.jvm.internal.g0.w();
        Object collect = iVar.collect(new AnonymousClass2(jVar), eVar);
        return collect == kotlin.coroutines.intrinsics.a.l() ? collect : n1.f44123a;
    }
}
