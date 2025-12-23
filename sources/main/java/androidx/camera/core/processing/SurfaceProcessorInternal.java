package androidx.camera.core.processing;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.SurfaceProcessor;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(api = 21)
/* loaded from: D:\Downloads\app\classes.dex */
public interface SurfaceProcessorInternal extends SurfaceProcessor {
    void release();

    @NonNull
    ListenableFuture<Void> snapshot(@IntRange(from = 0, to = 100) int i6, @IntRange(from = 0, to = 359) int i7);
}
