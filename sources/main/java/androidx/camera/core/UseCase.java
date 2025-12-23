package androidx.camera.core;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Range;
import android.util.Size;
import androidx.annotation.CallSuper;
import androidx.annotation.GuardedBy;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.internal.TargetConfig;
import androidx.camera.core.internal.utils.UseCaseConfigUtil;
import androidx.camera.core.processing.TargetUtils;
import androidx.camera.core.resolutionselector.ResolutionSelector;
import androidx.core.util.Preconditions;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public abstract class UseCase {
    private StreamSpec mAttachedStreamSpec;

    @GuardedBy("mCameraLock")
    private CameraInternal mCamera;

    @Nullable
    private UseCaseConfig<?> mCameraConfig;

    @NonNull
    private UseCaseConfig<?> mCurrentConfig;

    @Nullable
    private CameraEffect mEffect;

    @Nullable
    private UseCaseConfig<?> mExtendedConfig;

    @NonNull
    private UseCaseConfig<?> mUseCaseConfig;

    @Nullable
    private Rect mViewPortCropRect;
    private final Set<StateChangeCallback> mStateChangeCallbacks = new HashSet();
    private final Object mCameraLock = new Object();
    private State mState = State.INACTIVE;

    @NonNull
    private Matrix mSensorToBufferTransformMatrix = new Matrix();

    @NonNull
    private SessionConfig mAttachedSessionConfig = SessionConfig.defaultEmptySessionConfig();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public interface EventCallback {
        void onBind(@NonNull CameraInfo cameraInfo);

        void onUnbind();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    enum State {
        ACTIVE,
        INACTIVE
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public interface StateChangeCallback {
        void onUseCaseActive(@NonNull UseCase useCase);

        void onUseCaseInactive(@NonNull UseCase useCase);

        void onUseCaseReset(@NonNull UseCase useCase);

        void onUseCaseUpdated(@NonNull UseCase useCase);
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public abstract UseCaseConfig<?> getDefaultConfig(boolean z5, @NonNull UseCaseConfigFactory useCaseConfigFactory);

    @IntRange(from = 0, to = 359)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected int getRelativeRotation(@NonNull CameraInternal cameraInternal) {
        return getRelativeRotation(cameraInternal, false);
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public abstract UseCaseConfig.Builder<?, ?, ?> getUseCaseConfigBuilder(@NonNull Config config);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: androidx.camera.core.UseCase$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$camera$core$UseCase$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$androidx$camera$core$UseCase$State = iArr;
            try {
                iArr[State.INACTIVE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$camera$core$UseCase$State[State.ACTIVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private void addStateChangeCallback(@NonNull StateChangeCallback stateChangeCallback) {
        this.mStateChangeCallbacks.add(stateChangeCallback);
    }

    private void removeStateChangeCallback(@NonNull StateChangeCallback stateChangeCallback) {
        this.mStateChangeCallbacks.remove(stateChangeCallback);
    }

    public static int snapToSurfaceRotation(@IntRange(from = 0, to = 359) int i6) {
        Preconditions.checkArgumentInRange(i6, 0, MediaPlayer.MEDIA_PLAYER_OPTION_SPEEDX_DROP_FPS_LIMIT, "orientation");
        if (i6 >= 315 || i6 < 45) {
            return 0;
        }
        if (i6 >= 225) {
            return 1;
        }
        return i6 >= 135 ? 2 : 3;
    }

    @SuppressLint({"WrongConstant"})
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void bindToCamera(@NonNull CameraInternal cameraInternal, @Nullable UseCaseConfig<?> useCaseConfig, @Nullable UseCaseConfig<?> useCaseConfig2) {
        synchronized (this.mCameraLock) {
            this.mCamera = cameraInternal;
            addStateChangeCallback(cameraInternal);
        }
        this.mExtendedConfig = useCaseConfig;
        this.mCameraConfig = useCaseConfig2;
        UseCaseConfig<?> mergeConfigs = mergeConfigs(cameraInternal.getCameraInfoInternal(), this.mExtendedConfig, this.mCameraConfig);
        this.mCurrentConfig = mergeConfigs;
        EventCallback useCaseEventCallback = mergeConfigs.getUseCaseEventCallback(null);
        if (useCaseEventCallback != null) {
            useCaseEventCallback.onBind(cameraInternal.getCameraInfoInternal());
        }
        onBind();
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected UseCaseConfig<?> getAppConfig() {
        return this.mUseCaseConfig;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected int getAppTargetRotation() {
        return ((ImageOutputConfig) this.mCurrentConfig).getAppTargetRotation(-1);
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public StreamSpec getAttachedStreamSpec() {
        return this.mAttachedStreamSpec;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Size getAttachedSurfaceResolution() {
        StreamSpec streamSpec = this.mAttachedStreamSpec;
        if (streamSpec != null) {
            return streamSpec.getResolution();
        }
        return null;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public CameraInternal getCamera() {
        CameraInternal cameraInternal;
        synchronized (this.mCameraLock) {
            cameraInternal = this.mCamera;
        }
        return cameraInternal;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected CameraControlInternal getCameraControl() {
        synchronized (this.mCameraLock) {
            try {
                CameraInternal cameraInternal = this.mCamera;
                if (cameraInternal == null) {
                    return CameraControlInternal.DEFAULT_EMPTY_INSTANCE;
                }
                return cameraInternal.getCameraControlInternal();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public UseCaseConfig<?> getCurrentConfig() {
        return this.mCurrentConfig;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public CameraEffect getEffect() {
        return this.mEffect;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getImageFormat() {
        return this.mCurrentConfig.getInputFormat();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected int getMirrorModeInternal() {
        return ((ImageOutputConfig) this.mCurrentConfig).getMirrorMode(0);
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public String getName() {
        String targetName = this.mCurrentConfig.getTargetName("<UnknownUseCase-" + hashCode() + ">");
        Objects.requireNonNull(targetName);
        return targetName;
    }

    @IntRange(from = 0, to = 359)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected int getRelativeRotation(@NonNull CameraInternal cameraInternal, boolean z5) {
        int sensorRotationDegrees = cameraInternal.getCameraInfoInternal().getSensorRotationDegrees(getTargetRotationInternal());
        return (cameraInternal.getHasTransform() || !z5) ? sensorRotationDegrees : TransformUtils.within360(-sensorRotationDegrees);
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Matrix getSensorToBufferTransformMatrix() {
        return this.mSensorToBufferTransformMatrix;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public SessionConfig getSessionConfig() {
        return this.mAttachedSessionConfig;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected Set<Integer> getSupportedEffectTargets() {
        return Collections.EMPTY_SET;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected Range<Integer> getTargetFrameRateInternal() {
        return this.mCurrentConfig.getTargetFrameRate(StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED);
    }

    @SuppressLint({"WrongConstant"})
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected int getTargetRotationInternal() {
        return ((ImageOutputConfig) this.mCurrentConfig).getTargetRotation(0);
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Rect getViewPortCropRect() {
        return this.mViewPortCropRect;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public UseCaseConfig<?> mergeConfigs(@NonNull CameraInfoInternal cameraInfoInternal, @Nullable UseCaseConfig<?> useCaseConfig, @Nullable UseCaseConfig<?> useCaseConfig2) {
        MutableOptionsBundle create;
        if (useCaseConfig2 != null) {
            create = MutableOptionsBundle.from((Config) useCaseConfig2);
            create.removeOption(TargetConfig.OPTION_TARGET_NAME);
        } else {
            create = MutableOptionsBundle.create();
        }
        if (this.mUseCaseConfig.containsOption(ImageOutputConfig.OPTION_TARGET_ASPECT_RATIO) || this.mUseCaseConfig.containsOption(ImageOutputConfig.OPTION_TARGET_RESOLUTION)) {
            Config.Option<ResolutionSelector> option = ImageOutputConfig.OPTION_RESOLUTION_SELECTOR;
            if (create.containsOption(option)) {
                create.removeOption(option);
            }
        }
        UseCaseConfig<?> useCaseConfig3 = this.mUseCaseConfig;
        Config.Option<ResolutionSelector> option2 = ImageOutputConfig.OPTION_RESOLUTION_SELECTOR;
        if (useCaseConfig3.containsOption(option2)) {
            Config.Option<Size> option3 = ImageOutputConfig.OPTION_MAX_RESOLUTION;
            if (create.containsOption(option3) && ((ResolutionSelector) this.mUseCaseConfig.retrieveOption(option2)).getResolutionStrategy() != null) {
                create.removeOption(option3);
            }
        }
        Iterator<Config.Option<?>> it = this.mUseCaseConfig.listOptions().iterator();
        while (it.hasNext()) {
            androidx.camera.core.impl.o.c(create, create, this.mUseCaseConfig, it.next());
        }
        if (useCaseConfig != null) {
            for (Config.Option<?> option4 : useCaseConfig.listOptions()) {
                if (!option4.getId().equals(TargetConfig.OPTION_TARGET_NAME.getId())) {
                    androidx.camera.core.impl.o.c(create, create, useCaseConfig, option4);
                }
            }
        }
        if (create.containsOption(ImageOutputConfig.OPTION_TARGET_RESOLUTION)) {
            Config.Option<Integer> option5 = ImageOutputConfig.OPTION_TARGET_ASPECT_RATIO;
            if (create.containsOption(option5)) {
                create.removeOption(option5);
            }
        }
        Config.Option<ResolutionSelector> option6 = ImageOutputConfig.OPTION_RESOLUTION_SELECTOR;
        if (create.containsOption(option6) && ((ResolutionSelector) create.retrieveOption(option6)).getAllowedResolutionMode() != 0) {
            create.insertOption(UseCaseConfig.OPTION_ZSL_DISABLED, Boolean.TRUE);
        }
        return onMergeConfig(cameraInfoInternal, getUseCaseConfigBuilder(create));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected final void notifyActive() {
        this.mState = State.ACTIVE;
        notifyState();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected final void notifyInactive() {
        this.mState = State.INACTIVE;
        notifyState();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected final void notifyReset() {
        Iterator<StateChangeCallback> it = this.mStateChangeCallbacks.iterator();
        while (it.hasNext()) {
            it.next().onUseCaseReset(this);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void notifyState() {
        int i6 = AnonymousClass1.$SwitchMap$androidx$camera$core$UseCase$State[this.mState.ordinal()];
        if (i6 == 1) {
            Iterator<StateChangeCallback> it = this.mStateChangeCallbacks.iterator();
            while (it.hasNext()) {
                it.next().onUseCaseInactive(this);
            }
        } else {
            if (i6 != 2) {
                return;
            }
            Iterator<StateChangeCallback> it2 = this.mStateChangeCallbacks.iterator();
            while (it2.hasNext()) {
                it2.next().onUseCaseActive(this);
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected final void notifyUpdated() {
        Iterator<StateChangeCallback> it = this.mStateChangeCallbacks.iterator();
        while (it.hasNext()) {
            it.next().onUseCaseUpdated(this);
        }
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected StreamSpec onSuggestedStreamSpecImplementationOptionsUpdated(@NonNull Config config) {
        StreamSpec streamSpec = this.mAttachedStreamSpec;
        if (streamSpec != null) {
            return streamSpec.toBuilder().setImplementationOptions(config).build();
        }
        throw new UnsupportedOperationException("Attempt to update the implementation options for a use case without attached stream specifications.");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setEffect(@Nullable CameraEffect cameraEffect) {
        Preconditions.checkArgument(cameraEffect == null || isEffectTargetsSupported(cameraEffect.getTargets()));
        this.mEffect = cameraEffect;
    }

    @CallSuper
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setSensorToBufferTransformMatrix(@NonNull Matrix matrix) {
        this.mSensorToBufferTransformMatrix = new Matrix(matrix);
    }

    @CallSuper
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setViewPortCropRect(@NonNull Rect rect) {
        this.mViewPortCropRect = rect;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected void updateSessionConfig(@NonNull SessionConfig sessionConfig) {
        this.mAttachedSessionConfig = sessionConfig;
        for (DeferrableSurface deferrableSurface : sessionConfig.getSurfaces()) {
            if (deferrableSurface.getContainerClass() == null) {
                deferrableSurface.setContainerClass(getClass());
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected UseCase(@NonNull UseCaseConfig<?> useCaseConfig) {
        this.mUseCaseConfig = useCaseConfig;
        this.mCurrentConfig = useCaseConfig;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected String getCameraId() {
        return ((CameraInternal) Preconditions.checkNotNull(getCamera(), "No camera attached to use case: " + this)).getCameraInfoInternal().getCameraId();
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected ResolutionInfo getResolutionInfoInternal() {
        CameraInternal camera = getCamera();
        Size attachedSurfaceResolution = getAttachedSurfaceResolution();
        if (camera != null && attachedSurfaceResolution != null) {
            Rect viewPortCropRect = getViewPortCropRect();
            if (viewPortCropRect == null) {
                viewPortCropRect = new Rect(0, 0, attachedSurfaceResolution.getWidth(), attachedSurfaceResolution.getHeight());
            }
            return new ResolutionInfo(attachedSurfaceResolution, viewPortCropRect, getRelativeRotation(camera));
        }
        return null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected boolean isCurrentCamera(@NonNull String str) {
        if (getCamera() == null) {
            return false;
        }
        return Objects.equals(str, getCameraId());
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isEffectTargetsSupported(int i6) {
        Iterator<Integer> it = getSupportedEffectTargets().iterator();
        while (it.hasNext()) {
            if (TargetUtils.isSuperset(i6, it.next().intValue())) {
                return true;
            }
        }
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isMirroringRequired(@NonNull CameraInternal cameraInternal) {
        int mirrorModeInternal = getMirrorModeInternal();
        if (mirrorModeInternal != 0) {
            if (mirrorModeInternal == 1) {
                return true;
            }
            if (mirrorModeInternal == 2) {
                return cameraInternal.isFrontFacing();
            }
            throw new AssertionError("Unknown mirrorMode: " + mirrorModeInternal);
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [androidx.camera.core.impl.UseCaseConfig, androidx.camera.core.impl.UseCaseConfig<?>] */
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected UseCaseConfig<?> onMergeConfig(@NonNull CameraInfoInternal cameraInfoInternal, @NonNull UseCaseConfig.Builder<?, ?, ?> builder) {
        return builder.getUseCaseConfig();
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [androidx.camera.core.impl.UseCaseConfig, androidx.camera.core.impl.UseCaseConfig<?>] */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected boolean setTargetRotationInternal(int i6) {
        int targetRotation = ((ImageOutputConfig) getCurrentConfig()).getTargetRotation(-1);
        if (targetRotation != -1 && targetRotation == i6) {
            return false;
        }
        UseCaseConfig.Builder<?, ?, ?> useCaseConfigBuilder = getUseCaseConfigBuilder(this.mUseCaseConfig);
        UseCaseConfigUtil.updateTargetRotationAndRelatedConfigs(useCaseConfigBuilder, i6);
        this.mUseCaseConfig = useCaseConfigBuilder.getUseCaseConfig();
        CameraInternal camera = getCamera();
        if (camera == null) {
            this.mCurrentConfig = this.mUseCaseConfig;
            return true;
        }
        this.mCurrentConfig = mergeConfigs(camera.getCameraInfoInternal(), this.mExtendedConfig, this.mCameraConfig);
        return true;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final void unbindFromCamera(@NonNull CameraInternal cameraInternal) {
        boolean z5;
        onUnbind();
        EventCallback useCaseEventCallback = this.mCurrentConfig.getUseCaseEventCallback(null);
        if (useCaseEventCallback != null) {
            useCaseEventCallback.onUnbind();
        }
        synchronized (this.mCameraLock) {
            if (cameraInternal == this.mCamera) {
                z5 = true;
            } else {
                z5 = false;
            }
            Preconditions.checkArgument(z5);
            removeStateChangeCallback(this.mCamera);
            this.mCamera = null;
        }
        this.mAttachedStreamSpec = null;
        this.mViewPortCropRect = null;
        this.mCurrentConfig = this.mUseCaseConfig;
        this.mExtendedConfig = null;
        this.mCameraConfig = null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void updateSuggestedStreamSpec(@NonNull StreamSpec streamSpec) {
        this.mAttachedStreamSpec = onSuggestedStreamSpecUpdated(streamSpec);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void updateSuggestedStreamSpecImplementationOptions(@NonNull Config config) {
        this.mAttachedStreamSpec = onSuggestedStreamSpecImplementationOptionsUpdated(config);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onBind() {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onCameraControlReady() {
    }

    @CallSuper
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onStateAttached() {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onStateDetached() {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onUnbind() {
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected StreamSpec onSuggestedStreamSpecUpdated(@NonNull StreamSpec streamSpec) {
        return streamSpec;
    }
}
