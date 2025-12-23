package androidx.camera.core.impl.utils;

import androidx.annotation.RequiresApi;
import androidx.camera.core.Logger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public final class CameraOrientationUtil {
    private static final String TAG = "CameraOrientationUtil";

    public static int degreesToSurfaceRotation(int i6) {
        if (i6 == 0) {
            return 0;
        }
        if (i6 == 90) {
            return 1;
        }
        if (i6 == 180) {
            return 2;
        }
        if (i6 == 270) {
            return 3;
        }
        throw new IllegalStateException("Invalid sensor rotation: " + i6);
    }

    public static int getRelativeImageRotation(int i6, int i7, boolean z5) {
        int i8 = z5 ? ((i7 - i6) + 360) % 360 : (i7 + i6) % 360;
        if (Logger.isDebugEnabled(TAG)) {
            Logger.d(TAG, String.format("getRelativeImageRotation: destRotationDegrees=%s, sourceRotationDegrees=%s, isOppositeFacing=%s, result=%s", Integer.valueOf(i6), Integer.valueOf(i7), Boolean.valueOf(z5), Integer.valueOf(i8)));
        }
        return i8;
    }

    public static int surfaceRotationToDegrees(int i6) {
        if (i6 == 0) {
            return 0;
        }
        if (i6 == 1) {
            return 90;
        }
        if (i6 == 2) {
            return 180;
        }
        if (i6 == 3) {
            return 270;
        }
        throw new IllegalArgumentException("Unsupported surface rotation: " + i6);
    }

    private CameraOrientationUtil() {
    }
}
