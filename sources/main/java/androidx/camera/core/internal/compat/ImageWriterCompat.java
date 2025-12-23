package androidx.camera.core.internal.compat;

import android.media.Image;
import android.media.ImageWriter;
import android.os.Build;
import android.view.Surface;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(23)
/* loaded from: D:\Downloads\app\classes.dex */
public final class ImageWriterCompat {
    @NonNull
    public static ImageWriter newInstance(@NonNull Surface surface, @IntRange(from = 1) int i6, int i7) {
        int i8 = Build.VERSION.SDK_INT;
        if (i8 >= 29) {
            return ImageWriterCompatApi29Impl.newInstance(surface, i6, i7);
        }
        if (i8 >= 26) {
            return ImageWriterCompatApi26Impl.newInstance(surface, i6, i7);
        }
        throw new RuntimeException("Unable to call newInstance(Surface, int, int) on API " + i8 + ". Version 26 or higher required.");
    }

    public static void close(@NonNull ImageWriter imageWriter) {
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 23) {
            ImageWriterCompatApi23Impl.close(imageWriter);
            return;
        }
        throw new RuntimeException("Unable to call close() on API " + i6 + ". Version 23 or higher required.");
    }

    @NonNull
    public static Image dequeueInputImage(@NonNull ImageWriter imageWriter) {
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 23) {
            return ImageWriterCompatApi23Impl.dequeueInputImage(imageWriter);
        }
        throw new RuntimeException("Unable to call dequeueInputImage() on API " + i6 + ". Version 23 or higher required.");
    }

    public static void queueInputImage(@NonNull ImageWriter imageWriter, @NonNull Image image) {
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 23) {
            ImageWriterCompatApi23Impl.queueInputImage(imageWriter, image);
            return;
        }
        throw new RuntimeException("Unable to call queueInputImage() on API " + i6 + ". Version 23 or higher required.");
    }

    private ImageWriterCompat() {
    }

    @NonNull
    public static ImageWriter newInstance(@NonNull Surface surface, @IntRange(from = 1) int i6) {
        int i7 = Build.VERSION.SDK_INT;
        if (i7 >= 23) {
            return ImageWriterCompatApi23Impl.newInstance(surface, i6);
        }
        throw new RuntimeException("Unable to call newInstance(Surface, int) on API " + i7 + ". Version 23 or higher required.");
    }
}
