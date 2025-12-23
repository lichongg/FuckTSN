package androidx.camera.camera2.internal.compat.workaround;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.camera2.internal.compat.quirk.UseTorchAsFlashQuirk;
import androidx.camera.core.impl.Quirks;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public class UseTorchAsFlash {
    private final boolean mHasUseTorchAsFlashQuirk;

    public boolean shouldUseTorchAsFlash() {
        return this.mHasUseTorchAsFlashQuirk;
    }

    public UseTorchAsFlash(@NonNull Quirks quirks) {
        this.mHasUseTorchAsFlashQuirk = quirks.contains(UseTorchAsFlashQuirk.class);
    }
}
