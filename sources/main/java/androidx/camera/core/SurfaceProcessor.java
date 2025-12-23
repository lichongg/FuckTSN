package androidx.camera.core;

import androidx.annotation.NonNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public interface SurfaceProcessor {
    void onInputSurface(@NonNull SurfaceRequest surfaceRequest) throws ProcessingException;

    void onOutputSurface(@NonNull SurfaceOutput surfaceOutput) throws ProcessingException;
}
