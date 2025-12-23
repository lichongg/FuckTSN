package androidx.camera.core.streamsharing;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Size;
import androidx.annotation.IntRange;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ImageInputConfig;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.MutableConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.o;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.processing.DefaultSurfaceProcessor;
import androidx.camera.core.processing.SurfaceEdge;
import androidx.camera.core.processing.SurfaceProcessorNode;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(api = 21)
/* loaded from: D:\Downloads\app\classes.dex */
public class StreamSharing extends UseCase {
    private static final String TAG = "StreamSharing";

    @Nullable
    private SurfaceEdge mCameraEdge;

    @NonNull
    private final StreamSharingConfig mDefaultConfig;

    @Nullable
    private SurfaceProcessorNode mEffectNode;
    SessionConfig.Builder mSessionConfigBuilder;

    @Nullable
    private SurfaceEdge mSharingInputEdge;

    @Nullable
    private SurfaceProcessorNode mSharingNode;

    @NonNull
    private final VirtualCamera mVirtualCamera;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    interface Control {
        @NonNull
        ListenableFuture<Void> jpegSnapshot(@IntRange(from = 0, to = 100) int i6, @IntRange(from = 0, to = 359) int i7);
    }

    private static StreamSharingConfig getDefaultConfig(Set<UseCase> set) {
        MutableConfig mutableConfig = new StreamSharingBuilder().getMutableConfig();
        mutableConfig.insertOption(ImageInputConfig.OPTION_INPUT_FORMAT, 34);
        mutableConfig.insertOption(UseCaseConfig.OPTION_CAPTURE_TYPE, UseCaseConfigFactory.CaptureType.STREAM_SHARING);
        ArrayList arrayList = new ArrayList();
        for (UseCase useCase : set) {
            if (useCase.getCurrentConfig().containsOption(UseCaseConfig.OPTION_CAPTURE_TYPE)) {
                arrayList.add(useCase.getCurrentConfig().getCaptureType());
            }
        }
        mutableConfig.insertOption(StreamSharingConfig.OPTION_CAPTURE_TYPES, arrayList);
        mutableConfig.insertOption(ImageOutputConfig.OPTION_MIRROR_MODE, 2);
        return new StreamSharingConfig(OptionsBundle.from(mutableConfig));
    }

    private void addCameraErrorListener(@NonNull SessionConfig.Builder builder, @NonNull final String str, @NonNull final UseCaseConfig<?> useCaseConfig, @NonNull final StreamSpec streamSpec) {
        builder.addErrorListener(new SessionConfig.ErrorListener() { // from class: androidx.camera.core.streamsharing.a
            @Override // androidx.camera.core.impl.SessionConfig.ErrorListener
            public final void onError(SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
                StreamSharing.a(StreamSharing.this, str, useCaseConfig, streamSpec, sessionConfig, sessionError);
            }
        });
    }

    public static /* synthetic */ ListenableFuture b(StreamSharing streamSharing, int i6, int i7) {
        SurfaceProcessorNode surfaceProcessorNode = streamSharing.mSharingNode;
        return surfaceProcessorNode != null ? surfaceProcessorNode.getSurfaceProcessor().snapshot(i6, i7) : Futures.immediateFailedFuture(new Exception("Failed to take picture: pipeline is not ready."));
    }

    private void clearPipeline() {
        SurfaceEdge surfaceEdge = this.mCameraEdge;
        if (surfaceEdge != null) {
            surfaceEdge.close();
            this.mCameraEdge = null;
        }
        SurfaceEdge surfaceEdge2 = this.mSharingInputEdge;
        if (surfaceEdge2 != null) {
            surfaceEdge2.close();
            this.mSharingInputEdge = null;
        }
        SurfaceProcessorNode surfaceProcessorNode = this.mSharingNode;
        if (surfaceProcessorNode != null) {
            surfaceProcessorNode.release();
            this.mSharingNode = null;
        }
        SurfaceProcessorNode surfaceProcessorNode2 = this.mEffectNode;
        if (surfaceProcessorNode2 != null) {
            surfaceProcessorNode2.release();
            this.mEffectNode = null;
        }
    }

    @Nullable
    @VisibleForTesting
    SurfaceEdge getCameraEdge() {
        return this.mCameraEdge;
    }

    @NonNull
    public Set<UseCase> getChildren() {
        return this.mVirtualCamera.getChildren();
    }

    @Nullable
    @VisibleForTesting
    SurfaceProcessorNode getSharingNode() {
        return this.mSharingNode;
    }

    @Override // androidx.camera.core.UseCase
    @NonNull
    public Set<Integer> getSupportedEffectTargets() {
        HashSet hashSet = new HashSet();
        hashSet.add(3);
        return hashSet;
    }

    @Override // androidx.camera.core.UseCase
    @NonNull
    public UseCaseConfig.Builder<?, ?, ?> getUseCaseConfigBuilder(@NonNull Config config) {
        return new StreamSharingBuilder(MutableOptionsBundle.from(config));
    }

    @NonNull
    @VisibleForTesting
    VirtualCamera getVirtualCamera() {
        return this.mVirtualCamera;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [androidx.camera.core.impl.UseCaseConfig, androidx.camera.core.impl.UseCaseConfig<?>] */
    @Override // androidx.camera.core.UseCase
    @NonNull
    protected UseCaseConfig<?> onMergeConfig(@NonNull CameraInfoInternal cameraInfoInternal, @NonNull UseCaseConfig.Builder<?, ?, ?> builder) {
        this.mVirtualCamera.mergeChildrenConfigs(builder.getMutableConfig());
        return builder.getUseCaseConfig();
    }

    @Override // androidx.camera.core.UseCase
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected StreamSpec onSuggestedStreamSpecImplementationOptionsUpdated(@NonNull Config config) {
        this.mSessionConfigBuilder.addImplementationOptions(config);
        updateSessionConfig(this.mSessionConfigBuilder.build());
        return getAttachedStreamSpec().toBuilder().setImplementationOptions(config).build();
    }

    public StreamSharing(@NonNull CameraInternal cameraInternal, @NonNull Set<UseCase> set, @NonNull UseCaseConfigFactory useCaseConfigFactory) {
        super(getDefaultConfig(set));
        this.mDefaultConfig = getDefaultConfig(set);
        this.mVirtualCamera = new VirtualCamera(cameraInternal, set, useCaseConfigFactory, new Control() { // from class: androidx.camera.core.streamsharing.b
            @Override // androidx.camera.core.streamsharing.StreamSharing.Control
            public final ListenableFuture jpegSnapshot(int i6, int i7) {
                return StreamSharing.b(StreamSharing.this, i6, i7);
            }
        });
    }

    public static /* synthetic */ void a(StreamSharing streamSharing, String str, UseCaseConfig useCaseConfig, StreamSpec streamSpec, SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
        streamSharing.clearPipeline();
        if (streamSharing.isCurrentCamera(str)) {
            streamSharing.updateSessionConfig(streamSharing.createPipelineAndUpdateChildrenSpecs(str, useCaseConfig, streamSpec));
            streamSharing.notifyReset();
            streamSharing.mVirtualCamera.resetChildren();
        }
    }

    @NonNull
    @MainThread
    private SessionConfig createPipelineAndUpdateChildrenSpecs(@NonNull String str, @NonNull UseCaseConfig<?> useCaseConfig, @NonNull StreamSpec streamSpec) {
        Threads.checkMainThread();
        CameraInternal cameraInternal = (CameraInternal) Preconditions.checkNotNull(getCamera());
        Matrix sensorToBufferTransformMatrix = getSensorToBufferTransformMatrix();
        boolean hasTransform = cameraInternal.getHasTransform();
        Rect cropRect = getCropRect(streamSpec.getResolution());
        Objects.requireNonNull(cropRect);
        SurfaceEdge surfaceEdge = new SurfaceEdge(3, 34, streamSpec, sensorToBufferTransformMatrix, hasTransform, cropRect, getRelativeRotation(cameraInternal), -1, isMirroringRequired(cameraInternal));
        this.mCameraEdge = surfaceEdge;
        this.mSharingInputEdge = getSharingInputEdge(surfaceEdge, cameraInternal);
        this.mSharingNode = new SurfaceProcessorNode(cameraInternal, DefaultSurfaceProcessor.Factory.newInstance(streamSpec.getDynamicRange()));
        Map<UseCase, SurfaceProcessorNode.OutConfig> childrenOutConfigs = this.mVirtualCamera.getChildrenOutConfigs(this.mSharingInputEdge);
        SurfaceProcessorNode.Out transform = this.mSharingNode.transform(SurfaceProcessorNode.In.of(this.mSharingInputEdge, new ArrayList(childrenOutConfigs.values())));
        HashMap hashMap = new HashMap();
        for (Map.Entry<UseCase, SurfaceProcessorNode.OutConfig> entry : childrenOutConfigs.entrySet()) {
            hashMap.put(entry.getKey(), transform.get(entry.getValue()));
        }
        this.mVirtualCamera.setChildrenEdges(hashMap);
        SessionConfig.Builder createFrom = SessionConfig.Builder.createFrom(useCaseConfig, streamSpec.getResolution());
        createFrom.addSurface(this.mCameraEdge.getDeferrableSurface());
        createFrom.addRepeatingCameraCaptureCallback(this.mVirtualCamera.getParentMetadataCallback());
        if (streamSpec.getImplementationOptions() != null) {
            createFrom.addImplementationOptions(streamSpec.getImplementationOptions());
        }
        addCameraErrorListener(createFrom, str, useCaseConfig, streamSpec);
        this.mSessionConfigBuilder = createFrom;
        return createFrom.build();
    }

    @Nullable
    private Rect getCropRect(@NonNull Size size) {
        if (getViewPortCropRect() != null) {
            return getViewPortCropRect();
        }
        return new Rect(0, 0, size.getWidth(), size.getHeight());
    }

    @NonNull
    private SurfaceEdge getSharingInputEdge(@NonNull SurfaceEdge surfaceEdge, @NonNull CameraInternal cameraInternal) {
        if (getEffect() == null) {
            return surfaceEdge;
        }
        this.mEffectNode = new SurfaceProcessorNode(cameraInternal, getEffect().createSurfaceProcessorInternal());
        SurfaceProcessorNode.OutConfig of = SurfaceProcessorNode.OutConfig.of(surfaceEdge.getTargets(), surfaceEdge.getFormat(), surfaceEdge.getCropRect(), TransformUtils.getRotatedSize(surfaceEdge.getCropRect(), 0), 0, false);
        SurfaceEdge surfaceEdge2 = this.mEffectNode.transform(SurfaceProcessorNode.In.of(surfaceEdge, Collections.singletonList(of))).get(of);
        Objects.requireNonNull(surfaceEdge2);
        return surfaceEdge2;
    }

    @Override // androidx.camera.core.UseCase
    public void onBind() {
        super.onBind();
        this.mVirtualCamera.bindChildren();
    }

    @Override // androidx.camera.core.UseCase
    public void onStateAttached() {
        super.onStateAttached();
        this.mVirtualCamera.notifyStateAttached();
    }

    @Override // androidx.camera.core.UseCase
    public void onStateDetached() {
        super.onStateDetached();
        this.mVirtualCamera.notifyStateDetached();
    }

    @Override // androidx.camera.core.UseCase
    @NonNull
    protected StreamSpec onSuggestedStreamSpecUpdated(@NonNull StreamSpec streamSpec) {
        updateSessionConfig(createPipelineAndUpdateChildrenSpecs(getCameraId(), getCurrentConfig(), streamSpec));
        notifyActive();
        return streamSpec;
    }

    @Override // androidx.camera.core.UseCase
    public void onUnbind() {
        super.onUnbind();
        clearPipeline();
        this.mVirtualCamera.unbindChildren();
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [androidx.camera.core.impl.UseCaseConfig, androidx.camera.core.impl.UseCaseConfig<?>] */
    @Override // androidx.camera.core.UseCase
    @Nullable
    public UseCaseConfig<?> getDefaultConfig(boolean z5, @NonNull UseCaseConfigFactory useCaseConfigFactory) {
        Config config = useCaseConfigFactory.getConfig(this.mDefaultConfig.getCaptureType(), 1);
        if (z5) {
            config = o.b(config, this.mDefaultConfig.getConfig());
        }
        if (config == null) {
            return null;
        }
        return getUseCaseConfigBuilder(config).getUseCaseConfig();
    }
}
