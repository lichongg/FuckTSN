package androidx.camera.core.internal;

import android.graphics.Matrix;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.ImageInfo;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.TagBundle;
import androidx.camera.core.impl.utils.ExifData;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public final class CameraCaptureResultImageInfo implements ImageInfo {
    private final CameraCaptureResult mCameraCaptureResult;

    @Override // androidx.camera.core.ImageInfo
    public int getRotationDegrees() {
        return 0;
    }

    @NonNull
    public CameraCaptureResult getCameraCaptureResult() {
        return this.mCameraCaptureResult;
    }

    @Override // androidx.camera.core.ImageInfo
    @NonNull
    public Matrix getSensorToBufferTransformMatrix() {
        return new Matrix();
    }

    @Override // androidx.camera.core.ImageInfo
    @NonNull
    public TagBundle getTagBundle() {
        return this.mCameraCaptureResult.getTagBundle();
    }

    @Override // androidx.camera.core.ImageInfo
    public long getTimestamp() {
        return this.mCameraCaptureResult.getTimestamp();
    }

    @Override // androidx.camera.core.ImageInfo
    public void populateExifData(@NonNull ExifData.Builder builder) {
        this.mCameraCaptureResult.populateExifData(builder);
    }

    public CameraCaptureResultImageInfo(@NonNull CameraCaptureResult cameraCaptureResult) {
        this.mCameraCaptureResult = cameraCaptureResult;
    }
}
