package androidx.camera.core.internal.compat;

import android.media.ImageWriter;
import android.os.Build;
import android.view.Surface;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.util.Preconditions;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(26)
/* loaded from: D:\Downloads\app\classes.dex */
final class ImageWriterCompatApi26Impl {
    private static final String TAG = "ImageWriterCompatApi26";
    private static Method sNewInstanceMethod;

    static {
        try {
            Class cls = Integer.TYPE;
            sNewInstanceMethod = ImageWriter.class.getMethod("newInstance", Surface.class, cls, cls);
        } catch (NoSuchMethodException unused) {
        }
    }

    @NonNull
    static ImageWriter newInstance(@NonNull Surface surface, @IntRange(from = 1) int i6, int i7) {
        Throwable th = null;
        if (Build.VERSION.SDK_INT >= 26) {
            try {
            } catch (IllegalAccessException | InvocationTargetException e6) {
                e = e6;
            }
            try {
                return (ImageWriter) Preconditions.checkNotNull(sNewInstanceMethod.invoke(null, surface, Integer.valueOf(i6), Integer.valueOf(i7)));
            } catch (InvocationTargetException e7) {
                e = e7;
                th = e;
                throw new RuntimeException("Unable to invoke newInstance(Surface, int, int) via reflection.", th);
            }
        }
        throw new RuntimeException("Unable to invoke newInstance(Surface, int, int) via reflection.", th);
    }

    private ImageWriterCompatApi26Impl() {
    }
}
