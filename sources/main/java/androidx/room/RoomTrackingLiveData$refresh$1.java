package androidx.room;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@DebugMetadata(c = "androidx.room.RoomTrackingLiveData", f = "RoomTrackingLiveData.android.kt", i = {0, 0}, l = {82}, m = "refresh", n = {"this", "computed"}, s = {"L$0", "I$0"})
/* loaded from: D:\Downloads\app\classes.dex */
final class RoomTrackingLiveData$refresh$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RoomTrackingLiveData<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RoomTrackingLiveData$refresh$1(RoomTrackingLiveData<T> roomTrackingLiveData, kotlin.coroutines.e<? super RoomTrackingLiveData$refresh$1> eVar) {
        super(eVar);
        this.this$0 = roomTrackingLiveData;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object refresh;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        refresh = this.this$0.refresh(this);
        return refresh;
    }
}
