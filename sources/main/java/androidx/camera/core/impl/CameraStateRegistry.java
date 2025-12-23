package androidx.camera.core.impl;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.WorkerThread;
import androidx.camera.core.Camera;
import androidx.camera.core.Logger;
import androidx.camera.core.concurrent.CameraCoordinator;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.CameraStateRegistry;
import androidx.core.util.Preconditions;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public final class CameraStateRegistry implements CameraCoordinator.ConcurrentCameraModeListener {
    private static final int MAX_ALLOWED_CONCURRENT_CAMERAS_IN_CONCURRENT_MODE = 2;
    private static final int MAX_ALLOWED_CONCURRENT_CAMERAS_IN_SINGLE_MODE = 1;
    private static final String TAG = "CameraStateRegistry";

    @GuardedBy("mLock")
    private int mAvailableCameras;

    @GuardedBy("mLock")
    private final CameraCoordinator mCameraCoordinator;

    @GuardedBy("mLock")
    private final Map<Camera, CameraRegistration> mCameraStates;
    private final StringBuilder mDebugString = new StringBuilder();
    private final Object mLock;
    private int mMaxAllowedOpenedCameras;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class CameraRegistration {
        private final Executor mNotifyExecutor;
        private final OnConfigureAvailableListener mOnConfigureAvailableListener;
        private final OnOpenAvailableListener mOnOpenAvailableListener;
        private CameraInternal.State mState;

        CameraInternal.State getState() {
            return this.mState;
        }

        void notifyOnConfigureAvailableListener() {
            try {
                Executor executor = this.mNotifyExecutor;
                final OnConfigureAvailableListener onConfigureAvailableListener = this.mOnConfigureAvailableListener;
                Objects.requireNonNull(onConfigureAvailableListener);
                executor.execute(new Runnable() { // from class: androidx.camera.core.impl.n
                    @Override // java.lang.Runnable
                    public final void run() {
                        CameraStateRegistry.OnConfigureAvailableListener.this.onConfigureAvailable();
                    }
                });
            } catch (RejectedExecutionException e6) {
                Logger.e(CameraStateRegistry.TAG, "Unable to notify camera to configure.", e6);
            }
        }

        void notifyOnOpenAvailableListener() {
            try {
                Executor executor = this.mNotifyExecutor;
                final OnOpenAvailableListener onOpenAvailableListener = this.mOnOpenAvailableListener;
                Objects.requireNonNull(onOpenAvailableListener);
                executor.execute(new Runnable() { // from class: androidx.camera.core.impl.m
                    @Override // java.lang.Runnable
                    public final void run() {
                        CameraStateRegistry.OnOpenAvailableListener.this.onOpenAvailable();
                    }
                });
            } catch (RejectedExecutionException e6) {
                Logger.e(CameraStateRegistry.TAG, "Unable to notify camera to open.", e6);
            }
        }

        CameraInternal.State setState(@Nullable CameraInternal.State state) {
            CameraInternal.State state2 = this.mState;
            this.mState = state;
            return state2;
        }

        CameraRegistration(@Nullable CameraInternal.State state, @NonNull Executor executor, @NonNull OnConfigureAvailableListener onConfigureAvailableListener, @NonNull OnOpenAvailableListener onOpenAvailableListener) {
            this.mState = state;
            this.mNotifyExecutor = executor;
            this.mOnConfigureAvailableListener = onConfigureAvailableListener;
            this.mOnOpenAvailableListener = onOpenAvailableListener;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface OnConfigureAvailableListener {
        void onConfigureAvailable();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface OnOpenAvailableListener {
        void onOpenAvailable();
    }

    public void markCameraState(@NonNull Camera camera, @NonNull CameraInternal.State state) {
        markCameraState(camera, state, true);
    }

    @Nullable
    @GuardedBy("mLock")
    private CameraRegistration getCameraRegistration(@NonNull String str) {
        for (Camera camera : this.mCameraStates.keySet()) {
            if (str.equals(((CameraInfoInternal) camera.getCameraInfo()).getCameraId())) {
                return this.mCameraStates.get(camera);
            }
        }
        return null;
    }

    private static boolean isOpen(@Nullable CameraInternal.State state) {
        return state != null && state.holdsCameraSlot();
    }

    @GuardedBy("mLock")
    @WorkerThread
    private void recalculateAvailableCameras() {
        if (Logger.isDebugEnabled(TAG)) {
            this.mDebugString.setLength(0);
            this.mDebugString.append("Recalculating open cameras:\n");
            this.mDebugString.append(String.format(Locale.US, "%-45s%-22s\n", "Camera", "State"));
            this.mDebugString.append("-------------------------------------------------------------------\n");
        }
        int i6 = 0;
        for (Map.Entry<Camera, CameraRegistration> entry : this.mCameraStates.entrySet()) {
            if (Logger.isDebugEnabled(TAG)) {
                this.mDebugString.append(String.format(Locale.US, "%-45s%-22s\n", entry.getKey().toString(), entry.getValue().getState() != null ? entry.getValue().getState().toString() : "UNKNOWN"));
            }
            if (isOpen(entry.getValue().getState())) {
                i6++;
            }
        }
        if (Logger.isDebugEnabled(TAG)) {
            this.mDebugString.append("-------------------------------------------------------------------\n");
            this.mDebugString.append(String.format(Locale.US, "Open count: %d (Max allowed: %d)", Integer.valueOf(i6), Integer.valueOf(this.mMaxAllowedOpenedCameras)));
            Logger.d(TAG, this.mDebugString.toString());
        }
        this.mAvailableCameras = Math.max(this.mMaxAllowedOpenedCameras - i6, 0);
    }

    @Nullable
    @GuardedBy("mLock")
    private CameraInternal.State unregisterCamera(@NonNull Camera camera) {
        CameraRegistration remove = this.mCameraStates.remove(camera);
        if (remove == null) {
            return null;
        }
        recalculateAvailableCameras();
        return remove.getState();
    }

    @Nullable
    @GuardedBy("mLock")
    private CameraInternal.State updateAndVerifyState(@NonNull Camera camera, @NonNull CameraInternal.State state) {
        CameraInternal.State state2 = ((CameraRegistration) Preconditions.checkNotNull(this.mCameraStates.get(camera), "Cannot update state of camera which has not yet been registered. Register with CameraStateRegistry.registerCamera()")).setState(state);
        CameraInternal.State state3 = CameraInternal.State.OPENING;
        if (state == state3) {
            Preconditions.checkState(isOpen(state) || state2 == state3, "Cannot mark camera as opening until camera was successful at calling CameraStateRegistry.tryOpenCamera()");
        }
        if (state2 != state) {
            recalculateAvailableCameras();
        }
        return state2;
    }

    public boolean isCameraClosing() {
        synchronized (this.mLock) {
            try {
                Iterator<Map.Entry<Camera, CameraRegistration>> it = this.mCameraStates.entrySet().iterator();
                while (it.hasNext()) {
                    if (it.next().getValue().getState() == CameraInternal.State.CLOSING) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void markCameraState(@androidx.annotation.NonNull androidx.camera.core.Camera r7, @androidx.annotation.NonNull androidx.camera.core.impl.CameraInternal.State r8, boolean r9) {
        /*
            r6 = this;
            java.lang.Object r0 = r6.mLock
            monitor-enter(r0)
            int r1 = r6.mAvailableCameras     // Catch: java.lang.Throwable -> Le
            androidx.camera.core.impl.CameraInternal$State r2 = androidx.camera.core.impl.CameraInternal.State.RELEASED     // Catch: java.lang.Throwable -> Le
            if (r8 != r2) goto L11
            androidx.camera.core.impl.CameraInternal$State r2 = r6.unregisterCamera(r7)     // Catch: java.lang.Throwable -> Le
            goto L15
        Le:
            r7 = move-exception
            goto Lbf
        L11:
            androidx.camera.core.impl.CameraInternal$State r2 = r6.updateAndVerifyState(r7, r8)     // Catch: java.lang.Throwable -> Le
        L15:
            if (r2 != r8) goto L19
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Le
            return
        L19:
            androidx.camera.core.concurrent.CameraCoordinator r2 = r6.mCameraCoordinator     // Catch: java.lang.Throwable -> Le
            int r2 = r2.getCameraOperatingMode()     // Catch: java.lang.Throwable -> Le
            r3 = 2
            r4 = 0
            if (r2 != r3) goto L3e
            androidx.camera.core.impl.CameraInternal$State r2 = androidx.camera.core.impl.CameraInternal.State.CONFIGURED     // Catch: java.lang.Throwable -> Le
            if (r8 != r2) goto L3e
            androidx.camera.core.CameraInfo r2 = r7.getCameraInfo()     // Catch: java.lang.Throwable -> Le
            androidx.camera.core.impl.CameraInfoInternal r2 = (androidx.camera.core.impl.CameraInfoInternal) r2     // Catch: java.lang.Throwable -> Le
            java.lang.String r2 = r2.getCameraId()     // Catch: java.lang.Throwable -> Le
            androidx.camera.core.concurrent.CameraCoordinator r3 = r6.mCameraCoordinator     // Catch: java.lang.Throwable -> Le
            java.lang.String r2 = r3.getPairedConcurrentCameraId(r2)     // Catch: java.lang.Throwable -> Le
            if (r2 == 0) goto L3e
            androidx.camera.core.impl.CameraStateRegistry$CameraRegistration r2 = r6.getCameraRegistration(r2)     // Catch: java.lang.Throwable -> Le
            goto L3f
        L3e:
            r2 = r4
        L3f:
            r3 = 1
            if (r1 >= r3) goto L7f
            int r1 = r6.mAvailableCameras     // Catch: java.lang.Throwable -> Le
            if (r1 <= 0) goto L7f
            java.util.HashMap r4 = new java.util.HashMap     // Catch: java.lang.Throwable -> Le
            r4.<init>()     // Catch: java.lang.Throwable -> Le
            java.util.Map<androidx.camera.core.Camera, androidx.camera.core.impl.CameraStateRegistry$CameraRegistration> r8 = r6.mCameraStates     // Catch: java.lang.Throwable -> Le
            java.util.Set r8 = r8.entrySet()     // Catch: java.lang.Throwable -> Le
            java.util.Iterator r8 = r8.iterator()     // Catch: java.lang.Throwable -> Le
        L55:
            boolean r1 = r8.hasNext()     // Catch: java.lang.Throwable -> Le
            if (r1 == 0) goto L97
            java.lang.Object r1 = r8.next()     // Catch: java.lang.Throwable -> Le
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch: java.lang.Throwable -> Le
            java.lang.Object r3 = r1.getValue()     // Catch: java.lang.Throwable -> Le
            androidx.camera.core.impl.CameraStateRegistry$CameraRegistration r3 = (androidx.camera.core.impl.CameraStateRegistry.CameraRegistration) r3     // Catch: java.lang.Throwable -> Le
            androidx.camera.core.impl.CameraInternal$State r3 = r3.getState()     // Catch: java.lang.Throwable -> Le
            androidx.camera.core.impl.CameraInternal$State r5 = androidx.camera.core.impl.CameraInternal.State.PENDING_OPEN     // Catch: java.lang.Throwable -> Le
            if (r3 != r5) goto L55
            java.lang.Object r3 = r1.getKey()     // Catch: java.lang.Throwable -> Le
            androidx.camera.core.Camera r3 = (androidx.camera.core.Camera) r3     // Catch: java.lang.Throwable -> Le
            java.lang.Object r1 = r1.getValue()     // Catch: java.lang.Throwable -> Le
            androidx.camera.core.impl.CameraStateRegistry$CameraRegistration r1 = (androidx.camera.core.impl.CameraStateRegistry.CameraRegistration) r1     // Catch: java.lang.Throwable -> Le
            r4.put(r3, r1)     // Catch: java.lang.Throwable -> Le
            goto L55
        L7f:
            androidx.camera.core.impl.CameraInternal$State r1 = androidx.camera.core.impl.CameraInternal.State.PENDING_OPEN     // Catch: java.lang.Throwable -> Le
            if (r8 != r1) goto L97
            int r8 = r6.mAvailableCameras     // Catch: java.lang.Throwable -> Le
            if (r8 <= 0) goto L97
            java.util.HashMap r4 = new java.util.HashMap     // Catch: java.lang.Throwable -> Le
            r4.<init>()     // Catch: java.lang.Throwable -> Le
            java.util.Map<androidx.camera.core.Camera, androidx.camera.core.impl.CameraStateRegistry$CameraRegistration> r8 = r6.mCameraStates     // Catch: java.lang.Throwable -> Le
            java.lang.Object r8 = r8.get(r7)     // Catch: java.lang.Throwable -> Le
            androidx.camera.core.impl.CameraStateRegistry$CameraRegistration r8 = (androidx.camera.core.impl.CameraStateRegistry.CameraRegistration) r8     // Catch: java.lang.Throwable -> Le
            r4.put(r7, r8)     // Catch: java.lang.Throwable -> Le
        L97:
            if (r4 == 0) goto L9e
            if (r9 != 0) goto L9e
            r4.remove(r7)     // Catch: java.lang.Throwable -> Le
        L9e:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Le
            if (r4 == 0) goto Lb9
            java.util.Collection r7 = r4.values()
            java.util.Iterator r7 = r7.iterator()
        La9:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto Lb9
            java.lang.Object r8 = r7.next()
            androidx.camera.core.impl.CameraStateRegistry$CameraRegistration r8 = (androidx.camera.core.impl.CameraStateRegistry.CameraRegistration) r8
            r8.notifyOnOpenAvailableListener()
            goto La9
        Lb9:
            if (r2 == 0) goto Lbe
            r2.notifyOnConfigureAvailableListener()
        Lbe:
            return
        Lbf:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Le
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.impl.CameraStateRegistry.markCameraState(androidx.camera.core.Camera, androidx.camera.core.impl.CameraInternal$State, boolean):void");
    }

    @Override // androidx.camera.core.concurrent.CameraCoordinator.ConcurrentCameraModeListener
    public void onCameraOperatingModeUpdated(int i6, int i7) {
        synchronized (this.mLock) {
            boolean z5 = true;
            this.mMaxAllowedOpenedCameras = i7 == 2 ? 2 : 1;
            boolean z6 = i6 != 2 && i7 == 2;
            if (i6 != 2 || i7 == 2) {
                z5 = false;
            }
            if (z6 || z5) {
                recalculateAvailableCameras();
            }
        }
    }

    public void registerCamera(@NonNull Camera camera, @NonNull Executor executor, @NonNull OnConfigureAvailableListener onConfigureAvailableListener, @NonNull OnOpenAvailableListener onOpenAvailableListener) {
        synchronized (this.mLock) {
            Preconditions.checkState(!this.mCameraStates.containsKey(camera), "Camera is already registered: " + camera);
            this.mCameraStates.put(camera, new CameraRegistration(null, executor, onConfigureAvailableListener, onOpenAvailableListener));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0074 A[Catch: all -> 0x0053, TryCatch #0 {all -> 0x0053, blocks: (B:4:0x0003, B:6:0x001d, B:7:0x0055, B:9:0x0059, B:13:0x006c, B:15:0x0074, B:18:0x0081, B:21:0x0099, B:22:0x009c, B:26:0x0066), top: B:3:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0099 A[Catch: all -> 0x0053, TryCatch #0 {all -> 0x0053, blocks: (B:4:0x0003, B:6:0x001d, B:7:0x0055, B:9:0x0059, B:13:0x006c, B:15:0x0074, B:18:0x0081, B:21:0x0099, B:22:0x009c, B:26:0x0066), top: B:3:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean tryOpenCamera(@androidx.annotation.NonNull androidx.camera.core.Camera r12) {
        /*
            r11 = this;
            java.lang.Object r0 = r11.mLock
            monitor-enter(r0)
            java.util.Map<androidx.camera.core.Camera, androidx.camera.core.impl.CameraStateRegistry$CameraRegistration> r1 = r11.mCameraStates     // Catch: java.lang.Throwable -> L53
            java.lang.Object r1 = r1.get(r12)     // Catch: java.lang.Throwable -> L53
            androidx.camera.core.impl.CameraStateRegistry$CameraRegistration r1 = (androidx.camera.core.impl.CameraStateRegistry.CameraRegistration) r1     // Catch: java.lang.Throwable -> L53
            java.lang.String r2 = "Camera must first be registered with registerCamera()"
            java.lang.Object r1 = androidx.core.util.Preconditions.checkNotNull(r1, r2)     // Catch: java.lang.Throwable -> L53
            androidx.camera.core.impl.CameraStateRegistry$CameraRegistration r1 = (androidx.camera.core.impl.CameraStateRegistry.CameraRegistration) r1     // Catch: java.lang.Throwable -> L53
            java.lang.String r2 = "CameraStateRegistry"
            boolean r2 = androidx.camera.core.Logger.isDebugEnabled(r2)     // Catch: java.lang.Throwable -> L53
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L55
            java.lang.StringBuilder r2 = r11.mDebugString     // Catch: java.lang.Throwable -> L53
            r2.setLength(r4)     // Catch: java.lang.Throwable -> L53
            java.lang.StringBuilder r2 = r11.mDebugString     // Catch: java.lang.Throwable -> L53
            java.util.Locale r5 = java.util.Locale.US     // Catch: java.lang.Throwable -> L53
            java.lang.String r6 = "tryOpenCamera(%s) [Available Cameras: %d, Already Open: %b (Previous state: %s)]"
            int r7 = r11.mAvailableCameras     // Catch: java.lang.Throwable -> L53
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch: java.lang.Throwable -> L53
            androidx.camera.core.impl.CameraInternal$State r8 = r1.getState()     // Catch: java.lang.Throwable -> L53
            boolean r8 = isOpen(r8)     // Catch: java.lang.Throwable -> L53
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)     // Catch: java.lang.Throwable -> L53
            androidx.camera.core.impl.CameraInternal$State r9 = r1.getState()     // Catch: java.lang.Throwable -> L53
            r10 = 4
            java.lang.Object[] r10 = new java.lang.Object[r10]     // Catch: java.lang.Throwable -> L53
            r10[r4] = r12     // Catch: java.lang.Throwable -> L53
            r10[r3] = r7     // Catch: java.lang.Throwable -> L53
            r12 = 2
            r10[r12] = r8     // Catch: java.lang.Throwable -> L53
            r12 = 3
            r10[r12] = r9     // Catch: java.lang.Throwable -> L53
            java.lang.String r12 = java.lang.String.format(r5, r6, r10)     // Catch: java.lang.Throwable -> L53
            r2.append(r12)     // Catch: java.lang.Throwable -> L53
            goto L55
        L53:
            r12 = move-exception
            goto L9e
        L55:
            int r12 = r11.mAvailableCameras     // Catch: java.lang.Throwable -> L53
            if (r12 > 0) goto L66
            androidx.camera.core.impl.CameraInternal$State r12 = r1.getState()     // Catch: java.lang.Throwable -> L53
            boolean r12 = isOpen(r12)     // Catch: java.lang.Throwable -> L53
            if (r12 == 0) goto L64
            goto L66
        L64:
            r12 = 0
            goto L6c
        L66:
            androidx.camera.core.impl.CameraInternal$State r12 = androidx.camera.core.impl.CameraInternal.State.OPENING     // Catch: java.lang.Throwable -> L53
            r1.setState(r12)     // Catch: java.lang.Throwable -> L53
            r12 = 1
        L6c:
            java.lang.String r1 = "CameraStateRegistry"
            boolean r1 = androidx.camera.core.Logger.isDebugEnabled(r1)     // Catch: java.lang.Throwable -> L53
            if (r1 == 0) goto L97
            java.lang.StringBuilder r1 = r11.mDebugString     // Catch: java.lang.Throwable -> L53
            java.util.Locale r2 = java.util.Locale.US     // Catch: java.lang.Throwable -> L53
            java.lang.String r5 = " --> %s"
            if (r12 == 0) goto L7f
            java.lang.String r6 = "SUCCESS"
            goto L81
        L7f:
            java.lang.String r6 = "FAIL"
        L81:
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L53
            r3[r4] = r6     // Catch: java.lang.Throwable -> L53
            java.lang.String r2 = java.lang.String.format(r2, r5, r3)     // Catch: java.lang.Throwable -> L53
            r1.append(r2)     // Catch: java.lang.Throwable -> L53
            java.lang.String r1 = "CameraStateRegistry"
            java.lang.StringBuilder r2 = r11.mDebugString     // Catch: java.lang.Throwable -> L53
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L53
            androidx.camera.core.Logger.d(r1, r2)     // Catch: java.lang.Throwable -> L53
        L97:
            if (r12 == 0) goto L9c
            r11.recalculateAvailableCameras()     // Catch: java.lang.Throwable -> L53
        L9c:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L53
            return r12
        L9e:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L53
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.impl.CameraStateRegistry.tryOpenCamera(androidx.camera.core.Camera):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x005b A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean tryOpenCaptureSession(@androidx.annotation.NonNull java.lang.String r6, @androidx.annotation.Nullable java.lang.String r7) {
        /*
            r5 = this;
            java.lang.Object r0 = r5.mLock
            monitor-enter(r0)
            androidx.camera.core.concurrent.CameraCoordinator r1 = r5.mCameraCoordinator     // Catch: java.lang.Throwable -> Lf
            int r1 = r1.getCameraOperatingMode()     // Catch: java.lang.Throwable -> Lf
            r2 = 2
            r3 = 1
            if (r1 == r2) goto L11
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lf
            return r3
        Lf:
            r6 = move-exception
            goto L61
        L11:
            androidx.camera.core.impl.CameraStateRegistry$CameraRegistration r1 = r5.getCameraRegistration(r6)     // Catch: java.lang.Throwable -> Lf
            r2 = 0
            if (r1 == 0) goto L21
            androidx.camera.core.impl.CameraStateRegistry$CameraRegistration r6 = r5.getCameraRegistration(r6)     // Catch: java.lang.Throwable -> Lf
            androidx.camera.core.impl.CameraInternal$State r6 = r6.getState()     // Catch: java.lang.Throwable -> Lf
            goto L22
        L21:
            r6 = r2
        L22:
            if (r7 == 0) goto L32
            androidx.camera.core.impl.CameraStateRegistry$CameraRegistration r1 = r5.getCameraRegistration(r7)     // Catch: java.lang.Throwable -> Lf
            if (r1 == 0) goto L32
            androidx.camera.core.impl.CameraStateRegistry$CameraRegistration r7 = r5.getCameraRegistration(r7)     // Catch: java.lang.Throwable -> Lf
            androidx.camera.core.impl.CameraInternal$State r2 = r7.getState()     // Catch: java.lang.Throwable -> Lf
        L32:
            androidx.camera.core.impl.CameraInternal$State r7 = androidx.camera.core.impl.CameraInternal.State.OPEN     // Catch: java.lang.Throwable -> Lf
            boolean r1 = r7.equals(r6)     // Catch: java.lang.Throwable -> Lf
            r4 = 0
            if (r1 != 0) goto L46
            androidx.camera.core.impl.CameraInternal$State r1 = androidx.camera.core.impl.CameraInternal.State.CONFIGURED     // Catch: java.lang.Throwable -> Lf
            boolean r6 = r1.equals(r6)     // Catch: java.lang.Throwable -> Lf
            if (r6 == 0) goto L44
            goto L46
        L44:
            r6 = 0
            goto L47
        L46:
            r6 = 1
        L47:
            boolean r7 = r7.equals(r2)     // Catch: java.lang.Throwable -> Lf
            if (r7 != 0) goto L58
            androidx.camera.core.impl.CameraInternal$State r7 = androidx.camera.core.impl.CameraInternal.State.CONFIGURED     // Catch: java.lang.Throwable -> Lf
            boolean r7 = r7.equals(r2)     // Catch: java.lang.Throwable -> Lf
            if (r7 == 0) goto L56
            goto L58
        L56:
            r7 = 0
            goto L59
        L58:
            r7 = 1
        L59:
            if (r6 == 0) goto L5e
            if (r7 == 0) goto L5e
            goto L5f
        L5e:
            r3 = 0
        L5f:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lf
            return r3
        L61:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lf
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.impl.CameraStateRegistry.tryOpenCaptureSession(java.lang.String, java.lang.String):boolean");
    }

    public CameraStateRegistry(@NonNull CameraCoordinator cameraCoordinator, int i6) {
        Object obj = new Object();
        this.mLock = obj;
        this.mCameraStates = new HashMap();
        this.mMaxAllowedOpenedCameras = i6;
        synchronized (obj) {
            this.mCameraCoordinator = cameraCoordinator;
            this.mAvailableCameras = this.mMaxAllowedOpenedCameras;
        }
    }
}
