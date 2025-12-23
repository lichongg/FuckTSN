package androidx.camera.video.internal.audio;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.Logger;
import androidx.camera.video.internal.audio.AudioStream;
import androidx.core.util.Preconditions;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public class SilentAudioStream implements AudioStream {
    private static final String TAG = "SilentAudioStream";

    @Nullable
    private AudioStream.AudioStreamCallback mAudioStreamCallback;
    private final int mBytesPerFrame;

    @Nullable
    private Executor mCallbackExecutor;
    private long mCurrentReadTimeNs;
    private final int mSampleRate;

    @Nullable
    private byte[] mZeroBytes;
    private final AtomicBoolean mIsStarted = new AtomicBoolean(false);
    private final AtomicBoolean mIsReleased = new AtomicBoolean(false);

    private void checkNotReleasedOrThrow() {
        Preconditions.checkState(!this.mIsReleased.get(), "AudioStream has been released.");
    }

    private void checkStartedOrThrow() {
        Preconditions.checkState(this.mIsStarted.get(), "AudioStream has not been started.");
    }

    private void notifySilenced() {
        final AudioStream.AudioStreamCallback audioStreamCallback = this.mAudioStreamCallback;
        Executor executor = this.mCallbackExecutor;
        if (audioStreamCallback == null || executor == null) {
            return;
        }
        executor.execute(new Runnable() { // from class: androidx.camera.video.internal.audio.x
            @Override // java.lang.Runnable
            public final void run() {
                AudioStream.AudioStreamCallback.this.onSilenceStateChanged(true);
            }
        });
    }

    @Override // androidx.camera.video.internal.audio.AudioStream
    public void release() {
        this.mIsReleased.getAndSet(true);
    }

    @Override // androidx.camera.video.internal.audio.AudioStream
    public void setCallback(@Nullable AudioStream.AudioStreamCallback audioStreamCallback, @Nullable Executor executor) {
        boolean z5 = true;
        Preconditions.checkState(!this.mIsStarted.get(), "AudioStream can not be started when setCallback.");
        checkNotReleasedOrThrow();
        if (audioStreamCallback != null && executor == null) {
            z5 = false;
        }
        Preconditions.checkArgument(z5, "executor can't be null with non-null callback.");
        this.mAudioStreamCallback = audioStreamCallback;
        this.mCallbackExecutor = executor;
    }

    public SilentAudioStream(@NonNull AudioSettings audioSettings) {
        this.mBytesPerFrame = audioSettings.getBytesPerFrame();
        this.mSampleRate = audioSettings.getSampleRate();
    }

    private static void blockUntilSystemTimeReached(long j6) {
        long currentSystemTimeNs = j6 - currentSystemTimeNs();
        if (currentSystemTimeNs > 0) {
            try {
                Thread.sleep(TimeUnit.NANOSECONDS.toMillis(currentSystemTimeNs));
            } catch (InterruptedException e6) {
                Logger.w(TAG, "Ignore interruption", e6);
            }
        }
    }

    private static long currentSystemTimeNs() {
        return System.nanoTime();
    }

    private void writeSilenceToBuffer(@NonNull ByteBuffer byteBuffer, int i6) {
        boolean z5;
        if (i6 <= byteBuffer.remaining()) {
            z5 = true;
        } else {
            z5 = false;
        }
        Preconditions.checkState(z5);
        byte[] bArr = this.mZeroBytes;
        if (bArr == null || bArr.length < i6) {
            this.mZeroBytes = new byte[i6];
        }
        int position = byteBuffer.position();
        byteBuffer.put(this.mZeroBytes, 0, i6).limit(i6 + position).position(position);
    }

    @Override // androidx.camera.video.internal.audio.AudioStream
    @NonNull
    public AudioStream.PacketInfo read(@NonNull ByteBuffer byteBuffer) {
        checkNotReleasedOrThrow();
        checkStartedOrThrow();
        long sizeToFrameCount = AudioUtils.sizeToFrameCount(byteBuffer.remaining(), this.mBytesPerFrame);
        int frameCountToSize = (int) AudioUtils.frameCountToSize(sizeToFrameCount, this.mBytesPerFrame);
        if (frameCountToSize <= 0) {
            return AudioStream.PacketInfo.of(0, this.mCurrentReadTimeNs);
        }
        long frameCountToDurationNs = this.mCurrentReadTimeNs + AudioUtils.frameCountToDurationNs(sizeToFrameCount, this.mSampleRate);
        blockUntilSystemTimeReached(frameCountToDurationNs);
        writeSilenceToBuffer(byteBuffer, frameCountToSize);
        AudioStream.PacketInfo of = AudioStream.PacketInfo.of(frameCountToSize, this.mCurrentReadTimeNs);
        this.mCurrentReadTimeNs = frameCountToDurationNs;
        return of;
    }

    @Override // androidx.camera.video.internal.audio.AudioStream
    public void start() {
        checkNotReleasedOrThrow();
        if (this.mIsStarted.getAndSet(true)) {
            return;
        }
        this.mCurrentReadTimeNs = currentSystemTimeNs();
        notifySilenced();
    }

    @Override // androidx.camera.video.internal.audio.AudioStream
    public void stop() {
        checkNotReleasedOrThrow();
        this.mIsStarted.set(false);
    }
}
