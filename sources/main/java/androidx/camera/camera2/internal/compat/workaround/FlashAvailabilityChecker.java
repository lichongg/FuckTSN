package androidx.camera.camera2.internal.compat.workaround;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.camera2.internal.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.internal.compat.quirk.FlashAvailabilityBufferUnderflowQuirk;
import androidx.camera.core.Logger;
import java.nio.BufferUnderflowException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public final class FlashAvailabilityChecker {
    private static final String TAG = "FlashAvailability";

    public static boolean isFlashAvailable(@NonNull CameraCharacteristicsProvider cameraCharacteristicsProvider) {
        return isFlashAvailable(false, cameraCharacteristicsProvider);
    }

    public static boolean isFlashAvailable(boolean z5, @NonNull CameraCharacteristicsProvider cameraCharacteristicsProvider) {
        Boolean bool;
        try {
            bool = (Boolean) cameraCharacteristicsProvider.get(CameraCharacteristics.FLASH_INFO_AVAILABLE);
        } catch (BufferUnderflowException e6) {
            if (DeviceQuirks.get(FlashAvailabilityBufferUnderflowQuirk.class) != null) {
                Logger.d(TAG, String.format("Device is known to throw an exception while checking flash availability. Flash is not available. [Manufacturer: %s, Model: %s, API Level: %d].", Build.MANUFACTURER, Build.MODEL, Integer.valueOf(Build.VERSION.SDK_INT)));
            } else {
                Logger.e(TAG, String.format("Exception thrown while checking for flash availability on device not known to throw exceptions during this check. Please file an issue at https://issuetracker.google.com/issues/new?component=618491&template=1257717 with this error message [Manufacturer: %s, Model: %s, API Level: %d].\nFlash is not available.", Build.MANUFACTURER, Build.MODEL, Integer.valueOf(Build.VERSION.SDK_INT)), e6);
            }
            if (z5) {
                throw e6;
            }
            bool = Boolean.FALSE;
        }
        if (bool == null) {
            Logger.w(TAG, "Characteristics did not contain key FLASH_INFO_AVAILABLE. Flash is not available.");
        }
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    private FlashAvailabilityChecker() {
    }
}
