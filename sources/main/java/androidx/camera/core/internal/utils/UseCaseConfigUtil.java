package androidx.camera.core.internal.utils;

import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.utils.CameraOrientationUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public final class UseCaseConfigUtil {
    private UseCaseConfigUtil() {
    }

    public static void updateTargetRotationAndRelatedConfigs(@NonNull UseCaseConfig.Builder<?, ?, ?> builder, int i6) {
        Size targetResolution;
        ImageOutputConfig imageOutputConfig = (ImageOutputConfig) builder.getUseCaseConfig();
        int targetRotation = imageOutputConfig.getTargetRotation(-1);
        if (targetRotation == -1 || targetRotation != i6) {
            ((ImageOutputConfig.Builder) builder).setTargetRotation(i6);
        }
        if (targetRotation != -1 && i6 != -1 && targetRotation != i6) {
            if (Math.abs(CameraOrientationUtil.surfaceRotationToDegrees(i6) - CameraOrientationUtil.surfaceRotationToDegrees(targetRotation)) % 180 == 90 && (targetResolution = imageOutputConfig.getTargetResolution(null)) != null) {
                ((ImageOutputConfig.Builder) builder).setTargetResolution(new Size(targetResolution.getHeight(), targetResolution.getWidth()));
            }
        }
    }
}
