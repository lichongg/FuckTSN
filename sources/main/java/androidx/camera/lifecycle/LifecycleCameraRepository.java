package androidx.camera.lifecycle;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.UseCase;
import androidx.camera.core.concurrent.CameraCoordinator;
import androidx.camera.core.internal.CameraUseCaseAdapter;
import androidx.core.util.Preconditions;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.google.auto.value.AutoValue;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
final class LifecycleCameraRepository {

    @Nullable
    @GuardedBy("mLock")
    CameraCoordinator mCameraCoordinator;
    private final Object mLock = new Object();

    @GuardedBy("mLock")
    private final Map<Key, LifecycleCamera> mCameraMap = new HashMap();

    @GuardedBy("mLock")
    private final Map<LifecycleCameraRepositoryObserver, Set<Key>> mLifecycleObserverMap = new HashMap();

    @GuardedBy("mLock")
    private final ArrayDeque<LifecycleOwner> mActiveLifecycleOwners = new ArrayDeque<>();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @AutoValue
    static abstract class Key {
        @NonNull
        public abstract CameraUseCaseAdapter.CameraId getCameraId();

        @NonNull
        public abstract LifecycleOwner getLifecycleOwner();

        static Key create(@NonNull LifecycleOwner lifecycleOwner, @NonNull CameraUseCaseAdapter.CameraId cameraId) {
            return new AutoValue_LifecycleCameraRepository_Key(lifecycleOwner, cameraId);
        }

        Key() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class LifecycleCameraRepositoryObserver implements LifecycleObserver {
        private final LifecycleCameraRepository mLifecycleCameraRepository;
        private final LifecycleOwner mLifecycleOwner;

        LifecycleOwner getLifecycleOwner() {
            return this.mLifecycleOwner;
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        public void onDestroy(LifecycleOwner lifecycleOwner) {
            this.mLifecycleCameraRepository.unregisterLifecycle(lifecycleOwner);
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_START)
        public void onStart(LifecycleOwner lifecycleOwner) {
            this.mLifecycleCameraRepository.setActive(lifecycleOwner);
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
        public void onStop(LifecycleOwner lifecycleOwner) {
            this.mLifecycleCameraRepository.setInactive(lifecycleOwner);
        }

        LifecycleCameraRepositoryObserver(LifecycleOwner lifecycleOwner, LifecycleCameraRepository lifecycleCameraRepository) {
            this.mLifecycleOwner = lifecycleOwner;
            this.mLifecycleCameraRepository = lifecycleCameraRepository;
        }
    }

    private LifecycleCameraRepositoryObserver getLifecycleCameraRepositoryObserver(LifecycleOwner lifecycleOwner) {
        synchronized (this.mLock) {
            try {
                for (LifecycleCameraRepositoryObserver lifecycleCameraRepositoryObserver : this.mLifecycleObserverMap.keySet()) {
                    if (lifecycleOwner.equals(lifecycleCameraRepositoryObserver.getLifecycleOwner())) {
                        return lifecycleCameraRepositoryObserver;
                    }
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private boolean hasUseCaseBound(LifecycleOwner lifecycleOwner) {
        synchronized (this.mLock) {
            try {
                LifecycleCameraRepositoryObserver lifecycleCameraRepositoryObserver = getLifecycleCameraRepositoryObserver(lifecycleOwner);
                if (lifecycleCameraRepositoryObserver == null) {
                    return false;
                }
                Iterator<Key> it = this.mLifecycleObserverMap.get(lifecycleCameraRepositoryObserver).iterator();
                while (it.hasNext()) {
                    if (!((LifecycleCamera) Preconditions.checkNotNull(this.mCameraMap.get(it.next()))).getUseCases().isEmpty()) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void registerCamera(LifecycleCamera lifecycleCamera) {
        synchronized (this.mLock) {
            try {
                LifecycleOwner lifecycleOwner = lifecycleCamera.getLifecycleOwner();
                Key create = Key.create(lifecycleOwner, lifecycleCamera.getCameraUseCaseAdapter().getCameraId());
                LifecycleCameraRepositoryObserver lifecycleCameraRepositoryObserver = getLifecycleCameraRepositoryObserver(lifecycleOwner);
                Set<Key> hashSet = lifecycleCameraRepositoryObserver != null ? this.mLifecycleObserverMap.get(lifecycleCameraRepositoryObserver) : new HashSet<>();
                hashSet.add(create);
                this.mCameraMap.put(create, lifecycleCamera);
                if (lifecycleCameraRepositoryObserver == null) {
                    LifecycleCameraRepositoryObserver lifecycleCameraRepositoryObserver2 = new LifecycleCameraRepositoryObserver(lifecycleOwner, this);
                    this.mLifecycleObserverMap.put(lifecycleCameraRepositoryObserver2, hashSet);
                    lifecycleOwner.getLifecycle().addObserver(lifecycleCameraRepositoryObserver2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void suspendUseCases(LifecycleOwner lifecycleOwner) {
        synchronized (this.mLock) {
            try {
                LifecycleCameraRepositoryObserver lifecycleCameraRepositoryObserver = getLifecycleCameraRepositoryObserver(lifecycleOwner);
                if (lifecycleCameraRepositoryObserver == null) {
                    return;
                }
                Iterator<Key> it = this.mLifecycleObserverMap.get(lifecycleCameraRepositoryObserver).iterator();
                while (it.hasNext()) {
                    ((LifecycleCamera) Preconditions.checkNotNull(this.mCameraMap.get(it.next()))).suspend();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void unsuspendUseCases(LifecycleOwner lifecycleOwner) {
        synchronized (this.mLock) {
            try {
                Iterator<Key> it = this.mLifecycleObserverMap.get(getLifecycleCameraRepositoryObserver(lifecycleOwner)).iterator();
                while (it.hasNext()) {
                    LifecycleCamera lifecycleCamera = this.mCameraMap.get(it.next());
                    if (!((LifecycleCamera) Preconditions.checkNotNull(lifecycleCamera)).getUseCases().isEmpty()) {
                        lifecycleCamera.unsuspend();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0084 A[Catch: all -> 0x002a, TryCatch #1 {all -> 0x002a, blocks: (B:4:0x0003, B:6:0x0022, B:10:0x0063, B:11:0x0074, B:13:0x0084, B:14:0x0087, B:19:0x008a, B:20:0x0093, B:21:0x002c, B:22:0x0030, B:24:0x0036, B:27:0x0050, B:33:0x005b, B:34:0x0062), top: B:3:0x0003, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void bindToLifecycleCamera(@androidx.annotation.NonNull androidx.camera.lifecycle.LifecycleCamera r5, @androidx.annotation.Nullable androidx.camera.core.ViewPort r6, @androidx.annotation.NonNull java.util.List<androidx.camera.core.CameraEffect> r7, @androidx.annotation.NonNull java.util.Collection<androidx.camera.core.UseCase> r8, @androidx.annotation.Nullable androidx.camera.core.concurrent.CameraCoordinator r9) {
        /*
            r4 = this;
            java.lang.Object r0 = r4.mLock
            monitor-enter(r0)
            boolean r1 = r8.isEmpty()     // Catch: java.lang.Throwable -> L2a
            r1 = r1 ^ 1
            androidx.core.util.Preconditions.checkArgument(r1)     // Catch: java.lang.Throwable -> L2a
            r4.mCameraCoordinator = r9     // Catch: java.lang.Throwable -> L2a
            androidx.lifecycle.LifecycleOwner r9 = r5.getLifecycleOwner()     // Catch: java.lang.Throwable -> L2a
            androidx.camera.lifecycle.LifecycleCameraRepository$LifecycleCameraRepositoryObserver r1 = r4.getLifecycleCameraRepositoryObserver(r9)     // Catch: java.lang.Throwable -> L2a
            java.util.Map<androidx.camera.lifecycle.LifecycleCameraRepository$LifecycleCameraRepositoryObserver, java.util.Set<androidx.camera.lifecycle.LifecycleCameraRepository$Key>> r2 = r4.mLifecycleObserverMap     // Catch: java.lang.Throwable -> L2a
            java.lang.Object r1 = r2.get(r1)     // Catch: java.lang.Throwable -> L2a
            java.util.Set r1 = (java.util.Set) r1     // Catch: java.lang.Throwable -> L2a
            androidx.camera.core.concurrent.CameraCoordinator r2 = r4.mCameraCoordinator     // Catch: java.lang.Throwable -> L2a
            if (r2 == 0) goto L2c
            int r2 = r2.getCameraOperatingMode()     // Catch: java.lang.Throwable -> L2a
            r3 = 2
            if (r2 == r3) goto L63
            goto L2c
        L2a:
            r5 = move-exception
            goto L94
        L2c:
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Throwable -> L2a
        L30:
            boolean r2 = r1.hasNext()     // Catch: java.lang.Throwable -> L2a
            if (r2 == 0) goto L63
            java.lang.Object r2 = r1.next()     // Catch: java.lang.Throwable -> L2a
            androidx.camera.lifecycle.LifecycleCameraRepository$Key r2 = (androidx.camera.lifecycle.LifecycleCameraRepository.Key) r2     // Catch: java.lang.Throwable -> L2a
            java.util.Map<androidx.camera.lifecycle.LifecycleCameraRepository$Key, androidx.camera.lifecycle.LifecycleCamera> r3 = r4.mCameraMap     // Catch: java.lang.Throwable -> L2a
            java.lang.Object r2 = r3.get(r2)     // Catch: java.lang.Throwable -> L2a
            androidx.camera.lifecycle.LifecycleCamera r2 = (androidx.camera.lifecycle.LifecycleCamera) r2     // Catch: java.lang.Throwable -> L2a
            java.lang.Object r2 = androidx.core.util.Preconditions.checkNotNull(r2)     // Catch: java.lang.Throwable -> L2a
            androidx.camera.lifecycle.LifecycleCamera r2 = (androidx.camera.lifecycle.LifecycleCamera) r2     // Catch: java.lang.Throwable -> L2a
            boolean r3 = r2.equals(r5)     // Catch: java.lang.Throwable -> L2a
            if (r3 != 0) goto L30
            java.util.List r2 = r2.getUseCases()     // Catch: java.lang.Throwable -> L2a
            boolean r2 = r2.isEmpty()     // Catch: java.lang.Throwable -> L2a
            if (r2 == 0) goto L5b
            goto L30
        L5b:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException     // Catch: java.lang.Throwable -> L2a
            java.lang.String r6 = "Multiple LifecycleCameras with use cases are registered to the same LifecycleOwner."
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L2a
            throw r5     // Catch: java.lang.Throwable -> L2a
        L63:
            androidx.camera.core.internal.CameraUseCaseAdapter r1 = r5.getCameraUseCaseAdapter()     // Catch: java.lang.Throwable -> L2a androidx.camera.core.internal.CameraUseCaseAdapter.CameraException -> L89
            r1.setViewPort(r6)     // Catch: java.lang.Throwable -> L2a androidx.camera.core.internal.CameraUseCaseAdapter.CameraException -> L89
            androidx.camera.core.internal.CameraUseCaseAdapter r6 = r5.getCameraUseCaseAdapter()     // Catch: java.lang.Throwable -> L2a androidx.camera.core.internal.CameraUseCaseAdapter.CameraException -> L89
            r6.setEffects(r7)     // Catch: java.lang.Throwable -> L2a androidx.camera.core.internal.CameraUseCaseAdapter.CameraException -> L89
            r5.bind(r8)     // Catch: java.lang.Throwable -> L2a androidx.camera.core.internal.CameraUseCaseAdapter.CameraException -> L89
            androidx.lifecycle.Lifecycle r5 = r9.getLifecycle()     // Catch: java.lang.Throwable -> L2a
            androidx.lifecycle.Lifecycle$State r5 = r5.getCurrentState()     // Catch: java.lang.Throwable -> L2a
            androidx.lifecycle.Lifecycle$State r6 = androidx.lifecycle.Lifecycle.State.STARTED     // Catch: java.lang.Throwable -> L2a
            boolean r5 = r5.isAtLeast(r6)     // Catch: java.lang.Throwable -> L2a
            if (r5 == 0) goto L87
            r4.setActive(r9)     // Catch: java.lang.Throwable -> L2a
        L87:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L2a
            return
        L89:
            r5 = move-exception
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException     // Catch: java.lang.Throwable -> L2a
            java.lang.String r5 = r5.getMessage()     // Catch: java.lang.Throwable -> L2a
            r6.<init>(r5)     // Catch: java.lang.Throwable -> L2a
            throw r6     // Catch: java.lang.Throwable -> L2a
        L94:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L2a
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.lifecycle.LifecycleCameraRepository.bindToLifecycleCamera(androidx.camera.lifecycle.LifecycleCamera, androidx.camera.core.ViewPort, java.util.List, java.util.Collection, androidx.camera.core.concurrent.CameraCoordinator):void");
    }

    void clear() {
        synchronized (this.mLock) {
            try {
                Iterator it = new HashSet(this.mLifecycleObserverMap.keySet()).iterator();
                while (it.hasNext()) {
                    unregisterLifecycle(((LifecycleCameraRepositoryObserver) it.next()).getLifecycleOwner());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    LifecycleCamera createLifecycleCamera(@NonNull LifecycleOwner lifecycleOwner, @NonNull CameraUseCaseAdapter cameraUseCaseAdapter) {
        LifecycleCamera lifecycleCamera;
        synchronized (this.mLock) {
            try {
                Preconditions.checkArgument(this.mCameraMap.get(Key.create(lifecycleOwner, cameraUseCaseAdapter.getCameraId())) == null, "LifecycleCamera already exists for the given LifecycleOwner and set of cameras");
                if (lifecycleOwner.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) {
                    throw new IllegalArgumentException("Trying to create LifecycleCamera with destroyed lifecycle.");
                }
                lifecycleCamera = new LifecycleCamera(lifecycleOwner, cameraUseCaseAdapter);
                if (cameraUseCaseAdapter.getUseCases().isEmpty()) {
                    lifecycleCamera.suspend();
                }
                registerCamera(lifecycleCamera);
            } catch (Throwable th) {
                throw th;
            }
        }
        return lifecycleCamera;
    }

    @Nullable
    LifecycleCamera getLifecycleCamera(LifecycleOwner lifecycleOwner, CameraUseCaseAdapter.CameraId cameraId) {
        LifecycleCamera lifecycleCamera;
        synchronized (this.mLock) {
            lifecycleCamera = this.mCameraMap.get(Key.create(lifecycleOwner, cameraId));
        }
        return lifecycleCamera;
    }

    Collection<LifecycleCamera> getLifecycleCameras() {
        Collection<LifecycleCamera> unmodifiableCollection;
        synchronized (this.mLock) {
            unmodifiableCollection = Collections.unmodifiableCollection(this.mCameraMap.values());
        }
        return unmodifiableCollection;
    }

    void setActive(LifecycleOwner lifecycleOwner) {
        synchronized (this.mLock) {
            try {
                if (hasUseCaseBound(lifecycleOwner)) {
                    if (this.mActiveLifecycleOwners.isEmpty()) {
                        this.mActiveLifecycleOwners.push(lifecycleOwner);
                    } else {
                        CameraCoordinator cameraCoordinator = this.mCameraCoordinator;
                        if (cameraCoordinator == null || cameraCoordinator.getCameraOperatingMode() != 2) {
                            LifecycleOwner peek = this.mActiveLifecycleOwners.peek();
                            if (!lifecycleOwner.equals(peek)) {
                                suspendUseCases(peek);
                                this.mActiveLifecycleOwners.remove(lifecycleOwner);
                                this.mActiveLifecycleOwners.push(lifecycleOwner);
                            }
                        }
                    }
                    unsuspendUseCases(lifecycleOwner);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void setInactive(LifecycleOwner lifecycleOwner) {
        synchronized (this.mLock) {
            try {
                this.mActiveLifecycleOwners.remove(lifecycleOwner);
                suspendUseCases(lifecycleOwner);
                if (!this.mActiveLifecycleOwners.isEmpty()) {
                    unsuspendUseCases(this.mActiveLifecycleOwners.peek());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void unbind(@NonNull Collection<UseCase> collection) {
        synchronized (this.mLock) {
            try {
                Iterator<Key> it = this.mCameraMap.keySet().iterator();
                while (it.hasNext()) {
                    LifecycleCamera lifecycleCamera = this.mCameraMap.get(it.next());
                    boolean isEmpty = lifecycleCamera.getUseCases().isEmpty();
                    lifecycleCamera.unbind(collection);
                    if (!isEmpty && lifecycleCamera.getUseCases().isEmpty()) {
                        setInactive(lifecycleCamera.getLifecycleOwner());
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void unbindAll() {
        synchronized (this.mLock) {
            try {
                Iterator<Key> it = this.mCameraMap.keySet().iterator();
                while (it.hasNext()) {
                    LifecycleCamera lifecycleCamera = this.mCameraMap.get(it.next());
                    lifecycleCamera.unbindAll();
                    setInactive(lifecycleCamera.getLifecycleOwner());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void unregisterLifecycle(LifecycleOwner lifecycleOwner) {
        synchronized (this.mLock) {
            try {
                LifecycleCameraRepositoryObserver lifecycleCameraRepositoryObserver = getLifecycleCameraRepositoryObserver(lifecycleOwner);
                if (lifecycleCameraRepositoryObserver == null) {
                    return;
                }
                setInactive(lifecycleOwner);
                Iterator<Key> it = this.mLifecycleObserverMap.get(lifecycleCameraRepositoryObserver).iterator();
                while (it.hasNext()) {
                    this.mCameraMap.remove(it.next());
                }
                this.mLifecycleObserverMap.remove(lifecycleCameraRepositoryObserver);
                lifecycleCameraRepositoryObserver.getLifecycleOwner().getLifecycle().removeObserver(lifecycleCameraRepositoryObserver);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    LifecycleCameraRepository() {
    }
}
