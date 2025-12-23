package androidx.camera.core.internal.utils;

import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.utils.CompareSizesByArea;
import com.jmolsmobile.landscapevideocapture.configuration.PredefinedCaptureConfigurations;
import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public final class SizeUtil {
    public static final Size RESOLUTION_ZERO = new Size(0, 0);
    public static final Size RESOLUTION_QVGA = new Size(320, 240);
    public static final Size RESOLUTION_VGA = new Size(640, 480);
    public static final Size RESOLUTION_480P = new Size(PredefinedCaptureConfigurations.f35647n, 480);
    public static final Size RESOLUTION_720P = new Size(PredefinedCaptureConfigurations.f35648o, PredefinedCaptureConfigurations.f35647n);
    public static final Size RESOLUTION_1080P = new Size(PredefinedCaptureConfigurations.f35653t, PredefinedCaptureConfigurations.f35652s);
    public static final Size RESOLUTION_1440P = new Size(PredefinedCaptureConfigurations.f35653t, PredefinedCaptureConfigurations.f35657x);

    private SizeUtil() {
    }

    public static int getArea(@NonNull Size size) {
        return size.getWidth() * size.getHeight();
    }

    @Nullable
    public static Size getMaxSize(@NonNull List<Size> list) {
        if (list.isEmpty()) {
            return null;
        }
        return (Size) Collections.max(list, new CompareSizesByArea());
    }

    public static boolean isLongerInAnyEdge(@NonNull Size size, @NonNull Size size2) {
        if (size.getWidth() <= size2.getWidth() && size.getHeight() <= size2.getHeight()) {
            return false;
        }
        return true;
    }

    public static boolean isSmallerByArea(@NonNull Size size, @NonNull Size size2) {
        if (getArea(size) < getArea(size2)) {
            return true;
        }
        return false;
    }
}
