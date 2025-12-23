package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.Quirk;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public class InvalidVideoProfilesQuirk implements Quirk {
    static final List<String> AFFECTED_PIXEL_MODELS = Arrays.asList("pixel 4", "pixel 4a", "pixel 4a (5g)", "pixel 4 xl", "pixel 5", "pixel 5a", "pixel 6", "pixel 6a", "pixel 6 pro", "pixel 7", "pixel 7 pro");

    private static boolean isAffectedPixelModel() {
        return AFFECTED_PIXEL_MODELS.contains(Build.MODEL.toLowerCase(Locale.ROOT));
    }

    private static boolean isAffectedSamsungDevices() {
        return "samsung".equalsIgnoreCase(Build.BRAND) && isTp1aBuild();
    }

    private static boolean isTd1aBuild() {
        return Build.ID.toLowerCase(Locale.ROOT).startsWith("td1a");
    }

    private static boolean isTp1aBuild() {
        return Build.ID.toLowerCase(Locale.ROOT).startsWith("tp1a");
    }

    private static boolean isAffectedPixelBuild() {
        if (!isTp1aBuild() && !isTd1aBuild()) {
            return false;
        }
        return true;
    }

    private static boolean isAffectedPixelDevices() {
        if (isAffectedPixelModel() && isAffectedPixelBuild()) {
            return true;
        }
        return false;
    }

    static boolean load() {
        if (!isAffectedSamsungDevices() && !isAffectedPixelDevices()) {
            return false;
        }
        return true;
    }
}
