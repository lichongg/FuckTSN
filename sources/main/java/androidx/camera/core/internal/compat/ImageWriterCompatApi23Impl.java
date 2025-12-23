package androidx.camera.core.internal.compat;

import android.media.Image;
import android.media.ImageWriter;
import android.view.Surface;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(23)
/* loaded from: D:\Downloads\app\classes.dex */
final class ImageWriterCompatApi23Impl {
    private ImageWriterCompatApi23Impl() {
    }

    static void close(ImageWriter imageWriter) {
        imageWriter.close();
    }

    @NonNull
    static Image dequeueInputImage(@NonNull ImageWriter imageWriter) {
        return imageWriter.dequeueInputImage();
    }

    @NonNull
    static ImageWriter newInstance(@NonNull Surface surface, @IntRange(from = 1) int i6) {
        return ImageWriter.newInstance(surface, i6);
    }

    static void queueInputImage(@NonNull ImageWriter imageWriter, @NonNull Image image) {
        imageWriter.queueInputImage(image);
    }
}
