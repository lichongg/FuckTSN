package androidx.camera.video.internal.audio;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import androidx.annotation.VisibleForTesting;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.Observable;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.video.internal.BufferProvider;
import androidx.camera.video.internal.audio.AudioSource;
import androidx.camera.video.internal.audio.AudioStream;
import androidx.camera.video.internal.encoder.InputBuffer;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.nio.ByteBuffer;
import java.nio.ShortBuffer;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public final class AudioSource {

    @VisibleForTesting
    static final long DEFAULT_START_RETRY_INTERVAL_MS = 3000;
    private static final String TAG = "AudioSource";

    @Nullable
    private FutureCallback<InputBuffer> mAcquireBufferCallback;
    long mAmplitudeTimestamp;
    double mAudioAmplitude;
    private final int mAudioFormat;

    @Nullable
    AudioSourceCallback mAudioSourceCallback;
    final AudioStream mAudioStream;
    boolean mAudioStreamSilenced;

    @Nullable
    BufferProvider<? extends InputBuffer> mBufferProvider;

    @NonNull
    BufferProvider.State mBufferProviderState;

    @Nullable
    Executor mCallbackExecutor;
    final Executor mExecutor;
    boolean mInSilentStartState;
    boolean mIsSendingAudio;
    private long mLatestFailedStartTimeNs;
    boolean mMuted;
    final AtomicReference<Boolean> mNotifiedSilenceState;
    final AtomicBoolean mNotifiedSuspendState;
    final SilentAudioStream mSilentAudioStream;
    private final long mStartRetryIntervalNs;

    @NonNull
    InternalState mState;

    @Nullable
    private Observable.Observer<BufferProvider.State> mStateObserver;

    @Nullable
    private byte[] mZeroBytes;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface AudioSourceCallback {
        void onAmplitudeValue(double d6);

        void onError(@NonNull Throwable th);

        void onSilenceStateChanged(boolean z5);

        @VisibleForTesting
        void onSuspendStateChanged(boolean z5);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class AudioStreamCallback implements AudioStream.AudioStreamCallback {
        AudioStreamCallback() {
        }

        @Override // androidx.camera.video.internal.audio.AudioStream.AudioStreamCallback
        public void onSilenceStateChanged(boolean z5) {
            AudioSource audioSource = AudioSource.this;
            audioSource.mAudioStreamSilenced = z5;
            if (audioSource.mState == InternalState.STARTED) {
                audioSource.notifySilenced();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    enum InternalState {
        CONFIGURED,
        STARTED,
        RELEASED
    }

    @RequiresPermission("android.permission.RECORD_AUDIO")
    public AudioSource(@NonNull AudioSettings audioSettings, @NonNull Executor executor, @Nullable Context context) throws AudioSourceAccessException {
        this(audioSettings, executor, context, new AudioStreamFactory() { // from class: androidx.camera.video.internal.audio.d
            @Override // androidx.camera.video.internal.audio.AudioStreamFactory
            public final AudioStream create(AudioSettings audioSettings2, Context context2) {
                return new AudioStreamImpl(audioSettings2, context2);
            }
        }, DEFAULT_START_RETRY_INTERVAL_MS);
    }

    @Nullable
    private static BufferProvider.State fetchBufferProviderState(@NonNull BufferProvider<? extends InputBuffer> bufferProvider) {
        try {
            ListenableFuture<? extends InputBuffer> fetchData = bufferProvider.fetchData();
            if (fetchData.isDone()) {
                return (BufferProvider.State) fetchData.get();
            }
        } catch (InterruptedException | ExecutionException unused) {
        }
        return null;
    }

    public void start() {
        this.mExecutor.execute(new Runnable() { // from class: androidx.camera.video.internal.audio.j
            @Override // java.lang.Runnable
            public final void run() {
                r0.start(AudioSource.this.mMuted);
            }
        });
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: androidx.camera.video.internal.audio.AudioSource$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$androidx$camera$video$internal$audio$AudioSource$InternalState;

        static {
            int[] iArr = new int[InternalState.values().length];
            $SwitchMap$androidx$camera$video$internal$audio$AudioSource$InternalState = iArr;
            try {
                iArr[InternalState.CONFIGURED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$camera$video$internal$audio$AudioSource$InternalState[InternalState.STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$camera$video$internal$audio$AudioSource$InternalState[InternalState.RELEASED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @RequiresPermission("android.permission.RECORD_AUDIO")
    @VisibleForTesting
    AudioSource(@NonNull AudioSettings audioSettings, @NonNull Executor executor, @Nullable Context context, @NonNull AudioStreamFactory audioStreamFactory, long j6) throws AudioSourceAccessException {
        this.mNotifiedSilenceState = new AtomicReference<>(null);
        this.mNotifiedSuspendState = new AtomicBoolean(false);
        this.mState = InternalState.CONFIGURED;
        this.mBufferProviderState = BufferProvider.State.INACTIVE;
        this.mAmplitudeTimestamp = 0L;
        Executor newSequentialExecutor = CameraXExecutors.newSequentialExecutor(executor);
        this.mExecutor = newSequentialExecutor;
        this.mStartRetryIntervalNs = TimeUnit.MILLISECONDS.toNanos(j6);
        try {
            BufferedAudioStream bufferedAudioStream = new BufferedAudioStream(audioStreamFactory.create(audioSettings, context), audioSettings);
            this.mAudioStream = bufferedAudioStream;
            bufferedAudioStream.setCallback(new AudioStreamCallback(), newSequentialExecutor);
            this.mSilentAudioStream = new SilentAudioStream(audioSettings);
            this.mAudioFormat = audioSettings.getAudioFormat();
        } catch (AudioStream.AudioStreamException | IllegalArgumentException e6) {
            throw new AudioSourceAccessException("Unable to create AudioStream", e6);
        }
    }

    public static /* synthetic */ Object a(final AudioSource audioSource, final CallbackToFutureAdapter.Completer completer) {
        audioSource.mExecutor.execute(new Runnable() { // from class: androidx.camera.video.internal.audio.i
            @Override // java.lang.Runnable
            public final void run() {
                AudioSource.f(AudioSource.this, completer);
            }
        });
        return "AudioSource-release";
    }

    private void resetBufferProvider(@Nullable final BufferProvider<? extends InputBuffer> bufferProvider) {
        BufferProvider<? extends InputBuffer> bufferProvider2 = this.mBufferProvider;
        if (bufferProvider2 != null) {
            Observable.Observer<BufferProvider.State> observer = this.mStateObserver;
            Objects.requireNonNull(observer);
            bufferProvider2.removeObserver(observer);
            this.mBufferProvider = null;
            this.mStateObserver = null;
            this.mAcquireBufferCallback = null;
            this.mBufferProviderState = BufferProvider.State.INACTIVE;
            updateSendingAudio();
        }
        if (bufferProvider != null) {
            this.mBufferProvider = bufferProvider;
            this.mStateObserver = new Observable.Observer<BufferProvider.State>() { // from class: androidx.camera.video.internal.audio.AudioSource.1
                @Override // androidx.camera.core.impl.Observable.Observer
                public void onError(@NonNull Throwable th) {
                    AudioSource audioSource = AudioSource.this;
                    if (audioSource.mBufferProvider == bufferProvider) {
                        audioSource.notifyError(th);
                    }
                }

                @Override // androidx.camera.core.impl.Observable.Observer
                public void onNewData(@Nullable BufferProvider.State state) {
                    Objects.requireNonNull(state);
                    if (AudioSource.this.mBufferProvider == bufferProvider) {
                        Logger.d(AudioSource.TAG, "Receive BufferProvider state change: " + AudioSource.this.mBufferProviderState + " to " + state);
                        AudioSource audioSource = AudioSource.this;
                        if (audioSource.mBufferProviderState != state) {
                            audioSource.mBufferProviderState = state;
                            audioSource.updateSendingAudio();
                        }
                    }
                }
            };
            this.mAcquireBufferCallback = new FutureCallback<InputBuffer>() { // from class: androidx.camera.video.internal.audio.AudioSource.2
                @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                public void onFailure(@NonNull Throwable th) {
                    if (AudioSource.this.mBufferProvider != bufferProvider) {
                        return;
                    }
                    Logger.d(AudioSource.TAG, "Unable to get input buffer, the BufferProvider could be transitioning to INACTIVE state.");
                    if (th instanceof IllegalStateException) {
                        return;
                    }
                    AudioSource.this.notifyError(th);
                }

                @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                public void onSuccess(InputBuffer inputBuffer) {
                    AudioSource audioSource = AudioSource.this;
                    if (!audioSource.mIsSendingAudio || audioSource.mBufferProvider != bufferProvider) {
                        inputBuffer.cancel();
                        return;
                    }
                    if (audioSource.mInSilentStartState && audioSource.isStartRetryIntervalReached()) {
                        AudioSource.this.retryStartAudioStream();
                    }
                    AudioStream currentAudioStream = AudioSource.this.getCurrentAudioStream();
                    ByteBuffer byteBuffer = inputBuffer.getByteBuffer();
                    AudioStream.PacketInfo read = currentAudioStream.read(byteBuffer);
                    if (read.getSizeInBytes() > 0) {
                        AudioSource audioSource2 = AudioSource.this;
                        if (audioSource2.mMuted) {
                            audioSource2.overrideBySilence(byteBuffer, read.getSizeInBytes());
                        }
                        if (AudioSource.this.mCallbackExecutor != null) {
                            long timestampNs = read.getTimestampNs();
                            AudioSource audioSource3 = AudioSource.this;
                            if (timestampNs - audioSource3.mAmplitudeTimestamp >= 200) {
                                audioSource3.mAmplitudeTimestamp = read.getTimestampNs();
                                AudioSource.this.postMaxAmplitude(byteBuffer);
                            }
                        }
                        byteBuffer.limit(byteBuffer.position() + read.getSizeInBytes());
                        inputBuffer.setPresentationTimeUs(TimeUnit.NANOSECONDS.toMicros(read.getTimestampNs()));
                        inputBuffer.submit();
                    } else {
                        Logger.w(AudioSource.TAG, "Unable to read data from AudioStream.");
                        inputBuffer.cancel();
                    }
                    AudioSource.this.sendNextAudio();
                }
            };
            BufferProvider.State fetchBufferProviderState = fetchBufferProviderState(bufferProvider);
            if (fetchBufferProviderState != null) {
                this.mBufferProviderState = fetchBufferProviderState;
                updateSendingAudio();
            }
            this.mBufferProvider.addObserver(this.mExecutor, this.mStateObserver);
        }
    }

    private void startSendingAudio() {
        if (this.mIsSendingAudio) {
            return;
        }
        try {
            Logger.d(TAG, "startSendingAudio");
            this.mAudioStream.start();
            this.mInSilentStartState = false;
        } catch (AudioStream.AudioStreamException e6) {
            Logger.w(TAG, "Failed to start AudioStream", e6);
            this.mInSilentStartState = true;
            this.mSilentAudioStream.start();
            this.mLatestFailedStartTimeNs = getCurrentSystemTimeNs();
            notifySilenced();
        }
        this.mIsSendingAudio = true;
        sendNextAudio();
    }

    private void stopSendingAudio() {
        if (this.mIsSendingAudio) {
            this.mIsSendingAudio = false;
            Logger.d(TAG, "stopSendingAudio");
            this.mAudioStream.stop();
        }
    }

    @NonNull
    AudioStream getCurrentAudioStream() {
        return this.mInSilentStartState ? this.mSilentAudioStream : this.mAudioStream;
    }

    boolean isStartRetryIntervalReached() {
        Preconditions.checkState(this.mLatestFailedStartTimeNs > 0);
        return getCurrentSystemTimeNs() - this.mLatestFailedStartTimeNs >= this.mStartRetryIntervalNs;
    }

    public void mute(final boolean z5) {
        this.mExecutor.execute(new Runnable() { // from class: androidx.camera.video.internal.audio.a
            @Override // java.lang.Runnable
            public final void run() {
                AudioSource.e(AudioSource.this, z5);
            }
        });
    }

    void notifyError(@NonNull final Throwable th) {
        Executor executor = this.mCallbackExecutor;
        final AudioSourceCallback audioSourceCallback = this.mAudioSourceCallback;
        if (executor == null || audioSourceCallback == null) {
            return;
        }
        executor.execute(new Runnable() { // from class: androidx.camera.video.internal.audio.c
            @Override // java.lang.Runnable
            public final void run() {
                AudioSource.AudioSourceCallback.this.onError(th);
            }
        });
    }

    void notifySilenced() {
        Executor executor = this.mCallbackExecutor;
        final AudioSourceCallback audioSourceCallback = this.mAudioSourceCallback;
        if (executor == null || audioSourceCallback == null) {
            return;
        }
        final boolean z5 = this.mMuted || this.mInSilentStartState || this.mAudioStreamSilenced;
        if (Objects.equals(this.mNotifiedSilenceState.getAndSet(Boolean.valueOf(z5)), Boolean.valueOf(z5))) {
            return;
        }
        executor.execute(new Runnable() { // from class: androidx.camera.video.internal.audio.h
            @Override // java.lang.Runnable
            public final void run() {
                AudioSource.AudioSourceCallback.this.onSilenceStateChanged(z5);
            }
        });
    }

    void notifySuspended(final boolean z5) {
        Executor executor = this.mCallbackExecutor;
        final AudioSourceCallback audioSourceCallback = this.mAudioSourceCallback;
        if (executor == null || audioSourceCallback == null || this.mNotifiedSuspendState.getAndSet(z5) == z5) {
            return;
        }
        executor.execute(new Runnable() { // from class: androidx.camera.video.internal.audio.m
            @Override // java.lang.Runnable
            public final void run() {
                AudioSource.AudioSourceCallback.this.onSuspendStateChanged(z5);
            }
        });
    }

    void overrideBySilence(@NonNull ByteBuffer byteBuffer, int i6) {
        byte[] bArr = this.mZeroBytes;
        if (bArr == null || bArr.length < i6) {
            this.mZeroBytes = new byte[i6];
        }
        int position = byteBuffer.position();
        byteBuffer.put(this.mZeroBytes, 0, i6);
        byteBuffer.limit(byteBuffer.position()).position(position);
    }

    void postMaxAmplitude(ByteBuffer byteBuffer) {
        Executor executor = this.mCallbackExecutor;
        final AudioSourceCallback audioSourceCallback = this.mAudioSourceCallback;
        if (this.mAudioFormat == 2) {
            ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
            double d6 = 0.0d;
            while (asShortBuffer.hasRemaining()) {
                d6 = Math.max(d6, Math.abs((int) asShortBuffer.get()));
            }
            this.mAudioAmplitude = d6 / 32767.0d;
            if (executor == null || audioSourceCallback == null) {
                return;
            }
            executor.execute(new Runnable() { // from class: androidx.camera.video.internal.audio.l
                @Override // java.lang.Runnable
                public final void run() {
                    audioSourceCallback.onAmplitudeValue(AudioSource.this.mAudioAmplitude);
                }
            });
        }
    }

    @NonNull
    public ListenableFuture<Void> release() {
        return CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.video.internal.audio.f
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return AudioSource.a(AudioSource.this, completer);
            }
        });
    }

    void retryStartAudioStream() {
        Preconditions.checkState(this.mInSilentStartState);
        try {
            this.mAudioStream.start();
            Logger.d(TAG, "Retry start AudioStream succeed");
            this.mSilentAudioStream.stop();
            this.mInSilentStartState = false;
        } catch (AudioStream.AudioStreamException e6) {
            Logger.w(TAG, "Retry start AudioStream failed", e6);
            this.mLatestFailedStartTimeNs = getCurrentSystemTimeNs();
        }
    }

    void sendNextAudio() {
        BufferProvider<? extends InputBuffer> bufferProvider = this.mBufferProvider;
        Objects.requireNonNull(bufferProvider);
        ListenableFuture<? extends InputBuffer> acquireBuffer = bufferProvider.acquireBuffer();
        FutureCallback<InputBuffer> futureCallback = this.mAcquireBufferCallback;
        Objects.requireNonNull(futureCallback);
        Futures.addCallback(acquireBuffer, futureCallback, this.mExecutor);
    }

    public void setAudioSourceCallback(@NonNull final Executor executor, @NonNull final AudioSourceCallback audioSourceCallback) {
        this.mExecutor.execute(new Runnable() { // from class: androidx.camera.video.internal.audio.k
            @Override // java.lang.Runnable
            public final void run() {
                AudioSource.b(AudioSource.this, executor, audioSourceCallback);
            }
        });
    }

    public void setBufferProvider(@NonNull final BufferProvider<? extends InputBuffer> bufferProvider) {
        this.mExecutor.execute(new Runnable() { // from class: androidx.camera.video.internal.audio.b
            @Override // java.lang.Runnable
            public final void run() {
                AudioSource.d(AudioSource.this, bufferProvider);
            }
        });
    }

    void setState(InternalState internalState) {
        Logger.d(TAG, "Transitioning internal state: " + this.mState + " --> " + internalState);
        this.mState = internalState;
    }

    public void start(final boolean z5) {
        this.mExecutor.execute(new Runnable() { // from class: androidx.camera.video.internal.audio.g
            @Override // java.lang.Runnable
            public final void run() {
                AudioSource.k(AudioSource.this, z5);
            }
        });
    }

    public void stop() {
        this.mExecutor.execute(new Runnable() { // from class: androidx.camera.video.internal.audio.e
            @Override // java.lang.Runnable
            public final void run() {
                AudioSource.g(AudioSource.this);
            }
        });
    }

    void updateSendingAudio() {
        if (this.mState != InternalState.STARTED) {
            stopSendingAudio();
            return;
        }
        boolean z5 = this.mBufferProviderState == BufferProvider.State.ACTIVE;
        notifySuspended(!z5);
        if (z5) {
            startSendingAudio();
        } else {
            stopSendingAudio();
        }
    }

    public static /* synthetic */ void b(AudioSource audioSource, Executor executor, AudioSourceCallback audioSourceCallback) {
        audioSource.getClass();
        int i6 = AnonymousClass3.$SwitchMap$androidx$camera$video$internal$audio$AudioSource$InternalState[audioSource.mState.ordinal()];
        if (i6 != 1) {
            if (i6 != 2 && i6 != 3) {
            } else {
                throw new AssertionError("The audio recording callback must be registered before the audio source is started.");
            }
        } else {
            audioSource.mCallbackExecutor = executor;
            audioSource.mAudioSourceCallback = audioSourceCallback;
        }
    }

    public static /* synthetic */ void d(AudioSource audioSource, BufferProvider bufferProvider) {
        audioSource.getClass();
        int i6 = AnonymousClass3.$SwitchMap$androidx$camera$video$internal$audio$AudioSource$InternalState[audioSource.mState.ordinal()];
        if (i6 != 1 && i6 != 2) {
            if (i6 == 3) {
                throw new AssertionError("AudioSource is released");
            }
        } else if (audioSource.mBufferProvider != bufferProvider) {
            audioSource.resetBufferProvider(bufferProvider);
        }
    }

    public static /* synthetic */ void e(AudioSource audioSource, boolean z5) {
        audioSource.getClass();
        int i6 = AnonymousClass3.$SwitchMap$androidx$camera$video$internal$audio$AudioSource$InternalState[audioSource.mState.ordinal()];
        if (i6 != 1 && i6 != 2) {
            if (i6 == 3) {
                throw new AssertionError("AudioSource is released");
            }
        } else if (audioSource.mMuted != z5) {
            audioSource.mMuted = z5;
            if (audioSource.mState == InternalState.STARTED) {
                audioSource.notifySilenced();
            }
        }
    }

    public static /* synthetic */ void f(AudioSource audioSource, CallbackToFutureAdapter.Completer completer) {
        audioSource.getClass();
        try {
            int i6 = AnonymousClass3.$SwitchMap$androidx$camera$video$internal$audio$AudioSource$InternalState[audioSource.mState.ordinal()];
            if (i6 == 1 || i6 == 2) {
                audioSource.resetBufferProvider(null);
                audioSource.mSilentAudioStream.release();
                audioSource.mAudioStream.release();
                audioSource.stopSendingAudio();
                audioSource.setState(InternalState.RELEASED);
            }
            completer.set(null);
        } catch (Throwable th) {
            completer.setException(th);
        }
    }

    public static /* synthetic */ void g(AudioSource audioSource) {
        audioSource.getClass();
        int i6 = AnonymousClass3.$SwitchMap$androidx$camera$video$internal$audio$AudioSource$InternalState[audioSource.mState.ordinal()];
        if (i6 != 2) {
            if (i6 != 3) {
                return;
            }
            Logger.w(TAG, "AudioSource is released. Calling stop() is a no-op.");
        } else {
            audioSource.setState(InternalState.CONFIGURED);
            audioSource.updateSendingAudio();
        }
    }

    private static long getCurrentSystemTimeNs() {
        return System.nanoTime();
    }

    public static boolean isSettingsSupported(int i6, int i7, int i8) {
        return AudioStreamImpl.isSettingsSupported(i6, i7, i8);
    }

    public static /* synthetic */ void k(AudioSource audioSource, boolean z5) {
        audioSource.getClass();
        int i6 = AnonymousClass3.$SwitchMap$androidx$camera$video$internal$audio$AudioSource$InternalState[audioSource.mState.ordinal()];
        if (i6 != 1) {
            if (i6 != 3) {
                return;
            } else {
                throw new AssertionError("AudioSource is released");
            }
        }
        audioSource.mNotifiedSilenceState.set(null);
        audioSource.mNotifiedSuspendState.set(false);
        audioSource.setState(InternalState.STARTED);
        audioSource.mute(z5);
        audioSource.updateSendingAudio();
    }
}
