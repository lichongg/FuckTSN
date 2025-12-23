package androidx.camera.video;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.location.Location;
import android.net.Uri;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.video.MediaStoreOutputOptions;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
final class AutoValue_MediaStoreOutputOptions_MediaStoreOutputOptionsInternal extends MediaStoreOutputOptions.MediaStoreOutputOptionsInternal {
    private final Uri collectionUri;
    private final ContentResolver contentResolver;
    private final ContentValues contentValues;
    private final long durationLimitMillis;
    private final long fileSizeLimit;
    private final Location location;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class Builder extends MediaStoreOutputOptions.MediaStoreOutputOptionsInternal.Builder {
        private Uri collectionUri;
        private ContentResolver contentResolver;
        private ContentValues contentValues;
        private Long durationLimitMillis;
        private Long fileSizeLimit;
        private Location location;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.camera.video.MediaStoreOutputOptions.MediaStoreOutputOptionsInternal.Builder, androidx.camera.video.OutputOptions.OutputOptionsInternal.Builder
        public MediaStoreOutputOptions.MediaStoreOutputOptionsInternal build() {
            String str = "";
            if (this.fileSizeLimit == null) {
                str = " fileSizeLimit";
            }
            if (this.durationLimitMillis == null) {
                str = str + " durationLimitMillis";
            }
            if (this.contentResolver == null) {
                str = str + " contentResolver";
            }
            if (this.collectionUri == null) {
                str = str + " collectionUri";
            }
            if (this.contentValues == null) {
                str = str + " contentValues";
            }
            if (str.isEmpty()) {
                return new AutoValue_MediaStoreOutputOptions_MediaStoreOutputOptionsInternal(this.fileSizeLimit.longValue(), this.durationLimitMillis.longValue(), this.location, this.contentResolver, this.collectionUri, this.contentValues);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // androidx.camera.video.MediaStoreOutputOptions.MediaStoreOutputOptionsInternal.Builder
        MediaStoreOutputOptions.MediaStoreOutputOptionsInternal.Builder setCollectionUri(Uri uri) {
            if (uri == null) {
                throw new NullPointerException("Null collectionUri");
            }
            this.collectionUri = uri;
            return this;
        }

        @Override // androidx.camera.video.MediaStoreOutputOptions.MediaStoreOutputOptionsInternal.Builder
        MediaStoreOutputOptions.MediaStoreOutputOptionsInternal.Builder setContentResolver(ContentResolver contentResolver) {
            if (contentResolver == null) {
                throw new NullPointerException("Null contentResolver");
            }
            this.contentResolver = contentResolver;
            return this;
        }

        @Override // androidx.camera.video.MediaStoreOutputOptions.MediaStoreOutputOptionsInternal.Builder
        MediaStoreOutputOptions.MediaStoreOutputOptionsInternal.Builder setContentValues(ContentValues contentValues) {
            if (contentValues == null) {
                throw new NullPointerException("Null contentValues");
            }
            this.contentValues = contentValues;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.video.OutputOptions.OutputOptionsInternal.Builder
        public MediaStoreOutputOptions.MediaStoreOutputOptionsInternal.Builder setDurationLimitMillis(long j6) {
            this.durationLimitMillis = Long.valueOf(j6);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.video.OutputOptions.OutputOptionsInternal.Builder
        public MediaStoreOutputOptions.MediaStoreOutputOptionsInternal.Builder setFileSizeLimit(long j6) {
            this.fileSizeLimit = Long.valueOf(j6);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.video.OutputOptions.OutputOptionsInternal.Builder
        public MediaStoreOutputOptions.MediaStoreOutputOptionsInternal.Builder setLocation(@Nullable Location location) {
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
        if (obj instanceof MediaStoreOutputOptions.MediaStoreOutputOptionsInternal) {
            MediaStoreOutputOptions.MediaStoreOutputOptionsInternal mediaStoreOutputOptionsInternal = (MediaStoreOutputOptions.MediaStoreOutputOptionsInternal) obj;
            if (this.fileSizeLimit == mediaStoreOutputOptionsInternal.getFileSizeLimit() && this.durationLimitMillis == mediaStoreOutputOptionsInternal.getDurationLimitMillis() && ((location = this.location) != null ? location.equals(mediaStoreOutputOptionsInternal.getLocation()) : mediaStoreOutputOptionsInternal.getLocation() == null) && this.contentResolver.equals(mediaStoreOutputOptionsInternal.getContentResolver()) && this.collectionUri.equals(mediaStoreOutputOptionsInternal.getCollectionUri()) && this.contentValues.equals(mediaStoreOutputOptionsInternal.getContentValues())) {
                return true;
            }
        }
        return false;
    }

    private AutoValue_MediaStoreOutputOptions_MediaStoreOutputOptionsInternal(long j6, long j7, @Nullable Location location, ContentResolver contentResolver, Uri uri, ContentValues contentValues) {
        this.fileSizeLimit = j6;
        this.durationLimitMillis = j7;
        this.location = location;
        this.contentResolver = contentResolver;
        this.collectionUri = uri;
        this.contentValues = contentValues;
    }

    @Override // androidx.camera.video.MediaStoreOutputOptions.MediaStoreOutputOptionsInternal
    @NonNull
    Uri getCollectionUri() {
        return this.collectionUri;
    }

    @Override // androidx.camera.video.MediaStoreOutputOptions.MediaStoreOutputOptionsInternal
    @NonNull
    ContentResolver getContentResolver() {
        return this.contentResolver;
    }

    @Override // androidx.camera.video.MediaStoreOutputOptions.MediaStoreOutputOptionsInternal
    @NonNull
    ContentValues getContentValues() {
        return this.contentValues;
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

    public int hashCode() {
        long j6 = this.fileSizeLimit;
        long j7 = this.durationLimitMillis;
        int i6 = (((((int) (j6 ^ (j6 >>> 32))) ^ 1000003) * 1000003) ^ ((int) (j7 ^ (j7 >>> 32)))) * 1000003;
        Location location = this.location;
        return this.contentValues.hashCode() ^ ((((((i6 ^ (location == null ? 0 : location.hashCode())) * 1000003) ^ this.contentResolver.hashCode()) * 1000003) ^ this.collectionUri.hashCode()) * 1000003);
    }

    public String toString() {
        return "MediaStoreOutputOptionsInternal{fileSizeLimit=" + this.fileSizeLimit + ", durationLimitMillis=" + this.durationLimitMillis + ", location=" + this.location + ", contentResolver=" + this.contentResolver + ", collectionUri=" + this.collectionUri + ", contentValues=" + this.contentValues + "}";
    }
}
