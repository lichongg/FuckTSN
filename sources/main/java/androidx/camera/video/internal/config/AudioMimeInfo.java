package androidx.camera.video.internal.config;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.video.internal.config.AutoValue_AudioMimeInfo;
import androidx.camera.video.internal.config.MimeInfo;
import com.google.auto.value.AutoValue;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@AutoValue
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public abstract class AudioMimeInfo extends MimeInfo {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @AutoValue.Builder
    public static abstract class Builder extends MimeInfo.Builder<Builder> {
        @Override // androidx.camera.video.internal.config.MimeInfo.Builder
        @NonNull
        public abstract AudioMimeInfo build();

        @NonNull
        public abstract Builder setCompatibleAudioProfile(@Nullable EncoderProfilesProxy.AudioProfileProxy audioProfileProxy);
    }

    @Nullable
    public abstract EncoderProfilesProxy.AudioProfileProxy getCompatibleAudioProfile();

    @NonNull
    public static Builder builder(@NonNull String str) {
        return new AutoValue_AudioMimeInfo.Builder().setMimeType(str).setProfile(-1);
    }
}
