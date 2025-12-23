package androidx.camera.core.processing;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.CameraEffect;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProcessor;
import androidx.camera.core.ProcessingException;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import java.util.Objects;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(api = 21)
/* loaded from: D:\Downloads\app\classes.dex */
public class InternalImageProcessor {

    @NonNull
    private final Consumer<Throwable> mErrorListener;

    @NonNull
    private final Executor mExecutor;

    @NonNull
    private final ImageProcessor mImageProcessor;

    public static /* synthetic */ Object a(final InternalImageProcessor internalImageProcessor, final ImageProcessor.Request request, final CallbackToFutureAdapter.Completer completer) {
        internalImageProcessor.mExecutor.execute(new Runnable() { // from class: androidx.camera.core.processing.p
            @Override // java.lang.Runnable
            public final void run() {
                InternalImageProcessor.b(InternalImageProcessor.this, request, completer);
            }
        });
        return "InternalImageProcessor#process " + request.hashCode();
    }

    @NonNull
    public ImageProcessor.Response safeProcess(@NonNull final ImageProcessor.Request request) throws ImageCaptureException {
        try {
            return (ImageProcessor.Response) CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.core.processing.q
                @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                    return InternalImageProcessor.a(InternalImageProcessor.this, request, completer);
                }
            }).get();
        } catch (Exception e6) {
            e = e6;
            if (e.getCause() != null) {
                e = e.getCause();
            }
            throw new ImageCaptureException(0, "Failed to invoke ImageProcessor.", e);
        }
    }

    public InternalImageProcessor(@NonNull CameraEffect cameraEffect) {
        boolean z5;
        if (cameraEffect.getTargets() == 4) {
            z5 = true;
        } else {
            z5 = false;
        }
        Preconditions.checkArgument(z5);
        this.mExecutor = cameraEffect.getExecutor();
        ImageProcessor imageProcessor = cameraEffect.getImageProcessor();
        Objects.requireNonNull(imageProcessor);
        this.mImageProcessor = imageProcessor;
        this.mErrorListener = cameraEffect.getErrorListener();
    }

    public static /* synthetic */ void b(InternalImageProcessor internalImageProcessor, ImageProcessor.Request request, CallbackToFutureAdapter.Completer completer) {
        internalImageProcessor.getClass();
        try {
            completer.set(internalImageProcessor.mImageProcessor.process(request));
        } catch (ProcessingException e6) {
            internalImageProcessor.mErrorListener.accept(e6);
            completer.setException(e6);
        }
    }
}
