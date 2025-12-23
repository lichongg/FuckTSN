package androidx.room;

import androidx.room.ObservedTableStates;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@DebugMetadata(c = "androidx.room.TriggerBasedInvalidationTracker$syncTriggers$2$1", f = "InvalidationTracker.kt", i = {0}, l = {301, MediaPlayer.MEDIA_PLAYER_OPTION_START_PLAY_BUFFER_THRES}, m = "invokeSuspend", n = {"connection"}, s = {"L$0"})
/* loaded from: D:\Downloads\app\classes.dex */
final class TriggerBasedInvalidationTracker$syncTriggers$2$1 extends SuspendLambda implements Function2<Transactor, kotlin.coroutines.e<? super n1>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ TriggerBasedInvalidationTracker this$0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "androidx.room.TriggerBasedInvalidationTracker$syncTriggers$2$1$1", f = "InvalidationTracker.kt", i = {0, 0, 1, 1}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_ADVANCE_CHECK_BUFFERING_END, MediaPlayer.MEDIA_PLAYER_OPTION_WAIT_TIME_AFTER_FIRST_FRAME}, m = "invokeSuspend", n = {"$this$forEachIndexed$iv", "index$iv", "$this$forEachIndexed$iv", "index$iv"}, s = {"L$0", "I$0", "L$0", "I$0"})
    @SourceDebugExtension({"SMAP\nInvalidationTracker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InvalidationTracker.kt\nandroidx/room/TriggerBasedInvalidationTracker$syncTriggers$2$1$1\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,604:1\n13467#2,3:605\n*S KotlinDebug\n*F\n+ 1 InvalidationTracker.kt\nandroidx/room/TriggerBasedInvalidationTracker$syncTriggers$2$1$1\n*L\n310#1:605,3\n*E\n"})
    /* renamed from: androidx.room.TriggerBasedInvalidationTracker$syncTriggers$2$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<TransactionScope<n1>, kotlin.coroutines.e<? super n1>, Object> {
        final /* synthetic */ Transactor $connection;
        final /* synthetic */ ObservedTableStates.ObserveOp[] $tablesToSync;
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ TriggerBasedInvalidationTracker this$0;

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(TransactionScope<n1> transactionScope, kotlin.coroutines.e<? super n1> eVar) {
            return ((AnonymousClass1) create(transactionScope, eVar)).invokeSuspend(n1.f44123a);
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: androidx.room.TriggerBasedInvalidationTracker$syncTriggers$2$1$1$WhenMappings */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[ObservedTableStates.ObserveOp.values().length];
                try {
                    iArr[ObservedTableStates.ObserveOp.NO_OP.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[ObservedTableStates.ObserveOp.ADD.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[ObservedTableStates.ObserveOp.REMOVE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ObservedTableStates.ObserveOp[] observeOpArr, TriggerBasedInvalidationTracker triggerBasedInvalidationTracker, Transactor transactor, kotlin.coroutines.e<? super AnonymousClass1> eVar) {
            super(2, eVar);
            this.$tablesToSync = observeOpArr;
            this.this$0 = triggerBasedInvalidationTracker;
            this.$connection = transactor;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
            return new AnonymousClass1(this.$tablesToSync, this.this$0, this.$connection, eVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:24:0x0083, code lost:
        
            if (r5 == r0) goto L25;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x0068, code lost:
        
            r6 = r12;
            r5 = r9;
         */
        /* JADX WARN: Removed duplicated region for block: B:12:0x003e  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0089  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0086 -> B:10:0x0087). Please report as a decompilation issue!!! */
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
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L2c
                if (r1 == r3) goto Le
                if (r1 != r2) goto L24
            Le:
                int r1 = r11.I$2
                int r4 = r11.I$1
                int r5 = r11.I$0
                java.lang.Object r6 = r11.L$2
                androidx.room.Transactor r6 = (androidx.room.Transactor) r6
                java.lang.Object r7 = r11.L$1
                androidx.room.TriggerBasedInvalidationTracker r7 = (androidx.room.TriggerBasedInvalidationTracker) r7
                java.lang.Object r8 = r11.L$0
                androidx.room.ObservedTableStates$ObserveOp[] r8 = (androidx.room.ObservedTableStates.ObserveOp[]) r8
                kotlin.g0.n(r12)
                goto L68
            L24:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r12.<init>(r0)
                throw r12
            L2c:
                kotlin.g0.n(r12)
                androidx.room.ObservedTableStates$ObserveOp[] r12 = r11.$tablesToSync
                androidx.room.TriggerBasedInvalidationTracker r1 = r11.this$0
                androidx.room.Transactor r4 = r11.$connection
                int r5 = r12.length
                r6 = 0
                r8 = r12
                r7 = r1
                r12 = r4
                r1 = r5
                r4 = 0
            L3c:
                if (r4 >= r1) goto L89
                r5 = r8[r4]
                int r9 = r6 + 1
                int[] r10 = androidx.room.TriggerBasedInvalidationTracker$syncTriggers$2$1.AnonymousClass1.WhenMappings.$EnumSwitchMapping$0
                int r5 = r5.ordinal()
                r5 = r10[r5]
                if (r5 == r3) goto L86
                if (r5 == r2) goto L71
                r10 = 3
                if (r5 != r10) goto L6b
                r11.L$0 = r8
                r11.L$1 = r7
                r11.L$2 = r12
                r11.I$0 = r9
                r11.I$1 = r4
                r11.I$2 = r1
                r11.label = r2
                java.lang.Object r5 = androidx.room.TriggerBasedInvalidationTracker.access$stopTrackingTable(r7, r12, r6, r11)
                if (r5 != r0) goto L66
                goto L85
            L66:
                r6 = r12
                r5 = r9
            L68:
                r12 = r6
                r6 = r5
                goto L87
            L6b:
                kotlin.NoWhenBranchMatchedException r12 = new kotlin.NoWhenBranchMatchedException
                r12.<init>()
                throw r12
            L71:
                r11.L$0 = r8
                r11.L$1 = r7
                r11.L$2 = r12
                r11.I$0 = r9
                r11.I$1 = r4
                r11.I$2 = r1
                r11.label = r3
                java.lang.Object r5 = androidx.room.TriggerBasedInvalidationTracker.access$startTrackingTable(r7, r12, r6, r11)
                if (r5 != r0) goto L66
            L85:
                return r0
            L86:
                r6 = r9
            L87:
                int r4 = r4 + r3
                goto L3c
            L89:
                kotlin.n1 r12 = kotlin.n1.f44123a
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.TriggerBasedInvalidationTracker$syncTriggers$2$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Transactor transactor, kotlin.coroutines.e<? super n1> eVar) {
        return ((TriggerBasedInvalidationTracker$syncTriggers$2$1) create(transactor, eVar)).invokeSuspend(n1.f44123a);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TriggerBasedInvalidationTracker$syncTriggers$2$1(TriggerBasedInvalidationTracker triggerBasedInvalidationTracker, kotlin.coroutines.e<? super TriggerBasedInvalidationTracker$syncTriggers$2$1> eVar) {
        super(2, eVar);
        this.this$0 = triggerBasedInvalidationTracker;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
        TriggerBasedInvalidationTracker$syncTriggers$2$1 triggerBasedInvalidationTracker$syncTriggers$2$1 = new TriggerBasedInvalidationTracker$syncTriggers$2$1(this.this$0, eVar);
        triggerBasedInvalidationTracker$syncTriggers$2$1.L$0 = obj;
        return triggerBasedInvalidationTracker$syncTriggers$2$1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x005e, code lost:
    
        if (r1.withTransaction(r3, r4, r7) == r0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0060, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0032, code lost:
    
        if (r8 == r0) goto L21;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.a.l()
            int r1 = r7.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L22
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.g0.n(r8)
            goto L61
        L12:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L1a:
            java.lang.Object r1 = r7.L$0
            androidx.room.Transactor r1 = (androidx.room.Transactor) r1
            kotlin.g0.n(r8)
            goto L35
        L22:
            kotlin.g0.n(r8)
            java.lang.Object r8 = r7.L$0
            r1 = r8
            androidx.room.Transactor r1 = (androidx.room.Transactor) r1
            r7.L$0 = r1
            r7.label = r3
            java.lang.Object r8 = r1.inTransaction(r7)
            if (r8 != r0) goto L35
            goto L60
        L35:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L40
            kotlin.n1 r8 = kotlin.n1.f44123a
            return r8
        L40:
            androidx.room.TriggerBasedInvalidationTracker r8 = r7.this$0
            androidx.room.ObservedTableStates r8 = androidx.room.TriggerBasedInvalidationTracker.access$getObservedTableStates$p(r8)
            androidx.room.ObservedTableStates$ObserveOp[] r8 = r8.getTablesToSync$room_runtime_release()
            if (r8 == 0) goto L61
            androidx.room.Transactor$SQLiteTransactionType r3 = androidx.room.Transactor.SQLiteTransactionType.IMMEDIATE
            androidx.room.TriggerBasedInvalidationTracker$syncTriggers$2$1$1 r4 = new androidx.room.TriggerBasedInvalidationTracker$syncTriggers$2$1$1
            androidx.room.TriggerBasedInvalidationTracker r5 = r7.this$0
            r6 = 0
            r4.<init>(r8, r5, r1, r6)
            r7.L$0 = r6
            r7.label = r2
            java.lang.Object r8 = r1.withTransaction(r3, r4, r7)
            if (r8 != r0) goto L61
        L60:
            return r0
        L61:
            kotlin.n1 r8 = kotlin.n1.f44123a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.TriggerBasedInvalidationTracker$syncTriggers$2$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
