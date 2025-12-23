package androidx.camera.video.internal.encoder;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.google.common.util.concurrent.ListenableFuture;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public interface InputBuffer {
    boolean cancel();

    @NonNull
    ByteBuffer getByteBuffer();

    @NonNull
    ListenableFuture<Void> getTerminationFuture();

    void setEndOfStream(boolean z5);

    void setPresentationTimeUs(long j6);

    boolean submit();
}
