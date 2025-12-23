package androidx.camera.video.internal.encoder;

import android.media.MediaFormat;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.Timebase;
import androidx.camera.video.internal.encoder.AutoValue_VideoEncoderConfig;
import com.google.android.gms.common.Scopes;
import com.google.auto.value.AutoValue;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@AutoValue
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public abstract class VideoEncoderConfig implements EncoderConfig {
    private static final int VIDEO_COLOR_FORMAT_DEFAULT = 2130708361;
    private static final int VIDEO_INTRA_FRAME_INTERVAL_DEFAULT = 1;

    public abstract int getBitrate();

    public abstract int getColorFormat();

    @NonNull
    public abstract VideoEncoderDataSpace getDataSpace();

    public abstract int getFrameRate();

    public abstract int getIFrameInterval();

    @Override // androidx.camera.video.internal.encoder.EncoderConfig
    @NonNull
    public abstract Timebase getInputTimebase();

    @Override // androidx.camera.video.internal.encoder.EncoderConfig
    @NonNull
    public abstract String getMimeType();

    @Override // androidx.camera.video.internal.encoder.EncoderConfig
    public abstract int getProfile();

    @NonNull
    public abstract Size getResolution();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @AutoValue.Builder
    public static abstract class Builder {
        @NonNull
        public abstract VideoEncoderConfig build();

        @NonNull
        public abstract Builder setBitrate(int i6);

        @NonNull
        public abstract Builder setColorFormat(int i6);

        @NonNull
        public abstract Builder setDataSpace(@NonNull VideoEncoderDataSpace videoEncoderDataSpace);

        @NonNull
        public abstract Builder setFrameRate(int i6);

        @NonNull
        public abstract Builder setIFrameInterval(int i6);

        @NonNull
        public abstract Builder setInputTimebase(@NonNull Timebase timebase);

        @NonNull
        public abstract Builder setMimeType(@NonNull String str);

        @NonNull
        public abstract Builder setProfile(int i6);

        @NonNull
        public abstract Builder setResolution(@NonNull Size size);

        Builder() {
        }
    }

    @NonNull
    public static Builder builder() {
        return new AutoValue_VideoEncoderConfig.Builder().setProfile(-1).setIFrameInterval(1).setColorFormat(VIDEO_COLOR_FORMAT_DEFAULT).setDataSpace(VideoEncoderDataSpace.ENCODER_DATA_SPACE_UNSPECIFIED);
    }

    VideoEncoderConfig() {
    }

    @Override // androidx.camera.video.internal.encoder.EncoderConfig
    @NonNull
    public MediaFormat toMediaFormat() {
        Size resolution = getResolution();
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat(getMimeType(), resolution.getWidth(), resolution.getHeight());
        createVideoFormat.setInteger("color-format", getColorFormat());
        createVideoFormat.setInteger("bitrate", getBitrate());
        createVideoFormat.setInteger("frame-rate", getFrameRate());
        createVideoFormat.setInteger("i-frame-interval", getIFrameInterval());
        if (getProfile() != -1) {
            createVideoFormat.setInteger(Scopes.PROFILE, getProfile());
        }
        VideoEncoderDataSpace dataSpace = getDataSpace();
        if (dataSpace.getStandard() != 0) {
            createVideoFormat.setInteger("color-standard", dataSpace.getStandard());
        }
        if (dataSpace.getTransfer() != 0) {
            createVideoFormat.setInteger("color-transfer", dataSpace.getTransfer());
        }
        if (dataSpace.getRange() != 0) {
            createVideoFormat.setInteger("color-range", dataSpace.getRange());
        }
        return createVideoFormat;
    }
}
