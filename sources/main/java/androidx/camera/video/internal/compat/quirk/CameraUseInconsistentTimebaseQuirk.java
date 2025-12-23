package androidx.camera.video.internal.compat.quirk;

import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.Quirk;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public class CameraUseInconsistentTimebaseQuirk implements Quirk {
    private static final Set<String> BUILD_HARDWARE_SET = new HashSet(Arrays.asList("samsungexynos7570", "samsungexynos7870", "qcom"));
    private static final Set<String> BUILD_SOC_MODEL_SET = new HashSet(Arrays.asList("sm4350", "sm6375"));
    private static final Set<String> BUILD_MODEL_SET = new HashSet(Arrays.asList("m2007j20cg", "m2007j20ct"));

    private static boolean isAffectedModel() {
        return BUILD_MODEL_SET.contains(Build.MODEL.toLowerCase());
    }

    private static boolean isAffectedSamsungDevice() {
        return "SAMSUNG".equalsIgnoreCase(Build.BRAND) && BUILD_HARDWARE_SET.contains(Build.HARDWARE.toLowerCase());
    }

    private static boolean usesAffectedSoc() {
        String str;
        if (Build.VERSION.SDK_INT < 31) {
            return false;
        }
        Set<String> set = BUILD_SOC_MODEL_SET;
        str = Build.SOC_MODEL;
        return set.contains(str.toLowerCase());
    }

    static boolean load() {
        if (!usesAffectedSoc() && !isAffectedSamsungDevice() && !isAffectedModel()) {
            return false;
        }
        return true;
    }
}
