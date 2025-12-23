package androidx.room;

import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.g0;
import kotlin.jvm.functions.Function2;
import kotlin.n1;
import kotlinx.coroutines.r0;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@DebugMetadata(c = "androidx.room.InvalidationTracker$addObserver$1", f = "InvalidationTracker.android.kt", i = {}, l = {253}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\Downloads\app\classes.dex */
final class InvalidationTracker$addObserver$1 extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {
    int label;
    final /* synthetic */ InvalidationTracker this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InvalidationTracker$addObserver$1(InvalidationTracker invalidationTracker, kotlin.coroutines.e<? super InvalidationTracker$addObserver$1> eVar) {
        super(2, eVar);
        this.this$0 = invalidationTracker;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
        return new InvalidationTracker$addObserver$1(this.this$0, eVar);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(r0 r0Var, kotlin.coroutines.e<? super n1> eVar) {
        return ((InvalidationTracker$addObserver$1) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        TriggerBasedInvalidationTracker triggerBasedInvalidationTracker;
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
            triggerBasedInvalidationTracker = this.this$0.implementation;
            this.label = 1;
            if (triggerBasedInvalidationTracker.syncTriggers$room_runtime_release(this) == l6) {
                return l6;
            }
        }
        return n1.f44123a;
    }
}
