package androidx.room;

import androidx.room.util.DBUtil;
import androidx.sqlite.SQLiteConnection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class RoomLambdaTrackingLiveData<T> extends RoomTrackingLiveData<T> {

    @NotNull
    private final Function1<SQLiteConnection, T> lambdaFunction;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public RoomLambdaTrackingLiveData(@NotNull RoomDatabase database, @NotNull InvalidationLiveDataContainer container, boolean z5, @NotNull String[] tableNames, @NotNull Function1<? super SQLiteConnection, ? extends T> lambdaFunction) {
        super(database, container, z5, tableNames, null);
        g0.p(database, "database");
        g0.p(container, "container");
        g0.p(tableNames, "tableNames");
        g0.p(lambdaFunction, "lambdaFunction");
        this.lambdaFunction = lambdaFunction;
    }

    @Override // androidx.room.RoomTrackingLiveData
    @Nullable
    public Object compute(@NotNull kotlin.coroutines.e<? super T> eVar) {
        return DBUtil.performSuspending(getDatabase(), true, getInTransaction(), this.lambdaFunction, eVar);
    }
}
