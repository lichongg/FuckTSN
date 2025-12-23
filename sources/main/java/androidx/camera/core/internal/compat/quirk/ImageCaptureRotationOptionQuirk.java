package androidx.camera.core.internal.compat.quirk;

import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.Quirk;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public final class ImageCaptureRotationOptionQuirk implements Quirk {
    private static boolean isEmulator() {
        String str = Build.FINGERPRINT;
        if (str.startsWith("generic") || str.startsWith("unknown")) {
            return true;
        }
        String str2 = Build.MODEL;
        if (str2.contains("google_sdk") || str2.contains("Emulator") || str2.contains("Cuttlefish") || str2.contains("Android SDK built for x86") || Build.MANUFACTURER.contains("Genymotion")) {
            return true;
        }
        return (Build.BRAND.startsWith("generic") && Build.DEVICE.startsWith("generic")) || Build.PRODUCT.equals("google_sdk") || Build.HARDWARE.contains("ranchu");
    }

    private static boolean isHonor9X() {
        return "HONOR".equalsIgnoreCase(Build.BRAND) && "STK-LX1".equalsIgnoreCase(Build.MODEL);
    }

    private static boolean isHuaweiMate20Lite() {
        return "HUAWEI".equalsIgnoreCase(Build.BRAND) && "SNE-LX1".equalsIgnoreCase(Build.MODEL);
    }

    public boolean isSupported(@NonNull Config.Option<?> option) {
        return option != CaptureConfig.OPTION_ROTATION;
    }

    private static boolean isEmulatorAndApi21() {
        if (isEmulator() && Build.VERSION.SDK_INT == 21) {
            return true;
        }
        return false;
    }

    static boolean load() {
        if (!isHuaweiMate20Lite() && !isHonor9X() && !isEmulatorAndApi21()) {
            return false;
        }
        return true;
    }
}
