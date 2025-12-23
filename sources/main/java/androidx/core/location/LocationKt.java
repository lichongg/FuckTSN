package androidx.core.location;

import android.location.Location;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class LocationKt {
    public static final double component1(@NotNull Location location) {
        return location.getLatitude();
    }

    public static final double component2(@NotNull Location location) {
        return location.getLongitude();
    }
}
