package androidx.camera.video.internal.encoder;

import android.media.MediaCodec;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public class EncodedDataImpl implements EncodedData {
    private final int mBufferIndex;
    private final MediaCodec.BufferInfo mBufferInfo;
    private final ByteBuffer mByteBuffer;
    private final AtomicBoolean mClosed = new AtomicBoolean(false);
    private final CallbackToFutureAdapter.Completer<Void> mClosedCompleter;
    private final ListenableFuture<Void> mClosedFuture;
    private final MediaCodec mMediaCodec;

    private void throwIfClosed() {
        if (this.mClosed.get()) {
            throw new IllegalStateException("encoded data is closed.");
        }
    }

    @Override // androidx.camera.video.internal.encoder.EncodedData, java.lang.AutoCloseable
    public void close() {
        if (this.mClosed.getAndSet(true)) {
            return;
        }
        try {
            this.mMediaCodec.releaseOutputBuffer(this.mBufferIndex, false);
            this.mClosedCompleter.set(null);
        } catch (IllegalStateException e6) {
            this.mClosedCompleter.setException(e6);
        }
    }

    @Override // androidx.camera.video.internal.encoder.EncodedData
    @NonNull
    public MediaCodec.BufferInfo getBufferInfo() {
        return this.mBufferInfo;
    }

    @Override // androidx.camera.video.internal.encoder.EncodedData
    @NonNull
    public ListenableFuture<Void> getClosedFuture() {
        return Futures.nonCancellationPropagating(this.mClosedFuture);
    }

    @Override // androidx.camera.video.internal.encoder.EncodedData
    public long getPresentationTimeUs() {
        return this.mBufferInfo.presentationTimeUs;
    }

    @Override // androidx.camera.video.internal.encoder.EncodedData
    public boolean isKeyFrame() {
        return (this.mBufferInfo.flags & 1) != 0;
    }

    @Override // androidx.camera.video.internal.encoder.EncodedData
    public long size() {
        return this.mBufferInfo.size;
    }

    EncodedDataImpl(@NonNull MediaCodec mediaCodec, int i6, @NonNull MediaCodec.BufferInfo bufferInfo) throws MediaCodec.CodecException {
        this.mMediaCodec = (MediaCodec) Preconditions.checkNotNull(mediaCodec);
        this.mBufferIndex = i6;
        this.mByteBuffer = mediaCodec.getOutputBuffer(i6);
        this.mBufferInfo = (MediaCodec.BufferInfo) Preconditions.checkNotNull(bufferInfo);
        final AtomicReference atomicReference = new AtomicReference();
        this.mClosedFuture = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.video.internal.encoder.b
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return EncodedDataImpl.a(atomicReference, completer);
            }
        });
        this.mClosedCompleter = (CallbackToFutureAdapter.Completer) Preconditions.checkNotNull((CallbackToFutureAdapter.Completer) atomicReference.get());
    }

    public static /* synthetic */ Object a(AtomicReference atomicReference, CallbackToFutureAdapter.Completer completer) {
        atomicReference.set(completer);
        return "Data closed";
    }

    @Override // androidx.camera.video.internal.encoder.EncodedData
    @NonNull
    public ByteBuffer getByteBuffer() {
        throwIfClosed();
        this.mByteBuffer.position(this.mBufferInfo.offset);
        ByteBuffer byteBuffer = this.mByteBuffer;
        MediaCodec.BufferInfo bufferInfo = this.mBufferInfo;
        byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
        return this.mByteBuffer;
    }
}
