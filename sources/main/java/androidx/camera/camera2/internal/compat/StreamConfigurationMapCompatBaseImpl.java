package androidx.camera.camera2.internal.compat;

import android.graphics.SurfaceTexture;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.Build;
import android.util.Size;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.camera2.internal.compat.StreamConfigurationMapCompat;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
class StreamConfigurationMapCompatBaseImpl implements StreamConfigurationMapCompat.StreamConfigurationMapCompatImpl {
    final StreamConfigurationMap mStreamConfigurationMap;

    @Override // androidx.camera.camera2.internal.compat.StreamConfigurationMapCompat.StreamConfigurationMapCompatImpl
    @Nullable
    public Size[] getOutputSizes(int i6) {
        return i6 == 34 ? this.mStreamConfigurationMap.getOutputSizes(SurfaceTexture.class) : this.mStreamConfigurationMap.getOutputSizes(i6);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(23)
    static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        static Size[] getHighResolutionOutputSizes(StreamConfigurationMap streamConfigurationMap, int i6) {
            Size[] highResolutionOutputSizes;
            highResolutionOutputSizes = streamConfigurationMap.getHighResolutionOutputSizes(i6);
            return highResolutionOutputSizes;
        }
    }

    @Override // androidx.camera.camera2.internal.compat.StreamConfigurationMapCompat.StreamConfigurationMapCompatImpl
    @Nullable
    public Size[] getHighResolutionOutputSizes(int i6) {
        if (Build.VERSION.SDK_INT >= 23) {
            return Api23Impl.getHighResolutionOutputSizes(this.mStreamConfigurationMap, i6);
        }
        return null;
    }

    @Override // androidx.camera.camera2.internal.compat.StreamConfigurationMapCompat.StreamConfigurationMapCompatImpl
    @NonNull
    public StreamConfigurationMap unwrap() {
        return this.mStreamConfigurationMap;
    }

    StreamConfigurationMapCompatBaseImpl(@NonNull StreamConfigurationMap streamConfigurationMap) {
        this.mStreamConfigurationMap = streamConfigurationMap;
    }

    @Override // androidx.camera.camera2.internal.compat.StreamConfigurationMapCompat.StreamConfigurationMapCompatImpl
    @Nullable
    public <T> Size[] getOutputSizes(@NonNull Class<T> cls) {
        return this.mStreamConfigurationMap.getOutputSizes(cls);
    }
}
