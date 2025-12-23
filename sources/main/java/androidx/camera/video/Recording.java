package androidx.camera.video;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.camera.core.impl.utils.CloseGuardHelper;
import androidx.core.util.Preconditions;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public final class Recording implements AutoCloseable {
    private final CloseGuardHelper mCloseGuard;
    private final AtomicBoolean mIsClosed;
    private final boolean mIsPersistent;
    private final OutputOptions mOutputOptions;
    private final Recorder mRecorder;
    private final long mRecordingId;

    @Override // java.lang.AutoCloseable
    public void close() {
        stopWithError(0, null);
    }

    @NonNull
    static Recording createFinalizedFrom(@NonNull PendingRecording pendingRecording, long j6) {
        Preconditions.checkNotNull(pendingRecording, "The given PendingRecording cannot be null.");
        return new Recording(pendingRecording.getRecorder(), j6, pendingRecording.getOutputOptions(), pendingRecording.isPersistent(), true);
    }

    @NonNull
    static Recording from(@NonNull PendingRecording pendingRecording, long j6) {
        Preconditions.checkNotNull(pendingRecording, "The given PendingRecording cannot be null.");
        return new Recording(pendingRecording.getRecorder(), j6, pendingRecording.getOutputOptions(), pendingRecording.isPersistent(), false);
    }

    private void stopWithError(int i6, @Nullable Throwable th) {
        this.mCloseGuard.close();
        if (this.mIsClosed.getAndSet(true)) {
            return;
        }
        this.mRecorder.stop(this, i6, th);
    }

    protected void finalize() throws Throwable {
        try {
            this.mCloseGuard.warnIfOpen();
            stopWithError(10, new RuntimeException("Recording stopped due to being garbage collected."));
        } finally {
            super.finalize();
        }
    }

    @NonNull
    OutputOptions getOutputOptions() {
        return this.mOutputOptions;
    }

    long getRecordingId() {
        return this.mRecordingId;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isClosed() {
        return this.mIsClosed.get();
    }

    @ExperimentalPersistentRecording
    public boolean isPersistent() {
        return this.mIsPersistent;
    }

    public void mute(boolean z5) {
        if (this.mIsClosed.get()) {
            throw new IllegalStateException("The recording has been stopped.");
        }
        this.mRecorder.mute(this, z5);
    }

    public void pause() {
        if (this.mIsClosed.get()) {
            throw new IllegalStateException("The recording has been stopped.");
        }
        this.mRecorder.pause(this);
    }

    public void resume() {
        if (this.mIsClosed.get()) {
            throw new IllegalStateException("The recording has been stopped.");
        }
        this.mRecorder.resume(this);
    }

    Recording(@NonNull Recorder recorder, long j6, @NonNull OutputOptions outputOptions, boolean z5, boolean z6) {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.mIsClosed = atomicBoolean;
        CloseGuardHelper create = CloseGuardHelper.create();
        this.mCloseGuard = create;
        this.mRecorder = recorder;
        this.mRecordingId = j6;
        this.mOutputOptions = outputOptions;
        this.mIsPersistent = z5;
        if (z6) {
            atomicBoolean.set(true);
        } else {
            create.open("stop");
        }
    }

    public void stop() {
        close();
    }
}
