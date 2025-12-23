package androidx.camera.camera2.internal.compat.workaround;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.camera2.internal.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.internal.compat.quirk.ExtraSupportedSurfaceCombinationsQuirk;
import androidx.camera.core.impl.SurfaceCombination;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public class ExtraSupportedSurfaceCombinationsContainer {
    private final ExtraSupportedSurfaceCombinationsQuirk mQuirk = (ExtraSupportedSurfaceCombinationsQuirk) DeviceQuirks.get(ExtraSupportedSurfaceCombinationsQuirk.class);

    @NonNull
    public List<SurfaceCombination> get(@NonNull String str, int i6) {
        ExtraSupportedSurfaceCombinationsQuirk extraSupportedSurfaceCombinationsQuirk = this.mQuirk;
        return extraSupportedSurfaceCombinationsQuirk == null ? new ArrayList() : extraSupportedSurfaceCombinationsQuirk.getExtraSupportedSurfaceCombinations(str, i6);
    }
}
