package androidx.camera.core;

import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
final class CameraClosedException extends RuntimeException {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    CameraClosedException(String str, Throwable th) {
        super(str, th);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    CameraClosedException(String str) {
        super(str);
    }
}
