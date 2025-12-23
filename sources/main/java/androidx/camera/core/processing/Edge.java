package androidx.camera.core.processing;

import androidx.annotation.NonNull;
import androidx.core.util.Consumer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public class Edge<T> implements Consumer<T> {
    private Consumer<T> mListener;

    @Override // androidx.core.util.Consumer
    public void accept(@NonNull T t5) {
        kotlin.jvm.internal.g0.n(this.mListener, "Listener is not set.");
        this.mListener.accept(t5);
    }

    public void setListener(@NonNull Consumer<T> consumer) {
        this.mListener = consumer;
    }
}
