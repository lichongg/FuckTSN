package androidx.room.migration;

import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JvmName(name = "MigrationKt")
/* loaded from: D:\Downloads\app\classes.dex */
public final class MigrationKt {
    @NotNull
    public static final Migration Migration(int i6, int i7, @NotNull Function1<? super SupportSQLiteDatabase, n1> migrate) {
        g0.p(migrate, "migrate");
        return new MigrationImpl(i6, i7, migrate);
    }
}
