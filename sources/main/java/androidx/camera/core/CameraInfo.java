package androidx.camera.core;

import android.util.Range;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.LiveData;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public interface CameraInfo {

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final String IMPLEMENTATION_TYPE_CAMERA2 = "androidx.camera.camera2";

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final String IMPLEMENTATION_TYPE_CAMERA2_LEGACY = "androidx.camera.camera2.legacy";

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final String IMPLEMENTATION_TYPE_FAKE = "androidx.camera.fake";

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final String IMPLEMENTATION_TYPE_UNKNOWN = "<unknown>";

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final float INTRINSIC_ZOOM_RATIO_UNKNOWN = 1.0f;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface ImplementationType {
    }

    @NonNull
    CameraSelector getCameraSelector();

    @NonNull
    LiveData<CameraState> getCameraState();

    @NonNull
    ExposureState getExposureState();

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    String getImplementationType();

    @FloatRange(from = 0.0d, fromInclusive = false)
    float getIntrinsicZoomRatio();

    int getLensFacing();

    int getSensorRotationDegrees();

    int getSensorRotationDegrees(int i6);

    @NonNull
    Set<Range<Integer>> getSupportedFrameRateRanges();

    @NonNull
    LiveData<Integer> getTorchState();

    @NonNull
    LiveData<ZoomState> getZoomState();

    boolean hasFlashUnit();

    boolean isFocusMeteringSupported(@NonNull FocusMeteringAction focusMeteringAction);

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    boolean isPrivateReprocessingSupported();

    @ExperimentalZeroShutterLag
    boolean isZslSupported();
}
