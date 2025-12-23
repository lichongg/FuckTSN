package androidx.camera.core.processing;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Size;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.Logger;
import androidx.camera.core.ProcessingException;
import androidx.camera.core.SurfaceOutput;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.core.util.Preconditions;
import com.google.auto.value.AutoValue;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(api = 21)
/* loaded from: D:\Downloads\app\classes.dex */
public class SurfaceProcessorNode implements Node<In, Out> {
    private static final String TAG = "SurfaceProcessorNode";

    @NonNull
    final CameraInternal mCameraInternal;

    @Nullable
    private In mInput;

    @Nullable
    private Out mOutput;

    @NonNull
    final SurfaceProcessorInternal mSurfaceProcessor;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @AutoValue
    public static abstract class In {
        @NonNull
        public abstract List<OutConfig> getOutConfigs();

        @NonNull
        public abstract SurfaceEdge getSurfaceEdge();

        @NonNull
        public static In of(@NonNull SurfaceEdge surfaceEdge, @NonNull List<OutConfig> list) {
            return new AutoValue_SurfaceProcessorNode_In(surfaceEdge, list);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Out extends HashMap<OutConfig, SurfaceEdge> {
    }

    public static /* synthetic */ void c(SurfaceProcessorNode surfaceProcessorNode) {
        Out out = surfaceProcessorNode.mOutput;
        if (out != null) {
            Iterator<SurfaceEdge> it = out.values().iterator();
            while (it.hasNext()) {
                it.next().close();
            }
        }
    }

    private void sendSurfaceRequest(@NonNull SurfaceEdge surfaceEdge, @NonNull Map<OutConfig, SurfaceEdge> map) {
        SurfaceRequest createSurfaceRequest = surfaceEdge.createSurfaceRequest(this.mCameraInternal);
        setUpRotationUpdates(createSurfaceRequest, map);
        try {
            this.mSurfaceProcessor.onInputSurface(createSurfaceRequest);
        } catch (ProcessingException e6) {
            Logger.e(TAG, "Failed to send SurfaceRequest to SurfaceProcessor.", e6);
        }
    }

    @NonNull
    public SurfaceProcessorInternal getSurfaceProcessor() {
        return this.mSurfaceProcessor;
    }

    @Override // androidx.camera.core.processing.Node
    public void release() {
        this.mSurfaceProcessor.release();
        CameraXExecutors.mainThreadExecutor().execute(new Runnable() { // from class: androidx.camera.core.processing.f0
            @Override // java.lang.Runnable
            public final void run() {
                SurfaceProcessorNode.c(SurfaceProcessorNode.this);
            }
        });
    }

    @Override // androidx.camera.core.processing.Node
    @NonNull
    @MainThread
    public Out transform(@NonNull In in) {
        Threads.checkMainThread();
        this.mInput = in;
        this.mOutput = new Out();
        SurfaceEdge surfaceEdge = in.getSurfaceEdge();
        for (OutConfig outConfig : in.getOutConfigs()) {
            this.mOutput.put(outConfig, transformSingleOutput(surfaceEdge, outConfig));
        }
        sendSurfaceRequest(surfaceEdge, this.mOutput);
        sendSurfaceOutputs(surfaceEdge, this.mOutput);
        return this.mOutput;
    }

    public SurfaceProcessorNode(@NonNull CameraInternal cameraInternal, @NonNull SurfaceProcessorInternal surfaceProcessorInternal) {
        this.mCameraInternal = cameraInternal;
        this.mSurfaceProcessor = surfaceProcessorInternal;
    }

    public static /* synthetic */ void b(Map map, SurfaceRequest.TransformationInfo transformationInfo) {
        for (Map.Entry entry : map.entrySet()) {
            int rotationDegrees = transformationInfo.getRotationDegrees() - ((OutConfig) entry.getKey()).getRotationDegrees();
            if (((OutConfig) entry.getKey()).getMirroring()) {
                rotationDegrees = -rotationDegrees;
            }
            ((SurfaceEdge) entry.getValue()).updateTransformation(TransformUtils.within360(rotationDegrees), -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createAndSendSurfaceOutput(@NonNull SurfaceEdge surfaceEdge, Map.Entry<OutConfig, SurfaceEdge> entry) {
        CameraInternal cameraInternal;
        SurfaceEdge value = entry.getValue();
        Size resolution = surfaceEdge.getStreamSpec().getResolution();
        int format = entry.getKey().getFormat();
        Rect cropRect = entry.getKey().getCropRect();
        int rotationDegrees = entry.getKey().getRotationDegrees();
        boolean mirroring = entry.getKey().getMirroring();
        if (surfaceEdge.hasCameraTransform()) {
            cameraInternal = this.mCameraInternal;
        } else {
            cameraInternal = null;
        }
        Futures.addCallback(value.createSurfaceOutputFuture(resolution, format, cropRect, rotationDegrees, mirroring, cameraInternal), new FutureCallback<SurfaceOutput>() { // from class: androidx.camera.core.processing.SurfaceProcessorNode.1
            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onFailure(@NonNull Throwable th) {
                Logger.w(SurfaceProcessorNode.TAG, "Downstream node failed to provide Surface.", th);
            }

            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onSuccess(@Nullable SurfaceOutput surfaceOutput) {
                Preconditions.checkNotNull(surfaceOutput);
                try {
                    SurfaceProcessorNode.this.mSurfaceProcessor.onOutputSurface(surfaceOutput);
                } catch (ProcessingException e6) {
                    Logger.e(SurfaceProcessorNode.TAG, "Failed to send SurfaceOutput to SurfaceProcessor.", e6);
                }
            }
        }, CameraXExecutors.mainThreadExecutor());
    }

    private void sendSurfaceOutputs(@NonNull final SurfaceEdge surfaceEdge, @NonNull Map<OutConfig, SurfaceEdge> map) {
        for (final Map.Entry<OutConfig, SurfaceEdge> entry : map.entrySet()) {
            createAndSendSurfaceOutput(surfaceEdge, entry);
            entry.getValue().addOnInvalidatedListener(new Runnable() { // from class: androidx.camera.core.processing.e0
                @Override // java.lang.Runnable
                public final void run() {
                    SurfaceProcessorNode.this.createAndSendSurfaceOutput(surfaceEdge, entry);
                }
            });
        }
    }

    @NonNull
    private SurfaceEdge transformSingleOutput(@NonNull SurfaceEdge surfaceEdge, @NonNull OutConfig outConfig) {
        boolean z5;
        Rect cropRect = outConfig.getCropRect();
        int rotationDegrees = outConfig.getRotationDegrees();
        boolean mirroring = outConfig.getMirroring();
        Matrix matrix = new Matrix(surfaceEdge.getSensorToBufferTransform());
        matrix.postConcat(TransformUtils.getRectToRect(new RectF(cropRect), TransformUtils.sizeToRectF(outConfig.getSize()), rotationDegrees, mirroring));
        Preconditions.checkArgument(TransformUtils.isAspectRatioMatchingWithRoundingError(TransformUtils.getRotatedSize(cropRect, rotationDegrees), outConfig.getSize()));
        StreamSpec build = surfaceEdge.getStreamSpec().toBuilder().setResolution(outConfig.getSize()).build();
        int targets = outConfig.getTargets();
        int format = outConfig.getFormat();
        Rect sizeToRect = TransformUtils.sizeToRect(outConfig.getSize());
        int rotationDegrees2 = surfaceEdge.getRotationDegrees() - rotationDegrees;
        if (surfaceEdge.getMirroring() != mirroring) {
            z5 = true;
        } else {
            z5 = false;
        }
        return new SurfaceEdge(targets, format, build, matrix, false, sizeToRect, rotationDegrees2, -1, z5);
    }

    void setUpRotationUpdates(@NonNull SurfaceRequest surfaceRequest, @NonNull final Map<OutConfig, SurfaceEdge> map) {
        surfaceRequest.setTransformationInfoListener(CameraXExecutors.mainThreadExecutor(), new SurfaceRequest.TransformationInfoListener() { // from class: androidx.camera.core.processing.g0
            @Override // androidx.camera.core.SurfaceRequest.TransformationInfoListener
            public final void onTransformationInfoUpdate(SurfaceRequest.TransformationInfo transformationInfo) {
                SurfaceProcessorNode.b(map, transformationInfo);
            }
        });
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @AutoValue
    public static abstract class OutConfig {
        @NonNull
        public static OutConfig of(@NonNull SurfaceEdge surfaceEdge) {
            return of(surfaceEdge.getTargets(), surfaceEdge.getFormat(), surfaceEdge.getCropRect(), TransformUtils.getRotatedSize(surfaceEdge.getCropRect(), surfaceEdge.getRotationDegrees()), surfaceEdge.getRotationDegrees(), surfaceEdge.getMirroring());
        }

        @NonNull
        public abstract Rect getCropRect();

        public abstract int getFormat();

        public abstract boolean getMirroring();

        public abstract int getRotationDegrees();

        @NonNull
        public abstract Size getSize();

        public abstract int getTargets();

        @NonNull
        abstract UUID getUuid();

        @NonNull
        public static OutConfig of(int i6, int i7, @NonNull Rect rect, @NonNull Size size, int i8, boolean z5) {
            return new AutoValue_SurfaceProcessorNode_OutConfig(UUID.randomUUID(), i6, i7, rect, size, i8, z5);
        }
    }
}
