package androidx.camera.view;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
final class FlashModeConverter {
    @NonNull
    public static String nameOf(int i6) {
        if (i6 == 0) {
            return "AUTO";
        }
        if (i6 == 1) {
            return "ON";
        }
        if (i6 == 2) {
            return "OFF";
        }
        throw new IllegalArgumentException("Unknown flash mode " + i6);
    }

    public static int valueOf(@Nullable String str) {
        if (str == null) {
            throw new NullPointerException("name cannot be null");
        }
        switch (str) {
            case "ON":
                return 1;
            case "OFF":
                return 2;
            case "AUTO":
                return 0;
            default:
                throw new IllegalArgumentException("Unknown flash mode name " + str);
        }
    }

    private FlashModeConverter() {
    }
}
