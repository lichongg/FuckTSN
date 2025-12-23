package androidx.camera.camera2.internal.compat.workaround;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.camera2.internal.compat.quirk.AutoFlashUnderExposedQuirk;
import androidx.camera.core.impl.Quirks;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public class OverrideAeModeForStillCapture {
    private boolean mAePrecaptureStarted = false;
    private final boolean mHasAutoFlashUnderExposedQuirk;

    public void onAePrecaptureFinished() {
        this.mAePrecaptureStarted = false;
    }

    public void onAePrecaptureStarted() {
        this.mAePrecaptureStarted = true;
    }

    public boolean shouldSetAeModeAlwaysFlash(int i6) {
        return this.mAePrecaptureStarted && i6 == 0 && this.mHasAutoFlashUnderExposedQuirk;
    }

    public OverrideAeModeForStillCapture(@NonNull Quirks quirks) {
        this.mHasAutoFlashUnderExposedQuirk = quirks.get(AutoFlashUnderExposedQuirk.class) != null;
    }
}
