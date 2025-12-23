package androidx.room.coroutines;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@DebugMetadata(c = "androidx.room.coroutines.ConnectionPoolImpl", f = "ConnectionPoolImpl.kt", i = {2, 2, 2, 2, 2, 2, 3, 3}, l = {116, 120, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_END_TIME, 143}, m = "useConnection", n = {"this", "block", "pool", "connection", "currentContext", "isReadOnly", "pool", "connection"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "L$0", "L$1"})
/* loaded from: D:\Downloads\app\classes.dex */
final class ConnectionPoolImpl$useConnection$1<R> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ConnectionPoolImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ConnectionPoolImpl$useConnection$1(ConnectionPoolImpl connectionPoolImpl, kotlin.coroutines.e<? super ConnectionPoolImpl$useConnection$1> eVar) {
        super(eVar);
        this.this$0 = connectionPoolImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.useConnection(false, null, this);
    }
}
