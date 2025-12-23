package androidx.camera.camera2.internal.compat.workaround;

import android.hardware.camera2.CaptureRequest;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.camera2.internal.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.internal.compat.quirk.StillCaptureFlashStopRepeatingQuirk;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public class StillCaptureFlow {
    private final boolean mShouldStopRepeatingBeforeStillCapture;

    public boolean shouldStopRepeatingBeforeCapture(@NonNull List<CaptureRequest> list, boolean z5) {
        if (this.mShouldStopRepeatingBeforeStillCapture && z5) {
            Iterator<CaptureRequest> it = list.iterator();
            while (it.hasNext()) {
                int intValue = ((Integer) it.next().get(CaptureRequest.CONTROL_AE_MODE)).intValue();
                if (intValue == 2 || intValue == 3) {
                    return true;
                }
            }
        }
        return false;
    }

    public StillCaptureFlow() {
        boolean z5;
        if (((StillCaptureFlashStopRepeatingQuirk) DeviceQuirks.get(StillCaptureFlashStopRepeatingQuirk.class)) != null) {
            z5 = true;
        } else {
            z5 = false;
        }
        this.mShouldStopRepeatingBeforeStillCapture = z5;
    }
}
