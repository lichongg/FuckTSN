package androidx.camera.camera2.internal.compat.workaround;

import android.hardware.camera2.CaptureRequest;
import android.util.Rational;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.OptIn;
import androidx.annotation.RequiresApi;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.internal.compat.quirk.PreviewPixelHDRnetQuirk;
import androidx.camera.camera2.interop.ExperimentalCamera2Interop;
import androidx.camera.core.impl.SessionConfig;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public class PreviewPixelHDRnet {
    public static final Rational ASPECT_RATIO_16_9 = new Rational(16, 9);

    private static boolean isAspectRatioMatch(@NonNull Size size, @NonNull Rational rational) {
        return rational.equals(new Rational(size.getWidth(), size.getHeight()));
    }

    @OptIn(markerClass = {ExperimentalCamera2Interop.class})
    public static void setHDRnet(@NonNull Size size, @NonNull SessionConfig.Builder builder) {
        if (((PreviewPixelHDRnetQuirk) DeviceQuirks.get(PreviewPixelHDRnetQuirk.class)) == null || isAspectRatioMatch(size, ASPECT_RATIO_16_9)) {
            return;
        }
        Camera2ImplConfig.Builder builder2 = new Camera2ImplConfig.Builder();
        builder2.setCaptureRequestOption(CaptureRequest.TONEMAP_MODE, 2);
        builder.addImplementationOptions(builder2.build());
    }

    private PreviewPixelHDRnet() {
    }
}
