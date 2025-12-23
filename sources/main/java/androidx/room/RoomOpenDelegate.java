package androidx.room;

import androidx.annotation.RestrictTo;
import androidx.sqlite.SQLiteConnection;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: D:\Downloads\app\classes.dex */
public abstract class RoomOpenDelegate implements RoomOpenDelegateMarker {

    @NotNull
    private final String identityHash;

    @NotNull
    private final String legacyIdentityHash;
    private final int version;

    public abstract void createAllTables(@NotNull SQLiteConnection sQLiteConnection);

    public abstract void dropAllTables(@NotNull SQLiteConnection sQLiteConnection);

    public abstract void onCreate(@NotNull SQLiteConnection sQLiteConnection);

    public abstract void onOpen(@NotNull SQLiteConnection sQLiteConnection);

    public abstract void onPostMigrate(@NotNull SQLiteConnection sQLiteConnection);

    public abstract void onPreMigrate(@NotNull SQLiteConnection sQLiteConnection);

    @NotNull
    public abstract ValidationResult onValidateSchema(@NotNull SQLiteConnection sQLiteConnection);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final class ValidationResult {

        @JvmField
        @Nullable
        public final String expectedFoundMsg;

        @JvmField
        public final boolean isValid;

        public ValidationResult(boolean z5, @Nullable String str) {
            this.isValid = z5;
            this.expectedFoundMsg = str;
        }
    }

    public RoomOpenDelegate(int i6, @NotNull String identityHash, @NotNull String legacyIdentityHash) {
        g0.p(identityHash, "identityHash");
        g0.p(legacyIdentityHash, "legacyIdentityHash");
        this.version = i6;
        this.identityHash = identityHash;
        this.legacyIdentityHash = legacyIdentityHash;
    }

    @NotNull
    public final String getIdentityHash() {
        return this.identityHash;
    }

    @NotNull
    public final String getLegacyIdentityHash() {
        return this.legacyIdentityHash;
    }

    public final int getVersion() {
        return this.version;
    }
}
