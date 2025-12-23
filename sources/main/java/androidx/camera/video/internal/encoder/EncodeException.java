package androidx.camera.video.internal.encoder;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public class EncodeException extends Exception {
    public static final int ERROR_CODEC = 1;
    public static final int ERROR_UNKNOWN = 0;
    private final int mErrorType;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface ErrorType {
    }

    public int getErrorType() {
        return this.mErrorType;
    }

    public EncodeException(int i6, @Nullable String str, @Nullable Throwable th) {
        super(str, th);
        this.mErrorType = i6;
    }
}
