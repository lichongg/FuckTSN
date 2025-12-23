package androidx.room.coroutines;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@DebugMetadata(c = "androidx.room.coroutines.PooledConnectionImpl", f = "ConnectionPoolImpl.kt", i = {0, 0, 1, 1, 4}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_PAD_HELLO, 399, 412, 412, 412}, m = "transaction", n = {"this", "block", "this", "success", "exception"}, s = {"L$0", "L$1", "L$0", "I$0", "L$0"})
/* loaded from: D:\Downloads\app\classes.dex */
final class PooledConnectionImpl$transaction$1<R> extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PooledConnectionImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PooledConnectionImpl$transaction$1(PooledConnectionImpl pooledConnectionImpl, kotlin.coroutines.e<? super PooledConnectionImpl$transaction$1> eVar) {
        super(eVar);
        this.this$0 = pooledConnectionImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.transaction(null, null, this);
    }
}
