package androidx.camera.video;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.Observable;
import androidx.camera.core.impl.Timebase;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public interface VideoOutput {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public enum SourceState {
        ACTIVE_STREAMING,
        ACTIVE_NON_STREAMING,
        INACTIVE
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    VideoCapabilities getMediaCapabilities(@NonNull CameraInfo cameraInfo);

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    Observable<MediaSpec> getMediaSpec();

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    Observable<StreamInfo> getStreamInfo();

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    void onSourceStateChanged(@NonNull SourceState sourceState);

    void onSurfaceRequested(@NonNull SurfaceRequest surfaceRequest);

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    void onSurfaceRequested(@NonNull SurfaceRequest surfaceRequest, @NonNull Timebase timebase);
}
