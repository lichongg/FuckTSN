package q4;

import android.os.Parcelable;
import androidx.exifinterface.media.ExifInterface;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.o0;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class b {
    public static final /* synthetic */ <T extends Parcelable> Parcelable.Creator<T> a() {
        g0.y(4, ExifInterface.GPS_DIRECTION_TRUE);
        Object obj = Parcelable.class.getDeclaredField("CREATOR").get(null);
        Parcelable.Creator<T> creator = obj instanceof Parcelable.Creator ? (Parcelable.Creator) obj : null;
        if (creator != null) {
            return creator;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Could not access CREATOR field in class ");
        g0.y(4, ExifInterface.GPS_DIRECTION_TRUE);
        sb.append(o0.d(Parcelable.class).D());
        throw new IllegalArgumentException(sb.toString());
    }
}
