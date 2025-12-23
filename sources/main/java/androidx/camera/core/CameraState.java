package androidx.camera.core;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.auto.value.AutoValue;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@AutoValue
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public abstract class CameraState {
    public static final int ERROR_CAMERA_DISABLED = 5;
    public static final int ERROR_CAMERA_FATAL_ERROR = 6;
    public static final int ERROR_CAMERA_IN_USE = 2;
    public static final int ERROR_DO_NOT_DISTURB_MODE_ENABLED = 7;
    public static final int ERROR_MAX_CAMERAS_IN_USE = 1;
    public static final int ERROR_OTHER_RECOVERABLE_ERROR = 3;
    public static final int ERROR_STREAM_CONFIG = 4;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum ErrorType {
        RECOVERABLE,
        CRITICAL
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @AutoValue
    public static abstract class StateError {
        @NonNull
        public static StateError create(int i6) {
            return create(i6, null);
        }

        @Nullable
        public abstract Throwable getCause();

        public abstract int getCode();

        @NonNull
        public static StateError create(int i6, @Nullable Throwable th) {
            return new AutoValue_CameraState_StateError(i6, th);
        }

        @NonNull
        public ErrorType getType() {
            int code = getCode();
            if (code != 2 && code != 1 && code != 3) {
                return ErrorType.CRITICAL;
            }
            return ErrorType.RECOVERABLE;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum Type {
        PENDING_OPEN,
        OPENING,
        OPEN,
        CLOSING,
        CLOSED
    }

    @NonNull
    public static CameraState create(@NonNull Type type) {
        return create(type, null);
    }

    @Nullable
    public abstract StateError getError();

    @NonNull
    public abstract Type getType();

    @NonNull
    public static CameraState create(@NonNull Type type, @Nullable StateError stateError) {
        return new AutoValue_CameraState(type, stateError);
    }
}
