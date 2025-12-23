package androidx.camera.core;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public class CameraUnavailableException extends Exception {
    public static final int CAMERA_DISABLED = 1;
    public static final int CAMERA_DISCONNECTED = 2;
    public static final int CAMERA_ERROR = 3;
    public static final int CAMERA_IN_USE = 4;
    public static final int CAMERA_MAX_IN_USE = 5;
    public static final int CAMERA_UNAVAILABLE_DO_NOT_DISTURB = 6;
    public static final int CAMERA_UNKNOWN_ERROR = 0;
    private final int mReason;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface Reason {
    }

    public CameraUnavailableException(int i6) {
        this.mReason = i6;
    }

    public int getReason() {
        return this.mReason;
    }

    public CameraUnavailableException(int i6, @Nullable String str) {
        super(str);
        this.mReason = i6;
    }

    public CameraUnavailableException(int i6, @Nullable String str, @Nullable Throwable th) {
        super(str, th);
        this.mReason = i6;
    }

    public CameraUnavailableException(int i6, @Nullable Throwable th) {
        super(th);
        this.mReason = i6;
    }
}
