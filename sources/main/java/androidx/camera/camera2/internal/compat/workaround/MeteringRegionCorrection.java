package androidx.camera.camera2.internal.compat.workaround;

import android.graphics.PointF;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.camera2.internal.compat.quirk.AfRegionFlipHorizontallyQuirk;
import androidx.camera.core.MeteringPoint;
import androidx.camera.core.impl.Quirks;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public class MeteringRegionCorrection {
    private final Quirks mCameraQuirks;

    @NonNull
    public PointF getCorrectedPoint(@NonNull MeteringPoint meteringPoint, int i6) {
        return (i6 == 1 && this.mCameraQuirks.contains(AfRegionFlipHorizontallyQuirk.class)) ? new PointF(1.0f - meteringPoint.getX(), meteringPoint.getY()) : new PointF(meteringPoint.getX(), meteringPoint.getY());
    }

    public MeteringRegionCorrection(@NonNull Quirks quirks) {
        this.mCameraQuirks = quirks;
    }
}
