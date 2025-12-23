package androidx.camera.core.internal.compat.quirk;

import android.os.Build;
import android.util.Pair;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.Quirk;
import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public class CaptureFailedRetryQuirk implements Quirk {
    private static final Set<Pair<String, String>> FAILED_RETRY_ALLOW_LIST = new HashSet(Collections.singletonList(Pair.create("SAMSUNG", "SM-G981U1")));

    public int getRetryCount() {
        return 1;
    }

    static boolean load() {
        String str = Build.BRAND;
        Locale locale = Locale.US;
        return FAILED_RETRY_ALLOW_LIST.contains(Pair.create(str.toUpperCase(locale), Build.MODEL.toUpperCase(locale)));
    }
}
