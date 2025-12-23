package androidx.room;

import androidx.room.InvalidationTracker;
import java.lang.ref.WeakReference;
import java.util.Set;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class WeakObserver extends InvalidationTracker.Observer {

    @NotNull
    private final WeakReference<InvalidationTracker.Observer> delegateRef;

    @NotNull
    private final InvalidationTracker tracker;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WeakObserver(@NotNull InvalidationTracker tracker, @NotNull InvalidationTracker.Observer delegate) {
        super(delegate.getTables$room_runtime_release());
        g0.p(tracker, "tracker");
        g0.p(delegate, "delegate");
        this.tracker = tracker;
        this.delegateRef = new WeakReference<>(delegate);
    }

    @Override // androidx.room.InvalidationTracker.Observer
    public void onInvalidated(@NotNull Set<String> tables) {
        g0.p(tables, "tables");
        InvalidationTracker.Observer observer = this.delegateRef.get();
        if (observer == null) {
            this.tracker.removeObserver(this);
        } else {
            observer.onInvalidated(tables);
        }
    }
}
