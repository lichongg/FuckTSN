package androidx.camera.core.imagecapture;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.CaptureConfig;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(api = 21)
/* loaded from: D:\Downloads\app\classes.dex */
public final class CameraRequest {
    private final TakePictureCallback mCallback;
    private final List<CaptureConfig> mCaptureConfigs;

    @NonNull
    List<CaptureConfig> getCaptureConfigs() {
        return this.mCaptureConfigs;
    }

    boolean isAborted() {
        return this.mCallback.isAborted();
    }

    public CameraRequest(@NonNull List<CaptureConfig> list, @NonNull TakePictureCallback takePictureCallback) {
        this.mCaptureConfigs = list;
        this.mCallback = takePictureCallback;
    }
}
