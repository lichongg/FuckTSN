package androidx.camera.core.internal;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.util.Pair;
import android.util.Size;
import android.view.Surface;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraControl;
import androidx.camera.core.CameraEffect;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.Logger;
import androidx.camera.core.Preview;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.UseCase;
import androidx.camera.core.ViewPort;
import androidx.camera.core.concurrent.CameraCoordinator;
import androidx.camera.core.impl.AttachedSurfaceInfo;
import androidx.camera.core.impl.CameraConfig;
import androidx.camera.core.impl.CameraConfigs;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.CameraDeviceSurfaceManager;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.RestrictedCameraControl;
import androidx.camera.core.impl.RestrictedCameraInfo;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.SessionProcessor;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.processing.TargetUtils;
import androidx.camera.core.streamsharing.StreamSharing;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public final class CameraUseCaseAdapter implements Camera {
    private static final String TAG = "CameraUseCaseAdapter";

    @GuardedBy("mLock")
    private final CameraCoordinator mCameraCoordinator;
    private final CameraDeviceSurfaceManager mCameraDeviceSurfaceManager;

    @NonNull
    private final CameraInternal mCameraInternal;
    private final LinkedHashSet<CameraInternal> mCameraInternals;
    private final CameraId mId;

    @Nullable
    @GuardedBy("mLock")
    private UseCase mPlaceholderForExtensions;

    @NonNull
    private final RestrictedCameraControl mRestrictedCameraControl;

    @NonNull
    private final RestrictedCameraInfo mRestrictedCameraInfo;

    @Nullable
    @GuardedBy("mLock")
    private StreamSharing mStreamSharing;
    private final UseCaseConfigFactory mUseCaseConfigFactory;

    @Nullable
    @GuardedBy("mLock")
    private ViewPort mViewPort;

    @GuardedBy("mLock")
    private final List<UseCase> mAppUseCases = new ArrayList();

    @GuardedBy("mLock")
    private final List<UseCase> mCameraUseCases = new ArrayList();

    @NonNull
    @GuardedBy("mLock")
    private List<CameraEffect> mEffects = Collections.EMPTY_LIST;

    @NonNull
    @GuardedBy("mLock")
    private CameraConfig mCameraConfig = CameraConfigs.emptyConfig();
    private final Object mLock = new Object();

    @GuardedBy("mLock")
    private boolean mAttached = true;

    @GuardedBy("mLock")
    private Config mInteropConfig = null;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class CameraException extends Exception {
        public CameraException() {
        }

        public CameraException(@NonNull String str) {
            super(str);
        }

        public CameraException(@NonNull Throwable th) {
            super(th);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class CameraId {
        private final List<String> mIds = new ArrayList();

        public boolean equals(Object obj) {
            if (obj instanceof CameraId) {
                return this.mIds.equals(((CameraId) obj).mIds);
            }
            return false;
        }

        public int hashCode() {
            return this.mIds.hashCode() * 53;
        }

        CameraId(LinkedHashSet<CameraInternal> linkedHashSet) {
            Iterator<CameraInternal> it = linkedHashSet.iterator();
            while (it.hasNext()) {
                this.mIds.add(it.next().getCameraInfoInternal().getCameraId());
            }
        }
    }

    static boolean isStreamSharingChildrenCombinationValid(@NonNull Collection<UseCase> collection) {
        int[] iArr = {1, 2, 4};
        HashSet hashSet = new HashSet();
        for (UseCase useCase : collection) {
            for (int i6 = 0; i6 < 3; i6++) {
                int i7 = iArr[i6];
                if (useCase.isEffectTargetsSupported(i7)) {
                    if (hashSet.contains(Integer.valueOf(i7))) {
                        return false;
                    }
                    hashSet.add(Integer.valueOf(i7));
                }
            }
        }
        return true;
    }

    void updateUseCases(@NonNull Collection<UseCase> collection) {
        updateUseCases(collection, false);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class ConfigPair {
        UseCaseConfig<?> mCameraConfig;
        UseCaseConfig<?> mExtendedConfig;

        ConfigPair(UseCaseConfig<?> useCaseConfig, UseCaseConfig<?> useCaseConfig2) {
            this.mExtendedConfig = useCaseConfig;
            this.mCameraConfig = useCaseConfig2;
        }
    }

    public static /* synthetic */ void a(SurfaceRequest surfaceRequest) {
        final SurfaceTexture surfaceTexture = new SurfaceTexture(0);
        surfaceTexture.setDefaultBufferSize(surfaceRequest.getResolution().getWidth(), surfaceRequest.getResolution().getHeight());
        surfaceTexture.detachFromGLContext();
        final Surface surface = new Surface(surfaceTexture);
        surfaceRequest.provideSurface(surface, CameraXExecutors.directExecutor(), new Consumer() { // from class: androidx.camera.core.internal.a
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                CameraUseCaseAdapter.b(surface, surfaceTexture, (SurfaceRequest.Result) obj);
            }
        });
    }

    private void cacheInteropConfig() {
        synchronized (this.mLock) {
            CameraControlInternal cameraControlInternal = this.mCameraInternal.getCameraControlInternal();
            this.mInteropConfig = cameraControlInternal.getInteropConfig();
            cameraControlInternal.clearInteropConfig();
        }
    }

    static Collection<UseCase> calculateCameraUseCases(@NonNull Collection<UseCase> collection, @Nullable UseCase useCase, @Nullable StreamSharing streamSharing) {
        ArrayList arrayList = new ArrayList(collection);
        if (useCase != null) {
            arrayList.add(useCase);
        }
        if (streamSharing != null) {
            arrayList.add(streamSharing);
            arrayList.removeAll(streamSharing.getChildren());
        }
        return arrayList;
    }

    private Map<UseCase, StreamSpec> calculateSuggestedStreamSpecs(int i6, @NonNull CameraInfoInternal cameraInfoInternal, @NonNull Collection<UseCase> collection, @NonNull Collection<UseCase> collection2, @NonNull Map<UseCase, ConfigPair> map) {
        Rect rect;
        ArrayList arrayList = new ArrayList();
        String cameraId = cameraInfoInternal.getCameraId();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        Iterator<UseCase> it = collection2.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            UseCase next = it.next();
            AttachedSurfaceInfo create = AttachedSurfaceInfo.create(this.mCameraDeviceSurfaceManager.transformSurfaceConfig(i6, cameraId, next.getImageFormat(), next.getAttachedSurfaceResolution()), next.getImageFormat(), next.getAttachedSurfaceResolution(), ((StreamSpec) Preconditions.checkNotNull(next.getAttachedStreamSpec())).getDynamicRange(), getCaptureTypes(next), next.getAttachedStreamSpec().getImplementationOptions(), next.getCurrentConfig().getTargetFrameRate(null));
            arrayList.add(create);
            hashMap2.put(create, next);
            hashMap.put(next, next.getAttachedStreamSpec());
        }
        if (!collection.isEmpty()) {
            HashMap hashMap3 = new HashMap();
            HashMap hashMap4 = new HashMap();
            try {
                rect = this.mCameraInternal.getCameraControlInternal().getSensorRect();
            } catch (NullPointerException unused) {
                rect = null;
            }
            SupportedOutputSizesSorter supportedOutputSizesSorter = new SupportedOutputSizesSorter(cameraInfoInternal, rect != null ? TransformUtils.rectToSize(rect) : null);
            for (UseCase useCase : collection) {
                ConfigPair configPair = map.get(useCase);
                UseCaseConfig<?> mergeConfigs = useCase.mergeConfigs(cameraInfoInternal, configPair.mExtendedConfig, configPair.mCameraConfig);
                hashMap3.put(mergeConfigs, useCase);
                hashMap4.put(mergeConfigs, supportedOutputSizesSorter.getSortedSupportedOutputSizes(mergeConfigs));
            }
            Pair<Map<UseCaseConfig<?>, StreamSpec>, Map<AttachedSurfaceInfo, StreamSpec>> suggestedStreamSpecs = this.mCameraDeviceSurfaceManager.getSuggestedStreamSpecs(i6, cameraId, arrayList, hashMap4);
            for (Map.Entry entry : hashMap3.entrySet()) {
                hashMap.put((UseCase) entry.getValue(), (StreamSpec) ((Map) suggestedStreamSpecs.first).get(entry.getKey()));
            }
            for (Map.Entry entry2 : ((Map) suggestedStreamSpecs.second).entrySet()) {
                if (hashMap2.containsKey(entry2.getKey())) {
                    hashMap.put((UseCase) hashMap2.get(entry2.getKey()), (StreamSpec) entry2.getValue());
                }
            }
        }
        return hashMap;
    }

    private ImageCapture createExtraImageCapture() {
        return new ImageCapture.Builder().setTargetName("ImageCapture-Extra").build();
    }

    private Preview createExtraPreview() {
        Preview build = new Preview.Builder().setTargetName("Preview-Extra").build();
        build.setSurfaceProvider(new Preview.SurfaceProvider() { // from class: androidx.camera.core.internal.b
            @Override // androidx.camera.core.Preview.SurfaceProvider
            public final void onSurfaceRequested(SurfaceRequest surfaceRequest) {
                CameraUseCaseAdapter.a(surfaceRequest);
            }
        });
        return build;
    }

    @Nullable
    private StreamSharing createOrReuseStreamSharing(@NonNull Collection<UseCase> collection, boolean z5) {
        synchronized (this.mLock) {
            try {
                Set<UseCase> streamSharingChildren = getStreamSharingChildren(collection, z5);
                if (streamSharingChildren.size() < 2) {
                    return null;
                }
                StreamSharing streamSharing = this.mStreamSharing;
                if (streamSharing != null && streamSharing.getChildren().equals(streamSharingChildren)) {
                    StreamSharing streamSharing2 = this.mStreamSharing;
                    Objects.requireNonNull(streamSharing2);
                    return streamSharing2;
                }
                if (!isStreamSharingChildrenCombinationValid(streamSharingChildren)) {
                    return null;
                }
                return new StreamSharing(this.mCameraInternal, streamSharingChildren, this.mUseCaseConfigFactory);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @NonNull
    public static CameraId generateCameraId(@NonNull LinkedHashSet<CameraInternal> linkedHashSet) {
        return new CameraId(linkedHashSet);
    }

    private int getCameraMode() {
        synchronized (this.mLock) {
            try {
                return this.mCameraCoordinator.getCameraOperatingMode() == 2 ? 1 : 0;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @NonNull
    private static List<UseCaseConfigFactory.CaptureType> getCaptureTypes(UseCase useCase) {
        ArrayList arrayList = new ArrayList();
        if (!isStreamSharing(useCase)) {
            arrayList.add(useCase.getCurrentConfig().getCaptureType());
            return arrayList;
        }
        Iterator<UseCase> it = ((StreamSharing) useCase).getChildren().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getCurrentConfig().getCaptureType());
        }
        return arrayList;
    }

    private Map<UseCase, ConfigPair> getConfigs(Collection<UseCase> collection, UseCaseConfigFactory useCaseConfigFactory, UseCaseConfigFactory useCaseConfigFactory2) {
        HashMap hashMap = new HashMap();
        for (UseCase useCase : collection) {
            hashMap.put(useCase, new ConfigPair(useCase.getDefaultConfig(false, useCaseConfigFactory), useCase.getDefaultConfig(true, useCaseConfigFactory2)));
        }
        return hashMap;
    }

    private int getSharingTargets(boolean z5) {
        int i6;
        synchronized (this.mLock) {
            try {
                Iterator<CameraEffect> it = this.mEffects.iterator();
                CameraEffect cameraEffect = null;
                while (true) {
                    i6 = 0;
                    if (!it.hasNext()) {
                        break;
                    }
                    CameraEffect next = it.next();
                    if (TargetUtils.getNumberOfTargets(next.getTargets()) > 1) {
                        Preconditions.checkState(cameraEffect == null, "Can only have one sharing effect.");
                        cameraEffect = next;
                    }
                }
                if (cameraEffect != null) {
                    i6 = cameraEffect.getTargets();
                }
                if (z5) {
                    i6 |= 3;
                }
            } finally {
            }
        }
        return i6;
    }

    @NonNull
    private Set<UseCase> getStreamSharingChildren(@NonNull Collection<UseCase> collection, boolean z5) {
        HashSet hashSet = new HashSet();
        int sharingTargets = getSharingTargets(z5);
        for (UseCase useCase : collection) {
            Preconditions.checkArgument(!isStreamSharing(useCase), "Only support one level of sharing for now.");
            if (useCase.isEffectTargetsSupported(sharingTargets)) {
                hashSet.add(useCase);
            }
        }
        return hashSet;
    }

    private boolean hasNoExtension() {
        boolean z5;
        synchronized (this.mLock) {
            z5 = this.mCameraConfig == CameraConfigs.emptyConfig();
        }
        return z5;
    }

    private boolean isCoexistingPreviewImageCaptureRequired() {
        boolean z5;
        synchronized (this.mLock) {
            z5 = true;
            if (this.mCameraConfig.getUseCaseCombinationRequiredRule() != 1) {
                z5 = false;
            }
        }
        return z5;
    }

    private static boolean isImageCapture(@Nullable UseCase useCase) {
        return useCase instanceof ImageCapture;
    }

    private static boolean isPreview(@Nullable UseCase useCase) {
        return useCase instanceof Preview;
    }

    private static boolean isStreamSharing(@Nullable UseCase useCase) {
        return useCase instanceof StreamSharing;
    }

    private void restoreInteropConfig() {
        synchronized (this.mLock) {
            try {
                if (this.mInteropConfig != null) {
                    this.mCameraInternal.getCameraControlInternal().addInteropConfig(this.mInteropConfig);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @NonNull
    private static List<CameraEffect> setEffectsOnUseCases(@NonNull List<CameraEffect> list, @NonNull Collection<UseCase> collection) {
        ArrayList arrayList = new ArrayList(list);
        for (UseCase useCase : collection) {
            useCase.setEffect(null);
            for (CameraEffect cameraEffect : list) {
                if (useCase.isEffectTargetsSupported(cameraEffect.getTargets())) {
                    Preconditions.checkState(useCase.getEffect() == null, useCase + " already has effect" + useCase.getEffect());
                    useCase.setEffect(cameraEffect);
                    arrayList.remove(cameraEffect);
                }
            }
        }
        return arrayList;
    }

    private void updateViewPort(@NonNull Map<UseCase, StreamSpec> map, @NonNull Collection<UseCase> collection) {
        synchronized (this.mLock) {
            try {
                if (this.mViewPort != null) {
                    Map<UseCase, Rect> calculateViewPortRects = ViewPorts.calculateViewPortRects(this.mCameraInternal.getCameraControlInternal().getSensorRect(), this.mCameraInternal.getCameraInfoInternal().getLensFacing() == 0, this.mViewPort.getAspectRatio(), this.mCameraInternal.getCameraInfoInternal().getSensorRotationDegrees(this.mViewPort.getRotation()), this.mViewPort.getScaleType(), this.mViewPort.getLayoutDirection(), map);
                    for (UseCase useCase : collection) {
                        useCase.setViewPortCropRect((Rect) Preconditions.checkNotNull(calculateViewPortRects.get(useCase)));
                        useCase.setSensorToBufferTransformMatrix(calculateSensorToBufferTransformMatrix(this.mCameraInternal.getCameraControlInternal().getSensorRect(), ((StreamSpec) Preconditions.checkNotNull(map.get(useCase))).getResolution()));
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void addUseCases(@NonNull Collection<UseCase> collection) throws CameraException {
        synchronized (this.mLock) {
            try {
                LinkedHashSet linkedHashSet = new LinkedHashSet(this.mAppUseCases);
                linkedHashSet.addAll(collection);
                try {
                    updateUseCases(linkedHashSet);
                } catch (IllegalArgumentException e6) {
                    throw new CameraException(e6.getMessage());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void attachUseCases() {
        synchronized (this.mLock) {
            try {
                if (!this.mAttached) {
                    this.mCameraInternal.attachUseCases(this.mCameraUseCases);
                    restoreInteropConfig();
                    Iterator<UseCase> it = this.mCameraUseCases.iterator();
                    while (it.hasNext()) {
                        it.next().notifyState();
                    }
                    this.mAttached = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Nullable
    UseCase calculatePlaceholderForExtensions(@NonNull Collection<UseCase> collection) {
        UseCase useCase;
        synchronized (this.mLock) {
            try {
                if (isCoexistingPreviewImageCaptureRequired()) {
                    if (isExtraPreviewRequired(collection)) {
                        useCase = isPreview(this.mPlaceholderForExtensions) ? this.mPlaceholderForExtensions : createExtraPreview();
                    } else if (isExtraImageCaptureRequired(collection)) {
                        useCase = isImageCapture(this.mPlaceholderForExtensions) ? this.mPlaceholderForExtensions : createExtraImageCapture();
                    }
                }
                useCase = null;
            } catch (Throwable th) {
                throw th;
            }
        }
        return useCase;
    }

    public void detachUseCases() {
        synchronized (this.mLock) {
            try {
                if (this.mAttached) {
                    this.mCameraInternal.detachUseCases(new ArrayList(this.mCameraUseCases));
                    cacheInteropConfig();
                    this.mAttached = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.camera.core.Camera
    @NonNull
    public CameraControl getCameraControl() {
        return this.mRestrictedCameraControl;
    }

    @NonNull
    public CameraId getCameraId() {
        return this.mId;
    }

    @Override // androidx.camera.core.Camera
    @NonNull
    public CameraInfo getCameraInfo() {
        return this.mRestrictedCameraInfo;
    }

    @Override // androidx.camera.core.Camera
    @NonNull
    public LinkedHashSet<CameraInternal> getCameraInternals() {
        return this.mCameraInternals;
    }

    @NonNull
    @VisibleForTesting
    Collection<UseCase> getCameraUseCases() {
        ArrayList arrayList;
        synchronized (this.mLock) {
            arrayList = new ArrayList(this.mCameraUseCases);
        }
        return arrayList;
    }

    @Override // androidx.camera.core.Camera
    @NonNull
    public CameraConfig getExtendedConfig() {
        CameraConfig cameraConfig;
        synchronized (this.mLock) {
            cameraConfig = this.mCameraConfig;
        }
        return cameraConfig;
    }

    @NonNull
    public List<UseCase> getUseCases() {
        ArrayList arrayList;
        synchronized (this.mLock) {
            arrayList = new ArrayList(this.mAppUseCases);
        }
        return arrayList;
    }

    public boolean isEquivalent(@NonNull CameraUseCaseAdapter cameraUseCaseAdapter) {
        return this.mId.equals(cameraUseCaseAdapter.getCameraId());
    }

    @Override // androidx.camera.core.Camera
    public boolean isUseCasesCombinationSupported(@NonNull UseCase... useCaseArr) {
        synchronized (this.mLock) {
            try {
                try {
                    calculateSuggestedStreamSpecs(getCameraMode(), this.mCameraInternal.getCameraInfoInternal(), Arrays.asList(useCaseArr), Collections.EMPTY_LIST, getConfigs(Arrays.asList(useCaseArr), this.mCameraConfig.getUseCaseConfigFactory(), this.mUseCaseConfigFactory));
                } catch (IllegalArgumentException unused) {
                    return false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return true;
    }

    public void removeUseCases(@NonNull Collection<UseCase> collection) {
        synchronized (this.mLock) {
            LinkedHashSet linkedHashSet = new LinkedHashSet(this.mAppUseCases);
            linkedHashSet.removeAll(collection);
            updateUseCases(linkedHashSet);
        }
    }

    public void setActiveResumingMode(boolean z5) {
        this.mCameraInternal.setActiveResumingMode(z5);
    }

    public void setEffects(@Nullable List<CameraEffect> list) {
        synchronized (this.mLock) {
            this.mEffects = list;
        }
    }

    @Override // androidx.camera.core.Camera
    public void setExtendedConfig(@Nullable CameraConfig cameraConfig) {
        synchronized (this.mLock) {
            if (cameraConfig == null) {
                try {
                    cameraConfig = CameraConfigs.emptyConfig();
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (!this.mAppUseCases.isEmpty() && !this.mCameraConfig.getCompatibilityId().equals(cameraConfig.getCompatibilityId())) {
                throw new IllegalStateException("Need to unbind all use cases before binding with extension enabled");
            }
            this.mCameraConfig = cameraConfig;
            SessionProcessor sessionProcessor = cameraConfig.getSessionProcessor(null);
            if (sessionProcessor != null) {
                this.mRestrictedCameraControl.enableRestrictedOperations(true, sessionProcessor.getSupportedCameraOperations());
            } else {
                this.mRestrictedCameraControl.enableRestrictedOperations(false, null);
            }
            this.mCameraInternal.setExtendedConfig(this.mCameraConfig);
        }
    }

    public void setViewPort(@Nullable ViewPort viewPort) {
        synchronized (this.mLock) {
            this.mViewPort = viewPort;
        }
    }

    void updateUseCases(@NonNull Collection<UseCase> collection, boolean z5) {
        CameraUseCaseAdapter cameraUseCaseAdapter;
        StreamSpec streamSpec;
        Config implementationOptions;
        synchronized (this.mLock) {
            try {
            } catch (Throwable th) {
                th = th;
            }
            try {
                UseCase calculatePlaceholderForExtensions = calculatePlaceholderForExtensions(collection);
                StreamSharing createOrReuseStreamSharing = createOrReuseStreamSharing(collection, z5);
                Collection<UseCase> calculateCameraUseCases = calculateCameraUseCases(collection, calculatePlaceholderForExtensions, createOrReuseStreamSharing);
                ArrayList<UseCase> arrayList = new ArrayList(calculateCameraUseCases);
                arrayList.removeAll(this.mCameraUseCases);
                ArrayList<UseCase> arrayList2 = new ArrayList(calculateCameraUseCases);
                arrayList2.retainAll(this.mCameraUseCases);
                ArrayList arrayList3 = new ArrayList(this.mCameraUseCases);
                arrayList3.removeAll(calculateCameraUseCases);
                Map<UseCase, ConfigPair> configs = getConfigs(arrayList, this.mCameraConfig.getUseCaseConfigFactory(), this.mUseCaseConfigFactory);
                try {
                    cameraUseCaseAdapter = this;
                    try {
                        Map<UseCase, StreamSpec> calculateSuggestedStreamSpecs = cameraUseCaseAdapter.calculateSuggestedStreamSpecs(getCameraMode(), this.mCameraInternal.getCameraInfoInternal(), arrayList, arrayList2, configs);
                        updateViewPort(calculateSuggestedStreamSpecs, calculateCameraUseCases);
                        updateEffects(cameraUseCaseAdapter.mEffects, calculateCameraUseCases, collection);
                        Iterator it = arrayList3.iterator();
                        while (it.hasNext()) {
                            ((UseCase) it.next()).unbindFromCamera(cameraUseCaseAdapter.mCameraInternal);
                        }
                        cameraUseCaseAdapter.mCameraInternal.detachUseCases(arrayList3);
                        if (!arrayList3.isEmpty()) {
                            for (UseCase useCase : arrayList2) {
                                if (calculateSuggestedStreamSpecs.containsKey(useCase) && (implementationOptions = (streamSpec = calculateSuggestedStreamSpecs.get(useCase)).getImplementationOptions()) != null && hasImplementationOptionChanged(streamSpec, useCase.getSessionConfig())) {
                                    useCase.updateSuggestedStreamSpecImplementationOptions(implementationOptions);
                                }
                            }
                        }
                        for (UseCase useCase2 : arrayList) {
                            ConfigPair configPair = configs.get(useCase2);
                            Objects.requireNonNull(configPair);
                            useCase2.bindToCamera(cameraUseCaseAdapter.mCameraInternal, configPair.mExtendedConfig, configPair.mCameraConfig);
                            useCase2.updateSuggestedStreamSpec((StreamSpec) Preconditions.checkNotNull(calculateSuggestedStreamSpecs.get(useCase2)));
                        }
                        if (cameraUseCaseAdapter.mAttached) {
                            cameraUseCaseAdapter.mCameraInternal.attachUseCases(arrayList);
                        }
                        Iterator it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            ((UseCase) it2.next()).notifyState();
                        }
                        cameraUseCaseAdapter.mAppUseCases.clear();
                        cameraUseCaseAdapter.mAppUseCases.addAll(collection);
                        cameraUseCaseAdapter.mCameraUseCases.clear();
                        cameraUseCaseAdapter.mCameraUseCases.addAll(calculateCameraUseCases);
                        cameraUseCaseAdapter.mPlaceholderForExtensions = calculatePlaceholderForExtensions;
                        cameraUseCaseAdapter.mStreamSharing = createOrReuseStreamSharing;
                    } catch (IllegalArgumentException e6) {
                        e = e6;
                        if (z5 || !hasNoExtension() || cameraUseCaseAdapter.mCameraCoordinator.getCameraOperatingMode() == 2) {
                            throw e;
                        }
                        updateUseCases(collection, true);
                    }
                } catch (IllegalArgumentException e7) {
                    e = e7;
                    cameraUseCaseAdapter = this;
                }
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
        }
    }

    public CameraUseCaseAdapter(@NonNull LinkedHashSet<CameraInternal> linkedHashSet, @NonNull CameraCoordinator cameraCoordinator, @NonNull CameraDeviceSurfaceManager cameraDeviceSurfaceManager, @NonNull UseCaseConfigFactory useCaseConfigFactory) {
        CameraInternal next = linkedHashSet.iterator().next();
        this.mCameraInternal = next;
        LinkedHashSet<CameraInternal> linkedHashSet2 = new LinkedHashSet<>(linkedHashSet);
        this.mCameraInternals = linkedHashSet2;
        this.mId = new CameraId(linkedHashSet2);
        this.mCameraCoordinator = cameraCoordinator;
        this.mCameraDeviceSurfaceManager = cameraDeviceSurfaceManager;
        this.mUseCaseConfigFactory = useCaseConfigFactory;
        RestrictedCameraControl restrictedCameraControl = new RestrictedCameraControl(next.getCameraControlInternal());
        this.mRestrictedCameraControl = restrictedCameraControl;
        this.mRestrictedCameraInfo = new RestrictedCameraInfo(next.getCameraInfoInternal(), restrictedCameraControl);
    }

    public static /* synthetic */ void b(Surface surface, SurfaceTexture surfaceTexture, SurfaceRequest.Result result) {
        surface.release();
        surfaceTexture.release();
    }

    @NonNull
    private static Matrix calculateSensorToBufferTransformMatrix(@NonNull Rect rect, @NonNull Size size) {
        boolean z5;
        if (rect.width() > 0 && rect.height() > 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        Preconditions.checkArgument(z5, "Cannot compute viewport crop rects zero sized sensor rect.");
        RectF rectF = new RectF(rect);
        Matrix matrix = new Matrix();
        matrix.setRectToRect(new RectF(0.0f, 0.0f, size.getWidth(), size.getHeight()), rectF, Matrix.ScaleToFit.CENTER);
        matrix.invert(matrix);
        return matrix;
    }

    private static boolean hasImplementationOptionChanged(StreamSpec streamSpec, SessionConfig sessionConfig) {
        Config implementationOptions = streamSpec.getImplementationOptions();
        Config implementationOptions2 = sessionConfig.getImplementationOptions();
        if (implementationOptions.listOptions().size() != sessionConfig.getImplementationOptions().listOptions().size()) {
            return true;
        }
        for (Config.Option<?> option : implementationOptions.listOptions()) {
            if (!implementationOptions2.containsOption(option) || !Objects.equals(implementationOptions2.retrieveOption(option), implementationOptions.retrieveOption(option))) {
                return true;
            }
        }
        return false;
    }

    private boolean isExtraImageCaptureRequired(@NonNull Collection<UseCase> collection) {
        boolean z5 = false;
        boolean z6 = false;
        for (UseCase useCase : collection) {
            if (isPreview(useCase)) {
                z5 = true;
            } else if (isImageCapture(useCase)) {
                z6 = true;
            }
        }
        if (!z5 || z6) {
            return false;
        }
        return true;
    }

    private boolean isExtraPreviewRequired(@NonNull Collection<UseCase> collection) {
        boolean z5 = false;
        boolean z6 = false;
        for (UseCase useCase : collection) {
            if (isPreview(useCase)) {
                z6 = true;
            } else if (isImageCapture(useCase)) {
                z5 = true;
            }
        }
        if (!z5 || z6) {
            return false;
        }
        return true;
    }

    @VisibleForTesting
    static void updateEffects(@NonNull List<CameraEffect> list, @NonNull Collection<UseCase> collection, @NonNull Collection<UseCase> collection2) {
        List<CameraEffect> effectsOnUseCases = setEffectsOnUseCases(list, collection);
        ArrayList arrayList = new ArrayList(collection2);
        arrayList.removeAll(collection);
        List<CameraEffect> effectsOnUseCases2 = setEffectsOnUseCases(effectsOnUseCases, arrayList);
        if (effectsOnUseCases2.size() > 0) {
            Logger.w(TAG, "Unused effects: " + effectsOnUseCases2);
        }
    }
}
