package androidx.camera.core.processing;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public interface Node<I, O> {
    void release();

    @NonNull
    @MainThread
    O transform(@NonNull I i6);
}
