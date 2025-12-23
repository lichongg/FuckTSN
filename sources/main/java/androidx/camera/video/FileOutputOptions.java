package androidx.camera.video;

import android.location.Location;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.video.AutoValue_FileOutputOptions_FileOutputOptionsInternal;
import androidx.camera.video.OutputOptions;
import androidx.core.util.Preconditions;
import com.google.auto.value.AutoValue;
import java.io.File;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public final class FileOutputOptions extends OutputOptions {
    private final FileOutputOptionsInternal mFileOutputOptionsInternal;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(21)
    public static final class Builder extends OutputOptions.Builder<FileOutputOptions, Builder> {
        private final FileOutputOptionsInternal.Builder mInternalBuilder;

        public Builder(@NonNull File file) {
            super(new AutoValue_FileOutputOptions_FileOutputOptionsInternal.Builder());
            Preconditions.checkNotNull(file, "File can't be null.");
            FileOutputOptionsInternal.Builder builder = (FileOutputOptionsInternal.Builder) this.mRootInternalBuilder;
            this.mInternalBuilder = builder;
            builder.setFile(file);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.video.OutputOptions.Builder
        @NonNull
        public FileOutputOptions build() {
            return new FileOutputOptions(this.mInternalBuilder.build());
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [androidx.camera.video.FileOutputOptions$Builder, java.lang.Object] */
        @Override // androidx.camera.video.OutputOptions.Builder
        @NonNull
        public /* bridge */ /* synthetic */ Builder setDurationLimitMillis(@IntRange(from = 0) long j6) {
            return super.setDurationLimitMillis(j6);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [androidx.camera.video.FileOutputOptions$Builder, java.lang.Object] */
        @Override // androidx.camera.video.OutputOptions.Builder
        @NonNull
        public /* bridge */ /* synthetic */ Builder setFileSizeLimit(@IntRange(from = 0) long j6) {
            return super.setFileSizeLimit(j6);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [androidx.camera.video.FileOutputOptions$Builder, java.lang.Object] */
        @Override // androidx.camera.video.OutputOptions.Builder
        @NonNull
        public /* bridge */ /* synthetic */ Builder setLocation(@Nullable Location location) {
            return super.setLocation(location);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @AutoValue
    static abstract class FileOutputOptionsInternal extends OutputOptions.OutputOptionsInternal {
        @NonNull
        abstract File getFile();

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @AutoValue.Builder
        static abstract class Builder extends OutputOptions.OutputOptionsInternal.Builder<Builder> {
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.camera.video.OutputOptions.OutputOptionsInternal.Builder
            @NonNull
            public abstract FileOutputOptionsInternal build();

            @NonNull
            abstract Builder setFile(@NonNull File file);

            Builder() {
            }
        }

        FileOutputOptionsInternal() {
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FileOutputOptions) {
            return this.mFileOutputOptionsInternal.equals(((FileOutputOptions) obj).mFileOutputOptionsInternal);
        }
        return false;
    }

    @NonNull
    public File getFile() {
        return this.mFileOutputOptionsInternal.getFile();
    }

    public int hashCode() {
        return this.mFileOutputOptionsInternal.hashCode();
    }

    @NonNull
    public String toString() {
        return this.mFileOutputOptionsInternal.toString().replaceFirst("FileOutputOptionsInternal", "FileOutputOptions");
    }

    FileOutputOptions(@NonNull FileOutputOptionsInternal fileOutputOptionsInternal) {
        super(fileOutputOptionsInternal);
        this.mFileOutputOptionsInternal = fileOutputOptionsInternal;
    }
}
