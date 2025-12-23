package androidx.camera.video;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.ConstantObservable;
import androidx.camera.core.impl.Observable;
import androidx.camera.core.impl.Timebase;
import androidx.camera.video.VideoOutput;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final /* synthetic */ class y0 {
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static Observable b(VideoOutput videoOutput) {
        return ConstantObservable.withValue(null);
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static VideoCapabilities a(VideoOutput videoOutput, @NonNull CameraInfo cameraInfo) {
        return VideoCapabilities.EMPTY;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static Observable c(VideoOutput videoOutput) {
        return StreamInfo.ALWAYS_ACTIVE_OBSERVABLE;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static void e(VideoOutput videoOutput, @NonNull SurfaceRequest surfaceRequest, @NonNull Timebase timebase) {
        videoOutput.onSurfaceRequested(surfaceRequest);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static void d(VideoOutput videoOutput, @NonNull VideoOutput.SourceState sourceState) {
    }
}
