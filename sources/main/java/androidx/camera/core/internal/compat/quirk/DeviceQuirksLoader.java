package androidx.camera.core.internal.compat.quirk;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.Quirk;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public class DeviceQuirksLoader {
    @NonNull
    static List<Quirk> loadQuirks() {
        ArrayList arrayList = new ArrayList();
        if (ImageCaptureRotationOptionQuirk.load()) {
            arrayList.add(new ImageCaptureRotationOptionQuirk());
        }
        if (SurfaceOrderQuirk.load()) {
            arrayList.add(new SurfaceOrderQuirk());
        }
        if (CaptureFailedRetryQuirk.load()) {
            arrayList.add(new CaptureFailedRetryQuirk());
        }
        if (LowMemoryQuirk.load()) {
            arrayList.add(new LowMemoryQuirk());
        }
        if (LargeJpegImageQuirk.load()) {
            arrayList.add(new LargeJpegImageQuirk());
        }
        if (IncorrectJpegMetadataQuirk.load()) {
            arrayList.add(new IncorrectJpegMetadataQuirk());
        }
        return arrayList;
    }

    private DeviceQuirksLoader() {
    }
}
