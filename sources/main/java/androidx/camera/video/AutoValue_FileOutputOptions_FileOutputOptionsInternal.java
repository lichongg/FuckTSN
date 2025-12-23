package androidx.camera.video;

import android.location.Location;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.video.FileOutputOptions;
import java.io.File;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
final class AutoValue_FileOutputOptions_FileOutputOptionsInternal extends FileOutputOptions.FileOutputOptionsInternal {
    private final long durationLimitMillis;
    private final File file;
    private final long fileSizeLimit;
    private final Location location;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class Builder extends FileOutputOptions.FileOutputOptionsInternal.Builder {
        private Long durationLimitMillis;
        private File file;
        private Long fileSizeLimit;
        private Location location;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.camera.video.FileOutputOptions.FileOutputOptionsInternal.Builder, androidx.camera.video.OutputOptions.OutputOptionsInternal.Builder
        public FileOutputOptions.FileOutputOptionsInternal build() {
            String str = "";
            if (this.fileSizeLimit == null) {
                str = " fileSizeLimit";
            }
            if (this.durationLimitMillis == null) {
                str = str + " durationLimitMillis";
            }
            if (this.file == null) {
                str = str + " file";
            }
            if (str.isEmpty()) {
                return new AutoValue_FileOutputOptions_FileOutputOptionsInternal(this.fileSizeLimit.longValue(), this.durationLimitMillis.longValue(), this.location, this.file);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.video.OutputOptions.OutputOptionsInternal.Builder
        public FileOutputOptions.FileOutputOptionsInternal.Builder setDurationLimitMillis(long j6) {
            this.durationLimitMillis = Long.valueOf(j6);
            return this;
        }

        @Override // androidx.camera.video.FileOutputOptions.FileOutputOptionsInternal.Builder
        FileOutputOptions.FileOutputOptionsInternal.Builder setFile(File file) {
            if (file == null) {
                throw new NullPointerException("Null file");
            }
            this.file = file;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.video.OutputOptions.OutputOptionsInternal.Builder
        public FileOutputOptions.FileOutputOptionsInternal.Builder setFileSizeLimit(long j6) {
            this.fileSizeLimit = Long.valueOf(j6);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.video.OutputOptions.OutputOptionsInternal.Builder
        public FileOutputOptions.FileOutputOptionsInternal.Builder setLocation(@Nullable Location location) {
            this.location = location;
            return this;
        }

        Builder() {
        }
    }

    public boolean equals(Object obj) {
        Location location;
        if (obj == this) {
            return true;
        }
        if (obj instanceof FileOutputOptions.FileOutputOptionsInternal) {
            FileOutputOptions.FileOutputOptionsInternal fileOutputOptionsInternal = (FileOutputOptions.FileOutputOptionsInternal) obj;
            if (this.fileSizeLimit == fileOutputOptionsInternal.getFileSizeLimit() && this.durationLimitMillis == fileOutputOptionsInternal.getDurationLimitMillis() && ((location = this.location) != null ? location.equals(fileOutputOptionsInternal.getLocation()) : fileOutputOptionsInternal.getLocation() == null) && this.file.equals(fileOutputOptionsInternal.getFile())) {
                return true;
            }
        }
        return false;
    }

    private AutoValue_FileOutputOptions_FileOutputOptionsInternal(long j6, long j7, @Nullable Location location, File file) {
        this.fileSizeLimit = j6;
        this.durationLimitMillis = j7;
        this.location = location;
        this.file = file;
    }

    @Override // androidx.camera.video.OutputOptions.OutputOptionsInternal
    @IntRange(from = 0)
    long getDurationLimitMillis() {
        return this.durationLimitMillis;
    }

    @Override // androidx.camera.video.FileOutputOptions.FileOutputOptionsInternal
    @NonNull
    File getFile() {
        return this.file;
    }

    @Override // androidx.camera.video.OutputOptions.OutputOptionsInternal
    @IntRange(from = 0)
    long getFileSizeLimit() {
        return this.fileSizeLimit;
    }

    @Override // androidx.camera.video.OutputOptions.OutputOptionsInternal
    @Nullable
    Location getLocation() {
        return this.location;
    }

    public int hashCode() {
        long j6 = this.fileSizeLimit;
        long j7 = this.durationLimitMillis;
        int i6 = (((((int) (j6 ^ (j6 >>> 32))) ^ 1000003) * 1000003) ^ ((int) (j7 ^ (j7 >>> 32)))) * 1000003;
        Location location = this.location;
        return this.file.hashCode() ^ ((i6 ^ (location == null ? 0 : location.hashCode())) * 1000003);
    }

    public String toString() {
        return "FileOutputOptionsInternal{fileSizeLimit=" + this.fileSizeLimit + ", durationLimitMillis=" + this.durationLimitMillis + ", location=" + this.location + ", file=" + this.file + "}";
    }
}
