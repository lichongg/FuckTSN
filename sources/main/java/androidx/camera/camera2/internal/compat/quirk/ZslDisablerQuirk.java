package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.Quirk;
import java.util.Locale;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public class ZslDisablerQuirk implements Quirk {
    private static boolean isSamsungFold4() {
        return "samsung".equalsIgnoreCase(Build.BRAND) && Build.MODEL.toUpperCase(Locale.US).startsWith("SM-F936");
    }

    private static boolean isXiaoMiMi8() {
        if ("xiaomi".equalsIgnoreCase(Build.BRAND) && Build.MODEL.toUpperCase(Locale.US).startsWith("MI 8")) {
            return true;
        }
        return false;
    }

    static boolean load() {
        if (!isSamsungFold4() && !isXiaoMiMi8()) {
            return false;
        }
        return true;
    }
}
