package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.params.StreamConfigurationMap;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(23)
/* loaded from: D:\Downloads\app\classes.dex */
class StreamConfigurationMapCompatApi23Impl extends StreamConfigurationMapCompatBaseImpl {
    @Override // androidx.camera.camera2.internal.compat.StreamConfigurationMapCompatBaseImpl, androidx.camera.camera2.internal.compat.StreamConfigurationMapCompat.StreamConfigurationMapCompatImpl
    @Nullable
    public Size[] getOutputSizes(int i6) {
        return this.mStreamConfigurationMap.getOutputSizes(i6);
    }

    StreamConfigurationMapCompatApi23Impl(@NonNull StreamConfigurationMap streamConfigurationMap) {
        super(streamConfigurationMap);
    }
}
