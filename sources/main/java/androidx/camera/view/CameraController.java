package androidx.camera.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Matrix;
import android.os.Build;
import android.util.Size;
import androidx.annotation.DoNotInline;
import androidx.annotation.FloatRange;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.OptIn;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.arch.core.util.Function;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraControl;
import androidx.camera.core.CameraEffect;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraInfoUnavailableException;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.FocusMeteringAction;
import androidx.camera.core.FocusMeteringResult;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.Logger;
import androidx.camera.core.MeteringPointFactory;
import androidx.camera.core.Preview;
import androidx.camera.core.UseCaseGroup;
import androidx.camera.core.ViewPort;
import androidx.camera.core.ZoomState;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.video.FileDescriptorOutputOptions;
import androidx.camera.video.FileOutputOptions;
import androidx.camera.video.MediaStoreOutputOptions;
import androidx.camera.video.OutputOptions;
import androidx.camera.video.PendingRecording;
import androidx.camera.video.QualitySelector;
import androidx.camera.video.Recorder;
import androidx.camera.video.Recording;
import androidx.camera.video.VideoCapture;
import androidx.camera.video.VideoRecordEvent;
import androidx.camera.view.CameraController;
import androidx.camera.view.RotationProvider;
import androidx.camera.view.video.AudioConfig;
import androidx.core.content.ContextCompat;
import androidx.core.content.PermissionChecker;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public abstract class CameraController {
    private static final float AE_SIZE = 0.25f;
    private static final float AF_SIZE = 0.16666667f;
    private static final String CAMERA_NOT_ATTACHED = "Use cases not attached to camera.";
    private static final String CAMERA_NOT_INITIALIZED = "Camera not initialized.";
    public static final int COORDINATE_SYSTEM_VIEW_REFERENCED = 1;
    public static final int IMAGE_ANALYSIS = 2;
    public static final int IMAGE_CAPTURE = 1;
    private static final String IMAGE_CAPTURE_DISABLED = "ImageCapture disabled.";
    private static final String PREVIEW_VIEW_NOT_ATTACHED = "PreviewView not attached to CameraController.";
    private static final String TAG = "CameraController";
    public static final int TAP_TO_FOCUS_FAILED = 4;
    public static final int TAP_TO_FOCUS_FOCUSED = 2;
    public static final int TAP_TO_FOCUS_NOT_FOCUSED = 3;
    public static final int TAP_TO_FOCUS_NOT_STARTED = 0;
    public static final int TAP_TO_FOCUS_STARTED = 1;
    public static final int VIDEO_CAPTURE = 4;
    private static final String VIDEO_CAPTURE_DISABLED = "VideoCapture disabled.";
    private static final String VIDEO_RECORDING_UNFINISHED = "Recording video. Only one recording can be active at a time.";

    @Nullable
    Recording mActiveRecording;

    @Nullable
    private ImageAnalysis.Analyzer mAnalysisAnalyzer;

    @Nullable
    private Executor mAnalysisBackgroundExecutor;

    @Nullable
    private Executor mAnalysisExecutor;
    private final Context mAppContext;

    @Nullable
    Camera mCamera;

    @Nullable
    ProcessCameraProviderWrapper mCameraProvider;
    CameraSelector mCameraSelector;

    @NonNull
    @VisibleForTesting
    final RotationProvider.Listener mDeviceRotationListener;

    @NonNull
    private final Set<CameraEffect> mEffects;
    private int mEnabledUseCases;

    @NonNull
    ImageAnalysis mImageAnalysis;

    @Nullable
    OutputSize mImageAnalysisTargetSize;

    @NonNull
    ImageCapture mImageCapture;

    @Nullable
    Executor mImageCaptureIoExecutor;

    @Nullable
    OutputSize mImageCaptureTargetSize;

    @NonNull
    private final ListenableFuture<Void> mInitializationFuture;

    @NonNull
    private final PendingValue<Boolean> mPendingEnableTorch;

    @NonNull
    private final PendingValue<Float> mPendingLinearZoom;

    @NonNull
    private final PendingValue<Float> mPendingZoomRatio;
    private boolean mPinchToZoomEnabled;

    @NonNull
    Preview mPreview;

    @Nullable
    OutputSize mPreviewTargetSize;

    @NonNull
    Map<Consumer<VideoRecordEvent>, Recording> mRecordingMap;
    private final RotationProvider mRotationProvider;

    @Nullable
    Preview.SurfaceProvider mSurfaceProvider;
    private boolean mTapToFocusEnabled;
    final MutableLiveData<Integer> mTapToFocusState;
    private final ForwardingLiveData<Integer> mTorchState;

    @NonNull
    VideoCapture<Recorder> mVideoCapture;

    @NonNull
    QualitySelector mVideoCaptureQualitySelector;

    @Nullable
    ViewPort mViewPort;
    private final ForwardingLiveData<ZoomState> mZoomState;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: androidx.camera.view.CameraController$1, reason: invalid class name */
    class AnonymousClass1 implements Consumer<VideoRecordEvent> {
        final /* synthetic */ Consumer val$listener;
        final /* synthetic */ Executor val$mainExecutor;

        AnonymousClass1(Executor executor, Consumer consumer) {
            this.val$mainExecutor = executor;
            this.val$listener = consumer;
        }

        @Override // androidx.core.util.Consumer
        public void accept(VideoRecordEvent videoRecordEvent) {
            if (videoRecordEvent instanceof VideoRecordEvent.Finalize) {
                if (Threads.isMainThread()) {
                    CameraController.this.deactivateRecordingByListener(this);
                } else {
                    this.val$mainExecutor.execute(new Runnable() { // from class: androidx.camera.view.i
                        @Override // java.lang.Runnable
                        public final void run() {
                            CameraController.this.deactivateRecordingByListener(CameraController.AnonymousClass1.this);
                        }
                    });
                }
            }
            this.val$listener.accept(videoRecordEvent);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(21)
    public static final class OutputSize {
        public static final int UNASSIGNED_ASPECT_RATIO = -1;
        private final int mAspectRatio;

        @Nullable
        private final Size mResolution;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public @interface OutputAspectRatio {
        }

        public OutputSize(int i6) {
            Preconditions.checkArgument(i6 != -1);
            this.mAspectRatio = i6;
            this.mResolution = null;
        }

        public int getAspectRatio() {
            return this.mAspectRatio;
        }

        @Nullable
        public Size getResolution() {
            return this.mResolution;
        }

        @NonNull
        public String toString() {
            return "aspect ratio: " + this.mAspectRatio + " resolution: " + this.mResolution;
        }

        public OutputSize(@NonNull Size size) {
            Preconditions.checkNotNull(size);
            this.mAspectRatio = -1;
            this.mResolution = size;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface UseCases {
    }

    CameraController(@NonNull Context context) {
        this(context, Futures.transform(ProcessCameraProvider.getInstance(context), new Function() { // from class: androidx.camera.view.f
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return new ProcessCameraProviderWrapperImpl((ProcessCameraProvider) obj);
            }
        }, CameraXExecutors.directExecutor()));
    }

    private boolean isOutputSizeEqual(@Nullable OutputSize outputSize, @Nullable OutputSize outputSize2) {
        if (outputSize == outputSize2) {
            return true;
        }
        return outputSize != null && outputSize.equals(outputSize2);
    }

    private void restartCameraIfAnalyzerResolutionChanged(@Nullable ImageAnalysis.Analyzer analyzer, @Nullable ImageAnalysis.Analyzer analyzer2) {
        if (Objects.equals(analyzer == null ? null : analyzer.getDefaultTargetResolution(), analyzer2 != null ? analyzer2.getDefaultTargetResolution() : null)) {
            return;
        }
        unbindImageAnalysisAndRecreate(this.mImageAnalysis.getBackpressureStrategy(), this.mImageAnalysis.getImageQueueDepth());
        startCameraAndTrackStates();
    }

    @Nullable
    abstract Camera startCamera();

    void startCameraAndTrackStates() {
        startCameraAndTrackStates(null);
    }

    @NonNull
    @SuppressLint({"MissingPermission"})
    @MainThread
    public Recording startRecording(@NonNull FileOutputOptions fileOutputOptions, @NonNull AudioConfig audioConfig, @NonNull Executor executor, @NonNull Consumer<VideoRecordEvent> consumer) {
        return startRecordingInternal(fileOutputOptions, audioConfig, executor, consumer);
    }

    @MainThread
    public void takePicture(@NonNull ImageCapture.OutputFileOptions outputFileOptions, @NonNull Executor executor, @NonNull ImageCapture.OnImageSavedCallback onImageSavedCallback) {
        Threads.checkMainThread();
        Preconditions.checkState(isCameraInitialized(), CAMERA_NOT_INITIALIZED);
        Preconditions.checkState(isImageCaptureEnabled(), IMAGE_CAPTURE_DISABLED);
        updateMirroringFlagInOutputFileOptions(outputFileOptions);
        this.mImageCapture.takePicture(outputFileOptions, executor, onImageSavedCallback);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(30)
    private static class Api30Impl {
        private Api30Impl() {
        }

        @NonNull
        @DoNotInline
        static Context createAttributionContext(@NonNull Context context, @Nullable String str) {
            return context.createAttributionContext(str);
        }

        @Nullable
        @DoNotInline
        static String getAttributionTag(@NonNull Context context) {
            return context.getAttributionTag();
        }
    }

    public static /* synthetic */ Void a(CameraController cameraController, ProcessCameraProviderWrapper processCameraProviderWrapper) {
        cameraController.mCameraProvider = processCameraProviderWrapper;
        cameraController.startCameraAndTrackStates();
        return null;
    }

    public static /* synthetic */ void b(CameraController cameraController, int i6) {
        cameraController.mImageAnalysis.setTargetRotation(i6);
        cameraController.mImageCapture.setTargetRotation(i6);
        cameraController.mVideoCapture.setTargetRotation(i6);
    }

    private void checkAudioPermissionGranted() {
        if (PermissionChecker.checkSelfPermission(this.mAppContext, "android.permission.RECORD_AUDIO") == -1) {
            throw new SecurityException("Attempted to start recording with audio, but application does not have RECORD_AUDIO permission granted.");
        }
    }

    private VideoCapture<Recorder> createNewVideoCapture() {
        return VideoCapture.withOutput(generateVideoCaptureRecorder(this.mVideoCaptureQualitySelector));
    }

    @MainThread
    private void deactivateRecording(@NonNull Recording recording) {
        if (this.mActiveRecording == recording) {
            this.mActiveRecording = null;
        }
    }

    private static Recorder generateVideoCaptureRecorder(@NonNull QualitySelector qualitySelector) {
        return new Recorder.Builder().setQualitySelector(qualitySelector).build();
    }

    private boolean isCameraAttached() {
        return this.mCamera != null;
    }

    private boolean isCameraInitialized() {
        return this.mCameraProvider != null;
    }

    private boolean isPreviewViewAttached() {
        return (this.mSurfaceProvider == null || this.mViewPort == null) ? false : true;
    }

    private boolean isUseCaseEnabled(int i6) {
        return (i6 & this.mEnabledUseCases) != 0;
    }

    @MainThread
    private PendingRecording prepareRecording(@NonNull OutputOptions outputOptions) {
        Recorder output = this.mVideoCapture.getOutput();
        if (outputOptions instanceof FileOutputOptions) {
            return output.prepareRecording(this.mAppContext, (FileOutputOptions) outputOptions);
        }
        if (outputOptions instanceof FileDescriptorOutputOptions) {
            if (Build.VERSION.SDK_INT >= 26) {
                return output.prepareRecording(this.mAppContext, (FileDescriptorOutputOptions) outputOptions);
            }
            throw new UnsupportedOperationException("File descriptors are not supported on pre-Android O (API 26) devices.");
        }
        if (outputOptions instanceof MediaStoreOutputOptions) {
            return output.prepareRecording(this.mAppContext, (MediaStoreOutputOptions) outputOptions);
        }
        throw new IllegalArgumentException("Unsupported OutputOptions type.");
    }

    @MainThread
    private void setActiveRecording(@NonNull Recording recording, @NonNull Consumer<VideoRecordEvent> consumer) {
        this.mRecordingMap.put(consumer, recording);
        this.mActiveRecording = recording;
    }

    private void setTargetOutputSize(@NonNull ImageOutputConfig.Builder<?> builder, @Nullable OutputSize outputSize) {
        if (outputSize == null) {
            return;
        }
        if (outputSize.getResolution() != null) {
            builder.setTargetResolution(outputSize.getResolution());
            return;
        }
        if (outputSize.getAspectRatio() != -1) {
            builder.setTargetAspectRatio(outputSize.getAspectRatio());
            return;
        }
        Logger.e(TAG, "Invalid target surface size. " + outputSize);
    }

    private float speedUpZoomBy2X(float f6) {
        return f6 > 1.0f ? ((f6 - 1.0f) * 2.0f) + 1.0f : 1.0f - ((1.0f - f6) * 2.0f);
    }

    private void startListeningToRotationEvents() {
        this.mRotationProvider.addListener(CameraXExecutors.mainThreadExecutor(), this.mDeviceRotationListener);
    }

    private void stopListeningToRotationEvents() {
        this.mRotationProvider.removeListener(this.mDeviceRotationListener);
    }

    private Consumer<VideoRecordEvent> wrapListenerToDeactivateRecordingOnFinalized(@NonNull Consumer<VideoRecordEvent> consumer) {
        return new AnonymousClass1(ContextCompat.getMainExecutor(this.mAppContext), consumer);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @MainThread
    public void deactivateRecordingByListener(@NonNull Consumer<VideoRecordEvent> consumer) {
        Recording remove = this.mRecordingMap.remove(consumer);
        if (remove != null) {
            deactivateRecording(remove);
        }
    }

    @NonNull
    public ListenableFuture<Void> getInitializationFuture() {
        return this.mInitializationFuture;
    }

    void startCameraAndTrackStates(@Nullable Runnable runnable) {
        try {
            this.mCamera = startCamera();
            if (!isCameraAttached()) {
                Logger.d(TAG, CAMERA_NOT_ATTACHED);
                return;
            }
            this.mZoomState.setSource(this.mCamera.getCameraInfo().getZoomState());
            this.mTorchState.setSource(this.mCamera.getCameraInfo().getTorchState());
            this.mPendingEnableTorch.propagateIfHasValue(new Function() { // from class: androidx.camera.view.a
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return CameraController.this.enableTorch(((Boolean) obj).booleanValue());
                }
            });
            this.mPendingLinearZoom.propagateIfHasValue(new Function() { // from class: androidx.camera.view.b
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return CameraController.this.setLinearZoom(((Float) obj).floatValue());
                }
            });
            this.mPendingZoomRatio.propagateIfHasValue(new Function() { // from class: androidx.camera.view.c
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return CameraController.this.setZoomRatio(((Float) obj).floatValue());
                }
            });
        } catch (RuntimeException e6) {
            if (runnable != null) {
                runnable.run();
            }
            throw e6;
        }
    }

    @NonNull
    @SuppressLint({"MissingPermission"})
    @RequiresApi(26)
    @MainThread
    public Recording startRecording(@NonNull FileDescriptorOutputOptions fileDescriptorOutputOptions, @NonNull AudioConfig audioConfig, @NonNull Executor executor, @NonNull Consumer<VideoRecordEvent> consumer) {
        return startRecordingInternal(fileDescriptorOutputOptions, audioConfig, executor, consumer);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @VisibleForTesting
    void updateMirroringFlagInOutputFileOptions(@NonNull ImageCapture.OutputFileOptions outputFileOptions) {
        if (this.mCameraSelector.getLensFacing() == null || outputFileOptions.getMetadata().isReversedHorizontalSet()) {
            return;
        }
        outputFileOptions.getMetadata().setReversedHorizontal(this.mCameraSelector.getLensFacing().intValue() == 0);
    }

    private static Context getApplicationContext(@NonNull Context context) {
        String attributionTag;
        Context applicationContext = context.getApplicationContext();
        if (Build.VERSION.SDK_INT >= 30 && (attributionTag = Api30Impl.getAttributionTag(context)) != null) {
            return Api30Impl.createAttributionContext(applicationContext, attributionTag);
        }
        return applicationContext;
    }

    @RequiresPermission("android.permission.RECORD_AUDIO")
    @MainThread
    private Recording startRecordingInternal(@NonNull OutputOptions outputOptions, @NonNull AudioConfig audioConfig, @NonNull Executor executor, @NonNull Consumer<VideoRecordEvent> consumer) {
        Threads.checkMainThread();
        Preconditions.checkState(isCameraInitialized(), CAMERA_NOT_INITIALIZED);
        Preconditions.checkState(isVideoCaptureEnabled(), VIDEO_CAPTURE_DISABLED);
        Preconditions.checkState(!isRecording(), VIDEO_RECORDING_UNFINISHED);
        Consumer<VideoRecordEvent> wrapListenerToDeactivateRecordingOnFinalized = wrapListenerToDeactivateRecordingOnFinalized(consumer);
        PendingRecording prepareRecording = prepareRecording(outputOptions);
        if (audioConfig.getAudioEnabled()) {
            checkAudioPermissionGranted();
            prepareRecording.withAudioEnabled();
        }
        Recording start = prepareRecording.start(executor, wrapListenerToDeactivateRecordingOnFinalized);
        setActiveRecording(start, wrapListenerToDeactivateRecordingOnFinalized);
        return start;
    }

    @MainThread
    private void stopRecording() {
        Threads.checkMainThread();
        Recording recording = this.mActiveRecording;
        if (recording != null) {
            recording.stop();
            deactivateRecording(this.mActiveRecording);
        }
    }

    @MainThread
    private void unbindImageAnalysisAndRecreate(int i6, int i7) {
        ImageAnalysis.Analyzer analyzer;
        Threads.checkMainThread();
        if (isCameraInitialized()) {
            this.mCameraProvider.unbind(this.mImageAnalysis);
        }
        ImageAnalysis.Builder imageQueueDepth = new ImageAnalysis.Builder().setBackpressureStrategy(i6).setImageQueueDepth(i7);
        setTargetOutputSize(imageQueueDepth, this.mImageAnalysisTargetSize);
        Executor executor = this.mAnalysisBackgroundExecutor;
        if (executor != null) {
            imageQueueDepth.setBackgroundExecutor(executor);
        }
        ImageAnalysis build = imageQueueDepth.build();
        this.mImageAnalysis = build;
        Executor executor2 = this.mAnalysisExecutor;
        if (executor2 != null && (analyzer = this.mAnalysisAnalyzer) != null) {
            build.setAnalyzer(executor2, analyzer);
        }
    }

    private void unbindImageCaptureAndRecreate(int i6) {
        if (isCameraInitialized()) {
            this.mCameraProvider.unbind(this.mImageCapture);
        }
        ImageCapture.Builder captureMode = new ImageCapture.Builder().setCaptureMode(i6);
        setTargetOutputSize(captureMode, this.mImageCaptureTargetSize);
        Executor executor = this.mImageCaptureIoExecutor;
        if (executor != null) {
            captureMode.setIoExecutor(executor);
        }
        this.mImageCapture = captureMode.build();
    }

    private void unbindPreviewAndRecreate() {
        if (isCameraInitialized()) {
            this.mCameraProvider.unbind(this.mPreview);
        }
        Preview.Builder builder = new Preview.Builder();
        setTargetOutputSize(builder, this.mPreviewTargetSize);
        this.mPreview = builder.build();
    }

    private void unbindVideoAndRecreate() {
        if (isCameraInitialized()) {
            this.mCameraProvider.unbind(this.mVideoCapture);
        }
        this.mVideoCapture = createNewVideoCapture();
    }

    @SuppressLint({"MissingPermission", "WrongConstant"})
    @MainThread
    void attachPreviewSurface(@NonNull Preview.SurfaceProvider surfaceProvider, @NonNull ViewPort viewPort) {
        Threads.checkMainThread();
        if (this.mSurfaceProvider != surfaceProvider) {
            this.mSurfaceProvider = surfaceProvider;
            this.mPreview.setSurfaceProvider(surfaceProvider);
        }
        this.mViewPort = viewPort;
        startListeningToRotationEvents();
        startCameraAndTrackStates();
    }

    @MainThread
    public void clearEffects() {
        Threads.checkMainThread();
        ProcessCameraProviderWrapper processCameraProviderWrapper = this.mCameraProvider;
        if (processCameraProviderWrapper != null) {
            processCameraProviderWrapper.unbindAll();
        }
        this.mEffects.clear();
        startCameraAndTrackStates();
    }

    @MainThread
    public void clearImageAnalysisAnalyzer() {
        Threads.checkMainThread();
        ImageAnalysis.Analyzer analyzer = this.mAnalysisAnalyzer;
        this.mAnalysisExecutor = null;
        this.mAnalysisAnalyzer = null;
        this.mImageAnalysis.clearAnalyzer();
        restartCameraIfAnalyzerResolutionChanged(analyzer, null);
    }

    @MainThread
    void clearPreviewSurface() {
        Threads.checkMainThread();
        ProcessCameraProviderWrapper processCameraProviderWrapper = this.mCameraProvider;
        if (processCameraProviderWrapper != null) {
            processCameraProviderWrapper.unbind(this.mPreview, this.mImageCapture, this.mImageAnalysis, this.mVideoCapture);
        }
        this.mPreview.setSurfaceProvider(null);
        this.mCamera = null;
        this.mSurfaceProvider = null;
        this.mViewPort = null;
        stopListeningToRotationEvents();
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected UseCaseGroup createUseCaseGroup() {
        if (!isCameraInitialized()) {
            Logger.d(TAG, CAMERA_NOT_INITIALIZED);
            return null;
        }
        if (!isPreviewViewAttached()) {
            Logger.d(TAG, PREVIEW_VIEW_NOT_ATTACHED);
            return null;
        }
        UseCaseGroup.Builder addUseCase = new UseCaseGroup.Builder().addUseCase(this.mPreview);
        if (isImageCaptureEnabled()) {
            addUseCase.addUseCase(this.mImageCapture);
        } else {
            this.mCameraProvider.unbind(this.mImageCapture);
        }
        if (isImageAnalysisEnabled()) {
            addUseCase.addUseCase(this.mImageAnalysis);
        } else {
            this.mCameraProvider.unbind(this.mImageAnalysis);
        }
        if (isVideoCaptureEnabled()) {
            addUseCase.addUseCase(this.mVideoCapture);
        } else {
            this.mCameraProvider.unbind(this.mVideoCapture);
        }
        addUseCase.setViewPort(this.mViewPort);
        Iterator<CameraEffect> it = this.mEffects.iterator();
        while (it.hasNext()) {
            addUseCase.addEffect(it.next());
        }
        return addUseCase.build();
    }

    @NonNull
    @MainThread
    public ListenableFuture<Void> enableTorch(boolean z5) {
        Threads.checkMainThread();
        if (!isCameraAttached()) {
            return this.mPendingEnableTorch.setValue(Boolean.valueOf(z5));
        }
        return this.mCamera.getCameraControl().enableTorch(z5);
    }

    @Nullable
    @MainThread
    public CameraControl getCameraControl() {
        Threads.checkMainThread();
        Camera camera = this.mCamera;
        if (camera == null) {
            return null;
        }
        return camera.getCameraControl();
    }

    @Nullable
    @MainThread
    public CameraInfo getCameraInfo() {
        Threads.checkMainThread();
        Camera camera = this.mCamera;
        if (camera == null) {
            return null;
        }
        return camera.getCameraInfo();
    }

    @NonNull
    @MainThread
    public CameraSelector getCameraSelector() {
        Threads.checkMainThread();
        return this.mCameraSelector;
    }

    @Nullable
    @MainThread
    public Executor getImageAnalysisBackgroundExecutor() {
        Threads.checkMainThread();
        return this.mAnalysisBackgroundExecutor;
    }

    @MainThread
    public int getImageAnalysisBackpressureStrategy() {
        Threads.checkMainThread();
        return this.mImageAnalysis.getBackpressureStrategy();
    }

    @MainThread
    public int getImageAnalysisImageQueueDepth() {
        Threads.checkMainThread();
        return this.mImageAnalysis.getImageQueueDepth();
    }

    @Nullable
    @MainThread
    public OutputSize getImageAnalysisTargetSize() {
        Threads.checkMainThread();
        return this.mImageAnalysisTargetSize;
    }

    @MainThread
    public int getImageCaptureFlashMode() {
        Threads.checkMainThread();
        return this.mImageCapture.getFlashMode();
    }

    @Nullable
    @MainThread
    public Executor getImageCaptureIoExecutor() {
        Threads.checkMainThread();
        return this.mImageCaptureIoExecutor;
    }

    @MainThread
    public int getImageCaptureMode() {
        Threads.checkMainThread();
        return this.mImageCapture.getCaptureMode();
    }

    @Nullable
    @MainThread
    public OutputSize getImageCaptureTargetSize() {
        Threads.checkMainThread();
        return this.mImageCaptureTargetSize;
    }

    @Nullable
    @MainThread
    public OutputSize getPreviewTargetSize() {
        Threads.checkMainThread();
        return this.mPreviewTargetSize;
    }

    @NonNull
    @MainThread
    public LiveData<Integer> getTapToFocusState() {
        Threads.checkMainThread();
        return this.mTapToFocusState;
    }

    @NonNull
    @MainThread
    public LiveData<Integer> getTorchState() {
        Threads.checkMainThread();
        return this.mTorchState;
    }

    @NonNull
    @MainThread
    public QualitySelector getVideoCaptureQualitySelector() {
        Threads.checkMainThread();
        return this.mVideoCaptureQualitySelector;
    }

    @NonNull
    @MainThread
    public LiveData<ZoomState> getZoomState() {
        Threads.checkMainThread();
        return this.mZoomState;
    }

    @MainThread
    public boolean hasCamera(@NonNull CameraSelector cameraSelector) {
        Threads.checkMainThread();
        Preconditions.checkNotNull(cameraSelector);
        ProcessCameraProviderWrapper processCameraProviderWrapper = this.mCameraProvider;
        if (processCameraProviderWrapper != null) {
            try {
                return processCameraProviderWrapper.hasCamera(cameraSelector);
            } catch (CameraInfoUnavailableException e6) {
                Logger.w(TAG, "Failed to check camera availability", e6);
                return false;
            }
        }
        throw new IllegalStateException("Camera not initialized. Please wait for the initialization future to finish. See #getInitializationFuture().");
    }

    @MainThread
    public boolean isImageAnalysisEnabled() {
        Threads.checkMainThread();
        return isUseCaseEnabled(2);
    }

    @MainThread
    public boolean isImageCaptureEnabled() {
        Threads.checkMainThread();
        return isUseCaseEnabled(1);
    }

    @MainThread
    public boolean isPinchToZoomEnabled() {
        Threads.checkMainThread();
        return this.mPinchToZoomEnabled;
    }

    @MainThread
    public boolean isRecording() {
        Threads.checkMainThread();
        Recording recording = this.mActiveRecording;
        if (recording != null && !recording.isClosed()) {
            return true;
        }
        return false;
    }

    @MainThread
    public boolean isTapToFocusEnabled() {
        Threads.checkMainThread();
        return this.mTapToFocusEnabled;
    }

    @MainThread
    public boolean isVideoCaptureEnabled() {
        Threads.checkMainThread();
        return isUseCaseEnabled(4);
    }

    void onPinchToZoom(float f6) {
        if (!isCameraAttached()) {
            Logger.w(TAG, CAMERA_NOT_ATTACHED);
            return;
        }
        if (!this.mPinchToZoomEnabled) {
            Logger.d(TAG, "Pinch to zoom disabled.");
            return;
        }
        Logger.d(TAG, "Pinch to zoom with scale: " + f6);
        ZoomState value = getZoomState().getValue();
        if (value == null) {
            return;
        }
        setZoomRatio(Math.min(Math.max(value.getZoomRatio() * speedUpZoomBy2X(f6), value.getMinZoomRatio()), value.getMaxZoomRatio()));
    }

    void onTapToFocus(MeteringPointFactory meteringPointFactory, float f6, float f7) {
        if (!isCameraAttached()) {
            Logger.w(TAG, CAMERA_NOT_ATTACHED);
            return;
        }
        if (!this.mTapToFocusEnabled) {
            Logger.d(TAG, "Tap to focus disabled. ");
            return;
        }
        Logger.d(TAG, "Tap to focus started: " + f6 + ", " + f7);
        this.mTapToFocusState.postValue(1);
        Futures.addCallback(this.mCamera.getCameraControl().startFocusAndMetering(new FocusMeteringAction.Builder(meteringPointFactory.createPoint(f6, f7, AF_SIZE), 1).addPoint(meteringPointFactory.createPoint(f6, f7, 0.25f), 2).build()), new FutureCallback<FocusMeteringResult>() { // from class: androidx.camera.view.CameraController.2
            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onFailure(@NonNull Throwable th) {
                if (th instanceof CameraControl.OperationCanceledException) {
                    Logger.d(CameraController.TAG, "Tap-to-focus is canceled by new action.");
                } else {
                    Logger.d(CameraController.TAG, "Tap to focus failed.", th);
                    CameraController.this.mTapToFocusState.postValue(4);
                }
            }

            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onSuccess(@Nullable FocusMeteringResult focusMeteringResult) {
                if (focusMeteringResult == null) {
                    return;
                }
                Logger.d(CameraController.TAG, "Tap to focus onSuccess: " + focusMeteringResult.isFocusSuccessful());
                CameraController.this.mTapToFocusState.postValue(Integer.valueOf(focusMeteringResult.isFocusSuccessful() ? 2 : 3));
            }
        }, CameraXExecutors.directExecutor());
    }

    @MainThread
    public void setCameraSelector(@NonNull CameraSelector cameraSelector) {
        Threads.checkMainThread();
        final CameraSelector cameraSelector2 = this.mCameraSelector;
        if (cameraSelector2 != cameraSelector) {
            this.mCameraSelector = cameraSelector;
            ProcessCameraProviderWrapper processCameraProviderWrapper = this.mCameraProvider;
            if (processCameraProviderWrapper == null) {
                return;
            }
            processCameraProviderWrapper.unbind(this.mPreview, this.mImageCapture, this.mImageAnalysis, this.mVideoCapture);
            startCameraAndTrackStates(new Runnable() { // from class: androidx.camera.view.h
                @Override // java.lang.Runnable
                public final void run() {
                    CameraController.this.mCameraSelector = cameraSelector2;
                }
            });
        }
    }

    @MainThread
    public void setEffects(@NonNull Set<CameraEffect> set) {
        Threads.checkMainThread();
        if (Objects.equals(this.mEffects, set)) {
            return;
        }
        ProcessCameraProviderWrapper processCameraProviderWrapper = this.mCameraProvider;
        if (processCameraProviderWrapper != null) {
            processCameraProviderWrapper.unbindAll();
        }
        this.mEffects.clear();
        this.mEffects.addAll(set);
        startCameraAndTrackStates();
    }

    @MainThread
    public void setEnabledUseCases(int i6) {
        Threads.checkMainThread();
        final int i7 = this.mEnabledUseCases;
        if (i6 == i7) {
            return;
        }
        this.mEnabledUseCases = i6;
        if (!isVideoCaptureEnabled() && isRecording()) {
            stopRecording();
        }
        startCameraAndTrackStates(new Runnable() { // from class: androidx.camera.view.g
            @Override // java.lang.Runnable
            public final void run() {
                CameraController.this.mEnabledUseCases = i7;
            }
        });
    }

    @MainThread
    public void setImageAnalysisAnalyzer(@NonNull Executor executor, @NonNull ImageAnalysis.Analyzer analyzer) {
        Threads.checkMainThread();
        ImageAnalysis.Analyzer analyzer2 = this.mAnalysisAnalyzer;
        if (analyzer2 == analyzer && this.mAnalysisExecutor == executor) {
            return;
        }
        this.mAnalysisExecutor = executor;
        this.mAnalysisAnalyzer = analyzer;
        this.mImageAnalysis.setAnalyzer(executor, analyzer);
        restartCameraIfAnalyzerResolutionChanged(analyzer2, analyzer);
    }

    @MainThread
    public void setImageAnalysisBackgroundExecutor(@Nullable Executor executor) {
        Threads.checkMainThread();
        if (this.mAnalysisBackgroundExecutor == executor) {
            return;
        }
        this.mAnalysisBackgroundExecutor = executor;
        unbindImageAnalysisAndRecreate(this.mImageAnalysis.getBackpressureStrategy(), this.mImageAnalysis.getImageQueueDepth());
        startCameraAndTrackStates();
    }

    @MainThread
    public void setImageAnalysisBackpressureStrategy(int i6) {
        Threads.checkMainThread();
        if (this.mImageAnalysis.getBackpressureStrategy() == i6) {
            return;
        }
        unbindImageAnalysisAndRecreate(i6, this.mImageAnalysis.getImageQueueDepth());
        startCameraAndTrackStates();
    }

    @MainThread
    public void setImageAnalysisImageQueueDepth(int i6) {
        Threads.checkMainThread();
        if (this.mImageAnalysis.getImageQueueDepth() == i6) {
            return;
        }
        unbindImageAnalysisAndRecreate(this.mImageAnalysis.getBackpressureStrategy(), i6);
        startCameraAndTrackStates();
    }

    @MainThread
    public void setImageAnalysisTargetSize(@Nullable OutputSize outputSize) {
        Threads.checkMainThread();
        if (isOutputSizeEqual(this.mImageAnalysisTargetSize, outputSize)) {
            return;
        }
        this.mImageAnalysisTargetSize = outputSize;
        unbindImageAnalysisAndRecreate(this.mImageAnalysis.getBackpressureStrategy(), this.mImageAnalysis.getImageQueueDepth());
        startCameraAndTrackStates();
    }

    @MainThread
    public void setImageCaptureFlashMode(int i6) {
        Threads.checkMainThread();
        this.mImageCapture.setFlashMode(i6);
    }

    @MainThread
    public void setImageCaptureIoExecutor(@Nullable Executor executor) {
        Threads.checkMainThread();
        if (this.mImageCaptureIoExecutor == executor) {
            return;
        }
        this.mImageCaptureIoExecutor = executor;
        unbindImageCaptureAndRecreate(this.mImageCapture.getCaptureMode());
        startCameraAndTrackStates();
    }

    @MainThread
    public void setImageCaptureMode(int i6) {
        Threads.checkMainThread();
        if (this.mImageCapture.getCaptureMode() == i6) {
            return;
        }
        unbindImageCaptureAndRecreate(i6);
        startCameraAndTrackStates();
    }

    @MainThread
    public void setImageCaptureTargetSize(@Nullable OutputSize outputSize) {
        Threads.checkMainThread();
        if (isOutputSizeEqual(this.mImageCaptureTargetSize, outputSize)) {
            return;
        }
        this.mImageCaptureTargetSize = outputSize;
        unbindImageCaptureAndRecreate(getImageCaptureMode());
        startCameraAndTrackStates();
    }

    @NonNull
    @MainThread
    public ListenableFuture<Void> setLinearZoom(@FloatRange(from = 0.0d, to = 1.0d) float f6) {
        Threads.checkMainThread();
        if (!isCameraAttached()) {
            return this.mPendingLinearZoom.setValue(Float.valueOf(f6));
        }
        return this.mCamera.getCameraControl().setLinearZoom(f6);
    }

    @MainThread
    public void setPinchToZoomEnabled(boolean z5) {
        Threads.checkMainThread();
        this.mPinchToZoomEnabled = z5;
    }

    @MainThread
    public void setPreviewTargetSize(@Nullable OutputSize outputSize) {
        Threads.checkMainThread();
        if (isOutputSizeEqual(this.mPreviewTargetSize, outputSize)) {
            return;
        }
        this.mPreviewTargetSize = outputSize;
        unbindPreviewAndRecreate();
        startCameraAndTrackStates();
    }

    @MainThread
    public void setTapToFocusEnabled(boolean z5) {
        Threads.checkMainThread();
        this.mTapToFocusEnabled = z5;
    }

    @MainThread
    public void setVideoCaptureQualitySelector(@NonNull QualitySelector qualitySelector) {
        Threads.checkMainThread();
        this.mVideoCaptureQualitySelector = qualitySelector;
        unbindVideoAndRecreate();
        startCameraAndTrackStates();
    }

    @NonNull
    @MainThread
    public ListenableFuture<Void> setZoomRatio(float f6) {
        Threads.checkMainThread();
        if (!isCameraAttached()) {
            return this.mPendingZoomRatio.setValue(Float.valueOf(f6));
        }
        return this.mCamera.getCameraControl().setZoomRatio(f6);
    }

    @NonNull
    @SuppressLint({"MissingPermission"})
    @MainThread
    public Recording startRecording(@NonNull MediaStoreOutputOptions mediaStoreOutputOptions, @NonNull AudioConfig audioConfig, @NonNull Executor executor, @NonNull Consumer<VideoRecordEvent> consumer) {
        return startRecordingInternal(mediaStoreOutputOptions, audioConfig, executor, consumer);
    }

    @OptIn(markerClass = {TransformExperimental.class})
    @MainThread
    void updatePreviewViewTransform(@Nullable Matrix matrix) {
        Threads.checkMainThread();
        ImageAnalysis.Analyzer analyzer = this.mAnalysisAnalyzer;
        if (analyzer != null && analyzer.getTargetCoordinateSystem() == 1) {
            this.mAnalysisAnalyzer.updateTransform(matrix);
        }
    }

    CameraController(@NonNull Context context, @NonNull ListenableFuture<ProcessCameraProviderWrapper> listenableFuture) {
        this.mCameraSelector = CameraSelector.DEFAULT_BACK_CAMERA;
        this.mEnabledUseCases = 3;
        this.mActiveRecording = null;
        this.mRecordingMap = new HashMap();
        this.mVideoCaptureQualitySelector = Recorder.DEFAULT_QUALITY_SELECTOR;
        this.mPinchToZoomEnabled = true;
        this.mTapToFocusEnabled = true;
        this.mZoomState = new ForwardingLiveData<>();
        this.mTorchState = new ForwardingLiveData<>();
        this.mTapToFocusState = new MutableLiveData<>(0);
        this.mPendingEnableTorch = new PendingValue<>();
        this.mPendingLinearZoom = new PendingValue<>();
        this.mPendingZoomRatio = new PendingValue<>();
        this.mEffects = new HashSet();
        Context applicationContext = getApplicationContext(context);
        this.mAppContext = applicationContext;
        this.mPreview = new Preview.Builder().build();
        this.mImageCapture = new ImageCapture.Builder().build();
        this.mImageAnalysis = new ImageAnalysis.Builder().build();
        this.mVideoCapture = createNewVideoCapture();
        this.mInitializationFuture = Futures.transform(listenableFuture, new Function() { // from class: androidx.camera.view.d
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return CameraController.a(CameraController.this, (ProcessCameraProviderWrapper) obj);
            }
        }, CameraXExecutors.mainThreadExecutor());
        this.mRotationProvider = new RotationProvider(applicationContext);
        this.mDeviceRotationListener = new RotationProvider.Listener() { // from class: androidx.camera.view.e
            @Override // androidx.camera.view.RotationProvider.Listener
            public final void onRotationChanged(int i6) {
                CameraController.b(CameraController.this, i6);
            }
        };
    }

    @MainThread
    public void takePicture(@NonNull Executor executor, @NonNull ImageCapture.OnImageCapturedCallback onImageCapturedCallback) {
        Threads.checkMainThread();
        Preconditions.checkState(isCameraInitialized(), CAMERA_NOT_INITIALIZED);
        Preconditions.checkState(isImageCaptureEnabled(), IMAGE_CAPTURE_DISABLED);
        this.mImageCapture.takePicture(executor, onImageCapturedCallback);
    }
}
