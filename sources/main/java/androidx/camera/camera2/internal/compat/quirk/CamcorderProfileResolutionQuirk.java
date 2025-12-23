package androidx.camera.camera2.internal.compat.quirk;

import android.hardware.camera2.CameraCharacteristics;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.camera2.internal.compat.StreamConfigurationMapCompat;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.quirk.ProfileResolutionQuirk;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public class CamcorderProfileResolutionQuirk implements ProfileResolutionQuirk {
    private static final String TAG = "CamcorderProfileResolutionQuirk";
    private final StreamConfigurationMapCompat mStreamConfigurationMapCompat;
    private List<Size> mSupportedResolutions = null;

    static boolean load(@NonNull CameraCharacteristicsCompat cameraCharacteristicsCompat) {
        Integer num = (Integer) cameraCharacteristicsCompat.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
        return num != null && num.intValue() == 2;
    }

    @Override // androidx.camera.core.impl.quirk.ProfileResolutionQuirk
    @NonNull
    public List<Size> getSupportedResolutions() {
        if (this.mSupportedResolutions == null) {
            Size[] outputSizes = this.mStreamConfigurationMapCompat.getOutputSizes(34);
            this.mSupportedResolutions = outputSizes != null ? Arrays.asList((Size[]) outputSizes.clone()) : Collections.EMPTY_LIST;
            Logger.d(TAG, "mSupportedResolutions = " + this.mSupportedResolutions);
        }
        return new ArrayList(this.mSupportedResolutions);
    }

    public CamcorderProfileResolutionQuirk(@NonNull CameraCharacteristicsCompat cameraCharacteristicsCompat) {
        this.mStreamConfigurationMapCompat = cameraCharacteristicsCompat.getStreamConfigurationMapCompat();
    }
}
