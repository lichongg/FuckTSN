package androidx.camera.core.impl;

import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.DynamicRange;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public interface CameraInfoInternal extends CameraInfo {
    void addSessionCaptureCallback(@NonNull Executor executor, @NonNull CameraCaptureCallback cameraCaptureCallback);

    @NonNull
    String getCameraId();

    @NonNull
    Quirks getCameraQuirks();

    @Override // androidx.camera.core.CameraInfo
    @NonNull
    CameraSelector getCameraSelector();

    @NonNull
    EncoderProfilesProvider getEncoderProfilesProvider();

    @NonNull
    CameraInfoInternal getImplementation();

    @NonNull
    Set<DynamicRange> getSupportedDynamicRanges();

    @NonNull
    List<Size> getSupportedHighResolutions(int i6);

    @NonNull
    List<Size> getSupportedResolutions(int i6);

    @NonNull
    Timebase getTimebase();

    void removeSessionCaptureCallback(@NonNull CameraCaptureCallback cameraCaptureCallback);
}
