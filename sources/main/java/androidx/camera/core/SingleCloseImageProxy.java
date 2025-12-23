package androidx.camera.core;

import androidx.annotation.RequiresApi;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
final class SingleCloseImageProxy extends ForwardingImageProxy {
    private final AtomicBoolean mClosed;

    @Override // androidx.camera.core.ForwardingImageProxy, androidx.camera.core.ImageProxy, java.lang.AutoCloseable
    public void close() {
        if (this.mClosed.getAndSet(true)) {
            return;
        }
        super.close();
    }

    SingleCloseImageProxy(ImageProxy imageProxy) {
        super(imageProxy);
        this.mClosed = new AtomicBoolean(false);
    }
}
