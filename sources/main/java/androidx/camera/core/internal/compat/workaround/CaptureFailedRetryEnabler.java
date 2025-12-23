package androidx.camera.core.internal.compat.workaround;

import androidx.annotation.RequiresApi;
import androidx.camera.core.internal.compat.quirk.CaptureFailedRetryQuirk;
import androidx.camera.core.internal.compat.quirk.DeviceQuirks;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public class CaptureFailedRetryEnabler {
    private final CaptureFailedRetryQuirk mCaptureFailedRetryQuirk = (CaptureFailedRetryQuirk) DeviceQuirks.get(CaptureFailedRetryQuirk.class);

    public int getRetryCount() {
        CaptureFailedRetryQuirk captureFailedRetryQuirk = this.mCaptureFailedRetryQuirk;
        if (captureFailedRetryQuirk == null) {
            return 0;
        }
        return captureFailedRetryQuirk.getRetryCount();
    }
}
