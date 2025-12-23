package androidx.room.support;

import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import kotlin.jvm.internal.g0;
import kotlinx.coroutines.r0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class QueryInterceptorOpenHelperFactory implements SupportSQLiteOpenHelper.Factory {

    @NotNull
    private final SupportSQLiteOpenHelper.Factory delegate;

    @NotNull
    private final RoomDatabase.QueryCallback queryCallback;

    @NotNull
    private final r0 queryCallbackScope;

    public QueryInterceptorOpenHelperFactory(@NotNull SupportSQLiteOpenHelper.Factory delegate, @NotNull r0 queryCallbackScope, @NotNull RoomDatabase.QueryCallback queryCallback) {
        g0.p(delegate, "delegate");
        g0.p(queryCallbackScope, "queryCallbackScope");
        g0.p(queryCallback, "queryCallback");
        this.delegate = delegate;
        this.queryCallbackScope = queryCallbackScope;
        this.queryCallback = queryCallback;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Factory
    @NotNull
    public SupportSQLiteOpenHelper create(@NotNull SupportSQLiteOpenHelper.Configuration configuration) {
        g0.p(configuration, "configuration");
        return new QueryInterceptorOpenHelper(this.delegate.create(configuration), this.queryCallbackScope, this.queryCallback);
    }
}
