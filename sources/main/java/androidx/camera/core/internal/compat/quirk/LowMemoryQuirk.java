package androidx.camera.core.internal.compat.quirk;

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
public class LowMemoryQuirk implements Quirk {
    private static final Set<String> DEVICE_MODELS = new HashSet(Arrays.asList("SM-A520W", "MOTOG3"));

    static boolean load() {
        return DEVICE_MODELS.contains(Build.MODEL.toUpperCase(Locale.US));
    }
}
