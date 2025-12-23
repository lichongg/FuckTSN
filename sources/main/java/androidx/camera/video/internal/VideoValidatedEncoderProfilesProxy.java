package androidx.camera.video.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.core.util.Preconditions;
import com.google.auto.value.AutoValue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@AutoValue
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public abstract class VideoValidatedEncoderProfilesProxy implements EncoderProfilesProxy {
    @Nullable
    public abstract EncoderProfilesProxy.AudioProfileProxy getDefaultAudioProfile();

    @NonNull
    public abstract EncoderProfilesProxy.VideoProfileProxy getDefaultVideoProfile();

    @NonNull
    public static VideoValidatedEncoderProfilesProxy create(int i6, int i7, @NonNull List<EncoderProfilesProxy.AudioProfileProxy> list, @NonNull List<EncoderProfilesProxy.VideoProfileProxy> list2) {
        EncoderProfilesProxy.AudioProfileProxy audioProfileProxy;
        Preconditions.checkArgument(!list2.isEmpty(), "Should contain at least one VideoProfile.");
        EncoderProfilesProxy.VideoProfileProxy videoProfileProxy = list2.get(0);
        if (!list.isEmpty()) {
            audioProfileProxy = list.get(0);
        } else {
            audioProfileProxy = null;
        }
        return new AutoValue_VideoValidatedEncoderProfilesProxy(i6, i7, Collections.unmodifiableList(new ArrayList(list)), Collections.unmodifiableList(new ArrayList(list2)), audioProfileProxy, videoProfileProxy);
    }

    @NonNull
    public static VideoValidatedEncoderProfilesProxy from(@NonNull EncoderProfilesProxy encoderProfilesProxy) {
        return create(encoderProfilesProxy.getDefaultDurationSeconds(), encoderProfilesProxy.getRecommendedFileFormat(), encoderProfilesProxy.getAudioProfiles(), encoderProfilesProxy.getVideoProfiles());
    }
}
