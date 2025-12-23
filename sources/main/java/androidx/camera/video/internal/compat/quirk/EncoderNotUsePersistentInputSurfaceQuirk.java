package androidx.camera.video.internal.compat.quirk;

import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.Quirk;
import java.util.Arrays;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public class EncoderNotUsePersistentInputSurfaceQuirk implements Quirk {
    private static final List<String> DEVICE_MODELS = Arrays.asList("SM-N9208", "SM-G920V");

    static boolean load() {
        return Build.VERSION.SDK_INT <= 22 || DEVICE_MODELS.contains(Build.MODEL.toUpperCase());
    }
}
