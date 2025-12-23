package androidx.camera.core.imagecapture;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.imagecapture.Bitmap2JpegBytes;
import androidx.camera.core.imagecapture.Image2JpegBytes;
import androidx.camera.core.imagecapture.JpegBytes2Disk;
import androidx.camera.core.imagecapture.ProcessingNode;
import androidx.camera.core.impl.Quirks;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.internal.compat.quirk.DeviceQuirks;
import androidx.camera.core.internal.compat.quirk.IncorrectJpegMetadataQuirk;
import androidx.camera.core.internal.compat.quirk.LowMemoryQuirk;
import androidx.camera.core.processing.Edge;
import androidx.camera.core.processing.InternalImageProcessor;
import androidx.camera.core.processing.Node;
import androidx.camera.core.processing.Operation;
import androidx.camera.core.processing.Packet;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import com.google.auto.value.AutoValue;
import java.util.Objects;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(api = 21)
/* loaded from: D:\Downloads\app\classes.dex */
public class ProcessingNode implements Node<In, Void> {
    private Operation<Bitmap2JpegBytes.In, Packet<byte[]>> mBitmap2JpegBytes;
    private Operation<Packet<Bitmap>, Packet<Bitmap>> mBitmapEffect;

    @NonNull
    final Executor mBlockingExecutor;
    private final boolean mHasIncorrectJpegMetadataQuirk;
    private Operation<Image2JpegBytes.In, Packet<byte[]>> mImage2JpegBytes;

    @Nullable
    final InternalImageProcessor mImageProcessor;
    private Operation<InputPacket, Packet<ImageProxy>> mInput2Packet;
    private In mInputEdge;
    private Operation<Packet<byte[]>, Packet<Bitmap>> mJpegBytes2CroppedBitmap;
    private Operation<JpegBytes2Disk.In, ImageCapture.OutputFileResults> mJpegBytes2Disk;
    private Operation<Packet<byte[]>, Packet<ImageProxy>> mJpegBytes2Image;
    private Operation<Packet<ImageProxy>, ImageProxy> mJpegImage2Result;
    private final Quirks mQuirks;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @AutoValue
    static abstract class In {
        abstract Edge<InputPacket> getEdge();

        abstract int getInputFormat();

        abstract int getOutputFormat();

        static In of(int i6, int i7) {
            return new AutoValue_ProcessingNode_In(new Edge(), i6, i7);
        }

        In() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @AutoValue
    static abstract class InputPacket {
        @NonNull
        abstract ImageProxy getImageProxy();

        @NonNull
        abstract ProcessingRequest getProcessingRequest();

        static InputPacket of(@NonNull ProcessingRequest processingRequest, @NonNull ImageProxy imageProxy) {
            return new AutoValue_ProcessingNode_InputPacket(processingRequest, imageProxy);
        }

        InputPacket() {
        }
    }

    @VisibleForTesting
    ProcessingNode(@NonNull Executor executor) {
        this(executor, null, DeviceQuirks.getAll());
    }

    @VisibleForTesting
    ProcessingNode(@NonNull Executor executor, @NonNull Quirks quirks) {
        this(executor, null, quirks);
    }

    @VisibleForTesting
    void injectProcessingInput2Packet(@NonNull Operation<InputPacket, Packet<ImageProxy>> operation) {
        this.mInput2Packet = operation;
    }

    @NonNull
    @WorkerThread
    ImageCapture.OutputFileResults processOnDiskCapture(@NonNull InputPacket inputPacket) throws ImageCaptureException {
        Preconditions.checkArgument(this.mInputEdge.getOutputFormat() == 256, String.format("On-disk capture only support JPEG output format. Output format: %s", Integer.valueOf(this.mInputEdge.getOutputFormat())));
        ProcessingRequest processingRequest = inputPacket.getProcessingRequest();
        Packet<byte[]> apply = this.mImage2JpegBytes.apply(Image2JpegBytes.In.of(this.mInput2Packet.apply(inputPacket), processingRequest.getJpegQuality()));
        if (apply.hasCropping() || this.mBitmapEffect != null) {
            apply = cropAndMaybeApplyEffect(apply, processingRequest.getJpegQuality());
        }
        Operation<JpegBytes2Disk.In, ImageCapture.OutputFileResults> operation = this.mJpegBytes2Disk;
        ImageCapture.OutputFileOptions outputFileOptions = processingRequest.getOutputFileOptions();
        Objects.requireNonNull(outputFileOptions);
        return operation.apply(JpegBytes2Disk.In.of(apply, outputFileOptions));
    }

    @Override // androidx.camera.core.processing.Node
    @NonNull
    public Void transform(@NonNull In in) {
        this.mInputEdge = in;
        in.getEdge().setListener(new Consumer() { // from class: androidx.camera.core.imagecapture.f
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                ProcessingNode.a(ProcessingNode.this, (ProcessingNode.InputPacket) obj);
            }
        });
        this.mInput2Packet = new ProcessingInput2Packet();
        this.mImage2JpegBytes = new Image2JpegBytes(this.mQuirks);
        this.mJpegBytes2CroppedBitmap = new JpegBytes2CroppedBitmap();
        this.mBitmap2JpegBytes = new Bitmap2JpegBytes();
        this.mJpegBytes2Disk = new JpegBytes2Disk();
        this.mJpegImage2Result = new JpegImage2Result();
        if (in.getInputFormat() == 35 || this.mImageProcessor != null || this.mHasIncorrectJpegMetadataQuirk) {
            this.mJpegBytes2Image = new JpegBytes2Image();
        }
        InternalImageProcessor internalImageProcessor = this.mImageProcessor;
        if (internalImageProcessor == null) {
            return null;
        }
        this.mBitmapEffect = new BitmapEffect(internalImageProcessor);
        return null;
    }

    ProcessingNode(@NonNull Executor executor, @Nullable InternalImageProcessor internalImageProcessor) {
        this(executor, internalImageProcessor, DeviceQuirks.getAll());
    }

    public static /* synthetic */ void a(final ProcessingNode processingNode, final InputPacket inputPacket) {
        processingNode.getClass();
        if (inputPacket.getProcessingRequest().isAborted()) {
            return;
        }
        processingNode.mBlockingExecutor.execute(new Runnable() { // from class: androidx.camera.core.imagecapture.j
            @Override // java.lang.Runnable
            public final void run() {
                ProcessingNode.this.processInputPacket(inputPacket);
            }
        });
    }

    private Packet<byte[]> cropAndMaybeApplyEffect(Packet<byte[]> packet, int i6) throws ImageCaptureException {
        boolean z5;
        if (packet.getFormat() == 256) {
            z5 = true;
        } else {
            z5 = false;
        }
        Preconditions.checkState(z5);
        Packet<Bitmap> apply = this.mJpegBytes2CroppedBitmap.apply(packet);
        Operation<Packet<Bitmap>, Packet<Bitmap>> operation = this.mBitmapEffect;
        if (operation != null) {
            apply = operation.apply(apply);
        }
        return this.mBitmap2JpegBytes.apply(Bitmap2JpegBytes.In.of(apply, i6));
    }

    private static void sendError(@NonNull final ProcessingRequest processingRequest, @NonNull final ImageCaptureException imageCaptureException) {
        CameraXExecutors.mainThreadExecutor().execute(new Runnable() { // from class: androidx.camera.core.imagecapture.g
            @Override // java.lang.Runnable
            public final void run() {
                ProcessingRequest.this.onProcessFailure(imageCaptureException);
            }
        });
    }

    @NonNull
    @WorkerThread
    ImageProxy processInMemoryCapture(@NonNull InputPacket inputPacket) throws ImageCaptureException {
        ProcessingRequest processingRequest = inputPacket.getProcessingRequest();
        Packet<ImageProxy> apply = this.mInput2Packet.apply(inputPacket);
        if ((apply.getFormat() == 35 || this.mBitmapEffect != null || this.mHasIncorrectJpegMetadataQuirk) && this.mInputEdge.getOutputFormat() == 256) {
            Packet<byte[]> apply2 = this.mImage2JpegBytes.apply(Image2JpegBytes.In.of(apply, processingRequest.getJpegQuality()));
            if (this.mBitmapEffect != null) {
                apply2 = cropAndMaybeApplyEffect(apply2, processingRequest.getJpegQuality());
            }
            apply = this.mJpegBytes2Image.apply(apply2);
        }
        return this.mJpegImage2Result.apply(apply);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public void processInputPacket(@NonNull InputPacket inputPacket) {
        final ProcessingRequest processingRequest = inputPacket.getProcessingRequest();
        try {
            if (inputPacket.getProcessingRequest().isInMemoryCapture()) {
                final ImageProxy processInMemoryCapture = processInMemoryCapture(inputPacket);
                CameraXExecutors.mainThreadExecutor().execute(new Runnable() { // from class: androidx.camera.core.imagecapture.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        ProcessingRequest.this.onFinalResult(processInMemoryCapture);
                    }
                });
            } else {
                final ImageCapture.OutputFileResults processOnDiskCapture = processOnDiskCapture(inputPacket);
                CameraXExecutors.mainThreadExecutor().execute(new Runnable() { // from class: androidx.camera.core.imagecapture.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        ProcessingRequest.this.onFinalResult(processOnDiskCapture);
                    }
                });
            }
        } catch (ImageCaptureException e6) {
            sendError(processingRequest, e6);
        } catch (OutOfMemoryError e7) {
            sendError(processingRequest, new ImageCaptureException(0, "Processing failed due to low memory.", e7));
        } catch (RuntimeException e8) {
            sendError(processingRequest, new ImageCaptureException(0, "Processing failed.", e8));
        }
    }

    ProcessingNode(@NonNull Executor executor, @Nullable InternalImageProcessor internalImageProcessor, @NonNull Quirks quirks) {
        if (DeviceQuirks.get(LowMemoryQuirk.class) != null) {
            this.mBlockingExecutor = CameraXExecutors.newSequentialExecutor(executor);
        } else {
            this.mBlockingExecutor = executor;
        }
        this.mImageProcessor = internalImageProcessor;
        this.mQuirks = quirks;
        this.mHasIncorrectJpegMetadataQuirk = quirks.contains(IncorrectJpegMetadataQuirk.class);
    }

    @Override // androidx.camera.core.processing.Node
    public void release() {
    }
}
