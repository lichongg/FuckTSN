package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public final class CameraCaptureCallbacks {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class ComboCameraCaptureCallback extends CameraCaptureCallback {
        private final List<CameraCaptureCallback> mCallbacks = new ArrayList();

        @NonNull
        public List<CameraCaptureCallback> getCallbacks() {
            return this.mCallbacks;
        }

        @Override // androidx.camera.core.impl.CameraCaptureCallback
        public void onCaptureCancelled() {
            Iterator<CameraCaptureCallback> it = this.mCallbacks.iterator();
            while (it.hasNext()) {
                it.next().onCaptureCancelled();
            }
        }

        @Override // androidx.camera.core.impl.CameraCaptureCallback
        public void onCaptureCompleted(@NonNull CameraCaptureResult cameraCaptureResult) {
            Iterator<CameraCaptureCallback> it = this.mCallbacks.iterator();
            while (it.hasNext()) {
                it.next().onCaptureCompleted(cameraCaptureResult);
            }
        }

        @Override // androidx.camera.core.impl.CameraCaptureCallback
        public void onCaptureFailed(@NonNull CameraCaptureFailure cameraCaptureFailure) {
            Iterator<CameraCaptureCallback> it = this.mCallbacks.iterator();
            while (it.hasNext()) {
                it.next().onCaptureFailed(cameraCaptureFailure);
            }
        }

        ComboCameraCaptureCallback(@NonNull List<CameraCaptureCallback> list) {
            for (CameraCaptureCallback cameraCaptureCallback : list) {
                if (!(cameraCaptureCallback instanceof NoOpCameraCaptureCallback)) {
                    this.mCallbacks.add(cameraCaptureCallback);
                }
            }
        }
    }

    @NonNull
    static CameraCaptureCallback createComboCallback(@NonNull List<CameraCaptureCallback> list) {
        return list.isEmpty() ? createNoOpCallback() : list.size() == 1 ? list.get(0) : new ComboCameraCaptureCallback(list);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class NoOpCameraCaptureCallback extends CameraCaptureCallback {
        NoOpCameraCaptureCallback() {
        }

        @Override // androidx.camera.core.impl.CameraCaptureCallback
        public void onCaptureCompleted(@NonNull CameraCaptureResult cameraCaptureResult) {
        }

        @Override // androidx.camera.core.impl.CameraCaptureCallback
        public void onCaptureFailed(@NonNull CameraCaptureFailure cameraCaptureFailure) {
        }
    }

    @NonNull
    public static CameraCaptureCallback createNoOpCallback() {
        return new NoOpCameraCaptureCallback();
    }

    private CameraCaptureCallbacks() {
    }

    @NonNull
    public static CameraCaptureCallback createComboCallback(@NonNull CameraCaptureCallback... cameraCaptureCallbackArr) {
        return createComboCallback((List<CameraCaptureCallback>) Arrays.asList(cameraCaptureCallbackArr));
    }
}
