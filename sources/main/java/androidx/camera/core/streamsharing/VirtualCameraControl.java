package androidx.camera.core.streamsharing;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.ForwardingCameraControl;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.streamsharing.StreamSharing;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(api = 21)
/* loaded from: D:\Downloads\app\classes.dex */
public class VirtualCameraControl extends ForwardingCameraControl {
    private static final int DEFAULT_JPEG_QUALITY = 100;
    private static final int DEFAULT_ROTATION_DEGREES = 0;
    private final StreamSharing.Control mStreamSharingControl;

    VirtualCameraControl(@NonNull CameraControlInternal cameraControlInternal, @NonNull StreamSharing.Control control) {
        super(cameraControlInternal);
        this.mStreamSharingControl = control;
    }

    private int getJpegQuality(@NonNull CaptureConfig captureConfig) {
        Integer num = (Integer) captureConfig.getImplementationOptions().retrieveOption(CaptureConfig.OPTION_JPEG_QUALITY, 100);
        Objects.requireNonNull(num);
        return num.intValue();
    }

    private int getRotationDegrees(@NonNull CaptureConfig captureConfig) {
        Integer num = (Integer) captureConfig.getImplementationOptions().retrieveOption(CaptureConfig.OPTION_ROTATION, 0);
        Objects.requireNonNull(num);
        return num.intValue();
    }

    @Override // androidx.camera.core.impl.ForwardingCameraControl, androidx.camera.core.impl.CameraControlInternal
    @NonNull
    public ListenableFuture<List<Void>> submitStillCaptureRequests(@NonNull List<CaptureConfig> list, int i6, int i7) {
        boolean z5 = true;
        if (list.size() != 1) {
            z5 = false;
        }
        Preconditions.checkArgument(z5, "Only support one capture config.");
        return Futures.allAsList(Collections.singletonList(this.mStreamSharingControl.jpegSnapshot(getJpegQuality(list.get(0)), getRotationDegrees(list.get(0)))));
    }
}
