package okio;

import java.util.ArrayList;
import java.util.Map;
import kotlin.collections.f0;
import kotlin.collections.i1;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class FileMetadata {

    @Nullable
    private final Long createdAtMillis;

    @NotNull
    private final Map<kotlin.reflect.d<?>, Object> extras;
    private final boolean isDirectory;
    private final boolean isRegularFile;

    @Nullable
    private final Long lastAccessedAtMillis;

    @Nullable
    private final Long lastModifiedAtMillis;

    @Nullable
    private final Long size;

    @Nullable
    private final Path symlinkTarget;

    public FileMetadata() {
        this(false, false, null, null, null, null, null, null, 255, null);
    }

    public FileMetadata(boolean z5, boolean z6, @Nullable Path path, @Nullable Long l6, @Nullable Long l7, @Nullable Long l8, @Nullable Long l9, @NotNull Map<kotlin.reflect.d<?>, ? extends Object> extras) {
        g0.p(extras, "extras");
        this.isRegularFile = z5;
        this.isDirectory = z6;
        this.symlinkTarget = path;
        this.size = l6;
        this.createdAtMillis = l7;
        this.lastModifiedAtMillis = l8;
        this.lastAccessedAtMillis = l9;
        this.extras = i1.D0(extras);
    }

    public static /* synthetic */ FileMetadata copy$default(FileMetadata fileMetadata, boolean z5, boolean z6, Path path, Long l6, Long l7, Long l8, Long l9, Map map, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            z5 = fileMetadata.isRegularFile;
        }
        if ((i6 & 2) != 0) {
            z6 = fileMetadata.isDirectory;
        }
        if ((i6 & 4) != 0) {
            path = fileMetadata.symlinkTarget;
        }
        if ((i6 & 8) != 0) {
            l6 = fileMetadata.size;
        }
        if ((i6 & 16) != 0) {
            l7 = fileMetadata.createdAtMillis;
        }
        if ((i6 & 32) != 0) {
            l8 = fileMetadata.lastModifiedAtMillis;
        }
        if ((i6 & 64) != 0) {
            l9 = fileMetadata.lastAccessedAtMillis;
        }
        if ((i6 & 128) != 0) {
            map = fileMetadata.extras;
        }
        Long l10 = l9;
        Map map2 = map;
        Long l11 = l7;
        Long l12 = l8;
        return fileMetadata.copy(z5, z6, path, l6, l11, l12, l10, map2);
    }

    @NotNull
    public final FileMetadata copy(boolean z5, boolean z6, @Nullable Path path, @Nullable Long l6, @Nullable Long l7, @Nullable Long l8, @Nullable Long l9, @NotNull Map<kotlin.reflect.d<?>, ? extends Object> extras) {
        g0.p(extras, "extras");
        return new FileMetadata(z5, z6, path, l6, l7, l8, l9, extras);
    }

    @Nullable
    public final <T> T extra(@NotNull kotlin.reflect.d<? extends T> type) {
        g0.p(type, "type");
        Object obj = this.extras.get(type);
        if (obj == null) {
            return null;
        }
        return (T) kotlin.reflect.e.a(type, obj);
    }

    @Nullable
    public final Long getCreatedAtMillis() {
        return this.createdAtMillis;
    }

    @NotNull
    public final Map<kotlin.reflect.d<?>, Object> getExtras() {
        return this.extras;
    }

    @Nullable
    public final Long getLastAccessedAtMillis() {
        return this.lastAccessedAtMillis;
    }

    @Nullable
    public final Long getLastModifiedAtMillis() {
        return this.lastModifiedAtMillis;
    }

    @Nullable
    public final Long getSize() {
        return this.size;
    }

    @Nullable
    public final Path getSymlinkTarget() {
        return this.symlinkTarget;
    }

    public final boolean isDirectory() {
        return this.isDirectory;
    }

    public final boolean isRegularFile() {
        return this.isRegularFile;
    }

    @NotNull
    public String toString() {
        ArrayList arrayList = new ArrayList();
        if (this.isRegularFile) {
            arrayList.add("isRegularFile");
        }
        if (this.isDirectory) {
            arrayList.add("isDirectory");
        }
        if (this.size != null) {
            arrayList.add("byteCount=" + this.size.longValue());
        }
        if (this.createdAtMillis != null) {
            arrayList.add("createdAt=" + this.createdAtMillis.longValue());
        }
        if (this.lastModifiedAtMillis != null) {
            arrayList.add("lastModifiedAt=" + this.lastModifiedAtMillis.longValue());
        }
        if (this.lastAccessedAtMillis != null) {
            arrayList.add("lastAccessedAt=" + this.lastAccessedAtMillis.longValue());
        }
        if (!this.extras.isEmpty()) {
            arrayList.add("extras=" + this.extras);
        }
        return f0.r3(arrayList, ", ", "FileMetadata(", ")", 0, null, null, 56, null);
    }

    public /* synthetic */ FileMetadata(boolean z5, boolean z6, Path path, Long l6, Long l7, Long l8, Long l9, Map map, int i6, v vVar) {
        this((i6 & 1) != 0 ? false : z5, (i6 & 2) != 0 ? false : z6, (i6 & 4) != 0 ? null : path, (i6 & 8) != 0 ? null : l6, (i6 & 16) != 0 ? null : l7, (i6 & 32) != 0 ? null : l8, (i6 & 64) != 0 ? null : l9, (i6 & 128) != 0 ? i1.z() : map);
    }
}
