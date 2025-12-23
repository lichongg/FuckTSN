package kotlinx.coroutines.flow;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 3 CoroutineScope.kt\nkotlinx/coroutines/CoroutineScopeKt\n*L\n1#1,113:1\n147#2,13:114\n160#2,6:128\n329#3:127\n*S KotlinDebug\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n*L\n159#1:127\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1<T> implements i<T> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ i f48597a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Function3 f48598b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1", f = "Emitters.kt", i = {0, 0, 1, 2}, l = {115, 122, 129}, m = "collect", n = {"this", "$this$onCompletion_u24lambda_u242", "e", "sc"}, s = {"L$0", "L$1", "L$0", "L$0"})
    @SourceDebugExtension({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1$collect$1\n*L\n1#1,113:1\n*E\n"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1, reason: invalid class name */
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
            return FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1.this.collect(null, this);
        }
    }

    public FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1(i iVar, Function3 function3) {
        this.f48597a = iVar;
        this.f48598b = function3;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ac A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    @Override // kotlinx.coroutines.flow.i
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object collect(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.j<? super T> r9, @org.jetbrains.annotations.NotNull kotlin.coroutines.e<? super kotlin.n1> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r10
            kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1 r0 = (kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1 r0 = new kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L55
            if (r2 == r5) goto L47
            if (r2 == r4) goto L3e
            if (r2 != r3) goto L36
            java.lang.Object r9 = r0.L$0
            kotlinx.coroutines.flow.internal.SafeCollector r9 = (kotlinx.coroutines.flow.internal.SafeCollector) r9
            kotlin.g0.n(r10)     // Catch: java.lang.Throwable -> L34
            goto L89
        L34:
            r10 = move-exception
            goto L93
        L36:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3e:
            java.lang.Object r9 = r0.L$0
            java.lang.Throwable r9 = (java.lang.Throwable) r9
            kotlin.g0.n(r10)
            goto Lad
        L47:
            java.lang.Object r9 = r0.L$1
            kotlinx.coroutines.flow.j r9 = (kotlinx.coroutines.flow.j) r9
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1 r2 = (kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1) r2
            kotlin.g0.n(r10)     // Catch: java.lang.Throwable -> L53
            goto L68
        L53:
            r9 = move-exception
            goto L99
        L55:
            kotlin.g0.n(r10)
            kotlinx.coroutines.flow.i r10 = r8.f48597a     // Catch: java.lang.Throwable -> L97
            r0.L$0 = r8     // Catch: java.lang.Throwable -> L97
            r0.L$1 = r9     // Catch: java.lang.Throwable -> L97
            r0.label = r5     // Catch: java.lang.Throwable -> L97
            java.lang.Object r10 = r10.collect(r9, r0)     // Catch: java.lang.Throwable -> L97
            if (r10 != r1) goto L67
            goto Lac
        L67:
            r2 = r8
        L68:
            kotlinx.coroutines.flow.internal.SafeCollector r10 = new kotlinx.coroutines.flow.internal.SafeCollector
            kotlin.coroutines.i r4 = r0.getContext()
            r10.<init>(r9, r4)
            kotlin.jvm.functions.Function3 r9 = r2.f48598b     // Catch: java.lang.Throwable -> L8f
            r0.L$0 = r10     // Catch: java.lang.Throwable -> L8f
            r0.L$1 = r6     // Catch: java.lang.Throwable -> L8f
            r0.label = r3     // Catch: java.lang.Throwable -> L8f
            r2 = 6
            kotlin.jvm.internal.d0.e(r2)     // Catch: java.lang.Throwable -> L8f
            java.lang.Object r9 = r9.invoke(r10, r6, r0)     // Catch: java.lang.Throwable -> L8f
            r0 = 7
            kotlin.jvm.internal.d0.e(r0)     // Catch: java.lang.Throwable -> L8f
            if (r9 != r1) goto L88
            goto Lac
        L88:
            r9 = r10
        L89:
            r9.releaseIntercepted()
            kotlin.n1 r9 = kotlin.n1.f44123a
            return r9
        L8f:
            r9 = move-exception
            r7 = r10
            r10 = r9
            r9 = r7
        L93:
            r9.releaseIntercepted()
            throw r10
        L97:
            r9 = move-exception
            r2 = r8
        L99:
            kotlinx.coroutines.flow.n0 r10 = new kotlinx.coroutines.flow.n0
            r10.<init>(r9)
            kotlin.jvm.functions.Function3 r2 = r2.f48598b
            r0.L$0 = r9
            r0.L$1 = r6
            r0.label = r4
            java.lang.Object r10 = kotlinx.coroutines.flow.FlowKt__EmittersKt.a(r10, r2, r9, r0)
            if (r10 != r1) goto Lad
        Lac:
            return r1
        Lad:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1.collect(kotlinx.coroutines.flow.j, kotlin.coroutines.e):java.lang.Object");
    }
}
