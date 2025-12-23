package androidx.camera.view;

import android.content.Context;
import android.view.OrientationEventListener;
import androidx.annotation.CheckResult;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.camera.view.RotationProvider;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public final class RotationProvider {

    @NonNull
    @GuardedBy("mLock")
    @VisibleForTesting
    final OrientationEventListener mOrientationListener;
    final Object mLock = new Object();

    @NonNull
    @GuardedBy("mLock")
    final Map<Listener, ListenerWrapper> mListeners = new HashMap();

    @VisibleForTesting
    boolean mIgnoreCanDetectForTest = false;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface Listener {
        void onRotationChanged(int i6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class ListenerWrapper {
        private final AtomicBoolean mEnabled = new AtomicBoolean(true);
        private final Executor mExecutor;
        private final Listener mListener;

        public static /* synthetic */ void a(ListenerWrapper listenerWrapper, int i6) {
            if (listenerWrapper.mEnabled.get()) {
                listenerWrapper.mListener.onRotationChanged(i6);
            }
        }

        void disable() {
            this.mEnabled.set(false);
        }

        void onRotationChanged(final int i6) {
            this.mExecutor.execute(new Runnable() { // from class: androidx.camera.view.u
                @Override // java.lang.Runnable
                public final void run() {
                    RotationProvider.ListenerWrapper.a(RotationProvider.ListenerWrapper.this, i6);
                }
            });
        }

        ListenerWrapper(Listener listener, Executor executor) {
            this.mListener = listener;
            this.mExecutor = executor;
        }
    }

    @VisibleForTesting
    static int orientationToSurfaceRotation(int i6) {
        if (i6 >= 315 || i6 < 45) {
            return 0;
        }
        if (i6 >= 225) {
            return 1;
        }
        return i6 >= 135 ? 2 : 3;
    }

    @CheckResult
    public boolean addListener(@NonNull Executor executor, @NonNull Listener listener) {
        synchronized (this.mLock) {
            try {
                if (!this.mOrientationListener.canDetectOrientation() && !this.mIgnoreCanDetectForTest) {
                    return false;
                }
                this.mListeners.put(listener, new ListenerWrapper(listener, executor));
                this.mOrientationListener.enable();
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void removeListener(@NonNull Listener listener) {
        synchronized (this.mLock) {
            try {
                ListenerWrapper listenerWrapper = this.mListeners.get(listener);
                if (listenerWrapper != null) {
                    listenerWrapper.disable();
                    this.mListeners.remove(listener);
                }
                if (this.mListeners.isEmpty()) {
                    this.mOrientationListener.disable();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public RotationProvider(@NonNull Context context) {
        this.mOrientationListener = new OrientationEventListener(context) { // from class: androidx.camera.view.RotationProvider.1
            private static final int INVALID_SURFACE_ROTATION = -1;
            private int mRotation = -1;

            @Override // android.view.OrientationEventListener
            public void onOrientationChanged(int i6) {
                int orientationToSurfaceRotation;
                ArrayList arrayList;
                if (i6 == -1 || this.mRotation == (orientationToSurfaceRotation = RotationProvider.orientationToSurfaceRotation(i6))) {
                    return;
                }
                this.mRotation = orientationToSurfaceRotation;
                synchronized (RotationProvider.this.mLock) {
                    arrayList = new ArrayList(RotationProvider.this.mListeners.values());
                }
                if (arrayList.isEmpty()) {
                    return;
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((ListenerWrapper) it.next()).onRotationChanged(orientationToSurfaceRotation);
                }
            }
        };
    }
}
