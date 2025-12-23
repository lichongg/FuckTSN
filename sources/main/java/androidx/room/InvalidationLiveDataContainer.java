package androidx.room;

import androidx.lifecycle.LiveData;
import androidx.sqlite.SQLiteConnection;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import java.util.concurrent.Callable;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class InvalidationLiveDataContainer {

    @NotNull
    private final RoomDatabase database;

    @NotNull
    private final Set<LiveData<?>> liveDataSet;

    @NotNull
    public final <T> LiveData<T> create(@NotNull String[] tableNames, boolean z5, @NotNull Callable<T> callableFunction) {
        g0.p(tableNames, "tableNames");
        g0.p(callableFunction, "callableFunction");
        return new RoomCallableTrackingLiveData(this.database, this, z5, tableNames, callableFunction);
    }

    public InvalidationLiveDataContainer(@NotNull RoomDatabase database) {
        g0.p(database, "database");
        this.database = database;
        Set<LiveData<?>> newSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
        g0.o(newSetFromMap, "newSetFromMap(...)");
        this.liveDataSet = newSetFromMap;
    }

    @NotNull
    public final Set<LiveData<?>> getLiveDataSet$room_runtime_release() {
        return this.liveDataSet;
    }

    public final void onActive(@NotNull LiveData<?> liveData) {
        g0.p(liveData, "liveData");
        this.liveDataSet.add(liveData);
    }

    public final void onInactive(@NotNull LiveData<?> liveData) {
        g0.p(liveData, "liveData");
        this.liveDataSet.remove(liveData);
    }

    @NotNull
    public final <T> LiveData<T> create(@NotNull String[] tableNames, boolean z5, @NotNull Function1<? super SQLiteConnection, ? extends T> lambdaFunction) {
        g0.p(tableNames, "tableNames");
        g0.p(lambdaFunction, "lambdaFunction");
        return new RoomLambdaTrackingLiveData(this.database, this, z5, tableNames, lambdaFunction);
    }
}
