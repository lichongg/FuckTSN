package androidx.camera.core.internal.compat;

import android.media.ImageWriter;
import android.view.Surface;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(29)
/* loaded from: D:\Downloads\app\classes.dex */
final class ImageWriterCompatApi29Impl {
    private ImageWriterCompatApi29Impl() {
    }

    @NonNull
    static ImageWriter newInstance(@NonNull Surface surface, @IntRange(from = 1) int i6, int i7) {
        return ImageWriter.newInstance(surface, i6, i7);
    }
}
