package androidx.camera.video.internal.encoder;

import android.media.MediaCodec;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.google.common.util.concurrent.ListenableFuture;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public interface EncodedData extends AutoCloseable {
    @Override // java.lang.AutoCloseable
    void close();

    @NonNull
    MediaCodec.BufferInfo getBufferInfo();

    @NonNull
    ByteBuffer getByteBuffer();

    @NonNull
    ListenableFuture<Void> getClosedFuture();

    long getPresentationTimeUs();

    boolean isKeyFrame();

    long size();
}
