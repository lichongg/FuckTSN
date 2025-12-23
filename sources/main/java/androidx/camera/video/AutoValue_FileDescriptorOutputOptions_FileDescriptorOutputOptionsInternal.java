package androidx.camera.video;

import android.location.Location;
import android.os.ParcelFileDescriptor;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.video.FileDescriptorOutputOptions;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
final class AutoValue_FileDescriptorOutputOptions_FileDescriptorOutputOptionsInternal extends FileDescriptorOutputOptions.FileDescriptorOutputOptionsInternal {
    private final long durationLimitMillis;
    private final long fileSizeLimit;
    private final Location location;
    private final ParcelFileDescriptor parcelFileDescriptor;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class Builder extends FileDescriptorOutputOptions.FileDescriptorOutputOptionsInternal.Builder {
        private Long durationLimitMillis;
        private Long fileSizeLimit;
        private Location location;
        private ParcelFileDescriptor parcelFileDescriptor;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.camera.video.FileDescriptorOutputOptions.FileDescriptorOutputOptionsInternal.Builder, androidx.camera.video.OutputOptions.OutputOptionsInternal.Builder
        public FileDescriptorOutputOptions.FileDescriptorOutputOptionsInternal build() {
            String str = "";
            if (this.fileSizeLimit == null) {
                str = " fileSizeLimit";
            }
            if (this.durationLimitMillis == null) {
                str = str + " durationLimitMillis";
            }
            if (this.parcelFileDescriptor == null) {
                str = str + " parcelFileDescriptor";
            }
            if (str.isEmpty()) {
                return new AutoValue_FileDescriptorOutputOptions_FileDescriptorOutputOptionsInternal(this.fileSizeLimit.longValue(), this.durationLimitMillis.longValue(), this.location, this.parcelFileDescriptor);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.video.OutputOptions.OutputOptionsInternal.Builder
        public FileDescriptorOutputOptions.FileDescriptorOutputOptionsInternal.Builder setDurationLimitMillis(long j6) {
            this.durationLimitMillis = Long.valueOf(j6);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.video.OutputOptions.OutputOptionsInternal.Builder
        public FileDescriptorOutputOptions.FileDescriptorOutputOptionsInternal.Builder setFileSizeLimit(long j6) {
            this.fileSizeLimit = Long.valueOf(j6);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.video.OutputOptions.OutputOptionsInternal.Builder
        public FileDescriptorOutputOptions.FileDescriptorOutputOptionsInternal.Builder setLocation(@Nullable Location location) {
            this.location = location;
            return this;
        }

        @Override // androidx.camera.video.FileDescriptorOutputOptions.FileDescriptorOutputOptionsInternal.Builder
        FileDescriptorOutputOptions.FileDescriptorOutputOptionsInternal.Builder setParcelFileDescriptor(ParcelFileDescriptor parcelFileDescriptor) {
            if (parcelFileDescriptor == null) {
                throw new NullPointerException("Null parcelFileDescriptor");
            }
            this.parcelFileDescriptor = parcelFileDescriptor;
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
        if (obj instanceof FileDescriptorOutputOptions.FileDescriptorOutputOptionsInternal) {
            FileDescriptorOutputOptions.FileDescriptorOutputOptionsInternal fileDescriptorOutputOptionsInternal = (FileDescriptorOutputOptions.FileDescriptorOutputOptionsInternal) obj;
            if (this.fileSizeLimit == fileDescriptorOutputOptionsInternal.getFileSizeLimit() && this.durationLimitMillis == fileDescriptorOutputOptionsInternal.getDurationLimitMillis() && ((location = this.location) != null ? location.equals(fileDescriptorOutputOptionsInternal.getLocation()) : fileDescriptorOutputOptionsInternal.getLocation() == null) && this.parcelFileDescriptor.equals(fileDescriptorOutputOptionsInternal.getParcelFileDescriptor())) {
                return true;
            }
        }
        return false;
    }

    private AutoValue_FileDescriptorOutputOptions_FileDescriptorOutputOptionsInternal(long j6, long j7, @Nullable Location location, ParcelFileDescriptor parcelFileDescriptor) {
        this.fileSizeLimit = j6;
        this.durationLimitMillis = j7;
        this.location = location;
        this.parcelFileDescriptor = parcelFileDescriptor;
    }

    @Override // androidx.camera.video.OutputOptions.OutputOptionsInternal
    @IntRange(from = 0)
    long getDurationLimitMillis() {
        return this.durationLimitMillis;
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

    @Override // androidx.camera.video.FileDescriptorOutputOptions.FileDescriptorOutputOptionsInternal
    @NonNull
    ParcelFileDescriptor getParcelFileDescriptor() {
        return this.parcelFileDescriptor;
    }

    public int hashCode() {
        long j6 = this.fileSizeLimit;
        long j7 = this.durationLimitMillis;
        int i6 = (((((int) (j6 ^ (j6 >>> 32))) ^ 1000003) * 1000003) ^ ((int) (j7 ^ (j7 >>> 32)))) * 1000003;
        Location location = this.location;
        return this.parcelFileDescriptor.hashCode() ^ ((i6 ^ (location == null ? 0 : location.hashCode())) * 1000003);
    }

    public String toString() {
        return "FileDescriptorOutputOptionsInternal{fileSizeLimit=" + this.fileSizeLimit + ", durationLimitMillis=" + this.durationLimitMillis + ", location=" + this.location + ", parcelFileDescriptor=" + this.parcelFileDescriptor + "}";
    }
}
