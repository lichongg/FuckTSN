package androidx.room;

import java.util.concurrent.Callable;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class RoomCallableTrackingLiveData<T> extends RoomTrackingLiveData<T> {

    @NotNull
    private final Callable<T> callableFunction;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomCallableTrackingLiveData(@NotNull RoomDatabase database, @NotNull InvalidationLiveDataContainer container, boolean z5, @NotNull String[] tableNames, @NotNull Callable<T> callableFunction) {
        super(database, container, z5, tableNames, null);
        g0.p(database, "database");
        g0.p(container, "container");
        g0.p(tableNames, "tableNames");
        g0.p(callableFunction, "callableFunction");
        this.callableFunction = callableFunction;
    }

    @Override // androidx.room.RoomTrackingLiveData
    @Nullable
    public Object compute(@NotNull kotlin.coroutines.e<? super T> eVar) {
        return this.callableFunction.call();
    }
}
