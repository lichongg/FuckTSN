package androidx.camera.video.internal;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.Observable;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public interface BufferProvider<T> extends Observable<State> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum State {
        ACTIVE,
        INACTIVE
    }

    @NonNull
    ListenableFuture<T> acquireBuffer();
}
