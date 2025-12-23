package androidx.camera.video.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.impl.EncoderProfilesProvider;
import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.video.internal.utils.DynamicRangeUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public class DynamicRangeMatchedEncoderProfilesProvider implements EncoderProfilesProvider {
    private final DynamicRange mDynamicRange;
    private final Map<Integer, EncoderProfilesProxy> mEncoderProfilesCache = new HashMap();
    private final EncoderProfilesProvider mEncoderProfilesProvider;

    @Nullable
    private static EncoderProfilesProxy filterUnmatchedDynamicRange(@Nullable EncoderProfilesProxy encoderProfilesProxy, @NonNull DynamicRange dynamicRange) {
        if (encoderProfilesProxy == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (EncoderProfilesProxy.VideoProfileProxy videoProfileProxy : encoderProfilesProxy.getVideoProfiles()) {
            if (isBitDepthMatched(videoProfileProxy, dynamicRange) && isHdrEncodingMatched(videoProfileProxy, dynamicRange)) {
                arrayList.add(videoProfileProxy);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return EncoderProfilesProxy.ImmutableEncoderProfilesProxy.create(encoderProfilesProxy.getDefaultDurationSeconds(), encoderProfilesProxy.getRecommendedFileFormat(), encoderProfilesProxy.getAudioProfiles(), arrayList);
    }

    @Nullable
    private EncoderProfilesProxy getProfilesInternal(int i6) {
        if (this.mEncoderProfilesCache.containsKey(Integer.valueOf(i6))) {
            return this.mEncoderProfilesCache.get(Integer.valueOf(i6));
        }
        if (!this.mEncoderProfilesProvider.hasProfile(i6)) {
            return null;
        }
        EncoderProfilesProxy filterUnmatchedDynamicRange = filterUnmatchedDynamicRange(this.mEncoderProfilesProvider.getAll(i6), this.mDynamicRange);
        this.mEncoderProfilesCache.put(Integer.valueOf(i6), filterUnmatchedDynamicRange);
        return filterUnmatchedDynamicRange;
    }

    private static boolean isBitDepthMatched(@NonNull EncoderProfilesProxy.VideoProfileProxy videoProfileProxy, @NonNull DynamicRange dynamicRange) {
        Set<Integer> set = DynamicRangeUtil.DR_TO_VP_BIT_DEPTH_MAP.get(Integer.valueOf(dynamicRange.getBitDepth()));
        return set != null && set.contains(Integer.valueOf(videoProfileProxy.getBitDepth()));
    }

    private static boolean isHdrEncodingMatched(@NonNull EncoderProfilesProxy.VideoProfileProxy videoProfileProxy, @NonNull DynamicRange dynamicRange) {
        Set<Integer> set = DynamicRangeUtil.DR_TO_VP_FORMAT_MAP.get(Integer.valueOf(dynamicRange.getEncoding()));
        return set != null && set.contains(Integer.valueOf(videoProfileProxy.getHdrFormat()));
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProvider
    public boolean hasProfile(int i6) {
        return this.mEncoderProfilesProvider.hasProfile(i6) && getProfilesInternal(i6) != null;
    }

    public DynamicRangeMatchedEncoderProfilesProvider(@NonNull EncoderProfilesProvider encoderProfilesProvider, @NonNull DynamicRange dynamicRange) {
        this.mEncoderProfilesProvider = encoderProfilesProvider;
        this.mDynamicRange = dynamicRange;
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProvider
    @Nullable
    public EncoderProfilesProxy getAll(int i6) {
        return getProfilesInternal(i6);
    }
}
