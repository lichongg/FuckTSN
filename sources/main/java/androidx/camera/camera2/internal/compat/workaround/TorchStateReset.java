package androidx.camera.camera2.internal.compat.workaround;

import android.hardware.camera2.CaptureRequest;
import androidx.annotation.NonNull;
import androidx.annotation.OptIn;
import androidx.annotation.RequiresApi;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.internal.compat.quirk.TorchIsClosedAfterImageCapturingQuirk;
import androidx.camera.camera2.interop.ExperimentalCamera2Interop;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.DeferrableSurface;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public class TorchStateReset {
    private final boolean mIsImageCaptureTorchIsClosedQuirkEnabled;

    @NonNull
    @OptIn(markerClass = {ExperimentalCamera2Interop.class})
    public CaptureConfig createTorchResetRequest(@NonNull CaptureConfig captureConfig) {
        CaptureConfig.Builder builder = new CaptureConfig.Builder();
        builder.setTemplateType(captureConfig.getTemplateType());
        Iterator<DeferrableSurface> it = captureConfig.getSurfaces().iterator();
        while (it.hasNext()) {
            builder.addSurface(it.next());
        }
        builder.addImplementationOptions(captureConfig.getImplementationOptions());
        Camera2ImplConfig.Builder builder2 = new Camera2ImplConfig.Builder();
        builder2.setCaptureRequestOption(CaptureRequest.FLASH_MODE, 0);
        builder.addImplementationOptions(builder2.build());
        return builder.build();
    }

    public boolean isTorchResetRequired(@NonNull List<CaptureRequest> list, boolean z5) {
        if (!this.mIsImageCaptureTorchIsClosedQuirkEnabled || !z5) {
            return false;
        }
        Iterator<CaptureRequest> it = list.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next().get(CaptureRequest.FLASH_MODE);
            if (num != null && num.intValue() == 2) {
                return true;
            }
        }
        return false;
    }

    public TorchStateReset() {
        boolean z5;
        if (DeviceQuirks.get(TorchIsClosedAfterImageCapturingQuirk.class) != null) {
            z5 = true;
        } else {
            z5 = false;
        }
        this.mIsImageCaptureTorchIsClosedQuirkEnabled = z5;
    }
}
