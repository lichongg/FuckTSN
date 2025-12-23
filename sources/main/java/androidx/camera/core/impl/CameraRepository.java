package androidx.camera.core.impl;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.CameraUnavailableException;
import androidx.camera.core.InitializationException;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public final class CameraRepository {
    private static final String TAG = "CameraRepository";

    @GuardedBy("mCamerasLock")
    private CallbackToFutureAdapter.Completer<Void> mDeinitCompleter;

    @GuardedBy("mCamerasLock")
    private ListenableFuture<Void> mDeinitFuture;
    private final Object mCamerasLock = new Object();

    @GuardedBy("mCamerasLock")
    private final Map<String, CameraInternal> mCameras = new LinkedHashMap();

    @GuardedBy("mCamerasLock")
    private final Set<CameraInternal> mReleasingCameras = new HashSet();

    public static /* synthetic */ void a(CameraRepository cameraRepository, CameraInternal cameraInternal) {
        synchronized (cameraRepository.mCamerasLock) {
            try {
                cameraRepository.mReleasingCameras.remove(cameraInternal);
                if (cameraRepository.mReleasingCameras.isEmpty()) {
                    Preconditions.checkNotNull(cameraRepository.mDeinitCompleter);
                    cameraRepository.mDeinitCompleter.set(null);
                    cameraRepository.mDeinitCompleter = null;
                    cameraRepository.mDeinitFuture = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static /* synthetic */ Object b(CameraRepository cameraRepository, CallbackToFutureAdapter.Completer completer) {
        synchronized (cameraRepository.mCamerasLock) {
            cameraRepository.mDeinitCompleter = completer;
        }
        return "CameraRepository-deinit";
    }

    @NonNull
    public ListenableFuture<Void> deinit() {
        synchronized (this.mCamerasLock) {
            try {
                if (this.mCameras.isEmpty()) {
                    ListenableFuture<Void> listenableFuture = this.mDeinitFuture;
                    if (listenableFuture == null) {
                        listenableFuture = Futures.immediateFuture(null);
                    }
                    return listenableFuture;
                }
                ListenableFuture<Void> listenableFuture2 = this.mDeinitFuture;
                if (listenableFuture2 == null) {
                    listenableFuture2 = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.core.impl.k
                        @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                        public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                            return CameraRepository.b(CameraRepository.this, completer);
                        }
                    });
                    this.mDeinitFuture = listenableFuture2;
                }
                this.mReleasingCameras.addAll(this.mCameras.values());
                for (final CameraInternal cameraInternal : this.mCameras.values()) {
                    cameraInternal.release().addListener(new Runnable() { // from class: androidx.camera.core.impl.l
                        @Override // java.lang.Runnable
                        public final void run() {
                            CameraRepository.a(CameraRepository.this, cameraInternal);
                        }
                    }, CameraXExecutors.directExecutor());
                }
                this.mCameras.clear();
                return listenableFuture2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @NonNull
    public CameraInternal getCamera(@NonNull String str) {
        CameraInternal cameraInternal;
        synchronized (this.mCamerasLock) {
            try {
                cameraInternal = this.mCameras.get(str);
                if (cameraInternal == null) {
                    throw new IllegalArgumentException("Invalid camera: " + str);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cameraInternal;
    }

    @NonNull
    Set<String> getCameraIds() {
        LinkedHashSet linkedHashSet;
        synchronized (this.mCamerasLock) {
            linkedHashSet = new LinkedHashSet(this.mCameras.keySet());
        }
        return linkedHashSet;
    }

    @NonNull
    public LinkedHashSet<CameraInternal> getCameras() {
        LinkedHashSet<CameraInternal> linkedHashSet;
        synchronized (this.mCamerasLock) {
            linkedHashSet = new LinkedHashSet<>(this.mCameras.values());
        }
        return linkedHashSet;
    }

    public void init(@NonNull CameraFactory cameraFactory) throws InitializationException {
        synchronized (this.mCamerasLock) {
            try {
                for (String str : cameraFactory.getAvailableCameraIds()) {
                    Logger.d(TAG, "Added camera: " + str);
                    this.mCameras.put(str, cameraFactory.getCamera(str));
                }
            } catch (CameraUnavailableException e6) {
                throw new InitializationException(e6);
            }
        }
    }
}
