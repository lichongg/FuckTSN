package androidx.camera.camera2.internal.compat.workaround;

import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.camera.camera2.internal.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.internal.compat.quirk.ExtraCroppingQuirk;
import androidx.camera.core.impl.SurfaceConfig;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public class MaxPreviewSize {

    @Nullable
    private final ExtraCroppingQuirk mExtraCroppingQuirk;

    public MaxPreviewSize() {
        this((ExtraCroppingQuirk) DeviceQuirks.get(ExtraCroppingQuirk.class));
    }

    @VisibleForTesting
    MaxPreviewSize(@Nullable ExtraCroppingQuirk extraCroppingQuirk) {
        this.mExtraCroppingQuirk = extraCroppingQuirk;
    }

    @NonNull
    public Size getMaxPreviewResolution(@NonNull Size size) {
        Size verifiedResolution;
        ExtraCroppingQuirk extraCroppingQuirk = this.mExtraCroppingQuirk;
        return (extraCroppingQuirk == null || (verifiedResolution = extraCroppingQuirk.getVerifiedResolution(SurfaceConfig.ConfigType.PRIV)) == null) ? size : verifiedResolution.getWidth() * verifiedResolution.getHeight() > size.getWidth() * size.getHeight() ? verifiedResolution : size;
    }
}
