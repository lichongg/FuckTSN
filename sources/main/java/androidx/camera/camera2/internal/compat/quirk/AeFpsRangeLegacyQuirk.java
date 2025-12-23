package androidx.camera.camera2.internal.compat.quirk;

import android.hardware.camera2.CameraCharacteristics;
import android.util.Range;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.core.impl.Quirk;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public class AeFpsRangeLegacyQuirk implements Quirk {

    @Nullable
    private final Range<Integer> mAeFpsRange;

    @Nullable
    private Range<Integer> pickSuitableFpsRange(@Nullable Range<Integer>[] rangeArr) {
        Range<Integer> range = null;
        if (rangeArr != null && rangeArr.length != 0) {
            for (Range<Integer> range2 : rangeArr) {
                Range<Integer> correctedFpsRange = getCorrectedFpsRange(range2);
                if (correctedFpsRange.getUpper().intValue() == 30 && (range == null || correctedFpsRange.getLower().intValue() < range.getLower().intValue())) {
                    range = correctedFpsRange;
                }
            }
        }
        return range;
    }

    static boolean load(@NonNull CameraCharacteristicsCompat cameraCharacteristicsCompat) {
        Integer num = (Integer) cameraCharacteristicsCompat.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
        return num != null && num.intValue() == 2;
    }

    @Nullable
    public Range<Integer> getRange() {
        return this.mAeFpsRange;
    }

    public AeFpsRangeLegacyQuirk(@NonNull CameraCharacteristicsCompat cameraCharacteristicsCompat) {
        this.mAeFpsRange = pickSuitableFpsRange((Range[]) cameraCharacteristicsCompat.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES));
    }

    @NonNull
    private Range<Integer> getCorrectedFpsRange(@NonNull Range<Integer> range) {
        int intValue = range.getUpper().intValue();
        int intValue2 = range.getLower().intValue();
        if (range.getUpper().intValue() >= 1000) {
            intValue = range.getUpper().intValue() / 1000;
        }
        if (range.getLower().intValue() >= 1000) {
            intValue2 = range.getLower().intValue() / 1000;
        }
        return new Range<>(Integer.valueOf(intValue2), Integer.valueOf(intValue));
    }
}
