package androidx.camera.core.impl.compat;

import android.media.CamcorderProfile;
import android.media.EncoderProfiles;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.EncoderProfilesProxy;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public final class EncoderProfilesProxyCompat {
    private static final String TAG = "EncoderProfilesProxyCompat";

    @NonNull
    @RequiresApi(31)
    public static EncoderProfilesProxy from(@NonNull EncoderProfiles encoderProfiles) {
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 33) {
            return EncoderProfilesProxyCompatApi33Impl.from(encoderProfiles);
        }
        if (i6 >= 31) {
            return EncoderProfilesProxyCompatApi31Impl.from(encoderProfiles);
        }
        throw new RuntimeException("Unable to call from(EncoderProfiles) on API " + i6 + ". Version 31 or higher required.");
    }

    private EncoderProfilesProxyCompat() {
    }

    @NonNull
    public static EncoderProfilesProxy from(@NonNull CamcorderProfile camcorderProfile) {
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 31) {
            Logger.w(TAG, "Should use from(EncoderProfiles) on API " + i6 + "instead. CamcorderProfile is deprecated on API 31.");
        }
        return EncoderProfilesProxyCompatBaseImpl.from(camcorderProfile);
    }
}
