package androidx.room;

import androidx.annotation.RestrictTo;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: D:\Downloads\app\classes.dex */
public final class RoomMasterTable {

    @NotNull
    private static final String COLUMN_ID = "id";

    @NotNull
    private static final String COLUMN_IDENTITY_HASH = "identity_hash";

    @NotNull
    public static final String CREATE_QUERY = "CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)";

    @NotNull
    public static final String DEFAULT_ID = "42";

    @NotNull
    public static final RoomMasterTable INSTANCE = new RoomMasterTable();

    @NotNull
    public static final String NAME = "room_master_table";

    @NotNull
    public static final String READ_QUERY = "SELECT identity_hash FROM room_master_table WHERE id = 42 LIMIT 1";

    @NotNull
    public static final String TABLE_NAME = "room_master_table";

    @JvmStatic
    @NotNull
    public static final String createInsertQuery(@NotNull String hash) {
        g0.p(hash, "hash");
        return "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '" + hash + "')";
    }

    private RoomMasterTable() {
    }
}
