package androidx.camera.core;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.camera.core.impl.CaptureBundle;
import androidx.camera.core.impl.CaptureStage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes.dex */
public final class CaptureBundles {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class CaptureBundleImpl implements CaptureBundle {
        final List<CaptureStage> mCaptureStageList;

        @Override // androidx.camera.core.impl.CaptureBundle
        public List<CaptureStage> getCaptureStages() {
            return this.mCaptureStageList;
        }

        CaptureBundleImpl(List<CaptureStage> list) {
            if (list != null && !list.isEmpty()) {
                this.mCaptureStageList = Collections.unmodifiableList(new ArrayList(list));
                return;
            }
            throw new IllegalArgumentException("Cannot set an empty CaptureStage list.");
        }
    }

    @NonNull
    static CaptureBundle createCaptureBundle(@NonNull CaptureStage... captureStageArr) {
        return new CaptureBundleImpl(Arrays.asList(captureStageArr));
    }

    @NonNull
    static CaptureBundle createCaptureBundle(@NonNull List<CaptureStage> list) {
        return new CaptureBundleImpl(list);
    }

    @NonNull
    public static CaptureBundle singleDefaultCaptureBundle() {
        return createCaptureBundle(new CaptureStage.DefaultCaptureStage());
    }

    private CaptureBundles() {
    }
}
