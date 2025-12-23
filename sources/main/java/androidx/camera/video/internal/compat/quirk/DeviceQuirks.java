package androidx.camera.video.internal.compat.quirk;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.Quirk;
import androidx.camera.core.impl.Quirks;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public class DeviceQuirks {

    @NonNull
    private static final Quirks QUIRKS = new Quirks(DeviceQuirksLoader.loadQuirks());

    @NonNull
    public static Quirks getAll() {
        return QUIRKS;
    }

    @Nullable
    public static <T extends Quirk> T get(@NonNull Class<T> cls) {
        return (T) QUIRKS.get(cls);
    }

    @NonNull
    public static <T extends Quirk> List<T> getAll(@NonNull Class<T> cls) {
        return QUIRKS.getAll(cls);
    }

    private DeviceQuirks() {
    }
}
