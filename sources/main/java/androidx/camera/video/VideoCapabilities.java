package androidx.camera.video;

import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.camera.core.DynamicRange;
import androidx.camera.video.internal.VideoValidatedEncoderProfilesProxy;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public interface VideoCapabilities {

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final VideoCapabilities EMPTY = new VideoCapabilities() { // from class: androidx.camera.video.VideoCapabilities.1
        @Override // androidx.camera.video.VideoCapabilities
        public boolean isQualitySupported(@NonNull Quality quality, @NonNull DynamicRange dynamicRange) {
            return false;
        }

        @Override // androidx.camera.video.VideoCapabilities
        @NonNull
        public Set<DynamicRange> getSupportedDynamicRanges() {
            return new HashSet();
        }

        @Override // androidx.camera.video.VideoCapabilities
        @NonNull
        public List<Quality> getSupportedQualities(@NonNull DynamicRange dynamicRange) {
            return new ArrayList();
        }

        @Override // androidx.camera.video.VideoCapabilities
        public /* synthetic */ VideoValidatedEncoderProfilesProxy findHighestSupportedEncoderProfilesFor(Size size, DynamicRange dynamicRange) {
            return g0.a(this, size, dynamicRange);
        }

        @Override // androidx.camera.video.VideoCapabilities
        public /* synthetic */ Quality findHighestSupportedQualityFor(Size size, DynamicRange dynamicRange) {
            return g0.b(this, size, dynamicRange);
        }

        @Override // androidx.camera.video.VideoCapabilities
        public /* synthetic */ VideoValidatedEncoderProfilesProxy getProfiles(Quality quality, DynamicRange dynamicRange) {
            return g0.c(this, quality, dynamicRange);
        }
    };

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    VideoValidatedEncoderProfilesProxy findHighestSupportedEncoderProfilesFor(@NonNull Size size, @NonNull DynamicRange dynamicRange);

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    Quality findHighestSupportedQualityFor(@NonNull Size size, @NonNull DynamicRange dynamicRange);

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    VideoValidatedEncoderProfilesProxy getProfiles(@NonNull Quality quality, @NonNull DynamicRange dynamicRange);

    @NonNull
    Set<DynamicRange> getSupportedDynamicRanges();

    @NonNull
    List<Quality> getSupportedQualities(@NonNull DynamicRange dynamicRange);

    boolean isQualitySupported(@NonNull Quality quality, @NonNull DynamicRange dynamicRange);
}
