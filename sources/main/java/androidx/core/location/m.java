package androidx.core.location;

import android.location.Location;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final /* synthetic */ class m {
    public static void b(LocationListenerCompat locationListenerCompat, @NonNull List list) {
        int size = list.size();
        for (int i6 = 0; i6 < size; i6++) {
            locationListenerCompat.onLocationChanged((Location) list.get(i6));
        }
    }

    public static void a(LocationListenerCompat locationListenerCompat, int i6) {
    }

    public static void c(LocationListenerCompat locationListenerCompat, @NonNull String str) {
    }

    public static void d(LocationListenerCompat locationListenerCompat, @NonNull String str) {
    }

    public static void e(LocationListenerCompat locationListenerCompat, @NonNull String str, int i6, @Nullable Bundle bundle) {
    }
}
