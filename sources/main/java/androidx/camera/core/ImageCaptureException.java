package androidx.camera.core;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public class ImageCaptureException extends Exception {
    private final int mImageCaptureError;

    public int getImageCaptureError() {
        return this.mImageCaptureError;
    }

    public ImageCaptureException(int i6, @NonNull String str, @Nullable Throwable th) {
        super(str, th);
        this.mImageCaptureError = i6;
    }
}
