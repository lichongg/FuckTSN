package androidx.room;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@DebugMetadata(c = "androidx.room.TriggerBasedInvalidationTracker", f = "InvalidationTracker.kt", i = {0, 0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_GET_FIRST_AUDIO_POS}, m = "stopTrackingTable", n = {"connection", "tableName"}, s = {"L$0", "L$1"})
/* loaded from: D:\Downloads\app\classes.dex */
final class TriggerBasedInvalidationTracker$stopTrackingTable$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TriggerBasedInvalidationTracker this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TriggerBasedInvalidationTracker$stopTrackingTable$1(TriggerBasedInvalidationTracker triggerBasedInvalidationTracker, kotlin.coroutines.e<? super TriggerBasedInvalidationTracker$stopTrackingTable$1> eVar) {
        super(eVar);
        this.this$0 = triggerBasedInvalidationTracker;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object stopTrackingTable;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        stopTrackingTable = this.this$0.stopTrackingTable(null, 0, this);
        return stopTrackingTable;
    }
}
