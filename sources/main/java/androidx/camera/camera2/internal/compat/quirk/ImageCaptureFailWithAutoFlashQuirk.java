package androidx.camera.camera2.internal.compat.quirk;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.core.impl.Quirk;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public class ImageCaptureFailWithAutoFlashQuirk implements Quirk {
    private static final List<String> BUILD_MODELS_FRONT_CAMERA = Arrays.asList("sm-j700f", "sm-j710f");

    static boolean load(@NonNull CameraCharacteristicsCompat cameraCharacteristicsCompat) {
        return BUILD_MODELS_FRONT_CAMERA.contains(Build.MODEL.toLowerCase(Locale.US)) && ((Integer) cameraCharacteristicsCompat.get(CameraCharacteristics.LENS_FACING)).intValue() == 0;
    }
}
