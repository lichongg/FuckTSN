package androidx.camera.video.internal.compat.quirk;

import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.video.Quality;
import java.util.Arrays;
import java.util.Locale;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public class ReportedVideoQualityNotSupportedQuirk implements VideoQualityQuirk {
    private static boolean isHuaweiMate20() {
        return "Huawei".equalsIgnoreCase(Build.BRAND) && "HMA-L29".equalsIgnoreCase(Build.MODEL);
    }

    private static boolean isHuaweiMate20Pro() {
        return "Huawei".equalsIgnoreCase(Build.BRAND) && "LYA-AL00".equalsIgnoreCase(Build.MODEL);
    }

    private static boolean isHuaweiP40Lite() {
        return "Huawei".equalsIgnoreCase(Build.MANUFACTURER) && Arrays.asList("JNY-L21A", "JNY-L01A", "JNY-L21B", "JNY-L22A", "JNY-L02A", "JNY-L22B", "JNY-LX1").contains(Build.MODEL.toUpperCase(Locale.US));
    }

    private static boolean isVivoY91i() {
        return "Vivo".equalsIgnoreCase(Build.BRAND) && "vivo 1820".equalsIgnoreCase(Build.MODEL);
    }

    static boolean load() {
        if (!isHuaweiMate20() && !isHuaweiMate20Pro() && !isVivoY91i() && !isHuaweiP40Lite()) {
            return false;
        }
        return true;
    }

    @Override // androidx.camera.video.internal.compat.quirk.VideoQualityQuirk
    public boolean isProblematicVideoQuality(@NonNull CameraInfoInternal cameraInfoInternal, @NonNull Quality quality) {
        if (!isHuaweiMate20() && !isHuaweiMate20Pro()) {
            if (isVivoY91i()) {
                if (quality == Quality.HD || quality == Quality.FHD) {
                    return true;
                }
                return false;
            }
            if (isHuaweiP40Lite() && cameraInfoInternal.getLensFacing() == 0 && (quality == Quality.FHD || quality == Quality.HD)) {
                return true;
            }
            return false;
        }
        if (quality == Quality.UHD) {
            return true;
        }
        return false;
    }

    @Override // androidx.camera.video.internal.compat.quirk.VideoQualityQuirk
    public boolean workaroundBySurfaceProcessing() {
        if (!isHuaweiMate20() && !isHuaweiMate20Pro() && !isHuaweiP40Lite()) {
            return false;
        }
        return true;
    }
}
