package androidx.camera.core.processing;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.Matrix;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Size;
import android.view.Surface;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.arch.core.util.Function;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.ImageProcessingUtil;
import androidx.camera.core.Logger;
import androidx.camera.core.SurfaceOutput;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.utils.MatrixExt;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import com.beizi.fusion.widget.TwistView;
import com.google.auto.value.AutoValue;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Triple;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public class DefaultSurfaceProcessor implements SurfaceProcessorInternal, SurfaceTexture.OnFrameAvailableListener {
    private static final String TAG = "DefaultSurfaceProcessor";
    private final Executor mGlExecutor;

    @VisibleForTesting
    final Handler mGlHandler;
    private final OpenGlRenderer mGlRenderer;

    @VisibleForTesting
    final HandlerThread mGlThread;
    private int mInputSurfaceCount;
    private final AtomicBoolean mIsReleaseRequested;
    private boolean mIsReleased;
    final Map<SurfaceOutput, Surface> mOutputSurfaces;
    private final List<PendingSnapshot> mPendingSnapshots;
    private final float[] mSurfaceOutputMatrix;
    private final float[] mTextureMatrix;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Factory {
        private static Function<DynamicRange, SurfaceProcessorInternal> sSupplier = new Function() { // from class: androidx.camera.core.processing.o
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return new DefaultSurfaceProcessor((DynamicRange) obj);
            }
        };

        @NonNull
        public static SurfaceProcessorInternal newInstance(@NonNull DynamicRange dynamicRange) {
            return sSupplier.apply(dynamicRange);
        }

        @VisibleForTesting
        public static void setSupplier(@NonNull Function<DynamicRange, SurfaceProcessorInternal> function) {
            sSupplier = function;
        }

        private Factory() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @AutoValue
    static abstract class PendingSnapshot {
        @NonNull
        abstract CallbackToFutureAdapter.Completer<Void> getCompleter();

        @IntRange(from = 0, to = TwistView.DELAY_TIME_TWIST)
        abstract int getJpegQuality();

        @IntRange(from = 0, to = 359)
        abstract int getRotationDegrees();

        @NonNull
        static AutoValue_DefaultSurfaceProcessor_PendingSnapshot of(@IntRange(from = 0, to = 100) int i6, @IntRange(from = 0, to = 359) int i7, @NonNull CallbackToFutureAdapter.Completer<Void> completer) {
            return new AutoValue_DefaultSurfaceProcessor_PendingSnapshot(i6, i7, completer);
        }

        PendingSnapshot() {
        }
    }

    DefaultSurfaceProcessor(@NonNull DynamicRange dynamicRange) {
        this(dynamicRange, ShaderProvider.DEFAULT);
    }

    private void executeSafely(@NonNull Runnable runnable) {
        executeSafely(runnable, new Runnable() { // from class: androidx.camera.core.processing.h
            @Override // java.lang.Runnable
            public final void run() {
                DefaultSurfaceProcessor.a();
            }
        });
    }

    public static /* synthetic */ void h(DefaultSurfaceProcessor defaultSurfaceProcessor) {
        defaultSurfaceProcessor.mIsReleased = true;
        defaultSurfaceProcessor.checkReadyToRelease();
    }

    DefaultSurfaceProcessor(@NonNull DynamicRange dynamicRange, @NonNull ShaderProvider shaderProvider) {
        this.mIsReleaseRequested = new AtomicBoolean(false);
        this.mTextureMatrix = new float[16];
        this.mSurfaceOutputMatrix = new float[16];
        this.mOutputSurfaces = new LinkedHashMap();
        this.mInputSurfaceCount = 0;
        this.mIsReleased = false;
        this.mPendingSnapshots = new ArrayList();
        HandlerThread handlerThread = new HandlerThread("GL Thread");
        this.mGlThread = handlerThread;
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        this.mGlHandler = handler;
        this.mGlExecutor = CameraXExecutors.newHandlerExecutor(handler);
        this.mGlRenderer = new OpenGlRenderer();
        try {
            initGlRenderer(dynamicRange, shaderProvider);
        } catch (RuntimeException e6) {
            release();
            throw e6;
        }
    }

    @WorkerThread
    private void checkReadyToRelease() {
        if (this.mIsReleased && this.mInputSurfaceCount == 0) {
            Iterator<SurfaceOutput> it = this.mOutputSurfaces.keySet().iterator();
            while (it.hasNext()) {
                it.next().close();
            }
            Iterator<PendingSnapshot> it2 = this.mPendingSnapshots.iterator();
            while (it2.hasNext()) {
                it2.next().getCompleter().setException(new Exception("Failed to snapshot: DefaultSurfaceProcessor is released."));
            }
            this.mOutputSurfaces.clear();
            this.mGlRenderer.release();
            this.mGlThread.quit();
        }
    }

    public static /* synthetic */ void d(final DefaultSurfaceProcessor defaultSurfaceProcessor, SurfaceRequest surfaceRequest) {
        defaultSurfaceProcessor.mInputSurfaceCount++;
        final SurfaceTexture surfaceTexture = new SurfaceTexture(defaultSurfaceProcessor.mGlRenderer.getTextureName());
        surfaceTexture.setDefaultBufferSize(surfaceRequest.getResolution().getWidth(), surfaceRequest.getResolution().getHeight());
        final Surface surface = new Surface(surfaceTexture);
        surfaceRequest.provideSurface(surface, defaultSurfaceProcessor.mGlExecutor, new Consumer() { // from class: androidx.camera.core.processing.m
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                DefaultSurfaceProcessor.j(DefaultSurfaceProcessor.this, surfaceTexture, surface, (SurfaceRequest.Result) obj);
            }
        });
        surfaceTexture.setOnFrameAvailableListener(defaultSurfaceProcessor, defaultSurfaceProcessor.mGlHandler);
    }

    private void executeSafely(@NonNull final Runnable runnable, @NonNull final Runnable runnable2) {
        try {
            this.mGlExecutor.execute(new Runnable() { // from class: androidx.camera.core.processing.k
                @Override // java.lang.Runnable
                public final void run() {
                    DefaultSurfaceProcessor.l(DefaultSurfaceProcessor.this, runnable2, runnable);
                }
            });
        } catch (RejectedExecutionException e6) {
            Logger.w(TAG, "Unable to executor runnable", e6);
            runnable2.run();
        }
    }

    private void failAllPendingSnapshots(@NonNull Throwable th) {
        Iterator<PendingSnapshot> it = this.mPendingSnapshots.iterator();
        while (it.hasNext()) {
            it.next().getCompleter().setException(th);
        }
        this.mPendingSnapshots.clear();
    }

    @NonNull
    private Bitmap getBitmap(@NonNull Size size, @NonNull float[] fArr, int i6) {
        float[] fArr2 = new float[16];
        Matrix.setIdentityM(fArr2, 0);
        MatrixExt.preVerticalFlip(fArr2, 0.5f);
        MatrixExt.preRotate(fArr2, i6, 0.5f, 0.5f);
        Matrix.multiplyMM(fArr2, 0, fArr2, 0, fArr, 0);
        return this.mGlRenderer.snapshot(TransformUtils.rotateSize(size, i6), fArr2);
    }

    private void initGlRenderer(@NonNull final DynamicRange dynamicRange, @NonNull final ShaderProvider shaderProvider) {
        try {
            CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.core.processing.b
                @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                    return DefaultSurfaceProcessor.g(DefaultSurfaceProcessor.this, dynamicRange, shaderProvider, completer);
                }
            }).get();
        } catch (InterruptedException | ExecutionException e6) {
            e = e6;
            if (e instanceof ExecutionException) {
                e = e.getCause();
            }
            if (!(e instanceof RuntimeException)) {
                throw new IllegalStateException("Failed to create DefaultSurfaceProcessor", e);
            }
            throw ((RuntimeException) e);
        }
    }

    public static /* synthetic */ void k(final DefaultSurfaceProcessor defaultSurfaceProcessor, final SurfaceOutput surfaceOutput) {
        Surface surface = surfaceOutput.getSurface(defaultSurfaceProcessor.mGlExecutor, new Consumer() { // from class: androidx.camera.core.processing.a
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                DefaultSurfaceProcessor.c(DefaultSurfaceProcessor.this, surfaceOutput, (SurfaceOutput.Event) obj);
            }
        });
        defaultSurfaceProcessor.mGlRenderer.registerOutputSurface(surface);
        defaultSurfaceProcessor.mOutputSurfaces.put(surfaceOutput, surface);
    }

    public static /* synthetic */ void l(DefaultSurfaceProcessor defaultSurfaceProcessor, Runnable runnable, Runnable runnable2) {
        if (defaultSurfaceProcessor.mIsReleased) {
            runnable.run();
        } else {
            runnable2.run();
        }
    }

    @WorkerThread
    private void takeSnapshotAndDrawJpeg(@Nullable Triple<Surface, Size, float[]> triple) {
        if (this.mPendingSnapshots.isEmpty()) {
            return;
        }
        if (triple == null) {
            failAllPendingSnapshots(new Exception("Failed to snapshot: no JPEG Surface."));
            return;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                Iterator<PendingSnapshot> it = this.mPendingSnapshots.iterator();
                Bitmap bitmap = null;
                byte[] bArr = null;
                int i6 = -1;
                int i7 = -1;
                while (it.hasNext()) {
                    PendingSnapshot next = it.next();
                    if (i6 != next.getRotationDegrees() || bitmap == null) {
                        i6 = next.getRotationDegrees();
                        if (bitmap != null) {
                            bitmap.recycle();
                        }
                        bitmap = getBitmap(triple.getSecond(), triple.getThird(), i6);
                        i7 = -1;
                    }
                    if (i7 != next.getJpegQuality()) {
                        byteArrayOutputStream.reset();
                        i7 = next.getJpegQuality();
                        bitmap.compress(Bitmap.CompressFormat.JPEG, i7, byteArrayOutputStream);
                        bArr = byteArrayOutputStream.toByteArray();
                    }
                    Surface first = triple.getFirst();
                    Objects.requireNonNull(bArr);
                    ImageProcessingUtil.writeJpegBytesToSurface(first, bArr);
                    next.getCompleter().set(null);
                    it.remove();
                }
                byteArrayOutputStream.close();
            } finally {
            }
        } catch (IOException e6) {
            failAllPendingSnapshots(e6);
        }
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(@NonNull SurfaceTexture surfaceTexture) {
        if (this.mIsReleaseRequested.get()) {
            return;
        }
        surfaceTexture.updateTexImage();
        surfaceTexture.getTransformMatrix(this.mTextureMatrix);
        Triple<Surface, Size, float[]> triple = null;
        for (Map.Entry<SurfaceOutput, Surface> entry : this.mOutputSurfaces.entrySet()) {
            Surface value = entry.getValue();
            SurfaceOutput key = entry.getKey();
            key.updateTransformMatrix(this.mSurfaceOutputMatrix, this.mTextureMatrix);
            if (key.getFormat() == 34) {
                try {
                    this.mGlRenderer.render(surfaceTexture.getTimestamp(), this.mSurfaceOutputMatrix, value);
                } catch (RuntimeException e6) {
                    Logger.e(TAG, "Failed to render with OpenGL.", e6);
                }
            } else {
                Preconditions.checkState(key.getFormat() == 256, "Unsupported format: " + key.getFormat());
                Preconditions.checkState(triple == null, "Only one JPEG output is supported.");
                triple = new Triple<>(value, key.getSize(), (float[]) this.mSurfaceOutputMatrix.clone());
            }
        }
        try {
            takeSnapshotAndDrawJpeg(triple);
        } catch (RuntimeException e7) {
            failAllPendingSnapshots(e7);
        }
    }

    @Override // androidx.camera.core.SurfaceProcessor
    public void onInputSurface(@NonNull final SurfaceRequest surfaceRequest) {
        if (this.mIsReleaseRequested.get()) {
            surfaceRequest.willNotProvideSurface();
            return;
        }
        Runnable runnable = new Runnable() { // from class: androidx.camera.core.processing.i
            @Override // java.lang.Runnable
            public final void run() {
                DefaultSurfaceProcessor.d(DefaultSurfaceProcessor.this, surfaceRequest);
            }
        };
        Objects.requireNonNull(surfaceRequest);
        executeSafely(runnable, new Runnable() { // from class: androidx.camera.core.processing.j
            @Override // java.lang.Runnable
            public final void run() {
                SurfaceRequest.this.willNotProvideSurface();
            }
        });
    }

    @Override // androidx.camera.core.SurfaceProcessor
    public void onOutputSurface(@NonNull final SurfaceOutput surfaceOutput) {
        if (this.mIsReleaseRequested.get()) {
            surfaceOutput.close();
            return;
        }
        Runnable runnable = new Runnable() { // from class: androidx.camera.core.processing.f
            @Override // java.lang.Runnable
            public final void run() {
                DefaultSurfaceProcessor.k(DefaultSurfaceProcessor.this, surfaceOutput);
            }
        };
        Objects.requireNonNull(surfaceOutput);
        executeSafely(runnable, new Runnable() { // from class: androidx.camera.core.processing.g
            @Override // java.lang.Runnable
            public final void run() {
                SurfaceOutput.this.close();
            }
        });
    }

    @Override // androidx.camera.core.processing.SurfaceProcessorInternal
    public void release() {
        if (this.mIsReleaseRequested.getAndSet(true)) {
            return;
        }
        executeSafely(new Runnable() { // from class: androidx.camera.core.processing.n
            @Override // java.lang.Runnable
            public final void run() {
                DefaultSurfaceProcessor.h(DefaultSurfaceProcessor.this);
            }
        });
    }

    @Override // androidx.camera.core.processing.SurfaceProcessorInternal
    @NonNull
    public ListenableFuture<Void> snapshot(@IntRange(from = 0, to = 100) final int i6, @IntRange(from = 0, to = 359) final int i7) {
        return Futures.nonCancellationPropagating(CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.core.processing.e
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return DefaultSurfaceProcessor.b(DefaultSurfaceProcessor.this, i6, i7, completer);
            }
        }));
    }

    public static /* synthetic */ Object b(final DefaultSurfaceProcessor defaultSurfaceProcessor, int i6, int i7, final CallbackToFutureAdapter.Completer completer) {
        defaultSurfaceProcessor.getClass();
        final AutoValue_DefaultSurfaceProcessor_PendingSnapshot of = PendingSnapshot.of(i6, i7, completer);
        defaultSurfaceProcessor.executeSafely(new Runnable() { // from class: androidx.camera.core.processing.c
            @Override // java.lang.Runnable
            public final void run() {
                DefaultSurfaceProcessor.this.mPendingSnapshots.add(of);
            }
        }, new Runnable() { // from class: androidx.camera.core.processing.d
            @Override // java.lang.Runnable
            public final void run() {
                CallbackToFutureAdapter.Completer.this.setException(new Exception("Failed to snapshot: OpenGLRenderer not ready."));
            }
        });
        return "DefaultSurfaceProcessor#snapshot";
    }

    public static /* synthetic */ void c(DefaultSurfaceProcessor defaultSurfaceProcessor, SurfaceOutput surfaceOutput, SurfaceOutput.Event event) {
        defaultSurfaceProcessor.getClass();
        surfaceOutput.close();
        Surface remove = defaultSurfaceProcessor.mOutputSurfaces.remove(surfaceOutput);
        if (remove != null) {
            defaultSurfaceProcessor.mGlRenderer.unregisterOutputSurface(remove);
        }
    }

    public static /* synthetic */ Object g(final DefaultSurfaceProcessor defaultSurfaceProcessor, final DynamicRange dynamicRange, final ShaderProvider shaderProvider, final CallbackToFutureAdapter.Completer completer) {
        defaultSurfaceProcessor.getClass();
        defaultSurfaceProcessor.executeSafely(new Runnable() { // from class: androidx.camera.core.processing.l
            @Override // java.lang.Runnable
            public final void run() {
                DefaultSurfaceProcessor.i(DefaultSurfaceProcessor.this, dynamicRange, shaderProvider, completer);
            }
        });
        return "Init GlRenderer";
    }

    public static /* synthetic */ void i(DefaultSurfaceProcessor defaultSurfaceProcessor, DynamicRange dynamicRange, ShaderProvider shaderProvider, CallbackToFutureAdapter.Completer completer) {
        defaultSurfaceProcessor.getClass();
        try {
            defaultSurfaceProcessor.mGlRenderer.init(dynamicRange, shaderProvider);
            completer.set(null);
        } catch (RuntimeException e6) {
            completer.setException(e6);
        }
    }

    public static /* synthetic */ void j(DefaultSurfaceProcessor defaultSurfaceProcessor, SurfaceTexture surfaceTexture, Surface surface, SurfaceRequest.Result result) {
        defaultSurfaceProcessor.getClass();
        surfaceTexture.setOnFrameAvailableListener(null);
        surfaceTexture.release();
        surface.release();
        defaultSurfaceProcessor.mInputSurfaceCount--;
        defaultSurfaceProcessor.checkReadyToRelease();
    }

    public static /* synthetic */ void a() {
    }
}
