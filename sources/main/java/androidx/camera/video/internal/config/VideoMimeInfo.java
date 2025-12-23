package androidx.camera.video.internal.config;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.video.internal.config.AutoValue_VideoMimeInfo;
import androidx.camera.video.internal.config.MimeInfo;
import com.google.auto.value.AutoValue;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@AutoValue
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public abstract class VideoMimeInfo extends MimeInfo {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @AutoValue.Builder
    public static abstract class Builder extends MimeInfo.Builder<Builder> {
        @Override // androidx.camera.video.internal.config.MimeInfo.Builder
        @NonNull
        public abstract VideoMimeInfo build();

        @NonNull
        public abstract Builder setCompatibleVideoProfile(@Nullable EncoderProfilesProxy.VideoProfileProxy videoProfileProxy);
    }

    @Nullable
    public abstract EncoderProfilesProxy.VideoProfileProxy getCompatibleVideoProfile();

    @NonNull
    public static Builder builder(@NonNull String str) {
        return new AutoValue_VideoMimeInfo.Builder().setMimeType(str).setProfile(-1);
    }
}
