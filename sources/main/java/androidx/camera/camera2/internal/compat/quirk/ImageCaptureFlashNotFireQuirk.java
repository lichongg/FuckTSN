package androidx.camera.camera2.internal.compat.quirk;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public class ImageCaptureFlashNotFireQuirk implements UseTorchAsFlashQuirk {
    private static final List<String> BUILD_MODELS = Arrays.asList("itel w6004");
    private static final List<String> BUILD_MODELS_FRONT_CAMERA = Arrays.asList("sm-j700f", "sm-j710f");

    static boolean load(@NonNull CameraCharacteristicsCompat cameraCharacteristicsCompat) {
        List<String> list = BUILD_MODELS_FRONT_CAMERA;
        String str = Build.MODEL;
        Locale locale = Locale.US;
        return (list.contains(str.toLowerCase(locale)) && ((Integer) cameraCharacteristicsCompat.get(CameraCharacteristics.LENS_FACING)).intValue() == 0) || BUILD_MODELS.contains(str.toLowerCase(locale));
    }
}
