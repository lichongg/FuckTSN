package androidx.lifecycle;

import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.g0;
import kotlin.jvm.functions.Function2;
import kotlin.n1;
import kotlinx.coroutines.channels.z;
import kotlinx.coroutines.r0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@DebugMetadata(c = "androidx.lifecycle.FlowLiveDataConversions$asFlow$1", f = "FlowLiveData.kt", i = {0, 0}, l = {110, 114}, m = "invokeSuspend", n = {"$this$callbackFlow", "observer"}, s = {"L$0", "L$1"})
/* loaded from: D:\Downloads\app\classes.dex */
final class FlowLiveDataConversions$asFlow$1<T> extends SuspendLambda implements Function2<z<? super T>, kotlin.coroutines.e<? super n1>, Object> {
    final /* synthetic */ LiveData<T> $this_asFlow;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "androidx.lifecycle.FlowLiveDataConversions$asFlow$1$1", f = "FlowLiveData.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.lifecycle.FlowLiveDataConversions$asFlow$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {
        final /* synthetic */ Observer<T> $observer;
        final /* synthetic */ LiveData<T> $this_asFlow;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(LiveData<T> liveData, Observer<T> observer, kotlin.coroutines.e<? super AnonymousClass1> eVar) {
            super(2, eVar);
            this.$this_asFlow = liveData;
            this.$observer = observer;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.e<n1> create(@Nullable Object obj, @NotNull kotlin.coroutines.e<?> eVar) {
            return new AnonymousClass1(this.$this_asFlow, this.$observer, eVar);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull r0 r0Var, @Nullable kotlin.coroutines.e<? super n1> eVar) {
            return ((AnonymousClass1) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.l();
            if (this.label == 0) {
                g0.n(obj);
                this.$this_asFlow.observeForever(this.$observer);
                return n1.f44123a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FlowLiveDataConversions$asFlow$1(LiveData<T> liveData, kotlin.coroutines.e<? super FlowLiveDataConversions$asFlow$1> eVar) {
        super(2, eVar);
        this.$this_asFlow = liveData;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final kotlin.coroutines.e<n1> create(@Nullable Object obj, @NotNull kotlin.coroutines.e<?> eVar) {
        FlowLiveDataConversions$asFlow$1 flowLiveDataConversions$asFlow$1 = new FlowLiveDataConversions$asFlow$1(this.$this_asFlow, eVar);
        flowLiveDataConversions$asFlow$1.L$0 = obj;
        return flowLiveDataConversions$asFlow$1;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull z<? super T> zVar, @Nullable kotlin.coroutines.e<? super n1> eVar) {
        return ((FlowLiveDataConversions$asFlow$1) create(zVar, eVar)).invokeSuspend(n1.f44123a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0061, code lost:
    
        if (kotlinx.coroutines.channels.x.a(r3, r9, r8) == r0) goto L16;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.a.l()
            int r1 = r8.label
            r2 = 2
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L27
            if (r1 == r3) goto L1b
            if (r1 != r2) goto L13
            kotlin.g0.n(r9)
            goto L64
        L13:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L1b:
            java.lang.Object r1 = r8.L$1
            androidx.lifecycle.Observer r1 = (androidx.lifecycle.Observer) r1
            java.lang.Object r3 = r8.L$0
            kotlinx.coroutines.channels.z r3 = (kotlinx.coroutines.channels.z) r3
            kotlin.g0.n(r9)
            goto L50
        L27:
            kotlin.g0.n(r9)
            java.lang.Object r9 = r8.L$0
            kotlinx.coroutines.channels.z r9 = (kotlinx.coroutines.channels.z) r9
            androidx.lifecycle.e r1 = new androidx.lifecycle.e
            r1.<init>()
            kotlinx.coroutines.p2 r5 = kotlinx.coroutines.g1.e()
            kotlinx.coroutines.p2 r5 = r5.v()
            androidx.lifecycle.FlowLiveDataConversions$asFlow$1$1 r6 = new androidx.lifecycle.FlowLiveDataConversions$asFlow$1$1
            androidx.lifecycle.LiveData<T> r7 = r8.$this_asFlow
            r6.<init>(r7, r1, r4)
            r8.L$0 = r9
            r8.L$1 = r1
            r8.label = r3
            java.lang.Object r3 = kotlinx.coroutines.i.h(r5, r6, r8)
            if (r3 != r0) goto L4f
            goto L63
        L4f:
            r3 = r9
        L50:
            androidx.lifecycle.FlowLiveDataConversions$asFlow$1$2 r9 = new androidx.lifecycle.FlowLiveDataConversions$asFlow$1$2
            androidx.lifecycle.LiveData<T> r5 = r8.$this_asFlow
            r9.<init>()
            r8.L$0 = r4
            r8.L$1 = r4
            r8.label = r2
            java.lang.Object r9 = kotlinx.coroutines.channels.x.a(r3, r9, r8)
            if (r9 != r0) goto L64
        L63:
            return r0
        L64:
            kotlin.n1 r9 = kotlin.n1.f44123a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.FlowLiveDataConversions$asFlow$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
