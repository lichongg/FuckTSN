package androidx.room;

import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.room.InvalidationTracker;
import java.util.Set;
import kotlin.jvm.internal.g0;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class RoomTrackingLiveData$observer$1 extends InvalidationTracker.Observer {
    final /* synthetic */ RoomTrackingLiveData<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RoomTrackingLiveData$observer$1(String[] strArr, RoomTrackingLiveData<T> roomTrackingLiveData) {
        super(strArr);
        this.this$0 = roomTrackingLiveData;
    }

    @Override // androidx.room.InvalidationTracker.Observer
    public void onInvalidated(Set<String> tables) {
        g0.p(tables, "tables");
        ArchTaskExecutor archTaskExecutor = ArchTaskExecutor.getInstance();
        final RoomTrackingLiveData<T> roomTrackingLiveData = this.this$0;
        archTaskExecutor.executeOnMainThread(new Runnable() { // from class: androidx.room.t
            @Override // java.lang.Runnable
            public final void run() {
                RoomTrackingLiveData.access$invalidated(RoomTrackingLiveData.this);
            }
        });
    }
}
