package androidx.camera.lifecycle;

import android.content.Context;
import androidx.annotation.GuardedBy;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.arch.core.util.Function;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraEffect;
import androidx.camera.core.CameraFilter;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraInfoUnavailableException;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.CameraX;
import androidx.camera.core.CameraXConfig;
import androidx.camera.core.ConcurrentCamera;
import androidx.camera.core.UseCase;
import androidx.camera.core.UseCaseGroup;
import androidx.camera.core.ViewPort;
import androidx.camera.core.impl.CameraConfig;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.ExtendedCameraConfigProviderStore;
import androidx.camera.core.impl.utils.ContextUtil;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.FutureChain;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.internal.CameraUseCaseAdapter;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import androidx.lifecycle.LifecycleOwner;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public final class ProcessCameraProvider implements LifecycleCameraProvider {
    private static final ProcessCameraProvider sAppInstance = new ProcessCameraProvider();
    private CameraX mCameraX;

    @GuardedBy("mLock")
    private ListenableFuture<CameraX> mCameraXInitializeFuture;
    private Context mContext;
    private final Object mLock = new Object();

    @GuardedBy("mLock")
    private CameraXConfig.Provider mCameraXConfigProvider = null;

    @GuardedBy("mLock")
    private ListenableFuture<Void> mCameraXShutdownFuture = Futures.immediateFuture(null);
    private final LifecycleCameraRepository mLifecycleCameraRepository = new LifecycleCameraRepository();

    @NonNull
    @MainThread
    public Camera bindToLifecycle(@NonNull LifecycleOwner lifecycleOwner, @NonNull CameraSelector cameraSelector, @NonNull UseCase... useCaseArr) {
        if (getCameraOperatingMode() == 2) {
            throw new UnsupportedOperationException("bindToLifecycle for single camera is not supported in concurrent camera mode, call unbindAll() first");
        }
        setCameraOperatingMode(1);
        return bindToLifecycle(lifecycleOwner, cameraSelector, null, Collections.EMPTY_LIST, useCaseArr);
    }

    public static /* synthetic */ Object a(ProcessCameraProvider processCameraProvider, final CameraX cameraX, final CallbackToFutureAdapter.Completer completer) {
        synchronized (processCameraProvider.mLock) {
            Futures.addCallback(FutureChain.from(processCameraProvider.mCameraXShutdownFuture).transformAsync(new AsyncFunction() { // from class: androidx.camera.lifecycle.e
                @Override // androidx.camera.core.impl.utils.futures.AsyncFunction
                public final ListenableFuture apply(Object obj) {
                    ListenableFuture initializeFuture;
                    initializeFuture = CameraX.this.getInitializeFuture();
                    return initializeFuture;
                }
            }, CameraXExecutors.directExecutor()), new FutureCallback<Void>() { // from class: androidx.camera.lifecycle.ProcessCameraProvider.1
                @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                public void onFailure(@NonNull Throwable th) {
                    completer.setException(th);
                }

                @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                public void onSuccess(@Nullable Void r22) {
                    completer.set(cameraX);
                }
            }, CameraXExecutors.directExecutor());
        }
        return "ProcessCameraProvider-initializeCameraX";
    }

    @ExperimentalCameraProviderConfiguration
    public static void configureInstance(@NonNull CameraXConfig cameraXConfig) {
        sAppInstance.configureInstanceInternal(cameraXConfig);
    }

    private void configureInstanceInternal(@NonNull final CameraXConfig cameraXConfig) {
        synchronized (this.mLock) {
            Preconditions.checkNotNull(cameraXConfig);
            Preconditions.checkState(this.mCameraXConfigProvider == null, "CameraX has already been configured. To use a different configuration, shutdown() must be called.");
            this.mCameraXConfigProvider = new CameraXConfig.Provider() { // from class: androidx.camera.lifecycle.b
                @Override // androidx.camera.core.CameraXConfig.Provider
                public final CameraXConfig getCameraXConfig() {
                    return ProcessCameraProvider.c(CameraXConfig.this);
                }
            };
        }
    }

    public static /* synthetic */ ProcessCameraProvider e(Context context, CameraX cameraX) {
        ProcessCameraProvider processCameraProvider = sAppInstance;
        processCameraProvider.setCameraX(cameraX);
        processCameraProvider.setContext(ContextUtil.getApplicationContext(context));
        return processCameraProvider;
    }

    @NonNull
    private List<CameraInfo> getActiveConcurrentCameraInfos() {
        CameraX cameraX = this.mCameraX;
        return cameraX == null ? new ArrayList() : cameraX.getCameraFactory().getCameraCoordinator().getActiveConcurrentCameraInfos();
    }

    private int getCameraOperatingMode() {
        CameraX cameraX = this.mCameraX;
        if (cameraX == null) {
            return 0;
        }
        return cameraX.getCameraFactory().getCameraCoordinator().getCameraOperatingMode();
    }

    private ListenableFuture<CameraX> getOrCreateCameraXInstance(@NonNull Context context) {
        synchronized (this.mLock) {
            try {
                ListenableFuture<CameraX> listenableFuture = this.mCameraXInitializeFuture;
                if (listenableFuture != null) {
                    return listenableFuture;
                }
                final CameraX cameraX = new CameraX(context, this.mCameraXConfigProvider);
                ListenableFuture<CameraX> future = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.lifecycle.a
                    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                        return ProcessCameraProvider.a(ProcessCameraProvider.this, cameraX, completer);
                    }
                });
                this.mCameraXInitializeFuture = future;
                return future;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void setActiveConcurrentCameraInfos(@NonNull List<CameraInfo> list) {
        CameraX cameraX = this.mCameraX;
        if (cameraX == null) {
            return;
        }
        cameraX.getCameraFactory().getCameraCoordinator().setActiveConcurrentCameraInfos(list);
    }

    private void setCameraOperatingMode(int i6) {
        CameraX cameraX = this.mCameraX;
        if (cameraX == null) {
            return;
        }
        cameraX.getCameraFactory().getCameraCoordinator().setCameraOperatingMode(i6);
    }

    private void setCameraX(CameraX cameraX) {
        this.mCameraX = cameraX;
    }

    private void setContext(Context context) {
        this.mContext = context;
    }

    @Override // androidx.camera.core.CameraProvider
    @NonNull
    public List<CameraInfo> getAvailableCameraInfos() {
        ArrayList arrayList = new ArrayList();
        Iterator<CameraInternal> it = this.mCameraX.getCameraRepository().getCameras().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getCameraInfo());
        }
        return arrayList;
    }

    @NonNull
    public List<List<CameraInfo>> getAvailableConcurrentCameraInfos() {
        Objects.requireNonNull(this.mCameraX);
        Objects.requireNonNull(this.mCameraX.getCameraFactory().getCameraCoordinator());
        List<List<CameraSelector>> concurrentCameraSelectors = this.mCameraX.getCameraFactory().getCameraCoordinator().getConcurrentCameraSelectors();
        List<CameraInfo> availableCameraInfos = getAvailableCameraInfos();
        ArrayList arrayList = new ArrayList();
        for (List<CameraSelector> list : concurrentCameraSelectors) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<CameraSelector> it = list.iterator();
            while (it.hasNext()) {
                CameraInfo cameraInfoFromCameraSelector = getCameraInfoFromCameraSelector(it.next(), availableCameraInfos);
                if (cameraInfoFromCameraSelector != null) {
                    arrayList2.add(cameraInfoFromCameraSelector);
                }
            }
            arrayList.add(arrayList2);
        }
        return arrayList;
    }

    @Override // androidx.camera.core.CameraProvider
    public boolean hasCamera(@NonNull CameraSelector cameraSelector) throws CameraInfoUnavailableException {
        try {
            cameraSelector.select(this.mCameraX.getCameraRepository().getCameras());
            return true;
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    @Override // androidx.camera.lifecycle.LifecycleCameraProvider
    public boolean isBound(@NonNull UseCase useCase) {
        Iterator<LifecycleCamera> it = this.mLifecycleCameraRepository.getLifecycleCameras().iterator();
        while (it.hasNext()) {
            if (it.next().isBound(useCase)) {
                return true;
            }
        }
        return false;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @VisibleForTesting
    public ListenableFuture<Void> shutdown() {
        Threads.runOnMainSync(new Runnable() { // from class: androidx.camera.lifecycle.c
            @Override // java.lang.Runnable
            public final void run() {
                ProcessCameraProvider.d(ProcessCameraProvider.this);
            }
        });
        CameraX cameraX = this.mCameraX;
        if (cameraX != null) {
            cameraX.getCameraFactory().getCameraCoordinator().shutdown();
        }
        CameraX cameraX2 = this.mCameraX;
        ListenableFuture<Void> shutdown = cameraX2 != null ? cameraX2.shutdown() : Futures.immediateFuture(null);
        synchronized (this.mLock) {
            this.mCameraXConfigProvider = null;
            this.mCameraXInitializeFuture = null;
            this.mCameraXShutdownFuture = shutdown;
        }
        this.mCameraX = null;
        this.mContext = null;
        return shutdown;
    }

    private ProcessCameraProvider() {
    }

    public static /* synthetic */ void d(ProcessCameraProvider processCameraProvider) {
        processCameraProvider.unbindAll();
        processCameraProvider.mLifecycleCameraRepository.clear();
    }

    @Nullable
    private CameraInfo getCameraInfoFromCameraSelector(@NonNull CameraSelector cameraSelector, @NonNull List<CameraInfo> list) {
        List<CameraInfo> filter = cameraSelector.filter(list);
        if (filter.isEmpty()) {
            return null;
        }
        return filter.get(0);
    }

    @NonNull
    public static ListenableFuture<ProcessCameraProvider> getInstance(@NonNull final Context context) {
        Preconditions.checkNotNull(context);
        return Futures.transform(sAppInstance.getOrCreateCameraXInstance(context), new Function() { // from class: androidx.camera.lifecycle.d
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return ProcessCameraProvider.e(context, (CameraX) obj);
            }
        }, CameraXExecutors.directExecutor());
    }

    @MainThread
    public boolean isConcurrentCameraModeOn() {
        if (getCameraOperatingMode() == 2) {
            return true;
        }
        return false;
    }

    @Override // androidx.camera.lifecycle.LifecycleCameraProvider
    @MainThread
    public void unbind(@NonNull UseCase... useCaseArr) {
        Threads.checkMainThread();
        if (getCameraOperatingMode() != 2) {
            this.mLifecycleCameraRepository.unbind(Arrays.asList(useCaseArr));
            return;
        }
        throw new UnsupportedOperationException("unbind usecase is not supported in concurrent camera mode, call unbindAll() first");
    }

    @Override // androidx.camera.lifecycle.LifecycleCameraProvider
    @MainThread
    public void unbindAll() {
        Threads.checkMainThread();
        setCameraOperatingMode(0);
        this.mLifecycleCameraRepository.unbindAll();
    }

    @NonNull
    @MainThread
    public Camera bindToLifecycle(@NonNull LifecycleOwner lifecycleOwner, @NonNull CameraSelector cameraSelector, @NonNull UseCaseGroup useCaseGroup) {
        if (getCameraOperatingMode() != 2) {
            setCameraOperatingMode(1);
            return bindToLifecycle(lifecycleOwner, cameraSelector, useCaseGroup.getViewPort(), useCaseGroup.getEffects(), (UseCase[]) useCaseGroup.getUseCases().toArray(new UseCase[0]));
        }
        throw new UnsupportedOperationException("bindToLifecycle for single camera is not supported in concurrent camera mode, call unbindAll() first");
    }

    @NonNull
    @MainThread
    public ConcurrentCamera bindToLifecycle(@NonNull List<ConcurrentCamera.SingleCameraConfig> list) {
        if (this.mContext.getPackageManager().hasSystemFeature("android.hardware.camera.concurrent")) {
            if (getCameraOperatingMode() != 1) {
                if (list.size() >= 2) {
                    if (list.size() <= 2) {
                        ArrayList arrayList = new ArrayList();
                        List<CameraInfo> availableCameraInfos = getAvailableCameraInfos();
                        CameraInfo cameraInfoFromCameraSelector = getCameraInfoFromCameraSelector(list.get(0).getCameraSelector(), availableCameraInfos);
                        CameraInfo cameraInfoFromCameraSelector2 = getCameraInfoFromCameraSelector(list.get(1).getCameraSelector(), availableCameraInfos);
                        if (cameraInfoFromCameraSelector != null && cameraInfoFromCameraSelector2 != null) {
                            arrayList.add(cameraInfoFromCameraSelector);
                            arrayList.add(cameraInfoFromCameraSelector2);
                            if (!getActiveConcurrentCameraInfos().isEmpty() && !arrayList.equals(getActiveConcurrentCameraInfos())) {
                                throw new UnsupportedOperationException("Cameras are already running, call unbindAll() before binding more cameras");
                            }
                            setCameraOperatingMode(2);
                            ArrayList arrayList2 = new ArrayList();
                            for (ConcurrentCamera.SingleCameraConfig singleCameraConfig : list) {
                                arrayList2.add(bindToLifecycle(singleCameraConfig.getLifecycleOwner(), singleCameraConfig.getCameraSelector(), singleCameraConfig.getUseCaseGroup().getViewPort(), singleCameraConfig.getUseCaseGroup().getEffects(), (UseCase[]) singleCameraConfig.getUseCaseGroup().getUseCases().toArray(new UseCase[0])));
                            }
                            setActiveConcurrentCameraInfos(arrayList);
                            return new ConcurrentCamera(arrayList2);
                        }
                        throw new IllegalArgumentException("Invalid camera selectors in camera configs");
                    }
                    throw new IllegalArgumentException("Concurrent camera is only supporting two  cameras at maximum.");
                }
                throw new IllegalArgumentException("Concurrent camera needs two camera configs");
            }
            throw new UnsupportedOperationException("Camera is already running, call unbindAll() before binding more cameras");
        }
        throw new UnsupportedOperationException("Concurrent camera is not supported on the device");
    }

    public static /* synthetic */ CameraXConfig c(CameraXConfig cameraXConfig) {
        return cameraXConfig;
    }

    @NonNull
    Camera bindToLifecycle(@NonNull LifecycleOwner lifecycleOwner, @NonNull CameraSelector cameraSelector, @Nullable ViewPort viewPort, @NonNull List<CameraEffect> list, @NonNull UseCase... useCaseArr) {
        CameraConfig cameraConfig;
        CameraConfig config;
        Threads.checkMainThread();
        CameraSelector.Builder fromSelector = CameraSelector.Builder.fromSelector(cameraSelector);
        int length = useCaseArr.length;
        int i6 = 0;
        while (true) {
            cameraConfig = null;
            if (i6 >= length) {
                break;
            }
            CameraSelector cameraSelector2 = useCaseArr[i6].getCurrentConfig().getCameraSelector(null);
            if (cameraSelector2 != null) {
                Iterator<CameraFilter> it = cameraSelector2.getCameraFilterSet().iterator();
                while (it.hasNext()) {
                    fromSelector.addCameraFilter(it.next());
                }
            }
            i6++;
        }
        LinkedHashSet<CameraInternal> filter = fromSelector.build().filter(this.mCameraX.getCameraRepository().getCameras());
        if (!filter.isEmpty()) {
            LifecycleCamera lifecycleCamera = this.mLifecycleCameraRepository.getLifecycleCamera(lifecycleOwner, CameraUseCaseAdapter.generateCameraId(filter));
            Collection<LifecycleCamera> lifecycleCameras = this.mLifecycleCameraRepository.getLifecycleCameras();
            for (UseCase useCase : useCaseArr) {
                for (LifecycleCamera lifecycleCamera2 : lifecycleCameras) {
                    if (lifecycleCamera2.isBound(useCase) && lifecycleCamera2 != lifecycleCamera) {
                        throw new IllegalStateException(String.format("Use case %s already bound to a different lifecycle.", useCase));
                    }
                }
            }
            if (lifecycleCamera == null) {
                lifecycleCamera = this.mLifecycleCameraRepository.createLifecycleCamera(lifecycleOwner, new CameraUseCaseAdapter(filter, this.mCameraX.getCameraFactory().getCameraCoordinator(), this.mCameraX.getCameraDeviceSurfaceManager(), this.mCameraX.getDefaultConfigFactory()));
            }
            LifecycleCamera lifecycleCamera3 = lifecycleCamera;
            Iterator<CameraFilter> it2 = cameraSelector.getCameraFilterSet().iterator();
            while (it2.hasNext()) {
                CameraFilter next = it2.next();
                if (next.getIdentifier() != CameraFilter.DEFAULT_ID && (config = ExtendedCameraConfigProviderStore.getConfigProvider(next.getIdentifier()).getConfig(lifecycleCamera3.getCameraInfo(), this.mContext)) != null) {
                    if (cameraConfig != null) {
                        throw new IllegalArgumentException("Cannot apply multiple extended camera configs at the same time.");
                    }
                    cameraConfig = config;
                }
            }
            lifecycleCamera3.setExtendedConfig(cameraConfig);
            if (useCaseArr.length == 0) {
                return lifecycleCamera3;
            }
            this.mLifecycleCameraRepository.bindToLifecycleCamera(lifecycleCamera3, viewPort, list, Arrays.asList(useCaseArr), this.mCameraX.getCameraFactory().getCameraCoordinator());
            return lifecycleCamera3;
        }
        throw new IllegalArgumentException("Provided camera selector unable to resolve a camera for the given use case");
    }
}
