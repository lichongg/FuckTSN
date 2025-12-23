package androidx.camera.video.internal.encoder;

import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.video.internal.BufferProvider;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public interface Encoder {
    public static final long NO_TIMESTAMP = -1;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface ByteBufferInput extends EncoderInput, BufferProvider<InputBuffer> {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface EncoderInput {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface SurfaceInput extends EncoderInput {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public interface OnSurfaceUpdateListener {
            void onSurfaceUpdate(@NonNull Surface surface);
        }

        void setOnSurfaceUpdateListener(@NonNull Executor executor, @NonNull OnSurfaceUpdateListener onSurfaceUpdateListener);
    }

    int getConfiguredBitrate();

    @NonNull
    EncoderInfo getEncoderInfo();

    @NonNull
    EncoderInput getInput();

    @NonNull
    ListenableFuture<Void> getReleasedFuture();

    void pause();

    void release();

    void requestKeyFrame();

    void setEncoderCallback(@NonNull EncoderCallback encoderCallback, @NonNull Executor executor);

    void start();

    void stop();

    void stop(long j6);
}
