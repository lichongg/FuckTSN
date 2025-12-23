package androidx.room.migration;

import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
final class MigrationImpl extends Migration {

    @NotNull
    private final Function1<SupportSQLiteDatabase, n1> migrateCallback;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public MigrationImpl(int i6, int i7, @NotNull Function1<? super SupportSQLiteDatabase, n1> migrateCallback) {
        super(i6, i7);
        g0.p(migrateCallback, "migrateCallback");
        this.migrateCallback = migrateCallback;
    }

    @NotNull
    public final Function1<SupportSQLiteDatabase, n1> getMigrateCallback() {
        return this.migrateCallback;
    }

    @Override // androidx.room.migration.Migration
    public void migrate(@NotNull SupportSQLiteDatabase db) {
        g0.p(db, "db");
        this.migrateCallback.invoke(db);
    }
}
