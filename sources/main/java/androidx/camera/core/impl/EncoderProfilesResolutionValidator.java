package androidx.camera.core.impl;

import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.core.impl.quirk.ProfileResolutionQuirk;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public class EncoderProfilesResolutionValidator {

    @NonNull
    private final List<ProfileResolutionQuirk> mQuirks;

    @NonNull
    private final Set<Size> mSupportedResolutions;

    @Nullable
    public EncoderProfilesProxy filterInvalidVideoResolution(@Nullable EncoderProfilesProxy encoderProfilesProxy) {
        if (encoderProfilesProxy == null) {
            return null;
        }
        if (!hasQuirk()) {
            return encoderProfilesProxy;
        }
        ArrayList arrayList = new ArrayList();
        for (EncoderProfilesProxy.VideoProfileProxy videoProfileProxy : encoderProfilesProxy.getVideoProfiles()) {
            if (this.mSupportedResolutions.contains(new Size(videoProfileProxy.getWidth(), videoProfileProxy.getHeight()))) {
                arrayList.add(videoProfileProxy);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return EncoderProfilesProxy.ImmutableEncoderProfilesProxy.create(encoderProfilesProxy.getDefaultDurationSeconds(), encoderProfilesProxy.getRecommendedFileFormat(), encoderProfilesProxy.getAudioProfiles(), arrayList);
    }

    public boolean hasValidVideoResolution(@Nullable EncoderProfilesProxy encoderProfilesProxy) {
        if (encoderProfilesProxy == null) {
            return false;
        }
        if (!hasQuirk()) {
            return !encoderProfilesProxy.getVideoProfiles().isEmpty();
        }
        for (EncoderProfilesProxy.VideoProfileProxy videoProfileProxy : encoderProfilesProxy.getVideoProfiles()) {
            if (this.mSupportedResolutions.contains(new Size(videoProfileProxy.getWidth(), videoProfileProxy.getHeight()))) {
                return true;
            }
        }
        return false;
    }

    @NonNull
    private Set<Size> generateSupportedResolutions(@Nullable List<ProfileResolutionQuirk> list) {
        if (list == null || list.isEmpty()) {
            return Collections.EMPTY_SET;
        }
        HashSet hashSet = new HashSet(list.get(0).getSupportedResolutions());
        for (int i6 = 1; i6 < list.size(); i6++) {
            hashSet.retainAll(list.get(i6).getSupportedResolutions());
        }
        return hashSet;
    }

    public boolean hasQuirk() {
        return !this.mQuirks.isEmpty();
    }

    public EncoderProfilesResolutionValidator(@Nullable List<ProfileResolutionQuirk> list) {
        ArrayList arrayList = new ArrayList();
        this.mQuirks = arrayList;
        if (list != null) {
            arrayList.addAll(list);
        }
        this.mSupportedResolutions = generateSupportedResolutions(list);
    }
}
