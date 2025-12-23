package androidx.camera.camera2.internal.compat.workaround;

import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.camera.camera2.internal.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.internal.compat.quirk.ExtraCroppingQuirk;
import androidx.camera.core.impl.SurfaceConfig;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public class ResolutionCorrector {

    @Nullable
    private final ExtraCroppingQuirk mExtraCroppingQuirk;

    public ResolutionCorrector() {
        this((ExtraCroppingQuirk) DeviceQuirks.get(ExtraCroppingQuirk.class));
    }

    @VisibleForTesting
    ResolutionCorrector(@Nullable ExtraCroppingQuirk extraCroppingQuirk) {
        this.mExtraCroppingQuirk = extraCroppingQuirk;
    }

    @NonNull
    public List<Size> insertOrPrioritize(@NonNull SurfaceConfig.ConfigType configType, @NonNull List<Size> list) {
        Size verifiedResolution;
        ExtraCroppingQuirk extraCroppingQuirk = this.mExtraCroppingQuirk;
        if (extraCroppingQuirk == null || (verifiedResolution = extraCroppingQuirk.getVerifiedResolution(configType)) == null) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(verifiedResolution);
        for (Size size : list) {
            if (!size.equals(verifiedResolution)) {
                arrayList.add(size);
            }
        }
        return arrayList;
    }
}
