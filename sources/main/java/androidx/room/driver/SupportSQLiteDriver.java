package androidx.room.driver;

import androidx.annotation.RestrictTo;
import androidx.sqlite.SQLiteDriver;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes.dex */
public final class SupportSQLiteDriver implements SQLiteDriver {

    @NotNull
    private final SupportSQLiteOpenHelper openHelper;

    public SupportSQLiteDriver(@NotNull SupportSQLiteOpenHelper openHelper) {
        g0.p(openHelper, "openHelper");
        this.openHelper = openHelper;
    }

    @NotNull
    public final SupportSQLiteOpenHelper getOpenHelper() {
        return this.openHelper;
    }

    @Override // androidx.sqlite.SQLiteDriver
    @NotNull
    public SupportSQLiteConnection open(@NotNull String fileName) {
        g0.p(fileName, "fileName");
        return new SupportSQLiteConnection(this.openHelper.getWritableDatabase());
    }
}
