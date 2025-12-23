package androidx.camera.view.internal.compat.quirk;

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
        if (SurfaceViewStretchedQuirk.load()) {
            arrayList.add(new SurfaceViewStretchedQuirk());
        }
        if (SurfaceViewNotCroppedByParentQuirk.load()) {
            arrayList.add(new SurfaceViewNotCroppedByParentQuirk());
        }
        return arrayList;
    }

    private DeviceQuirksLoader() {
    }
}
