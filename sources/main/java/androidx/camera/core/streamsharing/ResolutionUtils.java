package androidx.camera.core.streamsharing;

import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.UseCaseConfig;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(api = 21)
/* loaded from: D:\Downloads\app\classes.dex */
class ResolutionUtils {
    private ResolutionUtils() {
    }

    static List<Size> getMergedResolutions(@NonNull List<Size> list, @NonNull Size size, @NonNull Set<UseCaseConfig<?>> set) {
        Iterator<UseCaseConfig<?>> it = set.iterator();
        while (it.hasNext()) {
            List<Size> list2 = (List) it.next().retrieveOption(ImageOutputConfig.OPTION_CUSTOM_ORDERED_RESOLUTIONS, null);
            if (list2 != null) {
                return list2;
            }
        }
        return list;
    }
}
