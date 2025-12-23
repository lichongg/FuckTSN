package androidx.camera.core.imagecapture;

import android.util.Size;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.camera.core.CameraEffect;
import androidx.camera.core.CaptureBundles;
import androidx.camera.core.ForwardingImageProxy;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.MetadataImageReader;
import androidx.camera.core.imagecapture.CaptureNode;
import androidx.camera.core.impl.CaptureBundle;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.CaptureStage;
import androidx.camera.core.impl.ImageCaptureConfig;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.internal.compat.workaround.ExifRotationAvailability;
import androidx.camera.core.processing.InternalImageProcessor;
import androidx.core.util.Pair;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(api = 21)
/* loaded from: D:\Downloads\app\classes.dex */
public class ImagePipeline {
    static final ExifRotationAvailability EXIF_ROTATION_AVAILABILITY = new ExifRotationAvailability();
    static final byte JPEG_QUALITY_MAX_QUALITY = 100;
    static final byte JPEG_QUALITY_MIN_LATENCY = 95;

    @NonNull
    private final SingleBundlingNode mBundlingNode;

    @NonNull
    private final CaptureConfig mCaptureConfig;

    @NonNull
    private final CaptureNode mCaptureNode;

    @NonNull
    private final CaptureNode.In mPipelineIn;

    @NonNull
    private final ProcessingNode mProcessingNode;

    @NonNull
    private final ImageCaptureConfig mUseCaseConfig;

    @MainThread
    @VisibleForTesting
    public ImagePipeline(@NonNull ImageCaptureConfig imageCaptureConfig, @NonNull Size size) {
        this(imageCaptureConfig, size, null, false);
    }

    @MainThread
    public ImagePipeline(@NonNull ImageCaptureConfig imageCaptureConfig, @NonNull Size size, @Nullable CameraEffect cameraEffect, boolean z5) {
        Threads.checkMainThread();
        this.mUseCaseConfig = imageCaptureConfig;
        this.mCaptureConfig = CaptureConfig.Builder.createFrom(imageCaptureConfig).build();
        CaptureNode captureNode = new CaptureNode();
        this.mCaptureNode = captureNode;
        SingleBundlingNode singleBundlingNode = new SingleBundlingNode();
        this.mBundlingNode = singleBundlingNode;
        Executor ioExecutor = imageCaptureConfig.getIoExecutor(CameraXExecutors.ioExecutor());
        Objects.requireNonNull(ioExecutor);
        ProcessingNode processingNode = new ProcessingNode(ioExecutor, cameraEffect != null ? new InternalImageProcessor(cameraEffect) : null);
        this.mProcessingNode = processingNode;
        CaptureNode.In of = CaptureNode.In.of(size, imageCaptureConfig.getInputFormat(), getOutputFormat(), z5, imageCaptureConfig.getImageReaderProxyProvider());
        this.mPipelineIn = of;
        processingNode.transform(singleBundlingNode.transform(captureNode.transform(of)));
    }

    private CameraRequest createCameraRequest(@NonNull CaptureBundle captureBundle, @NonNull TakePictureRequest takePictureRequest, @NonNull TakePictureCallback takePictureCallback) {
        ArrayList arrayList = new ArrayList();
        String valueOf = String.valueOf(captureBundle.hashCode());
        List<CaptureStage> captureStages = captureBundle.getCaptureStages();
        Objects.requireNonNull(captureStages);
        for (CaptureStage captureStage : captureStages) {
            CaptureConfig.Builder builder = new CaptureConfig.Builder();
            builder.setTemplateType(this.mCaptureConfig.getTemplateType());
            builder.addImplementationOptions(this.mCaptureConfig.getImplementationOptions());
            builder.addAllCameraCaptureCallbacks(takePictureRequest.getSessionConfigCameraCaptureCallbacks());
            builder.addSurface(this.mPipelineIn.getSurface());
            if (this.mPipelineIn.getInputFormat() == 256) {
                if (EXIF_ROTATION_AVAILABILITY.isRotationOptionSupported()) {
                    builder.addImplementationOption(CaptureConfig.OPTION_ROTATION, Integer.valueOf(takePictureRequest.getRotationDegrees()));
                }
                builder.addImplementationOption(CaptureConfig.OPTION_JPEG_QUALITY, Integer.valueOf(getCameraRequestJpegQuality(takePictureRequest)));
            }
            builder.addImplementationOptions(captureStage.getCaptureConfig().getImplementationOptions());
            builder.addTag(valueOf, Integer.valueOf(captureStage.getId()));
            builder.addCameraCaptureCallback(this.mPipelineIn.getCameraCaptureCallback());
            arrayList.add(builder.build());
        }
        return new CameraRequest(arrayList, takePictureCallback);
    }

    @NonNull
    private CaptureBundle createCaptureBundle() {
        CaptureBundle captureBundle = this.mUseCaseConfig.getCaptureBundle(CaptureBundles.singleDefaultCaptureBundle());
        Objects.requireNonNull(captureBundle);
        return captureBundle;
    }

    @NonNull
    private ProcessingRequest createProcessingRequest(@NonNull CaptureBundle captureBundle, @NonNull TakePictureRequest takePictureRequest, @NonNull TakePictureCallback takePictureCallback, @NonNull ListenableFuture<Void> listenableFuture) {
        return new ProcessingRequest(captureBundle, takePictureRequest.getOutputFileOptions(), takePictureRequest.getCropRect(), takePictureRequest.getRotationDegrees(), takePictureRequest.getJpegQuality(), takePictureRequest.getSensorToBufferTransform(), takePictureCallback, listenableFuture);
    }

    private int getOutputFormat() {
        Integer num = (Integer) this.mUseCaseConfig.retrieveOption(ImageCaptureConfig.OPTION_BUFFER_FORMAT, null);
        if (num != null) {
            return num.intValue();
        }
        return 256;
    }

    @NonNull
    public SessionConfig.Builder createSessionConfigBuilder(@NonNull Size size) {
        SessionConfig.Builder createFrom = SessionConfig.Builder.createFrom(this.mUseCaseConfig, size);
        createFrom.addNonRepeatingSurface(this.mPipelineIn.getSurface());
        return createFrom;
    }

    @VisibleForTesting
    public boolean expectsMetadata() {
        return this.mCaptureNode.getSafeCloseImageReaderProxy().getImageReaderProxy() instanceof MetadataImageReader;
    }

    @NonNull
    @VisibleForTesting
    CaptureNode getCaptureNode() {
        return this.mCaptureNode;
    }

    @NonNull
    @VisibleForTesting
    ProcessingNode getProcessingNode() {
        return this.mProcessingNode;
    }

    @MainThread
    public void close() {
        Threads.checkMainThread();
        this.mCaptureNode.release();
        this.mBundlingNode.release();
        this.mProcessingNode.release();
    }

    @NonNull
    @MainThread
    Pair<CameraRequest, ProcessingRequest> createRequests(@NonNull TakePictureRequest takePictureRequest, @NonNull TakePictureCallback takePictureCallback, @NonNull ListenableFuture<Void> listenableFuture) {
        Threads.checkMainThread();
        CaptureBundle createCaptureBundle = createCaptureBundle();
        return new Pair<>(createCameraRequest(createCaptureBundle, takePictureRequest, takePictureCallback), createProcessingRequest(createCaptureBundle, takePictureRequest, takePictureCallback, listenableFuture));
    }

    int getCameraRequestJpegQuality(@NonNull TakePictureRequest takePictureRequest) {
        boolean z5;
        if (takePictureRequest.getOnDiskCallback() != null) {
            z5 = true;
        } else {
            z5 = false;
        }
        boolean hasCropping = TransformUtils.hasCropping(takePictureRequest.getCropRect(), this.mPipelineIn.getSize());
        if (z5 && hasCropping) {
            if (takePictureRequest.getCaptureMode() == 0) {
                return 100;
            }
            return 95;
        }
        return takePictureRequest.getJpegQuality();
    }

    @MainThread
    public int getCapacity() {
        Threads.checkMainThread();
        return this.mCaptureNode.getCapacity();
    }

    @MainThread
    void notifyCaptureError(@NonNull ImageCaptureException imageCaptureException) {
        Threads.checkMainThread();
        this.mPipelineIn.getErrorEdge().accept(imageCaptureException);
    }

    @MainThread
    public void setOnImageCloseListener(@NonNull ForwardingImageProxy.OnImageCloseListener onImageCloseListener) {
        Threads.checkMainThread();
        this.mCaptureNode.setOnImageCloseListener(onImageCloseListener);
    }

    @MainThread
    void submitProcessingRequest(@NonNull ProcessingRequest processingRequest) {
        Threads.checkMainThread();
        this.mPipelineIn.getRequestEdge().accept(processingRequest);
    }
}
