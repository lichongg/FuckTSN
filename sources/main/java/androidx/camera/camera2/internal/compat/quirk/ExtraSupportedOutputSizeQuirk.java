package androidx.camera.camera2.internal.compat.quirk;

import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.Build;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.Quirk;
import com.jmolsmobile.landscapevideocapture.configuration.PredefinedCaptureConfigurations;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public class ExtraSupportedOutputSizeQuirk implements Quirk {
    @NonNull
    public Size[] getExtraSupportedResolutions(int i6) {
        return (i6 == 34 && isMotoE5Play()) ? getMotoE5PlayExtraSupportedResolutions() : new Size[0];
    }

    @NonNull
    private Size[] getMotoE5PlayExtraSupportedResolutions() {
        return new Size[]{new Size(PredefinedCaptureConfigurations.f35653t, PredefinedCaptureConfigurations.f35652s), new Size(PredefinedCaptureConfigurations.f35657x, PredefinedCaptureConfigurations.f35652s), new Size(PredefinedCaptureConfigurations.f35648o, PredefinedCaptureConfigurations.f35647n), new Size(960, PredefinedCaptureConfigurations.f35647n), new Size(864, 480), new Size(PredefinedCaptureConfigurations.f35647n, 480)};
    }

    private static boolean isMotoE5Play() {
        return "motorola".equalsIgnoreCase(Build.BRAND) && "moto e5 play".equalsIgnoreCase(Build.MODEL);
    }

    static boolean load() {
        return isMotoE5Play();
    }

    @NonNull
    public <T> Size[] getExtraSupportedResolutions(@NonNull Class<T> cls) {
        if (StreamConfigurationMap.isOutputSupportedFor(cls) && isMotoE5Play()) {
            return getMotoE5PlayExtraSupportedResolutions();
        }
        return new Size[0];
    }
}
