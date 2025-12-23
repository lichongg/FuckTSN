package androidx.camera.core.processing;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import androidx.camera.core.ImageCaptureException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public interface Operation<I, O> {
    @NonNull
    @WorkerThread
    O apply(@NonNull I i6) throws ImageCaptureException;
}
