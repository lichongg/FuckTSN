package androidx.media;

import android.media.VolumeProvider;
import androidx.annotation.RequiresApi;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
class VolumeProviderCompatApi21 {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface Delegate {
        void onAdjustVolume(int i6);

        void onSetVolumeTo(int i6);
    }

    public static Object createVolumeProvider(int i6, int i7, int i8, final Delegate delegate) {
        return new VolumeProvider(i6, i7, i8) { // from class: androidx.media.VolumeProviderCompatApi21.1
            @Override // android.media.VolumeProvider
            public void onAdjustVolume(int i9) {
                delegate.onAdjustVolume(i9);
            }

            @Override // android.media.VolumeProvider
            public void onSetVolumeTo(int i9) {
                delegate.onSetVolumeTo(i9);
            }
        };
    }

    public static void setCurrentVolume(Object obj, int i6) {
        ((VolumeProvider) obj).setCurrentVolume(i6);
    }

    private VolumeProviderCompatApi21() {
    }
}
