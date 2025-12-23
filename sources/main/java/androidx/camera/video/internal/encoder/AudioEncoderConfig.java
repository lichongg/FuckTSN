package androidx.camera.video.internal.encoder;

import android.media.MediaFormat;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.Timebase;
import androidx.camera.video.internal.encoder.AutoValue_AudioEncoderConfig;
import com.google.android.gms.common.Scopes;
import com.google.auto.value.AutoValue;
import java.util.Objects;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@AutoValue
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public abstract class AudioEncoderConfig implements EncoderConfig {
    public abstract int getBitrate();

    public abstract int getChannelCount();

    @Override // androidx.camera.video.internal.encoder.EncoderConfig
    @NonNull
    public abstract Timebase getInputTimebase();

    @Override // androidx.camera.video.internal.encoder.EncoderConfig
    @NonNull
    public abstract String getMimeType();

    @Override // androidx.camera.video.internal.encoder.EncoderConfig
    public abstract int getProfile();

    public abstract int getSampleRate();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @AutoValue.Builder
    public static abstract class Builder {
        @NonNull
        abstract AudioEncoderConfig autoBuild();

        @NonNull
        public abstract Builder setBitrate(int i6);

        @NonNull
        public abstract Builder setChannelCount(int i6);

        @NonNull
        public abstract Builder setInputTimebase(@NonNull Timebase timebase);

        @NonNull
        public abstract Builder setMimeType(@NonNull String str);

        @NonNull
        public abstract Builder setProfile(int i6);

        @NonNull
        public abstract Builder setSampleRate(int i6);

        Builder() {
        }

        @NonNull
        public AudioEncoderConfig build() {
            AudioEncoderConfig autoBuild = autoBuild();
            if (Objects.equals(autoBuild.getMimeType(), "audio/mp4a-latm") && autoBuild.getProfile() == -1) {
                throw new IllegalArgumentException("Encoder mime set to AAC, but no AAC profile was provided.");
            }
            return autoBuild;
        }
    }

    @NonNull
    public static Builder builder() {
        return new AutoValue_AudioEncoderConfig.Builder().setProfile(-1);
    }

    AudioEncoderConfig() {
    }

    @Override // androidx.camera.video.internal.encoder.EncoderConfig
    @NonNull
    public MediaFormat toMediaFormat() {
        MediaFormat createAudioFormat = MediaFormat.createAudioFormat(getMimeType(), getSampleRate(), getChannelCount());
        createAudioFormat.setInteger("bitrate", getBitrate());
        if (getProfile() != -1) {
            if (getMimeType().equals("audio/mp4a-latm")) {
                createAudioFormat.setInteger("aac-profile", getProfile());
                return createAudioFormat;
            }
            createAudioFormat.setInteger(Scopes.PROFILE, getProfile());
        }
        return createAudioFormat;
    }
}
