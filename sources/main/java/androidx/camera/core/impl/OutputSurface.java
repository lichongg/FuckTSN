package androidx.camera.core.impl;

import android.util.Size;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.google.auto.value.AutoValue;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@AutoValue
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public abstract class OutputSurface {
    public abstract int getImageFormat();

    @NonNull
    public abstract Size getSize();

    @NonNull
    public abstract Surface getSurface();

    @NonNull
    public static OutputSurface create(@NonNull Surface surface, @NonNull Size size, int i6) {
        return new AutoValue_OutputSurface(surface, size, i6);
    }
}
