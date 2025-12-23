package kotlinx.coroutines.flow;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nShare.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Share.kt\nkotlinx/coroutines/flow/SubscribedFlowCollector\n+ 2 CoroutineScope.kt\nkotlinx/coroutines/CoroutineScopeKt\n*L\n1#1,426:1\n329#2:427\n*S KotlinDebug\n*F\n+ 1 Share.kt\nkotlinx/coroutines/flow/SubscribedFlowCollector\n*L\n417#1:427\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class l0<T> implements j<T> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final j<T> f49054a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final Function2<j<? super T>, kotlin.coroutines.e<? super n1>, Object> f49055b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.flow.SubscribedFlowCollector", f = "Share.kt", i = {0, 0}, l = {419, org.apache.commons.net.nntp.h.f50927z}, m = "onSubscription", n = {"this", "safeCollector"}, s = {"L$0", "L$1"})
    static final class a extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        Object f49056a;

        /* renamed from: b, reason: collision with root package name */
        Object f49057b;

        /* renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f49058c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ l0<T> f49059d;

        /* renamed from: e, reason: collision with root package name */
        int f49060e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(l0<T> l0Var, kotlin.coroutines.e<? super a> eVar) {
            super(eVar);
            this.f49059d = l0Var;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f49058c = obj;
            this.f49060e |= Integer.MIN_VALUE;
            return this.f49059d.a(this);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0076, code lost:
    
        if (((kotlinx.coroutines.flow.l0) r7).a(r0) == r1) goto L29;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [kotlinx.coroutines.flow.internal.SafeCollector] */
    /* JADX WARN: Type inference failed for: r2v4, types: [boolean] */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(@org.jetbrains.annotations.NotNull kotlin.coroutines.e<? super kotlin.n1> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof kotlinx.coroutines.flow.l0.a
            if (r0 == 0) goto L13
            r0 = r7
            kotlinx.coroutines.flow.l0$a r0 = (kotlinx.coroutines.flow.l0.a) r0
            int r1 = r0.f49060e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f49060e = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.l0$a r0 = new kotlinx.coroutines.flow.l0$a
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.f49058c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
            int r2 = r0.f49060e
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L42
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.g0.n(r7)
            goto L79
        L2c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L34:
            java.lang.Object r2 = r0.f49057b
            kotlinx.coroutines.flow.internal.SafeCollector r2 = (kotlinx.coroutines.flow.internal.SafeCollector) r2
            java.lang.Object r4 = r0.f49056a
            kotlinx.coroutines.flow.l0 r4 = (kotlinx.coroutines.flow.l0) r4
            kotlin.g0.n(r7)     // Catch: java.lang.Throwable -> L40
            goto L60
        L40:
            r7 = move-exception
            goto L7f
        L42:
            kotlin.g0.n(r7)
            kotlinx.coroutines.flow.internal.SafeCollector r2 = new kotlinx.coroutines.flow.internal.SafeCollector
            kotlinx.coroutines.flow.j<T> r7 = r6.f49054a
            kotlin.coroutines.i r5 = r0.getContext()
            r2.<init>(r7, r5)
            kotlin.jvm.functions.Function2<kotlinx.coroutines.flow.j<? super T>, kotlin.coroutines.e<? super kotlin.n1>, java.lang.Object> r7 = r6.f49055b     // Catch: java.lang.Throwable -> L40
            r0.f49056a = r6     // Catch: java.lang.Throwable -> L40
            r0.f49057b = r2     // Catch: java.lang.Throwable -> L40
            r0.f49060e = r4     // Catch: java.lang.Throwable -> L40
            java.lang.Object r7 = r7.invoke(r2, r0)     // Catch: java.lang.Throwable -> L40
            if (r7 != r1) goto L5f
            goto L78
        L5f:
            r4 = r6
        L60:
            r2.releaseIntercepted()
            kotlinx.coroutines.flow.j<T> r7 = r4.f49054a
            boolean r2 = r7 instanceof kotlinx.coroutines.flow.l0
            if (r2 == 0) goto L7c
            kotlinx.coroutines.flow.l0 r7 = (kotlinx.coroutines.flow.l0) r7
            r2 = 0
            r0.f49056a = r2
            r0.f49057b = r2
            r0.f49060e = r3
            java.lang.Object r7 = r7.a(r0)
            if (r7 != r1) goto L79
        L78:
            return r1
        L79:
            kotlin.n1 r7 = kotlin.n1.f44123a
            return r7
        L7c:
            kotlin.n1 r7 = kotlin.n1.f44123a
            return r7
        L7f:
            r2.releaseIntercepted()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.l0.a(kotlin.coroutines.e):java.lang.Object");
    }

    @Override // kotlinx.coroutines.flow.j
    @Nullable
    public Object emit(T t5, @NotNull kotlin.coroutines.e<? super n1> eVar) {
        return this.f49054a.emit(t5, eVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public l0(@NotNull j<? super T> jVar, @NotNull Function2<? super j<? super T>, ? super kotlin.coroutines.e<? super n1>, ? extends Object> function2) {
        this.f49054a = jVar;
        this.f49055b = function2;
    }
}
