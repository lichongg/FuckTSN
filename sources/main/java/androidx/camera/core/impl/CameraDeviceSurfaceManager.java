package androidx.camera.core.impl;

import android.content.Context;
import android.util.Pair;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.InitializationException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public interface CameraDeviceSurfaceManager {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface Provider {
        @NonNull
        CameraDeviceSurfaceManager newInstance(@NonNull Context context, @Nullable Object obj, @NonNull Set<String> set) throws InitializationException;
    }

    @NonNull
    Pair<Map<UseCaseConfig<?>, StreamSpec>, Map<AttachedSurfaceInfo, StreamSpec>> getSuggestedStreamSpecs(int i6, @NonNull String str, @NonNull List<AttachedSurfaceInfo> list, @NonNull Map<UseCaseConfig<?>, List<Size>> map);

    @Nullable
    SurfaceConfig transformSurfaceConfig(int i6, @NonNull String str, int i7, @NonNull Size size);
}
