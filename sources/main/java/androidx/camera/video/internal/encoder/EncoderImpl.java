package androidx.camera.video.internal.encoder;

import android.annotation.SuppressLint;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Range;
import android.view.Surface;
import androidx.annotation.DoNotInline;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.Observable;
import androidx.camera.core.impl.Timebase;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.video.internal.BufferProvider;
import androidx.camera.video.internal.DebugUtils;
import androidx.camera.video.internal.compat.quirk.AudioEncoderIgnoresInputTimestampQuirk;
import androidx.camera.video.internal.compat.quirk.CameraUseInconsistentTimebaseQuirk;
import androidx.camera.video.internal.compat.quirk.DeviceQuirks;
import androidx.camera.video.internal.compat.quirk.EncoderNotUsePersistentInputSurfaceQuirk;
import androidx.camera.video.internal.compat.quirk.VideoEncoderSuspendDoesNotIncludeSuspendTimeQuirk;
import androidx.camera.video.internal.encoder.Encoder;
import androidx.camera.video.internal.encoder.EncoderImpl;
import androidx.camera.video.internal.workaround.EncoderFinder;
import androidx.camera.video.internal.workaround.VideoTimebaseConverter;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public class EncoderImpl implements Encoder {
    private static final boolean DEBUG = false;
    private static final int FAKE_BUFFER_INDEX = -9999;
    private static final long NO_LIMIT_LONG = Long.MAX_VALUE;
    private static final Range<Long> NO_RANGE = Range.create(Long.MAX_VALUE, Long.MAX_VALUE);
    private static final long STOP_TIMEOUT_MS = 1000;
    final Executor mEncoderExecutor;
    final EncoderFinder mEncoderFinder;
    private final EncoderInfo mEncoderInfo;
    final Encoder.EncoderInput mEncoderInput;
    final Timebase mInputTimebase;
    final boolean mIsVideoEncoder;
    final MediaCodec mMediaCodec;
    private final MediaFormat mMediaFormat;
    private final CallbackToFutureAdapter.Completer<Void> mReleasedCompleter;
    private final ListenableFuture<Void> mReleasedFuture;
    InternalState mState;
    final String mTag;
    final Object mLock = new Object();
    final Queue<Integer> mFreeInputBufferIndexQueue = new ArrayDeque();
    private final Queue<CallbackToFutureAdapter.Completer<InputBuffer>> mAcquisitionQueue = new ArrayDeque();
    private final Set<InputBuffer> mInputBufferSet = new HashSet();
    final Set<EncodedDataImpl> mEncodedDataSet = new HashSet();
    final Deque<Range<Long>> mActivePauseResumeTimeRanges = new ArrayDeque();
    final TimeProvider mTimeProvider = new SystemTimeProvider();

    @GuardedBy("mLock")
    EncoderCallback mEncoderCallback = EncoderCallback.EMPTY;

    @GuardedBy("mLock")
    Executor mEncoderCallbackExecutor = CameraXExecutors.directExecutor();
    Range<Long> mStartStopTimeRangeUs = NO_RANGE;
    long mTotalPausedDurationUs = 0;
    boolean mPendingCodecStop = false;
    Long mLastDataStopTimestamp = null;
    Future<?> mStopTimeoutFuture = null;
    private MediaCodecCallback mMediaCodecCallback = null;
    private boolean mIsFlushedAfterEndOfStream = false;
    private boolean mSourceStoppedSignalled = false;
    boolean mMediaCodecEosSignalled = false;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class ByteBufferInput implements Encoder.ByteBufferInput {
        private final Map<Observable.Observer<? super BufferProvider.State>, Executor> mStateObservers = new LinkedHashMap();
        private BufferProvider.State mBufferProviderState = BufferProvider.State.INACTIVE;
        private final List<ListenableFuture<InputBuffer>> mAcquisitionList = new ArrayList();

        /* JADX INFO: Access modifiers changed from: private */
        public void cancelInputBuffer(@NonNull ListenableFuture<InputBuffer> listenableFuture) {
            if (listenableFuture.cancel(true)) {
                return;
            }
            Preconditions.checkState(listenableFuture.isDone());
            try {
                listenableFuture.get().cancel();
            } catch (InterruptedException | CancellationException | ExecutionException e6) {
                Logger.w(EncoderImpl.this.mTag, "Unable to cancel the input buffer: " + e6);
            }
        }

        ByteBufferInput() {
        }

        public static /* synthetic */ Object c(final ByteBufferInput byteBufferInput, final CallbackToFutureAdapter.Completer completer) {
            EncoderImpl.this.mEncoderExecutor.execute(new Runnable() { // from class: androidx.camera.video.internal.encoder.z
                @Override // java.lang.Runnable
                public final void run() {
                    completer.set(EncoderImpl.ByteBufferInput.this.mBufferProviderState);
                }
            });
            return "fetchData";
        }

        public static /* synthetic */ void d(ByteBufferInput byteBufferInput, final Observable.Observer observer, Executor executor) {
            byteBufferInput.mStateObservers.put((Observable.Observer) Preconditions.checkNotNull(observer), (Executor) Preconditions.checkNotNull(executor));
            final BufferProvider.State state = byteBufferInput.mBufferProviderState;
            executor.execute(new Runnable() { // from class: androidx.camera.video.internal.encoder.d0
                @Override // java.lang.Runnable
                public final void run() {
                    Observable.Observer.this.onNewData(state);
                }
            });
        }

        public static /* synthetic */ Object h(final ByteBufferInput byteBufferInput, final CallbackToFutureAdapter.Completer completer) {
            EncoderImpl.this.mEncoderExecutor.execute(new Runnable() { // from class: androidx.camera.video.internal.encoder.y
                @Override // java.lang.Runnable
                public final void run() {
                    EncoderImpl.ByteBufferInput.i(EncoderImpl.ByteBufferInput.this, completer);
                }
            });
            return "acquireBuffer";
        }

        public static /* synthetic */ void i(final ByteBufferInput byteBufferInput, CallbackToFutureAdapter.Completer completer) {
            BufferProvider.State state = byteBufferInput.mBufferProviderState;
            if (state == BufferProvider.State.ACTIVE) {
                final ListenableFuture<InputBuffer> acquireInputBuffer = EncoderImpl.this.acquireInputBuffer();
                Futures.propagate(acquireInputBuffer, completer);
                completer.addCancellationListener(new Runnable() { // from class: androidx.camera.video.internal.encoder.a0
                    @Override // java.lang.Runnable
                    public final void run() {
                        EncoderImpl.ByteBufferInput.this.cancelInputBuffer(acquireInputBuffer);
                    }
                }, CameraXExecutors.directExecutor());
                byteBufferInput.mAcquisitionList.add(acquireInputBuffer);
                acquireInputBuffer.addListener(new Runnable() { // from class: androidx.camera.video.internal.encoder.b0
                    @Override // java.lang.Runnable
                    public final void run() {
                        EncoderImpl.ByteBufferInput.this.mAcquisitionList.remove(acquireInputBuffer);
                    }
                }, EncoderImpl.this.mEncoderExecutor);
                return;
            }
            if (state == BufferProvider.State.INACTIVE) {
                completer.setException(new IllegalStateException("BufferProvider is not active."));
                return;
            }
            completer.setException(new IllegalStateException("Unknown state: " + byteBufferInput.mBufferProviderState));
        }

        @Override // androidx.camera.video.internal.BufferProvider
        @NonNull
        public ListenableFuture<InputBuffer> acquireBuffer() {
            return CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.video.internal.encoder.x
                @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                    return EncoderImpl.ByteBufferInput.h(EncoderImpl.ByteBufferInput.this, completer);
                }
            });
        }

        @Override // androidx.camera.core.impl.Observable
        public void addObserver(@NonNull final Executor executor, @NonNull final Observable.Observer<? super BufferProvider.State> observer) {
            EncoderImpl.this.mEncoderExecutor.execute(new Runnable() { // from class: androidx.camera.video.internal.encoder.v
                @Override // java.lang.Runnable
                public final void run() {
                    EncoderImpl.ByteBufferInput.d(EncoderImpl.ByteBufferInput.this, observer, executor);
                }
            });
        }

        @Override // androidx.camera.core.impl.Observable
        @NonNull
        public ListenableFuture<BufferProvider.State> fetchData() {
            return CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.video.internal.encoder.w
                @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                    return EncoderImpl.ByteBufferInput.c(EncoderImpl.ByteBufferInput.this, completer);
                }
            });
        }

        @Override // androidx.camera.core.impl.Observable
        public void removeObserver(@NonNull final Observable.Observer<? super BufferProvider.State> observer) {
            EncoderImpl.this.mEncoderExecutor.execute(new Runnable() { // from class: androidx.camera.video.internal.encoder.e0
                @Override // java.lang.Runnable
                public final void run() {
                    EncoderImpl.ByteBufferInput.this.mStateObservers.remove(Preconditions.checkNotNull(observer));
                }
            });
        }

        void setActive(boolean z5) {
            final BufferProvider.State state = z5 ? BufferProvider.State.ACTIVE : BufferProvider.State.INACTIVE;
            if (this.mBufferProviderState == state) {
                return;
            }
            this.mBufferProviderState = state;
            if (state == BufferProvider.State.INACTIVE) {
                Iterator<ListenableFuture<InputBuffer>> it = this.mAcquisitionList.iterator();
                while (it.hasNext()) {
                    it.next().cancel(true);
                }
                this.mAcquisitionList.clear();
            }
            for (final Map.Entry<Observable.Observer<? super BufferProvider.State>, Executor> entry : this.mStateObservers.entrySet()) {
                try {
                    entry.getValue().execute(new Runnable() { // from class: androidx.camera.video.internal.encoder.c0
                        @Override // java.lang.Runnable
                        public final void run() {
                            ((Observable.Observer) entry.getKey()).onNewData(state);
                        }
                    });
                } catch (RejectedExecutionException e6) {
                    Logger.e(EncoderImpl.this.mTag, "Unable to post to the supplied executor.", e6);
                }
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    enum InternalState {
        CONFIGURED,
        STARTED,
        PAUSED,
        STOPPING,
        PENDING_START,
        PENDING_START_PAUSED,
        PENDING_RELEASE,
        ERROR,
        RELEASED
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(21)
    class MediaCodecCallback extends MediaCodec.Callback {

        @Nullable
        private final VideoTimebaseConverter mVideoTimestampConverter;
        private boolean mHasSendStartCallback = false;
        private boolean mHasFirstData = false;
        private boolean mHasEndData = false;
        private long mLastPresentationTimeUs = 0;
        private long mLastSentAdjustedTimeUs = 0;
        private boolean mIsOutputBufferInPauseState = false;
        private boolean mIsKeyFrameRequired = false;
        private boolean mStopped = false;

        void stop() {
            this.mStopped = true;
        }

        MediaCodecCallback() {
            Timebase timebase = null;
            if (!EncoderImpl.this.mIsVideoEncoder) {
                this.mVideoTimestampConverter = null;
                return;
            }
            if (DeviceQuirks.get(CameraUseInconsistentTimebaseQuirk.class) != null) {
                Logger.w(EncoderImpl.this.mTag, "CameraUseInconsistentTimebaseQuirk is enabled");
            } else {
                timebase = EncoderImpl.this.mInputTimebase;
            }
            this.mVideoTimestampConverter = new VideoTimebaseConverter(EncoderImpl.this.mTimeProvider, timebase);
        }

        public static /* synthetic */ void a(final MediaCodecCallback mediaCodecCallback, MediaCodec.BufferInfo bufferInfo, MediaCodec mediaCodec, int i6) {
            final EncoderCallback encoderCallback;
            final Executor executor;
            if (mediaCodecCallback.mStopped) {
                Logger.w(EncoderImpl.this.mTag, "Receives frame after codec is reset.");
                return;
            }
            switch (AnonymousClass2.$SwitchMap$androidx$camera$video$internal$encoder$EncoderImpl$InternalState[EncoderImpl.this.mState.ordinal()]) {
                case 1:
                case 8:
                case 9:
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    synchronized (EncoderImpl.this.mLock) {
                        EncoderImpl encoderImpl = EncoderImpl.this;
                        encoderCallback = encoderImpl.mEncoderCallback;
                        executor = encoderImpl.mEncoderCallbackExecutor;
                    }
                    if (!mediaCodecCallback.mHasSendStartCallback) {
                        mediaCodecCallback.mHasSendStartCallback = true;
                        try {
                            Objects.requireNonNull(encoderCallback);
                            executor.execute(new Runnable() { // from class: androidx.camera.video.internal.encoder.j0
                                @Override // java.lang.Runnable
                                public final void run() {
                                    EncoderCallback.this.onEncodeStart();
                                }
                            });
                        } catch (RejectedExecutionException e6) {
                            Logger.e(EncoderImpl.this.mTag, "Unable to post to the supplied executor.", e6);
                        }
                    }
                    if (mediaCodecCallback.checkBufferInfo(bufferInfo)) {
                        if (!mediaCodecCallback.mHasFirstData) {
                            mediaCodecCallback.mHasFirstData = true;
                            Logger.d(EncoderImpl.this.mTag, "data timestampUs = " + bufferInfo.presentationTimeUs + ", data timebase = " + EncoderImpl.this.mInputTimebase + ", current system uptimeMs = " + SystemClock.uptimeMillis() + ", current system realtimeMs = " + SystemClock.elapsedRealtime());
                        }
                        MediaCodec.BufferInfo resolveOutputBufferInfo = mediaCodecCallback.resolveOutputBufferInfo(bufferInfo);
                        mediaCodecCallback.mLastSentAdjustedTimeUs = resolveOutputBufferInfo.presentationTimeUs;
                        try {
                            mediaCodecCallback.sendEncodedData(new EncodedDataImpl(mediaCodec, i6, resolveOutputBufferInfo), encoderCallback, executor);
                        } catch (MediaCodec.CodecException e7) {
                            EncoderImpl.this.handleEncodeError(e7);
                            return;
                        }
                    } else if (i6 != -9999) {
                        try {
                            EncoderImpl.this.mMediaCodec.releaseOutputBuffer(i6, false);
                        } catch (MediaCodec.CodecException e8) {
                            EncoderImpl.this.handleEncodeError(e8);
                            return;
                        }
                    }
                    if (mediaCodecCallback.mHasEndData || !mediaCodecCallback.isEndOfStream(bufferInfo)) {
                        return;
                    }
                    mediaCodecCallback.mHasEndData = true;
                    EncoderImpl.this.stopMediaCodec(new Runnable() { // from class: androidx.camera.video.internal.encoder.k0
                        @Override // java.lang.Runnable
                        public final void run() {
                            EncoderImpl.MediaCodecCallback.e(EncoderImpl.MediaCodecCallback.this, executor, encoderCallback);
                        }
                    });
                    return;
                default:
                    throw new IllegalStateException("Unknown state: " + EncoderImpl.this.mState);
            }
        }

        private boolean checkBufferInfo(@NonNull MediaCodec.BufferInfo bufferInfo) {
            if (this.mHasEndData) {
                Logger.d(EncoderImpl.this.mTag, "Drop buffer by already reach end of stream.");
                return false;
            }
            if (bufferInfo.size <= 0) {
                Logger.d(EncoderImpl.this.mTag, "Drop buffer by invalid buffer size.");
                return false;
            }
            if ((bufferInfo.flags & 2) != 0) {
                Logger.d(EncoderImpl.this.mTag, "Drop buffer by codec config.");
                return false;
            }
            VideoTimebaseConverter videoTimebaseConverter = this.mVideoTimestampConverter;
            if (videoTimebaseConverter != null) {
                bufferInfo.presentationTimeUs = videoTimebaseConverter.convertToUptimeUs(bufferInfo.presentationTimeUs);
            }
            long j6 = bufferInfo.presentationTimeUs;
            if (j6 <= this.mLastPresentationTimeUs) {
                Logger.d(EncoderImpl.this.mTag, "Drop buffer by out of order buffer from MediaCodec.");
                return false;
            }
            this.mLastPresentationTimeUs = j6;
            if (!EncoderImpl.this.mStartStopTimeRangeUs.contains((Range<Long>) Long.valueOf(j6))) {
                Logger.d(EncoderImpl.this.mTag, "Drop buffer by not in start-stop range.");
                EncoderImpl encoderImpl = EncoderImpl.this;
                if (encoderImpl.mPendingCodecStop && bufferInfo.presentationTimeUs >= encoderImpl.mStartStopTimeRangeUs.getUpper().longValue()) {
                    Future<?> future = EncoderImpl.this.mStopTimeoutFuture;
                    if (future != null) {
                        future.cancel(true);
                    }
                    EncoderImpl.this.mLastDataStopTimestamp = Long.valueOf(bufferInfo.presentationTimeUs);
                    EncoderImpl.this.signalCodecStop();
                    EncoderImpl.this.mPendingCodecStop = false;
                }
                return false;
            }
            if (updatePauseRangeStateAndCheckIfBufferPaused(bufferInfo)) {
                Logger.d(EncoderImpl.this.mTag, "Drop buffer by pause.");
                return false;
            }
            if (EncoderImpl.this.getAdjustedTimeUs(bufferInfo) <= this.mLastSentAdjustedTimeUs) {
                Logger.d(EncoderImpl.this.mTag, "Drop buffer by adjusted time is less than the last sent time.");
                if (EncoderImpl.this.mIsVideoEncoder && EncoderImpl.isKeyFrame(bufferInfo)) {
                    this.mIsKeyFrameRequired = true;
                }
                return false;
            }
            if (!this.mHasFirstData && !this.mIsKeyFrameRequired && EncoderImpl.this.mIsVideoEncoder) {
                this.mIsKeyFrameRequired = true;
            }
            if (this.mIsKeyFrameRequired) {
                if (!EncoderImpl.isKeyFrame(bufferInfo)) {
                    Logger.d(EncoderImpl.this.mTag, "Drop buffer by not a key frame.");
                    EncoderImpl.this.requestKeyFrameToMediaCodec();
                    return false;
                }
                this.mIsKeyFrameRequired = false;
            }
            return true;
        }

        public static /* synthetic */ void e(MediaCodecCallback mediaCodecCallback, Executor executor, final EncoderCallback encoderCallback) {
            if (EncoderImpl.this.mState == InternalState.ERROR) {
                return;
            }
            try {
                Objects.requireNonNull(encoderCallback);
                executor.execute(new Runnable() { // from class: androidx.camera.video.internal.encoder.i0
                    @Override // java.lang.Runnable
                    public final void run() {
                        EncoderCallback.this.onEncodeStop();
                    }
                });
            } catch (RejectedExecutionException e6) {
                Logger.e(EncoderImpl.this.mTag, "Unable to post to the supplied executor.", e6);
            }
        }

        public static /* synthetic */ void f(MediaCodecCallback mediaCodecCallback, final MediaFormat mediaFormat) {
            final EncoderCallback encoderCallback;
            Executor executor;
            if (mediaCodecCallback.mStopped) {
                Logger.w(EncoderImpl.this.mTag, "Receives onOutputFormatChanged after codec is reset.");
                return;
            }
            switch (AnonymousClass2.$SwitchMap$androidx$camera$video$internal$encoder$EncoderImpl$InternalState[EncoderImpl.this.mState.ordinal()]) {
                case 1:
                case 8:
                case 9:
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    synchronized (EncoderImpl.this.mLock) {
                        EncoderImpl encoderImpl = EncoderImpl.this;
                        encoderCallback = encoderImpl.mEncoderCallback;
                        executor = encoderImpl.mEncoderCallbackExecutor;
                    }
                    try {
                        executor.execute(new Runnable() { // from class: androidx.camera.video.internal.encoder.n0
                            @Override // java.lang.Runnable
                            public final void run() {
                                EncoderCallback.this.onOutputConfigUpdate(new OutputConfig() { // from class: androidx.camera.video.internal.encoder.m0
                                    @Override // androidx.camera.video.internal.encoder.OutputConfig
                                    public final MediaFormat getMediaFormat() {
                                        return EncoderImpl.MediaCodecCallback.b(r1);
                                    }
                                });
                            }
                        });
                        return;
                    } catch (RejectedExecutionException e6) {
                        Logger.e(EncoderImpl.this.mTag, "Unable to post to the supplied executor.", e6);
                        return;
                    }
                default:
                    throw new IllegalStateException("Unknown state: " + EncoderImpl.this.mState);
            }
        }

        public static /* synthetic */ void g(MediaCodecCallback mediaCodecCallback, int i6) {
            if (mediaCodecCallback.mStopped) {
                Logger.w(EncoderImpl.this.mTag, "Receives input frame after codec is reset.");
                return;
            }
            switch (AnonymousClass2.$SwitchMap$androidx$camera$video$internal$encoder$EncoderImpl$InternalState[EncoderImpl.this.mState.ordinal()]) {
                case 1:
                case 8:
                case 9:
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    EncoderImpl.this.mFreeInputBufferIndexQueue.offer(Integer.valueOf(i6));
                    EncoderImpl.this.matchAcquisitionsAndFreeBufferIndexes();
                    return;
                default:
                    throw new IllegalStateException("Unknown state: " + EncoderImpl.this.mState);
            }
        }

        private boolean isEosSignalledAndStopTimeReached(@NonNull MediaCodec.BufferInfo bufferInfo) {
            EncoderImpl encoderImpl = EncoderImpl.this;
            return encoderImpl.mMediaCodecEosSignalled && bufferInfo.presentationTimeUs > encoderImpl.mStartStopTimeRangeUs.getUpper().longValue();
        }

        @NonNull
        private MediaCodec.BufferInfo resolveOutputBufferInfo(@NonNull MediaCodec.BufferInfo bufferInfo) {
            long adjustedTimeUs = EncoderImpl.this.getAdjustedTimeUs(bufferInfo);
            if (bufferInfo.presentationTimeUs == adjustedTimeUs) {
                return bufferInfo;
            }
            Preconditions.checkState(adjustedTimeUs > this.mLastSentAdjustedTimeUs);
            MediaCodec.BufferInfo bufferInfo2 = new MediaCodec.BufferInfo();
            bufferInfo2.set(bufferInfo.offset, bufferInfo.size, adjustedTimeUs, bufferInfo.flags);
            return bufferInfo2;
        }

        private void sendEncodedData(@NonNull final EncodedDataImpl encodedDataImpl, @NonNull final EncoderCallback encoderCallback, @NonNull Executor executor) {
            EncoderImpl.this.mEncodedDataSet.add(encodedDataImpl);
            Futures.addCallback(encodedDataImpl.getClosedFuture(), new FutureCallback<Void>() { // from class: androidx.camera.video.internal.encoder.EncoderImpl.MediaCodecCallback.1
                @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                public void onFailure(@NonNull Throwable th) {
                    EncoderImpl.this.mEncodedDataSet.remove(encodedDataImpl);
                    if (th instanceof MediaCodec.CodecException) {
                        EncoderImpl.this.handleEncodeError((MediaCodec.CodecException) th);
                    } else {
                        EncoderImpl.this.handleEncodeError(0, th.getMessage(), th);
                    }
                }

                @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                public void onSuccess(@Nullable Void r22) {
                    EncoderImpl.this.mEncodedDataSet.remove(encodedDataImpl);
                }
            }, EncoderImpl.this.mEncoderExecutor);
            try {
                executor.execute(new Runnable() { // from class: androidx.camera.video.internal.encoder.l0
                    @Override // java.lang.Runnable
                    public final void run() {
                        EncoderCallback.this.onEncodedData(encodedDataImpl);
                    }
                });
            } catch (RejectedExecutionException e6) {
                Logger.e(EncoderImpl.this.mTag, "Unable to post to the supplied executor.", e6);
                encodedDataImpl.close();
            }
        }

        private boolean updatePauseRangeStateAndCheckIfBufferPaused(@NonNull MediaCodec.BufferInfo bufferInfo) {
            Executor executor;
            final EncoderCallback encoderCallback;
            EncoderImpl.this.updateTotalPausedDuration(bufferInfo.presentationTimeUs);
            boolean isInPauseRange = EncoderImpl.this.isInPauseRange(bufferInfo.presentationTimeUs);
            boolean z5 = this.mIsOutputBufferInPauseState;
            if (!z5 && isInPauseRange) {
                Logger.d(EncoderImpl.this.mTag, "Switch to pause state");
                this.mIsOutputBufferInPauseState = true;
                synchronized (EncoderImpl.this.mLock) {
                    EncoderImpl encoderImpl = EncoderImpl.this;
                    executor = encoderImpl.mEncoderCallbackExecutor;
                    encoderCallback = encoderImpl.mEncoderCallback;
                }
                Objects.requireNonNull(encoderCallback);
                executor.execute(new Runnable() { // from class: androidx.camera.video.internal.encoder.o0
                    @Override // java.lang.Runnable
                    public final void run() {
                        EncoderCallback.this.onEncodePaused();
                    }
                });
                EncoderImpl encoderImpl2 = EncoderImpl.this;
                if (encoderImpl2.mState == InternalState.PAUSED && ((encoderImpl2.mIsVideoEncoder || DeviceQuirks.get(AudioEncoderIgnoresInputTimestampQuirk.class) == null) && (!EncoderImpl.this.mIsVideoEncoder || DeviceQuirks.get(VideoEncoderSuspendDoesNotIncludeSuspendTimeQuirk.class) == null))) {
                    Encoder.EncoderInput encoderInput = EncoderImpl.this.mEncoderInput;
                    if (encoderInput instanceof ByteBufferInput) {
                        ((ByteBufferInput) encoderInput).setActive(false);
                    }
                    EncoderImpl.this.setMediaCodecPaused(true);
                }
                EncoderImpl.this.mLastDataStopTimestamp = Long.valueOf(bufferInfo.presentationTimeUs);
                EncoderImpl encoderImpl3 = EncoderImpl.this;
                if (encoderImpl3.mPendingCodecStop) {
                    Future<?> future = encoderImpl3.mStopTimeoutFuture;
                    if (future != null) {
                        future.cancel(true);
                    }
                    EncoderImpl.this.signalCodecStop();
                    EncoderImpl.this.mPendingCodecStop = false;
                }
            } else if (z5 && !isInPauseRange) {
                Logger.d(EncoderImpl.this.mTag, "Switch to resume state");
                this.mIsOutputBufferInPauseState = false;
                if (EncoderImpl.this.mIsVideoEncoder && !EncoderImpl.isKeyFrame(bufferInfo)) {
                    this.mIsKeyFrameRequired = true;
                }
            }
            return this.mIsOutputBufferInPauseState;
        }

        @Override // android.media.MediaCodec.Callback
        public void onError(@NonNull MediaCodec mediaCodec, @NonNull final MediaCodec.CodecException codecException) {
            EncoderImpl.this.mEncoderExecutor.execute(new Runnable() { // from class: androidx.camera.video.internal.encoder.p0
                @Override // java.lang.Runnable
                public final void run() {
                    EncoderImpl.MediaCodecCallback.h(EncoderImpl.MediaCodecCallback.this, codecException);
                }
            });
        }

        @Override // android.media.MediaCodec.Callback
        public void onInputBufferAvailable(@NonNull MediaCodec mediaCodec, final int i6) {
            EncoderImpl.this.mEncoderExecutor.execute(new Runnable() { // from class: androidx.camera.video.internal.encoder.f0
                @Override // java.lang.Runnable
                public final void run() {
                    EncoderImpl.MediaCodecCallback.g(EncoderImpl.MediaCodecCallback.this, i6);
                }
            });
        }

        @Override // android.media.MediaCodec.Callback
        public void onOutputBufferAvailable(@NonNull final MediaCodec mediaCodec, final int i6, @NonNull final MediaCodec.BufferInfo bufferInfo) {
            EncoderImpl.this.mEncoderExecutor.execute(new Runnable() { // from class: androidx.camera.video.internal.encoder.h0
                @Override // java.lang.Runnable
                public final void run() {
                    EncoderImpl.MediaCodecCallback.a(EncoderImpl.MediaCodecCallback.this, bufferInfo, mediaCodec, i6);
                }
            });
        }

        @Override // android.media.MediaCodec.Callback
        public void onOutputFormatChanged(@NonNull MediaCodec mediaCodec, @NonNull final MediaFormat mediaFormat) {
            EncoderImpl.this.mEncoderExecutor.execute(new Runnable() { // from class: androidx.camera.video.internal.encoder.g0
                @Override // java.lang.Runnable
                public final void run() {
                    EncoderImpl.MediaCodecCallback.f(EncoderImpl.MediaCodecCallback.this, mediaFormat);
                }
            });
        }

        public static /* synthetic */ void h(MediaCodecCallback mediaCodecCallback, MediaCodec.CodecException codecException) {
            mediaCodecCallback.getClass();
            switch (AnonymousClass2.$SwitchMap$androidx$camera$video$internal$encoder$EncoderImpl$InternalState[EncoderImpl.this.mState.ordinal()]) {
                case 1:
                case 8:
                case 9:
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    EncoderImpl.this.handleEncodeError(codecException);
                    return;
                default:
                    throw new IllegalStateException("Unknown state: " + EncoderImpl.this.mState);
            }
        }

        private boolean isEndOfStream(@NonNull MediaCodec.BufferInfo bufferInfo) {
            if (!EncoderImpl.hasEndOfStreamFlag(bufferInfo) && !isEosSignalledAndStopTimeReached(bufferInfo)) {
                return false;
            }
            return true;
        }

        public static /* synthetic */ MediaFormat b(MediaFormat mediaFormat) {
            return mediaFormat;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(21)
    class SurfaceInput implements Encoder.SurfaceInput {
        private final Object mLock = new Object();

        @GuardedBy("mLock")
        private final Set<Surface> mObsoleteSurfaces = new HashSet();

        @GuardedBy("mLock")
        private Surface mSurface;

        @GuardedBy("mLock")
        private Executor mSurfaceUpdateExecutor;

        @GuardedBy("mLock")
        private Encoder.SurfaceInput.OnSurfaceUpdateListener mSurfaceUpdateListener;

        SurfaceInput() {
        }

        private void notifySurfaceUpdate(@NonNull Executor executor, @NonNull final Encoder.SurfaceInput.OnSurfaceUpdateListener onSurfaceUpdateListener, @NonNull final Surface surface) {
            try {
                executor.execute(new Runnable() { // from class: androidx.camera.video.internal.encoder.q0
                    @Override // java.lang.Runnable
                    public final void run() {
                        Encoder.SurfaceInput.OnSurfaceUpdateListener.this.onSurfaceUpdate(surface);
                    }
                });
            } catch (RejectedExecutionException e6) {
                Logger.e(EncoderImpl.this.mTag, "Unable to post to the supplied executor.", e6);
            }
        }

        void releaseSurface() {
            Surface surface;
            HashSet hashSet;
            synchronized (this.mLock) {
                surface = this.mSurface;
                this.mSurface = null;
                hashSet = new HashSet(this.mObsoleteSurfaces);
                this.mObsoleteSurfaces.clear();
            }
            if (surface != null) {
                surface.release();
            }
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                ((Surface) it.next()).release();
            }
        }

        @SuppressLint({"NewApi"})
        void resetSurface() {
            Surface createInputSurface;
            Encoder.SurfaceInput.OnSurfaceUpdateListener onSurfaceUpdateListener;
            Executor executor;
            EncoderNotUsePersistentInputSurfaceQuirk encoderNotUsePersistentInputSurfaceQuirk = (EncoderNotUsePersistentInputSurfaceQuirk) DeviceQuirks.get(EncoderNotUsePersistentInputSurfaceQuirk.class);
            synchronized (this.mLock) {
                try {
                    if (encoderNotUsePersistentInputSurfaceQuirk == null) {
                        if (this.mSurface == null) {
                            createInputSurface = Api23Impl.createPersistentInputSurface();
                            this.mSurface = createInputSurface;
                        } else {
                            createInputSurface = null;
                        }
                        Api23Impl.setInputSurface(EncoderImpl.this.mMediaCodec, this.mSurface);
                    } else {
                        Surface surface = this.mSurface;
                        if (surface != null) {
                            this.mObsoleteSurfaces.add(surface);
                        }
                        createInputSurface = EncoderImpl.this.mMediaCodec.createInputSurface();
                        this.mSurface = createInputSurface;
                    }
                    onSurfaceUpdateListener = this.mSurfaceUpdateListener;
                    executor = this.mSurfaceUpdateExecutor;
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (createInputSurface == null || onSurfaceUpdateListener == null || executor == null) {
                return;
            }
            notifySurfaceUpdate(executor, onSurfaceUpdateListener, createInputSurface);
        }

        @Override // androidx.camera.video.internal.encoder.Encoder.SurfaceInput
        public void setOnSurfaceUpdateListener(@NonNull Executor executor, @NonNull Encoder.SurfaceInput.OnSurfaceUpdateListener onSurfaceUpdateListener) {
            Surface surface;
            synchronized (this.mLock) {
                this.mSurfaceUpdateListener = (Encoder.SurfaceInput.OnSurfaceUpdateListener) Preconditions.checkNotNull(onSurfaceUpdateListener);
                this.mSurfaceUpdateExecutor = (Executor) Preconditions.checkNotNull(executor);
                surface = this.mSurface;
            }
            if (surface != null) {
                notifySurfaceUpdate(executor, onSurfaceUpdateListener, surface);
            }
        }
    }

    public static /* synthetic */ void j(EncoderImpl encoderImpl) {
        encoderImpl.mSourceStoppedSignalled = true;
        if (encoderImpl.mIsFlushedAfterEndOfStream) {
            encoderImpl.mMediaCodec.stop();
            encoderImpl.reset();
        }
    }

    void handleEncodeError(@NonNull MediaCodec.CodecException codecException) {
        handleEncodeError(1, codecException.getMessage(), codecException);
    }

    @Override // androidx.camera.video.internal.encoder.Encoder
    public void stop() {
        stop(-1L);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: androidx.camera.video.internal.encoder.EncoderImpl$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$androidx$camera$video$internal$encoder$EncoderImpl$InternalState;

        static {
            int[] iArr = new int[InternalState.values().length];
            $SwitchMap$androidx$camera$video$internal$encoder$EncoderImpl$InternalState = iArr;
            try {
                iArr[InternalState.CONFIGURED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$camera$video$internal$encoder$EncoderImpl$InternalState[InternalState.STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$camera$video$internal$encoder$EncoderImpl$InternalState[InternalState.PAUSED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$camera$video$internal$encoder$EncoderImpl$InternalState[InternalState.STOPPING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$androidx$camera$video$internal$encoder$EncoderImpl$InternalState[InternalState.PENDING_START_PAUSED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$androidx$camera$video$internal$encoder$EncoderImpl$InternalState[InternalState.PENDING_START.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$androidx$camera$video$internal$encoder$EncoderImpl$InternalState[InternalState.PENDING_RELEASE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$androidx$camera$video$internal$encoder$EncoderImpl$InternalState[InternalState.ERROR.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$androidx$camera$video$internal$encoder$EncoderImpl$InternalState[InternalState.RELEASED.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(23)
    private static class Api23Impl {
        private Api23Impl() {
        }

        @NonNull
        @DoNotInline
        static Surface createPersistentInputSurface() {
            Surface createPersistentInputSurface;
            createPersistentInputSurface = MediaCodec.createPersistentInputSurface();
            return createPersistentInputSurface;
        }

        @DoNotInline
        static void setInputSurface(@NonNull MediaCodec mediaCodec, @NonNull Surface surface) {
            mediaCodec.setInputSurface(surface);
        }
    }

    public static /* synthetic */ void a(EncoderImpl encoderImpl) {
        if (encoderImpl.mPendingCodecStop) {
            Logger.w(encoderImpl.mTag, "The data didn't reach the expected timestamp before timeout, stop the codec.");
            encoderImpl.mLastDataStopTimestamp = null;
            encoderImpl.signalCodecStop();
            encoderImpl.mPendingCodecStop = false;
        }
    }

    private void clampVideoBitrateIfNotSupported(@NonNull VideoEncoderInfo videoEncoderInfo, @NonNull MediaFormat mediaFormat) {
        Preconditions.checkState(this.mIsVideoEncoder);
        if (mediaFormat.containsKey("bitrate")) {
            int integer = mediaFormat.getInteger("bitrate");
            int intValue = videoEncoderInfo.getSupportedBitrateRange().clamp(Integer.valueOf(integer)).intValue();
            if (integer != intValue) {
                mediaFormat.setInteger("bitrate", intValue);
                Logger.d(this.mTag, "updated bitrate from " + integer + " to " + intValue);
            }
        }
    }

    @NonNull
    private static EncoderInfo createEncoderInfo(boolean z5, @NonNull MediaCodecInfo mediaCodecInfo, @NonNull String str) throws InvalidConfigException {
        return z5 ? new VideoEncoderInfoImpl(mediaCodecInfo, str) : new AudioEncoderInfoImpl(mediaCodecInfo, str);
    }

    public static /* synthetic */ void d(EncoderImpl encoderImpl, List list, Runnable runnable) {
        if (encoderImpl.mState != InternalState.ERROR) {
            if (!list.isEmpty()) {
                Logger.d(encoderImpl.mTag, "encoded data and input buffers are returned");
            }
            if (!(encoderImpl.mEncoderInput instanceof SurfaceInput) || encoderImpl.mSourceStoppedSignalled) {
                encoderImpl.mMediaCodec.stop();
            } else {
                encoderImpl.mMediaCodec.flush();
                encoderImpl.mIsFlushedAfterEndOfStream = true;
            }
        }
        if (runnable != null) {
            runnable.run();
        }
        encoderImpl.handleStopped();
    }

    static boolean hasEndOfStreamFlag(@NonNull MediaCodec.BufferInfo bufferInfo) {
        return (bufferInfo.flags & 4) != 0;
    }

    static boolean isKeyFrame(@NonNull MediaCodec.BufferInfo bufferInfo) {
        return (bufferInfo.flags & 1) != 0;
    }

    private void releaseInternal() {
        if (this.mIsFlushedAfterEndOfStream) {
            this.mMediaCodec.stop();
            this.mIsFlushedAfterEndOfStream = false;
        }
        this.mMediaCodec.release();
        Encoder.EncoderInput encoderInput = this.mEncoderInput;
        if (encoderInput instanceof SurfaceInput) {
            ((SurfaceInput) encoderInput).releaseSurface();
        }
        setState(InternalState.RELEASED);
        this.mReleasedCompleter.set(null);
    }

    private void reset() {
        this.mStartStopTimeRangeUs = NO_RANGE;
        this.mTotalPausedDurationUs = 0L;
        this.mActivePauseResumeTimeRanges.clear();
        this.mFreeInputBufferIndexQueue.clear();
        Iterator<CallbackToFutureAdapter.Completer<InputBuffer>> it = this.mAcquisitionQueue.iterator();
        while (it.hasNext()) {
            it.next().setCancelled();
        }
        this.mAcquisitionQueue.clear();
        this.mMediaCodec.reset();
        this.mIsFlushedAfterEndOfStream = false;
        this.mSourceStoppedSignalled = false;
        this.mMediaCodecEosSignalled = false;
        this.mPendingCodecStop = false;
        Future<?> future = this.mStopTimeoutFuture;
        if (future != null) {
            future.cancel(true);
            this.mStopTimeoutFuture = null;
        }
        MediaCodecCallback mediaCodecCallback = this.mMediaCodecCallback;
        if (mediaCodecCallback != null) {
            mediaCodecCallback.stop();
        }
        MediaCodecCallback mediaCodecCallback2 = new MediaCodecCallback();
        this.mMediaCodecCallback = mediaCodecCallback2;
        this.mMediaCodec.setCallback(mediaCodecCallback2);
        this.mMediaCodec.configure(this.mMediaFormat, (Surface) null, (MediaCrypto) null, 1);
        Encoder.EncoderInput encoderInput = this.mEncoderInput;
        if (encoderInput instanceof SurfaceInput) {
            ((SurfaceInput) encoderInput).resetSurface();
        }
    }

    private void setState(InternalState internalState) {
        if (this.mState == internalState) {
            return;
        }
        Logger.d(this.mTag, "Transitioning encoder internal state: " + this.mState + " --> " + internalState);
        this.mState = internalState;
    }

    @NonNull
    ListenableFuture<InputBuffer> acquireInputBuffer() {
        switch (AnonymousClass2.$SwitchMap$androidx$camera$video$internal$encoder$EncoderImpl$InternalState[this.mState.ordinal()]) {
            case 1:
                return Futures.immediateFailedFuture(new IllegalStateException("Encoder is not started yet."));
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                final AtomicReference atomicReference = new AtomicReference();
                ListenableFuture<InputBuffer> future = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.video.internal.encoder.g
                    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                        return EncoderImpl.o(atomicReference, completer);
                    }
                });
                final CallbackToFutureAdapter.Completer<InputBuffer> completer = (CallbackToFutureAdapter.Completer) Preconditions.checkNotNull((CallbackToFutureAdapter.Completer) atomicReference.get());
                this.mAcquisitionQueue.offer(completer);
                completer.addCancellationListener(new Runnable() { // from class: androidx.camera.video.internal.encoder.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        EncoderImpl.this.mAcquisitionQueue.remove(completer);
                    }
                }, this.mEncoderExecutor);
                matchAcquisitionsAndFreeBufferIndexes();
                return future;
            case 8:
                return Futures.immediateFailedFuture(new IllegalStateException("Encoder is in error state."));
            case 9:
                return Futures.immediateFailedFuture(new IllegalStateException("Encoder is released."));
            default:
                throw new IllegalStateException("Unknown state: " + this.mState);
        }
    }

    long generatePresentationTimeUs() {
        return this.mTimeProvider.uptimeUs();
    }

    long getAdjustedTimeUs(@NonNull MediaCodec.BufferInfo bufferInfo) {
        long j6 = this.mTotalPausedDurationUs;
        return j6 > 0 ? bufferInfo.presentationTimeUs - j6 : bufferInfo.presentationTimeUs;
    }

    @Override // androidx.camera.video.internal.encoder.Encoder
    public int getConfiguredBitrate() {
        if (this.mMediaFormat.containsKey("bitrate")) {
            return this.mMediaFormat.getInteger("bitrate");
        }
        return 0;
    }

    @Override // androidx.camera.video.internal.encoder.Encoder
    @NonNull
    public EncoderInfo getEncoderInfo() {
        return this.mEncoderInfo;
    }

    @Override // androidx.camera.video.internal.encoder.Encoder
    @NonNull
    public Encoder.EncoderInput getInput() {
        return this.mEncoderInput;
    }

    @Override // androidx.camera.video.internal.encoder.Encoder
    @NonNull
    public ListenableFuture<Void> getReleasedFuture() {
        return this.mReleasedFuture;
    }

    void handleEncodeError(final int i6, @Nullable final String str, @Nullable final Throwable th) {
        switch (AnonymousClass2.$SwitchMap$androidx$camera$video$internal$encoder$EncoderImpl$InternalState[this.mState.ordinal()]) {
            case 1:
                notifyError(i6, str, th);
                reset();
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                setState(InternalState.ERROR);
                stopMediaCodec(new Runnable() { // from class: androidx.camera.video.internal.encoder.q
                    @Override // java.lang.Runnable
                    public final void run() {
                        EncoderImpl.this.notifyError(i6, str, th);
                    }
                });
                break;
            case 8:
                Logger.w(this.mTag, "Get more than one error: " + str + "(" + i6 + ")", th);
                break;
        }
    }

    void handleStopped() {
        InternalState internalState = this.mState;
        if (internalState == InternalState.PENDING_RELEASE) {
            releaseInternal();
            return;
        }
        if (!this.mIsFlushedAfterEndOfStream) {
            reset();
        }
        setState(InternalState.CONFIGURED);
        if (internalState == InternalState.PENDING_START || internalState == InternalState.PENDING_START_PAUSED) {
            start();
            if (internalState == InternalState.PENDING_START_PAUSED) {
                pause();
            }
        }
    }

    boolean isInPauseRange(long j6) {
        for (Range<Long> range : this.mActivePauseResumeTimeRanges) {
            if (range.contains((Range<Long>) Long.valueOf(j6))) {
                return true;
            }
            if (j6 < range.getLower().longValue()) {
                break;
            }
        }
        return false;
    }

    void matchAcquisitionsAndFreeBufferIndexes() {
        while (!this.mAcquisitionQueue.isEmpty() && !this.mFreeInputBufferIndexQueue.isEmpty()) {
            CallbackToFutureAdapter.Completer poll = this.mAcquisitionQueue.poll();
            Objects.requireNonNull(poll);
            Integer poll2 = this.mFreeInputBufferIndexQueue.poll();
            Objects.requireNonNull(poll2);
            try {
                final InputBufferImpl inputBufferImpl = new InputBufferImpl(this.mMediaCodec, poll2.intValue());
                if (poll.set(inputBufferImpl)) {
                    this.mInputBufferSet.add(inputBufferImpl);
                    inputBufferImpl.getTerminationFuture().addListener(new Runnable() { // from class: androidx.camera.video.internal.encoder.i
                        @Override // java.lang.Runnable
                        public final void run() {
                            EncoderImpl.this.mInputBufferSet.remove(inputBufferImpl);
                        }
                    }, this.mEncoderExecutor);
                } else {
                    inputBufferImpl.cancel();
                }
            } catch (MediaCodec.CodecException e6) {
                handleEncodeError(e6);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void notifyError(final int i6, @Nullable final String str, @Nullable final Throwable th) {
        final EncoderCallback encoderCallback;
        Executor executor;
        synchronized (this.mLock) {
            encoderCallback = this.mEncoderCallback;
            executor = this.mEncoderCallbackExecutor;
        }
        try {
            executor.execute(new Runnable() { // from class: androidx.camera.video.internal.encoder.d
                @Override // java.lang.Runnable
                public final void run() {
                    EncoderCallback.this.onEncodeError(new EncodeException(i6, str, th));
                }
            });
        } catch (RejectedExecutionException e6) {
            Logger.e(this.mTag, "Unable to post to the supplied executor.", e6);
        }
    }

    @Override // androidx.camera.video.internal.encoder.Encoder
    public void release() {
        this.mEncoderExecutor.execute(new Runnable() { // from class: androidx.camera.video.internal.encoder.m
            @Override // java.lang.Runnable
            public final void run() {
                EncoderImpl.p(EncoderImpl.this);
            }
        });
    }

    @Override // androidx.camera.video.internal.encoder.Encoder
    public void requestKeyFrame() {
        this.mEncoderExecutor.execute(new Runnable() { // from class: androidx.camera.video.internal.encoder.n
            @Override // java.lang.Runnable
            public final void run() {
                EncoderImpl.e(EncoderImpl.this);
            }
        });
    }

    void requestKeyFrameToMediaCodec() {
        Bundle bundle = new Bundle();
        bundle.putInt("request-sync", 0);
        this.mMediaCodec.setParameters(bundle);
    }

    @Override // androidx.camera.video.internal.encoder.Encoder
    public void setEncoderCallback(@NonNull EncoderCallback encoderCallback, @NonNull Executor executor) {
        synchronized (this.mLock) {
            this.mEncoderCallback = encoderCallback;
            this.mEncoderCallbackExecutor = executor;
        }
    }

    void setMediaCodecPaused(boolean z5) {
        Bundle bundle = new Bundle();
        bundle.putInt("drop-input-frames", z5 ? 1 : 0);
        this.mMediaCodec.setParameters(bundle);
    }

    void signalCodecStop() {
        Encoder.EncoderInput encoderInput = this.mEncoderInput;
        if (encoderInput instanceof ByteBufferInput) {
            ((ByteBufferInput) encoderInput).setActive(false);
            ArrayList arrayList = new ArrayList();
            Iterator<InputBuffer> it = this.mInputBufferSet.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getTerminationFuture());
            }
            Futures.successfulAsList(arrayList).addListener(new Runnable() { // from class: androidx.camera.video.internal.encoder.r
                @Override // java.lang.Runnable
                public final void run() {
                    EncoderImpl.this.signalEndOfInputStream();
                }
            }, this.mEncoderExecutor);
            return;
        }
        if (encoderInput instanceof SurfaceInput) {
            try {
                this.mMediaCodec.signalEndOfInputStream();
                this.mMediaCodecEosSignalled = true;
            } catch (MediaCodec.CodecException e6) {
                handleEncodeError(e6);
            }
        }
    }

    public void signalSourceStopped() {
        this.mEncoderExecutor.execute(new Runnable() { // from class: androidx.camera.video.internal.encoder.o
            @Override // java.lang.Runnable
            public final void run() {
                EncoderImpl.j(EncoderImpl.this);
            }
        });
    }

    @Override // androidx.camera.video.internal.encoder.Encoder
    public void stop(final long j6) {
        final long generatePresentationTimeUs = generatePresentationTimeUs();
        this.mEncoderExecutor.execute(new Runnable() { // from class: androidx.camera.video.internal.encoder.f
            @Override // java.lang.Runnable
            public final void run() {
                EncoderImpl.l(EncoderImpl.this, j6, generatePresentationTimeUs);
            }
        });
    }

    void stopMediaCodec(@Nullable final Runnable runnable) {
        final ArrayList arrayList = new ArrayList();
        Iterator<EncodedDataImpl> it = this.mEncodedDataSet.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getClosedFuture());
        }
        Iterator<InputBuffer> it2 = this.mInputBufferSet.iterator();
        while (it2.hasNext()) {
            arrayList.add(it2.next().getTerminationFuture());
        }
        if (!arrayList.isEmpty()) {
            Logger.d(this.mTag, "Waiting for resources to return. encoded data = " + this.mEncodedDataSet.size() + ", input buffers = " + this.mInputBufferSet.size());
        }
        Futures.successfulAsList(arrayList).addListener(new Runnable() { // from class: androidx.camera.video.internal.encoder.p
            @Override // java.lang.Runnable
            public final void run() {
                EncoderImpl.d(EncoderImpl.this, arrayList, runnable);
            }
        }, this.mEncoderExecutor);
    }

    void updateTotalPausedDuration(long j6) {
        while (!this.mActivePauseResumeTimeRanges.isEmpty()) {
            Range<Long> first = this.mActivePauseResumeTimeRanges.getFirst();
            if (j6 <= first.getUpper().longValue()) {
                return;
            }
            this.mActivePauseResumeTimeRanges.removeFirst();
            this.mTotalPausedDurationUs += first.getUpper().longValue() - first.getLower().longValue();
            Logger.d(this.mTag, "Total paused duration = " + DebugUtils.readableUs(this.mTotalPausedDurationUs));
        }
    }

    public EncoderImpl(@NonNull Executor executor, @NonNull EncoderConfig encoderConfig) throws InvalidConfigException {
        EncoderFinder encoderFinder = new EncoderFinder();
        this.mEncoderFinder = encoderFinder;
        Preconditions.checkNotNull(executor);
        Preconditions.checkNotNull(encoderConfig);
        this.mEncoderExecutor = CameraXExecutors.newSequentialExecutor(executor);
        if (encoderConfig instanceof AudioEncoderConfig) {
            this.mTag = "AudioEncoder";
            this.mIsVideoEncoder = false;
            this.mEncoderInput = new ByteBufferInput();
        } else if (encoderConfig instanceof VideoEncoderConfig) {
            this.mTag = "VideoEncoder";
            this.mIsVideoEncoder = true;
            this.mEncoderInput = new SurfaceInput();
        } else {
            throw new InvalidConfigException("Unknown encoder config type");
        }
        Timebase inputTimebase = encoderConfig.getInputTimebase();
        this.mInputTimebase = inputTimebase;
        Logger.d(this.mTag, "mInputTimebase = " + inputTimebase);
        MediaFormat mediaFormat = encoderConfig.toMediaFormat();
        this.mMediaFormat = mediaFormat;
        Logger.d(this.mTag, "mMediaFormat = " + mediaFormat);
        MediaCodec findEncoder = encoderFinder.findEncoder(mediaFormat);
        this.mMediaCodec = findEncoder;
        Logger.i(this.mTag, "Selected encoder: " + findEncoder.getName());
        EncoderInfo createEncoderInfo = createEncoderInfo(this.mIsVideoEncoder, findEncoder.getCodecInfo(), encoderConfig.getMimeType());
        this.mEncoderInfo = createEncoderInfo;
        if (this.mIsVideoEncoder) {
            clampVideoBitrateIfNotSupported((VideoEncoderInfo) createEncoderInfo, mediaFormat);
        }
        try {
            reset();
            final AtomicReference atomicReference = new AtomicReference();
            this.mReleasedFuture = Futures.nonCancellationPropagating(CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.video.internal.encoder.j
                @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                    return EncoderImpl.n(atomicReference, completer);
                }
            }));
            this.mReleasedCompleter = (CallbackToFutureAdapter.Completer) Preconditions.checkNotNull((CallbackToFutureAdapter.Completer) atomicReference.get());
            setState(InternalState.CONFIGURED);
        } catch (MediaCodec.CodecException e6) {
            throw new InvalidConfigException(e6);
        }
    }

    public static /* synthetic */ void e(EncoderImpl encoderImpl) {
        encoderImpl.getClass();
        int i6 = AnonymousClass2.$SwitchMap$androidx$camera$video$internal$encoder$EncoderImpl$InternalState[encoderImpl.mState.ordinal()];
        if (i6 != 2) {
            if (i6 != 7 && i6 != 9) {
                return;
            } else {
                throw new IllegalStateException("Encoder is released");
            }
        }
        encoderImpl.requestKeyFrameToMediaCodec();
    }

    public static /* synthetic */ void g(EncoderImpl encoderImpl, long j6) {
        encoderImpl.getClass();
        switch (AnonymousClass2.$SwitchMap$androidx$camera$video$internal$encoder$EncoderImpl$InternalState[encoderImpl.mState.ordinal()]) {
            case 1:
            case 3:
            case 4:
            case 5:
            case 8:
                return;
            case 2:
                Logger.d(encoderImpl.mTag, "Pause on " + DebugUtils.readableUs(j6));
                encoderImpl.mActivePauseResumeTimeRanges.addLast(Range.create(Long.valueOf(j6), Long.MAX_VALUE));
                encoderImpl.setState(InternalState.PAUSED);
                return;
            case 6:
                encoderImpl.setState(InternalState.PENDING_START_PAUSED);
                return;
            case 7:
            case 9:
                throw new IllegalStateException("Encoder is released");
            default:
                throw new IllegalStateException("Unknown state: " + encoderImpl.mState);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ void l(final androidx.camera.video.internal.encoder.EncoderImpl r7, long r8, long r10) {
        /*
            r7.getClass()
            int[] r0 = androidx.camera.video.internal.encoder.EncoderImpl.AnonymousClass2.$SwitchMap$androidx$camera$video$internal$encoder$EncoderImpl$InternalState
            androidx.camera.video.internal.encoder.EncoderImpl$InternalState r1 = r7.mState
            int r1 = r1.ordinal()
            r0 = r0[r1]
            switch(r0) {
                case 1: goto Lc1;
                case 2: goto L37;
                case 3: goto L37;
                case 4: goto Lc1;
                case 5: goto L31;
                case 6: goto L31;
                case 7: goto L29;
                case 8: goto Lc1;
                case 9: goto L29;
                default: goto L10;
            }
        L10:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "Unknown state: "
            r9.append(r10)
            androidx.camera.video.internal.encoder.EncoderImpl$InternalState r7 = r7.mState
            r9.append(r7)
            java.lang.String r7 = r9.toString()
            r8.<init>(r7)
            throw r8
        L29:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "Encoder is released"
            r7.<init>(r8)
            throw r7
        L31:
            androidx.camera.video.internal.encoder.EncoderImpl$InternalState r8 = androidx.camera.video.internal.encoder.EncoderImpl.InternalState.CONFIGURED
            r7.setState(r8)
            return
        L37:
            androidx.camera.video.internal.encoder.EncoderImpl$InternalState r0 = r7.mState
            androidx.camera.video.internal.encoder.EncoderImpl$InternalState r1 = androidx.camera.video.internal.encoder.EncoderImpl.InternalState.STOPPING
            r7.setState(r1)
            android.util.Range<java.lang.Long> r1 = r7.mStartStopTimeRangeUs
            java.lang.Comparable r1 = r1.getLower()
            java.lang.Long r1 = (java.lang.Long) r1
            long r2 = r1.longValue()
            r4 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 == 0) goto Lb9
            r4 = -1
            int r6 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r6 != 0) goto L5a
            goto L65
        L5a:
            int r4 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r4 >= 0) goto L66
            java.lang.String r8 = r7.mTag
            java.lang.String r9 = "The expected stop time is less than the start time. Use current time as stop time."
            androidx.camera.core.Logger.w(r8, r9)
        L65:
            r8 = r10
        L66:
            int r10 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r10 < 0) goto Lb1
            java.lang.Long r10 = java.lang.Long.valueOf(r8)
            android.util.Range r10 = android.util.Range.create(r1, r10)
            r7.mStartStopTimeRangeUs = r10
            java.lang.String r10 = r7.mTag
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r1 = "Stop on "
            r11.append(r1)
            java.lang.String r8 = androidx.camera.video.internal.DebugUtils.readableUs(r8)
            r11.append(r8)
            java.lang.String r8 = r11.toString()
            androidx.camera.core.Logger.d(r10, r8)
            androidx.camera.video.internal.encoder.EncoderImpl$InternalState r8 = androidx.camera.video.internal.encoder.EncoderImpl.InternalState.PAUSED
            if (r0 != r8) goto L9a
            java.lang.Long r8 = r7.mLastDataStopTimestamp
            if (r8 == 0) goto L9a
            r7.signalCodecStop()
            return
        L9a:
            r8 = 1
            r7.mPendingCodecStop = r8
            java.util.concurrent.ScheduledExecutorService r8 = androidx.camera.core.impl.utils.executor.CameraXExecutors.mainThreadExecutor()
            androidx.camera.video.internal.encoder.s r9 = new androidx.camera.video.internal.encoder.s
            r9.<init>()
            r10 = 1000(0x3e8, double:4.94E-321)
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.MILLISECONDS
            java.util.concurrent.ScheduledFuture r8 = r8.schedule(r9, r10, r0)
            r7.mStopTimeoutFuture = r8
            return
        Lb1:
            java.lang.AssertionError r7 = new java.lang.AssertionError
            java.lang.String r8 = "The start time should be before the stop time."
            r7.<init>(r8)
            throw r7
        Lb9:
            java.lang.AssertionError r7 = new java.lang.AssertionError
            java.lang.String r8 = "There should be a \"start\" before \"stop\""
            r7.<init>(r8)
            throw r7
        Lc1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.video.internal.encoder.EncoderImpl.l(androidx.camera.video.internal.encoder.EncoderImpl, long, long):void");
    }

    public static /* synthetic */ void m(EncoderImpl encoderImpl, long j6) {
        boolean z5;
        encoderImpl.getClass();
        switch (AnonymousClass2.$SwitchMap$androidx$camera$video$internal$encoder$EncoderImpl$InternalState[encoderImpl.mState.ordinal()]) {
            case 1:
                encoderImpl.mLastDataStopTimestamp = null;
                Logger.d(encoderImpl.mTag, "Start on " + DebugUtils.readableUs(j6));
                try {
                    if (encoderImpl.mIsFlushedAfterEndOfStream) {
                        encoderImpl.reset();
                    }
                    encoderImpl.mStartStopTimeRangeUs = Range.create(Long.valueOf(j6), Long.MAX_VALUE);
                    encoderImpl.mMediaCodec.start();
                    Encoder.EncoderInput encoderInput = encoderImpl.mEncoderInput;
                    if (encoderInput instanceof ByteBufferInput) {
                        ((ByteBufferInput) encoderInput).setActive(true);
                    }
                    encoderImpl.setState(InternalState.STARTED);
                    return;
                } catch (MediaCodec.CodecException e6) {
                    encoderImpl.handleEncodeError(e6);
                    return;
                }
            case 2:
            case 6:
            case 8:
                return;
            case 3:
                encoderImpl.mLastDataStopTimestamp = null;
                Range<Long> removeLast = encoderImpl.mActivePauseResumeTimeRanges.removeLast();
                if (removeLast != null && removeLast.getUpper().longValue() == Long.MAX_VALUE) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                Preconditions.checkState(z5, "There should be a \"pause\" before \"resume\"");
                Long lower = removeLast.getLower();
                long longValue = lower.longValue();
                encoderImpl.mActivePauseResumeTimeRanges.addLast(Range.create(lower, Long.valueOf(j6)));
                Logger.d(encoderImpl.mTag, "Resume on " + DebugUtils.readableUs(j6) + "\nPaused duration = " + DebugUtils.readableUs(j6 - longValue));
                if ((encoderImpl.mIsVideoEncoder || DeviceQuirks.get(AudioEncoderIgnoresInputTimestampQuirk.class) == null) && (!encoderImpl.mIsVideoEncoder || DeviceQuirks.get(VideoEncoderSuspendDoesNotIncludeSuspendTimeQuirk.class) == null)) {
                    encoderImpl.setMediaCodecPaused(false);
                    Encoder.EncoderInput encoderInput2 = encoderImpl.mEncoderInput;
                    if (encoderInput2 instanceof ByteBufferInput) {
                        ((ByteBufferInput) encoderInput2).setActive(true);
                    }
                }
                if (encoderImpl.mIsVideoEncoder) {
                    encoderImpl.requestKeyFrameToMediaCodec();
                }
                encoderImpl.setState(InternalState.STARTED);
                return;
            case 4:
            case 5:
                encoderImpl.setState(InternalState.PENDING_START);
                return;
            case 7:
            case 9:
                throw new IllegalStateException("Encoder is released");
            default:
                throw new IllegalStateException("Unknown state: " + encoderImpl.mState);
        }
    }

    public static /* synthetic */ Object n(AtomicReference atomicReference, CallbackToFutureAdapter.Completer completer) {
        atomicReference.set(completer);
        return "mReleasedFuture";
    }

    public static /* synthetic */ Object o(AtomicReference atomicReference, CallbackToFutureAdapter.Completer completer) {
        atomicReference.set(completer);
        return "acquireInputBuffer";
    }

    public static /* synthetic */ void p(EncoderImpl encoderImpl) {
        encoderImpl.getClass();
        switch (AnonymousClass2.$SwitchMap$androidx$camera$video$internal$encoder$EncoderImpl$InternalState[encoderImpl.mState.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 8:
                encoderImpl.releaseInternal();
                return;
            case 4:
            case 5:
            case 6:
                encoderImpl.setState(InternalState.PENDING_RELEASE);
                return;
            case 7:
            case 9:
                return;
            default:
                throw new IllegalStateException("Unknown state: " + encoderImpl.mState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void signalEndOfInputStream() {
        Futures.addCallback(acquireInputBuffer(), new FutureCallback<InputBuffer>() { // from class: androidx.camera.video.internal.encoder.EncoderImpl.1
            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onFailure(@NonNull Throwable th) {
                EncoderImpl.this.handleEncodeError(0, "Unable to acquire InputBuffer.", th);
            }

            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onSuccess(InputBuffer inputBuffer) {
                inputBuffer.setPresentationTimeUs(EncoderImpl.this.generatePresentationTimeUs());
                inputBuffer.setEndOfStream(true);
                inputBuffer.submit();
                Futures.addCallback(inputBuffer.getTerminationFuture(), new FutureCallback<Void>() { // from class: androidx.camera.video.internal.encoder.EncoderImpl.1.1
                    @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                    public void onSuccess(@Nullable Void r12) {
                    }

                    @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                    public void onFailure(@NonNull Throwable th) {
                        if (th instanceof MediaCodec.CodecException) {
                            EncoderImpl.this.handleEncodeError((MediaCodec.CodecException) th);
                        } else {
                            EncoderImpl.this.handleEncodeError(0, th.getMessage(), th);
                        }
                    }
                }, EncoderImpl.this.mEncoderExecutor);
            }
        }, this.mEncoderExecutor);
    }

    @Override // androidx.camera.video.internal.encoder.Encoder
    public void pause() {
        final long generatePresentationTimeUs = generatePresentationTimeUs();
        this.mEncoderExecutor.execute(new Runnable() { // from class: androidx.camera.video.internal.encoder.k
            @Override // java.lang.Runnable
            public final void run() {
                EncoderImpl.g(EncoderImpl.this, generatePresentationTimeUs);
            }
        });
    }

    @Override // androidx.camera.video.internal.encoder.Encoder
    public void start() {
        final long generatePresentationTimeUs = generatePresentationTimeUs();
        this.mEncoderExecutor.execute(new Runnable() { // from class: androidx.camera.video.internal.encoder.e
            @Override // java.lang.Runnable
            public final void run() {
                EncoderImpl.m(EncoderImpl.this, generatePresentationTimeUs);
            }
        });
    }
}
