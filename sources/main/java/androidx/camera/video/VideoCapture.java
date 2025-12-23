package androidx.camera.video;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.media.MediaCodec;
import android.os.SystemClock;
import android.util.Pair;
import android.util.Range;
import android.util.Size;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.arch.core.util.Function;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.Logger;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ConfigProvider;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImageInputConfig;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.MutableConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.Observable;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.impl.Timebase;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.internal.TargetConfig;
import androidx.camera.core.internal.ThreadConfig;
import androidx.camera.core.internal.UseCaseEventConfig;
import androidx.camera.core.processing.DefaultSurfaceProcessor;
import androidx.camera.core.processing.SurfaceEdge;
import androidx.camera.core.processing.SurfaceProcessorInternal;
import androidx.camera.core.processing.SurfaceProcessorNode;
import androidx.camera.core.resolutionselector.ResolutionSelector;
import androidx.camera.video.StreamInfo;
import androidx.camera.video.VideoCapture;
import androidx.camera.video.VideoOutput;
import androidx.camera.video.impl.VideoCaptureConfig;
import androidx.camera.video.internal.VideoValidatedEncoderProfilesProxy;
import androidx.camera.video.internal.compat.quirk.DeviceQuirks;
import androidx.camera.video.internal.compat.quirk.ExtraSupportedResolutionQuirk;
import androidx.camera.video.internal.compat.quirk.ImageCaptureFailedWhenVideoCaptureIsBoundQuirk;
import androidx.camera.video.internal.compat.quirk.PreviewDelayWhenVideoCaptureIsBoundQuirk;
import androidx.camera.video.internal.compat.quirk.PreviewStretchWhenVideoCaptureIsBoundQuirk;
import androidx.camera.video.internal.compat.quirk.VideoQualityQuirk;
import androidx.camera.video.internal.config.VideoConfigUtil;
import androidx.camera.video.internal.encoder.InvalidConfigException;
import androidx.camera.video.internal.encoder.VideoEncoderConfig;
import androidx.camera.video.internal.encoder.VideoEncoderInfo;
import androidx.camera.video.internal.encoder.VideoEncoderInfoImpl;
import androidx.camera.video.internal.workaround.VideoEncoderInfoWrapper;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public final class VideoCapture<T extends VideoOutput> extends UseCase {
    private static final Defaults DEFAULT_CONFIG = new Defaults();
    private static final String SURFACE_UPDATE_KEY = "androidx.camera.video.VideoCapture.streamUpdate";
    private static final String TAG = "VideoCapture";
    private static final boolean USE_TEMPLATE_PREVIEW_BY_QUIRK;

    @VisibleForTesting
    static boolean sEnableSurfaceProcessingByQuirk;

    @Nullable
    private SurfaceEdge mCameraEdge;

    @Nullable
    private Rect mCropRect;
    DeferrableSurface mDeferrableSurface;
    private boolean mHasCompensatingTransformation;

    @Nullable
    private SurfaceProcessorNode mNode;
    private int mRotationDegrees;

    @NonNull
    SessionConfig.Builder mSessionConfigBuilder;
    VideoOutput.SourceState mSourceState;
    StreamInfo mStreamInfo;
    private final Observable.Observer<StreamInfo> mStreamInfoObserver;
    private SurfaceRequest mSurfaceRequest;
    ListenableFuture<Void> mSurfaceUpdateFuture;

    @Nullable
    private VideoEncoderInfo mVideoEncoderInfo;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: androidx.camera.video.VideoCapture$2, reason: invalid class name */
    class AnonymousClass2 extends CameraCaptureCallback {
        private boolean mIsFirstCaptureResult = true;
        final /* synthetic */ CallbackToFutureAdapter.Completer val$completer;
        final /* synthetic */ SessionConfig.Builder val$sessionConfigBuilder;
        final /* synthetic */ AtomicBoolean val$surfaceUpdateComplete;

        AnonymousClass2(AtomicBoolean atomicBoolean, CallbackToFutureAdapter.Completer completer, SessionConfig.Builder builder) {
            this.val$surfaceUpdateComplete = atomicBoolean;
            this.val$completer = completer;
            this.val$sessionConfigBuilder = builder;
        }

        public static /* synthetic */ void a(AnonymousClass2 anonymousClass2, SessionConfig.Builder builder) {
            anonymousClass2.getClass();
            builder.removeCameraCaptureCallback(anonymousClass2);
        }

        @Override // androidx.camera.core.impl.CameraCaptureCallback
        public void onCaptureCompleted(@NonNull CameraCaptureResult cameraCaptureResult) {
            Object tag;
            super.onCaptureCompleted(cameraCaptureResult);
            if (this.mIsFirstCaptureResult) {
                this.mIsFirstCaptureResult = false;
                Logger.d(VideoCapture.TAG, "cameraCaptureResult timestampNs = " + cameraCaptureResult.getTimestamp() + ", current system uptimeMs = " + SystemClock.uptimeMillis() + ", current system realtimeMs = " + SystemClock.elapsedRealtime());
            }
            if (!this.val$surfaceUpdateComplete.get() && (tag = cameraCaptureResult.getTagBundle().getTag(VideoCapture.SURFACE_UPDATE_KEY)) != null && ((Integer) tag).intValue() == this.val$completer.hashCode() && this.val$completer.set(null) && !this.val$surfaceUpdateComplete.getAndSet(true)) {
                ScheduledExecutorService mainThreadExecutor = CameraXExecutors.mainThreadExecutor();
                final SessionConfig.Builder builder = this.val$sessionConfigBuilder;
                mainThreadExecutor.execute(new Runnable() { // from class: androidx.camera.video.o0
                    @Override // java.lang.Runnable
                    public final void run() {
                        VideoCapture.AnonymousClass2.a(VideoCapture.AnonymousClass2.this, builder);
                    }
                });
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(21)
    public static final class Builder<T extends VideoOutput> implements UseCaseConfig.Builder<VideoCapture<T>, VideoCaptureConfig<T>, Builder<T>>, ImageOutputConfig.Builder<Builder<T>>, ImageInputConfig.Builder<Builder<T>>, ThreadConfig.Builder<Builder<T>> {
        private final MutableOptionsBundle mMutableConfig;

        public Builder(@NonNull T t5) {
            this(createInitialBundle(t5));
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        static Builder<? extends VideoOutput> fromConfig(@NonNull Config config) {
            return new Builder<>(MutableOptionsBundle.from(config));
        }

        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public /* bridge */ /* synthetic */ Object setCustomOrderedResolutions(@NonNull List list) {
            return setCustomOrderedResolutions((List<Size>) list);
        }

        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public /* bridge */ /* synthetic */ Object setSupportedResolutions(@NonNull List list) {
            return setSupportedResolutions((List<Pair<Integer, Size[]>>) list);
        }

        private Builder(@NonNull MutableOptionsBundle mutableOptionsBundle) {
            this.mMutableConfig = mutableOptionsBundle;
            if (!mutableOptionsBundle.containsOption(VideoCaptureConfig.OPTION_VIDEO_OUTPUT)) {
                throw new IllegalArgumentException("VideoOutput is required");
            }
            Class cls = (Class) mutableOptionsBundle.retrieveOption(TargetConfig.OPTION_TARGET_CLASS, null);
            if (cls == null || cls.equals(VideoCapture.class)) {
                setTargetClass((Class) VideoCapture.class);
                return;
            }
            throw new IllegalArgumentException("Invalid target class configuration for " + this + ": " + cls);
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static <T extends VideoOutput> Builder<T> fromConfig(@NonNull VideoCaptureConfig<T> videoCaptureConfig) {
            return new Builder<>(MutableOptionsBundle.from((Config) videoCaptureConfig));
        }

        @Override // androidx.camera.core.ExtendableBuilder
        @NonNull
        public VideoCapture<T> build() {
            return new VideoCapture<>(getUseCaseConfig());
        }

        @Override // androidx.camera.core.ExtendableBuilder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public MutableConfig getMutableConfig() {
            return this.mMutableConfig;
        }

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public VideoCaptureConfig<T> getUseCaseConfig() {
            return new VideoCaptureConfig<>(OptionsBundle.from(this.mMutableConfig));
        }

        @Override // androidx.camera.core.internal.ThreadConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder<T> setBackgroundExecutor(@NonNull Executor executor) {
            getMutableConfig().insertOption(ThreadConfig.OPTION_BACKGROUND_EXECUTOR, executor);
            return this;
        }

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder<T> setCameraSelector(@NonNull CameraSelector cameraSelector) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_CAMERA_SELECTOR, cameraSelector);
            return this;
        }

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder<T> setCaptureOptionUnpacker(@NonNull CaptureConfig.OptionUnpacker optionUnpacker) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_CAPTURE_CONFIG_UNPACKER, optionUnpacker);
            return this;
        }

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder<T> setCaptureType(@NonNull UseCaseConfigFactory.CaptureType captureType) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_CAPTURE_TYPE, captureType);
            return this;
        }

        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder<T> setCustomOrderedResolutions(@NonNull List<Size> list) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_CUSTOM_ORDERED_RESOLUTIONS, list);
            return this;
        }

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder<T> setDefaultCaptureConfig(@NonNull CaptureConfig captureConfig) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_DEFAULT_CAPTURE_CONFIG, captureConfig);
            return this;
        }

        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder<T> setDefaultResolution(@NonNull Size size) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_DEFAULT_RESOLUTION, size);
            return this;
        }

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder<T> setDefaultSessionConfig(@NonNull SessionConfig sessionConfig) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_DEFAULT_SESSION_CONFIG, sessionConfig);
            return this;
        }

        @Override // androidx.camera.core.impl.ImageInputConfig.Builder
        @NonNull
        public Builder<T> setDynamicRange(@NonNull DynamicRange dynamicRange) {
            getMutableConfig().insertOption(ImageInputConfig.OPTION_INPUT_DYNAMIC_RANGE, dynamicRange);
            return this;
        }

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder<T> setHighResolutionDisabled(boolean z5) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_HIGH_RESOLUTION_DISABLED, Boolean.valueOf(z5));
            return this;
        }

        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder<T> setMaxResolution(@NonNull Size size) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_MAX_RESOLUTION, size);
            return this;
        }

        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        @NonNull
        public Builder<T> setMirrorMode(int i6) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_MIRROR_MODE, Integer.valueOf(i6));
            return this;
        }

        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder<T> setResolutionSelector(@NonNull ResolutionSelector resolutionSelector) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_RESOLUTION_SELECTOR, resolutionSelector);
            return this;
        }

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder<T> setSessionOptionUnpacker(@NonNull SessionConfig.OptionUnpacker optionUnpacker) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_SESSION_CONFIG_UNPACKER, optionUnpacker);
            return this;
        }

        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder<T> setSupportedResolutions(@NonNull List<Pair<Integer, Size[]>> list) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_SUPPORTED_RESOLUTIONS, list);
            return this;
        }

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder<T> setSurfaceOccupancyPriority(int i6) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_SURFACE_OCCUPANCY_PRIORITY, Integer.valueOf(i6));
            return this;
        }

        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder<T> setTargetAspectRatio(int i6) {
            throw new UnsupportedOperationException("setTargetAspectRatio is not supported.");
        }

        @Override // androidx.camera.core.internal.TargetConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder<T> setTargetClass(@NonNull Class<VideoCapture<T>> cls) {
            getMutableConfig().insertOption(TargetConfig.OPTION_TARGET_CLASS, cls);
            if (getMutableConfig().retrieveOption(TargetConfig.OPTION_TARGET_NAME, null) == null) {
                setTargetName(cls.getCanonicalName() + "-" + UUID.randomUUID());
            }
            return this;
        }

        @Override // androidx.camera.core.internal.TargetConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder<T> setTargetName(@NonNull String str) {
            getMutableConfig().insertOption(TargetConfig.OPTION_TARGET_NAME, str);
            return this;
        }

        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder<T> setTargetResolution(@NonNull Size size) {
            throw new UnsupportedOperationException("setTargetResolution is not supported.");
        }

        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        @NonNull
        public Builder<T> setTargetRotation(int i6) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_TARGET_ROTATION, Integer.valueOf(i6));
            return this;
        }

        @Override // androidx.camera.core.internal.UseCaseEventConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder<T> setUseCaseEventCallback(@NonNull UseCase.EventCallback eventCallback) {
            getMutableConfig().insertOption(UseCaseEventConfig.OPTION_USE_CASE_EVENT_CALLBACK, eventCallback);
            return this;
        }

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder<T> setZslDisabled(boolean z5) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_ZSL_DISABLED, Boolean.valueOf(z5));
            return this;
        }

        @NonNull
        private static <T extends VideoOutput> MutableOptionsBundle createInitialBundle(@NonNull T t5) {
            MutableOptionsBundle create = MutableOptionsBundle.create();
            create.insertOption(VideoCaptureConfig.OPTION_VIDEO_OUTPUT, t5);
            return create;
        }

        @NonNull
        public Builder<T> setTargetFrameRate(@NonNull Range<Integer> range) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_TARGET_FRAME_RATE, range);
            return this;
        }

        @NonNull
        Builder<T> setVideoEncoderInfoFinder(@NonNull Function<VideoEncoderConfig, VideoEncoderInfo> function) {
            getMutableConfig().insertOption(VideoCaptureConfig.OPTION_VIDEO_ENCODER_INFO_FINDER, function);
            return this;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final class Defaults implements ConfigProvider<VideoCaptureConfig<?>> {
        private static final VideoCaptureConfig<?> DEFAULT_CONFIG;
        static final DynamicRange DEFAULT_DYNAMIC_RANGE;
        static final Range<Integer> DEFAULT_FPS_RANGE;
        private static final int DEFAULT_SURFACE_OCCUPANCY_PRIORITY = 5;
        private static final Function<VideoEncoderConfig, VideoEncoderInfo> DEFAULT_VIDEO_ENCODER_INFO_FINDER;
        private static final VideoOutput DEFAULT_VIDEO_OUTPUT;

        static {
            VideoOutput videoOutput = new VideoOutput() { // from class: androidx.camera.video.q0
                @Override // androidx.camera.video.VideoOutput
                public final void onSurfaceRequested(SurfaceRequest surfaceRequest) {
                    surfaceRequest.willNotProvideSurface();
                }

                @Override // androidx.camera.video.VideoOutput
                public /* synthetic */ void onSurfaceRequested(SurfaceRequest surfaceRequest, Timebase timebase) {
                    y0.e(this, surfaceRequest, timebase);
                }

                @Override // androidx.camera.video.VideoOutput
                public /* synthetic */ VideoCapabilities getMediaCapabilities(CameraInfo cameraInfo) {
                    return y0.a(this, cameraInfo);
                }

                @Override // androidx.camera.video.VideoOutput
                public /* synthetic */ Observable getMediaSpec() {
                    return y0.b(this);
                }

                @Override // androidx.camera.video.VideoOutput
                public /* synthetic */ Observable getStreamInfo() {
                    return y0.c(this);
                }

                @Override // androidx.camera.video.VideoOutput
                public /* synthetic */ void onSourceStateChanged(VideoOutput.SourceState sourceState) {
                    y0.d(this, sourceState);
                }
            };
            DEFAULT_VIDEO_OUTPUT = videoOutput;
            Function<VideoEncoderConfig, VideoEncoderInfo> createFinder = createFinder();
            DEFAULT_VIDEO_ENCODER_INFO_FINDER = createFinder;
            DEFAULT_FPS_RANGE = new Range<>(30, 30);
            DynamicRange dynamicRange = DynamicRange.SDR;
            DEFAULT_DYNAMIC_RANGE = dynamicRange;
            DEFAULT_CONFIG = new Builder(videoOutput).setSurfaceOccupancyPriority(5).setVideoEncoderInfoFinder(createFinder).setDynamicRange(dynamicRange).setCaptureType(UseCaseConfigFactory.CaptureType.VIDEO_CAPTURE).getUseCaseConfig();
        }

        @NonNull
        private static Function<VideoEncoderConfig, VideoEncoderInfo> createFinder() {
            return new Function() { // from class: androidx.camera.video.p0
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return VideoCapture.Defaults.a((VideoEncoderConfig) obj);
                }
            };
        }

        @Override // androidx.camera.core.impl.ConfigProvider
        @NonNull
        public VideoCaptureConfig<?> getConfig() {
            return DEFAULT_CONFIG;
        }

        public static /* synthetic */ VideoEncoderInfo a(VideoEncoderConfig videoEncoderConfig) {
            try {
                return VideoEncoderInfoImpl.from(videoEncoderConfig);
            } catch (InvalidConfigException e6) {
                Logger.w(VideoCapture.TAG, "Unable to find VideoEncoderInfo", e6);
                return null;
            }
        }
    }

    private static int alignDown(int i6, int i7, @NonNull Range<Integer> range) {
        return align(true, i6, i7, range);
    }

    private static int alignUp(int i6, int i7, @NonNull Range<Integer> range) {
        return align(false, i6, i7, range);
    }

    static {
        boolean z5 = DeviceQuirks.get(PreviewStretchWhenVideoCaptureIsBoundQuirk.class) != null;
        boolean z6 = DeviceQuirks.get(PreviewDelayWhenVideoCaptureIsBoundQuirk.class) != null;
        boolean z7 = DeviceQuirks.get(ImageCaptureFailedWhenVideoCaptureIsBoundQuirk.class) != null;
        boolean hasVideoQualityQuirkAndWorkaroundBySurfaceProcessing = hasVideoQualityQuirkAndWorkaroundBySurfaceProcessing();
        boolean z8 = DeviceQuirks.get(ExtraSupportedResolutionQuirk.class) != null;
        USE_TEMPLATE_PREVIEW_BY_QUIRK = z5 || z6 || z7;
        sEnableSurfaceProcessingByQuirk = z6 || z7 || hasVideoQualityQuirkAndWorkaroundBySurfaceProcessing || z8;
    }

    private static void addBySupportedSize(@NonNull Set<Size> set, int i6, int i7, @NonNull Size size, @NonNull VideoEncoderInfo videoEncoderInfo) {
        if (i6 > size.getWidth() || i7 > size.getHeight()) {
            return;
        }
        try {
            set.add(new Size(i6, videoEncoderInfo.getSupportedHeightsFor(i6).clamp(Integer.valueOf(i7)).intValue()));
        } catch (IllegalArgumentException e6) {
            Logger.w(TAG, "No supportedHeights for width: " + i6, e6);
        }
        try {
            set.add(new Size(videoEncoderInfo.getSupportedWidthsFor(i7).clamp(Integer.valueOf(i6)).intValue(), i7));
        } catch (IllegalArgumentException e7) {
            Logger.w(TAG, "No supportedWidths for height: " + i7, e7);
        }
    }

    private static int align(boolean z5, int i6, int i7, @NonNull Range<Integer> range) {
        int i8 = i6 % i7;
        if (i8 != 0) {
            i6 = z5 ? i6 - i8 : i6 + (i7 - i8);
        }
        return range.clamp(Integer.valueOf(i6)).intValue();
    }

    public static /* synthetic */ void c(VideoCapture videoCapture, DeferrableSurface deferrableSurface) {
        if (deferrableSurface == videoCapture.mDeferrableSurface) {
            videoCapture.clearPipeline();
        }
    }

    @NonNull
    @SuppressLint({"WrongConstant"})
    @MainThread
    private SessionConfig.Builder createPipeline(@NonNull final String str, @NonNull VideoCaptureConfig<T> videoCaptureConfig, @NonNull final StreamSpec streamSpec) {
        final VideoCaptureConfig<T> videoCaptureConfig2;
        final VideoCapture<T> videoCapture = this;
        Threads.checkMainThread();
        final CameraInternal cameraInternal = (CameraInternal) Preconditions.checkNotNull(videoCapture.getCamera());
        Size resolution = streamSpec.getResolution();
        Runnable runnable = new Runnable() { // from class: androidx.camera.video.k0
            @Override // java.lang.Runnable
            public final void run() {
                VideoCapture.this.notifyReset();
            }
        };
        Range<Integer> expectedFrameRateRange = streamSpec.getExpectedFrameRateRange();
        if (Objects.equals(expectedFrameRateRange, StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED)) {
            expectedFrameRateRange = Defaults.DEFAULT_FPS_RANGE;
        }
        Range<Integer> range = expectedFrameRateRange;
        MediaSpec mediaSpec = videoCapture.getMediaSpec();
        Objects.requireNonNull(mediaSpec);
        VideoCapabilities videoCapabilities = videoCapture.getVideoCapabilities(cameraInternal.getCameraInfo());
        DynamicRange dynamicRange = streamSpec.getDynamicRange();
        VideoEncoderInfo videoEncoderInfo = videoCapture.getVideoEncoderInfo(videoCaptureConfig.getVideoEncoderInfoFinder(), videoCapabilities, dynamicRange, mediaSpec, resolution, range);
        videoCapture.mRotationDegrees = videoCapture.adjustRotationWithInProgressTransformation(videoCapture.getRelativeRotation(cameraInternal, videoCapture.isMirroringRequired(cameraInternal)));
        Rect calculateCropRect = videoCapture.calculateCropRect(resolution, videoEncoderInfo);
        Rect adjustCropRectWithInProgressTransformation = videoCapture.adjustCropRectWithInProgressTransformation(calculateCropRect, videoCapture.mRotationDegrees);
        videoCapture.mCropRect = adjustCropRectWithInProgressTransformation;
        Size adjustResolutionWithInProgressTransformation = videoCapture.adjustResolutionWithInProgressTransformation(resolution, calculateCropRect, adjustCropRectWithInProgressTransformation);
        if (videoCapture.shouldCompensateTransformation()) {
            videoCapture.mHasCompensatingTransformation = true;
        }
        SurfaceProcessorNode createNodeIfNeeded = videoCapture.createNodeIfNeeded(cameraInternal, videoCapture.mCropRect, resolution, dynamicRange);
        videoCapture.mNode = createNodeIfNeeded;
        final Timebase timebase = (createNodeIfNeeded == null && cameraInternal.getHasTransform()) ? Timebase.UPTIME : cameraInternal.getCameraInfoInternal().getTimebase();
        Logger.d(TAG, "camera timebase = " + cameraInternal.getCameraInfoInternal().getTimebase() + ", processing timebase = " + timebase);
        StreamSpec build = streamSpec.toBuilder().setResolution(adjustResolutionWithInProgressTransformation).setExpectedFrameRateRange(range).build();
        Preconditions.checkState(videoCapture.mCameraEdge == null);
        SurfaceEdge surfaceEdge = new SurfaceEdge(2, 34, build, videoCapture.getSensorToBufferTransformMatrix(), cameraInternal.getHasTransform(), videoCapture.mCropRect, videoCapture.mRotationDegrees, videoCapture.getAppTargetRotation(), videoCapture.shouldMirror(cameraInternal));
        videoCapture.mCameraEdge = surfaceEdge;
        surfaceEdge.addOnInvalidatedListener(runnable);
        if (videoCapture.mNode != null) {
            SurfaceProcessorNode.OutConfig of = SurfaceProcessorNode.OutConfig.of(videoCapture.mCameraEdge);
            final SurfaceEdge surfaceEdge2 = videoCapture.mNode.transform(SurfaceProcessorNode.In.of(videoCapture.mCameraEdge, Collections.singletonList(of))).get(of);
            Objects.requireNonNull(surfaceEdge2);
            videoCaptureConfig2 = videoCaptureConfig;
            videoCapture = this;
            surfaceEdge2.addOnInvalidatedListener(new Runnable() { // from class: androidx.camera.video.l0
                @Override // java.lang.Runnable
                public final void run() {
                    VideoCapture.this.onAppEdgeInvalidated(surfaceEdge2, cameraInternal, videoCaptureConfig2, timebase);
                }
            });
            videoCapture.mSurfaceRequest = surfaceEdge2.createSurfaceRequest(cameraInternal);
            final DeferrableSurface deferrableSurface = videoCapture.mCameraEdge.getDeferrableSurface();
            videoCapture.mDeferrableSurface = deferrableSurface;
            deferrableSurface.getTerminationFuture().addListener(new Runnable() { // from class: androidx.camera.video.m0
                @Override // java.lang.Runnable
                public final void run() {
                    VideoCapture.c(VideoCapture.this, deferrableSurface);
                }
            }, CameraXExecutors.mainThreadExecutor());
        } else {
            videoCaptureConfig2 = videoCaptureConfig;
            SurfaceRequest createSurfaceRequest = videoCapture.mCameraEdge.createSurfaceRequest(cameraInternal);
            videoCapture.mSurfaceRequest = createSurfaceRequest;
            videoCapture.mDeferrableSurface = createSurfaceRequest.getDeferrableSurface();
        }
        videoCaptureConfig2.getVideoOutput().onSurfaceRequested(videoCapture.mSurfaceRequest, timebase);
        videoCapture.sendTransformationInfoIfReady();
        videoCapture.mDeferrableSurface.setContainerClass(MediaCodec.class);
        SessionConfig.Builder createFrom = SessionConfig.Builder.createFrom(videoCaptureConfig2, streamSpec.getResolution());
        createFrom.setExpectedFrameRateRange(streamSpec.getExpectedFrameRateRange());
        createFrom.addErrorListener(new SessionConfig.ErrorListener() { // from class: androidx.camera.video.n0
            @Override // androidx.camera.core.impl.SessionConfig.ErrorListener
            public final void onError(SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
                VideoCapture.this.resetPipeline(str, videoCaptureConfig2, streamSpec);
            }
        });
        if (USE_TEMPLATE_PREVIEW_BY_QUIRK) {
            createFrom.setTemplateType(1);
        }
        if (streamSpec.getImplementationOptions() != null) {
            createFrom.addImplementationOptions(streamSpec.getImplementationOptions());
        }
        return createFrom;
    }

    @Nullable
    @MainThread
    private VideoEncoderInfo getVideoEncoderInfo(@NonNull Function<VideoEncoderConfig, VideoEncoderInfo> function, @NonNull VideoCapabilities videoCapabilities, @NonNull DynamicRange dynamicRange, @NonNull MediaSpec mediaSpec, @NonNull Size size, @NonNull Range<Integer> range) {
        VideoEncoderInfo videoEncoderInfo = this.mVideoEncoderInfo;
        if (videoEncoderInfo != null) {
            return videoEncoderInfo;
        }
        VideoValidatedEncoderProfilesProxy findHighestSupportedEncoderProfilesFor = videoCapabilities.findHighestSupportedEncoderProfilesFor(size, dynamicRange);
        VideoEncoderInfo resolveVideoEncoderInfo = resolveVideoEncoderInfo(function, findHighestSupportedEncoderProfilesFor, mediaSpec, size, dynamicRange, range);
        if (resolveVideoEncoderInfo == null) {
            Logger.w(TAG, "Can't find videoEncoderInfo");
            return null;
        }
        VideoEncoderInfo from = VideoEncoderInfoWrapper.from(resolveVideoEncoderInfo, findHighestSupportedEncoderProfilesFor != null ? new Size(findHighestSupportedEncoderProfilesFor.getDefaultVideoProfile().getWidth(), findHighestSupportedEncoderProfilesFor.getDefaultVideoProfile().getHeight()) : null);
        this.mVideoEncoderInfo = from;
        return from;
    }

    private static boolean hasVideoQualityQuirkAndWorkaroundBySurfaceProcessing() {
        Iterator it = DeviceQuirks.getAll(VideoQualityQuirk.class).iterator();
        while (it.hasNext()) {
            if (((VideoQualityQuirk) it.next()).workaroundBySurfaceProcessing()) {
                return true;
            }
        }
        return false;
    }

    @MainThread
    private void setupSurfaceUpdateNotifier(@NonNull final SessionConfig.Builder builder, final boolean z5) {
        ListenableFuture<Void> listenableFuture = this.mSurfaceUpdateFuture;
        if (listenableFuture != null && listenableFuture.cancel(false)) {
            Logger.d(TAG, "A newer surface update is requested. Previous surface update cancelled.");
        }
        final ListenableFuture<Void> future = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.video.j0
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return VideoCapture.f(VideoCapture.this, builder, completer);
            }
        });
        this.mSurfaceUpdateFuture = future;
        Futures.addCallback(future, new FutureCallback<Void>() { // from class: androidx.camera.video.VideoCapture.3
            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onFailure(@NonNull Throwable th) {
                if (th instanceof CancellationException) {
                    return;
                }
                Logger.e(VideoCapture.TAG, "Surface update completed with unexpected exception", th);
            }

            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onSuccess(@Nullable Void r32) {
                ListenableFuture<Void> listenableFuture2 = future;
                VideoCapture videoCapture = VideoCapture.this;
                if (listenableFuture2 != videoCapture.mSurfaceUpdateFuture || videoCapture.mSourceState == VideoOutput.SourceState.INACTIVE) {
                    return;
                }
                videoCapture.setSourceState(z5 ? VideoOutput.SourceState.ACTIVE_STREAMING : VideoOutput.SourceState.ACTIVE_NON_STREAMING);
            }
        }, CameraXExecutors.mainThreadExecutor());
    }

    private boolean shouldCompensateTransformation() {
        return this.mStreamInfo.getInProgressTransformationInfo() != null;
    }

    @NonNull
    public static <T extends VideoOutput> VideoCapture<T> withOutput(@NonNull T t5) {
        return new Builder((VideoOutput) Preconditions.checkNotNull(t5)).setCaptureType(UseCaseConfigFactory.CaptureType.VIDEO_CAPTURE).build();
    }

    @Nullable
    @VisibleForTesting
    SurfaceEdge getCameraEdge() {
        return this.mCameraEdge;
    }

    @Nullable
    @VisibleForTesting
    Rect getCropRect() {
        return this.mCropRect;
    }

    /* JADX WARN: Type inference failed for: r4v2, types: [androidx.camera.core.impl.UseCaseConfig, androidx.camera.core.impl.UseCaseConfig<?>] */
    @Override // androidx.camera.core.UseCase
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public UseCaseConfig<?> getDefaultConfig(boolean z5, @NonNull UseCaseConfigFactory useCaseConfigFactory) {
        Defaults defaults = DEFAULT_CONFIG;
        Config config = useCaseConfigFactory.getConfig(defaults.getConfig().getCaptureType(), 1);
        if (z5) {
            config = androidx.camera.core.impl.o.b(config, defaults.getConfig());
        }
        if (config == null) {
            return null;
        }
        return getUseCaseConfigBuilder(config).getUseCaseConfig();
    }

    @Nullable
    @VisibleForTesting
    SurfaceProcessorNode getNode() {
        return this.mNode;
    }

    @VisibleForTesting
    int getRotationDegrees() {
        return this.mRotationDegrees;
    }

    @Override // androidx.camera.core.UseCase
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Set<Integer> getSupportedEffectTargets() {
        HashSet hashSet = new HashSet();
        hashSet.add(2);
        return hashSet;
    }

    @NonNull
    @VisibleForTesting
    SurfaceRequest getSurfaceRequest() {
        SurfaceRequest surfaceRequest = this.mSurfaceRequest;
        Objects.requireNonNull(surfaceRequest);
        return surfaceRequest;
    }

    boolean isStreamIdChanged(int i6, int i7) {
        Set<Integer> set = StreamInfo.NON_SURFACE_STREAM_ID;
        return (set.contains(Integer.valueOf(i6)) || set.contains(Integer.valueOf(i7)) || i6 == i7) ? false : true;
    }

    @Override // androidx.camera.core.UseCase
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected StreamSpec onSuggestedStreamSpecImplementationOptionsUpdated(@NonNull Config config) {
        this.mSessionConfigBuilder.addImplementationOptions(config);
        updateSessionConfig(this.mSessionConfigBuilder.build());
        return getAttachedStreamSpec().toBuilder().setImplementationOptions(config).build();
    }

    @Override // androidx.camera.core.UseCase
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected StreamSpec onSuggestedStreamSpecUpdated(@NonNull StreamSpec streamSpec) {
        Logger.d(TAG, "onSuggestedStreamSpecUpdated: " + streamSpec);
        List customOrderedResolutions = ((VideoCaptureConfig) getCurrentConfig()).getCustomOrderedResolutions(null);
        if (customOrderedResolutions != null && !customOrderedResolutions.contains(streamSpec.getResolution())) {
            Logger.w(TAG, "suggested resolution " + streamSpec.getResolution() + " is not in custom ordered resolutions " + customOrderedResolutions);
        }
        return streamSpec;
    }

    @MainThread
    void setSourceState(@NonNull VideoOutput.SourceState sourceState) {
        if (sourceState != this.mSourceState) {
            this.mSourceState = sourceState;
            getOutput().onSourceStateChanged(sourceState);
        }
    }

    boolean shouldResetCompensatingTransformation(@NonNull StreamInfo streamInfo, @NonNull StreamInfo streamInfo2) {
        return this.mHasCompensatingTransformation && streamInfo.getInProgressTransformationInfo() != null && streamInfo2.getInProgressTransformationInfo() == null;
    }

    @NonNull
    public String toString() {
        return "VideoCapture:" + getName();
    }

    VideoCapture(@NonNull VideoCaptureConfig<T> videoCaptureConfig) {
        super(videoCaptureConfig);
        this.mStreamInfo = StreamInfo.STREAM_INFO_ANY_INACTIVE;
        this.mSessionConfigBuilder = new SessionConfig.Builder();
        this.mSurfaceUpdateFuture = null;
        this.mSourceState = VideoOutput.SourceState.INACTIVE;
        this.mHasCompensatingTransformation = false;
        this.mStreamInfoObserver = new Observable.Observer<StreamInfo>() { // from class: androidx.camera.video.VideoCapture.1
            @Override // androidx.camera.core.impl.Observable.Observer
            public void onError(@NonNull Throwable th) {
                Logger.w(VideoCapture.TAG, "Receive onError from StreamState observer", th);
            }

            @Override // androidx.camera.core.impl.Observable.Observer
            public void onNewData(@Nullable StreamInfo streamInfo) {
                if (streamInfo == null) {
                    throw new IllegalArgumentException("StreamInfo can't be null");
                }
                if (VideoCapture.this.mSourceState == VideoOutput.SourceState.INACTIVE) {
                    return;
                }
                Logger.d(VideoCapture.TAG, "Stream info update: old: " + VideoCapture.this.mStreamInfo + " new: " + streamInfo);
                VideoCapture videoCapture = VideoCapture.this;
                StreamInfo streamInfo2 = videoCapture.mStreamInfo;
                videoCapture.mStreamInfo = streamInfo;
                StreamSpec streamSpec = (StreamSpec) Preconditions.checkNotNull(videoCapture.getAttachedStreamSpec());
                if (VideoCapture.this.isStreamIdChanged(streamInfo2.getId(), streamInfo.getId()) || VideoCapture.this.shouldResetCompensatingTransformation(streamInfo2, streamInfo)) {
                    VideoCapture videoCapture2 = VideoCapture.this;
                    videoCapture2.resetPipeline(videoCapture2.getCameraId(), (VideoCaptureConfig) VideoCapture.this.getCurrentConfig(), (StreamSpec) Preconditions.checkNotNull(VideoCapture.this.getAttachedStreamSpec()));
                    return;
                }
                if ((streamInfo2.getId() != -1 && streamInfo.getId() == -1) || (streamInfo2.getId() == -1 && streamInfo.getId() != -1)) {
                    VideoCapture videoCapture3 = VideoCapture.this;
                    videoCapture3.applyStreamInfoAndStreamSpecToSessionConfigBuilder(videoCapture3.mSessionConfigBuilder, streamInfo, streamSpec);
                    VideoCapture videoCapture4 = VideoCapture.this;
                    videoCapture4.updateSessionConfig(videoCapture4.mSessionConfigBuilder.build());
                    VideoCapture.this.notifyReset();
                    return;
                }
                if (streamInfo2.getStreamState() != streamInfo.getStreamState()) {
                    VideoCapture videoCapture5 = VideoCapture.this;
                    videoCapture5.applyStreamInfoAndStreamSpecToSessionConfigBuilder(videoCapture5.mSessionConfigBuilder, streamInfo, streamSpec);
                    VideoCapture videoCapture6 = VideoCapture.this;
                    videoCapture6.updateSessionConfig(videoCapture6.mSessionConfigBuilder.build());
                    VideoCapture.this.notifyUpdated();
                }
            }
        };
    }

    @NonNull
    private static Rect adjustCropRectToValidSize(@NonNull final Rect rect, @NonNull Size size, @NonNull VideoEncoderInfo videoEncoderInfo) {
        boolean z5;
        Logger.d(TAG, String.format("Adjust cropRect %s by width/height alignment %d/%d and supported widths %s / supported heights %s", TransformUtils.rectToString(rect), Integer.valueOf(videoEncoderInfo.getWidthAlignment()), Integer.valueOf(videoEncoderInfo.getHeightAlignment()), videoEncoderInfo.getSupportedWidths(), videoEncoderInfo.getSupportedHeights()));
        int widthAlignment = videoEncoderInfo.getWidthAlignment();
        int heightAlignment = videoEncoderInfo.getHeightAlignment();
        Range<Integer> supportedWidths = videoEncoderInfo.getSupportedWidths();
        Range<Integer> supportedHeights = videoEncoderInfo.getSupportedHeights();
        int alignDown = alignDown(rect.width(), widthAlignment, supportedWidths);
        int alignUp = alignUp(rect.width(), widthAlignment, supportedWidths);
        int alignDown2 = alignDown(rect.height(), heightAlignment, supportedHeights);
        int alignUp2 = alignUp(rect.height(), heightAlignment, supportedHeights);
        HashSet hashSet = new HashSet();
        addBySupportedSize(hashSet, alignDown, alignDown2, size, videoEncoderInfo);
        addBySupportedSize(hashSet, alignDown, alignUp2, size, videoEncoderInfo);
        addBySupportedSize(hashSet, alignUp, alignDown2, size, videoEncoderInfo);
        addBySupportedSize(hashSet, alignUp, alignUp2, size, videoEncoderInfo);
        if (hashSet.isEmpty()) {
            Logger.w(TAG, "Can't find valid cropped size");
            return rect;
        }
        ArrayList arrayList = new ArrayList(hashSet);
        Logger.d(TAG, "candidatesList = " + arrayList);
        Collections.sort(arrayList, new Comparator() { // from class: androidx.camera.video.i0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return VideoCapture.b(rect, (Size) obj, (Size) obj2);
            }
        });
        Logger.d(TAG, "sorted candidatesList = " + arrayList);
        Size size2 = (Size) arrayList.get(0);
        int width = size2.getWidth();
        int height = size2.getHeight();
        if (width == rect.width() && height == rect.height()) {
            Logger.d(TAG, "No need to adjust cropRect because crop size is valid.");
            return rect;
        }
        if (width % 2 == 0 && height % 2 == 0 && width <= size.getWidth() && height <= size.getHeight()) {
            z5 = true;
        } else {
            z5 = false;
        }
        Preconditions.checkState(z5);
        Rect rect2 = new Rect(rect);
        if (width != rect.width()) {
            int max = Math.max(0, rect.centerX() - (width / 2));
            rect2.left = max;
            int i6 = max + width;
            rect2.right = i6;
            if (i6 > size.getWidth()) {
                int width2 = size.getWidth();
                rect2.right = width2;
                rect2.left = width2 - width;
            }
        }
        if (height != rect.height()) {
            int max2 = Math.max(0, rect.centerY() - (height / 2));
            rect2.top = max2;
            int i7 = max2 + height;
            rect2.bottom = i7;
            if (i7 > size.getHeight()) {
                int height2 = size.getHeight();
                rect2.bottom = height2;
                rect2.top = height2 - height;
            }
        }
        Logger.d(TAG, String.format("Adjust cropRect from %s to %s", TransformUtils.rectToString(rect), TransformUtils.rectToString(rect2)));
        return rect2;
    }

    @NonNull
    private Rect adjustCropRectWithInProgressTransformation(@NonNull Rect rect, int i6) {
        if (shouldCompensateTransformation()) {
            return TransformUtils.sizeToRect(TransformUtils.getRotatedSize(((SurfaceRequest.TransformationInfo) Preconditions.checkNotNull(this.mStreamInfo.getInProgressTransformationInfo())).getCropRect(), i6));
        }
        return rect;
    }

    @NonNull
    private Size adjustResolutionWithInProgressTransformation(@NonNull Size size, @NonNull Rect rect, @NonNull Rect rect2) {
        if (shouldCompensateTransformation() && !rect2.equals(rect)) {
            float height = rect2.height() / rect.height();
            return new Size((int) Math.ceil(size.getWidth() * height), (int) Math.ceil(size.getHeight() * height));
        }
        return size;
    }

    private int adjustRotationWithInProgressTransformation(int i6) {
        if (shouldCompensateTransformation()) {
            return TransformUtils.within360(i6 - this.mStreamInfo.getInProgressTransformationInfo().getRotationDegrees());
        }
        return i6;
    }

    public static /* synthetic */ int b(Rect rect, Size size, Size size2) {
        return (Math.abs(size.getWidth() - rect.width()) + Math.abs(size.getHeight() - rect.height())) - (Math.abs(size2.getWidth() - rect.width()) + Math.abs(size2.getHeight() - rect.height()));
    }

    @NonNull
    private Rect calculateCropRect(@NonNull Size size, @Nullable VideoEncoderInfo videoEncoderInfo) {
        Rect rect;
        if (getViewPortCropRect() != null) {
            rect = getViewPortCropRect();
        } else {
            rect = new Rect(0, 0, size.getWidth(), size.getHeight());
        }
        if (videoEncoderInfo != null && !videoEncoderInfo.isSizeSupported(rect.width(), rect.height())) {
            return adjustCropRectToValidSize(rect, size, videoEncoderInfo);
        }
        return rect;
    }

    @MainThread
    private void clearPipeline() {
        Threads.checkMainThread();
        DeferrableSurface deferrableSurface = this.mDeferrableSurface;
        if (deferrableSurface != null) {
            deferrableSurface.close();
            this.mDeferrableSurface = null;
        }
        SurfaceProcessorNode surfaceProcessorNode = this.mNode;
        if (surfaceProcessorNode != null) {
            surfaceProcessorNode.release();
            this.mNode = null;
        }
        SurfaceEdge surfaceEdge = this.mCameraEdge;
        if (surfaceEdge != null) {
            surfaceEdge.close();
            this.mCameraEdge = null;
        }
        this.mVideoEncoderInfo = null;
        this.mCropRect = null;
        this.mSurfaceRequest = null;
        this.mStreamInfo = StreamInfo.STREAM_INFO_ANY_INACTIVE;
        this.mRotationDegrees = 0;
        this.mHasCompensatingTransformation = false;
    }

    @Nullable
    private SurfaceProcessorNode createNodeIfNeeded(@NonNull CameraInternal cameraInternal, @NonNull Rect rect, @NonNull Size size, @NonNull DynamicRange dynamicRange) {
        SurfaceProcessorInternal newInstance;
        if (getEffect() == null && !shouldEnableSurfaceProcessingByQuirk(cameraInternal) && !shouldCrop(rect, size) && !shouldMirror(cameraInternal) && !shouldCompensateTransformation()) {
            return null;
        }
        Logger.d(TAG, "Surface processing is enabled.");
        CameraInternal camera = getCamera();
        Objects.requireNonNull(camera);
        CameraInternal cameraInternal2 = camera;
        if (getEffect() != null) {
            newInstance = getEffect().createSurfaceProcessorInternal();
        } else {
            newInstance = DefaultSurfaceProcessor.Factory.newInstance(dynamicRange);
        }
        return new SurfaceProcessorNode(cameraInternal2, newInstance);
    }

    public static /* synthetic */ void e(AtomicBoolean atomicBoolean, SessionConfig.Builder builder, CameraCaptureCallback cameraCaptureCallback) {
        Preconditions.checkState(Threads.isMainThread(), "Surface update cancellation should only occur on main thread.");
        atomicBoolean.set(true);
        builder.removeCameraCaptureCallback(cameraCaptureCallback);
    }

    public static /* synthetic */ Object f(VideoCapture videoCapture, final SessionConfig.Builder builder, CallbackToFutureAdapter.Completer completer) {
        videoCapture.getClass();
        builder.addTag(SURFACE_UPDATE_KEY, Integer.valueOf(completer.hashCode()));
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final AnonymousClass2 anonymousClass2 = new AnonymousClass2(atomicBoolean, completer, builder);
        completer.addCancellationListener(new Runnable() { // from class: androidx.camera.video.h0
            @Override // java.lang.Runnable
            public final void run() {
                VideoCapture.e(atomicBoolean, builder, anonymousClass2);
            }
        }, CameraXExecutors.directExecutor());
        builder.addRepeatingCameraCaptureCallback(anonymousClass2);
        return String.format("%s[0x%x]", SURFACE_UPDATE_KEY, Integer.valueOf(completer.hashCode()));
    }

    @Nullable
    private static <T> T fetchObservableValue(@NonNull Observable<T> observable, @Nullable T t5) {
        ListenableFuture<T> fetchData = observable.fetchData();
        if (!fetchData.isDone()) {
            return t5;
        }
        try {
            return fetchData.get();
        } catch (InterruptedException | ExecutionException e6) {
            throw new IllegalStateException(e6);
        }
    }

    @Nullable
    private MediaSpec getMediaSpec() {
        return (MediaSpec) fetchObservableValue(getOutput().getMediaSpec(), null);
    }

    @NonNull
    private VideoCapabilities getVideoCapabilities(@NonNull CameraInfo cameraInfo) {
        return getOutput().getMediaCapabilities(cameraInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAppEdgeInvalidated(@NonNull SurfaceEdge surfaceEdge, @NonNull CameraInternal cameraInternal, @NonNull VideoCaptureConfig<T> videoCaptureConfig, @NonNull Timebase timebase) {
        if (cameraInternal == getCamera()) {
            this.mSurfaceRequest = surfaceEdge.createSurfaceRequest(cameraInternal);
            videoCaptureConfig.getVideoOutput().onSurfaceRequested(this.mSurfaceRequest, timebase);
            sendTransformationInfoIfReady();
        }
    }

    @Nullable
    private static VideoEncoderInfo resolveVideoEncoderInfo(@NonNull Function<VideoEncoderConfig, VideoEncoderInfo> function, @Nullable VideoValidatedEncoderProfilesProxy videoValidatedEncoderProfilesProxy, @NonNull MediaSpec mediaSpec, @NonNull Size size, @NonNull DynamicRange dynamicRange, @NonNull Range<Integer> range) {
        return function.apply(VideoConfigUtil.resolveVideoEncoderConfig(VideoConfigUtil.resolveVideoMimeInfo(mediaSpec, dynamicRange, videoValidatedEncoderProfilesProxy), Timebase.UPTIME, mediaSpec.getVideoSpec(), size, dynamicRange, range));
    }

    private void sendTransformationInfoIfReady() {
        CameraInternal camera = getCamera();
        SurfaceEdge surfaceEdge = this.mCameraEdge;
        if (camera != null && surfaceEdge != null) {
            int adjustRotationWithInProgressTransformation = adjustRotationWithInProgressTransformation(getRelativeRotation(camera, isMirroringRequired(camera)));
            this.mRotationDegrees = adjustRotationWithInProgressTransformation;
            surfaceEdge.updateTransformation(adjustRotationWithInProgressTransformation, getAppTargetRotation());
        }
    }

    private static boolean shouldCrop(@NonNull Rect rect, @NonNull Size size) {
        if (size.getWidth() == rect.width() && size.getHeight() == rect.height()) {
            return false;
        }
        return true;
    }

    private static boolean shouldEnableSurfaceProcessingByQuirk(@NonNull CameraInternal cameraInternal) {
        if (cameraInternal.getHasTransform() && sEnableSurfaceProcessingByQuirk) {
            return true;
        }
        return false;
    }

    private boolean shouldMirror(@NonNull CameraInternal cameraInternal) {
        if (cameraInternal.getHasTransform() && isMirroringRequired(cameraInternal)) {
            return true;
        }
        return false;
    }

    private void updateCustomOrderedResolutionsByQuality(@NonNull CameraInfoInternal cameraInfoInternal, @NonNull UseCaseConfig.Builder<?, ?, ?> builder) throws IllegalArgumentException {
        boolean z5;
        MediaSpec mediaSpec = getMediaSpec();
        if (mediaSpec != null) {
            z5 = true;
        } else {
            z5 = false;
        }
        Preconditions.checkArgument(z5, "Unable to update target resolution by null MediaSpec.");
        DynamicRange dynamicRange = getDynamicRange();
        VideoCapabilities videoCapabilities = getVideoCapabilities(cameraInfoInternal);
        List<Quality> supportedQualities = videoCapabilities.getSupportedQualities(dynamicRange);
        if (supportedQualities.isEmpty()) {
            Logger.w(TAG, "Can't find any supported quality on the device.");
            return;
        }
        VideoSpec videoSpec = mediaSpec.getVideoSpec();
        QualitySelector qualitySelector = videoSpec.getQualitySelector();
        List<Quality> prioritizedQualities = qualitySelector.getPrioritizedQualities(supportedQualities);
        Logger.d(TAG, "Found selectedQualities " + prioritizedQualities + " by " + qualitySelector);
        if (!prioritizedQualities.isEmpty()) {
            int aspectRatio = videoSpec.getAspectRatio();
            QualityRatioToResolutionsTable qualityRatioToResolutionsTable = new QualityRatioToResolutionsTable(cameraInfoInternal.getSupportedResolutions(getImageFormat()), QualitySelector.getQualityToResolutionMap(videoCapabilities, dynamicRange));
            ArrayList arrayList = new ArrayList();
            Iterator<Quality> it = prioritizedQualities.iterator();
            while (it.hasNext()) {
                arrayList.addAll(qualityRatioToResolutionsTable.getResolutions(it.next(), aspectRatio));
            }
            Logger.d(TAG, "Set custom ordered resolutions = " + arrayList);
            builder.getMutableConfig().insertOption(ImageOutputConfig.OPTION_CUSTOM_ORDERED_RESOLUTIONS, arrayList);
            return;
        }
        throw new IllegalArgumentException("Unable to find supported quality by QualitySelector");
    }

    @MainThread
    void applyStreamInfoAndStreamSpecToSessionConfigBuilder(@NonNull SessionConfig.Builder builder, @NonNull StreamInfo streamInfo, @NonNull StreamSpec streamSpec) {
        boolean z5;
        boolean z6 = false;
        if (streamInfo.getId() == -1) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (streamInfo.getStreamState() == StreamInfo.StreamState.ACTIVE) {
            z6 = true;
        }
        if (z5 && z6) {
            throw new IllegalStateException("Unexpected stream state, stream is error but active");
        }
        builder.clearSurfaces();
        DynamicRange dynamicRange = streamSpec.getDynamicRange();
        if (!z5) {
            if (z6) {
                builder.addSurface(this.mDeferrableSurface, dynamicRange);
            } else {
                builder.addNonRepeatingSurface(this.mDeferrableSurface, dynamicRange);
            }
        }
        setupSurfaceUpdateNotifier(builder, z6);
    }

    @NonNull
    public DynamicRange getDynamicRange() {
        if (getCurrentConfig().hasDynamicRange()) {
            return getCurrentConfig().getDynamicRange();
        }
        return Defaults.DEFAULT_DYNAMIC_RANGE;
    }

    public int getMirrorMode() {
        return getMirrorModeInternal();
    }

    @NonNull
    public T getOutput() {
        return (T) ((VideoCaptureConfig) getCurrentConfig()).getVideoOutput();
    }

    @NonNull
    public Range<Integer> getTargetFrameRate() {
        return getTargetFrameRateInternal();
    }

    public int getTargetRotation() {
        return getTargetRotationInternal();
    }

    @Override // androidx.camera.core.UseCase
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public UseCaseConfig.Builder<?, ?, ?> getUseCaseConfigBuilder(@NonNull Config config) {
        return Builder.fromConfig(config);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [androidx.camera.core.impl.UseCaseConfig, androidx.camera.core.impl.UseCaseConfig<?>] */
    @Override // androidx.camera.core.UseCase
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected UseCaseConfig<?> onMergeConfig(@NonNull CameraInfoInternal cameraInfoInternal, @NonNull UseCaseConfig.Builder<?, ?, ?> builder) {
        updateCustomOrderedResolutionsByQuality(cameraInfoInternal, builder);
        return builder.getUseCaseConfig();
    }

    @Override // androidx.camera.core.UseCase
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onStateAttached() {
        boolean z5;
        super.onStateAttached();
        Preconditions.checkNotNull(getAttachedStreamSpec(), "The suggested stream specification should be already updated and shouldn't be null.");
        if (this.mSurfaceRequest == null) {
            z5 = true;
        } else {
            z5 = false;
        }
        Preconditions.checkState(z5, "The surface request should be null when VideoCapture is attached.");
        StreamSpec streamSpec = (StreamSpec) Preconditions.checkNotNull(getAttachedStreamSpec());
        this.mStreamInfo = (StreamInfo) fetchObservableValue(getOutput().getStreamInfo(), StreamInfo.STREAM_INFO_ANY_INACTIVE);
        SessionConfig.Builder createPipeline = createPipeline(getCameraId(), (VideoCaptureConfig) getCurrentConfig(), streamSpec);
        this.mSessionConfigBuilder = createPipeline;
        applyStreamInfoAndStreamSpecToSessionConfigBuilder(createPipeline, this.mStreamInfo, streamSpec);
        updateSessionConfig(this.mSessionConfigBuilder.build());
        notifyActive();
        getOutput().getStreamInfo().addObserver(CameraXExecutors.mainThreadExecutor(), this.mStreamInfoObserver);
        setSourceState(VideoOutput.SourceState.ACTIVE_NON_STREAMING);
    }

    @Override // androidx.camera.core.UseCase
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onStateDetached() {
        Preconditions.checkState(Threads.isMainThread(), "VideoCapture can only be detached on the main thread.");
        setSourceState(VideoOutput.SourceState.INACTIVE);
        getOutput().getStreamInfo().removeObserver(this.mStreamInfoObserver);
        ListenableFuture<Void> listenableFuture = this.mSurfaceUpdateFuture;
        if (listenableFuture != null && listenableFuture.cancel(false)) {
            Logger.d(TAG, "VideoCapture is detached from the camera. Surface update cancelled.");
        }
        clearPipeline();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @MainThread
    public void resetPipeline(@NonNull String str, @NonNull VideoCaptureConfig<T> videoCaptureConfig, @NonNull StreamSpec streamSpec) {
        clearPipeline();
        if (isCurrentCamera(str)) {
            SessionConfig.Builder createPipeline = createPipeline(str, videoCaptureConfig, streamSpec);
            this.mSessionConfigBuilder = createPipeline;
            applyStreamInfoAndStreamSpecToSessionConfigBuilder(createPipeline, this.mStreamInfo, streamSpec);
            updateSessionConfig(this.mSessionConfigBuilder.build());
            notifyReset();
        }
    }

    public void setTargetRotation(int i6) {
        if (setTargetRotationInternal(i6)) {
            sendTransformationInfoIfReady();
        }
    }

    @Override // androidx.camera.core.UseCase
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setViewPortCropRect(@NonNull Rect rect) {
        super.setViewPortCropRect(rect);
        sendTransformationInfoIfReady();
    }
}
