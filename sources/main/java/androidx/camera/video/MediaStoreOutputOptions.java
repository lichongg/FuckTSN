package androidx.camera.video;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.location.Location;
import android.net.Uri;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.video.AutoValue_MediaStoreOutputOptions_MediaStoreOutputOptionsInternal;
import androidx.camera.video.OutputOptions;
import androidx.core.util.Preconditions;
import com.google.auto.value.AutoValue;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public final class MediaStoreOutputOptions extends OutputOptions {

    @NonNull
    public static final ContentValues EMPTY_CONTENT_VALUES = new ContentValues();
    private final MediaStoreOutputOptionsInternal mMediaStoreOutputOptionsInternal;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Builder extends OutputOptions.Builder<MediaStoreOutputOptions, Builder> {
        private final MediaStoreOutputOptionsInternal.Builder mInternalBuilder;

        public Builder(@NonNull ContentResolver contentResolver, @NonNull Uri uri) {
            super(new AutoValue_MediaStoreOutputOptions_MediaStoreOutputOptionsInternal.Builder());
            Preconditions.checkNotNull(contentResolver, "Content resolver can't be null.");
            Preconditions.checkNotNull(uri, "Collection Uri can't be null.");
            MediaStoreOutputOptionsInternal.Builder builder = (MediaStoreOutputOptionsInternal.Builder) this.mRootInternalBuilder;
            this.mInternalBuilder = builder;
            builder.setContentResolver(contentResolver).setCollectionUri(uri).setContentValues(MediaStoreOutputOptions.EMPTY_CONTENT_VALUES);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.video.OutputOptions.Builder
        @NonNull
        public MediaStoreOutputOptions build() {
            return new MediaStoreOutputOptions(this.mInternalBuilder.build());
        }

        @NonNull
        public Builder setContentValues(@NonNull ContentValues contentValues) {
            Preconditions.checkNotNull(contentValues, "Content values can't be null.");
            this.mInternalBuilder.setContentValues(contentValues);
            return this;
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [androidx.camera.video.MediaStoreOutputOptions$Builder, java.lang.Object] */
        @Override // androidx.camera.video.OutputOptions.Builder
        @NonNull
        public /* bridge */ /* synthetic */ Builder setDurationLimitMillis(@IntRange(from = 0) long j6) {
            return super.setDurationLimitMillis(j6);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [androidx.camera.video.MediaStoreOutputOptions$Builder, java.lang.Object] */
        @Override // androidx.camera.video.OutputOptions.Builder
        @NonNull
        public /* bridge */ /* synthetic */ Builder setFileSizeLimit(@IntRange(from = 0) long j6) {
            return super.setFileSizeLimit(j6);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [androidx.camera.video.MediaStoreOutputOptions$Builder, java.lang.Object] */
        @Override // androidx.camera.video.OutputOptions.Builder
        @NonNull
        public /* bridge */ /* synthetic */ Builder setLocation(@Nullable Location location) {
            return super.setLocation(location);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @AutoValue
    static abstract class MediaStoreOutputOptionsInternal extends OutputOptions.OutputOptionsInternal {
        @NonNull
        abstract Uri getCollectionUri();

        @NonNull
        abstract ContentResolver getContentResolver();

        @NonNull
        abstract ContentValues getContentValues();

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @AutoValue.Builder
        static abstract class Builder extends OutputOptions.OutputOptionsInternal.Builder<Builder> {
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.camera.video.OutputOptions.OutputOptionsInternal.Builder
            @NonNull
            public abstract MediaStoreOutputOptionsInternal build();

            @NonNull
            abstract Builder setCollectionUri(@NonNull Uri uri);

            @NonNull
            abstract Builder setContentResolver(@NonNull ContentResolver contentResolver);

            @NonNull
            abstract Builder setContentValues(@NonNull ContentValues contentValues);

            Builder() {
            }
        }

        MediaStoreOutputOptionsInternal() {
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MediaStoreOutputOptions) {
            return this.mMediaStoreOutputOptionsInternal.equals(((MediaStoreOutputOptions) obj).mMediaStoreOutputOptionsInternal);
        }
        return false;
    }

    @NonNull
    public Uri getCollectionUri() {
        return this.mMediaStoreOutputOptionsInternal.getCollectionUri();
    }

    @NonNull
    public ContentResolver getContentResolver() {
        return this.mMediaStoreOutputOptionsInternal.getContentResolver();
    }

    @NonNull
    public ContentValues getContentValues() {
        return this.mMediaStoreOutputOptionsInternal.getContentValues();
    }

    public int hashCode() {
        return this.mMediaStoreOutputOptionsInternal.hashCode();
    }

    @NonNull
    public String toString() {
        return this.mMediaStoreOutputOptionsInternal.toString().replaceFirst("MediaStoreOutputOptionsInternal", "MediaStoreOutputOptions");
    }

    MediaStoreOutputOptions(@NonNull MediaStoreOutputOptionsInternal mediaStoreOutputOptionsInternal) {
        super(mediaStoreOutputOptionsInternal);
        this.mMediaStoreOutputOptionsInternal = mediaStoreOutputOptionsInternal;
    }
}
