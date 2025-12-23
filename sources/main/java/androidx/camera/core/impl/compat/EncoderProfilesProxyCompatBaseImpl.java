package androidx.camera.core.impl.compat;

import android.media.CamcorderProfile;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.core.impl.x;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
class EncoderProfilesProxyCompatBaseImpl {
    @NonNull
    public static EncoderProfilesProxy from(@NonNull CamcorderProfile camcorderProfile) {
        return EncoderProfilesProxy.ImmutableEncoderProfilesProxy.create(camcorderProfile.duration, camcorderProfile.fileFormat, toAudioProfiles(camcorderProfile), toVideoProfiles(camcorderProfile));
    }

    @NonNull
    private static List<EncoderProfilesProxy.AudioProfileProxy> toAudioProfiles(@NonNull CamcorderProfile camcorderProfile) {
        ArrayList arrayList = new ArrayList();
        int i6 = camcorderProfile.audioCodec;
        arrayList.add(EncoderProfilesProxy.AudioProfileProxy.create(i6, x.a(i6), camcorderProfile.audioBitRate, camcorderProfile.audioSampleRate, camcorderProfile.audioChannels, x.b(camcorderProfile.audioCodec)));
        return arrayList;
    }

    @NonNull
    private static List<EncoderProfilesProxy.VideoProfileProxy> toVideoProfiles(@NonNull CamcorderProfile camcorderProfile) {
        ArrayList arrayList = new ArrayList();
        int i6 = camcorderProfile.videoCodec;
        arrayList.add(EncoderProfilesProxy.VideoProfileProxy.create(i6, x.c(i6), camcorderProfile.videoBitRate, camcorderProfile.videoFrameRate, camcorderProfile.videoFrameWidth, camcorderProfile.videoFrameHeight, -1, 8, 0, 0));
        return arrayList;
    }

    private EncoderProfilesProxyCompatBaseImpl() {
    }
}
