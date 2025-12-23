package androidx.camera.core.streamsharing;

import android.hardware.camera2.CaptureResult;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.CameraCaptureMetaData;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.TagBundle;
import androidx.camera.core.impl.utils.ExifData;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(api = 21)
/* loaded from: D:\Downloads\app\classes.dex */
public class VirtualCameraCaptureResult implements CameraCaptureResult {
    private static final long INVALID_TIMESTAMP = -1;

    @Nullable
    private final CameraCaptureResult mBaseCameraCaptureResult;

    @NonNull
    private final TagBundle mTagBundle;
    private final long mTimestamp;

    public VirtualCameraCaptureResult(@NonNull TagBundle tagBundle, @Nullable CameraCaptureResult cameraCaptureResult) {
        this(cameraCaptureResult, tagBundle, -1L);
    }

    public VirtualCameraCaptureResult(@NonNull TagBundle tagBundle, long j6) {
        this(null, tagBundle, j6);
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    @NonNull
    public CameraCaptureMetaData.AeState getAeState() {
        CameraCaptureResult cameraCaptureResult = this.mBaseCameraCaptureResult;
        return cameraCaptureResult != null ? cameraCaptureResult.getAeState() : CameraCaptureMetaData.AeState.UNKNOWN;
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    @NonNull
    public CameraCaptureMetaData.AfMode getAfMode() {
        CameraCaptureResult cameraCaptureResult = this.mBaseCameraCaptureResult;
        return cameraCaptureResult != null ? cameraCaptureResult.getAfMode() : CameraCaptureMetaData.AfMode.UNKNOWN;
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    @NonNull
    public CameraCaptureMetaData.AfState getAfState() {
        CameraCaptureResult cameraCaptureResult = this.mBaseCameraCaptureResult;
        return cameraCaptureResult != null ? cameraCaptureResult.getAfState() : CameraCaptureMetaData.AfState.UNKNOWN;
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    @NonNull
    public CameraCaptureMetaData.AwbState getAwbState() {
        CameraCaptureResult cameraCaptureResult = this.mBaseCameraCaptureResult;
        return cameraCaptureResult != null ? cameraCaptureResult.getAwbState() : CameraCaptureMetaData.AwbState.UNKNOWN;
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    @NonNull
    public CameraCaptureMetaData.FlashState getFlashState() {
        CameraCaptureResult cameraCaptureResult = this.mBaseCameraCaptureResult;
        return cameraCaptureResult != null ? cameraCaptureResult.getFlashState() : CameraCaptureMetaData.FlashState.UNKNOWN;
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    @NonNull
    public TagBundle getTagBundle() {
        return this.mTagBundle;
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    public long getTimestamp() {
        CameraCaptureResult cameraCaptureResult = this.mBaseCameraCaptureResult;
        if (cameraCaptureResult != null) {
            return cameraCaptureResult.getTimestamp();
        }
        long j6 = this.mTimestamp;
        if (j6 != -1) {
            return j6;
        }
        throw new IllegalStateException("No timestamp is available.");
    }

    private VirtualCameraCaptureResult(@Nullable CameraCaptureResult cameraCaptureResult, @NonNull TagBundle tagBundle, long j6) {
        this.mBaseCameraCaptureResult = cameraCaptureResult;
        this.mTagBundle = tagBundle;
        this.mTimestamp = j6;
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    public /* synthetic */ CaptureResult getCaptureResult() {
        return androidx.camera.core.impl.a.a(this);
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    public /* synthetic */ void populateExifData(ExifData.Builder builder) {
        androidx.camera.core.impl.a.b(this, builder);
    }
}
