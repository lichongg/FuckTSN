package androidx.camera.lifecycle;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.CameraProvider;
import androidx.camera.core.UseCase;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
interface LifecycleCameraProvider extends CameraProvider {
    boolean isBound(@NonNull UseCase useCase);

    void unbind(@NonNull UseCase... useCaseArr);

    void unbindAll();
}
