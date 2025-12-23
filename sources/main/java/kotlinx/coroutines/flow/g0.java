package kotlinx.coroutines.flow;

import java.util.List;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nSharingStarted.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SharingStarted.kt\nkotlinx/coroutines/flow/StartedWhileSubscribed\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,209:1\n1#2:210\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
final class g0 implements c0 {

    /* renamed from: b, reason: collision with root package name */
    private final long f48881b;

    /* renamed from: c, reason: collision with root package name */
    private final long f48882c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.flow.StartedWhileSubscribed$command$1", f = "SharingStarted.kt", i = {1, 2, 3}, l = {178, 180, 182, 183, 185}, m = "invokeSuspend", n = {"$this$transformLatest", "$this$transformLatest", "$this$transformLatest"}, s = {"L$0", "L$0", "L$0"})
    static final class a extends SuspendLambda implements Function3<j<? super SharingCommand>, Integer, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f48883a;

        /* renamed from: b, reason: collision with root package name */
        private /* synthetic */ Object f48884b;

        /* renamed from: c, reason: collision with root package name */
        /* synthetic */ int f48885c;

        a(kotlin.coroutines.e<? super a> eVar) {
            super(3, eVar);
        }

        @Nullable
        public final Object f(@NotNull j<? super SharingCommand> jVar, int i6, @Nullable kotlin.coroutines.e<? super n1> eVar) {
            a aVar = g0.this.new a(eVar);
            aVar.f48884b = jVar;
            aVar.f48885c = i6;
            return aVar.invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(j<? super SharingCommand> jVar, Integer num, kotlin.coroutines.e<? super n1> eVar) {
            return f(jVar, num.intValue(), eVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0099, code lost:
        
            if (r1.emit(r10, r9) != r0) goto L35;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x008b, code lost:
        
            if (kotlinx.coroutines.a1.b(r4, r9) == r0) goto L34;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x007a, code lost:
        
            if (r1.emit(r10, r9) == r0) goto L34;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x0050, code lost:
        
            if (r1.emit(r10, r9) == r0) goto L34;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x0061, code lost:
        
            if (kotlinx.coroutines.a1.b(r6, r9) == r0) goto L34;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r10) {
            /*
                r9 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.a.l()
                int r1 = r9.f48883a
                r2 = 5
                r3 = 4
                r4 = 3
                r5 = 2
                r6 = 1
                if (r1 == 0) goto L3c
                if (r1 == r6) goto L38
                if (r1 == r5) goto L30
                if (r1 == r4) goto L28
                if (r1 == r3) goto L20
                if (r1 != r2) goto L18
                goto L38
            L18:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r0)
                throw r10
            L20:
                java.lang.Object r1 = r9.f48884b
                kotlinx.coroutines.flow.j r1 = (kotlinx.coroutines.flow.j) r1
                kotlin.g0.n(r10)
                goto L8e
            L28:
                java.lang.Object r1 = r9.f48884b
                kotlinx.coroutines.flow.j r1 = (kotlinx.coroutines.flow.j) r1
                kotlin.g0.n(r10)
                goto L7d
            L30:
                java.lang.Object r1 = r9.f48884b
                kotlinx.coroutines.flow.j r1 = (kotlinx.coroutines.flow.j) r1
                kotlin.g0.n(r10)
                goto L64
            L38:
                kotlin.g0.n(r10)
                goto L9c
            L3c:
                kotlin.g0.n(r10)
                java.lang.Object r10 = r9.f48884b
                r1 = r10
                kotlinx.coroutines.flow.j r1 = (kotlinx.coroutines.flow.j) r1
                int r10 = r9.f48885c
                if (r10 <= 0) goto L53
                kotlinx.coroutines.flow.SharingCommand r10 = kotlinx.coroutines.flow.SharingCommand.START
                r9.f48883a = r6
                java.lang.Object r10 = r1.emit(r10, r9)
                if (r10 != r0) goto L9c
                goto L9b
            L53:
                kotlinx.coroutines.flow.g0 r10 = kotlinx.coroutines.flow.g0.this
                long r6 = kotlinx.coroutines.flow.g0.c(r10)
                r9.f48884b = r1
                r9.f48883a = r5
                java.lang.Object r10 = kotlinx.coroutines.a1.b(r6, r9)
                if (r10 != r0) goto L64
                goto L9b
            L64:
                kotlinx.coroutines.flow.g0 r10 = kotlinx.coroutines.flow.g0.this
                long r5 = kotlinx.coroutines.flow.g0.b(r10)
                r7 = 0
                int r10 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                if (r10 <= 0) goto L8e
                kotlinx.coroutines.flow.SharingCommand r10 = kotlinx.coroutines.flow.SharingCommand.STOP
                r9.f48884b = r1
                r9.f48883a = r4
                java.lang.Object r10 = r1.emit(r10, r9)
                if (r10 != r0) goto L7d
                goto L9b
            L7d:
                kotlinx.coroutines.flow.g0 r10 = kotlinx.coroutines.flow.g0.this
                long r4 = kotlinx.coroutines.flow.g0.b(r10)
                r9.f48884b = r1
                r9.f48883a = r3
                java.lang.Object r10 = kotlinx.coroutines.a1.b(r4, r9)
                if (r10 != r0) goto L8e
                goto L9b
            L8e:
                kotlinx.coroutines.flow.SharingCommand r10 = kotlinx.coroutines.flow.SharingCommand.STOP_AND_RESET_REPLAY_CACHE
                r3 = 0
                r9.f48884b = r3
                r9.f48883a = r2
                java.lang.Object r10 = r1.emit(r10, r9)
                if (r10 != r0) goto L9c
            L9b:
                return r0
            L9c:
                kotlin.n1 r10 = kotlin.n1.f44123a
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.g0.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.flow.StartedWhileSubscribed$command$2", f = "SharingStarted.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class b extends SuspendLambda implements Function2<SharingCommand, kotlin.coroutines.e<? super Boolean>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f48887a;

        /* renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f48888b;

        b(kotlin.coroutines.e<? super b> eVar) {
            super(2, eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.e<n1> create(@Nullable Object obj, @NotNull kotlin.coroutines.e<?> eVar) {
            b bVar = new b(eVar);
            bVar.f48888b = obj;
            return bVar;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Object invoke(@NotNull SharingCommand sharingCommand, @Nullable kotlin.coroutines.e<? super Boolean> eVar) {
            return ((b) create(sharingCommand, eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            boolean z5;
            kotlin.coroutines.intrinsics.a.l();
            if (this.f48887a == 0) {
                kotlin.g0.n(obj);
                if (((SharingCommand) this.f48888b) != SharingCommand.START) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                return kotlin.coroutines.jvm.internal.a.a(z5);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @NotNull
    public String toString() {
        List k6 = kotlin.collections.f0.k(2);
        if (this.f48881b > 0) {
            k6.add("stopTimeout=" + this.f48881b + "ms");
        }
        if (this.f48882c < Long.MAX_VALUE) {
            k6.add("replayExpiration=" + this.f48882c + "ms");
        }
        return "SharingStarted.WhileSubscribed(" + kotlin.collections.f0.r3(kotlin.collections.f0.b(k6), null, null, null, 0, null, null, 63, null) + ')';
    }

    @Override // kotlinx.coroutines.flow.c0
    @NotNull
    public i<SharingCommand> a(@NotNull h0<Integer> h0Var) {
        return k.g0(k.k0(k.d2(h0Var, new a(null)), new b(null)));
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof g0)) {
            return false;
        }
        g0 g0Var = (g0) obj;
        return this.f48881b == g0Var.f48881b && this.f48882c == g0Var.f48882c;
    }

    @IgnoreJRERequirement
    public int hashCode() {
        return (androidx.camera.camera2.internal.compat.params.e.a(this.f48881b) * 31) + androidx.camera.camera2.internal.compat.params.e.a(this.f48882c);
    }

    public g0(long j6, long j7) {
        this.f48881b = j6;
        this.f48882c = j7;
        if (j6 >= 0) {
            if (j7 >= 0) {
                return;
            }
            throw new IllegalArgumentException(("replayExpiration(" + j7 + " ms) cannot be negative").toString());
        }
        throw new IllegalArgumentException(("stopTimeout(" + j6 + " ms) cannot be negative").toString());
    }
}
