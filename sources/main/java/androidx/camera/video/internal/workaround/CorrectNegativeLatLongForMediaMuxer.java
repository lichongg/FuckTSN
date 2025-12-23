package androidx.camera.video.internal.workaround;

import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.video.internal.compat.quirk.DeviceQuirks;
import androidx.camera.video.internal.compat.quirk.NegativeLatLongSavesIncorrectlyQuirk;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public final class CorrectNegativeLatLongForMediaMuxer {
    @NonNull
    public static Pair<Double, Double> adjustGeoLocation(double d6, double d7) {
        if (DeviceQuirks.get(NegativeLatLongSavesIncorrectlyQuirk.class) != null) {
            d6 = adjustInternal(d6);
            d7 = adjustInternal(d7);
        }
        return Pair.create(Double.valueOf(d6), Double.valueOf(d7));
    }

    private static double adjustInternal(double d6) {
        return d6 >= 0.0d ? d6 : ((d6 * 10000.0d) - 1.0d) / 10000.0d;
    }

    private CorrectNegativeLatLongForMediaMuxer() {
    }
}
