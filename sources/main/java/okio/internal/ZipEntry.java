package okio.internal;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.g0;
import okio.Path;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class ZipEntry {

    @NotNull
    private final Path canonicalPath;

    @NotNull
    private final List<Path> children;

    @NotNull
    private final String comment;
    private final long compressedSize;
    private final int compressionMethod;
    private final long crc;
    private final int dosLastModifiedAtDate;
    private final int dosLastModifiedAtTime;

    @Nullable
    private final Integer extendedCreatedAtSeconds;

    @Nullable
    private final Integer extendedLastAccessedAtSeconds;

    @Nullable
    private final Integer extendedLastModifiedAtSeconds;
    private final boolean isDirectory;

    @Nullable
    private final Long ntfsCreatedAtFiletime;

    @Nullable
    private final Long ntfsLastAccessedAtFiletime;

    @Nullable
    private final Long ntfsLastModifiedAtFiletime;
    private final long offset;
    private final long size;

    public ZipEntry(@NotNull Path canonicalPath, boolean z5, @NotNull String comment, long j6, long j7, long j8, int i6, long j9, int i7, int i8, @Nullable Long l6, @Nullable Long l7, @Nullable Long l8, @Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3) {
        g0.p(canonicalPath, "canonicalPath");
        g0.p(comment, "comment");
        this.canonicalPath = canonicalPath;
        this.isDirectory = z5;
        this.comment = comment;
        this.crc = j6;
        this.compressedSize = j7;
        this.size = j8;
        this.compressionMethod = i6;
        this.offset = j9;
        this.dosLastModifiedAtDate = i7;
        this.dosLastModifiedAtTime = i8;
        this.ntfsLastModifiedAtFiletime = l6;
        this.ntfsLastAccessedAtFiletime = l7;
        this.ntfsCreatedAtFiletime = l8;
        this.extendedLastModifiedAtSeconds = num;
        this.extendedLastAccessedAtSeconds = num2;
        this.extendedCreatedAtSeconds = num3;
        this.children = new ArrayList();
    }

    @NotNull
    public final ZipEntry copy$okio(@Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3) {
        return new ZipEntry(this.canonicalPath, this.isDirectory, this.comment, this.crc, this.compressedSize, this.size, this.compressionMethod, this.offset, this.dosLastModifiedAtDate, this.dosLastModifiedAtTime, this.ntfsLastModifiedAtFiletime, this.ntfsLastAccessedAtFiletime, this.ntfsCreatedAtFiletime, num, num2, num3);
    }

    @NotNull
    public final Path getCanonicalPath() {
        return this.canonicalPath;
    }

    @NotNull
    public final List<Path> getChildren() {
        return this.children;
    }

    @NotNull
    public final String getComment() {
        return this.comment;
    }

    public final long getCompressedSize() {
        return this.compressedSize;
    }

    public final int getCompressionMethod() {
        return this.compressionMethod;
    }

    public final long getCrc() {
        return this.crc;
    }

    @Nullable
    public final Long getCreatedAtMillis$okio() {
        Long l6 = this.ntfsCreatedAtFiletime;
        if (l6 != null) {
            return Long.valueOf(ZipFilesKt.filetimeToEpochMillis(l6.longValue()));
        }
        if (this.extendedCreatedAtSeconds != null) {
            return Long.valueOf(r0.intValue() * 1000);
        }
        return null;
    }

    public final int getDosLastModifiedAtDate() {
        return this.dosLastModifiedAtDate;
    }

    public final int getDosLastModifiedAtTime() {
        return this.dosLastModifiedAtTime;
    }

    @Nullable
    public final Integer getExtendedCreatedAtSeconds() {
        return this.extendedCreatedAtSeconds;
    }

    @Nullable
    public final Integer getExtendedLastAccessedAtSeconds() {
        return this.extendedLastAccessedAtSeconds;
    }

    @Nullable
    public final Integer getExtendedLastModifiedAtSeconds() {
        return this.extendedLastModifiedAtSeconds;
    }

    @Nullable
    public final Long getLastAccessedAtMillis$okio() {
        Long l6 = this.ntfsLastAccessedAtFiletime;
        if (l6 != null) {
            return Long.valueOf(ZipFilesKt.filetimeToEpochMillis(l6.longValue()));
        }
        if (this.extendedLastAccessedAtSeconds != null) {
            return Long.valueOf(r0.intValue() * 1000);
        }
        return null;
    }

    @Nullable
    public final Long getLastModifiedAtMillis$okio() {
        Long l6 = this.ntfsLastModifiedAtFiletime;
        if (l6 != null) {
            return Long.valueOf(ZipFilesKt.filetimeToEpochMillis(l6.longValue()));
        }
        if (this.extendedLastModifiedAtSeconds != null) {
            return Long.valueOf(r0.intValue() * 1000);
        }
        int i6 = this.dosLastModifiedAtTime;
        if (i6 != -1) {
            return ZipFilesKt.dosDateTimeToEpochMillis(this.dosLastModifiedAtDate, i6);
        }
        return null;
    }

    @Nullable
    public final Long getNtfsCreatedAtFiletime() {
        return this.ntfsCreatedAtFiletime;
    }

    @Nullable
    public final Long getNtfsLastAccessedAtFiletime() {
        return this.ntfsLastAccessedAtFiletime;
    }

    @Nullable
    public final Long getNtfsLastModifiedAtFiletime() {
        return this.ntfsLastModifiedAtFiletime;
    }

    public final long getOffset() {
        return this.offset;
    }

    public final long getSize() {
        return this.size;
    }

    public final boolean isDirectory() {
        return this.isDirectory;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ ZipEntry(okio.Path r18, boolean r19, java.lang.String r20, long r21, long r23, long r25, int r27, long r28, int r30, int r31, java.lang.Long r32, java.lang.Long r33, java.lang.Long r34, java.lang.Integer r35, java.lang.Integer r36, java.lang.Integer r37, int r38, kotlin.jvm.internal.v r39) {
        /*
            Method dump skipped, instructions count: 177
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.ZipEntry.<init>(okio.Path, boolean, java.lang.String, long, long, long, int, long, int, int, java.lang.Long, java.lang.Long, java.lang.Long, java.lang.Integer, java.lang.Integer, java.lang.Integer, int, kotlin.jvm.internal.v):void");
    }
}
