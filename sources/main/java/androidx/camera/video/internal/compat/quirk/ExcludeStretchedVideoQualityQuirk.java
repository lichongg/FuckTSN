package androidx.camera.video.internal.compat.quirk;

import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.video.Quality;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public class ExcludeStretchedVideoQualityQuirk implements VideoQualityQuirk {
    private static boolean isSamsungJ4() {
        return "Samsung".equalsIgnoreCase(Build.BRAND) && "SM-J400G".equalsIgnoreCase(Build.MODEL);
    }

    private static boolean isSamsungJ7Api27Above() {
        return "Samsung".equalsIgnoreCase(Build.BRAND) && "SM-J710MN".equalsIgnoreCase(Build.MODEL) && Build.VERSION.SDK_INT >= 27;
    }

    private static boolean isSamsungJ7PrimeApi27Above() {
        return "Samsung".equalsIgnoreCase(Build.BRAND) && "SM-G610M".equalsIgnoreCase(Build.MODEL) && Build.VERSION.SDK_INT >= 27;
    }

    static boolean load() {
        if (!isSamsungJ4() && !isSamsungJ7PrimeApi27Above() && !isSamsungJ7Api27Above()) {
            return false;
        }
        return true;
    }

    @Override // androidx.camera.video.internal.compat.quirk.VideoQualityQuirk
    public boolean isProblematicVideoQuality(@NonNull CameraInfoInternal cameraInfoInternal, @NonNull Quality quality) {
        if (isSamsungJ4()) {
            if (quality == Quality.FHD || quality == Quality.UHD) {
                return true;
            }
            return false;
        }
        if ((isSamsungJ7PrimeApi27Above() || isSamsungJ7Api27Above()) && quality == Quality.FHD) {
            return true;
        }
        return false;
    }

    @Override // androidx.camera.video.internal.compat.quirk.VideoQualityQuirk
    public /* synthetic */ boolean workaroundBySurfaceProcessing() {
        return b.a(this);
    }
}
