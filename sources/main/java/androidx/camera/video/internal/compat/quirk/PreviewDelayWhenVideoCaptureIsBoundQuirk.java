package androidx.camera.video.internal.compat.quirk;

import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.Quirk;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public class PreviewDelayWhenVideoCaptureIsBoundQuirk implements Quirk {
    private static final Set<String> HUAWEI_DEVICE_LIST = new HashSet(Arrays.asList("HWELE", "HW-02L", "HWVOG", "HWYAL", "HWLYA", "HWCOL", "HWPAR"));
    private static final Set<String> HUAWEI_MODEL_LIST = new HashSet(Arrays.asList("ELS-AN00", "ELS-TN00", "ELS-NX9", "ELS-N04"));

    static boolean load() {
        if (!"Huawei".equalsIgnoreCase(Build.MANUFACTURER)) {
            return false;
        }
        Set<String> set = HUAWEI_DEVICE_LIST;
        String str = Build.DEVICE;
        Locale locale = Locale.US;
        return set.contains(str.toUpperCase(locale)) || HUAWEI_MODEL_LIST.contains(Build.MODEL.toUpperCase(locale));
    }
}
