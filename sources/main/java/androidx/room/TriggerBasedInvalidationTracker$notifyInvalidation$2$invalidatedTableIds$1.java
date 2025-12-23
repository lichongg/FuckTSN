package androidx.room;

import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.util.Set;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.g0;
import kotlin.jvm.functions.Function2;
import kotlin.n1;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@DebugMetadata(c = "androidx.room.TriggerBasedInvalidationTracker$notifyInvalidation$2$invalidatedTableIds$1", f = "InvalidationTracker.kt", i = {0}, l = {TTAdConstant.VIDEO_INFO_CODE, org.apache.commons.net.nntp.h.f50924w}, m = "invokeSuspend", n = {"connection"}, s = {"L$0"})
/* loaded from: D:\Downloads\app\classes.dex */
final class TriggerBasedInvalidationTracker$notifyInvalidation$2$invalidatedTableIds$1 extends SuspendLambda implements Function2<Transactor, kotlin.coroutines.e<? super Set<? extends Integer>>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ TriggerBasedInvalidationTracker this$0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "androidx.room.TriggerBasedInvalidationTracker$notifyInvalidation$2$invalidatedTableIds$1$1", f = "InvalidationTracker.kt", i = {}, l = {421}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.room.TriggerBasedInvalidationTracker$notifyInvalidation$2$invalidatedTableIds$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<TransactionScope<Set<? extends Integer>>, kotlin.coroutines.e<? super Set<? extends Integer>>, Object> {
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ TriggerBasedInvalidationTracker this$0;

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(TransactionScope<Set<Integer>> transactionScope, kotlin.coroutines.e<? super Set<Integer>> eVar) {
            return ((AnonymousClass1) create(transactionScope, eVar)).invokeSuspend(n1.f44123a);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(TriggerBasedInvalidationTracker triggerBasedInvalidationTracker, kotlin.coroutines.e<? super AnonymousClass1> eVar) {
            super(2, eVar);
            this.this$0 = triggerBasedInvalidationTracker;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, eVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(TransactionScope<Set<? extends Integer>> transactionScope, kotlin.coroutines.e<? super Set<? extends Integer>> eVar) {
            return invoke2((TransactionScope<Set<Integer>>) transactionScope, (kotlin.coroutines.e<? super Set<Integer>>) eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object checkInvalidatedTables;
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.label;
            if (i6 != 0) {
                if (i6 == 1) {
                    g0.n(obj);
                    return obj;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            g0.n(obj);
            TransactionScope transactionScope = (TransactionScope) this.L$0;
            TriggerBasedInvalidationTracker triggerBasedInvalidationTracker = this.this$0;
            this.label = 1;
            checkInvalidatedTables = triggerBasedInvalidationTracker.checkInvalidatedTables(transactionScope, this);
            if (checkInvalidatedTables == l6) {
                return l6;
            }
            return checkInvalidatedTables;
        }
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Transactor transactor, kotlin.coroutines.e<? super Set<Integer>> eVar) {
        return ((TriggerBasedInvalidationTracker$notifyInvalidation$2$invalidatedTableIds$1) create(transactor, eVar)).invokeSuspend(n1.f44123a);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TriggerBasedInvalidationTracker$notifyInvalidation$2$invalidatedTableIds$1(TriggerBasedInvalidationTracker triggerBasedInvalidationTracker, kotlin.coroutines.e<? super TriggerBasedInvalidationTracker$notifyInvalidation$2$invalidatedTableIds$1> eVar) {
        super(2, eVar);
        this.this$0 = triggerBasedInvalidationTracker;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
        TriggerBasedInvalidationTracker$notifyInvalidation$2$invalidatedTableIds$1 triggerBasedInvalidationTracker$notifyInvalidation$2$invalidatedTableIds$1 = new TriggerBasedInvalidationTracker$notifyInvalidation$2$invalidatedTableIds$1(this.this$0, eVar);
        triggerBasedInvalidationTracker$notifyInvalidation$2$invalidatedTableIds$1.L$0 = obj;
        return triggerBasedInvalidationTracker$notifyInvalidation$2$invalidatedTableIds$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Transactor transactor, kotlin.coroutines.e<? super Set<? extends Integer>> eVar) {
        return invoke2(transactor, (kotlin.coroutines.e<? super Set<Integer>>) eVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0054, code lost:
    
        if (r7 == r0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0056, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0032, code lost:
    
        if (r7 == r0) goto L20;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.a.l()
            int r1 = r6.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L22
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.g0.n(r7)     // Catch: android.database.SQLException -> L5a
            goto L57
        L12:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L1a:
            java.lang.Object r1 = r6.L$0
            androidx.room.Transactor r1 = (androidx.room.Transactor) r1
            kotlin.g0.n(r7)
            goto L35
        L22:
            kotlin.g0.n(r7)
            java.lang.Object r7 = r6.L$0
            r1 = r7
            androidx.room.Transactor r1 = (androidx.room.Transactor) r1
            r6.L$0 = r1
            r6.label = r3
            java.lang.Object r7 = r1.inTransaction(r6)
            if (r7 != r0) goto L35
            goto L56
        L35:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L42
            java.util.Set r7 = kotlin.collections.u1.k()
            return r7
        L42:
            androidx.room.Transactor$SQLiteTransactionType r7 = androidx.room.Transactor.SQLiteTransactionType.IMMEDIATE     // Catch: android.database.SQLException -> L5a
            androidx.room.TriggerBasedInvalidationTracker$notifyInvalidation$2$invalidatedTableIds$1$1 r3 = new androidx.room.TriggerBasedInvalidationTracker$notifyInvalidation$2$invalidatedTableIds$1$1     // Catch: android.database.SQLException -> L5a
            androidx.room.TriggerBasedInvalidationTracker r4 = r6.this$0     // Catch: android.database.SQLException -> L5a
            r5 = 0
            r3.<init>(r4, r5)     // Catch: android.database.SQLException -> L5a
            r6.L$0 = r5     // Catch: android.database.SQLException -> L5a
            r6.label = r2     // Catch: android.database.SQLException -> L5a
            java.lang.Object r7 = r1.withTransaction(r7, r3, r6)     // Catch: android.database.SQLException -> L5a
            if (r7 != r0) goto L57
        L56:
            return r0
        L57:
            java.util.Set r7 = (java.util.Set) r7     // Catch: android.database.SQLException -> L5a
            return r7
        L5a:
            java.util.Set r7 = kotlin.collections.u1.k()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.TriggerBasedInvalidationTracker$notifyInvalidation$2$invalidatedTableIds$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
