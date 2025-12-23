package androidx.room;

import java.util.Set;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.g0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import kotlinx.coroutines.r0;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@DebugMetadata(c = "androidx.room.TriggerBasedInvalidationTracker$createFlow$1", f = "InvalidationTracker.kt", i = {0, 1}, l = {233, 233, org.apache.commons.net.telnet.f.f51104t}, m = "invokeSuspend", n = {"$this$flow", "$this$flow"}, s = {"L$0", "L$0"})
/* loaded from: D:\Downloads\app\classes.dex */
final class TriggerBasedInvalidationTracker$createFlow$1 extends SuspendLambda implements Function2<kotlinx.coroutines.flow.j<? super Set<? extends String>>, kotlin.coroutines.e<? super n1>, Object> {
    final /* synthetic */ boolean $emitInitialState;
    final /* synthetic */ String[] $resolvedTableNames;
    final /* synthetic */ int[] $tableIds;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ TriggerBasedInvalidationTracker this$0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "androidx.room.TriggerBasedInvalidationTracker$createFlow$1$1", f = "InvalidationTracker.kt", i = {}, l = {233}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.room.TriggerBasedInvalidationTracker$createFlow$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {
        int label;
        final /* synthetic */ TriggerBasedInvalidationTracker this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(TriggerBasedInvalidationTracker triggerBasedInvalidationTracker, kotlin.coroutines.e<? super AnonymousClass1> eVar) {
            super(2, eVar);
            this.this$0 = triggerBasedInvalidationTracker;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
            return new AnonymousClass1(this.this$0, eVar);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(r0 r0Var, kotlin.coroutines.e<? super n1> eVar) {
            return ((AnonymousClass1) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.label;
            if (i6 != 0) {
                if (i6 == 1) {
                    g0.n(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                g0.n(obj);
                TriggerBasedInvalidationTracker triggerBasedInvalidationTracker = this.this$0;
                this.label = 1;
                if (triggerBasedInvalidationTracker.syncTriggers$room_runtime_release(this) == l6) {
                    return l6;
                }
            }
            return n1.f44123a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nInvalidationTracker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InvalidationTracker.kt\nandroidx/room/TriggerBasedInvalidationTracker$createFlow$1$2\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,604:1\n3912#2:605\n4011#2:606\n13467#2,2:607\n4012#2,2:609\n13469#2:611\n4014#2:612\n*S KotlinDebug\n*F\n+ 1 InvalidationTracker.kt\nandroidx/room/TriggerBasedInvalidationTracker$createFlow$1$2\n*L\n245#1:605\n245#1:606\n245#1:607,2\n245#1:609,2\n245#1:611\n245#1:612\n*E\n"})
    /* renamed from: androidx.room.TriggerBasedInvalidationTracker$createFlow$1$2, reason: invalid class name */
    static final class AnonymousClass2<T> implements kotlinx.coroutines.flow.j {
        final /* synthetic */ kotlinx.coroutines.flow.j<Set<String>> $$this$flow;
        final /* synthetic */ Ref.ObjectRef<int[]> $currentVersions;
        final /* synthetic */ boolean $emitInitialState;
        final /* synthetic */ String[] $resolvedTableNames;
        final /* synthetic */ int[] $tableIds;

        @Override // kotlinx.coroutines.flow.j
        public /* bridge */ /* synthetic */ Object emit(Object obj, kotlin.coroutines.e eVar) {
            return emit((int[]) obj, (kotlin.coroutines.e<? super n1>) eVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(Ref.ObjectRef<int[]> objectRef, boolean z5, kotlinx.coroutines.flow.j<? super Set<String>> jVar, String[] strArr, int[] iArr) {
            this.$currentVersions = objectRef;
            this.$emitInitialState = z5;
            this.$$this$flow = jVar;
            this.$resolvedTableNames = strArr;
            this.$tableIds = iArr;
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x005c, code lost:
        
            if (r14.emit(r2, r0) == r1) goto L37;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x00a6, code lost:
        
            return r1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x00a4, code lost:
        
            if (r14.emit(r2, r0) == r1) goto L37;
         */
        /* JADX WARN: Removed duplicated region for block: B:16:0x003d  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object emit(int[] r13, kotlin.coroutines.e<? super kotlin.n1> r14) {
            /*
                r12 = this;
                boolean r0 = r14 instanceof androidx.room.TriggerBasedInvalidationTracker$createFlow$1$2$emit$1
                if (r0 == 0) goto L13
                r0 = r14
                androidx.room.TriggerBasedInvalidationTracker$createFlow$1$2$emit$1 r0 = (androidx.room.TriggerBasedInvalidationTracker$createFlow$1$2$emit$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                androidx.room.TriggerBasedInvalidationTracker$createFlow$1$2$emit$1 r0 = new androidx.room.TriggerBasedInvalidationTracker$createFlow$1$2$emit$1
                r0.<init>(r12, r14)
            L18:
                java.lang.Object r14 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
                int r2 = r0.label
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L3d
                if (r2 == r4) goto L31
                if (r2 != r3) goto L29
                goto L31
            L29:
                java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
                r13.<init>(r14)
                throw r13
            L31:
                java.lang.Object r13 = r0.L$1
                int[] r13 = (int[]) r13
                java.lang.Object r0 = r0.L$0
                androidx.room.TriggerBasedInvalidationTracker$createFlow$1$2 r0 = (androidx.room.TriggerBasedInvalidationTracker$createFlow$1.AnonymousClass2) r0
                kotlin.g0.n(r14)
                goto La8
            L3d:
                kotlin.g0.n(r14)
                kotlin.jvm.internal.Ref$ObjectRef<int[]> r14 = r12.$currentVersions
                T r2 = r14.element
                if (r2 != 0) goto L5f
                boolean r14 = r12.$emitInitialState
                if (r14 == 0) goto La7
                kotlinx.coroutines.flow.j<java.util.Set<java.lang.String>> r14 = r12.$$this$flow
                java.lang.String[] r2 = r12.$resolvedTableNames
                java.util.Set r2 = kotlin.collections.n.Fz(r2)
                r0.L$0 = r12
                r0.L$1 = r13
                r0.label = r4
                java.lang.Object r14 = r14.emit(r2, r0)
                if (r14 != r1) goto La7
                goto La6
            L5f:
                java.lang.String[] r2 = r12.$resolvedTableNames
                int[] r4 = r12.$tableIds
                java.util.ArrayList r5 = new java.util.ArrayList
                r5.<init>()
                int r6 = r2.length
                r7 = 0
                r8 = 0
            L6b:
                if (r7 >= r6) goto L8e
                r9 = r2[r7]
                int r10 = r8 + 1
                T r11 = r14.element
                if (r11 == 0) goto L86
                int[] r11 = (int[]) r11
                r8 = r4[r8]
                r11 = r11[r8]
                r8 = r13[r8]
                if (r11 == r8) goto L82
                r5.add(r9)
            L82:
                int r7 = r7 + 1
                r8 = r10
                goto L6b
            L86:
                java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                java.lang.String r14 = "Required value was null."
                r13.<init>(r14)
                throw r13
            L8e:
                boolean r14 = r5.isEmpty()
                if (r14 != 0) goto La7
                kotlinx.coroutines.flow.j<java.util.Set<java.lang.String>> r14 = r12.$$this$flow
                java.util.Set r2 = kotlin.collections.f0.f6(r5)
                r0.L$0 = r12
                r0.L$1 = r13
                r0.label = r3
                java.lang.Object r14 = r14.emit(r2, r0)
                if (r14 != r1) goto La7
            La6:
                return r1
            La7:
                r0 = r12
            La8:
                kotlin.jvm.internal.Ref$ObjectRef<int[]> r14 = r0.$currentVersions
                r14.element = r13
                kotlin.n1 r13 = kotlin.n1.f44123a
                return r13
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.TriggerBasedInvalidationTracker$createFlow$1.AnonymousClass2.emit(int[], kotlin.coroutines.e):java.lang.Object");
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(kotlinx.coroutines.flow.j<? super Set<? extends String>> jVar, kotlin.coroutines.e<? super n1> eVar) {
        return invoke2((kotlinx.coroutines.flow.j<? super Set<String>>) jVar, eVar);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TriggerBasedInvalidationTracker$createFlow$1(TriggerBasedInvalidationTracker triggerBasedInvalidationTracker, int[] iArr, boolean z5, String[] strArr, kotlin.coroutines.e<? super TriggerBasedInvalidationTracker$createFlow$1> eVar) {
        super(2, eVar);
        this.this$0 = triggerBasedInvalidationTracker;
        this.$tableIds = iArr;
        this.$emitInitialState = z5;
        this.$resolvedTableNames = strArr;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
        TriggerBasedInvalidationTracker$createFlow$1 triggerBasedInvalidationTracker$createFlow$1 = new TriggerBasedInvalidationTracker$createFlow$1(this.this$0, this.$tableIds, this.$emitInitialState, this.$resolvedTableNames, eVar);
        triggerBasedInvalidationTracker$createFlow$1.L$0 = obj;
        return triggerBasedInvalidationTracker$createFlow$1;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(kotlinx.coroutines.flow.j<? super Set<String>> jVar, kotlin.coroutines.e<? super n1> eVar) {
        return ((TriggerBasedInvalidationTracker$createFlow$1) create(jVar, eVar)).invokeSuspend(n1.f44123a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0092, code lost:
    
        if (r12.collect(r4, r11) != r0) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x006e, code lost:
    
        if (kotlinx.coroutines.i.h((kotlin.coroutines.i) r12, r5, r11) == r0) goto L28;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.a.l()
            int r1 = r11.label
            r2 = 0
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L33
            if (r1 == r5) goto L2b
            if (r1 == r4) goto L23
            if (r1 == r3) goto L1a
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L1a:
            kotlin.g0.n(r12)     // Catch: java.lang.Throwable -> L1f
            goto L95
        L1f:
            r0 = move-exception
            r12 = r0
            goto L9b
        L23:
            java.lang.Object r1 = r11.L$0
            kotlinx.coroutines.flow.j r1 = (kotlinx.coroutines.flow.j) r1
            kotlin.g0.n(r12)
            goto L71
        L2b:
            java.lang.Object r1 = r11.L$0
            kotlinx.coroutines.flow.j r1 = (kotlinx.coroutines.flow.j) r1
            kotlin.g0.n(r12)
            goto L5d
        L33:
            kotlin.g0.n(r12)
            java.lang.Object r12 = r11.L$0
            kotlinx.coroutines.flow.j r12 = (kotlinx.coroutines.flow.j) r12
            androidx.room.TriggerBasedInvalidationTracker r1 = r11.this$0
            androidx.room.ObservedTableStates r1 = androidx.room.TriggerBasedInvalidationTracker.access$getObservedTableStates$p(r1)
            int[] r6 = r11.$tableIds
            boolean r1 = r1.onObserverAdded$room_runtime_release(r6)
            if (r1 == 0) goto L73
            androidx.room.TriggerBasedInvalidationTracker r1 = r11.this$0
            androidx.room.RoomDatabase r1 = androidx.room.TriggerBasedInvalidationTracker.access$getDatabase$p(r1)
            r11.L$0 = r12
            r11.label = r5
            r5 = 0
            java.lang.Object r1 = androidx.room.util.DBUtil.getCoroutineContext(r1, r5, r11)
            if (r1 != r0) goto L5a
            goto L94
        L5a:
            r10 = r1
            r1 = r12
            r12 = r10
        L5d:
            kotlin.coroutines.i r12 = (kotlin.coroutines.i) r12
            androidx.room.TriggerBasedInvalidationTracker$createFlow$1$1 r5 = new androidx.room.TriggerBasedInvalidationTracker$createFlow$1$1
            androidx.room.TriggerBasedInvalidationTracker r6 = r11.this$0
            r5.<init>(r6, r2)
            r11.L$0 = r1
            r11.label = r4
            java.lang.Object r12 = kotlinx.coroutines.i.h(r12, r5, r11)
            if (r12 != r0) goto L71
            goto L94
        L71:
            r7 = r1
            goto L74
        L73:
            r7 = r12
        L74:
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef     // Catch: java.lang.Throwable -> L1f
            r5.<init>()     // Catch: java.lang.Throwable -> L1f
            androidx.room.TriggerBasedInvalidationTracker r12 = r11.this$0     // Catch: java.lang.Throwable -> L1f
            androidx.room.ObservedTableVersions r12 = androidx.room.TriggerBasedInvalidationTracker.access$getObservedTableVersions$p(r12)     // Catch: java.lang.Throwable -> L1f
            androidx.room.TriggerBasedInvalidationTracker$createFlow$1$2 r4 = new androidx.room.TriggerBasedInvalidationTracker$createFlow$1$2     // Catch: java.lang.Throwable -> L1f
            boolean r6 = r11.$emitInitialState     // Catch: java.lang.Throwable -> L1f
            java.lang.String[] r8 = r11.$resolvedTableNames     // Catch: java.lang.Throwable -> L1f
            int[] r9 = r11.$tableIds     // Catch: java.lang.Throwable -> L1f
            r4.<init>(r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L1f
            r11.L$0 = r2     // Catch: java.lang.Throwable -> L1f
            r11.label = r3     // Catch: java.lang.Throwable -> L1f
            java.lang.Object r12 = r12.collect(r4, r11)     // Catch: java.lang.Throwable -> L1f
            if (r12 != r0) goto L95
        L94:
            return r0
        L95:
            kotlin.KotlinNothingValueException r12 = new kotlin.KotlinNothingValueException     // Catch: java.lang.Throwable -> L1f
            r12.<init>()     // Catch: java.lang.Throwable -> L1f
            throw r12     // Catch: java.lang.Throwable -> L1f
        L9b:
            androidx.room.TriggerBasedInvalidationTracker r0 = r11.this$0
            androidx.room.ObservedTableStates r0 = androidx.room.TriggerBasedInvalidationTracker.access$getObservedTableStates$p(r0)
            int[] r1 = r11.$tableIds
            r0.onObserverRemoved$room_runtime_release(r1)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.TriggerBasedInvalidationTracker$createFlow$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
