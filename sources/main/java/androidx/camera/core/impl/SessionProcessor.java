package androidx.camera.core.impl;

import android.hardware.camera2.CaptureResult;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.impl.RestrictedCameraControl;
import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public interface SessionProcessor {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface CaptureCallback {
        void onCaptureCompleted(long j6, int i6, @NonNull Map<CaptureResult.Key, Object> map);

        void onCaptureFailed(int i6);

        void onCaptureProcessStarted(int i6);

        void onCaptureSequenceAborted(int i6);

        void onCaptureSequenceCompleted(int i6);

        void onCaptureStarted(int i6, long j6);
    }

    void abortCapture(int i6);

    void deInitSession();

    @Nullable
    Pair<Long, Long> getRealtimeCaptureLatency();

    @NonNull
    @RestrictedCameraControl.CameraOperation
    Set<Integer> getSupportedCameraOperations();

    @NonNull
    SessionConfig initSession(@NonNull CameraInfo cameraInfo, @NonNull OutputSurface outputSurface, @NonNull OutputSurface outputSurface2, @Nullable OutputSurface outputSurface3);

    void onCaptureSessionEnd();

    void onCaptureSessionStart(@NonNull RequestProcessor requestProcessor);

    void setParameters(@NonNull Config config);

    int startCapture(@NonNull CaptureCallback captureCallback);

    int startRepeating(@NonNull CaptureCallback captureCallback);

    int startTrigger(@NonNull Config config, @NonNull CaptureCallback captureCallback);

    void stopRepeating();
}
