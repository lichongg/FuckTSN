package androidx.room;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.g0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.n1;
import kotlinx.coroutines.r0;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@DebugMetadata(c = "androidx.room.TriggerBasedInvalidationTracker$refreshInvalidationAsync$3", f = "InvalidationTracker.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_MAX_CRYPTO_RETRANSMISSIONS}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\Downloads\app\classes.dex */
final class TriggerBasedInvalidationTracker$refreshInvalidationAsync$3 extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {
    final /* synthetic */ Function0<n1> $onRefreshCompleted;
    int label;
    final /* synthetic */ TriggerBasedInvalidationTracker this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TriggerBasedInvalidationTracker$refreshInvalidationAsync$3(TriggerBasedInvalidationTracker triggerBasedInvalidationTracker, Function0<n1> function0, kotlin.coroutines.e<? super TriggerBasedInvalidationTracker$refreshInvalidationAsync$3> eVar) {
        super(2, eVar);
        this.this$0 = triggerBasedInvalidationTracker;
        this.$onRefreshCompleted = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
        return new TriggerBasedInvalidationTracker$refreshInvalidationAsync$3(this.this$0, this.$onRefreshCompleted, eVar);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(r0 r0Var, kotlin.coroutines.e<? super n1> eVar) {
        return ((TriggerBasedInvalidationTracker$refreshInvalidationAsync$3) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object l6 = kotlin.coroutines.intrinsics.a.l();
        int i6 = this.label;
        try {
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
                obj = triggerBasedInvalidationTracker.notifyInvalidation(this);
                if (obj == l6) {
                    return l6;
                }
            }
            this.$onRefreshCompleted.invoke();
            return n1.f44123a;
        } catch (Throwable th) {
            this.$onRefreshCompleted.invoke();
            throw th;
        }
    }
}
