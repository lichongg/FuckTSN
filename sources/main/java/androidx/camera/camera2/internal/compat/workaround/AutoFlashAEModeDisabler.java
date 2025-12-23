package androidx.camera.camera2.internal.compat.workaround;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.camera2.internal.compat.quirk.CrashWhenTakingPhotoWithAutoFlashAEModeQuirk;
import androidx.camera.camera2.internal.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.internal.compat.quirk.ImageCaptureFailWithAutoFlashQuirk;
import androidx.camera.core.impl.Quirks;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public class AutoFlashAEModeDisabler {
    private final boolean mIsCrashWhenTakingPhotoWithAutoFlashAEModeQuirkEnabled;
    private final boolean mIsImageCaptureFailWithAutoFlashQuirkEnabled;

    public int getCorrectedAeMode(int i6) {
        if ((this.mIsImageCaptureFailWithAutoFlashQuirkEnabled || this.mIsCrashWhenTakingPhotoWithAutoFlashAEModeQuirkEnabled) && i6 == 2) {
            return 1;
        }
        return i6;
    }

    public AutoFlashAEModeDisabler(@NonNull Quirks quirks) {
        boolean z5;
        this.mIsImageCaptureFailWithAutoFlashQuirkEnabled = quirks.contains(ImageCaptureFailWithAutoFlashQuirk.class);
        if (DeviceQuirks.get(CrashWhenTakingPhotoWithAutoFlashAEModeQuirk.class) != null) {
            z5 = true;
        } else {
            z5 = false;
        }
        this.mIsCrashWhenTakingPhotoWithAutoFlashAEModeQuirkEnabled = z5;
    }
}
