package androidx.room.support;

import androidx.sqlite.db.SupportSQLiteOpenHelper;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class AutoClosingRoomOpenHelperFactory implements SupportSQLiteOpenHelper.Factory {

    @NotNull
    private final AutoCloser autoCloser;

    @NotNull
    private final SupportSQLiteOpenHelper.Factory delegate;

    public AutoClosingRoomOpenHelperFactory(@NotNull SupportSQLiteOpenHelper.Factory delegate, @NotNull AutoCloser autoCloser) {
        g0.p(delegate, "delegate");
        g0.p(autoCloser, "autoCloser");
        this.delegate = delegate;
        this.autoCloser = autoCloser;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Factory
    @NotNull
    public AutoClosingRoomOpenHelper create(@NotNull SupportSQLiteOpenHelper.Configuration configuration) {
        g0.p(configuration, "configuration");
        return new AutoClosingRoomOpenHelper(this.delegate.create(configuration), this.autoCloser);
    }
}
