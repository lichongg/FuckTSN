package androidx.camera.core.impl;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.Logger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public final class CameraValidator {
    private static final String TAG = "CameraValidator";

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class CameraIdListIncorrectException extends Exception {
        public CameraIdListIncorrectException(@Nullable String str, @Nullable Throwable th) {
            super(str, th);
        }
    }

    public static void validateCameras(@NonNull Context context, @NonNull CameraRepository cameraRepository, @Nullable CameraSelector cameraSelector) throws CameraIdListIncorrectException {
        Integer lensFacing;
        if (cameraSelector != null) {
            try {
                lensFacing = cameraSelector.getLensFacing();
                if (lensFacing == null) {
                    Logger.w(TAG, "No lens facing info in the availableCamerasSelector, don't verify the camera lens facing.");
                    return;
                }
            } catch (IllegalStateException e6) {
                Logger.e(TAG, "Cannot get lens facing from the availableCamerasSelector don't verify the camera lens facing.", e6);
                return;
            }
        } else {
            lensFacing = null;
        }
        Logger.d(TAG, "Verifying camera lens facing on " + Build.DEVICE + ", lensFacingInteger: " + lensFacing);
        PackageManager packageManager = context.getPackageManager();
        try {
            if (packageManager.hasSystemFeature("android.hardware.camera")) {
                if (cameraSelector != null) {
                    if (lensFacing.intValue() == 1) {
                    }
                }
                CameraSelector.DEFAULT_BACK_CAMERA.select(cameraRepository.getCameras());
            }
            if (packageManager.hasSystemFeature("android.hardware.camera.front")) {
                if (cameraSelector == null || lensFacing.intValue() == 0) {
                    CameraSelector.DEFAULT_FRONT_CAMERA.select(cameraRepository.getCameras());
                }
            }
        } catch (IllegalArgumentException e7) {
            Logger.e(TAG, "Camera LensFacing verification failed, existing cameras: " + cameraRepository.getCameras());
            throw new CameraIdListIncorrectException("Expected camera missing from device.", e7);
        }
    }

    private CameraValidator() {
    }
}
