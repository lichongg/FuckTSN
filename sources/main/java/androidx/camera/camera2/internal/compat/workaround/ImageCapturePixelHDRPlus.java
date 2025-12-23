package androidx.camera.camera2.internal.compat.workaround;

import android.annotation.SuppressLint;
import android.hardware.camera2.CaptureRequest;
import androidx.annotation.NonNull;
import androidx.annotation.OptIn;
import androidx.annotation.RequiresApi;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.internal.compat.quirk.ImageCapturePixelHDRPlusQuirk;
import androidx.camera.camera2.interop.ExperimentalCamera2Interop;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@OptIn(markerClass = {ExperimentalCamera2Interop.class})
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public class ImageCapturePixelHDRPlus {
    @SuppressLint({"NewApi"})
    public void toggleHDRPlus(int i6, @NonNull Camera2ImplConfig.Builder builder) {
        CaptureRequest.Key key;
        CaptureRequest.Key key2;
        if (((ImageCapturePixelHDRPlusQuirk) DeviceQuirks.get(ImageCapturePixelHDRPlusQuirk.class)) == null) {
            return;
        }
        if (i6 == 0) {
            key = CaptureRequest.CONTROL_ENABLE_ZSL;
            builder.setCaptureRequestOption(key, Boolean.TRUE);
        } else {
            if (i6 != 1) {
                return;
            }
            key2 = CaptureRequest.CONTROL_ENABLE_ZSL;
            builder.setCaptureRequestOption(key2, Boolean.FALSE);
        }
    }
}
