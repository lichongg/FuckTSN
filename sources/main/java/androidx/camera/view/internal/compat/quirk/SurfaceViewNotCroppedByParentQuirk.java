package androidx.camera.view.internal.compat.quirk;

import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.Quirk;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public class SurfaceViewNotCroppedByParentQuirk implements Quirk {
    private static final String RED_MI_NOTE_10_MODEL = "M2101K7AG";
    private static final String XIAOMI = "XIAOMI";

    static boolean load() {
        return XIAOMI.equalsIgnoreCase(Build.MANUFACTURER) && RED_MI_NOTE_10_MODEL.equalsIgnoreCase(Build.MODEL);
    }
}
