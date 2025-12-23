package androidx.camera.core;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.camera.core.impl.Identifier;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public interface CameraFilter {

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final Identifier DEFAULT_ID = Identifier.create(new Object());

    @NonNull
    List<CameraInfo> filter(@NonNull List<CameraInfo> list);

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    Identifier getIdentifier();
}
