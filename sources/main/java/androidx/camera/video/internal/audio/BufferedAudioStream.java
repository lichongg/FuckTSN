package androidx.camera.video.internal.audio;

import android.annotation.SuppressLint;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.video.internal.audio.AudioStream;
import androidx.core.util.Preconditions;
import java.nio.ByteBuffer;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public class BufferedAudioStream implements AudioStream {
    private static final int DATA_WAITING_TIME_MILLIS = 1;
    private static final int DEFAULT_BUFFER_SIZE_IN_FRAME = 1024;
    private static final int DEFAULT_QUEUE_SIZE = 500;
    private static final String TAG = "BufferedAudioStream";
    private final AudioStream mAudioStream;
    private int mBufferSize;
    private final int mBytesPerFrame;
    private final int mQueueMaxSize;
    private final int mSampleRate;
    private final AtomicBoolean mIsStarted = new AtomicBoolean(false);
    private final AtomicBoolean mIsReleased = new AtomicBoolean(false);

    @GuardedBy("mLock")
    private final Queue<AudioData> mAudioDataQueue = new ConcurrentLinkedQueue();
    private final Executor mProducerExecutor = CameraXExecutors.newSequentialExecutor(CameraXExecutors.audioExecutor());
    private final Object mLock = new Object();

    @Nullable
    @GuardedBy("mLock")
    private AudioData mAudioDataNotFullyRead = null;
    private final AtomicBoolean mIsCollectingAudioData = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(21)
    static class AudioData {
        private final ByteBuffer mByteBuffer;
        private final int mBytesPerFrame;
        private final int mSampleRate;
        private long mTimestampNs;

        public int getRemainingBufferSizeInBytes() {
            return this.mByteBuffer.remaining();
        }

        public AudioStream.PacketInfo read(@NonNull ByteBuffer byteBuffer) {
            int remaining;
            long j6 = this.mTimestampNs;
            int position = this.mByteBuffer.position();
            int position2 = byteBuffer.position();
            if (this.mByteBuffer.remaining() > byteBuffer.remaining()) {
                remaining = byteBuffer.remaining();
                this.mTimestampNs += AudioUtils.frameCountToDurationNs(AudioUtils.sizeToFrameCount(remaining, this.mBytesPerFrame), this.mSampleRate);
                ByteBuffer duplicate = this.mByteBuffer.duplicate();
                duplicate.position(position).limit(position + remaining);
                byteBuffer.put(duplicate).limit(position2 + remaining).position(position2);
            } else {
                remaining = this.mByteBuffer.remaining();
                byteBuffer.put(this.mByteBuffer).limit(position2 + remaining).position(position2);
            }
            this.mByteBuffer.position(position + remaining);
            return AudioStream.PacketInfo.of(remaining, j6);
        }

        AudioData(@NonNull ByteBuffer byteBuffer, @NonNull AudioStream.PacketInfo packetInfo, int i6, int i7) {
            byteBuffer.rewind();
            int limit = byteBuffer.limit() - byteBuffer.position();
            if (limit == packetInfo.getSizeInBytes()) {
                this.mBytesPerFrame = i6;
                this.mSampleRate = i7;
                this.mByteBuffer = byteBuffer;
                this.mTimestampNs = packetInfo.getTimestampNs();
                return;
            }
            throw new IllegalStateException("Byte buffer size is not match with packet info: " + limit + " != " + packetInfo.getSizeInBytes());
        }
    }

    public static /* synthetic */ void a(BufferedAudioStream bufferedAudioStream) {
        bufferedAudioStream.mIsCollectingAudioData.set(false);
        bufferedAudioStream.mAudioStream.stop();
        synchronized (bufferedAudioStream.mLock) {
            bufferedAudioStream.mAudioDataNotFullyRead = null;
            bufferedAudioStream.mAudioDataQueue.clear();
        }
    }

    public static /* synthetic */ void c(BufferedAudioStream bufferedAudioStream) {
        bufferedAudioStream.mIsCollectingAudioData.set(false);
        bufferedAudioStream.mAudioStream.release();
        synchronized (bufferedAudioStream.mLock) {
            bufferedAudioStream.mAudioDataNotFullyRead = null;
            bufferedAudioStream.mAudioDataQueue.clear();
        }
    }

    private void checkNotReleasedOrThrow() {
        Preconditions.checkState(!this.mIsReleased.get(), "AudioStream has been released.");
    }

    private void checkStartedOrThrow() {
        Preconditions.checkState(this.mIsStarted.get(), "AudioStream has not been started.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void collectAudioData() {
        if (this.mIsCollectingAudioData.get()) {
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.mBufferSize);
            AudioData audioData = new AudioData(allocateDirect, this.mAudioStream.read(allocateDirect), this.mBytesPerFrame, this.mSampleRate);
            int i6 = this.mQueueMaxSize;
            synchronized (this.mLock) {
                try {
                    this.mAudioDataQueue.offer(audioData);
                    while (this.mAudioDataQueue.size() > i6) {
                        this.mAudioDataQueue.poll();
                        Logger.w(TAG, "Drop audio data due to full of queue.");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (this.mIsCollectingAudioData.get()) {
                this.mProducerExecutor.execute(new Runnable() { // from class: androidx.camera.video.internal.audio.u
                    @Override // java.lang.Runnable
                    public final void run() {
                        BufferedAudioStream.this.collectAudioData();
                    }
                });
            }
        }
    }

    private void startCollectingAudioData() {
        if (this.mIsCollectingAudioData.getAndSet(true)) {
            return;
        }
        collectAudioData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCollectionBufferSize(int i6) {
        int i7 = this.mBufferSize;
        if (i7 == i6) {
            return;
        }
        int i8 = this.mBytesPerFrame;
        this.mBufferSize = (i6 / i8) * i8;
        Logger.d(TAG, "Update buffer size from " + i7 + " to " + this.mBufferSize);
    }

    private void updateCollectionBufferSizeAsync(final int i6) {
        this.mProducerExecutor.execute(new Runnable() { // from class: androidx.camera.video.internal.audio.v
            @Override // java.lang.Runnable
            public final void run() {
                BufferedAudioStream.this.updateCollectionBufferSize(i6);
            }
        });
    }

    @Override // androidx.camera.video.internal.audio.AudioStream
    public void release() {
        if (this.mIsReleased.getAndSet(true)) {
            return;
        }
        this.mProducerExecutor.execute(new Runnable() { // from class: androidx.camera.video.internal.audio.w
            @Override // java.lang.Runnable
            public final void run() {
                BufferedAudioStream.c(BufferedAudioStream.this);
            }
        });
    }

    @Override // androidx.camera.video.internal.audio.AudioStream
    public void setCallback(@Nullable final AudioStream.AudioStreamCallback audioStreamCallback, @Nullable final Executor executor) {
        boolean z5 = true;
        Preconditions.checkState(!this.mIsStarted.get(), "AudioStream can not be started when setCallback.");
        checkNotReleasedOrThrow();
        if (audioStreamCallback != null && executor == null) {
            z5 = false;
        }
        Preconditions.checkArgument(z5, "executor can't be null with non-null callback.");
        this.mProducerExecutor.execute(new Runnable() { // from class: androidx.camera.video.internal.audio.s
            @Override // java.lang.Runnable
            public final void run() {
                BufferedAudioStream.this.mAudioStream.setCallback(audioStreamCallback, executor);
            }
        });
    }

    public BufferedAudioStream(@NonNull AudioStream audioStream, @NonNull AudioSettings audioSettings) {
        boolean z5;
        this.mAudioStream = audioStream;
        int bytesPerFrame = audioSettings.getBytesPerFrame();
        this.mBytesPerFrame = bytesPerFrame;
        int sampleRate = audioSettings.getSampleRate();
        this.mSampleRate = sampleRate;
        if (bytesPerFrame > 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        Preconditions.checkArgument(z5, "mBytesPerFrame must be greater than 0.");
        Preconditions.checkArgument(((long) sampleRate) > 0, "mSampleRate must be greater than 0.");
        this.mQueueMaxSize = 500;
        this.mBufferSize = bytesPerFrame * 1024;
    }

    public static /* synthetic */ void b(BufferedAudioStream bufferedAudioStream) {
        bufferedAudioStream.getClass();
        try {
            bufferedAudioStream.mAudioStream.start();
            bufferedAudioStream.startCollectingAudioData();
        } catch (AudioStream.AudioStreamException e6) {
            throw new RuntimeException(e6);
        }
    }

    @Override // androidx.camera.video.internal.audio.AudioStream
    @NonNull
    @SuppressLint({"BanThreadSleep"})
    public AudioStream.PacketInfo read(@NonNull ByteBuffer byteBuffer) {
        boolean z5;
        checkNotReleasedOrThrow();
        checkStartedOrThrow();
        updateCollectionBufferSizeAsync(byteBuffer.remaining());
        AudioStream.PacketInfo of = AudioStream.PacketInfo.of(0, 0L);
        do {
            synchronized (this.mLock) {
                try {
                    AudioData audioData = this.mAudioDataNotFullyRead;
                    this.mAudioDataNotFullyRead = null;
                    if (audioData == null) {
                        audioData = this.mAudioDataQueue.poll();
                    }
                    if (audioData != null) {
                        of = audioData.read(byteBuffer);
                        if (audioData.getRemainingBufferSizeInBytes() > 0) {
                            this.mAudioDataNotFullyRead = audioData;
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (of.getSizeInBytes() <= 0 && this.mIsStarted.get() && !this.mIsReleased.get()) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (z5) {
                try {
                    Thread.sleep(1L);
                } catch (InterruptedException e6) {
                    Logger.w(TAG, "Interruption while waiting for audio data", e6);
                    return of;
                }
            }
        } while (z5);
        return of;
    }

    @Override // androidx.camera.video.internal.audio.AudioStream
    public void start() throws AudioStream.AudioStreamException, IllegalStateException {
        checkNotReleasedOrThrow();
        if (this.mIsStarted.getAndSet(true)) {
            return;
        }
        FutureTask futureTask = new FutureTask(new Runnable() { // from class: androidx.camera.video.internal.audio.t
            @Override // java.lang.Runnable
            public final void run() {
                BufferedAudioStream.b(BufferedAudioStream.this);
            }
        }, null);
        this.mProducerExecutor.execute(futureTask);
        try {
            futureTask.get();
        } catch (InterruptedException | ExecutionException e6) {
            this.mIsStarted.set(false);
            throw new AudioStream.AudioStreamException(e6);
        }
    }

    @Override // androidx.camera.video.internal.audio.AudioStream
    public void stop() throws IllegalStateException {
        checkNotReleasedOrThrow();
        if (!this.mIsStarted.getAndSet(false)) {
            return;
        }
        this.mProducerExecutor.execute(new Runnable() { // from class: androidx.camera.video.internal.audio.r
            @Override // java.lang.Runnable
            public final void run() {
                BufferedAudioStream.a(BufferedAudioStream.this);
            }
        });
    }
}
