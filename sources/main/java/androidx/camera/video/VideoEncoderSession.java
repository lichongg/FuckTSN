package androidx.camera.video;

import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.Logger;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.Timebase;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.video.internal.VideoValidatedEncoderProfilesProxy;
import androidx.camera.video.internal.config.VideoConfigUtil;
import androidx.camera.video.internal.encoder.Encoder;
import androidx.camera.video.internal.encoder.EncoderFactory;
import androidx.camera.video.internal.encoder.InvalidConfigException;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Consumer;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
final class VideoEncoderSession {
    private static final String TAG = "VideoEncoderSession";
    private final Executor mExecutor;
    private final Executor mSequentialExecutor;
    private final EncoderFactory mVideoEncoderFactory;
    private Encoder mVideoEncoder = null;
    private Surface mActiveSurface = null;
    private SurfaceRequest mSurfaceRequest = null;
    private Executor mOnSurfaceUpdateExecutor = null;
    private Encoder.SurfaceInput.OnSurfaceUpdateListener mOnSurfaceUpdateListener = null;
    private VideoEncoderState mVideoEncoderState = VideoEncoderState.NOT_INITIALIZED;
    private ListenableFuture<Void> mReleasedFuture = Futures.immediateFailedFuture(new IllegalStateException("Cannot close the encoder before configuring."));
    private CallbackToFutureAdapter.Completer<Void> mReleasedCompleter = null;
    private ListenableFuture<Encoder> mReadyToReleaseFuture = Futures.immediateFailedFuture(new IllegalStateException("Cannot close the encoder before configuring."));
    private CallbackToFutureAdapter.Completer<Encoder> mReadyToReleaseCompleter = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    enum VideoEncoderState {
        NOT_INITIALIZED,
        INITIALIZING,
        PENDING_RELEASE,
        READY,
        RELEASED
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: androidx.camera.video.VideoEncoderSession$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$androidx$camera$video$VideoEncoderSession$VideoEncoderState;

        static {
            int[] iArr = new int[VideoEncoderState.values().length];
            $SwitchMap$androidx$camera$video$VideoEncoderSession$VideoEncoderState = iArr;
            try {
                iArr[VideoEncoderState.NOT_INITIALIZED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$camera$video$VideoEncoderSession$VideoEncoderState[VideoEncoderState.INITIALIZING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$camera$video$VideoEncoderSession$VideoEncoderState[VideoEncoderState.READY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$camera$video$VideoEncoderSession$VideoEncoderState[VideoEncoderState.PENDING_RELEASE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$androidx$camera$video$VideoEncoderSession$VideoEncoderState[VideoEncoderState.RELEASED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private void closeInternal() {
        int i6 = AnonymousClass2.$SwitchMap$androidx$camera$video$VideoEncoderSession$VideoEncoderState[this.mVideoEncoderState.ordinal()];
        if (i6 == 1 || i6 == 2) {
            terminateNow();
            return;
        }
        if (i6 == 3 || i6 == 4) {
            Logger.d(TAG, "closeInternal in " + this.mVideoEncoderState + " state");
            this.mVideoEncoderState = VideoEncoderState.PENDING_RELEASE;
            return;
        }
        if (i6 == 5) {
            Logger.d(TAG, "closeInternal in RELEASED state, No-op");
            return;
        }
        throw new IllegalStateException("State " + this.mVideoEncoderState + " is not handled");
    }

    public static /* synthetic */ Object d(VideoEncoderSession videoEncoderSession, CallbackToFutureAdapter.Completer completer) {
        videoEncoderSession.mReleasedCompleter = completer;
        return "ReleasedFuture " + videoEncoderSession;
    }

    public static /* synthetic */ Object f(VideoEncoderSession videoEncoderSession, CallbackToFutureAdapter.Completer completer) {
        videoEncoderSession.mReadyToReleaseCompleter = completer;
        return "ReadyToReleaseFuture " + videoEncoderSession;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSurfaceRequestComplete(@NonNull SurfaceRequest.Result result) {
        Logger.d(TAG, "Surface can be closed: " + result.getSurface().hashCode());
        Surface surface = result.getSurface();
        if (surface != this.mActiveSurface) {
            surface.release();
            return;
        }
        this.mActiveSurface = null;
        this.mReadyToReleaseCompleter.set(this.mVideoEncoder);
        closeInternal();
    }

    @NonNull
    ListenableFuture<Encoder> configure(@NonNull final SurfaceRequest surfaceRequest, @NonNull final Timebase timebase, @NonNull final MediaSpec mediaSpec, @Nullable final VideoValidatedEncoderProfilesProxy videoValidatedEncoderProfilesProxy) {
        if (AnonymousClass2.$SwitchMap$androidx$camera$video$VideoEncoderSession$VideoEncoderState[this.mVideoEncoderState.ordinal()] != 1) {
            return Futures.immediateFailedFuture(new IllegalStateException("configure() shouldn't be called in " + this.mVideoEncoderState));
        }
        this.mVideoEncoderState = VideoEncoderState.INITIALIZING;
        this.mSurfaceRequest = surfaceRequest;
        Logger.d(TAG, "Create VideoEncoderSession: " + this);
        this.mReleasedFuture = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.video.t0
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return VideoEncoderSession.d(VideoEncoderSession.this, completer);
            }
        });
        this.mReadyToReleaseFuture = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.video.u0
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return VideoEncoderSession.f(VideoEncoderSession.this, completer);
            }
        });
        ListenableFuture future = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.video.v0
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return VideoEncoderSession.a(VideoEncoderSession.this, surfaceRequest, timebase, videoValidatedEncoderProfilesProxy, mediaSpec, completer);
            }
        });
        Futures.addCallback(future, new FutureCallback<Encoder>() { // from class: androidx.camera.video.VideoEncoderSession.1
            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onSuccess(@Nullable Encoder encoder) {
            }

            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onFailure(@NonNull Throwable th) {
                Logger.w(VideoEncoderSession.TAG, "VideoEncoder configuration failed.", th);
                VideoEncoderSession.this.terminateNow();
            }
        }, this.mSequentialExecutor);
        return Futures.nonCancellationPropagating(future);
    }

    @Nullable
    Surface getActiveSurface() {
        if (this.mVideoEncoderState != VideoEncoderState.READY) {
            return null;
        }
        return this.mActiveSurface;
    }

    @NonNull
    ListenableFuture<Encoder> getReadyToReleaseFuture() {
        return Futures.nonCancellationPropagating(this.mReadyToReleaseFuture);
    }

    @Nullable
    Encoder getVideoEncoder() {
        return this.mVideoEncoder;
    }

    boolean isConfiguredSurfaceRequest(@NonNull SurfaceRequest surfaceRequest) {
        int i6 = AnonymousClass2.$SwitchMap$androidx$camera$video$VideoEncoderSession$VideoEncoderState[this.mVideoEncoderState.ordinal()];
        if (i6 != 1) {
            if (i6 == 2 || i6 == 3) {
                if (this.mSurfaceRequest == surfaceRequest) {
                    return true;
                }
            } else if (i6 != 4 && i6 != 5) {
                throw new IllegalStateException("State " + this.mVideoEncoderState + " is not handled");
            }
        }
        return false;
    }

    void setOnSurfaceUpdateListener(@NonNull Executor executor, @NonNull Encoder.SurfaceInput.OnSurfaceUpdateListener onSurfaceUpdateListener) {
        this.mOnSurfaceUpdateExecutor = executor;
        this.mOnSurfaceUpdateListener = onSurfaceUpdateListener;
    }

    void terminateNow() {
        int i6 = AnonymousClass2.$SwitchMap$androidx$camera$video$VideoEncoderSession$VideoEncoderState[this.mVideoEncoderState.ordinal()];
        if (i6 == 1) {
            this.mVideoEncoderState = VideoEncoderState.RELEASED;
            return;
        }
        if (i6 != 2 && i6 != 3 && i6 != 4) {
            if (i6 != 5) {
                throw new IllegalStateException("State " + this.mVideoEncoderState + " is not handled");
            }
            Logger.d(TAG, "terminateNow in " + this.mVideoEncoderState + ", No-op");
            return;
        }
        this.mVideoEncoderState = VideoEncoderState.RELEASED;
        this.mReadyToReleaseCompleter.set(this.mVideoEncoder);
        this.mSurfaceRequest = null;
        if (this.mVideoEncoder == null) {
            Logger.w(TAG, "There's no VideoEncoder to release! Finish release completer.");
            this.mReleasedCompleter.set(null);
            return;
        }
        Logger.d(TAG, "VideoEncoder is releasing: " + this.mVideoEncoder);
        this.mVideoEncoder.release();
        this.mVideoEncoder.getReleasedFuture().addListener(new Runnable() { // from class: androidx.camera.video.s0
            @Override // java.lang.Runnable
            public final void run() {
                VideoEncoderSession.this.mReleasedCompleter.set(null);
            }
        }, this.mSequentialExecutor);
        this.mVideoEncoder = null;
    }

    @NonNull
    public String toString() {
        return "VideoEncoderSession@" + hashCode() + " for " + Objects.toString(this.mSurfaceRequest, "SURFACE_REQUEST_NOT_CONFIGURED");
    }

    VideoEncoderSession(@NonNull EncoderFactory encoderFactory, @NonNull Executor executor, @NonNull Executor executor2) {
        this.mExecutor = executor2;
        this.mSequentialExecutor = executor;
        this.mVideoEncoderFactory = encoderFactory;
    }

    public static /* synthetic */ Object a(VideoEncoderSession videoEncoderSession, SurfaceRequest surfaceRequest, Timebase timebase, VideoValidatedEncoderProfilesProxy videoValidatedEncoderProfilesProxy, MediaSpec mediaSpec, CallbackToFutureAdapter.Completer completer) {
        videoEncoderSession.configureVideoEncoderInternal(surfaceRequest, timebase, videoValidatedEncoderProfilesProxy, mediaSpec, completer);
        return "ConfigureVideoEncoderFuture " + videoEncoderSession;
    }

    private void configureVideoEncoderInternal(@NonNull final SurfaceRequest surfaceRequest, @NonNull Timebase timebase, @Nullable VideoValidatedEncoderProfilesProxy videoValidatedEncoderProfilesProxy, @NonNull MediaSpec mediaSpec, @NonNull final CallbackToFutureAdapter.Completer<Encoder> completer) {
        DynamicRange dynamicRange = surfaceRequest.getDynamicRange();
        try {
            Encoder createEncoder = this.mVideoEncoderFactory.createEncoder(this.mExecutor, VideoConfigUtil.resolveVideoEncoderConfig(VideoConfigUtil.resolveVideoMimeInfo(mediaSpec, dynamicRange, videoValidatedEncoderProfilesProxy), timebase, mediaSpec.getVideoSpec(), surfaceRequest.getResolution(), dynamicRange, surfaceRequest.getExpectedFrameRate()));
            this.mVideoEncoder = createEncoder;
            Encoder.EncoderInput input = createEncoder.getInput();
            if (!(input instanceof Encoder.SurfaceInput)) {
                completer.setException(new AssertionError("The EncoderInput of video isn't a SurfaceInput."));
            } else {
                ((Encoder.SurfaceInput) input).setOnSurfaceUpdateListener(this.mSequentialExecutor, new Encoder.SurfaceInput.OnSurfaceUpdateListener() { // from class: androidx.camera.video.r0
                    @Override // androidx.camera.video.internal.encoder.Encoder.SurfaceInput.OnSurfaceUpdateListener
                    public final void onSurfaceUpdate(Surface surface) {
                        VideoEncoderSession.g(VideoEncoderSession.this, completer, surfaceRequest, surface);
                    }
                });
            }
        } catch (InvalidConfigException e6) {
            Logger.e(TAG, "Unable to initialize video encoder.", e6);
            completer.setException(e6);
        }
    }

    public static /* synthetic */ void g(final VideoEncoderSession videoEncoderSession, CallbackToFutureAdapter.Completer completer, SurfaceRequest surfaceRequest, final Surface surface) {
        Executor executor;
        videoEncoderSession.getClass();
        int i6 = AnonymousClass2.$SwitchMap$androidx$camera$video$VideoEncoderSession$VideoEncoderState[videoEncoderSession.mVideoEncoderState.ordinal()];
        if (i6 != 1) {
            if (i6 != 2) {
                if (i6 != 3) {
                    if (i6 != 4 && i6 != 5) {
                        throw new IllegalStateException("State " + videoEncoderSession.mVideoEncoderState + " is not handled");
                    }
                } else {
                    if (videoEncoderSession.mOnSurfaceUpdateListener != null && (executor = videoEncoderSession.mOnSurfaceUpdateExecutor) != null) {
                        executor.execute(new Runnable() { // from class: androidx.camera.video.x0
                            @Override // java.lang.Runnable
                            public final void run() {
                                VideoEncoderSession.this.mOnSurfaceUpdateListener.onSurfaceUpdate(surface);
                            }
                        });
                    }
                    Logger.w(TAG, "Surface is updated in READY state: " + surface);
                    return;
                }
            } else {
                if (surfaceRequest.isServiced()) {
                    Logger.d(TAG, "Not provide surface, " + Objects.toString(surfaceRequest, "EMPTY") + " is already serviced.");
                    completer.set(null);
                    videoEncoderSession.closeInternal();
                    return;
                }
                videoEncoderSession.mActiveSurface = surface;
                Logger.d(TAG, "provide surface: " + surface);
                surfaceRequest.provideSurface(surface, videoEncoderSession.mSequentialExecutor, new Consumer() { // from class: androidx.camera.video.w0
                    @Override // androidx.core.util.Consumer
                    public final void accept(Object obj) {
                        VideoEncoderSession.this.onSurfaceRequestComplete((SurfaceRequest.Result) obj);
                    }
                });
                videoEncoderSession.mVideoEncoderState = VideoEncoderState.READY;
                completer.set(videoEncoderSession.mVideoEncoder);
                return;
            }
        }
        Logger.d(TAG, "Not provide surface in " + videoEncoderSession.mVideoEncoderState);
        completer.set(null);
    }

    @NonNull
    ListenableFuture<Void> signalTermination() {
        closeInternal();
        return Futures.nonCancellationPropagating(this.mReleasedFuture);
    }
}
