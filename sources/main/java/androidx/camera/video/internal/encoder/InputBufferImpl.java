package androidx.camera.video.internal.encoder;

import android.media.MediaCodec;
import androidx.annotation.IntRange;
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
class InputBufferImpl implements InputBuffer {
    private final int mBufferIndex;
    private final ByteBuffer mByteBuffer;
    private final MediaCodec mMediaCodec;
    private final CallbackToFutureAdapter.Completer<Void> mTerminationCompleter;
    private final ListenableFuture<Void> mTerminationFuture;
    private final AtomicBoolean mTerminated = new AtomicBoolean(false);
    private long mPresentationTimeUs = 0;
    private boolean mIsEndOfStream = false;

    private void throwIfTerminated() {
        if (this.mTerminated.get()) {
            throw new IllegalStateException("The buffer is submitted or canceled.");
        }
    }

    @Override // androidx.camera.video.internal.encoder.InputBuffer
    public boolean cancel() {
        if (this.mTerminated.getAndSet(true)) {
            return false;
        }
        try {
            this.mMediaCodec.queueInputBuffer(this.mBufferIndex, 0, 0, 0L, 0);
            this.mTerminationCompleter.set(null);
        } catch (IllegalStateException e6) {
            this.mTerminationCompleter.setException(e6);
        }
        return true;
    }

    @Override // androidx.camera.video.internal.encoder.InputBuffer
    @NonNull
    public ListenableFuture<Void> getTerminationFuture() {
        return Futures.nonCancellationPropagating(this.mTerminationFuture);
    }

    @Override // androidx.camera.video.internal.encoder.InputBuffer
    public boolean submit() {
        if (this.mTerminated.getAndSet(true)) {
            return false;
        }
        try {
            this.mMediaCodec.queueInputBuffer(this.mBufferIndex, this.mByteBuffer.position(), this.mByteBuffer.limit(), this.mPresentationTimeUs, this.mIsEndOfStream ? 4 : 0);
            this.mTerminationCompleter.set(null);
            return true;
        } catch (IllegalStateException e6) {
            this.mTerminationCompleter.setException(e6);
            return false;
        }
    }

    InputBufferImpl(@NonNull MediaCodec mediaCodec, @IntRange(from = 0) int i6) throws MediaCodec.CodecException {
        this.mMediaCodec = (MediaCodec) Preconditions.checkNotNull(mediaCodec);
        this.mBufferIndex = Preconditions.checkArgumentNonnegative(i6);
        this.mByteBuffer = mediaCodec.getInputBuffer(i6);
        final AtomicReference atomicReference = new AtomicReference();
        this.mTerminationFuture = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.video.internal.encoder.r0
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return InputBufferImpl.a(atomicReference, completer);
            }
        });
        this.mTerminationCompleter = (CallbackToFutureAdapter.Completer) Preconditions.checkNotNull((CallbackToFutureAdapter.Completer) atomicReference.get());
    }

    public static /* synthetic */ Object a(AtomicReference atomicReference, CallbackToFutureAdapter.Completer completer) {
        atomicReference.set(completer);
        return "Terminate InputBuffer";
    }

    @Override // androidx.camera.video.internal.encoder.InputBuffer
    @NonNull
    public ByteBuffer getByteBuffer() {
        throwIfTerminated();
        return this.mByteBuffer;
    }

    @Override // androidx.camera.video.internal.encoder.InputBuffer
    public void setEndOfStream(boolean z5) {
        throwIfTerminated();
        this.mIsEndOfStream = z5;
    }

    @Override // androidx.camera.video.internal.encoder.InputBuffer
    public void setPresentationTimeUs(long j6) {
        boolean z5;
        throwIfTerminated();
        if (j6 >= 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        Preconditions.checkArgument(z5);
        this.mPresentationTimeUs = j6;
    }
}
