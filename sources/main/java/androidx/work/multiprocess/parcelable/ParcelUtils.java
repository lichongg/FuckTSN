package androidx.work.multiprocess.parcelable;

import android.os.Parcel;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes.dex */
public final class ParcelUtils {
    private ParcelUtils() {
    }

    public static boolean readBooleanValue(@NonNull Parcel parcel) {
        if (parcel.readInt() == 1) {
            return true;
        }
        return false;
    }

    public static void writeBooleanValue(@NonNull Parcel parcel, boolean z5) {
        parcel.writeInt(z5 ? 1 : 0);
    }
}
