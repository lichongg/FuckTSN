package androidx.camera.core.impl;

import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.camera.core.ImageProxy;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public interface ImageReaderProxy {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public interface OnImageAvailableListener {
        void onImageAvailable(@NonNull ImageReaderProxy imageReaderProxy);
    }

    @Nullable
    ImageProxy acquireLatestImage();

    @Nullable
    ImageProxy acquireNextImage();

    void clearOnImageAvailableListener();

    void close();

    int getHeight();

    int getImageFormat();

    int getMaxImages();

    @Nullable
    Surface getSurface();

    int getWidth();

    void setOnImageAvailableListener(@NonNull OnImageAvailableListener onImageAvailableListener, @NonNull Executor executor);
}
