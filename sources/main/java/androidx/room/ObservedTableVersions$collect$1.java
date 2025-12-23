package androidx.room;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@DebugMetadata(c = "androidx.room.ObservedTableVersions", f = "InvalidationTracker.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_BUFLEN}, m = "collect", n = {}, s = {})
/* loaded from: D:\Downloads\app\classes.dex */
final class ObservedTableVersions$collect$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ObservedTableVersions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ObservedTableVersions$collect$1(ObservedTableVersions observedTableVersions, kotlin.coroutines.e<? super ObservedTableVersions$collect$1> eVar) {
        super(eVar);
        this.this$0 = observedTableVersions;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.collect(null, this);
    }
}
