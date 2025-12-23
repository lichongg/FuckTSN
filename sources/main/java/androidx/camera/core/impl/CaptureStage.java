package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.CaptureConfig;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public interface CaptureStage {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class DefaultCaptureStage implements CaptureStage {
        private final CaptureConfig mCaptureConfig = new CaptureConfig.Builder().build();

        @Override // androidx.camera.core.impl.CaptureStage
        public int getId() {
            return 0;
        }

        @Override // androidx.camera.core.impl.CaptureStage
        @NonNull
        public CaptureConfig getCaptureConfig() {
            return this.mCaptureConfig;
        }
    }

    @NonNull
    CaptureConfig getCaptureConfig();

    int getId();
}
