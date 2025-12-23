package androidx.core.location;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public interface LocationListenerCompat extends LocationListener {
    @Override // android.location.LocationListener
    void onFlushComplete(int i6);

    @Override // android.location.LocationListener
    void onLocationChanged(@NonNull List<Location> list);

    @Override // android.location.LocationListener
    void onProviderDisabled(@NonNull String str);

    @Override // android.location.LocationListener
    void onProviderEnabled(@NonNull String str);

    @Override // android.location.LocationListener
    void onStatusChanged(@NonNull String str, int i6, @Nullable Bundle bundle);
}
