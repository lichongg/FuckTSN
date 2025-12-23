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
public class TorchIsClosedAfterImageCapturingQuirk implements Quirk {
    public static final List<String> BUILD_MODELS = Arrays.asList("mi a1", "mi a2", "mi a2 lite", "redmi 4x", "redmi 5a", "redmi 6 pro");

    static boolean load() {
        return BUILD_MODELS.contains(Build.MODEL.toLowerCase(Locale.US));
    }
}
