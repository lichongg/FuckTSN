package androidx.camera.core;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public class InitializationException extends Exception {
    public InitializationException(@Nullable String str) {
        super(str);
    }

    public InitializationException(@Nullable String str, @Nullable Throwable th) {
        super(str, th);
    }

    public InitializationException(@Nullable Throwable th) {
        super(th);
    }
}
